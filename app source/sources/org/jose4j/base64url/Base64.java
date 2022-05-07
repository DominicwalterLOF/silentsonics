package org.jose4j.base64url;

public class Base64 {
    public Base64() {
    }

    public static String encode(byte[] bytes) {
        return getCodec().encodeToString(bytes);
    }

    public static byte[] decode(String encoded) {
        return getCodec().decode(encoded);
    }

    private static org.jose4j.base64url.internal.apache.commons.codec.binary.Base64 getCodec() {
        org.jose4j.base64url.internal.apache.commons.codec.binary.Base64 base64;
        org.jose4j.base64url.internal.apache.commons.codec.binary.Base64 base642 = base64;
        new org.jose4j.base64url.internal.apache.commons.codec.binary.Base64();
        return base642;
    }
}
