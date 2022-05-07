package com.airbnb.lottie.value;

import android.view.animation.Interpolator;

abstract class LottieInterpolatedValue<T> extends LottieValueCallback<T> {
    private final T endValue;
    private final Interpolator interpolator;
    private final T startValue;

    /* access modifiers changed from: package-private */
    public abstract T interpolateValue(T t, T t2, float f);

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    LottieInterpolatedValue(T r10, T r11) {
        /*
            r9 = this;
            r0 = r9
            r1 = r10
            r2 = r11
            r3 = r0
            r4 = r1
            r5 = r2
            android.view.animation.LinearInterpolator r6 = new android.view.animation.LinearInterpolator
            r8 = r6
            r6 = r8
            r7 = r8
            r7.<init>()
            r3.<init>(r4, r5, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.value.LottieInterpolatedValue.<init>(java.lang.Object, java.lang.Object):void");
    }

    LottieInterpolatedValue(T startValue2, T endValue2, Interpolator interpolator2) {
        this.startValue = startValue2;
        this.endValue = endValue2;
        this.interpolator = interpolator2;
    }

    public T getValue(LottieFrameInfo<T> frameInfo) {
        return interpolateValue(this.startValue, this.endValue, this.interpolator.getInterpolation(frameInfo.getOverallProgress()));
    }
}
