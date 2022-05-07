package com.microsoft.appcenter.persistence;

import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.microsoft.appcenter.ingestion.models.Log;
import com.microsoft.appcenter.ingestion.models.json.LogSerializer;
import java.io.Closeable;
import java.util.Collection;
import java.util.List;

public abstract class Persistence implements Closeable {
    private LogSerializer mLogSerializer;

    public abstract void clearPendingLogState();

    public abstract int countLogs(@NonNull String str);

    public abstract void deleteLogs(String str);

    public abstract void deleteLogs(@NonNull String str, @NonNull String str2);

    @Nullable
    public abstract String getLogs(@NonNull String str, @NonNull Collection<String> collection, @IntRange(from = 0) int i, @NonNull List<Log> list);

    public abstract long putLog(@NonNull Log log, @NonNull String str, @IntRange(from = 1, to = 2) int i) throws PersistenceException;

    public abstract boolean setMaxStorageSize(long j);

    public Persistence() {
    }

    /* access modifiers changed from: package-private */
    public LogSerializer getLogSerializer() {
        Throwable th;
        if (this.mLogSerializer != null) {
            return this.mLogSerializer;
        }
        Throwable th2 = th;
        new IllegalStateException("logSerializer not configured");
        throw th2;
    }

    public void setLogSerializer(@NonNull LogSerializer logSerializer) {
        LogSerializer logSerializer2 = logSerializer;
        this.mLogSerializer = logSerializer2;
    }

    public static class PersistenceException extends Exception {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public PersistenceException(String detailMessage, Throwable throwable) {
            super(detailMessage, throwable);
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        PersistenceException(String detailMessage) {
            super(detailMessage);
        }
    }
}
