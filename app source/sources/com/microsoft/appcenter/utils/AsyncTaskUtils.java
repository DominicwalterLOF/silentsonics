package com.microsoft.appcenter.utils;

import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;
import java.util.concurrent.RejectedExecutionException;

public class AsyncTaskUtils {
    @VisibleForTesting
    AsyncTaskUtils() {
    }

    @SafeVarargs
    @NonNull
    public static <Params, Type extends AsyncTask<Params, ?, ?>> Type execute(String str, @NonNull Type type, Params... paramsArr) {
        String logTag = str;
        Type asyncTask = type;
        Params[] params = paramsArr;
        try {
            return asyncTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, params);
        } catch (RejectedExecutionException e) {
            AppCenterLog.warn(logTag, "THREAD_POOL_EXECUTOR saturated, fall back on SERIAL_EXECUTOR which has an unbounded queue", e);
            return asyncTask.executeOnExecutor(AsyncTask.SERIAL_EXECUTOR, params);
        }
    }
}
