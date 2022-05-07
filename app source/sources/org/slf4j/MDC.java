package org.slf4j;

import java.io.Closeable;
import java.util.Map;
import org.slf4j.helpers.NOPMDCAdapter;
import org.slf4j.helpers.Util;
import org.slf4j.impl.StaticMDCBinder;
import org.slf4j.spi.MDCAdapter;

public class MDC {
    static final String NO_STATIC_MDC_BINDER_URL = "http://www.slf4j.org/codes.html#no_static_mdc_binder";
    static final String NULL_MDCA_URL = "http://www.slf4j.org/codes.html#null_MDCA";
    static MDCAdapter mdcAdapter;

    public static class MDCCloseable implements Closeable {
        private final String key;

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        /* synthetic */ MDCCloseable(String x0, AnonymousClass1 r7) {
            this(x0);
            AnonymousClass1 r2 = r7;
        }

        private MDCCloseable(String key2) {
            this.key = key2;
        }

        public void close() {
            MDC.remove(this.key);
        }
    }

    private MDC() {
    }

    private static MDCAdapter bwCompatibleGetMDCAdapterFromBinder() throws NoClassDefFoundError {
        try {
            return StaticMDCBinder.getSingleton().getMDCA();
        } catch (NoSuchMethodError e) {
            NoSuchMethodError noSuchMethodError = e;
            return StaticMDCBinder.SINGLETON.getMDCA();
        }
    }

    static {
        MDCAdapter mDCAdapter;
        try {
            mdcAdapter = bwCompatibleGetMDCAdapterFromBinder();
        } catch (NoClassDefFoundError e) {
            NoClassDefFoundError ncde = e;
            new NOPMDCAdapter();
            mdcAdapter = mDCAdapter;
            String msg = ncde.getMessage();
            if (msg == null || !msg.contains("StaticMDCBinder")) {
                throw ncde;
            }
            Util.report("Failed to load class \"org.slf4j.impl.StaticMDCBinder\".");
            Util.report("Defaulting to no-operation MDCAdapter implementation.");
            Util.report("See http://www.slf4j.org/codes.html#no_static_mdc_binder for further details.");
        } catch (Exception e2) {
            Util.report("MDC binding unsuccessful.", e2);
        }
    }

    public static void put(String str, String str2) throws IllegalArgumentException {
        Throwable th;
        Throwable th2;
        String key = str;
        String val = str2;
        if (key == null) {
            Throwable th3 = th2;
            new IllegalArgumentException("key parameter cannot be null");
            throw th3;
        } else if (mdcAdapter == null) {
            Throwable th4 = th;
            new IllegalStateException("MDCAdapter cannot be null. See also http://www.slf4j.org/codes.html#null_MDCA");
            throw th4;
        } else {
            mdcAdapter.put(key, val);
        }
    }

    public static MDCCloseable putCloseable(String str, String val) throws IllegalArgumentException {
        MDCCloseable mDCCloseable;
        String key = str;
        put(key, val);
        new MDCCloseable(key, (AnonymousClass1) null);
        return mDCCloseable;
    }

    public static String get(String str) throws IllegalArgumentException {
        Throwable th;
        Throwable th2;
        String key = str;
        if (key == null) {
            Throwable th3 = th2;
            new IllegalArgumentException("key parameter cannot be null");
            throw th3;
        } else if (mdcAdapter != null) {
            return mdcAdapter.get(key);
        } else {
            Throwable th4 = th;
            new IllegalStateException("MDCAdapter cannot be null. See also http://www.slf4j.org/codes.html#null_MDCA");
            throw th4;
        }
    }

    public static void remove(String str) throws IllegalArgumentException {
        Throwable th;
        Throwable th2;
        String key = str;
        if (key == null) {
            Throwable th3 = th2;
            new IllegalArgumentException("key parameter cannot be null");
            throw th3;
        } else if (mdcAdapter == null) {
            Throwable th4 = th;
            new IllegalStateException("MDCAdapter cannot be null. See also http://www.slf4j.org/codes.html#null_MDCA");
            throw th4;
        } else {
            mdcAdapter.remove(key);
        }
    }

    public static void clear() {
        Throwable th;
        if (mdcAdapter == null) {
            Throwable th2 = th;
            new IllegalStateException("MDCAdapter cannot be null. See also http://www.slf4j.org/codes.html#null_MDCA");
            throw th2;
        }
        mdcAdapter.clear();
    }

    public static Map<String, String> getCopyOfContextMap() {
        Throwable th;
        if (mdcAdapter != null) {
            return mdcAdapter.getCopyOfContextMap();
        }
        Throwable th2 = th;
        new IllegalStateException("MDCAdapter cannot be null. See also http://www.slf4j.org/codes.html#null_MDCA");
        throw th2;
    }

    public static void setContextMap(Map<String, String> map) {
        Throwable th;
        Map<String, String> contextMap = map;
        if (mdcAdapter == null) {
            Throwable th2 = th;
            new IllegalStateException("MDCAdapter cannot be null. See also http://www.slf4j.org/codes.html#null_MDCA");
            throw th2;
        }
        mdcAdapter.setContextMap(contextMap);
    }

    public static MDCAdapter getMDCAdapter() {
        return mdcAdapter;
    }
}
