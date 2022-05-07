package com.microsoft.appcenter.analytics;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;
import android.support.annotation.WorkerThread;
import com.microsoft.appcenter.AbstractAppCenterService;
import com.microsoft.appcenter.AppCenter;
import com.microsoft.appcenter.Flags;
import com.microsoft.appcenter.analytics.channel.AnalyticsListener;
import com.microsoft.appcenter.analytics.channel.AnalyticsValidator;
import com.microsoft.appcenter.analytics.channel.SessionTracker;
import com.microsoft.appcenter.analytics.ingestion.models.EventLog;
import com.microsoft.appcenter.analytics.ingestion.models.PageLog;
import com.microsoft.appcenter.analytics.ingestion.models.StartSessionLog;
import com.microsoft.appcenter.analytics.ingestion.models.json.EventLogFactory;
import com.microsoft.appcenter.analytics.ingestion.models.json.PageLogFactory;
import com.microsoft.appcenter.analytics.ingestion.models.json.StartSessionLogFactory;
import com.microsoft.appcenter.analytics.ingestion.models.one.CommonSchemaEventLog;
import com.microsoft.appcenter.analytics.ingestion.models.one.json.CommonSchemaEventLogFactory;
import com.microsoft.appcenter.channel.Channel;
import com.microsoft.appcenter.ingestion.Ingestion;
import com.microsoft.appcenter.ingestion.models.Log;
import com.microsoft.appcenter.ingestion.models.json.LogFactory;
import com.microsoft.appcenter.ingestion.models.properties.StringTypedProperty;
import com.microsoft.appcenter.ingestion.models.properties.TypedProperty;
import com.microsoft.appcenter.utils.AppCenterLog;
import com.microsoft.appcenter.utils.async.AppCenterFuture;
import com.microsoft.appcenter.utils.async.DefaultAppCenterFuture;
import com.microsoft.appcenter.utils.context.UserIdContext;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class Analytics extends AbstractAppCenterService {
    private static final String ACTIVITY_SUFFIX = "Activity";
    static final String ANALYTICS_CRITICAL_GROUP = "group_analytics_critical";
    static final String ANALYTICS_GROUP = "group_analytics";
    public static final String LOG_TAG = "AppCenterAnalytics";
    @VisibleForTesting
    static final int MAXIMUM_TRANSMISSION_INTERVAL_IN_SECONDS = 86400;
    @VisibleForTesting
    static final int MINIMUM_TRANSMISSION_INTERVAL_IN_SECONDS = 3;
    private static final String SERVICE_NAME = "Analytics";
    @SuppressLint({"StaticFieldLeak"})
    private static Analytics sInstance;
    /* access modifiers changed from: private */
    public AnalyticsListener mAnalyticsListener;
    private Channel.Listener mAnalyticsTransmissionTargetListener;
    private AnalyticsValidator mAnalyticsValidator;
    private boolean mAutoPageTrackingEnabled = false;
    /* access modifiers changed from: private */
    public Context mContext;
    private WeakReference<Activity> mCurrentActivity;
    @VisibleForTesting
    AnalyticsTransmissionTarget mDefaultTransmissionTarget;
    private final Map<String, LogFactory> mFactories;
    /* access modifiers changed from: private */
    public SessionTracker mSessionTracker;
    /* access modifiers changed from: private */
    public boolean mStartedFromApp;
    private long mTransmissionInterval;
    private final Map<String, AnalyticsTransmissionTarget> mTransmissionTargets;

    static /* synthetic */ WeakReference access$202(Analytics x0, WeakReference x1) {
        WeakReference weakReference = x1;
        WeakReference weakReference2 = weakReference;
        x0.mCurrentActivity = weakReference2;
        return weakReference;
    }

    private Analytics() {
        Map<String, LogFactory> map;
        Object obj;
        Object obj2;
        Object obj3;
        Object obj4;
        Map<String, AnalyticsTransmissionTarget> map2;
        new HashMap();
        this.mFactories = map;
        new StartSessionLogFactory();
        LogFactory put = this.mFactories.put(StartSessionLog.TYPE, obj);
        new PageLogFactory();
        LogFactory put2 = this.mFactories.put(PageLog.TYPE, obj2);
        new EventLogFactory();
        LogFactory put3 = this.mFactories.put("event", obj3);
        new CommonSchemaEventLogFactory();
        LogFactory put4 = this.mFactories.put(CommonSchemaEventLog.TYPE, obj4);
        new HashMap();
        this.mTransmissionTargets = map2;
        this.mTransmissionInterval = TimeUnit.SECONDS.toMillis(3);
    }

    public static synchronized Analytics getInstance() {
        Analytics analytics;
        Analytics analytics2;
        synchronized (Analytics.class) {
            if (sInstance == null) {
                new Analytics();
                sInstance = analytics2;
            }
            analytics = sInstance;
        }
        return analytics;
    }

    @VisibleForTesting
    static synchronized void unsetInstance() {
        synchronized (Analytics.class) {
            sInstance = null;
        }
    }

    public static AppCenterFuture<Boolean> isEnabled() {
        return getInstance().isInstanceEnabledAsync();
    }

    public static AppCenterFuture<Void> setEnabled(boolean enabled) {
        return getInstance().setInstanceEnabledAsync(enabled);
    }

    public static boolean setTransmissionInterval(int seconds) {
        return getInstance().setInstanceTransmissionInterval(seconds);
    }

    public static void pause() {
        getInstance().pauseInstanceAsync();
    }

    public static void resume() {
        getInstance().resumeInstanceAsync();
    }

    @VisibleForTesting
    protected static void setListener(AnalyticsListener listener) {
        getInstance().setInstanceListener(listener);
    }

    protected static boolean isAutoPageTrackingEnabled() {
        return getInstance().isInstanceAutoPageTrackingEnabled();
    }

    protected static void setAutoPageTrackingEnabled(boolean autoPageTrackingEnabled) {
        getInstance().setInstanceAutoPageTrackingEnabled(autoPageTrackingEnabled);
    }

    protected static void trackPage(String name) {
        trackPage(name, (Map<String, String>) null);
    }

    protected static void trackPage(String name, Map<String, String> properties) {
        getInstance().trackPageAsync(name, properties);
    }

    public static void trackEvent(String name) {
        trackEvent(name, (EventProperties) null, (AnalyticsTransmissionTarget) null, 1);
    }

    public static void trackEvent(String name, Map<String, String> properties) {
        getInstance().trackEventAsync(name, convertProperties(properties), (AnalyticsTransmissionTarget) null, 1);
    }

    public static void trackEvent(String name, Map<String, String> properties, int flags) {
        getInstance().trackEventAsync(name, convertProperties(properties), (AnalyticsTransmissionTarget) null, flags);
    }

    public static void trackEvent(String name, EventProperties properties) {
        trackEvent(name, properties, 1);
    }

    public static void trackEvent(String name, EventProperties properties, int flags) {
        trackEvent(name, properties, (AnalyticsTransmissionTarget) null, flags);
    }

    static void trackEvent(String name, EventProperties properties, AnalyticsTransmissionTarget transmissionTarget, int flags) {
        getInstance().trackEventAsync(name, convertProperties(properties), transmissionTarget, flags);
    }

    private static List<TypedProperty> convertProperties(EventProperties eventProperties) {
        List<TypedProperty> list;
        EventProperties properties = eventProperties;
        if (properties == null) {
            return null;
        }
        new ArrayList(properties.getProperties().values());
        return list;
    }

    private static List<TypedProperty> convertProperties(Map<String, String> map) {
        List<TypedProperty> list;
        StringTypedProperty stringTypedProperty;
        Map<String, String> properties = map;
        if (properties == null) {
            return null;
        }
        new ArrayList(properties.size());
        List<TypedProperty> typedProperties = list;
        for (Map.Entry<String, String> property : properties.entrySet()) {
            new StringTypedProperty();
            StringTypedProperty typedProperty = stringTypedProperty;
            typedProperty.setName(property.getKey());
            typedProperty.setValue(property.getValue());
            boolean add = typedProperties.add(typedProperty);
        }
        return typedProperties;
    }

    public static AnalyticsTransmissionTarget getTransmissionTarget(String transmissionTargetToken) {
        return getInstance().getInstanceTransmissionTarget(transmissionTargetToken);
    }

    private static String generatePageName(Class<?> activityClass) {
        String name = activityClass.getSimpleName();
        String suffix = ACTIVITY_SUFFIX;
        if (!name.endsWith(suffix) || name.length() <= suffix.length()) {
            return name;
        }
        return name.substring(0, name.length() - suffix.length());
    }

    private synchronized AnalyticsTransmissionTarget getInstanceTransmissionTarget(String str) {
        AnalyticsTransmissionTarget analyticsTransmissionTarget;
        StringBuilder sb;
        String transmissionTargetToken = str;
        synchronized (this) {
            if (transmissionTargetToken != null) {
                if (!transmissionTargetToken.isEmpty()) {
                    if (!AppCenter.isConfigured()) {
                        AppCenterLog.error(LOG_TAG, "Cannot create transmission target, AppCenter is not configured or started.");
                        analyticsTransmissionTarget = null;
                    } else {
                        AnalyticsTransmissionTarget transmissionTarget = this.mTransmissionTargets.get(transmissionTargetToken);
                        if (transmissionTarget != null) {
                            new StringBuilder();
                            AppCenterLog.debug(LOG_TAG, sb.append("Returning transmission target found with token ").append(transmissionTargetToken).toString());
                            analyticsTransmissionTarget = transmissionTarget;
                        } else {
                            AnalyticsTransmissionTarget transmissionTarget2 = createAnalyticsTransmissionTarget(transmissionTargetToken);
                            AnalyticsTransmissionTarget put = this.mTransmissionTargets.put(transmissionTargetToken, transmissionTarget2);
                            analyticsTransmissionTarget = transmissionTarget2;
                        }
                    }
                }
            }
            AppCenterLog.error(LOG_TAG, "Transmission target token may not be null or empty.");
            analyticsTransmissionTarget = null;
        }
        return analyticsTransmissionTarget;
    }

    private AnalyticsTransmissionTarget createAnalyticsTransmissionTarget(String str) {
        AnalyticsTransmissionTarget analyticsTransmissionTarget;
        StringBuilder sb;
        Runnable runnable;
        String transmissionTargetToken = str;
        new AnalyticsTransmissionTarget(transmissionTargetToken, (AnalyticsTransmissionTarget) null);
        AnalyticsTransmissionTarget transmissionTarget = analyticsTransmissionTarget;
        new StringBuilder();
        AppCenterLog.debug(LOG_TAG, sb.append("Created transmission target with token ").append(transmissionTargetToken).toString());
        final AnalyticsTransmissionTarget analyticsTransmissionTarget2 = transmissionTarget;
        new Runnable(this) {
            final /* synthetic */ Analytics this$0;

            {
                this.this$0 = this$0;
            }

            public void run() {
                analyticsTransmissionTarget2.initInBackground(this.this$0.mContext, this.this$0.mChannel);
            }
        };
        postCommandEvenIfDisabled(runnable);
        return transmissionTarget;
    }

    public boolean isAppSecretRequired() {
        return false;
    }

    /* access modifiers changed from: protected */
    public String getGroupName() {
        return ANALYTICS_GROUP;
    }

    public String getServiceName() {
        return SERVICE_NAME;
    }

    /* access modifiers changed from: protected */
    public String getLoggerTag() {
        return LOG_TAG;
    }

    public Map<String, LogFactory> getLogFactories() {
        return this.mFactories;
    }

    public synchronized void onActivityResumed(Activity activity) {
        Runnable runnable;
        Runnable runnable2;
        Activity activity2 = activity;
        synchronized (this) {
            final Activity activity3 = activity2;
            new Runnable(this) {
                final /* synthetic */ Analytics this$0;

                {
                    this.this$0 = this$0;
                }

                public void run() {
                    WeakReference weakReference;
                    new WeakReference(activity3);
                    WeakReference access$202 = Analytics.access$202(this.this$0, weakReference);
                }
            };
            Runnable updateCurrentActivityRunnable = runnable;
            final Runnable runnable3 = updateCurrentActivityRunnable;
            final Activity activity4 = activity2;
            new Runnable(this) {
                final /* synthetic */ Analytics this$0;

                {
                    this.this$0 = this$0;
                }

                public void run() {
                    runnable3.run();
                    this.this$0.processOnResume(activity4);
                }
            };
            boolean post = post(runnable2, updateCurrentActivityRunnable, updateCurrentActivityRunnable);
        }
    }

    /* access modifiers changed from: protected */
    public long getTriggerInterval() {
        return this.mTransmissionInterval;
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public void processOnResume(Activity activity) {
        Activity activity2 = activity;
        if (this.mSessionTracker != null) {
            this.mSessionTracker.onActivityResumed();
            if (this.mAutoPageTrackingEnabled) {
                queuePage(generatePageName(activity2.getClass()), (Map<String, String>) null);
            }
        }
    }

    public synchronized void onActivityPaused(Activity activity) {
        Runnable runnable;
        Runnable runnable2;
        Activity activity2 = activity;
        synchronized (this) {
            new Runnable(this) {
                final /* synthetic */ Analytics this$0;

                {
                    this.this$0 = this$0;
                }

                public void run() {
                    WeakReference access$202 = Analytics.access$202(this.this$0, (WeakReference) null);
                }
            };
            Runnable updateCurrentActivityRunnable = runnable;
            final Runnable runnable3 = updateCurrentActivityRunnable;
            new Runnable(this) {
                final /* synthetic */ Analytics this$0;

                {
                    this.this$0 = this$0;
                }

                public void run() {
                    runnable3.run();
                    if (this.this$0.mSessionTracker != null) {
                        this.this$0.mSessionTracker.onActivityPaused();
                    }
                }
            };
            boolean post = post(runnable2, updateCurrentActivityRunnable, updateCurrentActivityRunnable);
        }
    }

    /* access modifiers changed from: protected */
    public Channel.GroupListener getChannelListener() {
        Channel.GroupListener groupListener;
        new Channel.GroupListener(this) {
            final /* synthetic */ Analytics this$0;

            {
                this.this$0 = this$0;
            }

            public void onBeforeSending(Log log) {
                Log log2 = log;
                if (this.this$0.mAnalyticsListener != null) {
                    this.this$0.mAnalyticsListener.onBeforeSending(log2);
                }
            }

            public void onSuccess(Log log) {
                Log log2 = log;
                if (this.this$0.mAnalyticsListener != null) {
                    this.this$0.mAnalyticsListener.onSendingSucceeded(log2);
                }
            }

            public void onFailure(Log log, Exception exc) {
                Log log2 = log;
                Exception e = exc;
                if (this.this$0.mAnalyticsListener != null) {
                    this.this$0.mAnalyticsListener.onSendingFailed(log2, e);
                }
            }
        };
        return groupListener;
    }

    /* access modifiers changed from: protected */
    public synchronized void applyEnabledState(boolean z) {
        boolean enabled = z;
        synchronized (this) {
            if (enabled) {
                this.mChannel.addGroup(ANALYTICS_CRITICAL_GROUP, getTriggerCount(), 3000, getTriggerMaxParallelRequests(), (Ingestion) null, getChannelListener());
                startAppLevelFeatures();
            } else {
                this.mChannel.removeGroup(ANALYTICS_CRITICAL_GROUP);
                if (this.mAnalyticsValidator != null) {
                    this.mChannel.removeListener(this.mAnalyticsValidator);
                    this.mAnalyticsValidator = null;
                }
                if (this.mSessionTracker != null) {
                    this.mChannel.removeListener(this.mSessionTracker);
                    this.mSessionTracker.clearSessions();
                    this.mSessionTracker = null;
                }
                if (this.mAnalyticsTransmissionTargetListener != null) {
                    this.mChannel.removeListener(this.mAnalyticsTransmissionTargetListener);
                    this.mAnalyticsTransmissionTargetListener = null;
                }
            }
        }
    }

    @WorkerThread
    private void startAppLevelFeatures() {
        AnalyticsValidator analyticsValidator;
        SessionTracker sessionTracker;
        Activity activity;
        if (this.mStartedFromApp) {
            new AnalyticsValidator();
            this.mAnalyticsValidator = analyticsValidator;
            this.mChannel.addListener(this.mAnalyticsValidator);
            new SessionTracker(this.mChannel, ANALYTICS_GROUP);
            this.mSessionTracker = sessionTracker;
            this.mChannel.addListener(this.mSessionTracker);
            if (!(this.mCurrentActivity == null || (activity = (Activity) this.mCurrentActivity.get()) == null)) {
                processOnResume(activity);
            }
            this.mAnalyticsTransmissionTargetListener = AnalyticsTransmissionTarget.getChannelListener();
            this.mChannel.addListener(this.mAnalyticsTransmissionTargetListener);
        }
    }

    private synchronized void trackPageAsync(String str, Map<String, String> map) {
        Map map2;
        Runnable runnable;
        Map map3;
        String name = str;
        Map<String, String> properties = map;
        synchronized (this) {
            if (properties != null) {
                map2 = map3;
                new HashMap(properties);
            } else {
                map2 = null;
            }
            final String str2 = name;
            final Map map4 = map2;
            new Runnable(this) {
                final /* synthetic */ Analytics this$0;

                {
                    this.this$0 = this$0;
                }

                public void run() {
                    if (this.this$0.mStartedFromApp) {
                        this.this$0.queuePage(str2, map4);
                    } else {
                        AppCenterLog.error(Analytics.LOG_TAG, "Cannot track page if not started from app.");
                    }
                }
            };
            post(runnable);
        }
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public void queuePage(String name, Map<String, String> properties) {
        PageLog pageLog;
        new PageLog();
        PageLog pageLog2 = pageLog;
        pageLog2.setName(name);
        pageLog2.setProperties(properties);
        this.mChannel.enqueue(pageLog2, ANALYTICS_GROUP, 1);
    }

    private synchronized void trackEventAsync(String str, List<TypedProperty> list, AnalyticsTransmissionTarget analyticsTransmissionTarget, int i) {
        Runnable runnable;
        String name = str;
        List<TypedProperty> properties = list;
        AnalyticsTransmissionTarget transmissionTarget = analyticsTransmissionTarget;
        int flags = i;
        synchronized (this) {
            final AnalyticsTransmissionTarget analyticsTransmissionTarget2 = transmissionTarget;
            final String userId = UserIdContext.getInstance().getUserId();
            final String str2 = name;
            final List<TypedProperty> list2 = properties;
            final int i2 = flags;
            new Runnable(this) {
                final /* synthetic */ Analytics this$0;

                {
                    this.this$0 = this$0;
                }

                public void run() {
                    EventLog eventLog;
                    AnalyticsTransmissionTarget aTransmissionTarget = analyticsTransmissionTarget2 == null ? this.this$0.mDefaultTransmissionTarget : analyticsTransmissionTarget2;
                    new EventLog();
                    EventLog eventLog2 = eventLog;
                    if (aTransmissionTarget != null) {
                        if (aTransmissionTarget.isEnabled()) {
                            eventLog2.addTransmissionTarget(aTransmissionTarget.getTransmissionTargetToken());
                            eventLog2.setTag(aTransmissionTarget);
                            if (aTransmissionTarget == this.this$0.mDefaultTransmissionTarget) {
                                eventLog2.setUserId(userId);
                            }
                        } else {
                            AppCenterLog.error(Analytics.LOG_TAG, "This transmission target is disabled.");
                            return;
                        }
                    } else if (!this.this$0.mStartedFromApp) {
                        AppCenterLog.error(Analytics.LOG_TAG, "Cannot track event using Analytics.trackEvent if not started from app, please start from the application or use Analytics.getTransmissionTarget.");
                        return;
                    }
                    eventLog2.setId(UUID.randomUUID());
                    eventLog2.setName(str2);
                    eventLog2.setTypedProperties(list2);
                    int filteredFlags = Flags.getPersistenceFlag(i2, true);
                    this.this$0.mChannel.enqueue(eventLog2, filteredFlags == 2 ? Analytics.ANALYTICS_CRITICAL_GROUP : Analytics.ANALYTICS_GROUP, filteredFlags);
                }
            };
            post(runnable);
        }
    }

    private boolean isInstanceAutoPageTrackingEnabled() {
        return this.mAutoPageTrackingEnabled;
    }

    private synchronized void setInstanceAutoPageTrackingEnabled(boolean z) {
        boolean autoPageTrackingEnabled = z;
        synchronized (this) {
            this.mAutoPageTrackingEnabled = autoPageTrackingEnabled;
        }
    }

    private synchronized void setInstanceListener(AnalyticsListener analyticsListener) {
        AnalyticsListener listener = analyticsListener;
        synchronized (this) {
            this.mAnalyticsListener = listener;
        }
    }

    private synchronized void pauseInstanceAsync() {
        Runnable runnable;
        synchronized (this) {
            new Runnable(this) {
                final /* synthetic */ Analytics this$0;

                {
                    this.this$0 = this$0;
                }

                public void run() {
                    this.this$0.mChannel.pauseGroup(Analytics.ANALYTICS_GROUP, (String) null);
                    this.this$0.mChannel.pauseGroup(Analytics.ANALYTICS_CRITICAL_GROUP, (String) null);
                }
            };
            post(runnable);
        }
    }

    private synchronized void resumeInstanceAsync() {
        Runnable runnable;
        synchronized (this) {
            new Runnable(this) {
                final /* synthetic */ Analytics this$0;

                {
                    this.this$0 = this$0;
                }

                public void run() {
                    this.this$0.mChannel.resumeGroup(Analytics.ANALYTICS_GROUP, (String) null);
                    this.this$0.mChannel.resumeGroup(Analytics.ANALYTICS_CRITICAL_GROUP, (String) null);
                }
            };
            post(runnable);
        }
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public WeakReference<Activity> getCurrentActivity() {
        return this.mCurrentActivity;
    }

    public synchronized void onStarted(@NonNull Context context, @NonNull Channel channel, String str, String str2, boolean z) {
        Context context2 = context;
        Channel channel2 = channel;
        String appSecret = str;
        String transmissionTargetToken = str2;
        boolean startedFromApp = z;
        synchronized (this) {
            this.mContext = context2;
            this.mStartedFromApp = startedFromApp;
            super.onStarted(context2, channel2, appSecret, transmissionTargetToken, startedFromApp);
            setDefaultTransmissionTarget(transmissionTargetToken);
        }
    }

    public void onConfigurationUpdated(String str, String transmissionTargetToken) {
        String str2 = str;
        this.mStartedFromApp = true;
        startAppLevelFeatures();
        setDefaultTransmissionTarget(transmissionTargetToken);
    }

    @WorkerThread
    private void setDefaultTransmissionTarget(String str) {
        String transmissionTargetToken = str;
        if (transmissionTargetToken != null) {
            this.mDefaultTransmissionTarget = createAnalyticsTransmissionTarget(transmissionTargetToken);
        }
    }

    private boolean setInstanceTransmissionInterval(int i) {
        int seconds = i;
        if (this.mChannel != null) {
            AppCenterLog.error(LOG_TAG, "Transmission interval should be set before the service is started.");
            return false;
        } else if (seconds < 3 || seconds > MAXIMUM_TRANSMISSION_INTERVAL_IN_SECONDS) {
            Locale locale = Locale.ENGLISH;
            Object[] objArr = new Object[3];
            objArr[0] = 3;
            Object[] objArr2 = objArr;
            objArr2[1] = Integer.valueOf(MAXIMUM_TRANSMISSION_INTERVAL_IN_SECONDS);
            Object[] objArr3 = objArr2;
            objArr3[2] = Long.valueOf(TimeUnit.SECONDS.toDays(86400));
            AppCenterLog.error(LOG_TAG, String.format(locale, "The transmission interval is invalid. The value should be between %d seconds and %d seconds (%d day).", objArr3));
            return false;
        } else {
            this.mTransmissionInterval = TimeUnit.SECONDS.toMillis((long) seconds);
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    public <T> void postCommand(Runnable runnable, DefaultAppCenterFuture<T> future, T valueIfDisabledOrNotStarted) {
        postAsyncGetter(runnable, future, valueIfDisabledOrNotStarted);
    }

    /* access modifiers changed from: protected */
    public synchronized void post(Runnable runnable) {
        Runnable runnable2 = runnable;
        synchronized (this) {
            super.post(runnable2);
        }
    }

    /* access modifiers changed from: package-private */
    public void postCommandEvenIfDisabled(Runnable runnable) {
        Runnable runnable2 = runnable;
        boolean post = post(runnable2, runnable2, runnable2);
    }

    /* access modifiers changed from: package-private */
    public String getEnabledPreferenceKeyPrefix() {
        StringBuilder sb;
        new StringBuilder();
        return sb.append(getEnabledPreferenceKey()).append("/").toString();
    }
}
