package org.jose4j.jwe;

import java.security.Key;
import org.jose4j.base64url.Base64Url;
import org.jose4j.jwa.AlgorithmConstraints;
import org.jose4j.jwa.AlgorithmFactoryFactory;
import org.jose4j.jwx.CompactSerializer;
import org.jose4j.jwx.HeaderParameterNames;
import org.jose4j.jwx.Headers;
import org.jose4j.jwx.JsonWebStructure;
import org.jose4j.lang.InvalidAlgorithmException;
import org.jose4j.lang.JoseException;
import org.jose4j.lang.StringUtil;
import org.jose4j.zip.CompressionAlgorithmIdentifiers;

public class JsonWebEncryption extends JsonWebStructure {
    public static final short COMPACT_SERIALIZATION_PARTS = 5;
    private Base64Url base64url;
    byte[] ciphertext;
    private AlgorithmConstraints contentEncryptionAlgorithmConstraints = AlgorithmConstraints.NO_CONSTRAINTS;
    byte[] contentEncryptionKey;
    byte[] encryptedKey;
    byte[] iv;
    private byte[] plaintext;
    private String plaintextCharEncoding = "UTF-8";

    public JsonWebEncryption() {
        Base64Url base64Url;
        new Base64Url();
        this.base64url = base64Url;
    }

    public void setPlainTextCharEncoding(String plaintextCharEncoding2) {
        String str = plaintextCharEncoding2;
        this.plaintextCharEncoding = str;
    }

    public void setPlaintext(byte[] plaintext2) {
        byte[] bArr = plaintext2;
        this.plaintext = bArr;
    }

    public void setPlaintext(String plaintext2) {
        this.plaintext = StringUtil.getBytesUnchecked(plaintext2, this.plaintextCharEncoding);
    }

    public String getPlaintextString() throws JoseException {
        return StringUtil.newString(getPlaintextBytes(), this.plaintextCharEncoding);
    }

    public byte[] getPlaintextBytes() throws JoseException {
        if (this.plaintext == null) {
            decrypt();
        }
        return this.plaintext;
    }

    public String getPayload() throws JoseException {
        return getPlaintextString();
    }

    public void setPayload(String payload) {
        setPlaintext(payload);
    }

    public void setEncryptionMethodHeaderParameter(String enc) {
        setHeader("enc", enc);
    }

    public String getEncryptionMethodHeaderParameter() {
        return getHeader("enc");
    }

    public void setCompressionAlgorithmHeaderParameter(String zip) {
        setHeader(HeaderParameterNames.ZIP, zip);
    }

    public String getCompressionAlgorithmHeaderParameter() {
        return getHeader(HeaderParameterNames.ZIP);
    }

    public void enableDefaultCompression() {
        setCompressionAlgorithmHeaderParameter(CompressionAlgorithmIdentifiers.DEFLATE);
    }

    public void setContentEncryptionAlgorithmConstraints(AlgorithmConstraints contentEncryptionAlgorithmConstraints2) {
        AlgorithmConstraints algorithmConstraints = contentEncryptionAlgorithmConstraints2;
        this.contentEncryptionAlgorithmConstraints = algorithmConstraints;
    }

    public ContentEncryptionAlgorithm getContentEncryptionAlgorithm() throws InvalidAlgorithmException {
        Throwable th;
        String encValue = getEncryptionMethodHeaderParameter();
        if (encValue == null) {
            Throwable th2 = th;
            new InvalidAlgorithmException("Content encryption header (enc) not set.");
            throw th2;
        }
        this.contentEncryptionAlgorithmConstraints.checkConstraint(encValue);
        return AlgorithmFactoryFactory.getInstance().getJweContentEncryptionAlgorithmFactory().getAlgorithm(encValue);
    }

    public KeyManagementAlgorithm getKeyManagementModeAlgorithm() throws InvalidAlgorithmException {
        return getKeyManagementModeAlgorithm(true);
    }

