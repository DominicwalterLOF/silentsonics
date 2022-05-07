package org.jose4j.jwe;

import java.security.Key;
import org.jose4j.jca.ProviderContext;
import org.jose4j.jwa.AlgorithmInfo;
import org.jose4j.jwk.OctetSequenceJsonWebKey;
import org.jose4j.jwx.Headers;
import org.jose4j.jwx.KeyValidationSupport;
import org.jose4j.keys.KeyPersuasion;
import org.jose4j.lang.ByteUtil;
import org.jose4j.lang.InvalidKeyException;
import org.jose4j.lang.JoseException;

public class DirectKeyManagementAlgorithm extends AlgorithmInfo implements KeyManagementAlgorithm {
    public DirectKeyManagementAlgorithm() {
        setAlgorithmIdentifier(KeyManagementAlgorithmIdentifiers.DIRECT);
        setKeyPersuasion(KeyPersuasion.SYMMETRIC);
        setKeyType(OctetSequenceJsonWebKey.KEY_TYPE);
    }

    public ContentEncryptionKeys manageForEncrypt(Key managementKey, ContentEncryptionKeyDescriptor contentEncryptionKeyDescriptor, Headers headers, byte[] cekOverride, ProviderContext providerContext) throws JoseException {
        ContentEncryptionKeys contentEncryptionKeys;
        ContentEncryptionKeyDescriptor contentEncryptionKeyDescriptor2 = contentEncryptionKeyDescriptor;
        Headers headers2 = headers;
        ProviderContext providerContext2 = providerContext;
        KeyValidationSupport.cekNotAllowed(cekOverride, getAlgorithmIdentifier());
        new ContentEncryptionKeys(managementKey.getEncoded(), ByteUtil.EMPTY_BYTES);
        return contentEncryptionKeys;
    }

    public Key manageForDecrypt(Key key, byte[] bArr, ContentEncryptionKeyDescriptor contentEncryptionKeyDescriptor, Headers headers, ProviderContext providerContext) throws JoseException {
        Throwable th;
        StringBuilder sb;
        Key managementKey = key;
        byte[] encryptedKey = bArr;
        ContentEncryptionKeyDescriptor contentEncryptionKeyDescriptor2 = contentEncryptionKeyDescriptor;
        Headers headers2 = headers;
        ProviderContext providerContext2 = providerContext;
        if (encryptedKey.length == 0) {
            return managementKey;
        }
        Throwable th2 = th;
        new StringBuilder();
        new InvalidKeyException(sb.append("An empty octet sequence is to be used as the JWE Encrypted Key value when utilizing direct encryption but this JWE has ").append(encryptedKey.length).append(" octets in the encrypted key part.").toString());
        throw th2;
    }

    public void validateEncryptionKey(Key managementKey, ContentEncryptionAlgorithm contentEncryptionAlg) throws InvalidKeyException {
        validateKey(managementKey, contentEncryptionAlg);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000e, code lost:
        r3 = r1.getEncoded().length;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void validateKey(java.security.Key r11, org.jose4j.jwe.ContentEncryptionAlgorithm r12) throws org.jose4j.lang.InvalidKeyException {
        /*
            r10 = this;
            r0 = r10
            r1 = r11
            r2 = r12
            r5 = r1
            org.jose4j.jwx.KeyValidationSupport.notNull(r5)
            r5 = r1
            byte[] r5 = r5.getEncoded()
            if (r5 == 0) goto L_0x007f
            r5 = r1
            byte[] r5 = r5.getEncoded()
            int r5 = r5.length
            r3 = r5
            r5 = r2
            org.jose4j.jwe.ContentEncryptionKeyDescriptor r5 = r5.getContentEncryptionKeyDescriptor()
            int r5 = r5.getContentEncryptionKeyByteLength()
            r4 = r5
            r5 = r4
            r6 = r3
            if (r5 == r6) goto L_0x007f
            org.jose4j.lang.InvalidKeyException r5 = new org.jose4j.lang.InvalidKeyException
            r9 = r5
            r5 = r9
            r6 = r9
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r9 = r7
            r7 = r9
            r8 = r9
            r8.<init>()
            java.lang.String r8 = "Invalid key for "
            java.lang.StringBuilder r7 = r7.append(r8)
            r8 = r0
            java.lang.String r8 = r8.getAlgorithmIdentifier()
            java.lang.StringBuilder r7 = r7.append(r8)
            java.lang.String r8 = " with "
            java.lang.StringBuilder r7 = r7.append(r8)
            r8 = r2
            java.lang.String r8 = r8.getAlgorithmIdentifier()
            java.lang.StringBuilder r7 = r7.append(r8)
            java.lang.String r8 = ", expected a "
            java.lang.StringBuilder r7 = r7.append(r8)
            r8 = r4
            int r8 = org.jose4j.lang.ByteUtil.bitLength((int) r8)
            java.lang.StringBuilder r7 = r7.append(r8)
            java.lang.String r8 = " bit key but a "
            java.lang.StringBuilder r7 = r7.append(r8)
            r8 = r3
            int r8 = org.jose4j.lang.ByteUtil.bitLength((int) r8)
            java.lang.StringBuilder r7 = r7.append(r8)
            java.lang.String r8 = " bit key was provided."
            java.lang.StringBuilder r7 = r7.append(r8)
            java.lang.String r7 = r7.toString()
            r6.<init>(r7)
            throw r5
        L_0x007f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jose4j.jwe.DirectKeyManagementAlgorithm.validateKey(java.security.Key, org.jose4j.jwe.ContentEncryptionAlgorithm):void");
    }

    public void validateDecryptionKey(Key managementKey, ContentEncryptionAlgorithm contentEncryptionAlg) throws InvalidKeyException {
        validateKey(managementKey, contentEncryptionAlg);
    }

    public boolean isAvailable() {
        return true;
    }
}
