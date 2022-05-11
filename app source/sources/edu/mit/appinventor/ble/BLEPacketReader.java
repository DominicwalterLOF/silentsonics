package edu.mit.appinventor.ble;

import com.google.appinventor.components.runtime.util.Ev3Constants;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.util.Arrays;
import org.shaded.apache.http.protocol.HTTP;

public class BLEPacketReader {
    private static final int INFINITY_S16 = 2046;
    private static final int INFINITY_S32 = 8388606;
    private static final int NAN_S16 = 2047;
    private static final int NAN_S32 = 8388607;
    private static final int NEG_INFINITY_S16 = 2049;
    private static final int NEG_INFINITY_S32 = 8388610;
    private static final int NRES_S16 = 2048;
    private static final int NRES_S32 = 8388608;
    private final byte[] buffer;
    private int index = 0;

    public BLEPacketReader(byte[] bArr) {
        byte[] packet = bArr;
        this.buffer = Arrays.copyOf(packet, packet.length);
    }

    public boolean readBoolean() {
        byte[] bArr = this.buffer;
        int i = this.index;
        int i2 = i + 1;
        this.index = i2;
        return bArr[i] != 0;
    }

    public int read2Bit() {
        byte[] bArr = this.buffer;
        int i = this.index;
        int i2 = i + 1;
        this.index = i2;
        return bArr[i];
    }

    public int readNibble() {
        byte[] bArr = this.buffer;
        int i = this.index;
        int i2 = i + 1;
        this.index = i2;
        return bArr[i];
    }

    public int readInt8() {
        byte[] bArr = this.buffer;
        int i = this.index;
        int i2 = i + 1;
        this.index = i2;
        return bArr[i];
    }

    public int readUint8() {
        byte[] bArr = this.buffer;
        int i = this.index;
        int i2 = i + 1;
        this.index = i2;
        return bArr[i] & Ev3Constants.Opcode.TST;
    }

    public int readInt16() {
        return (readInt8() << 8) | (readInt8() & 255);
    }

    public int readUint16() {
        return (readUint8() << 8) | readUint8();
    }

    public int readInt12() {
        return readInt16();
    }

    public int readUint12() {
        return readUint16();
    }

    public int readUint24() {
        return readInt32();
    }

    public int readInt24() {
        return ((int) readUint32()) & 16777215;
    }

    public int readInt32() {
        return (readInt16() << 16) | readUint16();
    }

    public long readUint32() {
        return (((long) readUint16()) << 16) | ((long) readUint16());
    }

    public long readInt48() {
        return (((long) readInt32()) << 16) | ((long) readUint16());
    }

    public long readUint48() {
        return (readUint32() << 16) | ((long) readUint16());
    }

    public long readInt64() {
        return (((long) readInt32()) << 32) | readUint32();
    }

    public BigInteger readUint64() {
        BigInteger bigInteger;
        byte[] data = Arrays.copyOfRange(this.buffer, this.index, this.index + 8);
        this.index += 8;
        new BigInteger(data);
        return bigInteger;
    }

    public float readFloat32() {
        return Float.intBitsToFloat(readInt32());
    }

    public double readFloat64() {
        return Double.longBitsToDouble(readInt64());
    }

    public double readSFloat() {
        int data = readInt16();
        if (data == INFINITY_S16) {
            return Double.POSITIVE_INFINITY;
        }
        if (data == NEG_INFINITY_S16) {
            return Double.NEGATIVE_INFINITY;
        }
        if (data == NAN_S16) {
            return Double.NaN;
        }
        if (data == 2048) {
            return Double.NaN;
        }
        int exponent = data >> 12;
        int mantissa = data & 4095;
        if ((mantissa & 2048) != 0) {
            mantissa |= -4096;
        }
        return ((double) mantissa) * Math.pow(10.0d, (double) exponent);
    }

    public double readFloat10() {
        int data = readInt32();
        if (data == INFINITY_S32) {
            return Double.POSITIVE_INFINITY;
        }
        if (data == NEG_INFINITY_S32) {
            return Double.NEGATIVE_INFINITY;
        }
        if (data == NAN_S32) {
            return Double.NaN;
        }
        if (data == 8388608) {
            return Double.NaN;
        }
        int exponent = data >> 24;
        int mantissa = data & 16777215;
        if ((mantissa & 8388608) != 0) {
            mantissa |= -16777216;
        }
        return ((double) mantissa) * Math.pow(10.0d, (double) exponent);
    }

    public String readUtf8() {
        String str;
        int end = this.index;
        while (end < this.buffer.length && this.buffer[end] != 0) {
            end++;
        }
        try {
            String str2 = str;
            new String(this.buffer, this.index, end - this.index, "UTF-8");
            String str3 = str2;
            this.index = end + 1;
            return str3;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            this.index = end + 1;
            return null;
        } catch (Throwable th) {
            Throwable th2 = th;
            this.index = end + 1;
            throw th2;
        }
    }

    public String readUtf16() {
        String str;
        int end = this.index;
        while (end < this.buffer.length && this.buffer[end] != 0) {
            end++;
        }
        try {
            String str2 = str;
            new String(this.buffer, this.index, end - this.index, HTTP.UTF_16);
            String str3 = str2;
            this.index = end + 2;
            return str3;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            this.index = end + 2;
            return null;
        } catch (Throwable th) {
            Throwable th2 = th;
            this.index = end + 2;
            throw th2;
        }
    }

    public BigInteger readUint128() {
        return readUint64().shiftLeft(64).or(readUint64());
    }

    public BigInteger readInt128() {
        return BigInteger.valueOf(readInt64()).shiftLeft(64).or(readUint64());
    }

    public int[] readDuint16() {
        int[] iArr = new int[2];
        iArr[0] = readUint16();
        int[] iArr2 = iArr;
        iArr2[1] = readUint16();
        return iArr2;
    }
}
