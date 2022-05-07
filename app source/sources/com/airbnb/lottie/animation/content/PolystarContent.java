package com.airbnb.lottie.animation.content;

import android.graphics.Path;
import android.graphics.PointF;
import androidx.annotation.Nullable;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.content.PolystarShape;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.List;

public class PolystarContent implements PathContent, BaseKeyframeAnimation.AnimationListener, KeyPathElementContent {
    private static final float POLYGON_MAGIC_NUMBER = 0.25f;
    private static final float POLYSTAR_MAGIC_NUMBER = 0.47829f;
    private final boolean hidden;
    @Nullable
    private final BaseKeyframeAnimation<?, Float> innerRadiusAnimation;
    @Nullable
    private final BaseKeyframeAnimation<?, Float> innerRoundednessAnimation;
    private boolean isPathValid;
    private final LottieDrawable lottieDrawable;
    private final String name;
    private final BaseKeyframeAnimation<?, Float> outerRadiusAnimation;
    private final BaseKeyframeAnimation<?, Float> outerRoundednessAnimation;
    private final Path path;
    private final BaseKeyframeAnimation<?, Float> pointsAnimation;
    private final BaseKeyframeAnimation<?, PointF> positionAnimation;
    private final BaseKeyframeAnimation<?, Float> rotationAnimation;
    private CompoundTrimPathContent trimPaths;
    private final PolystarShape.Type type;

    public PolystarContent(LottieDrawable lottieDrawable2, BaseLayer baseLayer, PolystarShape polystarShape) {
        Path path2;
        CompoundTrimPathContent compoundTrimPathContent;
        BaseLayer layer = baseLayer;
        PolystarShape polystarShape2 = polystarShape;
        new Path();
        this.path = path2;
        new CompoundTrimPathContent();
        this.trimPaths = compoundTrimPathContent;
        this.lottieDrawable = lottieDrawable2;
        this.name = polystarShape2.getName();
        this.type = polystarShape2.getType();
        this.hidden = polystarShape2.isHidden();
        this.pointsAnimation = polystarShape2.getPoints().createAnimation();
        this.positionAnimation = polystarShape2.getPosition().createAnimation();
        this.rotationAnimation = polystarShape2.getRotation().createAnimation();
        this.outerRadiusAnimation = polystarShape2.getOuterRadius().createAnimation();
        this.outerRoundednessAnimation = polystarShape2.getOuterRoundedness().createAnimation();
        if (this.type == PolystarShape.Type.STAR) {
            this.innerRadiusAnimation = polystarShape2.getInnerRadius().createAnimation();
            this.innerRoundednessAnimation = polystarShape2.getInnerRoundedness().createAnimation();
        } else {
            this.innerRadiusAnimation = null;
            this.innerRoundednessAnimation = null;
        }
        layer.addAnimation(this.pointsAnimation);
        layer.addAnimation(this.positionAnimation);
        layer.addAnimation(this.rotationAnimation);
        layer.addAnimation(this.outerRadiusAnimation);
        layer.addAnimation(this.outerRoundednessAnimation);
        if (this.type == PolystarShape.Type.STAR) {
            layer.addAnimation(this.innerRadiusAnimation);
            layer.addAnimation(this.innerRoundednessAnimation);
        }
        this.pointsAnimation.addUpdateListener(this);
        this.positionAnimation.addUpdateListener(this);
        this.rotationAnimation.addUpdateListener(this);
        this.outerRadiusAnimation.addUpdateListener(this);
        this.outerRoundednessAnimation.addUpdateListener(this);
        if (this.type == PolystarShape.Type.STAR) {
            this.innerRadiusAnimation.addUpdateListener(this);
            this.innerRoundednessAnimation.addUpdateListener(this);
        }
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
        if (this.isPathValid) {
            return this.path;
        }
        this.path.reset();
        if (this.hidden) {
            this.isPathValid = true;
            return this.path;
        }
        switch (this.type) {
            case STAR:
                createStarPath();
                break;
            case POLYGON:
                createPolygonPath();
                break;
        }
        this.path.close();
        this.trimPaths.apply(this.path);
        this.isPathValid = true;
        return this.path;
    }

    public String getName() {
        return this.name;
    }

