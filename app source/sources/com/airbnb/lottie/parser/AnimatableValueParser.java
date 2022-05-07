package com.airbnb.lottie.parser;

import android.util.JsonReader;
import androidx.annotation.Nullable;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableColorValue;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableGradientColorValue;
import com.airbnb.lottie.model.animatable.AnimatableIntegerValue;
import com.airbnb.lottie.model.animatable.AnimatablePointValue;
import com.airbnb.lottie.model.animatable.AnimatableScaleValue;
import com.airbnb.lottie.model.animatable.AnimatableShapeValue;
import com.airbnb.lottie.model.animatable.AnimatableTextFrame;
import com.airbnb.lottie.utils.Utils;
import com.airbnb.lottie.value.Keyframe;
import com.airbnb.lottie.value.ScaleXY;
import java.io.IOException;
import java.util.List;

public class AnimatableValueParser {
    private AnimatableValueParser() {
    }

    public static AnimatableFloatValue parseFloat(JsonReader reader, LottieComposition composition) throws IOException {
        return parseFloat(reader, composition, true);
    }

    public static AnimatableFloatValue parseFloat(JsonReader reader, LottieComposition composition, boolean isDp) throws IOException {
        AnimatableFloatValue animatableFloatValue = r9;
        AnimatableFloatValue animatableFloatValue2 = new AnimatableFloatValue(parse(reader, isDp ? Utils.dpScale() : 1.0f, composition, FloatParser.INSTANCE));
        return animatableFloatValue;
    }

    static AnimatableIntegerValue parseInteger(JsonReader reader, LottieComposition composition) throws IOException {
        AnimatableIntegerValue animatableIntegerValue;
        new AnimatableIntegerValue(parse(reader, composition, IntegerParser.INSTANCE));
        return animatableIntegerValue;
    }

    static AnimatablePointValue parsePoint(JsonReader reader, LottieComposition composition) throws IOException {
        AnimatablePointValue animatablePointValue;
        new AnimatablePointValue(parse(reader, Utils.dpScale(), composition, PointFParser.INSTANCE));
        return animatablePointValue;
    }

    static AnimatableScaleValue parseScale(JsonReader reader, LottieComposition composition) throws IOException {
        AnimatableScaleValue animatableScaleValue;
        new AnimatableScaleValue((List<Keyframe<ScaleXY>>) parse(reader, composition, ScaleXYParser.INSTANCE));
        return animatableScaleValue;
    }

    static AnimatableShapeValue parseShapeData(JsonReader reader, LottieComposition composition) throws IOException {
        AnimatableShapeValue animatableShapeValue;
        new AnimatableShapeValue(parse(reader, Utils.dpScale(), composition, ShapeDataParser.INSTANCE));
        return animatableShapeValue;
    }

    static AnimatableTextFrame parseDocumentData(JsonReader reader, LottieComposition composition) throws IOException {
        AnimatableTextFrame animatableTextFrame;
        new AnimatableTextFrame(parse(reader, composition, DocumentDataParser.INSTANCE));
        return animatableTextFrame;
    }

    static AnimatableColorValue parseColor(JsonReader reader, LottieComposition composition) throws IOException {
        AnimatableColorValue animatableColorValue;
        new AnimatableColorValue(parse(reader, composition, ColorParser.INSTANCE));
        return animatableColorValue;
    }

    static AnimatableGradientColorValue parseGradientColor(JsonReader reader, LottieComposition composition, int points) throws IOException {
        AnimatableGradientColorValue animatableGradientColorValue;
        ValueParser valueParser;
        new GradientColorParser(points);
        new AnimatableGradientColorValue(parse(reader, composition, valueParser));
        return animatableGradientColorValue;
    }

    @Nullable
    private static <T> List<Keyframe<T>> parse(JsonReader reader, LottieComposition composition, ValueParser<T> valueParser) throws IOException {
        return KeyframesParser.parse(reader, composition, 1.0f, valueParser);
    }

    @Nullable
    private static <T> List<Keyframe<T>> parse(JsonReader reader, float scale, LottieComposition composition, ValueParser<T> valueParser) throws IOException {
        return KeyframesParser.parse(reader, composition, scale, valueParser);
    }
}
