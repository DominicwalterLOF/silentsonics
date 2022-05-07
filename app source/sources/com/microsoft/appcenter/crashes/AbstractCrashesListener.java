package com.microsoft.appcenter.crashes;

import com.microsoft.appcenter.crashes.ingestion.models.ErrorAttachmentLog;
import com.microsoft.appcenter.crashes.model.ErrorReport;

public abstract class AbstractCrashesListener implements CrashesListener {
    public AbstractCrashesListener() {
    }

    public boolean shouldProcess(ErrorReport errorReport) {
        ErrorReport errorReport2 = errorReport;
        return true;
    }

    public boolean shouldAwaitUserConfirmation() {
        return false;
    }

    public Iterable<ErrorAttachmentLog> getErrorAttachments(ErrorReport errorReport) {
        ErrorReport errorReport2 = errorReport;
        return null;
    }

    public void onBeforeSending(ErrorReport report) {
    }

    public void onSendingFailed(ErrorReport report, Exception e) {
    }

    public void onSendingSucceeded(ErrorReport report) {
    }
}
