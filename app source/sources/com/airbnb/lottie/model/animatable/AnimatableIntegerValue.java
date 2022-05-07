package com.airbnb.lottie.model.animatable;

import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.IntegerKeyframeAnimation;
import com.airbnb.lottie.value.Keyframe;
import java.util.List;

public class AnimatableIntegerValue extends BaseAnimatableValue<Integer, Integer> {
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
    public AnimatableIntegerValue() {
        super(100);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AnimatableIntegerValue(List<Keyframe<Integer>> keyframes) {
        super(keyframes);
    }

    public BaseKeyframeAnimation<Integer, Integer> createAnimation() {
        BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation;
        new IntegerKeyframeAnimation(this.keyframes);
        return baseKeyframeAnimation;
    }
}
