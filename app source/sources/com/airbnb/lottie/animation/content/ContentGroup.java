package com.airbnb.lottie.animation.content;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import androidx.annotation.Nullable;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.TransformKeyframeAnimation;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.KeyPathElement;
import com.airbnb.lottie.model.animatable.AnimatableTransform;
import com.airbnb.lottie.model.content.ContentModel;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.ArrayList;
import java.util.List;

public class ContentGroup implements DrawingContent, PathContent, BaseKeyframeAnimation.AnimationListener, KeyPathElement {
    private final List<Content> contents;
    private final boolean hidden;
    private final LottieDrawable lottieDrawable;
    private final Matrix matrix;
    private final String name;
    private final Path path;
    @Nullable
    private List<PathContent> pathContents;
    private final RectF rect;
    @Nullable
    private TransformKeyframeAnimation transformAnimation;

    private static List<Content> contentsFromModels(LottieDrawable lottieDrawable2, BaseLayer baseLayer, List<ContentModel> list) {
        List<Content> list2;
        LottieDrawable drawable = lottieDrawable2;
        BaseLayer layer = baseLayer;
        List<ContentModel> contentModels = list;
        new ArrayList(contentModels.size());
        List<Content> contents2 = list2;
        for (int i = 0; i < contentModels.size(); i++) {
            Content content = contentModels.get(i).toContent(drawable, layer);
            if (content != null) {
                boolean add = contents2.add(content);
            }
        }
        return contents2;
    }

