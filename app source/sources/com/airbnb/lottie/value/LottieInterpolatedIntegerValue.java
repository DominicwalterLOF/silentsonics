package com.airbnb.lottie.value;

import android.view.animation.Interpolator;
import com.airbnb.lottie.utils.MiscUtils;

public class LottieInterpolatedIntegerValue extends LottieInterpolatedValue<Integer> {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LottieInterpolatedIntegerValue(Integer startValue, Integer endValue) {
        super(startValue, endValue);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LottieInterpolatedIntegerValue(Integer startValue, Integer endValue, Interpolator interpolator) {
        super(startValue, endValue, interpolator);
    }

    /* access modifiers changed from: package-private */
    public Integer interpolateValue(Integer startValue, Integer endValue, float progress) {
        return Integer.valueOf(MiscUtils.lerp(startValue.intValue(), endValue.intValue(), progress));
    }
}