    /* access modifiers changed from: package-private */
    public KeyManagementAlgorithm getKeyManagementModeAlgorithm(boolean z) throws InvalidAlgorithmException {
        Throwable th;
        boolean checkConstraints = z;
        String algo = getAlgorithmHeaderValue();
        if (algo == null) {
            Throwable th2 = th;
            new InvalidAlgorithmException("Encryption key management algorithm header (alg) not set.");
            throw th2;
        }
        if (checkConstraints) {
            getAlgorithmConstraints().checkConstraint(algo);
        }
        return AlgorithmFactoryFactory.getInstance().getJweKeyManagementAlgorithmFactory().getAlgorithm(algo);
    }

    public KeyManagementAlgorithm getAlgorithmNoConstraintCheck() throws InvalidAlgorithmException {
        return getKeyManagementModeAlgorithm(false);
    }

    public KeyManagementAlgorithm getAlgorithm() throws InvalidAlgorithmException {
        return getKeyManagementModeAlgorithm();
    }

    /* access modifiers changed from: protected */
    public void setCompactSerializationParts(String[] strArr) throws JoseException {
        Throwable th;
        String[] parts = strArr;
        if (parts.length != 5) {
            Throwable th2 = th;
            new JoseException("A JWE Compact Serialization must have exactly 5 parts separated by period ('.') characters");
            throw th2;
        }
        setEncodedHeader(parts[0]);
        this.encryptedKey = this.base64url.base64UrlDecode(parts[1]);
        setEncodedIv(parts[2]);
        String encodedCiphertext = parts[3];
        checkNotEmptyPart(encodedCiphertext, "Encoded JWE Ciphertext");
        this.ciphertext = this.base64url.base64UrlDecode(encodedCiphertext);
        String encodedAuthenticationTag = parts[4];
        checkNotEmptyPart(encodedAuthenticationTag, "Encoded JWE Authentication Tag");
        setIntegrity(this.base64url.base64UrlDecode(encodedAuthenticationTag));
    }

    private void decrypt() throws JoseException {
        ContentEncryptionParts contentEncryptionParts;
        KeyManagementAlgorithm keyManagementModeAlg = getKeyManagementModeAlgorithm();
        ContentEncryptionAlgorithm contentEncryptionAlg = getContentEncryptionAlgorithm();
        ContentEncryptionKeyDescriptor contentEncryptionKeyDesc = contentEncryptionAlg.getContentEncryptionKeyDescriptor();
        if (isDoKeyValidation()) {
            keyManagementModeAlg.validateDecryptionKey(getKey(), contentEncryptionAlg);
        }
        checkCrit();
        Key cek = keyManagementModeAlg.manageForDecrypt(getKey(), getEncryptedKey(), contentEncryptionKeyDesc, getHeaders(), getProviderCtx());
        new ContentEncryptionParts(this.iv, this.ciphertext, getIntegrity());
        setPlaintext(decompress(getHeaders(), contentEncryptionAlg.decrypt(contentEncryptionParts, getEncodedHeaderAsciiBytesForAdditionalAuthenticatedData(), cek.getEncoded(), getHeaders(), getProviderCtx())));
    }

    public byte[] getEncryptedKey() {
        return this.encryptedKey;
    }

    /* access modifiers changed from: package-private */
    public byte[] getEncodedHeaderAsciiBytesForAdditionalAuthenticatedData() {
        return StringUtil.getBytesAscii(getEncodedHeader());
    }

    /* access modifiers changed from: package-private */
    public byte[] decompress(Headers headers, byte[] bArr) throws JoseException {
        byte[] data = bArr;
        String zipHeaderValue = headers.getStringHeaderValue(HeaderParameterNames.ZIP);
        if (zipHeaderValue != null) {
            data = AlgorithmFactoryFactory.getInstance().getCompressionAlgorithmFactory().getAlgorithm(zipHeaderValue).decompress(data);
        }
        return data;
    }

