package com.airbnb.lottie.animation.keyframe;

import android.graphics.Matrix;
import android.graphics.PointF;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.model.animatable.AnimatableTransform;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.value.Keyframe;
import com.airbnb.lottie.value.LottieValueCallback;
import com.airbnb.lottie.value.ScaleXY;
import java.util.Collections;

public class TransformKeyframeAnimation {
    @NonNull
    private BaseKeyframeAnimation<PointF, PointF> anchorPoint;
    @Nullable
    private BaseKeyframeAnimation<?, Float> endOpacity;
    private final Matrix matrix;
    @NonNull
    private BaseKeyframeAnimation<Integer, Integer> opacity;
    @NonNull
    private BaseKeyframeAnimation<?, PointF> position;
    @NonNull
    private BaseKeyframeAnimation<Float, Float> rotation;
    @NonNull
    private BaseKeyframeAnimation<ScaleXY, ScaleXY> scale;
    @Nullable
    private FloatKeyframeAnimation skew;
    @Nullable
    private FloatKeyframeAnimation skewAngle;
    private final Matrix skewMatrix1;
    private final Matrix skewMatrix2;
    private final Matrix skewMatrix3;
    private final float[] skewValues;
    @Nullable
    private BaseKeyframeAnimation<?, Float> startOpacity;

    public TransformKeyframeAnimation(AnimatableTransform animatableTransform) {
        Matrix matrix2;
        Matrix matrix3;
        Matrix matrix4;
        Matrix matrix5;
        AnimatableTransform animatableTransform2 = animatableTransform;
        new Matrix();
        this.matrix = matrix2;
        this.anchorPoint = animatableTransform2.getAnchorPoint() == null ? null : animatableTransform2.getAnchorPoint().createAnimation();
        this.position = animatableTransform2.getPosition() == null ? null : animatableTransform2.getPosition().createAnimation();
        this.scale = animatableTransform2.getScale() == null ? null : animatableTransform2.getScale().createAnimation();
        this.rotation = animatableTransform2.getRotation() == null ? null : animatableTransform2.getRotation().createAnimation();
        this.skew = animatableTransform2.getSkew() == null ? null : (FloatKeyframeAnimation) animatableTransform2.getSkew().createAnimation();
        if (this.skew != null) {
            new Matrix();
            this.skewMatrix1 = matrix3;
            new Matrix();
            this.skewMatrix2 = matrix4;
            new Matrix();
            this.skewMatrix3 = matrix5;
            this.skewValues = new float[9];
        } else {
            this.skewMatrix1 = null;
            this.skewMatrix2 = null;
            this.skewMatrix3 = null;
            this.skewValues = null;
        }
        this.skewAngle = animatableTransform2.getSkewAngle() == null ? null : (FloatKeyframeAnimation) animatableTransform2.getSkewAngle().createAnimation();
        if (animatableTransform2.getOpacity() != null) {
            this.opacity = animatableTransform2.getOpacity().createAnimation();
        }
        if (animatableTransform2.getStartOpacity() != null) {
            this.startOpacity = animatableTransform2.getStartOpacity().createAnimation();
        } else {
            this.startOpacity = null;
        }
        if (animatableTransform2.getEndOpacity() != null) {
            this.endOpacity = animatableTransform2.getEndOpacity().createAnimation();
        } else {
            this.endOpacity = null;
        }
    }

    public void addAnimationsToLayer(BaseLayer baseLayer) {
        BaseLayer layer = baseLayer;
        layer.addAnimation(this.opacity);
        layer.addAnimation(this.startOpacity);
        layer.addAnimation(this.endOpacity);
        layer.addAnimation(this.anchorPoint);
        layer.addAnimation(this.position);
        layer.addAnimation(this.scale);
        layer.addAnimation(this.rotation);
        layer.addAnimation(this.skew);
        layer.addAnimation(this.skewAngle);
    }

    public void addListener(BaseKeyframeAnimation.AnimationListener animationListener) {
        BaseKeyframeAnimation.AnimationListener listener = animationListener;
        if (this.opacity != null) {
            this.opacity.addUpdateListener(listener);
        }
        if (this.startOpacity != null) {
            this.startOpacity.addUpdateListener(listener);
        }
        if (this.endOpacity != null) {
            this.endOpacity.addUpdateListener(listener);
        }
        if (this.anchorPoint != null) {
            this.anchorPoint.addUpdateListener(listener);
        }
        if (this.position != null) {
            this.position.addUpdateListener(listener);
        }
        if (this.scale != null) {
            this.scale.addUpdateListener(listener);
        }
        if (this.rotation != null) {
            this.rotation.addUpdateListener(listener);
        }
        if (this.skew != null) {
            this.skew.addUpdateListener(listener);
        }
        if (this.skewAngle != null) {
            this.skewAngle.addUpdateListener(listener);
        }
    }

