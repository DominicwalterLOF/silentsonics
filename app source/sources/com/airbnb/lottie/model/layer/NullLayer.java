package com.airbnb.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import com.airbnb.lottie.LottieDrawable;

public class NullLayer extends BaseLayer {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    NullLayer(LottieDrawable lottieDrawable, Layer layerModel) {
        super(lottieDrawable, layerModel);
    }

    /* access modifiers changed from: package-private */
    public void drawLayer(Canvas canvas, Matrix parentMatrix, int parentAlpha) {
    }

    public void getBounds(RectF rectF, Matrix parentMatrix, boolean applyParents) {
        RectF outBounds = rectF;
        super.getBounds(outBounds, parentMatrix, applyParents);
        outBounds.set(0.0f, 0.0f, 0.0f, 0.0f);
    }
}
