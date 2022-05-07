package org.jose4j.keys;

import javax.crypto.spec.SecretKeySpec;
import org.jose4j.lang.StringUtil;

public class PbkdfKey extends SecretKeySpec {
    public static final String ALGORITHM = "PBKDF2";

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PbkdfKey(String password) {
        super(StringUtil.getBytesUtf8(password), ALGORITHM);
    }
}
