package org.jose4j.base64url.internal.apache.commons.codec.binary;

import java.util.Arrays;
import org.jose4j.lang.StringUtil;

public abstract class BaseNCodec {
    private static final int DEFAULT_BUFFER_RESIZE_FACTOR = 2;
    private static final int DEFAULT_BUFFER_SIZE = 8192;
    static final int EOF = -1;
    protected static final int MASK_8BITS = 255;
    public static final int MIME_CHUNK_SIZE = 76;
    protected static final byte PAD_DEFAULT = 61;
    public static final int PEM_CHUNK_SIZE = 64;
    protected final byte PAD = 61;
    private final int chunkSeparatorLength;
    private final int encodedBlockSize;
    protected final int lineLength;
    private final int unencodedBlockSize;

    /* access modifiers changed from: package-private */
    public abstract void decode(byte[] bArr, int i, int i2, Context context);

    /* access modifiers changed from: package-private */
    public abstract void encode(byte[] bArr, int i, int i2, Context context);

    /* access modifiers changed from: protected */
    public abstract boolean isInAlphabet(byte b);

    static class Context {
        byte[] buffer;
        int currentLinePos;
        boolean eof;
        int ibitWorkArea;
        long lbitWorkArea;
        int modulus;
        int pos;
        int readPos;

        Context() {
        }

        public String toString() {
            Object[] objArr = new Object[9];
            objArr[0] = getClass().getSimpleName();
            Object[] objArr2 = objArr;
            objArr2[1] = Arrays.toString(this.buffer);
            Object[] objArr3 = objArr2;
            objArr3[2] = Integer.valueOf(this.currentLinePos);
            Object[] objArr4 = objArr3;
            objArr4[3] = Boolean.valueOf(this.eof);
            Object[] objArr5 = objArr4;
            objArr5[4] = Integer.valueOf(this.ibitWorkArea);
            Object[] objArr6 = objArr5;
            objArr6[5] = Long.valueOf(this.lbitWorkArea);
            Object[] objArr7 = objArr6;
            objArr7[6] = Integer.valueOf(this.modulus);
            Object[] objArr8 = objArr7;
            objArr8[7] = Integer.valueOf(this.pos);
            Object[] objArr9 = objArr8;
            objArr9[8] = Integer.valueOf(this.readPos);
            return String.format("%s[buffer=%s, currentLinePos=%s, eof=%s, ibitWorkArea=%s, lbitWorkArea=%s, modulus=%s, pos=%s, readPos=%s]", objArr9);
        }
    }

    protected BaseNCodec(int unencodedBlockSize2, int i, int i2, int i3) {
        int encodedBlockSize2 = i;
        int lineLength2 = i2;
        int chunkSeparatorLength2 = i3;
        this.unencodedBlockSize = unencodedBlockSize2;
        this.encodedBlockSize = encodedBlockSize2;
        this.lineLength = lineLength2 > 0 && chunkSeparatorLength2 > 0 ? (lineLength2 / encodedBlockSize2) * encodedBlockSize2 : 0;
        this.chunkSeparatorLength = chunkSeparatorLength2;
    }

    /* access modifiers changed from: package-private */
    public boolean hasData(Context context) {
        return context.buffer != null;
    }

    /* access modifiers changed from: package-private */
    public int available(Context context) {
        Context context2 = context;
        return context2.buffer != null ? context2.pos - context2.readPos : 0;
    }

    /* access modifiers changed from: protected */
    public int getDefaultBufferSize() {
        return 8192;
    }

    private byte[] resizeBuffer(Context context) {
        Context context2 = context;
        if (context2.buffer == null) {
            context2.buffer = new byte[getDefaultBufferSize()];
            context2.pos = 0;
            context2.readPos = 0;
        } else {
            byte[] b = new byte[(context2.buffer.length * 2)];
            System.arraycopy(context2.buffer, 0, b, 0, context2.buffer.length);
            context2.buffer = b;
        }
        return context2.buffer;
    }

