package com.airbnb.lottie.animation.content;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import androidx.annotation.Nullable;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.TransformKeyframeAnimation;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.content.Repeater;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.List;

public class RepeaterContent implements DrawingContent, PathContent, GreedyContent, BaseKeyframeAnimation.AnimationListener, KeyPathElementContent {
    private ContentGroup contentGroup;
    private final BaseKeyframeAnimation<Float, Float> copies;
    private final boolean hidden;
    private final BaseLayer layer;
    private final LottieDrawable lottieDrawable;
    private final Matrix matrix;
    private final String name;
    private final BaseKeyframeAnimation<Float, Float> offset;
    private final Path path;
    private final TransformKeyframeAnimation transform;

    public RepeaterContent(LottieDrawable lottieDrawable2, BaseLayer baseLayer, Repeater repeater) {
        Matrix matrix2;
        Path path2;
        BaseLayer layer2 = baseLayer;
        Repeater repeater2 = repeater;
        new Matrix();
        this.matrix = matrix2;
        new Path();
        this.path = path2;
        this.lottieDrawable = lottieDrawable2;
        this.layer = layer2;
        this.name = repeater2.getName();
        this.hidden = repeater2.isHidden();
        this.copies = repeater2.getCopies().createAnimation();
        layer2.addAnimation(this.copies);
        this.copies.addUpdateListener(this);
        this.offset = repeater2.getOffset().createAnimation();
        layer2.addAnimation(this.offset);
        this.offset.addUpdateListener(this);
        this.transform = repeater2.getTransform().createAnimation();
        this.transform.addAnimationsToLayer(layer2);
        this.transform.addListener(this);
    }

    /* JADX WARNING: Removed duplicated region for block: B:2:0x0008 A[LOOP:0: B:2:0x0008->B:5:0x0015, LOOP_START] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void absorbContent(java.util.ListIterator<com.airbnb.lottie.animation.content.Content> r14) {
        /*
            r13 = this;
            r0 = r13
            r1 = r14
            r3 = r0
            com.airbnb.lottie.animation.content.ContentGroup r3 = r3.contentGroup
            if (r3 == 0) goto L_0x0008
        L_0x0007:
            return
        L_0x0008:
            r3 = r1
            boolean r3 = r3.hasPrevious()
            if (r3 == 0) goto L_0x0018
            r3 = r1
            java.lang.Object r3 = r3.previous()
            r4 = r0
            if (r3 == r4) goto L_0x0018
            goto L_0x0008
        L_0x0018:
            java.util.ArrayList r3 = new java.util.ArrayList
            r12 = r3
            r3 = r12
            r4 = r12
            r4.<init>()
            r2 = r3
        L_0x0021:
            r3 = r1
            boolean r3 = r3.hasPrevious()
            if (r3 == 0) goto L_0x0037
            r3 = r2
            r4 = r1
            java.lang.Object r4 = r4.previous()
            boolean r3 = r3.add(r4)
            r3 = r1
            r3.remove()
            goto L_0x0021
        L_0x0037:
            r3 = r2
            java.util.Collections.reverse(r3)
            r3 = r0
            com.airbnb.lottie.animation.content.ContentGroup r4 = new com.airbnb.lottie.animation.content.ContentGroup
            r12 = r4
            r4 = r12
            r5 = r12
            r6 = r0
            com.airbnb.lottie.LottieDrawable r6 = r6.lottieDrawable
            r7 = r0
            com.airbnb.lottie.model.layer.BaseLayer r7 = r7.layer
            java.lang.String r8 = "Repeater"
            r9 = r0
            boolean r9 = r9.hidden
            r10 = r2
            r11 = 0
            r5.<init>(r6, r7, r8, r9, r10, r11)
            r3.contentGroup = r4
            goto L_0x0007
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.animation.content.RepeaterContent.absorbContent(java.util.ListIterator):void");
    }

    public String getName() {
        return this.name;
    }

    public void setContents(List<Content> contentsBefore, List<Content> contentsAfter) {
        this.contentGroup.setContents(contentsBefore, contentsAfter);
    }

    public Path getPath() {
        Path contentPath = this.contentGroup.getPath();
        this.path.reset();
        float copies2 = this.copies.getValue().floatValue();
        float offset2 = this.offset.getValue().floatValue();
        for (int i = ((int) copies2) - 1; i >= 0; i--) {
            this.matrix.set(this.transform.getMatrixForRepeater(((float) i) + offset2));
            this.path.addPath(contentPath, this.matrix);
        }
        return this.path;
    }

    public void draw(Canvas canvas, Matrix matrix2, int i) {
        Canvas canvas2 = canvas;
        Matrix parentMatrix = matrix2;
        int alpha = i;
        float copies2 = this.copies.getValue().floatValue();
        float offset2 = this.offset.getValue().floatValue();
        float startOpacity = this.transform.getStartOpacity().getValue().floatValue() / 100.0f;
        float endOpacity = this.transform.getEndOpacity().getValue().floatValue() / 100.0f;
        for (int i2 = ((int) copies2) - 1; i2 >= 0; i2--) {
            this.matrix.set(parentMatrix);
            boolean preConcat = this.matrix.preConcat(this.transform.getMatrixForRepeater(((float) i2) + offset2));
            this.contentGroup.draw(canvas2, this.matrix, (int) (((float) alpha) * MiscUtils.lerp(startOpacity, endOpacity, ((float) i2) / copies2)));
        }
    }

    public void getBounds(RectF outBounds, Matrix parentMatrix, boolean applyParents) {
        this.contentGroup.getBounds(outBounds, parentMatrix, applyParents);
    }

    public void onValueChanged() {
        this.lottieDrawable.invalidateSelf();
    }

    public void resolveKeyPath(KeyPath keyPath, int depth, List<KeyPath> accumulator, KeyPath currentPartialKeyPath) {
        MiscUtils.resolveKeyPath(keyPath, depth, accumulator, currentPartialKeyPath, this);
    }

    public <T> void addValueCallback(T t, @Nullable LottieValueCallback<T> lottieValueCallback) {
        T property = t;
        LottieValueCallback<T> callback = lottieValueCallback;
        if (!this.transform.applyValueCallback(property, callback)) {
            if (property == LottieProperty.REPEATER_COPIES) {
                this.copies.setValueCallback(callback);
            } else if (property == LottieProperty.REPEATER_OFFSET) {
                this.offset.setValueCallback(callback);
            }
        }
    }
}
