package com.airbnb.lottie.animation.content;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathEffect;
import android.graphics.PathMeasure;
import android.graphics.RectF;
import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import com.airbnb.lottie.L;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.LPaint;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.FloatKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.IntegerKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.ValueCallbackKeyframeAnimation;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableIntegerValue;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.utils.Utils;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseStrokeContent implements BaseKeyframeAnimation.AnimationListener, KeyPathElementContent, DrawingContent {
    @Nullable
    private BaseKeyframeAnimation<ColorFilter, ColorFilter> colorFilterAnimation;
    private final List<BaseKeyframeAnimation<?, Float>> dashPatternAnimations;
    @Nullable
    private final BaseKeyframeAnimation<?, Float> dashPatternOffsetAnimation;
    private final float[] dashPatternValues;
    protected final BaseLayer layer;
    private final LottieDrawable lottieDrawable;
    private final BaseKeyframeAnimation<?, Integer> opacityAnimation;
    final Paint paint;
    private final Path path;
    private final List<PathGroup> pathGroups;
    private final PathMeasure pm;
    private final RectF rect;
    private final Path trimPathPath;
    private final BaseKeyframeAnimation<?, Float> widthAnimation;

    BaseStrokeContent(LottieDrawable lottieDrawable2, BaseLayer baseLayer, Paint.Cap cap, Paint.Join join, float miterLimit, AnimatableIntegerValue opacity, AnimatableFloatValue width, List<AnimatableFloatValue> list, AnimatableFloatValue animatableFloatValue) {
        PathMeasure pathMeasure;
        Path path2;
        Path path3;
        RectF rectF;
        List<PathGroup> list2;
        Paint paint2;
        List<BaseKeyframeAnimation<?, Float>> list3;
        BaseLayer layer2 = baseLayer;
        List<AnimatableFloatValue> dashPattern = list;
        AnimatableFloatValue offset = animatableFloatValue;
        new PathMeasure();
        this.pm = pathMeasure;
        new Path();
        this.path = path2;
        new Path();
        this.trimPathPath = path3;
        new RectF();
        this.rect = rectF;
        new ArrayList();
        this.pathGroups = list2;
        new LPaint(1);
        this.paint = paint2;
        this.lottieDrawable = lottieDrawable2;
        this.layer = layer2;
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setStrokeCap(cap);
        this.paint.setStrokeJoin(join);
        this.paint.setStrokeMiter(miterLimit);
        this.opacityAnimation = opacity.createAnimation();
        this.widthAnimation = width.createAnimation();
        if (offset == null) {
            this.dashPatternOffsetAnimation = null;
        } else {
            this.dashPatternOffsetAnimation = offset.createAnimation();
        }
        new ArrayList(dashPattern.size());
        this.dashPatternAnimations = list3;
        this.dashPatternValues = new float[dashPattern.size()];
        for (int i = 0; i < dashPattern.size(); i++) {
            boolean add = this.dashPatternAnimations.add(dashPattern.get(i).createAnimation());
        }
        layer2.addAnimation(this.opacityAnimation);
        layer2.addAnimation(this.widthAnimation);
        for (int i2 = 0; i2 < this.dashPatternAnimations.size(); i2++) {
            layer2.addAnimation(this.dashPatternAnimations.get(i2));
        }
        if (this.dashPatternOffsetAnimation != null) {
            layer2.addAnimation(this.dashPatternOffsetAnimation);
        }
        this.opacityAnimation.addUpdateListener(this);
        this.widthAnimation.addUpdateListener(this);
        for (int i3 = 0; i3 < dashPattern.size(); i3++) {
            this.dashPatternAnimations.get(i3).addUpdateListener(this);
        }
        if (this.dashPatternOffsetAnimation != null) {
            this.dashPatternOffsetAnimation.addUpdateListener(this);
        }
    }

    public void onValueChanged() {
        this.lottieDrawable.invalidateSelf();
    }

    public void setContents(List<Content> list, List<Content> list2) {
        PathGroup pathGroup;
        PathGroup pathGroup2;
        List<Content> contentsBefore = list;
        List<Content> contentsAfter = list2;
        TrimPathContent trimPathContentBefore = null;
        for (int i = contentsBefore.size() - 1; i >= 0; i--) {
            Content content = contentsBefore.get(i);
            if ((content instanceof TrimPathContent) && ((TrimPathContent) content).getType() == ShapeTrimPath.Type.INDIVIDUALLY) {
                trimPathContentBefore = (TrimPathContent) content;
            }
        }
        if (trimPathContentBefore != null) {
            trimPathContentBefore.addListener(this);
        }
        PathGroup currentPathGroup = null;
        for (int i2 = contentsAfter.size() - 1; i2 >= 0; i2--) {
            Content content2 = contentsAfter.get(i2);
            if ((content2 instanceof TrimPathContent) && ((TrimPathContent) content2).getType() == ShapeTrimPath.Type.INDIVIDUALLY) {
                if (currentPathGroup != null) {
                    boolean add = this.pathGroups.add(currentPathGroup);
                }
                new PathGroup((TrimPathContent) content2, (AnonymousClass1) null);
                currentPathGroup = pathGroup2;
                ((TrimPathContent) content2).addListener(this);
            } else if (content2 instanceof PathContent) {
                if (currentPathGroup == null) {
                    new PathGroup(trimPathContentBefore, (AnonymousClass1) null);
                    currentPathGroup = pathGroup;
                }
                boolean add2 = currentPathGroup.paths.add((PathContent) content2);
            }
        }
        if (currentPathGroup != null) {
            boolean add3 = this.pathGroups.add(currentPathGroup);
        }
    }

    public void draw(Canvas canvas, Matrix matrix, int i) {
        Canvas canvas2 = canvas;
        Matrix parentMatrix = matrix;
        int parentAlpha = i;
        L.beginSection("StrokeContent#draw");
        if (Utils.hasZeroScaleAxis(parentMatrix)) {
            float endSection = L.endSection("StrokeContent#draw");
            return;
        }
        this.paint.setAlpha(MiscUtils.clamp((int) ((((((float) parentAlpha) / 255.0f) * ((float) ((IntegerKeyframeAnimation) this.opacityAnimation).getIntValue())) / 100.0f) * 255.0f), 0, 255));
        this.paint.setStrokeWidth(((FloatKeyframeAnimation) this.widthAnimation).getFloatValue() * Utils.getScale(parentMatrix));
        if (this.paint.getStrokeWidth() <= 0.0f) {
            float endSection2 = L.endSection("StrokeContent#draw");
            return;
        }
        applyDashPatternIfNeeded(parentMatrix);
        if (this.colorFilterAnimation != null) {
            ColorFilter colorFilter = this.paint.setColorFilter(this.colorFilterAnimation.getValue());
        }
        for (int i2 = 0; i2 < this.pathGroups.size(); i2++) {
            PathGroup pathGroup = this.pathGroups.get(i2);
            if (pathGroup.trimPath != null) {
                applyTrimPath(canvas2, pathGroup, parentMatrix);
            } else {
                L.beginSection("StrokeContent#buildPath");
                this.path.reset();
                for (int j = pathGroup.paths.size() - 1; j >= 0; j--) {
                    this.path.addPath(((PathContent) pathGroup.paths.get(j)).getPath(), parentMatrix);
                }
                float endSection3 = L.endSection("StrokeContent#buildPath");
                L.beginSection("StrokeContent#drawPath");
                canvas2.drawPath(this.path, this.paint);
                float endSection4 = L.endSection("StrokeContent#drawPath");
            }
        }
        float endSection5 = L.endSection("StrokeContent#draw");
    }

    private void applyTrimPath(Canvas canvas, PathGroup pathGroup, Matrix matrix) {
        float totalLength;
        float startValue;
        float endValue;
        float startValue2;
        Canvas canvas2 = canvas;
        PathGroup pathGroup2 = pathGroup;
        Matrix parentMatrix = matrix;
        L.beginSection("StrokeContent#applyTrimPath");
        if (pathGroup2.trimPath == null) {
            float endSection = L.endSection("StrokeContent#applyTrimPath");
            return;
        }
        this.path.reset();
        for (int j = pathGroup2.paths.size() - 1; j >= 0; j--) {
            this.path.addPath(((PathContent) pathGroup2.paths.get(j)).getPath(), parentMatrix);
        }
        this.pm.setPath(this.path, false);
        float length = this.pm.getLength();
        while (true) {
            totalLength = length;
            if (!this.pm.nextContour()) {
                break;
            }
            length = totalLength + this.pm.getLength();
        }
        float offsetLength = (totalLength * pathGroup2.trimPath.getOffset().getValue().floatValue()) / 360.0f;
        float startLength = ((totalLength * pathGroup2.trimPath.getStart().getValue().floatValue()) / 100.0f) + offsetLength;
        float endLength = ((totalLength * pathGroup2.trimPath.getEnd().getValue().floatValue()) / 100.0f) + offsetLength;
        float currentLength = 0.0f;
        for (int j2 = pathGroup2.paths.size() - 1; j2 >= 0; j2--) {
            this.trimPathPath.set(((PathContent) pathGroup2.paths.get(j2)).getPath());
            this.trimPathPath.transform(parentMatrix);
            this.pm.setPath(this.trimPathPath, false);
            float length2 = this.pm.getLength();
            if (endLength > totalLength && endLength - totalLength < currentLength + length2 && currentLength < endLength - totalLength) {
                if (startLength > totalLength) {
                    startValue2 = (startLength - totalLength) / length2;
                } else {
                    startValue2 = 0.0f;
                }
                Utils.applyTrimPathIfNeeded(this.trimPathPath, startValue2, Math.min((endLength - totalLength) / length2, 1.0f), 0.0f);
                canvas2.drawPath(this.trimPathPath, this.paint);
            } else if (currentLength + length2 >= startLength && currentLength <= endLength) {
                if (currentLength + length2 > endLength || startLength >= currentLength) {
                    if (startLength < currentLength) {
                        startValue = 0.0f;
                    } else {
                        startValue = (startLength - currentLength) / length2;
                    }
                    if (endLength > currentLength + length2) {
                        endValue = 1.0f;
                    } else {
                        endValue = (endLength - currentLength) / length2;
                    }
                    Utils.applyTrimPathIfNeeded(this.trimPathPath, startValue, endValue, 0.0f);
                    canvas2.drawPath(this.trimPathPath, this.paint);
                } else {
                    canvas2.drawPath(this.trimPathPath, this.paint);
                }
            }
            currentLength += length2;
        }
        float endSection2 = L.endSection("StrokeContent#applyTrimPath");
    }

    public void getBounds(RectF rectF, Matrix matrix, boolean z) {
        RectF outBounds = rectF;
        Matrix parentMatrix = matrix;
        boolean z2 = z;
        L.beginSection("StrokeContent#getBounds");
        this.path.reset();
        for (int i = 0; i < this.pathGroups.size(); i++) {
            PathGroup pathGroup = this.pathGroups.get(i);
            for (int j = 0; j < pathGroup.paths.size(); j++) {
                this.path.addPath(((PathContent) pathGroup.paths.get(j)).getPath(), parentMatrix);
            }
        }
        this.path.computeBounds(this.rect, false);
        float width = ((FloatKeyframeAnimation) this.widthAnimation).getFloatValue();
        this.rect.set(this.rect.left - (width / 2.0f), this.rect.top - (width / 2.0f), this.rect.right + (width / 2.0f), this.rect.bottom + (width / 2.0f));
        outBounds.set(this.rect);
        outBounds.set(outBounds.left - 1.0f, outBounds.top - 1.0f, outBounds.right + 1.0f, outBounds.bottom + 1.0f);
        float endSection = L.endSection("StrokeContent#getBounds");
    }

    private void applyDashPatternIfNeeded(Matrix matrix) {
        PathEffect pathEffect;
        Matrix parentMatrix = matrix;
        L.beginSection("StrokeContent#applyDashPattern");
        if (this.dashPatternAnimations.isEmpty()) {
            float endSection = L.endSection("StrokeContent#applyDashPattern");
            return;
        }
        float scale = Utils.getScale(parentMatrix);
        for (int i = 0; i < this.dashPatternAnimations.size(); i++) {
            this.dashPatternValues[i] = ((Float) this.dashPatternAnimations.get(i).getValue()).floatValue();
            if (i % 2 == 0) {
                if (this.dashPatternValues[i] < 1.0f) {
                    this.dashPatternValues[i] = 1.0f;
                }
            } else if (this.dashPatternValues[i] < 0.1f) {
                this.dashPatternValues[i] = 0.1f;
            }
            float[] fArr = this.dashPatternValues;
            int i2 = i;
            fArr[i2] = fArr[i2] * scale;
        }
        new DashPathEffect(this.dashPatternValues, this.dashPatternOffsetAnimation == null ? 0.0f : this.dashPatternOffsetAnimation.getValue().floatValue());
        PathEffect pathEffect2 = this.paint.setPathEffect(pathEffect);
        float endSection2 = L.endSection("StrokeContent#applyDashPattern");
    }

    public void resolveKeyPath(KeyPath keyPath, int depth, List<KeyPath> accumulator, KeyPath currentPartialKeyPath) {
        MiscUtils.resolveKeyPath(keyPath, depth, accumulator, currentPartialKeyPath, this);
    }

    @CallSuper
    public <T> void addValueCallback(T t, @Nullable LottieValueCallback<T> lottieValueCallback) {
        BaseKeyframeAnimation<ColorFilter, ColorFilter> baseKeyframeAnimation;
        T property = t;
        LottieValueCallback<T> callback = lottieValueCallback;
        if (property == LottieProperty.OPACITY) {
            this.opacityAnimation.setValueCallback(callback);
        } else if (property == LottieProperty.STROKE_WIDTH) {
            this.widthAnimation.setValueCallback(callback);
        } else if (property != LottieProperty.COLOR_FILTER) {
        } else {
            if (callback == null) {
                this.colorFilterAnimation = null;
                return;
            }
            new ValueCallbackKeyframeAnimation(callback);
            this.colorFilterAnimation = baseKeyframeAnimation;
            this.colorFilterAnimation.addUpdateListener(this);
            this.layer.addAnimation(this.colorFilterAnimation);
        }
    }

    private static final class PathGroup {
        /* access modifiers changed from: private */
        public final List<PathContent> paths;
        /* access modifiers changed from: private */
        @Nullable
        public final TrimPathContent trimPath;

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        /* synthetic */ PathGroup(TrimPathContent x0, AnonymousClass1 r7) {
            this(x0);
            AnonymousClass1 r2 = r7;
        }

        private PathGroup(@Nullable TrimPathContent trimPath2) {
            List<PathContent> list;
            new ArrayList();
            this.paths = list;
            this.trimPath = trimPath2;
        }
    }
}
