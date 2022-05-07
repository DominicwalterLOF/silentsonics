package org.jose4j.base64url;

import org.jose4j.base64url.internal.apache.commons.codec.binary.Base64;

public class SimplePEMEncoder {
    public SimplePEMEncoder() {
    }

    public static String encode(byte[] bytes) {
        return getCodec().encodeToString(bytes);
    }

    public static byte[] decode(String encoded) {
        return getCodec().decode(encoded);
    }

    static Base64 getCodec() {
        Base64 base64;
        Base64 base642 = base64;
        new Base64(64);
        return base642;
    }
}
