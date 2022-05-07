package org.slf4j.helpers;

import java.io.PrintStream;

public final class Util {
    private static ClassContextSecurityManager SECURITY_MANAGER;
    private static boolean SECURITY_MANAGER_CREATION_ALREADY_ATTEMPTED = false;

    private Util() {
    }

    public static String safeGetSystemProperty(String str) {
        Throwable th;
        String key = str;
        if (key == null) {
            Throwable th2 = th;
            new IllegalArgumentException("null input");
            throw th2;
        }
        String result = null;
        try {
            result = System.getProperty(key);
        } catch (SecurityException e) {
            SecurityException securityException = e;
        }
        return result;
    }

    public static boolean safeGetBooleanSystemProperty(String key) {
        String value = safeGetSystemProperty(key);
        if (value == null) {
            return false;
        }
        return value.equalsIgnoreCase("true");
    }

    private static final class ClassContextSecurityManager extends SecurityManager {
        private ClassContextSecurityManager() {
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        /* synthetic */ ClassContextSecurityManager(AnonymousClass1 r4) {
            this();
            AnonymousClass1 r1 = r4;
        }

        /* access modifiers changed from: protected */
        public Class<?>[] getClassContext() {
            return super.getClassContext();
        }
    }

    private static ClassContextSecurityManager getSecurityManager() {
        if (SECURITY_MANAGER != null) {
            return SECURITY_MANAGER;
        }
        if (SECURITY_MANAGER_CREATION_ALREADY_ATTEMPTED) {
            return null;
        }
        SECURITY_MANAGER = safeCreateSecurityManager();
        SECURITY_MANAGER_CREATION_ALREADY_ATTEMPTED = true;
        return SECURITY_MANAGER;
    }

    private static ClassContextSecurityManager safeCreateSecurityManager() {
        ClassContextSecurityManager classContextSecurityManager;
        try {
            ClassContextSecurityManager classContextSecurityManager2 = classContextSecurityManager;
            new ClassContextSecurityManager((AnonymousClass1) null);
            return classContextSecurityManager2;
        } catch (SecurityException e) {
            SecurityException securityException = e;
            return null;
        }
    }

    public static Class<?> getCallingClass() {
        Throwable th;
        ClassContextSecurityManager securityManager = getSecurityManager();
        if (securityManager == null) {
            return null;
        }
        Class<?>[] trace = securityManager.getClassContext();
        String thisClassName = Util.class.getName();
        int i = 0;
        while (i < trace.length && !thisClassName.equals(trace[i].getName())) {
            i++;
        }
        if (i < trace.length && i + 2 < trace.length) {
            return trace[i + 2];
        }
        Throwable th2 = th;
        new IllegalStateException("Failed to find org.slf4j.helpers.Util or its caller in the stack; this should not happen");
        throw th2;
    }

    public static final void report(String msg, Throwable t) {
        System.err.println(msg);
        System.err.println("Reported exception:");
        t.printStackTrace();
    }

    public static final void report(String msg) {
        StringBuilder sb;
        PrintStream printStream = System.err;
        new StringBuilder();
        printStream.println(sb.append("SLF4J: ").append(msg).toString());
    }
}
