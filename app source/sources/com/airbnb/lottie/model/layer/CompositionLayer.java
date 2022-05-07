package com.airbnb.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import androidx.annotation.FloatRange;
import androidx.annotation.Nullable;
import com.airbnb.lottie.L;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.ValueCallbackKeyframeAnimation;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.List;

public class CompositionLayer extends BaseLayer {
    @Nullable
    private Boolean hasMasks;
    @Nullable
    private Boolean hasMatte;
    private final List<BaseLayer> layers;
    private final RectF newClipRect;
    private final RectF rect;
    @Nullable
    private BaseKeyframeAnimation<Float, Float> timeRemapping;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public CompositionLayer(com.airbnb.lottie.LottieDrawable r19, com.airbnb.lottie.model.layer.Layer r20, java.util.List<com.airbnb.lottie.model.layer.Layer> r21, com.airbnb.lottie.LottieComposition r22) {
        /*
            r18 = this;
            r0 = r18
            r1 = r19
            r2 = r20
            r3 = r21
            r4 = r22
            r13 = r0
            r14 = r1
            r15 = r2
            r13.<init>(r14, r15)
            r13 = r0
            java.util.ArrayList r14 = new java.util.ArrayList
            r17 = r14
            r14 = r17
            r15 = r17
            r15.<init>()
            r13.layers = r14
            r13 = r0
            android.graphics.RectF r14 = new android.graphics.RectF
            r17 = r14
            r14 = r17
            r15 = r17
            r15.<init>()
            r13.rect = r14
            r13 = r0
            android.graphics.RectF r14 = new android.graphics.RectF
            r17 = r14
            r14 = r17
            r15 = r17
            r15.<init>()
            r13.newClipRect = r14
            r13 = r2
            com.airbnb.lottie.model.animatable.AnimatableFloatValue r13 = r13.getTimeRemapping()
            r5 = r13
            r13 = r5
            if (r13 == 0) goto L_0x0093
            r13 = r0
            r14 = r5
            com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation r14 = r14.createAnimation()
            r13.timeRemapping = r14
            r13 = r0
            r14 = r0
            com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<java.lang.Float, java.lang.Float> r14 = r14.timeRemapping
            r13.addAnimation(r14)
            r13 = r0
            com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<java.lang.Float, java.lang.Float> r13 = r13.timeRemapping
            r14 = r0
            r13.addUpdateListener(r14)
        L_0x0059:
            androidx.collection.LongSparseArray r13 = new androidx.collection.LongSparseArray
            r17 = r13
            r13 = r17
            r14 = r17
            r15 = r4
            java.util.List r15 = r15.getLayers()
            int r15 = r15.size()
            r14.<init>(r15)
            r6 = r13
            r13 = 0
            r7 = r13
            r13 = r3
            int r13 = r13.size()
            r14 = 1
            int r13 = r13 + -1
            r8 = r13
        L_0x0079:
            r13 = r8
            if (r13 < 0) goto L_0x00ce
            r13 = r3
            r14 = r8
            java.lang.Object r13 = r13.get(r14)
            com.airbnb.lottie.model.layer.Layer r13 = (com.airbnb.lottie.model.layer.Layer) r13
            r9 = r13
            r13 = r9
            r14 = r1
            r15 = r4
            com.airbnb.lottie.model.layer.BaseLayer r13 = com.airbnb.lottie.model.layer.BaseLayer.forModel(r13, r14, r15)
            r10 = r13
            r13 = r10
            if (r13 != 0) goto L_0x0098
        L_0x0090:
            int r8 = r8 + -1
            goto L_0x0079
        L_0x0093:
            r13 = r0
            r14 = 0
            r13.timeRemapping = r14
            goto L_0x0059
        L_0x0098:
            r13 = r6
            r14 = r10
            com.airbnb.lottie.model.layer.Layer r14 = r14.getLayerModel()
            long r14 = r14.getId()
            r16 = r10
            r13.put(r14, r16)
            r13 = r7
            if (r13 == 0) goto L_0x00b2
            r13 = r7
            r14 = r10
            r13.setMatteLayer(r14)
            r13 = 0
            r7 = r13
            goto L_0x0090
        L_0x00b2:
            r13 = r0
            java.util.List<com.airbnb.lottie.model.layer.BaseLayer> r13 = r13.layers
            r14 = 0
            r15 = r10
            r13.add(r14, r15)
            int[] r13 = com.airbnb.lottie.model.layer.CompositionLayer.AnonymousClass1.$SwitchMap$com$airbnb$lottie$model$layer$Layer$MatteType
            r14 = r9
            com.airbnb.lottie.model.layer.Layer$MatteType r14 = r14.getMatteType()
            int r14 = r14.ordinal()
            r13 = r13[r14]
            switch(r13) {
                case 1: goto L_0x00cb;
                case 2: goto L_0x00cb;
                default: goto L_0x00ca;
            }
        L_0x00ca:
            goto L_0x0090
        L_0x00cb:
            r13 = r10
            r7 = r13
            goto L_0x0090
        L_0x00ce:
            r13 = 0
            r8 = r13
        L_0x00d0:
            r13 = r8
            r14 = r6
            int r14 = r14.size()
            if (r13 >= r14) goto L_0x0108
            r13 = r6
            r14 = r8
            long r13 = r13.keyAt(r14)
            r9 = r13
            r13 = r6
            r14 = r9
            java.lang.Object r13 = r13.get(r14)
            com.airbnb.lottie.model.layer.BaseLayer r13 = (com.airbnb.lottie.model.layer.BaseLayer) r13
            r11 = r13
            r13 = r11
            if (r13 != 0) goto L_0x00ee
        L_0x00eb:
            int r8 = r8 + 1
            goto L_0x00d0
        L_0x00ee:
            r13 = r6
            r14 = r11
            com.airbnb.lottie.model.layer.Layer r14 = r14.getLayerModel()
            long r14 = r14.getParentId()
            java.lang.Object r13 = r13.get(r14)
            com.airbnb.lottie.model.layer.BaseLayer r13 = (com.airbnb.lottie.model.layer.BaseLayer) r13
            r12 = r13
            r13 = r12
            if (r13 == 0) goto L_0x00eb
            r13 = r11
            r14 = r12
            r13.setParentLayer(r14)
            goto L_0x00eb
        L_0x0108:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.model.layer.CompositionLayer.<init>(com.airbnb.lottie.LottieDrawable, com.airbnb.lottie.model.layer.Layer, java.util.List, com.airbnb.lottie.LottieComposition):void");
    }

    /* access modifiers changed from: package-private */
    public void drawLayer(Canvas canvas, Matrix matrix, int i) {
        Canvas canvas2 = canvas;
        Matrix parentMatrix = matrix;
        int parentAlpha = i;
        L.beginSection("CompositionLayer#draw");
        int save = canvas2.save();
        this.newClipRect.set(0.0f, 0.0f, (float) this.layerModel.getPreCompWidth(), (float) this.layerModel.getPreCompHeight());
        boolean mapRect = parentMatrix.mapRect(this.newClipRect);
        for (int i2 = this.layers.size() - 1; i2 >= 0; i2--) {
            boolean nonEmptyClip = true;
            if (!this.newClipRect.isEmpty()) {
                nonEmptyClip = canvas2.clipRect(this.newClipRect);
            }
            if (nonEmptyClip) {
                this.layers.get(i2).draw(canvas2, parentMatrix, parentAlpha);
            }
        }
        canvas2.restore();
        float endSection = L.endSection("CompositionLayer#draw");
    }

    public void getBounds(RectF rectF, Matrix parentMatrix, boolean applyParents) {
        RectF outBounds = rectF;
        super.getBounds(outBounds, parentMatrix, applyParents);
        for (int i = this.layers.size() - 1; i >= 0; i--) {
            this.rect.set(0.0f, 0.0f, 0.0f, 0.0f);
            this.layers.get(i).getBounds(this.rect, this.boundsMatrix, true);
            outBounds.union(this.rect);
        }
    }

    public void setProgress(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        float progress = f;
        super.setProgress(progress);
        if (this.timeRemapping != null) {
            progress = ((float) ((long) (this.timeRemapping.getValue().floatValue() * 1000.0f))) / this.lottieDrawable.getComposition().getDuration();
        }
        if (this.layerModel.getTimeStretch() != 0.0f) {
            progress /= this.layerModel.getTimeStretch();
        }
        float progress2 = progress - this.layerModel.getStartProgress();
        for (int i = this.layers.size() - 1; i >= 0; i--) {
            this.layers.get(i).setProgress(progress2);
        }
    }

    public boolean hasMasks() {
        if (this.hasMasks == null) {
            for (int i = this.layers.size() - 1; i >= 0; i--) {
                BaseLayer layer = this.layers.get(i);
                if (layer instanceof ShapeLayer) {
                    if (layer.hasMasksOnThisLayer()) {
                        this.hasMasks = true;
                        return true;
                    }
                } else if ((layer instanceof CompositionLayer) && ((CompositionLayer) layer).hasMasks()) {
                    this.hasMasks = true;
                    return true;
                }
            }
            this.hasMasks = false;
        }
        return this.hasMasks.booleanValue();
    }

    public boolean hasMatte() {
        if (this.hasMatte == null) {
            if (hasMatteOnThisLayer()) {
                this.hasMatte = true;
                return true;
            }
            for (int i = this.layers.size() - 1; i >= 0; i--) {
                if (this.layers.get(i).hasMatteOnThisLayer()) {
                    this.hasMatte = true;
                    return true;
                }
            }
            this.hasMatte = false;
        }
        return this.hasMatte.booleanValue();
    }

    /* access modifiers changed from: protected */
    public void resolveChildKeyPath(KeyPath keyPath, int i, List<KeyPath> list, KeyPath keyPath2) {
        KeyPath keyPath3 = keyPath;
        int depth = i;
        List<KeyPath> accumulator = list;
        KeyPath currentPartialKeyPath = keyPath2;
        for (int i2 = 0; i2 < this.layers.size(); i2++) {
            this.layers.get(i2).resolveKeyPath(keyPath3, depth, accumulator, currentPartialKeyPath);
        }
    }

    public <T> void addValueCallback(T t, @Nullable LottieValueCallback<T> lottieValueCallback) {
        BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation;
        T property = t;
        LottieValueCallback<T> callback = lottieValueCallback;
        super.addValueCallback(property, callback);
        if (property != LottieProperty.TIME_REMAP) {
            return;
        }
        if (callback == null) {
            this.timeRemapping = null;
            return;
        }
        new ValueCallbackKeyframeAnimation(callback);
        this.timeRemapping = baseKeyframeAnimation;
        addAnimation(this.timeRemapping);
    }
}
