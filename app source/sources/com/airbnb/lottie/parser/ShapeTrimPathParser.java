package com.airbnb.lottie.parser;

import android.util.JsonReader;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import java.io.IOException;
import org.jose4j.jwk.RsaJsonWebKey;

class ShapeTrimPathParser {
    private ShapeTrimPathParser() {
    }

    static ShapeTrimPath parse(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        ShapeTrimPath shapeTrimPath;
        JsonReader reader = jsonReader;
        LottieComposition composition = lottieComposition;
        String name = null;
        ShapeTrimPath.Type type = null;
        AnimatableFloatValue start = null;
        AnimatableFloatValue end = null;
        AnimatableFloatValue offset = null;
        boolean hidden = false;
        while (reader.hasNext()) {
            String nextName = reader.nextName();
            boolean z = true;
            switch (nextName.hashCode()) {
                case 101:
                    if (nextName.equals(RsaJsonWebKey.EXPONENT_MEMBER_NAME)) {
                        z = true;
                        break;
                    }
                    break;
                case 109:
                    if (nextName.equals("m")) {
                        z = true;
                        break;
                    }
                    break;
                case 111:
                    if (nextName.equals("o")) {
                        z = true;
                        break;
                    }
                    break;
                case 115:
                    if (nextName.equals("s")) {
                        z = false;
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
                        z = true;
                        break;
                    }
                    break;
            }
            switch (z) {
                case false:
                    start = AnimatableValueParser.parseFloat(reader, composition, false);
                    break;
                case true:
                    end = AnimatableValueParser.parseFloat(reader, composition, false);
                    break;
                case true:
                    offset = AnimatableValueParser.parseFloat(reader, composition, false);
                    break;
                case true:
                    name = reader.nextString();
                    break;
                case true:
                    type = ShapeTrimPath.Type.forId(reader.nextInt());
                    break;
                case true:
                    hidden = reader.nextBoolean();
                    break;
                default:
                    reader.skipValue();
                    break;
            }
        }
        new ShapeTrimPath(name, type, start, end, offset, hidden);
        return shapeTrimPath;
    }
}
