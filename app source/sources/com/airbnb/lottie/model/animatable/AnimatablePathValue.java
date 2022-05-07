package com.airbnb.lottie.model.animatable;

import android.graphics.PointF;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.PathKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.PointKeyframeAnimation;
import com.airbnb.lottie.value.Keyframe;
import java.util.Collections;
import java.util.List;

public class AnimatablePathValue implements AnimatableValue<PointF, PointF> {
    private final List<Keyframe<PointF>> keyframes;

    public AnimatablePathValue() {
        Object obj;
        Object obj2;
        new PointF(0.0f, 0.0f);
        new Keyframe(obj2);
        this.keyframes = Collections.singletonList(obj);
    }

    public AnimatablePathValue(List<Keyframe<PointF>> keyframes2) {
        this.keyframes = keyframes2;
    }

    public List<Keyframe<PointF>> getKeyframes() {
        return this.keyframes;
    }

    public boolean isStatic() {
        return this.keyframes.size() == 1 && this.keyframes.get(0).isStatic();
    }

    public BaseKeyframeAnimation<PointF, PointF> createAnimation() {
        BaseKeyframeAnimation<PointF, PointF> baseKeyframeAnimation;
        BaseKeyframeAnimation<PointF, PointF> baseKeyframeAnimation2;
        if (this.keyframes.get(0).isStatic()) {
            new PointKeyframeAnimation(this.keyframes);
            return baseKeyframeAnimation2;
        }
        new PathKeyframeAnimation(this.keyframes);
        return baseKeyframeAnimation;
    }
}
