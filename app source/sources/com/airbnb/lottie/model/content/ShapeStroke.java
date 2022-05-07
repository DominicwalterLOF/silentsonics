package com.airbnb.lottie.model.content;

import android.graphics.Paint;
import androidx.annotation.Nullable;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.StrokeContent;
import com.airbnb.lottie.model.animatable.AnimatableColorValue;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableIntegerValue;
import com.airbnb.lottie.model.layer.BaseLayer;
import java.util.List;

public class ShapeStroke implements ContentModel {
    private final LineCapType capType;
    private final AnimatableColorValue color;
    private final boolean hidden;
    private final LineJoinType joinType;
    private final List<AnimatableFloatValue> lineDashPattern;
    private final float miterLimit;
    private final String name;
    @Nullable
    private final AnimatableFloatValue offset;
    private final AnimatableIntegerValue opacity;
    private final AnimatableFloatValue width;

    public enum LineCapType {
        ;

        public Paint.Cap toPaintCap() {
            switch (this) {
                case BUTT:
                    return Paint.Cap.BUTT;
                case ROUND:
                    return Paint.Cap.ROUND;
                default:
                    return Paint.Cap.SQUARE;
            }
        }
    }

    public enum LineJoinType {
        ;

        public Paint.Join toPaintJoin() {
            switch (this) {
                case BEVEL:
                    return Paint.Join.BEVEL;
                case MITER:
                    return Paint.Join.MITER;
                case ROUND:
                    return Paint.Join.ROUND;
                default:
                    return null;
            }
        }
    }

    public ShapeStroke(String name2, @Nullable AnimatableFloatValue offset2, List<AnimatableFloatValue> lineDashPattern2, AnimatableColorValue color2, AnimatableIntegerValue opacity2, AnimatableFloatValue width2, LineCapType capType2, LineJoinType joinType2, float miterLimit2, boolean hidden2) {
        this.name = name2;
        this.offset = offset2;
        this.lineDashPattern = lineDashPattern2;
        this.color = color2;
        this.opacity = opacity2;
        this.width = width2;
        this.capType = capType2;
        this.joinType = joinType2;
        this.miterLimit = miterLimit2;
        this.hidden = hidden2;
    }

    public Content toContent(LottieDrawable drawable, BaseLayer layer) {
        Content content;
        new StrokeContent(drawable, layer, this);
        return content;
    }

    public String getName() {
        return this.name;
    }

    public AnimatableColorValue getColor() {
        return this.color;
    }

    public AnimatableIntegerValue getOpacity() {
        return this.opacity;
    }

    public AnimatableFloatValue getWidth() {
        return this.width;
    }

    public List<AnimatableFloatValue> getLineDashPattern() {
        return this.lineDashPattern;
    }

    public AnimatableFloatValue getDashOffset() {
        return this.offset;
    }

    public LineCapType getCapType() {
        return this.capType;
    }

    public LineJoinType getJoinType() {
        return this.joinType;
    }

    public float getMiterLimit() {
        return this.miterLimit;
    }

    public boolean isHidden() {
        return this.hidden;
    }
}
