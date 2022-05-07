package org.jose4j.jwe;

import java.security.SecureRandom;
import org.jose4j.lang.ByteUtil;

public class InitializationVectorHelp {
    public InitializationVectorHelp() {
    }

    static byte[] iv(int byteLength, byte[] bArr, SecureRandom secureRandom) {
        byte[] ivOverride = bArr;
        return ivOverride == null ? ByteUtil.randomBytes(byteLength, secureRandom) : ivOverride;
    }
}
