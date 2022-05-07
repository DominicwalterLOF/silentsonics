package com.microsoft.appcenter.crashes;

import android.support.annotation.VisibleForTesting;
import com.microsoft.appcenter.utils.ShutdownHelper;
import java.lang.Thread;

class UncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {
    private Thread.UncaughtExceptionHandler mDefaultUncaughtExceptionHandler;
    private boolean mIgnoreDefaultExceptionHandler = false;

    UncaughtExceptionHandler() {
    }

    public void uncaughtException(Thread thread, Throwable th) {
        Thread thread2 = thread;
        Throwable exception = th;
        Crashes.getInstance().saveUncaughtException(thread2, exception);
        if (this.mDefaultUncaughtExceptionHandler != null) {
            this.mDefaultUncaughtExceptionHandler.uncaughtException(thread2, exception);
        } else {
            ShutdownHelper.shutdown(10);
        }
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public void setIgnoreDefaultExceptionHandler(boolean z) {
        boolean ignoreDefaultExceptionHandler = z;
        this.mIgnoreDefaultExceptionHandler = ignoreDefaultExceptionHandler;
        if (ignoreDefaultExceptionHandler) {
            this.mDefaultUncaughtExceptionHandler = null;
        }
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public Thread.UncaughtExceptionHandler getDefaultUncaughtExceptionHandler() {
        return this.mDefaultUncaughtExceptionHandler;
    }

    /* access modifiers changed from: package-private */
    public void register() {
        if (!this.mIgnoreDefaultExceptionHandler) {
            this.mDefaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        } else {
            this.mDefaultUncaughtExceptionHandler = null;
        }
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    /* access modifiers changed from: package-private */
    public void unregister() {
        Thread.setDefaultUncaughtExceptionHandler(this.mDefaultUncaughtExceptionHandler);
    }
}
