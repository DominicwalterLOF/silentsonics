package com.microsoft.appcenter.crashes;

import android.annotation.SuppressLint;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import android.support.annotation.WorkerThread;
import com.microsoft.appcenter.AbstractAppCenterService;
import com.microsoft.appcenter.Constants;
import com.microsoft.appcenter.channel.Channel;
import com.microsoft.appcenter.crashes.ingestion.models.ErrorAttachmentLog;
import com.microsoft.appcenter.crashes.ingestion.models.Exception;
import com.microsoft.appcenter.crashes.ingestion.models.HandledErrorLog;
import com.microsoft.appcenter.crashes.ingestion.models.ManagedErrorLog;
import com.microsoft.appcenter.crashes.ingestion.models.json.ErrorAttachmentLogFactory;
import com.microsoft.appcenter.crashes.ingestion.models.json.HandledErrorLogFactory;
import com.microsoft.appcenter.crashes.ingestion.models.json.ManagedErrorLogFactory;
import com.microsoft.appcenter.crashes.model.ErrorReport;
import com.microsoft.appcenter.crashes.model.NativeException;
import com.microsoft.appcenter.crashes.model.TestCrashException;
import com.microsoft.appcenter.crashes.utils.ErrorLogHelper;
import com.microsoft.appcenter.ingestion.models.Device;
import com.microsoft.appcenter.ingestion.models.Log;
import com.microsoft.appcenter.ingestion.models.json.DefaultLogSerializer;
import com.microsoft.appcenter.ingestion.models.json.LogFactory;
import com.microsoft.appcenter.ingestion.models.json.LogSerializer;
import com.microsoft.appcenter.utils.AppCenterLog;
import com.microsoft.appcenter.utils.DeviceInfoHelper;
import com.microsoft.appcenter.utils.HandlerUtils;
import com.microsoft.appcenter.utils.async.AppCenterFuture;
import com.microsoft.appcenter.utils.async.DefaultAppCenterFuture;
import com.microsoft.appcenter.utils.context.SessionContext;
import com.microsoft.appcenter.utils.context.UserIdContext;
import com.microsoft.appcenter.utils.storage.FileManager;
import com.microsoft.appcenter.utils.storage.SharedPreferencesManager;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import org.json.JSONException;

public class Crashes extends AbstractAppCenterService {
    public static final int ALWAYS_SEND = 2;
    private static final CrashesListener DEFAULT_ERROR_REPORTING_LISTENER;
    public static final int DONT_SEND = 1;
    @VisibleForTesting
    static final String ERROR_GROUP = "groupErrors";
    public static final String LOG_TAG = "AppCenterCrashes";
    private static final int MAX_ATTACHMENT_SIZE = 7340032;
    @VisibleForTesting
    public static final String PREF_KEY_ALWAYS_SEND = "com.microsoft.appcenter.crashes.always.send";
    @VisibleForTesting
    static final String PREF_KEY_MEMORY_RUNNING_LEVEL = "com.microsoft.appcenter.crashes.memory";
    public static final int SEND = 0;
    private static final String SERVICE_NAME = "Crashes";
    @SuppressLint({"StaticFieldLeak"})
    private static Crashes sInstance = null;
    /* access modifiers changed from: private */
    public boolean mAutomaticProcessing = true;
    /* access modifiers changed from: private */
    public Context mContext;
    /* access modifiers changed from: private */
    public CrashesListener mCrashesListener;
    private Device mDevice;
    private final Map<UUID, ErrorLogReport> mErrorReportCache;
    private final Map<String, LogFactory> mFactories;
    /* access modifiers changed from: private */
    public boolean mHasReceivedMemoryWarningInLastSession;
    private long mInitializeTimestamp;
    /* access modifiers changed from: private */
    public ErrorReport mLastSessionErrorReport;
    private LogSerializer mLogSerializer;
    private ComponentCallbacks2 mMemoryWarningListener;
    private boolean mSavedUncaughtException;
    private UncaughtExceptionHandler mUncaughtExceptionHandler;
    /* access modifiers changed from: private */
    public final Map<UUID, ErrorLogReport> mUnprocessedErrorReports;

    private interface CallbackProcessor {
        void onCallBack(ErrorReport errorReport);

        boolean shouldDeleteThrowable();
    }

    private interface ExceptionModelBuilder {
        Exception buildExceptionModel();
    }

    static {
        CrashesListener crashesListener;
        new DefaultCrashesListener((AnonymousClass1) null);
        DEFAULT_ERROR_REPORTING_LISTENER = crashesListener;
    }

    private Crashes() {
        Map<String, LogFactory> map;
        LogSerializer logSerializer;
        Map<UUID, ErrorLogReport> map2;
        Map<UUID, ErrorLogReport> map3;
        new HashMap();
        this.mFactories = map;
        LogFactory put = this.mFactories.put(ManagedErrorLog.TYPE, ManagedErrorLogFactory.getInstance());
        LogFactory put2 = this.mFactories.put(HandledErrorLog.TYPE, HandledErrorLogFactory.getInstance());
        LogFactory put3 = this.mFactories.put(ErrorAttachmentLog.TYPE, ErrorAttachmentLogFactory.getInstance());
        new DefaultLogSerializer();
        this.mLogSerializer = logSerializer;
        this.mLogSerializer.addLogFactory(ManagedErrorLog.TYPE, ManagedErrorLogFactory.getInstance());
        this.mLogSerializer.addLogFactory(ErrorAttachmentLog.TYPE, ErrorAttachmentLogFactory.getInstance());
        this.mCrashesListener = DEFAULT_ERROR_REPORTING_LISTENER;
        new LinkedHashMap();
        this.mUnprocessedErrorReports = map2;
        new LinkedHashMap();
        this.mErrorReportCache = map3;
    }

    @NonNull
    public static synchronized Crashes getInstance() {
        Crashes crashes;
        Crashes crashes2;
        synchronized (Crashes.class) {
            if (sInstance == null) {
                new Crashes();
                sInstance = crashes2;
            }
            crashes = sInstance;
        }
        return crashes;
    }

