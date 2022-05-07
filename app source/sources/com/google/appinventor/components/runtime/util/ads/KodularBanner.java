package com.google.appinventor.components.runtime.util.ads;

import android.view.View;
import android.widget.LinearLayout;
import com.google.appinventor.components.runtime.Component;
import com.google.appinventor.components.runtime.Form;
import com.google.appinventor.components.runtime.util.KodularAdsUtil;
import com.google.appinventor.components.runtime.util.ScreenDensityUtil;
import com.startapp.sdk.ads.banner.Banner;
import com.startapp.sdk.ads.banner.BannerListener;
import com.startapp.sdk.adsbase.StartAppAd;
import com.startapp.sdk.adsbase.StartAppSDK;
import com.unity3d.ads.UnityAds;
import com.unity3d.services.banners.BannerErrorInfo;
import com.unity3d.services.banners.BannerView;
import com.unity3d.services.banners.UnityBannerSize;

public class KodularBanner {
    private String FIE8cugyTFVTdxJSfxM9EehRPnzPzIOAc9vSAeB8a1WUYj86HP0oOgrT11MLilPE = Component.COMMISSION_BANNER_ADS_NETWORK_DEFAULT;
    /* access modifiers changed from: private */
    public OnAdsSwitcherListener hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME;

    /* renamed from: hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME  reason: collision with other field name */
    private Banner f318hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME;

    /* renamed from: hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME  reason: collision with other field name */
    private BannerView f319hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME;

    public interface OnAdsSwitcherListener {
        void onAdsClick();

        void onAdsError(String str);

        void onAdsReady();
    }

    public KodularBanner() {
    }

    public void setOnAdsSwitcherListener(OnAdsSwitcherListener onAdsSwitcherListener) {
        OnAdsSwitcherListener onAdsSwitcherListener2 = onAdsSwitcherListener;
        this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME = onAdsSwitcherListener2;
    }

    public void updateNetwork(String str) {
        String str2 = str;
        this.FIE8cugyTFVTdxJSfxM9EehRPnzPzIOAc9vSAeB8a1WUYj86HP0oOgrT11MLilPE = str2;
    }

