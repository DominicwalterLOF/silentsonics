package org.jose4j.json.internal.json_simple.parser;

import java.io.IOException;
import java.io.Reader;
import java.math.BigInteger;

class Yylex {
    public static final int STRING_BEGIN = 2;
    public static final int YYEOF = -1;
    public static final int YYINITIAL = 0;
    private static final int[] ZZ_ACTION = zzUnpackAction();
    private static final String ZZ_ACTION_PACKED_0 = "\u0002\u0000\u0002\u0001\u0001\u0002\u0001\u0003\u0001\u0004\u0003\u0001\u0001\u0005\u0001\u0006\u0001\u0007\u0001\b\u0001\t\u0001\n\u0001\u000b\u0001\f\u0001\r\u0005\u0000\u0001\f\u0001\u000e\u0001\u000f\u0001\u0010\u0001\u0011\u0001\u0012\u0001\u0013\u0001\u0014\u0001\u0000\u0001\u0015\u0001\u0000\u0001\u0015\u0004\u0000\u0001\u0016\u0001\u0017\u0002\u0000\u0001\u0018";
    private static final int[] ZZ_ATTRIBUTE = zzUnpackAttribute();
    private static final String ZZ_ATTRIBUTE_PACKED_0 = "\u0002\u0000\u0001\t\u0003\u0001\u0001\t\u0003\u0001\u0006\t\u0002\u0001\u0001\t\u0005\u0000\b\t\u0001\u0000\u0001\u0001\u0001\u0000\u0001\u0001\u0004\u0000\u0002\t\u0002\u0000\u0001\t";
    private static final int ZZ_BUFFERSIZE = 16384;
    private static final char[] ZZ_CMAP = zzUnpackCMap(ZZ_CMAP_PACKED);
    private static final String ZZ_CMAP_PACKED = "\t\u0000\u0001\u0007\u0001\u0007\u0002\u0000\u0001\u0007\u0012\u0000\u0001\u0007\u0001\u0000\u0001\t\b\u0000\u0001\u0006\u0001\u0019\u0001\u0002\u0001\u0004\u0001\n\n\u0003\u0001\u001a\u0006\u0000\u0004\u0001\u0001\u0005\u0001\u0001\u0014\u0000\u0001\u0017\u0001\b\u0001\u0018\u0003\u0000\u0001\u0012\u0001\u000b\u0002\u0001\u0001\u0011\u0001\f\u0005\u0000\u0001\u0013\u0001\u0000\u0001\r\u0003\u0000\u0001\u000e\u0001\u0014\u0001\u000f\u0001\u0010\u0005\u0000\u0001\u0015\u0001\u0000\u0001\u0016ﾂ\u0000";
    private static final String[] ZZ_ERROR_MSG;
    private static final int[] ZZ_LEXSTATE = {0, 0, 1, 1};
    private static final int ZZ_NO_MATCH = 1;
    private static final int ZZ_PUSHBACK_2BIG = 2;
    private static final int[] ZZ_ROWMAP = zzUnpackRowMap();
    private static final String ZZ_ROWMAP_PACKED_0 = "\u0000\u0000\u0000\u001b\u00006\u0000Q\u0000l\u0000\u00006\u0000¢\u0000½\u0000Ø\u00006\u00006\u00006\u00006\u00006\u00006\u0000ó\u0000Ď\u00006\u0000ĩ\u0000ń\u0000ş\u0000ź\u0000ƕ\u00006\u00006\u00006\u00006\u00006\u00006\u00006\u00006\u0000ư\u0000ǋ\u0000Ǧ\u0000Ǧ\u0000ȁ\u0000Ȝ\u0000ȷ\u0000ɒ\u00006\u00006\u0000ɭ\u0000ʈ\u00006";
    private static final int[] ZZ_TRANS = {2, 2, 3, 4, 2, 2, 2, 5, 2, 6, 2, 2, 7, 8, 2, 9, 2, 2, 2, 2, 2, 10, 11, 12, 13, 14, 15, 16, 16, 16, 16, 16, 16, 16, 16, 17, 18, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 4, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 4, 19, 20, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 20, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 5, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 21, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 22, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 23, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 16, 16, 16, 16, 16, 16, 16, 16, -1, -1, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, -1, -1, -1, -1, -1, -1, -1, -1, 24, 25, 26, 27, 28, 29, 30, 31, 32, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 33, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 34, 35, -1, -1, 34, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 36, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 37, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 38, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 39, -1, 39, -1, 39, -1, -1, -1, -1, -1, 39, 39, -1, -1, -1, -1, 39, 39, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 33, -1, 20, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 20, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 35, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 38, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 40, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 41, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 42, -1, 42, -1, 42, -1, -1, -1, -1, -1, 42, 42, -1, -1, -1, -1, 42, 42, -1, -1, -1, -1, -1, -1, -1, -1, -1, 43, -1, 43, -1, 43, -1, -1, -1, -1, -1, 43, 43, -1, -1, -1, -1, 43, 43, -1, -1, -1, -1, -1, -1, -1, -1, -1, 44, -1, 44, -1, 44, -1, -1, -1, -1, -1, 44, 44, -1, -1, -1, -1, 44, 44, -1, -1, -1, -1, -1, -1, -1, -1};
    private static final int ZZ_UNKNOWN_ERROR = 0;
    private StringBuilder sb;
    private int yychar;
    private int yycolumn;
    private int yyline;
    private boolean zzAtBOL;
    private boolean zzAtEOF;
    private char[] zzBuffer;
    private int zzCurrentPos;
    private int zzEndRead;
    private int zzLexicalState;
    private int zzMarkedPos;
    private Reader zzReader;
    private int zzStartRead;
    private int zzState;

