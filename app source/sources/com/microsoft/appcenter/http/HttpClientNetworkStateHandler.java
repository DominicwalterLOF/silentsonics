package com.microsoft.appcenter.http;

import com.microsoft.appcenter.http.HttpClient;
import com.microsoft.appcenter.utils.AppCenterLog;
import com.microsoft.appcenter.utils.NetworkStateHelper;
import java.io.IOException;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class HttpClientNetworkStateHandler extends HttpClientDecorator implements NetworkStateHelper.Listener {
    private final Set<Call> mCalls;
    private final NetworkStateHelper mNetworkStateHelper;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HttpClientNetworkStateHandler(HttpClient decoratedApi, NetworkStateHelper networkStateHelper) {
        super(decoratedApi);
        Set<Call> set;
        new HashSet();
        this.mCalls = set;
        this.mNetworkStateHelper = networkStateHelper;
        this.mNetworkStateHelper.addListener(this);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v0, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v10, resolved type: com.microsoft.appcenter.http.HttpClientNetworkStateHandler$Call} */
    /* JADX WARNING: type inference failed for: r0v2, types: [com.microsoft.appcenter.http.ServiceCall] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized com.microsoft.appcenter.http.ServiceCall callAsync(java.lang.String r19, java.lang.String r20, java.util.Map<java.lang.String, java.lang.String> r21, com.microsoft.appcenter.http.HttpClient.CallTemplate r22, com.microsoft.appcenter.http.ServiceCallback r23) {
        /*
            r18 = this;
            r0 = r18
            r1 = r19
            r2 = r20
            r3 = r21
            r4 = r22
            r5 = r23
            r16 = r18
            monitor-enter(r16)
            com.microsoft.appcenter.http.HttpClientNetworkStateHandler$Call r7 = new com.microsoft.appcenter.http.HttpClientNetworkStateHandler$Call     // Catch:{ all -> 0x0047 }
            r17 = r7
            r7 = r17
            r8 = r17
            r9 = r0
            r10 = r0
            com.microsoft.appcenter.http.HttpClient r10 = r10.mDecoratedApi     // Catch:{ all -> 0x0047 }
            r11 = r1
            r12 = r2
            r13 = r3
            r14 = r4
            r15 = r5
            r8.<init>(r9, r10, r11, r12, r13, r14, r15)     // Catch:{ all -> 0x0047 }
            r6 = r7
            r7 = r0
            com.microsoft.appcenter.utils.NetworkStateHelper r7 = r7.mNetworkStateHelper     // Catch:{ all -> 0x0047 }
            boolean r7 = r7.isNetworkConnected()     // Catch:{ all -> 0x0047 }
            if (r7 == 0) goto L_0x0035
            r7 = r6
            r7.run()     // Catch:{ all -> 0x0047 }
        L_0x0031:
            r7 = r6
            r0 = r7
            monitor-exit(r16)
            return r0
        L_0x0035:
            r7 = r0
            java.util.Set<com.microsoft.appcenter.http.HttpClientNetworkStateHandler$Call> r7 = r7.mCalls     // Catch:{ all -> 0x0047 }
            r8 = r6
            boolean r7 = r7.add(r8)     // Catch:{ all -> 0x0047 }
            java.lang.String r7 = "AppCenter"
            java.lang.String r8 = "Call triggered with no network connectivity, waiting network to become available..."
            com.microsoft.appcenter.utils.AppCenterLog.debug(r7, r8)     // Catch:{ all -> 0x0047 }
            goto L_0x0031
        L_0x0047:
            r0 = move-exception
            monitor-exit(r16)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microsoft.appcenter.http.HttpClientNetworkStateHandler.callAsync(java.lang.String, java.lang.String, java.util.Map, com.microsoft.appcenter.http.HttpClient$CallTemplate, com.microsoft.appcenter.http.ServiceCallback):com.microsoft.appcenter.http.ServiceCall");
    }

    public synchronized void close() throws IOException {
        synchronized (this) {
            this.mNetworkStateHelper.removeListener(this);
            this.mCalls.clear();
            super.close();
        }
    }

    public void reopen() {
        this.mNetworkStateHelper.addListener(this);
        super.reopen();
    }

    public synchronized void onNetworkStateUpdated(boolean z) {
        StringBuilder sb;
        boolean connected = z;
        synchronized (this) {
            if (connected) {
                if (this.mCalls.size() > 0) {
                    new StringBuilder();
                    AppCenterLog.debug("AppCenter", sb.append("Network is available. ").append(this.mCalls.size()).append(" pending call(s) to submit now.").toString());
                    for (Call call : this.mCalls) {
                        call.run();
                    }
                    this.mCalls.clear();
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public synchronized void cancelCall(Call call) {
        Call call2 = call;
        synchronized (this) {
            if (call2.mServiceCall != null) {
                call2.mServiceCall.cancel();
            }
            boolean remove = this.mCalls.remove(call2);
        }
    }

    private class Call extends HttpClientCallDecorator {
        final /* synthetic */ HttpClientNetworkStateHandler this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        Call(HttpClientNetworkStateHandler httpClientNetworkStateHandler, HttpClient decoratedApi, String url, String method, Map<String, String> headers, HttpClient.CallTemplate callTemplate, ServiceCallback serviceCallback) {
            super(decoratedApi, url, method, headers, callTemplate, serviceCallback);
            this.this$0 = httpClientNetworkStateHandler;
        }

        public void cancel() {
            this.this$0.cancelCall(this);
        }
    }
}
