package com.google.appinventor.components.runtime;

import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognitionListener;
import android.speech.SpeechRecognizer;

public class ServiceBasedSpeechRecognizer extends SpeechRecognizerController implements RecognitionListener {
    private Intent B8WBXPBCF2jGfUDZZU2zV5EYdqbUBu0lAZ0THCEqYyuE8VACR9dY7rDnwBIqh64T;
    private String KbzcIEn6WDqjdY1QBot1TMrBwhEYy4xAUKG2cbzQ22VNohlOtuBGKUJsEeMNZyEH;
    private ComponentContainer container;
    private SpeechRecognizer hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME = null;

    public ServiceBasedSpeechRecognizer(ComponentContainer componentContainer, Intent intent) {
        this.container = componentContainer;
        this.B8WBXPBCF2jGfUDZZU2zV5EYdqbUBu0lAZ0THCEqYyuE8VACR9dY7rDnwBIqh64T = intent;
    }

    public void start() {
        this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME = SpeechRecognizer.createSpeechRecognizer(this.container.$context());
        this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.setRecognitionListener(this);
        this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.startListening(this.B8WBXPBCF2jGfUDZZU2zV5EYdqbUBu0lAZ0THCEqYyuE8VACR9dY7rDnwBIqh64T);
    }

    public void stop() {
        if (this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME != null) {
            this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.stopListening();
        }
    }

    public void onReadyForSpeech(Bundle bundle) {
    }

    public void onBeginningOfSpeech() {
    }

    public void onRmsChanged(float f) {
    }

    public void onBufferReceived(byte[] bArr) {
    }

    public void onEndOfSpeech() {
    }

    public void onResults(Bundle bundle) {
        Bundle bundle2 = bundle;
        if (bundle2.isEmpty()) {
            this.KbzcIEn6WDqjdY1QBot1TMrBwhEYy4xAUKG2cbzQ22VNohlOtuBGKUJsEeMNZyEH = "";
        } else {
            this.KbzcIEn6WDqjdY1QBot1TMrBwhEYy4xAUKG2cbzQ22VNohlOtuBGKUJsEeMNZyEH = bundle2.getStringArrayList("results_recognition").get(0);
        }
        this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.onResult(this.KbzcIEn6WDqjdY1QBot1TMrBwhEYy4xAUKG2cbzQ22VNohlOtuBGKUJsEeMNZyEH);
    }

    public void onPartialResults(Bundle bundle) {
        Bundle bundle2 = bundle;
        if (bundle2.isEmpty()) {
            this.KbzcIEn6WDqjdY1QBot1TMrBwhEYy4xAUKG2cbzQ22VNohlOtuBGKUJsEeMNZyEH = "";
        } else {
            this.KbzcIEn6WDqjdY1QBot1TMrBwhEYy4xAUKG2cbzQ22VNohlOtuBGKUJsEeMNZyEH = bundle2.getStringArrayList("results_recognition").get(0);
        }
        this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.onPartialResult(this.KbzcIEn6WDqjdY1QBot1TMrBwhEYy4xAUKG2cbzQ22VNohlOtuBGKUJsEeMNZyEH);
    }

    public void onEvent(int i, Bundle bundle) {
    }

    public void onError(int i) {
        int i2 = 0;
        switch (i) {
            case 1:
                i2 = 3805;
                break;
            case 2:
                i2 = 3804;
                break;
            case 3:
                i2 = 3801;
                break;
            case 4:
                i2 = 3808;
                break;
            case 5:
                i2 = 3802;
                break;
            case 6:
                i2 = 3809;
                break;
            case 7:
                i2 = 3806;
                break;
            case 8:
                i2 = 3807;
                break;
            case 9:
                i2 = 3803;
                break;
        }
        this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.onError(i2);
    }
}
