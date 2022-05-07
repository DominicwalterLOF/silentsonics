package com.airbnb.lottie.parser;

import android.util.JsonReader;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableShapeValue;
import com.airbnb.lottie.model.content.ShapePath;
import java.io.IOException;

class ShapePathParser {
    private ShapePathParser() {
    }

    static ShapePath parse(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        ShapePath shapePath;
        JsonReader reader = jsonReader;
        LottieComposition composition = lottieComposition;
        String name = null;
        int ind = 0;
        AnimatableShapeValue shape = null;
        boolean hidden = false;
        while (reader.hasNext()) {
            String nextName = reader.nextName();
            boolean z = true;
            switch (nextName.hashCode()) {
                case 3324:
                    if (nextName.equals("hd")) {
                        z = true;
                        break;
                    }
                    break;
                case 3432:
                    if (nextName.equals("ks")) {
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
                case 104415:
                    if (nextName.equals("ind")) {
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
                    ind = reader.nextInt();
                    break;
                case true:
                    shape = AnimatableValueParser.parseShapeData(reader, composition);
                    break;
                case true:
                    hidden = reader.nextBoolean();
                    break;
                default:
                    reader.skipValue();
                    break;
            }
        }
        new ShapePath(name, ind, shape, hidden);
        return shapePath;
    }
}
