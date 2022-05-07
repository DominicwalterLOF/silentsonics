package com.google.appinventor.components.runtime.util;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import java.util.Calendar;
import java.util.Date;

public class MakeroidDataProtection {
    public static String TYPE_AD_MOB_BANNER = "AdMob Banner";
    public static String TYPE_AD_MOB_INTERSTITIAL = "AdMob Interstitial";
    public static String TYPE_AD_MOB_REWARDED_VIDEO = "AdMob Rewarded Video";
    private AdView B8WBXPBCF2jGfUDZZU2zV5EYdqbUBu0lAZ0THCEqYyuE8VACR9dY7rDnwBIqh64T;

    /* renamed from: B8WBXPBCF2jGfUDZZU2zV5EYdqbUBu0lAZ0THCEqYyuE8VACR9dY7rDnwBIqh64T  reason: collision with other field name */
    private InterstitialAd f280B8WBXPBCF2jGfUDZZU2zV5EYdqbUBu0lAZ0THCEqYyuE8VACR9dY7rDnwBIqh64T;

    /* renamed from: B8WBXPBCF2jGfUDZZU2zV5EYdqbUBu0lAZ0THCEqYyuE8VACR9dY7rDnwBIqh64T  reason: collision with other field name */
    private RewardedVideoAd f281B8WBXPBCF2jGfUDZZU2zV5EYdqbUBu0lAZ0THCEqYyuE8VACR9dY7rDnwBIqh64T;
    private String Czk3JxQndp8OXzdhVJbUdjsQzir0LjcvTO4sxxzJFetSb3s5Ea1z9Q4DZEvMPAr1;
    private String G6NGZkO3GzJPBmNJ6LwDoEfdjbnPkejEO5C5VyyDaUNT1yJXqTcFE5lxbNsfgCQk = "Makeroid Data Protection Database 18";
    private String LOG_TAG = "Makeroid Data Protection";
    private int LYXVmrSApJtjkX58iaWYcT93zXSX0GhbrHTAKbm3TBRJ5avsjGCN1sJz61Za2zkA = 0;
    private String OOU2L6ZPvPBvVsNChdspsFDAiRPppRoUY09Zs89r9dCXQgf8whit7Vv4m0wrV8PG;
    private String SZ5aRRQoo4RABtl0KnlkQDhNcppg3ZUNkmsRmBa9EW4UdQenZXJCu8cuK0SgtVYc;
    private boolean Sj3UMCQcT7f46E8U4TVavenawPElr174psURarVHJJBTqMXe22hIekct3fzxe7Vm = true;
    private boolean TDuNe2Upxoi7WX7QZc6R8eUnFPyyDFw3hP7z3w6U8jMxQwJRQM03zSa9HzWXRv1 = false;
    private boolean ZBOPOXf20XZKrN6ycbQhEDPC2OsW2QCGfMHApJMYjAVGCpHVQNyA3eb1TXx8tY2I = false;
    private SharedPreferences.Editor hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME;

    /* renamed from: hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME  reason: collision with other field name */
    private OnConsentListener f282hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME;
    private boolean ik13O8j78hPb27XeipAJHUcJmdHxYMJFw4gYbTGvLKIOs7SX1F7x61gocQ17TlNc = false;
    private String iydqlq85U6KFMIBI7LRgMfKfWOWXdlnJs0rL9QevzYsIGMKLioEecnL9YVjuTN9v;
    private int kkTI9AxohjOECYVBpzZOuVO0b9llYVM2xqggkPHvpPoNGTREwN5YZmwC10Gk8X2Q;
    private String nEkPfLDGYD22bahiHhpKxaqa4vdjROQiBAWGj9Zqw3V6ag4osXolkZLRAXiafTD = "";
    private Drawable qPeHJnCLP0dAOwDPeFIn82vcSIsCMh6KFFn3o4kyIe0RhQKOQXDeyY2LFwPu2GbE = null;
    private Context vSp02fkBXgM8EI0gm0rKWXHQ6wdQINJBQuAtCR15YU8g4XNqVKV8r32SYxkQYxkq;
    private boolean wfWoJD9s05zGciiq11jj7TXqW1AmJIE9BV68DWBBkLZSv9NayRoTG3XJb9WJMlyD;
    private SharedPreferences wq07duYRO6iFAgWM70EZOSvbCMKs1QznMRJKrct0XuHOBYqCk3XqOKtSBGIpDou;

