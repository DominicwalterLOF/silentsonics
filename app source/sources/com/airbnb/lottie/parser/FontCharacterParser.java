package com.airbnb.lottie.parser;

import android.util.JsonReader;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.FontCharacter;
import com.airbnb.lottie.model.content.ShapeGroup;
import com.google.appinventor.components.common.PropertyTypeConstants;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class FontCharacterParser {
    private FontCharacterParser() {
    }

    static FontCharacter parse(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        List<ShapeGroup> list;
        FontCharacter fontCharacter;
        JsonReader reader = jsonReader;
        LottieComposition composition = lottieComposition;
        char character = 0;
        double size = 0.0d;
        double width = 0.0d;
        String style = null;
        String fontFamily = null;
        new ArrayList<>();
        List<ShapeGroup> shapes = list;
        reader.beginObject();
        while (reader.hasNext()) {
            String nextName = reader.nextName();
            boolean z = true;
            switch (nextName.hashCode()) {
                case -1866931350:
                    if (nextName.equals("fFamily")) {
                        z = true;
                        break;
                    }
                    break;
                case 119:
                    if (nextName.equals("w")) {
                        z = true;
                        break;
                    }
                    break;
                case 3173:
                    if (nextName.equals("ch")) {
                        z = false;
                        break;
                    }
                    break;
                case 3076010:
                    if (nextName.equals("data")) {
                        z = true;
                        break;
                    }
                    break;
                case 3530753:
                    if (nextName.equals(PropertyTypeConstants.PROPERTY_TYPE_FAB_SIZE)) {
                        z = true;
                        break;
                    }
                    break;
                case 109780401:
                    if (nextName.equals("style")) {
                        z = true;
                        break;
                    }
                    break;
            }
            switch (z) {
                case false:
                    character = reader.nextString().charAt(0);
                    break;
                case true:
                    size = reader.nextDouble();
                    break;
                case true:
                    width = reader.nextDouble();
                    break;
                case true:
                    style = reader.nextString();
                    break;
                case true:
                    fontFamily = reader.nextString();
                    break;
                case true:
                    reader.beginObject();
                    while (reader.hasNext()) {
                        if ("shapes".equals(reader.nextName())) {
                            reader.beginArray();
                            while (reader.hasNext()) {
                                boolean add = shapes.add((ShapeGroup) ContentModelParser.parse(reader, composition));
                            }
                            reader.endArray();
                        } else {
                            reader.skipValue();
                        }
                    }
                    reader.endObject();
                    break;
                default:
                    reader.skipValue();
                    break;
            }
        }
        reader.endObject();
        new FontCharacter(shapes, character, size, width, style, fontFamily);
        return fontCharacter;
    }
}
