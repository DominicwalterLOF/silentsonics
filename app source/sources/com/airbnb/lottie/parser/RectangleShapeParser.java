package com.airbnb.lottie.parser;

import android.graphics.PointF;
import android.util.JsonReader;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatablePointValue;
import com.airbnb.lottie.model.animatable.AnimatableValue;
import com.airbnb.lottie.model.content.RectangleShape;
import java.io.IOException;
import org.jose4j.jwk.RsaJsonWebKey;

class RectangleShapeParser {
    private RectangleShapeParser() {
    }

    static RectangleShape parse(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        RectangleShape rectangleShape;
        JsonReader reader = jsonReader;
        LottieComposition composition = lottieComposition;
        String name = null;
        AnimatableValue<PointF, PointF> position = null;
        AnimatablePointValue size = null;
        AnimatableFloatValue roundedness = null;
        boolean hidden = false;
        while (reader.hasNext()) {
            String nextName = reader.nextName();
            boolean z = true;
            switch (nextName.hashCode()) {
                case 112:
                    if (nextName.equals(RsaJsonWebKey.FIRST_PRIME_FACTOR_MEMBER_NAME)) {
                        z = true;
                        break;
                    }
                    break;
                case 114:
                    if (nextName.equals(RsaJsonWebKey.PRIME_FACTOR_OTHER_MEMBER_NAME)) {
                        z = true;
                        break;
                    }
                    break;
                case 115:
                    if (nextName.equals("s")) {
                        z = true;
                        break;
                    }
                    break;
                case 3324:
                    if (nextName.equals("hd")) {
                        z = true;
                        break;
                    }
                    break;
                case 3519:
                    if (nextName.equals("nm")) {
                        z = false;
                        break;
                    }
                    break;
            }
            switch (z) {
                case false:
                    name = reader.nextString();
                    break;
                case true:
                    position = AnimatablePathValueParser.parseSplitPath(reader, composition);
                    break;
                case true:
                    size = AnimatableValueParser.parsePoint(reader, composition);
                    break;
                case true:
                    roundedness = AnimatableValueParser.parseFloat(reader, composition);
                    break;
                case true:
                    hidden = reader.nextBoolean();
                    break;
                default:
                    reader.skipValue();
                    break;
            }
        }
        new RectangleShape(name, position, size, roundedness, hidden);
        return rectangleShape;
    }
}