    static {
        String[] strArr = new String[3];
        strArr[0] = "Unkown internal scanner error";
        String[] strArr2 = strArr;
        strArr2[1] = "Error: could not match input";
        String[] strArr3 = strArr2;
        strArr3[2] = "Error: pushback value was too large";
        ZZ_ERROR_MSG = strArr3;
    }

    private static int[] zzUnpackAction() {
        int[] result = new int[45];
        int offset = zzUnpackAction(ZZ_ACTION_PACKED_0, 0, result);
        return result;
    }

    private static int zzUnpackAction(String str, int offset, int[] iArr) {
        String packed = str;
        int[] result = iArr;
        int i = 0;
        int j = offset;
        int l = packed.length();
        while (i < l) {
            int i2 = i;
            int i3 = i + 1;
            int count = packed.charAt(i2);
            int i4 = i3;
            i = i3 + 1;
            int value = packed.charAt(i4);
            do {
                int i5 = j;
                j++;
                result[i5] = value;
                count--;
            } while (count > 0);
        }
        return j;
    }

    private static int[] zzUnpackRowMap() {
        int[] result = new int[45];
        int offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, 0, result);
        return result;
    }

    private static int zzUnpackRowMap(String str, int offset, int[] iArr) {
        String packed = str;
        int[] result = iArr;
        int i = 0;
        int j = offset;
        int l = packed.length();
        while (i < l) {
            int i2 = i;
            int i3 = i + 1;
            int high = packed.charAt(i2) << 16;
            int i4 = j;
            j++;
            int i5 = i3;
            i = i3 + 1;
            result[i4] = high | packed.charAt(i5);
        }
        return j;
    }

    private static int[] zzUnpackAttribute() {
        int[] result = new int[45];
        int offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, 0, result);
        return result;
    }

    private static int zzUnpackAttribute(String str, int offset, int[] iArr) {
        String packed = str;
        int[] result = iArr;
        int i = 0;
        int j = offset;
        int l = packed.length();
        while (i < l) {
            int i2 = i;
            int i3 = i + 1;
            int count = packed.charAt(i2);
            int i4 = i3;
            i = i3 + 1;
            int value = packed.charAt(i4);
            do {
                int i5 = j;
                j++;
                result[i5] = value;
                count--;
            } while (count > 0);
        }
        return j;
    }

    /* access modifiers changed from: package-private */
    public int getPosition() {
        return this.yychar;
    }

    Yylex(Reader in) {
        StringBuilder sb2;
        this.zzLexicalState = 0;
        this.zzBuffer = new char[16384];
        this.zzAtBOL = true;
        new StringBuilder();
        this.sb = sb2;
        this.zzReader = in;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    Yylex(java.io.InputStream r8) {
        /*
            r7 = this;
            r0 = r7
            r1 = r8
            r2 = r0
            java.io.InputStreamReader r3 = new java.io.InputStreamReader
            r6 = r3
            r3 = r6
            r4 = r6
            r5 = r1
            r4.<init>(r5)
            r2.<init>((java.io.Reader) r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jose4j.json.internal.json_simple.parser.Yylex.<init>(java.io.InputStream):void");
    }

    private static char[] zzUnpackCMap(String str) {
        String packed = str;
        char[] map = new char[65536];
        int i = 0;
        int j = 0;
        while (i < 90) {
            int i2 = i;
            int i3 = i + 1;
            int count = packed.charAt(i2);
            int i4 = i3;
            i = i3 + 1;
            char value = packed.charAt(i4);
            do {
                int i5 = j;
                j++;
                map[i5] = value;
                count--;
            } while (count > 0);
        }
        return map;
    }

    private boolean zzRefill() throws IOException {
        if (this.zzStartRead > 0) {
            System.arraycopy(this.zzBuffer, this.zzStartRead, this.zzBuffer, 0, this.zzEndRead - this.zzStartRead);
            this.zzEndRead -= this.zzStartRead;
            this.zzCurrentPos -= this.zzStartRead;
            this.zzMarkedPos -= this.zzStartRead;
            this.zzStartRead = 0;
        }
        if (this.zzCurrentPos >= this.zzBuffer.length) {
            char[] newBuffer = new char[(this.zzCurrentPos * 2)];
            System.arraycopy(this.zzBuffer, 0, newBuffer, 0, this.zzBuffer.length);
            this.zzBuffer = newBuffer;
        }
        int numRead = this.zzReader.read(this.zzBuffer, this.zzEndRead, this.zzBuffer.length - this.zzEndRead);
        if (numRead > 0) {
            this.zzEndRead += numRead;
            return false;
        } else if (numRead != 0) {
            return true;
        } else {
            int c = this.zzReader.read();
            if (c == -1) {
                return true;
            }
            char[] cArr = this.zzBuffer;
            int i = this.zzEndRead;
            int i2 = i + 1;
            this.zzEndRead = i2;
            cArr[i] = (char) c;
            return false;
        }
    }

    public final void yyclose() throws IOException {
        this.zzAtEOF = true;
        this.zzEndRead = this.zzStartRead;
        if (this.zzReader != null) {
            this.zzReader.close();
        }
    }

    public final void yyreset(Reader reader) {
        this.zzReader = reader;
        this.zzAtBOL = true;
        this.zzAtEOF = false;
        this.zzStartRead = 0;
        this.zzEndRead = 0;
        this.zzMarkedPos = 0;
        this.zzCurrentPos = 0;
        this.yycolumn = 0;
        this.yychar = 0;
        this.yyline = 0;
        this.zzLexicalState = 0;
    }

    public final int yystate() {
        return this.zzLexicalState;
    }

    public final void yybegin(int newState) {
        int i = newState;
        this.zzLexicalState = i;
    }

    public final String yytext() {
        String str;
        new String(this.zzBuffer, this.zzStartRead, this.zzMarkedPos - this.zzStartRead);
        return str;
    }

    public final char yycharat(int pos) {
        return this.zzBuffer[this.zzStartRead + pos];
    }

    public final int yylength() {
        return this.zzMarkedPos - this.zzStartRead;
    }

    private void zzScanError(int errorCode) {
        String message;
        Throwable th;
        try {
            message = ZZ_ERROR_MSG[errorCode];
        } catch (ArrayIndexOutOfBoundsException e) {
            ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException = e;
            message = ZZ_ERROR_MSG[0];
        }
        Throwable th2 = th;
        new Error(message);
        throw th2;
    }

    public void yypushback(int i) {
        int number = i;
        if (number > yylength()) {
            zzScanError(2);
        }
        this.zzMarkedPos -= number;
    }

    public Yytoken yylex() throws IOException, ParseException {
        int zzInput;
        int i;
        Yytoken yytoken;
        BigInteger val;
        Yytoken yytoken2;
        Yytoken yytoken3;
        Yytoken yytoken4;
        Yytoken yytoken5;
        Yytoken yytoken6;
        Yytoken yytoken7;
        Throwable th;
        Object obj;
        Yytoken yytoken8;
        Yytoken yytoken9;
        Yytoken yytoken10;
        Yytoken yytoken11;
        Yytoken yytoken12;
        Throwable th2;
        StringBuilder sb2;
        int zzEndReadL = this.zzEndRead;
        char[] zzBufferL = this.zzBuffer;
        char[] zzCMapL = ZZ_CMAP;
        int[] zzTransL = ZZ_TRANS;
        int[] zzRowMapL = ZZ_ROWMAP;
        int[] zzAttrL = ZZ_ATTRIBUTE;
        while (true) {
            int zzMarkedPosL = this.zzMarkedPos;
            this.yychar += zzMarkedPosL - this.zzStartRead;
            int zzAction = -1;
            int i2 = zzMarkedPosL;
            this.zzStartRead = i2;
            int i3 = i2;
            this.zzCurrentPos = i3;
            int zzCurrentPosL = i3;
            this.zzState = ZZ_LEXSTATE[this.zzLexicalState];
            while (true) {
                if (zzCurrentPosL < zzEndReadL) {
                    int i4 = zzCurrentPosL;
                    zzCurrentPosL++;
                    zzInput = zzBufferL[i4];
                } else {
                    if (this.zzAtEOF) {
                        zzInput = 65535;
                    } else {
                        this.zzCurrentPos = zzCurrentPosL;
                        this.zzMarkedPos = zzMarkedPosL;
                        boolean eof = zzRefill();
                        int zzCurrentPosL2 = this.zzCurrentPos;
                        zzMarkedPosL = this.zzMarkedPos;
                        zzBufferL = this.zzBuffer;
                        zzEndReadL = this.zzEndRead;
                        if (eof) {
                            zzInput = -1;
                        } else {
                            int i5 = zzCurrentPosL2;
                            zzCurrentPosL = zzCurrentPosL2 + 1;
                            zzInput = zzBufferL[i5];
                        }
                    }
                }
                int zzNext = zzTransL[zzRowMapL[this.zzState] + zzCMapL[zzInput]];
                if (zzNext != -1) {
                    this.zzState = zzNext;
                    int zzAttributes = zzAttrL[this.zzState];
                    if ((zzAttributes & 1) == 1) {
                        zzAction = this.zzState;
                        zzMarkedPosL = zzCurrentPosL;
                        if ((zzAttributes & 8) == 8) {
                        }
                    }
                }
            }
            this.zzMarkedPos = zzMarkedPosL;
            if (zzAction < 0) {
                i = zzAction;
            } else {
                i = ZZ_ACTION[zzAction];
            }
            switch (i) {
                case 1:
                    Throwable th3 = th;
                    new Character(yycharat(0));
                    new ParseException(this.yychar, 0, obj);
                    throw th3;
                case 2:
                    String yytext = yytext();
                    try {
                        Yytoken yytoken13 = yytoken3;
                        new Yytoken(0, Long.valueOf(yytext));
                        return yytoken13;
                    } catch (NumberFormatException e) {
                        NumberFormatException numberFormatException = e;
                        new BigInteger(yytext);
                        new Yytoken(0, val);
                        return yytoken2;
                    }
                case 3:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                    break;
                case 4:
                    this.sb = null;
                    new StringBuilder();
                    this.sb = sb2;
                    yybegin(2);
                    break;
                case 5:
                    new Yytoken(1, (Object) null);
                    return yytoken5;
                case 6:
                    new Yytoken(2, (Object) null);
                    return yytoken12;
                case 7:
                    new Yytoken(3, (Object) null);
                    return yytoken4;
                case 8:
                    new Yytoken(4, (Object) null);
                    return yytoken7;
                case 9:
                    new Yytoken(5, (Object) null);
                    return yytoken;
                case 10:
                    new Yytoken(6, (Object) null);
                    return yytoken6;
                case 11:
                    StringBuilder append = this.sb.append(yytext());
                    break;
                case 12:
                    StringBuilder append2 = this.sb.append('\\');
                    break;
                case 13:
                    yybegin(0);
                    new Yytoken(0, this.sb.toString());
                    return yytoken9;
                case 14:
                    StringBuilder append3 = this.sb.append('\"');
                    break;
                case 15:
                    StringBuilder append4 = this.sb.append('/');
                    break;
                case 16:
                    StringBuilder append5 = this.sb.append(8);
                    break;
                case 17:
                    StringBuilder append6 = this.sb.append(12);
                    break;
                case 18:
                    StringBuilder append7 = this.sb.append(10);
                    break;
                case 19:
                    StringBuilder append8 = this.sb.append(13);
                    break;
                case 20:
                    StringBuilder append9 = this.sb.append(9);
                    break;
                case 21:
                    new Yytoken(0, Double.valueOf(yytext()));
                    return yytoken8;
                case 22:
                    new Yytoken(0, (Object) null);
                    return yytoken10;
                case 23:
                    new Yytoken(0, Boolean.valueOf(yytext()));
                    return yytoken11;
                case 24:
                    try {
                        StringBuilder append10 = this.sb.append((char) Integer.parseInt(yytext().substring(2), 16));
                        break;
                    } catch (Exception e2) {
                        Exception e3 = e2;
                        Throwable th4 = th2;
                        new ParseException(this.yychar, 2, e3);
                        throw th4;
                    }
                default:
                    if (zzInput != -1 || this.zzStartRead != this.zzCurrentPos) {
                        zzScanError(1);
                        break;
                    } else {
                        this.zzAtEOF = true;
                        return null;
                    }
                    break;
            }
        }
    }
}
