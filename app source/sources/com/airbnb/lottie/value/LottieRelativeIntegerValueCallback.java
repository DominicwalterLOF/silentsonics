package com.airbnb.lottie.value;

import com.airbnb.lottie.utils.MiscUtils;

public class LottieRelativeIntegerValueCallback extends LottieValueCallback<Integer> {
    public LottieRelativeIntegerValueCallback() {
    }

    public Integer getValue(LottieFrameInfo<Integer> lottieFrameInfo) {
        LottieFrameInfo<Integer> frameInfo = lottieFrameInfo;
        return Integer.valueOf(MiscUtils.lerp(frameInfo.getStartValue().intValue(), frameInfo.getEndValue().intValue(), frameInfo.getInterpolatedKeyframeProgress()) + getOffset(frameInfo).intValue());
    }

    public Integer getOffset(LottieFrameInfo<Integer> lottieFrameInfo) {
        Throwable th;
        LottieFrameInfo<Integer> lottieFrameInfo2 = lottieFrameInfo;
        if (this.value != null) {
            return (Integer) this.value;
        }
        Throwable th2 = th;
        new IllegalArgumentException("You must provide a static value in the constructor , call setValue, or override getValue.");
        throw th2;
    }
}
