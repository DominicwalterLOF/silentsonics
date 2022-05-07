package com.google.android.material.animation;

import android.animation.TimeInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import androidx.annotation.RestrictTo;
import androidx.interpolator.view.animation.FastOutLinearInInterpolator;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import androidx.interpolator.view.animation.LinearOutSlowInInterpolator;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class AnimationUtils {
    public static final TimeInterpolator DECELERATE_INTERPOLATOR;
    public static final TimeInterpolator FAST_OUT_LINEAR_IN_INTERPOLATOR;
    public static final TimeInterpolator FAST_OUT_SLOW_IN_INTERPOLATOR;
    public static final TimeInterpolator LINEAR_INTERPOLATOR;
    public static final TimeInterpolator LINEAR_OUT_SLOW_IN_INTERPOLATOR;

    public AnimationUtils() {
    }

    static {
        TimeInterpolator timeInterpolator;
        TimeInterpolator timeInterpolator2;
        TimeInterpolator timeInterpolator3;
        TimeInterpolator timeInterpolator4;
        TimeInterpolator timeInterpolator5;
        new LinearInterpolator();
        LINEAR_INTERPOLATOR = timeInterpolator;
        new FastOutSlowInInterpolator();
        FAST_OUT_SLOW_IN_INTERPOLATOR = timeInterpolator2;
        new FastOutLinearInInterpolator();
        FAST_OUT_LINEAR_IN_INTERPOLATOR = timeInterpolator3;
        new LinearOutSlowInInterpolator();
        LINEAR_OUT_SLOW_IN_INTERPOLATOR = timeInterpolator4;
        new DecelerateInterpolator();
        DECELERATE_INTERPOLATOR = timeInterpolator5;
    }

    public static float lerp(float f, float endValue, float fraction) {
        float startValue = f;
        return startValue + (fraction * (endValue - startValue));
    }

    public static int lerp(int i, int endValue, float fraction) {
        int startValue = i;
        return startValue + Math.round(fraction * ((float) (endValue - startValue)));
    }
}
