package com.airbnb.lottie.value;

import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;

public class LottieValueCallback<T> {
    @Nullable
    private BaseKeyframeAnimation<?, ?> animation;
    private final LottieFrameInfo<T> frameInfo;
    @Nullable
    protected T value = null;

    public LottieValueCallback() {
        LottieFrameInfo<T> lottieFrameInfo;
        new LottieFrameInfo<>();
        this.frameInfo = lottieFrameInfo;
    }

    public LottieValueCallback(@Nullable T staticValue) {
        LottieFrameInfo<T> lottieFrameInfo;
        new LottieFrameInfo<>();
        this.frameInfo = lottieFrameInfo;
        this.value = staticValue;
    }

    @Nullable
    public T getValue(LottieFrameInfo<T> lottieFrameInfo) {
        LottieFrameInfo<T> lottieFrameInfo2 = lottieFrameInfo;
        return this.value;
    }

    public final void setValue(@Nullable T value2) {
        this.value = value2;
        if (this.animation != null) {
            this.animation.notifyListeners();
        }
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public final T getValueInternal(float startFrame, float endFrame, T startValue, T endValue, float linearKeyframeProgress, float interpolatedKeyframeProgress, float overallProgress) {
        return getValue(this.frameInfo.set(startFrame, endFrame, startValue, endValue, linearKeyframeProgress, interpolatedKeyframeProgress, overallProgress));
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public final void setAnimation(@Nullable BaseKeyframeAnimation<?, ?> animation2) {
        BaseKeyframeAnimation<?, ?> baseKeyframeAnimation = animation2;
        this.animation = baseKeyframeAnimation;
    }
}
