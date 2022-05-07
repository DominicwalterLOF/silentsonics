package org.jose4j.jwe;

import java.security.Key;
import javax.crypto.spec.SecretKeySpec;
import org.jose4j.base64url.Base64Url;
import org.jose4j.jca.ProviderContext;
import org.jose4j.jwa.AlgorithmInfo;
import org.jose4j.jwe.kdf.PasswordBasedKeyDerivationFunction2;
import org.jose4j.jwx.HeaderParameterNames;
import org.jose4j.jwx.Headers;
import org.jose4j.jwx.KeyValidationSupport;
import org.jose4j.keys.AesKey;
import org.jose4j.keys.KeyPersuasion;
import org.jose4j.keys.PbkdfKey;
import org.jose4j.lang.ByteUtil;
import org.jose4j.lang.InvalidKeyException;
import org.jose4j.lang.JoseException;
import org.jose4j.lang.StringUtil;

public class Pbes2HmacShaWithAesKeyWrapAlgorithm extends AlgorithmInfo implements KeyManagementAlgorithm {
    private static final byte[] ZERO_BYTE = {0};
    private long defaultIterationCount = 8192;
    private int defaultSaltByteLength = 12;
    private AesKeyWrapManagementAlgorithm keyWrap;
    private ContentEncryptionKeyDescriptor keyWrapKeyDescriptor;
    private PasswordBasedKeyDerivationFunction2 pbkdf2;

    public Pbes2HmacShaWithAesKeyWrapAlgorithm(String alg, String hmacAlg, AesKeyWrapManagementAlgorithm keyWrapAlg) {
        PasswordBasedKeyDerivationFunction2 passwordBasedKeyDerivationFunction2;
        ContentEncryptionKeyDescriptor contentEncryptionKeyDescriptor;
        setAlgorithmIdentifier(alg);
        setJavaAlgorithm("n/a");
        new PasswordBasedKeyDerivationFunction2(hmacAlg);
        this.pbkdf2 = passwordBasedKeyDerivationFunction2;
        setKeyPersuasion(KeyPersuasion.SYMMETRIC);
        setKeyType(PbkdfKey.ALGORITHM);
        this.keyWrap = keyWrapAlg;
        new ContentEncryptionKeyDescriptor(this.keyWrap.getKeyByteLength(), AesKey.ALGORITHM);
        this.keyWrapKeyDescriptor = contentEncryptionKeyDescriptor;
    }

    public ContentEncryptionKeys manageForEncrypt(Key managementKey, ContentEncryptionKeyDescriptor cekDesc, Headers headers, byte[] cekOverride, ProviderContext providerContext) throws JoseException {
        Headers headers2 = headers;
        ProviderContext providerContext2 = providerContext;
        return this.keyWrap.manageForEncrypt(deriveForEncrypt(managementKey, headers2, providerContext2), cekDesc, headers2, cekOverride, providerContext2);
    }

    /* access modifiers changed from: protected */
    public Key deriveForEncrypt(Key key, Headers headers, ProviderContext providerContext) throws JoseException {
        Base64Url base64Url;
        byte[] saltInput;
        Key managementKey = key;
        Headers headers2 = headers;
        ProviderContext providerContext2 = providerContext;
        Long iterationCount = headers2.getLongHeaderValue(HeaderParameterNames.PBES2_ITERATION_COUNT);
        if (iterationCount == null) {
            iterationCount = Long.valueOf(this.defaultIterationCount);
            headers2.setObjectHeaderValue(HeaderParameterNames.PBES2_ITERATION_COUNT, iterationCount);
        }
        String saltInputString = headers2.getStringHeaderValue(HeaderParameterNames.PBES2_SALT_INPUT);
        new Base64Url();
        Base64Url base64Url2 = base64Url;
        if (saltInputString == null) {
            saltInput = ByteUtil.randomBytes(this.defaultSaltByteLength, providerContext2.getSecureRandom());
            headers2.setStringHeaderValue(HeaderParameterNames.PBES2_SALT_INPUT, base64Url2.base64UrlEncode(saltInput));
        } else {
            saltInput = base64Url2.base64UrlDecode(saltInputString);
        }
        return deriveKey(managementKey, iterationCount, saltInput, providerContext2);
    }

    public Key manageForDecrypt(Key managementKey, byte[] encryptedKey, ContentEncryptionKeyDescriptor cekDesc, Headers headers, ProviderContext providerContext) throws JoseException {
        Base64Url base64Url;
        Headers headers2 = headers;
        ProviderContext providerContext2 = providerContext;
        Long iterationCount = headers2.getLongHeaderValue(HeaderParameterNames.PBES2_ITERATION_COUNT);
        String saltInputString = headers2.getStringHeaderValue(HeaderParameterNames.PBES2_SALT_INPUT);
        new Base64Url();
        return this.keyWrap.manageForDecrypt(deriveKey(managementKey, iterationCount, base64Url.base64UrlDecode(saltInputString), providerContext2), encryptedKey, cekDesc, headers2, providerContext2);
    }