    /* renamed from: wq07duYRO6iFAgWM70EZOSvbCMKs1QznMRJKrct0XuHOBYqCk3XqOKtSBGIpDou  reason: collision with other field name */
    private Bundle f283wq07duYRO6iFAgWM70EZOSvbCMKs1QznMRJKrct0XuHOBYqCk3XqOKtSBGIpDou;
    private boolean yHAbLPerXNK4pCwn5nqbt3OeUjDvQdxh29RmVa0moB4dUtgatbeaGoP5jClPUWFb = false;

    public interface OnConsentListener {
        void result(boolean z, boolean z2);
    }

    public MakeroidDataProtection(Context context) {
        Bundle bundle;
        new Bundle();
        this.f283wq07duYRO6iFAgWM70EZOSvbCMKs1QznMRJKrct0XuHOBYqCk3XqOKtSBGIpDou = bundle;
        setContext(context);
    }

    public MakeroidDataProtection(Context context, String str) {
        Bundle bundle;
        new Bundle();
        this.f283wq07duYRO6iFAgWM70EZOSvbCMKs1QznMRJKrct0XuHOBYqCk3XqOKtSBGIpDou = bundle;
        setContext(context);
        setComponentType(str);
    }

    private void setContext(Context context) {
        this.vSp02fkBXgM8EI0gm0rKWXHQ6wdQINJBQuAtCR15YU8g4XNqVKV8r32SYxkQYxkq = context;
        this.wq07duYRO6iFAgWM70EZOSvbCMKs1QznMRJKrct0XuHOBYqCk3XqOKtSBGIpDou = this.vSp02fkBXgM8EI0gm0rKWXHQ6wdQINJBQuAtCR15YU8g4XNqVKV8r32SYxkQYxkq.getSharedPreferences(this.G6NGZkO3GzJPBmNJ6LwDoEfdjbnPkejEO5C5VyyDaUNT1yJXqTcFE5lxbNsfgCQk, 0);
        this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME = this.wq07duYRO6iFAgWM70EZOSvbCMKs1QznMRJKrct0XuHOBYqCk3XqOKtSBGIpDou.edit();
        this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.apply();
        this.f283wq07duYRO6iFAgWM70EZOSvbCMKs1QznMRJKrct0XuHOBYqCk3XqOKtSBGIpDou.putString("npa", "1");
        int i = Log.i(this.LOG_TAG, "Context was added.");
    }

    public void setAdView(AdView adView) {
        this.B8WBXPBCF2jGfUDZZU2zV5EYdqbUBu0lAZ0THCEqYyuE8VACR9dY7rDnwBIqh64T = adView;
        int i = Log.i(this.LOG_TAG, "AdView was added.");
    }

    public void setInterstitialAd(InterstitialAd interstitialAd) {
        this.f280B8WBXPBCF2jGfUDZZU2zV5EYdqbUBu0lAZ0THCEqYyuE8VACR9dY7rDnwBIqh64T = interstitialAd;
        int i = Log.i(this.LOG_TAG, "InterstitialAd was added.");
    }

    public void setRewardedVideoAd(RewardedVideoAd rewardedVideoAd) {
        this.f281B8WBXPBCF2jGfUDZZU2zV5EYdqbUBu0lAZ0THCEqYyuE8VACR9dY7rDnwBIqh64T = rewardedVideoAd;
        int i = Log.i(this.LOG_TAG, "RewardedVideoAd was added.");
    }

