package com.airbnb.lottie.model.content;

import android.graphics.PointF;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.EllipseContent;
import com.airbnb.lottie.model.animatable.AnimatablePointValue;
import com.airbnb.lottie.model.animatable.AnimatableValue;
import com.airbnb.lottie.model.layer.BaseLayer;

public class CircleShape implements ContentModel {
    private final boolean hidden;
    private final boolean isReversed;
    private final String name;
    private final AnimatableValue<PointF, PointF> position;
    private final AnimatablePointValue size;

    public CircleShape(String name2, AnimatableValue<PointF, PointF> position2, AnimatablePointValue size2, boolean isReversed2, boolean hidden2) {
        this.name = name2;
        this.position = position2;
        this.size = size2;
        this.isReversed = isReversed2;
        this.hidden = hidden2;
    }

    public Content toContent(LottieDrawable drawable, BaseLayer layer) {
        Content content;
        new EllipseContent(drawable, layer, this);
        return content;
    }

    public String getName() {
        return this.name;
    }

    public AnimatableValue<PointF, PointF> getPosition() {
        return this.position;
    }

    public AnimatablePointValue getSize() {
        return this.size;
    }

    public boolean isReversed() {
        return this.isReversed;
    }

    public boolean isHidden() {
        return this.hidden;
    }
}
