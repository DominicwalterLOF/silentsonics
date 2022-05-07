package com.airbnb.lottie.model.content;

import android.graphics.PointF;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.RectangleContent;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatablePointValue;
import com.airbnb.lottie.model.animatable.AnimatableValue;
import com.airbnb.lottie.model.layer.BaseLayer;

public class RectangleShape implements ContentModel {
    private final AnimatableFloatValue cornerRadius;
    private final boolean hidden;
    private final String name;
    private final AnimatableValue<PointF, PointF> position;
    private final AnimatablePointValue size;

    public RectangleShape(String name2, AnimatableValue<PointF, PointF> position2, AnimatablePointValue size2, AnimatableFloatValue cornerRadius2, boolean hidden2) {
        this.name = name2;
        this.position = position2;
        this.size = size2;
        this.cornerRadius = cornerRadius2;
        this.hidden = hidden2;
    }

    public String getName() {
        return this.name;
    }

    public AnimatableFloatValue getCornerRadius() {
        return this.cornerRadius;
    }

    public AnimatablePointValue getSize() {
        return this.size;
    }

    public AnimatableValue<PointF, PointF> getPosition() {
        return this.position;
    }

    public boolean isHidden() {
        return this.hidden;
    }

    public Content toContent(LottieDrawable drawable, BaseLayer layer) {
        Content content;
        new RectangleContent(drawable, layer, this);
        return content;
    }

    public String toString() {
        StringBuilder sb;
        new StringBuilder();
        return sb.append("RectangleShape{position=").append(this.position).append(", size=").append(this.size).append('}').toString();
    }
}
