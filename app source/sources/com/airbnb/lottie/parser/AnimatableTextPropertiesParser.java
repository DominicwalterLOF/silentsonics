package com.airbnb.lottie.parser;

import android.util.JsonReader;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableColorValue;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableTextProperties;
import java.io.IOException;
import org.jose4j.jwk.RsaJsonWebKey;

public class AnimatableTextPropertiesParser {
    private AnimatableTextPropertiesParser() {
    }

    public static AnimatableTextProperties parse(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        AnimatableTextProperties animatableTextProperties;
        JsonReader reader = jsonReader;
        LottieComposition composition = lottieComposition;
        AnimatableTextProperties anim = null;
        reader.beginObject();
        while (reader.hasNext()) {
            String nextName = reader.nextName();
            boolean z = true;
            switch (nextName.hashCode()) {
                case 97:
                    if (nextName.equals("a")) {
                        z = false;
                        break;
                    }
                    break;
            }
            switch (z) {
                case false:
                    anim = parseAnimatableTextProperties(reader, composition);
                    break;
                default:
                    reader.skipValue();
                    break;
            }
        }
        reader.endObject();
        if (anim != null) {
            return anim;
        }
        new AnimatableTextProperties((AnimatableColorValue) null, (AnimatableColorValue) null, (AnimatableFloatValue) null, (AnimatableFloatValue) null);
        return animatableTextProperties;
    }

    private static AnimatableTextProperties parseAnimatableTextProperties(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        AnimatableTextProperties animatableTextProperties;
        JsonReader reader = jsonReader;
        LottieComposition composition = lottieComposition;
        AnimatableColorValue color = null;
        AnimatableColorValue stroke = null;
        AnimatableFloatValue strokeWidth = null;
        AnimatableFloatValue tracking = null;
        reader.beginObject();
        while (reader.hasNext()) {
            String nextName = reader.nextName();
            boolean z = true;
            switch (nextName.hashCode()) {
                case 116:
                    if (nextName.equals(RsaJsonWebKey.FACTOR_CRT_COEFFICIENT)) {
                        z = true;
                        break;
                    }
                    break;
                case 3261:
                    if (nextName.equals("fc")) {
                        z = false;
                        break;
                    }
                    break;
                case 3664:
                    if (nextName.equals("sc")) {
                        z = true;
                        break;
                    }
                    break;
                case 3684:
                    if (nextName.equals("sw")) {
                        z = true;
                        break;
                    }
                    break;
            }
            switch (z) {
                case false:
                    color = AnimatableValueParser.parseColor(reader, composition);
                    break;
                case true:
                    stroke = AnimatableValueParser.parseColor(reader, composition);
                    break;
                case true:
                    strokeWidth = AnimatableValueParser.parseFloat(reader, composition);
                    break;
                case true:
                    tracking = AnimatableValueParser.parseFloat(reader, composition);
                    break;
                default:
                    reader.skipValue();
                    break;
            }
        }
        reader.endObject();
        new AnimatableTextProperties(color, stroke, strokeWidth, tracking);
        return animatableTextProperties;
    }
}
