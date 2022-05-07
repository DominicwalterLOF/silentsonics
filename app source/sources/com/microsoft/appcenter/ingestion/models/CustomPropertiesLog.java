package com.microsoft.appcenter.ingestion.models;

import com.microsoft.appcenter.ingestion.models.json.JSONDateUtils;
import com.microsoft.appcenter.ingestion.models.json.JSONUtils;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

public class CustomPropertiesLog extends AbstractLog {
    private static final String PROPERTIES = "properties";
    private static final String PROPERTY_NAME = "name";
    private static final String PROPERTY_TYPE = "type";
    private static final String PROPERTY_TYPE_BOOLEAN = "boolean";
    private static final String PROPERTY_TYPE_CLEAR = "clear";
    private static final String PROPERTY_TYPE_DATETIME = "dateTime";
    private static final String PROPERTY_TYPE_NUMBER = "number";
    private static final String PROPERTY_TYPE_STRING = "string";
    private static final String PROPERTY_VALUE = "value";
    public static final String TYPE = "customProperties";
    private Map<String, Object> properties;

    public CustomPropertiesLog() {
    }

    private static Map<String, Object> readProperties(JSONObject object) throws JSONException {
        Map<String, Object> map;
        JSONArray jArray = object.getJSONArray(PROPERTIES);
        new HashMap();
        Map<String, Object> properties2 = map;
        for (int i = 0; i < jArray.length(); i++) {
            JSONObject jProperty = jArray.getJSONObject(i);
            Object put = properties2.put(jProperty.getString("name"), readPropertyValue(jProperty));
        }
        return properties2;
    }

    private static Object readPropertyValue(JSONObject jSONObject) throws JSONException {
        Throwable th;
        Object value;
        Throwable th2;
        JSONObject object = jSONObject;
        String type = object.getString("type");
        if (type.equals(PROPERTY_TYPE_CLEAR)) {
            value = null;
        } else if (type.equals("boolean")) {
            value = Boolean.valueOf(object.getBoolean("value"));
        } else if (type.equals(PROPERTY_TYPE_NUMBER)) {
            value = object.get("value");
            if (!(value instanceof Number)) {
                Throwable th3 = th2;
                new JSONException("Invalid value type");
                throw th3;
            }
        } else if (type.equals("dateTime")) {
            value = JSONDateUtils.toDate(object.getString("value"));
        } else if (type.equals("string")) {
            value = object.getString("value");
        } else {
            Throwable th4 = th;
            new JSONException("Invalid value type");
            throw th4;
        }
        return value;
    }

    private static void writeProperties(JSONStringer jSONStringer, Map<String, Object> map) throws JSONException {
        Throwable th;
        JSONStringer writer = jSONStringer;
        Map<String, Object> properties2 = map;
        if (properties2 != null) {
            JSONStringer array = writer.key(PROPERTIES).array();
            for (Map.Entry<String, Object> property : properties2.entrySet()) {
                JSONStringer object = writer.object();
                JSONUtils.write(writer, "name", property.getKey());
                writePropertyValue(writer, property.getValue());
                JSONStringer endObject = writer.endObject();
            }
            JSONStringer endArray = writer.endArray();
            return;
        }
        Throwable th2 = th;
        new JSONException("Properties cannot be null");
        throw th2;
    }

    private static void writePropertyValue(JSONStringer jSONStringer, Object obj) throws JSONException {
        Throwable th;
        JSONStringer writer = jSONStringer;
        Object value = obj;
        if (value == null) {
            JSONUtils.write(writer, "type", PROPERTY_TYPE_CLEAR);
        } else if (value instanceof Boolean) {
            JSONUtils.write(writer, "type", "boolean");
            JSONUtils.write(writer, "value", value);
        } else if (value instanceof Number) {
            JSONUtils.write(writer, "type", PROPERTY_TYPE_NUMBER);
            JSONUtils.write(writer, "value", value);
        } else if (value instanceof Date) {
            JSONUtils.write(writer, "type", "dateTime");
            JSONUtils.write(writer, "value", JSONDateUtils.toString((Date) value));
        } else if (value instanceof String) {
            JSONUtils.write(writer, "type", "string");
            JSONUtils.write(writer, "value", value);
        } else {
            Throwable th2 = th;
            new JSONException("Invalid value type");
            throw th2;
        }
    }

    public String getType() {
        return TYPE;
    }

    public Map<String, Object> getProperties() {
        return this.properties;
    }

    public void setProperties(Map<String, Object> properties2) {
        Map<String, Object> map = properties2;
        this.properties = map;
    }

    public void read(JSONObject jSONObject) throws JSONException {
        JSONObject object = jSONObject;
        super.read(object);
        setProperties(readProperties(object));
    }

    public void write(JSONStringer jSONStringer) throws JSONException {
        JSONStringer writer = jSONStringer;
        super.write(writer);
        writeProperties(writer, getProperties());
    }

    public boolean equals(Object obj) {
        Object o = obj;
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        CustomPropertiesLog that = (CustomPropertiesLog) o;
        return this.properties != null ? this.properties.equals(that.properties) : that.properties == null;
    }

    public int hashCode() {
        return (31 * super.hashCode()) + (this.properties != null ? this.properties.hashCode() : 0);
    }
}
