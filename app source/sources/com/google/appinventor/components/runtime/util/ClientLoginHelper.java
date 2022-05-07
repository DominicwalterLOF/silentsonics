package com.google.appinventor.components.runtime.util;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.accounts.AccountManagerCallback;
import android.accounts.AccountManagerFuture;
import android.accounts.AuthenticatorException;
import android.accounts.OperationCanceledException;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import java.io.IOException;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.DefaultHttpClient;

public class ClientLoginHelper implements IClientLoginHelper {
    private AccountChooser B8WBXPBCF2jGfUDZZU2zV5EYdqbUBu0lAZ0THCEqYyuE8VACR9dY7rDnwBIqh64T;
    private Activity activity;
    private String authToken;
    private String h8Png9oaVDfYGvgWdHcn1DMBnn2tbT5MRZoUvXvvhLrY5O6ybby2QmTOJ6PZJucW;
    private AccountManager hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME;

    /* renamed from: hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME  reason: collision with other field name */
    private HttpClient f270hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME;
    private boolean initialized = false;

    public ClientLoginHelper(Activity activity2, String str, String str2, HttpClient httpClient) {
        HttpClient httpClient2;
        AccountChooser accountChooser;
        HttpClient httpClient3;
        Activity activity3 = activity2;
        String str3 = str;
        String str4 = str2;
        HttpClient httpClient4 = httpClient;
        this.h8Png9oaVDfYGvgWdHcn1DMBnn2tbT5MRZoUvXvvhLrY5O6ybby2QmTOJ6PZJucW = str3;
        if (httpClient4 == null) {
            httpClient2 = httpClient3;
            new DefaultHttpClient();
        } else {
            httpClient2 = httpClient4;
        }
        this.f270hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME = httpClient2;
        this.activity = activity3;
        this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME = AccountManager.get(activity3);
        new AccountChooser(activity3, str3, str4, str3);
        this.B8WBXPBCF2jGfUDZZU2zV5EYdqbUBu0lAZ0THCEqYyuE8VACR9dY7rDnwBIqh64T = accountChooser;
    }

    public HttpResponse execute(HttpUriRequest httpUriRequest) throws ClientProtocolException, IOException {
        StringBuilder sb;
        StringBuilder sb2;
        Throwable th;
        HttpUriRequest httpUriRequest2 = httpUriRequest;
        if (!this.initialized) {
            int i = Log.i("ClientLoginHelper", "initializing");
            if (Looper.getMainLooper().getThread().equals(Thread.currentThread())) {
                Throwable th2 = th;
                new IllegalArgumentException("Can't initialize login helper from UI thread");
                throw th2;
            }
            this.authToken = getAuthToken();
            this.initialized = true;
        }
        hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME(httpUriRequest2, this.authToken);
        HttpResponse execute = this.f270hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.execute(httpUriRequest2);
        HttpResponse httpResponse = execute;
        if (execute.getStatusLine().getStatusCode() == 401) {
            new StringBuilder("Invalid token: ");
            int i2 = Log.i("ClientLoginHelper", sb.append(this.authToken).toString());
            this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.invalidateAuthToken("com.google", this.authToken);
            this.authToken = getAuthToken();
            hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME(httpUriRequest2);
            hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME(httpUriRequest2, this.authToken);
            new StringBuilder("new token: ");
            int i3 = Log.i("ClientLoginHelper", sb2.append(this.authToken).toString());
            httpResponse = this.f270hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.execute(httpUriRequest2);
        }
        return httpResponse;
    }

    public void forgetAccountName() {
        this.B8WBXPBCF2jGfUDZZU2zV5EYdqbUBu0lAZ0THCEqYyuE8VACR9dY7rDnwBIqh64T.forgetAccountName();
    }

    private static void hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME(HttpUriRequest httpUriRequest, String str) {
        HttpUriRequest httpUriRequest2 = httpUriRequest;
        String str2 = str;
        if (str2 != null) {
            int i = Log.i("ClientLoginHelper", "adding auth token token: ".concat(String.valueOf(str2)));
            httpUriRequest2.addHeader("Authorization", "GoogleLogin auth=".concat(String.valueOf(str2)));
        }
    }

    private static void hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME(HttpUriRequest httpUriRequest) {
        HttpUriRequest httpUriRequest2 = httpUriRequest;
        Header[] allHeaders = httpUriRequest2.getAllHeaders();
        Header[] headerArr = allHeaders;
        int length = allHeaders.length;
        for (int i = 0; i < length; i++) {
            Header header = headerArr[i];
            Header header2 = header;
            if (header.getName().equalsIgnoreCase("Authorization") && header2.getValue().startsWith("GoogleLogin auth=")) {
                int i2 = Log.i("ClientLoginHelper", "Removing header:".concat(String.valueOf(header2)));
                httpUriRequest2.removeHeader(header2);
            }
        }
    }

    public String getAuthToken() throws ClientProtocolException {
        Throwable th;
        Account findAccount = this.B8WBXPBCF2jGfUDZZU2zV5EYdqbUBu0lAZ0THCEqYyuE8VACR9dY7rDnwBIqh64T.findAccount();
        Account account = findAccount;
        if (findAccount != null) {
            AccountManagerFuture<Bundle> authToken2 = this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.getAuthToken(account, this.h8Png9oaVDfYGvgWdHcn1DMBnn2tbT5MRZoUvXvvhLrY5O6ybby2QmTOJ6PZJucW, (Bundle) null, this.activity, (AccountManagerCallback) null, (Handler) null);
            int i = Log.i("ClientLoginHelper", "Have account, auth token: ".concat(String.valueOf(authToken2)));
            try {
                return authToken2.getResult().getString("authtoken");
            } catch (AuthenticatorException e) {
                e.printStackTrace();
            } catch (IOException e2) {
                e2.printStackTrace();
            } catch (OperationCanceledException e3) {
                e3.printStackTrace();
            }
        }
        Throwable th2 = th;
        new ClientProtocolException("Can't get valid authentication token");
        throw th2;
    }
}
