package com.microsoft.appcenter.ingestion.models.json;

import android.support.annotation.VisibleForTesting;
import com.microsoft.appcenter.ingestion.models.Model;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

public class JSONUtils {
    @VisibleForTesting
    JSONUtils() {
    }

    public static Integer readInteger(JSONObject jSONObject, String str) throws JSONException {
        JSONObject object = jSONObject;
        String key = str;
        if (object.has(key)) {
            return Integer.valueOf(object.getInt(key));
        }
        return null;
    }

    public static Long readLong(JSONObject jSONObject, String str) throws JSONException {
        JSONObject object = jSONObject;
        String key = str;
        if (object.has(key)) {
            return Long.valueOf(object.getLong(key));
        }
        return null;
    }

    public static Boolean readBoolean(JSONObject jSONObject, String str) throws JSONException {
        JSONObject object = jSONObject;
        String key = str;
        if (object.has(key)) {
            return Boolean.valueOf(object.getBoolean(key));
        }
        return null;
    }

    public static Map<String, String> readMap(JSONObject object, String key) throws JSONException {
        Map<String, String> map;
        JSONObject jProperties = object.optJSONObject(key);
        if (jProperties == null) {
            return null;
        }
        new HashMap(jProperties.length());
        Map<String, String> properties = map;
        Iterator<String> subKeys = jProperties.keys();
        while (subKeys.hasNext()) {
            String subKey = subKeys.next();
            String put = properties.put(subKey, jProperties.getString(subKey));
        }
        return properties;
    }

    public static <M extends Model> List<M> readArray(JSONObject object, String key, ModelFactory<M> modelFactory) throws JSONException {
        ModelFactory<M> factory = modelFactory;
        JSONArray jArray = object.optJSONArray(key);
        if (jArray == null) {
            return null;
        }
        List<M> array = factory.createList(jArray.length());
        for (int i = 0; i < jArray.length(); i++) {
            JSONObject jModel = jArray.getJSONObject(i);
            M model = factory.create();
            model.read(jModel);
            boolean add = array.add(model);
        }
        return array;
    }

    public static List<String> readStringArray(JSONObject object, String key) throws JSONException {
        List<String> list;
        JSONArray jArray = object.optJSONArray(key);
        if (jArray == null) {
            return null;
        }
        new ArrayList(jArray.length());
        List<String> array = list;
        for (int i = 0; i < jArray.length(); i++) {
            boolean add = array.add(jArray.getString(i));
        }
        return array;
    }

    public static void write(JSONStringer jSONStringer, String str, Object obj) throws JSONException {
        JSONStringer writer = jSONStringer;
        String key = str;
        Object value = obj;
        if (value != null) {
            JSONStringer value2 = writer.key(key).value(value);
        }
    }

    public static void writeMap(JSONStringer jSONStringer, String str, Map<String, String> map) throws JSONException {
        JSONStringer writer = jSONStringer;
        String key = str;
        Map<String, String> value = map;
        if (value != null) {
            JSONStringer object = writer.key(key).object();
            for (Map.Entry<String, String> property : value.entrySet()) {
                JSONStringer value2 = writer.key(property.getKey()).value(property.getValue());
            }
            JSONStringer endObject = writer.endObject();
        }
    }

    public static void writeArray(JSONStringer jSONStringer, String str, List<? extends Model> list) throws JSONException {
        JSONStringer writer = jSONStringer;
        String key = str;
        List<? extends Model> value = list;
        if (value != null) {
            JSONStringer array = writer.key(key).array();
            for (Model model : value) {
                JSONStringer object = writer.object();
                model.write(writer);
                JSONStringer endObject = writer.endObject();
            }
            JSONStringer endArray = writer.endArray();
        }
    }

    public static void writeStringArray(JSONStringer jSONStringer, String str, List<String> list) throws JSONException {
        JSONStringer writer = jSONStringer;
        String key = str;
        List<String> values = list;
        if (values != null) {
            JSONStringer array = writer.key(key).array();
            for (String value : values) {
                JSONStringer value2 = writer.value(value);
            }
            JSONStringer endArray = writer.endArray();
        }
    }
}