    public void setInterstitialOptions(boolean z, String str, int i) {
        String str2 = str;
        int i2 = i;
        this.wfWoJD9s05zGciiq11jj7TXqW1AmJIE9BV68DWBBkLZSv9NayRoTG3XJb9WJMlyD = z;
        if (str2.equalsIgnoreCase("female")) {
            this.LYXVmrSApJtjkX58iaWYcT93zXSX0GhbrHTAKbm3TBRJ5avsjGCN1sJz61Za2zkA = 2;
        } else if (str2.equalsIgnoreCase("male")) {
            this.LYXVmrSApJtjkX58iaWYcT93zXSX0GhbrHTAKbm3TBRJ5avsjGCN1sJz61Za2zkA = 1;
        } else {
            this.LYXVmrSApJtjkX58iaWYcT93zXSX0GhbrHTAKbm3TBRJ5avsjGCN1sJz61Za2zkA = 0;
        }
        this.kkTI9AxohjOECYVBpzZOuVO0b9llYVM2xqggkPHvpPoNGTREwN5YZmwC10Gk8X2Q = i2;
        this.ZBOPOXf20XZKrN6ycbQhEDPC2OsW2QCGfMHApJMYjAVGCpHVQNyA3eb1TXx8tY2I = true;
    }

    public void setRewardedOptions(String str) {
        this.iydqlq85U6KFMIBI7LRgMfKfWOWXdlnJs0rL9QevzYsIGMKLioEecnL9YVjuTN9v = str;
        this.TDuNe2Upxoi7WX7QZc6R8eUnFPyyDFw3hP7z3w6U8jMxQwJRQM03zSa9HzWXRv1 = true;
    }

    public void setComponentType(String str) {
        StringBuilder sb;
        String str2 = str;
        this.SZ5aRRQoo4RABtl0KnlkQDhNcppg3ZUNkmsRmBa9EW4UdQenZXJCu8cuK0SgtVYc = str2;
        String str3 = this.LOG_TAG;
        new StringBuilder();
        int i = Log.i(str3, sb.append(str2).append(" component was added.").toString());
    }

    private String vwEpIRqEf6xdtwTR9dehwBO7JUhyLV6iEzEK2WqfPN10eUMQDPn3AUmqAFfsnr6R() {
        return vSp02fkBXgM8EI0gm0rKWXHQ6wdQINJBQuAtCR15YU8g4XNqVKV8r32SYxkQYxkq(this.SZ5aRRQoo4RABtl0KnlkQDhNcppg3ZUNkmsRmBa9EW4UdQenZXJCu8cuK0SgtVYc, "TYPE_WAS_NOT_FOUND");
    }

    public void setTitle(String str) {
        this.Czk3JxQndp8OXzdhVJbUdjsQzir0LjcvTO4sxxzJFetSb3s5Ea1z9Q4DZEvMPAr1 = str;
        int i = Log.i(this.LOG_TAG, "DialogTitle was added.");
    }

    public String getTitle() {
        return vSp02fkBXgM8EI0gm0rKWXHQ6wdQINJBQuAtCR15YU8g4XNqVKV8r32SYxkQYxkq(this.Czk3JxQndp8OXzdhVJbUdjsQzir0LjcvTO4sxxzJFetSb3s5Ea1z9Q4DZEvMPAr1, "Data Protection");
    }

    public void setMessage(String str) {
        this.OOU2L6ZPvPBvVsNChdspsFDAiRPppRoUY09Zs89r9dCXQgf8whit7Vv4m0wrV8PG = str;
        int i = Log.i(this.LOG_TAG, "DialogMessage was added.");
    }

    public String getMessage() {
        return vSp02fkBXgM8EI0gm0rKWXHQ6wdQINJBQuAtCR15YU8g4XNqVKV8r32SYxkQYxkq(this.OOU2L6ZPvPBvVsNChdspsFDAiRPppRoUY09Zs89r9dCXQgf8whit7Vv4m0wrV8PG, "Can we continue to use your data to tailor ads for you?");
    }

    public void RevokeConsent() {
        SharedPreferences.Editor putBoolean = this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.putBoolean("AdsFree", false);
        SharedPreferences.Editor putBoolean2 = this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.putBoolean("Personalized", false);
        SharedPreferences.Editor putBoolean3 = this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.putBoolean("FirstTime", true);
        boolean commit = this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.commit();
        int i = Log.i(this.LOG_TAG, "The user withdrew the consent.");
    }

    public boolean getAdsFreeResult() {
        return false;
    }

