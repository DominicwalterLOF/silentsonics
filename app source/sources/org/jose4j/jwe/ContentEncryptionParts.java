package org.jose4j.jwe;

public class ContentEncryptionParts {
    private byte[] authenticationTag;
    private byte[] ciphertext;
    private byte[] iv;

    public ContentEncryptionParts(byte[] iv2, byte[] ciphertext2, byte[] authenticationTag2) {
        this.iv = iv2;
        this.ciphertext = ciphertext2;
        this.authenticationTag = authenticationTag2;
    }

    public byte[] getIv() {
        return this.iv;
    }

    public byte[] getCiphertext() {
        return this.ciphertext;
    }

    public byte[] getAuthenticationTag() {
        return this.authenticationTag;
    }
}
