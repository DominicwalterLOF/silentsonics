package com.microsoft.appcenter;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.WorkerThread;
import com.microsoft.appcenter.channel.Channel;
import com.microsoft.appcenter.ingestion.Ingestion;
import com.microsoft.appcenter.ingestion.models.json.LogFactory;
import com.microsoft.appcenter.utils.AppCenterLog;
import com.microsoft.appcenter.utils.HandlerUtils;
import com.microsoft.appcenter.utils.PrefStorageConstants;
import com.microsoft.appcenter.utils.async.AppCenterFuture;
import com.microsoft.appcenter.utils.async.DefaultAppCenterFuture;
import com.microsoft.appcenter.utils.storage.SharedPreferencesManager;
import java.util.Map;

public abstract class AbstractAppCenterService implements AppCenterService {
    private static final String PREFERENCE_KEY_SEPARATOR = "_";
    /* access modifiers changed from: protected */
    public Channel mChannel;
    private AppCenterHandler mHandler;

    /* access modifiers changed from: protected */
    public abstract String getGroupName();

    /* access modifiers changed from: protected */
    public abstract String getLoggerTag();

    public AbstractAppCenterService() {
    }

    public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
    }

    public void onActivityStarted(Activity activity) {
    }

    public void onActivityResumed(Activity activity) {
    }

    public void onActivityPaused(Activity activity) {
    }

    public void onActivityStopped(Activity activity) {
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
    }

    public void onActivityDestroyed(Activity activity) {
    }

    public void onApplicationEnterForeground() {
    }

    public void onApplicationEnterBackground() {
    }

    /* access modifiers changed from: protected */
    public synchronized AppCenterFuture<Boolean> isInstanceEnabledAsync() {
        DefaultAppCenterFuture defaultAppCenterFuture;
        Runnable runnable;
        DefaultAppCenterFuture defaultAppCenterFuture2;
        synchronized (this) {
            new DefaultAppCenterFuture();
            DefaultAppCenterFuture defaultAppCenterFuture3 = defaultAppCenterFuture;
            final DefaultAppCenterFuture defaultAppCenterFuture4 = defaultAppCenterFuture3;
            new Runnable(this) {
                final /* synthetic */ AbstractAppCenterService this$0;

                {
                    this.this$0 = this$0;
                }

                public void run() {
                    defaultAppCenterFuture4.complete(true);
                }
            };
            postAsyncGetter(runnable, defaultAppCenterFuture3, false);
            defaultAppCenterFuture2 = defaultAppCenterFuture3;
        }
        return defaultAppCenterFuture2;
    }

    /* access modifiers changed from: protected */
    public final synchronized AppCenterFuture<Void> setInstanceEnabledAsync(boolean z) {
        DefaultAppCenterFuture defaultAppCenterFuture;
        Runnable runnable;
        Runnable runnable2;
        DefaultAppCenterFuture defaultAppCenterFuture2;
        boolean enabled = z;
        synchronized (this) {
            new DefaultAppCenterFuture();
            DefaultAppCenterFuture defaultAppCenterFuture3 = defaultAppCenterFuture;
            final DefaultAppCenterFuture defaultAppCenterFuture4 = defaultAppCenterFuture3;
            new Runnable(this) {
                final /* synthetic */ AbstractAppCenterService this$0;

                {
                    this.this$0 = this$0;
                }

                public void run() {
                    AppCenterLog.error("AppCenter", "App Center SDK is disabled.");
                    defaultAppCenterFuture4.complete(null);
                }
            };
            Runnable coreDisabledRunnable = runnable;
            final boolean z2 = enabled;
            final DefaultAppCenterFuture defaultAppCenterFuture5 = defaultAppCenterFuture3;
            new Runnable(this) {
                final /* synthetic */ AbstractAppCenterService this$0;

                {
                    this.this$0 = this$0;
                }

                public void run() {
                    this.this$0.setInstanceEnabled(z2);
                    defaultAppCenterFuture5.complete(null);
                }
            };
            Runnable runnable3 = runnable2;
            if (!post(runnable3, coreDisabledRunnable, runnable3)) {
                defaultAppCenterFuture3.complete(null);
            }
            defaultAppCenterFuture2 = defaultAppCenterFuture3;
        }
        return defaultAppCenterFuture2;
    }

    public synchronized boolean isInstanceEnabled() {
        boolean z;
        synchronized (this) {
            z = SharedPreferencesManager.getBoolean(getEnabledPreferenceKey(), true);
        }
        return z;
    }

    @WorkerThread
    public synchronized void setInstanceEnabled(boolean z) {
        boolean enabled = z;
        synchronized (this) {
            if (enabled == isInstanceEnabled()) {
                String loggerTag = getLoggerTag();
                Object[] objArr = new Object[2];
                objArr[0] = getServiceName();
                Object[] objArr2 = objArr;
                Object[] objArr3 = objArr2;
                objArr2[1] = enabled ? PrefStorageConstants.KEY_ENABLED : "disabled";
                AppCenterLog.info(loggerTag, String.format("%s service has already been %s.", objArr3));
            } else {
                String groupName = getGroupName();
                if (!(this.mChannel == null || groupName == null)) {
                    if (enabled) {
                        this.mChannel.addGroup(groupName, getTriggerCount(), getTriggerInterval(), getTriggerMaxParallelRequests(), (Ingestion) null, getChannelListener());
                    } else {
                        this.mChannel.clear(groupName);
                        this.mChannel.removeGroup(groupName);
                    }
                }
                SharedPreferencesManager.putBoolean(getEnabledPreferenceKey(), enabled);
                String loggerTag2 = getLoggerTag();
                Object[] objArr4 = new Object[2];
                objArr4[0] = getServiceName();
                Object[] objArr5 = objArr4;
                Object[] objArr6 = objArr5;
                objArr5[1] = enabled ? PrefStorageConstants.KEY_ENABLED : "disabled";
                AppCenterLog.info(loggerTag2, String.format("%s service has been %s.", objArr6));
                if (this.mChannel != null) {
                    applyEnabledState(enabled);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    public synchronized void applyEnabledState(boolean z) {
        boolean z2 = z;
        synchronized (this) {
        }
    }

    public boolean isAppSecretRequired() {
        return true;
    }

    public final synchronized void onStarting(@NonNull AppCenterHandler appCenterHandler) {
        AppCenterHandler handler = appCenterHandler;
        synchronized (this) {
            this.mHandler = handler;
        }
    }

    @WorkerThread
    public synchronized void onStarted(@NonNull Context context, @NonNull Channel channel, String str, String str2, boolean z) {
        Context context2 = context;
        Channel channel2 = channel;
        String str3 = str;
        String str4 = str2;
        boolean z2 = z;
        synchronized (this) {
            String groupName = getGroupName();
            boolean enabled = isInstanceEnabled();
            if (groupName != null) {
                channel2.removeGroup(groupName);
                if (enabled) {
                    channel2.addGroup(groupName, getTriggerCount(), getTriggerInterval(), getTriggerMaxParallelRequests(), (Ingestion) null, getChannelListener());
                } else {
                    channel2.clear(groupName);
                }
            }
            this.mChannel = channel2;
            applyEnabledState(enabled);
        }
    }

    public void onConfigurationUpdated(String appSecret, String transmissionTargetToken) {
    }

    public Map<String, LogFactory> getLogFactories() {
        return null;
    }

    /* access modifiers changed from: protected */
    @NonNull
    public String getEnabledPreferenceKey() {
        StringBuilder sb;
        new StringBuilder();
        return sb.append("enabled_").append(getServiceName()).toString();
    }

    /* access modifiers changed from: protected */
    public int getTriggerCount() {
        return 50;
    }

    /* access modifiers changed from: protected */
    public long getTriggerInterval() {
        return 3000;
    }

    /* access modifiers changed from: protected */
    public int getTriggerMaxParallelRequests() {
        return 3;
    }

    /* access modifiers changed from: protected */
    public Channel.GroupListener getChannelListener() {
        return null;
    }

    /* access modifiers changed from: protected */
    public synchronized void post(Runnable runnable) {
        Runnable runnable2 = runnable;
        synchronized (this) {
            boolean post = post(runnable2, (Runnable) null, (Runnable) null);
        }
    }

    /* access modifiers changed from: protected */
    public synchronized boolean post(Runnable runnable, Runnable runnable2, Runnable runnable3) {
        Runnable runnable4;
        boolean z;
        StringBuilder sb;
        Runnable runnable5 = runnable;
        Runnable coreDisabledRunnable = runnable2;
        Runnable serviceDisabledRunnable = runnable3;
        synchronized (this) {
            if (this.mHandler == null) {
                new StringBuilder();
                AppCenterLog.error("AppCenter", sb.append(getServiceName()).append(" needs to be started before it can be used.").toString());
                z = false;
            } else {
                final Runnable runnable6 = runnable5;
                final Runnable runnable7 = serviceDisabledRunnable;
                new Runnable(this) {
                    final /* synthetic */ AbstractAppCenterService this$0;

                    {
                        this.this$0 = this$0;
                    }

                    public void run() {
                        StringBuilder sb;
                        if (this.this$0.isInstanceEnabled()) {
                            runnable6.run();
                        } else if (runnable7 != null) {
                            runnable7.run();
                        } else {
                            new StringBuilder();
                            AppCenterLog.info("AppCenter", sb.append(this.this$0.getServiceName()).append(" service disabled, discarding calls.").toString());
                        }
                    }
                };
                this.mHandler.post(runnable4, coreDisabledRunnable);
                z = true;
            }
        }
        return z;
    }

    /* access modifiers changed from: protected */
    public synchronized <T> void postAsyncGetter(Runnable runnable, DefaultAppCenterFuture<T> defaultAppCenterFuture, T t) {
        Runnable runnable2;
        Runnable runnable3;
        Runnable runnable4 = runnable;
        DefaultAppCenterFuture<T> future = defaultAppCenterFuture;
        T valueIfDisabledOrNotStarted = t;
        synchronized (this) {
            final DefaultAppCenterFuture<T> defaultAppCenterFuture2 = future;
            final T t2 = valueIfDisabledOrNotStarted;
            new Runnable(this) {
                final /* synthetic */ AbstractAppCenterService this$0;

                {
                    this.this$0 = this$0;
                }

                public void run() {
                    defaultAppCenterFuture2.complete(t2);
                }
            };
            Runnable disabledOrNotStartedRunnable = runnable2;
            final Runnable runnable5 = runnable4;
            new Runnable(this) {
                final /* synthetic */ AbstractAppCenterService this$0;

                {
                    this.this$0 = this$0;
                }

                public void run() {
                    runnable5.run();
                }
            };
            if (!post(runnable3, disabledOrNotStartedRunnable, disabledOrNotStartedRunnable)) {
                disabledOrNotStartedRunnable.run();
            }
        }
    }

    /* access modifiers changed from: protected */
    public synchronized void postOnUiThread(Runnable runnable) {
        Runnable runnable2;
        Runnable runnable3;
        Runnable runnable4 = runnable;
        synchronized (this) {
            final Runnable runnable5 = runnable4;
            new Runnable(this) {
                final /* synthetic */ AbstractAppCenterService this$0;

                {
                    this.this$0 = this$0;
                }

                public void run() {
                    Runnable runnable;
                    new Runnable(this) {
                        final /* synthetic */ AnonymousClass7 this$1;

                        {
                            this.this$1 = this$1;
                        }

                        public void run() {
                            this.this$1.this$0.runIfEnabled(runnable5);
                        }
                    };
                    HandlerUtils.runOnUiThread(runnable);
                }
            };
            new Runnable(this) {
                final /* synthetic */ AbstractAppCenterService this$0;

                {
                    this.this$0 = this$0;
                }

                public void run() {
                }
            };
            boolean post = post(runnable2, runnable3, (Runnable) null);
        }
    }

    /* access modifiers changed from: private */
    public synchronized void runIfEnabled(Runnable runnable) {
        Runnable runnable2 = runnable;
        synchronized (this) {
            if (isInstanceEnabled()) {
                runnable2.run();
            }
        }
    }
}
