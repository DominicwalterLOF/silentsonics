package org.jose4j.jwe;

import com.google.appinventor.components.runtime.util.FullScreenVideoUtil;
import java.security.Key;
import java.security.SecureRandom;
import javax.crypto.spec.SecretKeySpec;
import org.jose4j.base64url.Base64Url;
import org.jose4j.jca.ProviderContext;
import org.jose4j.jwa.AlgorithmInfo;
import org.jose4j.jwe.SimpleAeadCipher;
import org.jose4j.jwk.OctetSequenceJsonWebKey;
import org.jose4j.jwx.HeaderParameterNames;
import org.jose4j.jwx.Headers;
import org.jose4j.jwx.KeyValidationSupport;
import org.jose4j.keys.KeyPersuasion;
import org.jose4j.lang.ByteUtil;
import org.jose4j.lang.InvalidKeyException;
import org.jose4j.lang.JoseException;

public class AesGcmKeyEncryptionAlgorithm extends AlgorithmInfo implements KeyManagementAlgorithm {
    private static final int IV_BYTE_LENGTH = 12;
    private static final int TAG_BYTE_LENGTH = 16;
    private int keyByteLength;
    private SimpleAeadCipher simpleAeadCipher;

    public AesGcmKeyEncryptionAlgorithm(String alg, int keyByteLength2) {
        SimpleAeadCipher simpleAeadCipher2;
        setAlgorithmIdentifier(alg);
        setJavaAlgorithm(SimpleAeadCipher.GCM_TRANSFORMATION_NAME);
        setKeyPersuasion(KeyPersuasion.SYMMETRIC);
        setKeyType(OctetSequenceJsonWebKey.KEY_TYPE);
        new SimpleAeadCipher(getJavaAlgorithm(), 16);
        this.simpleAeadCipher = simpleAeadCipher2;
        this.keyByteLength = keyByteLength2;
    }

    public ContentEncryptionKeys manageForEncrypt(Key key, ContentEncryptionKeyDescriptor contentEncryptionKeyDescriptor, Headers headers, byte[] bArr, ProviderContext providerContext) throws JoseException {
        Base64Url base64Url;
        byte[] iv;
        ContentEncryptionKeys contentEncryptionKeys;
        Key managementKey = key;
        ContentEncryptionKeyDescriptor cekDesc = contentEncryptionKeyDescriptor;
        Headers headers2 = headers;
        byte[] cekOverride = bArr;
        ProviderContext providerContext2 = providerContext;
        SecureRandom secureRandom = providerContext2.getSecureRandom();
        byte[] cek = cekOverride == null ? ByteUtil.randomBytes(cekDesc.getContentEncryptionKeyByteLength(), secureRandom) : cekOverride;
        new Base64Url();
        Base64Url base64Url2 = base64Url;
        String encodedIv = headers2.getStringHeaderValue(HeaderParameterNames.INITIALIZATION_VECTOR);
        if (encodedIv == null) {
            iv = ByteUtil.randomBytes(12, secureRandom);
            headers2.setStringHeaderValue(HeaderParameterNames.INITIALIZATION_VECTOR, base64Url2.base64UrlEncode(iv));
        } else {
            iv = base64Url2.base64UrlDecode(encodedIv);
        }
        SimpleAeadCipher.CipherOutput encrypted = this.simpleAeadCipher.encrypt(managementKey, iv, cek, (byte[]) null, providerContext2.getSuppliedKeyProviderContext().getCipherProvider());
        byte[] encryptedKey = encrypted.getCiphertext();
        headers2.setStringHeaderValue(HeaderParameterNames.AUTHENTICATION_TAG, base64Url2.base64UrlEncode(encrypted.getTag()));
        new ContentEncryptionKeys(cek, encryptedKey);
        return contentEncryptionKeys;
    }

    public Key manageForDecrypt(Key managementKey, byte[] encryptedKey, ContentEncryptionKeyDescriptor cekDesc, Headers headers, ProviderContext providerContext) throws JoseException {
        Base64Url base64Url;
        Key key;
        Headers headers2 = headers;
        new Base64Url();
        Base64Url base64Url2 = base64Url;
        byte[] iv = base64Url2.base64UrlDecode(headers2.getStringHeaderValue(HeaderParameterNames.INITIALIZATION_VECTOR));
        byte[] tag = base64Url2.base64UrlDecode(headers2.getStringHeaderValue(HeaderParameterNames.AUTHENTICATION_TAG));
        String cipherProvider = providerContext.getSuppliedKeyProviderContext().getCipherProvider();
        new SecretKeySpec(this.simpleAeadCipher.decrypt(managementKey, iv, encryptedKey, tag, (byte[]) null, cipherProvider), cekDesc.getContentEncryptionKeyAlgorithm());
        return key;
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
        KeyValidationSupport.validateAesWrappingKey(managementKey, getAlgorithmIdentifier(), this.keyByteLength);
    }

    public boolean isAvailable() {
        return this.simpleAeadCipher.isAvailable(this.log, this.keyByteLength, 12, getAlgorithmIdentifier());
    }

    public static class Aes128Gcm extends AesGcmKeyEncryptionAlgorithm {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Aes128Gcm() {
            super(KeyManagementAlgorithmIdentifiers.A128GCMKW, ByteUtil.byteLength(128));
        }
    }

    public static class Aes192Gcm extends AesGcmKeyEncryptionAlgorithm {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Aes192Gcm() {
            super(KeyManagementAlgorithmIdentifiers.A192GCMKW, ByteUtil.byteLength(FullScreenVideoUtil.FULLSCREEN_VIDEO_ACTION_PAUSE));
        }
    }

    public static class Aes256Gcm extends AesGcmKeyEncryptionAlgorithm {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Aes256Gcm() {
            super(KeyManagementAlgorithmIdentifiers.A256GCMKW, ByteUtil.byteLength(256));
        }
    }
}
