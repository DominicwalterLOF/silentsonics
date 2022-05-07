package com.airbnb.lottie.model.animatable;

import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.ScaleKeyframeAnimation;
import com.airbnb.lottie.value.Keyframe;
import com.airbnb.lottie.value.ScaleXY;
import java.util.List;

public class AnimatableScaleValue extends BaseAnimatableValue<ScaleXY, ScaleXY> {
    public /* bridge */ /* synthetic */ List getKeyframes() {
        return super.getKeyframes();
    }

    public /* bridge */ /* synthetic */ boolean isStatic() {
        return super.isStatic();
    }

    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    AnimatableScaleValue() {
        /*
            r7 = this;
            r0 = r7
            r1 = r0
            com.airbnb.lottie.value.ScaleXY r2 = new com.airbnb.lottie.value.ScaleXY
            r6 = r2
            r2 = r6
            r3 = r6
            r4 = 1065353216(0x3f800000, float:1.0)
            r5 = 1065353216(0x3f800000, float:1.0)
            r3.<init>(r4, r5)
            r1.<init>((com.airbnb.lottie.value.ScaleXY) r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.model.animatable.AnimatableScaleValue.<init>():void");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AnimatableScaleValue(ScaleXY value) {
        super(value);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AnimatableScaleValue(List<Keyframe<ScaleXY>> keyframes) {
        super(keyframes);
    }

    public BaseKeyframeAnimation<ScaleXY, ScaleXY> createAnimation() {
        BaseKeyframeAnimation<ScaleXY, ScaleXY> baseKeyframeAnimation;
        new ScaleKeyframeAnimation(this.keyframes);
        return baseKeyframeAnimation;
    }
}