    @VisibleForTesting
    static synchronized void unsetInstance() {
        synchronized (Crashes.class) {
            sInstance = null;
        }
    }

    public static AppCenterFuture<Boolean> isEnabled() {
        return getInstance().isInstanceEnabledAsync();
    }

    public static AppCenterFuture<Void> setEnabled(boolean enabled) {
        return getInstance().setInstanceEnabledAsync(enabled);
    }

    public static void trackError(Throwable throwable) {
        trackError(throwable, (Map<String, String>) null, (Iterable<ErrorAttachmentLog>) null);
    }

    public static void trackError(Throwable throwable, Map<String, String> properties, Iterable<ErrorAttachmentLog> attachments) {
        getInstance().queueException(throwable, properties, attachments);
    }

    public static void generateTestCrash() {
        Throwable th;
        if (Constants.APPLICATION_DEBUGGABLE) {
            Throwable th2 = th;
            new TestCrashException();
            throw th2;
        }
        AppCenterLog.warn(LOG_TAG, "The application is not debuggable so SDK won't generate test crash");
    }

    public static void setListener(CrashesListener listener) {
        getInstance().setInstanceListener(listener);
    }

    public static AppCenterFuture<String> getMinidumpDirectory() {
        return getInstance().getNewMinidumpDirectoryAsync();
    }

    public static void notifyUserConfirmation(int userConfirmation) {
        getInstance().handleUserConfirmation(userConfirmation);
    }

    public static AppCenterFuture<Boolean> hasCrashedInLastSession() {
        return getInstance().hasInstanceCrashedInLastSession();
    }

    public static AppCenterFuture<ErrorReport> getLastSessionCrashReport() {
        return getInstance().getInstanceLastSessionCrashReport();
    }

    public static AppCenterFuture<Boolean> hasReceivedMemoryWarningInLastSession() {
        return getInstance().hasInstanceReceivedMemoryWarningInLastSession();
    }

    private synchronized AppCenterFuture<String> getNewMinidumpDirectoryAsync() {
        DefaultAppCenterFuture defaultAppCenterFuture;
        Runnable runnable;
        DefaultAppCenterFuture defaultAppCenterFuture2;
        synchronized (this) {
            new DefaultAppCenterFuture();
            DefaultAppCenterFuture defaultAppCenterFuture3 = defaultAppCenterFuture;
            final DefaultAppCenterFuture defaultAppCenterFuture4 = defaultAppCenterFuture3;
            new Runnable(this) {
                final /* synthetic */ Crashes this$0;

                {
                    this.this$0 = this$0;
                }

                public void run() {
                    defaultAppCenterFuture4.complete(ErrorLogHelper.getNewMinidumpSubfolderWithContextData(this.this$0.mContext).getAbsolutePath());
                }
            };
            postAsyncGetter(runnable, defaultAppCenterFuture3, null);
            defaultAppCenterFuture2 = defaultAppCenterFuture3;
        }
        return defaultAppCenterFuture2;
    }

    private synchronized AppCenterFuture<Boolean> hasInstanceCrashedInLastSession() {
        DefaultAppCenterFuture defaultAppCenterFuture;
        Runnable runnable;
        DefaultAppCenterFuture defaultAppCenterFuture2;
        synchronized (this) {
            new DefaultAppCenterFuture();
            DefaultAppCenterFuture defaultAppCenterFuture3 = defaultAppCenterFuture;
            final DefaultAppCenterFuture defaultAppCenterFuture4 = defaultAppCenterFuture3;
            new Runnable(this) {
                final /* synthetic */ Crashes this$0;

                {
                    this.this$0 = this$0;
                }

                public void run() {
                    defaultAppCenterFuture4.complete(Boolean.valueOf(this.this$0.mLastSessionErrorReport != null));
                }
            };
            postAsyncGetter(runnable, defaultAppCenterFuture3, false);
            defaultAppCenterFuture2 = defaultAppCenterFuture3;
        }
        return defaultAppCenterFuture2;
    }

    private synchronized AppCenterFuture<Boolean> hasInstanceReceivedMemoryWarningInLastSession() {
        DefaultAppCenterFuture defaultAppCenterFuture;
        Runnable runnable;
        DefaultAppCenterFuture defaultAppCenterFuture2;
        synchronized (this) {
            new DefaultAppCenterFuture();
            DefaultAppCenterFuture defaultAppCenterFuture3 = defaultAppCenterFuture;
            final DefaultAppCenterFuture defaultAppCenterFuture4 = defaultAppCenterFuture3;
            new Runnable(this) {
                final /* synthetic */ Crashes this$0;

                {
                    this.this$0 = this$0;
                }

                public void run() {
                    defaultAppCenterFuture4.complete(Boolean.valueOf(this.this$0.mHasReceivedMemoryWarningInLastSession));
                }
            };
            postAsyncGetter(runnable, defaultAppCenterFuture3, false);
            defaultAppCenterFuture2 = defaultAppCenterFuture3;
        }
        return defaultAppCenterFuture2;
    }

    private synchronized AppCenterFuture<ErrorReport> getInstanceLastSessionCrashReport() {
        DefaultAppCenterFuture defaultAppCenterFuture;
        Runnable runnable;
        DefaultAppCenterFuture defaultAppCenterFuture2;
        synchronized (this) {
            new DefaultAppCenterFuture();
            DefaultAppCenterFuture defaultAppCenterFuture3 = defaultAppCenterFuture;
            final DefaultAppCenterFuture defaultAppCenterFuture4 = defaultAppCenterFuture3;
            new Runnable(this) {
                final /* synthetic */ Crashes this$0;

                {
                    this.this$0 = this$0;
                }

                public void run() {
                    defaultAppCenterFuture4.complete(this.this$0.mLastSessionErrorReport);
                }
            };
            postAsyncGetter(runnable, defaultAppCenterFuture3, null);
            defaultAppCenterFuture2 = defaultAppCenterFuture3;
        }
        return defaultAppCenterFuture2;
    }

