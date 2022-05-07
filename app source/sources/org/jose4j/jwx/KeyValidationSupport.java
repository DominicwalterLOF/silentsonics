package org.jose4j.jwx;

import java.security.Key;
import java.security.interfaces.RSAKey;
import org.jose4j.keys.AesKey;
import org.jose4j.lang.ByteUtil;
import org.jose4j.lang.InvalidKeyException;

public class KeyValidationSupport {
    public static final int MIN_RSA_KEY_LENGTH = 2048;

    public KeyValidationSupport() {
    }

    public static void checkRsaKeySize(Key key) throws InvalidKeyException {
        int size;
        Throwable th;
        StringBuilder sb;
        Throwable th2;
        Key key2 = key;
        if (key2 == null) {
            Throwable th3 = th2;
            new InvalidKeyException("The RSA key must not be null.");
            throw th3;
        } else if ((key2 instanceof RSAKey) && (size = ((RSAKey) key2).getModulus().bitLength()) < 2048) {
            Throwable th4 = th;
            new StringBuilder();
            new InvalidKeyException(sb.append("An RSA key of size 2048 bits or larger MUST be used with the all JOSE RSA algorithms (given key was only ").append(size).append(" bits).").toString());
            throw th4;
        }
    }

    public static <K extends Key> K castKey(Key key, Class<K> type) throws InvalidKeyException {
        Throwable th;
        StringBuilder sb;
        Key key2 = key;
        notNull(key2);
        try {
            return type.cast(key2);
        } catch (ClassCastException e) {
            ClassCastException e2 = e;
            Throwable th2 = th;
            new StringBuilder();
            new InvalidKeyException(sb.append("Invalid key ").append(e2).toString());
            throw th2;
        }
    }

    public static void notNull(Key key) throws InvalidKeyException {
        Throwable th;
        if (key == null) {
            Throwable th2 = th;
            new InvalidKeyException("The key must not be null.");
            throw th2;
        }
    }

    public static void cekNotAllowed(byte[] cekOverride, String str) throws InvalidKeyException {
        Throwable th;
        StringBuilder sb;
        String alg = str;
        if (cekOverride != null) {
            Throwable th2 = th;
            new StringBuilder();
            new InvalidKeyException(sb.append("An explicit content encryption key cannot be used with ").append(alg).toString());
            throw th2;
        }
    }

    public static void validateAesWrappingKey(Key key, String str, int i) throws InvalidKeyException {
        int managementKeyByteLength;
        Throwable th;
        StringBuilder sb;
        Throwable th2;
        StringBuilder sb2;
        Key managementKey = key;
        String joseAlg = str;
        int expectedKeyByteLength = i;
        notNull(managementKey);
        String alg = managementKey.getAlgorithm();
        if (!AesKey.ALGORITHM.equals(alg)) {
            Throwable th3 = th2;
            new StringBuilder();
            new InvalidKeyException(sb2.append("Invalid key for JWE ").append(joseAlg).append(", expected an ").append(AesKey.ALGORITHM).append(" key but an ").append(alg).append(" key was provided.").toString());
            throw th3;
        } else if (managementKey.getEncoded() != null && (managementKeyByteLength = managementKey.getEncoded().length) != expectedKeyByteLength) {
            Throwable th4 = th;
            new StringBuilder();
            new InvalidKeyException(sb.append("Invalid key for JWE ").append(joseAlg).append(", expected a ").append(ByteUtil.bitLength(expectedKeyByteLength)).append(" bit key but a ").append(ByteUtil.bitLength(managementKeyByteLength)).append(" bit key was provided.").toString());
            throw th4;
        }
    }
}
