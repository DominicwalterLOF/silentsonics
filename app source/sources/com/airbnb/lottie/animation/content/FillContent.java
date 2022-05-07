package com.airbnb.lottie.animation.content;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import androidx.annotation.Nullable;
import com.airbnb.lottie.L;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.LPaint;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.ColorKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.ValueCallbackKeyframeAnimation;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.content.ShapeFill;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.ArrayList;
import java.util.List;

public class FillContent implements DrawingContent, BaseKeyframeAnimation.AnimationListener, KeyPathElementContent {
    private final BaseKeyframeAnimation<Integer, Integer> colorAnimation;
    @Nullable
    private BaseKeyframeAnimation<ColorFilter, ColorFilter> colorFilterAnimation;
    private final boolean hidden;
    private final BaseLayer layer;
    private final LottieDrawable lottieDrawable;
    private final String name;
    private final BaseKeyframeAnimation<Integer, Integer> opacityAnimation;
    private final Paint paint;
    private final Path path;
    private final List<PathContent> paths;

    public FillContent(LottieDrawable lottieDrawable2, BaseLayer baseLayer, ShapeFill shapeFill) {
        Path path2;
        Paint paint2;
        List<PathContent> list;
        BaseLayer layer2 = baseLayer;
        ShapeFill fill = shapeFill;
        new Path();
        this.path = path2;
        new LPaint(1);
        this.paint = paint2;
        new ArrayList();
        this.paths = list;
        this.layer = layer2;
        this.name = fill.getName();
        this.hidden = fill.isHidden();
        this.lottieDrawable = lottieDrawable2;
        if (fill.getColor() == null || fill.getOpacity() == null) {
            this.colorAnimation = null;
            this.opacityAnimation = null;
            return;
        }
        this.path.setFillType(fill.getFillType());
        this.colorAnimation = fill.getColor().createAnimation();
        this.colorAnimation.addUpdateListener(this);
        layer2.addAnimation(this.colorAnimation);
        this.opacityAnimation = fill.getOpacity().createAnimation();
        this.opacityAnimation.addUpdateListener(this);
        layer2.addAnimation(this.opacityAnimation);
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

    public String getName() {
        return this.name;
    }

    public void draw(Canvas canvas, Matrix matrix, int i) {
        Canvas canvas2 = canvas;
        Matrix parentMatrix = matrix;
        int parentAlpha = i;
        if (!this.hidden) {
            L.beginSection("FillContent#draw");
            this.paint.setColor(((ColorKeyframeAnimation) this.colorAnimation).getIntValue());
            this.paint.setAlpha(MiscUtils.clamp((int) ((((((float) parentAlpha) / 255.0f) * ((float) this.opacityAnimation.getValue().intValue())) / 100.0f) * 255.0f), 0, 255));
            if (this.colorFilterAnimation != null) {
                ColorFilter colorFilter = this.paint.setColorFilter(this.colorFilterAnimation.getValue());
            }
            this.path.reset();
            for (int i2 = 0; i2 < this.paths.size(); i2++) {
                this.path.addPath(this.paths.get(i2).getPath(), parentMatrix);
            }
            canvas2.drawPath(this.path, this.paint);
            float endSection = L.endSection("FillContent#draw");
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

    public void resolveKeyPath(KeyPath keyPath, int depth, List<KeyPath> accumulator, KeyPath currentPartialKeyPath) {
        MiscUtils.resolveKeyPath(keyPath, depth, accumulator, currentPartialKeyPath, this);
    }

    public <T> void addValueCallback(T t, @Nullable LottieValueCallback<T> lottieValueCallback) {
        BaseKeyframeAnimation<ColorFilter, ColorFilter> baseKeyframeAnimation;
        T property = t;
        LottieValueCallback<T> callback = lottieValueCallback;
        if (property == LottieProperty.COLOR) {
            this.colorAnimation.setValueCallback(callback);
        } else if (property == LottieProperty.OPACITY) {
            this.opacityAnimation.setValueCallback(callback);
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
}
