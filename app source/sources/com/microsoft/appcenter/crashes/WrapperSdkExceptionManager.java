package com.microsoft.appcenter.crashes;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;
import com.microsoft.appcenter.crashes.ingestion.models.ErrorAttachmentLog;
import com.microsoft.appcenter.crashes.ingestion.models.Exception;
import com.microsoft.appcenter.crashes.model.ErrorReport;
import com.microsoft.appcenter.crashes.utils.ErrorLogHelper;
import com.microsoft.appcenter.utils.AppCenterLog;
import com.microsoft.appcenter.utils.DeviceInfoHelper;
import com.microsoft.appcenter.utils.async.AppCenterFuture;
import com.microsoft.appcenter.utils.storage.FileManager;
import java.io.File;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class WrapperSdkExceptionManager {
    private static final String DATA_FILE_EXTENSION = ".dat";
    @VisibleForTesting
    static final Map<String, String> sWrapperExceptionDataContainer;

    static {
        Map<String, String> map;
        new HashMap();
        sWrapperExceptionDataContainer = map;
    }

    @VisibleForTesting
    WrapperSdkExceptionManager() {
    }

    public static UUID saveWrapperException(Thread thread, Throwable throwable, Exception modelException, String str) {
        StringBuilder sb;
        String rawSerializedException = str;
        try {
            UUID errorId = Crashes.getInstance().saveUncaughtException(thread, throwable, modelException);
            if (!(errorId == null || rawSerializedException == null)) {
                String put = sWrapperExceptionDataContainer.put(errorId.toString(), rawSerializedException);
                File dataFile = getFile(errorId);
                FileManager.write(dataFile, rawSerializedException);
                new StringBuilder();
                AppCenterLog.debug(Crashes.LOG_TAG, sb.append("Saved raw wrapper exception data into ").append(dataFile).toString());
            }
            return errorId;
        } catch (Exception e) {
            AppCenterLog.error(Crashes.LOG_TAG, "Failed to save wrapper exception data to file", e);
            return null;
        }
    }

    public static void deleteWrapperExceptionData(UUID uuid) {
        UUID errorId = uuid;
        if (errorId == null) {
            AppCenterLog.error(Crashes.LOG_TAG, "Failed to delete wrapper exception data: null errorId");
            return;
        }
        File dataFile = getFile(errorId);
        if (dataFile.exists()) {
            if (loadWrapperExceptionData(errorId) == null) {
                AppCenterLog.error(Crashes.LOG_TAG, "Failed to load wrapper exception data.");
            }
            boolean delete = FileManager.delete(dataFile);
        }
    }

    public static String loadWrapperExceptionData(UUID uuid) {
        UUID errorId = uuid;
        if (errorId == null) {
            AppCenterLog.error(Crashes.LOG_TAG, "Failed to load wrapper exception data: null errorId");
            return null;
        }
        String data = sWrapperExceptionDataContainer.get(errorId.toString());
        if (data != null) {
            return data;
        }
        File dataFile = getFile(errorId);
        if (!dataFile.exists()) {
            return null;
        }
        String data2 = FileManager.read(dataFile);
        if (data2 != null) {
            String put = sWrapperExceptionDataContainer.put(errorId.toString(), data2);
        }
        return data2;
    }

    private static File getFile(@NonNull UUID errorId) {
        StringBuilder sb;
        File file;
        File errorStorageDirectory = ErrorLogHelper.getErrorStorageDirectory();
        new StringBuilder();
        new File(errorStorageDirectory, sb.append(errorId.toString()).append(DATA_FILE_EXTENSION).toString());
        return file;
    }

    public static String trackException(Exception modelException, Map<String, String> properties, Iterable<ErrorAttachmentLog> attachments) {
        return Crashes.getInstance().queueException(modelException, properties, attachments).toString();
    }

    public static void setAutomaticProcessing(boolean automaticProcessing) {
        Crashes.getInstance().setAutomaticProcessing(automaticProcessing);
    }

    public static AppCenterFuture<Collection<ErrorReport>> getUnprocessedErrorReports() {
        return Crashes.getInstance().getUnprocessedErrorReports();
    }

    public static AppCenterFuture<Boolean> sendCrashReportsOrAwaitUserConfirmation(Collection<String> filteredReportIds) {
        return Crashes.getInstance().sendCrashReportsOrAwaitUserConfirmation(filteredReportIds);
    }

    public static ErrorReport buildHandledErrorReport(Context context, String str) {
        ErrorReport errorReport;
        Date date;
        Date date2;
        StringBuilder sb;
        Context context2 = context;
        String errorReportId = str;
        new ErrorReport();
        ErrorReport report = errorReport;
        report.setId(errorReportId);
        new Date();
        report.setAppErrorTime(date);
        new Date(Crashes.getInstance().getInitializeTimestamp());
        report.setAppStartTime(date2);
        try {
            report.setDevice(Crashes.getInstance().getDeviceInfo(context2));
        } catch (DeviceInfoHelper.DeviceInfoException e) {
            DeviceInfoHelper.DeviceInfoException deviceInfoException = e;
            new StringBuilder();
            AppCenterLog.warn(Crashes.LOG_TAG, sb.append("Handled error report cannot get device info, errorReportId=").append(errorReportId).toString());
        }
        return report;
    }

    public static void sendErrorAttachments(String errorReportId, Iterable<ErrorAttachmentLog> attachments) {
        Crashes.getInstance().sendErrorAttachments(errorReportId, attachments);
    }
}
