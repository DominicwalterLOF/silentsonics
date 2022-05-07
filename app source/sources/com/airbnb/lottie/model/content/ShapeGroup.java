package com.airbnb.lottie.model.content;

import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.ContentGroup;
import com.airbnb.lottie.model.layer.BaseLayer;
import java.util.Arrays;
import java.util.List;

public class ShapeGroup implements ContentModel {
    private final boolean hidden;
    private final List<ContentModel> items;
    private final String name;

    public ShapeGroup(String name2, List<ContentModel> items2, boolean hidden2) {
        this.name = name2;
        this.items = items2;
        this.hidden = hidden2;
    }

    public String getName() {
        return this.name;
    }

    public List<ContentModel> getItems() {
        return this.items;
    }

    public boolean isHidden() {
        return this.hidden;
    }

    public Content toContent(LottieDrawable drawable, BaseLayer layer) {
        Content content;
        new ContentGroup(drawable, layer, this);
        return content;
    }

    public String toString() {
        StringBuilder sb;
        new StringBuilder();
        return sb.append("ShapeGroup{name='").append(this.name).append("' Shapes: ").append(Arrays.toString(this.items.toArray())).append('}').toString();
    }
}
