package com.airbnb.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import androidx.annotation.Nullable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.ValueCallbackKeyframeAnimation;
import com.airbnb.lottie.value.LottieValueCallback;

public class SolidLayer extends BaseLayer {
    @Nullable
    private BaseKeyframeAnimation<ColorFilter, ColorFilter> colorFilterAnimation;
    private final Layer layerModel;
    private final Paint paint;
    private final Path path;
    private final float[] points = new float[8];
    private final RectF rect;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    SolidLayer(com.airbnb.lottie.LottieDrawable r8, com.airbnb.lottie.model.layer.Layer r9) {
        /*
            r7 = this;
            r0 = r7
            r1 = r8
            r2 = r9
            r3 = r0
            r4 = r1
            r5 = r2
            r3.<init>(r4, r5)
            r3 = r0
            android.graphics.RectF r4 = new android.graphics.RectF
            r6 = r4
            r4 = r6
            r5 = r6
            r5.<init>()
            r3.rect = r4
            r3 = r0
            com.airbnb.lottie.animation.LPaint r4 = new com.airbnb.lottie.animation.LPaint
            r6 = r4
            r4 = r6
            r5 = r6
            r5.<init>()
            r3.paint = r4
            r3 = r0
            r4 = 8
            float[] r4 = new float[r4]
            r3.points = r4
            r3 = r0
            android.graphics.Path r4 = new android.graphics.Path
            r6 = r4
            r4 = r6
            r5 = r6
            r5.<init>()
            r3.path = r4
            r3 = r0
            r4 = r2
            r3.layerModel = r4
            r3 = r0
            android.graphics.Paint r3 = r3.paint
            r4 = 0
            r3.setAlpha(r4)
            r3 = r0
            android.graphics.Paint r3 = r3.paint
            android.graphics.Paint$Style r4 = android.graphics.Paint.Style.FILL
            r3.setStyle(r4)
            r3 = r0
            android.graphics.Paint r3 = r3.paint
            r4 = r2
            int r4 = r4.getSolidColor()
            r3.setColor(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.model.layer.SolidLayer.<init>(com.airbnb.lottie.LottieDrawable, com.airbnb.lottie.model.layer.Layer):void");
    }

    public void drawLayer(Canvas canvas, Matrix matrix, int i) {
        Canvas canvas2 = canvas;
        Matrix parentMatrix = matrix;
        int parentAlpha = i;
        int backgroundAlpha = Color.alpha(this.layerModel.getSolidColor());
        if (backgroundAlpha != 0) {
            int alpha = (int) ((((float) parentAlpha) / 255.0f) * (((((float) backgroundAlpha) / 255.0f) * ((float) (this.transform.getOpacity() == null ? 100 : this.transform.getOpacity().getValue().intValue()))) / 100.0f) * 255.0f);
            this.paint.setAlpha(alpha);
            if (this.colorFilterAnimation != null) {
                ColorFilter colorFilter = this.paint.setColorFilter(this.colorFilterAnimation.getValue());
            }
            if (alpha > 0) {
                this.points[0] = 0.0f;
                this.points[1] = 0.0f;
                this.points[2] = (float) this.layerModel.getSolidWidth();
                this.points[3] = 0.0f;
                this.points[4] = (float) this.layerModel.getSolidWidth();
                this.points[5] = (float) this.layerModel.getSolidHeight();
                this.points[6] = 0.0f;
                this.points[7] = (float) this.layerModel.getSolidHeight();
                parentMatrix.mapPoints(this.points);
                this.path.reset();
                this.path.moveTo(this.points[0], this.points[1]);
                this.path.lineTo(this.points[2], this.points[3]);
                this.path.lineTo(this.points[4], this.points[5]);
                this.path.lineTo(this.points[6], this.points[7]);
                this.path.lineTo(this.points[0], this.points[1]);
                this.path.close();
                canvas2.drawPath(this.path, this.paint);
            }
        }
    }

    public void getBounds(RectF rectF, Matrix parentMatrix, boolean applyParents) {
        RectF outBounds = rectF;
        super.getBounds(outBounds, parentMatrix, applyParents);
        this.rect.set(0.0f, 0.0f, (float) this.layerModel.getSolidWidth(), (float) this.layerModel.getSolidHeight());
        boolean mapRect = this.boundsMatrix.mapRect(this.rect);
        outBounds.set(this.rect);
    }

    public <T> void addValueCallback(T t, @Nullable LottieValueCallback<T> lottieValueCallback) {
        BaseKeyframeAnimation<ColorFilter, ColorFilter> baseKeyframeAnimation;
        T property = t;
        LottieValueCallback<T> callback = lottieValueCallback;
        super.addValueCallback(property, callback);
        if (property != LottieProperty.COLOR_FILTER) {
            return;
        }
        if (callback == null) {
            this.colorFilterAnimation = null;
            return;
        }
        new ValueCallbackKeyframeAnimation(callback);
        this.colorFilterAnimation = baseKeyframeAnimation;
    }
}
