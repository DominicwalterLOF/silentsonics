package org.jose4j.lang;

public class Maths {
    public Maths() {
    }

    public static long add(long j, long j2) {
        Throwable th;
        StringBuilder sb;
        long x = j;
        long y = j2;
        long result = x + y;
        if (0 <= ((x ^ result) & (y ^ result))) {
            return result;
        }
        Throwable th2 = th;
        new StringBuilder();
        new ArithmeticException(sb.append("long overflow adding: ").append(x).append(" + ").append(y).append(" = ").append(result).toString());
        throw th2;
    }

    public static long subtract(long j, long j2) {
        Throwable th;
        StringBuilder sb;
        long x = j;
        long y = j2;
        long result = x - y;
        if (0 <= ((x ^ y) & (x ^ result))) {
            return result;
        }
        Throwable th2 = th;
        new StringBuilder();
        new ArithmeticException(sb.append("long overflow subtracting: ").append(x).append(" - ").append(y).append(" = ").append(result).toString());
        throw th2;
    }
}
