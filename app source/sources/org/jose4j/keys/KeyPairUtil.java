package org.jose4j.keys;

import java.security.KeyFactory;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.Security;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Set;
import org.jose4j.base64url.SimplePEMEncoder;
import org.jose4j.lang.JoseException;

abstract class KeyPairUtil {
    private static final String BEGIN_PUBLIC_KEY = "-----BEGIN PUBLIC KEY-----";
    private static final String END_PUBLIC_KEY = "-----END PUBLIC KEY-----";
    protected String provider;
    protected SecureRandom secureRandom;

    /* access modifiers changed from: package-private */
    public abstract String getAlgorithm();

    protected KeyPairUtil(String provider2, SecureRandom secureRandom2) {
        this.provider = provider2;
        this.secureRandom = secureRandom2;
    }

    /* access modifiers changed from: protected */
    public KeyFactory getKeyFactory() throws JoseException {
        Throwable th;
        StringBuilder sb;
        Throwable th2;
        StringBuilder sb2;
        String agl = getAlgorithm();
        try {
            return this.provider == null ? KeyFactory.getInstance(agl) : KeyFactory.getInstance(agl, this.provider);
        } catch (NoSuchAlgorithmException e) {
            NoSuchAlgorithmException e2 = e;
            Throwable th3 = th2;
            new StringBuilder();
            new JoseException(sb2.append("Couldn't find ").append(agl).append(" KeyFactory! ").append(e2).toString(), e2);
            throw th3;
        } catch (NoSuchProviderException e3) {
            NoSuchProviderException e4 = e3;
            Throwable th4 = th;
            new StringBuilder();
            new JoseException(sb.append("Cannot get KeyFactory instance with provider ").append(this.provider).toString(), e4);
            throw th4;
        }
    }

    /* access modifiers changed from: protected */
    public KeyPairGenerator getKeyPairGenerator() throws JoseException {
        Throwable th;
        StringBuilder sb;
        Throwable th2;
        StringBuilder sb2;
        String alg = getAlgorithm();
        try {
            return this.provider == null ? KeyPairGenerator.getInstance(alg) : KeyPairGenerator.getInstance(alg, this.provider);
        } catch (NoSuchAlgorithmException e) {
            NoSuchAlgorithmException e2 = e;
            Throwable th3 = th2;
            new StringBuilder();
            new JoseException(sb2.append("Couldn't find ").append(alg).append(" KeyPairGenerator! ").append(e2).toString(), e2);
            throw th3;
        } catch (NoSuchProviderException e3) {
            NoSuchProviderException e4 = e3;
            Throwable th4 = th;
            new StringBuilder();
            new JoseException(sb.append("Cannot get KeyPairGenerator instance with provider ").append(this.provider).toString(), e4);
            throw th4;
        }
    }

    public PublicKey fromPemEncoded(String str) throws JoseException, InvalidKeySpecException {
        KeySpec keySpec;
        String pem = str;
        new X509EncodedKeySpec(SimplePEMEncoder.decode(pem.substring(pem.indexOf(BEGIN_PUBLIC_KEY) + BEGIN_PUBLIC_KEY.length(), pem.indexOf(END_PUBLIC_KEY)).trim()));
        return getKeyFactory().generatePublic(keySpec);
    }

    public static String pemEncode(PublicKey publicKey) {
        StringBuilder sb;
        byte[] encoded = publicKey.getEncoded();
        new StringBuilder();
        return sb.append("-----BEGIN PUBLIC KEY-----\r\n").append(SimplePEMEncoder.encode(encoded)).append(END_PUBLIC_KEY).toString();
    }

    public boolean isAvailable() {
        Set<String> keyFactories = Security.getAlgorithms("KeyFactory");
        Set<String> keyPairGenerators = Security.getAlgorithms("KeyPairGenerator");
        String algorithm = getAlgorithm();
        return keyPairGenerators.contains(algorithm) && keyFactories.contains(algorithm);
    }
}
