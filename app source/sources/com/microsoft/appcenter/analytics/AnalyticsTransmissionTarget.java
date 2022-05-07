package com.microsoft.appcenter.analytics;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;
import android.support.annotation.WorkerThread;
import com.microsoft.appcenter.AppCenter;
import com.microsoft.appcenter.channel.AbstractChannelListener;
import com.microsoft.appcenter.channel.Channel;
import com.microsoft.appcenter.ingestion.models.Log;
import com.microsoft.appcenter.ingestion.models.one.CommonSchemaLog;
import com.microsoft.appcenter.ingestion.models.one.PartAUtils;
import com.microsoft.appcenter.utils.AppCenterLog;
import com.microsoft.appcenter.utils.async.AppCenterFuture;
import com.microsoft.appcenter.utils.async.DefaultAppCenterFuture;
import com.microsoft.appcenter.utils.storage.SharedPreferencesManager;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

public class AnalyticsTransmissionTarget {
    @VisibleForTesting
    static AuthenticationProvider sAuthenticationProvider;
    /* access modifiers changed from: private */
    public Channel mChannel;
    /* access modifiers changed from: private */
    public final Map<String, AnalyticsTransmissionTarget> mChildrenTargets;
    Context mContext;
    final AnalyticsTransmissionTarget mParentTarget;
    private final PropertyConfigurator mPropertyConfigurator;
    /* access modifiers changed from: private */
    public final String mTransmissionTargetToken;

