package com.airbnb.lottie.animation.keyframe;

import android.graphics.Path;
import android.graphics.PointF;
import androidx.annotation.Nullable;
import com.airbnb.lottie.utils.Utils;
import com.airbnb.lottie.value.Keyframe;

public class PathKeyframe extends Keyframe<PointF> {
    @Nullable
    private Path path;
    private final Keyframe<PointF> pointKeyFrame;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public PathKeyframe(com.airbnb.lottie.LottieComposition r11, com.airbnb.lottie.value.Keyframe<android.graphics.PointF> r12) {
        /*
            r10 = this;
            r0 = r10
            r1 = r11
            r2 = r12
            r3 = r0
            r4 = r1
            r5 = r2
            T r5 = r5.startValue
            r6 = r2
            T r6 = r6.endValue
            r7 = r2
            android.view.animation.Interpolator r7 = r7.interpolator
            r8 = r2
            float r8 = r8.startFrame
            r9 = r2
            java.lang.Float r9 = r9.endFrame
            r3.<init>(r4, r5, r6, r7, r8, r9)
            r3 = r0
            r4 = r2
            r3.pointKeyFrame = r4
            r3 = r0
            r3.createPath()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.animation.keyframe.PathKeyframe.<init>(com.airbnb.lottie.LottieComposition, com.airbnb.lottie.value.Keyframe):void");
    }

    public void createPath() {
        boolean equals = (this.endValue == null || this.startValue == null || !((PointF) this.startValue).equals(((PointF) this.endValue).x, ((PointF) this.endValue).y)) ? false : true;
        if (this.endValue != null && !equals) {
            this.path = Utils.createPath((PointF) this.startValue, (PointF) this.endValue, this.pointKeyFrame.pathCp1, this.pointKeyFrame.pathCp2);
        }
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public Path getPath() {
        return this.path;
    }
}
