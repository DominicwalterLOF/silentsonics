package com.airbnb.lottie;

import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import androidx.annotation.ColorInt;

public class SimpleColorFilter extends PorterDuffColorFilter {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SimpleColorFilter(@ColorInt int color) {
        super(color, PorterDuff.Mode.SRC_ATOP);
    }
}
