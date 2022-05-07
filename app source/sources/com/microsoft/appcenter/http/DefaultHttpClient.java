package com.microsoft.appcenter.http;

import android.os.AsyncTask;
import android.support.annotation.VisibleForTesting;
import com.microsoft.appcenter.http.DefaultHttpClientCallTask;
import com.microsoft.appcenter.http.HttpClient;
import com.microsoft.appcenter.utils.AppCenterLog;
import com.microsoft.appcenter.utils.HandlerUtils;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.RejectedExecutionException;

public class DefaultHttpClient implements HttpClient, DefaultHttpClientCallTask.Tracker {
    static final String CHARSET_NAME = "UTF-8";
    static final String CONTENT_ENCODING_KEY = "Content-Encoding";
    static final String CONTENT_ENCODING_VALUE = "gzip";
    public static final String CONTENT_TYPE_KEY = "Content-Type";
    static final String CONTENT_TYPE_VALUE = "application/json";
    public static final String METHOD_DELETE = "DELETE";
    public static final String METHOD_GET = "GET";
    public static final String METHOD_POST = "POST";
    static final String X_MS_RETRY_AFTER_MS_HEADER = "x-ms-retry-after-ms";
    private final boolean mCompressionEnabled;
    private final Set<DefaultHttpClientCallTask> mTasks;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public DefaultHttpClient() {
        this(true);
    }

    public DefaultHttpClient(boolean compressionEnabled) {
        Set<DefaultHttpClientCallTask> set;
        new HashSet();
        this.mTasks = set;
        this.mCompressionEnabled = compressionEnabled;
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public Set<DefaultHttpClientCallTask> getTasks() {
        return this.mTasks;
    }

    public ServiceCall callAsync(String url, String method, Map<String, String> headers, HttpClient.CallTemplate callTemplate, ServiceCallback serviceCallback) {
        DefaultHttpClientCallTask defaultHttpClientCallTask;
        Runnable runnable;
        ServiceCall serviceCall;
        ServiceCallback serviceCallback2 = serviceCallback;
        new DefaultHttpClientCallTask(url, method, headers, callTemplate, serviceCallback2, this, this.mCompressionEnabled);
        DefaultHttpClientCallTask task = defaultHttpClientCallTask;
        try {
            AsyncTask executeOnExecutor = task.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        } catch (RejectedExecutionException e) {
            final ServiceCallback serviceCallback3 = serviceCallback2;
            final RejectedExecutionException rejectedExecutionException = e;
            new Runnable(this) {
                final /* synthetic */ DefaultHttpClient this$0;

                {
                    this.this$0 = this$0;
                }

                public void run() {
                    serviceCallback3.onCallFailed(rejectedExecutionException);
                }
            };
            HandlerUtils.runOnUiThread(runnable);
        }
        final DefaultHttpClientCallTask defaultHttpClientCallTask2 = task;
        new ServiceCall(this) {
            final /* synthetic */ DefaultHttpClient this$0;

            {
                this.this$0 = this$0;
            }

            public void cancel() {
                boolean cancel = defaultHttpClientCallTask2.cancel(true);
            }
        };
        return serviceCall;
    }

    public synchronized void onStart(DefaultHttpClientCallTask defaultHttpClientCallTask) {
        DefaultHttpClientCallTask task = defaultHttpClientCallTask;
        synchronized (this) {
            boolean add = this.mTasks.add(task);
        }
    }

    public synchronized void onFinish(DefaultHttpClientCallTask defaultHttpClientCallTask) {
        DefaultHttpClientCallTask task = defaultHttpClientCallTask;
        synchronized (this) {
            boolean remove = this.mTasks.remove(task);
        }
    }

    public synchronized void close() {
        StringBuilder sb;
        synchronized (this) {
            if (this.mTasks.size() > 0) {
                new StringBuilder();
                AppCenterLog.debug("AppCenter", sb.append("Cancelling ").append(this.mTasks.size()).append(" network call(s).").toString());
                for (DefaultHttpClientCallTask task : this.mTasks) {
                    boolean cancel = task.cancel(true);
                }
                this.mTasks.clear();
            }
        }
    }

    public void reopen() {
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public boolean isCompressionEnabled() {
        return this.mCompressionEnabled;
    }
}
