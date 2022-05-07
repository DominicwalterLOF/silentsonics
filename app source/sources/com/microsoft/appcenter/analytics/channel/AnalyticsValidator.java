package com.microsoft.appcenter.analytics.channel;

import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;
import com.microsoft.appcenter.analytics.Analytics;
import com.microsoft.appcenter.analytics.ingestion.models.EventLog;
import com.microsoft.appcenter.analytics.ingestion.models.LogWithNameAndProperties;
import com.microsoft.appcenter.analytics.ingestion.models.PageLog;
import com.microsoft.appcenter.channel.AbstractChannelListener;
import com.microsoft.appcenter.ingestion.models.Log;
import com.microsoft.appcenter.ingestion.models.properties.StringTypedProperty;
import com.microsoft.appcenter.ingestion.models.properties.TypedProperty;
import com.microsoft.appcenter.utils.AppCenterLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

public class AnalyticsValidator extends AbstractChannelListener {
    @VisibleForTesting
    static final int MAX_NAME_LENGTH = 256;
    @VisibleForTesting
    static final int MAX_PROPERTY_COUNT = 20;
    @VisibleForTesting
    static final int MAX_PROPERTY_ITEM_LENGTH = 125;

    public AnalyticsValidator() {
    }

    private boolean validateLog(@NonNull LogWithNameAndProperties logWithNameAndProperties) {
        LogWithNameAndProperties log = logWithNameAndProperties;
        String name = validateName(log.getName(), log.getType());
        if (name == null) {
            return false;
        }
        Map<String, String> validatedProperties = validateProperties(log.getProperties(), name, log.getType());
        log.setName(name);
        log.setProperties(validatedProperties);
        return true;
    }

    private boolean validateLog(@NonNull EventLog eventLog) {
        EventLog log = eventLog;
        String name = validateName(log.getName(), log.getType());
        if (name == null) {
            return false;
        }
        validateProperties(log.getTypedProperties());
        log.setName(name);
        return true;
    }

    private static String validateName(String str, String str2) {
        StringBuilder sb;
        String name = str;
        String logType = str2;
        if (name == null || name.isEmpty()) {
            new StringBuilder();
            AppCenterLog.error(Analytics.LOG_TAG, sb.append(logType).append(" name cannot be null or empty.").toString());
            return null;
        }
        if (name.length() > 256) {
            Object[] objArr = new Object[3];
            objArr[0] = logType;
            Object[] objArr2 = objArr;
            objArr2[1] = name;
            Object[] objArr3 = objArr2;
            objArr3[2] = 256;
            AppCenterLog.warn(Analytics.LOG_TAG, String.format("%s '%s' : name length cannot be longer than %s characters. Name will be truncated.", objArr3));
            name = name.substring(0, 256);
        }
        return name;
    }

