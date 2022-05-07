package com.airbnb.lottie.animation.keyframe;

import android.graphics.Path;
import com.airbnb.lottie.model.content.ShapeData;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.Keyframe;
import java.util.List;

public class ShapeKeyframeAnimation extends BaseKeyframeAnimation<ShapeData, Path> {
    private final Path tempPath;
    private final ShapeData tempShapeData;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ShapeKeyframeAnimation(List<Keyframe<ShapeData>> keyframes) {
        super(keyframes);
        ShapeData shapeData;
        Path path;
        new ShapeData();
        this.tempShapeData = shapeData;
        new Path();
        this.tempPath = path;
    }

    public Path getValue(Keyframe<ShapeData> keyframe, float keyframeProgress) {
        Keyframe<ShapeData> keyframe2 = keyframe;
        this.tempShapeData.interpolateBetween((ShapeData) keyframe2.startValue, (ShapeData) keyframe2.endValue, keyframeProgress);
        MiscUtils.getPathFromData(this.tempShapeData, this.tempPath);
        return this.tempPath;
    }
}
