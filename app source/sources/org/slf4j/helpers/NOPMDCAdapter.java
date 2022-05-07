package org.slf4j.helpers;

import java.util.Map;
import org.slf4j.spi.MDCAdapter;

public class NOPMDCAdapter implements MDCAdapter {
    public NOPMDCAdapter() {
    }

    public void clear() {
    }

    public String get(String str) {
        String str2 = str;
        return null;
    }

    public void put(String key, String val) {
    }

    public void remove(String key) {
    }

    public Map<String, String> getCopyOfContextMap() {
        return null;
    }

    public void setContextMap(Map<String, String> map) {
    }
}
