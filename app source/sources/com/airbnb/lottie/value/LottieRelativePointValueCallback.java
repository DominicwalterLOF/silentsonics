package com.airbnb.lottie.value;

import android.graphics.PointF;
import androidx.annotation.NonNull;
import com.airbnb.lottie.utils.MiscUtils;

public class LottieRelativePointValueCallback extends LottieValueCallback<PointF> {
    private final PointF point;

    public LottieRelativePointValueCallback() {
        PointF pointF;
        new PointF();
        this.point = pointF;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LottieRelativePointValueCallback(@NonNull PointF staticValue) {
        super(staticValue);
        PointF pointF;
        new PointF();
        this.point = pointF;
    }

    public final PointF getValue(LottieFrameInfo<PointF> lottieFrameInfo) {
        LottieFrameInfo<PointF> frameInfo = lottieFrameInfo;
        this.point.set(MiscUtils.lerp(frameInfo.getStartValue().x, frameInfo.getEndValue().x, frameInfo.getInterpolatedKeyframeProgress()), MiscUtils.lerp(frameInfo.getStartValue().y, frameInfo.getEndValue().y, frameInfo.getInterpolatedKeyframeProgress()));
        PointF offset = getOffset(frameInfo);
        this.point.offset(offset.x, offset.y);
        return this.point;
    }

    public PointF getOffset(LottieFrameInfo<PointF> lottieFrameInfo) {
        Throwable th;
        LottieFrameInfo<PointF> lottieFrameInfo2 = lottieFrameInfo;
        if (this.value != null) {
            return (PointF) this.value;
        }
        Throwable th2 = th;
        new IllegalArgumentException("You must provide a static value in the constructor , call setValue, or override getValue.");
        throw th2;
    }
}
