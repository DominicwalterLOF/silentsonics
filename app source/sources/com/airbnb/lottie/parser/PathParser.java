package com.airbnb.lottie.parser;

import android.graphics.PointF;
import android.util.JsonReader;
import java.io.IOException;

public class PathParser implements ValueParser<PointF> {
    public static final PathParser INSTANCE;

    static {
        PathParser pathParser;
        new PathParser();
        INSTANCE = pathParser;
    }

    private PathParser() {
    }

    public PointF parse(JsonReader reader, float scale) throws IOException {
        return JsonUtils.jsonToPoint(reader, scale);
    }
}