    public void setProgress(float f) {
        float progress = f;
        if (this.opacity != null) {
            this.opacity.setProgress(progress);
        }
        if (this.startOpacity != null) {
            this.startOpacity.setProgress(progress);
        }
        if (this.endOpacity != null) {
            this.endOpacity.setProgress(progress);
        }
        if (this.anchorPoint != null) {
            this.anchorPoint.setProgress(progress);
        }
        if (this.position != null) {
            this.position.setProgress(progress);
        }
        if (this.scale != null) {
            this.scale.setProgress(progress);
        }
        if (this.rotation != null) {
            this.rotation.setProgress(progress);
        }
        if (this.skew != null) {
            this.skew.setProgress(progress);
        }
        if (this.skewAngle != null) {
            this.skewAngle.setProgress(progress);
        }
    }

    @Nullable
    public BaseKeyframeAnimation<?, Integer> getOpacity() {
        return this.opacity;
    }

    @Nullable
    public BaseKeyframeAnimation<?, Float> getStartOpacity() {
        return this.startOpacity;
    }

    @Nullable
    public BaseKeyframeAnimation<?, Float> getEndOpacity() {
        return this.endOpacity;
    }

    public Matrix getMatrix() {
        float rotation2;
        this.matrix.reset();
        if (this.position != null) {
            PointF position2 = this.position.getValue();
            if (!(position2.x == 0.0f && position2.y == 0.0f)) {
                boolean preTranslate = this.matrix.preTranslate(position2.x, position2.y);
            }
        }
        if (this.rotation != null) {
            if (this.rotation instanceof ValueCallbackKeyframeAnimation) {
                rotation2 = this.rotation.getValue().floatValue();
            } else {
                rotation2 = ((FloatKeyframeAnimation) this.rotation).getFloatValue();
            }
            if (rotation2 != 0.0f) {
                boolean preRotate = this.matrix.preRotate(rotation2);
            }
        }
        if (this.skew != null) {
            float mCos = this.skewAngle == null ? 0.0f : (float) Math.cos(Math.toRadians((double) ((-this.skewAngle.getFloatValue()) + 90.0f)));
            float mSin = this.skewAngle == null ? 1.0f : (float) Math.sin(Math.toRadians((double) ((-this.skewAngle.getFloatValue()) + 90.0f)));
            float aTan = (float) Math.tan(Math.toRadians((double) this.skew.getFloatValue()));
            clearSkewValues();
            this.skewValues[0] = mCos;
            this.skewValues[1] = mSin;
            this.skewValues[3] = -mSin;
            this.skewValues[4] = mCos;
            this.skewValues[8] = 1.0f;
            this.skewMatrix1.setValues(this.skewValues);
            clearSkewValues();
            this.skewValues[0] = 1.0f;
            this.skewValues[3] = aTan;
            this.skewValues[4] = 1.0f;
            this.skewValues[8] = 1.0f;
            this.skewMatrix2.setValues(this.skewValues);
            clearSkewValues();
            this.skewValues[0] = mCos;
            this.skewValues[1] = -mSin;
            this.skewValues[3] = mSin;
            this.skewValues[4] = mCos;
            this.skewValues[8] = 1.0f;
            this.skewMatrix3.setValues(this.skewValues);
            boolean preConcat = this.skewMatrix2.preConcat(this.skewMatrix1);
            boolean preConcat2 = this.skewMatrix3.preConcat(this.skewMatrix2);
            boolean preConcat3 = this.matrix.preConcat(this.skewMatrix3);
        }
        if (this.scale != null) {
            ScaleXY scaleTransform = this.scale.getValue();
            if (!(scaleTransform.getScaleX() == 1.0f && scaleTransform.getScaleY() == 1.0f)) {
                boolean preScale = this.matrix.preScale(scaleTransform.getScaleX(), scaleTransform.getScaleY());
            }
        }
        if (this.anchorPoint != null) {
            PointF anchorPoint2 = this.anchorPoint.getValue();
            if (!(anchorPoint2.x == 0.0f && anchorPoint2.y == 0.0f)) {
                boolean preTranslate2 = this.matrix.preTranslate(-anchorPoint2.x, -anchorPoint2.y);
            }
        }
        return this.matrix;
    }

    private void clearSkewValues() {
        for (int i = 0; i < 9; i++) {
            this.skewValues[i] = 0.0f;
        }
    }

