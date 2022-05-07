package org.jose4j.jws;

import com.google.appinventor.components.runtime.util.Ev3Constants;
import java.io.IOException;
import java.security.Key;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.interfaces.ECKey;
import org.jose4j.jca.ProviderContext;
import org.jose4j.keys.EllipticCurves;
import org.jose4j.lang.InvalidKeyException;
import org.jose4j.lang.JoseException;

public class EcdsaUsingShaAlgorithm extends BaseSignatureAlgorithm implements JsonWebSignatureAlgorithm {
    private String curveName;
    private int signatureByteLength;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public EcdsaUsingShaAlgorithm(String id, String javaAlgo, String curveName2, int signatureByteLength2) {
        super(id, javaAlgo, "EC");
        this.curveName = curveName2;
        this.signatureByteLength = signatureByteLength2;
    }

    public boolean verifySignature(byte[] signatureBytes, Key key, byte[] bArr, ProviderContext providerContext) throws JoseException {
        Throwable th;
        Key key2 = key;
        byte[] securedInputBytes = bArr;
        ProviderContext providerContext2 = providerContext;
        try {
            return super.verifySignature(convertConcatenatedToDer(signatureBytes), key2, securedInputBytes, providerContext2);
        } catch (IOException e) {
            IOException e2 = e;
            Throwable th2 = th;
            new JoseException("Unable to convert R and S as a concatenated byte array to DER encoding.", e2);
            throw th2;
        }
    }

    public byte[] sign(Key key, byte[] securedInputBytes, ProviderContext providerContext) throws JoseException {
        Throwable th;
        try {
            return convertDerToConcatenated(super.sign(key, securedInputBytes, providerContext), this.signatureByteLength);
        } catch (IOException e) {
            IOException e2 = e;
            Throwable th2 = th;
            new JoseException("Unable to convert DER encoding to R and S as a concatenated byte array.", e2);
            throw th2;
        }
    }

    public static byte[] convertConcatenatedToDer(byte[] bArr) throws IOException {
        byte[] derEncodedSignatureBytes;
        int offset;
        Throwable th;
        byte[] concatenatedSignatureBytes = bArr;
        int rawLen = concatenatedSignatureBytes.length / 2;
        int i = rawLen;
        while (i > 0 && concatenatedSignatureBytes[rawLen - i] == 0) {
            i--;
        }
        int j = i;
        if (concatenatedSignatureBytes[rawLen - i] < 0) {
            j++;
        }
        int k = rawLen;
        while (k > 0 && concatenatedSignatureBytes[(2 * rawLen) - k] == 0) {
            k--;
        }
        int l = k;
        if (concatenatedSignatureBytes[(2 * rawLen) - k] < 0) {
            l++;
        }
        int len = 2 + j + 2 + l;
        if (len > 255) {
            Throwable th2 = th;
            new IOException("Invalid format of ECDSA signature");
            throw th2;
        }
        if (len < 128) {
            derEncodedSignatureBytes = new byte[(4 + j + 2 + l)];
            offset = 1;
        } else {
            derEncodedSignatureBytes = new byte[(5 + j + 2 + l)];
            derEncodedSignatureBytes[1] = -127;
            offset = 2;
        }
        derEncodedSignatureBytes[0] = Ev3Constants.Opcode.MOVE8_8;
        int i2 = offset;
        int offset2 = offset + 1;
        derEncodedSignatureBytes[i2] = (byte) len;
        int i3 = offset2;
        int offset3 = offset2 + 1;
        derEncodedSignatureBytes[i3] = 2;
        int i4 = offset3;
        int offset4 = offset3 + 1;
        derEncodedSignatureBytes[i4] = (byte) j;
        System.arraycopy(concatenatedSignatureBytes, rawLen - i, derEncodedSignatureBytes, (offset4 + j) - i, i);
        int offset5 = offset4 + j;
        int i5 = offset5;
        int offset6 = offset5 + 1;
        derEncodedSignatureBytes[i5] = 2;
        derEncodedSignatureBytes[offset6] = (byte) l;
        System.arraycopy(concatenatedSignatureBytes, (2 * rawLen) - k, derEncodedSignatureBytes, ((offset6 + 1) + l) - k, k);
        return derEncodedSignatureBytes;
    }

