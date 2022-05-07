package org.slf4j.helpers;

import java.util.HashMap;
import java.util.Map;

public final class MessageFormatter {
    static final char DELIM_START = '{';
    static final char DELIM_STOP = '}';
    static final String DELIM_STR = "{}";
    private static final char ESCAPE_CHAR = '\\';

    public MessageFormatter() {
    }

    public static final FormattingTuple format(String messagePattern, Object arg) {
        return arrayFormat(messagePattern, new Object[]{arg});
    }

    public static final FormattingTuple format(String messagePattern, Object arg1, Object arg2) {
        Object[] objArr = new Object[2];
        objArr[0] = arg1;
        Object[] objArr2 = objArr;
        objArr2[1] = arg2;
        return arrayFormat(messagePattern, objArr2);
    }

    public static final FormattingTuple arrayFormat(String str, Object[] objArr) {
        String messagePattern = str;
        Object[] argArray = objArr;
        Throwable throwableCandidate = getThrowableCandidate(argArray);
        Object[] args = argArray;
        if (throwableCandidate != null) {
            args = trimmedCopy(argArray);
        }
        return arrayFormat(messagePattern, args, throwableCandidate);
    }

    public static final FormattingTuple arrayFormat(String str, Object[] objArr, Throwable th) {
        StringBuilder sb;
        FormattingTuple formattingTuple;
        FormattingTuple formattingTuple2;
        FormattingTuple formattingTuple3;
        Map map;
        int i;
        Map map2;
        FormattingTuple formattingTuple4;
        FormattingTuple formattingTuple5;
        String messagePattern = str;
        Object[] argArray = objArr;
        Throwable throwable = th;
        if (messagePattern == null) {
            new FormattingTuple((String) null, argArray, throwable);
            return formattingTuple5;
        } else if (argArray == null) {
            new FormattingTuple(messagePattern);
            return formattingTuple4;
        } else {
            int i2 = 0;
            new StringBuilder(messagePattern.length() + 50);
            StringBuilder sbuf = sb;
            int L = 0;
            while (L < argArray.length) {
                int j = messagePattern.indexOf(DELIM_STR, i2);
                if (j != -1) {
                    if (!isEscapedDelimeter(messagePattern, j)) {
                        StringBuilder append = sbuf.append(messagePattern, i2, j);
                        new HashMap();
                        deeplyAppendParameter(sbuf, argArray[L], map);
                        i = j + 2;
                    } else if (!isDoubleEscaped(messagePattern, j)) {
                        L--;
                        StringBuilder append2 = sbuf.append(messagePattern, i2, j - 1);
                        StringBuilder append3 = sbuf.append(DELIM_START);
                        i = j + 1;
                    } else {
                        StringBuilder append4 = sbuf.append(messagePattern, i2, j - 1);
                        new HashMap();
                        deeplyAppendParameter(sbuf, argArray[L], map2);
                        i = j + 2;
                    }
                    i2 = i;
                    L++;
                } else if (i2 == 0) {
                    new FormattingTuple(messagePattern, argArray, throwable);
                    return formattingTuple3;
                } else {
                    StringBuilder append5 = sbuf.append(messagePattern, i2, messagePattern.length());
                    new FormattingTuple(sbuf.toString(), argArray, throwable);
                    return formattingTuple2;
                }
            }
            StringBuilder append6 = sbuf.append(messagePattern, i2, messagePattern.length());
            new FormattingTuple(sbuf.toString(), argArray, throwable);
            return formattingTuple;
        }
    }

    static final boolean isEscapedDelimeter(String str, int i) {
        String messagePattern = str;
        int delimeterStartIndex = i;
        if (delimeterStartIndex == 0) {
            return false;
        }
        if (messagePattern.charAt(delimeterStartIndex - 1) == '\\') {
            return true;
        }
        return false;
    }

    static final boolean isDoubleEscaped(String str, int i) {
        String messagePattern = str;
        int delimeterStartIndex = i;
        if (delimeterStartIndex < 2 || messagePattern.charAt(delimeterStartIndex - 2) != '\\') {
            return false;
        }
        return true;
    }

    private static void deeplyAppendParameter(StringBuilder sb, Object obj, Map<Object[], Object> map) {
        StringBuilder sbuf = sb;
        Object o = obj;
        Map<Object[], Object> seenMap = map;
        if (o == null) {
            StringBuilder append = sbuf.append("null");
        } else if (!o.getClass().isArray()) {
            safeObjectAppend(sbuf, o);
        } else if (o instanceof boolean[]) {
            booleanArrayAppend(sbuf, (boolean[]) o);
        } else if (o instanceof byte[]) {
            byteArrayAppend(sbuf, (byte[]) o);
        } else if (o instanceof char[]) {
            charArrayAppend(sbuf, (char[]) o);
        } else if (o instanceof short[]) {
            shortArrayAppend(sbuf, (short[]) o);
        } else if (o instanceof int[]) {
            intArrayAppend(sbuf, (int[]) o);
        } else if (o instanceof long[]) {
            longArrayAppend(sbuf, (long[]) o);
        } else if (o instanceof float[]) {
            floatArrayAppend(sbuf, (float[]) o);
        } else if (o instanceof double[]) {
            doubleArrayAppend(sbuf, (double[]) o);
        } else {
            objectArrayAppend(sbuf, (Object[]) o, seenMap);
        }
    }

    private static void safeObjectAppend(StringBuilder sb, Object obj) {
        StringBuilder sb2;
        StringBuilder sbuf = sb;
        Object o = obj;
        try {
            StringBuilder append = sbuf.append(o.toString());
        } catch (Throwable th) {
            new StringBuilder();
            Util.report(sb2.append("SLF4J: Failed toString() invocation on an object of type [").append(o.getClass().getName()).append("]").toString(), th);
            StringBuilder append2 = sbuf.append("[FAILED toString()]");
        }
    }

