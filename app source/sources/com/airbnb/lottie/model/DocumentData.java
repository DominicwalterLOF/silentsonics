package com.airbnb.lottie.model;

import androidx.annotation.ColorInt;
import androidx.annotation.RestrictTo;

@RestrictTo({RestrictTo.Scope.LIBRARY})
public class DocumentData {
    public final double baselineShift;
    @ColorInt
    public final int color;
    public final String fontName;
    public final Justification justification;
    public final double lineHeight;
    public final double size;
    @ColorInt
    public final int strokeColor;
    public final boolean strokeOverFill;
    public final double strokeWidth;
    public final String text;
    public final int tracking;

    public enum Justification {
    }

    public DocumentData(String text2, String fontName2, double size2, Justification justification2, int tracking2, double lineHeight2, double baselineShift2, @ColorInt int color2, @ColorInt int strokeColor2, double strokeWidth2, boolean strokeOverFill2) {
        this.text = text2;
        this.fontName = fontName2;
        this.size = size2;
        this.justification = justification2;
        this.tracking = tracking2;
        this.lineHeight = lineHeight2;
        this.baselineShift = baselineShift2;
        this.color = color2;
        this.strokeColor = strokeColor2;
        this.strokeWidth = strokeWidth2;
        this.strokeOverFill = strokeOverFill2;
    }

    public int hashCode() {
        int result = (31 * ((31 * ((int) (((double) (31 * ((31 * this.text.hashCode()) + this.fontName.hashCode()))) + this.size))) + this.justification.ordinal())) + this.tracking;
        long temp = Double.doubleToLongBits(this.lineHeight);
        return (31 * ((31 * result) + ((int) (temp ^ (temp >>> 32))))) + this.color;
    }
}
