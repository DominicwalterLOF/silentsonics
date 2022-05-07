package com.airbnb.lottie.parser;

import android.graphics.PointF;
import android.util.JsonReader;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatablePointValue;
import com.airbnb.lottie.model.animatable.AnimatableValue;
import com.airbnb.lottie.model.content.CircleShape;
import java.io.IOException;
import org.jose4j.jwk.RsaJsonWebKey;

class CircleShapeParser {
    private CircleShapeParser() {
    }

    static CircleShape parse(JsonReader jsonReader, LottieComposition lottieComposition, int d) throws IOException {
        CircleShape circleShape;
        JsonReader reader = jsonReader;
        LottieComposition composition = lottieComposition;
        String name = null;
        AnimatableValue<PointF, PointF> position = null;
        AnimatablePointValue size = null;
        boolean reversed = d == 3;
        boolean hidden = false;
        while (reader.hasNext()) {
            String nextName = reader.nextName();
            boolean z = true;
            switch (nextName.hashCode()) {
                case 100:
                    if (nextName.equals("d")) {
                        z = true;
                        break;
                    }
                    break;
                case 112:
                    if (nextName.equals(RsaJsonWebKey.FIRST_PRIME_FACTOR_MEMBER_NAME)) {
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
                    hidden = reader.nextBoolean();
                    break;
                case true:
                    reversed = reader.nextInt() == 3;
                    break;
                default:
                    reader.skipValue();
                    break;
            }
        }
        new CircleShape(name, position, size, reversed, hidden);
        return circleShape;
    }
}
