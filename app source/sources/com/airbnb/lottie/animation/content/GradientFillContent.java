package com.airbnb.lottie.animation.content;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.LongSparseArray;
import com.airbnb.lottie.L;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.LPaint;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.ValueCallbackKeyframeAnimation;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.content.GradientColor;
import com.airbnb.lottie.model.content.GradientFill;
import com.airbnb.lottie.model.content.GradientType;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.ArrayList;
import java.util.List;

public class GradientFillContent implements DrawingContent, BaseKeyframeAnimation.AnimationListener, KeyPathElementContent {
    private static final int CACHE_STEPS_MS = 32;
    private final RectF boundsRect;
    private final int cacheSteps;
    private final BaseKeyframeAnimation<GradientColor, GradientColor> colorAnimation;
    @Nullable
    private ValueCallbackKeyframeAnimation colorCallbackAnimation;
    @Nullable
    private BaseKeyframeAnimation<ColorFilter, ColorFilter> colorFilterAnimation;
    private final BaseKeyframeAnimation<PointF, PointF> endPointAnimation;
    private final boolean hidden;
    private final BaseLayer layer;
    private final LongSparseArray<LinearGradient> linearGradientCache;
    private final LottieDrawable lottieDrawable;
    @NonNull
    private final String name;
    private final BaseKeyframeAnimation<Integer, Integer> opacityAnimation;
    private final Paint paint;
    private final Path path;
    private final List<PathContent> paths;
    private final LongSparseArray<RadialGradient> radialGradientCache;
    private final Matrix shaderMatrix;
    private final BaseKeyframeAnimation<PointF, PointF> startPointAnimation;
    private final GradientType type;

    public GradientFillContent(LottieDrawable lottieDrawable2, BaseLayer baseLayer, GradientFill gradientFill) {
        LongSparseArray<LinearGradient> longSparseArray;
        LongSparseArray<RadialGradient> longSparseArray2;
        Matrix matrix;
        Path path2;
        Paint paint2;
        RectF rectF;
        List<PathContent> list;
        LottieDrawable lottieDrawable3 = lottieDrawable2;
        BaseLayer layer2 = baseLayer;
        GradientFill fill = gradientFill;
        new LongSparseArray<>();
        this.linearGradientCache = longSparseArray;
        new LongSparseArray<>();
        this.radialGradientCache = longSparseArray2;
        new Matrix();
        this.shaderMatrix = matrix;
        new Path();
        this.path = path2;
        new LPaint(1);
        this.paint = paint2;
        new RectF();
        this.boundsRect = rectF;
        new ArrayList();
        this.paths = list;
        this.layer = layer2;
        this.name = fill.getName();
        this.hidden = fill.isHidden();
        this.lottieDrawable = lottieDrawable3;
        this.type = fill.getGradientType();
        this.path.setFillType(fill.getFillType());
        this.cacheSteps = (int) (lottieDrawable3.getComposition().getDuration() / 32.0f);
        this.colorAnimation = fill.getGradientColor().createAnimation();
        this.colorAnimation.addUpdateListener(this);
        layer2.addAnimation(this.colorAnimation);
        this.opacityAnimation = fill.getOpacity().createAnimation();
        this.opacityAnimation.addUpdateListener(this);
        layer2.addAnimation(this.opacityAnimation);
        this.startPointAnimation = fill.getStartPoint().createAnimation();
        this.startPointAnimation.addUpdateListener(this);
        layer2.addAnimation(this.startPointAnimation);
        this.endPointAnimation = fill.getEndPoint().createAnimation();
        this.endPointAnimation.addUpdateListener(this);
        layer2.addAnimation(this.endPointAnimation);
    }

    public void onValueChanged() {
        this.lottieDrawable.invalidateSelf();
    }

