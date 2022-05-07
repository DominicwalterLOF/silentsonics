package org.jose4j.lang;

import androidx.core.os.EnvironmentCompat;
import java.util.List;
import java.util.Map;
import org.jose4j.jwt.IntDate;

public class JsonHelp {
    public JsonHelp() {
    }

    public static String getString(Map<String, Object> map, String name) {
        return (String) map.get(name);
    }

    public static String getStringChecked(Map<String, Object> map, String str) throws JoseException {
        Throwable th;
        StringBuilder sb;
        String name = str;
        Object o = map.get(name);
        try {
            return (String) o;
        } catch (ClassCastException e) {
            ClassCastException classCastException = e;
            Throwable th2 = th;
            new StringBuilder();
            new JoseException(sb.append("'").append(name).append("' parameter was ").append(jsonTypeName(o)).append(" type but is required to be a String.").toString());
            throw th2;
        }
    }

    public static List<String> getStringArray(Map<String, Object> map, String name) {
        return (List) map.get(name);
    }

    public static IntDate getIntDate(Map<String, Object> map, String name) {
        return IntDate.fromSeconds(getLong(map, name).longValue());
    }

    public static Long getLong(Map<String, ?> map, String name) {
        Object o = map.get(name);
        return o != null ? Long.valueOf(((Number) o).longValue()) : null;
    }

    public static String jsonTypeName(Object obj) {
        String jsonTypeName;
        Object value = obj;
        if (value instanceof Number) {
            jsonTypeName = "Number";
        } else if (value instanceof Boolean) {
            jsonTypeName = "Boolean";
        } else if (value instanceof List) {
            jsonTypeName = "Array";
        } else if (value instanceof Map) {
            jsonTypeName = "Object";
        } else {
            jsonTypeName = value instanceof String ? "String" : EnvironmentCompat.MEDIA_UNKNOWN;
        }
        return jsonTypeName;
    }
}
