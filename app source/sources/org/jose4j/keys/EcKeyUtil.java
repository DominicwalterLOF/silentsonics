package org.jose4j.keys;

import java.math.BigInteger;
import java.security.InvalidAlgorithmParameterException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPoint;
import java.security.spec.ECPrivateKeySpec;
import java.security.spec.ECPublicKeySpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import org.jose4j.lang.JoseException;

public class EcKeyUtil extends KeyPairUtil {
    public static final String EC = "EC";

    public /* bridge */ /* synthetic */ PublicKey fromPemEncoded(String str) throws JoseException, InvalidKeySpecException {
        return super.fromPemEncoded(str);
    }

    public /* bridge */ /* synthetic */ boolean isAvailable() {
        return super.isAvailable();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public EcKeyUtil() {
        this((String) null, (SecureRandom) null);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public EcKeyUtil(String provider, SecureRandom secureRandom) {
        super(provider, secureRandom);
    }

    /* access modifiers changed from: package-private */
    public String getAlgorithm() {
        return "EC";
    }

    public ECPublicKey publicKey(BigInteger x, BigInteger y, ECParameterSpec spec) throws JoseException {
        ECPoint w;
        KeySpec keySpec;
        Throwable th;
        StringBuilder sb;
        new ECPoint(x, y);
        new ECPublicKeySpec(w, spec);
        try {
            return (ECPublicKey) getKeyFactory().generatePublic(keySpec);
        } catch (InvalidKeySpecException e) {
            InvalidKeySpecException e2 = e;
            Throwable th2 = th;
            new StringBuilder();
            new JoseException(sb.append("Invalid key spec: ").append(e2).toString(), e2);
            throw th2;
        }
    }

    public ECPrivateKey privateKey(BigInteger d, ECParameterSpec spec) throws JoseException {
        KeySpec keySpec;
        Throwable th;
        StringBuilder sb;
        new ECPrivateKeySpec(d, spec);
        try {
            return (ECPrivateKey) getKeyFactory().generatePrivate(keySpec);
        } catch (InvalidKeySpecException e) {
            InvalidKeySpecException e2 = e;
            Throwable th2 = th;
            new StringBuilder();
            new JoseException(sb.append("Invalid key spec: ").append(e2).toString(), e2);
            throw th2;
        }
    }

    public KeyPair generateKeyPair(ECParameterSpec eCParameterSpec) throws JoseException {
        Throwable th;
        StringBuilder sb;
        ECParameterSpec spec = eCParameterSpec;
        KeyPairGenerator keyGenerator = getKeyPairGenerator();
        try {
            if (this.secureRandom == null) {
                keyGenerator.initialize(spec);
            } else {
                keyGenerator.initialize(spec, this.secureRandom);
            }
            return keyGenerator.generateKeyPair();
        } catch (InvalidAlgorithmParameterException e) {
            InvalidAlgorithmParameterException e2 = e;
            Throwable th2 = th;
            new StringBuilder();
            new JoseException(sb.append("Unable to create EC key pair with spec ").append(spec).toString(), e2);
            throw th2;
        }
    }
}
