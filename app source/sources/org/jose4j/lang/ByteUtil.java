package org.jose4j.lang;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.security.SecureRandom;
import java.util.Arrays;
import org.jose4j.base64url.Base64Url;

public class ByteUtil {
    public static final byte[] EMPTY_BYTES = new byte[0];
    private static final int MAX_BYTE_LENGTH = 268435455;

    public ByteUtil() {
    }

    public static byte[] convertUnsignedToSignedTwosComp(int[] iArr) {
        int[] ints = iArr;
        byte[] bytes = new byte[ints.length];
        for (int idx = 0; idx < ints.length; idx++) {
            bytes[idx] = getByte(ints[idx]);
        }
        return bytes;
    }

    public static int[] convertSignedTwosCompToUnsigned(byte[] bArr) {
        byte[] bytes = bArr;
        int[] ints = new int[bytes.length];
        for (int idx = 0; idx < bytes.length; idx++) {
            ints[idx] = getInt(bytes[idx]);
        }
        return ints;
    }

    public static byte getByte(int i) {
        Throwable th;
        StringBuilder sb;
        int intValue = i;
        byte[] bytes = getBytes(intValue);
        if (bytes[0] == 0 && bytes[1] == 0 && bytes[2] == 0) {
            return bytes[3];
        }
        Throwable th2 = th;
        new StringBuilder();
        new IllegalArgumentException(sb.append("Integer value (").append(intValue).append(") too large to stuff into one byte.").toString());
        throw th2;
    }

    public static byte[] getBytes(int intValue) {
        ByteBuffer byteBuffer = ByteBuffer.allocate(4);
        ByteBuffer putInt = byteBuffer.putInt(intValue);
        return byteBuffer.array();
    }

    public static byte[] getBytes(long longValue) {
        ByteBuffer byteBuffer = ByteBuffer.allocate(8);
        ByteBuffer putLong = byteBuffer.putLong(longValue);
        return byteBuffer.array();
    }

    public static int getInt(byte b) {
        byte b2 = b;
        return b2 >= 0 ? b2 : 256 - ((b2 - 1) ^ -1);
    }

    public static boolean secureEquals(byte[] bArr, byte[] bArr2) {
        byte[] bytes1 = bArr;
        byte[] bytes2 = bArr2;
        byte[] bytes12 = bytes1 == null ? EMPTY_BYTES : bytes1;
        byte[] bytes22 = bytes2 == null ? EMPTY_BYTES : bytes2;
        int shortest = Math.min(bytes12.length, bytes22.length);
        int longest = Math.max(bytes12.length, bytes22.length);
        int result = 0;
        for (int i = 0; i < shortest; i++) {
            result |= bytes12[i] ^ bytes22[i];
        }
        return result == 0 && shortest == longest;
    }

    public static byte[] concat(byte[]... bArr) {
        Throwable th;
        ByteArrayOutputStream byteArrayOutputStream;
        byte[][] byteArrays = bArr;
        try {
            new ByteArrayOutputStream();
            ByteArrayOutputStream byteArrayOutputStream2 = byteArrayOutputStream;
            byte[][] arr$ = byteArrays;
            int len$ = arr$.length;
            for (int i$ = 0; i$ < len$; i$++) {
                byteArrayOutputStream2.write(arr$[i$]);
            }
            return byteArrayOutputStream2.toByteArray();
        } catch (IOException e) {
            IOException e2 = e;
            Throwable th2 = th;
            new IllegalStateException("IOEx from ByteArrayOutputStream?!", e2);
            throw th2;
        }
    }

    public static byte[] subArray(byte[] inputBytes, int startPos, int length) {
        byte[] subArray = new byte[length];
        System.arraycopy(inputBytes, startPos, subArray, 0, subArray.length);
        return subArray;
    }

    public static byte[] leftHalf(byte[] bArr) {
        byte[] inputBytes = bArr;
        return subArray(inputBytes, 0, inputBytes.length / 2);
    }

    public static byte[] rightHalf(byte[] bArr) {
        byte[] inputBytes = bArr;
        int half = inputBytes.length / 2;
        return subArray(inputBytes, half, half);
    }

    public static int bitLength(byte[] bytes) {
        return bitLength(bytes.length);
    }

    public static int bitLength(int i) {
        Throwable th;
        StringBuilder sb;
        int byteLength = i;
        if (byteLength <= MAX_BYTE_LENGTH && byteLength >= 0) {
            return byteLength * 8;
        }
        Throwable th2 = th;
        new StringBuilder();
        new UncheckedJoseException(sb.append("Invalid byte length (").append(byteLength).append(") for converting to bit length").toString());
        throw th2;
    }

    public static int byteLength(int numberOfBits) {
        return numberOfBits / 8;
    }

    public static byte[] randomBytes(int i, SecureRandom secureRandom) {
        SecureRandom secureRandom2;
        SecureRandom secureRandom3;
        int length = i;
        SecureRandom secureRandom4 = secureRandom;
        if (secureRandom4 == null) {
            secureRandom2 = secureRandom3;
            new SecureRandom();
        } else {
            secureRandom2 = secureRandom4;
        }
        byte[] bytes = new byte[length];
        secureRandom2.nextBytes(bytes);
        return bytes;
    }

    public static byte[] randomBytes(int length) {
        return randomBytes(length, (SecureRandom) null);
    }

    public static String toDebugString(byte[] bArr) {
        Base64Url base64Url;
        StringBuilder sb;
        byte[] bytes = bArr;
        new Base64Url();
        String s = base64Url.base64UrlEncode(bytes);
        int[] ints = convertSignedTwosCompToUnsigned(bytes);
        new StringBuilder();
        return sb.append(Arrays.toString(ints)).append("(").append(ints.length).append("bytes/").append(bitLength(ints.length)).append("bits) | base64url encoded: ").append(s).toString();
    }
}
