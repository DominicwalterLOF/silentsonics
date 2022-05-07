package com.microsoft.appcenter.utils.context;

import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;
import android.text.TextUtils;
import com.microsoft.appcenter.Constants;
import com.microsoft.appcenter.utils.AppCenterLog;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class UserIdContext {
    private static final String CUSTOM_PREFIX = "c";
    @VisibleForTesting
    public static final int USER_ID_APP_CENTER_MAX_LENGTH = 256;
    private static UserIdContext sInstance;
    private final Set<Listener> mListeners;
    private String mUserId;

    public interface Listener {
        void onNewUserId(String str);
    }

    public UserIdContext() {
        Map map;
        new ConcurrentHashMap();
        this.mListeners = Collections.newSetFromMap(map);
    }

    public static synchronized UserIdContext getInstance() {
        UserIdContext userIdContext;
        UserIdContext userIdContext2;
        synchronized (UserIdContext.class) {
            if (sInstance == null) {
                new UserIdContext();
                sInstance = userIdContext2;
            }
            userIdContext = sInstance;
        }
        return userIdContext;
    }

    @VisibleForTesting
    public static synchronized void unsetInstance() {
        synchronized (UserIdContext.class) {
            sInstance = null;
        }
    }

    public static boolean checkUserIdValidForOneCollector(String str) {
        String userId = str;
        if (userId == null) {
            return true;
        }
        if (userId.isEmpty()) {
            AppCenterLog.error("AppCenter", "userId must not be empty.");
            return false;
        }
        int prefixIndex = userId.indexOf(Constants.COMMON_SCHEMA_PREFIX_SEPARATOR);
        if (prefixIndex >= 0) {
            String prefix = userId.substring(0, prefixIndex);
            if (!prefix.equals(CUSTOM_PREFIX)) {
                Object[] objArr = new Object[4];
                objArr[0] = CUSTOM_PREFIX;
                Object[] objArr2 = objArr;
                objArr2[1] = Constants.COMMON_SCHEMA_PREFIX_SEPARATOR;
                Object[] objArr3 = objArr2;
                objArr3[2] = prefix;
                Object[] objArr4 = objArr3;
                objArr4[3] = Constants.COMMON_SCHEMA_PREFIX_SEPARATOR;
                AppCenterLog.error("AppCenter", String.format("userId prefix must be '%s%s', '%s%s' is not supported.", objArr4));
                return false;
            } else if (prefixIndex == userId.length() - 1) {
                AppCenterLog.error("AppCenter", "userId must not be empty.");
                return false;
            }
        }
        return true;
    }

    public static boolean checkUserIdValidForAppCenter(String str) {
        String userId = str;
        if (userId == null || userId.length() <= 256) {
            return true;
        }
        AppCenterLog.error("AppCenter", "userId is limited to 256 characters.");
        return false;
    }

    public static String getPrefixedUserId(String str) {
        StringBuilder sb;
        String userId = str;
        if (userId == null || userId.contains(Constants.COMMON_SCHEMA_PREFIX_SEPARATOR)) {
            return userId;
        }
        new StringBuilder();
        return sb.append("c:").append(userId).toString();
    }

    public void addListener(@NonNull Listener listener) {
        boolean add = this.mListeners.add(listener);
    }

    public void removeListener(@NonNull Listener listener) {
        boolean remove = this.mListeners.remove(listener);
    }

    public synchronized String getUserId() {
        String str;
        synchronized (this) {
            str = this.mUserId;
        }
        return str;
    }

    public void setUserId(String userId) {
        if (updateUserId(userId)) {
            for (Listener listener : this.mListeners) {
                listener.onNewUserId(this.mUserId);
            }
        }
    }

    private synchronized boolean updateUserId(String str) {
        boolean z;
        String userId = str;
        synchronized (this) {
            if (TextUtils.equals(this.mUserId, userId)) {
                z = false;
            } else {
                this.mUserId = userId;
                z = true;
            }
        }
        return z;
    }
}