    public boolean getPersonalizedResult() {
        return this.Sj3UMCQcT7f46E8U4TVavenawPElr174psURarVHJJBTqMXe22hIekct3fzxe7Vm;
    }

    public void setDevelopmentMode(boolean z) {
        boolean z2 = z;
        this.ik13O8j78hPb27XeipAJHUcJmdHxYMJFw4gYbTGvLKIOs7SX1F7x61gocQ17TlNc = z2;
    }

    public boolean getDevelopmentMode() {
        return this.ik13O8j78hPb27XeipAJHUcJmdHxYMJFw4gYbTGvLKIOs7SX1F7x61gocQ17TlNc;
    }

    public void Start() {
        StringBuilder sb;
        AlertDialog.Builder builder;
        DialogInterface.OnClickListener onClickListener;
        DialogInterface.OnClickListener onClickListener2;
        if (!KodularGDPRUtil.isRequestLocationInEurope(this.vSp02fkBXgM8EI0gm0rKWXHQ6wdQINJBQuAtCR15YU8g4XNqVKV8r32SYxkQYxkq) && !this.ik13O8j78hPb27XeipAJHUcJmdHxYMJFw4gYbTGvLKIOs7SX1F7x61gocQ17TlNc) {
            int i = Log.i(this.LOG_TAG, "isRequestLocationInEurope = false.");
            B8WBXPBCF2jGfUDZZU2zV5EYdqbUBu0lAZ0THCEqYyuE8VACR9dY7rDnwBIqh64T(1);
        } else if (!this.ik13O8j78hPb27XeipAJHUcJmdHxYMJFw4gYbTGvLKIOs7SX1F7x61gocQ17TlNc && !this.wq07duYRO6iFAgWM70EZOSvbCMKs1QznMRJKrct0XuHOBYqCk3XqOKtSBGIpDou.getBoolean("FirstTime", true)) {
            int i2 = Log.i(this.LOG_TAG, "The user has already made a selection.");
            if (this.wq07duYRO6iFAgWM70EZOSvbCMKs1QznMRJKrct0XuHOBYqCk3XqOKtSBGIpDou.getBoolean("Personalized", false)) {
                int i3 = Log.i(this.LOG_TAG, "Personalized was loaded from the db.");
                B8WBXPBCF2jGfUDZZU2zV5EYdqbUBu0lAZ0THCEqYyuE8VACR9dY7rDnwBIqh64T(1);
            } else if (this.wq07duYRO6iFAgWM70EZOSvbCMKs1QznMRJKrct0XuHOBYqCk3XqOKtSBGIpDou.getBoolean("AdsFree", false)) {
                int i4 = Log.i(this.LOG_TAG, "AdsFree was loaded from the db.");
            } else {
                int i5 = Log.i(this.LOG_TAG, "Non-Personalized was loaded from the db.");
                B8WBXPBCF2jGfUDZZU2zV5EYdqbUBu0lAZ0THCEqYyuE8VACR9dY7rDnwBIqh64T(2);
            }
        } else if (this.vSp02fkBXgM8EI0gm0rKWXHQ6wdQINJBQuAtCR15YU8g4XNqVKV8r32SYxkQYxkq == null) {
            int e = Log.e(this.LOG_TAG, "Please add your context in 'void setContext(Context context);'");
        } else {
            String str = this.LOG_TAG;
            new StringBuilder("Development mode is: ");
            int i6 = Log.i(str, sb.append(this.ik13O8j78hPb27XeipAJHUcJmdHxYMJFw4gYbTGvLKIOs7SX1F7x61gocQ17TlNc).toString());
            new AlertDialog.Builder(this.vSp02fkBXgM8EI0gm0rKWXHQ6wdQINJBQuAtCR15YU8g4XNqVKV8r32SYxkQYxkq, 16974393);
            AlertDialog create = builder.create();
            AlertDialog alertDialog = create;
            create.setTitle(getTitle());
            alertDialog.setMessage(TextViewUtil.fromHtml(getMessage()));
            alertDialog.setCancelable(false);
            new DialogInterface.OnClickListener(this) {
                private /* synthetic */ MakeroidDataProtection B8WBXPBCF2jGfUDZZU2zV5EYdqbUBu0lAZ0THCEqYyuE8VACR9dY7rDnwBIqh64T;

                {
                    this.B8WBXPBCF2jGfUDZZU2zV5EYdqbUBu0lAZ0THCEqYyuE8VACR9dY7rDnwBIqh64T = r5;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    DialogInterface dialogInterface2 = dialogInterface;
                    int i2 = i;
                    this.B8WBXPBCF2jGfUDZZU2zV5EYdqbUBu0lAZ0THCEqYyuE8VACR9dY7rDnwBIqh64T.B8WBXPBCF2jGfUDZZU2zV5EYdqbUBu0lAZ0THCEqYyuE8VACR9dY7rDnwBIqh64T(1);
                }
            };
            alertDialog.setButton(-1, this.vSp02fkBXgM8EI0gm0rKWXHQ6wdQINJBQuAtCR15YU8g4XNqVKV8r32SYxkQYxkq.getResources().getString(17039379), onClickListener);
            new DialogInterface.OnClickListener(this) {
                private /* synthetic */ MakeroidDataProtection B8WBXPBCF2jGfUDZZU2zV5EYdqbUBu0lAZ0THCEqYyuE8VACR9dY7rDnwBIqh64T;

                {
                    this.B8WBXPBCF2jGfUDZZU2zV5EYdqbUBu0lAZ0THCEqYyuE8VACR9dY7rDnwBIqh64T = r5;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    DialogInterface dialogInterface2 = dialogInterface;
                    int i2 = i;
                    this.B8WBXPBCF2jGfUDZZU2zV5EYdqbUBu0lAZ0THCEqYyuE8VACR9dY7rDnwBIqh64T.B8WBXPBCF2jGfUDZZU2zV5EYdqbUBu0lAZ0THCEqYyuE8VACR9dY7rDnwBIqh64T(2);
                }
            };
            alertDialog.setButton(-2, this.vSp02fkBXgM8EI0gm0rKWXHQ6wdQINJBQuAtCR15YU8g4XNqVKV8r32SYxkQYxkq.getResources().getString(17039369), onClickListener2);
            alertDialog.show();
        }
    }

