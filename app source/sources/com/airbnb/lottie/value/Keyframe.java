package com.airbnb.lottie.value;

import android.graphics.PointF;
import android.view.animation.Interpolator;
import androidx.annotation.FloatRange;
import androidx.annotation.Nullable;
import com.airbnb.lottie.LottieComposition;

public class Keyframe<T> {
    private static final float UNSET_FLOAT = -3987645.8f;
    private static final int UNSET_INT = 784923401;
    @Nullable
    private final LottieComposition composition;
    @Nullable
    public Float endFrame;
    private float endProgress;
    @Nullable
    public T endValue;
    private float endValueFloat;
    private int endValueInt;
    @Nullable
    public final Interpolator interpolator;
    public PointF pathCp1;
    public PointF pathCp2;
    public final float startFrame;
    private float startProgress;
    @Nullable
    public final T startValue;
    private float startValueFloat;
    private int startValueInt;

    public Keyframe(LottieComposition composition2, @Nullable T startValue2, @Nullable T endValue2, @Nullable Interpolator interpolator2, float startFrame2, @Nullable Float endFrame2) {
        this.startValueFloat = UNSET_FLOAT;
        this.endValueFloat = UNSET_FLOAT;
        this.startValueInt = UNSET_INT;
        this.endValueInt = UNSET_INT;
        this.startProgress = Float.MIN_VALUE;
        this.endProgress = Float.MIN_VALUE;
        this.pathCp1 = null;
        this.pathCp2 = null;
        this.composition = composition2;
        this.startValue = startValue2;
        this.endValue = endValue2;
        this.interpolator = interpolator2;
        this.startFrame = startFrame2;
        this.endFrame = endFrame2;
    }

    public Keyframe(T t) {
        T value = t;
        this.startValueFloat = UNSET_FLOAT;
        this.endValueFloat = UNSET_FLOAT;
        this.startValueInt = UNSET_INT;
        this.endValueInt = UNSET_INT;
        this.startProgress = Float.MIN_VALUE;
        this.endProgress = Float.MIN_VALUE;
        this.pathCp1 = null;
        this.pathCp2 = null;
        this.composition = null;
        this.startValue = value;
        this.endValue = value;
        this.interpolator = null;
        this.startFrame = Float.MIN_VALUE;
        this.endFrame = Float.valueOf(Float.MAX_VALUE);
    }

    public float getStartProgress() {
        if (this.composition == null) {
            return 0.0f;
        }
        if (this.startProgress == Float.MIN_VALUE) {
            this.startProgress = (this.startFrame - this.composition.getStartFrame()) / this.composition.getDurationFrames();
        }
        return this.startProgress;
    }

    public float getEndProgress() {
        if (this.composition == null) {
            return 1.0f;
        }
        if (this.endProgress == Float.MIN_VALUE) {
            if (this.endFrame == null) {
                this.endProgress = 1.0f;
            } else {
                this.endProgress = getStartProgress() + ((this.endFrame.floatValue() - this.startFrame) / this.composition.getDurationFrames());
            }
        }
        return this.endProgress;
    }

    public boolean isStatic() {
        return this.interpolator == null;
    }

    public boolean containsProgress(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        float progress = f;
        return progress >= getStartProgress() && progress < getEndProgress();
    }

    public float getStartValueFloat() {
        if (this.startValueFloat == UNSET_FLOAT) {
            this.startValueFloat = ((Float) this.startValue).floatValue();
        }
        return this.startValueFloat;
    }

    public float getEndValueFloat() {
        if (this.endValueFloat == UNSET_FLOAT) {
            this.endValueFloat = ((Float) this.endValue).floatValue();
        }
        return this.endValueFloat;
    }

    public int getStartValueInt() {
        if (this.startValueInt == UNSET_INT) {
            this.startValueInt = ((Integer) this.startValue).intValue();
        }
        return this.startValueInt;
    }

    public int getEndValueInt() {
        if (this.endValueInt == UNSET_INT) {
            this.endValueInt = ((Integer) this.endValue).intValue();
        }
        return this.endValueInt;
    }

    public String toString() {
        StringBuilder sb;
        new StringBuilder();
        return sb.append("Keyframe{startValue=").append(this.startValue).append(", endValue=").append(this.endValue).append(", startFrame=").append(this.startFrame).append(", endFrame=").append(this.endFrame).append(", interpolator=").append(this.interpolator).append('}').toString();
    }
}
