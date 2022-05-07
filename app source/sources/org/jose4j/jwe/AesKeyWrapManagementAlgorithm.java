package org.jose4j.jwe;

import java.security.Key;
import org.jose4j.jwa.AlgorithmAvailability;
import org.jose4j.jwk.OctetSequenceJsonWebKey;
import org.jose4j.jwx.KeyValidationSupport;
import org.jose4j.keys.KeyPersuasion;
import org.jose4j.lang.InvalidKeyException;

public class AesKeyWrapManagementAlgorithm extends WrappingKeyManagementAlgorithm {
    int keyByteLength;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AesKeyWrapManagementAlgorithm(String alg, int keyByteLength2) {
        super("AESWrap", alg);
        setKeyType(OctetSequenceJsonWebKey.KEY_TYPE);
        setKeyPersuasion(KeyPersuasion.SYMMETRIC);
        this.keyByteLength = keyByteLength2;
    }

    /* access modifiers changed from: package-private */
    public int getKeyByteLength() {
        return this.keyByteLength;
    }

    public void validateEncryptionKey(Key managementKey, ContentEncryptionAlgorithm contentEncryptionAlgorithm) throws InvalidKeyException {
        ContentEncryptionAlgorithm contentEncryptionAlgorithm2 = contentEncryptionAlgorithm;
        validateKey(managementKey);
    }

    public void validateDecryptionKey(Key managementKey, ContentEncryptionAlgorithm contentEncryptionAlgorithm) throws InvalidKeyException {
        ContentEncryptionAlgorithm contentEncryptionAlgorithm2 = contentEncryptionAlgorithm;
        validateKey(managementKey);
    }

    /* access modifiers changed from: package-private */
    public void validateKey(Key managementKey) throws InvalidKeyException {
        KeyValidationSupport.validateAesWrappingKey(managementKey, getAlgorithmIdentifier(), getKeyByteLength());
    }

    public boolean isAvailable() {
        int aesByteKeyLength = getKeyByteLength();
        String agl = getJavaAlgorithm();
        return AlgorithmAvailability.isAvailable("Cipher", agl) && CipherStrengthSupport.isAvailable(agl, aesByteKeyLength);
    }

    /* access modifiers changed from: package-private */
    public AesKeyWrapManagementAlgorithm setUseGeneralProviderContext() {
        this.useSuppliedKeyProviderContext = false;
        return this;
    }

    public static class Aes128 extends AesKeyWrapManagementAlgorithm {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Aes128() {
            super(KeyManagementAlgorithmIdentifiers.A128KW, 16);
        }
    }

    public static class Aes192 extends AesKeyWrapManagementAlgorithm {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Aes192() {
            super(KeyManagementAlgorithmIdentifiers.A192KW, 24);
        }
    }

    public static class Aes256 extends AesKeyWrapManagementAlgorithm {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Aes256() {
            super(KeyManagementAlgorithmIdentifiers.A256KW, 32);
        }
    }
}