    @Nullable
    static AnimatableTransform findTransform(List<ContentModel> list) {
        List<ContentModel> contentModels = list;
        for (int i = 0; i < contentModels.size(); i++) {
            ContentModel contentModel = contentModels.get(i);
            if (contentModel instanceof AnimatableTransform) {
                return (AnimatableTransform) contentModel;
            }
        }
        return null;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public ContentGroup(com.airbnb.lottie.LottieDrawable r13, com.airbnb.lottie.model.layer.BaseLayer r14, com.airbnb.lottie.model.content.ShapeGroup r15) {
        /*
            r12 = this;
            r0 = r12
            r1 = r13
            r2 = r14
            r3 = r15
            r4 = r0
            r5 = r1
            r6 = r2
            r7 = r3
            java.lang.String r7 = r7.getName()
            r8 = r3
            boolean r8 = r8.isHidden()
            r9 = r1
            r10 = r2
            r11 = r3
            java.util.List r11 = r11.getItems()
            java.util.List r9 = contentsFromModels(r9, r10, r11)
            r10 = r3
            java.util.List r10 = r10.getItems()
            com.airbnb.lottie.model.animatable.AnimatableTransform r10 = findTransform(r10)
            r4.<init>(r5, r6, r7, r8, r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.animation.content.ContentGroup.<init>(com.airbnb.lottie.LottieDrawable, com.airbnb.lottie.model.layer.BaseLayer, com.airbnb.lottie.model.content.ShapeGroup):void");
    }

    ContentGroup(LottieDrawable lottieDrawable2, BaseLayer baseLayer, String name2, boolean hidden2, List<Content> list, @Nullable AnimatableTransform animatableTransform) {
        Matrix matrix2;
        Path path2;
        RectF rectF;
        List<GreedyContent> list2;
        BaseLayer layer = baseLayer;
        List<Content> contents2 = list;
        AnimatableTransform transform = animatableTransform;
        new Matrix();
        this.matrix = matrix2;
        new Path();
        this.path = path2;
        new RectF();
        this.rect = rectF;
        this.name = name2;
        this.lottieDrawable = lottieDrawable2;
        this.hidden = hidden2;
        this.contents = contents2;
        if (transform != null) {
            this.transformAnimation = transform.createAnimation();
            this.transformAnimation.addAnimationsToLayer(layer);
            this.transformAnimation.addListener(this);
        }
        new ArrayList<>();
        List<GreedyContent> greedyContents = list2;
        for (int i = contents2.size() - 1; i >= 0; i--) {
            Content content = contents2.get(i);
            if (content instanceof GreedyContent) {
                boolean add = greedyContents.add((GreedyContent) content);
            }
        }
        for (int i2 = greedyContents.size() - 1; i2 >= 0; i2--) {
            greedyContents.get(i2).absorbContent(contents2.listIterator(contents2.size()));
        }
    }

    public void onValueChanged() {
        this.lottieDrawable.invalidateSelf();
    }

    public String getName() {
        return this.name;
    }

    public void setContents(List<Content> list, List<Content> list2) {
        List<Content> list3;
        List<Content> contentsBefore = list;
        List<Content> list4 = list2;
        new ArrayList<>(contentsBefore.size() + this.contents.size());
        List<Content> myContentsBefore = list3;
        boolean addAll = myContentsBefore.addAll(contentsBefore);
        for (int i = this.contents.size() - 1; i >= 0; i--) {
            Content content = this.contents.get(i);
            content.setContents(myContentsBefore, this.contents.subList(0, i));
            boolean add = myContentsBefore.add(content);
        }
    }

    /* access modifiers changed from: package-private */
    public List<PathContent> getPathList() {
        List<PathContent> list;
        if (this.pathContents == null) {
            new ArrayList();
            this.pathContents = list;
            for (int i = 0; i < this.contents.size(); i++) {
                Content content = this.contents.get(i);
                if (content instanceof PathContent) {
                    boolean add = this.pathContents.add((PathContent) content);
                }
            }
        }
        return this.pathContents;
    }

    /* access modifiers changed from: package-private */
    public Matrix getTransformationMatrix() {
        if (this.transformAnimation != null) {
            return this.transformAnimation.getMatrix();
        }
        this.matrix.reset();
        return this.matrix;
    }

    public Path getPath() {
        this.matrix.reset();
        if (this.transformAnimation != null) {
            this.matrix.set(this.transformAnimation.getMatrix());
        }
        this.path.reset();
        if (this.hidden) {
            return this.path;
        }
        for (int i = this.contents.size() - 1; i >= 0; i--) {
            Content content = this.contents.get(i);
            if (content instanceof PathContent) {
                this.path.addPath(((PathContent) content).getPath(), this.matrix);
            }
        }
        return this.path;
    }

    public void draw(Canvas canvas, Matrix matrix2, int i) {
        int alpha;
        Canvas canvas2 = canvas;
        Matrix parentMatrix = matrix2;
        int parentAlpha = i;
        if (!this.hidden) {
            this.matrix.set(parentMatrix);
            if (this.transformAnimation != null) {
                boolean preConcat = this.matrix.preConcat(this.transformAnimation.getMatrix());
                alpha = (int) ((((((float) (this.transformAnimation.getOpacity() == null ? 100 : this.transformAnimation.getOpacity().getValue().intValue())) / 100.0f) * ((float) parentAlpha)) / 255.0f) * 255.0f);
            } else {
                alpha = parentAlpha;
            }
            for (int i2 = this.contents.size() - 1; i2 >= 0; i2--) {
                Object content = this.contents.get(i2);
                if (content instanceof DrawingContent) {
                    ((DrawingContent) content).draw(canvas2, this.matrix, alpha);
                }
            }
        }
    }

    public void getBounds(RectF rectF, Matrix parentMatrix, boolean z) {
        RectF outBounds = rectF;
        boolean applyParents = z;
        this.matrix.set(parentMatrix);
        if (this.transformAnimation != null) {
            boolean preConcat = this.matrix.preConcat(this.transformAnimation.getMatrix());
        }
        this.rect.set(0.0f, 0.0f, 0.0f, 0.0f);
        for (int i = this.contents.size() - 1; i >= 0; i--) {
            Content content = this.contents.get(i);
            if (content instanceof DrawingContent) {
                ((DrawingContent) content).getBounds(this.rect, this.matrix, applyParents);
                outBounds.union(this.rect);
            }
        }
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
                int newDepth = depth + keyPath3.incrementDepthBy(getName(), depth);
                for (int i2 = 0; i2 < this.contents.size(); i2++) {
                    Content content = this.contents.get(i2);
                    if (content instanceof KeyPathElement) {
                        ((KeyPathElement) content).resolveKeyPath(keyPath3, newDepth, accumulator, currentPartialKeyPath);
                    }
                }
            }
        }
    }

    public <T> void addValueCallback(T t, @Nullable LottieValueCallback<T> lottieValueCallback) {
        T property = t;
        LottieValueCallback<T> callback = lottieValueCallback;
        if (this.transformAnimation != null) {
            boolean applyValueCallback = this.transformAnimation.applyValueCallback(property, callback);
        }
    }
}
