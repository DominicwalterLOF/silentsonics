package com.airbnb.lottie.model.animatable;

import com.airbnb.lottie.value.Keyframe;
import java.util.Arrays;
import java.util.List;

abstract class BaseAnimatableValue<V, O> implements AnimatableValue<V, O> {
    final List<Keyframe<V>> keyframes;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    BaseAnimatableValue(V r8) {
        /*
            r7 = this;
            r0 = r7
            r1 = r8
            r2 = r0
            com.airbnb.lottie.value.Keyframe r3 = new com.airbnb.lottie.value.Keyframe
            r6 = r3
            r3 = r6
            r4 = r6
            r5 = r1
            r4.<init>(r5)
            java.util.List r3 = java.util.Collections.singletonList(r3)
            r2.<init>(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.model.animatable.BaseAnimatableValue.<init>(java.lang.Object):void");
    }

    BaseAnimatableValue(List<Keyframe<V>> keyframes2) {
        this.keyframes = keyframes2;
    }

    public List<Keyframe<V>> getKeyframes() {
        return this.keyframes;
    }

    public boolean isStatic() {
        return this.keyframes.isEmpty() || (this.keyframes.size() == 1 && this.keyframes.get(0).isStatic());
    }

    public String toString() {
        StringBuilder sb;
        new StringBuilder();
        StringBuilder sb2 = sb;
        if (!this.keyframes.isEmpty()) {
            StringBuilder append = sb2.append("values=").append(Arrays.toString(this.keyframes.toArray()));
        }
        return sb2.toString();
    }
}
