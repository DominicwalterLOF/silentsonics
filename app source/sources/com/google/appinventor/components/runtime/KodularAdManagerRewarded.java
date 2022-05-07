package com.google.appinventor.components.runtime;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.OnUserEarnedRewardListener;
import com.google.android.gms.ads.RequestConfiguration;
import com.google.android.gms.ads.rewarded.RewardItem;
import com.google.android.gms.ads.rewarded.RewardedAd;
import com.google.appinventor.components.annotations.DesignerComponent;
import com.google.appinventor.components.annotations.DesignerProperty;
import com.google.appinventor.components.annotations.SimpleEvent;
import com.google.appinventor.components.annotations.SimpleFunction;
import com.google.appinventor.components.annotations.SimpleObject;
import com.google.appinventor.components.annotations.SimpleProperty;
import com.google.appinventor.components.annotations.UsesActivities;
import com.google.appinventor.components.annotations.UsesLibraries;
import com.google.appinventor.components.annotations.UsesPermissions;
import com.google.appinventor.components.annotations.androidmanifest.ActivityElement;
import com.google.appinventor.components.common.ComponentCategory;
import com.google.appinventor.components.runtime.util.KodularAdManager;
import com.google.appinventor.components.runtime.util.KodularAdsUtil;
import com.google.appinventor.components.runtime.util.KodularContentProtection;
import java.util.Collections;
import java.util.List;