    /* access modifiers changed from: package-private */
    public byte[] compress(Headers headers, byte[] bArr) throws InvalidAlgorithmException {
        byte[] data = bArr;
        String zipHeaderValue = headers.getStringHeaderValue(HeaderParameterNames.ZIP);
        if (zipHeaderValue != null) {
            data = AlgorithmFactoryFactory.getInstance().getCompressionAlgorithmFactory().getAlgorithm(zipHeaderValue).compress(data);
        }
        return data;
    }

    public String getCompactSerialization() throws JoseException {
        Throwable th;
        KeyManagementAlgorithm keyManagementModeAlg = getKeyManagementModeAlgorithm();
        ContentEncryptionAlgorithm contentEncryptionAlg = getContentEncryptionAlgorithm();
        ContentEncryptionKeyDescriptor contentEncryptionKeyDesc = contentEncryptionAlg.getContentEncryptionKeyDescriptor();
        Key managementKey = getKey();
        if (isDoKeyValidation()) {
            keyManagementModeAlg.validateEncryptionKey(getKey(), contentEncryptionAlg);
        }
        ContentEncryptionKeys contentEncryptionKeys = keyManagementModeAlg.manageForEncrypt(managementKey, contentEncryptionKeyDesc, getHeaders(), this.contentEncryptionKey, getProviderCtx());
        setContentEncryptionKey(contentEncryptionKeys.getContentEncryptionKey());
        this.encryptedKey = contentEncryptionKeys.getEncryptedKey();
        byte[] aad = getEncodedHeaderAsciiBytesForAdditionalAuthenticatedData();
        byte[] contentEncryptionKey2 = contentEncryptionKeys.getContentEncryptionKey();
        byte[] plaintextBytes = this.plaintext;
        if (plaintextBytes == null) {
            Throwable th2 = th;
            new NullPointerException("The plaintext payload for the JWE has not been set.");
            throw th2;
        }
        ContentEncryptionParts contentEncryptionParts = contentEncryptionAlg.encrypt(compress(getHeaders(), plaintextBytes), aad, contentEncryptionKey2, getHeaders(), getIv(), getProviderCtx());
        setIv(contentEncryptionParts.getIv());
        this.ciphertext = contentEncryptionParts.getCiphertext();
        String encodedIv = this.base64url.base64UrlEncode(contentEncryptionParts.getIv());
        String encodedCiphertext = this.base64url.base64UrlEncode(contentEncryptionParts.getCiphertext());
        String encodedTag = this.base64url.base64UrlEncode(contentEncryptionParts.getAuthenticationTag());
        String encodedEncryptedKey = this.base64url.base64UrlEncode(contentEncryptionKeys.getEncryptedKey());
        String[] strArr = new String[5];
        strArr[0] = getEncodedHeader();
        String[] strArr2 = strArr;
        strArr2[1] = encodedEncryptedKey;
        String[] strArr3 = strArr2;
        strArr3[2] = encodedIv;
        String[] strArr4 = strArr3;
        strArr4[3] = encodedCiphertext;
        String[] strArr5 = strArr4;
        strArr5[4] = encodedTag;
        return CompactSerializer.serialize(strArr5);
    }

    public byte[] getContentEncryptionKey() {
        return this.contentEncryptionKey;
    }

    public void setContentEncryptionKey(byte[] contentEncryptionKey2) {
        byte[] bArr = contentEncryptionKey2;
        this.contentEncryptionKey = bArr;
    }

    public void setEncodedContentEncryptionKey(String encodedContentEncryptionKey) {
        Base64Url base64Url = this.base64url;
        setContentEncryptionKey(Base64Url.decode(encodedContentEncryptionKey));
    }

    public byte[] getIv() {
        return this.iv;
    }

    public void setIv(byte[] iv2) {
        byte[] bArr = iv2;
        this.iv = bArr;
    }

    public void setEncodedIv(String encodedIv) {
        setIv(this.base64url.base64UrlDecode(encodedIv));
    }
}
