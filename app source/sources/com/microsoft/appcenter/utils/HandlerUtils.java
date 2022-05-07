package com.microsoft.appcenter.utils;

import android.os.Handler;
import android.os.Looper;
import android.support.annotation.VisibleForTesting;

public class HandlerUtils {
    @VisibleForTesting
    static final Handler sMainHandler;

    public HandlerUtils() {
    }

    static {
        Handler handler;
        new Handler(Looper.getMainLooper());
        sMainHandler = handler;
    }

    public static void runOnUiThread(Runnable runnable) {
        Runnable runnable2 = runnable;
        if (Thread.currentThread() == sMainHandler.getLooper().getThread()) {
            runnable2.run();
        } else {
            boolean post = sMainHandler.post(runnable2);
        }
    }

    public static Handler getMainHandler() {
        return sMainHandler;
    }
}
