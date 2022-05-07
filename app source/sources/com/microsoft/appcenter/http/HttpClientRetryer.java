package com.microsoft.appcenter.http;

import android.os.Handler;
import android.support.annotation.VisibleForTesting;
import com.microsoft.appcenter.http.HttpClient;
import com.microsoft.appcenter.utils.AppCenterLog;
import java.net.UnknownHostException;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class HttpClientRetryer extends HttpClientDecorator {
    @VisibleForTesting
    static final long[] RETRY_INTERVALS;
    /* access modifiers changed from: private */
    public final Handler mHandler;
    /* access modifiers changed from: private */
    public final Random mRandom;

    static {
        long[] jArr = new long[3];
        jArr[0] = TimeUnit.SECONDS.toMillis(10);
        long[] jArr2 = jArr;
        jArr2[1] = TimeUnit.MINUTES.toMillis(5);
        long[] jArr3 = jArr2;
        jArr3[2] = TimeUnit.MINUTES.toMillis(20);
        RETRY_INTERVALS = jArr3;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    HttpClientRetryer(com.microsoft.appcenter.http.HttpClient r9) {
        /*
            r8 = this;
            r0 = r8
            r1 = r9
            r2 = r0
            r3 = r1
            android.os.Handler r4 = new android.os.Handler
            r7 = r4
            r4 = r7
            r5 = r7
            android.os.Looper r6 = android.os.Looper.getMainLooper()
            r5.<init>(r6)
            r2.<init>(r3, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microsoft.appcenter.http.HttpClientRetryer.<init>(com.microsoft.appcenter.http.HttpClient):void");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @VisibleForTesting
    HttpClientRetryer(HttpClient decoratedApi, Handler handler) {
        super(decoratedApi);
        Random random;
        new Random();
        this.mRandom = random;
        this.mHandler = handler;
    }

    public ServiceCall callAsync(String url, String method, Map<String, String> headers, HttpClient.CallTemplate callTemplate, ServiceCallback serviceCallback) {
        RetryableCall retryableCall;
        new RetryableCall(this, this.mDecoratedApi, url, method, headers, callTemplate, serviceCallback);
        RetryableCall retryableCall2 = retryableCall;
        retryableCall2.run();
        return retryableCall2;
    }

    private class RetryableCall extends HttpClientCallDecorator {
        private int mRetryCount;
        final /* synthetic */ HttpClientRetryer this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        RetryableCall(HttpClientRetryer httpClientRetryer, HttpClient decoratedApi, String url, String method, Map<String, String> headers, HttpClient.CallTemplate callTemplate, ServiceCallback serviceCallback) {
            super(decoratedApi, url, method, headers, callTemplate, serviceCallback);
            this.this$0 = httpClientRetryer;
        }

        public synchronized void cancel() {
            synchronized (this) {
                this.this$0.mHandler.removeCallbacks(this);
                super.cancel();
            }
        }

        public void onCallFailed(Exception exc) {
            StringBuilder sb;
            StringBuilder sb2;
            String retryAfterMs;
            Exception e = exc;
            if (this.mRetryCount >= HttpClientRetryer.RETRY_INTERVALS.length || !HttpUtils.isRecoverableError(e)) {
                this.mServiceCallback.onCallFailed(e);
                return;
            }
            long delay = 0;
            if ((e instanceof HttpException) && (retryAfterMs = ((HttpException) e).getHttpResponse().getHeaders().get("x-ms-retry-after-ms")) != null) {
                delay = Long.parseLong(retryAfterMs);
            }
            if (delay == 0) {
                long[] jArr = HttpClientRetryer.RETRY_INTERVALS;
                int i = this.mRetryCount;
                int i2 = i + 1;
                this.mRetryCount = i2;
                long delay2 = jArr[i] / 2;
                delay = delay2 + ((long) this.this$0.mRandom.nextInt((int) delay2));
            }
            new StringBuilder();
            String message = sb.append("Try #").append(this.mRetryCount).append(" failed and will be retried in ").append(delay).append(" ms").toString();
            if (e instanceof UnknownHostException) {
                new StringBuilder();
                message = sb2.append(message).append(" (UnknownHostException)").toString();
            }
            AppCenterLog.warn("AppCenter", message, e);
            boolean postDelayed = this.this$0.mHandler.postDelayed(this, delay);
        }
    }
}
