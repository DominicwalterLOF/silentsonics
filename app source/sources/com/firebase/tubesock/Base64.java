package com.firebase.tubesock;

import com.google.appinventor.components.runtime.util.Ev3Constants;
import java.util.Arrays;

public class Base64 {
    private static final char[] CA = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".toCharArray();
    private static final int[] IA = new int[256];

    public Base64() {
    }

    static {
        Arrays.fill(IA, -1);
        int iS = CA.length;
        for (int i = 0; i < iS; i++) {
            IA[CA[i]] = i;
        }
        IA[61] = 0;
    }

    public static final char[] encodeToChar(byte[] bArr, boolean z) {
        byte[] sArr = bArr;
        boolean lineSep = z;
        int sLen = sArr != null ? sArr.length : 0;
        if (sLen == 0) {
            return new char[0];
        }
        int eLen = (sLen / 3) * 3;
        int cCnt = (((sLen - 1) / 3) + 1) << 2;
        int dLen = cCnt + (lineSep ? ((cCnt - 1) / 76) << 1 : 0);
        char[] dArr = new char[dLen];
        int s = 0;
        int d = 0;
        int cc = 0;
        while (s < eLen) {
            int i = s;
            int s2 = s + 1;
            int i2 = s2;
            int s3 = s2 + 1;
            int i3 = s3;
            s = s3 + 1;
            int i4 = ((sArr[i] & Ev3Constants.Opcode.TST) << 16) | ((sArr[i2] & Ev3Constants.Opcode.TST) << 8) | (sArr[i3] & 255);
            int i5 = d;
            int d2 = d + 1;
            dArr[i5] = CA[(i4 >>> 18) & 63];
            int i6 = d2;
            int d3 = d2 + 1;
            dArr[i6] = CA[(i4 >>> 12) & 63];
            int i7 = d3;
            int d4 = d3 + 1;
            dArr[i7] = CA[(i4 >>> 6) & 63];
            int i8 = d4;
            d = d4 + 1;
            dArr[i8] = CA[i4 & 63];
            if (lineSep) {
                cc++;
                if (cc == 19 && d < dLen - 2) {
                    int i9 = d;
                    int d5 = d + 1;
                    dArr[i9] = 13;
                    int i10 = d5;
                    d = d5 + 1;
                    dArr[i10] = 10;
                    cc = 0;
                }
            }
        }
        int left = sLen - eLen;
        if (left > 0) {
            int d6 = ((sArr[eLen] & Ev3Constants.Opcode.TST) << 10) | (left == 2 ? (sArr[sLen - 1] & Ev3Constants.Opcode.TST) << 2 : 0);
            dArr[dLen - 4] = CA[d6 >> 12];
            dArr[dLen - 3] = CA[(d6 >>> 6) & 63];
            dArr[dLen - 2] = left == 2 ? CA[d6 & 63] : '=';
            dArr[dLen - 1] = '=';
        }
        return dArr;
    }

    public static final byte[] decode(char[] cArr) {
        char[] sArr = cArr;
        int sLen = sArr != null ? sArr.length : 0;
        if (sLen == 0) {
            return new byte[0];
        }
        int sepCnt = 0;
        for (int i = 0; i < sLen; i++) {
            if (IA[sArr[i]] < 0) {
                sepCnt++;
            }
        }
        if ((sLen - sepCnt) % 4 != 0) {
            return null;
        }
        int pad = 0;
        int i2 = sLen;
        while (i2 > 1) {
            i2--;
            if (IA[sArr[i2]] > 0) {
                break;
            } else if (sArr[i2] == '=') {
                pad++;
            }
        }
        int i3 = (((sLen - sepCnt) * 6) >> 3) - pad;
        byte[] dArr = new byte[i3];
        int s = 0;
        int d = 0;
        while (d < i3) {
            int i4 = 0;
            int j = 0;
            while (j < 4) {
                int i5 = s;
                s++;
                int c = IA[sArr[i5]];
                if (c >= 0) {
                    i4 |= c << (18 - (j * 6));
                } else {
                    j--;
                }
                j++;
            }
            int i6 = d;
            d++;
            dArr[i6] = (byte) (i4 >> 16);
            if (d < i3) {
                int i7 = d;
                d++;
                dArr[i7] = (byte) (i4 >> 8);
                if (d < i3) {
                    int i8 = d;
                    d++;
                    dArr[i8] = (byte) i4;
                }
            }
        }
        return dArr;
    }

