package com.airbnb.lottie.parser;

import android.graphics.PointF;
import android.util.JsonReader;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableValue;
import com.airbnb.lottie.model.content.PolystarShape;
import java.io.IOException;
import org.jose4j.jwk.RsaJsonWebKey;

class PolystarShapeParser {
    private PolystarShapeParser() {
    }

    static PolystarShape parse(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        PolystarShape polystarShape;
        JsonReader reader = jsonReader;
        LottieComposition composition = lottieComposition;
        String name = null;
        PolystarShape.Type type = null;
        AnimatableFloatValue points = null;
        AnimatableValue<PointF, PointF> position = null;
        AnimatableFloatValue rotation = null;
        AnimatableFloatValue outerRadius = null;
        AnimatableFloatValue outerRoundedness = null;
        AnimatableFloatValue innerRadius = null;
        AnimatableFloatValue innerRoundedness = null;
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
                case 3324:
                    if (nextName.equals("hd")) {
                        z = true;
                        break;
                    }
                    break;
                case 3369:
                    if (nextName.equals("ir")) {
                        z = true;
                        break;
                    }
                    break;
                case 3370:
                    if (nextName.equals("is")) {
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
                case 3555:
                    if (nextName.equals("or")) {
                        z = true;
                        break;
                    }
                    break;
                case 3556:
                    if (nextName.equals("os")) {
                        z = true;
                        break;
                    }
                    break;
                case 3588:
                    if (nextName.equals("pt")) {
                        z = true;
                        break;
                    }
                    break;
                case 3686:
                    if (nextName.equals("sy")) {
                        z = true;
                        break;
                    }
                    break;
            }
            switch (z) {
                case false:
                    name = reader.nextString();
                    break;
                case true:
                    type = PolystarShape.Type.forValue(reader.nextInt());
                    break;
                case true:
                    points = AnimatableValueParser.parseFloat(reader, composition, false);
                    break;
                case true:
                    position = AnimatablePathValueParser.parseSplitPath(reader, composition);
                    break;
                case true:
                    rotation = AnimatableValueParser.parseFloat(reader, composition, false);
                    break;
                case true:
                    outerRadius = AnimatableValueParser.parseFloat(reader, composition);
                    break;
                case true:
                    outerRoundedness = AnimatableValueParser.parseFloat(reader, composition, false);
                    break;
                case true:
                    innerRadius = AnimatableValueParser.parseFloat(reader, composition);
                    break;
                case true:
                    innerRoundedness = AnimatableValueParser.parseFloat(reader, composition, false);
                    break;
                case true:
                    hidden = reader.nextBoolean();
                    break;
                default:
                    reader.skipValue();
                    break;
            }
        }
        new PolystarShape(name, type, points, position, rotation, innerRadius, outerRadius, innerRoundedness, outerRoundedness, hidden);
        return polystarShape;
    }
}
