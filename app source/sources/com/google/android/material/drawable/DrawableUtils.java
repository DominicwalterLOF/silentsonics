package com.google.android.material.drawable;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class DrawableUtils {
    private DrawableUtils() {
    }

    @Nullable
    public static PorterDuffColorFilter updateTintFilter(Drawable drawable, @Nullable ColorStateList colorStateList, @Nullable PorterDuff.Mode mode) {
        PorterDuffColorFilter porterDuffColorFilter;
        Drawable drawable2 = drawable;
        ColorStateList tint = colorStateList;
        PorterDuff.Mode tintMode = mode;
        if (tint == null || tintMode == null) {
            return null;
        }
        new PorterDuffColorFilter(tint.getColorForState(drawable2.getState(), 0), tintMode);
        return porterDuffColorFilter;
    }
}