@DesignerComponent(category = ComponentCategory.ADVERTISING, description = "add description in OdeMessage ", iconName = "images/kodularRewarded.png", nonVisible = true, version = 3)
@UsesLibraries({"play-services-ads.jar", "play-services-ads.aar", "browser.jar", "browser.aar", "play-services-ads-base.jar", "play-services-ads-base.aar", "play-services-ads-identifier.jar", "play-services-ads-identifier.aar", "play-services-ads-lite.jar", "play-services-ads-lite.aar", "play-services-basement.jar", "play-services-basement.aar", "play-services-gass.jar", "play-services-gass.aar", "play-services-measurement-sdk-api.jar", "play-services-measurement-sdk-api.aar", "play-services-measurement-sdk.jar", "play-services-measurement-sdk.aar", "play-services-measurement-impl.jar", "play-services-measurement-impl.aar", "play-services-measurement-base.jar", "play-services-measurement-base.aar", "play-services-measurement-api.jar", "play-services-measurement-api.aar", "play-services-measurement.jar", "play-services-measurement.aar", "ump.jar"})
@SimpleObject
@UsesActivities(activities = {@ActivityElement(configChanges = "keyboard|keyboardHidden|orientation|screenLayout|uiMode|screenSize|smallestScreenSize", name = "com.google.android.gms.ads.AdActivity")})
@UsesPermissions({"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE", "android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
public class KodularAdManagerRewarded extends AndroidNonvisibleComponent implements Component {
    private Activity activity;
    private ComponentContainer container;
    private Context context;
    private Form form;
    private RewardedAd hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME;

    /* renamed from: hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME  reason: collision with other field name */
    private final KodularAdManager f163hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME;
    private KodularContentProtection kodularContentProtection;
    private boolean testMode;

    static /* synthetic */ RewardedAd hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME(KodularAdManagerRewarded kodularAdManagerRewarded, RewardedAd rewardedAd) {
        RewardedAd rewardedAd2 = rewardedAd;
        RewardedAd rewardedAd3 = rewardedAd2;
        kodularAdManagerRewarded.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME = rewardedAd3;
        return rewardedAd2;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public KodularAdManagerRewarded(com.google.appinventor.components.runtime.ComponentContainer r9) {
        /*
            r8 = this;
            r0 = r8
            r1 = r9
            r2 = r0
            r3 = r1
            com.google.appinventor.components.runtime.Form r3 = r3.$form()
            r2.<init>(r3)
            r2 = r0
            r3 = r1
            r2.container = r3
            r2 = r0
            r3 = r1
            android.app.Activity r3 = r3.$context()
            r2.context = r3
            r2 = r0
            r3 = r1
            android.app.Activity r3 = r3.$context()
            r2.activity = r3
            r2 = r0
            r3 = r1
            com.google.appinventor.components.runtime.Form r3 = r3.$form()
            r2.form = r3
            r2 = r0
            com.google.appinventor.components.runtime.util.KodularAdManager r3 = new com.google.appinventor.components.runtime.util.KodularAdManager
            r7 = r3
            r3 = r7
            r4 = r7
            r5 = r0
            android.content.Context r5 = r5.context
            r6 = r0
            com.google.appinventor.components.runtime.Form r6 = r6.form
            r4.<init>(r5, r6)
            r2.f163hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME = r3
            r2 = r0
            com.google.appinventor.components.runtime.util.KodularContentProtection r3 = new com.google.appinventor.components.runtime.util.KodularContentProtection
            r7 = r3
            r3 = r7
            r4 = r7
            r5 = r0
            android.app.Activity r5 = r5.activity
            r4.<init>(r5)
            r2.kodularContentProtection = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.appinventor.components.runtime.KodularAdManagerRewarded.<init>(com.google.appinventor.components.runtime.ComponentContainer):void");
    }

    @DesignerProperty(defaultValue = "False", editorType = "boolean")
    @SimpleProperty(userVisible = false)
    public void TestMode(boolean z) {
        List list;
        boolean z2 = z;
        this.testMode = z2;
        if (z2 || this.form.IsCompanion()) {
            list = Collections.singletonList(KodularAdsUtil.guessSelfDeviceId(this.context));
        } else {
            list = Collections.emptyList();
        }
        RequestConfiguration.Builder builder = MobileAds.getRequestConfiguration().toBuilder();
        RequestConfiguration.Builder testDeviceIds = builder.setTestDeviceIds(list);
        MobileAds.setRequestConfiguration(builder.build());
        KodularAdManager.Consent.request(this.activity, this.context, z2);
    }

    /* JADX WARNING: Multi-variable type inference failed */
    @com.google.appinventor.components.annotations.SimpleFunction(description = "Loads a rewarded ad and prepares it for showing to the user.")
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void Load() {
        /*
            r10 = this;
            r0 = r10
            com.google.android.gms.ads.admanager.AdManagerAdRequest$Builder r3 = new com.google.android.gms.ads.admanager.AdManagerAdRequest$Builder
            r9 = r3
            r3 = r9
            r4 = r9
            r4.<init>()
            java.lang.String r4 = "k-ad-format"
            java.lang.String r5 = "rewarded"
            com.google.android.gms.ads.admanager.AdManagerAdRequest$Builder r3 = r3.addCustomTargeting(r4, r5)
            com.google.android.gms.ads.admanager.AdManagerAdRequest r3 = r3.build()
            r1 = r3
            com.google.appinventor.components.runtime.KodularAdManagerRewarded$1 r3 = new com.google.appinventor.components.runtime.KodularAdManagerRewarded$1
            r9 = r3
            r3 = r9
            r4 = r9
            r5 = r0
            r4.<init>(r5)
            r2 = r3
            r3 = r0
            com.google.appinventor.components.runtime.util.KodularContentProtection r3 = r3.kodularContentProtection
            com.google.appinventor.components.runtime.KodularAdManagerRewarded$2 r4 = new com.google.appinventor.components.runtime.KodularAdManagerRewarded$2
            r9 = r4
            r4 = r9
            r5 = r9
            r6 = r0
            r7 = r1
            r8 = r2
            r5.<init>(r6, r7, r8)
            r3.setOnValidationResultListener(r4)
            r3 = r0
            com.google.appinventor.components.runtime.util.KodularContentProtection r3 = r3.kodularContentProtection
            r4 = r0
            com.google.appinventor.components.runtime.Form r4 = r4.form
            java.lang.String r4 = r4.getAppId()
            r3.startContentValidation(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.appinventor.components.runtime.KodularAdManagerRewarded.Load():void");
    }

    @SimpleFunction(description = "Displays a previously loaded interstitial ad.")
    public void Show() {
        OnUserEarnedRewardListener onUserEarnedRewardListener;
        if (this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME != null) {
            new OnUserEarnedRewardListener(this) {
                private /* synthetic */ KodularAdManagerRewarded hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME;

                {
                    this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME = r5;
                }

                public final void onUserEarnedReward(@NonNull RewardItem rewardItem) {
                    RewardItem rewardItem2 = rewardItem;
                    int d = Log.d("KodularAdManagerRewarded", "The user earned the reward.");
                    this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.ReadyToReward();
                    RewardedAd hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME2 = KodularAdManagerRewarded.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME(this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME, (RewardedAd) null);
                }
            };
            this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.show(this.form, onUserEarnedRewardListener);
            return;
        }
        int d = Log.d("KodularAdManagerRewarded", "The rewarded ad wasn't ready yet");
        FailedToShow("Could not show ad: No ad loaded!");
    }

    @SimpleEvent(description = "Event raised when an ad could not be loaded.")
    public void FailedToLoad(String str) {
        boolean dispatchEvent = EventDispatcher.dispatchEvent(this, "FailedToLoad", str);
    }

    @SimpleEvent(description = "Event raised when an ad could not be displayd to the user.")
    public void FailedToShow(String str) {
        boolean dispatchEvent = EventDispatcher.dispatchEvent(this, "FailedToShow", str);
    }

    @SimpleEvent(description = "Event raised when an ad was loaded successfully.")
    public void Loaded() {
        boolean dispatchEvent = EventDispatcher.dispatchEvent(this, "Loaded", new Object[0]);
    }

    @SimpleEvent(description = "Event raised when the user has watched the ad and is now ready to receive a reward.")
    public void ReadyToReward() {
        boolean dispatchEvent = EventDispatcher.dispatchEvent(this, "ReadyToReward", new Object[0]);
    }
}
