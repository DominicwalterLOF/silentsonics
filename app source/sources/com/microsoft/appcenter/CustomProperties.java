package com.microsoft.appcenter;

import android.support.annotation.VisibleForTesting;
import com.microsoft.appcenter.utils.AppCenterLog;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class CustomProperties {
    private static final Pattern KEY_PATTERN = Pattern.compile("^[a-zA-Z][a-zA-Z0-9]*$");
    @VisibleForTesting
    static final int MAX_PROPERTIES_COUNT = 60;
    @VisibleForTesting
    static final int MAX_PROPERTY_KEY_LENGTH = 128;
    private static final int MAX_PROPERTY_VALUE_LENGTH = 128;
    private static final String VALUE_NULL_ERROR_MESSAGE = "Custom property value cannot be null, did you mean to call clear?";
    private final Map<String, Object> mProperties;

    public CustomProperties() {
        Map<String, Object> map;
        new HashMap();
        this.mProperties = map;
    }

    /* access modifiers changed from: package-private */
    public synchronized Map<String, Object> getProperties() {
        Map<String, Object> map;
        Map<String, Object> map2;
        synchronized (this) {
            Map<String, Object> map3 = map;
            new HashMap(this.mProperties);
            map2 = map3;
        }
        return map2;
    }

    public synchronized CustomProperties set(String str, String str2) {
        String key = str;
        String value = str2;
        synchronized (this) {
            if (isValidKey(key) && isValidStringValue(key, value)) {
                addProperty(key, value);
            }
        }
        return this;
    }

    public synchronized CustomProperties set(String str, Date date) {
        String key = str;
        Date value = date;
        synchronized (this) {
            if (isValidKey(key)) {
                if (value != null) {
                    addProperty(key, value);
                } else {
                    AppCenterLog.error("AppCenter", VALUE_NULL_ERROR_MESSAGE);
                }
            }
        }
        return this;
    }

    public synchronized CustomProperties set(String str, Number number) {
        String key = str;
        Number value = number;
        synchronized (this) {
            if (isValidKey(key) && isValidNumberValue(key, value)) {
                addProperty(key, value);
            }
        }
        return this;
    }

    public synchronized CustomProperties set(String str, boolean z) {
        String key = str;
        boolean value = z;
        synchronized (this) {
            if (isValidKey(key)) {
                addProperty(key, Boolean.valueOf(value));
            }
        }
        return this;
    }

    public synchronized CustomProperties clear(String str) {
        String key = str;
        synchronized (this) {
            if (isValidKey(key)) {
                addProperty(key, (Object) null);
            }
        }
        return this;
    }

    private void addProperty(String str, Object obj) {
        String key = str;
        Object value = obj;
        if (this.mProperties.containsKey(key) || this.mProperties.size() < 60) {
            Object put = this.mProperties.put(key, value);
        } else {
            AppCenterLog.error("AppCenter", "Custom properties cannot contain more than 60 items");
        }
    }

    private boolean isValidKey(String str) {
        StringBuilder sb;
        StringBuilder sb2;
        StringBuilder sb3;
        String key = str;
        if (key == null || !KEY_PATTERN.matcher(key).matches()) {
            new StringBuilder();
            AppCenterLog.error("AppCenter", sb.append("Custom property \"").append(key).append("\" must match \"").append(KEY_PATTERN).append("\"").toString());
            return false;
        } else if (key.length() > 128) {
            new StringBuilder();
            AppCenterLog.error("AppCenter", sb3.append("Custom property \"").append(key).append("\" length cannot be longer than ").append(128).append(" characters.").toString());
            return false;
        } else {
            if (this.mProperties.containsKey(key)) {
                new StringBuilder();
                AppCenterLog.warn("AppCenter", sb2.append("Custom property \"").append(key).append("\" is already set or cleared and will be overridden.").toString());
            }
            return true;
        }
    }

    private boolean isValidStringValue(String str, String str2) {
        StringBuilder sb;
        String key = str;
        String value = str2;
        if (value == null) {
            AppCenterLog.error("AppCenter", VALUE_NULL_ERROR_MESSAGE);
            return false;
        } else if (value.length() <= 128) {
            return true;
        } else {
            new StringBuilder();
            AppCenterLog.error("AppCenter", sb.append("Custom property \"").append(key).append("\" value length cannot be longer than ").append(128).append(" characters.").toString());
            return false;
        }
    }

    private boolean isValidNumberValue(String str, Number number) {
        StringBuilder sb;
        String key = str;
        Number value = number;
        if (value == null) {
            AppCenterLog.error("AppCenter", VALUE_NULL_ERROR_MESSAGE);
            return false;
        }
        double doubleValue = value.doubleValue();
        if (!Double.isInfinite(doubleValue) && !Double.isNaN(doubleValue)) {
            return true;
        }
        new StringBuilder();
        AppCenterLog.error("AppCenter", sb.append("Custom property \"").append(key).append("\" value cannot be NaN or infinite.").toString());
        return false;
    }
}
