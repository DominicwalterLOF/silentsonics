package com.airbnb.lottie.model.animatable;

import android.graphics.PointF;
import androidx.annotation.Nullable;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.ModifierContent;
import com.airbnb.lottie.animation.keyframe.TransformKeyframeAnimation;
import com.airbnb.lottie.model.content.ContentModel;
import com.airbnb.lottie.model.layer.BaseLayer;

public class AnimatableTransform implements ModifierContent, ContentModel {
    @Nullable
    private final AnimatablePathValue anchorPoint;
    @Nullable
    private final AnimatableFloatValue endOpacity;
    @Nullable
    private final AnimatableIntegerValue opacity;
    @Nullable
    private final AnimatableValue<PointF, PointF> position;
    @Nullable
    private final AnimatableFloatValue rotation;
    @Nullable
    private final AnimatableScaleValue scale;
    @Nullable
    private final AnimatableFloatValue skew;
    @Nullable
    private final AnimatableFloatValue skewAngle;
    @Nullable
    private final AnimatableFloatValue startOpacity;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public AnimatableTransform() {
        this((AnimatablePathValue) null, (AnimatableValue<PointF, PointF>) null, (AnimatableScaleValue) null, (AnimatableFloatValue) null, (AnimatableIntegerValue) null, (AnimatableFloatValue) null, (AnimatableFloatValue) null, (AnimatableFloatValue) null, (AnimatableFloatValue) null);
    }

    public AnimatableTransform(@Nullable AnimatablePathValue anchorPoint2, @Nullable AnimatableValue<PointF, PointF> position2, @Nullable AnimatableScaleValue scale2, @Nullable AnimatableFloatValue rotation2, @Nullable AnimatableIntegerValue opacity2, @Nullable AnimatableFloatValue startOpacity2, @Nullable AnimatableFloatValue endOpacity2, @Nullable AnimatableFloatValue skew2, @Nullable AnimatableFloatValue skewAngle2) {
        this.anchorPoint = anchorPoint2;
        this.position = position2;
        this.scale = scale2;
        this.rotation = rotation2;
        this.opacity = opacity2;
        this.startOpacity = startOpacity2;
        this.endOpacity = endOpacity2;
        this.skew = skew2;
        this.skewAngle = skewAngle2;
    }

    @Nullable
    public AnimatablePathValue getAnchorPoint() {
        return this.anchorPoint;
    }

    @Nullable
    public AnimatableValue<PointF, PointF> getPosition() {
        return this.position;
    }

    @Nullable
    public AnimatableScaleValue getScale() {
        return this.scale;
    }

    @Nullable
    public AnimatableFloatValue getRotation() {
        return this.rotation;
    }

    @Nullable
    public AnimatableIntegerValue getOpacity() {
        return this.opacity;
    }

    @Nullable
    public AnimatableFloatValue getStartOpacity() {
        return this.startOpacity;
    }

    @Nullable
    public AnimatableFloatValue getEndOpacity() {
        return this.endOpacity;
    }

    @Nullable
    public AnimatableFloatValue getSkew() {
        return this.skew;
    }

    @Nullable
    public AnimatableFloatValue getSkewAngle() {
        return this.skewAngle;
    }

    public TransformKeyframeAnimation createAnimation() {
        TransformKeyframeAnimation transformKeyframeAnimation;
        new TransformKeyframeAnimation(this);
        return transformKeyframeAnimation;
    }

    @Nullable
    public Content toContent(LottieDrawable lottieDrawable, BaseLayer baseLayer) {
        LottieDrawable lottieDrawable2 = lottieDrawable;
        BaseLayer baseLayer2 = baseLayer;
        return null;
    }
}
