package com.airbnb.lottie.utils;

public class GammaEvaluator {
    public GammaEvaluator() {
    }

    private static float OECF_sRGB(float f) {
        float linear;
        float linear2 = f;
        if (linear2 <= 0.0031308f) {
            linear = linear2 * 12.92f;
        } else {
            linear = (float) ((Math.pow((double) linear2, 0.4166666567325592d) * 1.0549999475479126d) - 0.054999999701976776d);
        }
        return linear;
    }

    private static float EOCF_sRGB(float f) {
        float srgb = f;
        return srgb <= 0.04045f ? srgb / 12.92f : (float) Math.pow((double) ((srgb + 0.055f) / 1.055f), 2.4000000953674316d);
    }

    public static int evaluate(float f, int i, int i2) {
        float fraction = f;
        int startInt = i;
        int endInt = i2;
        float startA = ((float) ((startInt >> 24) & 255)) / 255.0f;
        float startR = EOCF_sRGB(((float) ((startInt >> 16) & 255)) / 255.0f);
        float startG = EOCF_sRGB(((float) ((startInt >> 8) & 255)) / 255.0f);
        float startB = EOCF_sRGB(((float) (startInt & 255)) / 255.0f);
        float endR = EOCF_sRGB(((float) ((endInt >> 16) & 255)) / 255.0f);
        float endG = EOCF_sRGB(((float) ((endInt >> 8) & 255)) / 255.0f);
        return (Math.round((startA + (fraction * ((((float) ((endInt >> 24) & 255)) / 255.0f) - startA))) * 255.0f) << 24) | (Math.round(OECF_sRGB(startR + (fraction * (endR - startR))) * 255.0f) << 16) | (Math.round(OECF_sRGB(startG + (fraction * (endG - startG))) * 255.0f) << 8) | Math.round(OECF_sRGB(startB + (fraction * (EOCF_sRGB(((float) (endInt & 255)) / 255.0f) - startB))) * 255.0f);
    }
}
