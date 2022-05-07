package com.airbnb.lottie.model.animatable;

import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.FloatKeyframeAnimation;
import com.airbnb.lottie.value.Keyframe;
import java.util.List;

public class AnimatableFloatValue extends BaseAnimatableValue<Float, Float> {
    public /* bridge */ /* synthetic */ List getKeyframes() {
        return super.getKeyframes();
    }

    public /* bridge */ /* synthetic */ boolean isStatic() {
        return super.isStatic();
    }

    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AnimatableFloatValue() {
        super(Float.valueOf(0.0f));
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AnimatableFloatValue(List<Keyframe<Float>> keyframes) {
        super(keyframes);
    }

    public BaseKeyframeAnimation<Float, Float> createAnimation() {
        BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation;
        new FloatKeyframeAnimation(this.keyframes);
        return baseKeyframeAnimation;
    }
}
