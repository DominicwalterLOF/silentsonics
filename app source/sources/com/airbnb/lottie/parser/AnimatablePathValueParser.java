package com.airbnb.lottie.parser;

import android.graphics.PointF;
import android.util.JsonReader;
import android.util.JsonToken;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatablePathValue;
import com.airbnb.lottie.model.animatable.AnimatableSplitDimensionPathValue;
import com.airbnb.lottie.model.animatable.AnimatableValue;
import com.airbnb.lottie.utils.Utils;
import com.airbnb.lottie.value.Keyframe;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.jose4j.jwk.EllipticCurveJsonWebKey;
import org.jose4j.jwk.OctetSequenceJsonWebKey;

public class AnimatablePathValueParser {
    private AnimatablePathValueParser() {
    }

    public static AnimatablePathValue parse(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        List<Keyframe<PointF>> list;
        Object obj;
        AnimatablePathValue animatablePathValue;
        JsonReader reader = jsonReader;
        LottieComposition composition = lottieComposition;
        new ArrayList<>();
        List<Keyframe<PointF>> keyframes = list;
        if (reader.peek() == JsonToken.BEGIN_ARRAY) {
            reader.beginArray();
            while (reader.hasNext()) {
                boolean add = keyframes.add(PathKeyframeParser.parse(reader, composition));
            }
            reader.endArray();
            KeyframesParser.setEndFrames(keyframes);
        } else {
            new Keyframe(JsonUtils.jsonToPoint(reader, Utils.dpScale()));
            boolean add2 = keyframes.add(obj);
        }
        new AnimatablePathValue(keyframes);
        return animatablePathValue;
    }

    static AnimatableValue<PointF, PointF> parseSplitPath(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        AnimatableValue<PointF, PointF> animatableValue;
        JsonReader reader = jsonReader;
        LottieComposition composition = lottieComposition;
        AnimatablePathValue pathAnimation = null;
        AnimatableFloatValue xAnimation = null;
        AnimatableFloatValue yAnimation = null;
        boolean hasExpressions = false;
        reader.beginObject();
        while (reader.peek() != JsonToken.END_OBJECT) {
            String nextName = reader.nextName();
            boolean z = true;
            switch (nextName.hashCode()) {
                case 107:
                    if (nextName.equals(OctetSequenceJsonWebKey.KEY_VALUE_MEMBER_NAME)) {
                        z = false;
                        break;
                    }
                    break;
                case 120:
                    if (nextName.equals(EllipticCurveJsonWebKey.X_MEMBER_NAME)) {
                        z = true;
                        break;
                    }
                    break;
                case 121:
                    if (nextName.equals(EllipticCurveJsonWebKey.Y_MEMBER_NAME)) {
                        z = true;
                        break;
                    }
                    break;
            }
            switch (z) {
                case false:
                    pathAnimation = parse(reader, composition);
                    break;
                case true:
                    if (reader.peek() != JsonToken.STRING) {
                        xAnimation = AnimatableValueParser.parseFloat(reader, composition);
                        break;
                    } else {
                        hasExpressions = true;
                        reader.skipValue();
                        break;
                    }
                case true:
                    if (reader.peek() != JsonToken.STRING) {
                        yAnimation = AnimatableValueParser.parseFloat(reader, composition);
                        break;
                    } else {
                        hasExpressions = true;
                        reader.skipValue();
                        break;
                    }
                default:
                    reader.skipValue();
                    break;
            }
        }
        reader.endObject();
        if (hasExpressions) {
            composition.addWarning("Lottie doesn't support expressions.");
        }
        if (pathAnimation != null) {
            return pathAnimation;
        }
        new AnimatableSplitDimensionPathValue(xAnimation, yAnimation);
        return animatableValue;
    }
}