    /* access modifiers changed from: protected */
    public synchronized void applyEnabledState(boolean z) {
        StringBuilder sb;
        StringBuilder sb2;
        ComponentCallbacks2 componentCallbacks2;
        boolean enabled = z;
        synchronized (this) {
            initialize();
            if (enabled) {
                new ComponentCallbacks2(this) {
                    final /* synthetic */ Crashes this$0;

                    {
                        this.this$0 = this$0;
                    }

                    public void onTrimMemory(int level) {
                        Crashes.saveMemoryRunningLevel(level);
                    }

                    public void onConfigurationChanged(@NonNull Configuration newConfig) {
                    }

                    public void onLowMemory() {
                        Crashes.saveMemoryRunningLevel(80);
                    }
                };
                this.mMemoryWarningListener = componentCallbacks2;
                this.mContext.registerComponentCallbacks(this.mMemoryWarningListener);
            } else {
                File[] files = ErrorLogHelper.getErrorStorageDirectory().listFiles();
                if (files != null) {
                    File[] fileArr = files;
                    int length = fileArr.length;
                    for (int i = 0; i < length; i++) {
                        File file = fileArr[i];
                        new StringBuilder();
                        AppCenterLog.debug(LOG_TAG, sb.append("Deleting file ").append(file).toString());
                        if (!file.delete()) {
                            new StringBuilder();
                            AppCenterLog.warn(LOG_TAG, sb2.append("Failed to delete file ").append(file).toString());
                        }
                    }
                }
                AppCenterLog.info(LOG_TAG, "Deleted crashes local files");
                this.mErrorReportCache.clear();
                this.mLastSessionErrorReport = null;
                this.mContext.unregisterComponentCallbacks(this.mMemoryWarningListener);
                this.mMemoryWarningListener = null;
                SharedPreferencesManager.remove(PREF_KEY_MEMORY_RUNNING_LEVEL);
            }
        }
    }

    public synchronized void onStarted(@NonNull Context context, @NonNull Channel channel, String str, String str2, boolean z) {
        Context context2 = context;
        Channel channel2 = channel;
        String appSecret = str;
        String transmissionTargetToken = str2;
        boolean startedFromApp = z;
        synchronized (this) {
            this.mContext = context2;
            if (!isInstanceEnabled()) {
                ErrorLogHelper.removeMinidumpFolder();
                AppCenterLog.debug(LOG_TAG, "Clean up minidump folder.");
            }
            super.onStarted(context2, channel2, appSecret, transmissionTargetToken, startedFromApp);
            if (isInstanceEnabled()) {
                processPendingErrors();
            }
        }
    }

    public Map<String, LogFactory> getLogFactories() {
        return this.mFactories;
    }

    /* access modifiers changed from: protected */
    public String getGroupName() {
        return ERROR_GROUP;
    }

    public String getServiceName() {
        return SERVICE_NAME;
    }

    /* access modifiers changed from: protected */
    public String getLoggerTag() {
        return LOG_TAG;
    }

    /* access modifiers changed from: protected */
    public int getTriggerCount() {
        return 1;
    }

    /* access modifiers changed from: protected */
    public Channel.GroupListener getChannelListener() {
        Channel.GroupListener groupListener;
        new Channel.GroupListener(this) {
            final /* synthetic */ Crashes this$0;

            {
                this.this$0 = this$0;
            }

            private void processCallback(Log log, CallbackProcessor callbackProcessor) {
                Runnable runnable;
                final Log log2 = log;
                final CallbackProcessor callbackProcessor2 = callbackProcessor;
                new Runnable(this) {
                    final /* synthetic */ AnonymousClass6 this$1;

                    {
                        this.this$1 = this$1;
                    }

                    public void run() {
                        StringBuilder sb;
                        StringBuilder sb2;
                        Runnable runnable;
                        if (log2 instanceof ManagedErrorLog) {
                            ManagedErrorLog errorLog = (ManagedErrorLog) log2;
                            ErrorReport report = this.this$1.this$0.buildErrorReport(errorLog);
                            UUID id = errorLog.getId();
                            if (report != null) {
                                if (callbackProcessor2.shouldDeleteThrowable()) {
                                    this.this$1.this$0.removeStoredThrowable(id);
                                }
                                final ErrorReport errorReport = report;
                                new Runnable(this) {
                                    final /* synthetic */ AnonymousClass1 this$2;

                                    {
                                        this.this$2 = this$2;
                                    }

                                    public void run() {
                                        callbackProcessor2.onCallBack(errorReport);
                                    }
                                };
                                HandlerUtils.runOnUiThread(runnable);
                                return;
                            }
                            new StringBuilder();
                            AppCenterLog.warn(Crashes.LOG_TAG, sb2.append("Cannot find crash report for the error log: ").append(id).toString());
                        } else if (!(log2 instanceof ErrorAttachmentLog) && !(log2 instanceof HandledErrorLog)) {
                            new StringBuilder();
                            AppCenterLog.warn(Crashes.LOG_TAG, sb.append("A different type of log comes to crashes: ").append(log2.getClass().getName()).toString());
                        }
                    }
                };
                this.this$0.post(runnable);
            }

            public void onBeforeSending(Log log) {
                CallbackProcessor callbackProcessor;
                new CallbackProcessor(this) {
                    final /* synthetic */ AnonymousClass6 this$1;

                    {
                        this.this$1 = this$1;
                    }

                    public boolean shouldDeleteThrowable() {
                        return false;
                    }

                    public void onCallBack(ErrorReport report) {
                        this.this$1.this$0.mCrashesListener.onBeforeSending(report);
                    }
                };
                processCallback(log, callbackProcessor);
            }

            public void onSuccess(Log log) {
                CallbackProcessor callbackProcessor;
                new CallbackProcessor(this) {
                    final /* synthetic */ AnonymousClass6 this$1;

                    {
                        this.this$1 = this$1;
                    }

                    public boolean shouldDeleteThrowable() {
                        return true;
                    }

                    public void onCallBack(ErrorReport report) {
                        this.this$1.this$0.mCrashesListener.onSendingSucceeded(report);
                    }
                };
                processCallback(log, callbackProcessor);
            }

            public void onFailure(Log log, Exception e) {
                CallbackProcessor callbackProcessor;
                final Exception exc = e;
                new CallbackProcessor(this) {
                    final /* synthetic */ AnonymousClass6 this$1;

                    {
                        this.this$1 = this$1;
                    }

                    public boolean shouldDeleteThrowable() {
                        return true;
                    }

                    public void onCallBack(ErrorReport report) {
                        this.this$1.this$0.mCrashesListener.onSendingFailed(report, exc);
                    }
                };
                processCallback(log, callbackProcessor);
            }
        };
        return groupListener;
    }

