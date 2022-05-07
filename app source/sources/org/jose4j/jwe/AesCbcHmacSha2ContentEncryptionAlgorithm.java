package org.jose4j.jwe;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.Mac;
import javax.crypto.spec.IvParameterSpec;
import org.jose4j.base64url.Base64Url;
import org.jose4j.jca.ProviderContext;
import org.jose4j.jwa.AlgorithmInfo;
import org.jose4j.jwx.Headers;
import org.jose4j.keys.AesKey;
import org.jose4j.keys.HmacKey;
import org.jose4j.keys.KeyPersuasion;
import org.jose4j.lang.ByteUtil;
import org.jose4j.lang.IntegrityException;
import org.jose4j.lang.JoseException;
import org.jose4j.mac.MacUtil;

public class AesCbcHmacSha2ContentEncryptionAlgorithm extends AlgorithmInfo implements ContentEncryptionAlgorithm {
    public static final int IV_BYTE_LENGTH = 16;
    private final ContentEncryptionKeyDescriptor contentEncryptionKeyDescriptor;
    private final String hmacJavaAlgorithm;
    private final int tagTruncationLength;

    public AesCbcHmacSha2ContentEncryptionAlgorithm(String alg, int cekByteLen, String javaHmacAlg, int tagTruncationLength2) {
        ContentEncryptionKeyDescriptor contentEncryptionKeyDescriptor2;
        setAlgorithmIdentifier(alg);
        new ContentEncryptionKeyDescriptor(cekByteLen, AesKey.ALGORITHM);
        this.contentEncryptionKeyDescriptor = contentEncryptionKeyDescriptor2;
        this.hmacJavaAlgorithm = javaHmacAlg;
        this.tagTruncationLength = tagTruncationLength2;
        setJavaAlgorithm("AES/CBC/PKCS5Padding");
        setKeyPersuasion(KeyPersuasion.SYMMETRIC);
        setKeyType(AesKey.ALGORITHM);
    }

    public String getHmacJavaAlgorithm() {
        return this.hmacJavaAlgorithm;
    }

    public int getTagTruncationLength() {
        return this.tagTruncationLength;
    }

    public ContentEncryptionKeyDescriptor getContentEncryptionKeyDescriptor() {
        return this.contentEncryptionKeyDescriptor;
    }

    public ContentEncryptionParts encrypt(byte[] plaintext, byte[] aad, byte[] contentEncryptionKey, Headers headers, byte[] ivOverride, ProviderContext providerContext) throws JoseException {
        ProviderContext providerContext2 = providerContext;
        return encrypt(plaintext, aad, contentEncryptionKey, InitializationVectorHelp.iv(16, ivOverride, providerContext2.getSecureRandom()), headers, providerContext2);
    }

    /* access modifiers changed from: package-private */
    public ContentEncryptionParts encrypt(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, Headers headers, ProviderContext providerContext) throws JoseException {
        Key key;
        Key encryptionKey;
        Throwable th;
        Throwable th2;
        StringBuilder sb;
        AlgorithmParameterSpec algorithmParameterSpec;
        Throwable th3;
        ContentEncryptionParts contentEncryptionParts;
        byte[] plaintext = bArr;
        byte[] aad = bArr2;
        byte[] key2 = bArr3;
        byte[] iv = bArr4;
        Headers headers2 = headers;
        ProviderContext providerContext2 = providerContext;
        new HmacKey(ByteUtil.leftHalf(key2));
        Key hmacKey = key;
        new AesKey(ByteUtil.rightHalf(key2));
        Cipher cipher = CipherUtil.getCipher(getJavaAlgorithm(), ContentEncryptionHelp.getCipherProvider(headers2, providerContext2));
        Cipher cipher2 = cipher;
        Key key3 = encryptionKey;
        try {
            new IvParameterSpec(iv);
            cipher2.init(1, key3, algorithmParameterSpec);
            try {
                byte[] cipherText = cipher.doFinal(plaintext);
                Mac mac = MacUtil.getInitializedMac(getHmacJavaAlgorithm(), hmacKey, ContentEncryptionHelp.getMacProvider(headers2, providerContext2));
                byte[] al = getAdditionalAuthenticatedDataLengthBytes(aad);
                byte[][] bArr5 = new byte[4][];
                bArr5[0] = aad;
                byte[][] bArr6 = bArr5;
                bArr6[1] = iv;
                byte[][] bArr7 = bArr6;
                bArr7[2] = cipherText;
                byte[][] bArr8 = bArr7;
                bArr8[3] = al;
                new ContentEncryptionParts(iv, cipherText, ByteUtil.subArray(mac.doFinal(ByteUtil.concat(bArr8)), 0, getTagTruncationLength()));
                return contentEncryptionParts;
            } catch (BadPaddingException | IllegalBlockSizeException e) {
                GeneralSecurityException e2 = e;
                Throwable th4 = th3;
                new JoseException(e2.toString(), e2);
                throw th4;
            }
        } catch (InvalidKeyException e3) {
            InvalidKeyException e4 = e3;
            Throwable th5 = th2;
            new StringBuilder();
            new JoseException(sb.append("Invalid key for ").append(getJavaAlgorithm()).toString(), e4);
            throw th5;
        } catch (InvalidAlgorithmParameterException e5) {
            InvalidAlgorithmParameterException e6 = e5;
            Throwable th6 = th;
            new JoseException(e6.toString(), e6);
            throw th6;
        }
    }

