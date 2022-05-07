package com.microsoft.appcenter;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;
import android.support.annotation.WorkerThread;
import com.microsoft.appcenter.channel.Channel;
import com.microsoft.appcenter.channel.DefaultChannel;
import com.microsoft.appcenter.channel.OneCollectorChannelListener;
import com.microsoft.appcenter.http.HttpClient;
import com.microsoft.appcenter.http.HttpUtils;
import com.microsoft.appcenter.ingestion.Ingestion;
import com.microsoft.appcenter.ingestion.models.CustomPropertiesLog;
import com.microsoft.appcenter.ingestion.models.StartServiceLog;
import com.microsoft.appcenter.ingestion.models.WrapperSdk;
import com.microsoft.appcenter.ingestion.models.json.CustomPropertiesLogFactory;
import com.microsoft.appcenter.ingestion.models.json.DefaultLogSerializer;
import com.microsoft.appcenter.ingestion.models.json.LogFactory;
import com.microsoft.appcenter.ingestion.models.json.LogSerializer;
import com.microsoft.appcenter.ingestion.models.json.StartServiceLogFactory;
import com.microsoft.appcenter.utils.AppCenterLog;
import com.microsoft.appcenter.utils.ApplicationLifecycleListener;
import com.microsoft.appcenter.utils.DeviceInfoHelper;
import com.microsoft.appcenter.utils.IdHelper;
import com.microsoft.appcenter.utils.InstrumentationRegistryHelper;
import com.microsoft.appcenter.utils.NetworkStateHelper;
import com.microsoft.appcenter.utils.PrefStorageConstants;
import com.microsoft.appcenter.utils.async.AppCenterFuture;
import com.microsoft.appcenter.utils.async.DefaultAppCenterFuture;
import com.microsoft.appcenter.utils.context.SessionContext;
import com.microsoft.appcenter.utils.context.UserIdContext;
import com.microsoft.appcenter.utils.storage.FileManager;
import com.microsoft.appcenter.utils.storage.SharedPreferencesManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

public class AppCenter {
    @VisibleForTesting
    static final String APP_SECRET_KEY = "appsecret";
    @VisibleForTesting
    static final String CORE_GROUP = "group_core";
    @VisibleForTesting
    static final long DEFAULT_MAX_STORAGE_SIZE_IN_BYTES = 10485760;
    @VisibleForTesting
    static final String KEY_VALUE_DELIMITER = "=";
    public static final String LOG_TAG = "AppCenter";
    @VisibleForTesting
    static final long MINIMUM_STORAGE_SIZE = 24576;
    @VisibleForTesting
    static final String PAIR_DELIMITER = ";";
    @VisibleForTesting
    static final String RUNNING_IN_APP_CENTER = "RUNNING_IN_APP_CENTER";
    @VisibleForTesting
    static final String TRANSMISSION_TARGET_TOKEN_KEY = "target";
    private static final String TRUE_ENVIRONMENT_STRING = "1";
    @SuppressLint({"StaticFieldLeak"})
    private static AppCenter sInstance;
    private AppCenterHandler mAppCenterHandler;
    /* access modifiers changed from: private */
    public String mAppSecret;
    private Application mApplication;
    private ApplicationLifecycleListener mApplicationLifecycleListener;
    /* access modifiers changed from: private */
    public Channel mChannel;
    private boolean mConfiguredFromApp;
    private Handler mHandler;
    private HandlerThread mHandlerThread;
    private boolean mLogLevelConfigured;
    private LogSerializer mLogSerializer;
    private String mLogUrl;
    private long mMaxStorageSizeInBytes = DEFAULT_MAX_STORAGE_SIZE_IN_BYTES;
    /* access modifiers changed from: private */
    public OneCollectorChannelListener mOneCollectorChannelListener;
    private Set<AppCenterService> mServices;
    private Set<AppCenterService> mServicesStartedFromLibrary;
    private DefaultAppCenterFuture<Boolean> mSetMaxStorageSizeFuture;
    private final List<String> mStartedServicesNamesToLog;
    private String mTransmissionTargetToken;
    private UncaughtExceptionHandler mUncaughtExceptionHandler;

    public AppCenter() {
        List<String> list;
        new ArrayList();
        this.mStartedServicesNamesToLog = list;
    }

    public static synchronized AppCenter getInstance() {
        AppCenter appCenter;
        AppCenter appCenter2;
        synchronized (AppCenter.class) {
            if (sInstance == null) {
                new AppCenter();
                sInstance = appCenter2;
            }
            appCenter = sInstance;
        }
        return appCenter;
    }

    @VisibleForTesting
    static synchronized void unsetInstance() {
        synchronized (AppCenter.class) {
            sInstance = null;
            NetworkStateHelper.unsetInstance();
        }
    }

    public static void setWrapperSdk(WrapperSdk wrapperSdk) {
        getInstance().setInstanceWrapperSdk(wrapperSdk);
    }

    @IntRange(from = 2, to = 8)
    public static int getLogLevel() {
        return AppCenterLog.getLogLevel();
    }

    public static void setLogLevel(@IntRange(from = 2, to = 8) int logLevel) {
        getInstance().setInstanceLogLevel(logLevel);
    }

    public static void setLogUrl(String logUrl) {
        getInstance().setInstanceLogUrl(logUrl);
    }

    public static String getSdkVersion() {
        return "3.3.0";
    }