    /* access modifiers changed from: package-private */
    public synchronized Device getDeviceInfo(Context context) throws DeviceInfoHelper.DeviceInfoException {
        Device device;
        Context context2 = context;
        synchronized (this) {
            if (this.mDevice == null) {
                this.mDevice = DeviceInfoHelper.getDeviceInfo(context2);
            }
            device = this.mDevice;
        }
        return device;
    }

    /* access modifiers changed from: package-private */
    public synchronized long getInitializeTimestamp() {
        long j;
        synchronized (this) {
            j = this.mInitializeTimestamp;
        }
        return j;
    }

    private synchronized void queueException(@NonNull Throwable th, Map<String, String> map, Iterable<ErrorAttachmentLog> iterable) {
        ExceptionModelBuilder exceptionModelBuilder;
        Throwable throwable = th;
        Map<String, String> properties = map;
        Iterable<ErrorAttachmentLog> attachments = iterable;
        synchronized (this) {
            final Throwable th2 = throwable;
            new ExceptionModelBuilder(this) {
                final /* synthetic */ Crashes this$0;

                {
                    this.this$0 = this$0;
                }

                public Exception buildExceptionModel() {
                    return ErrorLogHelper.getModelExceptionFromThrowable(th2);
                }
            };
            UUID queueException = queueException(exceptionModelBuilder, properties, attachments);
        }
    }

    /* access modifiers changed from: package-private */
    public synchronized UUID queueException(@NonNull Exception exception, Map<String, String> map, Iterable<ErrorAttachmentLog> iterable) {
        ExceptionModelBuilder exceptionModelBuilder;
        UUID queueException;
        Exception modelException = exception;
        Map<String, String> properties = map;
        Iterable<ErrorAttachmentLog> attachments = iterable;
        synchronized (this) {
            final Exception exception2 = modelException;
            new ExceptionModelBuilder(this) {
                final /* synthetic */ Crashes this$0;

                {
                    this.this$0 = this$0;
                }

                public Exception buildExceptionModel() {
                    return exception2;
                }
            };
            queueException = queueException(exceptionModelBuilder, properties, attachments);
        }
        return queueException;
    }

    private synchronized UUID queueException(@NonNull ExceptionModelBuilder exceptionModelBuilder, Map<String, String> map, Iterable<ErrorAttachmentLog> iterable) {
        Runnable runnable;
        UUID uuid;
        ExceptionModelBuilder exceptionModelBuilder2 = exceptionModelBuilder;
        Map<String, String> properties = map;
        Iterable<ErrorAttachmentLog> attachments = iterable;
        synchronized (this) {
            String userId = UserIdContext.getInstance().getUserId();
            UUID errorId = UUID.randomUUID();
            final UUID uuid2 = errorId;
            final String str = userId;
            final ExceptionModelBuilder exceptionModelBuilder3 = exceptionModelBuilder2;
            final Map<String, String> validateProperties = ErrorLogHelper.validateProperties(properties, "HandledError");
            final Iterable<ErrorAttachmentLog> iterable2 = attachments;
            new Runnable(this) {
                final /* synthetic */ Crashes this$0;

                {
                    this.this$0 = this$0;
                }

                public void run() {
                    HandledErrorLog handledErrorLog;
                    new HandledErrorLog();
                    HandledErrorLog errorLog = handledErrorLog;
                    errorLog.setId(uuid2);
                    errorLog.setUserId(str);
                    errorLog.setException(exceptionModelBuilder3.buildExceptionModel());
                    errorLog.setProperties(validateProperties);
                    this.this$0.mChannel.enqueue(errorLog, Crashes.ERROR_GROUP, 1);
                    this.this$0.sendErrorAttachment(uuid2, iterable2);
                }
            };
            post(runnable);
            uuid = errorId;
        }
        return uuid;
    }

    private void initialize() {
        UncaughtExceptionHandler uncaughtExceptionHandler;
        boolean enabled = isInstanceEnabled();
        this.mInitializeTimestamp = enabled ? System.currentTimeMillis() : -1;
        if (enabled) {
            new UncaughtExceptionHandler();
            this.mUncaughtExceptionHandler = uncaughtExceptionHandler;
            this.mUncaughtExceptionHandler.register();
            processMinidumpFiles();
        } else if (this.mUncaughtExceptionHandler != null) {
            this.mUncaughtExceptionHandler.unregister();
            this.mUncaughtExceptionHandler = null;
        }
    }

