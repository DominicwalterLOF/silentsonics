package com.google.appinventor.components.runtime;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.RequestConfiguration;
import com.google.android.gms.ads.admanager.AdManagerInterstitialAd;
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

@DesignerComponent(category = ComponentCategory.ADVERTISING, description = "A visible component that displays banner ads from multiple advertisers and mediation partners", iconName = "images/kodularInterstitial.png", nonVisible = true, version = 1)
@UsesLibraries({"browser.jar", "browser.aar", "play-services-ads.jar", "play-services-ads.aar", "play-services-ads-base.jar", "play-services-ads-base.aar", "play-services-ads-identifier.jar", "play-services-ads-identifier.aar", "play-services-ads-lite.jar", "play-services-ads-lite.aar", "play-services-basement.jar", "play-services-basement.aar", "play-services-gass.jar", "play-services-gass.aar", "play-services-measurement-sdk-api.jar", "play-services-measurement-sdk-api.aar", "play-services-measurement-sdk.jar", "play-services-measurement-sdk.aar", "play-services-measurement-impl.jar", "play-services-measurement-impl.aar", "play-services-measurement-base.jar", "play-services-measurement-base.aar", "play-services-measurement-api.jar", "play-services-measurement-api.aar", "play-services-measurement.jar", "play-services-measurement.aar", "ump.jar"})
@SimpleObject
@UsesActivities(activities = {@ActivityElement(configChanges = "keyboard|keyboardHidden|orientation|screenLayout|uiMode|screenSize|smallestScreenSize", name = "com.google.android.gms.ads.AdActivity")})
@UsesPermissions({"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE", "android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
public final class KodularAdManagerInterstitial extends AndroidNonvisibleComponent implements Component {
    private Activity activity;
    private ComponentContainer container;
    private Context context;
    private Form form;
    private AdManagerInterstitialAd hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME;

    /* renamed from: hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME  reason: collision with other field name */
    private final KodularAdManager f161hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME;
    private KodularContentProtection kodularContentProtection;
    private boolean testMode;

    static /* synthetic */ AdManagerInterstitialAd hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME(KodularAdManagerInterstitial kodularAdManagerInterstitial, AdManagerInterstitialAd adManagerInterstitialAd) {
        AdManagerInterstitialAd adManagerInterstitialAd2 = adManagerInterstitialAd;
        AdManagerInterstitialAd adManagerInterstitialAd3 = adManagerInterstitialAd2;
        kodularAdManagerInterstitial.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME = adManagerInterstitialAd3;
        return adManagerInterstitialAd2;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public KodularAdManagerInterstitial(com.google.appinventor.components.runtime.ComponentContainer r9) {
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
            r2.f161hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME = r3
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.appinventor.components.runtime.KodularAdManagerInterstitial.<init>(com.google.appinventor.components.runtime.ComponentContainer):void");
    }

    @DesignerProperty(defaultValue = "False", editorType = "boolean")
    @SimpleProperty(userVisible = false)
    public final void TestMode(boolean z) {
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

    @SimpleEvent(description = "Event raised when an ad could not be loaded.")
    public final void FailedToLoad(String str) {
        boolean dispatchEvent = EventDispatcher.dispatchEvent(this, "FailedToLoad", str);
    }

    @SimpleEvent(description = "Event raised when an ad could not be displayd to the user.")
    public final void FailedToShow(String str) {
        boolean dispatchEvent = EventDispatcher.dispatchEvent(this, "FailedToShow", str);
    }

    @SimpleEvent(description = "Event raised when an ad was loaded successfully.")
    public final void Loaded() {
        boolean dispatchEvent = EventDispatcher.dispatchEvent(this, "Loaded", new Object[0]);
    }

    /* JADX WARNING: Multi-variable type inference failed */
    @com.google.appinventor.components.annotations.SimpleFunction(description = "Loads an interstitial ad and prepares it for showing to the user.")
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void Load() {
        /*
            r10 = this;
            r0 = r10
            com.google.android.gms.ads.admanager.AdManagerAdRequest$Builder r3 = new com.google.android.gms.ads.admanager.AdManagerAdRequest$Builder
            r9 = r3
            r3 = r9
            r4 = r9
            r4.<init>()
            java.lang.String r4 = "k-ad-format"
            java.lang.String r5 = "interstitial"
            com.google.android.gms.ads.admanager.AdManagerAdRequest$Builder r3 = r3.addCustomTargeting(r4, r5)
            com.google.android.gms.ads.admanager.AdManagerAdRequest r3 = r3.build()
            r9 = r3
            r3 = r9
            r4 = r9
            r1 = r4
            r4 = r0
            android.content.Context r4 = r4.context
            boolean r3 = r3.isTestDevice(r4)
            if (r3 != 0) goto L_0x0031
            r3 = r0
            boolean r3 = r3.testMode
            if (r3 == 0) goto L_0x0031
            r3 = r0
            java.lang.String r4 = "Could not load ad: Expected test device but got other"
            r3.FailedToLoad(r4)
        L_0x0030:
            return
        L_0x0031:
            com.google.appinventor.components.runtime.KodularAdManagerInterstitial$1 r3 = new com.google.appinventor.components.runtime.KodularAdManagerInterstitial$1
            r9 = r3
            r3 = r9
            r4 = r9
            r5 = r0
            r4.<init>(r5)
            r2 = r3
            r3 = r0
            com.google.appinventor.components.runtime.util.KodularContentProtection r3 = r3.kodularContentProtection
            com.google.appinventor.components.runtime.KodularAdManagerInterstitial$2 r4 = new com.google.appinventor.components.runtime.KodularAdManagerInterstitial$2
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
            goto L_0x0030
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.appinventor.components.runtime.KodularAdManagerInterstitial.Load():void");
    }

    @SimpleFunction(description = "Displays a previously loaded interstitial ad.")
    public final void Show() {
        if (this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME != null) {
            this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.show(this.activity);
        } else {
            FailedToShow("Could not show ad: No ad loaded!");
        }
    }
}
