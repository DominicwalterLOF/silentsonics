package org.jose4j.jwe;

import java.security.Key;
import javax.crypto.spec.SecretKeySpec;
import org.jose4j.jca.ProviderContext;
import org.jose4j.jwa.AlgorithmInfo;
import org.jose4j.jwx.Headers;
import org.jose4j.keys.AesKey;
import org.jose4j.keys.KeyPersuasion;
import org.jose4j.lang.ByteUtil;
import org.jose4j.lang.InvalidKeyException;
import org.jose4j.lang.JoseException;

public class EcdhKeyAgreementWithAesKeyWrapAlgorithm extends AlgorithmInfo implements KeyManagementAlgorithm {
    private EcdhKeyAgreementAlgorithm ecdh;
    private AesKeyWrapManagementAlgorithm keyWrap;
    private ContentEncryptionKeyDescriptor keyWrapKeyDescriptor;

    public EcdhKeyAgreementWithAesKeyWrapAlgorithm(String alg, AesKeyWrapManagementAlgorithm aesKeyWrapManagementAlgorithm) {
        EcdhKeyAgreementAlgorithm ecdhKeyAgreementAlgorithm;
        ContentEncryptionKeyDescriptor contentEncryptionKeyDescriptor;
        AesKeyWrapManagementAlgorithm keyWrapAlgorithm = aesKeyWrapManagementAlgorithm;
        setAlgorithmIdentifier(alg);
        setJavaAlgorithm("N/A");
        setKeyType("EC");
        setKeyPersuasion(KeyPersuasion.ASYMMETRIC);
        this.keyWrap = keyWrapAlgorithm;
        new EcdhKeyAgreementAlgorithm("alg");
        this.ecdh = ecdhKeyAgreementAlgorithm;
        new ContentEncryptionKeyDescriptor(keyWrapAlgorithm.getKeyByteLength(), AesKey.ALGORITHM);
        this.keyWrapKeyDescriptor = contentEncryptionKeyDescriptor;
    }

    public ContentEncryptionKeys manageForEncrypt(Key managementKey, ContentEncryptionKeyDescriptor cekDesc, Headers headers, byte[] cekOverride, ProviderContext providerContext) throws JoseException {
        Key agreedKey;
        Headers headers2 = headers;
        ProviderContext providerContext2 = providerContext;
        ContentEncryptionKeys agreedKeys = this.ecdh.manageForEncrypt(managementKey, this.keyWrapKeyDescriptor, headers2, (byte[]) null, providerContext2);
        new SecretKeySpec(agreedKeys.getContentEncryptionKey(), this.keyWrapKeyDescriptor.getContentEncryptionKeyAlgorithm());
        return this.keyWrap.manageForEncrypt(agreedKey, cekDesc, headers2, cekOverride, providerContext2);
    }

    public Key manageForDecrypt(Key managementKey, byte[] encryptedKey, ContentEncryptionKeyDescriptor cekDesc, Headers headers, ProviderContext providerContext) throws JoseException {
        Headers headers2 = headers;
        ProviderContext providerContext2 = providerContext;
        return this.keyWrap.manageForDecrypt(this.ecdh.manageForDecrypt(managementKey, ByteUtil.EMPTY_BYTES, this.keyWrapKeyDescriptor, headers2, providerContext2), encryptedKey, cekDesc, headers2, providerContext2);
    }

    public void validateEncryptionKey(Key managementKey, ContentEncryptionAlgorithm contentEncryptionAlg) throws InvalidKeyException {
        this.ecdh.validateEncryptionKey(managementKey, contentEncryptionAlg);
    }

    public void validateDecryptionKey(Key managementKey, ContentEncryptionAlgorithm contentEncryptionAlg) throws InvalidKeyException {
        this.ecdh.validateDecryptionKey(managementKey, contentEncryptionAlg);
    }

    public boolean isAvailable() {
        return this.ecdh.isAvailable() && this.keyWrap.isAvailable();
    }

    public static class EcdhKeyAgreementWithAes128KeyWrapAlgorithm extends EcdhKeyAgreementWithAesKeyWrapAlgorithm implements KeyManagementAlgorithm {
        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public EcdhKeyAgreementWithAes128KeyWrapAlgorithm() {
            /*
                r6 = this;
                r0 = r6
                r1 = r0
                java.lang.String r2 = "ECDH-ES+A128KW"
                org.jose4j.jwe.AesKeyWrapManagementAlgorithm$Aes128 r3 = new org.jose4j.jwe.AesKeyWrapManagementAlgorithm$Aes128
                r5 = r3
                r3 = r5
                r4 = r5
                r4.<init>()
                org.jose4j.jwe.AesKeyWrapManagementAlgorithm r3 = r3.setUseGeneralProviderContext()
                r1.<init>(r2, r3)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.jose4j.jwe.EcdhKeyAgreementWithAesKeyWrapAlgorithm.EcdhKeyAgreementWithAes128KeyWrapAlgorithm.<init>():void");
        }
    }

    public static class EcdhKeyAgreementWithAes192KeyWrapAlgorithm extends EcdhKeyAgreementWithAesKeyWrapAlgorithm implements KeyManagementAlgorithm {
        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public EcdhKeyAgreementWithAes192KeyWrapAlgorithm() {
            /*
                r6 = this;
                r0 = r6
                r1 = r0
                java.lang.String r2 = "ECDH-ES+A192KW"
                org.jose4j.jwe.AesKeyWrapManagementAlgorithm$Aes192 r3 = new org.jose4j.jwe.AesKeyWrapManagementAlgorithm$Aes192
                r5 = r3
                r3 = r5
                r4 = r5
                r4.<init>()
                org.jose4j.jwe.AesKeyWrapManagementAlgorithm r3 = r3.setUseGeneralProviderContext()
                r1.<init>(r2, r3)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.jose4j.jwe.EcdhKeyAgreementWithAesKeyWrapAlgorithm.EcdhKeyAgreementWithAes192KeyWrapAlgorithm.<init>():void");
        }
    }

    public static class EcdhKeyAgreementWithAes256KeyWrapAlgorithm extends EcdhKeyAgreementWithAesKeyWrapAlgorithm implements KeyManagementAlgorithm {
        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public EcdhKeyAgreementWithAes256KeyWrapAlgorithm() {
            /*
                r6 = this;
                r0 = r6
                r1 = r0
                java.lang.String r2 = "ECDH-ES+A256KW"
                org.jose4j.jwe.AesKeyWrapManagementAlgorithm$Aes256 r3 = new org.jose4j.jwe.AesKeyWrapManagementAlgorithm$Aes256
                r5 = r3
                r3 = r5
                r4 = r5
                r4.<init>()
                org.jose4j.jwe.AesKeyWrapManagementAlgorithm r3 = r3.setUseGeneralProviderContext()
                r1.<init>(r2, r3)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.jose4j.jwe.EcdhKeyAgreementWithAesKeyWrapAlgorithm.EcdhKeyAgreementWithAes256KeyWrapAlgorithm.<init>():void");
        }
    }
}
