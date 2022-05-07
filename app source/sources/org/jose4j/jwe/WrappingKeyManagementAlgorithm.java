package org.jose4j.jwe;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.spec.SecretKeySpec;
import org.jose4j.jca.ProviderContext;
import org.jose4j.jwa.AlgorithmInfo;
import org.jose4j.jwx.Headers;
import org.jose4j.lang.ByteUtil;
import org.jose4j.lang.ExceptionHelp;
import org.jose4j.lang.JoseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class WrappingKeyManagementAlgorithm extends AlgorithmInfo implements KeyManagementAlgorithm {
    private AlgorithmParameterSpec algorithmParameterSpec;
    protected final Logger log = LoggerFactory.getLogger(getClass());
    protected boolean useSuppliedKeyProviderContext = true;

    public WrappingKeyManagementAlgorithm(String javaAlg, String alg) {
        setJavaAlgorithm(javaAlg);
        setAlgorithmIdentifier(alg);
    }

    public void setAlgorithmParameterSpec(AlgorithmParameterSpec algorithmParameterSpec2) {
        AlgorithmParameterSpec algorithmParameterSpec3 = algorithmParameterSpec2;
        this.algorithmParameterSpec = algorithmParameterSpec3;
    }

    public ContentEncryptionKeys manageForEncrypt(Key managementKey, ContentEncryptionKeyDescriptor contentEncryptionKeyDescriptor, Headers headers, byte[] bArr, ProviderContext providerContext) throws JoseException {
        ContentEncryptionKeyDescriptor cekDesc = contentEncryptionKeyDescriptor;
        Headers headers2 = headers;
        byte[] cekOverride = bArr;
        return manageForEnc(managementKey, cekDesc, cekOverride == null ? ByteUtil.randomBytes(cekDesc.getContentEncryptionKeyByteLength()) : cekOverride, providerContext);
    }

    /* access modifiers changed from: protected */
    public ContentEncryptionKeys manageForEnc(Key key, ContentEncryptionKeyDescriptor contentEncryptionKeyDescriptor, byte[] bArr, ProviderContext providerContext) throws JoseException {
        ProviderContext.Context ctx;
        Throwable th;
        StringBuilder sb;
        Throwable th2;
        StringBuilder sb2;
        Key key2;
        ContentEncryptionKeys contentEncryptionKeys;
        Key managementKey = key;
        ContentEncryptionKeyDescriptor cekDesc = contentEncryptionKeyDescriptor;
        byte[] contentEncryptionKey = bArr;
        ProviderContext providerContext2 = providerContext;
        if (this.useSuppliedKeyProviderContext) {
            ctx = providerContext2.getSuppliedKeyProviderContext();
        } else {
            ctx = providerContext2.getGeneralProviderContext();
        }
        Cipher cipher = CipherUtil.getCipher(getJavaAlgorithm(), ctx.getCipherProvider());
        try {
            initCipher(cipher, 3, managementKey);
            new SecretKeySpec(contentEncryptionKey, cekDesc.getContentEncryptionKeyAlgorithm());
            ContentEncryptionKeys contentEncryptionKeys2 = contentEncryptionKeys;
            new ContentEncryptionKeys(contentEncryptionKey, cipher.wrap(key2));
            return contentEncryptionKeys2;
        } catch (InvalidKeyException e) {
            InvalidKeyException e2 = e;
            Throwable th3 = th2;
            new StringBuilder();
            new org.jose4j.lang.InvalidKeyException(sb2.append("Unable to encrypt (").append(cipher.getAlgorithm()).append(") the Content Encryption Key: ").append(e2).toString(), e2);
            throw th3;
        } catch (InvalidAlgorithmParameterException | IllegalBlockSizeException e3) {
            GeneralSecurityException e4 = e3;
            Throwable th4 = th;
            new StringBuilder();
            new JoseException(sb.append("Unable to encrypt (").append(cipher.getAlgorithm()).append(") the Content Encryption Key: ").append(e4).toString(), e4);
            throw th4;
        }
    }

    /* access modifiers changed from: package-private */
    public void initCipher(Cipher cipher, int i, Key key) throws InvalidAlgorithmParameterException, InvalidKeyException {
        Cipher cipher2 = cipher;
        int mode = i;
        Key key2 = key;
        if (this.algorithmParameterSpec == null) {
            cipher2.init(mode, key2);
        } else {
            cipher2.init(mode, key2, this.algorithmParameterSpec);
        }
    }

    public Key manageForDecrypt(Key managementKey, byte[] bArr, ContentEncryptionKeyDescriptor contentEncryptionKeyDescriptor, Headers headers, ProviderContext providerContext) throws JoseException {
        Throwable th;
        StringBuilder sb;
        Throwable th2;
        StringBuilder sb2;
        Key key;
        byte[] encryptedKey = bArr;
        ContentEncryptionKeyDescriptor cekDesc = contentEncryptionKeyDescriptor;
        Headers headers2 = headers;
        Cipher cipher = CipherUtil.getCipher(getJavaAlgorithm(), providerContext.getSuppliedKeyProviderContext().getCipherProvider());
        try {
            initCipher(cipher, 4, managementKey);
            String cekAlg = cekDesc.getContentEncryptionKeyAlgorithm();
            try {
                return cipher.unwrap(encryptedKey, cekAlg, 3);
            } catch (Exception e) {
                Exception e2 = e;
                if (this.log.isDebugEnabled()) {
                    this.log.debug("Key unwrap failed. Substituting a randomly generated CEK and proceeding. {}", (Object) ExceptionHelp.toStringWithCausesAndAbbreviatedStack(e2, JsonWebEncryption.class));
                }
                new SecretKeySpec(ByteUtil.randomBytes(cekDesc.getContentEncryptionKeyByteLength()), cekAlg);
                return key;
            }
        } catch (InvalidKeyException e3) {
            InvalidKeyException e4 = e3;
            Throwable th3 = th2;
            new StringBuilder();
            new org.jose4j.lang.InvalidKeyException(sb2.append("Unable to initialize cipher (").append(cipher.getAlgorithm()).append(") for key decryption - ").append(e4).toString(), e4);
            throw th3;
        } catch (InvalidAlgorithmParameterException e5) {
            InvalidAlgorithmParameterException e6 = e5;
            Throwable th4 = th;
            new StringBuilder();
            new JoseException(sb.append("Unable to initialize cipher (").append(cipher.getAlgorithm()).append(") for key decryption - ").append(e6).toString(), e6);
            throw th4;
        }
    }
}
