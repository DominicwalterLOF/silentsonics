package com.google.appinventor.components.runtime.util;

import android.app.Application;
import android.content.Context;
import com.google.appinventor.common.version.GitBuildId;
import com.google.appinventor.components.runtime.Form;
import com.microsoft.appcenter.AppCenter;
import com.microsoft.appcenter.analytics.Analytics;
import com.microsoft.appcenter.crashes.Crashes;
import java.util.HashMap;
import java.util.Map;

public class KodularAnalyticsUtil {
    public KodularAnalyticsUtil() {
    }

    public static void init(Application application, Context context, Form form) {
        a aVar;
        String str;
        Application application2 = application;
        Context context2 = context;
        Form form2 = form;
        if (!AppCenter.isConfigured()) {
            Application application3 = application2;
            String str2 = form2.IsCompanion() ? "18e6b6d5-7c2b-4a1a-9042-e3448b8c323c" : "34294338-ee8e-4726-a3aa-9a17934f7bcc";
            Class[] clsArr = new Class[2];
            clsArr[0] = Analytics.class;
            Class[] clsArr2 = clsArr;
            clsArr2[1] = Crashes.class;
            AppCenter.start(application3, str2, clsArr2);
        }
        new a();
        a hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME = aVar.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME("App ID", form2.getAppId()).hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME("Regular Package Name", form2.getKodularPackageName()).hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME("Custom Package Name", form2.getPackageName()).hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME("App Name", Form.getApplicationName(context2)).hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME("Kodular Version", GitBuildId.getVersion()).hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME("Installed From", form2.getInstalledFrom());
        if (form2.isCustomPackage()) {
            str = "Yes";
        } else {
            str = "No";
        }
        hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME("App Started", hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME("Is Custom", str).PpoaLB2hgzDTOuqu9FkRmbGOAi4DOSz44cSb2WOQzHfJN0AfA0f9dWyZXVLXkHHC);
    }

    public static void screenOpen(String str, Form form) {
        a aVar;
        new a();
        hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME("Screen", aVar.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME("App ID", form.getAppId()).hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME("Screen Name", str).PpoaLB2hgzDTOuqu9FkRmbGOAi4DOSz44cSb2WOQzHfJN0AfA0f9dWyZXVLXkHHC);
    }

    public static void adEvent(String str, String str2, Form form) {
        a aVar;
        new a();
        hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME("Ads", aVar.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME("App ID", form.getAppId()).hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME("Network", str).hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME("Format", str2).PpoaLB2hgzDTOuqu9FkRmbGOAi4DOSz44cSb2WOQzHfJN0AfA0f9dWyZXVLXkHHC);
    }

    public static void logError(String str, String str2, int i, String str3, Form form) {
        a aVar;
        new a();
        hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME("Error Occurred", aVar.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME("App ID", form.getAppId()).hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME("Component", str).hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME("Block", str2).hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME("Code", String.valueOf(i)).hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME("Message", str3).PpoaLB2hgzDTOuqu9FkRmbGOAi4DOSz44cSb2WOQzHfJN0AfA0f9dWyZXVLXkHHC);
    }

    private static void hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME(String str, Map<String, String> map) {
        String str2 = str;
        Map<String, String> map2 = map;
        if (map2 == null) {
            Analytics.trackEvent(str2);
        } else {
            Analytics.trackEvent(str2, map2);
        }
    }

    public static class Ads {
        public static final String FORMAT_BANNER = "Banner";
        public static final String FORMAT_INTERSTITIAL = "Interstitial";
        public static final String FORMAT_SURVEY = "Rewarded Survey";
        public static final String FORMAT_VIDEO = "Rewarded Video";
        public static final String NETWORK_ADCOLONY = "AdColony";
        public static final String NETWORK_ADMANAGER = "Ad Manager";
        public static final String NETWORK_ADMOB = "Admob";
        public static final String NETWORK_AMAZON = "Amazon";
        public static final String NETWORK_APPLOVIN = "AppLovin";
        public static final String NETWORK_FACEBOOK = "Facebook";
        public static final String NETWORK_LEADBOLT = "Leadbolt";
        public static final String NETWORK_POLLFISH = "Pollfish";
        public static final String NETWORK_STARTAPP = "StartApp";
        public static final String NETWORK_UNITY = "Unity";

        public Ads() {
        }
    }

    static class a {
        final Map<String, String> PpoaLB2hgzDTOuqu9FkRmbGOAi4DOSz44cSb2WOQzHfJN0AfA0f9dWyZXVLXkHHC;

        public a() {
            Map<String, String> map;
            new HashMap();
            this.PpoaLB2hgzDTOuqu9FkRmbGOAi4DOSz44cSb2WOQzHfJN0AfA0f9dWyZXVLXkHHC = map;
        }

        public final a hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME(String str, String str2) {
            String put = this.PpoaLB2hgzDTOuqu9FkRmbGOAi4DOSz44cSb2WOQzHfJN0AfA0f9dWyZXVLXkHHC.put(str, str2);
            return this;
        }
    }
}
