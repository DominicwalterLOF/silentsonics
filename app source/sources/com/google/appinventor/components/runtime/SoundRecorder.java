package com.google.appinventor.components.runtime;

import android.media.MediaRecorder;
import android.os.Build;
import android.os.Environment;
import android.util.Log;
import com.google.appinventor.components.annotations.DesignerComponent;
import com.google.appinventor.components.annotations.DesignerProperty;
import com.google.appinventor.components.annotations.PropertyCategory;
import com.google.appinventor.components.annotations.SimpleEvent;
import com.google.appinventor.components.annotations.SimpleFunction;
import com.google.appinventor.components.annotations.SimpleObject;
import com.google.appinventor.components.annotations.SimpleProperty;
import com.google.appinventor.components.annotations.UsesPermissions;
import com.google.appinventor.components.common.ComponentCategory;
import com.google.appinventor.components.runtime.errors.PermissionException;
import com.google.appinventor.components.runtime.util.BulkPermissionRequest;
import com.google.appinventor.components.runtime.util.ErrorMessages;
import com.google.appinventor.components.runtime.util.FileUtil;
import com.google.appinventor.components.runtime.util.MediaUtil;
import java.io.File;
import java.io.IOException;

@DesignerComponent(category = ComponentCategory.MEDIA, description = "<p>Multimedia component that records audio.</p>", iconName = "images/soundRecorder.png", nonVisible = true, version = 4)
@SimpleObject
@UsesPermissions({"android.permission.RECORD_AUDIO", "android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE"})
public final class SoundRecorder extends AndroidNonvisibleComponent implements MediaRecorder.OnErrorListener, MediaRecorder.OnInfoListener, Component {
    private String T3TEUSUxjrJVucuujQ9pjstrX3UcxHV1L9cOGs7CI5pfz9hjmRfdL7GRyW8ebdVq = "";
    /* access modifiers changed from: private */
    public boolean havePermission = false;
    private a hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME;

    class a {
        final String ZFwQoaMsdRwNqOTkWG5sFNIKnTcrKyb4dIRsDmVa68cFIA9m1jUiaqOHngvgXrvD;
        final MediaRecorder hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME;

        /* renamed from: hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME  reason: collision with other field name */
        final /* synthetic */ SoundRecorder f242hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME;

        a(SoundRecorder soundRecorder, String str) throws IOException {
            MediaRecorder mediaRecorder;
            StringBuilder sb;
            SoundRecorder soundRecorder2 = soundRecorder;
            String str2 = str;
            this.f242hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME = soundRecorder2;
            this.ZFwQoaMsdRwNqOTkWG5sFNIKnTcrKyb4dIRsDmVa68cFIA9m1jUiaqOHngvgXrvD = str2.equals("") ? FileUtil.getRecordingFile(soundRecorder2.form, "3gp").getAbsolutePath() : str2;
            new MediaRecorder();
            this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME = mediaRecorder;
            this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.setAudioSource(1);
            this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.setOutputFormat(1);
            this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.setAudioEncoder(1);
            new StringBuilder("Setting output file to ");
            int i = Log.i("SoundRecorder", sb.append(this.ZFwQoaMsdRwNqOTkWG5sFNIKnTcrKyb4dIRsDmVa68cFIA9m1jUiaqOHngvgXrvD).toString());
            this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.setOutputFile(this.ZFwQoaMsdRwNqOTkWG5sFNIKnTcrKyb4dIRsDmVa68cFIA9m1jUiaqOHngvgXrvD);
            int i2 = Log.i("SoundRecorder", "preparing");
            this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.prepare();
            this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.setOnErrorListener(soundRecorder2);
            this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.setOnInfoListener(soundRecorder2);
        }

