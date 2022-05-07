package com.airbnb.lottie.animation.keyframe;

import android.graphics.PointF;
import com.airbnb.lottie.value.Keyframe;
import java.util.List;

public class PointKeyframeAnimation extends KeyframeAnimation<PointF> {
    private final PointF point;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PointKeyframeAnimation(List<Keyframe<PointF>> keyframes) {
        super(keyframes);
        PointF pointF;
        new PointF();
        this.point = pointF;
    }

    public PointF getValue(Keyframe<PointF> keyframe, float f) {
        Throwable th;
        PointF value;
        Keyframe<PointF> keyframe2 = keyframe;
        float keyframeProgress = f;
        if (keyframe2.startValue == null || keyframe2.endValue == null) {
            Throwable th2 = th;
            new IllegalStateException("Missing values for keyframe.");
            throw th2;
        }
        PointF startPoint = (PointF) keyframe2.startValue;
        PointF endPoint = (PointF) keyframe2.endValue;
        if (this.valueCallback != null && (value = (PointF) this.valueCallback.getValueInternal(keyframe2.startFrame, keyframe2.endFrame.floatValue(), startPoint, endPoint, keyframeProgress, getLinearCurrentKeyframeProgress(), getProgress())) != null) {
            return value;
        }
        this.point.set(startPoint.x + (keyframeProgress * (endPoint.x - startPoint.x)), startPoint.y + (keyframeProgress * (endPoint.y - startPoint.y)));
        return this.point;
    }
}