    private static void objectArrayAppend(StringBuilder sb, Object[] objArr, Map<Object[], Object> map) {
        StringBuilder sbuf = sb;
        Object[] a = objArr;
        Map<Object[], Object> seenMap = map;
        StringBuilder append = sbuf.append('[');
        if (!seenMap.containsKey(a)) {
            Object put = seenMap.put(a, (Object) null);
            int len = a.length;
            for (int i = 0; i < len; i++) {
                deeplyAppendParameter(sbuf, a[i], seenMap);
                if (i != len - 1) {
                    StringBuilder append2 = sbuf.append(", ");
                }
            }
            Object remove = seenMap.remove(a);
        } else {
            StringBuilder append3 = sbuf.append("...");
        }
        StringBuilder append4 = sbuf.append(']');
    }

    private static void booleanArrayAppend(StringBuilder sb, boolean[] zArr) {
        StringBuilder sbuf = sb;
        boolean[] a = zArr;
        StringBuilder append = sbuf.append('[');
        int len = a.length;
        for (int i = 0; i < len; i++) {
            StringBuilder append2 = sbuf.append(a[i]);
            if (i != len - 1) {
                StringBuilder append3 = sbuf.append(", ");
            }
        }
        StringBuilder append4 = sbuf.append(']');
    }

    private static void byteArrayAppend(StringBuilder sb, byte[] bArr) {
        StringBuilder sbuf = sb;
        byte[] a = bArr;
        StringBuilder append = sbuf.append('[');
        int len = a.length;
        for (int i = 0; i < len; i++) {
            StringBuilder append2 = sbuf.append(a[i]);
            if (i != len - 1) {
                StringBuilder append3 = sbuf.append(", ");
            }
        }
        StringBuilder append4 = sbuf.append(']');
    }

    private static void charArrayAppend(StringBuilder sb, char[] cArr) {
        StringBuilder sbuf = sb;
        char[] a = cArr;
        StringBuilder append = sbuf.append('[');
        int len = a.length;
        for (int i = 0; i < len; i++) {
            StringBuilder append2 = sbuf.append(a[i]);
            if (i != len - 1) {
                StringBuilder append3 = sbuf.append(", ");
            }
        }
        StringBuilder append4 = sbuf.append(']');
    }

    private static void shortArrayAppend(StringBuilder sb, short[] sArr) {
        StringBuilder sbuf = sb;
        short[] a = sArr;
        StringBuilder append = sbuf.append('[');
        int len = a.length;
        for (int i = 0; i < len; i++) {
            StringBuilder append2 = sbuf.append(a[i]);
            if (i != len - 1) {
                StringBuilder append3 = sbuf.append(", ");
            }
        }
        StringBuilder append4 = sbuf.append(']');
    }

    private static void intArrayAppend(StringBuilder sb, int[] iArr) {
        StringBuilder sbuf = sb;
        int[] a = iArr;
        StringBuilder append = sbuf.append('[');
        int len = a.length;
        for (int i = 0; i < len; i++) {
            StringBuilder append2 = sbuf.append(a[i]);
            if (i != len - 1) {
                StringBuilder append3 = sbuf.append(", ");
            }
        }
        StringBuilder append4 = sbuf.append(']');
    }

    private static void longArrayAppend(StringBuilder sb, long[] jArr) {
        StringBuilder sbuf = sb;
        long[] a = jArr;
        StringBuilder append = sbuf.append('[');
        int len = a.length;
        for (int i = 0; i < len; i++) {
            StringBuilder append2 = sbuf.append(a[i]);
            if (i != len - 1) {
                StringBuilder append3 = sbuf.append(", ");
            }
        }
        StringBuilder append4 = sbuf.append(']');
    }

    private static void floatArrayAppend(StringBuilder sb, float[] fArr) {
        StringBuilder sbuf = sb;
        float[] a = fArr;
        StringBuilder append = sbuf.append('[');
        int len = a.length;
        for (int i = 0; i < len; i++) {
            StringBuilder append2 = sbuf.append(a[i]);
            if (i != len - 1) {
                StringBuilder append3 = sbuf.append(", ");
            }
        }
        StringBuilder append4 = sbuf.append(']');
    }

    private static void doubleArrayAppend(StringBuilder sb, double[] dArr) {
        StringBuilder sbuf = sb;
        double[] a = dArr;
        StringBuilder append = sbuf.append('[');
        int len = a.length;
        for (int i = 0; i < len; i++) {
            StringBuilder append2 = sbuf.append(a[i]);
            if (i != len - 1) {
                StringBuilder append3 = sbuf.append(", ");
            }
        }
        StringBuilder append4 = sbuf.append(']');
    }

    public static Throwable getThrowableCandidate(Object[] objArr) {
        Object[] argArray = objArr;
        if (argArray == null || argArray.length == 0) {
            return null;
        }
        Object lastEntry = argArray[argArray.length - 1];
        if (lastEntry instanceof Throwable) {
            return (Throwable) lastEntry;
        }
        return null;
    }

    public static Object[] trimmedCopy(Object[] objArr) {
        Throwable th;
        Object[] argArray = objArr;
        if (argArray == null || argArray.length == 0) {
            Throwable th2 = th;
            new IllegalStateException("non-sensical empty or null argument array");
            throw th2;
        }
        int trimmedLen = argArray.length - 1;
        Object[] trimmed = new Object[trimmedLen];
        if (trimmedLen > 0) {
            System.arraycopy(argArray, 0, trimmed, 0, trimmedLen);
        }
        return trimmed;
    }
}