    private Key deriveKey(Key managementKey, Long iterationCount, byte[] saltInput, ProviderContext providerContext) throws JoseException {
        Key key;
        byte[][] bArr = new byte[3][];
        bArr[0] = StringUtil.getBytesUtf8(getAlgorithmIdentifier());
        byte[][] bArr2 = bArr;
        bArr2[1] = ZERO_BYTE;
        byte[][] bArr3 = bArr2;
        bArr3[2] = saltInput;
        new SecretKeySpec(this.pbkdf2.derive(managementKey.getEncoded(), ByteUtil.concat(bArr3), iterationCount.intValue(), this.keyWrapKeyDescriptor.getContentEncryptionKeyByteLength(), providerContext.getSuppliedKeyProviderContext().getMacProvider()), this.keyWrapKeyDescriptor.getContentEncryptionKeyAlgorithm());
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

    public void validateKey(Key managementKey) throws InvalidKeyException {
        KeyValidationSupport.notNull(managementKey);
    }

    public boolean isAvailable() {
        return this.keyWrap.isAvailable();
    }

    public long getDefaultIterationCount() {
        return this.defaultIterationCount;
    }

    public void setDefaultIterationCount(long defaultIterationCount2) {
        long j = defaultIterationCount2;
        this.defaultIterationCount = j;
    }

    public int getDefaultSaltByteLength() {
        return this.defaultSaltByteLength;
    }

    public void setDefaultSaltByteLength(int defaultSaltByteLength2) {
        int i = defaultSaltByteLength2;
        this.defaultSaltByteLength = i;
    }

    public static class HmacSha256Aes128 extends Pbes2HmacShaWithAesKeyWrapAlgorithm {
        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public HmacSha256Aes128() {
            /*
                r7 = this;
                r0 = r7
                r1 = r0
                java.lang.String r2 = "PBES2-HS256+A128KW"
                java.lang.String r3 = "HmacSHA256"
                org.jose4j.jwe.AesKeyWrapManagementAlgorithm$Aes128 r4 = new org.jose4j.jwe.AesKeyWrapManagementAlgorithm$Aes128
                r6 = r4
                r4 = r6
                r5 = r6
                r5.<init>()
                org.jose4j.jwe.AesKeyWrapManagementAlgorithm r4 = r4.setUseGeneralProviderContext()
                r1.<init>(r2, r3, r4)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.jose4j.jwe.Pbes2HmacShaWithAesKeyWrapAlgorithm.HmacSha256Aes128.<init>():void");
        }
    }

    public static class HmacSha384Aes192 extends Pbes2HmacShaWithAesKeyWrapAlgorithm {
        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public HmacSha384Aes192() {
            /*
                r7 = this;
                r0 = r7
                r1 = r0
                java.lang.String r2 = "PBES2-HS384+A192KW"
                java.lang.String r3 = "HmacSHA384"
                org.jose4j.jwe.AesKeyWrapManagementAlgorithm$Aes192 r4 = new org.jose4j.jwe.AesKeyWrapManagementAlgorithm$Aes192
                r6 = r4
                r4 = r6
                r5 = r6
                r5.<init>()
                org.jose4j.jwe.AesKeyWrapManagementAlgorithm r4 = r4.setUseGeneralProviderContext()
                r1.<init>(r2, r3, r4)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.jose4j.jwe.Pbes2HmacShaWithAesKeyWrapAlgorithm.HmacSha384Aes192.<init>():void");
        }
    }

    public static class HmacSha512Aes256 extends Pbes2HmacShaWithAesKeyWrapAlgorithm {
        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public HmacSha512Aes256() {
            /*
                r7 = this;
                r0 = r7
                r1 = r0
                java.lang.String r2 = "PBES2-HS512+A256KW"
                java.lang.String r3 = "HmacSHA512"
                org.jose4j.jwe.AesKeyWrapManagementAlgorithm$Aes256 r4 = new org.jose4j.jwe.AesKeyWrapManagementAlgorithm$Aes256
                r6 = r4
                r4 = r6
                r5 = r6
                r5.<init>()
                org.jose4j.jwe.AesKeyWrapManagementAlgorithm r4 = r4.setUseGeneralProviderContext()
                r1.<init>(r2, r3, r4)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.jose4j.jwe.Pbes2HmacShaWithAesKeyWrapAlgorithm.HmacSha512Aes256.<init>():void");
        }
    }
}
