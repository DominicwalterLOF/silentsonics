package com.google.appinventor.components.runtime.util;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.ump.ConsentDebugSettings;
import com.google.android.ump.ConsentForm;
import com.google.android.ump.ConsentInformation;
import com.google.android.ump.ConsentRequestParameters;
import com.google.android.ump.FormError;
import com.google.android.ump.UserMessagingPlatform;
import com.google.appinventor.components.runtime.Form;

public class KodularAdManager {
    private final SharedPreferences B8WBXPBCF2jGfUDZZU2zV5EYdqbUBu0lAZ0THCEqYyuE8VACR9dY7rDnwBIqh64T;
    private String LOG_TAG = "KodularAdManager";
    private final Context context;

    public KodularAdManager(Context context2, Form form) {
        StringBuilder sb;
        a aVar;
        Form form2 = form;
        this.context = context2;
        this.B8WBXPBCF2jGfUDZZU2zV5EYdqbUBu0lAZ0THCEqYyuE8VACR9dY7rDnwBIqh64T = this.context.getSharedPreferences(getKodularPackageName(), 0);
        SharedPreferences sharedPreferences = this.B8WBXPBCF2jGfUDZZU2zV5EYdqbUBu0lAZ0THCEqYyuE8VACR9dY7rDnwBIqh64T;
        new StringBuilder();
        if (!sharedPreferences.contains(sb.append(getKodularPackageName()).append(".kadm").toString())) {
            new a((byte) 0);
            AsyncTask execute = aVar.execute(new Form[]{form2});
        }
    }

