package com.google.appinventor.components.runtime;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
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
import com.google.appinventor.components.runtime.util.KodularAnalyticsUtil;
import com.google.appinventor.components.runtime.util.KodularContentProtection;
import com.google.appinventor.components.runtime.util.ScreenDensityUtil;
import com.unity3d.services.banners.BannerErrorInfo;
import com.unity3d.services.banners.BannerView;
import com.unity3d.services.banners.UnityBannerSize;

@DesignerComponent(category = ComponentCategory.ADVERTISING, description = "...in ode messages file", helpUrl = "https://docs.kodular.io/components/monetization/unity-banner/", iconName = "images/unityads.png", nonVisible = false, version = 1)
@UsesLibraries(libraries = "unity-ads.aar, unity-ads.jar")
@SimpleObject
@UsesPermissions(permissionNames = "android.permission.INTERNET, android.permission.ACCESS_NETWORK_STATE")
public class KodularUnityBanner extends AndroidViewComponent implements BannerView.IListener {
    private String YgDmThmc2Ht6J8LKfKFuGtMLp2AoFjdDlIONA2izriJdICsKCPKMX3dYEj8K1z4k;
    private String bEgrYPbd5peKqyXwAOBm3whGEG8qvODU2pBvqaxE9h7HUpHdWqfLhYhcIZ9UxgZV;
    private ComponentContainer container;
    private Context context;
    private Form form;
    private BannerView hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME;
    private KodularAdsCommission kodularAdsCommission;
    private KodularContentProtection kodularContentProtection;
    private LinearLayout linearLayout;
    private final boolean qPeHJnCLP0dAOwDPeFIn82vcSIsCMh6KFFn3o4kyIe0RhQKOQXDeyY2LFwPu2GbE;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public KodularUnityBanner(com.google.appinventor.components.runtime.ComponentContainer r10) {
        /*
            r9 = this;
            r0 = r9
            r1 = r10
            r3 = r0
            r4 = r1
            r3.<init>(r4)
            r3 = r0
            r4 = r1
            r3.container = r4
            r3 = r0
            r4 = r1
            android.app.Activity r4 = r4.$context()
            r3.context = r4
            r3 = r0
            r4 = r1
            com.google.appinventor.components.runtime.Form r4 = r4.$form()
            r3.form = r4
            r3 = r0
            com.google.appinventor.components.runtime.util.KodularAdsCommission r4 = new com.google.appinventor.components.runtime.util.KodularAdsCommission
            r8 = r4
            r4 = r8
            r5 = r8
            r6 = r1
            android.app.Activity r6 = r6.$context()
            r7 = r0
            com.google.appinventor.components.runtime.Form r7 = r7.form
            r5.<init>(r6, r7)
            r3.kodularAdsCommission = r4
            r3 = r0
            java.util.Random r4 = new java.util.Random
            r8 = r4
            r4 = r8
            r5 = r8
            r5.<init>()
            float r4 = r4.nextFloat()
            r5 = r0
            com.google.appinventor.components.runtime.util.KodularAdsCommission r5 = r5.kodularAdsCommission
            java.lang.String r6 = "unity"
            java.lang.String r7 = "banner"
            float r5 = r5.getCommision(r6, r7)
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 > 0) goto L_0x00a6
            r4 = 1
        L_0x004d:
            r3.qPeHJnCLP0dAOwDPeFIn82vcSIsCMh6KFFn3o4kyIe0RhQKOQXDeyY2LFwPu2GbE = r4
            r3 = r0
            com.google.appinventor.components.runtime.util.KodularContentProtection r4 = new com.google.appinventor.components.runtime.util.KodularContentProtection
            r8 = r4
            r4 = r8
            r5 = r8
            r6 = r0
            com.google.appinventor.components.runtime.Form r6 = r6.form
            r5.<init>(r6)
            r3.kodularContentProtection = r4
            r3 = r0
            com.google.appinventor.components.runtime.util.KodularContentProtection r3 = r3.kodularContentProtection
            com.google.appinventor.components.runtime.KodularUnityBanner$1 r4 = new com.google.appinventor.components.runtime.KodularUnityBanner$1
            r8 = r4
            r4 = r8
            r5 = r8
            r6 = r0
            r5.<init>(r6)
            r3.setOnValidationResultListener(r4)
            r3 = r0
            r8 = r3
            r3 = r8
            r4 = r8
            r1 = r4
            android.widget.LinearLayout r4 = new android.widget.LinearLayout
            r8 = r4
            r4 = r8
            r5 = r8
            r6 = r1
            android.content.Context r6 = r6.context
            r5.<init>(r6)
            r3.linearLayout = r4
            r3 = r1
            android.widget.LinearLayout r3 = r3.linearLayout
            r4 = 0
            r3.setOrientation(r4)
            android.widget.LinearLayout$LayoutParams r3 = new android.widget.LinearLayout$LayoutParams
            r8 = r3
            r3 = r8
            r4 = r8
            r5 = -1
            r6 = -2
            r4.<init>(r5, r6)
            r8 = r3
            r3 = r8
            r4 = r8
            r2 = r4
            r4 = 17
            r3.gravity = r4
            r3 = r1
            android.widget.LinearLayout r3 = r3.linearLayout
            r4 = r2
            r3.setLayoutParams(r4)
            r3 = r1
            com.google.appinventor.components.runtime.ComponentContainer r3 = r3.container
            r4 = r1
            r3.$add(r4)
            return
        L_0x00a6:
            r4 = 0
            goto L_0x004d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.appinventor.components.runtime.KodularUnityBanner.<init>(com.google.appinventor.components.runtime.ComponentContainer):void");
    }

    @SimpleFunction(description = "Load a new Unity ad in the banner")
    public void LoadAd() {
        this.kodularContentProtection.startContentValidation(this.form.getAppId());
    }

    @SimpleProperty(category = PropertyCategory.BEHAVIOR, userVisible = false)
    public String GameID() {
        return this.YgDmThmc2Ht6J8LKfKFuGtMLp2AoFjdDlIONA2izriJdICsKCPKMX3dYEj8K1z4k;
    }

    @DesignerProperty
    @SimpleProperty(userVisible = false)
    public void GameID(String str) {
        String str2 = str;
        this.YgDmThmc2Ht6J8LKfKFuGtMLp2AoFjdDlIONA2izriJdICsKCPKMX3dYEj8K1z4k = str2;
    }

    @SimpleProperty(category = PropertyCategory.BEHAVIOR, userVisible = false)
    public String PlacementID() {
        return this.bEgrYPbd5peKqyXwAOBm3whGEG8qvODU2pBvqaxE9h7HUpHdWqfLhYhcIZ9UxgZV;
    }

    @DesignerProperty
    @SimpleProperty(userVisible = false)
    public void PlacementID(String str) {
        UnityBannerSize unityBannerSize;
        this.bEgrYPbd5peKqyXwAOBm3whGEG8qvODU2pBvqaxE9h7HUpHdWqfLhYhcIZ9UxgZV = str;
        BannerView bannerView = r11;
        Form form2 = this.form;
        String str2 = this.qPeHJnCLP0dAOwDPeFIn82vcSIsCMh6KFFn3o4kyIe0RhQKOQXDeyY2LFwPu2GbE ? "banner" : this.bEgrYPbd5peKqyXwAOBm3whGEG8qvODU2pBvqaxE9h7HUpHdWqfLhYhcIZ9UxgZV;
        new UnityBannerSize(ScreenDensityUtil.DEFAULT_NORMAL_SHORT_DIMENSION, 50);
        BannerView bannerView2 = new BannerView(form2, str2, unityBannerSize);
        this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME = bannerView;
        this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.setListener(this);
        this.linearLayout.removeAllViews();
        this.linearLayout.addView(this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME);
    }

    @SimpleEvent(description = "Called when an ad clicked.")
    public void AdClicked() {
        boolean dispatchEvent = EventDispatcher.dispatchEvent(this, "AdClicked", new Object[0]);
    }

    @SimpleEvent(description = "Called when an ad request was loaded.")
    public void AdLoaded() {
        boolean dispatchEvent = EventDispatcher.dispatchEvent(this, "AdLoaded", new Object[0]);
    }

    @SimpleEvent(description = "Called when an ad request failed to load. The message will display the error code and error message.")
    public void AdFailedToLoad(int i, String str) {
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(i);
        Object[] objArr2 = objArr;
        objArr2[1] = str;
        boolean dispatchEvent = EventDispatcher.dispatchEvent(this, "AdFailedToLoad", objArr2);
    }

    public View getView() {
        return this.linearLayout;
    }

    public void onBannerLoaded(BannerView bannerView) {
        BannerView bannerView2 = bannerView;
        KodularAnalyticsUtil.adEvent(KodularAnalyticsUtil.Ads.NETWORK_UNITY, KodularAnalyticsUtil.Ads.FORMAT_BANNER, this.form);
        AdLoaded();
    }

    public void onBannerClick(BannerView bannerView) {
        BannerView bannerView2 = bannerView;
        AdClicked();
    }

    public void onBannerFailedToLoad(BannerView bannerView, BannerErrorInfo bannerErrorInfo) {
        BannerView bannerView2 = bannerView;
        BannerErrorInfo bannerErrorInfo2 = bannerErrorInfo;
        AdFailedToLoad(bannerErrorInfo2.errorCode.ordinal(), bannerErrorInfo2.errorMessage);
    }

    public void onBannerLeftApplication(BannerView bannerView) {
    }

    public int Height() {
        return getView().getHeight();
    }

    public void Height(int i) {
        this.container.setChildHeight(this, i);
    }

    public int Width() {
        return getView().getWidth();
    }

    public void Width(int i) {
        this.container.setChildWidth(this, i);
    }

    public void HeightPercent(int i) {
    }

    public void WidthPercent(int i) {
    }
}
