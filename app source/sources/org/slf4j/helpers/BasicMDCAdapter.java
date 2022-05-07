package org.slf4j.helpers;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.slf4j.spi.MDCAdapter;

public class BasicMDCAdapter implements MDCAdapter {
    private InheritableThreadLocal<Map<String, String>> inheritableThreadLocal;

    public BasicMDCAdapter() {
        InheritableThreadLocal<Map<String, String>> inheritableThreadLocal2;
        new InheritableThreadLocal<Map<String, String>>(this) {
            final /* synthetic */ BasicMDCAdapter this$0;

            {
                this.this$0 = this$0;
            }

            /* access modifiers changed from: protected */
            public Map<String, String> childValue(Map<String, String> map) {
                Map<String, String> map2;
                Map<String, String> parentValue = map;
                if (parentValue == null) {
                    return null;
                }
                new HashMap(parentValue);
                return map2;
            }
        };
        this.inheritableThreadLocal = inheritableThreadLocal2;
    }

    public void put(String str, String str2) {
        Map<String, String> map;
        Throwable th;
        String key = str;
        String val = str2;
        if (key == null) {
            Throwable th2 = th;
            new IllegalArgumentException("key cannot be null");
            throw th2;
        }
        Map<String, String> map2 = (Map) this.inheritableThreadLocal.get();
        if (map2 == null) {
            new HashMap<>();
            map2 = map;
            this.inheritableThreadLocal.set(map2);
        }
        String put = map2.put(key, val);
    }

    public String get(String str) {
        String key = str;
        Map<String, String> map = (Map) this.inheritableThreadLocal.get();
        if (map == null || key == null) {
            return null;
        }
        return map.get(key);
    }

    public void remove(String str) {
        String key = str;
        Map<String, String> map = (Map) this.inheritableThreadLocal.get();
        if (map != null) {
            String remove = map.remove(key);
        }
    }

    public void clear() {
        Map<String, String> map = (Map) this.inheritableThreadLocal.get();
        if (map != null) {
            map.clear();
            this.inheritableThreadLocal.remove();
        }
    }

    public Set<String> getKeys() {
        Map<String, String> map = (Map) this.inheritableThreadLocal.get();
        if (map != null) {
            return map.keySet();
        }
        return null;
    }

    public Map<String, String> getCopyOfContextMap() {
        Map<String, String> map;
        Map<String, String> oldMap = (Map) this.inheritableThreadLocal.get();
        if (oldMap == null) {
            return null;
        }
        new HashMap(oldMap);
        return map;
    }

    public void setContextMap(Map<String, String> contextMap) {
        Object obj;
        new HashMap(contextMap);
        this.inheritableThreadLocal.set(obj);
    }
}
