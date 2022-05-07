package com.airbnb.lottie.model.layer;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.LPaint;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.ValueCallbackKeyframeAnimation;
import com.airbnb.lottie.utils.Utils;
import com.airbnb.lottie.value.LottieValueCallback;

public class ImageLayer extends BaseLayer {
    @Nullable
    private BaseKeyframeAnimation<ColorFilter, ColorFilter> colorFilterAnimation;
    private final Rect dst;
    private final Paint paint;
    private final Rect src;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ImageLayer(LottieDrawable lottieDrawable, Layer layerModel) {
        super(lottieDrawable, layerModel);
        Paint paint2;
        Rect rect;
        Rect rect2;
        new LPaint(3);
        this.paint = paint2;
        new Rect();
        this.src = rect;
        new Rect();
        this.dst = rect2;
    }

    public void drawLayer(@NonNull Canvas canvas, Matrix matrix, int i) {
        Canvas canvas2 = canvas;
        Matrix parentMatrix = matrix;
        int parentAlpha = i;
        Bitmap bitmap = getBitmap();
        if (bitmap != null && !bitmap.isRecycled()) {
            float density = Utils.dpScale();
            this.paint.setAlpha(parentAlpha);
            if (this.colorFilterAnimation != null) {
                ColorFilter colorFilter = this.paint.setColorFilter(this.colorFilterAnimation.getValue());
            }
            int save = canvas2.save();
            canvas2.concat(parentMatrix);
            this.src.set(0, 0, bitmap.getWidth(), bitmap.getHeight());
            this.dst.set(0, 0, (int) (((float) bitmap.getWidth()) * density), (int) (((float) bitmap.getHeight()) * density));
            canvas2.drawBitmap(bitmap, this.src, this.dst, this.paint);
            canvas2.restore();
        }
    }

    public void getBounds(RectF rectF, Matrix parentMatrix, boolean applyParents) {
        RectF outBounds = rectF;
        super.getBounds(outBounds, parentMatrix, applyParents);
        Bitmap bitmap = getBitmap();
        if (bitmap != null) {
            outBounds.set(0.0f, 0.0f, ((float) bitmap.getWidth()) * Utils.dpScale(), ((float) bitmap.getHeight()) * Utils.dpScale());
            boolean mapRect = this.boundsMatrix.mapRect(outBounds);
        }
    }

    @Nullable
    private Bitmap getBitmap() {
        return this.lottieDrawable.getImageAsset(this.layerModel.getRefId());
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
