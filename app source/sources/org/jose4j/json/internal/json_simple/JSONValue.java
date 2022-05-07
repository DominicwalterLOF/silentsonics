package org.jose4j.json.internal.json_simple;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Collection;
import java.util.Map;
import org.jose4j.json.internal.json_simple.parser.JSONParser;
import org.jose4j.json.internal.json_simple.parser.ParseException;

public class JSONValue {
    public JSONValue() {
    }

    public static Object parse(Reader reader) {
        JSONParser parser;
        Reader in = reader;
        try {
            new JSONParser();
            return parser.parse(in);
        } catch (Exception e) {
            Exception exc = e;
            return null;
        }
    }

    public static Object parse(String s) {
        Reader reader;
        new StringReader(s);
        return parse(reader);
    }

    public static Object parseWithException(Reader in) throws IOException, ParseException {
        JSONParser parser;
        new JSONParser();
        return parser.parse(in);
    }

    public static Object parseWithException(String s) throws ParseException {
        JSONParser parser;
        new JSONParser();
        return parser.parse(s);
    }

    public static void writeJSONString(Object obj, Writer writer) throws IOException {
        Object value = obj;
        Writer out = writer;
        if (value == null) {
            out.write("null");
        } else if (value instanceof String) {
            out.write(34);
            out.write(escape((String) value));
            out.write(34);
        } else if (value instanceof Double) {
            if (((Double) value).isInfinite() || ((Double) value).isNaN()) {
                out.write("null");
            } else {
                out.write(value.toString());
            }
        } else if (value instanceof Float) {
            if (((Float) value).isInfinite() || ((Float) value).isNaN()) {
                out.write("null");
            } else {
                out.write(value.toString());
            }
        } else if (value instanceof Number) {
            out.write(value.toString());
        } else if (value instanceof Boolean) {
            out.write(value.toString());
        } else if (value instanceof JSONStreamAware) {
            ((JSONStreamAware) value).writeJSONString(out);
        } else if (value instanceof JSONAware) {
            out.write(((JSONAware) value).toJSONString());
        } else if (value instanceof Map) {
            JSONObject.writeJSONString((Map) value, out);
        } else if (value instanceof Collection) {
            JSONArray.writeJSONString((Collection) value, out);
        } else if (value instanceof byte[]) {
            JSONArray.writeJSONString((byte[]) value, out);
        } else if (value instanceof short[]) {
            JSONArray.writeJSONString((short[]) value, out);
        } else if (value instanceof int[]) {
            JSONArray.writeJSONString((int[]) value, out);
        } else if (value instanceof long[]) {
            JSONArray.writeJSONString((long[]) value, out);
        } else if (value instanceof float[]) {
            JSONArray.writeJSONString((float[]) value, out);
        } else if (value instanceof double[]) {
            JSONArray.writeJSONString((double[]) value, out);
        } else if (value instanceof boolean[]) {
            JSONArray.writeJSONString((boolean[]) value, out);
        } else if (value instanceof char[]) {
            JSONArray.writeJSONString((char[]) value, out);
        } else if (value instanceof Object[]) {
            JSONArray.writeJSONString((Object[]) value, out);
        } else {
            writeJSONString(value.toString(), out);
        }
    }

    public static String toJSONString(Object value) {
        StringWriter stringWriter;
        Throwable th;
        new StringWriter();
        StringWriter writer = stringWriter;
        try {
            writeJSONString(value, writer);
            return writer.toString();
        } catch (IOException e) {
            IOException e2 = e;
            Throwable th2 = th;
            new RuntimeException(e2);
            throw th2;
        }
    }

    public static String escape(String str) {
        StringBuilder sb;
        String s = str;
        if (s == null) {
            return null;
        }
        new StringBuilder();
        StringBuilder sb2 = sb;
        escape(s, sb2);
        return sb2.toString();
    }

    static void escape(String str, StringBuilder sb) {
        String s = str;
        StringBuilder sb2 = sb;
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            switch (ch) {
                case 8:
                    StringBuilder append = sb2.append("\\b");
                    break;
                case 9:
                    StringBuilder append2 = sb2.append("\\t");
                    break;
                case 10:
                    StringBuilder append3 = sb2.append("\\n");
                    break;
                case 12:
                    StringBuilder append4 = sb2.append("\\f");
                    break;
                case 13:
                    StringBuilder append5 = sb2.append("\\r");
                    break;
                case '\"':
                    StringBuilder append6 = sb2.append("\\\"");
                    break;
                case '\\':
                    StringBuilder append7 = sb2.append("\\\\");
                    break;
                default:
                    if ((ch >= 0 && ch <= 31) || ((ch >= 127 && ch <= 159) || (ch >= 8192 && ch <= 8447))) {
                        String ss = Integer.toHexString(ch);
                        StringBuilder append8 = sb2.append("\\u");
                        for (int k = 0; k < 4 - ss.length(); k++) {
                            StringBuilder append9 = sb2.append('0');
                        }
                        StringBuilder append10 = sb2.append(ss.toUpperCase());
                        break;
                    } else {
                        StringBuilder append11 = sb2.append(ch);
                        break;
                    }
            }
        }
    }
}
