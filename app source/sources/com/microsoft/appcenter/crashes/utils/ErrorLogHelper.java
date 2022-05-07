package com.microsoft.appcenter.crashes.utils;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import com.microsoft.appcenter.Constants;
import com.microsoft.appcenter.crashes.Crashes;
import com.microsoft.appcenter.crashes.ingestion.models.Exception;
import com.microsoft.appcenter.crashes.ingestion.models.ManagedErrorLog;
import com.microsoft.appcenter.crashes.ingestion.models.StackFrame;
import com.microsoft.appcenter.crashes.ingestion.models.Thread;
import com.microsoft.appcenter.crashes.model.ErrorReport;
import com.microsoft.appcenter.ingestion.models.Device;
import com.microsoft.appcenter.utils.AppCenterLog;
import com.microsoft.appcenter.utils.DeviceInfoHelper;
import com.microsoft.appcenter.utils.context.UserIdContext;
import com.microsoft.appcenter.utils.storage.FileManager;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

public class ErrorLogHelper {
    @VisibleForTesting
    static final int CAUSE_LIMIT = 16;
    private static final int CAUSE_LIMIT_HALF = 8;
    public static final String DEVICE_INFO_FILE = "deviceInfo";
    @VisibleForTesting
    static final String ERROR_DIRECTORY = "error";
    public static final String ERROR_LOG_FILE_EXTENSION = ".json";
    @VisibleForTesting
    public static final int FRAME_LIMIT = 256;
    private static final int FRAME_LIMIT_HALF = 128;
    private static final int MAX_PROPERTY_COUNT = 20;
    public static final int MAX_PROPERTY_ITEM_LENGTH = 125;
    private static final String MINIDUMP_DIRECTORY = "minidump";
    public static final String MINIDUMP_FILE_EXTENSION = ".dmp";
    private static final String NEW_MINIDUMP_DIRECTORY = "new";
    private static final String PENDING_MINIDUMP_DIRECTORY = "pending";
    public static final String THROWABLE_FILE_EXTENSION = ".throwable";
    private static File sErrorLogDirectory;
    /* access modifiers changed from: private */
    public static File sNewMinidumpDirectory;
    private static File sPendingMinidumpDirectory;

    public ErrorLogHelper() {
    }

    @NonNull
    public static ManagedErrorLog createErrorLog(@NonNull Context context, @NonNull Thread thread, @NonNull Throwable throwable, @NonNull Map<Thread, StackTraceElement[]> allStackTraces, long initializeTimestamp) {
        return createErrorLog(context, thread, getModelExceptionFromThrowable(throwable), allStackTraces, initializeTimestamp, true);
    }

    @NonNull
    public static ManagedErrorLog createErrorLog(@NonNull Context context, @NonNull Thread thread, @NonNull Exception exception, @NonNull Map<Thread, StackTraceElement[]> map, long j, boolean z) {
        ManagedErrorLog managedErrorLog;
        Date date;
        Date date2;
        List<Thread> list;
        Thread thread2;
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        Context context2 = context;
        Thread thread3 = thread;
        Exception exception2 = exception;
        Map<Thread, StackTraceElement[]> allStackTraces = map;
        long initializeTimestamp = j;
        boolean fatal = z;
        new ManagedErrorLog();
        ManagedErrorLog errorLog = managedErrorLog;
        errorLog.setId(UUID.randomUUID());
        new Date();
        errorLog.setTimestamp(date);
        errorLog.setUserId(UserIdContext.getInstance().getUserId());
        try {
            errorLog.setDevice(DeviceInfoHelper.getDeviceInfo(context2));
        } catch (DeviceInfoHelper.DeviceInfoException e) {
            AppCenterLog.error(Crashes.LOG_TAG, "Could not attach device properties snapshot to error log, will attach at sending time", e);
        }
        errorLog.setProcessId(Integer.valueOf(Process.myPid()));
        ActivityManager activityManager = (ActivityManager) context2.getSystemService("activity");
        if (!(activityManager == null || (runningAppProcesses = activityManager.getRunningAppProcesses()) == null)) {
            for (ActivityManager.RunningAppProcessInfo info : runningAppProcesses) {
                if (info.pid == Process.myPid()) {
                    errorLog.setProcessName(info.processName);
                }
            }
        }
        if (errorLog.getProcessName() == null) {
            errorLog.setProcessName("");
        }
        errorLog.setArchitecture(getArchitecture());
        errorLog.setErrorThreadId(Long.valueOf(thread3.getId()));
        errorLog.setErrorThreadName(thread3.getName());
        errorLog.setFatal(Boolean.valueOf(fatal));
        new Date(initializeTimestamp);
        errorLog.setAppLaunchTimestamp(date2);
        errorLog.setException(exception2);
        new ArrayList<>(allStackTraces.size());
        List<Thread> threads = list;
        for (Map.Entry<Thread, StackTraceElement[]> entry : allStackTraces.entrySet()) {
            new Thread();
            Thread javaThread = thread2;
            javaThread.setId(entry.getKey().getId());
            javaThread.setName(entry.getKey().getName());
            javaThread.setFrames(getModelFramesFromStackTrace(entry.getValue()));
            boolean add = threads.add(javaThread);
        }
        errorLog.setThreads(threads);
        return errorLog;
    }

