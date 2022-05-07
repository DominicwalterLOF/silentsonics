package com.google.android.material.card;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.ColorInt;
import androidx.annotation.Dimension;
import androidx.cardview.widget.C0002CardView;
import com.google.android.material.R;

public class MaterialCardView extends C0002CardView {
    private final MaterialCardViewHelper cardViewHelper;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public MaterialCardView(Context context) {
        this(context, (AttributeSet) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public MaterialCardView(Context context, AttributeSet attrs) {
        this(context, attrs, R.attr.materialCardViewStyle);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public MaterialCardView(android.content.Context r13, android.util.AttributeSet r14, int r15) {
        /*
            r12 = this;
            r0 = r12
            r1 = r13
            r2 = r14
            r3 = r15
            r5 = r0
            r6 = r1
            r7 = r2
            r8 = r3
            r5.<init>(r6, r7, r8)
            r5 = r1
            r6 = r2
            int[] r7 = com.google.android.material.R.styleable.MaterialCardView
            r8 = r3
            int r9 = com.google.android.material.R.style.Widget_MaterialComponents_CardView
            r10 = 0
            int[] r10 = new int[r10]
            android.content.res.TypedArray r5 = com.google.android.material.internal.ThemeEnforcement.obtainStyledAttributes(r5, r6, r7, r8, r9, r10)
            r4 = r5
            r5 = r0
            com.google.android.material.card.MaterialCardViewHelper r6 = new com.google.android.material.card.MaterialCardViewHelper
            r11 = r6
            r6 = r11
            r7 = r11
            r8 = r0
            r7.<init>(r8)
            r5.cardViewHelper = r6
            r5 = r0
            com.google.android.material.card.MaterialCardViewHelper r5 = r5.cardViewHelper
            r6 = r4
            r5.loadFromAttributes(r6)
            r5 = r4
            r5.recycle()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.card.MaterialCardView.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    public void setStrokeColor(@ColorInt int strokeColor) {
        this.cardViewHelper.setStrokeColor(strokeColor);
    }

    @ColorInt
    public int getStrokeColor() {
        return this.cardViewHelper.getStrokeColor();
    }

    public void setStrokeWidth(@Dimension int strokeWidth) {
        this.cardViewHelper.setStrokeWidth(strokeWidth);
    }

    @Dimension
    public int getStrokeWidth() {
        return this.cardViewHelper.getStrokeWidth();
    }

    public void setRadius(float radius) {
        super.setRadius(radius);
        this.cardViewHelper.updateForeground();
    }
}
