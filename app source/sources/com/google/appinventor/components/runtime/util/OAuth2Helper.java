package com.google.appinventor.components.runtime.util;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.accounts.AccountManagerCallback;
import android.accounts.AccountManagerFuture;
import android.accounts.AuthenticatorException;
import android.accounts.OperationCanceledException;
import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.googleapis.extensions.android2.auth.GoogleAccountManager;
import java.io.IOException;

public class OAuth2Helper {
    public static final String PREF_ACCOUNT_NAME = "accountName";
    public static final String PREF_AUTH_TOKEN = "authToken";
    public static final String TAG = "OAuthHelper";
    private static String YPNDRC6guNtR9Y1y2H2jw2eNOGhWZENW1YRifRdfZVF6tZ3Hhm9vVsLmqobDf9o1 = "Error during OAuth";

    public OAuth2Helper() {
    }

    public String getRefreshedAuthToken(Activity activity, String str) {
        GoogleCredential googleCredential;
        GoogleAccountManager googleAccountManager;
        AccountManagerFuture<Bundle> authTokenByFeatures;
        Throwable th;
        Activity activity2 = activity;
        String str2 = str;
        int i = Log.i(TAG, "getRefreshedAuthToken()");
        if (Looper.getMainLooper().getThread().equals(Thread.currentThread())) {
            Throwable th2 = th;
            new IllegalArgumentException("Can't get authtoken from UI thread");
            throw th2;
        }
        SharedPreferences preferences = activity2.getPreferences(0);
        SharedPreferences sharedPreferences = preferences;
        String string = preferences.getString(PREF_ACCOUNT_NAME, (String) null);
        String string2 = sharedPreferences.getString(PREF_AUTH_TOKEN, (String) null);
        new GoogleCredential();
        GoogleCredential googleCredential2 = googleCredential;
        GoogleCredential accessToken = googleCredential2.setAccessToken(string2);
        GoogleCredential googleCredential3 = googleCredential2;
        String str3 = str2;
        GoogleCredential googleCredential4 = googleCredential3;
        Activity activity3 = activity2;
        new GoogleAccountManager(activity3);
        GoogleAccountManager googleAccountManager2 = googleAccountManager;
        GoogleAccountManager googleAccountManager3 = googleAccountManager2;
        googleAccountManager2.invalidateAuthToken(googleCredential4.getAccessToken());
        AccountManager.get(activity3).invalidateAuthToken(str3, (String) null);
        Account accountByName = googleAccountManager3.getAccountByName(string);
        Account account = accountByName;
        if (accountByName != null) {
            int i2 = Log.i(TAG, "Getting token by account");
            authTokenByFeatures = googleAccountManager3.getAccountManager().getAuthToken(account, str3, true, (AccountManagerCallback) null, (Handler) null);
        } else {
            int i3 = Log.i(TAG, "Getting token by features, possibly prompting user to select an account");
            authTokenByFeatures = googleAccountManager3.getAccountManager().getAuthTokenByFeatures("com.google", str3, (String[]) null, activity3, (Bundle) null, (Bundle) null, (AccountManagerCallback) null, (Handler) null);
        }
        try {
            Bundle result = authTokenByFeatures.getResult();
            string2 = result.get("authtoken").toString();
            String string3 = result.getString("authAccount");
            int i4 = Log.i(TAG, "Persisting credentials, acct =".concat(String.valueOf(string3)));
            SharedPreferences.Editor edit = sharedPreferences.edit();
            SharedPreferences.Editor editor = edit;
            SharedPreferences.Editor putString = edit.putString(PREF_ACCOUNT_NAME, string3);
            SharedPreferences.Editor putString2 = editor.putString(PREF_AUTH_TOKEN, string2);
            boolean commit = editor.commit();
        } catch (OperationCanceledException e) {
            e.printStackTrace();
            resetAccountCredential(activity2);
            YPNDRC6guNtR9Y1y2H2jw2eNOGhWZENW1YRifRdfZVF6tZ3Hhm9vVsLmqobDf9o1 = "Error: operation cancelled";
        } catch (AuthenticatorException e2) {
            e2.printStackTrace();
            YPNDRC6guNtR9Y1y2H2jw2eNOGhWZENW1YRifRdfZVF6tZ3Hhm9vVsLmqobDf9o1 = "Error: Authenticator error";
        } catch (IOException e3) {
            e3.printStackTrace();
            YPNDRC6guNtR9Y1y2H2jw2eNOGhWZENW1YRifRdfZVF6tZ3Hhm9vVsLmqobDf9o1 = "Error: I/O error";
        }
        return string2;
    }

    public static void resetAccountCredential(Activity activity) {
        int i = Log.i(TAG, "Reset credentials");
        SharedPreferences.Editor edit = activity.getPreferences(0).edit();
        SharedPreferences.Editor editor = edit;
        SharedPreferences.Editor remove = edit.remove(PREF_AUTH_TOKEN);
        SharedPreferences.Editor remove2 = editor.remove(PREF_ACCOUNT_NAME);
        boolean commit = editor.commit();
    }

    public static String getErrorMessage() {
        StringBuilder sb;
        new StringBuilder("getErrorMessage = ");
        int i = Log.i(TAG, sb.append(YPNDRC6guNtR9Y1y2H2jw2eNOGhWZENW1YRifRdfZVF6tZ3Hhm9vVsLmqobDf9o1).toString());
        return YPNDRC6guNtR9Y1y2H2jw2eNOGhWZENW1YRifRdfZVF6tZ3Hhm9vVsLmqobDf9o1;
    }
}
