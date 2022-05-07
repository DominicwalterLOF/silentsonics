package com.airbnb.lottie.animation.content;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import androidx.annotation.Nullable;
import androidx.collection.LongSparseArray;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.ValueCallbackKeyframeAnimation;
import com.airbnb.lottie.model.content.GradientColor;
import com.airbnb.lottie.model.content.GradientType;
import com.airbnb.lottie.value.LottieValueCallback;

public class GradientStrokeContent extends BaseStrokeContent {
    private static final int CACHE_STEPS_MS = 32;
    private final RectF boundsRect;
    private final int cacheSteps;
    private final BaseKeyframeAnimation<GradientColor, GradientColor> colorAnimation;
    @Nullable
    private ValueCallbackKeyframeAnimation colorCallbackAnimation;
    private final BaseKeyframeAnimation<PointF, PointF> endPointAnimation;
    private final boolean hidden;
    private final LongSparseArray<LinearGradient> linearGradientCache;
    private final String name;
    private final LongSparseArray<RadialGradient> radialGradientCache;
    private final BaseKeyframeAnimation<PointF, PointF> startPointAnimation;
    private final GradientType type;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public GradientStrokeContent(com.airbnb.lottie.LottieDrawable r16, com.airbnb.lottie.model.layer.BaseLayer r17, com.airbnb.lottie.model.content.GradientStroke r18) {
        /*
            r15 = this;
            r0 = r15
            r1 = r16
            r2 = r17
            r3 = r18
            r4 = r0
            r5 = r1
            r6 = r2
            r7 = r3
            com.airbnb.lottie.model.content.ShapeStroke$LineCapType r7 = r7.getCapType()
            android.graphics.Paint$Cap r7 = r7.toPaintCap()
            r8 = r3
            com.airbnb.lottie.model.content.ShapeStroke$LineJoinType r8 = r8.getJoinType()
            android.graphics.Paint$Join r8 = r8.toPaintJoin()
            r9 = r3
            float r9 = r9.getMiterLimit()
            r10 = r3
            com.airbnb.lottie.model.animatable.AnimatableIntegerValue r10 = r10.getOpacity()
            r11 = r3
            com.airbnb.lottie.model.animatable.AnimatableFloatValue r11 = r11.getWidth()
            r12 = r3
            java.util.List r12 = r12.getLineDashPattern()
            r13 = r3
            com.airbnb.lottie.model.animatable.AnimatableFloatValue r13 = r13.getDashOffset()
            r4.<init>(r5, r6, r7, r8, r9, r10, r11, r12, r13)
            r4 = r0
            androidx.collection.LongSparseArray r5 = new androidx.collection.LongSparseArray
            r14 = r5
            r5 = r14
            r6 = r14
            r6.<init>()
            r4.linearGradientCache = r5
            r4 = r0
            androidx.collection.LongSparseArray r5 = new androidx.collection.LongSparseArray
            r14 = r5
            r5 = r14
            r6 = r14
            r6.<init>()
            r4.radialGradientCache = r5
            r4 = r0
            android.graphics.RectF r5 = new android.graphics.RectF
            r14 = r5
            r5 = r14
            r6 = r14
            r6.<init>()
            r4.boundsRect = r5
            r4 = r0
            r5 = r3
            java.lang.String r5 = r5.getName()
            r4.name = r5
            r4 = r0
            r5 = r3
            com.airbnb.lottie.model.content.GradientType r5 = r5.getGradientType()
            r4.type = r5
            r4 = r0
            r5 = r3
            boolean r5 = r5.isHidden()
            r4.hidden = r5
            r4 = r0
            r5 = r1
            com.airbnb.lottie.LottieComposition r5 = r5.getComposition()
            float r5 = r5.getDuration()
            r6 = 1107296256(0x42000000, float:32.0)
            float r5 = r5 / r6
            int r5 = (int) r5
            r4.cacheSteps = r5
            r4 = r0
            r5 = r3
            com.airbnb.lottie.model.animatable.AnimatableGradientColorValue r5 = r5.getGradientColor()
            com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation r5 = r5.createAnimation()
            r4.colorAnimation = r5
            r4 = r0
            com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<com.airbnb.lottie.model.content.GradientColor, com.airbnb.lottie.model.content.GradientColor> r4 = r4.colorAnimation
            r5 = r0
            r4.addUpdateListener(r5)
            r4 = r2
            r5 = r0
            com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<com.airbnb.lottie.model.content.GradientColor, com.airbnb.lottie.model.content.GradientColor> r5 = r5.colorAnimation
            r4.addAnimation(r5)
            r4 = r0
            r5 = r3
            com.airbnb.lottie.model.animatable.AnimatablePointValue r5 = r5.getStartPoint()
            com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation r5 = r5.createAnimation()
            r4.startPointAnimation = r5
            r4 = r0
            com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<android.graphics.PointF, android.graphics.PointF> r4 = r4.startPointAnimation
            r5 = r0
            r4.addUpdateListener(r5)
            r4 = r2
            r5 = r0
            com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<android.graphics.PointF, android.graphics.PointF> r5 = r5.startPointAnimation
            r4.addAnimation(r5)
            r4 = r0
            r5 = r3
            com.airbnb.lottie.model.animatable.AnimatablePointValue r5 = r5.getEndPoint()
            com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation r5 = r5.createAnimation()
            r4.endPointAnimation = r5
            r4 = r0
            com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<android.graphics.PointF, android.graphics.PointF> r4 = r4.endPointAnimation
            r5 = r0
            r4.addUpdateListener(r5)
            r4 = r2
            r5 = r0
            com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<android.graphics.PointF, android.graphics.PointF> r5 = r5.endPointAnimation
            r4.addAnimation(r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.animation.content.GradientStrokeContent.<init>(com.airbnb.lottie.LottieDrawable, com.airbnb.lottie.model.layer.BaseLayer, com.airbnb.lottie.model.content.GradientStroke):void");
    }

    public void draw(Canvas canvas, Matrix matrix, int i) {
        Shader shader;
        Canvas canvas2 = canvas;
        Matrix parentMatrix = matrix;
        int parentAlpha = i;
        if (!this.hidden) {
            getBounds(this.boundsRect, parentMatrix, false);
            if (this.type == GradientType.LINEAR) {
                shader = getLinearGradient();
            } else {
                shader = getRadialGradient();
            }
            Shader shader2 = this.paint.setShader(shader);
            super.draw(canvas2, parentMatrix, parentAlpha);
        }
    }

    public String getName() {
        return this.name;
    }

    private LinearGradient getLinearGradient() {
        LinearGradient linearGradient;
        int gradientHash = getGradientHash();
        LinearGradient gradient = this.linearGradientCache.get((long) gradientHash);
        if (gradient != null) {
            return gradient;
        }
        PointF startPoint = this.startPointAnimation.getValue();
        PointF endPoint = this.endPointAnimation.getValue();
        GradientColor gradientColor = this.colorAnimation.getValue();
        new LinearGradient((float) ((int) (this.boundsRect.left + (this.boundsRect.width() / 2.0f) + startPoint.x)), (float) ((int) (this.boundsRect.top + (this.boundsRect.height() / 2.0f) + startPoint.y)), (float) ((int) (this.boundsRect.left + (this.boundsRect.width() / 2.0f) + endPoint.x)), (float) ((int) (this.boundsRect.top + (this.boundsRect.height() / 2.0f) + endPoint.y)), applyDynamicColorsIfNeeded(gradientColor.getColors()), gradientColor.getPositions(), Shader.TileMode.CLAMP);
        LinearGradient gradient2 = linearGradient;
        this.linearGradientCache.put((long) gradientHash, gradient2);
        return gradient2;
    }

    private RadialGradient getRadialGradient() {
        RadialGradient radialGradient;
        int gradientHash = getGradientHash();
        RadialGradient gradient = this.radialGradientCache.get((long) gradientHash);
        if (gradient != null) {
            return gradient;
        }
        PointF startPoint = this.startPointAnimation.getValue();
        PointF endPoint = this.endPointAnimation.getValue();
        GradientColor gradientColor = this.colorAnimation.getValue();
        int[] colors = applyDynamicColorsIfNeeded(gradientColor.getColors());
        float[] positions = gradientColor.getPositions();
        int x0 = (int) (this.boundsRect.left + (this.boundsRect.width() / 2.0f) + startPoint.x);
        int y0 = (int) (this.boundsRect.top + (this.boundsRect.height() / 2.0f) + startPoint.y);
        new RadialGradient((float) x0, (float) y0, (float) Math.hypot((double) (((int) ((this.boundsRect.left + (this.boundsRect.width() / 2.0f)) + endPoint.x)) - x0), (double) (((int) ((this.boundsRect.top + (this.boundsRect.height() / 2.0f)) + endPoint.y)) - y0)), colors, positions, Shader.TileMode.CLAMP);
        RadialGradient gradient2 = radialGradient;
        this.radialGradientCache.put((long) gradientHash, gradient2);
        return gradient2;
    }

    private int getGradientHash() {
        int startPointProgress = Math.round(this.startPointAnimation.getProgress() * ((float) this.cacheSteps));
        int endPointProgress = Math.round(this.endPointAnimation.getProgress() * ((float) this.cacheSteps));
        int colorProgress = Math.round(this.colorAnimation.getProgress() * ((float) this.cacheSteps));
        int hash = 17;
        if (startPointProgress != 0) {
            hash = 17 * 31 * startPointProgress;
        }
        if (endPointProgress != 0) {
            hash = hash * 31 * endPointProgress;
        }
        if (colorProgress != 0) {
            hash = hash * 31 * colorProgress;
        }
        return hash;
    }

    private int[] applyDynamicColorsIfNeeded(int[] iArr) {
        int[] colors = iArr;
        if (this.colorCallbackAnimation != null) {
            Integer[] dynamicColors = (Integer[]) this.colorCallbackAnimation.getValue();
            if (colors.length == dynamicColors.length) {
                for (int i = 0; i < colors.length; i++) {
                    colors[i] = dynamicColors[i].intValue();
                }
            } else {
                colors = new int[dynamicColors.length];
                for (int i2 = 0; i2 < dynamicColors.length; i2++) {
                    colors[i2] = dynamicColors[i2].intValue();
                }
            }
        }
        return colors;
    }

    public <T> void addValueCallback(T t, @Nullable LottieValueCallback<T> lottieValueCallback) {
        ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation;
        T property = t;
        LottieValueCallback<T> callback = lottieValueCallback;
        super.addValueCallback(property, callback);
        if (property != LottieProperty.GRADIENT_COLOR) {
            return;
        }
        if (callback == null) {
            if (this.colorCallbackAnimation != null) {
                this.layer.removeAnimation(this.colorCallbackAnimation);
            }
            this.colorCallbackAnimation = null;
            return;
        }
        new ValueCallbackKeyframeAnimation(callback);
        this.colorCallbackAnimation = valueCallbackKeyframeAnimation;
        this.colorCallbackAnimation.addUpdateListener(this);
        this.layer.addAnimation(this.colorCallbackAnimation);
    }
}
