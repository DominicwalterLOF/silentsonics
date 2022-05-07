package org.jose4j.jwk;

import java.security.Key;
import java.security.SecureRandom;
import org.jose4j.keys.AesKey;
import org.jose4j.lang.ByteUtil;

public class OctJwkGenerator {
    public OctJwkGenerator() {
    }

    public static OctetSequenceJsonWebKey generateJwk(int keyLengthInBits) {
        return generateJwk(keyLengthInBits, (SecureRandom) null);
    }

    public static OctetSequenceJsonWebKey generateJwk(int keyLengthInBits, SecureRandom secureRandom) {
        OctetSequenceJsonWebKey octetSequenceJsonWebKey;
        Key key;
        new AesKey(ByteUtil.randomBytes(ByteUtil.byteLength(keyLengthInBits), secureRandom));
        new OctetSequenceJsonWebKey(key);
        return octetSequenceJsonWebKey;
    }
}
