package com.microsoft.appcenter;

import com.microsoft.appcenter.utils.AppCenterLog;

public final class Flags {
    public static final int CRITICAL = 2;
    public static final int DEFAULTS = 1;
    public static final int NORMAL = 1;
    @Deprecated
    public static final int PERSISTENCE_CRITICAL = 2;
    private static final int PERSISTENCE_MASK = 255;
    @Deprecated
    public static final int PERSISTENCE_NORMAL = 1;

    public Flags() {
    }

    public static int getPersistenceFlag(int flags, boolean z) {
        StringBuilder sb;
        boolean warnFallback = z;
        int persistencePriority = flags & 255;
        if (!(persistencePriority == 1 || persistencePriority == 2)) {
            if (persistencePriority != 0 && warnFallback) {
                new StringBuilder();
                AppCenterLog.warn("AppCenter", sb.append("Invalid value=").append(persistencePriority).append(" for persistence flag, using NORMAL as a default.").toString());
            }
            persistencePriority = 1;
        }
        return persistencePriority;
    }
}