    /* access modifiers changed from: protected */
    public byte[] ensureBufferSize(int i, Context context) {
        int size = i;
        Context context2 = context;
        if (context2.buffer == null || context2.buffer.length < context2.pos + size) {
            return resizeBuffer(context2);
        }
        return context2.buffer;
    }

    /* access modifiers changed from: package-private */
    public int readResults(byte[] bArr, int i, int i2, Context context) {
        byte[] b = bArr;
        int bPos = i;
        int bAvail = i2;
        Context context2 = context;
        if (context2.buffer != null) {
            int len = Math.min(available(context2), bAvail);
            System.arraycopy(context2.buffer, context2.readPos, b, bPos, len);
            context2.readPos += len;
            if (context2.readPos >= context2.pos) {
                context2.buffer = null;
            }
            return len;
        }
        return context2.eof ? -1 : 0;
    }

    protected static boolean isWhiteSpace(byte byteToCheck) {
        switch (byteToCheck) {
            case 9:
            case 10:
            case 13:
            case 32:
                return true;
            default:
                return false;
        }
    }

    public String encodeToString(byte[] pArray) {
        return StringUtil.newStringUtf8(encode(pArray));
    }

    public String encodeAsString(byte[] pArray) {
        return StringUtil.newStringUtf8(encode(pArray));
    }

    public byte[] decode(String pArray) {
        return decode(StringUtil.getBytesUtf8(pArray));
    }

    public byte[] decode(byte[] bArr) {
        Context context;
        byte[] pArray = bArr;
        if (pArray == null || pArray.length == 0) {
            return pArray;
        }
        new Context();
        Context context2 = context;
        decode(pArray, 0, pArray.length, context2);
        decode(pArray, 0, -1, context2);
        byte[] result = new byte[context2.pos];
        int readResults = readResults(result, 0, result.length, context2);
        return result;
    }

    public byte[] encode(byte[] bArr) {
        Context context;
        byte[] pArray = bArr;
        if (pArray == null || pArray.length == 0) {
            return pArray;
        }
        new Context();
        Context context2 = context;
        encode(pArray, 0, pArray.length, context2);
        encode(pArray, 0, -1, context2);
        byte[] buf = new byte[(context2.pos - context2.readPos)];
        int readResults = readResults(buf, 0, buf.length, context2);
        return buf;
    }

    public boolean isInAlphabet(byte[] bArr, boolean z) {
        byte[] arrayOctet = bArr;
        boolean allowWSPad = z;
        for (int i = 0; i < arrayOctet.length; i++) {
            if (!isInAlphabet(arrayOctet[i]) && (!allowWSPad || (arrayOctet[i] != 61 && !isWhiteSpace(arrayOctet[i])))) {
                return false;
            }
        }
        return true;
    }

    public boolean isInAlphabet(String basen) {
        return isInAlphabet(StringUtil.getBytesUtf8(basen), true);
    }

    /* access modifiers changed from: protected */
    public boolean containsAlphabetOrPad(byte[] bArr) {
        byte[] arrayOctet = bArr;
        if (arrayOctet == null) {
            return false;
        }
        byte[] arr$ = arrayOctet;
        int len$ = arr$.length;
        for (int i$ = 0; i$ < len$; i$++) {
            byte element = arr$[i$];
            if (61 == element || isInAlphabet(element)) {
                return true;
            }
        }
        return false;
    }

    public long getEncodedLength(byte[] pArray) {
        long len = ((long) (((pArray.length + this.unencodedBlockSize) - 1) / this.unencodedBlockSize)) * ((long) this.encodedBlockSize);
        if (this.lineLength > 0) {
            len += (((len + ((long) this.lineLength)) - 1) / ((long) this.lineLength)) * ((long) this.chunkSeparatorLength);
        }
        return len;
    }
}