    public static final byte[] decodeFast(char[] cArr) {
        int sIx;
        int i;
        char[] sArr = cArr;
        int sLen = sArr.length;
        if (sLen == 0) {
            return new byte[0];
        }
        int sIx2 = 0;
        int eIx = sLen - 1;
        while (sIx < eIx && IA[sArr[sIx]] < 0) {
            sIx2 = sIx + 1;
        }
        while (eIx > 0 && IA[sArr[eIx]] < 0) {
            eIx--;
        }
        int pad = sArr[eIx] == '=' ? sArr[eIx + -1] == '=' ? 2 : 1 : 0;
        int cCnt = (eIx - sIx) + 1;
        if (sLen > 76) {
            i = (sArr[76] == 13 ? cCnt / 78 : 0) << 1;
        } else {
            i = 0;
        }
        int sepCnt = i;
        int len = (((cCnt - sepCnt) * 6) >> 3) - pad;
        byte[] dArr = new byte[len];
        int d = 0;
        int cc = 0;
        int eLen = (len / 3) * 3;
        while (d < eLen) {
            int i2 = sIx;
            int sIx3 = sIx + 1;
            int i3 = sIx3;
            int sIx4 = sIx3 + 1;
            int i4 = sIx4;
            int sIx5 = sIx4 + 1;
            int i5 = sIx5;
            sIx = sIx5 + 1;
            int i6 = (IA[sArr[i2]] << 18) | (IA[sArr[i3]] << 12) | (IA[sArr[i4]] << 6) | IA[sArr[i5]];
            int i7 = d;
            int d2 = d + 1;
            dArr[i7] = (byte) (i6 >> 16);
            int i8 = d2;
            int d3 = d2 + 1;
            dArr[i8] = (byte) (i6 >> 8);
            int i9 = d3;
            d = d3 + 1;
            dArr[i9] = (byte) i6;
            if (sepCnt > 0) {
                cc++;
                if (cc == 19) {
                    sIx += 2;
                    cc = 0;
                }
            }
        }
        if (d < len) {
            int i10 = 0;
            int j = 0;
            while (sIx <= eIx - pad) {
                int i11 = sIx;
                sIx++;
                i10 |= IA[sArr[i11]] << (18 - (j * 6));
                j++;
            }
            int r = 16;
            while (d < len) {
                int i12 = d;
                d++;
                dArr[i12] = (byte) (i10 >> r);
                r -= 8;
            }
        }
        return dArr;
    }

    public static final byte[] encodeToByte(byte[] bArr, boolean z) {
        byte[] sArr = bArr;
        boolean lineSep = z;
        int sLen = sArr != null ? sArr.length : 0;
        if (sLen == 0) {
            return new byte[0];
        }
        int eLen = (sLen / 3) * 3;
        int cCnt = (((sLen - 1) / 3) + 1) << 2;
        int dLen = cCnt + (lineSep ? ((cCnt - 1) / 76) << 1 : 0);
        byte[] dArr = new byte[dLen];
        int s = 0;
        int d = 0;
        int cc = 0;
        while (s < eLen) {
            int i = s;
            int s2 = s + 1;
            int i2 = s2;
            int s3 = s2 + 1;
            int i3 = s3;
            s = s3 + 1;
            int i4 = ((sArr[i] & Ev3Constants.Opcode.TST) << 16) | ((sArr[i2] & Ev3Constants.Opcode.TST) << 8) | (sArr[i3] & 255);
            int i5 = d;
            int d2 = d + 1;
            dArr[i5] = (byte) CA[(i4 >>> 18) & 63];
            int i6 = d2;
            int d3 = d2 + 1;
            dArr[i6] = (byte) CA[(i4 >>> 12) & 63];
            int i7 = d3;
            int d4 = d3 + 1;
            dArr[i7] = (byte) CA[(i4 >>> 6) & 63];
            int i8 = d4;
            d = d4 + 1;
            dArr[i8] = (byte) CA[i4 & 63];
            if (lineSep) {
                cc++;
                if (cc == 19 && d < dLen - 2) {
                    int i9 = d;
                    int d5 = d + 1;
                    dArr[i9] = 13;
                    int i10 = d5;
                    d = d5 + 1;
                    dArr[i10] = 10;
                    cc = 0;
                }
            }
        }
        int left = sLen - eLen;
        if (left > 0) {
            int d6 = ((sArr[eLen] & Ev3Constants.Opcode.TST) << 10) | (left == 2 ? (sArr[sLen - 1] & Ev3Constants.Opcode.TST) << 2 : 0);
            dArr[dLen - 4] = (byte) CA[d6 >> 12];
            dArr[dLen - 3] = (byte) CA[(d6 >>> 6) & 63];
            dArr[dLen - 2] = left == 2 ? (byte) CA[d6 & 63] : Ev3Constants.Opcode.MOVEF_16;
            dArr[dLen - 1] = Ev3Constants.Opcode.MOVEF_16;
        }
        return dArr;
    }

