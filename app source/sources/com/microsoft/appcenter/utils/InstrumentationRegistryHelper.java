package com.microsoft.appcenter.utils;

import android.os.Bundle;

public class InstrumentationRegistryHelper {
    private static final String[] LOCATIONS;

    public InstrumentationRegistryHelper() {
    }

    static {
        String[] strArr = new String[3];
        strArr[0] = "androidx.test.platform.app.InstrumentationRegistry";
        String[] strArr2 = strArr;
        strArr2[1] = "androidx.test.InstrumentationRegistry";
        String[] strArr3 = strArr2;
        strArr3[2] = "android.support.test.InstrumentationRegistry";
        LOCATIONS = strArr3;
    }

    public static Bundle getArguments() throws IllegalStateException {
        Throwable th;
        Exception exception = null;
        String[] strArr = LOCATIONS;
        int length = strArr.length;
        int i = 0;
        while (i < length) {
            try {
                return (Bundle) getClass(strArr[i]).getMethod("getArguments", new Class[0]).invoke((Object) null, new Object[0]);
            } catch (Exception e) {
                exception = e;
                i++;
            }
        }
        Throwable th2 = th;
        new IllegalStateException(exception);
        throw th2;
    }

    private static Class<?> getClass(String className) throws ClassNotFoundException {
        return Class.forName(className);
    }
}
