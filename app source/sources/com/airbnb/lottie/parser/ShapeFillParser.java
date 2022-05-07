package com.airbnb.lottie.parser;

import android.graphics.Path;
import android.util.JsonReader;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableColorValue;
import com.airbnb.lottie.model.animatable.AnimatableIntegerValue;
import com.airbnb.lottie.model.content.ShapeFill;
import java.io.IOException;
import org.jose4j.jwk.RsaJsonWebKey;

class ShapeFillParser {
    private ShapeFillParser() {
    }

    static ShapeFill parse(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        ShapeFill shapeFill;
        JsonReader reader = jsonReader;
        LottieComposition composition = lottieComposition;
        AnimatableColorValue color = null;
        boolean fillEnabled = false;
        AnimatableIntegerValue opacity = null;
        String name = null;
        int fillTypeInt = 1;
        boolean hidden = false;
        while (reader.hasNext()) {
            String nextName = reader.nextName();
            boolean z = true;
            switch (nextName.hashCode()) {
                case -396065730:
                    if (nextName.equals("fillEnabled")) {
                        z = true;
                        break;
                    }
                    break;
                case 99:
                    if (nextName.equals("c")) {
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
                    color = AnimatableValueParser.parseColor(reader, composition);
                    break;
                case true:
                    opacity = AnimatableValueParser.parseInteger(reader, composition);
                    break;
                case true:
                    fillEnabled = reader.nextBoolean();
                    break;
                case true:
                    fillTypeInt = reader.nextInt();
                    break;
                case true:
                    hidden = reader.nextBoolean();
                    break;
                default:
                    reader.skipValue();
                    break;
            }
        }
        new ShapeFill(name, fillEnabled, fillTypeInt == 1 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD, color, opacity, hidden);
        return shapeFill;
    }
}
