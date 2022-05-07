package com.airbnb.lottie.animation.content;

import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import androidx.annotation.Nullable;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.FloatKeyframeAnimation;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.content.RectangleShape;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.List;

public class RectangleContent implements BaseKeyframeAnimation.AnimationListener, KeyPathElementContent, PathContent {
    private final BaseKeyframeAnimation<?, Float> cornerRadiusAnimation;
    private final boolean hidden;
    private boolean isPathValid;
    private final LottieDrawable lottieDrawable;
    private final String name;
    private final Path path;
    private final BaseKeyframeAnimation<?, PointF> positionAnimation;
    private final RectF rect;
    private final BaseKeyframeAnimation<?, PointF> sizeAnimation;
    private CompoundTrimPathContent trimPaths;

    public RectangleContent(LottieDrawable lottieDrawable2, BaseLayer baseLayer, RectangleShape rectangleShape) {
        Path path2;
        RectF rectF;
        CompoundTrimPathContent compoundTrimPathContent;
        BaseLayer layer = baseLayer;
        RectangleShape rectShape = rectangleShape;
        new Path();
        this.path = path2;
        new RectF();
        this.rect = rectF;
        new CompoundTrimPathContent();
        this.trimPaths = compoundTrimPathContent;
        this.name = rectShape.getName();
        this.hidden = rectShape.isHidden();
        this.lottieDrawable = lottieDrawable2;
        this.positionAnimation = rectShape.getPosition().createAnimation();
        this.sizeAnimation = rectShape.getSize().createAnimation();
        this.cornerRadiusAnimation = rectShape.getCornerRadius().createAnimation();
        layer.addAnimation(this.positionAnimation);
        layer.addAnimation(this.sizeAnimation);
        layer.addAnimation(this.cornerRadiusAnimation);
        this.positionAnimation.addUpdateListener(this);
        this.sizeAnimation.addUpdateListener(this);
        this.cornerRadiusAnimation.addUpdateListener(this);
    }

    public String getName() {
        return this.name;
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

    public Path getPath() {
        float floatValue;
        if (this.isPathValid) {
            return this.path;
        }
        this.path.reset();
        if (this.hidden) {
            this.isPathValid = true;
            return this.path;
        }
        PointF size = this.sizeAnimation.getValue();
        float halfWidth = size.x / 2.0f;
        float halfHeight = size.y / 2.0f;
        if (this.cornerRadiusAnimation == null) {
            floatValue = 0.0f;
        } else {
            floatValue = ((FloatKeyframeAnimation) this.cornerRadiusAnimation).getFloatValue();
        }
        float radius = floatValue;
        float maxRadius = Math.min(halfWidth, halfHeight);
        if (radius > maxRadius) {
            radius = maxRadius;
        }
        PointF position = this.positionAnimation.getValue();
        this.path.moveTo(position.x + halfWidth, (position.y - halfHeight) + radius);
        this.path.lineTo(position.x + halfWidth, (position.y + halfHeight) - radius);
        if (radius > 0.0f) {
            this.rect.set((position.x + halfWidth) - (2.0f * radius), (position.y + halfHeight) - (2.0f * radius), position.x + halfWidth, position.y + halfHeight);
            this.path.arcTo(this.rect, 0.0f, 90.0f, false);
        }
        this.path.lineTo((position.x - halfWidth) + radius, position.y + halfHeight);
        if (radius > 0.0f) {
            this.rect.set(position.x - halfWidth, (position.y + halfHeight) - (2.0f * radius), (position.x - halfWidth) + (2.0f * radius), position.y + halfHeight);
            this.path.arcTo(this.rect, 90.0f, 90.0f, false);
        }
        this.path.lineTo(position.x - halfWidth, (position.y - halfHeight) + radius);
        if (radius > 0.0f) {
            this.rect.set(position.x - halfWidth, position.y - halfHeight, (position.x - halfWidth) + (2.0f * radius), (position.y - halfHeight) + (2.0f * radius));
            this.path.arcTo(this.rect, 180.0f, 90.0f, false);
        }
        this.path.lineTo((position.x + halfWidth) - radius, position.y - halfHeight);
        if (radius > 0.0f) {
            this.rect.set((position.x + halfWidth) - (2.0f * radius), position.y - halfHeight, position.x + halfWidth, (position.y - halfHeight) + (2.0f * radius));
            this.path.arcTo(this.rect, 270.0f, 90.0f, false);
        }
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
        if (property == LottieProperty.RECTANGLE_SIZE) {
            this.sizeAnimation.setValueCallback(callback);
        } else if (property == LottieProperty.POSITION) {
            this.positionAnimation.setValueCallback(callback);
        } else if (property == LottieProperty.CORNER_RADIUS) {
            this.cornerRadiusAnimation.setValueCallback(callback);
        }
    }
}
