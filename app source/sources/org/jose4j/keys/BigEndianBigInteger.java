package org.jose4j.keys;

import java.math.BigInteger;
import org.jose4j.base64url.Base64Url;
import org.jose4j.lang.ByteUtil;

public class BigEndianBigInteger {
    public BigEndianBigInteger() {
    }

    public static BigInteger fromBytes(byte[] magnitude) {
        BigInteger bigInteger;
        new BigInteger(1, magnitude);
        return bigInteger;
    }

    public static BigInteger fromBase64Url(String base64urlEncodedBytes) {
        Base64Url base64Url;
        new Base64Url();
        return fromBytes(base64Url.base64UrlDecode(base64urlEncodedBytes));
    }

    public static byte[] toByteArray(BigInteger bigInteger, int i) {
        int minArrayLength = i;
        byte[] bytes = toByteArray(bigInteger);
        if (minArrayLength > bytes.length) {
            byte[][] bArr = new byte[2][];
            bArr[0] = new byte[(minArrayLength - bytes.length)];
            byte[][] bArr2 = bArr;
            bArr2[1] = bytes;
            bytes = ByteUtil.concat(bArr2);
        }
        return bytes;
    }

    public static byte[] toByteArray(BigInteger bigInteger) {
        byte[] magnitude;
        StringBuilder sb;
        Throwable th;
        BigInteger bigInteger2 = bigInteger;
        if (bigInteger2.signum() < 0) {
            new StringBuilder();
            Throwable th2 = th;
            new IllegalArgumentException(sb.append("Cannot convert negative values to an unsigned magnitude byte array: ").append(bigInteger2).toString());
            throw th2;
        }
        byte[] twosComplementBytes = bigInteger2.toByteArray();
        if (bigInteger2.bitLength() % 8 == 0 && twosComplementBytes[0] == 0 && twosComplementBytes.length > 1) {
            magnitude = ByteUtil.subArray(twosComplementBytes, 1, twosComplementBytes.length - 1);
        } else {
            magnitude = twosComplementBytes;
        }
        return magnitude;
    }

    public static String toBase64Url(BigInteger bigInteger) {
        Base64Url base64Url;
        new Base64Url();
        return base64Url.base64UrlEncode(toByteArray(bigInteger));
    }

    public static String toBase64Url(BigInteger bigInteger, int minByteArrayLength) {
        Base64Url base64Url;
        new Base64Url();
        return base64Url.base64UrlEncode(toByteArray(bigInteger, minByteArrayLength));
    }
}