    private static Map<String, String> validateProperties(Map<String, String> map, String str, String str2) {
        Map<String, String> map2;
        Map<String, String> properties = map;
        String logName = str;
        String logType = str2;
        if (properties == null) {
            return null;
        }
        new HashMap();
        Map<String, String> result = map2;
        Iterator<Map.Entry<String, String>> it = properties.entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Map.Entry<String, String> property = it.next();
            String key = property.getKey();
            String value = property.getValue();
            if (result.size() >= 20) {
                Object[] objArr = new Object[3];
                objArr[0] = logType;
                Object[] objArr2 = objArr;
                objArr2[1] = logName;
                Object[] objArr3 = objArr2;
                objArr3[2] = 20;
                AppCenterLog.warn(Analytics.LOG_TAG, String.format("%s '%s' : properties cannot contain more than %s items. Skipping other properties.", objArr3));
                break;
            } else if (key == null || key.isEmpty()) {
                Object[] objArr4 = new Object[2];
                objArr4[0] = logType;
                Object[] objArr5 = objArr4;
                objArr5[1] = logName;
                AppCenterLog.warn(Analytics.LOG_TAG, String.format("%s '%s' : a property key cannot be null or empty. Property will be skipped.", objArr5));
            } else if (value == null) {
                Object[] objArr6 = new Object[4];
                objArr6[0] = logType;
                Object[] objArr7 = objArr6;
                objArr7[1] = logName;
                Object[] objArr8 = objArr7;
                objArr8[2] = key;
                Object[] objArr9 = objArr8;
                objArr9[3] = key;
                AppCenterLog.warn(Analytics.LOG_TAG, String.format("%s '%s' : property '%s' : property value cannot be null. Property '%s' will be skipped.", objArr9));
            } else {
                if (key.length() > 125) {
                    Object[] objArr10 = new Object[4];
                    objArr10[0] = logType;
                    Object[] objArr11 = objArr10;
                    objArr11[1] = logName;
                    Object[] objArr12 = objArr11;
                    objArr12[2] = key;
                    Object[] objArr13 = objArr12;
                    objArr13[3] = 125;
                    AppCenterLog.warn(Analytics.LOG_TAG, String.format("%s '%s' : property '%s' : property key length cannot be longer than %s characters. Property key will be truncated.", objArr13));
                    key = key.substring(0, 125);
                }
                if (value.length() > 125) {
                    Object[] objArr14 = new Object[4];
                    objArr14[0] = logType;
                    Object[] objArr15 = objArr14;
                    objArr15[1] = logName;
                    Object[] objArr16 = objArr15;
                    objArr16[2] = key;
                    Object[] objArr17 = objArr16;
                    objArr17[3] = 125;
                    AppCenterLog.warn(Analytics.LOG_TAG, String.format("%s '%s' : property '%s' : property value cannot be longer than %s characters. Property value will be truncated.", objArr17));
                    value = value.substring(0, 125);
                }
                String put = result.put(key, value);
            }
        }
        return result;
    }

    private static void validateProperties(List<TypedProperty> list) {
        StringTypedProperty stringTypedProperty;
        List<TypedProperty> properties = list;
        if (properties != null) {
            int count = 0;
            boolean maxCountReached = false;
            ListIterator<TypedProperty> iterator = properties.listIterator();
            while (iterator.hasNext()) {
                boolean copyNeededOnModification = true;
                TypedProperty property = iterator.next();
                String key = property.getName();
                if (count >= 20) {
                    if (!maxCountReached) {
                        AppCenterLog.warn(Analytics.LOG_TAG, String.format("Typed properties cannot contain more than %s items. Skipping other properties.", new Object[]{20}));
                        maxCountReached = true;
                    }
                    iterator.remove();
                } else if (key == null || key.isEmpty()) {
                    AppCenterLog.warn(Analytics.LOG_TAG, "A typed property key cannot be null or empty. Property will be skipped.");
                    iterator.remove();
                } else {
                    if (key.length() > 125) {
                        Object[] objArr = new Object[2];
                        objArr[0] = key;
                        Object[] objArr2 = objArr;
                        objArr2[1] = 125;
                        AppCenterLog.warn(Analytics.LOG_TAG, String.format("Typed property '%s' : property key length cannot be longer than %s characters. Property key will be truncated.", objArr2));
                        key = key.substring(0, 125);
                        property = copyProperty(property, key);
                        iterator.set(property);
                        copyNeededOnModification = false;
                    }
                    if (property instanceof StringTypedProperty) {
                        StringTypedProperty stringTypedProperty2 = (StringTypedProperty) property;
                        String value = stringTypedProperty2.getValue();
                        if (value == null) {
                            Object[] objArr3 = new Object[2];
                            objArr3[0] = key;
                            Object[] objArr4 = objArr3;
                            objArr4[1] = key;
                            AppCenterLog.warn(Analytics.LOG_TAG, String.format("Typed property '%s' : property value cannot be null. Property '%s' will be skipped.", objArr4));
                            iterator.remove();
                        } else if (value.length() > 125) {
                            Object[] objArr5 = new Object[2];
                            objArr5[0] = key;
                            Object[] objArr6 = objArr5;
                            objArr6[1] = 125;
                            AppCenterLog.warn(Analytics.LOG_TAG, String.format("A String property '%s' : property value cannot be longer than %s characters. Property value will be truncated.", objArr6));
                            String value2 = value.substring(0, 125);
                            if (copyNeededOnModification) {
                                new StringTypedProperty();
                                StringTypedProperty stringTypedProperty3 = stringTypedProperty;
                                stringTypedProperty3.setName(key);
                                stringTypedProperty3.setValue(value2);
                                iterator.set(stringTypedProperty3);
                            } else {
                                stringTypedProperty2.setValue(value2);
                            }
                        }
                    }
                    count++;
                }
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: com.microsoft.appcenter.ingestion.models.properties.StringTypedProperty} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v1, resolved type: com.microsoft.appcenter.ingestion.models.properties.StringTypedProperty} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v16, resolved type: com.microsoft.appcenter.ingestion.models.properties.LongTypedProperty} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: com.microsoft.appcenter.ingestion.models.properties.StringTypedProperty} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v2, resolved type: com.microsoft.appcenter.ingestion.models.properties.StringTypedProperty} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v20, resolved type: com.microsoft.appcenter.ingestion.models.properties.DoubleTypedProperty} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v3, resolved type: com.microsoft.appcenter.ingestion.models.properties.StringTypedProperty} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v3, resolved type: com.microsoft.appcenter.ingestion.models.properties.StringTypedProperty} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v24, resolved type: com.microsoft.appcenter.ingestion.models.properties.DateTimeTypedProperty} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v4, resolved type: com.microsoft.appcenter.ingestion.models.properties.StringTypedProperty} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v4, resolved type: com.microsoft.appcenter.ingestion.models.properties.StringTypedProperty} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v30, resolved type: com.microsoft.appcenter.ingestion.models.properties.BooleanTypedProperty} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.microsoft.appcenter.ingestion.models.properties.TypedProperty copyProperty(com.microsoft.appcenter.ingestion.models.properties.TypedProperty r9, java.lang.String r10) {
        /*
            r0 = r9
            r1 = r10
            r5 = r0
            java.lang.String r5 = r5.getType()
            r2 = r5
            java.lang.String r5 = "boolean"
            r6 = r2
            boolean r5 = r5.equals(r6)
            if (r5 == 0) goto L_0x0030
            com.microsoft.appcenter.ingestion.models.properties.BooleanTypedProperty r5 = new com.microsoft.appcenter.ingestion.models.properties.BooleanTypedProperty
            r8 = r5
            r5 = r8
            r6 = r8
            r6.<init>()
            r4 = r5
            r5 = r4
            r6 = r0
            com.microsoft.appcenter.ingestion.models.properties.BooleanTypedProperty r6 = (com.microsoft.appcenter.ingestion.models.properties.BooleanTypedProperty) r6
            boolean r6 = r6.getValue()
            r5.setValue(r6)
            r5 = r4
            r3 = r5
        L_0x0028:
            r5 = r3
            r6 = r1
            r5.setName(r6)
            r5 = r3
            r0 = r5
            return r0
        L_0x0030:
            java.lang.String r5 = "dateTime"
            r6 = r2
            boolean r5 = r5.equals(r6)
            if (r5 == 0) goto L_0x0051
            com.microsoft.appcenter.ingestion.models.properties.DateTimeTypedProperty r5 = new com.microsoft.appcenter.ingestion.models.properties.DateTimeTypedProperty
            r8 = r5
            r5 = r8
            r6 = r8
            r6.<init>()
            r4 = r5
            r5 = r4
            r6 = r0
            com.microsoft.appcenter.ingestion.models.properties.DateTimeTypedProperty r6 = (com.microsoft.appcenter.ingestion.models.properties.DateTimeTypedProperty) r6
            java.util.Date r6 = r6.getValue()
            r5.setValue(r6)
            r5 = r4
            r3 = r5
            goto L_0x0028
        L_0x0051:
            java.lang.String r5 = "double"
            r6 = r2
            boolean r5 = r5.equals(r6)
            if (r5 == 0) goto L_0x0072
            com.microsoft.appcenter.ingestion.models.properties.DoubleTypedProperty r5 = new com.microsoft.appcenter.ingestion.models.properties.DoubleTypedProperty
            r8 = r5
            r5 = r8
            r6 = r8
            r6.<init>()
            r4 = r5
            r5 = r4
            r6 = r0
            com.microsoft.appcenter.ingestion.models.properties.DoubleTypedProperty r6 = (com.microsoft.appcenter.ingestion.models.properties.DoubleTypedProperty) r6
            double r6 = r6.getValue()
            r5.setValue(r6)
            r5 = r4
            r3 = r5
            goto L_0x0028
        L_0x0072:
            java.lang.String r5 = "long"
            r6 = r2
            boolean r5 = r5.equals(r6)
            if (r5 == 0) goto L_0x0093
            com.microsoft.appcenter.ingestion.models.properties.LongTypedProperty r5 = new com.microsoft.appcenter.ingestion.models.properties.LongTypedProperty
            r8 = r5
            r5 = r8
            r6 = r8
            r6.<init>()
            r4 = r5
            r5 = r4
            r6 = r0
            com.microsoft.appcenter.ingestion.models.properties.LongTypedProperty r6 = (com.microsoft.appcenter.ingestion.models.properties.LongTypedProperty) r6
            long r6 = r6.getValue()
            r5.setValue(r6)
            r5 = r4
            r3 = r5
            goto L_0x0028
        L_0x0093:
            com.microsoft.appcenter.ingestion.models.properties.StringTypedProperty r5 = new com.microsoft.appcenter.ingestion.models.properties.StringTypedProperty
            r8 = r5
            r5 = r8
            r6 = r8
            r6.<init>()
            r4 = r5
            r5 = r4
            r6 = r0
            com.microsoft.appcenter.ingestion.models.properties.StringTypedProperty r6 = (com.microsoft.appcenter.ingestion.models.properties.StringTypedProperty) r6
            java.lang.String r6 = r6.getValue()
            r5.setValue(r6)
            r5 = r4
            r3 = r5
            goto L_0x0028
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microsoft.appcenter.analytics.channel.AnalyticsValidator.copyProperty(com.microsoft.appcenter.ingestion.models.properties.TypedProperty, java.lang.String):com.microsoft.appcenter.ingestion.models.properties.TypedProperty");
    }

    public boolean shouldFilter(@NonNull Log log) {
        Log log2 = log;
        if (log2 instanceof PageLog) {
            return !validateLog((LogWithNameAndProperties) log2);
        } else if (!(log2 instanceof EventLog)) {
            return false;
        } else {
            return !validateLog((EventLog) log2);
        }
    }
}
