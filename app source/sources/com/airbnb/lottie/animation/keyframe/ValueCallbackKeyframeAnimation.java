package com.airbnb.lottie.animation.keyframe;

import androidx.annotation.Nullable;
import com.airbnb.lottie.value.Keyframe;
import com.airbnb.lottie.value.LottieFrameInfo;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.Collections;

public class ValueCallbackKeyframeAnimation<K, A> extends BaseKeyframeAnimation<K, A> {
    private final LottieFrameInfo<A> frameInfo;
    private final A valueCallbackValue;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ValueCallbackKeyframeAnimation(LottieValueCallback<A> valueCallback) {
        this(valueCallback, (Object) null);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ValueCallbackKeyframeAnimation(LottieValueCallback<A> valueCallback, @Nullable A valueCallbackValue2) {
        super(Collections.emptyList());
        LottieFrameInfo<A> lottieFrameInfo;
        new LottieFrameInfo<>();
        this.frameInfo = lottieFrameInfo;
        setValueCallback(valueCallback);
        this.valueCallbackValue = valueCallbackValue2;
    }

    /* access modifiers changed from: package-private */
    public float getEndProgress() {
        return 1.0f;
    }

    public void notifyListeners() {
        if (this.valueCallback != null) {
            super.notifyListeners();
        }
    }

    public A getValue() {
        return this.valueCallback.getValueInternal(0.0f, 0.0f, this.valueCallbackValue, this.valueCallbackValue, getProgress(), getProgress(), getProgress());
    }

    /* access modifiers changed from: package-private */
    public A getValue(Keyframe<K> keyframe, float f) {
        Keyframe<K> keyframe2 = keyframe;
        float f2 = f;
        return getValue();
    }
}
