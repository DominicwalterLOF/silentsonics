package com.airbnb.lottie.animation.content;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import androidx.annotation.Nullable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.ColorKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.ValueCallbackKeyframeAnimation;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.value.LottieValueCallback;

public class StrokeContent extends BaseStrokeContent {
    private final BaseKeyframeAnimation<Integer, Integer> colorAnimation;
    @Nullable
    private BaseKeyframeAnimation<ColorFilter, ColorFilter> colorFilterAnimation;
    private final boolean hidden;
    private final BaseLayer layer;
    private final String name;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public StrokeContent(com.airbnb.lottie.LottieDrawable r15, com.airbnb.lottie.model.layer.BaseLayer r16, com.airbnb.lottie.model.content.ShapeStroke r17) {
        /*
            r14 = this;
            r0 = r14
            r1 = r15
            r2 = r16
            r3 = r17
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
            r5 = r2
            r4.layer = r5
            r4 = r0
            r5 = r3
            java.lang.String r5 = r5.getName()
            r4.name = r5
            r4 = r0
            r5 = r3
            boolean r5 = r5.isHidden()
            r4.hidden = r5
            r4 = r0
            r5 = r3
            com.airbnb.lottie.model.animatable.AnimatableColorValue r5 = r5.getColor()
            com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation r5 = r5.createAnimation()
            r4.colorAnimation = r5
            r4 = r0
            com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<java.lang.Integer, java.lang.Integer> r4 = r4.colorAnimation
            r5 = r0
            r4.addUpdateListener(r5)
            r4 = r2
            r5 = r0
            com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<java.lang.Integer, java.lang.Integer> r5 = r5.colorAnimation
            r4.addAnimation(r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.animation.content.StrokeContent.<init>(com.airbnb.lottie.LottieDrawable, com.airbnb.lottie.model.layer.BaseLayer, com.airbnb.lottie.model.content.ShapeStroke):void");
    }

    public void draw(Canvas canvas, Matrix matrix, int i) {
        Canvas canvas2 = canvas;
        Matrix parentMatrix = matrix;
        int parentAlpha = i;
        if (!this.hidden) {
            this.paint.setColor(((ColorKeyframeAnimation) this.colorAnimation).getIntValue());
            if (this.colorFilterAnimation != null) {
                ColorFilter colorFilter = this.paint.setColorFilter(this.colorFilterAnimation.getValue());
            }
            super.draw(canvas2, parentMatrix, parentAlpha);
        }
    }

    public String getName() {
        return this.name;
    }

    public <T> void addValueCallback(T t, @Nullable LottieValueCallback<T> lottieValueCallback) {
        BaseKeyframeAnimation<ColorFilter, ColorFilter> baseKeyframeAnimation;
        T property = t;
        LottieValueCallback<T> callback = lottieValueCallback;
        super.addValueCallback(property, callback);
        if (property == LottieProperty.STROKE_COLOR) {
            this.colorAnimation.setValueCallback(callback);
        } else if (property != LottieProperty.COLOR_FILTER) {
        } else {
            if (callback == null) {
                this.colorFilterAnimation = null;
                return;
            }
            new ValueCallbackKeyframeAnimation(callback);
            this.colorFilterAnimation = baseKeyframeAnimation;
            this.colorFilterAnimation.addUpdateListener(this);
            this.layer.addAnimation(this.colorAnimation);
        }
    }
}
