package com.airbnb.lottie.animation.keyframe;

import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.Keyframe;
import java.util.List;

public class IntegerKeyframeAnimation extends KeyframeAnimation<Integer> {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public IntegerKeyframeAnimation(List<Keyframe<Integer>> keyframes) {
        super(keyframes);
    }

    /* access modifiers changed from: package-private */
    public Integer getValue(Keyframe<Integer> keyframe, float keyframeProgress) {
        return Integer.valueOf(getIntValue(keyframe, keyframeProgress));
    }

    /* access modifiers changed from: package-private */
    public int getIntValue(Keyframe<Integer> keyframe, float f) {
        Throwable th;
        Integer value;
        Keyframe<Integer> keyframe2 = keyframe;
        float keyframeProgress = f;
        if (keyframe2.startValue == null || keyframe2.endValue == null) {
            Throwable th2 = th;
            new IllegalStateException("Missing values for keyframe.");
            throw th2;
        } else if (this.valueCallback == null || (value = (Integer) this.valueCallback.getValueInternal(keyframe2.startFrame, keyframe2.endFrame.floatValue(), keyframe2.startValue, keyframe2.endValue, keyframeProgress, getLinearCurrentKeyframeProgress(), getProgress())) == null) {
            return MiscUtils.lerp(keyframe2.getStartValueInt(), keyframe2.getEndValueInt(), keyframeProgress);
        } else {
            return value.intValue();
        }
    }

    public int getIntValue() {
        return getIntValue(getCurrentKeyframe(), getInterpolatedCurrentKeyframeProgress());
    }
}
