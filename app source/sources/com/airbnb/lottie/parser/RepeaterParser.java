package com.airbnb.lottie.parser;

import android.util.JsonReader;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableTransform;
import com.airbnb.lottie.model.content.Repeater;
import java.io.IOException;

class RepeaterParser {
    private RepeaterParser() {
    }

    static Repeater parse(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        Repeater repeater;
        JsonReader reader = jsonReader;
        LottieComposition composition = lottieComposition;
        String name = null;
        AnimatableFloatValue copies = null;
        AnimatableFloatValue offset = null;
        AnimatableTransform transform = null;
        boolean hidden = false;
        while (reader.hasNext()) {
            String nextName = reader.nextName();
            boolean z = true;
            switch (nextName.hashCode()) {
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
                case 3710:
                    if (nextName.equals("tr")) {
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
                    copies = AnimatableValueParser.parseFloat(reader, composition, false);
                    break;
                case true:
                    offset = AnimatableValueParser.parseFloat(reader, composition, false);
                    break;
                case true:
                    transform = AnimatableTransformParser.parse(reader, composition);
                    break;
                case true:
                    hidden = reader.nextBoolean();
                    break;
                default:
                    reader.skipValue();
                    break;
            }
        }
        new Repeater(name, copies, offset, transform, hidden);
        return repeater;
    }
}
