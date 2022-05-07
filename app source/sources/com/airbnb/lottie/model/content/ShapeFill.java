package com.airbnb.lottie.model.content;

import android.graphics.Path;
import androidx.annotation.Nullable;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.FillContent;
import com.airbnb.lottie.model.animatable.AnimatableColorValue;
import com.airbnb.lottie.model.animatable.AnimatableIntegerValue;
import com.airbnb.lottie.model.layer.BaseLayer;

public class ShapeFill implements ContentModel {
    @Nullable
    private final AnimatableColorValue color;
    private final boolean fillEnabled;
    private final Path.FillType fillType;
    private final boolean hidden;
    private final String name;
    @Nullable
    private final AnimatableIntegerValue opacity;

    public ShapeFill(String name2, boolean fillEnabled2, Path.FillType fillType2, @Nullable AnimatableColorValue color2, @Nullable AnimatableIntegerValue opacity2, boolean hidden2) {
        this.name = name2;
        this.fillEnabled = fillEnabled2;
        this.fillType = fillType2;
        this.color = color2;
        this.opacity = opacity2;
        this.hidden = hidden2;
    }

    public String getName() {
        return this.name;
    }

    @Nullable
    public AnimatableColorValue getColor() {
        return this.color;
    }

    @Nullable
    public AnimatableIntegerValue getOpacity() {
        return this.opacity;
    }

    public Path.FillType getFillType() {
        return this.fillType;
    }

    public boolean isHidden() {
        return this.hidden;
    }

    public Content toContent(LottieDrawable drawable, BaseLayer layer) {
        Content content;
        new FillContent(drawable, layer, this);
        return content;
    }

    public String toString() {
        StringBuilder sb;
        new StringBuilder();
        return sb.append("ShapeFill{color=, fillEnabled=").append(this.fillEnabled).append('}').toString();
    }
}
