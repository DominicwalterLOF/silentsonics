package com.airbnb.lottie.utils;

import android.util.Log;
import com.airbnb.lottie.L;
import com.airbnb.lottie.LottieLogger;
import java.util.HashSet;
import java.util.Set;

public class LogcatLogger implements LottieLogger {
    private static final Set<String> loggedMessages;

    public LogcatLogger() {
    }

    static {
        Set<String> set;
        new HashSet();
        loggedMessages = set;
    }

    public void debug(String message) {
        debug(message, (Throwable) null);
    }

    public void debug(String str, Throwable th) {
        String message = str;
        Throwable exception = th;
        if (L.DBG) {
            int d = Log.d(L.TAG, message, exception);
        }
    }

    public void warning(String message) {
        warning(message, (Throwable) null);
    }

    public void warning(String str, Throwable th) {
        String message = str;
        Throwable exception = th;
        if (!loggedMessages.contains(message)) {
            int w = Log.w(L.TAG, message, exception);
            boolean add = loggedMessages.add(message);
        }
    }
}
