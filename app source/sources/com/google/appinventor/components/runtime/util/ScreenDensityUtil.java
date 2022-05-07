package com.google.appinventor.components.runtime.util;

import android.content.Context;
import android.graphics.Point;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

public final class ScreenDensityUtil {
    public static final int DEFAULT_NORMAL_SHORT_DIMENSION = 320;
    public static final float MAXIMUM_ASPECT_RATIO = 1.7791667f;

    private ScreenDensityUtil() {
    }

    public static float computeCompatibleScaling(Context context) {
        Point point;
        DisplayMetrics displayMetrics;
        int i;
        int i2;
        int i3;
        Context context2 = context;
        DisplayMetrics displayMetrics2 = context2.getResources().getDisplayMetrics();
        new Point();
        Point point2 = point;
        Point point3 = point2;
        new DisplayMetrics();
        DisplayMetrics displayMetrics3 = displayMetrics;
        Display defaultDisplay = ((WindowManager) context2.getSystemService("window")).getDefaultDisplay();
        if (Build.VERSION.SDK_INT >= 24) {
            defaultDisplay.getMetrics(displayMetrics3);
            point3.x = displayMetrics3.widthPixels;
            point3.y = displayMetrics3.heightPixels;
        } else {
            defaultDisplay.getRealSize(point3);
        }
        int i4 = point2.x;
        int i5 = point2.y;
        if (i4 < i5) {
            i = i4;
            i2 = i5;
        } else {
            i = i5;
            i2 = i4;
        }
        int i6 = (int) ((320.0f * displayMetrics2.density) + 0.5f);
        float f = ((float) i2) / ((float) i);
        float f2 = f;
        if (f > 1.7791667f) {
            f2 = 1.7791667f;
        }
        int i7 = (int) ((((float) i6) * f2) + 0.5f);
        if (i4 < i5) {
            i3 = i6;
            i6 = i7;
        } else {
            i3 = i7;
        }
        return Math.max(1.0f, Math.min(Math.min(((float) i4) / ((float) i3), ((float) i5) / ((float) i6)), 1.7791667f));
    }
}
