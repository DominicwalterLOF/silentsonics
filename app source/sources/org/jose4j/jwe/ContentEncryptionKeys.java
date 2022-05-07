package org.jose4j.jwe;

import org.jose4j.lang.ByteUtil;

public class ContentEncryptionKeys {
    private final byte[] contentEncryptionKey;
    private final byte[] encryptedKey;

    public ContentEncryptionKeys(byte[] contentEncryptionKey2, byte[] bArr) {
        byte[] encryptedKey2 = bArr;
        this.contentEncryptionKey = contentEncryptionKey2;
        this.encryptedKey = encryptedKey2 == null ? ByteUtil.EMPTY_BYTES : encryptedKey2;
    }

    public byte[] getContentEncryptionKey() {
        return this.contentEncryptionKey;
    }

    public byte[] getEncryptedKey() {
        return this.encryptedKey;
    }
}