    @TargetApi(21)
    private static String getArchitecture() {
        if (Build.VERSION.SDK_INT >= 21) {
            return Build.SUPPORTED_ABIS[0];
        }
        return Build.CPU_ABI;
    }

    @NonNull
    public static synchronized File getErrorStorageDirectory() {
        File file;
        File file2;
        synchronized (ErrorLogHelper.class) {
            if (sErrorLogDirectory == null) {
                new File(Constants.FILES_PATH, ERROR_DIRECTORY);
                sErrorLogDirectory = file2;
                FileManager.mkdir(sErrorLogDirectory.getAbsolutePath());
            }
            file = sErrorLogDirectory;
        }
        return file;
    }

    @NonNull
    public static synchronized File getNewMinidumpDirectory() {
        File minidumpDirectory;
        File file;
        File errorStorageDirectory;
        synchronized (ErrorLogHelper.class) {
            new File(getErrorStorageDirectory().getAbsolutePath(), MINIDUMP_DIRECTORY);
            File file2 = file;
            new File(minidumpDirectory, NEW_MINIDUMP_DIRECTORY);
            errorStorageDirectory = file2;
        }
        return errorStorageDirectory;
    }

    @NonNull
    public static synchronized File getNewMinidumpSubfolder() {
        File minidumpDirectory;
        File file;
        synchronized (ErrorLogHelper.class) {
            if (sNewMinidumpDirectory == null) {
                new File(getNewMinidumpDirectory(), UUID.randomUUID().toString());
                sNewMinidumpDirectory = file;
                FileManager.mkdir(sNewMinidumpDirectory.getPath());
            }
            minidumpDirectory = sNewMinidumpDirectory;
        }
        return minidumpDirectory;
    }

    @NonNull
    public static synchronized File getNewMinidumpSubfolderWithContextData(Context context) {
        File file;
        File file2;
        JSONStringer jSONStringer;
        Context context2 = context;
        synchronized (ErrorLogHelper.class) {
            File directorySubfolder = getNewMinidumpSubfolder();
            File file3 = file;
            new File(directorySubfolder, DEVICE_INFO_FILE);
            File deviceInfoFile = file3;
            try {
                Device deviceInfo = DeviceInfoHelper.getDeviceInfo(context2);
                deviceInfo.setWrapperSdkName(Constants.WRAPPER_SDK_NAME_NDK);
                new JSONStringer();
                JSONStringer writer = jSONStringer;
                JSONStringer object = writer.object();
                deviceInfo.write(writer);
                JSONStringer endObject = writer.endObject();
                FileManager.write(deviceInfoFile, writer.toString());
            } catch (DeviceInfoHelper.DeviceInfoException | IOException | JSONException e) {
                AppCenterLog.error(Crashes.LOG_TAG, "Failed to store device info in a minidump folder.", e);
                boolean delete = deviceInfoFile.delete();
            }
            file2 = directorySubfolder;
        }
        return file2;
    }

    @NonNull
    public static synchronized File getPendingMinidumpDirectory() {
        File errorStorageDirectory;
        File minidumpDirectory;
        File file;
        synchronized (ErrorLogHelper.class) {
            if (sPendingMinidumpDirectory == null) {
                new File(getErrorStorageDirectory().getAbsolutePath(), MINIDUMP_DIRECTORY);
                new File(minidumpDirectory, PENDING_MINIDUMP_DIRECTORY);
                sPendingMinidumpDirectory = file;
                FileManager.mkdir(sPendingMinidumpDirectory.getPath());
            }
            errorStorageDirectory = sPendingMinidumpDirectory;
        }
        return errorStorageDirectory;
    }

