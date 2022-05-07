package org.jose4j.jwk;

import java.security.Key;
import java.security.KeyPair;
import java.security.SecureRandom;
import java.security.spec.ECParameterSpec;
import org.jose4j.jwk.PublicJsonWebKey;
import org.jose4j.keys.EcKeyUtil;
import org.jose4j.lang.JoseException;

public class EcJwkGenerator {
    public EcJwkGenerator() {
    }

    public static EllipticCurveJsonWebKey generateJwk(ECParameterSpec spec) throws JoseException {
        return generateJwk(spec, (String) null, (SecureRandom) null);
    }

    public static EllipticCurveJsonWebKey generateJwk(ECParameterSpec spec, String provider, SecureRandom secureRandom) throws JoseException {
        EcKeyUtil keyUtil;
        new EcKeyUtil(provider, secureRandom);
        KeyPair keyPair = keyUtil.generateKeyPair(spec);
        EllipticCurveJsonWebKey ecJwk = (EllipticCurveJsonWebKey) PublicJsonWebKey.Factory.newPublicJwk((Key) keyPair.getPublic());
        ecJwk.setPrivateKey(keyPair.getPrivate());
        return ecJwk;
    }
}
