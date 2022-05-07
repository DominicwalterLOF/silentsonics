package com.airbnb.lottie.parser;

import android.graphics.PointF;
import android.util.JsonReader;
import android.util.JsonToken;
import java.io.IOException;

public class PointFParser implements ValueParser<PointF> {
    public static final PointFParser INSTANCE;

    static {
        PointFParser pointFParser;
        new PointFParser();
        INSTANCE = pointFParser;
    }

    private PointFParser() {
    }

    public PointF parse(JsonReader jsonReader, float f) throws IOException {
        Throwable th;
        StringBuilder sb;
        PointF pointF;
        JsonReader reader = jsonReader;
        float scale = f;
        JsonToken token = reader.peek();
        if (token == JsonToken.BEGIN_ARRAY) {
            return JsonUtils.jsonToPoint(reader, scale);
        }
        if (token == JsonToken.BEGIN_OBJECT) {
            return JsonUtils.jsonToPoint(reader, scale);
        }
        if (token == JsonToken.NUMBER) {
            new PointF(((float) reader.nextDouble()) * scale, ((float) reader.nextDouble()) * scale);
            PointF point = pointF;
            while (reader.hasNext()) {
                reader.skipValue();
            }
            return point;
        }
        Throwable th2 = th;
        new StringBuilder();
        new IllegalArgumentException(sb.append("Cannot convert json to point. Next token is ").append(token).toString());
        throw th2;
    }
}
