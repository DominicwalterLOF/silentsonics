package com.google.appinventor.components.runtime;

import android.content.Context;
import android.util.Log;
import com.apptracker.android.listener.AppModuleListener;
import com.apptracker.android.track.AppTracker;
import com.google.appinventor.components.annotations.DesignerComponent;
import com.google.appinventor.components.annotations.DesignerProperty;
import com.google.appinventor.components.annotations.PropertyCategory;
import com.google.appinventor.components.annotations.SimpleEvent;
import com.google.appinventor.components.annotations.SimpleFunction;
import com.google.appinventor.components.annotations.SimpleObject;
import com.google.appinventor.components.annotations.SimpleProperty;
import com.google.appinventor.components.annotations.UsesLibraries;
import com.google.appinventor.components.annotations.UsesPermissions;
import com.google.appinventor.components.common.ComponentCategory;
import com.google.appinventor.components.runtime.util.KodularAdsCommission;
import com.google.appinventor.components.runtime.util.ads.KodularInterstitial;
import com.google.appinventor.components.runtime.util.ads.KodularRewardedVideo;
import java.util.Random;

@DesignerComponent(category = ComponentCategory.ADVERTISING, description = "LeadBolt is a non-visible component allowing you to show Network and Rewarded ads.", helpUrl = "https://docs.kodular.io/components/monetization/leadbolt/", iconName = "images/leadbolt.png", nonVisible = true, version = 2)
@UsesLibraries({"AppTracker.jar", "AdMobAppTracker.jar", "unity-ads.aar", "unity-ads.jar"})
@SimpleObject
@UsesPermissions({"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE"})
public class LeadBolt extends AndroidNonvisibleComponent implements Component {
    /* access modifiers changed from: private */
    public boolean MquXNtZWbdf4047WbYlKutT53l31krf70C8DMUB6GwZPFECVbiJ9LgmrYHlSNQF0 = false;
    /* access modifiers changed from: private */
    public boolean bEgrYPbd5peKqyXwAOBm3whGEG8qvODU2pBvqaxE9h7HUpHdWqfLhYhcIZ9UxgZV = false;
    private ComponentContainer container;
    private Context context;
    private boolean e1IHYfRNckEvpOWbFvMtuN7w9PEpZtVYShhIlzbQR8mwSxiOizA6OYtX7vMfGCUT = false;
    /* access modifiers changed from: private */
    public boolean ht6M5vNRogDvRYCDAZw5zQxzUwImwEpGaHRJyoKVPYuZoKA1X0CMwOko8kVy3tgl = false;
    private AppModuleListener hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME;

    /* renamed from: hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME  reason: collision with other field name */
    private KodularInterstitial f175hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME;

