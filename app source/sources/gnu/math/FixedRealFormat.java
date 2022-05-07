package gnu.math;

import java.text.FieldPosition;
import java.text.Format;
import java.text.ParsePosition;

public class FixedRealFormat extends Format {
    private int d;
    private int i;
    public boolean internalPad;
    public char overflowChar;
    public char padChar;
    public int scale;
    public boolean showPlus;
    public int width;

    public FixedRealFormat() {
    }

    public int getMaximumFractionDigits() {
        return this.d;
    }

    public int getMinimumIntegerDigits() {
        return this.i;
    }

    public void setMaximumFractionDigits(int d2) {
        int i2 = d2;
        this.d = i2;
    }

    public void setMinimumIntegerDigits(int i2) {
        int i3 = i2;
        this.i = i3;
    }

    public void format(RealNum realNum, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        RealNum number = realNum;
        StringBuffer sbuf = stringBuffer;
        FieldPosition fpos = fieldPosition;
        if (number instanceof RatNum) {
            int maximumFractionDigits = getMaximumFractionDigits();
            int decimals = maximumFractionDigits;
            if (maximumFractionDigits >= 0) {
                RatNum ratnum = (RatNum) number;
                boolean negative = ratnum.isNegative();
                if (negative) {
                    ratnum = ratnum.rneg();
                }
                int oldSize = sbuf.length();
                int signLen = 1;
                if (negative) {
                    StringBuffer append = sbuf.append('-');
                } else if (this.showPlus) {
                    StringBuffer append2 = sbuf.append('+');
                } else {
                    signLen = 0;
                }
                String string = RealNum.toScaledInt(ratnum, decimals + this.scale).toString();
                StringBuffer append3 = sbuf.append(string);
                int length = string.length();
                format(sbuf, fpos, length, length - decimals, decimals, signLen, oldSize);
                return;
            }
        }
        StringBuffer format = format(number.doubleValue(), sbuf, fpos);
    }

    public StringBuffer format(long num, StringBuffer stringBuffer, FieldPosition fpos) {
        StringBuffer sbuf = stringBuffer;
        format((RealNum) IntNum.make(num), sbuf, fpos);
        return sbuf;
    }

    public StringBuffer format(double d2, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        boolean negative;
        int decimals;
        char nextDigit;
        StringBuilder sb;
        double num = d2;
        StringBuffer sbuf = stringBuffer;
        FieldPosition fpos = fieldPosition;
        if (Double.isNaN(num) || Double.isInfinite(num)) {
            return sbuf.append(num);
        }
        if (getMaximumFractionDigits() >= 0) {
            format((RealNum) DFloNum.toExact(num), sbuf, fpos);
        } else {
            if (num < 0.0d) {
                negative = true;
                num = -num;
            } else {
                negative = false;
            }
            int oldSize = sbuf.length();
            int signLen = 1;
            if (negative) {
                StringBuffer append = sbuf.append('-');
            } else {
                if (this.showPlus) {
                    StringBuffer append2 = sbuf.append('+');
                } else {
                    signLen = 0;
                }
            }
            String string = Double.toString(num);
            int cur_scale = this.scale;
            int seenE = string.indexOf(69);
            if (seenE >= 0) {
                int expStart = seenE + 1;
                if (string.charAt(expStart) == '+') {
                    expStart++;
                }
                cur_scale += Integer.parseInt(string.substring(expStart));
                string = string.substring(0, seenE);
            }
            int seenDot = string.indexOf(46);
            int length = string.length();
            if (seenDot >= 0) {
                cur_scale -= (length - seenDot) - 1;
                int length2 = length - 1;
                new StringBuilder();
                string = sb.append(string.substring(0, seenDot)).append(string.substring(seenDot + 1)).toString();
            }
            int i2 = string.length();
            int initial_zeros = 0;
            while (initial_zeros < i2 - 1 && string.charAt(initial_zeros) == '0') {
                initial_zeros++;
            }
            if (initial_zeros > 0) {
                string = string.substring(initial_zeros);
                i2 -= initial_zeros;
            }
            int digits = i2 + cur_scale;
            if (this.width > 0) {
                while (digits < 0) {
                    StringBuffer append3 = sbuf.append('0');
                    digits++;
                    i2++;
                }
                decimals = ((this.width - signLen) - 1) - digits;
            } else {
                decimals = (i2 > 16 ? 16 : i2) - digits;
            }
            if (decimals < 0) {
                decimals = 0;
            }
            StringBuffer append4 = sbuf.append(string);
            while (cur_scale > 0) {
                StringBuffer append5 = sbuf.append('0');
                cur_scale--;
                i2++;
            }
            int digStart = oldSize + signLen;
            int digEnd = digStart + digits + decimals;
            int i3 = sbuf.length();
            if (digEnd >= i3) {
                digEnd = i3;
                nextDigit = '0';
            } else {
                nextDigit = sbuf.charAt(digEnd);
            }
            boolean addOne = nextDigit >= '5';
            char skip = addOne ? '9' : '0';
            while (digEnd > digStart + digits && sbuf.charAt(digEnd - 1) == skip) {
                digEnd--;
            }
            int length3 = digEnd - digStart;
            int decimals2 = length3 - digits;
            if (addOne && ExponentialFormat.addOne(sbuf, digStart, digEnd)) {
                digits++;
                decimals2 = 0;
                length3 = digits;
            }
            if (decimals2 == 0) {
                if (this.width <= 0 || signLen + digits + 1 < this.width) {
                    decimals2 = 1;
                    length3++;
                    StringBuffer insert = sbuf.insert(digStart + digits, '0');
                }
            }
            sbuf.setLength(digStart + length3);
            format(sbuf, fpos, length3, digits, decimals2, negative ? 1 : 0, oldSize);
        }
        return sbuf;
    }

