package com.airbnb.lottie.model.layer;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Xfermode;
import android.os.Build;
import androidx.annotation.CallSuper;
import androidx.annotation.FloatRange;
import androidx.annotation.Nullable;
import com.airbnb.lottie.L;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.LPaint;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.DrawingContent;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.FloatKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.MaskKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.TransformKeyframeAnimation;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.KeyPathElement;
import com.airbnb.lottie.model.content.Mask;
import com.airbnb.lottie.model.content.ShapeData;
import com.airbnb.lottie.model.layer.Layer;
import com.airbnb.lottie.utils.Logger;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class BaseLayer implements DrawingContent, BaseKeyframeAnimation.AnimationListener, KeyPathElement {
    private static final int CLIP_SAVE_FLAG = 2;
    private static final int CLIP_TO_LAYER_SAVE_FLAG = 16;
    private static final int MATRIX_SAVE_FLAG = 1;
    private static final int SAVE_FLAGS = 19;
    private final List<BaseKeyframeAnimation<?, ?>> animations;
    final Matrix boundsMatrix;
    private final Paint clearPaint;
    private final Paint contentPaint;
    private final String drawTraceName;
    private final Paint dstInPaint;
    private final Paint dstOutPaint;
    final Layer layerModel;
    final LottieDrawable lottieDrawable;
    @Nullable
    private MaskKeyframeAnimation mask;
    private final RectF maskBoundsRect;
    private final Matrix matrix;
    private final RectF matteBoundsRect;
    @Nullable
    private BaseLayer matteLayer;
    private final Paint mattePaint;
    @Nullable
    private BaseLayer parentLayer;
    private List<BaseLayer> parentLayers;
    private final Path path;
    private final RectF rect;
    private final RectF tempMaskBoundsRect;
    final TransformKeyframeAnimation transform;
    private boolean visible = true;

    /* access modifiers changed from: package-private */
    public abstract void drawLayer(Canvas canvas, Matrix matrix2, int i);

    @Nullable
    static BaseLayer forModel(Layer layer, LottieDrawable lottieDrawable2, LottieComposition lottieComposition) {
        BaseLayer baseLayer;
        BaseLayer baseLayer2;
        BaseLayer baseLayer3;
        BaseLayer baseLayer4;
        BaseLayer baseLayer5;
        BaseLayer baseLayer6;
        StringBuilder sb;
        Layer layerModel2 = layer;
        LottieDrawable drawable = lottieDrawable2;
        LottieComposition composition = lottieComposition;
        switch (layerModel2.getLayerType()) {
            case SHAPE:
                new ShapeLayer(drawable, layerModel2);
                return baseLayer6;
            case PRE_COMP:
                new CompositionLayer(drawable, layerModel2, composition.getPrecomps(layerModel2.getRefId()), composition);
                return baseLayer5;
            case SOLID:
                new SolidLayer(drawable, layerModel2);
                return baseLayer4;
            case IMAGE:
                new ImageLayer(drawable, layerModel2);
                return baseLayer3;
            case NULL:
                new NullLayer(drawable, layerModel2);
                return baseLayer2;
            case TEXT:
                new TextLayer(drawable, layerModel2);
                return baseLayer;
            default:
                new StringBuilder();
                Logger.warning(sb.append("Unknown layer type ").append(layerModel2.getLayerType()).toString());
                return null;
        }
    }

    BaseLayer(LottieDrawable lottieDrawable2, Layer layer) {
        Path path2;
        Matrix matrix2;
        Paint paint;
        Paint paint2;
        Paint paint3;
        Paint paint4;
        Paint paint5;
        RectF rectF;
        RectF rectF2;
        RectF rectF3;
        RectF rectF4;
        Matrix matrix3;
        List<BaseKeyframeAnimation<?, ?>> list;
        StringBuilder sb;
        Xfermode xfermode;
        MaskKeyframeAnimation maskKeyframeAnimation;
        Xfermode xfermode2;
        Layer layerModel2 = layer;
        new Path();
        this.path = path2;
        new Matrix();
        this.matrix = matrix2;
        new LPaint(1);
        this.contentPaint = paint;
        new LPaint(1, PorterDuff.Mode.DST_IN);
        this.dstInPaint = paint2;
        new LPaint(1, PorterDuff.Mode.DST_OUT);
        this.dstOutPaint = paint3;
        new LPaint(1);
        this.mattePaint = paint4;
        new LPaint(PorterDuff.Mode.CLEAR);
        this.clearPaint = paint5;
        new RectF();
        this.rect = rectF;
        new RectF();
        this.maskBoundsRect = rectF2;
        new RectF();
        this.matteBoundsRect = rectF3;
        new RectF();
        this.tempMaskBoundsRect = rectF4;
        new Matrix();
        this.boundsMatrix = matrix3;
        new ArrayList();
        this.animations = list;
        this.lottieDrawable = lottieDrawable2;
        this.layerModel = layerModel2;
        new StringBuilder();
        this.drawTraceName = sb.append(layerModel2.getName()).append("#draw").toString();
        if (layerModel2.getMatteType() == Layer.MatteType.INVERT) {
            new PorterDuffXfermode(PorterDuff.Mode.DST_OUT);
            Xfermode xfermode3 = this.mattePaint.setXfermode(xfermode2);
        } else {
            new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
            Xfermode xfermode4 = this.mattePaint.setXfermode(xfermode);
        }
        this.transform = layerModel2.getTransform().createAnimation();
        this.transform.addListener(this);
        if (layerModel2.getMasks() != null && !layerModel2.getMasks().isEmpty()) {
            new MaskKeyframeAnimation(layerModel2.getMasks());
            this.mask = maskKeyframeAnimation;
            for (BaseKeyframeAnimation<ShapeData, Path> addUpdateListener : this.mask.getMaskAnimations()) {
                addUpdateListener.addUpdateListener(this);
            }
            for (BaseKeyframeAnimation<Integer, Integer> animation : this.mask.getOpacityAnimations()) {
                addAnimation(animation);
                animation.addUpdateListener(this);
            }
        }
        setupInOutAnimations();
    }

    public void onValueChanged() {
        invalidateSelf();
    }

    /* access modifiers changed from: package-private */
    public Layer getLayerModel() {
        return this.layerModel;
    }

    /* access modifiers changed from: package-private */
    public void setMatteLayer(@Nullable BaseLayer matteLayer2) {
        BaseLayer baseLayer = matteLayer2;
        this.matteLayer = baseLayer;
    }

    /* access modifiers changed from: package-private */
    public boolean hasMatteOnThisLayer() {
        return this.matteLayer != null;
    }

    /* access modifiers changed from: package-private */
    public void setParentLayer(@Nullable BaseLayer parentLayer2) {
        BaseLayer baseLayer = parentLayer2;
        this.parentLayer = baseLayer;
    }

    private void setupInOutAnimations() {
        FloatKeyframeAnimation floatKeyframeAnimation;
        BaseKeyframeAnimation.AnimationListener animationListener;
        if (!this.layerModel.getInOutKeyframes().isEmpty()) {
            new FloatKeyframeAnimation(this.layerModel.getInOutKeyframes());
            FloatKeyframeAnimation inOutAnimation = floatKeyframeAnimation;
            inOutAnimation.setIsDiscrete();
            final FloatKeyframeAnimation floatKeyframeAnimation2 = inOutAnimation;
            new BaseKeyframeAnimation.AnimationListener(this) {
                final /* synthetic */ BaseLayer this$0;

                {
                    this.this$0 = this$0;
                }

                public void onValueChanged() {
                    this.this$0.setVisible(floatKeyframeAnimation2.getFloatValue() == 1.0f);
                }
            };
            inOutAnimation.addUpdateListener(animationListener);
            setVisible(((Float) inOutAnimation.getValue()).floatValue() == 1.0f);
            addAnimation(inOutAnimation);
            return;
        }
        setVisible(true);
    }

    private void invalidateSelf() {
        this.lottieDrawable.invalidateSelf();
    }

    @SuppressLint({"WrongConstant"})
    private void saveLayerCompat(Canvas canvas, RectF rectF, Paint paint, boolean z) {
        Canvas canvas2 = canvas;
        RectF rect2 = rectF;
        Paint paint2 = paint;
        boolean all = z;
        if (Build.VERSION.SDK_INT < 23) {
            int saveLayer = canvas2.saveLayer(rect2, paint2, all ? 31 : 19);
        } else {
            int saveLayer2 = canvas2.saveLayer(rect2, paint2);
        }
    }

    public void addAnimation(@Nullable BaseKeyframeAnimation<?, ?> baseKeyframeAnimation) {
        BaseKeyframeAnimation<?, ?> newAnimation = baseKeyframeAnimation;
        if (newAnimation != null) {
            boolean add = this.animations.add(newAnimation);
        }
    }

    public void removeAnimation(BaseKeyframeAnimation<?, ?> animation) {
        boolean remove = this.animations.remove(animation);
    }

    @CallSuper
    public void getBounds(RectF rectF, Matrix parentMatrix, boolean applyParents) {
        RectF rectF2 = rectF;
        this.rect.set(0.0f, 0.0f, 0.0f, 0.0f);
        buildParentLayerListIfNeeded();
        this.boundsMatrix.set(parentMatrix);
        if (applyParents) {
            if (this.parentLayers != null) {
                for (int i = this.parentLayers.size() - 1; i >= 0; i--) {
                    boolean preConcat = this.boundsMatrix.preConcat(this.parentLayers.get(i).transform.getMatrix());
                }
            } else if (this.parentLayer != null) {
                boolean preConcat2 = this.boundsMatrix.preConcat(this.parentLayer.transform.getMatrix());
            }
        }
        boolean preConcat3 = this.boundsMatrix.preConcat(this.transform.getMatrix());
    }

    public void draw(Canvas canvas, Matrix matrix2, int i) {
        int i2;
        Canvas canvas2 = canvas;
        Matrix parentMatrix = matrix2;
        int parentAlpha = i;
        L.beginSection(this.drawTraceName);
        if (!this.visible || this.layerModel.isHidden()) {
            float endSection = L.endSection(this.drawTraceName);
            return;
        }
        buildParentLayerListIfNeeded();
        L.beginSection("Layer#parentMatrix");
        this.matrix.reset();
        this.matrix.set(parentMatrix);
        for (int i3 = this.parentLayers.size() - 1; i3 >= 0; i3--) {
            boolean preConcat = this.matrix.preConcat(this.parentLayers.get(i3).transform.getMatrix());
        }
        float endSection2 = L.endSection("Layer#parentMatrix");
        if (this.transform.getOpacity() == null) {
            i2 = 100;
        } else {
            i2 = this.transform.getOpacity().getValue().intValue();
        }
        int alpha = (int) ((((((float) parentAlpha) / 255.0f) * ((float) i2)) / 100.0f) * 255.0f);
        if (hasMatteOnThisLayer() || hasMasksOnThisLayer()) {
            L.beginSection("Layer#computeBounds");
            getBounds(this.rect, this.matrix, false);
            intersectBoundsWithMatte(this.rect, parentMatrix);
            boolean preConcat2 = this.matrix.preConcat(this.transform.getMatrix());
            intersectBoundsWithMask(this.rect, this.matrix);
            float endSection3 = L.endSection("Layer#computeBounds");
            if (!this.rect.isEmpty()) {
                L.beginSection("Layer#saveLayer");
                saveLayerCompat(canvas2, this.rect, this.contentPaint, true);
                float endSection4 = L.endSection("Layer#saveLayer");
                clearCanvas(canvas2);
                L.beginSection("Layer#drawLayer");
                drawLayer(canvas2, this.matrix, alpha);
                float endSection5 = L.endSection("Layer#drawLayer");
                if (hasMasksOnThisLayer()) {
                    applyMasks(canvas2, this.matrix);
                }
                if (hasMatteOnThisLayer()) {
                    L.beginSection("Layer#drawMatte");
                    L.beginSection("Layer#saveLayer");
                    saveLayerCompat(canvas2, this.rect, this.mattePaint, false);
                    float endSection6 = L.endSection("Layer#saveLayer");
                    clearCanvas(canvas2);
                    this.matteLayer.draw(canvas2, parentMatrix, alpha);
                    L.beginSection("Layer#restoreLayer");
                    canvas2.restore();
                    float endSection7 = L.endSection("Layer#restoreLayer");
                    float endSection8 = L.endSection("Layer#drawMatte");
                }
                L.beginSection("Layer#restoreLayer");
                canvas2.restore();
                float endSection9 = L.endSection("Layer#restoreLayer");
            }
            recordRenderTime(L.endSection(this.drawTraceName));
            return;
        }
        boolean preConcat3 = this.matrix.preConcat(this.transform.getMatrix());
        L.beginSection("Layer#drawLayer");
        drawLayer(canvas2, this.matrix, alpha);
        float endSection10 = L.endSection("Layer#drawLayer");
        recordRenderTime(L.endSection(this.drawTraceName));
    }

    private void recordRenderTime(float ms) {
        this.lottieDrawable.getComposition().getPerformanceTracker().recordRenderTime(this.layerModel.getName(), ms);
    }

    private void clearCanvas(Canvas canvas) {
        L.beginSection("Layer#clearLayer");
        canvas.drawRect(this.rect.left - 1.0f, this.rect.top - 1.0f, this.rect.right + 1.0f, this.rect.bottom + 1.0f, this.clearPaint);
        float endSection = L.endSection("Layer#clearLayer");
    }

    private void intersectBoundsWithMask(RectF rectF, Matrix matrix2) {
        RectF rect2 = rectF;
        Matrix matrix3 = matrix2;
        this.maskBoundsRect.set(0.0f, 0.0f, 0.0f, 0.0f);
        if (hasMasksOnThisLayer()) {
            int size = this.mask.getMasks().size();
            for (int i = 0; i < size; i++) {
                Mask mask2 = this.mask.getMasks().get(i);
                this.path.set((Path) this.mask.getMaskAnimations().get(i).getValue());
                this.path.transform(matrix3);
                switch (mask2.getMaskMode()) {
                    case MASK_MODE_SUBTRACT:
                        return;
                    case MASK_MODE_INTERSECT:
                    case MASK_MODE_ADD:
                        if (mask2.isInverted()) {
                            return;
                        }
                        break;
                }
                this.path.computeBounds(this.tempMaskBoundsRect, false);
                if (i == 0) {
                    this.maskBoundsRect.set(this.tempMaskBoundsRect);
                } else {
                    this.maskBoundsRect.set(Math.min(this.maskBoundsRect.left, this.tempMaskBoundsRect.left), Math.min(this.maskBoundsRect.top, this.tempMaskBoundsRect.top), Math.max(this.maskBoundsRect.right, this.tempMaskBoundsRect.right), Math.max(this.maskBoundsRect.bottom, this.tempMaskBoundsRect.bottom));
                }
            }
            if (rect2.intersect(this.maskBoundsRect) == 0) {
                rect2.set(0.0f, 0.0f, 0.0f, 0.0f);
            }
        }
    }

    private void intersectBoundsWithMatte(RectF rectF, Matrix matrix2) {
        RectF rect2 = rectF;
        Matrix matrix3 = matrix2;
        if (hasMatteOnThisLayer() && this.layerModel.getMatteType() != Layer.MatteType.INVERT) {
            this.matteBoundsRect.set(0.0f, 0.0f, 0.0f, 0.0f);
            this.matteLayer.getBounds(this.matteBoundsRect, matrix3, true);
            if (!rect2.intersect(this.matteBoundsRect)) {
                rect2.set(0.0f, 0.0f, 0.0f, 0.0f);
            }
        }
    }

    private void applyMasks(Canvas canvas, Matrix matrix2) {
        Paint paint;
        Canvas canvas2 = canvas;
        Matrix matrix3 = matrix2;
        L.beginSection("Layer#saveLayer");
        saveLayerCompat(canvas2, this.rect, this.dstInPaint, false);
        float endSection = L.endSection("Layer#saveLayer");
        for (int i = 0; i < this.mask.getMasks().size(); i++) {
            Mask mask2 = this.mask.getMasks().get(i);
            BaseKeyframeAnimation<ShapeData, Path> maskAnimation = this.mask.getMaskAnimations().get(i);
            BaseKeyframeAnimation<Integer, Integer> opacityAnimation = this.mask.getOpacityAnimations().get(i);
            switch (mask2.getMaskMode()) {
                case MASK_MODE_SUBTRACT:
                    if (i == 0) {
                        new Paint();
                        Paint paint2 = paint;
                        paint2.setColor(-16777216);
                        canvas2.drawRect(this.rect, paint2);
                    }
                    if (!mask2.isInverted()) {
                        applySubtractMask(canvas2, matrix3, mask2, maskAnimation, opacityAnimation);
                        break;
                    } else {
                        applyInvertedSubtractMask(canvas2, matrix3, mask2, maskAnimation, opacityAnimation);
                        break;
                    }
                case MASK_MODE_INTERSECT:
                    if (!mask2.isInverted()) {
                        applyIntersectMask(canvas2, matrix3, mask2, maskAnimation, opacityAnimation);
                        break;
                    } else {
                        applyInvertedIntersectMask(canvas2, matrix3, mask2, maskAnimation, opacityAnimation);
                        break;
                    }
                case MASK_MODE_ADD:
                    if (!mask2.isInverted()) {
                        applyAddMask(canvas2, matrix3, mask2, maskAnimation, opacityAnimation);
                        break;
                    } else {
                        applyInvertedAddMask(canvas2, matrix3, mask2, maskAnimation, opacityAnimation);
                        break;
                    }
            }
        }
        L.beginSection("Layer#restoreLayer");
        canvas2.restore();
        float endSection2 = L.endSection("Layer#restoreLayer");
    }

    private void applyAddMask(Canvas canvas, Matrix matrix2, Mask mask2, BaseKeyframeAnimation<ShapeData, Path> maskAnimation, BaseKeyframeAnimation<Integer, Integer> opacityAnimation) {
        Mask mask3 = mask2;
        this.path.set(maskAnimation.getValue());
        this.path.transform(matrix2);
        this.contentPaint.setAlpha((int) (((float) opacityAnimation.getValue().intValue()) * 2.55f));
        canvas.drawPath(this.path, this.contentPaint);
    }

    private void applyInvertedAddMask(Canvas canvas, Matrix matrix2, Mask mask2, BaseKeyframeAnimation<ShapeData, Path> maskAnimation, BaseKeyframeAnimation<Integer, Integer> opacityAnimation) {
        Canvas canvas2 = canvas;
        Mask mask3 = mask2;
        saveLayerCompat(canvas2, this.rect, this.contentPaint, true);
        canvas2.drawRect(this.rect, this.contentPaint);
        this.path.set(maskAnimation.getValue());
        this.path.transform(matrix2);
        this.contentPaint.setAlpha((int) (((float) opacityAnimation.getValue().intValue()) * 2.55f));
        canvas2.drawPath(this.path, this.dstOutPaint);
        canvas2.restore();
    }

    private void applySubtractMask(Canvas canvas, Matrix matrix2, Mask mask2, BaseKeyframeAnimation<ShapeData, Path> maskAnimation, BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation) {
        Mask mask3 = mask2;
        BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation2 = baseKeyframeAnimation;
        this.path.set(maskAnimation.getValue());
        this.path.transform(matrix2);
        canvas.drawPath(this.path, this.dstOutPaint);
    }

    private void applyInvertedSubtractMask(Canvas canvas, Matrix matrix2, Mask mask2, BaseKeyframeAnimation<ShapeData, Path> maskAnimation, BaseKeyframeAnimation<Integer, Integer> opacityAnimation) {
        Canvas canvas2 = canvas;
        Mask mask3 = mask2;
        saveLayerCompat(canvas2, this.rect, this.dstOutPaint, true);
        canvas2.drawRect(this.rect, this.contentPaint);
        this.dstOutPaint.setAlpha((int) (((float) opacityAnimation.getValue().intValue()) * 2.55f));
        this.path.set(maskAnimation.getValue());
        this.path.transform(matrix2);
        canvas2.drawPath(this.path, this.dstOutPaint);
        canvas2.restore();
    }

    private void applyIntersectMask(Canvas canvas, Matrix matrix2, Mask mask2, BaseKeyframeAnimation<ShapeData, Path> maskAnimation, BaseKeyframeAnimation<Integer, Integer> opacityAnimation) {
        Canvas canvas2 = canvas;
        Mask mask3 = mask2;
        saveLayerCompat(canvas2, this.rect, this.dstInPaint, true);
        this.path.set(maskAnimation.getValue());
        this.path.transform(matrix2);
        this.contentPaint.setAlpha((int) (((float) opacityAnimation.getValue().intValue()) * 2.55f));
        canvas2.drawPath(this.path, this.contentPaint);
        canvas2.restore();
    }

    private void applyInvertedIntersectMask(Canvas canvas, Matrix matrix2, Mask mask2, BaseKeyframeAnimation<ShapeData, Path> maskAnimation, BaseKeyframeAnimation<Integer, Integer> opacityAnimation) {
        Canvas canvas2 = canvas;
        Mask mask3 = mask2;
        saveLayerCompat(canvas2, this.rect, this.dstInPaint, true);
        canvas2.drawRect(this.rect, this.contentPaint);
        this.dstOutPaint.setAlpha((int) (((float) opacityAnimation.getValue().intValue()) * 2.55f));
        this.path.set(maskAnimation.getValue());
        this.path.transform(matrix2);
        canvas2.drawPath(this.path, this.dstOutPaint);
        canvas2.restore();
    }

    /* access modifiers changed from: package-private */
    public boolean hasMasksOnThisLayer() {
        return this.mask != null && !this.mask.getMaskAnimations().isEmpty();
    }

    /* access modifiers changed from: private */
    public void setVisible(boolean z) {
        boolean visible2 = z;
        if (visible2 != this.visible) {
            this.visible = visible2;
            invalidateSelf();
        }
    }

    /* access modifiers changed from: package-private */
    public void setProgress(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        float progress = f;
        this.transform.setProgress(progress);
        if (this.mask != null) {
            for (int i = 0; i < this.mask.getMaskAnimations().size(); i++) {
                this.mask.getMaskAnimations().get(i).setProgress(progress);
            }
        }
        if (this.layerModel.getTimeStretch() != 0.0f) {
            progress /= this.layerModel.getTimeStretch();
        }
        if (this.matteLayer != null) {
            this.matteLayer.setProgress(progress * this.matteLayer.layerModel.getTimeStretch());
        }
        for (int i2 = 0; i2 < this.animations.size(); i2++) {
            this.animations.get(i2).setProgress(progress);
        }
    }

    private void buildParentLayerListIfNeeded() {
        List<BaseLayer> list;
        if (this.parentLayers == null) {
            if (this.parentLayer == null) {
                this.parentLayers = Collections.emptyList();
                return;
            }
            new ArrayList();
            this.parentLayers = list;
            BaseLayer baseLayer = this.parentLayer;
            while (true) {
                BaseLayer layer = baseLayer;
                if (layer != null) {
                    boolean add = this.parentLayers.add(layer);
                    baseLayer = layer.parentLayer;
                } else {
                    return;
                }
            }
        }
    }

    public String getName() {
        return this.layerModel.getName();
    }

    public void setContents(List<Content> list, List<Content> list2) {
    }

    public void resolveKeyPath(KeyPath keyPath, int i, List<KeyPath> list, KeyPath keyPath2) {
        KeyPath keyPath3 = keyPath;
        int depth = i;
        List<KeyPath> accumulator = list;
        KeyPath currentPartialKeyPath = keyPath2;
        if (keyPath3.matches(getName(), depth)) {
            if (!"__container".equals(getName())) {
                currentPartialKeyPath = currentPartialKeyPath.addKey(getName());
                if (keyPath3.fullyResolvesTo(getName(), depth)) {
                    boolean add = accumulator.add(currentPartialKeyPath.resolve(this));
                }
            }
            if (keyPath3.propagateToChildren(getName(), depth)) {
                resolveChildKeyPath(keyPath3, depth + keyPath3.incrementDepthBy(getName(), depth), accumulator, currentPartialKeyPath);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void resolveChildKeyPath(KeyPath keyPath, int depth, List<KeyPath> list, KeyPath currentPartialKeyPath) {
    }

    @CallSuper
    public <T> void addValueCallback(T property, @Nullable LottieValueCallback<T> callback) {
        boolean applyValueCallback = this.transform.applyValueCallback(property, callback);
    }
}
