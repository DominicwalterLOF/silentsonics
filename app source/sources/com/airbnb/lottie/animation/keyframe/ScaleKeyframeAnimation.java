package com.airbnb.lottie.animation.keyframe;

import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.Keyframe;
import com.airbnb.lottie.value.ScaleXY;
import java.util.List;

public class ScaleKeyframeAnimation extends KeyframeAnimation<ScaleXY> {
    private final ScaleXY scaleXY;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ScaleKeyframeAnimation(List<Keyframe<ScaleXY>> keyframes) {
        super(keyframes);
        ScaleXY scaleXY2;
        new ScaleXY();
        this.scaleXY = scaleXY2;
    }

    public ScaleXY getValue(Keyframe<ScaleXY> keyframe, float f) {
        Throwable th;
        ScaleXY value;
        Keyframe<ScaleXY> keyframe2 = keyframe;
        float keyframeProgress = f;
        if (keyframe2.startValue == null || keyframe2.endValue == null) {
            Throwable th2 = th;
            new IllegalStateException("Missing values for keyframe.");
            throw th2;
        }
        ScaleXY startTransform = (ScaleXY) keyframe2.startValue;
        ScaleXY endTransform = (ScaleXY) keyframe2.endValue;
        if (this.valueCallback != null && (value = (ScaleXY) this.valueCallback.getValueInternal(keyframe2.startFrame, keyframe2.endFrame.floatValue(), startTransform, endTransform, keyframeProgress, getLinearCurrentKeyframeProgress(), getProgress())) != null) {
            return value;
        }
        this.scaleXY.set(MiscUtils.lerp(startTransform.getScaleX(), endTransform.getScaleX(), keyframeProgress), MiscUtils.lerp(startTransform.getScaleY(), endTransform.getScaleY(), keyframeProgress));
        return this.scaleXY;
    }
}
