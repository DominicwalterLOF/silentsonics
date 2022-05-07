package com.microsoft.appcenter.utils;

import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.jose4j.lang.HashUtil;

public class HashUtils {
    private static final char[] HEXADECIMAL_OUTPUT = "0123456789abcdef".toCharArray();

    @VisibleForTesting
    HashUtils() {
    }

    @NonNull
    public static String sha256(@NonNull String data) {
        return sha256(data, "UTF-8");
    }

    @VisibleForTesting
    @NonNull
    static String sha256(@NonNull String str, String str2) {
        Throwable th;
        String data = str;
        String charsetName = str2;
        try {
            MessageDigest digest = MessageDigest.getInstance(HashUtil.SHA_256);
            digest.update(data.getBytes(charsetName));
            return encodeHex(digest.digest());
        } catch (UnsupportedEncodingException | NoSuchAlgorithmException e) {
            Exception e2 = e;
            Throwable th2 = th;
            new RuntimeException(e2);
            throw th2;
        }
    }

    @NonNull
    private static String encodeHex(@NonNull byte[] bArr) {
        String str;
        byte[] bytes = bArr;
        char[] output = new char[(bytes.length * 2)];
        for (int j = 0; j < bytes.length; j++) {
            int v = bytes[j] & 255;
            output[j * 2] = HEXADECIMAL_OUTPUT[v >>> 4];
            output[(j * 2) + 1] = HEXADECIMAL_OUTPUT[v & 15];
        }
        new String(output);
        return str;
    }
}