    public static final byte[] decode(byte[] bArr) {
        byte[] sArr = bArr;
        int sLen = sArr.length;
        int sepCnt = 0;
        for (int i = 0; i < sLen; i++) {
            if (IA[sArr[i] & Ev3Constants.Opcode.TST] < 0) {
                sepCnt++;
            }
        }
        if ((sLen - sepCnt) % 4 != 0) {
            return null;
        }
        int pad = 0;
        int i2 = sLen;
        while (i2 > 1) {
            i2--;
            if (IA[sArr[i2] & Ev3Constants.Opcode.TST] > 0) {
                break;
            } else if (sArr[i2] == 61) {
                pad++;
            }
        }
        int i3 = (((sLen - sepCnt) * 6) >> 3) - pad;
        byte[] dArr = new byte[i3];
        int s = 0;
        int d = 0;
        while (d < i3) {
            int i4 = 0;
            int j = 0;
            while (j < 4) {
                int i5 = s;
                s++;
                int c = IA[sArr[i5] & Ev3Constants.Opcode.TST];
                if (c >= 0) {
                    i4 |= c << (18 - (j * 6));
                } else {
                    j--;
                }
                j++;
            }
            int i6 = d;
            d++;
            dArr[i6] = (byte) (i4 >> 16);
            if (d < i3) {
                int i7 = d;
                d++;
                dArr[i7] = (byte) (i4 >> 8);
                if (d < i3) {
                    int i8 = d;
                    d++;
                    dArr[i8] = (byte) i4;
                }
            }
        }
        return dArr;
    }

    public static final byte[] decodeFast(byte[] bArr) {
        int sIx;
        int i;
        byte[] sArr = bArr;
        int sLen = sArr.length;
        if (sLen == 0) {
            return new byte[0];
        }
        int sIx2 = 0;
        int eIx = sLen - 1;
        while (sIx < eIx && IA[sArr[sIx] & Ev3Constants.Opcode.TST] < 0) {
            sIx2 = sIx + 1;
        }
        while (eIx > 0 && IA[sArr[eIx] & Ev3Constants.Opcode.TST] < 0) {
            eIx--;
        }
        int pad = sArr[eIx] == 61 ? sArr[eIx + -1] == 61 ? 2 : 1 : 0;
        int cCnt = (eIx - sIx) + 1;
        if (sLen > 76) {
            i = (sArr[76] == 13 ? cCnt / 78 : 0) << 1;
        } else {
            i = 0;
        }
        int sepCnt = i;
        int len = (((cCnt - sepCnt) * 6) >> 3) - pad;
        byte[] dArr = new byte[len];
        int d = 0;
        int cc = 0;
        int eLen = (len / 3) * 3;
        while (d < eLen) {
            int i2 = sIx;
            int sIx3 = sIx + 1;
            int i3 = sIx3;
            int sIx4 = sIx3 + 1;
            int i4 = sIx4;
            int sIx5 = sIx4 + 1;
            int i5 = sIx5;
            sIx = sIx5 + 1;
            int i6 = (IA[sArr[i2]] << 18) | (IA[sArr[i3]] << 12) | (IA[sArr[i4]] << 6) | IA[sArr[i5]];
            int i7 = d;
            int d2 = d + 1;
            dArr[i7] = (byte) (i6 >> 16);
            int i8 = d2;
            int d3 = d2 + 1;
            dArr[i8] = (byte) (i6 >> 8);
            int i9 = d3;
            d = d3 + 1;
            dArr[i9] = (byte) i6;
            if (sepCnt > 0) {
                cc++;
                if (cc == 19) {
                    sIx += 2;
                    cc = 0;
                }
            }
        }
        if (d < len) {
            int i10 = 0;
            int j = 0;
            while (sIx <= eIx - pad) {
                int i11 = sIx;
                sIx++;
                i10 |= IA[sArr[i11]] << (18 - (j * 6));
                j++;
            }
            int r = 16;
            while (d < len) {
                int i12 = d;
                d++;
                dArr[i12] = (byte) (i10 >> r);
                r -= 8;
            }
        }
        return dArr;
    }

