package org.jose4j.json;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.jose4j.json.internal.json_simple.JSONValue;
import org.jose4j.json.internal.json_simple.parser.ContainerFactory;
import org.jose4j.json.internal.json_simple.parser.JSONParser;
import org.jose4j.json.internal.json_simple.parser.ParseException;
import org.jose4j.lang.JoseException;

public class JsonUtil {
    private static final ContainerFactory CONTAINER_FACTORY;

    public JsonUtil() {
    }

    static {
        ContainerFactory containerFactory;
        new ContainerFactory() {
            public List creatArrayContainer() {
                List list;
                new ArrayList();
                return list;
            }

            public Map createObjectContainer() {
                Map map;
                new DupeKeyDisallowingLinkedHashMap();
                return map;
            }
        };
        CONTAINER_FACTORY = containerFactory;
    }

    public static Map<String, Object> parseJson(String str) throws JoseException {
        Throwable th;
        StringBuilder sb;
        Throwable th2;
        StringBuilder sb2;
        JSONParser parser;
        Throwable th3;
        String jsonString = str;
        try {
            new JSONParser();
            Object parsed = parser.parse(jsonString, CONTAINER_FACTORY);
            if (parsed != null) {
                return (Map) parsed;
            }
            Throwable th4 = th3;
            new JoseException("Parsing returned null");
            throw th4;
        } catch (IllegalArgumentException | ParseException e) {
            Exception e2 = e;
            Throwable th5 = th2;
            new StringBuilder();
            new JoseException(sb2.append("Parsing error: ").append(e2).toString(), e2);
            throw th5;
        } catch (ClassCastException e3) {
            ClassCastException e4 = e3;
            Throwable th6 = th;
            new StringBuilder();
            new JoseException(sb.append("Expecting a JSON object at the root but ").append(e4).toString(), e4);
            throw th6;
        }
    }

    public static String toJson(Map<String, ?> map) {
        return JSONValue.toJSONString(map);
    }

    public static void writeJson(Map<String, ?> map, Writer w) throws IOException {
        JSONValue.writeJSONString(map, w);
    }

    static class DupeKeyDisallowingLinkedHashMap extends LinkedHashMap<String, Object> {
        DupeKeyDisallowingLinkedHashMap() {
        }

        public Object put(String str, Object obj) {
            Throwable th;
            StringBuilder sb;
            String key = str;
            Object value = obj;
            if (!containsKey(key)) {
                return super.put(key, value);
            }
            Throwable th2 = th;
            new StringBuilder();
            new IllegalArgumentException(sb.append("An entry for '").append(key).append("' already exists. Names must be unique.").toString());
            throw th2;
        }
    }
}
