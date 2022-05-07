package com.airbnb.lottie.model.animatable;

import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.GradientColorKeyframeAnimation;
import com.airbnb.lottie.model.content.GradientColor;
import com.airbnb.lottie.value.Keyframe;
import java.util.List;

public class AnimatableGradientColorValue extends BaseAnimatableValue<GradientColor, GradientColor> {
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
    public AnimatableGradientColorValue(List<Keyframe<GradientColor>> keyframes) {
        super(keyframes);
    }

    public BaseKeyframeAnimation<GradientColor, GradientColor> createAnimation() {
        BaseKeyframeAnimation<GradientColor, GradientColor> baseKeyframeAnimation;
        new GradientColorKeyframeAnimation(this.keyframes);
        return baseKeyframeAnimation;
    }
}
