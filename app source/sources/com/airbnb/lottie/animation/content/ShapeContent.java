package com.airbnb.lottie.animation.content;

import android.graphics.Path;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.model.content.ShapePath;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import com.airbnb.lottie.model.layer.BaseLayer;
import java.util.List;

public class ShapeContent implements PathContent, BaseKeyframeAnimation.AnimationListener {
    private final boolean hidden;
    private boolean isPathValid;
    private final LottieDrawable lottieDrawable;
    private final String name;
    private final Path path;
    private final BaseKeyframeAnimation<?, Path> shapeAnimation;
    private CompoundTrimPathContent trimPaths;

    public ShapeContent(LottieDrawable lottieDrawable2, BaseLayer layer, ShapePath shapePath) {
        Path path2;
        CompoundTrimPathContent compoundTrimPathContent;
        ShapePath shape = shapePath;
        new Path();
        this.path = path2;
        new CompoundTrimPathContent();
        this.trimPaths = compoundTrimPathContent;
        this.name = shape.getName();
        this.hidden = shape.isHidden();
        this.lottieDrawable = lottieDrawable2;
        this.shapeAnimation = shape.getShapePath().createAnimation();
        layer.addAnimation(this.shapeAnimation);
        this.shapeAnimation.addUpdateListener(this);
    }

    public void onValueChanged() {
        invalidate();
    }

    private void invalidate() {
        this.isPathValid = false;
        this.lottieDrawable.invalidateSelf();
    }

    public void setContents(List<Content> list, List<Content> list2) {
        List<Content> contentsBefore = list;
        List<Content> list3 = list2;
        for (int i = 0; i < contentsBefore.size(); i++) {
            Content content = contentsBefore.get(i);
            if ((content instanceof TrimPathContent) && ((TrimPathContent) content).getType() == ShapeTrimPath.Type.SIMULTANEOUSLY) {
                TrimPathContent trimPath = (TrimPathContent) content;
                this.trimPaths.addTrimPath(trimPath);
                trimPath.addListener(this);
            }
        }
    }

    public Path getPath() {
        if (this.isPathValid) {
            return this.path;
        }
        this.path.reset();
        if (this.hidden) {
            this.isPathValid = true;
            return this.path;
        }
        this.path.set(this.shapeAnimation.getValue());
        this.path.setFillType(Path.FillType.EVEN_ODD);
        this.trimPaths.apply(this.path);
        this.isPathValid = true;
        return this.path;
    }

    public String getName() {
        return this.name;
    }
}
