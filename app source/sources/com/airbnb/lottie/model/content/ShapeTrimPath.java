package com.airbnb.lottie.model.content;

import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.TrimPathContent;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.layer.BaseLayer;

public class ShapeTrimPath implements ContentModel {
    private final AnimatableFloatValue end;
    private final boolean hidden;
    private final String name;
    private final AnimatableFloatValue offset;
    private final AnimatableFloatValue start;
    private final Type type;

    public enum Type {
        ;

        public static Type forId(int i) {
            Throwable th;
            StringBuilder sb;
            int id = i;
            switch (id) {
                case 1:
                    return SIMULTANEOUSLY;
                case 2:
                    return INDIVIDUALLY;
                default:
                    Throwable th2 = th;
                    new StringBuilder();
                    new IllegalArgumentException(sb.append("Unknown trim path type ").append(id).toString());
                    throw th2;
            }
        }
    }

    public ShapeTrimPath(String name2, Type type2, AnimatableFloatValue start2, AnimatableFloatValue end2, AnimatableFloatValue offset2, boolean hidden2) {
        this.name = name2;
        this.type = type2;
        this.start = start2;
        this.end = end2;
        this.offset = offset2;
        this.hidden = hidden2;
    }

    public String getName() {
        return this.name;
    }

    public Type getType() {
        return this.type;
    }

    public AnimatableFloatValue getEnd() {
        return this.end;
    }

    public AnimatableFloatValue getStart() {
        return this.start;
    }

    public AnimatableFloatValue getOffset() {
        return this.offset;
    }

    public boolean isHidden() {
        return this.hidden;
    }

    public Content toContent(LottieDrawable lottieDrawable, BaseLayer layer) {
        Content content;
        LottieDrawable lottieDrawable2 = lottieDrawable;
        new TrimPathContent(layer, this);
        return content;
    }

    public String toString() {
        StringBuilder sb;
        new StringBuilder();
        return sb.append("Trim Path: {start: ").append(this.start).append(", end: ").append(this.end).append(", offset: ").append(this.offset).append("}").toString();
    }
}