    @NonNull
    public static File[] getStoredErrorLogFiles() {
        FilenameFilter filenameFilter;
        new FilenameFilter() {
            public boolean accept(File file, String filename) {
                File file2 = file;
                return filename.endsWith(ErrorLogHelper.ERROR_LOG_FILE_EXTENSION);
            }
        };
        File[] files = getErrorStorageDirectory().listFiles(filenameFilter);
        return files != null ? files : new File[0];
    }

    @NonNull
    public static File[] getNewMinidumpFiles() {
        File[] files = getNewMinidumpDirectory().listFiles();
        return files != null ? files : new File[0];
    }

    @Nullable
    public static Device getStoredDeviceInfo(File logFolder) {
        FilenameFilter filenameFilter;
        new FilenameFilter() {
            public boolean accept(File file, String filename) {
                File file2 = file;
                return filename.equals(ErrorLogHelper.DEVICE_INFO_FILE);
            }
        };
        File[] files = logFolder.listFiles(filenameFilter);
        if (files == null || files.length == 0) {
            AppCenterLog.warn(Crashes.LOG_TAG, "No stored deviceinfo file found in a minidump folder.");
            return null;
        }
        String deviceInfoString = FileManager.read(files[0]);
        if (deviceInfoString != null) {
            return parseDevice(deviceInfoString);
        }
        AppCenterLog.error(Crashes.LOG_TAG, "Failed to read stored device info.");
        return null;
    }

    @VisibleForTesting
    static Device parseDevice(String str) {
        Device device;
        JSONObject jsonObject;
        String deviceInfoString = str;
        try {
            new Device();
            Device device2 = device;
            new JSONObject(deviceInfoString);
            device2.read(jsonObject);
            return device2;
        } catch (JSONException e) {
            AppCenterLog.error(Crashes.LOG_TAG, "Failed to deserialize device info.", e);
            return null;
        }
    }

    public static void removeStaleMinidumpSubfolders() {
        FilenameFilter filenameFilter;
        new FilenameFilter() {
            public boolean accept(File file, String str) {
                File file2 = file;
                String name = str;
                if (ErrorLogHelper.sNewMinidumpDirectory == null) {
                    return true;
                }
                return !name.equals(ErrorLogHelper.sNewMinidumpDirectory.getName());
            }
        };
        File[] previousSubFolders = getNewMinidumpDirectory().listFiles(filenameFilter);
        if (previousSubFolders == null || previousSubFolders.length == 0) {
            AppCenterLog.debug(Crashes.LOG_TAG, "No previous minidump sub-folders.");
            return;
        }
        File[] fileArr = previousSubFolders;
        int length = fileArr.length;
        for (int i = 0; i < length; i++) {
            boolean deleteDirectory = FileManager.deleteDirectory(fileArr[i]);
        }
    }

    public static void removeMinidumpFolder() {
        File minidumpDirectory;
        new File(getErrorStorageDirectory().getAbsolutePath(), MINIDUMP_DIRECTORY);
        boolean deleteDirectory = FileManager.deleteDirectory(minidumpDirectory);
    }

    @Nullable
    public static File getLastErrorLogFile() {
        FilenameFilter filenameFilter;
        new FilenameFilter() {
            public boolean accept(File file, String filename) {
                File file2 = file;
                return filename.endsWith(ErrorLogHelper.ERROR_LOG_FILE_EXTENSION);
            }
        };
        return FileManager.lastModifiedFile(getErrorStorageDirectory(), filenameFilter);
    }

    @Nullable
    public static File getStoredThrowableFile(@NonNull UUID id) {
        return getStoredFile(id, THROWABLE_FILE_EXTENSION);
    }

    public static void removeStoredThrowableFile(@NonNull UUID id) {
        StringBuilder sb;
        File file = getStoredThrowableFile(id);
        if (file != null) {
            new StringBuilder();
            AppCenterLog.info(Crashes.LOG_TAG, sb.append("Deleting throwable file ").append(file.getName()).toString());
            boolean delete = FileManager.delete(file);
        }
    }

