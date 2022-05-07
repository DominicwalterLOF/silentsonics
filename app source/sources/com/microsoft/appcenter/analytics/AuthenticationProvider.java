package com.microsoft.appcenter.analytics;

import com.microsoft.appcenter.Constants;
import com.microsoft.appcenter.utils.AppCenterLog;
import com.microsoft.appcenter.utils.HashUtils;
import com.microsoft.appcenter.utils.TicketCache;
import java.util.Date;

public class AuthenticationProvider {
    private static final long REFRESH_THRESHOLD = 600000;
    private AuthenticationCallback mCallback;
    private Date mExpiryDate;
    private final String mTicketKey;
    private final String mTicketKeyHash;
    private final TokenProvider mTokenProvider;
    private final Type mType;

    public interface AuthenticationCallback {
        void onAuthenticationResult(String str, Date date);
    }

    public interface TokenProvider {
        void acquireToken(String str, AuthenticationCallback authenticationCallback);
    }

    public AuthenticationProvider(Type type, String str, TokenProvider tokenProvider) {
        String ticketKey = str;
        TokenProvider tokenProvider2 = tokenProvider;
        this.mType = type;
        this.mTicketKey = ticketKey;
        this.mTicketKeyHash = ticketKey == null ? null : HashUtils.sha256(ticketKey);
        this.mTokenProvider = tokenProvider2;
    }

    /* access modifiers changed from: package-private */
    public Type getType() {
        return this.mType;
    }

    /* access modifiers changed from: package-private */
    public String getTicketKey() {
        return this.mTicketKey;
    }

    /* access modifiers changed from: package-private */
    public String getTicketKeyHash() {
        return this.mTicketKeyHash;
    }

    /* access modifiers changed from: package-private */
    public TokenProvider getTokenProvider() {
        return this.mTokenProvider;
    }

    /* access modifiers changed from: package-private */
    public synchronized void acquireTokenAsync() {
        StringBuilder sb;
        AuthenticationCallback authenticationCallback;
        synchronized (this) {
            if (this.mCallback == null) {
                new StringBuilder();
                AppCenterLog.debug(Analytics.LOG_TAG, sb.append("Calling token provider=").append(this.mType).append(" callback.").toString());
                new AuthenticationCallback(this) {
                    final /* synthetic */ AuthenticationProvider this$0;

                    {
                        this.this$0 = this$0;
                    }

                    public void onAuthenticationResult(String token, Date expiryDate) {
                        this.this$0.handleTokenUpdate(token, expiryDate, this);
                    }
                };
                this.mCallback = authenticationCallback;
                this.mTokenProvider.acquireToken(this.mTicketKey, this.mCallback);
            }
        }
    }

    /* access modifiers changed from: private */
    public synchronized void handleTokenUpdate(String str, Date date, AuthenticationCallback authenticationCallback) {
        StringBuilder sb;
        StringBuilder sb2;
        StringBuilder sb3;
        StringBuilder sb4;
        StringBuilder sb5;
        String token = str;
        Date expiryDate = date;
        AuthenticationCallback callback = authenticationCallback;
        synchronized (this) {
            if (this.mCallback != callback) {
                new StringBuilder();
                AppCenterLog.debug(Analytics.LOG_TAG, sb5.append("Ignore duplicate authentication callback calls, provider=").append(this.mType).toString());
            } else {
                this.mCallback = null;
                new StringBuilder();
                AppCenterLog.debug(Analytics.LOG_TAG, sb.append("Got result back from token provider=").append(this.mType).toString());
                if (token == null) {
                    new StringBuilder();
                    AppCenterLog.error(Analytics.LOG_TAG, sb4.append("Authentication failed for ticketKey=").append(this.mTicketKey).toString());
                } else if (expiryDate == null) {
                    new StringBuilder();
                    AppCenterLog.error(Analytics.LOG_TAG, sb3.append("No expiry date provided for ticketKey=").append(this.mTicketKey).toString());
                } else {
                    String str2 = this.mTicketKeyHash;
                    new StringBuilder();
                    TicketCache.putTicket(str2, sb2.append(this.mType.mTokenPrefix).append(token).toString());
                    this.mExpiryDate = expiryDate;
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public synchronized void checkTokenExpiry() {
        synchronized (this) {
            if (this.mExpiryDate != null && this.mExpiryDate.getTime() <= System.currentTimeMillis() + REFRESH_THRESHOLD) {
                acquireTokenAsync();
            }
        }
    }

    public enum Type {
        ;
        
        /* access modifiers changed from: private */
        public final String mTokenPrefix;

        private Type(String tokenPrefix) {
            StringBuilder sb;
            String str = r9;
            int i = r10;
            new StringBuilder();
            this.mTokenPrefix = sb.append(tokenPrefix).append(Constants.COMMON_SCHEMA_PREFIX_SEPARATOR).toString();
        }
    }
}
