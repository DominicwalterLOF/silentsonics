package org.jose4j.lang;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

public class StringUtil {
    public static final String US_ASCII = "US-ASCII";
    public static final String UTF_8 = "UTF-8";

    public StringUtil() {
    }

    public static String newStringUtf8(byte[] bytes) {
        return newString(bytes, "UTF-8");
    }

    public static String newStringUsAscii(byte[] bytes) {
        return newString(bytes, "US-ASCII");
    }

    public static String newString(byte[] bArr, String str) {
        String str2;
        String str3;
        byte[] bytes = bArr;
        String charsetName = str;
        if (bytes == null) {
            str3 = null;
        } else {
            try {
                str3 = str2;
                new String(bytes, charsetName);
            } catch (UnsupportedEncodingException e) {
                UnsupportedEncodingException unsupportedEncodingException = e;
                throw newISE(charsetName);
            }
        }
        return str3;
    }

    public static String newString(byte[] bArr, Charset charset) {
        String str;
        String str2;
        byte[] bytes = bArr;
        Charset charset2 = charset;
        if (bytes == null) {
            str2 = null;
        } else {
            str2 = str;
            new String(bytes, charset2);
        }
        return str2;
    }

    public static byte[] getBytesUtf8(String string) {
        return getBytesUnchecked(string, "UTF-8");
    }

    public static byte[] getBytesAscii(String string) {
        return getBytesUnchecked(string, "US-ASCII");
    }

    public static byte[] getBytes(String str, Charset charset) {
        String string = str;
        return string == null ? null : string.getBytes(charset);
    }

    public static byte[] getBytesUnchecked(String str, String str2) {
        byte[] bytes;
        String string = str;
        String charsetName = str2;
        if (string == null) {
            bytes = null;
        } else {
            try {
                bytes = string.getBytes(charsetName);
            } catch (UnsupportedEncodingException e) {
                UnsupportedEncodingException unsupportedEncodingException = e;
                throw newISE(charsetName);
            }
        }
        return bytes;
    }

    private static IllegalStateException newISE(String charsetName) {
        IllegalStateException illegalStateException;
        StringBuilder sb;
        new StringBuilder();
        new IllegalStateException(sb.append("Unknown or unsupported character set name: ").append(charsetName).toString());
        return illegalStateException;
    }
}