    public void setContents(List<Content> list, List<Content> list2) {
        List<Content> list3 = list;
        List<Content> contentsAfter = list2;
        for (int i = 0; i < contentsAfter.size(); i++) {
            Content content = contentsAfter.get(i);
            if (content instanceof PathContent) {
                boolean add = this.paths.add((PathContent) content);
            }
        }
    }

    public void draw(Canvas canvas, Matrix matrix, int i) {
        Shader shader;
        Canvas canvas2 = canvas;
        Matrix parentMatrix = matrix;
        int parentAlpha = i;
        if (!this.hidden) {
            L.beginSection("GradientFillContent#draw");
            this.path.reset();
            for (int i2 = 0; i2 < this.paths.size(); i2++) {
                this.path.addPath(this.paths.get(i2).getPath(), parentMatrix);
            }
            this.path.computeBounds(this.boundsRect, false);
            if (this.type == GradientType.LINEAR) {
                shader = getLinearGradient();
            } else {
                shader = getRadialGradient();
            }
            this.shaderMatrix.set(parentMatrix);
            shader.setLocalMatrix(this.shaderMatrix);
            Shader shader2 = this.paint.setShader(shader);
            if (this.colorFilterAnimation != null) {
                ColorFilter colorFilter = this.paint.setColorFilter(this.colorFilterAnimation.getValue());
            }
            this.paint.setAlpha(MiscUtils.clamp((int) ((((((float) parentAlpha) / 255.0f) * ((float) this.opacityAnimation.getValue().intValue())) / 100.0f) * 255.0f), 0, 255));
            canvas2.drawPath(this.path, this.paint);
            float endSection = L.endSection("GradientFillContent#draw");
        }
    }

    public void getBounds(RectF rectF, Matrix matrix, boolean z) {
        RectF outBounds = rectF;
        Matrix parentMatrix = matrix;
        boolean z2 = z;
        this.path.reset();
        for (int i = 0; i < this.paths.size(); i++) {
            this.path.addPath(this.paths.get(i).getPath(), parentMatrix);
        }
        this.path.computeBounds(outBounds, false);
        outBounds.set(outBounds.left - 1.0f, outBounds.top - 1.0f, outBounds.right + 1.0f, outBounds.bottom + 1.0f);
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
        new LinearGradient(startPoint.x, startPoint.y, endPoint.x, endPoint.y, applyDynamicColorsIfNeeded(gradientColor.getColors()), gradientColor.getPositions(), Shader.TileMode.CLAMP);
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
        float x0 = startPoint.x;
        float y0 = startPoint.y;
        float r = (float) Math.hypot((double) (endPoint.x - x0), (double) (endPoint.y - y0));
        if (r <= 0.0f) {
            r = 0.001f;
        }
        new RadialGradient(x0, y0, r, colors, positions, Shader.TileMode.CLAMP);
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

    public void resolveKeyPath(KeyPath keyPath, int depth, List<KeyPath> accumulator, KeyPath currentPartialKeyPath) {
        MiscUtils.resolveKeyPath(keyPath, depth, accumulator, currentPartialKeyPath, this);
    }

    public <T> void addValueCallback(T t, @Nullable LottieValueCallback<T> lottieValueCallback) {
        ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation;
        BaseKeyframeAnimation<ColorFilter, ColorFilter> baseKeyframeAnimation;
        T property = t;
        LottieValueCallback<T> callback = lottieValueCallback;
        if (property == LottieProperty.OPACITY) {
            this.opacityAnimation.setValueCallback(callback);
        } else if (property == LottieProperty.COLOR_FILTER) {
            if (callback == null) {
                this.colorFilterAnimation = null;
                return;
            }
            new ValueCallbackKeyframeAnimation(callback);
            this.colorFilterAnimation = baseKeyframeAnimation;
            this.colorFilterAnimation.addUpdateListener(this);
            this.layer.addAnimation(this.colorFilterAnimation);
        } else if (property != LottieProperty.GRADIENT_COLOR) {
        } else {
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
}
