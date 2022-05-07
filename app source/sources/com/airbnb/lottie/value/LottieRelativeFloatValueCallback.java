package com.airbnb.lottie.value;

import androidx.annotation.NonNull;
import com.airbnb.lottie.utils.MiscUtils;

public class LottieRelativeFloatValueCallback extends LottieValueCallback<Float> {
    public LottieRelativeFloatValueCallback() {
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LottieRelativeFloatValueCallback(@NonNull Float staticValue) {
        super(staticValue);
    }

    public Float getValue(LottieFrameInfo<Float> lottieFrameInfo) {
        LottieFrameInfo<Float> frameInfo = lottieFrameInfo;
        return Float.valueOf(MiscUtils.lerp(frameInfo.getStartValue().floatValue(), frameInfo.getEndValue().floatValue(), frameInfo.getInterpolatedKeyframeProgress()) + getOffset(frameInfo).floatValue());
    }

    public Float getOffset(LottieFrameInfo<Float> lottieFrameInfo) {
        Throwable th;
        LottieFrameInfo<Float> lottieFrameInfo2 = lottieFrameInfo;
        if (this.value != null) {
            return (Float) this.value;
        }
        Throwable th2 = th;
        new IllegalArgumentException("You must provide a static value in the constructor , call setValue, or override getValue.");
        throw th2;
    }
}
