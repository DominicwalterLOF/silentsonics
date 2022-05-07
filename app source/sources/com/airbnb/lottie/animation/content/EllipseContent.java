package com.airbnb.lottie.animation.content;

import android.graphics.Path;
import android.graphics.PointF;
import androidx.annotation.Nullable;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.content.CircleShape;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.List;

public class EllipseContent implements PathContent, BaseKeyframeAnimation.AnimationListener, KeyPathElementContent {
    private static final float ELLIPSE_CONTROL_POINT_PERCENTAGE = 0.55228f;
    private final CircleShape circleShape;
    private boolean isPathValid;
    private final LottieDrawable lottieDrawable;
    private final String name;
    private final Path path;
    private final BaseKeyframeAnimation<?, PointF> positionAnimation;
    private final BaseKeyframeAnimation<?, PointF> sizeAnimation;
    private CompoundTrimPathContent trimPaths;

    public EllipseContent(LottieDrawable lottieDrawable2, BaseLayer baseLayer, CircleShape circleShape2) {
        Path path2;
        CompoundTrimPathContent compoundTrimPathContent;
        BaseLayer layer = baseLayer;
        CircleShape circleShape3 = circleShape2;
        new Path();
        this.path = path2;
        new CompoundTrimPathContent();
        this.trimPaths = compoundTrimPathContent;
        this.name = circleShape3.getName();
        this.lottieDrawable = lottieDrawable2;
        this.sizeAnimation = circleShape3.getSize().createAnimation();
        this.positionAnimation = circleShape3.getPosition().createAnimation();
        this.circleShape = circleShape3;
        layer.addAnimation(this.sizeAnimation);
        layer.addAnimation(this.positionAnimation);
        this.sizeAnimation.addUpdateListener(this);
        this.positionAnimation.addUpdateListener(this);
    }

    public void onValueChanged() {
        invalidate();
    }

    private void invalidate() {
        this.isPathValid = false;
        this.lottieDrawable.invalidateSelf();
    }

    public void setContents(List<Content> list, List<Content> list2) {
        List<Content> contentsBefore = list;
        List<Content> list3 = list2;
        for (int i = 0; i < contentsBefore.size(); i++) {
            Content content = contentsBefore.get(i);
            if ((content instanceof TrimPathContent) && ((TrimPathContent) content).getType() == ShapeTrimPath.Type.SIMULTANEOUSLY) {
                TrimPathContent trimPath = (TrimPathContent) content;
                this.trimPaths.addTrimPath(trimPath);
                trimPath.addListener(this);
            }
        }
    }

    public String getName() {
        return this.name;
    }

    public Path getPath() {
        if (this.isPathValid) {
            return this.path;
        }
        this.path.reset();
        if (this.circleShape.isHidden()) {
            this.isPathValid = true;
            return this.path;
        }
        PointF size = this.sizeAnimation.getValue();
        float halfWidth = size.x / 2.0f;
        float halfHeight = size.y / 2.0f;
        float cpW = halfWidth * ELLIPSE_CONTROL_POINT_PERCENTAGE;
        float cpH = halfHeight * ELLIPSE_CONTROL_POINT_PERCENTAGE;
        this.path.reset();
        if (this.circleShape.isReversed()) {
            this.path.moveTo(0.0f, -halfHeight);
            this.path.cubicTo(0.0f - cpW, -halfHeight, -halfWidth, 0.0f - cpH, -halfWidth, 0.0f);
            this.path.cubicTo(-halfWidth, 0.0f + cpH, 0.0f - cpW, halfHeight, 0.0f, halfHeight);
            this.path.cubicTo(0.0f + cpW, halfHeight, halfWidth, 0.0f + cpH, halfWidth, 0.0f);
            this.path.cubicTo(halfWidth, 0.0f - cpH, 0.0f + cpW, -halfHeight, 0.0f, -halfHeight);
        } else {
            this.path.moveTo(0.0f, -halfHeight);
            this.path.cubicTo(0.0f + cpW, -halfHeight, halfWidth, 0.0f - cpH, halfWidth, 0.0f);
            this.path.cubicTo(halfWidth, 0.0f + cpH, 0.0f + cpW, halfHeight, 0.0f, halfHeight);
            this.path.cubicTo(0.0f - cpW, halfHeight, -halfWidth, 0.0f + cpH, -halfWidth, 0.0f);
            this.path.cubicTo(-halfWidth, 0.0f - cpH, 0.0f - cpW, -halfHeight, 0.0f, -halfHeight);
        }
        PointF position = this.positionAnimation.getValue();
        this.path.offset(position.x, position.y);
        this.path.close();
        this.trimPaths.apply(this.path);
        this.isPathValid = true;
        return this.path;
    }

    public void resolveKeyPath(KeyPath keyPath, int depth, List<KeyPath> accumulator, KeyPath currentPartialKeyPath) {
        MiscUtils.resolveKeyPath(keyPath, depth, accumulator, currentPartialKeyPath, this);
    }

    public <T> void addValueCallback(T t, @Nullable LottieValueCallback<T> lottieValueCallback) {
        T property = t;
        LottieValueCallback<T> callback = lottieValueCallback;
        if (property == LottieProperty.ELLIPSE_SIZE) {
            this.sizeAnimation.setValueCallback(callback);
        } else if (property == LottieProperty.POSITION) {
            this.positionAnimation.setValueCallback(callback);
        }
    }
}
