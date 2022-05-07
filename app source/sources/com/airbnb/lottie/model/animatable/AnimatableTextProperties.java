package com.airbnb.lottie.model.animatable;

import androidx.annotation.Nullable;

public class AnimatableTextProperties {
    @Nullable
    public final AnimatableColorValue color;
    @Nullable
    public final AnimatableColorValue stroke;
    @Nullable
    public final AnimatableFloatValue strokeWidth;
    @Nullable
    public final AnimatableFloatValue tracking;

    public AnimatableTextProperties(@Nullable AnimatableColorValue color2, @Nullable AnimatableColorValue stroke2, @Nullable AnimatableFloatValue strokeWidth2, @Nullable AnimatableFloatValue tracking2) {
        this.color = color2;
        this.stroke = stroke2;
        this.strokeWidth = strokeWidth2;
        this.tracking = tracking2;
    }
}