    /* access modifiers changed from: private */
    public void B8WBXPBCF2jGfUDZZU2zV5EYdqbUBu0lAZ0THCEqYyuE8VACR9dY7rDnwBIqh64T(int i) {
        AdRequest.Builder builder;
        AdRequest.Builder builder2;
        AdRequest.Builder builder3;
        AdRequest.Builder builder4;
        int i2 = i;
        if (vwEpIRqEf6xdtwTR9dehwBO7JUhyLV6iEzEK2WqfPN10eUMQDPn3AUmqAFfsnr6R().equalsIgnoreCase(TYPE_AD_MOB_BANNER)) {
            if (this.B8WBXPBCF2jGfUDZZU2zV5EYdqbUBu0lAZ0THCEqYyuE8VACR9dY7rDnwBIqh64T == null) {
                int e = Log.e(this.LOG_TAG, "Please add your AdView in 'void setAdView(AdView adView);'");
            } else if (i2 == 1) {
                hR11jdqaRrvBRiBFd4KN6gI7d8MNQVP5Yc7fufDZjGGTeTxaualejjrhiR1Iz2xO(true);
                int i3 = Log.i(this.LOG_TAG, "Trying to load now a personalized AdMob Banner ad");
                AdView adView = this.B8WBXPBCF2jGfUDZZU2zV5EYdqbUBu0lAZ0THCEqYyuE8VACR9dY7rDnwBIqh64T;
                new AdRequest.Builder();
                adView.loadAd(builder4.build());
            } else {
                hR11jdqaRrvBRiBFd4KN6gI7d8MNQVP5Yc7fufDZjGGTeTxaualejjrhiR1Iz2xO(false);
                int i4 = Log.i(this.LOG_TAG, "Trying to load now a non-personalized AdMob Banner ad");
                AdView adView2 = this.B8WBXPBCF2jGfUDZZU2zV5EYdqbUBu0lAZ0THCEqYyuE8VACR9dY7rDnwBIqh64T;
                new AdRequest.Builder();
                adView2.loadAd(builder3.addNetworkExtrasBundle(AdMobAdapter.class, this.f283wq07duYRO6iFAgWM70EZOSvbCMKs1QznMRJKrct0XuHOBYqCk3XqOKtSBGIpDou).build());
            }
        } else if (vwEpIRqEf6xdtwTR9dehwBO7JUhyLV6iEzEK2WqfPN10eUMQDPn3AUmqAFfsnr6R().equalsIgnoreCase(TYPE_AD_MOB_INTERSTITIAL)) {
            if (this.f280B8WBXPBCF2jGfUDZZU2zV5EYdqbUBu0lAZ0THCEqYyuE8VACR9dY7rDnwBIqh64T == null) {
                int e2 = Log.e(this.LOG_TAG, "Please add your InterstitialAd in 'void setInterstitialAd(InterstitialAd interstitialAd);'");
            } else if (!this.ZBOPOXf20XZKrN6ycbQhEDPC2OsW2QCGfMHApJMYjAVGCpHVQNyA3eb1TXx8tY2I) {
                int e3 = Log.e(this.LOG_TAG, "Please add your 'void setInterstitialOptions(boolean targetForChildren, String targetGender, int targetAge);'");
            } else if (i2 == 1) {
                hR11jdqaRrvBRiBFd4KN6gI7d8MNQVP5Yc7fufDZjGGTeTxaualejjrhiR1Iz2xO(true);
                int i5 = Log.i(this.LOG_TAG, "Trying to load now a personalized AdMob Interstitial ad");
                if (this.kkTI9AxohjOECYVBpzZOuVO0b9llYVM2xqggkPHvpPoNGTREwN5YZmwC10Gk8X2Q > 0) {
                    zWdiPvy9THbs14kS37O202JH95jn5GzRAXQdLdM0hhw5e6hZSAshBMBb0bJkJXW5();
                } else {
                    J9GCddMpW5m7K6b7f8nFol5AuYTClyx20NTbEibimiSwx7sDFiwQjZjPs0Mw8DwU();
                }
            } else {
                hR11jdqaRrvBRiBFd4KN6gI7d8MNQVP5Yc7fufDZjGGTeTxaualejjrhiR1Iz2xO(false);
                int i6 = Log.i(this.LOG_TAG, "Trying to load now a non-personalized AdMob Interstitial ad");
                if (this.kkTI9AxohjOECYVBpzZOuVO0b9llYVM2xqggkPHvpPoNGTREwN5YZmwC10Gk8X2Q > 0) {
                    bVeTzqSexGvEaauwiYAVDIi0rEKwP38hsr4zIk14QJ70YrYaNw4t0FSa76teZ34b();
                } else {
                    KZERK4FJjgj00YJ12FkBt8g0XGe7fRlOujzm0QMQzA20gzGqez6qkZCId3aKJaes();
                }
            }
        } else if (vwEpIRqEf6xdtwTR9dehwBO7JUhyLV6iEzEK2WqfPN10eUMQDPn3AUmqAFfsnr6R().equalsIgnoreCase(TYPE_AD_MOB_REWARDED_VIDEO)) {
            if (this.f281B8WBXPBCF2jGfUDZZU2zV5EYdqbUBu0lAZ0THCEqYyuE8VACR9dY7rDnwBIqh64T == null) {
                int e4 = Log.e(this.LOG_TAG, "Please add your RewardedVideoAd in 'void setRewardedOptions(RewardedVideoAd rewardedVideoAd);'");
            } else if (!this.TDuNe2Upxoi7WX7QZc6R8eUnFPyyDFw3hP7z3w6U8jMxQwJRQM03zSa9HzWXRv1) {
                int e5 = Log.e(this.LOG_TAG, "Please add your 'void setRewardedOptions(String id);'");
            } else if (i2 == 1) {
                hR11jdqaRrvBRiBFd4KN6gI7d8MNQVP5Yc7fufDZjGGTeTxaualejjrhiR1Iz2xO(true);
                int i7 = Log.i(this.LOG_TAG, "Trying to load now a personalized AdMob Rewarded Video ad");
                RewardedVideoAd rewardedVideoAd = this.f281B8WBXPBCF2jGfUDZZU2zV5EYdqbUBu0lAZ0THCEqYyuE8VACR9dY7rDnwBIqh64T;
                String str = this.iydqlq85U6KFMIBI7LRgMfKfWOWXdlnJs0rL9QevzYsIGMKLioEecnL9YVjuTN9v;
                new AdRequest.Builder();
                rewardedVideoAd.loadAd(str, builder2.build());
            } else {
                hR11jdqaRrvBRiBFd4KN6gI7d8MNQVP5Yc7fufDZjGGTeTxaualejjrhiR1Iz2xO(false);
                int i8 = Log.i(this.LOG_TAG, "Trying to load now a non-personalized Rewarded Video ad");
                RewardedVideoAd rewardedVideoAd2 = this.f281B8WBXPBCF2jGfUDZZU2zV5EYdqbUBu0lAZ0THCEqYyuE8VACR9dY7rDnwBIqh64T;
                String str2 = this.iydqlq85U6KFMIBI7LRgMfKfWOWXdlnJs0rL9QevzYsIGMKLioEecnL9YVjuTN9v;
                new AdRequest.Builder();
                rewardedVideoAd2.loadAd(str2, builder.addNetworkExtrasBundle(AdMobAdapter.class, this.f283wq07duYRO6iFAgWM70EZOSvbCMKs1QznMRJKrct0XuHOBYqCk3XqOKtSBGIpDou).build());
            }
        } else if (vwEpIRqEf6xdtwTR9dehwBO7JUhyLV6iEzEK2WqfPN10eUMQDPn3AUmqAFfsnr6R().equalsIgnoreCase("TYPE_WAS_NOT_FOUND")) {
            int e6 = Log.e(this.LOG_TAG, "Make sure you have added a component type in 'void setComponentType(String type);'");
        }
    }