        /* access modifiers changed from: package-private */
        public final void stop() {
            this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.setOnErrorListener((MediaRecorder.OnErrorListener) null);
            this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.setOnInfoListener((MediaRecorder.OnInfoListener) null);
            this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.stop();
            this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.reset();
            this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.release();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SoundRecorder(ComponentContainer componentContainer) {
        super(componentContainer.$form());
    }

    @SimpleProperty(category = PropertyCategory.BEHAVIOR, description = "Specifies the path to the file where the recording should be stored. If this property is the empty string, then starting a recording will create a file in an appropriate location.  If the property is not the empty string, it should specify a complete path to a file in an existing directory, including a file name with the extension .3gp.")
    public final String SavedRecording() {
        return this.T3TEUSUxjrJVucuujQ9pjstrX3UcxHV1L9cOGs7CI5pfz9hjmRfdL7GRyW8ebdVq;
    }

    @DesignerProperty(defaultValue = "", editorType = "string")
    @SimpleProperty
    public final void SavedRecording(String str) {
        String str2 = str;
        this.T3TEUSUxjrJVucuujQ9pjstrX3UcxHV1L9cOGs7CI5pfz9hjmRfdL7GRyW8ebdVq = str2;
    }

    @SimpleFunction(description = "Use this block to start the sound recorder.")
    public final void Start() {
        StringBuilder sb;
        a aVar;
        StringBuilder sb2;
        Throwable th;
        File file;
        StringBuilder sb3;
        BulkPermissionRequest bulkPermissionRequest;
        BulkPermissionRequest bulkPermissionRequest2;
        if (!this.havePermission) {
            if (MediaUtil.isExternalFile(this.form.$context(), this.T3TEUSUxjrJVucuujQ9pjstrX3UcxHV1L9cOGs7CI5pfz9hjmRfdL7GRyW8ebdVq)) {
                Form form = this.form;
                BulkPermissionRequest bulkPermissionRequest3 = bulkPermissionRequest2;
                String[] strArr = new String[2];
                strArr[0] = "android.permission.RECORD_AUDIO";
                String[] strArr2 = strArr;
                strArr2[1] = "android.permission.WRITE_EXTERNAL_STORAGE";
                new BulkPermissionRequest(this, this, "Start", strArr2) {
                    private /* synthetic */ SoundRecorder hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME;

                    {
                        this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME = r10;
                    }

                    public final void onGranted() {
                        boolean hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME2 = this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.havePermission = true;
                        this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.Start();
                    }
                };
                form.askPermission(bulkPermissionRequest3);
                return;
            }
            Form form2 = this.form;
            BulkPermissionRequest bulkPermissionRequest4 = bulkPermissionRequest;
            new BulkPermissionRequest(this, this, "Start", "android.permission.RECORD_AUDIO") {
                private /* synthetic */ SoundRecorder hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME;

                {
                    this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME = r10;
                }

                public final void onGranted() {
                    boolean hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME2 = this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.havePermission = true;
                    this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.Start();
                }
            };
            form2.askPermission(bulkPermissionRequest4);
        } else if (this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME != null) {
            new StringBuilder("Start() called, but already recording to ");
            int i = Log.i("SoundRecorder", sb3.append(this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.ZFwQoaMsdRwNqOTkWG5sFNIKnTcrKyb4dIRsDmVa68cFIA9m1jUiaqOHngvgXrvD).toString());
        } else {
            int i2 = Log.i("SoundRecorder", "Start() called");
            if (!MediaUtil.isExternalFile(this.form.$context(), this.T3TEUSUxjrJVucuujQ9pjstrX3UcxHV1L9cOGs7CI5pfz9hjmRfdL7GRyW8ebdVq) || Environment.getExternalStorageState().equals("mounted")) {
                try {
                    if (!this.T3TEUSUxjrJVucuujQ9pjstrX3UcxHV1L9cOGs7CI5pfz9hjmRfdL7GRyW8ebdVq.equals("")) {
                        new File(this.T3TEUSUxjrJVucuujQ9pjstrX3UcxHV1L9cOGs7CI5pfz9hjmRfdL7GRyW8ebdVq);
                        File parentFile = file.getParentFile();
                        File file2 = parentFile;
                        if (!parentFile.exists()) {
                            boolean mkdirs = file2.mkdirs();
                        }
                    }
                    a aVar2 = aVar;
                    new a(this, this.T3TEUSUxjrJVucuujQ9pjstrX3UcxHV1L9cOGs7CI5pfz9hjmRfdL7GRyW8ebdVq);
                    this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME = aVar2;
                    try {
                        a aVar3 = this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME;
                        int i3 = Log.i("SoundRecorder", "starting");
                        aVar3.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.start();
                        StartedRecording();
                    } catch (IllegalStateException e) {
                        int e2 = Log.e("SoundRecorder", "got IllegalStateException. Are there two recorders running?", e);
                        Throwable th2 = th;
                        new IllegalStateException("Is there another recording running?");
                        throw th2;
                    } catch (Throwable th3) {
                        this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME = null;
                        new StringBuilder();
                        this.form.dispatchErrorOccurredEvent(this, "Start", ErrorMessages.ERROR_SOUND_RECORDER_CANNOT_CREATE, sb2.append(th3.getMessage()).toString());
                    }
                } catch (PermissionException e3) {
                    this.form.dispatchPermissionDeniedEvent((Component) this, "Start", e3);
                } catch (Throwable th4) {
                    new StringBuilder();
                    this.form.dispatchErrorOccurredEvent(this, "Start", ErrorMessages.ERROR_SOUND_RECORDER_CANNOT_CREATE, sb.append(th4.getMessage()).toString());
                }
            } else {
                this.form.dispatchErrorOccurredEvent(this, "Start", ErrorMessages.ERROR_MEDIA_EXTERNAL_STORAGE_NOT_AVAILABLE, new Object[0]);
            }
        }
    }

    public final void onError(MediaRecorder mediaRecorder, int i, int i2) {
        StringBuilder sb;
        MediaRecorder mediaRecorder2 = mediaRecorder;
        int i3 = i;
        int i4 = i2;
        if (this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME == null || mediaRecorder2 != this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME) {
            int w = Log.w("SoundRecorder", "onError called with wrong recorder. Ignoring.");
            return;
        }
        this.form.dispatchErrorOccurredEvent(this, "onError", ErrorMessages.ERROR_SOUND_RECORDER, new Object[0]);
        try {
            this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.stop();
            this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME = null;
            StoppedRecording();
        } catch (Throwable th) {
            Throwable th2 = th;
            this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME = null;
            StoppedRecording();
            throw th2;
        }
    }

    public final void onInfo(MediaRecorder mediaRecorder, int i, int i2) {
        MediaRecorder mediaRecorder2 = mediaRecorder;
        int i3 = i;
        int i4 = i2;
        if (this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME == null || mediaRecorder2 != this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME) {
            int w = Log.w("SoundRecorder", "onInfo called with wrong recorder. Ignoring.");
            return;
        }
        switch (i3) {
            case 1:
                this.form.dispatchErrorOccurredEvent(this, "recording", ErrorMessages.ERROR_SOUND_RECORDER, new Object[0]);
                break;
            case 800:
                this.form.dispatchErrorOccurredEvent(this, "recording", ErrorMessages.ERROR_SOUND_RECORDER_MAX_DURATION_REACHED, new Object[0]);
                break;
            case ErrorMessages.ERROR_SOUND_RECORDER /*801*/:
                this.form.dispatchErrorOccurredEvent(this, "recording", ErrorMessages.ERROR_SOUND_RECORDER_MAX_FILESIZE_REACHED, new Object[0]);
                break;
            default:
                return;
        }
        try {
            int i5 = Log.i("SoundRecorder", "Recoverable condition while recording. Will attempt to stop normally.");
            this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.stop();
            this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME = null;
            StoppedRecording();
        } catch (IllegalStateException e) {
            int i6 = Log.i("SoundRecorder", "SoundRecorder was not in a recording state.", e);
            this.form.dispatchErrorOccurredEventDialog(this, "Stop", ErrorMessages.ERROR_SOUND_RECORDER_ILLEGAL_STOP, new Object[0]);
            this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME = null;
            StoppedRecording();
        } catch (Throwable th) {
            Throwable th2 = th;
            this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME = null;
            StoppedRecording();
            throw th2;
        }
    }

    @SimpleFunction(description = "Use this block to stop the sound recorder.")
    public final void Stop() {
        StringBuilder sb;
        if (this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME == null) {
            int i = Log.i("SoundRecorder", "Stop() called, but already stopped.");
            return;
        }
        try {
            int i2 = Log.i("SoundRecorder", "Stop() called");
            int i3 = Log.i("SoundRecorder", "stopping");
            this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.stop();
            new StringBuilder("Firing AfterSoundRecorded with ");
            int i4 = Log.i("SoundRecorder", sb.append(this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.ZFwQoaMsdRwNqOTkWG5sFNIKnTcrKyb4dIRsDmVa68cFIA9m1jUiaqOHngvgXrvD).toString());
            AfterSoundRecorded(this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.ZFwQoaMsdRwNqOTkWG5sFNIKnTcrKyb4dIRsDmVa68cFIA9m1jUiaqOHngvgXrvD);
            this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME = null;
            StoppedRecording();
        } catch (Throwable th) {
            Throwable th2 = th;
            this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME = null;
            StoppedRecording();
            throw th2;
        }
    }

    @SimpleFunction(description = "Use this block to pause the sound recorder. Works only on Android 6 and above.")
    public final void Pause() {
        if (this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME != null) {
            a aVar = this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME;
            if (Build.VERSION.SDK_INT >= 24) {
                aVar.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.pause();
                aVar.f242hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.PausedRecording();
            }
        }
    }

    @SimpleFunction(description = "Use this block to resume the sound recorder. Works only on Android 6 and above.")
    public final void Resume() {
        if (this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME != null) {
            a aVar = this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME;
            if (Build.VERSION.SDK_INT >= 24) {
                aVar.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.resume();
                aVar.f242hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.ResumedRecording();
            }
        }
    }

    @SimpleEvent(description = "Provides the location of the newly created sound.")
    public final void AfterSoundRecorded(String str) {
        boolean dispatchEvent = EventDispatcher.dispatchEvent(this, "AfterSoundRecorded", str);
    }

    @SimpleEvent(description = "Indicates that the recorder has started, and can be stopped.")
    public final void StartedRecording() {
        boolean dispatchEvent = EventDispatcher.dispatchEvent(this, "StartedRecording", new Object[0]);
    }

    @SimpleEvent(description = "Indicates that the recorder has stopped, and can be started again.")
    public final void StoppedRecording() {
        boolean dispatchEvent = EventDispatcher.dispatchEvent(this, "StoppedRecording", new Object[0]);
    }

    @SimpleEvent(description = "Indicates that the recorder has paused, and can be resumed again.")
    public final void PausedRecording() {
        boolean dispatchEvent = EventDispatcher.dispatchEvent(this, "PausedRecording", new Object[0]);
    }

    @SimpleEvent(description = "Indicates that the recorder has resumed, and can be started again.")
    public final void ResumedRecording() {
        boolean dispatchEvent = EventDispatcher.dispatchEvent(this, "ResumedRecording", new Object[0]);
    }
}
