package com.airbnb.lottie.model.animatable;

import android.graphics.PointF;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.SplitDimensionPathKeyframeAnimation;
import com.airbnb.lottie.value.Keyframe;
import java.util.List;

public class AnimatableSplitDimensionPathValue implements AnimatableValue<PointF, PointF> {
    private final AnimatableFloatValue animatableXDimension;
    private final AnimatableFloatValue animatableYDimension;

    public AnimatableSplitDimensionPathValue(AnimatableFloatValue animatableXDimension2, AnimatableFloatValue animatableYDimension2) {
        this.animatableXDimension = animatableXDimension2;
        this.animatableYDimension = animatableYDimension2;
    }

    public List<Keyframe<PointF>> getKeyframes() {
        Throwable th;
        Throwable th2 = th;
        new UnsupportedOperationException("Cannot call getKeyframes on AnimatableSplitDimensionPathValue.");
        throw th2;
    }

    public boolean isStatic() {
        return this.animatableXDimension.isStatic() && this.animatableYDimension.isStatic();
    }

    public BaseKeyframeAnimation<PointF, PointF> createAnimation() {
        BaseKeyframeAnimation<PointF, PointF> baseKeyframeAnimation;
        new SplitDimensionPathKeyframeAnimation(this.animatableXDimension.createAnimation(), this.animatableYDimension.createAnimation());
        return baseKeyframeAnimation;
    }
}
