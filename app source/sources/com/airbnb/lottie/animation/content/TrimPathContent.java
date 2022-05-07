package com.airbnb.lottie.animation.content;

import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import com.airbnb.lottie.model.layer.BaseLayer;
import java.util.ArrayList;
import java.util.List;

public class TrimPathContent implements Content, BaseKeyframeAnimation.AnimationListener {
    private final BaseKeyframeAnimation<?, Float> endAnimation;
    private final boolean hidden;
    private final List<BaseKeyframeAnimation.AnimationListener> listeners;
    private final String name;
    private final BaseKeyframeAnimation<?, Float> offsetAnimation;
    private final BaseKeyframeAnimation<?, Float> startAnimation;
    private final ShapeTrimPath.Type type;

    public TrimPathContent(BaseLayer baseLayer, ShapeTrimPath shapeTrimPath) {
        List<BaseKeyframeAnimation.AnimationListener> list;
        BaseLayer layer = baseLayer;
        ShapeTrimPath trimPath = shapeTrimPath;
        new ArrayList();
        this.listeners = list;
        this.name = trimPath.getName();
        this.hidden = trimPath.isHidden();
        this.type = trimPath.getType();
        this.startAnimation = trimPath.getStart().createAnimation();
        this.endAnimation = trimPath.getEnd().createAnimation();
        this.offsetAnimation = trimPath.getOffset().createAnimation();
        layer.addAnimation(this.startAnimation);
        layer.addAnimation(this.endAnimation);
        layer.addAnimation(this.offsetAnimation);
        this.startAnimation.addUpdateListener(this);
        this.endAnimation.addUpdateListener(this);
        this.offsetAnimation.addUpdateListener(this);
    }

    public void onValueChanged() {
        for (int i = 0; i < this.listeners.size(); i++) {
            this.listeners.get(i).onValueChanged();
        }
    }

    public void setContents(List<Content> list, List<Content> list2) {
    }

    public String getName() {
        return this.name;
    }

    /* access modifiers changed from: package-private */
    public void addListener(BaseKeyframeAnimation.AnimationListener listener) {
        boolean add = this.listeners.add(listener);
    }

    /* access modifiers changed from: package-private */
    public ShapeTrimPath.Type getType() {
        return this.type;
    }

    public BaseKeyframeAnimation<?, Float> getStart() {
        return this.startAnimation;
    }

    public BaseKeyframeAnimation<?, Float> getEnd() {
        return this.endAnimation;
    }

    public BaseKeyframeAnimation<?, Float> getOffset() {
        return this.offsetAnimation;
    }

    public boolean isHidden() {
        return this.hidden;
    }
}
