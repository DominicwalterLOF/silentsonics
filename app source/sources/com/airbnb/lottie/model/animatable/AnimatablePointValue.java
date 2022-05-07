package com.airbnb.lottie.model.animatable;

import android.graphics.PointF;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.PointKeyframeAnimation;
import com.airbnb.lottie.value.Keyframe;
import java.util.List;

public class AnimatablePointValue extends BaseAnimatableValue<PointF, PointF> {
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
    public AnimatablePointValue(List<Keyframe<PointF>> keyframes) {
        super(keyframes);
    }

    public BaseKeyframeAnimation<PointF, PointF> createAnimation() {
        BaseKeyframeAnimation<PointF, PointF> baseKeyframeAnimation;
        new PointKeyframeAnimation(this.keyframes);
        return baseKeyframeAnimation;
    }
}