    public StringBuffer format(Object obj, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        Object num = obj;
        StringBuffer sbuf = stringBuffer;
        FieldPosition fpos = fieldPosition;
        RealNum rnum = RealNum.asRealNumOrNull(num);
        if (rnum == null) {
            if (num instanceof Complex) {
                String str = num.toString();
                int padding = this.width - str.length();
                while (true) {
                    padding--;
                    if (padding >= 0) {
                        StringBuffer append = sbuf.append(' ');
                    } else {
                        StringBuffer append2 = sbuf.append(str);
                        return sbuf;
                    }
                }
            } else {
                rnum = (RealNum) num;
            }
        }
        return format(rnum.doubleValue(), sbuf, fpos);
    }

    private void format(StringBuffer stringBuffer, FieldPosition fieldPosition, int i2, int i3, int i4, int i5, int i6) {
        int zero_digits;
        StringBuffer sbuf = stringBuffer;
        FieldPosition fieldPosition2 = fieldPosition;
        int length = i2;
        int digits = i3;
        int decimals = i4;
        int signLen = i5;
        int oldSize = i6;
        int i7 = digits + decimals;
        int zero_digits2 = getMinimumIntegerDigits();
        if (digits < 0 || digits <= zero_digits2) {
            zero_digits = zero_digits2 - digits;
        } else {
            zero_digits = 0;
        }
        if (digits + zero_digits <= 0 && (this.width <= 0 || this.width > decimals + 1 + signLen)) {
            zero_digits++;
        }
        int padding = this.width - (((signLen + length) + zero_digits) + 1);
        int i8 = zero_digits;
        while (true) {
            i8--;
            if (i8 < 0) {
                break;
            }
            StringBuffer insert = sbuf.insert(oldSize + signLen, '0');
        }
        if (padding >= 0) {
            int i9 = oldSize;
            if (this.internalPad && signLen > 0) {
                i9++;
            }
            while (true) {
                padding--;
                if (padding < 0) {
                    break;
                }
                StringBuffer insert2 = sbuf.insert(i9, this.padChar);
            }
        } else if (this.overflowChar != 0) {
            sbuf.setLength(oldSize);
            this.i = this.width;
            while (true) {
                int i10 = this.i - 1;
                int i11 = i10;
                this.i = i10;
                if (i11 >= 0) {
                    StringBuffer append = sbuf.append(this.overflowChar);
                } else {
                    return;
                }
            }
        }
        StringBuffer insert3 = sbuf.insert(sbuf.length() - decimals, '.');
    }

    public Number parse(String str, ParsePosition parsePosition) {
        Throwable th;
        String str2 = str;
        ParsePosition parsePosition2 = parsePosition;
        Throwable th2 = th;
        new Error("RealFixedFormat.parse - not implemented");
        throw th2;
    }

    public Object parseObject(String str, ParsePosition parsePosition) {
        Throwable th;
        String str2 = str;
        ParsePosition parsePosition2 = parsePosition;
        Throwable th2 = th;
        new Error("RealFixedFormat.parseObject - not implemented");
        throw th2;
    }
}
