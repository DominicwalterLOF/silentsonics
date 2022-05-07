package com.google.appinventor.common.version;

import com.shaded.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import org.jose4j.jws.AlgorithmIdentifiers;

public final class GitBuildId {
    public static final String ANT_BUILD_DATE = "April 28 2022";
    public static final String GIT_BUILD_FINGERPRINT = "078decd784b85de8edba1e973f38eb0e0023f274";
    public static final String GIT_BUILD_VERSION = "1.5.4-Fenix";

    private GitBuildId() {
    }

    public static String getVersion() {
        String str = GIT_BUILD_VERSION;
        String str2 = str;
        return (str == "" || str2.contains(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR)) ? AlgorithmIdentifiers.NONE : str2;
    }

    public static String getFingerprint() {
        return GIT_BUILD_FINGERPRINT;
    }

    public static String getDate() {
        return ANT_BUILD_DATE;
    }
}