    /* renamed from: hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME  reason: collision with other field name */
    private KodularRewardedVideo f176hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME;
    private KodularAdsCommission kodularAdsCommission;
    private boolean nvMxrgxLbjkSMxKVTHnXYUSqg15Nn9sVGKlCuWXpKupRQzyTNqJO1nkpaVIaCsw = false;
    private String qPA23Y7cwrM2jVYdTZaCOyuoTEsak9zRoCsFocZMlDYlamZRzkT9xY09N4QNxUyM = "";
    private boolean qPeHJnCLP0dAOwDPeFIn82vcSIsCMh6KFFn3o4kyIe0RhQKOQXDeyY2LFwPu2GbE = false;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public LeadBolt(com.google.appinventor.components.runtime.ComponentContainer r9) {
        /*
            r8 = this;
            r0 = r8
            r1 = r9
            r2 = r0
            r3 = r1
            com.google.appinventor.components.runtime.Form r3 = r3.$form()
            r2.<init>(r3)
            r2 = r0
            java.lang.String r3 = ""
            r2.qPA23Y7cwrM2jVYdTZaCOyuoTEsak9zRoCsFocZMlDYlamZRzkT9xY09N4QNxUyM = r3
            r2 = r0
            r3 = 0
            r2.nvMxrgxLbjkSMxKVTHnXYUSqg15Nn9sVGKlCuWXpKupRQzyTNqJO1nkpaVIaCsw = r3
            r2 = r0
            r3 = 0
            r2.qPeHJnCLP0dAOwDPeFIn82vcSIsCMh6KFFn3o4kyIe0RhQKOQXDeyY2LFwPu2GbE = r3
            r2 = r0
            r3 = 0
            r2.MquXNtZWbdf4047WbYlKutT53l31krf70C8DMUB6GwZPFECVbiJ9LgmrYHlSNQF0 = r3
            r2 = r0
            r3 = 0
            r2.e1IHYfRNckEvpOWbFvMtuN7w9PEpZtVYShhIlzbQR8mwSxiOizA6OYtX7vMfGCUT = r3
            r2 = r0
            r3 = 0
            r2.ht6M5vNRogDvRYCDAZw5zQxzUwImwEpGaHRJyoKVPYuZoKA1X0CMwOko8kVy3tgl = r3
            r2 = r0
            r3 = 0
            r2.bEgrYPbd5peKqyXwAOBm3whGEG8qvODU2pBvqaxE9h7HUpHdWqfLhYhcIZ9UxgZV = r3
            r2 = r0
            com.google.appinventor.components.runtime.LeadBolt$3 r3 = new com.google.appinventor.components.runtime.LeadBolt$3
            r7 = r3
            r3 = r7
            r4 = r7
            r5 = r0
            r4.<init>(r5)
            r2.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME = r3
            r2 = r0
            r3 = r1
            r2.container = r3
            r2 = r0
            r3 = r1
            android.app.Activity r3 = r3.$context()
            r2.context = r3
            r2 = r0
            com.google.appinventor.components.runtime.util.KodularAdsCommission r3 = new com.google.appinventor.components.runtime.util.KodularAdsCommission
            r7 = r3
            r3 = r7
            r4 = r7
            r5 = r0
            android.content.Context r5 = r5.context
            r6 = r1
            com.google.appinventor.components.runtime.Form r6 = r6.$form()
            r4.<init>(r5, r6)
            r2.kodularAdsCommission = r3
            r2 = r0
            com.google.appinventor.components.runtime.util.ads.KodularInterstitial r3 = new com.google.appinventor.components.runtime.util.ads.KodularInterstitial
            r7 = r3
            r3 = r7
            r4 = r7
            r5 = r0
            android.content.Context r5 = r5.context
            r4.<init>(r5)
            r2.f175hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME = r3
            r2 = r0
            com.google.appinventor.components.runtime.util.ads.KodularInterstitial r2 = r2.f175hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME
            com.google.appinventor.components.runtime.LeadBolt$1 r3 = new com.google.appinventor.components.runtime.LeadBolt$1
            r7 = r3
            r3 = r7
            r4 = r7
            r5 = r0
            r4.<init>(r5)
            r2.setOnAdsSwitcherListener(r3)
            r2 = r0
            com.google.appinventor.components.runtime.util.ads.KodularRewardedVideo r3 = new com.google.appinventor.components.runtime.util.ads.KodularRewardedVideo
            r7 = r3
            r3 = r7
            r4 = r7
            r5 = r0
            android.content.Context r5 = r5.context
            r4.<init>(r5)
            r2.f176hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME = r3
            r2 = r0
            com.google.appinventor.components.runtime.util.ads.KodularRewardedVideo r2 = r2.f176hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME
            com.google.appinventor.components.runtime.LeadBolt$2 r3 = new com.google.appinventor.components.runtime.LeadBolt$2
            r7 = r3
            r3 = r7
            r4 = r7
            r5 = r0
            r4.<init>(r5)
            r2.setOnAdsSwitcherListener(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.appinventor.components.runtime.LeadBolt.<init>(com.google.appinventor.components.runtime.ComponentContainer):void");
    }

    private void wq07duYRO6iFAgWM70EZOSvbCMKs1QznMRJKrct0XuHOBYqCk3XqOKtSBGIpDou(String str) {
        String str2 = str;
        if (!this.nvMxrgxLbjkSMxKVTHnXYUSqg15Nn9sVGKlCuWXpKupRQzyTNqJO1nkpaVIaCsw) {
            AppTracker.setModuleListener(this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME);
            AppTracker.startSession(this.context, this.qPA23Y7cwrM2jVYdTZaCOyuoTEsak9zRoCsFocZMlDYlamZRzkT9xY09N4QNxUyM, true);
            this.nvMxrgxLbjkSMxKVTHnXYUSqg15Nn9sVGKlCuWXpKupRQzyTNqJO1nkpaVIaCsw = true;
            if (str2.contains("NetworkAd")) {
                LoadNetworkAd();
            } else if (str2.contains("RewardedAd")) {
                LoadRewardedAd();
            }
        }
    }

    @DesignerProperty(defaultValue = "", editorType = "string")
    @SimpleProperty(category = PropertyCategory.BEHAVIOR, userVisible = false)
    public void APIKey(String str) {
        String str2 = str;
        this.qPA23Y7cwrM2jVYdTZaCOyuoTEsak9zRoCsFocZMlDYlamZRzkT9xY09N4QNxUyM = str2;
    }

    @DesignerProperty(defaultValue = "unity", editorType = "commission_interstitial_ads_network")
    @Deprecated
    @SimpleProperty(description = "Sets the ad network used to take the commission.")
    public void CommissionInterstitialAdsNetwork(String str) {
        this.f175hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.updateNetwork(str);
    }

    @DesignerProperty(defaultValue = "unity", editorType = "commission_rewarded_ads_network")
    @Deprecated
    @SimpleProperty(description = "Sets the ad network used to take the commission.")
    public void CommissionRewardedAdsNetwork(String str) {
        this.f176hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.updateNetwork(str);
    }

    @SimpleFunction(description = "Use this block to load a Network ad.")
    public void LoadNetworkAd() {
        Random random;
        this.bEgrYPbd5peKqyXwAOBm3whGEG8qvODU2pBvqaxE9h7HUpHdWqfLhYhcIZ9UxgZV = false;
        new Random();
        if (random.nextFloat() <= this.kodularAdsCommission.getCommision("leadbolt", "interstitial") || this.qPeHJnCLP0dAOwDPeFIn82vcSIsCMh6KFFn3o4kyIe0RhQKOQXDeyY2LFwPu2GbE) {
            this.qPeHJnCLP0dAOwDPeFIn82vcSIsCMh6KFFn3o4kyIe0RhQKOQXDeyY2LFwPu2GbE = true;
            this.f175hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.loadAd(false);
            return;
        }
        wq07duYRO6iFAgWM70EZOSvbCMKs1QznMRJKrct0XuHOBYqCk3XqOKtSBGIpDou("NetworkAd");
        if (AppTracker.isAdReady("inapp")) {
            AppTracker.loadModuleToCache(this.context, "inapp");
            return;
        }
        this.nvMxrgxLbjkSMxKVTHnXYUSqg15Nn9sVGKlCuWXpKupRQzyTNqJO1nkpaVIaCsw = false;
        int i = Log.i("LeadBolt", "No ads ready");
    }

    @SimpleFunction(description = "Use this block after LoadNetworkAd to show the loaded ad.")
    public void ShowNetworkAd() {
        if (this.qPeHJnCLP0dAOwDPeFIn82vcSIsCMh6KFFn3o4kyIe0RhQKOQXDeyY2LFwPu2GbE) {
            if (!this.f175hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.showAd()) {
                LBFailed("", "Ad failed to show.", false);
                return;
            }
            this.qPeHJnCLP0dAOwDPeFIn82vcSIsCMh6KFFn3o4kyIe0RhQKOQXDeyY2LFwPu2GbE = false;
            this.MquXNtZWbdf4047WbYlKutT53l31krf70C8DMUB6GwZPFECVbiJ9LgmrYHlSNQF0 = false;
        } else if (AppTracker.isAdReady("inapp")) {
            AppTracker.loadModule(this.context, "inapp");
        } else {
            this.nvMxrgxLbjkSMxKVTHnXYUSqg15Nn9sVGKlCuWXpKupRQzyTNqJO1nkpaVIaCsw = false;
            int i = Log.i("LeadBolt", "No ads ready");
        }
    }

    @SimpleFunction(description = "Use this block to load a Rewarded Video ad.")
    public void LoadRewardedAd() {
        Random random;
        this.bEgrYPbd5peKqyXwAOBm3whGEG8qvODU2pBvqaxE9h7HUpHdWqfLhYhcIZ9UxgZV = true;
        new Random();
        if (random.nextFloat() <= this.kodularAdsCommission.getCommision("leadbolt", "video")) {
            this.e1IHYfRNckEvpOWbFvMtuN7w9PEpZtVYShhIlzbQR8mwSxiOizA6OYtX7vMfGCUT = true;
            this.f176hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.loadAd(false);
            return;
        }
        wq07duYRO6iFAgWM70EZOSvbCMKs1QznMRJKrct0XuHOBYqCk3XqOKtSBGIpDou("RewardedAd");
        if (AppTracker.isAdReady("reward")) {
            AppTracker.loadModuleToCache(this.context, "reward");
            return;
        }
        this.nvMxrgxLbjkSMxKVTHnXYUSqg15Nn9sVGKlCuWXpKupRQzyTNqJO1nkpaVIaCsw = false;
        int i = Log.i("LeadBolt", "No ads ready");
    }

    @SimpleFunction(description = "Use this block after LoadRewardedAd to show the loaded ad.")
    public void ShowRewardedAd() {
        if (this.e1IHYfRNckEvpOWbFvMtuN7w9PEpZtVYShhIlzbQR8mwSxiOizA6OYtX7vMfGCUT) {
            if (!this.f176hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.showAd()) {
                LBFailed("", "Ad failed to show.", false);
            } else {
                this.ht6M5vNRogDvRYCDAZw5zQxzUwImwEpGaHRJyoKVPYuZoKA1X0CMwOko8kVy3tgl = false;
            }
        } else if (AppTracker.isAdReady("reward")) {
            AppTracker.loadModule(this.context, "reward");
        } else {
            this.nvMxrgxLbjkSMxKVTHnXYUSqg15Nn9sVGKlCuWXpKupRQzyTNqJO1nkpaVIaCsw = false;
            int i = Log.i("LeadBolt", "No ads ready");
        }
    }

    @SimpleFunction(description = "Use this block after loading an ad to check whether it's ready to show.")
    public boolean IsNetworkAdReady() {
        return this.qPeHJnCLP0dAOwDPeFIn82vcSIsCMh6KFFn3o4kyIe0RhQKOQXDeyY2LFwPu2GbE ? this.MquXNtZWbdf4047WbYlKutT53l31krf70C8DMUB6GwZPFECVbiJ9LgmrYHlSNQF0 : AppTracker.isAdReady("inapp");
    }

    @SimpleFunction(description = "Use this block after loading an ad to check whether it's ready to show.")
    public boolean IsRewardedAdReady() {
        return this.e1IHYfRNckEvpOWbFvMtuN7w9PEpZtVYShhIlzbQR8mwSxiOizA6OYtX7vMfGCUT ? this.ht6M5vNRogDvRYCDAZw5zQxzUwImwEpGaHRJyoKVPYuZoKA1X0CMwOko8kVy3tgl : AppTracker.isAdReady("reward");
    }

    @SimpleEvent(description = "Event triggered when ads are shown")
    public void LBLoaded(String str) {
        boolean dispatchEvent = EventDispatcher.dispatchEvent(this, "LBLoaded", str);
    }

    @SimpleEvent(description = "Event triggered when ads are failed to load")
    public void LBFailed(String str, String str2, boolean z) {
        Object[] objArr = new Object[3];
        objArr[0] = str;
        Object[] objArr2 = objArr;
        objArr2[1] = str2;
        Object[] objArr3 = objArr2;
        objArr3[2] = Boolean.valueOf(z);
        boolean dispatchEvent = EventDispatcher.dispatchEvent(this, "LBFailed", objArr3);
    }

    @SimpleEvent(description = "Event triggered when ads are closed")
    public void LBClosed(String str, boolean z) {
        Object[] objArr = new Object[2];
        objArr[0] = str;
        Object[] objArr2 = objArr;
        objArr2[1] = Boolean.valueOf(z);
        boolean dispatchEvent = EventDispatcher.dispatchEvent(this, "LBClosed", objArr2);
    }

    @SimpleEvent(description = "Event triggered when ads are clicked")
    public void LBClicked(String str) {
        boolean dispatchEvent = EventDispatcher.dispatchEvent(this, "LBClicked", str);
    }

    @SimpleEvent(description = "Event triggered when ads are loaded")
    public void LBCached(String str) {
        boolean dispatchEvent = EventDispatcher.dispatchEvent(this, "LBCached", str);
    }
}
