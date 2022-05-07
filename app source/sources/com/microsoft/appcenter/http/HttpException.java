package com.microsoft.appcenter.http;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import java.io.IOException;

public class HttpException extends IOException {
    private final HttpResponse mHttpResponse;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public HttpException(@android.support.annotation.NonNull com.microsoft.appcenter.http.HttpResponse r6) {
        /*
            r5 = this;
            r0 = r5
            r1 = r6
            r2 = r0
            r3 = r1
            int r3 = r3.getStatusCode()
            r4 = r1
            java.lang.String r4 = r4.getPayload()
            java.lang.String r3 = getDetailMessage(r3, r4)
            r2.<init>(r3)
            r2 = r0
            r3 = r1
            r2.mHttpResponse = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microsoft.appcenter.http.HttpException.<init>(com.microsoft.appcenter.http.HttpResponse):void");
    }

    @NonNull
    private static String getDetailMessage(int i, @NonNull String str) {
        StringBuilder sb;
        int status = i;
        String payload = str;
        if (TextUtils.isEmpty(payload)) {
            return String.valueOf(status);
        }
        new StringBuilder();
        return sb.append(status).append(" - ").append(payload).toString();
    }

    public HttpResponse getHttpResponse() {
        return this.mHttpResponse;
    }

    public boolean equals(Object obj) {
        Object o = obj;
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        return this.mHttpResponse.equals(((HttpException) o).mHttpResponse);
    }

    public int hashCode() {
        return this.mHttpResponse.hashCode();
    }
}
