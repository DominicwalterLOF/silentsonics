package org.jose4j.json.internal.json_simple;

import com.microsoft.appcenter.crashes.utils.ErrorLogHelper;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

public class JSONObject extends HashMap implements Map, JSONAware, JSONStreamAware {
    private static final long serialVersionUID = -503443796854799292L;

    public JSONObject() {
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public JSONObject(Map map) {
        super(map);
    }

    public static void writeJSONString(Map map, Writer writer) throws IOException {
        Map map2 = map;
        Writer out = writer;
        if (map2 == null) {
            out.write("null");
            return;
        }
        boolean first = true;
        out.write(123);
        for (Map.Entry entry : map2.entrySet()) {
            if (first) {
                first = false;
            } else {
                out.write(44);
            }
            out.write(34);
            out.write(escape(String.valueOf(entry.getKey())));
            out.write(34);
            out.write(58);
            JSONValue.writeJSONString(entry.getValue(), out);
        }
        out.write(ErrorLogHelper.MAX_PROPERTY_ITEM_LENGTH);
    }

    public void writeJSONString(Writer out) throws IOException {
        writeJSONString(this, out);
    }

    public static String toJSONString(Map map) {
        StringWriter stringWriter;
        Throwable th;
        new StringWriter();
        StringWriter writer = stringWriter;
        try {
            writeJSONString(map, writer);
            return writer.toString();
        } catch (IOException e) {
            IOException e2 = e;
            Throwable th2 = th;
            new RuntimeException(e2);
            throw th2;
        }
    }

    public String toJSONString() {
        return toJSONString(this);
    }

    public String toString() {
        return toJSONString();
    }

    public static String toString(String str, Object obj) {
        StringBuilder sb;
        String key = str;
        Object value = obj;
        new StringBuilder();
        StringBuilder sb2 = sb;
        StringBuilder append = sb2.append('\"');
        if (key == null) {
            StringBuilder append2 = sb2.append("null");
        } else {
            JSONValue.escape(key, sb2);
        }
        StringBuilder append3 = sb2.append('\"').append(':');
        StringBuilder append4 = sb2.append(JSONValue.toJSONString(value));
        return sb2.toString();
    }

    public static String escape(String s) {
        return JSONValue.escape(s);
    }
}