    public String getAdUnit() {
        StringBuilder sb;
        SharedPreferences sharedPreferences = this.B8WBXPBCF2jGfUDZZU2zV5EYdqbUBu0lAZ0THCEqYyuE8VACR9dY7rDnwBIqh64T;
        new StringBuilder();
        String string = sharedPreferences.getString(sb.append(getKodularPackageName()).append(".kadm").toString(), (String) null);
        int i = Log.i(this.LOG_TAG, "KAdM Ad Unit: ".concat(String.valueOf(string)));
        return string;
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

    static class a extends AsyncTask<Form, Void, String> {
        private String LOG_TAG;
        private Form hR11jdqaRrvBRiBFd4KN6gI7d8MNQVP5Yc7fufDZjGGTeTxaualejjrhiR1Iz2xO;

        private a() {
            this.LOG_TAG = "KodularAdManagerTask";
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        /* synthetic */ a(byte b) {
            this();
            byte b2 = b;
        }

        /* access modifiers changed from: protected */
        public final /* synthetic */ void onPostExecute(Object obj) {
            StringBuilder sb;
            String str = (String) obj;
            SharedPreferences sharedPreferences = this.hR11jdqaRrvBRiBFd4KN6gI7d8MNQVP5Yc7fufDZjGGTeTxaualejjrhiR1Iz2xO.$context().getSharedPreferences(this.hR11jdqaRrvBRiBFd4KN6gI7d8MNQVP5Yc7fufDZjGGTeTxaualejjrhiR1Iz2xO.getKodularPackageName(), 0);
            if (str != null && sharedPreferences != null) {
                SharedPreferences.Editor edit = sharedPreferences.edit();
                new StringBuilder();
                edit.putString(sb.append(this.hR11jdqaRrvBRiBFd4KN6gI7d8MNQVP5Yc7fufDZjGGTeTxaualejjrhiR1Iz2xO.getKodularPackageName()).append(".kadm").toString(), str).apply();
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME */
        public String doInBackground(Form... formArr) {
            try {
                this.hR11jdqaRrvBRiBFd4KN6gI7d8MNQVP5Yc7fufDZjGGTeTxaualejjrhiR1Iz2xO = formArr[0];
                Bundle bundle = this.hR11jdqaRrvBRiBFd4KN6gI7d8MNQVP5Yc7fufDZjGGTeTxaualejjrhiR1Iz2xO.$context().getPackageManager().getApplicationInfo(this.hR11jdqaRrvBRiBFd4KN6gI7d8MNQVP5Yc7fufDZjGGTeTxaualejjrhiR1Iz2xO.getPackageName(), 128).metaData;
                Bundle bundle2 = bundle;
                if (bundle == null) {
                    int e = Log.e(this.LOG_TAG, "No bundle!");
                    return null;
                }
                String string = bundle2.getString("KADM_CN_ADUNIT");
                String str = string;
                if (string != null) {
                    return str;
                }
                int e2 = Log.e(this.LOG_TAG, "No AD_UNIT!");
                return null;
            } catch (PackageManager.NameNotFoundException e3) {
                int e4 = Log.e(this.LOG_TAG, "Could not find PackageManager");
                return null;
            }
        }
    }

    public static class Consent {
        private static boolean PMWpqVMsyfTUgqkfqh3FKX4Q3IYlcybzKrBGEl7qtzs6HNVssJ63V430Ige89pyP;
        /* access modifiers changed from: private */
        public static ConsentInformation hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME;

        public Consent() {
        }

        static /* synthetic */ void hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME(Activity activity) {
            UserMessagingPlatform.OnConsentFormLoadSuccessListener onConsentFormLoadSuccessListener;
            UserMessagingPlatform.OnConsentFormLoadFailureListener onConsentFormLoadFailureListener;
            Activity activity2 = activity;
            final Activity activity3 = activity2;
            new UserMessagingPlatform.OnConsentFormLoadSuccessListener() {
                public final void onConsentFormLoadSuccess(ConsentForm consentForm) {
                    ConsentForm.OnConsentFormDismissedListener onConsentFormDismissedListener;
                    ConsentForm consentForm2 = consentForm;
                    if (Consent.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.getConsentStatus() == 2) {
                        new ConsentForm.OnConsentFormDismissedListener(this) {
                            private /* synthetic */ AnonymousClass3 hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME;

                            {
                                this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME = r5;
                            }

                            public final void onConsentFormDismissed(FormError formError) {
                                FormError formError2 = formError;
                                Consent.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME(activity3);
                            }
                        };
                        consentForm2.show(activity3, onConsentFormDismissedListener);
                    }
                }
            };
            new UserMessagingPlatform.OnConsentFormLoadFailureListener() {
                public final void onConsentFormLoadFailure(FormError formError) {
                }
            };
            UserMessagingPlatform.loadConsentForm(activity2, onConsentFormLoadSuccessListener, onConsentFormLoadFailureListener);
        }

        public static void request(Activity activity, Context context, boolean z) {
            ConsentRequestParameters.Builder builder;
            ConsentInformation.OnConsentInfoUpdateSuccessListener onConsentInfoUpdateSuccessListener;
            ConsentInformation.OnConsentInfoUpdateFailureListener onConsentInfoUpdateFailureListener;
            ConsentDebugSettings.Builder builder2;
            Activity activity2 = activity;
            Context context2 = context;
            new ConsentRequestParameters.Builder();
            ConsentRequestParameters.Builder tagForUnderAgeOfConsent = builder.setTagForUnderAgeOfConsent(false);
            hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME = UserMessagingPlatform.getConsentInformation(activity2);
            if (z) {
                new ConsentDebugSettings.Builder(activity2);
                ConsentRequestParameters.Builder consentDebugSettings = tagForUnderAgeOfConsent.setConsentDebugSettings(builder2.setDebugGeography(1).addTestDeviceHashedId(KodularAdsUtil.guessSelfDeviceId(context2)).build());
                if (!PMWpqVMsyfTUgqkfqh3FKX4Q3IYlcybzKrBGEl7qtzs6HNVssJ63V430Ige89pyP) {
                    hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.reset();
                    PMWpqVMsyfTUgqkfqh3FKX4Q3IYlcybzKrBGEl7qtzs6HNVssJ63V430Ige89pyP = true;
                }
            }
            final Activity activity3 = activity2;
            final Context context3 = context2;
            new ConsentInformation.OnConsentInfoUpdateSuccessListener() {
                public final void onConsentInfoUpdateSuccess() {
                    OnInitializationCompleteListener onInitializationCompleteListener;
                    if (Consent.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.isConsentFormAvailable()) {
                        Consent.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME(activity3);
                    }
                    new OnInitializationCompleteListener(this) {
                        private /* synthetic */ AnonymousClass1 hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME;

                        {
                            this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME = r5;
                        }

                        public final void onInitializationComplete(InitializationStatus initializationStatus) {
                        }
                    };
                    MobileAds.initialize(context3, onInitializationCompleteListener);
                }
            };
            new ConsentInformation.OnConsentInfoUpdateFailureListener() {
                public final void onConsentInfoUpdateFailure(FormError formError) {
                }
            };
            hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.requestConsentInfoUpdate(activity2, tagForUnderAgeOfConsent.build(), onConsentInfoUpdateSuccessListener, onConsentInfoUpdateFailureListener);
        }

        public static void destroy() {
            hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME = null;
            PMWpqVMsyfTUgqkfqh3FKX4Q3IYlcybzKrBGEl7qtzs6HNVssJ63V430Ige89pyP = false;
        }
    }
}