    public static void setCustomProperties(CustomProperties customProperties) {
        getInstance().setInstanceCustomProperties(customProperties);
    }

    public static boolean isConfigured() {
        return getInstance().isInstanceConfigured();
    }

    public static boolean isRunningInAppCenterTestCloud() {
        try {
            return TRUE_ENVIRONMENT_STRING.equals(InstrumentationRegistryHelper.getArguments().getString(RUNNING_IN_APP_CENTER));
        } catch (IllegalStateException e) {
            IllegalStateException illegalStateException = e;
            return false;
        }
    }

    public static void configure(Application application, String appSecret) {
        getInstance().configureInstanceWithRequiredAppSecret(application, appSecret);
    }

    public static void configure(Application application) {
        boolean configureInstance = getInstance().configureInstance(application, (String) null, true);
    }

    @SafeVarargs
    public static void start(Class<? extends AppCenterService>... services) {
        getInstance().startServices(true, services);
    }

    @SafeVarargs
    public static void start(Application application, String appSecret, Class<? extends AppCenterService>... services) {
        getInstance().configureAndStartServices(application, appSecret, services);
    }

    @SafeVarargs
    public static void start(Application application, Class<? extends AppCenterService>... services) {
        getInstance().configureAndStartServices(application, (String) null, true, services);
    }

    @SafeVarargs
    public static void startFromLibrary(Context context, Class<? extends AppCenterService>... services) {
        getInstance().startInstanceFromLibrary(context, services);
    }

    public static AppCenterFuture<Boolean> isEnabled() {
        return getInstance().isInstanceEnabledAsync();
    }

    public static AppCenterFuture<Void> setEnabled(boolean enabled) {
        return getInstance().setInstanceEnabledAsync(enabled);
    }

    public static AppCenterFuture<UUID> getInstallId() {
        return getInstance().getInstanceInstallIdAsync();
    }

    public static AppCenterFuture<Boolean> setMaxStorageSize(long storageSizeInBytes) {
        return getInstance().setInstanceMaxStorageSizeAsync(storageSizeInBytes);
    }

    private synchronized void setInstanceUserId(String str) {
        String userId = str;
        synchronized (this) {
            if (!this.mConfiguredFromApp) {
                AppCenterLog.error("AppCenter", "AppCenter must be configured from application, libraries cannot use call setUserId.");
            } else if (this.mAppSecret == null && this.mTransmissionTargetToken == null) {
                AppCenterLog.error("AppCenter", "AppCenter must be configured with a secret from application to call setUserId.");
            } else {
                if (userId != null) {
                    if (this.mAppSecret == null || UserIdContext.checkUserIdValidForAppCenter(userId)) {
                        if (this.mTransmissionTargetToken != null && !UserIdContext.checkUserIdValidForOneCollector(userId)) {
                        }
                    }
                }
                UserIdContext.getInstance().setUserId(userId);
            }
        }
    }

    private synchronized boolean checkPrecondition() {
        boolean z;
        synchronized (this) {
            if (isInstanceConfigured()) {
                z = true;
            } else {
                AppCenterLog.error("AppCenter", "App Center hasn't been configured. You need to call AppCenter.start with appSecret or AppCenter.configure first.");
                z = false;
            }
        }
        return z;
    }

    private synchronized void setInstanceWrapperSdk(WrapperSdk wrapperSdk) {
        Runnable runnable;
        WrapperSdk wrapperSdk2 = wrapperSdk;
        synchronized (this) {
            DeviceInfoHelper.setWrapperSdk(wrapperSdk2);
            if (this.mHandler != null) {
                new Runnable(this) {
                    final /* synthetic */ AppCenter this$0;

                    {
                        this.this$0 = this$0;
                    }

                    public void run() {
                        this.this$0.mChannel.invalidateDeviceCache();
                    }
                };
                boolean post = this.mHandler.post(runnable);
            }
        }
    }

    private synchronized void setInstanceLogLevel(int i) {
        int logLevel = i;
        synchronized (this) {
            this.mLogLevelConfigured = true;
            AppCenterLog.setLogLevel(logLevel);
        }
    }

    private synchronized void setInstanceLogUrl(String str) {
        Runnable runnable;
        String logUrl = str;
        synchronized (this) {
            this.mLogUrl = logUrl;
            if (this.mHandler != null) {
                final String str2 = logUrl;
                new Runnable(this) {
                    final /* synthetic */ AppCenter this$0;

                    {
                        this.this$0 = this$0;
                    }

                    public void run() {
                        StringBuilder sb;
                        StringBuilder sb2;
                        if (this.this$0.mAppSecret != null) {
                            new StringBuilder();
                            AppCenterLog.info("AppCenter", sb2.append("The log url of App Center endpoint has been changed to ").append(str2).toString());
                            this.this$0.mChannel.setLogUrl(str2);
                            return;
                        }
                        new StringBuilder();
                        AppCenterLog.info("AppCenter", sb.append("The log url of One Collector endpoint has been changed to ").append(str2).toString());
                        this.this$0.mOneCollectorChannelListener.setLogUrl(str2);
                    }
                };
                boolean post = this.mHandler.post(runnable);
            }
        }
    }

