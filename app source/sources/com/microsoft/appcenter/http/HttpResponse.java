package com.microsoft.appcenter.http;

import android.support.annotation.NonNull;
import java.util.Map;

public class HttpResponse {
    private final Map<String, String> headers;
    private final String payload;
    private final int statusCode;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public HttpResponse(int status) {
        this(status, "");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public HttpResponse(int r10, @android.support.annotation.NonNull java.lang.String r11) {
        /*
            r9 = this;
            r0 = r9
            r1 = r10
            r2 = r11
            r3 = r0
            r4 = r1
            r5 = r2
            java.util.HashMap r6 = new java.util.HashMap
            r8 = r6
            r6 = r8
            r7 = r8
            r7.<init>()
            r3.<init>(r4, r5, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microsoft.appcenter.http.HttpResponse.<init>(int, java.lang.String):void");
    }

    public HttpResponse(int status, @NonNull String payload2, @NonNull Map<String, String> headers2) {
        this.payload = payload2;
        this.statusCode = status;
        this.headers = headers2;
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    @NonNull
    public String getPayload() {
        return this.payload;
    }

    @NonNull
    public Map<String, String> getHeaders() {
        return this.headers;
    }

    public boolean equals(Object obj) {
        Object o = obj;
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        HttpResponse that = (HttpResponse) o;
        return this.statusCode == that.statusCode && this.payload.equals(that.payload) && this.headers.equals(that.headers);
    }

    public int hashCode() {
        return (31 * ((31 * this.statusCode) + this.payload.hashCode())) + this.headers.hashCode();
    }
}
