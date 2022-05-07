package org.jose4j.jws;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.Key;
import org.jose4j.jwa.AlgorithmConstraints;
import org.jose4j.jwa.AlgorithmFactoryFactory;
import org.jose4j.jwx.CompactSerializer;
import org.jose4j.jwx.HeaderParameterNames;
import org.jose4j.jwx.JsonWebStructure;
import org.jose4j.keys.KeyPersuasion;
import org.jose4j.lang.IntegrityException;
import org.jose4j.lang.InvalidAlgorithmException;
import org.jose4j.lang.JoseException;
import org.jose4j.lang.StringUtil;

public class JsonWebSignature extends JsonWebStructure {
    public static final short COMPACT_SERIALIZATION_PARTS = 3;
    private String encodedPayload;
    private byte[] payloadBytes;
    private String payloadCharEncoding = "UTF-8";
    private Boolean validSignature;

    public JsonWebSignature() {
        if (!Boolean.getBoolean("org.jose4j.jws.default-allow-none")) {
            setAlgorithmConstraints(AlgorithmConstraints.DISALLOW_NONE);
        }
    }

    public void setPayload(String payload) {
        this.payloadBytes = StringUtil.getBytesUnchecked(payload, this.payloadCharEncoding);
    }

    public byte[] getPayloadBytes() throws JoseException {
        Throwable th;
        if (verifySignature()) {
            return this.payloadBytes;
        }
        Throwable th2 = th;
        new IntegrityException("JWS signature is invalid.");
        throw th2;
    }

    public byte[] getUnverifiedPayloadBytes() {
        return this.payloadBytes;
    }

    public void setPayloadBytes(byte[] payloadBytes2) {
        byte[] bArr = payloadBytes2;
        this.payloadBytes = bArr;
    }

    /* access modifiers changed from: protected */
    public void setCompactSerializationParts(String[] strArr) throws JoseException {
        Throwable th;
        String[] parts = strArr;
        if (parts.length != 3) {
            Throwable th2 = th;
            new JoseException("A JWS Compact Serialization must have exactly 3 parts separated by period ('.') characters");
            throw th2;
        }
        setEncodedHeader(parts[0]);
        if (isRfc7797UnencodedPayload()) {
            setPayload(parts[1]);
        } else {
            setEncodedPayload(parts[1]);
        }
        setSignature(this.base64url.base64UrlDecode(parts[2]));
    }

    public String getCompactSerialization() throws JoseException {
        String payload;
        Throwable th;
        sign();
        if (isRfc7797UnencodedPayload()) {
            payload = getStringPayload();
            if (payload.contains(".")) {
                Throwable th2 = th;
                new JoseException("per https://tools.ietf.org/html/rfc7797#section-5.2 when using the JWS Compact Serialization, unencoded non-detached payloads using period ('.') characters would cause parsing errors; such payloads MUST NOT be used with the JWS Compact Serialization.");
                throw th2;
            }
        } else {
            payload = getEncodedPayload();
        }
        String[] strArr = new String[3];
        strArr[0] = getEncodedHeader();
        String[] strArr2 = strArr;
        strArr2[1] = payload;
        String[] strArr3 = strArr2;
        strArr3[2] = getEncodedSignature();
        return CompactSerializer.serialize(strArr3);
    }

    public String getDetachedContentCompactSerialization() throws JoseException {
        sign();
        String[] strArr = new String[3];
        strArr[0] = getEncodedHeader();
        String[] strArr2 = strArr;
        strArr2[1] = "";
        String[] strArr3 = strArr2;
        strArr3[2] = getEncodedSignature();
        return CompactSerializer.serialize(strArr3);
    }

    public void sign() throws JoseException {
        JsonWebSignatureAlgorithm algorithm = getAlgorithm();
        Key signingKey = getKey();
        if (isDoKeyValidation()) {
            algorithm.validateSigningKey(signingKey);
        }
        setSignature(algorithm.sign(signingKey, getSigningInputBytes(), getProviderCtx()));
    }

    /* access modifiers changed from: protected */
    public void onNewKey() {
        this.validSignature = null;
    }

    public boolean verifySignature() throws JoseException {
        JsonWebSignatureAlgorithm algorithm = getAlgorithm();
        Key verificationKey = getKey();
        if (isDoKeyValidation()) {
            algorithm.validateVerificationKey(verificationKey);
        }
        if (this.validSignature == null) {
            checkCrit();
            this.validSignature = Boolean.valueOf(algorithm.verifySignature(getSignature(), verificationKey, getSigningInputBytes(), getProviderCtx()));
        }
        return this.validSignature.booleanValue();
    }

