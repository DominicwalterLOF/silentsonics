package com.airbnb.lottie.model;

import androidx.annotation.RestrictTo;

@RestrictTo({RestrictTo.Scope.LIBRARY})
public class Font {
    private final float ascent;
    private final String family;
    private final String name;
    private final String style;

    public Font(String family2, String name2, String style2, float ascent2) {
        this.family = family2;
        this.name = name2;
        this.style = style2;
        this.ascent = ascent2;
    }

    public String getFamily() {
        return this.family;
    }

    public String getName() {
        return this.name;
    }

    public String getStyle() {
        return this.style;
    }

    /* access modifiers changed from: package-private */
    public float getAscent() {
        return this.ascent;
    }
}