    private synchronized void setInstanceCustomProperties(CustomProperties customProperties) {
        Runnable runnable;
        CustomProperties customProperties2 = customProperties;
        synchronized (this) {
            if (customProperties2 == null) {
                AppCenterLog.error("AppCenter", "Custom properties may not be null.");
            } else {
                Map<String, Object> properties = customProperties2.getProperties();
                if (properties.size() == 0) {
                    AppCenterLog.error("AppCenter", "Custom properties may not be empty.");
                } else {
                    final Map<String, Object> map = properties;
                    new Runnable(this) {
                        final /* synthetic */ AppCenter this$0;

                        {
                            this.this$0 = this$0;
                        }

                        public void run() {
                            this.this$0.queueCustomProperties(map);
                        }
                    };
                    handlerAppCenterOperation(runnable, (Runnable) null);
                }
            }
        }
    }

    private synchronized AppCenterFuture<Boolean> setInstanceMaxStorageSizeAsync(long j) {
        DefaultAppCenterFuture<Boolean> defaultAppCenterFuture;
        DefaultAppCenterFuture<Boolean> defaultAppCenterFuture2;
        long storageSizeInBytes = j;
        synchronized (this) {
            new DefaultAppCenterFuture();
            DefaultAppCenterFuture<Boolean> setMaxStorageSizeFuture = defaultAppCenterFuture;
            if (this.mConfiguredFromApp) {
                AppCenterLog.error("AppCenter", "setMaxStorageSize may not be called after App Center has been configured.");
                setMaxStorageSizeFuture.complete(false);
                defaultAppCenterFuture2 = setMaxStorageSizeFuture;
            } else if (storageSizeInBytes < MINIMUM_STORAGE_SIZE) {
                AppCenterLog.error("AppCenter", "Maximum storage size must be at least 24576 bytes.");
                setMaxStorageSizeFuture.complete(false);
                defaultAppCenterFuture2 = setMaxStorageSizeFuture;
            } else if (this.mSetMaxStorageSizeFuture != null) {
                AppCenterLog.error("AppCenter", "setMaxStorageSize may only be called once per app launch.");
                setMaxStorageSizeFuture.complete(false);
                defaultAppCenterFuture2 = setMaxStorageSizeFuture;
            } else {
                this.mMaxStorageSizeInBytes = storageSizeInBytes;
                this.mSetMaxStorageSizeFuture = setMaxStorageSizeFuture;
                defaultAppCenterFuture2 = setMaxStorageSizeFuture;
            }
        }
        return defaultAppCenterFuture2;
    }

    private synchronized boolean isInstanceConfigured() {
        boolean z;
        synchronized (this) {
            z = this.mApplication != null;
        }
        return z;
    }

    private void configureInstanceWithRequiredAppSecret(Application application, String str) {
        Application application2 = application;
        String appSecret = str;
        if (appSecret == null || appSecret.isEmpty()) {
            AppCenterLog.error("AppCenter", "appSecret may not be null or empty.");
        } else {
            boolean configureInstance = configureInstance(application2, appSecret, true);
        }
    }

    private synchronized boolean configureInstance(Application application, String str, boolean z) {
        HandlerThread handlerThread;
        Handler handler;
        AppCenterHandler appCenterHandler;
        ApplicationLifecycleListener applicationLifecycleListener;
        Set<AppCenterService> set;
        Set<AppCenterService> set2;
        Runnable runnable;
        boolean z2;
        Runnable runnable2;
        Application application2 = application;
        String secretString = str;
        boolean configureFromApp = z;
        synchronized (this) {
            if (application2 == null) {
                AppCenterLog.error("AppCenter", "Application context may not be null.");
                z2 = false;
            } else {
                if (!this.mLogLevelConfigured && (application2.getApplicationInfo().flags & 2) == 2) {
                    AppCenterLog.setLogLevel(5);
                }
                String previousAppSecret = this.mAppSecret;
                if (configureFromApp && !configureSecretString(secretString)) {
                    z2 = false;
                } else if (this.mHandler != null) {
                    if (this.mAppSecret != null && !this.mAppSecret.equals(previousAppSecret)) {
                        new Runnable(this) {
                            final /* synthetic */ AppCenter this$0;

                            {
                                this.this$0 = this$0;
                            }

                            public void run() {
                                this.this$0.mChannel.setAppSecret(this.this$0.mAppSecret);
                                this.this$0.applyStorageMaxSize();
                            }
                        };
                        boolean post = this.mHandler.post(runnable2);
                    }
                    z2 = true;
                } else {
                    this.mApplication = application2;
                    new HandlerThread("AppCenter.Looper");
                    this.mHandlerThread = handlerThread;
                    this.mHandlerThread.start();
                    new Handler(this.mHandlerThread.getLooper());
                    this.mHandler = handler;
                    new AppCenterHandler(this) {
                        final /* synthetic */ AppCenter this$0;

                        {
                            this.this$0 = this$0;
                        }

                        public void post(@NonNull Runnable runnable, Runnable disabledRunnable) {
                            this.this$0.handlerAppCenterOperation(runnable, disabledRunnable);
                        }
                    };
                    this.mAppCenterHandler = appCenterHandler;
                    new ApplicationLifecycleListener(this.mHandler);
                    this.mApplicationLifecycleListener = applicationLifecycleListener;
                    this.mApplication.registerActivityLifecycleCallbacks(this.mApplicationLifecycleListener);
                    new HashSet();
                    this.mServices = set;
                    new HashSet();
                    this.mServicesStartedFromLibrary = set2;
                    final boolean z3 = configureFromApp;
                    new Runnable(this) {
                        final /* synthetic */ AppCenter this$0;

                        {
                            this.this$0 = this$0;
                        }

                        public void run() {
                            this.this$0.finishConfiguration(z3);
                        }
                    };
                    boolean post2 = this.mHandler.post(runnable);
                    AppCenterLog.info("AppCenter", "App Center SDK configured successfully.");
                    z2 = true;
                }
            }
        }
        return z2;
    }