    public static final String encodeToString(byte[] sArr, boolean lineSep) {
        String str;
        new String(encodeToChar(sArr, lineSep));
        return str;
    }

    public static final byte[] decode(String str) {
        String str2 = str;
        int sLen = str2 != null ? str2.length() : 0;
        if (sLen == 0) {
            return new byte[0];
        }
        int sepCnt = 0;
        for (int i = 0; i < sLen; i++) {
            if (IA[str2.charAt(i)] < 0) {
                sepCnt++;
            }
        }
        if ((sLen - sepCnt) % 4 != 0) {
            return null;
        }
        int pad = 0;
        int i2 = sLen;
        while (i2 > 1) {
            i2--;
            if (IA[str2.charAt(i2)] > 0) {
                break;
            } else if (str2.charAt(i2) == '=') {
                pad++;
            }
        }
        int i3 = (((sLen - sepCnt) * 6) >> 3) - pad;
        byte[] dArr = new byte[i3];
        int s = 0;
        int d = 0;
        while (d < i3) {
            int i4 = 0;
            int j = 0;
            while (j < 4) {
                int i5 = s;
                s++;
                int c = IA[str2.charAt(i5)];
                if (c >= 0) {
                    i4 |= c << (18 - (j * 6));
                } else {
                    j--;
                }
                j++;
            }
            int i6 = d;
            d++;
            dArr[i6] = (byte) (i4 >> 16);
            if (d < i3) {
                int i7 = d;
                d++;
                dArr[i7] = (byte) (i4 >> 8);
                if (d < i3) {
                    int i8 = d;
                    d++;
                    dArr[i8] = (byte) i4;
                }
            }
        }
        return dArr;
    }

    public static final byte[] decodeFast(String str) {
        int sIx;
        int i;
        String s = str;
        int sLen = s.length();
        if (sLen == 0) {
            return new byte[0];
        }
        int sIx2 = 0;
        int eIx = sLen - 1;
        while (sIx < eIx && IA[s.charAt(sIx) & 255] < 0) {
            sIx2 = sIx + 1;
        }
        while (eIx > 0 && IA[s.charAt(eIx) & 255] < 0) {
            eIx--;
        }
        int pad = s.charAt(eIx) == '=' ? s.charAt(eIx + -1) == '=' ? 2 : 1 : 0;
        int cCnt = (eIx - sIx) + 1;
        if (sLen > 76) {
            i = (s.charAt(76) == 13 ? cCnt / 78 : 0) << 1;
        } else {
            i = 0;
        }
        int sepCnt = i;
        int len = (((cCnt - sepCnt) * 6) >> 3) - pad;
        byte[] dArr = new byte[len];
        int d = 0;
        int cc = 0;
        int eLen = (len / 3) * 3;
        while (d < eLen) {
            int i2 = sIx;
            int sIx3 = sIx + 1;
            int i3 = sIx3;
            int sIx4 = sIx3 + 1;
            int i4 = sIx4;
            int sIx5 = sIx4 + 1;
            int i5 = sIx5;
            sIx = sIx5 + 1;
            int i6 = (IA[s.charAt(i2)] << 18) | (IA[s.charAt(i3)] << 12) | (IA[s.charAt(i4)] << 6) | IA[s.charAt(i5)];
            int i7 = d;
            int d2 = d + 1;
            dArr[i7] = (byte) (i6 >> 16);
            int i8 = d2;
            int d3 = d2 + 1;
            dArr[i8] = (byte) (i6 >> 8);
            int i9 = d3;
            d = d3 + 1;
            dArr[i9] = (byte) i6;
            if (sepCnt > 0) {
                cc++;
                if (cc == 19) {
                    sIx += 2;
                    cc = 0;
                }
            }
        }
        if (d < len) {
            int i10 = 0;
            int j = 0;
            while (sIx <= eIx - pad) {
                int i11 = sIx;
                sIx++;
                i10 |= IA[s.charAt(i11)] << (18 - (j * 6));
                j++;
            }
            int r = 16;
            while (d < len) {
                int i12 = d;
                d++;
                dArr[i12] = (byte) (i10 >> r);
                r -= 8;
            }
        }
        return dArr;
    }
}
