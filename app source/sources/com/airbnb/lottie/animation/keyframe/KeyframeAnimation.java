package com.airbnb.lottie.animation.keyframe;

import com.airbnb.lottie.value.Keyframe;
import java.util.List;

abstract class KeyframeAnimation<T> extends BaseKeyframeAnimation<T, T> {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    KeyframeAnimation(List<? extends Keyframe<T>> keyframes) {
        super(keyframes);
    }
}
