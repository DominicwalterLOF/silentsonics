package org.jose4j.jwe;

import com.google.appinventor.components.runtime.util.FullScreenVideoUtil;
import java.security.Key;
import org.jose4j.jca.ProviderContext;
import org.jose4j.jwa.AlgorithmInfo;
import org.jose4j.jwe.SimpleAeadCipher;
import org.jose4j.jwx.Headers;
import org.jose4j.keys.AesKey;
import org.jose4j.keys.KeyPersuasion;
import org.jose4j.lang.ByteUtil;
import org.jose4j.lang.JoseException;

public class AesGcmContentEncryptionAlgorithm extends AlgorithmInfo implements ContentEncryptionAlgorithm {
    private static final int IV_BYTE_LENGTH = 12;
    private static final int TAG_BYTE_LENGTH = 16;
    private ContentEncryptionKeyDescriptor contentEncryptionKeyDescriptor;
    private SimpleAeadCipher simpleAeadCipher;

    public AesGcmContentEncryptionAlgorithm(String alg, int keyBitLength) {
        ContentEncryptionKeyDescriptor contentEncryptionKeyDescriptor2;
        SimpleAeadCipher simpleAeadCipher2;
        setAlgorithmIdentifier(alg);
        setJavaAlgorithm(SimpleAeadCipher.GCM_TRANSFORMATION_NAME);
        setKeyPersuasion(KeyPersuasion.SYMMETRIC);
        setKeyType(AesKey.ALGORITHM);
        new ContentEncryptionKeyDescriptor(ByteUtil.byteLength(keyBitLength), AesKey.ALGORITHM);
        this.contentEncryptionKeyDescriptor = contentEncryptionKeyDescriptor2;
        new SimpleAeadCipher(getJavaAlgorithm(), 16);
        this.simpleAeadCipher = simpleAeadCipher2;
    }

    public ContentEncryptionKeyDescriptor getContentEncryptionKeyDescriptor() {
        return this.contentEncryptionKeyDescriptor;
    }

    public ContentEncryptionParts encrypt(byte[] plaintext, byte[] aad, byte[] contentEncryptionKey, Headers headers, byte[] ivOverride, ProviderContext providerContext) throws JoseException {
        ProviderContext providerContext2 = providerContext;
        return encrypt(plaintext, aad, contentEncryptionKey, InitializationVectorHelp.iv(12, ivOverride, providerContext2.getSecureRandom()), ContentEncryptionHelp.getCipherProvider(headers, providerContext2));
    }

    public ContentEncryptionParts encrypt(byte[] plaintext, byte[] aad, byte[] contentEncryptionKey, byte[] bArr, String provider) throws JoseException {
        Key key;
        ContentEncryptionParts contentEncryptionParts;
        byte[] iv = bArr;
        new AesKey(contentEncryptionKey);
        Key key2 = key;
        SimpleAeadCipher.CipherOutput encrypted = this.simpleAeadCipher.encrypt(key2, iv, plaintext, aad, provider);
        new ContentEncryptionParts(iv, encrypted.getCiphertext(), encrypted.getTag());
        return contentEncryptionParts;
    }

    public byte[] decrypt(ContentEncryptionParts contentEncryptionParts, byte[] aad, byte[] contentEncryptionKey, Headers headers, ProviderContext providerContext) throws JoseException {
        Key key;
        ContentEncryptionParts contentEncParts = contentEncryptionParts;
        byte[] iv = contentEncParts.getIv();
        new AesKey(contentEncryptionKey);
        return this.simpleAeadCipher.decrypt(key, iv, contentEncParts.getCiphertext(), contentEncParts.getAuthenticationTag(), aad, ContentEncryptionHelp.getCipherProvider(headers, providerContext));
    }

    public boolean isAvailable() {
        return this.simpleAeadCipher.isAvailable(this.log, getContentEncryptionKeyDescriptor().getContentEncryptionKeyByteLength(), 12, getAlgorithmIdentifier());
    }

    public static class Aes256Gcm extends AesGcmContentEncryptionAlgorithm {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Aes256Gcm() {
            super(ContentEncryptionAlgorithmIdentifiers.AES_256_GCM, 256);
        }
    }

    public static class Aes192Gcm extends AesGcmContentEncryptionAlgorithm {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Aes192Gcm() {
            super(ContentEncryptionAlgorithmIdentifiers.AES_192_GCM, FullScreenVideoUtil.FULLSCREEN_VIDEO_ACTION_PAUSE);
        }
    }

    public static class Aes128Gcm extends AesGcmContentEncryptionAlgorithm {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Aes128Gcm() {
            super(ContentEncryptionAlgorithmIdentifiers.AES_128_GCM, 128);
        }
    }
}