    private void hR11jdqaRrvBRiBFd4KN6gI7d8MNQVP5Yc7fufDZjGGTeTxaualejjrhiR1Iz2xO(boolean z) {
        boolean z2 = z;
        if (this.ik13O8j78hPb27XeipAJHUcJmdHxYMJFw4gYbTGvLKIOs7SX1F7x61gocQ17TlNc) {
            int i = Log.i(this.LOG_TAG, "I don't save setting now because development mode is on.");
            return;
        }
        SharedPreferences.Editor putBoolean = this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.putBoolean("Personalized", z2);
        SharedPreferences.Editor putBoolean2 = this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.putBoolean("AdsFree", false);
        SharedPreferences.Editor putBoolean3 = this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.putBoolean("FirstTime", false);
        boolean commit = this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.commit();
        if (this.f282hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME != null) {
            this.f282hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.result(false, z2);
        }
        this.yHAbLPerXNK4pCwn5nqbt3OeUjDvQdxh29RmVa0moB4dUtgatbeaGoP5jClPUWFb = false;
        this.Sj3UMCQcT7f46E8U4TVavenawPElr174psURarVHJJBTqMXe22hIekct3fzxe7Vm = z2;
        int i2 = Log.i(this.LOG_TAG, "SaveOptionsHelper was running and options are now saved.");
    }

