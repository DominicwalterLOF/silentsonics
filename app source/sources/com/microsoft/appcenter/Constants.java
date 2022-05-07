package com.microsoft.appcenter;

import android.content.Context;
import com.microsoft.appcenter.utils.AppCenterLog;

public class Constants {
    public static boolean APPLICATION_DEBUGGABLE = false;
    public static final String APP_SECRET = "App-Secret";
    public static final String AUTHORIZATION_HEADER = "Authorization";
    public static final String COMMON_SCHEMA_PREFIX_SEPARATOR = ":";
    public static final String DATABASE = "com.microsoft.appcenter.documents";
    static final int DEFAULT_TRIGGER_COUNT = 50;
    public static final int DEFAULT_TRIGGER_INTERVAL = 3000;
    static final int DEFAULT_TRIGGER_MAX_PARALLEL_REQUESTS = 3;
    public static String FILES_PATH = null;
    public static final String READONLY_TABLE = "app_documents";
    public static final String USER_TABLE_FORMAT = "user_%s_documents";
    public static final String WRAPPER_SDK_NAME_NDK = "appcenter.ndk";

    public Constants() {
    }

    public static void loadFromContext(Context context) {
        Context context2 = context;
        loadFilesPath(context2);
        setDebuggableFlag(context2);
    }

    private static void loadFilesPath(Context context) {
        Context context2 = context;
        if (context2 != null) {
            try {
                FILES_PATH = context2.getFilesDir().getAbsolutePath();
            } catch (Exception e) {
                AppCenterLog.error("AppCenter", "Exception thrown when accessing the application filesystem", e);
            }
        }
    }

    private static void setDebuggableFlag(Context context) {
        Context context2 = context;
        if (context2 != null && context2.getApplicationInfo() != null) {
            APPLICATION_DEBUGGABLE = (context2.getApplicationInfo().flags & 2) > 0;
        }
    }
}
