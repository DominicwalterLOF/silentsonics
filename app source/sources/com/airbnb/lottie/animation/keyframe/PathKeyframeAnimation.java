package com.airbnb.lottie.animation.keyframe;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import com.airbnb.lottie.value.Keyframe;
import java.util.List;

public class PathKeyframeAnimation extends KeyframeAnimation<PointF> {
    private PathMeasure pathMeasure;
    private PathKeyframe pathMeasureKeyframe;
    private final PointF point;
    private final float[] pos = new float[2];

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PathKeyframeAnimation(List<? extends Keyframe<PointF>> keyframes) {
        super(keyframes);
        PointF pointF;
        PathMeasure pathMeasure2;
        new PointF();
        this.point = pointF;
        new PathMeasure();
        this.pathMeasure = pathMeasure2;
    }

    public PointF getValue(Keyframe<PointF> keyframe, float f) {
        PointF value;
        Keyframe<PointF> keyframe2 = keyframe;
        float keyframeProgress = f;
        PathKeyframe pathKeyframe = (PathKeyframe) keyframe2;
        Path path = pathKeyframe.getPath();
        if (path == null) {
            return (PointF) keyframe2.startValue;
        }
        if (this.valueCallback != null && (value = (PointF) this.valueCallback.getValueInternal(pathKeyframe.startFrame, pathKeyframe.endFrame.floatValue(), pathKeyframe.startValue, pathKeyframe.endValue, getLinearCurrentKeyframeProgress(), keyframeProgress, getProgress())) != null) {
            return value;
        }
        if (this.pathMeasureKeyframe != pathKeyframe) {
            this.pathMeasure.setPath(path, false);
            this.pathMeasureKeyframe = pathKeyframe;
        }
        boolean posTan = this.pathMeasure.getPosTan(keyframeProgress * this.pathMeasure.getLength(), this.pos, (float[]) null);
        this.point.set(this.pos[0], this.pos[1]);
        return this.point;
    }
}
