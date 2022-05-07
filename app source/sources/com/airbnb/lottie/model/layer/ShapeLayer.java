package com.airbnb.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import androidx.annotation.NonNull;
import com.airbnb.lottie.animation.content.ContentGroup;
import com.airbnb.lottie.model.KeyPath;
import java.util.List;

public class ShapeLayer extends BaseLayer {
    private final ContentGroup contentGroup;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    ShapeLayer(com.airbnb.lottie.LottieDrawable r12, com.airbnb.lottie.model.layer.Layer r13) {
        /*
            r11 = this;
            r0 = r11
            r1 = r12
            r2 = r13
            r4 = r0
            r5 = r1
            r6 = r2
            r4.<init>(r5, r6)
            com.airbnb.lottie.model.content.ShapeGroup r4 = new com.airbnb.lottie.model.content.ShapeGroup
            r10 = r4
            r4 = r10
            r5 = r10
            java.lang.String r6 = "__container"
            r7 = r2
            java.util.List r7 = r7.getShapes()
            r8 = 0
            r5.<init>(r6, r7, r8)
            r3 = r4
            r4 = r0
            com.airbnb.lottie.animation.content.ContentGroup r5 = new com.airbnb.lottie.animation.content.ContentGroup
            r10 = r5
            r5 = r10
            r6 = r10
            r7 = r1
            r8 = r0
            r9 = r3
            r6.<init>(r7, r8, r9)
            r4.contentGroup = r5
            r4 = r0
            com.airbnb.lottie.animation.content.ContentGroup r4 = r4.contentGroup
            java.util.List r5 = java.util.Collections.emptyList()
            java.util.List r6 = java.util.Collections.emptyList()
            r4.setContents(r5, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.model.layer.ShapeLayer.<init>(com.airbnb.lottie.LottieDrawable, com.airbnb.lottie.model.layer.Layer):void");
    }

    /* access modifiers changed from: package-private */
    public void drawLayer(@NonNull Canvas canvas, Matrix parentMatrix, int parentAlpha) {
        this.contentGroup.draw(canvas, parentMatrix, parentAlpha);
    }

    public void getBounds(RectF rectF, Matrix parentMatrix, boolean z) {
        RectF outBounds = rectF;
        boolean applyParents = z;
        super.getBounds(outBounds, parentMatrix, applyParents);
        this.contentGroup.getBounds(outBounds, this.boundsMatrix, applyParents);
    }

    /* access modifiers changed from: protected */
    public void resolveChildKeyPath(KeyPath keyPath, int depth, List<KeyPath> accumulator, KeyPath currentPartialKeyPath) {
        this.contentGroup.resolveKeyPath(keyPath, depth, accumulator, currentPartialKeyPath);
    }
}
