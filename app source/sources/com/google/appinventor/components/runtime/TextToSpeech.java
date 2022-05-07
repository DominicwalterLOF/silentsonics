package com.google.appinventor.components.runtime;

import android.util.Log;
import com.google.appinventor.components.annotations.DesignerComponent;
import com.google.appinventor.components.annotations.DesignerProperty;
import com.google.appinventor.components.annotations.PropertyCategory;
import com.google.appinventor.components.annotations.SimpleEvent;
import com.google.appinventor.components.annotations.SimpleFunction;
import com.google.appinventor.components.annotations.SimpleObject;
import com.google.appinventor.components.annotations.SimpleProperty;
import com.google.appinventor.components.annotations.UsesQueries;
import com.google.appinventor.components.annotations.androidmanifest.ActionElement;
import com.google.appinventor.components.annotations.androidmanifest.IntentFilterElement;
import com.google.appinventor.components.common.ComponentCategory;
import com.google.appinventor.components.runtime.collect.Maps;
import com.google.appinventor.components.runtime.util.ErrorMessages;
import com.google.appinventor.components.runtime.util.ITextToSpeech;
import com.google.appinventor.components.runtime.util.YailList;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.MissingResourceException;

@SimpleObject
@DesignerComponent(category = ComponentCategory.MEDIA, description = "The TestToSpeech component speaks a given text aloud.  You can set the pitch and the rate of speech. <p>You can also set a language by supplying a language code.  This changes the pronounciation of words, not the actual language spoken.  For example, setting the language to French and speaking English text will sound like someone speaking English (en) with a French accent.</p> <p>You can also specify a country by supplying a country code. This can affect the pronounciation.  For example, British English (GBR) will sound different from US English (USA).  Not every country code will affect every language.</p> <p>The languages and countries available depend on the particular device, and can be listed with the AvailableLanguages and AvailableCountries properties.</p>", iconName = "images/textToSpeech.png", nonVisible = true, version = 5)
@UsesQueries(intents = {@IntentFilterElement(actionElements = {@ActionElement(name = "android.intent.action.TTS_SERVICE")})})
public class TextToSpeech extends AndroidNonvisibleComponent implements Component, OnDestroyListener, OnResumeListener, OnStopListener {
    private static final Map<String, Locale> KbzcIEn6WDqjdY1QBot1TMrBwhEYy4xAUKG2cbzQ22VNohlOtuBGKUJsEeMNZyEH = Maps.newHashMap();
    private static final Map<String, Locale> l557Ll1q9gLt3cEfyQaLTgWgvIutpQIPuKKLXX2glk42j33zjQ1xoBSDeCkOGk6j = Maps.newHashMap();
    private float DmQGLROFyZ9Eo0RSsJcpZNxJZjgcsPDfYPi3awNwmyyErT71sGU5mvgG4PDW3yL = 1.0f;
    private String KYHvnTv0AWOO8SeFCXsiNXCxcIirISbo8kAOvMnivJLnqAuCVxfixET1OT3ZpHhw;
    private YailList LYVRHQlR5uMq9RmVQLgPQwQp4HVKuBDt7Jnpu0jTztYClgnk53NSpkUmjjPPbYn;
    private String LYXVmrSApJtjkX58iaWYcT93zXSX0GhbrHTAKbm3TBRJ5avsjGCN1sJz61Za2zkA;
    private boolean R6I3TvhVUzjImNcsZnPIarNQNa08KFL5suF8ZyHVabZqiWX3lxOTmOWImMG2ChIe;
    private boolean dNRA8zk5IiUh4Pp3hPTF1cOQ5zFA2APl8kyLVDxMBtQN7HXMvFLEdGqNCHj4PKNw = false;
    private ArrayList<String> hR11jdqaRrvBRiBFd4KN6gI7d8MNQVP5Yc7fufDZjGGTeTxaualejjrhiR1Iz2xO;
    private final ITextToSpeech hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME;
    private float iLHecwZEZ1qFKybU5FAR3aqOIDdUsGdPPaR0D5I2BkdnPzgzEMwtpOPW3wNOFXm = 1.0f;
    private String kkTI9AxohjOECYVBpzZOuVO0b9llYVM2xqggkPHvpPoNGTREwN5YZmwC10Gk8X2Q;
    private String tFNQ38WX0EWx1sBmwkfGOavwj0ohdRyv5RfL5KQ0qa5Pnr6qc7YsZTQu1aP3NtmA;
    private YailList vOibdtOfNxMVixWab9VDGgvD9L4Kqb2ZDQBius3PMdhiP1dPN68Z9GzWJA49TUbE;
    private ArrayList<String> vwEpIRqEf6xdtwTR9dehwBO7JUhyLV6iEzEK2WqfPN10eUMQDPn3AUmqAFfsnr6R;

