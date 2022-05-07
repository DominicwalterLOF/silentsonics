package com.microsoft.appcenter.utils;

import android.support.annotation.VisibleForTesting;
import java.util.HashMap;
import java.util.Map;

public class TicketCache {
    private static final Map<String, String> sTickets;

    public TicketCache() {
    }

    static {
        Map<String, String> map;
        new HashMap();
        sTickets = map;
    }

    public static String getTicket(String key) {
        return sTickets.get(key);
    }

    public static void putTicket(String key, String value) {
        String put = sTickets.put(key, value);
    }

    @VisibleForTesting
    public static void clear() {
        sTickets.clear();
    }
}