    private static String vSp02fkBXgM8EI0gm0rKWXHQ6wdQINJBQuAtCR15YU8g4XNqVKV8r32SYxkQYxkq(String str, String str2) {
        String str3 = str;
        String str4 = str2;
        if (str3 == null || str3.isEmpty()) {
            return str4;
        }
        return str3;
    }

    private void zWdiPvy9THbs14kS37O202JH95jn5GzRAXQdLdM0hhw5e6hZSAshBMBb0bJkJXW5() {
        AdRequest.Builder builder;
        new AdRequest.Builder();
        AdRequest.Builder gender = builder.tagForChildDirectedTreatment(this.wfWoJD9s05zGciiq11jj7TXqW1AmJIE9BV68DWBBkLZSv9NayRoTG3XJb9WJMlyD).setGender(this.LYXVmrSApJtjkX58iaWYcT93zXSX0GhbrHTAKbm3TBRJ5avsjGCN1sJz61Za2zkA);
        this.f280B8WBXPBCF2jGfUDZZU2zV5EYdqbUBu0lAZ0THCEqYyuE8VACR9dY7rDnwBIqh64T.loadAd(gender.setBirthday(hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME(this.kkTI9AxohjOECYVBpzZOuVO0b9llYVM2xqggkPHvpPoNGTREwN5YZmwC10Gk8X2Q)).build());
    }

