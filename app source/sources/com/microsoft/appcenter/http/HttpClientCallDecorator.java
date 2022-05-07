package com.microsoft.appcenter.http;

import com.microsoft.appcenter.http.HttpClient;
import java.util.Map;

abstract class HttpClientCallDecorator implements Runnable, ServiceCall, ServiceCallback {
    private final HttpClient.CallTemplate mCallTemplate;
    private final HttpClient mDecoratedApi;
    private final Map<String, String> mHeaders;
    private final String mMethod;
    ServiceCall mServiceCall;
    final ServiceCallback mServiceCallback;
    private final String mUrl;

    HttpClientCallDecorator(HttpClient decoratedApi, String url, String method, Map<String, String> headers, HttpClient.CallTemplate callTemplate, ServiceCallback serviceCallback) {
        this.mDecoratedApi = decoratedApi;
        this.mUrl = url;
        this.mMethod = method;
        this.mHeaders = headers;
        this.mCallTemplate = callTemplate;
        this.mServiceCallback = serviceCallback;
    }

    public synchronized void cancel() {
        synchronized (this) {
            this.mServiceCall.cancel();
        }
    }

    public synchronized void run() {
        synchronized (this) {
            this.mServiceCall = this.mDecoratedApi.callAsync(this.mUrl, this.mMethod, this.mHeaders, this.mCallTemplate, this);
        }
    }

    public void onCallSucceeded(HttpResponse httpResponse) {
        this.mServiceCallback.onCallSucceeded(httpResponse);
    }

    public void onCallFailed(Exception e) {
        this.mServiceCallback.onCallFailed(e);
    }
}
