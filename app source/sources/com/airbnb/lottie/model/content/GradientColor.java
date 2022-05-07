package com.airbnb.lottie.model.content;

import com.airbnb.lottie.utils.GammaEvaluator;
import com.airbnb.lottie.utils.MiscUtils;

public class GradientColor {
    private final int[] colors;
    private final float[] positions;

    public GradientColor(float[] positions2, int[] colors2) {
        this.positions = positions2;
        this.colors = colors2;
    }

    public float[] getPositions() {
        return this.positions;
    }

    public int[] getColors() {
        return this.colors;
    }

    public int getSize() {
        return this.colors.length;
    }

    public void lerp(GradientColor gradientColor, GradientColor gradientColor2, float f) {
        Throwable th;
        StringBuilder sb;
        GradientColor gc1 = gradientColor;
        GradientColor gc2 = gradientColor2;
        float progress = f;
        if (gc1.colors.length != gc2.colors.length) {
            Throwable th2 = th;
            new StringBuilder();
            new IllegalArgumentException(sb.append("Cannot interpolate between gradients. Lengths vary (").append(gc1.colors.length).append(" vs ").append(gc2.colors.length).append(")").toString());
            throw th2;
        }
        for (int i = 0; i < gc1.colors.length; i++) {
            this.positions[i] = MiscUtils.lerp(gc1.positions[i], gc2.positions[i], progress);
            this.colors[i] = GammaEvaluator.evaluate(progress, gc1.colors[i], gc2.colors[i]);
        }
    }
}
