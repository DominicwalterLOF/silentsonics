package org.jose4j.jwe.kdf;

import java.io.ByteArrayOutputStream;
import java.security.Key;
import javax.crypto.Mac;
import org.jose4j.keys.HmacKey;
import org.jose4j.lang.ByteUtil;
import org.jose4j.lang.JoseException;
import org.jose4j.lang.UncheckedJoseException;
import org.jose4j.mac.MacUtil;

public class PasswordBasedKeyDerivationFunction2 {
    private String hmacAlgorithm;

    public PasswordBasedKeyDerivationFunction2(String hmacAlgorithm2) {
        this.hmacAlgorithm = hmacAlgorithm2;
    }

    public byte[] derive(byte[] password, byte[] salt, int iterationCount, int dkLen) throws JoseException {
        return derive(password, salt, iterationCount, dkLen, (String) null);
    }

    public byte[] derive(byte[] password, byte[] bArr, int i, int i2, String provider) throws JoseException {
        Key key;
        ByteArrayOutputStream byteArrayOutputStream;
        Throwable th;
        StringBuilder sb;
        byte[] salt = bArr;
        int iterationCount = i;
        int dkLen = i2;
        new HmacKey(password);
        Mac prf = MacUtil.getInitializedMac(this.hmacAlgorithm, key, provider);
        int hLen = prf.getMacLength();
        if (((long) dkLen) > 4294967295L) {
            Throwable th2 = th;
            new StringBuilder();
            new UncheckedJoseException(sb.append("derived key too long ").append(dkLen).toString());
            throw th2;
        }
        int l = (int) Math.ceil(((double) dkLen) / ((double) hLen));
        int r = dkLen - ((l - 1) * hLen);
        new ByteArrayOutputStream();
        ByteArrayOutputStream byteArrayOutputStream2 = byteArrayOutputStream;
        for (int i3 = 0; i3 < l; i3++) {
            byte[] block = f(salt, iterationCount, i3 + 1, prf);
            if (i3 == l - 1) {
                block = ByteUtil.subArray(block, 0, r);
            }
            byteArrayOutputStream2.write(block, 0, block.length);
        }
        return byteArrayOutputStream2.toByteArray();
    }

    /* access modifiers changed from: package-private */
    public byte[] f(byte[] bArr, int i, int i2, Mac mac) {
        byte[] currentU;
        byte[] salt = bArr;
        int iterationCount = i;
        int blockIndex = i2;
        Mac prf = mac;
        byte[] lastU = null;
        byte[] xorU = null;
        for (int i3 = 1; i3 <= iterationCount; i3++) {
            if (i3 == 1) {
                byte[][] bArr2 = new byte[2][];
                bArr2[0] = salt;
                byte[][] bArr3 = bArr2;
                bArr3[1] = ByteUtil.getBytes(blockIndex);
                currentU = prf.doFinal(ByteUtil.concat(bArr3));
                xorU = currentU;
            } else {
                currentU = prf.doFinal(lastU);
                for (int j = 0; j < currentU.length; j++) {
                    xorU[j] = (byte) (currentU[j] ^ xorU[j]);
                }
            }
            lastU = currentU;
        }
        return xorU;
    }
}
