package com.microsoft.appcenter.analytics;

import com.microsoft.appcenter.ingestion.models.properties.BooleanTypedProperty;
import com.microsoft.appcenter.ingestion.models.properties.DateTimeTypedProperty;
import com.microsoft.appcenter.ingestion.models.properties.DoubleTypedProperty;
import com.microsoft.appcenter.ingestion.models.properties.LongTypedProperty;
import com.microsoft.appcenter.ingestion.models.properties.StringTypedProperty;
import com.microsoft.appcenter.ingestion.models.properties.TypedProperty;
import com.microsoft.appcenter.utils.AppCenterLog;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class EventProperties {
    private static final String VALUE_NULL_ERROR_MESSAGE = "Property value cannot be null";
    private final Map<String, TypedProperty> mProperties;

    public EventProperties() {
        Map<String, TypedProperty> map;
        new ConcurrentHashMap();
        this.mProperties = map;
    }

    /* access modifiers changed from: package-private */
    public Map<String, TypedProperty> getProperties() {
        return this.mProperties;
    }

    public EventProperties set(String str, boolean z) {
        BooleanTypedProperty booleanTypedProperty;
        String key = str;
        boolean value = z;
        if (isValidKey(key)) {
            new BooleanTypedProperty();
            BooleanTypedProperty property = booleanTypedProperty;
            property.setName(key);
            property.setValue(value);
            TypedProperty put = this.mProperties.put(key, property);
        }
        return this;
    }

    public EventProperties set(String str, Date date) {
        DateTimeTypedProperty dateTimeTypedProperty;
        String key = str;
        Date value = date;
        if (isValidKey(key) && isValidValue(value)) {
            new DateTimeTypedProperty();
            DateTimeTypedProperty property = dateTimeTypedProperty;
            property.setName(key);
            property.setValue(value);
            TypedProperty put = this.mProperties.put(key, property);
        }
        return this;
    }

    public EventProperties set(String str, double d) {
        DoubleTypedProperty doubleTypedProperty;
        String key = str;
        double value = d;
        if (isValidKey(key)) {
            if (Double.isInfinite(value) || Double.isNaN(value)) {
                AppCenterLog.error(Analytics.LOG_TAG, "Double property value cannot be NaN or infinite.");
            } else {
                new DoubleTypedProperty();
                DoubleTypedProperty property = doubleTypedProperty;
                property.setName(key);
                property.setValue(value);
                TypedProperty put = this.mProperties.put(key, property);
            }
        }
        return this;
    }

    public EventProperties set(String str, long j) {
        LongTypedProperty longTypedProperty;
        String key = str;
        long value = j;
        if (isValidKey(key)) {
            new LongTypedProperty();
            LongTypedProperty property = longTypedProperty;
            property.setName(key);
            property.setValue(value);
            TypedProperty put = this.mProperties.put(key, property);
        }
        return this;
    }

    public EventProperties set(String str, String str2) {
        StringTypedProperty stringTypedProperty;
        String key = str;
        String value = str2;
        if (isValidKey(key) && isValidValue(value)) {
            new StringTypedProperty();
            StringTypedProperty property = stringTypedProperty;
            property.setName(key);
            property.setValue(value);
            TypedProperty put = this.mProperties.put(key, property);
        }
        return this;
    }

    private boolean isValidKey(String str) {
        StringBuilder sb;
        String key = str;
        if (key == null) {
            AppCenterLog.error(Analytics.LOG_TAG, "Property key must not be null");
            return false;
        }
        if (this.mProperties.containsKey(key)) {
            new StringBuilder();
            AppCenterLog.warn(Analytics.LOG_TAG, sb.append("Property \"").append(key).append("\" is already set and will be overridden.").toString());
        }
        return true;
    }

    private boolean isValidValue(Object value) {
        if (value != null) {
            return true;
        }
        AppCenterLog.error(Analytics.LOG_TAG, VALUE_NULL_ERROR_MESSAGE);
        return false;
    }
}
