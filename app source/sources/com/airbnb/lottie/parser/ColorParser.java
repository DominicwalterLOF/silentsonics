package com.airbnb.lottie.parser;

import android.graphics.Color;
import android.util.JsonReader;
import android.util.JsonToken;
import java.io.IOException;

public class ColorParser implements ValueParser<Integer> {
    public static final ColorParser INSTANCE;

    static {
        ColorParser colorParser;
        new ColorParser();
        INSTANCE = colorParser;
    }

    private ColorParser() {
    }

    public Integer parse(JsonReader jsonReader, float f) throws IOException {
        JsonReader reader = jsonReader;
        float f2 = f;
        boolean isArray = reader.peek() == JsonToken.BEGIN_ARRAY;
        if (isArray) {
            reader.beginArray();
        }
        double r = reader.nextDouble();
        double g = reader.nextDouble();
        double b = reader.nextDouble();
        double a = reader.nextDouble();
        if (isArray) {
            reader.endArray();
        }
        if (r <= 1.0d && g <= 1.0d && b <= 1.0d && a <= 1.0d) {
            r *= 255.0d;
            g *= 255.0d;
            b *= 255.0d;
            a *= 255.0d;
        }
        return Integer.valueOf(Color.argb((int) a, (int) r, (int) g, (int) b));
    }
}