    private void processMinidumpFiles() {
        File logFile;
        StringBuilder sb;
        FilenameFilter filenameFilter;
        File[] newMinidumpFiles = ErrorLogHelper.getNewMinidumpFiles();
        int length = newMinidumpFiles.length;
        for (int i = 0; i < length; i++) {
            File minidumpSubfolder = newMinidumpFiles[i];
            if (!minidumpSubfolder.isDirectory()) {
                AppCenterLog.debug(LOG_TAG, "Found a minidump from a previous SDK version.");
                processSingleMinidump(minidumpSubfolder, minidumpSubfolder);
            } else {
                new FilenameFilter(this) {
                    final /* synthetic */ Crashes this$0;

                    {
                        this.this$0 = this$0;
                    }

                    public boolean accept(File file, String filename) {
                        File file2 = file;
                        return filename.endsWith(ErrorLogHelper.MINIDUMP_FILE_EXTENSION);
                    }
                };
                File[] minidumpSubfolderFiles = minidumpSubfolder.listFiles(filenameFilter);
                if (!(minidumpSubfolderFiles == null || minidumpSubfolderFiles.length == 0)) {
                    File[] fileArr = minidumpSubfolderFiles;
                    int length2 = fileArr.length;
                    for (int i2 = 0; i2 < length2; i2++) {
                        processSingleMinidump(fileArr[i2], minidumpSubfolder);
                    }
                }
            }
        }
        File lastErrorLogFile = ErrorLogHelper.getLastErrorLogFile();
        while (true) {
            logFile = lastErrorLogFile;
            if (logFile != null && logFile.length() == 0) {
                new StringBuilder();
                AppCenterLog.warn(LOG_TAG, sb.append("Deleting empty error file: ").append(logFile).toString());
                boolean delete = logFile.delete();
                lastErrorLogFile = ErrorLogHelper.getLastErrorLogFile();
            }
        }
        if (logFile != null) {
            AppCenterLog.debug(LOG_TAG, "Processing crash report for the last session.");
            String logFileContents = FileManager.read(logFile);
            if (logFileContents == null) {
                AppCenterLog.error(LOG_TAG, "Error reading last session error log.");
            } else {
                try {
                    this.mLastSessionErrorReport = buildErrorReport((ManagedErrorLog) this.mLogSerializer.deserializeLog(logFileContents, (String) null));
                    AppCenterLog.debug(LOG_TAG, "Processed crash report for the last session.");
                } catch (JSONException e) {
                    AppCenterLog.error(LOG_TAG, "Error parsing last session error log.", e);
                }
            }
        }
        ErrorLogHelper.removeStaleMinidumpSubfolders();
    }

    private void processSingleMinidump(File file, File file2) {
        StringBuilder sb;
        File file3;
        Exception exception;
        ManagedErrorLog managedErrorLog;
        Date date;
        StringBuilder sb2;
        Throwable th;
        Throwable th2;
        Date date2;
        File minidumpFile = file;
        File minidumpFolder = file2;
        new StringBuilder();
        AppCenterLog.debug(LOG_TAG, sb.append("Process pending minidump file: ").append(minidumpFile).toString());
        long minidumpDate = minidumpFile.lastModified();
        new File(ErrorLogHelper.getPendingMinidumpDirectory(), minidumpFile.getName());
        File dest = file3;
        new Exception();
        Exception modelException = exception;
        modelException.setType("minidump");
        modelException.setWrapperSdkName(Constants.WRAPPER_SDK_NAME_NDK);
        modelException.setMinidumpFilePath(dest.getPath());
        new ManagedErrorLog();
        ManagedErrorLog errorLog = managedErrorLog;
        errorLog.setException(modelException);
        new Date(minidumpDate);
        errorLog.setTimestamp(date);
        errorLog.setFatal(true);
        errorLog.setId(ErrorLogHelper.parseLogFolderUuid(minidumpFolder));
        SessionContext.SessionInfo session = SessionContext.getInstance().getSessionAt(minidumpDate);
        if (session == null || session.getAppLaunchTimestamp() > minidumpDate) {
            errorLog.setAppLaunchTimestamp(errorLog.getTimestamp());
        } else {
            new Date(session.getAppLaunchTimestamp());
            errorLog.setAppLaunchTimestamp(date2);
        }
        errorLog.setProcessId(0);
        errorLog.setProcessName("");
        errorLog.setUserId(UserIdContext.getInstance().getUserId());
        try {
            Device savedDeviceInfo = ErrorLogHelper.getStoredDeviceInfo(minidumpFolder);
            if (savedDeviceInfo == null) {
                savedDeviceInfo = getDeviceInfo(this.mContext);
                savedDeviceInfo.setWrapperSdkName(Constants.WRAPPER_SDK_NAME_NDK);
            }
            errorLog.setDevice(savedDeviceInfo);
            new NativeException();
            UUID saveErrorLogFiles = saveErrorLogFiles(th, errorLog);
            if (!minidumpFile.renameTo(dest)) {
                Throwable th3 = th2;
                new IOException("Failed to move file");
                throw th3;
            }
        } catch (Exception e) {
            Exception e2 = e;
            boolean delete = minidumpFile.delete();
            removeAllStoredErrorLogFiles(errorLog.getId());
            new StringBuilder();
            AppCenterLog.error(LOG_TAG, sb2.append("Failed to process new minidump file: ").append(minidumpFile).toString(), e2);
        }
    }

    private void processPendingErrors() {
        StringBuilder sb;
        StringBuilder sb2;
        StringBuilder sb3;
        StringBuilder sb4;
        File[] storedErrorLogFiles = ErrorLogHelper.getStoredErrorLogFiles();
        int length = storedErrorLogFiles.length;
        for (int i = 0; i < length; i++) {
            File logFile = storedErrorLogFiles[i];
            new StringBuilder();
            AppCenterLog.debug(LOG_TAG, sb.append("Process pending error file: ").append(logFile).toString());
            String logfileContents = FileManager.read(logFile);
            if (logfileContents != null) {
                try {
                    ManagedErrorLog log = (ManagedErrorLog) this.mLogSerializer.deserializeLog(logfileContents, (String) null);
                    UUID id = log.getId();
                    ErrorReport report = buildErrorReport(log);
                    if (report == null) {
                        removeAllStoredErrorLogFiles(id);
                    } else if (!this.mAutomaticProcessing || this.mCrashesListener.shouldProcess(report)) {
                        if (!this.mAutomaticProcessing) {
                            new StringBuilder();
                            AppCenterLog.debug(LOG_TAG, sb3.append("CrashesListener.shouldProcess returned true, continue processing log: ").append(id.toString()).toString());
                        }
                        ErrorLogReport put = this.mUnprocessedErrorReports.put(id, this.mErrorReportCache.get(id));
                    } else {
                        new StringBuilder();
                        AppCenterLog.debug(LOG_TAG, sb4.append("CrashesListener.shouldProcess returned false, clean up and ignore log: ").append(id.toString()).toString());
                        removeAllStoredErrorLogFiles(id);
                    }
                } catch (JSONException e) {
                    new StringBuilder();
                    AppCenterLog.error(LOG_TAG, sb2.append("Error parsing error log. Deleting invalid file: ").append(logFile).toString(), e);
                    boolean delete = logFile.delete();
                }
            }
        }
        this.mHasReceivedMemoryWarningInLastSession = isMemoryRunningLevelWasReceived(SharedPreferencesManager.getInt(PREF_KEY_MEMORY_RUNNING_LEVEL, -1));
        if (this.mHasReceivedMemoryWarningInLastSession) {
            AppCenterLog.debug(LOG_TAG, "The application received a low memory warning in the last session.");
        }
        SharedPreferencesManager.remove(PREF_KEY_MEMORY_RUNNING_LEVEL);
        if (this.mAutomaticProcessing) {
            boolean sendCrashReportsOrAwaitUserConfirmation = sendCrashReportsOrAwaitUserConfirmation();
        }
    }

