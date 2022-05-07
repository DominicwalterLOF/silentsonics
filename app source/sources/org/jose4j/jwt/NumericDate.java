package org.jose4j.jwt;

import java.text.DateFormat;
import java.util.Date;
import org.jose4j.lang.Maths;

public class NumericDate {
    private static final long CONVERSION = 1000;
    private long value;

    private NumericDate(long value2) {
        setValue(value2);
    }

    public static NumericDate now() {
        return fromMilliseconds(System.currentTimeMillis());
    }

    public static NumericDate fromSeconds(long secondsFromEpoch) {
        NumericDate numericDate;
        new NumericDate(secondsFromEpoch);
        return numericDate;
    }

    public static NumericDate fromMilliseconds(long millisecondsFromEpoch) {
        return fromSeconds(millisecondsFromEpoch / 1000);
    }

    public void addSeconds(long seconds) {
        setValue(Maths.add(this.value, seconds));
    }

    public long getValue() {
        return this.value;
    }

    public void setValue(long value2) {
        long j = value2;
        this.value = j;
    }

    public long getValueInMillis() {
        Throwable th;
        StringBuilder sb;
        long secs = getValue();
        long millis = secs * 1000;
        if (canConvertToMillis()) {
            return millis;
        }
        Throwable th2 = th;
        new StringBuilder();
        new ArithmeticException(sb.append("converting ").append(secs).append(" seconds to milliseconds (x1000) resulted in long integer overflow (").append(millis).append(")").toString());
        throw th2;
    }

    private boolean canConvertToMillis() {
        boolean z;
        long secs = getValue();
        long millis = secs * 1000;
        if ((secs <= 0 || millis >= secs) && (secs >= 0 || millis <= secs)) {
            if (!(secs == 0) || !(millis != 0)) {
                z = true;
                return z;
            }
        }
        z = false;
        return z;
    }

    public boolean isBefore(NumericDate when) {
        return this.value < when.getValue();
    }

    public boolean isOnOrAfter(NumericDate when) {
        return !isBefore(when);
    }

    public boolean isAfter(NumericDate when) {
        return this.value > when.getValue();
    }

    public String toString() {
        StringBuilder sb;
        Date date;
        new StringBuilder();
        StringBuilder sb2 = sb;
        StringBuilder append = sb2.append("NumericDate").append("{").append(getValue());
        if (canConvertToMillis()) {
            DateFormat df = DateFormat.getDateTimeInstance(2, 1);
            new Date(getValueInMillis());
            StringBuilder append2 = sb2.append(" -> ").append(df.format(date));
        }
        StringBuilder append3 = sb2.append('}');
        return sb2.toString();
    }

    public boolean equals(Object obj) {
        Object other = obj;
        return this == other || ((other instanceof NumericDate) && this.value == ((NumericDate) other).value);
    }

    public int hashCode() {
        return (int) (this.value ^ (this.value >>> 32));
    }
}
