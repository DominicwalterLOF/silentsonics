package org.jose4j.jws;

import java.security.Key;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import org.jose4j.jca.ProviderContext;
import org.jose4j.jwa.AlgorithmAvailability;
import org.jose4j.jwa.AlgorithmInfo;
import org.jose4j.jwk.OctetSequenceJsonWebKey;
import org.jose4j.keys.KeyPersuasion;
import org.jose4j.lang.ByteUtil;
import org.jose4j.lang.InvalidKeyException;
import org.jose4j.lang.JoseException;
import org.jose4j.mac.MacUtil;

public class HmacUsingShaAlgorithm extends AlgorithmInfo implements JsonWebSignatureAlgorithm {
    private int minimumKeyLength;

    public HmacUsingShaAlgorithm(String id, String javaAlgo, int minimumKeyLength2) {
        setAlgorithmIdentifier(id);
        setJavaAlgorithm(javaAlgo);
        setKeyPersuasion(KeyPersuasion.SYMMETRIC);
        setKeyType(OctetSequenceJsonWebKey.KEY_TYPE);
        this.minimumKeyLength = minimumKeyLength2;
    }

    public boolean verifySignature(byte[] bArr, Key key, byte[] bArr2, ProviderContext providerContext) throws JoseException {
        Throwable th;
        StringBuilder sb;
        byte[] signatureBytes = bArr;
        Key key2 = key;
        byte[] securedInputBytes = bArr2;
        ProviderContext providerContext2 = providerContext;
        if (!(key2 instanceof SecretKey)) {
            Throwable th2 = th;
            new StringBuilder();
            new InvalidKeyException(sb.append(key2.getClass()).append(" cannot be used for HMAC verification.").toString());
            throw th2;
        }
        return ByteUtil.secureEquals(signatureBytes, getMacInstance(key2, providerContext2).doFinal(securedInputBytes));
    }

    public byte[] sign(Key key, byte[] securedInputBytes, ProviderContext providerContext) throws JoseException {
        return getMacInstance(key, providerContext).doFinal(securedInputBytes);
    }

    private Mac getMacInstance(Key key, ProviderContext providerContext) throws JoseException {
        return MacUtil.getInitializedMac(getJavaAlgorithm(), key, providerContext.getSuppliedKeyProviderContext().getMacProvider());
    }

    /* access modifiers changed from: package-private */
    public void validateKey(Key key) throws InvalidKeyException {
        int length;
        Throwable th;
        StringBuilder sb;
        Throwable th2;
        Key key2 = key;
        if (key2 == null) {
            Throwable th3 = th2;
            new InvalidKeyException("key is null");
            throw th3;
        } else if (key2.getEncoded() != null && (length = ByteUtil.bitLength(key2.getEncoded())) < this.minimumKeyLength) {
            Throwable th4 = th;
            new StringBuilder();
            new InvalidKeyException(sb.append("A key of the same size as the hash output (i.e. ").append(this.minimumKeyLength).append(" bits for ").append(getAlgorithmIdentifier()).append(") or larger MUST be used with the HMAC SHA algorithms but this key is only ").append(length).append(" bits").toString());
            throw th4;
        }
    }

    public void validateSigningKey(Key key) throws InvalidKeyException {
        validateKey(key);
    }

    public void validateVerificationKey(Key key) throws InvalidKeyException {
        validateKey(key);
    }

    public boolean isAvailable() {
        return AlgorithmAvailability.isAvailable("Mac", getJavaAlgorithm());
    }

    public static class HmacSha256 extends HmacUsingShaAlgorithm {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public HmacSha256() {
            super(AlgorithmIdentifiers.HMAC_SHA256, MacUtil.HMAC_SHA256, 256);
        }
    }

    public static class HmacSha384 extends HmacUsingShaAlgorithm {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public HmacSha384() {
            super(AlgorithmIdentifiers.HMAC_SHA384, MacUtil.HMAC_SHA384, 384);
        }
    }

    public static class HmacSha512 extends HmacUsingShaAlgorithm {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public HmacSha512() {
            super(AlgorithmIdentifiers.HMAC_SHA512, MacUtil.HMAC_SHA512, 512);
        }
    }
}
