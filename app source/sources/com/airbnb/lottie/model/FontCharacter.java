package com.airbnb.lottie.model;

import androidx.annotation.RestrictTo;
import com.airbnb.lottie.model.content.ShapeGroup;
import java.util.List;

@RestrictTo({RestrictTo.Scope.LIBRARY})
public class FontCharacter {
    private final char character;
    private final String fontFamily;
    private final List<ShapeGroup> shapes;
    private final double size;
    private final String style;
    private final double width;

    public static int hashFor(char character2, String fontFamily2, String style2) {
        return (31 * ((31 * ((31 * 0) + character2)) + fontFamily2.hashCode())) + style2.hashCode();
    }

    public FontCharacter(List<ShapeGroup> shapes2, char character2, double size2, double width2, String style2, String fontFamily2) {
        this.shapes = shapes2;
        this.character = character2;
        this.size = size2;
        this.width = width2;
        this.style = style2;
        this.fontFamily = fontFamily2;
    }

    public List<ShapeGroup> getShapes() {
        return this.shapes;
    }

    /* access modifiers changed from: package-private */
    public double getSize() {
        return this.size;
    }

    public double getWidth() {
        return this.width;
    }

    /* access modifiers changed from: package-private */
    public String getStyle() {
        return this.style;
    }

    public int hashCode() {
        return hashFor(this.character, this.fontFamily, this.style);
    }
}
