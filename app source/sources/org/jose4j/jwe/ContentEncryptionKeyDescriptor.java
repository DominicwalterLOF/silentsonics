package org.jose4j.jwe;

public class ContentEncryptionKeyDescriptor {
    private final String contentEncryptionKeyAlgorithm;
    private final int contentEncryptionKeyByteLength;

    public ContentEncryptionKeyDescriptor(int contentEncryptionKeyByteLength2, String contentEncryptionKeyAlgorithm2) {
        this.contentEncryptionKeyByteLength = contentEncryptionKeyByteLength2;
        this.contentEncryptionKeyAlgorithm = contentEncryptionKeyAlgorithm2;
    }

    public int getContentEncryptionKeyByteLength() {
        return this.contentEncryptionKeyByteLength;
    }

    public String getContentEncryptionKeyAlgorithm() {
        return this.contentEncryptionKeyAlgorithm;
    }
}
