package com.airbnb.lottie.value;

import android.graphics.PointF;
import android.view.animation.Interpolator;
import com.airbnb.lottie.utils.MiscUtils;

public class LottieInterpolatedPointValue extends LottieInterpolatedValue<PointF> {
    private final PointF point;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LottieInterpolatedPointValue(PointF startValue, PointF endValue) {
        super(startValue, endValue);
        PointF pointF;
        new PointF();
        this.point = pointF;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LottieInterpolatedPointValue(PointF startValue, PointF endValue, Interpolator interpolator) {
        super(startValue, endValue, interpolator);
        PointF pointF;
        new PointF();
        this.point = pointF;
    }

    /* access modifiers changed from: package-private */
    public PointF interpolateValue(PointF pointF, PointF pointF2, float f) {
        PointF startValue = pointF;
        PointF endValue = pointF2;
        float progress = f;
        this.point.set(MiscUtils.lerp(startValue.x, endValue.x, progress), MiscUtils.lerp(startValue.y, endValue.y, progress));
        return this.point;
    }
}
