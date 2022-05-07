package com.google.appinventor.components.runtime.util;

import android.content.Context;
import android.content.pm.PackageManager;
import android.util.Log;
import com.google.appinventor.components.runtime.Component;
import com.google.appinventor.components.runtime.Form;

public class KodularAdsCommission {
    private String LOG_TAG = "KodularAdsCommission";
    private final Context context;
    private final KodularBilling hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME;

    public KodularAdsCommission(Context context2, Form form) {
        KodularBilling kodularBilling;
        Context context3 = context2;
        this.context = context3;
        new KodularBilling(context3, form);
        this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME = kodularBilling;
    }

    public float getCommision(String str, String str2) {
        boolean z;
        float f;
        String str3 = str;
        String str4 = str2;
        if (this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.hasCommissionRemoved()) {
            return 0.0f;
        }
        float f2 = 0.035f;
        if (this.context.getPackageName().equals(getKodularPackageName()) || this.context.getPackageName().equals(getKodularPackageName().replace("io.kodular", "com.appybuilder")) || this.context.getPackageName().equals(getKodularPackageName().replace("io.kodular", "com.thunkable"))) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            f2 = 0.085f;
        }
        boolean z2 = true;
        switch (str3.hashCode()) {
            case -1414265340:
                if (str3.equals("amazon")) {
                    z2 = true;
                    break;
                }
                break;
            case -1249910051:
                if (str3.equals("adcolony")) {
                    z2 = false;
                    break;
                }
                break;
            case 92668925:
                if (str3.equals("admob")) {
                    z2 = true;
                    break;
                }
                break;
            case 111433589:
                if (str3.equals("unity")) {
                    z2 = true;
                    break;
                }
                break;
            case 497130182:
                if (str3.equals("facebook")) {
                    z2 = true;
                    break;
                }
                break;
            case 1179703863:
                if (str3.equals("applovin")) {
                    z2 = true;
                    break;
                }
                break;
            case 1316799103:
                if (str3.equals(Component.COMMISSION_BANNER_ADS_NETWORK_DEFAULT)) {
                    z2 = true;
                    break;
                }
                break;
            case 1560923121:
                if (str3.equals("leadbolt")) {
                    z2 = true;
                    break;
                }
                break;
        }
        switch (z2) {
            case false:
            case true:
                String str5 = str4;
                boolean z3 = true;
                switch (str5.hashCode()) {
                    case 604727084:
                        if (str5.equals("interstitial")) {
                            z3 = false;
                            break;
                        }
                        break;
                }
                switch (z3) {
                    case false:
                        f = f2 + 0.08f;
                        break;
                    default:
                        f = f2 + 0.15f;
                        break;
                }
            case true:
                String str6 = str4;
                boolean z4 = true;
                switch (str6.hashCode()) {
                    case -1396342996:
                        if (str6.equals("banner")) {
                            z4 = false;
                            break;
                        }
                        break;
                    case 112202875:
                        if (str6.equals("video")) {
                            z4 = true;
                            break;
                        }
                        break;
                    case 604727084:
                        if (str6.equals("interstitial")) {
                            z4 = true;
                            break;
                        }
                        break;
                }
                switch (z4) {
                    case false:
                        f = f2 + 0.07f;
                        break;
                    case true:
                        f = f2 + 0.1f;
                        break;
                    case true:
                        f = f2 + 0.13f;
                        break;
                    default:
                        f = f2 + 0.15f;
                        break;
                }
            case true:
                String str7 = str4;
                boolean z5 = true;
                switch (str7.hashCode()) {
                    case -1396342996:
                        if (str7.equals("banner")) {
                            z5 = false;
                            break;
                        }
                        break;
                    case 604727084:
                        if (str7.equals("interstitial")) {
                            z5 = true;
                            break;
                        }
                        break;
                }
                switch (z5) {
                    case false:
                        f = f2 + 0.06f;
                        break;
                    case true:
                        f = f2 + 0.09f;
                        break;
                    default:
                        f = f2 + 0.15f;
                        break;
                }
            case true:
                String str8 = str4;
                boolean z6 = true;
                switch (str8.hashCode()) {
                    case -1396342996:
                        if (str8.equals("banner")) {
                            z6 = false;
                            break;
                        }
                        break;
                    case 112202875:
                        if (str8.equals("video")) {
                            z6 = true;
                            break;
                        }
                        break;
                    case 604727084:
                        if (str8.equals("interstitial")) {
                            z6 = true;
                            break;
                        }
                        break;
                }
                switch (z6) {
                    case false:
                        f = f2 + 0.06f;
                        break;
                    case true:
                        f = f2 + 0.09f;
                        break;
                    case true:
                        f = f2 + 0.12f;
                        break;
                    default:
                        f = f2 + 0.15f;
                        break;
                }
            case true:
                String str9 = str4;
                boolean z7 = true;
                switch (str9.hashCode()) {
                    case 112202875:
                        if (str9.equals("video")) {
                            z7 = true;
                            break;
                        }
                        break;
                    case 604727084:
                        if (str9.equals("interstitial")) {
                            z7 = false;
                            break;
                        }
                        break;
                }
                switch (z7) {
                    case false:
                        f = f2 + 0.09f;
                        break;
                    case true:
                        f = f2 + 0.12f;
                        break;
                    default:
                        f = f2 + 0.15f;
                        break;
                }
            case true:
            case true:
                String str10 = str4;
                boolean z8 = true;
                switch (str10.hashCode()) {
                    case -1396342996:
                        if (str10.equals("banner")) {
                            z8 = false;
                            break;
                        }
                        break;
                    case 604727084:
                        if (str10.equals("interstitial")) {
                            z8 = true;
                            break;
                        }
                        break;
                }
                switch (z8) {
                    case false:
                        f = f2 + 0.05f;
                        break;
                    case true:
                        f = f2 + 0.08f;
                        break;
                    default:
                        f = f2 + 0.15f;
                        break;
                }
            default:
                int hashCode = str4.hashCode();
                f = f2 + 0.2f;
                break;
        }
        int i = Log.i(this.LOG_TAG, "Final Commission: ".concat(String.valueOf(f)));
        return f;
    }

    private String getKodularPackageName() {
        String packageName = this.context.getPackageName();
        try {
            PackageManager packageManager = this.context.getPackageManager();
            return packageManager.resolveActivity(packageManager.getLaunchIntentForPackage(packageName), 65536).activityInfo.name.replaceAll(".Screen1", "");
        } catch (Exception e) {
            return packageName;
        }
    }
}