    private void createStarPath() {
        double currentAngle;
        float x;
        float y;
        double currentAngle2;
        boolean z;
        float points = this.pointsAnimation.getValue().floatValue();
        if (this.rotationAnimation == null) {
            currentAngle = 0.0d;
        } else {
            currentAngle = (double) this.rotationAnimation.getValue().floatValue();
        }
        double currentAngle3 = Math.toRadians(currentAngle - 90.0d);
        float anglePerPoint = (float) (6.283185307179586d / ((double) points));
        float halfAnglePerPoint = anglePerPoint / 2.0f;
        float partialPointAmount = points - ((float) ((int) points));
        if (partialPointAmount != 0.0f) {
            currentAngle3 += (double) (halfAnglePerPoint * (1.0f - partialPointAmount));
        }
        float outerRadius = this.outerRadiusAnimation.getValue().floatValue();
        float innerRadius = this.innerRadiusAnimation.getValue().floatValue();
        float innerRoundedness = 0.0f;
        if (this.innerRoundednessAnimation != null) {
            innerRoundedness = this.innerRoundednessAnimation.getValue().floatValue() / 100.0f;
        }
        float outerRoundedness = 0.0f;
        if (this.outerRoundednessAnimation != null) {
            outerRoundedness = this.outerRoundednessAnimation.getValue().floatValue() / 100.0f;
        }
        float partialPointRadius = 0.0f;
        if (partialPointAmount != 0.0f) {
            partialPointRadius = innerRadius + (partialPointAmount * (outerRadius - innerRadius));
            x = (float) (((double) partialPointRadius) * Math.cos(currentAngle3));
            y = (float) (((double) partialPointRadius) * Math.sin(currentAngle3));
            this.path.moveTo(x, y);
            currentAngle2 = currentAngle3 + ((double) ((anglePerPoint * partialPointAmount) / 2.0f));
        } else {
            x = (float) (((double) outerRadius) * Math.cos(currentAngle3));
            y = (float) (((double) outerRadius) * Math.sin(currentAngle3));
            this.path.moveTo(x, y);
            currentAngle2 = currentAngle3 + ((double) halfAnglePerPoint);
        }
        boolean longSegment = false;
        double numPoints = Math.ceil((double) points) * 2.0d;
        for (int i = 0; ((double) i) < numPoints; i++) {
            float radius = longSegment ? outerRadius : innerRadius;
            float dTheta = halfAnglePerPoint;
            if (partialPointRadius != 0.0f && ((double) i) == numPoints - 2.0d) {
                dTheta = (anglePerPoint * partialPointAmount) / 2.0f;
            }
            if (partialPointRadius != 0.0f && ((double) i) == numPoints - 1.0d) {
                radius = partialPointRadius;
            }
            float previousX = x;
            float previousY = y;
            x = (float) (((double) radius) * Math.cos(currentAngle2));
            y = (float) (((double) radius) * Math.sin(currentAngle2));
            if (innerRoundedness == 0.0f && outerRoundedness == 0.0f) {
                this.path.lineTo(x, y);
            } else {
                float cp1Theta = (float) (Math.atan2((double) previousY, (double) previousX) - 1.5707963267948966d);
                float cp1Dx = (float) Math.cos((double) cp1Theta);
                float cp1Dy = (float) Math.sin((double) cp1Theta);
                float cp2Theta = (float) (Math.atan2((double) y, (double) x) - 1.5707963267948966d);
                float cp2Dx = (float) Math.cos((double) cp2Theta);
                float cp2Dy = (float) Math.sin((double) cp2Theta);
                float cp1Roundedness = longSegment ? innerRoundedness : outerRoundedness;
                float cp2Roundedness = longSegment ? outerRoundedness : innerRoundedness;
                float cp1Radius = longSegment ? innerRadius : outerRadius;
                float cp2Radius = longSegment ? outerRadius : innerRadius;
                float cp1x = cp1Radius * cp1Roundedness * POLYSTAR_MAGIC_NUMBER * cp1Dx;
                float cp1y = cp1Radius * cp1Roundedness * POLYSTAR_MAGIC_NUMBER * cp1Dy;
                float cp2x = cp2Radius * cp2Roundedness * POLYSTAR_MAGIC_NUMBER * cp2Dx;
                float cp2y = cp2Radius * cp2Roundedness * POLYSTAR_MAGIC_NUMBER * cp2Dy;
                if (partialPointAmount != 0.0f) {
                    if (i == 0) {
                        cp1x *= partialPointAmount;
                        cp1y *= partialPointAmount;
                    } else if (((double) i) == numPoints - 1.0d) {
                        cp2x *= partialPointAmount;
                        cp2y *= partialPointAmount;
                    }
                }
                this.path.cubicTo(previousX - cp1x, previousY - cp1y, x + cp2x, y + cp2y, x, y);
            }
            currentAngle2 += (double) dTheta;
            if (!longSegment) {
                z = true;
            } else {
                z = false;
            }
            longSegment = z;
        }
        PointF position = this.positionAnimation.getValue();
        this.path.offset(position.x, position.y);
        this.path.close();
    }

