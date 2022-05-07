package com.airbnb.lottie.animation.keyframe;

import com.airbnb.lottie.model.DocumentData;
import com.airbnb.lottie.value.Keyframe;
import java.util.List;

public class TextKeyframeAnimation extends KeyframeAnimation<DocumentData> {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TextKeyframeAnimation(List<Keyframe<DocumentData>> keyframes) {
        super(keyframes);
    }

    /* access modifiers changed from: package-private */
    public DocumentData getValue(Keyframe<DocumentData> keyframe, float f) {
        float f2 = f;
        return (DocumentData) keyframe.startValue;
    }
}