    public Matrix getMatrixForRepeater(float f) {
        ScaleXY value;
        float amount = f;
        PointF position2 = this.position == null ? null : this.position.getValue();
        if (this.scale == null) {
            value = null;
        } else {
            value = this.scale.getValue();
        }
        ScaleXY scale2 = value;
        this.matrix.reset();
        if (position2 != null) {
            boolean preTranslate = this.matrix.preTranslate(position2.x * amount, position2.y * amount);
        }
        if (scale2 != null) {
            boolean preScale = this.matrix.preScale((float) Math.pow((double) scale2.getScaleX(), (double) amount), (float) Math.pow((double) scale2.getScaleY(), (double) amount));
        }
        if (this.rotation != null) {
            float rotation2 = this.rotation.getValue().floatValue();
            PointF anchorPoint2 = this.anchorPoint == null ? null : this.anchorPoint.getValue();
            boolean preRotate = this.matrix.preRotate(rotation2 * amount, anchorPoint2 == null ? 0.0f : anchorPoint2.x, anchorPoint2 == null ? 0.0f : anchorPoint2.y);
        }
        return this.matrix;
    }

    public <T> boolean applyValueCallback(T t, @Nullable LottieValueCallback<T> lottieValueCallback) {
        FloatKeyframeAnimation floatKeyframeAnimation;
        Object obj;
        FloatKeyframeAnimation floatKeyframeAnimation2;
        Object obj2;
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation;
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation2;
        BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation3;
        BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation4;
        BaseKeyframeAnimation<ScaleXY, ScaleXY> baseKeyframeAnimation5;
        Object obj3;
        BaseKeyframeAnimation<?, PointF> baseKeyframeAnimation6;
        Object obj4;
        BaseKeyframeAnimation<PointF, PointF> baseKeyframeAnimation7;
        Object obj5;
        T property = t;
        LottieValueCallback<T> callback = lottieValueCallback;
        if (property == LottieProperty.TRANSFORM_ANCHOR_POINT) {
            if (this.anchorPoint == null) {
                new PointF();
                new ValueCallbackKeyframeAnimation(callback, obj5);
                this.anchorPoint = baseKeyframeAnimation7;
            } else {
                this.anchorPoint.setValueCallback(callback);
            }
        } else if (property == LottieProperty.TRANSFORM_POSITION) {
            if (this.position == null) {
                new PointF();
                new ValueCallbackKeyframeAnimation(callback, obj4);
                this.position = baseKeyframeAnimation6;
            } else {
                this.position.setValueCallback(callback);
            }
        } else if (property == LottieProperty.TRANSFORM_SCALE) {
            if (this.scale == null) {
                new ScaleXY();
                new ValueCallbackKeyframeAnimation(callback, obj3);
                this.scale = baseKeyframeAnimation5;
            } else {
                this.scale.setValueCallback(callback);
            }
        } else if (property == LottieProperty.TRANSFORM_ROTATION) {
            if (this.rotation == null) {
                new ValueCallbackKeyframeAnimation(callback, Float.valueOf(0.0f));
                this.rotation = baseKeyframeAnimation4;
            } else {
                this.rotation.setValueCallback(callback);
            }
        } else if (property == LottieProperty.TRANSFORM_OPACITY) {
            if (this.opacity == null) {
                new ValueCallbackKeyframeAnimation(callback, 100);
                this.opacity = baseKeyframeAnimation3;
            } else {
                this.opacity.setValueCallback(callback);
            }
        } else if (property != LottieProperty.TRANSFORM_START_OPACITY || this.startOpacity == null) {
            if (property != LottieProperty.TRANSFORM_END_OPACITY || this.endOpacity == null) {
                if (property == LottieProperty.TRANSFORM_SKEW && this.skew != null) {
                    if (this.skew == null) {
                        new Keyframe(Float.valueOf(0.0f));
                        new FloatKeyframeAnimation(Collections.singletonList(obj2));
                        this.skew = floatKeyframeAnimation2;
                    }
                    this.skew.setValueCallback(callback);
                } else if (property != LottieProperty.TRANSFORM_SKEW_ANGLE || this.skewAngle == null) {
                    return false;
                } else {
                    if (this.skewAngle == null) {
                        new Keyframe(Float.valueOf(0.0f));
                        new FloatKeyframeAnimation(Collections.singletonList(obj));
                        this.skewAngle = floatKeyframeAnimation;
                    }
                    this.skewAngle.setValueCallback(callback);
                }
            } else if (this.endOpacity == null) {
                new ValueCallbackKeyframeAnimation(callback, 100);
                this.endOpacity = baseKeyframeAnimation;
            } else {
                this.endOpacity.setValueCallback(callback);
            }
        } else if (this.startOpacity == null) {
            new ValueCallbackKeyframeAnimation(callback, 100);
            this.startOpacity = baseKeyframeAnimation2;
        } else {
            this.startOpacity.setValueCallback(callback);
        }
        return true;
    }
}