    private void bVeTzqSexGvEaauwiYAVDIi0rEKwP38hsr4zIk14QJ70YrYaNw4t0FSa76teZ34b() {
        AdRequest.Builder builder;
        new AdRequest.Builder();
        AdRequest.Builder gender = builder.tagForChildDirectedTreatment(this.wfWoJD9s05zGciiq11jj7TXqW1AmJIE9BV68DWBBkLZSv9NayRoTG3XJb9WJMlyD).setGender(this.LYXVmrSApJtjkX58iaWYcT93zXSX0GhbrHTAKbm3TBRJ5avsjGCN1sJz61Za2zkA);
        this.f280B8WBXPBCF2jGfUDZZU2zV5EYdqbUBu0lAZ0THCEqYyuE8VACR9dY7rDnwBIqh64T.loadAd(gender.setBirthday(hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME(this.kkTI9AxohjOECYVBpzZOuVO0b9llYVM2xqggkPHvpPoNGTREwN5YZmwC10Gk8X2Q)).addNetworkExtrasBundle(AdMobAdapter.class, this.f283wq07duYRO6iFAgWM70EZOSvbCMKs1QznMRJKrct0XuHOBYqCk3XqOKtSBGIpDou).build());
    }

    private void J9GCddMpW5m7K6b7f8nFol5AuYTClyx20NTbEibimiSwx7sDFiwQjZjPs0Mw8DwU() {
        AdRequest.Builder builder;
        new AdRequest.Builder();
        this.f280B8WBXPBCF2jGfUDZZU2zV5EYdqbUBu0lAZ0THCEqYyuE8VACR9dY7rDnwBIqh64T.loadAd(builder.tagForChildDirectedTreatment(this.wfWoJD9s05zGciiq11jj7TXqW1AmJIE9BV68DWBBkLZSv9NayRoTG3XJb9WJMlyD).setGender(this.LYXVmrSApJtjkX58iaWYcT93zXSX0GhbrHTAKbm3TBRJ5avsjGCN1sJz61Za2zkA).build());
    }

    private void KZERK4FJjgj00YJ12FkBt8g0XGe7fRlOujzm0QMQzA20gzGqez6qkZCId3aKJaes() {
        AdRequest.Builder builder;
        new AdRequest.Builder();
        this.f280B8WBXPBCF2jGfUDZZU2zV5EYdqbUBu0lAZ0THCEqYyuE8VACR9dY7rDnwBIqh64T.loadAd(builder.tagForChildDirectedTreatment(this.wfWoJD9s05zGciiq11jj7TXqW1AmJIE9BV68DWBBkLZSv9NayRoTG3XJb9WJMlyD).setGender(this.LYXVmrSApJtjkX58iaWYcT93zXSX0GhbrHTAKbm3TBRJ5avsjGCN1sJz61Za2zkA).addNetworkExtrasBundle(AdMobAdapter.class, this.f283wq07duYRO6iFAgWM70EZOSvbCMKs1QznMRJKrct0XuHOBYqCk3XqOKtSBGIpDou).build());
    }

    private Date hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME(int i) {
        Date date;
        StringBuilder sb;
        int i2 = i;
        Calendar instance = Calendar.getInstance();
        instance.add(1, -i2);
        new Date(instance.getTimeInMillis());
        Date date2 = date;
        String str = this.LOG_TAG;
        new StringBuilder("The calculated date based on age of ");
        int d = Log.d(str, sb.append(i2).append(" is ").append(date2).toString());
        return date2;
    }

    public void setOnConsentListener(OnConsentListener onConsentListener) {
        OnConsentListener onConsentListener2 = onConsentListener;
        this.f282hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME = onConsentListener2;
    }
}
