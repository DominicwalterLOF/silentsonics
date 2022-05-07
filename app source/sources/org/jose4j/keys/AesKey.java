package org.jose4j.keys;

import javax.crypto.spec.SecretKeySpec;
import org.jose4j.lang.ByteUtil;

public class AesKey extends SecretKeySpec {
    public static final String ALGORITHM = "AES";

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AesKey(byte[] bytes) {
        super(bytes, ALGORITHM);
    }

    public String toString() {
        StringBuilder sb;
        new StringBuilder();
        return sb.append(ByteUtil.bitLength(getEncoded().length)).append(" bit ").append(ALGORITHM).append(" key").toString();
    }
}