    private static boolean isMemoryRunningLevelWasReceived(int i) {
        int memoryLevel = i;
        return memoryLevel == 5 || memoryLevel == 10 || memoryLevel == 15 || memoryLevel == 80;
    }

    /* access modifiers changed from: private */
    public boolean sendCrashReportsOrAwaitUserConfirmation() {
        Runnable runnable;
        boolean alwaysSend = SharedPreferencesManager.getBoolean(PREF_KEY_ALWAYS_SEND, false);
        final boolean z = alwaysSend;
        new Runnable(this) {
            final /* synthetic */ Crashes this$0;

            {
                this.this$0 = this$0;
            }

            public void run() {
                if (this.this$0.mUnprocessedErrorReports.size() <= 0) {
                    return;
                }
                if (z) {
                    AppCenterLog.debug(Crashes.LOG_TAG, "The flag for user confirmation is set to ALWAYS_SEND, will send logs.");
                    this.this$0.handleUserConfirmation(0);
                } else if (!this.this$0.mAutomaticProcessing) {
                    AppCenterLog.debug(Crashes.LOG_TAG, "Automatic processing disabled, will wait for explicit user confirmation.");
                } else if (!this.this$0.mCrashesListener.shouldAwaitUserConfirmation()) {
                    AppCenterLog.debug(Crashes.LOG_TAG, "CrashesListener.shouldAwaitUserConfirmation returned false, will send logs.");
                    this.this$0.handleUserConfirmation(0);
                } else {
                    AppCenterLog.debug(Crashes.LOG_TAG, "CrashesListener.shouldAwaitUserConfirmation returned true, wait sending logs.");
                }
            }
        };
        HandlerUtils.runOnUiThread(runnable);
        return alwaysSend;
    }

    /* access modifiers changed from: private */
    public void removeAllStoredErrorLogFiles(UUID uuid) {
        UUID id = uuid;
        ErrorLogHelper.removeStoredErrorLogFile(id);
        removeStoredThrowable(id);
    }

