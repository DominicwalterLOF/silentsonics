package com.google.appinventor.components.runtime.util;

import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.util.Log;
import android.view.View;

public class KodularRippleDrawable {
    private KodularRippleDrawable() {
    }

    public static void setRippleDrawable(View view, int i, int i2) {
        Drawable drawable;
        View view2 = view;
        int i3 = i;
        try {
            new RippleDrawable(ColorStateList.valueOf(i2), view2.getBackground(), (Drawable) null);
            view2.setBackground(drawable);
        } catch (Exception e) {
            int e2 = Log.e("KodularRippleDrawable", String.valueOf(e));
        }
    }
}
