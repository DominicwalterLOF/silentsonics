package com.airbnb.lottie.animation.keyframe;

import com.airbnb.lottie.model.content.GradientColor;
import com.airbnb.lottie.value.Keyframe;

public class GradientColorKeyframeAnimation extends KeyframeAnimation<GradientColor> {
    private final GradientColor gradientColor;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public GradientColorKeyframeAnimation(java.util.List<com.airbnb.lottie.value.Keyframe<com.airbnb.lottie.model.content.GradientColor>> r11) {
        /*
            r10 = this;
            r0 = r10
            r1 = r11
            r4 = r0
            r5 = r1
            r4.<init>(r5)
            r4 = r1
            r5 = 0
            java.lang.Object r4 = r4.get(r5)
            com.airbnb.lottie.value.Keyframe r4 = (com.airbnb.lottie.value.Keyframe) r4
            T r4 = r4.startValue
            com.airbnb.lottie.model.content.GradientColor r4 = (com.airbnb.lottie.model.content.GradientColor) r4
            r2 = r4
            r4 = r2
            if (r4 != 0) goto L_0x002b
            r4 = 0
        L_0x0018:
            r3 = r4
            r4 = r0
            com.airbnb.lottie.model.content.GradientColor r5 = new com.airbnb.lottie.model.content.GradientColor
            r9 = r5
            r5 = r9
            r6 = r9
            r7 = r3
            float[] r7 = new float[r7]
            r8 = r3
            int[] r8 = new int[r8]
            r6.<init>(r7, r8)
            r4.gradientColor = r5
            return
        L_0x002b:
            r4 = r2
            int r4 = r4.getSize()
            goto L_0x0018
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.animation.keyframe.GradientColorKeyframeAnimation.<init>(java.util.List):void");
    }

    /* access modifiers changed from: package-private */
    public GradientColor getValue(Keyframe<GradientColor> keyframe, float keyframeProgress) {
        Keyframe<GradientColor> keyframe2 = keyframe;
        this.gradientColor.lerp((GradientColor) keyframe2.startValue, (GradientColor) keyframe2.endValue, keyframeProgress);
        return this.gradientColor;
    }
}
