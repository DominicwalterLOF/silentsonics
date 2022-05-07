package com.airbnb.lottie.animation.keyframe;

import android.graphics.PointF;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.value.Keyframe;
import java.util.Collections;

public class SplitDimensionPathKeyframeAnimation extends BaseKeyframeAnimation<PointF, PointF> {
    private final PointF point;
    private final BaseKeyframeAnimation<Float, Float> xAnimation;
    private final BaseKeyframeAnimation<Float, Float> yAnimation;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SplitDimensionPathKeyframeAnimation(BaseKeyframeAnimation<Float, Float> xAnimation2, BaseKeyframeAnimation<Float, Float> yAnimation2) {
        super(Collections.emptyList());
        PointF pointF;
        new PointF();
        this.point = pointF;
        this.xAnimation = xAnimation2;
        this.yAnimation = yAnimation2;
        setProgress(getProgress());
    }

    public void setProgress(float f) {
        float progress = f;
        this.xAnimation.setProgress(progress);
        this.yAnimation.setProgress(progress);
        this.point.set(this.xAnimation.getValue().floatValue(), this.yAnimation.getValue().floatValue());
        for (int i = 0; i < this.listeners.size(); i++) {
            ((BaseKeyframeAnimation.AnimationListener) this.listeners.get(i)).onValueChanged();
        }
    }

    public PointF getValue() {
        return getValue((Keyframe<PointF>) null, 0.0f);
    }

    /* access modifiers changed from: package-private */
    public PointF getValue(Keyframe<PointF> keyframe, float f) {
        Keyframe<PointF> keyframe2 = keyframe;
        float f2 = f;
        return this.point;
    }
}
