package com.google.appinventor.components.runtime;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.RequestConfiguration;
import com.google.android.gms.ads.admanager.AdManagerAdRequest;
import com.google.android.gms.ads.admanager.AdManagerAdView;
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

@DesignerComponent(category = ComponentCategory.ADVERTISING, description = "A visible component that displays banner ads from multiple advertisers and mediation partners", iconName = "images/kodularBanner.png", nonVisible = false, version = 1)
@UsesLibraries({"browser.jar", "browser.aar", "play-services-ads.jar", "play-services-ads.aar", "play-services-ads-base.jar", "play-services-ads-base.aar", "play-services-ads-identifier.jar", "play-services-ads-identifier.aar", "play-services-ads-lite.jar", "play-services-ads-lite.aar", "play-services-basement.jar", "play-services-basement.aar", "play-services-gass.jar", "play-services-gass.aar", "play-services-measurement-sdk-api.jar", "play-services-measurement-sdk-api.aar", "play-services-measurement-sdk.jar", "play-services-measurement-sdk.aar", "play-services-measurement-impl.jar", "play-services-measurement-impl.aar", "play-services-measurement-base.jar", "play-services-measurement-base.aar", "play-services-measurement-api.jar", "play-services-measurement-api.aar", "play-services-measurement.jar", "play-services-measurement.aar", "ump.jar"})
@SimpleObject
@UsesActivities(activities = {@ActivityElement(configChanges = "keyboard|keyboardHidden|orientation|screenLayout|uiMode|screenSize|smallestScreenSize", name = "com.google.android.gms.ads.AdActivity")})
@UsesPermissions({"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE", "android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
public final class KodularAdManagerBanner extends AndroidViewComponent implements OnDestroyListener, OnPauseListener, OnResumeListener {
    private Activity activity;
    private ComponentContainer container;
    private Context context;
    private Form form;
    private AdManagerAdView hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME;

    /* renamed from: hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME  reason: collision with other field name */
    private final KodularAdManager f159hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME;
    private KodularContentProtection kodularContentProtection;
    private LinearLayout linearLayout;
    private boolean poblgm1P6mADk8QKAia8LTNTlp3hP9LK4vL2LyACRyn6OaTobhLhKjphCbjAETmg;
    private boolean testMode;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public KodularAdManagerBanner(com.google.appinventor.components.runtime.ComponentContainer r11) {
        /*
            r10 = this;
            r0 = r10
            r1 = r11
            r4 = r0
            r5 = r1
            r4.<init>(r5)
            r4 = r0
            r5 = r1
            r4.container = r5
            r4 = r0
            r5 = r1
            android.app.Activity r5 = r5.$context()
            r4.context = r5
            r4 = r0
            r5 = r1
            android.app.Activity r5 = r5.$context()
            r4.activity = r5
            r4 = r0
            r5 = r1
            com.google.appinventor.components.runtime.Form r5 = r5.$form()
            r4.form = r5
            r4 = r0
            com.google.appinventor.components.runtime.util.KodularAdManager r5 = new com.google.appinventor.components.runtime.util.KodularAdManager
            r9 = r5
            r5 = r9
            r6 = r9
            r7 = r0
            android.content.Context r7 = r7.context
            r8 = r0
            com.google.appinventor.components.runtime.Form r8 = r8.form
            r6.<init>(r7, r8)
            r4.f159hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME = r5
            r4 = r0
            com.google.appinventor.components.runtime.util.KodularContentProtection r5 = new com.google.appinventor.components.runtime.util.KodularContentProtection
            r9 = r5
            r5 = r9
            r6 = r9
            r7 = r0
            android.app.Activity r7 = r7.activity
            r6.<init>(r7)
            r4.kodularContentProtection = r5
            r4 = r0
            com.google.appinventor.components.runtime.Form r4 = r4.form
            r5 = r0
            r4.registerForOnDestroy(r5)
            r4 = r0
            com.google.appinventor.components.runtime.Form r4 = r4.form
            r5 = r0
            r4.registerForOnPause(r5)
            r4 = r0
            com.google.appinventor.components.runtime.Form r4 = r4.form
            r5 = r0
            r4.registerForOnResume(r5)
            r4 = r0
            r9 = r4
            r4 = r9
            r5 = r9
            r2 = r5
            android.widget.LinearLayout r5 = new android.widget.LinearLayout
            r9 = r5
            r5 = r9
            r6 = r9
            r7 = r2
            android.content.Context r7 = r7.context
            r6.<init>(r7)
            r4.linearLayout = r5
            r4 = r2
            android.widget.LinearLayout r4 = r4.linearLayout
            r5 = 0
            r4.setOrientation(r5)
            r4 = r2
            android.widget.LinearLayout r4 = r4.linearLayout
            android.widget.LinearLayout$LayoutParams r5 = new android.widget.LinearLayout$LayoutParams
            r9 = r5
            r5 = r9
            r6 = r9
            r7 = -1
            r8 = -2
            r6.<init>(r7, r8)
            r4.setLayoutParams(r5)
            r4 = r2
            com.google.android.gms.ads.admanager.AdManagerAdView r5 = new com.google.android.gms.ads.admanager.AdManagerAdView
            r9 = r5
            r5 = r9
            r6 = r9
            r7 = r2
            android.content.Context r7 = r7.context
            r6.<init>(r7)
            r4.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME = r5
            r4 = r2
            com.google.android.gms.ads.admanager.AdManagerAdView r4 = r4.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME
            r5 = 4
            com.google.android.gms.ads.AdSize[] r5 = new com.google.android.gms.ads.AdSize[r5]
            r9 = r5
            r5 = r9
            r6 = r9
            r7 = 0
            com.google.android.gms.ads.AdSize r8 = com.google.android.gms.ads.AdSize.BANNER
            r6[r7] = r8
            r9 = r5
            r5 = r9
            r6 = r9
            r7 = 1
            com.google.android.gms.ads.AdSize r8 = com.google.android.gms.ads.AdSize.FULL_BANNER
            r6[r7] = r8
            r9 = r5
            r5 = r9
            r6 = r9
            r7 = 2
            com.google.android.gms.ads.AdSize r8 = com.google.android.gms.ads.AdSize.LARGE_BANNER
            r6[r7] = r8
            r9 = r5
            r5 = r9
            r6 = r9
            r7 = 3
            com.google.android.gms.ads.AdSize r8 = com.google.android.gms.ads.AdSize.LEADERBOARD
            r6[r7] = r8
            r4.setAdSizes(r5)
            android.widget.RelativeLayout$LayoutParams r4 = new android.widget.RelativeLayout$LayoutParams
            r9 = r4
            r4 = r9
            r5 = r9
            r6 = -1
            r7 = -2
            r5.<init>(r6, r7)
            r9 = r4
            r4 = r9
            r5 = r9
            r3 = r5
            r5 = 12
            r4.addRule(r5)
            r4 = r2
            com.google.android.gms.ads.admanager.AdManagerAdView r4 = r4.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME
            r5 = r3
            r4.setLayoutParams(r5)
            r4 = r2
            com.google.android.gms.ads.admanager.AdManagerAdView r4 = r4.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME
            com.google.appinventor.components.runtime.KodularAdManagerBanner$2 r5 = new com.google.appinventor.components.runtime.KodularAdManagerBanner$2
            r9 = r5
            r5 = r9
            r6 = r9
            r7 = r2
            r6.<init>(r7)
            r4.setAdListener(r5)
            r4 = r2
            android.widget.LinearLayout r4 = r4.linearLayout
            r5 = r2
            com.google.android.gms.ads.admanager.AdManagerAdView r5 = r5.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME
            r4.addView(r5)
            r4 = r1
            r5 = r0
            r4.$add(r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.appinventor.components.runtime.KodularAdManagerBanner.<init>(com.google.appinventor.components.runtime.ComponentContainer):void");
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

    @SimpleFunction(description = "Loads a banner ad and displays it")
    public final void Load() {
        AdManagerAdRequest.Builder builder;
        KodularContentProtection.OnValidationResultListener onValidationResultListener;
        new AdManagerAdRequest.Builder();
        AdManagerAdRequest build = builder.addCustomTargeting("k-ad-format", "banner").build();
        AdManagerAdRequest adManagerAdRequest = build;
        if (build.isTestDevice(this.context) || !this.testMode) {
            if (!this.poblgm1P6mADk8QKAia8LTNTlp3hP9LK4vL2LyACRyn6OaTobhLhKjphCbjAETmg) {
                if (this.testMode || this.form.IsCompanion()) {
                    this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.setAdUnitId(KodularAdsUtil.AD_MANAGER_BANNER_TEST_ID);
                } else {
                    this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.setAdUnitId(this.f159hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.getAdUnit());
                }
                this.poblgm1P6mADk8QKAia8LTNTlp3hP9LK4vL2LyACRyn6OaTobhLhKjphCbjAETmg = true;
            }
            final AdManagerAdRequest adManagerAdRequest2 = adManagerAdRequest;
            new KodularContentProtection.OnValidationResultListener(this) {

                /* renamed from: hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME  reason: collision with other field name */
                private /* synthetic */ KodularAdManagerBanner f160hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME;

                {
                    this.f160hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME = r6;
                }

                public final void onResult(boolean z, boolean z2, String str) {
                    boolean z3 = z2;
                    String str2 = str;
                    if (!z || !z3) {
                        this.f160hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.FailedToLoad(str2);
                    } else {
                        KodularAdManagerBanner.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME(this.f160hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME).loadAd(adManagerAdRequest2);
                    }
                }
            };
            this.kodularContentProtection.setOnValidationResultListener(onValidationResultListener);
            this.kodularContentProtection.startContentValidation(this.form.getAppId());
            return;
        }
        FailedToLoad("Could not load ad: Expected test device but got other");
    }

    @SimpleEvent(description = "Event raised when an ad could not be loaded")
    public final void FailedToLoad(String str) {
        boolean dispatchEvent = EventDispatcher.dispatchEvent(this, "FailedToLoad", str);
    }

    public final View getView() {
        return this.linearLayout;
    }

    public final void onPause() {
        if (this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME != null) {
            this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.pause();
        }
    }

    public final void onResume() {
        if (this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME != null) {
            this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.resume();
        }
    }

    public final void onDestroy() {
        if (this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME != null) {
            this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.destroy();
        }
        KodularAdManager.Consent.destroy();
    }

    public final int Height() {
        return getView().getHeight();
    }

    public final void Height(int i) {
        this.container.setChildHeight(this, i);
    }

    public final int Width() {
        return getView().getWidth();
    }

    public final void Width(int i) {
        this.container.setChildWidth(this, i);
    }

    public final void HeightPercent(int i) {
    }

    public final void WidthPercent(int i) {
    }
}
