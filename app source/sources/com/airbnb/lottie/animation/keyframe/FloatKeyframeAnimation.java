package com.airbnb.lottie.animation.keyframe;

import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.Keyframe;
import java.util.List;

public class FloatKeyframeAnimation extends KeyframeAnimation<Float> {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FloatKeyframeAnimation(List<Keyframe<Float>> keyframes) {
        super(keyframes);
    }

    /* access modifiers changed from: package-private */
    public Float getValue(Keyframe<Float> keyframe, float keyframeProgress) {
        return Float.valueOf(getFloatValue(keyframe, keyframeProgress));
    }

    /* access modifiers changed from: package-private */
    public float getFloatValue(Keyframe<Float> keyframe, float f) {
        Throwable th;
        Float value;
        Keyframe<Float> keyframe2 = keyframe;
        float keyframeProgress = f;
        if (keyframe2.startValue == null || keyframe2.endValue == null) {
            Throwable th2 = th;
            new IllegalStateException("Missing values for keyframe.");
            throw th2;
        } else if (this.valueCallback == null || (value = (Float) this.valueCallback.getValueInternal(keyframe2.startFrame, keyframe2.endFrame.floatValue(), keyframe2.startValue, keyframe2.endValue, keyframeProgress, getLinearCurrentKeyframeProgress(), getProgress())) == null) {
            return MiscUtils.lerp(keyframe2.getStartValueFloat(), keyframe2.getEndValueFloat(), keyframeProgress);
        } else {
            return value.floatValue();
        }
    }

    public float getFloatValue() {
        return getFloatValue(getCurrentKeyframe(), getInterpolatedCurrentKeyframeProgress());
    }
}
