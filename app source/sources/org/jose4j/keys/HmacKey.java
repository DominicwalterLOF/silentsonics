package org.jose4j.keys;

import javax.crypto.spec.SecretKeySpec;

public class HmacKey extends SecretKeySpec {
    public static final String ALGORITHM = "HMAC";

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HmacKey(byte[] bytes) {
        super(bytes, ALGORITHM);
    }
}