    /* access modifiers changed from: private */
    public void removeStoredThrowable(UUID uuid) {
        UUID id = uuid;
        ErrorLogReport remove = this.mErrorReportCache.remove(id);
        WrapperSdkExceptionManager.deleteWrapperExceptionData(id);
        ErrorLogHelper.removeStoredThrowableFile(id);
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public UncaughtExceptionHandler getUncaughtExceptionHandler() {
        return this.mUncaughtExceptionHandler;
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public void setUncaughtExceptionHandler(UncaughtExceptionHandler handler) {
        UncaughtExceptionHandler uncaughtExceptionHandler = handler;
        this.mUncaughtExceptionHandler = uncaughtExceptionHandler;
    }

    /* access modifiers changed from: package-private */
    @Nullable
    @VisibleForTesting
    public ErrorReport buildErrorReport(ManagedErrorLog managedErrorLog) {
        Object obj;
        ManagedErrorLog log = managedErrorLog;
        UUID id = log.getId();
        if (this.mErrorReportCache.containsKey(id)) {
            ErrorReport report = this.mErrorReportCache.get(id).report;
            report.setDevice(log.getDevice());
            return report;
        }
        File file = ErrorLogHelper.getStoredThrowableFile(id);
        if (file == null) {
            return null;
        }
        String stackTrace = null;
        if (file.length() > 0) {
            stackTrace = FileManager.read(file);
        }
        ErrorReport report2 = ErrorLogHelper.getErrorReportFromErrorLog(log, stackTrace);
        new ErrorLogReport(log, report2, (AnonymousClass1) null);
        ErrorLogReport put = this.mErrorReportCache.put(id, obj);
        return report2;
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public CrashesListener getInstanceListener() {
        return this.mCrashesListener;
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public synchronized void setInstanceListener(CrashesListener crashesListener) {
        CrashesListener listener = crashesListener;
        synchronized (this) {
            if (listener == null) {
                listener = DEFAULT_ERROR_REPORTING_LISTENER;
            }
            this.mCrashesListener = listener;
        }
    }

    /* access modifiers changed from: private */
    @VisibleForTesting
    public synchronized void handleUserConfirmation(int i) {
        Runnable runnable;
        int userConfirmation = i;
        synchronized (this) {
            final int i2 = userConfirmation;
            new Runnable(this) {
                final /* synthetic */ Crashes this$0;

                {
                    this.this$0 = this$0;
                }

                public void run() {
                    File file;
                    if (i2 == 1) {
                        Iterator<UUID> iterator = this.this$0.mUnprocessedErrorReports.keySet().iterator();
                        while (iterator.hasNext()) {
                            UUID id = iterator.next();
                            iterator.remove();
                            this.this$0.removeAllStoredErrorLogFiles(id);
                        }
                        ErrorLogHelper.cleanPendingMinidumps();
                        return;
                    }
                    if (i2 == 2) {
                        SharedPreferencesManager.putBoolean(Crashes.PREF_KEY_ALWAYS_SEND, true);
                    }
                    Iterator<Map.Entry<UUID, ErrorLogReport>> unprocessedIterator = this.this$0.mUnprocessedErrorReports.entrySet().iterator();
                    while (unprocessedIterator.hasNext()) {
                        File dumpFile = null;
                        ErrorAttachmentLog dumpAttachment = null;
                        Map.Entry<UUID, ErrorLogReport> unprocessedEntry = unprocessedIterator.next();
                        ErrorLogReport errorLogReport = unprocessedEntry.getValue();
                        if (errorLogReport.report.getDevice() != null && Constants.WRAPPER_SDK_NAME_NDK.equals(errorLogReport.report.getDevice().getWrapperSdkName())) {
                            Exception exception = errorLogReport.log.getException();
                            String minidumpFilePath = exception.getMinidumpFilePath();
                            exception.setMinidumpFilePath((String) null);
                            if (minidumpFilePath == null) {
                                minidumpFilePath = exception.getStackTrace();
                                exception.setStackTrace((String) null);
                            }
                            if (minidumpFilePath != null) {
                                new File(minidumpFilePath);
                                dumpFile = file;
                                dumpAttachment = ErrorAttachmentLog.attachmentWithBinary(FileManager.readBytes(dumpFile), "minidump.dmp", "application/octet-stream");
                            } else {
                                AppCenterLog.warn(Crashes.LOG_TAG, "NativeException found without minidump.");
                            }
                        }
                        this.this$0.mChannel.enqueue(errorLogReport.log, Crashes.ERROR_GROUP, 2);
                        if (dumpAttachment != null) {
                            this.this$0.sendErrorAttachment(errorLogReport.log.getId(), Collections.singleton(dumpAttachment));
                            boolean delete = dumpFile.delete();
                        }
                        if (this.this$0.mAutomaticProcessing) {
                            this.this$0.sendErrorAttachment(errorLogReport.log.getId(), this.this$0.mCrashesListener.getErrorAttachments(errorLogReport.report));
                        }
                        unprocessedIterator.remove();
                        ErrorLogHelper.removeStoredErrorLogFile(unprocessedEntry.getKey());
                    }
                }
            };
            post(runnable);
        }
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public void sendErrorAttachment(UUID uuid, Iterable<ErrorAttachmentLog> iterable) {
        StringBuilder sb;
        UUID errorId = uuid;
        Iterable<ErrorAttachmentLog> attachments = iterable;
        if (attachments == null) {
            new StringBuilder();
            AppCenterLog.debug(LOG_TAG, sb.append("Error report: ").append(errorId.toString()).append(" does not have any attachment.").toString());
            return;
        }
        for (ErrorAttachmentLog attachment : attachments) {
            if (attachment != null) {
                attachment.setId(UUID.randomUUID());
                attachment.setErrorId(errorId);
                if (!attachment.isValid()) {
                    AppCenterLog.error(LOG_TAG, "Not all required fields are present in ErrorAttachmentLog.");
                } else if (attachment.getData().length > MAX_ATTACHMENT_SIZE) {
                    Locale locale = Locale.ENGLISH;
                    Object[] objArr = new Object[3];
                    objArr[0] = Integer.valueOf(MAX_ATTACHMENT_SIZE);
                    Object[] objArr2 = objArr;
                    objArr2[1] = Integer.valueOf(attachment.getData().length);
                    Object[] objArr3 = objArr2;
                    objArr3[2] = attachment.getFileName();
                    AppCenterLog.error(LOG_TAG, String.format(locale, "Discarding attachment with size above %d bytes: size=%d, fileName=%s.", objArr3));
                } else {
                    this.mChannel.enqueue(attachment, ERROR_GROUP, 1);
                }
            } else {
                AppCenterLog.warn(LOG_TAG, "Skipping null ErrorAttachmentLog.");
            }
        }
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public void setLogSerializer(LogSerializer logSerializer) {
        LogSerializer logSerializer2 = logSerializer;
        this.mLogSerializer = logSerializer2;
    }

    /* access modifiers changed from: package-private */
    public void saveUncaughtException(Thread thread, Throwable th) {
        Throwable throwable = th;
        try {
            UUID saveUncaughtException = saveUncaughtException(thread, throwable, ErrorLogHelper.getModelExceptionFromThrowable(throwable));
        } catch (JSONException e) {
            AppCenterLog.error(LOG_TAG, "Error serializing error log to JSON", e);
        } catch (IOException e2) {
            AppCenterLog.error(LOG_TAG, "Error writing error log to file", e2);
        }
    }

    /* access modifiers changed from: package-private */
    public UUID saveUncaughtException(Thread thread, Throwable th, Exception exception) throws JSONException, IOException {
        Thread thread2 = thread;
        Throwable throwable = th;
        Exception modelException = exception;
        if (!isEnabled().get().booleanValue()) {
            return null;
        }
        if (this.mSavedUncaughtException) {
            return null;
        }
        this.mSavedUncaughtException = true;
        return saveErrorLogFiles(throwable, ErrorLogHelper.createErrorLog(this.mContext, thread2, modelException, Thread.getAllStackTraces(), this.mInitializeTimestamp, true));
    }

    @NonNull
    private UUID saveErrorLogFiles(Throwable th, ManagedErrorLog managedErrorLog) throws JSONException, IOException {
        File file;
        StringBuilder sb;
        StringBuilder sb2;
        File file2;
        StringBuilder sb3;
        StringBuilder sb4;
        Throwable th2;
        StringBuilder sb5;
        Throwable throwable = th;
        ManagedErrorLog errorLog = managedErrorLog;
        File errorStorageDirectory = ErrorLogHelper.getErrorStorageDirectory();
        UUID errorLogId = errorLog.getId();
        String filename = errorLogId.toString();
        AppCenterLog.debug(LOG_TAG, "Saving uncaught exception.");
        new StringBuilder();
        new File(errorStorageDirectory, sb.append(filename).append(ErrorLogHelper.ERROR_LOG_FILE_EXTENSION).toString());
        File errorLogFile = file;
        FileManager.write(errorLogFile, this.mLogSerializer.serializeLog(errorLog));
        new StringBuilder();
        AppCenterLog.debug(LOG_TAG, sb2.append("Saved JSON content for ingestion into ").append(errorLogFile).toString());
        new StringBuilder();
        new File(errorStorageDirectory, sb3.append(filename).append(ErrorLogHelper.THROWABLE_FILE_EXTENSION).toString());
        File throwableFile = file2;
        if (throwable != null) {
            try {
                String stackTrace = android.util.Log.getStackTraceString(throwable);
                FileManager.write(throwableFile, stackTrace);
                new StringBuilder();
                AppCenterLog.debug(LOG_TAG, sb5.append("Saved stack trace as is for client side inspection in ").append(throwableFile).append(" stack trace:").append(stackTrace).toString());
            } catch (StackOverflowError e) {
                AppCenterLog.error(LOG_TAG, "Failed to store stack trace.", e);
                throwable = null;
                boolean delete = throwableFile.delete();
            }
        }
        if (throwable == null) {
            if (!throwableFile.createNewFile()) {
                Throwable th3 = th2;
                new IOException(throwableFile.getName());
                throw th3;
            }
            new StringBuilder();
            AppCenterLog.debug(LOG_TAG, sb4.append("Saved empty Throwable file in ").append(throwableFile).toString());
        }
        return errorLogId;
    }

    /* access modifiers changed from: package-private */
    public void setAutomaticProcessing(boolean automaticProcessing) {
        boolean z = automaticProcessing;
        this.mAutomaticProcessing = z;
    }

    /* access modifiers changed from: package-private */
    public AppCenterFuture<Collection<ErrorReport>> getUnprocessedErrorReports() {
        DefaultAppCenterFuture defaultAppCenterFuture;
        Runnable runnable;
        new DefaultAppCenterFuture();
        DefaultAppCenterFuture defaultAppCenterFuture2 = defaultAppCenterFuture;
        final DefaultAppCenterFuture defaultAppCenterFuture3 = defaultAppCenterFuture2;
        new Runnable(this) {
            final /* synthetic */ Crashes this$0;

            {
                this.this$0 = this$0;
            }

            public void run() {
                Collection<ErrorReport> collection;
                new ArrayList<>(this.this$0.mUnprocessedErrorReports.size());
                Collection<ErrorReport> reports = collection;
                for (ErrorLogReport entry : this.this$0.mUnprocessedErrorReports.values()) {
                    boolean add = reports.add(entry.report);
                }
                defaultAppCenterFuture3.complete(reports);
            }
        };
        postAsyncGetter(runnable, defaultAppCenterFuture2, Collections.emptyList());
        return defaultAppCenterFuture2;
    }

    /* access modifiers changed from: package-private */
    public AppCenterFuture<Boolean> sendCrashReportsOrAwaitUserConfirmation(Collection<String> filteredReportIds) {
        DefaultAppCenterFuture defaultAppCenterFuture;
        Runnable runnable;
        new DefaultAppCenterFuture();
        DefaultAppCenterFuture defaultAppCenterFuture2 = defaultAppCenterFuture;
        final Collection<String> collection = filteredReportIds;
        final DefaultAppCenterFuture defaultAppCenterFuture3 = defaultAppCenterFuture2;
        new Runnable(this) {
            final /* synthetic */ Crashes this$0;

            {
                this.this$0 = this$0;
            }

            public void run() {
                StringBuilder sb;
                StringBuilder sb2;
                Iterator<Map.Entry<UUID, ErrorLogReport>> iterator = this.this$0.mUnprocessedErrorReports.entrySet().iterator();
                while (iterator.hasNext()) {
                    Map.Entry<UUID, ErrorLogReport> entry = iterator.next();
                    UUID id = entry.getKey();
                    String idString = entry.getValue().report.getId();
                    if (collection == null || !collection.contains(idString)) {
                        new StringBuilder();
                        AppCenterLog.debug(Crashes.LOG_TAG, sb.append("CrashesListener.shouldProcess returned false, clean up and ignore log: ").append(idString).toString());
                        this.this$0.removeAllStoredErrorLogFiles(id);
                        iterator.remove();
                    } else {
                        new StringBuilder();
                        AppCenterLog.debug(Crashes.LOG_TAG, sb2.append("CrashesListener.shouldProcess returned true, continue processing log: ").append(idString).toString());
                    }
                }
                defaultAppCenterFuture3.complete(Boolean.valueOf(this.this$0.sendCrashReportsOrAwaitUserConfirmation()));
            }
        };
        postAsyncGetter(runnable, defaultAppCenterFuture2, false);
        return defaultAppCenterFuture2;
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public void sendErrorAttachments(String errorReportId, Iterable<ErrorAttachmentLog> attachments) {
        Runnable runnable;
        final String str = errorReportId;
        final Iterable<ErrorAttachmentLog> iterable = attachments;
        new Runnable(this) {
            final /* synthetic */ Crashes this$0;

            {
                this.this$0 = this$0;
            }

            public void run() {
                try {
                    this.this$0.sendErrorAttachment(UUID.fromString(str), iterable);
                } catch (RuntimeException e) {
                    RuntimeException runtimeException = e;
                    AppCenterLog.error(Crashes.LOG_TAG, "Error report identifier has an invalid format for sending attachments.");
                }
            }
        };
        post(runnable);
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public static void saveMemoryRunningLevel(int i) {
        int level = i;
        SharedPreferencesManager.putInt(PREF_KEY_MEMORY_RUNNING_LEVEL, level);
        AppCenterLog.debug(LOG_TAG, String.format("The memory running level (%s) was saved.", new Object[]{Integer.valueOf(level)}));
    }

    private static class DefaultCrashesListener extends AbstractCrashesListener {
        private DefaultCrashesListener() {
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        /* synthetic */ DefaultCrashesListener(AnonymousClass1 r4) {
            this();
            AnonymousClass1 r1 = r4;
        }
    }

    private static class ErrorLogReport {
        /* access modifiers changed from: private */
        public final ManagedErrorLog log;
        /* access modifiers changed from: private */
        public final ErrorReport report;

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        /* synthetic */ ErrorLogReport(ManagedErrorLog x0, ErrorReport x1, AnonymousClass1 r10) {
            this(x0, x1);
            AnonymousClass1 r3 = r10;
        }

        private ErrorLogReport(ManagedErrorLog log2, ErrorReport report2) {
            this.log = log2;
            this.report = report2;
        }
    }
}