    public void loadAd(LinearLayout linearLayout, Form form, boolean z) {
        Banner banner;
        BannerListener bannerListener;
        BannerView bannerView;
        UnityBannerSize unityBannerSize;
        BannerView.IListener iListener;
        LinearLayout linearLayout2 = linearLayout;
        Form form2 = form;
        boolean z2 = z;
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) linearLayout2.getLayoutParams();
        String str = this.FIE8cugyTFVTdxJSfxM9EehRPnzPzIOAc9vSAeB8a1WUYj86HP0oOgrT11MLilPE;
        boolean z3 = true;
        switch (str.hashCode()) {
            case 1316799103:
                if (str.equals(Component.COMMISSION_BANNER_ADS_NETWORK_DEFAULT)) {
                    z3 = false;
                    break;
                }
                break;
        }
        switch (z3) {
            case false:
                linearLayout2.removeAllViews();
                layoutParams.gravity = 1;
                linearLayout2.setLayoutParams(layoutParams);
                StartAppSDK.init(form2.$context(), KodularAdsUtil.STARTAPP_APP_ID, false);
                StartAppSDK.enableReturnAds(false);
                StartAppAd.disableSplash();
                StartAppSDK.setUserConsent(form2.$context(), "pas", System.currentTimeMillis(), false);
                new BannerListener(this) {
                    private /* synthetic */ KodularBanner B8WBXPBCF2jGfUDZZU2zV5EYdqbUBu0lAZ0THCEqYyuE8VACR9dY7rDnwBIqh64T;

                    {
                        this.B8WBXPBCF2jGfUDZZU2zV5EYdqbUBu0lAZ0THCEqYyuE8VACR9dY7rDnwBIqh64T = r5;
                    }

                    public final void onReceiveAd(View view) {
                        View view2 = view;
                        if (this.B8WBXPBCF2jGfUDZZU2zV5EYdqbUBu0lAZ0THCEqYyuE8VACR9dY7rDnwBIqh64T.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME != null) {
                            this.B8WBXPBCF2jGfUDZZU2zV5EYdqbUBu0lAZ0THCEqYyuE8VACR9dY7rDnwBIqh64T.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.onAdsReady();
                        }
                    }

                    public final void onFailedToReceiveAd(View view) {
                        View view2 = view;
                        if (this.B8WBXPBCF2jGfUDZZU2zV5EYdqbUBu0lAZ0THCEqYyuE8VACR9dY7rDnwBIqh64T.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME != null) {
                            this.B8WBXPBCF2jGfUDZZU2zV5EYdqbUBu0lAZ0THCEqYyuE8VACR9dY7rDnwBIqh64T.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.onAdsError("Could not load ad");
                        }
                    }

                    public final void onImpression(View view) {
                    }

                    public final void onClick(View view) {
                        View view2 = view;
                        if (this.B8WBXPBCF2jGfUDZZU2zV5EYdqbUBu0lAZ0THCEqYyuE8VACR9dY7rDnwBIqh64T.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME != null) {
                            this.B8WBXPBCF2jGfUDZZU2zV5EYdqbUBu0lAZ0THCEqYyuE8VACR9dY7rDnwBIqh64T.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.onAdsClick();
                        }
                    }
                };
                new Banner(form2.$context(), bannerListener);
                this.f318hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME = banner;
                linearLayout2.addView(this.f318hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME);
                this.f318hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.loadAd(ScreenDensityUtil.DEFAULT_NORMAL_SHORT_DIMENSION, 50);
                return;
            default:
                linearLayout2.removeAllViews();
                layoutParams.gravity = 17;
                linearLayout2.setLayoutParams(layoutParams);
                UnityAds.initialize(form2, KodularAdsUtil.UNITY_ADS_GAME_ID, z2);
                new UnityBannerSize(ScreenDensityUtil.DEFAULT_NORMAL_SHORT_DIMENSION, 50);
                new BannerView(form2, "banner", unityBannerSize);
                this.f319hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME = bannerView;
                new BannerView.IListener(this) {
                    private /* synthetic */ KodularBanner B8WBXPBCF2jGfUDZZU2zV5EYdqbUBu0lAZ0THCEqYyuE8VACR9dY7rDnwBIqh64T;

                    {
                        this.B8WBXPBCF2jGfUDZZU2zV5EYdqbUBu0lAZ0THCEqYyuE8VACR9dY7rDnwBIqh64T = r5;
                    }

                    public final void onBannerLoaded(BannerView bannerView) {
                        BannerView bannerView2 = bannerView;
                        if (this.B8WBXPBCF2jGfUDZZU2zV5EYdqbUBu0lAZ0THCEqYyuE8VACR9dY7rDnwBIqh64T.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME != null) {
                            this.B8WBXPBCF2jGfUDZZU2zV5EYdqbUBu0lAZ0THCEqYyuE8VACR9dY7rDnwBIqh64T.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.onAdsReady();
                        }
                    }

                    public final void onBannerClick(BannerView bannerView) {
                        BannerView bannerView2 = bannerView;
                        if (this.B8WBXPBCF2jGfUDZZU2zV5EYdqbUBu0lAZ0THCEqYyuE8VACR9dY7rDnwBIqh64T.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME != null) {
                            this.B8WBXPBCF2jGfUDZZU2zV5EYdqbUBu0lAZ0THCEqYyuE8VACR9dY7rDnwBIqh64T.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.onAdsClick();
                        }
                    }

                    public final void onBannerFailedToLoad(BannerView bannerView, BannerErrorInfo bannerErrorInfo) {
                        BannerView bannerView2 = bannerView;
                        BannerErrorInfo bannerErrorInfo2 = bannerErrorInfo;
                        if (this.B8WBXPBCF2jGfUDZZU2zV5EYdqbUBu0lAZ0THCEqYyuE8VACR9dY7rDnwBIqh64T.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME != null) {
                            this.B8WBXPBCF2jGfUDZZU2zV5EYdqbUBu0lAZ0THCEqYyuE8VACR9dY7rDnwBIqh64T.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.onAdsError(bannerErrorInfo2.errorMessage);
                        }
                    }

                    public final void onBannerLeftApplication(BannerView bannerView) {
                    }
                };
                this.f319hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.setListener(iListener);
                linearLayout2.addView(this.f319hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME);
                this.f319hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.load();
                return;
        }
    }
}