    /* access modifiers changed from: protected */
    public boolean isSupportedCriticalHeader(String headerName) {
        return HeaderParameterNames.BASE64URL_ENCODE_PAYLOAD.equals(headerName);
    }

    public JsonWebSignatureAlgorithm getAlgorithm() throws InvalidAlgorithmException {
        return getAlgorithm(true);
    }

    public JsonWebSignatureAlgorithm getAlgorithmNoConstraintCheck() throws InvalidAlgorithmException {
        return getAlgorithm(false);
    }

    private JsonWebSignatureAlgorithm getAlgorithm(boolean z) throws InvalidAlgorithmException {
        Throwable th;
        boolean checkConstraints = z;
        String algo = getAlgorithmHeaderValue();
        if (algo == null) {
            Throwable th2 = th;
            new InvalidAlgorithmException("Signature algorithm header (alg) not set.");
            throw th2;
        }
        if (checkConstraints) {
            getAlgorithmConstraints().checkConstraint(algo);
        }
        return AlgorithmFactoryFactory.getInstance().getJwsAlgorithmFactory().getAlgorithm(algo);
    }

    private byte[] getSigningInputBytes() throws JoseException {
        Throwable th;
        ByteArrayOutputStream byteArrayOutputStream;
        if (!isRfc7797UnencodedPayload()) {
            String[] strArr = new String[2];
            strArr[0] = getEncodedHeader();
            String[] strArr2 = strArr;
            strArr2[1] = getEncodedPayload();
            return StringUtil.getBytesAscii(CompactSerializer.serialize(strArr2));
        }
        try {
            new ByteArrayOutputStream();
            ByteArrayOutputStream os = byteArrayOutputStream;
            os.write(StringUtil.getBytesAscii(getEncodedHeader()));
            os.write(46);
            os.write(this.payloadBytes);
            return os.toByteArray();
        } catch (IOException e) {
            IOException e2 = e;
            Throwable th2 = th;
            new JoseException("This should never happen from a ByteArrayOutputStream", e2);
            throw th2;
        }
    }

    /* access modifiers changed from: protected */
    public boolean isRfc7797UnencodedPayload() {
        Object b64 = this.headers.getObjectHeaderValue(HeaderParameterNames.BASE64URL_ENCODE_PAYLOAD);
        return b64 != null && (b64 instanceof Boolean) && !((Boolean) b64).booleanValue();
    }

    public String getPayload() throws JoseException {
        Throwable th;
        if (Boolean.getBoolean("org.jose4j.jws.getPayload-skip-verify") || verifySignature()) {
            return getStringPayload();
        }
        Throwable th2 = th;
        new IntegrityException("JWS signature is invalid.");
        throw th2;
    }

    public String getUnverifiedPayload() {
        return getStringPayload();
    }

    private String getStringPayload() {
        return StringUtil.newString(this.payloadBytes, this.payloadCharEncoding);
    }

    public String getPayloadCharEncoding() {
        return this.payloadCharEncoding;
    }

    public void setPayloadCharEncoding(String payloadCharEncoding2) {
        String str = payloadCharEncoding2;
        this.payloadCharEncoding = str;
    }

    public String getKeyType() throws InvalidAlgorithmException {
        return getAlgorithmNoConstraintCheck().getKeyType();
    }

    public KeyPersuasion getKeyPersuasion() throws InvalidAlgorithmException {
        return getAlgorithmNoConstraintCheck().getKeyPersuasion();
    }

    public void setEncodedPayload(String str) {
        String encodedPayload2 = str;
        this.encodedPayload = encodedPayload2;
        this.payloadBytes = this.base64url.base64UrlDecode(encodedPayload2);
    }

    public String getEncodedPayload() {
        return this.encodedPayload != null ? this.encodedPayload : this.base64url.base64UrlEncode(this.payloadBytes);
    }

    public String getEncodedSignature() {
        return this.base64url.base64UrlEncode(getSignature());
    }

    /* access modifiers changed from: protected */
    public byte[] getSignature() {
        return getIntegrity();
    }

    /* access modifiers changed from: protected */
    public void setSignature(byte[] signature) {
        setIntegrity(signature);
    }
}
