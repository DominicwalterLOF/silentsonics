package com.airbnb.lottie.value;

import androidx.annotation.RestrictTo;

public class LottieFrameInfo<T> {
    private float endFrame;
    private T endValue;
    private float interpolatedKeyframeProgress;
    private float linearKeyframeProgress;
    private float overallProgress;
    private float startFrame;
    private T startValue;

    public LottieFrameInfo() {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public LottieFrameInfo<T> set(float startFrame2, float endFrame2, T startValue2, T endValue2, float linearKeyframeProgress2, float interpolatedKeyframeProgress2, float overallProgress2) {
        this.startFrame = startFrame2;
        this.endFrame = endFrame2;
        this.startValue = startValue2;
        this.endValue = endValue2;
        this.linearKeyframeProgress = linearKeyframeProgress2;
        this.interpolatedKeyframeProgress = interpolatedKeyframeProgress2;
        this.overallProgress = overallProgress2;
        return this;
    }

    public float getStartFrame() {
        return this.startFrame;
    }

    public float getEndFrame() {
        return this.endFrame;
    }

    public T getStartValue() {
        return this.startValue;
    }

    public T getEndValue() {
        return this.endValue;
    }

    public float getLinearKeyframeProgress() {
        return this.linearKeyframeProgress;
    }

    public float getInterpolatedKeyframeProgress() {
        return this.interpolatedKeyframeProgress;
    }

    public float getOverallProgress() {
        return this.overallProgress;
    }
}
