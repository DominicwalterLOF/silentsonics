package org.jose4j.keys;

import java.math.BigInteger;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.security.spec.RSAPrivateCrtKeySpec;
import java.security.spec.RSAPrivateKeySpec;
import java.security.spec.RSAPublicKeySpec;
import org.jose4j.lang.JoseException;

public class RsaKeyUtil extends KeyPairUtil {
    public static final String RSA = "RSA";

    public /* bridge */ /* synthetic */ PublicKey fromPemEncoded(String str) throws JoseException, InvalidKeySpecException {
        return super.fromPemEncoded(str);
    }

    public /* bridge */ /* synthetic */ boolean isAvailable() {
        return super.isAvailable();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public RsaKeyUtil() {
        this((String) null, (SecureRandom) null);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RsaKeyUtil(String provider, SecureRandom secureRandom) {
        super(provider, secureRandom);
    }

    /* access modifiers changed from: package-private */
    public String getAlgorithm() {
        return "RSA";
    }

    public RSAPublicKey publicKey(BigInteger modulus, BigInteger publicExponent) throws JoseException {
        KeySpec keySpec;
        Throwable th;
        StringBuilder sb;
        new RSAPublicKeySpec(modulus, publicExponent);
        try {
            return (RSAPublicKey) getKeyFactory().generatePublic(keySpec);
        } catch (InvalidKeySpecException e) {
            InvalidKeySpecException e2 = e;
            Throwable th2 = th;
            new StringBuilder();
            new JoseException(sb.append("Invalid key spec: ").append(e2).toString(), e2);
            throw th2;
        }
    }

    public RSAPrivateKey privateKey(BigInteger modulus, BigInteger privateExponent) throws JoseException {
        RSAPrivateKeySpec keySpec;
        new RSAPrivateKeySpec(modulus, privateExponent);
        return getRsaPrivateKey(keySpec);
    }

    public RSAPrivateKey privateKey(BigInteger modulus, BigInteger publicExponent, BigInteger privateExponent, BigInteger primeP, BigInteger primeQ, BigInteger primeExponentP, BigInteger primeExponentQ, BigInteger crtCoefficient) throws JoseException {
        RSAPrivateKeySpec rSAPrivateKeySpec;
        new RSAPrivateCrtKeySpec(modulus, publicExponent, privateExponent, primeP, primeQ, primeExponentP, primeExponentQ, crtCoefficient);
        return getRsaPrivateKey(rSAPrivateKeySpec);
    }

    public RSAPrivateKey getRsaPrivateKey(RSAPrivateKeySpec keySpec) throws JoseException {
        Throwable th;
        StringBuilder sb;
        try {
            return (RSAPrivateKey) getKeyFactory().generatePrivate(keySpec);
        } catch (InvalidKeySpecException e) {
            InvalidKeySpecException e2 = e;
            Throwable th2 = th;
            new StringBuilder();
            new JoseException(sb.append("Invalid key spec: ").append(e2).toString(), e2);
            throw th2;
        }
    }

    public KeyPair generateKeyPair(int i) throws JoseException {
        int bits = i;
        KeyPairGenerator keyGenerator = getKeyPairGenerator();
        if (this.secureRandom == null) {
            keyGenerator.initialize(bits);
        } else {
            keyGenerator.initialize(bits, this.secureRandom);
        }
        return keyGenerator.generateKeyPair();
    }
}
