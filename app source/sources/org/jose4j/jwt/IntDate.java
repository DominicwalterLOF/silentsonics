package org.jose4j.jwt;

import java.util.Date;

public class IntDate {
    private static final long CONVERSION = 1000;
    private long value;

    private IntDate(long value2) {
        this.value = value2;
    }

    public static IntDate now() {
        return fromMillis(System.currentTimeMillis());
    }

    public static IntDate fromSeconds(long secondsFromEpoch) {
        IntDate intDate;
        new IntDate(secondsFromEpoch);
        return intDate;
    }

    public static IntDate fromMillis(long millisecondsFromEpoch) {
        return fromSeconds(millisecondsFromEpoch / 1000);
    }

    public void addSeconds(long seconds) {
        this.value += seconds;
    }

    public void addSeconds(int seconds) {
        addSeconds((long) seconds);
    }

    public long getValue() {
        return this.value;
    }

    public long getValueInMillis() {
        return getValue() * 1000;
    }

    public boolean before(IntDate when) {
        return this.value < when.getValue();
    }

    public boolean after(IntDate when) {
        return this.value > when.getValue();
    }

    public String toString() {
        StringBuilder sb;
        Object obj;
        new StringBuilder();
        StringBuilder sb2 = sb;
        StringBuilder append = sb2.append("IntDate");
        StringBuilder append2 = sb2.append("{").append(getValue()).append(" --> ");
        new Date(getValueInMillis());
        StringBuilder append3 = sb2.append(obj);
        StringBuilder append4 = sb2.append('}');
        return sb2.toString();
    }

    public boolean equals(Object obj) {
        Object other = obj;
        return this == other || ((other instanceof IntDate) && this.value == ((IntDate) other).value);
    }

    public int hashCode() {
        return (int) (this.value ^ (this.value >>> 32));
    }
}