    AnalyticsTransmissionTarget(@NonNull String transmissionTargetToken, AnalyticsTransmissionTarget parentTarget) {
        Map<String, AnalyticsTransmissionTarget> map;
        PropertyConfigurator propertyConfigurator;
        new HashMap();
        this.mChildrenTargets = map;
        this.mTransmissionTargetToken = transmissionTargetToken;
        this.mParentTarget = parentTarget;
        new PropertyConfigurator(this);
        this.mPropertyConfigurator = propertyConfigurator;
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public void initInBackground(Context context, Channel channel) {
        Channel channel2 = channel;
        this.mContext = context;
        this.mChannel = channel2;
        channel2.addListener(this.mPropertyConfigurator);
    }

    public static synchronized void addAuthenticationProvider(AuthenticationProvider authenticationProvider) {
        Runnable runnable;
        AuthenticationProvider authenticationProvider2 = authenticationProvider;
        synchronized (AnalyticsTransmissionTarget.class) {
            if (authenticationProvider2 == null) {
                AppCenterLog.error(Analytics.LOG_TAG, "Authentication provider may not be null.");
            } else if (authenticationProvider2.getType() == null) {
                AppCenterLog.error(Analytics.LOG_TAG, "Authentication provider type may not be null.");
            } else if (authenticationProvider2.getTicketKey() == null) {
                AppCenterLog.error(Analytics.LOG_TAG, "Authentication ticket key may not be null.");
            } else if (authenticationProvider2.getTokenProvider() == null) {
                AppCenterLog.error(Analytics.LOG_TAG, "Authentication token provider may not be null.");
            } else if (AppCenter.isConfigured()) {
                final AuthenticationProvider authenticationProvider3 = authenticationProvider2;
                new Runnable() {
                    public void run() {
                        AnalyticsTransmissionTarget.updateProvider(authenticationProvider3);
                    }
                };
                Analytics.getInstance().postCommandEvenIfDisabled(runnable);
            } else {
                updateProvider(authenticationProvider2);
            }
        }
    }

    /* access modifiers changed from: private */
    public static void updateProvider(AuthenticationProvider authenticationProvider) {
        AuthenticationProvider authenticationProvider2 = authenticationProvider;
        sAuthenticationProvider = authenticationProvider2;
        authenticationProvider2.acquireTokenAsync();
    }

    public void trackEvent(String name) {
        trackEvent(name, (EventProperties) null, 1);
    }

    public void trackEvent(String name, Map<String, String> properties) {
        trackEvent(name, properties, 1);
    }

    public void trackEvent(String str, Map<String, String> map, int i) {
        EventProperties eventProperties;
        String name = str;
        Map<String, String> properties = map;
        int flags = i;
        EventProperties eventProperties2 = null;
        if (properties != null) {
            new EventProperties();
            eventProperties2 = eventProperties;
            for (Map.Entry<String, String> entry : properties.entrySet()) {
                EventProperties eventProperties3 = eventProperties2.set(entry.getKey(), entry.getValue());
            }
        }
        trackEvent(name, eventProperties2, flags);
    }

    public void trackEvent(String name, EventProperties properties) {
        trackEvent(name, properties, 1);
    }

    public void trackEvent(String str, EventProperties eventProperties, int i) {
        EventProperties eventProperties2;
        String name = str;
        EventProperties properties = eventProperties;
        int flags = i;
        new EventProperties();
        EventProperties mergedProperties = eventProperties2;
        AnalyticsTransmissionTarget analyticsTransmissionTarget = this;
        while (true) {
            AnalyticsTransmissionTarget target = analyticsTransmissionTarget;
            if (target == null) {
                break;
            }
            target.getPropertyConfigurator().mergeEventProperties(mergedProperties);
            analyticsTransmissionTarget = target.mParentTarget;
        }
        if (properties != null) {
            mergedProperties.getProperties().putAll(properties.getProperties());
        } else if (mergedProperties.getProperties().isEmpty()) {
            mergedProperties = null;
        }
        Analytics.trackEvent(name, mergedProperties, this, flags);
    }

    public synchronized AnalyticsTransmissionTarget getTransmissionTarget(String str) {
        AnalyticsTransmissionTarget analyticsTransmissionTarget;
        AnalyticsTransmissionTarget analyticsTransmissionTarget2;
        Runnable runnable;
        String transmissionTargetToken = str;
        synchronized (this) {
            AnalyticsTransmissionTarget childTarget = this.mChildrenTargets.get(transmissionTargetToken);
            if (childTarget == null) {
                new AnalyticsTransmissionTarget(transmissionTargetToken, this);
                childTarget = analyticsTransmissionTarget2;
                AnalyticsTransmissionTarget put = this.mChildrenTargets.put(transmissionTargetToken, childTarget);
                final AnalyticsTransmissionTarget analyticsTransmissionTarget3 = childTarget;
                new Runnable(this) {
                    final /* synthetic */ AnalyticsTransmissionTarget this$0;

                    {
                        this.this$0 = this$0;
                    }

                    public void run() {
                        analyticsTransmissionTarget3.initInBackground(this.this$0.mContext, this.this$0.mChannel);
                    }
                };
                Analytics.getInstance().postCommandEvenIfDisabled(runnable);
            }
            analyticsTransmissionTarget = childTarget;
        }
        return analyticsTransmissionTarget;
    }

    public AppCenterFuture<Boolean> isEnabledAsync() {
        DefaultAppCenterFuture defaultAppCenterFuture;
        Runnable runnable;
        new DefaultAppCenterFuture();
        DefaultAppCenterFuture defaultAppCenterFuture2 = defaultAppCenterFuture;
        final DefaultAppCenterFuture defaultAppCenterFuture3 = defaultAppCenterFuture2;
        new Runnable(this) {
            final /* synthetic */ AnalyticsTransmissionTarget this$0;

            {
                this.this$0 = this$0;
            }

            public void run() {
                defaultAppCenterFuture3.complete(Boolean.valueOf(this.this$0.isEnabled()));
            }
        };
        Analytics.getInstance().postCommand(runnable, defaultAppCenterFuture2, false);
        return defaultAppCenterFuture2;
    }

    public AppCenterFuture<Void> setEnabledAsync(boolean enabled) {
        DefaultAppCenterFuture defaultAppCenterFuture;
        Runnable runnable;
        new DefaultAppCenterFuture();
        DefaultAppCenterFuture defaultAppCenterFuture2 = defaultAppCenterFuture;
        final boolean z = enabled;
        final DefaultAppCenterFuture defaultAppCenterFuture3 = defaultAppCenterFuture2;
        new Runnable(this) {
            final /* synthetic */ AnalyticsTransmissionTarget this$0;

            {
                this.this$0 = this$0;
            }

            public void run() {
                List<AnalyticsTransmissionTarget> list;
                if (this.this$0.areAncestorsEnabled()) {
                    new LinkedList<>();
                    List<AnalyticsTransmissionTarget> descendantTargets = list;
                    boolean add = descendantTargets.add(this.this$0);
                    while (!descendantTargets.isEmpty()) {
                        ListIterator<AnalyticsTransmissionTarget> descendantIterator = descendantTargets.listIterator();
                        while (descendantIterator.hasNext()) {
                            AnalyticsTransmissionTarget descendantTarget = descendantIterator.next();
                            descendantIterator.remove();
                            SharedPreferencesManager.putBoolean(descendantTarget.getEnabledPreferenceKey(), z);
                            for (AnalyticsTransmissionTarget childTarget : descendantTarget.mChildrenTargets.values()) {
                                descendantIterator.add(childTarget);
                            }
                        }
                    }
                } else {
                    AppCenterLog.error(Analytics.LOG_TAG, "One of the parent transmission target is disabled, cannot change state.");
                }
                defaultAppCenterFuture3.complete(null);
            }
        };
        Analytics.getInstance().postCommand(runnable, defaultAppCenterFuture2, null);
        return defaultAppCenterFuture2;
    }

    public void pause() {
        Runnable runnable;
        new Runnable(this) {
            final /* synthetic */ AnalyticsTransmissionTarget this$0;

            {
                this.this$0 = this$0;
            }

            public void run() {
                this.this$0.mChannel.pauseGroup("group_analytics", this.this$0.mTransmissionTargetToken);
                this.this$0.mChannel.pauseGroup("group_analytics_critical", this.this$0.mTransmissionTargetToken);
            }
        };
        Analytics.getInstance().post(runnable);
    }

    public void resume() {
        Runnable runnable;
        new Runnable(this) {
            final /* synthetic */ AnalyticsTransmissionTarget this$0;

            {
                this.this$0 = this$0;
            }

            public void run() {
                this.this$0.mChannel.resumeGroup("group_analytics", this.this$0.mTransmissionTargetToken);
                this.this$0.mChannel.resumeGroup("group_analytics_critical", this.this$0.mTransmissionTargetToken);
            }
        };
        Analytics.getInstance().post(runnable);
    }

    /* access modifiers changed from: package-private */
    public String getTransmissionTargetToken() {
        return this.mTransmissionTargetToken;
    }

    static Channel.Listener getChannelListener() {
        Channel.Listener listener;
        Channel.Listener listener2 = listener;
        new AbstractChannelListener() {
            public void onPreparingLog(@NonNull Log log, @NonNull String str) {
                String str2 = str;
                AnalyticsTransmissionTarget.addTicketToLog(log);
            }
        };
        return listener2;
    }

    /* access modifiers changed from: private */
    public static void addTicketToLog(@NonNull Log log) {
        Log log2 = log;
        if (sAuthenticationProvider != null && (log2 instanceof CommonSchemaLog)) {
            ((CommonSchemaLog) log2).getExt().getProtocol().setTicketKeys(Collections.singletonList(sAuthenticationProvider.getTicketKeyHash()));
            sAuthenticationProvider.checkTokenExpiry();
        }
    }

    /* access modifiers changed from: private */
    @NonNull
    public String getEnabledPreferenceKey() {
        StringBuilder sb;
        new StringBuilder();
        return sb.append(Analytics.getInstance().getEnabledPreferenceKeyPrefix()).append(PartAUtils.getTargetKey(this.mTransmissionTargetToken)).toString();
    }

    @WorkerThread
    private boolean isEnabledInStorage() {
        return SharedPreferencesManager.getBoolean(getEnabledPreferenceKey(), true);
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public boolean areAncestorsEnabled() {
        AnalyticsTransmissionTarget analyticsTransmissionTarget = this.mParentTarget;
        while (true) {
            AnalyticsTransmissionTarget target = analyticsTransmissionTarget;
            if (target == null) {
                return true;
            }
            if (!target.isEnabledInStorage()) {
                return false;
            }
            analyticsTransmissionTarget = target.mParentTarget;
        }
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public boolean isEnabled() {
        return areAncestorsEnabled() && isEnabledInStorage();
    }

    public PropertyConfigurator getPropertyConfigurator() {
        return this.mPropertyConfigurator;
    }
}