    public static byte[] convertDerToConcatenated(byte[] bArr, int i) throws IOException {
        Throwable th;
        Throwable th2;
        int offset;
        Throwable th3;
        byte[] derEncodedBytes = bArr;
        int outputLength = i;
        if (derEncodedBytes.length < 8 || derEncodedBytes[0] != 48) {
            Throwable th4 = th;
            new IOException("Invalid format of ECDSA signature");
            throw th4;
        }
        if (derEncodedBytes[1] > 0) {
            offset = 2;
        } else if (derEncodedBytes[1] == -127) {
            offset = 3;
        } else {
            Throwable th5 = th2;
            new IOException("Invalid format of ECDSA signature");
            throw th5;
        }
        byte rLength = derEncodedBytes[offset + 1];
        int i2 = rLength;
        while (i2 > 0 && derEncodedBytes[((offset + 2) + rLength) - i2] == 0) {
            i2--;
        }
        byte sLength = derEncodedBytes[offset + 2 + rLength + 1];
        int j = sLength;
        while (j > 0 && derEncodedBytes[((((offset + 2) + rLength) + 2) + sLength) - j] == 0) {
            j--;
        }
        int rawLen = Math.max(Math.max(i2, j), outputLength / 2);
        if ((derEncodedBytes[offset - 1] & Ev3Constants.Opcode.TST) == derEncodedBytes.length - offset && (derEncodedBytes[offset - 1] & Ev3Constants.Opcode.TST) == 2 + rLength + 2 + sLength && derEncodedBytes[offset] == 2 && derEncodedBytes[offset + 2 + rLength] == 2) {
            byte[] concatenatedSignatureBytes = new byte[(2 * rawLen)];
            System.arraycopy(derEncodedBytes, ((offset + 2) + rLength) - i2, concatenatedSignatureBytes, rawLen - i2, i2);
            System.arraycopy(derEncodedBytes, ((((offset + 2) + rLength) + 2) + sLength) - j, concatenatedSignatureBytes, (2 * rawLen) - j, j);
            return concatenatedSignatureBytes;
        }
        Throwable th6 = th3;
        new IOException("Invalid format of ECDSA signature");
        throw th6;
    }

    public void validatePrivateKey(PrivateKey privateKey) throws InvalidKeyException {
        validateKeySpec(privateKey);
    }

    public void validatePublicKey(PublicKey publicKey) throws InvalidKeyException {
        validateKeySpec(publicKey);
    }

    private void validateKeySpec(Key key) throws InvalidKeyException {
        Throwable th;
        StringBuilder sb;
        Key key2 = key;
        if (key2 instanceof ECKey) {
            String name = EllipticCurves.getName(((ECKey) key2).getParams().getCurve());
            if (!getCurveName().equals(name)) {
                Throwable th2 = th;
                new StringBuilder();
                new InvalidKeyException(sb.append(getAlgorithmIdentifier()).append("/").append(getJavaAlgorithm()).append(" expects a key using ").append(getCurveName()).append(" but was ").append(name).toString());
                throw th2;
            }
        }
    }

    public String getCurveName() {
        return this.curveName;
    }

    public static class EcdsaP256UsingSha256 extends EcdsaUsingShaAlgorithm {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public EcdsaP256UsingSha256() {
            super(AlgorithmIdentifiers.ECDSA_USING_P256_CURVE_AND_SHA256, "SHA256withECDSA", EllipticCurves.P_256, 64);
        }
    }

    public static class EcdsaP384UsingSha384 extends EcdsaUsingShaAlgorithm {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public EcdsaP384UsingSha384() {
            super(AlgorithmIdentifiers.ECDSA_USING_P384_CURVE_AND_SHA384, "SHA384withECDSA", EllipticCurves.P_384, 96);
        }
    }

    public static class EcdsaP521UsingSha512 extends EcdsaUsingShaAlgorithm {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public EcdsaP521UsingSha512() {
            super(AlgorithmIdentifiers.ECDSA_USING_P521_CURVE_AND_SHA512, "SHA512withECDSA", EllipticCurves.P_521, 132);
        }
    }
}
