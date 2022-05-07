package com.airbnb.lottie.parser;

import android.util.JsonReader;
import android.util.JsonToken;
import com.airbnb.lottie.value.ScaleXY;
import java.io.IOException;

public class ScaleXYParser implements ValueParser<ScaleXY> {
    public static final ScaleXYParser INSTANCE;

    static {
        ScaleXYParser scaleXYParser;
        new ScaleXYParser();
        INSTANCE = scaleXYParser;
    }

    private ScaleXYParser() {
    }

    public ScaleXY parse(JsonReader jsonReader, float f) throws IOException {
        ScaleXY scaleXY;
        JsonReader reader = jsonReader;
        float scale = f;
        boolean isArray = reader.peek() == JsonToken.BEGIN_ARRAY;
        if (isArray) {
            reader.beginArray();
        }
        float sx = (float) reader.nextDouble();
        float sy = (float) reader.nextDouble();
        while (reader.hasNext()) {
            reader.skipValue();
        }
        if (isArray) {
            reader.endArray();
        }
        new ScaleXY((sx / 100.0f) * scale, (sy / 100.0f) * scale);
        return scaleXY;
    }
}