    private void createPolygonPath() {
        double currentAngle;
        int points = (int) Math.floor((double) this.pointsAnimation.getValue().floatValue());
        if (this.rotationAnimation == null) {
            currentAngle = 0.0d;
        } else {
            currentAngle = (double) this.rotationAnimation.getValue().floatValue();
        }
        double currentAngle2 = Math.toRadians(currentAngle - 90.0d);
        float anglePerPoint = (float) (6.283185307179586d / ((double) points));
        float roundedness = this.outerRoundednessAnimation.getValue().floatValue() / 100.0f;
        float radius = this.outerRadiusAnimation.getValue().floatValue();
        float x = (float) (((double) radius) * Math.cos(currentAngle2));
        float y = (float) (((double) radius) * Math.sin(currentAngle2));
        this.path.moveTo(x, y);
        double currentAngle3 = currentAngle2 + ((double) anglePerPoint);
        double numPoints = Math.ceil((double) points);
        for (int i = 0; ((double) i) < numPoints; i++) {
            float previousX = x;
            float previousY = y;
            x = (float) (((double) radius) * Math.cos(currentAngle3));
            y = (float) (((double) radius) * Math.sin(currentAngle3));
            if (roundedness != 0.0f) {
                float cp1Theta = (float) (Math.atan2((double) previousY, (double) previousX) - 1.5707963267948966d);
                float cp1Dx = (float) Math.cos((double) cp1Theta);
                float cp1Dy = (float) Math.sin((double) cp1Theta);
                float cp2Theta = (float) (Math.atan2((double) y, (double) x) - 1.5707963267948966d);
                this.path.cubicTo(previousX - (((radius * roundedness) * POLYGON_MAGIC_NUMBER) * cp1Dx), previousY - (((radius * roundedness) * POLYGON_MAGIC_NUMBER) * cp1Dy), x + (radius * roundedness * POLYGON_MAGIC_NUMBER * ((float) Math.cos((double) cp2Theta))), y + (radius * roundedness * POLYGON_MAGIC_NUMBER * ((float) Math.sin((double) cp2Theta))), x, y);
            } else {
                this.path.lineTo(x, y);
            }
            currentAngle3 += (double) anglePerPoint;
        }
        PointF position = this.positionAnimation.getValue();
        this.path.offset(position.x, position.y);
        this.path.close();
    }

    public void resolveKeyPath(KeyPath keyPath, int depth, List<KeyPath> accumulator, KeyPath currentPartialKeyPath) {
        MiscUtils.resolveKeyPath(keyPath, depth, accumulator, currentPartialKeyPath, this);
    }

    public <T> void addValueCallback(T t, @Nullable LottieValueCallback<T> lottieValueCallback) {
        T property = t;
        LottieValueCallback<T> callback = lottieValueCallback;
        if (property == LottieProperty.POLYSTAR_POINTS) {
            this.pointsAnimation.setValueCallback(callback);
        } else if (property == LottieProperty.POLYSTAR_ROTATION) {
            this.rotationAnimation.setValueCallback(callback);
        } else if (property == LottieProperty.POSITION) {
            this.positionAnimation.setValueCallback(callback);
        } else if (property == LottieProperty.POLYSTAR_INNER_RADIUS && this.innerRadiusAnimation != null) {
            this.innerRadiusAnimation.setValueCallback(callback);
        } else if (property == LottieProperty.POLYSTAR_OUTER_RADIUS) {
            this.outerRadiusAnimation.setValueCallback(callback);
        } else if (property == LottieProperty.POLYSTAR_INNER_ROUNDEDNESS && this.innerRoundednessAnimation != null) {
            this.innerRoundednessAnimation.setValueCallback(callback);
        } else if (property == LottieProperty.POLYSTAR_OUTER_ROUNDEDNESS) {
            this.outerRoundednessAnimation.setValueCallback(callback);
        }
    }
}
