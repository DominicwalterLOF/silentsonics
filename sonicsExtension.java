package de.ullisroboterseite.ursai2visualizer;

// Autor: https://UllisRoboterSeite.de
// Doku:  https://UllisRoboterSeite.de/android-AI2-Visualizer.html
// Created: 2020-04-08
//
// Version 1 (2020-04-08)
// -------------------------
// - Basis-Version

import java.util.*;

import com.google.appinventor.components.annotations.*;
import com.google.appinventor.components.common.*;
import com.google.appinventor.components.runtime.*;
import com.google.appinventor.components.runtime.util.*;

import android.Manifest;
import android.content.Context;
import android.app.Activity;
import android.os.Handler;

import android.media.audiofx.Visualizer;

@DesignerComponent(version = 1, //
        versionName = "1.0", //
        dateBuilt = "2020-04-08", //
        description = "AI2 extension block for exposing the Android Visualizer class.", //
        category = com.google.appinventor.components.common.ComponentCategory.EXTENSION, //
        nonVisible = true, //
        helpUrl = "http://UllisRoboterSeite.de/android-AI2-Visualizer.html", //
        iconName = "aiwebres/icon.png")
@UsesPermissions(permissionNames = "android.permission.RECORD_AUDIO,android.permission.MODIFY_AUDIO_SETTINGS")
@SimpleObject(external = true)
public class UrsAI2Visualizer extends AndroidNonvisibleComponent //
        implements Component, OnInitializeListener, Visualizer.OnDataCaptureListener {
    private final Context thisContext;
    private final Activity thisActivity;
    private final Form thisForm;
    private final UrsAI2Visualizer thisInstance = this;

    final Handler handler = new Handler();

    private Visualizer visualizer = null;
    private volatile int hasPermission = 0; // 0: nicht abgefragt, 1: erteilt, 2: abgelehnt.
    private int captureRate = 5; // Häufigkeit, mit der FFT-Analysen durchgeführt werden.
    private int captureSize = 1; // Anzahl Datenpunkte in der Analyse (wird bei Start() ermittelt)
    private float scaling = 0; // 0: 1; -10: 1/10 ; +10: 10 (10 ^ (scaling/10))
    private float scalingMultiplicator = 1; // der reale Multiplikator
    private YailList channels; // Frequenzen der Kanalgrenzen als Liste von Strings.
    private int[] channelBoundaryValues; // Frequenzen der Kanalgrenzen. Letzter Wert ist immer Integer.MAX_VALUE
    private float[] frequencies; // Frequenzen der einzelnen FFT-Datenpunkte (wird bei Start() ermittelt)


    public UrsAI2Visualizer(ComponentContainer container) {
        super(container.$form());
        thisActivity = (Activity) container.$context();
        thisContext = container.$context();
        thisForm = container.$form();

        channels = new YailList();
        channelBoundaryValues = new int[1];
        channelBoundaryValues[0] = Integer.MAX_VALUE; // höher als alle erwarteten Frequenzen

        thisForm.registerForOnInitialize(this);
    } // ctor

    // #region Permissions ========================================
    @Override
    public void onInitialize() {
        askForPermissions();
    }

    @SimpleFunction(description = "Asks for audio access permissions.")
    public void askForPermissions() {
        if (hasPermission != 1) {
            form.askPermission(new BulkPermissionRequest(this, "UrsAi2Visualizer", //
                    Manifest.permission.RECORD_AUDIO, Manifest.permission.MODIFY_AUDIO_SETTINGS) {
                @Override
                public void onGranted() {
                    thisInstance.hasPermission = 1;
                    afterPermissionRequest(true);
                }

                @Override
                public void onDenied(String[] permissions) {
                    thisInstance.hasPermission = -1;
                    afterPermissionRequest(false);
                }
            });
        }
    }

    @SimpleEvent(description = "Raised after permission request.")
    public void afterPermissionRequest(final boolean Granted) {
        if (Granted && (visualizer == null)) {
            visualizer = new Visualizer(0);
        }
        EventDispatcher.dispatchEvent(thisInstance, "afterPermissionRequest", Granted);
    }

    @SimpleProperty(description = "Returns whether the extension has permission to access the audio system.")
    public boolean HasPermission() {
        return hasPermission == 1;
    }

    // #endregion

    // #region CaptureRate ========================================
    @SimpleProperty(description = "Returns the maximum capture rate in Hz for the callback capture method.")
    public int MaxCaptureRate() {
        if (visualizer == null)
            return 0;
        else
            return (int) Math.floor(visualizer.getMaxCaptureRate() / 1000);
    }

    @DesignerProperty(editorType = PropertyTypeConstants.PROPERTY_TYPE_INTEGER, defaultValue = "5")
    @SimpleProperty(description = "Sets the capture rate in Hz for the callback capture method.")
    public void CaptureRate(int value) {
        if (value > 0)
            captureRate = value;
    }

    @SimpleProperty(description = "Returns the capture rate in Hz for the callback capture method.")
    public int CaptureRate() {
        return captureRate;
    }
    // #endregion

    // #region Scaling ============================================
    @DesignerProperty(editorType = PropertyTypeConstants.PROPERTY_TYPE_INTEGER, defaultValue = "0")
    @SimpleProperty(description = "Sets the gain. Range is -10..0..+10. The resulting factor is logarithmic (see ScalingMultiplicator).")
    public void Gain(float value) {
        if (value < -10.0 || value > 10.0)
            return;
        scaling = value;
        scalingMultiplicator = (float) Math.pow(10, scaling / 10);
    }

    @SimpleProperty(description = "Returns the gain.")
    public float Gain() {
        return scaling;
    }

    @SimpleProperty(description = "Returns the value that is multiplied to the raw output.")
    public float GainMultiplicator() {
        return scalingMultiplicator;
    }
    // #endregion

    // #region Channels ===========================================
    @DesignerProperty(editorType = PropertyTypeConstants.PROPERTY_TYPE_TEXTAREA, defaultValue = "")
    @SimpleProperty(description = "Sets the list of the channel boundary frequencies.\n"
            + "All values must be greater than 1 and the list must be sorted in ascending order.")
    public void ChannelsFromString(String itemString) {
        YailList l = ElementsUtil.elementsFromString(itemString);
        int[] array = strings2ints(l);
        if (array != null) {
            channels = l;
            channelBoundaryValues = array;
        }
    }

    @SimpleProperty(description = "Returns the list of the channel boundary frequencies (List of String).")
    public YailList Channels() {
        return channels;
    }

    @SimpleProperty(description = "Sets the list of the channel boundary frequencies."
            + "All values must be greater than 1 and the list must be sorted in ascending order.")
    public void Channels(YailList itemList) {
        YailList l = ElementsUtil.elements(itemList, "Visualizer");
        int[] array = strings2ints(channels);
        if (array != null) {
            channels = l;
            channelBoundaryValues = array;
        }
    }

    // Konvertiert die Stringliste in ein Integer-Array
    // Alle Werte müssen größer als 1 und die Liste muss aufsteigend sortiert sein.
    private int[] strings2ints(YailList list) {
        String[] s = list.toStringArray();
        int[] items = new int[s.length + 1];
        int last = 0; // folgender Wert muss größer als last sein. "=0" => ester Wert mindestens 1

        for (int i = 0; i < s.length; i++) {
            int v;
            try {
                v = Integer.parseInt(s[i].trim());
            } catch (NumberFormatException nfe) {
                return null; // kein Integer
            }
            if (v <= last){
                return null;
            }
            last = v;
            items[i] = v;
        }
        items[s.length] = Integer.MAX_VALUE;
        return items;
    }
    // #endregion

    // #region Start/Stop =========================================
    @SimpleProperty(description = "Returns wether the audio capture is active.")
    public int IsEnabled() {
        if (visualizer == null)
            return -1;
        if (visualizer.getEnabled())
            return 1;
        else
            return 0;
    }

    @SimpleFunction(description = "Starts the capture.")
    public void Start() {
        Stop();
        if (visualizer == null)
            return;
        if (captureRate > MaxCaptureRate())
            captureRate = MaxCaptureRate();

        captureSize = visualizer.getCaptureSizeRange()[1];
        frequencies = new float[captureSize / 2 + 1];
        float samplingRate = visualizer.getSamplingRate() / 1000;
        for (int k = 1; k < captureSize / 2 + 1; k++) {
            frequencies[k] = k * samplingRate / captureSize;
        }
        onFFTFreq(frequencies);
        visualizer.setCaptureSize(captureSize);
        visualizer.setDataCaptureListener(this, captureRate * 1000, false, true);
        visualizer.setEnabled(true);
    }

    @SimpleFunction(description = "Stops the capture.")
    public void Stop() {
        if (visualizer == null)
            return;
        visualizer.setEnabled(false);
    }
    // #endregion

    // #region Capture ============================================
    @SimpleEvent(description = "Returns the channnel values. Maximum value is 127.")
    public void onFFT(final YailList FFT) {
        handler.post(new Runnable() {
            public void run() {
                EventDispatcher.dispatchEvent(thisInstance, "onFFT", FFT);
            } // run
        }); // post
    }


    @SimpleEvent(description = "Returns the list of frequencies - LOFLABS - code by Dominic Walter")
    public void onFFTFreq(final float[] FFT) {
        handler.post(new Runnable() {
            public void run() {
                EventDispatcher.dispatchEvent(thisInstance, "frequencies", FFT);
            } // run
        }); // post
    }



    @Override
    public void onWaveFormDataCapture(Visualizer thisVisualiser, byte[] waveform, int samplingRate) {
        // nothing to do
    }

    @Override
    public void onFftDataCapture(Visualizer thisVisualiser, byte[] fft, int samplingRate) {
        float max = 0;
        float[] magnitudes = new float[captureSize / 2 + 1];

        int[] output = new int[channelBoundaryValues.length];
        int currentChannel = 0;

        magnitudes[0] = (float) Math.abs(fft[0]);
        magnitudes[captureSize / 2] = (float) Math.abs(fft[1]);
        for (int k = 1; k < captureSize / 2; k++) {
            // Kanal-Wechsel ?
            if (frequencies[k] > channelBoundaryValues[currentChannel]) {
                output[currentChannel] = (int) max;
                max = 0;
                currentChannel++;
            }

            int i = k * 2;
            magnitudes[k] = (float) (Math.hypot(fft[i], fft[i + 1] * scalingMultiplicator * 1.41));
            // Max Magnitude ist 127 * sqrt(2). *1.41 => Max Magnitude ist 255.
            max = Math.max(max, magnitudes[k]);
            if (max > 255)
            max = 255;
        }

        output[currentChannel] = (int) max; // letzten Wert speichern

        String[] a = new String[output.length];
        for (int i = 0; i < output.length; i++)
            a[i] = "" + output[i];
        YailList out = YailList.makeList(a);
        onFFT(out);
    }
    // #endregion

}