    @Nullable
    static File getStoredErrorLogFile(@NonNull UUID id) {
        return getStoredFile(id, ERROR_LOG_FILE_EXTENSION);
    }

    public static void removeStoredErrorLogFile(@NonNull UUID id) {
        StringBuilder sb;
        File file = getStoredErrorLogFile(id);
        if (file != null) {
            new StringBuilder();
            AppCenterLog.info(Crashes.LOG_TAG, sb.append("Deleting error log file ").append(file.getName()).toString());
            boolean delete = FileManager.delete(file);
        }
    }

    @NonNull
    public static ErrorReport getErrorReportFromErrorLog(@NonNull ManagedErrorLog managedErrorLog, String stackTrace) {
        ErrorReport errorReport;
        ManagedErrorLog log = managedErrorLog;
        new ErrorReport();
        ErrorReport report = errorReport;
        report.setId(log.getId().toString());
        report.setThreadName(log.getErrorThreadName());
        report.setStackTrace(stackTrace);
        report.setAppStartTime(log.getAppLaunchTimestamp());
        report.setAppErrorTime(log.getTimestamp());
        report.setDevice(log.getDevice());
        return report;
    }

    @VisibleForTesting
    static void setErrorLogDirectory(File file) {
        sErrorLogDirectory = file;
    }

    @Nullable
    private static File getStoredFile(@NonNull UUID id, @NonNull String extension) {
        FilenameFilter filenameFilter;
        final UUID uuid = id;
        final String str = extension;
        new FilenameFilter() {
            public boolean accept(File file, String str) {
                File file2 = file;
                String filename = str;
                return filename.startsWith(uuid.toString()) && filename.endsWith(str);
            }
        };
        File[] files = getErrorStorageDirectory().listFiles(filenameFilter);
        return (files == null || files.length <= 0) ? null : files[0];
    }

    @NonNull
    public static Exception getModelExceptionFromThrowable(@NonNull Throwable t) {
        List<Throwable> list;
        Exception exception;
        StringBuilder sb;
        Exception topException = null;
        Exception parentException = null;
        new LinkedList<>();
        List<Throwable> causeChain = list;
        Throwable th = t;
        while (true) {
            Throwable cause = th;
            if (cause == null) {
                break;
            }
            boolean add = causeChain.add(cause);
            th = cause.getCause();
        }
        if (causeChain.size() > 16) {
            new StringBuilder();
            AppCenterLog.warn(Crashes.LOG_TAG, sb.append("Crash causes truncated from ").append(causeChain.size()).append(" to ").append(16).append(" causes.").toString());
            causeChain.subList(8, causeChain.size() - 8).clear();
        }
        for (Throwable cause2 : causeChain) {
            new Exception();
            Exception exception2 = exception;
            exception2.setType(cause2.getClass().getName());
            exception2.setMessage(cause2.getMessage());
            exception2.setFrames(getModelFramesFromStackTrace(cause2));
            if (topException == null) {
                topException = exception2;
            } else {
                parentException.setInnerExceptions(Collections.singletonList(exception2));
            }
            parentException = exception2;
        }
        return topException;
    }

    @NonNull
    private static List<StackFrame> getModelFramesFromStackTrace(@NonNull Throwable th) {
        StringBuilder sb;
        Throwable throwable = th;
        StackTraceElement[] stackTrace = throwable.getStackTrace();
        if (stackTrace.length > 256) {
            StackTraceElement[] stackTraceTruncated = new StackTraceElement[256];
            System.arraycopy(stackTrace, 0, stackTraceTruncated, 0, 128);
            System.arraycopy(stackTrace, stackTrace.length - 128, stackTraceTruncated, 128, 128);
            throwable.setStackTrace(stackTraceTruncated);
            new StringBuilder();
            AppCenterLog.warn(Crashes.LOG_TAG, sb.append("Crash frames truncated from ").append(stackTrace.length).append(" to ").append(stackTraceTruncated.length).append(" frames.").toString());
            stackTrace = stackTraceTruncated;
        }
        return getModelFramesFromStackTrace(stackTrace);
    }

    @NonNull
    private static List<StackFrame> getModelFramesFromStackTrace(@NonNull StackTraceElement[] stackTrace) {
        List<StackFrame> list;
        new ArrayList();
        List<StackFrame> stackFrames = list;
        StackTraceElement[] stackTraceElementArr = stackTrace;
        int length = stackTraceElementArr.length;
        for (int i = 0; i < length; i++) {
            boolean add = stackFrames.add(getModelStackFrame(stackTraceElementArr[i]));
        }
        return stackFrames;
    }

