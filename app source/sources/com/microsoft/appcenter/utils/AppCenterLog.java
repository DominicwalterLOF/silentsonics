package com.microsoft.appcenter.utils;

import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.util.Log;

public class AppCenterLog {
    public static final String LOG_TAG = "AppCenter";
    public static final int NONE = 8;
    private static int sLogLevel = 7;

    public AppCenterLog() {
    }

    @IntRange(from = 2, to = 8)
    public static int getLogLevel() {
        return sLogLevel;
    }

    public static void setLogLevel(@IntRange(from = 2, to = 8) int logLevel) {
        sLogLevel = logLevel;
    }

    public static void verbose(@NonNull String str, @NonNull String str2) {
        String tag = str;
        String message = str2;
        if (sLogLevel <= 2) {
            int v = Log.v(tag, message);
        }
    }

    public static void verbose(@NonNull String str, @NonNull String str2, Throwable th) {
        String tag = str;
        String message = str2;
        Throwable throwable = th;
        if (sLogLevel <= 2) {
            int v = Log.v(tag, message, throwable);
        }
    }

    public static void debug(@NonNull String str, @NonNull String str2) {
        String tag = str;
        String message = str2;
        if (sLogLevel <= 3) {
            int d = Log.d(tag, message);
        }
    }

    public static void debug(@NonNull String str, @NonNull String str2, Throwable th) {
        String tag = str;
        String message = str2;
        Throwable throwable = th;
        if (sLogLevel <= 3) {
            int d = Log.d(tag, message, throwable);
        }
    }

    public static void info(@NonNull String str, @NonNull String str2) {
        String tag = str;
        String message = str2;
        if (sLogLevel <= 4) {
            int i = Log.i(tag, message);
        }
    }

    public static void info(@NonNull String str, @NonNull String str2, Throwable th) {
        String tag = str;
        String message = str2;
        Throwable throwable = th;
        if (sLogLevel <= 4) {
            int i = Log.i(tag, message, throwable);
        }
    }

    public static void warn(@NonNull String str, @NonNull String str2) {
        String tag = str;
        String message = str2;
        if (sLogLevel <= 5) {
            int w = Log.w(tag, message);
        }
    }

    public static void warn(@NonNull String str, @NonNull String str2, Throwable th) {
        String tag = str;
        String message = str2;
        Throwable throwable = th;
        if (sLogLevel <= 5) {
            int w = Log.w(tag, message, throwable);
        }
    }

    public static void error(@NonNull String str, @NonNull String str2) {
        String tag = str;
        String message = str2;
        if (sLogLevel <= 6) {
            int e = Log.e(tag, message);
        }
    }

    public static void error(@NonNull String str, @NonNull String str2, Throwable th) {
        String tag = str;
        String message = str2;
        Throwable throwable = th;
        if (sLogLevel <= 6) {
            int e = Log.e(tag, message, throwable);
        }
    }

    public static void logAssert(@NonNull String str, @NonNull String str2) {
        String tag = str;
        String message = str2;
        if (sLogLevel <= 7) {
            int println = Log.println(7, tag, message);
        }
    }

    public static void logAssert(@NonNull String str, @NonNull String str2, Throwable th) {
        StringBuilder sb;
        String tag = str;
        String message = str2;
        Throwable throwable = th;
        if (sLogLevel <= 7) {
            new StringBuilder();
            int println = Log.println(7, tag, sb.append(message).append("\n").append(Log.getStackTraceString(throwable)).toString());
        }
    }
}
