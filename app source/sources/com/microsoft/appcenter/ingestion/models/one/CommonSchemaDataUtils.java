package com.microsoft.appcenter.ingestion.models.one;

import android.support.annotation.VisibleForTesting;
import com.microsoft.appcenter.ingestion.models.json.JSONDateUtils;
import com.microsoft.appcenter.ingestion.models.properties.BooleanTypedProperty;
import com.microsoft.appcenter.ingestion.models.properties.DateTimeTypedProperty;
import com.microsoft.appcenter.ingestion.models.properties.DoubleTypedProperty;
import com.microsoft.appcenter.ingestion.models.properties.LongTypedProperty;
import com.microsoft.appcenter.ingestion.models.properties.StringTypedProperty;
import com.microsoft.appcenter.ingestion.models.properties.TypedProperty;
import com.microsoft.appcenter.utils.AppCenterLog;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class CommonSchemaDataUtils {
    @VisibleForTesting
    static final int DATA_TYPE_DATETIME = 9;
    @VisibleForTesting
    static final int DATA_TYPE_DOUBLE = 6;
    @VisibleForTesting
    static final int DATA_TYPE_INT64 = 4;
    @VisibleForTesting
    static final String METADATA_FIELDS = "f";

    public CommonSchemaDataUtils() {
    }

    public static void addCommonSchemaData(List<TypedProperty> list, CommonSchemaLog commonSchemaLog) {
        Data data;
        MetadataExtension metadataExtension;
        Extensions extensions;
        StringBuilder sb;
        JSONObject jSONObject;
        StringBuilder sb2;
        List<TypedProperty> properties = list;
        CommonSchemaLog dest = commonSchemaLog;
        if (properties != null) {
            try {
                new Data();
                Data data2 = data;
                dest.setData(data2);
                new MetadataExtension();
                MetadataExtension metadata = metadataExtension;
                for (TypedProperty property : properties) {
                    try {
                        Object value = validateProperty(property);
                        Integer metadataType = getMetadataType(property);
                        String[] keys = property.getName().split("\\.", -1);
                        int lastIndex = keys.length - 1;
                        JSONObject destProperties = data2.getProperties();
                        JSONObject destMetadata = metadata.getMetadata();
                        for (int i = 0; i < lastIndex; i++) {
                            String subKey = keys[i];
                            JSONObject subDataObject = destProperties.optJSONObject(subKey);
                            if (subDataObject == null) {
                                if (destProperties.has(subKey)) {
                                    new StringBuilder();
                                    AppCenterLog.warn("AppCenter", sb2.append("Property key '").append(subKey).append("' already has a value, the old value will be overridden.").toString());
                                }
                                new JSONObject();
                                subDataObject = jSONObject;
                                JSONObject put = destProperties.put(subKey, subDataObject);
                            }
                            destProperties = subDataObject;
                            destMetadata = addIntermediateMetadata(destMetadata, subKey);
                        }
                        String lastKey = keys[lastIndex];
                        if (destProperties.has(lastKey)) {
                            new StringBuilder();
                            AppCenterLog.warn("AppCenter", sb.append("Property key '").append(lastKey).append("' already has a value, the old value will be overridden.").toString());
                        }
                        JSONObject put2 = destProperties.put(lastKey, value);
                        addLeafMetadata(metadataType, destMetadata, lastKey);
                    } catch (IllegalArgumentException e) {
                        AppCenterLog.warn("AppCenter", e.getMessage());
                    }
                }
                JSONObject dataObject = data2.getProperties();
                String baseType = dataObject.optString("baseType", (String) null);
                JSONObject baseData = dataObject.optJSONObject("baseData");
                if (baseType == null && baseData != null) {
                    AppCenterLog.warn("AppCenter", "baseData was set but baseType is missing.");
                    Object remove = dataObject.remove("baseData");
                    Object remove2 = metadata.getMetadata().optJSONObject(METADATA_FIELDS).remove("baseData");
                }
                if (baseType != null && baseData == null) {
                    AppCenterLog.warn("AppCenter", "baseType was set but baseData is missing.");
                    Object remove3 = dataObject.remove("baseType");
                }
                if (!cleanUpEmptyObjectsInMetadata(metadata.getMetadata())) {
                    if (dest.getExt() == null) {
                        new Extensions();
                        dest.setExt(extensions);
                    }
                    dest.getExt().setMetadata(metadata);
                }
            } catch (JSONException e2) {
                JSONException jSONException = e2;
            }
        }
    }

    private static Object validateProperty(TypedProperty typedProperty) throws IllegalArgumentException, JSONException {
        Throwable th;
        StringBuilder sb;
        Object valueOf;
        Throwable th2;
        StringBuilder sb2;
        Throwable th3;
        Throwable th4;
        Throwable th5;
        Throwable th6;
        TypedProperty property = typedProperty;
        String key = property.getName();
        if (key == null) {
            Throwable th7 = th6;
            new IllegalArgumentException("Property key cannot be null.");
            throw th7;
        } else if (key.equals("baseType") && !(property instanceof StringTypedProperty)) {
            Throwable th8 = th5;
            new IllegalArgumentException("baseType must be a string.");
            throw th8;
        } else if (key.startsWith("baseType.")) {
            Throwable th9 = th4;
            new IllegalArgumentException("baseType must be a string.");
            throw th9;
        } else if (key.equals("baseData")) {
            Throwable th10 = th3;
            new IllegalArgumentException("baseData must be an object.");
            throw th10;
        } else {
            if (property instanceof StringTypedProperty) {
                valueOf = ((StringTypedProperty) property).getValue();
            } else if (property instanceof LongTypedProperty) {
                valueOf = Long.valueOf(((LongTypedProperty) property).getValue());
            } else if (property instanceof DoubleTypedProperty) {
                valueOf = Double.valueOf(((DoubleTypedProperty) property).getValue());
            } else if (property instanceof DateTimeTypedProperty) {
                valueOf = JSONDateUtils.toString(((DateTimeTypedProperty) property).getValue());
            } else if (property instanceof BooleanTypedProperty) {
                valueOf = Boolean.valueOf(((BooleanTypedProperty) property).getValue());
            } else {
                Throwable th11 = th;
                new StringBuilder();
                new IllegalArgumentException(sb.append("Unsupported property type: ").append(property.getType()).toString());
                throw th11;
            }
            if (valueOf != null) {
                return valueOf;
            }
            Throwable th12 = th2;
            new StringBuilder();
            new IllegalArgumentException(sb2.append("Value of property with key '").append(key).append("' cannot be null.").toString());
            throw th12;
        }
    }

    private static Integer getMetadataType(TypedProperty typedProperty) {
        TypedProperty property = typedProperty;
        if (property instanceof LongTypedProperty) {
            return 4;
        }
        if (property instanceof DoubleTypedProperty) {
            return 6;
        }
        if (property instanceof DateTimeTypedProperty) {
            return 9;
        }
        return null;
    }

    private static void addLeafMetadata(Integer num, JSONObject jSONObject, String str) throws JSONException {
        JSONObject jSONObject2;
        Integer metadataType = num;
        JSONObject destMetadata = jSONObject;
        String lastKey = str;
        JSONObject fields = destMetadata.optJSONObject(METADATA_FIELDS);
        if (metadataType != null) {
            if (fields == null) {
                new JSONObject();
                fields = jSONObject2;
                JSONObject put = destMetadata.put(METADATA_FIELDS, fields);
            }
            JSONObject put2 = fields.put(lastKey, metadataType);
        } else if (fields != null) {
            Object remove = fields.remove(lastKey);
        }
    }

    private static JSONObject addIntermediateMetadata(JSONObject jSONObject, String str) throws JSONException {
        JSONObject jSONObject2;
        JSONObject jSONObject3;
        JSONObject destMetadata = jSONObject;
        String subKey = str;
        JSONObject fields = destMetadata.optJSONObject(METADATA_FIELDS);
        if (fields == null) {
            new JSONObject();
            fields = jSONObject3;
            JSONObject put = destMetadata.put(METADATA_FIELDS, fields);
        }
        JSONObject subMetadataObject = fields.optJSONObject(subKey);
        if (subMetadataObject == null) {
            new JSONObject();
            subMetadataObject = jSONObject2;
            JSONObject put2 = fields.put(subKey, subMetadataObject);
        }
        return subMetadataObject;
    }

    private static boolean cleanUpEmptyObjectsInMetadata(JSONObject jSONObject) {
        JSONObject object = jSONObject;
        Iterator<String> iterator = object.keys();
        while (iterator.hasNext()) {
            JSONObject child = object.optJSONObject(iterator.next());
            if (child != null && cleanUpEmptyObjectsInMetadata(child)) {
                iterator.remove();
            }
        }
        return object.length() == 0;
    }
}
