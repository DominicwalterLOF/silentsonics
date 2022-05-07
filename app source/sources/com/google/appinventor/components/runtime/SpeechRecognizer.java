package com.google.appinventor.components.runtime;

import android.content.Intent;
import android.text.TextUtils;
import com.google.appinventor.components.annotations.DesignerComponent;
import com.google.appinventor.components.annotations.DesignerProperty;
import com.google.appinventor.components.annotations.PropertyCategory;
import com.google.appinventor.components.annotations.SimpleEvent;
import com.google.appinventor.components.annotations.SimpleFunction;
import com.google.appinventor.components.annotations.SimpleObject;
import com.google.appinventor.components.annotations.SimpleProperty;
import com.google.appinventor.components.annotations.UsesPermissions;
import com.google.appinventor.components.annotations.UsesQueries;
import com.google.appinventor.components.annotations.androidmanifest.ActionElement;
import com.google.appinventor.components.annotations.androidmanifest.IntentFilterElement;
import com.google.appinventor.components.common.ComponentCategory;

@SimpleObject
@DesignerComponent(category = ComponentCategory.MEDIA, description = "Component for using Voice Recognition to convert from speech to text", iconName = "images/speechRecognizer.png", nonVisible = true, version = 3)
@UsesPermissions({"android.permission.RECORD_AUDIO", "android.permission.INTERNET"})
public class SpeechRecognizer extends AndroidNonvisibleComponent implements Component, OnClearListener, SpeechListener {
    private Intent B8WBXPBCF2jGfUDZZU2zV5EYdqbUBu0lAZ0THCEqYyuE8VACR9dY7rDnwBIqh64T;
    private String KbzcIEn6WDqjdY1QBot1TMrBwhEYy4xAUKG2cbzQ22VNohlOtuBGKUJsEeMNZyEH;
    private final ComponentContainer container;
    /* access modifiers changed from: private */
    public boolean havePermission = false;
    private SpeechRecognizerController hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME;
    private boolean nrk4qDbuonwjAUi7HPDytbtabfk6KLkf1OM4Z1o9O6dUiFPBfNVpTU1RRHKJKimM = true;
    private String tFNQ38WX0EWx1sBmwkfGOavwj0ohdRyv5RfL5KQ0qa5Pnr6qc7YsZTQu1aP3NtmA = "";

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public SpeechRecognizer(com.google.appinventor.components.runtime.ComponentContainer r8) {
        /*
            r7 = this;
            r0 = r7
            r1 = r8
            r2 = r0
            r3 = r1
            com.google.appinventor.components.runtime.Form r3 = r3.$form()
            r2.<init>(r3)
            r2 = r0
            r3 = 0
            r2.havePermission = r3
            r2 = r0
            r3 = 1
            r2.nrk4qDbuonwjAUi7HPDytbtabfk6KLkf1OM4Z1o9O6dUiFPBfNVpTU1RRHKJKimM = r3
            r2 = r0
            java.lang.String r3 = ""
            r2.tFNQ38WX0EWx1sBmwkfGOavwj0ohdRyv5RfL5KQ0qa5Pnr6qc7YsZTQu1aP3NtmA = r3
            r2 = r1
            com.google.appinventor.components.runtime.Form r2 = r2.$form()
            r3 = r0
            r2.registerForOnClear(r3)
            r2 = r0
            r3 = r1
            r2.container = r3
            r2 = r0
            java.lang.String r3 = ""
            r2.KbzcIEn6WDqjdY1QBot1TMrBwhEYy4xAUKG2cbzQ22VNohlOtuBGKUJsEeMNZyEH = r3
            r2 = r0
            android.content.Intent r3 = new android.content.Intent
            r6 = r3
            r3 = r6
            r4 = r6
            java.lang.String r5 = "android.speech.action.RECOGNIZE_SPEECH"
            r4.<init>(r5)
            r2.B8WBXPBCF2jGfUDZZU2zV5EYdqbUBu0lAZ0THCEqYyuE8VACR9dY7rDnwBIqh64T = r3
            r2 = r0
            android.content.Intent r2 = r2.B8WBXPBCF2jGfUDZZU2zV5EYdqbUBu0lAZ0THCEqYyuE8VACR9dY7rDnwBIqh64T
            java.lang.String r3 = "android.speech.extra.LANGUAGE_MODEL"
            java.lang.String r4 = "free_form"
            android.content.Intent r2 = r2.putExtra(r3, r4)
            r2 = r0
            android.content.Intent r2 = r2.B8WBXPBCF2jGfUDZZU2zV5EYdqbUBu0lAZ0THCEqYyuE8VACR9dY7rDnwBIqh64T
            java.lang.String r3 = "android.speech.extra.PARTIAL_RESULTS"
            r4 = 1
            android.content.Intent r2 = r2.putExtra(r3, r4)
            r2 = r0
            r6 = r2
            r2 = r6
            r3 = r6
            boolean r3 = r3.nrk4qDbuonwjAUi7HPDytbtabfk6KLkf1OM4Z1o9O6dUiFPBfNVpTU1RRHKJKimM
            r2.UseLegacy(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.appinventor.components.runtime.SpeechRecognizer.<init>(com.google.appinventor.components.runtime.ComponentContainer):void");
    }

    @SimpleProperty(category = PropertyCategory.BEHAVIOR)
    public String Language() {
        return this.tFNQ38WX0EWx1sBmwkfGOavwj0ohdRyv5RfL5KQ0qa5Pnr6qc7YsZTQu1aP3NtmA;
    }

    @SimpleProperty
    public void Language(String str) {
        String str2 = str;
        this.tFNQ38WX0EWx1sBmwkfGOavwj0ohdRyv5RfL5KQ0qa5Pnr6qc7YsZTQu1aP3NtmA = str2;
        if (TextUtils.isEmpty(str2)) {
            this.B8WBXPBCF2jGfUDZZU2zV5EYdqbUBu0lAZ0THCEqYyuE8VACR9dY7rDnwBIqh64T.removeExtra("android.speech.extra.LANGUAGE");
        } else {
            Intent putExtra = this.B8WBXPBCF2jGfUDZZU2zV5EYdqbUBu0lAZ0THCEqYyuE8VACR9dY7rDnwBIqh64T.putExtra("android.speech.extra.LANGUAGE", str2);
        }
    }

    @SimpleProperty(category = PropertyCategory.BEHAVIOR)
    public String Result() {
        return this.KbzcIEn6WDqjdY1QBot1TMrBwhEYy4xAUKG2cbzQ22VNohlOtuBGKUJsEeMNZyEH;
    }

    @SimpleFunction
    public void GetText() {
        Runnable runnable;
        if (!this.havePermission) {
            new Runnable(this) {
                final /* synthetic */ SpeechRecognizer B8WBXPBCF2jGfUDZZU2zV5EYdqbUBu0lAZ0THCEqYyuE8VACR9dY7rDnwBIqh64T;

                {
                    this.B8WBXPBCF2jGfUDZZU2zV5EYdqbUBu0lAZ0THCEqYyuE8VACR9dY7rDnwBIqh64T = r6;
                }

                public final void run() {
                    PermissionResultHandler permissionResultHandler;
                    new PermissionResultHandler(this) {
                        private /* synthetic */ AnonymousClass1 hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME;

                        {
                            this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME = r5;
                        }

                        public final void HandlePermissionResponse(String str, boolean z) {
                            String str2 = str;
                            if (z) {
                                boolean hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME2 = this.havePermission = true;
                                this.GetText();
                                return;
                            }
                            this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.B8WBXPBCF2jGfUDZZU2zV5EYdqbUBu0lAZ0THCEqYyuE8VACR9dY7rDnwBIqh64T.form.dispatchPermissionDeniedEvent((Component) this, "GetText", "android.permission.RECORD_AUDIO");
                        }
                    };
                    this.B8WBXPBCF2jGfUDZZU2zV5EYdqbUBu0lAZ0THCEqYyuE8VACR9dY7rDnwBIqh64T.form.askPermission("android.permission.RECORD_AUDIO", permissionResultHandler);
                }
            };
            this.form.runOnUiThread(runnable);
            return;
        }
        BeforeGettingText();
        this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME = this;
        this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.start();
    }

    @SimpleFunction
    public void Stop() {
        if (this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME != null) {
            this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.stop();
        }
    }

    @SimpleEvent
    public void BeforeGettingText() {
        boolean dispatchEvent = EventDispatcher.dispatchEvent(this, "BeforeGettingText", new Object[0]);
    }

    @SimpleEvent
    public void AfterGettingText(String str, boolean z) {
        Object[] objArr = new Object[2];
        objArr[0] = str;
        Object[] objArr2 = objArr;
        objArr2[1] = Boolean.valueOf(z);
        boolean dispatchEvent = EventDispatcher.dispatchEvent(this, "AfterGettingText", objArr2);
    }

    public void onPartialResult(String str) {
        this.KbzcIEn6WDqjdY1QBot1TMrBwhEYy4xAUKG2cbzQ22VNohlOtuBGKUJsEeMNZyEH = str;
        AfterGettingText(this.KbzcIEn6WDqjdY1QBot1TMrBwhEYy4xAUKG2cbzQ22VNohlOtuBGKUJsEeMNZyEH, true);
    }

    public void onResult(String str) {
        this.KbzcIEn6WDqjdY1QBot1TMrBwhEYy4xAUKG2cbzQ22VNohlOtuBGKUJsEeMNZyEH = str;
        AfterGettingText(this.KbzcIEn6WDqjdY1QBot1TMrBwhEYy4xAUKG2cbzQ22VNohlOtuBGKUJsEeMNZyEH, false);
    }

    public void onError(int i) {
        this.form.dispatchErrorOccurredEvent(this, "GetText", i, new Object[0]);
    }

    public void onClear() {
        Stop();
        this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME = null;
        this.B8WBXPBCF2jGfUDZZU2zV5EYdqbUBu0lAZ0THCEqYyuE8VACR9dY7rDnwBIqh64T = null;
    }

    @SimpleProperty(category = PropertyCategory.BEHAVIOR, description = "If true, an app can retain their older behaviour.")
    public boolean UseLegacy() {
        return this.nrk4qDbuonwjAUi7HPDytbtabfk6KLkf1OM4Z1o9O6dUiFPBfNVpTU1RRHKJKimM;
    }

    @DesignerProperty(defaultValue = "True", editorType = "boolean")
    @UsesQueries(intents = {@IntentFilterElement(actionElements = {@ActionElement(name = "android.speech.RecognitionService")})})
    @SimpleProperty(description = "If true, a separate dialog is used to recognize speech. If false, speech is recognized without changing the user interface and partial results are also provided.")
    public void UseLegacy(boolean z) {
        SpeechRecognizerController speechRecognizerController;
        SpeechRecognizerController speechRecognizerController2;
        boolean z2 = z;
        this.nrk4qDbuonwjAUi7HPDytbtabfk6KLkf1OM4Z1o9O6dUiFPBfNVpTU1RRHKJKimM = z2;
        Stop();
        if (z2) {
            new IntentBasedSpeechRecognizer(this.container, this.B8WBXPBCF2jGfUDZZU2zV5EYdqbUBu0lAZ0THCEqYyuE8VACR9dY7rDnwBIqh64T);
            this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME = speechRecognizerController2;
            return;
        }
        new ServiceBasedSpeechRecognizer(this.container, this.B8WBXPBCF2jGfUDZZU2zV5EYdqbUBu0lAZ0THCEqYyuE8VACR9dY7rDnwBIqh64T);
        this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME = speechRecognizerController;
    }
}
