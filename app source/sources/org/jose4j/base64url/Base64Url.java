package org.jose4j.base64url;

import org.jose4j.base64url.internal.apache.commons.codec.binary.Base64;
import org.jose4j.lang.StringUtil;

public class Base64Url {
    private Base64 base64urlCodec;

    public Base64Url() {
        Base64 base64;
        new Base64(-1, (byte[]) null, true);
        this.base64urlCodec = base64;
    }

    public String base64UrlDecodeToUtf8String(String encodedValue) {
        return base64UrlDecodeToString(encodedValue, "UTF-8");
    }

    public String base64UrlDecodeToString(String encodedValue, String charsetName) {
        return StringUtil.newString(base64UrlDecode(encodedValue), charsetName);
    }

    public byte[] base64UrlDecode(String encodedValue) {
        return this.base64urlCodec.decode(encodedValue);
    }

    public String base64UrlEncodeUtf8ByteRepresentation(String value) {
        return base64UrlEncode(value, "UTF-8");
    }

    public String base64UrlEncode(String value, String charsetName) {
        return base64UrlEncode(StringUtil.getBytesUnchecked(value, charsetName));
    }

    public String base64UrlEncode(byte[] bytes) {
        return this.base64urlCodec.encodeToString(bytes);
    }

    private static Base64Url getOne() {
        Base64Url base64Url;
        Base64Url base64Url2 = base64Url;
        new Base64Url();
        return base64Url2;
    }

    public static String decodeToUtf8String(String encodedValue) {
        return getOne().base64UrlDecodeToString(encodedValue, "UTF-8");
    }

    public static String decodeToString(String encodedValue, String charsetName) {
        return getOne().base64UrlDecodeToString(encodedValue, charsetName);
    }

    public static byte[] decode(String encodedValue) {
        return getOne().base64UrlDecode(encodedValue);
    }

    public static String encodeUtf8ByteRepresentation(String value) {
        return getOne().base64UrlEncodeUtf8ByteRepresentation(value);
    }

    public static String encode(String value, String charsetName) {
        return getOne().base64UrlEncode(value, charsetName);
    }

    public static String encode(byte[] bytes) {
        return getOne().base64UrlEncode(bytes);
    }
}
