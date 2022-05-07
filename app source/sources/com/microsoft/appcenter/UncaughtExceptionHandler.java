package com.microsoft.appcenter;

import android.os.Handler;
import android.support.annotation.VisibleForTesting;
import com.microsoft.appcenter.channel.Channel;
import com.microsoft.appcenter.utils.AppCenterLog;
import com.microsoft.appcenter.utils.ShutdownHelper;
import java.lang.Thread;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

class UncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {
    private static final int SHUTDOWN_TIMEOUT = 5000;
    /* access modifiers changed from: private */
    public final Channel mChannel;
    private Thread.UncaughtExceptionHandler mDefaultUncaughtExceptionHandler;
    private final Handler mHandler;

    UncaughtExceptionHandler(Handler handler, Channel channel) {
        this.mHandler = handler;
        this.mChannel = channel;
    }

    public void uncaughtException(Thread thread, Throwable th) {
        Semaphore semaphore;
        Runnable runnable;
        Thread thread2 = thread;
        Throwable exception = th;
        if (AppCenter.getInstance().isInstanceEnabled()) {
            new Semaphore(0);
            Semaphore semaphore2 = semaphore;
            final Semaphore semaphore3 = semaphore2;
            new Runnable(this) {
                final /* synthetic */ UncaughtExceptionHandler this$0;

                {
                    this.this$0 = this$0;
                }

                public void run() {
                    this.this$0.mChannel.shutdown();
                    AppCenterLog.debug("AppCenter", "Channel completed shutdown.");
                    semaphore3.release();
                }
            };
            boolean post = this.mHandler.post(runnable);
            try {
                if (!semaphore2.tryAcquire(5000, TimeUnit.MILLISECONDS)) {
                    AppCenterLog.error("AppCenter", "Timeout waiting for looper tasks to complete.");
                }
            } catch (InterruptedException e) {
                AppCenterLog.warn("AppCenter", "Interrupted while waiting looper to flush.", e);
            }
        }
        if (this.mDefaultUncaughtExceptionHandler != null) {
            this.mDefaultUncaughtExceptionHandler.uncaughtException(thread2, exception);
        } else {
            ShutdownHelper.shutdown(10);
        }
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public Thread.UncaughtExceptionHandler getDefaultUncaughtExceptionHandler() {
        return this.mDefaultUncaughtExceptionHandler;
    }

    /* access modifiers changed from: package-private */
    public void register() {
        this.mDefaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    /* access modifiers changed from: package-private */
    public void unregister() {
        Thread.setDefaultUncaughtExceptionHandler(this.mDefaultUncaughtExceptionHandler);
    }
}