    @NonNull
    private static StackFrame getModelStackFrame(StackTraceElement stackTraceElement) {
        StackFrame stackFrame;
        StackTraceElement stackTraceElement2 = stackTraceElement;
        new StackFrame();
        StackFrame stackFrame2 = stackFrame;
        stackFrame2.setClassName(stackTraceElement2.getClassName());
        stackFrame2.setMethodName(stackTraceElement2.getMethodName());
        stackFrame2.setLineNumber(Integer.valueOf(stackTraceElement2.getLineNumber()));
        stackFrame2.setFileName(stackTraceElement2.getFileName());
        return stackFrame2;
    }

    public static Map<String, String> validateProperties(Map<String, String> map, String str) {
        Map<String, String> map2;
        Map<String, String> properties = map;
        String logType = str;
        if (properties == null) {
            return null;
        }
        new HashMap();
        Map<String, String> result = map2;
        Iterator<Map.Entry<String, String>> it = properties.entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Map.Entry<String, String> property = it.next();
            String key = property.getKey();
            String value = property.getValue();
            if (result.size() >= 20) {
                Object[] objArr = new Object[2];
                objArr[0] = logType;
                Object[] objArr2 = objArr;
                objArr2[1] = 20;
                AppCenterLog.warn(Crashes.LOG_TAG, String.format("%s : properties cannot contain more than %s items. Skipping other properties.", objArr2));
                break;
            } else if (key == null || key.isEmpty()) {
                AppCenterLog.warn(Crashes.LOG_TAG, String.format("%s : a property key cannot be null or empty. Property will be skipped.", new Object[]{logType}));
            } else if (value == null) {
                Object[] objArr3 = new Object[3];
                objArr3[0] = logType;
                Object[] objArr4 = objArr3;
                objArr4[1] = key;
                Object[] objArr5 = objArr4;
                objArr5[2] = key;
                AppCenterLog.warn(Crashes.LOG_TAG, String.format("%s : property '%s' : property value cannot be null. Property '%s' will be skipped.", objArr5));
            } else {
                if (key.length() > 125) {
                    Object[] objArr6 = new Object[3];
                    objArr6[0] = logType;
                    Object[] objArr7 = objArr6;
                    objArr7[1] = key;
                    Object[] objArr8 = objArr7;
                    objArr8[2] = Integer.valueOf(MAX_PROPERTY_ITEM_LENGTH);
                    AppCenterLog.warn(Crashes.LOG_TAG, String.format("%s : property '%s' : property key length cannot be longer than %s characters. Property key will be truncated.", objArr8));
                    key = key.substring(0, MAX_PROPERTY_ITEM_LENGTH);
                }
                if (value.length() > 125) {
                    Object[] objArr9 = new Object[3];
                    objArr9[0] = logType;
                    Object[] objArr10 = objArr9;
                    objArr10[1] = key;
                    Object[] objArr11 = objArr10;
                    objArr11[2] = Integer.valueOf(MAX_PROPERTY_ITEM_LENGTH);
                    AppCenterLog.warn(Crashes.LOG_TAG, String.format("%s : property '%s' : property value cannot be longer than %s characters. Property value will be truncated.", objArr11));
                    value = value.substring(0, MAX_PROPERTY_ITEM_LENGTH);
                }
                String put = result.put(key, value);
            }
        }
        return result;
    }

    public static void cleanPendingMinidumps() {
        FileManager.cleanDirectory(getPendingMinidumpDirectory());
    }

    @NonNull
    public static UUID parseLogFolderUuid(File file) {
        File logFolder = file;
        UUID uuid = null;
        if (logFolder.isDirectory()) {
            try {
                uuid = UUID.fromString(logFolder.getName());
            } catch (IllegalArgumentException e) {
                AppCenterLog.warn(Crashes.LOG_TAG, "Cannot parse minidump folder name to UUID.", e);
            }
        }
        return uuid == null ? UUID.randomUUID() : uuid;
    }

    @VisibleForTesting
    public static void clearStaticState() {
        sNewMinidumpDirectory = null;
        sErrorLogDirectory = null;
        sPendingMinidumpDirectory = null;
    }
}
