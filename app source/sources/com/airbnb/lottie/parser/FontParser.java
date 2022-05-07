package com.airbnb.lottie.parser;

import android.util.JsonReader;
import com.airbnb.lottie.model.Font;
import java.io.IOException;

class FontParser {
    private FontParser() {
    }

    static Font parse(JsonReader jsonReader) throws IOException {
        Font font;
        JsonReader reader = jsonReader;
        String family = null;
        String name = null;
        String style = null;
        float ascent = 0.0f;
        reader.beginObject();
        while (reader.hasNext()) {
            String nextName = reader.nextName();
            boolean z = true;
            switch (nextName.hashCode()) {
                case -1866931350:
                    if (nextName.equals("fFamily")) {
                        z = false;
                        break;
                    }
                    break;
                case -1408684838:
                    if (nextName.equals("ascent")) {
                        z = true;
                        break;
                    }
                    break;
                case -1294566165:
                    if (nextName.equals("fStyle")) {
                        z = true;
                        break;
                    }
                    break;
                case 96619537:
                    if (nextName.equals("fName")) {
                        z = true;
                        break;
                    }
                    break;
            }
            switch (z) {
                case false:
                    family = reader.nextString();
                    break;
                case true:
                    name = reader.nextString();
                    break;
                case true:
                    style = reader.nextString();
                    break;
                case true:
                    ascent = (float) reader.nextDouble();
                    break;
                default:
                    reader.skipValue();
                    break;
            }
        }
        reader.endObject();
        new Font(family, name, style, ascent);
        return font;
    }
}