    private boolean configureSecretString(String str) {
        String secretString = str;
        if (this.mConfiguredFromApp) {
            AppCenterLog.warn("AppCenter", "App Center may only be configured once.");
            return false;
        }
        this.mConfiguredFromApp = true;
        if (secretString != null) {
            String[] split = secretString.split(PAIR_DELIMITER);
            int length = split.length;
            for (int i = 0; i < length; i++) {
                String[] keyValue = split[i].split(KEY_VALUE_DELIMITER, -1);
                String key = keyValue[0];
                if (keyValue.length == 1) {
                    if (!key.isEmpty()) {
                        this.mAppSecret = key;
                    }
                } else if (!keyValue[1].isEmpty()) {
                    String value = keyValue[1];
                    if (APP_SECRET_KEY.equals(key)) {
                        this.mAppSecret = value;
                    } else if (TRANSMISSION_TARGET_TOKEN_KEY.equals(key)) {
                        this.mTransmissionTargetToken = value;
                    }
                }
            }
        }
        return true;
    }

    /* access modifiers changed from: private */
    public synchronized void handlerAppCenterOperation(Runnable runnable, Runnable runnable2) {
        Runnable runnable3;
        Runnable runnable4 = runnable;
        Runnable disabledRunnable = runnable2;
        synchronized (this) {
            if (checkPrecondition()) {
                final Runnable runnable5 = runnable4;
                final Runnable runnable6 = disabledRunnable;
                new Runnable(this) {
                    final /* synthetic */ AppCenter this$0;

                    {
                        this.this$0 = this$0;
                    }

                    public void run() {
                        if (this.this$0.isInstanceEnabled()) {
                            runnable5.run();
                        } else if (runnable6 != null) {
                            runnable6.run();
                        } else {
                            AppCenterLog.error("AppCenter", "App Center SDK is disabled.");
                        }
                    }
                };
                Runnable wrapperRunnable = runnable3;
                if (Thread.currentThread() == this.mHandlerThread) {
                    runnable4.run();
                } else {
                    boolean post = this.mHandler.post(wrapperRunnable);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public void finishConfiguration(boolean z) {
        LogSerializer logSerializer;
        LogFactory logFactory;
        LogFactory logFactory2;
        Channel channel;
        OneCollectorChannelListener oneCollectorChannelListener;
        UncaughtExceptionHandler uncaughtExceptionHandler;
        StringBuilder sb;
        StringBuilder sb2;
        boolean configureFromApp = z;
        Constants.loadFromContext(this.mApplication);
        FileManager.initialize(this.mApplication);
        SharedPreferencesManager.initialize(this.mApplication);
        SessionContext instance = SessionContext.getInstance();
        boolean enabled = isInstanceEnabled();
        HttpClient httpClient = DependencyConfiguration.getHttpClient();
        if (httpClient == null) {
            httpClient = HttpUtils.createHttpClient(this.mApplication);
        }
        new DefaultLogSerializer();
        this.mLogSerializer = logSerializer;
        new StartServiceLogFactory();
        this.mLogSerializer.addLogFactory(StartServiceLog.TYPE, logFactory);
        new CustomPropertiesLogFactory();
        this.mLogSerializer.addLogFactory(CustomPropertiesLog.TYPE, logFactory2);
        new DefaultChannel((Context) this.mApplication, this.mAppSecret, this.mLogSerializer, httpClient, this.mHandler);
        this.mChannel = channel;
        if (configureFromApp) {
            applyStorageMaxSize();
        } else {
            boolean maxStorageSize = this.mChannel.setMaxStorageSize(DEFAULT_MAX_STORAGE_SIZE_IN_BYTES);
        }
        this.mChannel.setEnabled(enabled);
        this.mChannel.addGroup(CORE_GROUP, 50, 3000, 3, (Ingestion) null, (Channel.GroupListener) null);
        new OneCollectorChannelListener(this.mChannel, this.mLogSerializer, httpClient, IdHelper.getInstallId());
        this.mOneCollectorChannelListener = oneCollectorChannelListener;
        if (this.mLogUrl != null) {
            if (this.mAppSecret != null) {
                new StringBuilder();
                AppCenterLog.info("AppCenter", sb2.append("The log url of App Center endpoint has been changed to ").append(this.mLogUrl).toString());
                this.mChannel.setLogUrl(this.mLogUrl);
            } else {
                new StringBuilder();
                AppCenterLog.info("AppCenter", sb.append("The log url of One Collector endpoint has been changed to ").append(this.mLogUrl).toString());
                this.mOneCollectorChannelListener.setLogUrl(this.mLogUrl);
            }
        }
        this.mChannel.addListener(this.mOneCollectorChannelListener);
        if (!enabled) {
            NetworkStateHelper.getSharedInstance(this.mApplication).close();
        }
        new UncaughtExceptionHandler(this.mHandler, this.mChannel);
        this.mUncaughtExceptionHandler = uncaughtExceptionHandler;
        if (enabled) {
            this.mUncaughtExceptionHandler.register();
        }
        AppCenterLog.debug("AppCenter", "App Center initialized.");
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public void applyStorageMaxSize() {
        boolean resizeResult = this.mChannel.setMaxStorageSize(this.mMaxStorageSizeInBytes);
        if (this.mSetMaxStorageSizeFuture != null) {
            this.mSetMaxStorageSizeFuture.complete(Boolean.valueOf(resizeResult));
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v36, resolved type: java.lang.StringBuilder} */
    /* JADX WARNING: Multi-variable type inference failed */
    @java.lang.SafeVarargs
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final synchronized void startServices(boolean r20, java.lang.Class<? extends com.microsoft.appcenter.AppCenterService>... r21) {
        /*
            r19 = this;
            r0 = r19
            r1 = r20
            r2 = r21
            r17 = r19
            monitor-enter(r17)
            r10 = r2
            if (r10 != 0) goto L_0x0017
            java.lang.String r10 = "AppCenter"
            java.lang.String r11 = "Cannot start services, services array is null. Failed to start services."
            com.microsoft.appcenter.utils.AppCenterLog.error(r10, r11)     // Catch:{ all -> 0x00fb }
        L_0x0015:
            monitor-exit(r17)
            return
        L_0x0017:
            r10 = r0
            android.app.Application r10 = r10.mApplication     // Catch:{ all -> 0x00fb }
            if (r10 != 0) goto L_0x0075
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ all -> 0x00fb }
            r18 = r10
            r10 = r18
            r11 = r18
            r11.<init>()     // Catch:{ all -> 0x00fb }
            r3 = r10
            r10 = r2
            r4 = r10
            r10 = r4
            int r10 = r10.length     // Catch:{ all -> 0x00fb }
            r5 = r10
            r10 = 0
            r6 = r10
        L_0x002f:
            r10 = r6
            r11 = r5
            if (r10 >= r11) goto L_0x0053
            r10 = r4
            r11 = r6
            r10 = r10[r11]     // Catch:{ all -> 0x00fb }
            r7 = r10
            r10 = r3
            java.lang.String r11 = "\t"
            java.lang.StringBuilder r10 = r10.append(r11)     // Catch:{ all -> 0x00fb }
            r11 = r7
            java.lang.String r11 = r11.getName()     // Catch:{ all -> 0x00fb }
            java.lang.StringBuilder r10 = r10.append(r11)     // Catch:{ all -> 0x00fb }
            java.lang.String r11 = "\n"
            java.lang.StringBuilder r10 = r10.append(r11)     // Catch:{ all -> 0x00fb }
            int r6 = r6 + 1
            goto L_0x002f
        L_0x0053:
            java.lang.String r10 = "AppCenter"
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ all -> 0x00fb }
            r18 = r11
            r11 = r18
            r12 = r18
            r12.<init>()     // Catch:{ all -> 0x00fb }
            java.lang.String r12 = "Cannot start services, App Center has not been configured. Failed to start the following services:\n"
            java.lang.StringBuilder r11 = r11.append(r12)     // Catch:{ all -> 0x00fb }
            r12 = r3
            java.lang.StringBuilder r11 = r11.append(r12)     // Catch:{ all -> 0x00fb }
            java.lang.String r11 = r11.toString()     // Catch:{ all -> 0x00fb }
            com.microsoft.appcenter.utils.AppCenterLog.error(r10, r11)     // Catch:{ all -> 0x00fb }
            goto L_0x0015
        L_0x0075:
            java.util.ArrayList r10 = new java.util.ArrayList     // Catch:{ all -> 0x00fb }
            r18 = r10
            r10 = r18
            r11 = r18
            r11.<init>()     // Catch:{ all -> 0x00fb }
            r3 = r10
            java.util.ArrayList r10 = new java.util.ArrayList     // Catch:{ all -> 0x00fb }
            r18 = r10
            r10 = r18
            r11 = r18
            r11.<init>()     // Catch:{ all -> 0x00fb }
            r4 = r10
            r10 = r2
            r5 = r10
            r10 = r5
            int r10 = r10.length     // Catch:{ all -> 0x00fb }
            r6 = r10
            r10 = 0
            r7 = r10
        L_0x0094:
            r10 = r7
            r11 = r6
            if (r10 >= r11) goto L_0x00fe
            r10 = r5
            r11 = r7
            r10 = r10[r11]     // Catch:{ all -> 0x00fb }
            r8 = r10
            r10 = r8
            if (r10 != 0) goto L_0x00ac
            java.lang.String r10 = "AppCenter"
            java.lang.String r11 = "Skipping null service, please check your varargs/array does not contain any null reference."
            com.microsoft.appcenter.utils.AppCenterLog.warn(r10, r11)     // Catch:{ all -> 0x00fb }
        L_0x00a9:
            int r7 = r7 + 1
            goto L_0x0094
        L_0x00ac:
            r10 = r8
            java.lang.String r11 = "getInstance"
            r12 = 0
            java.lang.Class[] r12 = new java.lang.Class[r12]     // Catch:{ Exception -> 0x00cb }
            java.lang.reflect.Method r10 = r10.getMethod(r11, r12)     // Catch:{ Exception -> 0x00cb }
            r11 = 0
            r12 = 0
            java.lang.Object[] r12 = new java.lang.Object[r12]     // Catch:{ Exception -> 0x00cb }
            java.lang.Object r10 = r10.invoke(r11, r12)     // Catch:{ Exception -> 0x00cb }
            com.microsoft.appcenter.AppCenterService r10 = (com.microsoft.appcenter.AppCenterService) r10     // Catch:{ Exception -> 0x00cb }
            r9 = r10
            r10 = r0
            r11 = r9
            r12 = r3
            r13 = r4
            r14 = r1
            r10.startOrUpdateService(r11, r12, r13, r14)     // Catch:{ Exception -> 0x00cb }
            goto L_0x00a9
        L_0x00cb:
            r10 = move-exception
            r9 = r10
            java.lang.String r10 = "AppCenter"
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ all -> 0x00fb }
            r18 = r11
            r11 = r18
            r12 = r18
            r12.<init>()     // Catch:{ all -> 0x00fb }
            java.lang.String r12 = "Failed to get service instance '"
            java.lang.StringBuilder r11 = r11.append(r12)     // Catch:{ all -> 0x00fb }
            r12 = r8
            java.lang.String r12 = r12.getName()     // Catch:{ all -> 0x00fb }
            java.lang.StringBuilder r11 = r11.append(r12)     // Catch:{ all -> 0x00fb }
            java.lang.String r12 = "', skipping it."
            java.lang.StringBuilder r11 = r11.append(r12)     // Catch:{ all -> 0x00fb }
            java.lang.String r11 = r11.toString()     // Catch:{ all -> 0x00fb }
            r12 = r9
            com.microsoft.appcenter.utils.AppCenterLog.error(r10, r11, r12)     // Catch:{ all -> 0x00fb }
            goto L_0x00a9
        L_0x00fb:
            r0 = move-exception
            monitor-exit(r17)
            throw r0
        L_0x00fe:
            r10 = r0
            android.os.Handler r10 = r10.mHandler     // Catch:{ all -> 0x00fb }
            com.microsoft.appcenter.AppCenter$8 r11 = new com.microsoft.appcenter.AppCenter$8     // Catch:{ all -> 0x00fb }
            r18 = r11
            r11 = r18
            r12 = r18
            r13 = r0
            r14 = r4
            r15 = r3
            r16 = r1
            r12.<init>(r13, r14, r15, r16)     // Catch:{ all -> 0x00fb }
            boolean r10 = r10.post(r11)     // Catch:{ all -> 0x00fb }
            goto L_0x0015
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microsoft.appcenter.AppCenter.startServices(boolean, java.lang.Class[]):void");
    }

    private void startOrUpdateService(AppCenterService appCenterService, Collection<AppCenterService> collection, Collection<AppCenterService> collection2, boolean startFromApp) {
        AppCenterService serviceInstance = appCenterService;
        Collection<AppCenterService> startedServices = collection;
        Collection<AppCenterService> updatedServices = collection2;
        if (startFromApp) {
            startOrUpdateServiceFromApp(serviceInstance, startedServices, updatedServices);
        } else if (!this.mServices.contains(serviceInstance)) {
            startServiceFromLibrary(serviceInstance, startedServices);
        }
    }

    private void startOrUpdateServiceFromApp(AppCenterService appCenterService, Collection<AppCenterService> collection, Collection<AppCenterService> collection2) {
        StringBuilder sb;
        StringBuilder sb2;
        AppCenterService serviceInstance = appCenterService;
        Collection<AppCenterService> startedServices = collection;
        Collection<AppCenterService> updatedServices = collection2;
        String serviceName = serviceInstance.getServiceName();
        if (this.mServices.contains(serviceInstance)) {
            if (this.mServicesStartedFromLibrary.remove(serviceInstance)) {
                boolean add = updatedServices.add(serviceInstance);
                return;
            }
            new StringBuilder();
            AppCenterLog.warn("AppCenter", sb2.append("App Center has already started the service with class name: ").append(serviceInstance.getServiceName()).toString());
        } else if (this.mAppSecret != null || !serviceInstance.isAppSecretRequired()) {
            boolean startService = startService(serviceInstance, startedServices);
        } else {
            new StringBuilder();
            AppCenterLog.error("AppCenter", sb.append("App Center was started without app secret, but the service requires it; not starting service ").append(serviceName).append(".").toString());
        }
    }

    private void startServiceFromLibrary(AppCenterService appCenterService, Collection<AppCenterService> collection) {
        StringBuilder sb;
        AppCenterService serviceInstance = appCenterService;
        Collection<AppCenterService> startedServices = collection;
        String serviceName = serviceInstance.getServiceName();
        if (serviceInstance.isAppSecretRequired()) {
            new StringBuilder();
            AppCenterLog.error("AppCenter", sb.append("This service cannot be started from a library: ").append(serviceName).append(".").toString());
        } else if (startService(serviceInstance, startedServices)) {
            boolean add = this.mServicesStartedFromLibrary.add(serviceInstance);
        }
    }

    private boolean startService(AppCenterService appCenterService, Collection<AppCenterService> collection) {
        StringBuilder sb;
        AppCenterService serviceInstance = appCenterService;
        Collection<AppCenterService> startedServices = collection;
        String serviceName = serviceInstance.getServiceName();
        if (ServiceInstrumentationUtils.isServiceDisabledByInstrumentation(serviceName)) {
            new StringBuilder();
            AppCenterLog.debug("AppCenter", sb.append("Instrumentation variable to disable service has been set; not starting service ").append(serviceName).append(".").toString());
            return false;
        }
        serviceInstance.onStarting(this.mAppCenterHandler);
        this.mApplicationLifecycleListener.registerApplicationLifecycleCallbacks(serviceInstance);
        this.mApplication.registerActivityLifecycleCallbacks(serviceInstance);
        boolean add = this.mServices.add(serviceInstance);
        boolean add2 = startedServices.add(serviceInstance);
        return true;
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public void finishStartServices(Iterable<AppCenterService> iterable, Iterable<AppCenterService> iterable2, boolean z) {
        StringBuilder sb;
        StringBuilder sb2;
        StringBuilder sb3;
        Iterable<AppCenterService> updatedServices = iterable;
        Iterable<AppCenterService> startedServices = iterable2;
        boolean startFromApp = z;
        for (AppCenterService service : updatedServices) {
            service.onConfigurationUpdated(this.mAppSecret, this.mTransmissionTargetToken);
            new StringBuilder();
            AppCenterLog.info("AppCenter", sb3.append(service.getClass().getSimpleName()).append(" service configuration updated.").toString());
        }
        boolean enabled = isInstanceEnabled();
        for (AppCenterService service2 : startedServices) {
            Map<String, LogFactory> logFactories = service2.getLogFactories();
            if (logFactories != null) {
                for (Map.Entry<String, LogFactory> logFactory : logFactories.entrySet()) {
                    this.mLogSerializer.addLogFactory(logFactory.getKey(), logFactory.getValue());
                }
            }
            if (!enabled && service2.isInstanceEnabled()) {
                service2.setInstanceEnabled(false);
            }
            if (startFromApp) {
                service2.onStarted(this.mApplication, this.mChannel, this.mAppSecret, this.mTransmissionTargetToken, true);
                new StringBuilder();
                AppCenterLog.info("AppCenter", sb2.append(service2.getClass().getSimpleName()).append(" service started from application.").toString());
            } else {
                service2.onStarted(this.mApplication, this.mChannel, (String) null, (String) null, false);
                new StringBuilder();
                AppCenterLog.info("AppCenter", sb.append(service2.getClass().getSimpleName()).append(" service started from library.").toString());
            }
        }
        if (startFromApp) {
            for (AppCenterService service3 : updatedServices) {
                boolean add = this.mStartedServicesNamesToLog.add(service3.getServiceName());
            }
            for (AppCenterService service4 : startedServices) {
                boolean add2 = this.mStartedServicesNamesToLog.add(service4.getServiceName());
            }
            sendStartServiceLog();
        }
    }

    @WorkerThread
    private void sendStartServiceLog() {
        List list;
        StartServiceLog startServiceLog;
        if (!this.mStartedServicesNamesToLog.isEmpty() && isInstanceEnabled()) {
            new ArrayList(this.mStartedServicesNamesToLog);
            this.mStartedServicesNamesToLog.clear();
            new StartServiceLog();
            StartServiceLog startServiceLog2 = startServiceLog;
            startServiceLog2.setServices(list);
            this.mChannel.enqueue(startServiceLog2, CORE_GROUP, 1);
        }
    }

    private synchronized void configureAndStartServices(Application application, String str, Class<? extends AppCenterService>[] clsArr) {
        Application application2 = application;
        String appSecret = str;
        Class<? extends AppCenterService>[] services = clsArr;
        synchronized (this) {
            if (appSecret != null) {
                if (!appSecret.isEmpty()) {
                    configureAndStartServices(application2, appSecret, true, services);
                }
            }
            AppCenterLog.error("AppCenter", "appSecret may not be null or empty.");
        }
    }

    private synchronized void startInstanceFromLibrary(Context context, Class<? extends AppCenterService>[] clsArr) {
        Context context2 = context;
        Class<? extends AppCenterService>[] services = clsArr;
        synchronized (this) {
            configureAndStartServices(context2 != null ? (Application) context2.getApplicationContext() : null, (String) null, false, services);
        }
    }

    private void configureAndStartServices(Application application, String appSecret, boolean z, Class<? extends AppCenterService>[] clsArr) {
        boolean startFromApp = z;
        Class<? extends AppCenterService>[] services = clsArr;
        if (configureInstance(application, appSecret, startFromApp)) {
            startServices(startFromApp, services);
        }
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public void queueCustomProperties(@NonNull Map<String, Object> properties) {
        CustomPropertiesLog customPropertiesLog;
        new CustomPropertiesLog();
        CustomPropertiesLog customPropertiesLog2 = customPropertiesLog;
        customPropertiesLog2.setProperties(properties);
        this.mChannel.enqueue(customPropertiesLog2, CORE_GROUP, 1);
    }

    private synchronized AppCenterFuture<Boolean> isInstanceEnabledAsync() {
        DefaultAppCenterFuture defaultAppCenterFuture;
        DefaultAppCenterFuture defaultAppCenterFuture2;
        Runnable runnable;
        Runnable runnable2;
        synchronized (this) {
            new DefaultAppCenterFuture();
            DefaultAppCenterFuture defaultAppCenterFuture3 = defaultAppCenterFuture;
            if (checkPrecondition()) {
                final DefaultAppCenterFuture defaultAppCenterFuture4 = defaultAppCenterFuture3;
                new Runnable(this) {
                    final /* synthetic */ AppCenter this$0;

                    {
                        this.this$0 = this$0;
                    }

                    public void run() {
                        defaultAppCenterFuture4.complete(true);
                    }
                };
                final DefaultAppCenterFuture defaultAppCenterFuture5 = defaultAppCenterFuture3;
                new Runnable(this) {
                    final /* synthetic */ AppCenter this$0;

                    {
                        this.this$0 = this$0;
                    }

                    public void run() {
                        defaultAppCenterFuture5.complete(false);
                    }
                };
                this.mAppCenterHandler.post(runnable, runnable2);
            } else {
                defaultAppCenterFuture3.complete(false);
            }
            defaultAppCenterFuture2 = defaultAppCenterFuture3;
        }
        return defaultAppCenterFuture2;
    }

    /* access modifiers changed from: package-private */
    public boolean isInstanceEnabled() {
        return SharedPreferencesManager.getBoolean(PrefStorageConstants.KEY_ENABLED, true);
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public void setInstanceEnabled(boolean z) {
        StringBuilder sb;
        boolean enabled = z;
        this.mChannel.setEnabled(enabled);
        boolean previouslyEnabled = isInstanceEnabled();
        boolean switchToDisabled = previouslyEnabled && !enabled;
        boolean switchToEnabled = !previouslyEnabled && enabled;
        if (switchToEnabled) {
            this.mUncaughtExceptionHandler.register();
            NetworkStateHelper.getSharedInstance(this.mApplication).reopen();
        } else if (switchToDisabled) {
            this.mUncaughtExceptionHandler.unregister();
            NetworkStateHelper.getSharedInstance(this.mApplication).close();
        }
        if (enabled) {
            SharedPreferencesManager.putBoolean(PrefStorageConstants.KEY_ENABLED, true);
        }
        if (!this.mStartedServicesNamesToLog.isEmpty() && switchToEnabled) {
            sendStartServiceLog();
        }
        for (AppCenterService service : this.mServices) {
            if (service.isInstanceEnabled() != enabled) {
                service.setInstanceEnabled(enabled);
            }
        }
        if (!enabled) {
            SharedPreferencesManager.putBoolean(PrefStorageConstants.KEY_ENABLED, false);
        }
        if (switchToDisabled) {
            AppCenterLog.info("AppCenter", "App Center has been disabled.");
        } else if (switchToEnabled) {
            AppCenterLog.info("AppCenter", "App Center has been enabled.");
        } else {
            new StringBuilder();
            AppCenterLog.info("AppCenter", sb.append("App Center has already been ").append(enabled ? PrefStorageConstants.KEY_ENABLED : "disabled").append(".").toString());
        }
    }

    private synchronized AppCenterFuture<Void> setInstanceEnabledAsync(boolean z) {
        DefaultAppCenterFuture defaultAppCenterFuture;
        DefaultAppCenterFuture defaultAppCenterFuture2;
        Runnable runnable;
        boolean enabled = z;
        synchronized (this) {
            new DefaultAppCenterFuture();
            DefaultAppCenterFuture defaultAppCenterFuture3 = defaultAppCenterFuture;
            if (checkPrecondition()) {
                final boolean z2 = enabled;
                final DefaultAppCenterFuture defaultAppCenterFuture4 = defaultAppCenterFuture3;
                new Runnable(this) {
                    final /* synthetic */ AppCenter this$0;

                    {
                        this.this$0 = this$0;
                    }

                    public void run() {
                        this.this$0.setInstanceEnabled(z2);
                        defaultAppCenterFuture4.complete(null);
                    }
                };
                boolean post = this.mHandler.post(runnable);
            } else {
                defaultAppCenterFuture3.complete(null);
            }
            defaultAppCenterFuture2 = defaultAppCenterFuture3;
        }
        return defaultAppCenterFuture2;
    }

    private synchronized AppCenterFuture<UUID> getInstanceInstallIdAsync() {
        DefaultAppCenterFuture defaultAppCenterFuture;
        DefaultAppCenterFuture defaultAppCenterFuture2;
        Runnable runnable;
        Runnable runnable2;
        synchronized (this) {
            new DefaultAppCenterFuture();
            DefaultAppCenterFuture defaultAppCenterFuture3 = defaultAppCenterFuture;
            if (checkPrecondition()) {
                final DefaultAppCenterFuture defaultAppCenterFuture4 = defaultAppCenterFuture3;
                new Runnable(this) {
                    final /* synthetic */ AppCenter this$0;

                    {
                        this.this$0 = this$0;
                    }

                    public void run() {
                        defaultAppCenterFuture4.complete(IdHelper.getInstallId());
                    }
                };
                final DefaultAppCenterFuture defaultAppCenterFuture5 = defaultAppCenterFuture3;
                new Runnable(this) {
                    final /* synthetic */ AppCenter this$0;

                    {
                        this.this$0 = this$0;
                    }

                    public void run() {
                        defaultAppCenterFuture5.complete(null);
                    }
                };
                this.mAppCenterHandler.post(runnable, runnable2);
            } else {
                defaultAppCenterFuture3.complete(null);
            }
            defaultAppCenterFuture2 = defaultAppCenterFuture3;
        }
        return defaultAppCenterFuture2;
    }

    public static void setUserId(String userId) {
        getInstance().setInstanceUserId(userId);
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public Set<AppCenterService> getServices() {
        return this.mServices;
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public Application getApplication() {
        return this.mApplication;
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public UncaughtExceptionHandler getUncaughtExceptionHandler() {
        return this.mUncaughtExceptionHandler;
    }

    @VisibleForTesting
    public void setChannel(Channel channel) {
        Channel channel2 = channel;
        this.mChannel = channel2;
    }
}