    public byte[] decrypt(ContentEncryptionParts contentEncryptionParts, byte[] bArr, byte[] bArr2, Headers headers, ProviderContext providerContext) throws JoseException {
        Key hmacKey;
        Key encryptionKey;
        Throwable th;
        Throwable th2;
        StringBuilder sb;
        AlgorithmParameterSpec algorithmParameterSpec;
        Throwable th3;
        Base64Url base64Url;
        Throwable th4;
        StringBuilder sb2;
        ContentEncryptionParts contentEncryptionParts2 = contentEncryptionParts;
        byte[] aad = bArr;
        byte[] contentEncryptionKey = bArr2;
        Headers headers2 = headers;
        ProviderContext providerContext2 = providerContext;
        String cipherProvider = ContentEncryptionHelp.getCipherProvider(headers2, providerContext2);
        String macProvider = ContentEncryptionHelp.getMacProvider(headers2, providerContext2);
        byte[] iv = contentEncryptionParts2.getIv();
        byte[] ciphertext = contentEncryptionParts2.getCiphertext();
        byte[] authenticationTag = contentEncryptionParts2.getAuthenticationTag();
        byte[] al = getAdditionalAuthenticatedDataLengthBytes(aad);
        byte[][] bArr3 = new byte[4][];
        bArr3[0] = aad;
        byte[][] bArr4 = bArr3;
        bArr4[1] = iv;
        byte[][] bArr5 = bArr4;
        bArr5[2] = ciphertext;
        byte[][] bArr6 = bArr5;
        bArr6[3] = al;
        byte[] authenticationTagInput = ByteUtil.concat(bArr6);
        new HmacKey(ByteUtil.leftHalf(contentEncryptionKey));
        if (!ByteUtil.secureEquals(authenticationTag, ByteUtil.subArray(MacUtil.getInitializedMac(getHmacJavaAlgorithm(), hmacKey, macProvider).doFinal(authenticationTagInput), 0, getTagTruncationLength()))) {
            new Base64Url();
            String encTag = base64Url.base64UrlEncode(authenticationTag);
            Throwable th5 = th4;
            new StringBuilder();
            new IntegrityException(sb2.append("Authentication tag check failed. Message=").append(encTag).toString());
            throw th5;
        }
        new AesKey(ByteUtil.rightHalf(contentEncryptionKey));
        Cipher cipher = CipherUtil.getCipher(getJavaAlgorithm(), cipherProvider);
        Cipher cipher2 = cipher;
        Key key = encryptionKey;
        try {
            new IvParameterSpec(iv);
            cipher2.init(2, key, algorithmParameterSpec);
            try {
                return cipher.doFinal(ciphertext);
            } catch (BadPaddingException | IllegalBlockSizeException e) {
                GeneralSecurityException e2 = e;
                Throwable th6 = th3;
                new JoseException(e2.toString(), e2);
                throw th6;
            }
        } catch (InvalidKeyException e3) {
            InvalidKeyException e4 = e3;
            Throwable th7 = th2;
            new StringBuilder();
            new JoseException(sb.append("Invalid key for ").append(getJavaAlgorithm()).toString(), e4);
            throw th7;
        } catch (InvalidAlgorithmParameterException e5) {
            InvalidAlgorithmParameterException e6 = e5;
            Throwable th8 = th;
            new JoseException(e6.toString(), e6);
            throw th8;
        }
    }

    private byte[] getAdditionalAuthenticatedDataLengthBytes(byte[] additionalAuthenticatedData) {
        return ByteUtil.getBytes((long) ByteUtil.bitLength(additionalAuthenticatedData));
    }

    public boolean isAvailable() {
        return CipherStrengthSupport.isAvailable(getJavaAlgorithm(), getContentEncryptionKeyDescriptor().getContentEncryptionKeyByteLength() / 2);
    }

    public static class Aes128CbcHmacSha256 extends AesCbcHmacSha2ContentEncryptionAlgorithm implements ContentEncryptionAlgorithm {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Aes128CbcHmacSha256() {
            super(ContentEncryptionAlgorithmIdentifiers.AES_128_CBC_HMAC_SHA_256, 32, MacUtil.HMAC_SHA256, 16);
        }
    }

    public static class Aes192CbcHmacSha384 extends AesCbcHmacSha2ContentEncryptionAlgorithm implements ContentEncryptionAlgorithm {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Aes192CbcHmacSha384() {
            super(ContentEncryptionAlgorithmIdentifiers.AES_192_CBC_HMAC_SHA_384, 48, MacUtil.HMAC_SHA384, 24);
        }
    }

    public static class Aes256CbcHmacSha512 extends AesCbcHmacSha2ContentEncryptionAlgorithm implements ContentEncryptionAlgorithm {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Aes256CbcHmacSha512() {
            super(ContentEncryptionAlgorithmIdentifiers.AES_256_CBC_HMAC_SHA_512, 64, MacUtil.HMAC_SHA512, 32);
        }
    }
}