    static /* synthetic */ boolean hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME(TextToSpeech textToSpeech, boolean z) {
        boolean z2 = z;
        boolean z3 = z2;
        textToSpeech.dNRA8zk5IiUh4Pp3hPTF1cOQ5zFA2APl8kyLVDxMBtQN7HXMvFLEdGqNCHj4PKNw = z3;
        return z2;
    }

    static {
        Locale[] availableLocales = Locale.getAvailableLocales();
        Locale[] localeArr = availableLocales;
        int length = availableLocales.length;
        for (int i = 0; i < length; i++) {
            Locale locale = localeArr[i];
            try {
                String iSO3Country = locale.getISO3Country();
                String str = iSO3Country;
                if (iSO3Country.length() > 0) {
                    Locale put = KbzcIEn6WDqjdY1QBot1TMrBwhEYy4xAUKG2cbzQ22VNohlOtuBGKUJsEeMNZyEH.put(str, locale);
                }
            } catch (MissingResourceException e) {
            }
            try {
                String iSO3Language = locale.getISO3Language();
                String str2 = iSO3Language;
                if (iSO3Language.length() > 0) {
                    Locale put2 = l557Ll1q9gLt3cEfyQaLTgWgvIutpQIPuKKLXX2glk42j33zjQ1xoBSDeCkOGk6j.put(str2, locale);
                }
            } catch (MissingResourceException e2) {
            }
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public TextToSpeech(com.google.appinventor.components.runtime.ComponentContainer r10) {
        /*
            r9 = this;
            r0 = r9
            r1 = r10
            r3 = r0
            r4 = r1
            com.google.appinventor.components.runtime.Form r4 = r4.$form()
            r3.<init>(r4)
            r3 = r0
            r4 = 1065353216(0x3f800000, float:1.0)
            r3.DmQGLROFyZ9Eo0RSsJcpZNxJZjgcsPDfYPi3awNwmyyErT71sGU5mvgG4PDW3yL = r4
            r3 = r0
            r4 = 1065353216(0x3f800000, float:1.0)
            r3.iLHecwZEZ1qFKybU5FAR3aqOIDdUsGdPPaR0D5I2BkdnPzgzEMwtpOPW3wNOFXm = r4
            r3 = r0
            r4 = 0
            r3.dNRA8zk5IiUh4Pp3hPTF1cOQ5zFA2APl8kyLVDxMBtQN7HXMvFLEdGqNCHj4PKNw = r4
            r3 = r0
            java.lang.String r4 = ""
            r3.Language(r4)
            r3 = r0
            java.lang.String r4 = ""
            r3.Country(r4)
            com.google.appinventor.components.runtime.TextToSpeech$1 r3 = new com.google.appinventor.components.runtime.TextToSpeech$1
            r8 = r3
            r3 = r8
            r4 = r8
            r5 = r0
            r4.<init>(r5)
            r2 = r3
            r3 = r0
            com.google.appinventor.components.runtime.util.InternalTextToSpeech r4 = new com.google.appinventor.components.runtime.util.InternalTextToSpeech
            r8 = r4
            r4 = r8
            r5 = r8
            r6 = r1
            android.app.Activity r6 = r6.$context()
            r7 = r2
            r5.<init>(r6, r7)
            r3.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME = r4
            r3 = r0
            com.google.appinventor.components.runtime.Form r3 = r3.form
            r4 = r0
            r3.registerForOnStop(r4)
            r3 = r0
            com.google.appinventor.components.runtime.Form r3 = r3.form
            r4 = r0
            r3.registerForOnResume(r4)
            r3 = r0
            com.google.appinventor.components.runtime.Form r3 = r3.form
            r4 = r0
            r3.registerForOnDestroy(r4)
            r3 = r0
            com.google.appinventor.components.runtime.Form r3 = r3.form
            r4 = 3
            r3.setVolumeControlStream(r4)
            r3 = r0
            r4 = 0
            r3.R6I3TvhVUzjImNcsZnPIarNQNa08KFL5suF8ZyHVabZqiWX3lxOTmOWImMG2ChIe = r4
            r3 = r0
            java.util.ArrayList r4 = new java.util.ArrayList
            r8 = r4
            r4 = r8
            r5 = r8
            r5.<init>()
            r3.hR11jdqaRrvBRiBFd4KN6gI7d8MNQVP5Yc7fufDZjGGTeTxaualejjrhiR1Iz2xO = r4
            r3 = r0
            java.util.ArrayList r4 = new java.util.ArrayList
            r8 = r4
            r4 = r8
            r5 = r8
            r5.<init>()
            r3.vwEpIRqEf6xdtwTR9dehwBO7JUhyLV6iEzEK2WqfPN10eUMQDPn3AUmqAFfsnr6R = r4
            r3 = r0
            r8 = r3
            r3 = r8
            r4 = r8
            java.util.ArrayList<java.lang.String> r4 = r4.hR11jdqaRrvBRiBFd4KN6gI7d8MNQVP5Yc7fufDZjGGTeTxaualejjrhiR1Iz2xO
            com.google.appinventor.components.runtime.util.YailList r4 = com.google.appinventor.components.runtime.util.YailList.makeList((java.util.List) r4)
            r3.LYVRHQlR5uMq9RmVQLgPQwQp4HVKuBDt7Jnpu0jTztYClgnk53NSpkUmjjPPbYn = r4
            r3 = r0
            r8 = r3
            r3 = r8
            r4 = r8
            java.util.ArrayList<java.lang.String> r4 = r4.vwEpIRqEf6xdtwTR9dehwBO7JUhyLV6iEzEK2WqfPN10eUMQDPn3AUmqAFfsnr6R
            com.google.appinventor.components.runtime.util.YailList r4 = com.google.appinventor.components.runtime.util.YailList.makeList((java.util.List) r4)
            r3.vOibdtOfNxMVixWab9VDGgvD9L4Kqb2ZDQBius3PMdhiP1dPN68Z9GzWJA49TUbE = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.appinventor.components.runtime.TextToSpeech.<init>(com.google.appinventor.components.runtime.ComponentContainer):void");
    }

    @SimpleProperty(category = PropertyCategory.BEHAVIOR)
    public boolean Result() {
        return this.dNRA8zk5IiUh4Pp3hPTF1cOQ5zFA2APl8kyLVDxMBtQN7HXMvFLEdGqNCHj4PKNw;
    }

    @DesignerProperty(defaultValue = "", editorType = "languages")
    @SimpleProperty(category = PropertyCategory.BEHAVIOR, description = "Sets the language for TextToSpeech. This changes the way that words are pronounced, not the actual language that is spoken.  For example setting the language to and speaking English text with sound like someone speaking English with a French accent.")
    public void Language(String str) {
        Locale locale;
        Locale locale2;
        Locale locale3;
        String str2 = str;
        switch (str2.length()) {
            case 2:
                new Locale(str2);
                locale2 = locale;
                this.tFNQ38WX0EWx1sBmwkfGOavwj0ohdRyv5RfL5KQ0qa5Pnr6qc7YsZTQu1aP3NtmA = locale2.getLanguage();
                break;
            case 3:
                Locale locale4 = l557Ll1q9gLt3cEfyQaLTgWgvIutpQIPuKKLXX2glk42j33zjQ1xoBSDeCkOGk6j.get(str2);
                Locale locale5 = locale4;
                if (locale4 == null) {
                    locale5 = l557Ll1q9gLt3cEfyQaLTgWgvIutpQIPuKKLXX2glk42j33zjQ1xoBSDeCkOGk6j.get(str2.toLowerCase(Locale.ENGLISH));
                }
                if (locale5 == null) {
                    locale3 = Locale.getDefault();
                } else {
                    locale3 = locale5;
                }
                locale2 = locale3;
                this.tFNQ38WX0EWx1sBmwkfGOavwj0ohdRyv5RfL5KQ0qa5Pnr6qc7YsZTQu1aP3NtmA = locale2.getISO3Language();
                break;
            default:
                locale2 = Locale.getDefault();
                this.tFNQ38WX0EWx1sBmwkfGOavwj0ohdRyv5RfL5KQ0qa5Pnr6qc7YsZTQu1aP3NtmA = locale2.getLanguage();
                break;
        }
        this.LYXVmrSApJtjkX58iaWYcT93zXSX0GhbrHTAKbm3TBRJ5avsjGCN1sJz61Za2zkA = locale2.getLanguage();
    }

    @DesignerProperty(defaultValue = "1.0", editorType = "float")
    @SimpleProperty(category = PropertyCategory.BEHAVIOR, description = "Sets the Pitch for TextToSpeech The values should be between 0 and 2 where lower values lower the tone of synthesized voice and greater values raise it.")
    public void Pitch(float f) {
        float f2 = f;
        if (f2 < 0.0f || f2 > 2.0f) {
            int i = Log.i("TextToSpeech", "Pitch value should be between 0 and 2, but user specified: ".concat(String.valueOf(f2)));
            return;
        }
        this.DmQGLROFyZ9Eo0RSsJcpZNxJZjgcsPDfYPi3awNwmyyErT71sGU5mvgG4PDW3yL = f2;
        this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.setPitch(f2 == 0.0f ? 0.1f : f2);
    }

    @SimpleProperty(category = PropertyCategory.BEHAVIOR, description = "Returns current value of Pitch")
    public float Pitch() {
        return this.DmQGLROFyZ9Eo0RSsJcpZNxJZjgcsPDfYPi3awNwmyyErT71sGU5mvgG4PDW3yL;
    }

    @DesignerProperty(defaultValue = "1.0", editorType = "float")
    @SimpleProperty(category = PropertyCategory.BEHAVIOR, description = "Sets the SpeechRate for TextToSpeech. The values should be between 0 and 2 where lower values slow down the pitch and greater values accelerate it.")
    public void SpeechRate(float f) {
        float f2 = f;
        if (f2 < 0.0f || f2 > 2.0f) {
            int i = Log.i("TextToSpeech", "speechRate value should be between 0 and 2, but user specified: ".concat(String.valueOf(f2)));
            return;
        }
        this.iLHecwZEZ1qFKybU5FAR3aqOIDdUsGdPPaR0D5I2BkdnPzgzEMwtpOPW3wNOFXm = f2;
        this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.setSpeechRate(f2 == 0.0f ? 0.1f : f2);
    }

    @SimpleProperty(category = PropertyCategory.BEHAVIOR, description = "Returns current value of SpeechRate")
    public float SpeechRate() {
        return this.iLHecwZEZ1qFKybU5FAR3aqOIDdUsGdPPaR0D5I2BkdnPzgzEMwtpOPW3wNOFXm;
    }

    @SimpleProperty
    public String Language() {
        return this.tFNQ38WX0EWx1sBmwkfGOavwj0ohdRyv5RfL5KQ0qa5Pnr6qc7YsZTQu1aP3NtmA;
    }

    @DesignerProperty(defaultValue = "", editorType = "countries")
    @SimpleProperty(category = PropertyCategory.BEHAVIOR, description = "Country code to use for speech generation.  This can affect the pronounciation.  For example, British English (GBR) will sound different from US English (USA).  Not every country code will affect every language.")
    public void Country(String str) {
        Locale locale;
        Locale locale2;
        Locale locale3;
        String str2 = str;
        switch (str2.length()) {
            case 2:
                new Locale(str2);
                locale2 = locale;
                this.KYHvnTv0AWOO8SeFCXsiNXCxcIirISbo8kAOvMnivJLnqAuCVxfixET1OT3ZpHhw = locale2.getCountry();
                break;
            case 3:
                Locale locale4 = KbzcIEn6WDqjdY1QBot1TMrBwhEYy4xAUKG2cbzQ22VNohlOtuBGKUJsEeMNZyEH.get(str2);
                Locale locale5 = locale4;
                if (locale4 == null) {
                    locale5 = KbzcIEn6WDqjdY1QBot1TMrBwhEYy4xAUKG2cbzQ22VNohlOtuBGKUJsEeMNZyEH.get(str2.toUpperCase(Locale.ENGLISH));
                }
                if (locale5 == null) {
                    locale3 = Locale.getDefault();
                } else {
                    locale3 = locale5;
                }
                locale2 = locale3;
                this.KYHvnTv0AWOO8SeFCXsiNXCxcIirISbo8kAOvMnivJLnqAuCVxfixET1OT3ZpHhw = locale2.getISO3Country();
                break;
            default:
                locale2 = Locale.getDefault();
                this.KYHvnTv0AWOO8SeFCXsiNXCxcIirISbo8kAOvMnivJLnqAuCVxfixET1OT3ZpHhw = locale2.getCountry();
                break;
        }
        this.kkTI9AxohjOECYVBpzZOuVO0b9llYVM2xqggkPHvpPoNGTREwN5YZmwC10Gk8X2Q = locale2.getCountry();
    }

    @SimpleProperty
    public String Country() {
        return this.KYHvnTv0AWOO8SeFCXsiNXCxcIirISbo8kAOvMnivJLnqAuCVxfixET1OT3ZpHhw;
    }

    @SimpleProperty(description = "List of the languages available on this device for use with TextToSpeech.  Check the Android developer documentation under supported languages to find the meanings of these abbreviations.")
    public YailList AvailableLanguages() {
        prepareLanguageAndCountryProperties();
        return this.LYVRHQlR5uMq9RmVQLgPQwQp4HVKuBDt7Jnpu0jTztYClgnk53NSpkUmjjPPbYn;
    }

    @SimpleProperty(description = "List of the country codes available on this device for use with TextToSpeech.  Check the Android developer documentation under supported languages to find the meanings of these abbreviations.")
    public YailList AvailableCountries() {
        prepareLanguageAndCountryProperties();
        return this.vOibdtOfNxMVixWab9VDGgvD9L4Kqb2ZDQBius3PMdhiP1dPN68Z9GzWJA49TUbE;
    }

    public void prepareLanguageAndCountryProperties() {
        if (this.R6I3TvhVUzjImNcsZnPIarNQNa08KFL5suF8ZyHVabZqiWX3lxOTmOWImMG2ChIe) {
            return;
        }
        if (!this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.isInitialized()) {
            this.form.dispatchErrorOccurredEvent(this, "TextToSpeech", ErrorMessages.ERROR_TTS_NOT_READY, new Object[0]);
            Speak("");
            return;
        }
        Locale[] availableLocales = Locale.getAvailableLocales();
        Locale[] localeArr = availableLocales;
        int length = availableLocales.length;
        for (int i = 0; i < length; i++) {
            Locale locale = localeArr[i];
            if (this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.isLanguageAvailable(locale) != -2) {
                String language = locale.getLanguage();
                String iSO3Country = locale.getISO3Country();
                if (!language.equals("") && !this.hR11jdqaRrvBRiBFd4KN6gI7d8MNQVP5Yc7fufDZjGGTeTxaualejjrhiR1Iz2xO.contains(language)) {
                    boolean add = this.hR11jdqaRrvBRiBFd4KN6gI7d8MNQVP5Yc7fufDZjGGTeTxaualejjrhiR1Iz2xO.add(language);
                }
                if (!iSO3Country.equals("") && !this.vwEpIRqEf6xdtwTR9dehwBO7JUhyLV6iEzEK2WqfPN10eUMQDPn3AUmqAFfsnr6R.contains(iSO3Country)) {
                    boolean add2 = this.vwEpIRqEf6xdtwTR9dehwBO7JUhyLV6iEzEK2WqfPN10eUMQDPn3AUmqAFfsnr6R.add(iSO3Country);
                }
            }
        }
        Collections.sort(this.hR11jdqaRrvBRiBFd4KN6gI7d8MNQVP5Yc7fufDZjGGTeTxaualejjrhiR1Iz2xO);
        Collections.sort(this.vwEpIRqEf6xdtwTR9dehwBO7JUhyLV6iEzEK2WqfPN10eUMQDPn3AUmqAFfsnr6R);
        this.LYVRHQlR5uMq9RmVQLgPQwQp4HVKuBDt7Jnpu0jTztYClgnk53NSpkUmjjPPbYn = YailList.makeList((List) this.hR11jdqaRrvBRiBFd4KN6gI7d8MNQVP5Yc7fufDZjGGTeTxaualejjrhiR1Iz2xO);
        this.vOibdtOfNxMVixWab9VDGgvD9L4Kqb2ZDQBius3PMdhiP1dPN68Z9GzWJA49TUbE = YailList.makeList((List) this.vwEpIRqEf6xdtwTR9dehwBO7JUhyLV6iEzEK2WqfPN10eUMQDPn3AUmqAFfsnr6R);
        this.R6I3TvhVUzjImNcsZnPIarNQNa08KFL5suF8ZyHVabZqiWX3lxOTmOWImMG2ChIe = true;
    }

    @SimpleFunction
    public void Speak(String str) {
        Locale locale;
        BeforeSpeaking();
        new Locale(this.LYXVmrSApJtjkX58iaWYcT93zXSX0GhbrHTAKbm3TBRJ5avsjGCN1sJz61Za2zkA, this.kkTI9AxohjOECYVBpzZOuVO0b9llYVM2xqggkPHvpPoNGTREwN5YZmwC10Gk8X2Q);
        this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.speak(str, locale);
    }

    @SimpleEvent
    public void BeforeSpeaking() {
        boolean dispatchEvent = EventDispatcher.dispatchEvent(this, "BeforeSpeaking", new Object[0]);
    }

    @SimpleEvent
    public void AfterSpeaking(boolean z) {
        boolean dispatchEvent = EventDispatcher.dispatchEvent(this, "AfterSpeaking", Boolean.valueOf(z));
    }

    public void onStop() {
        this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.onStop();
    }

    public void onResume() {
        this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.onResume();
    }

    public void onDestroy() {
        this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.onDestroy();
    }
}
