package com.airbnb.lottie.parser;

import android.graphics.PointF;
import android.util.JsonReader;
import android.util.JsonToken;
import com.airbnb.lottie.model.CubicCurveData;
import com.airbnb.lottie.model.content.ShapeData;
import com.airbnb.lottie.utils.MiscUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ShapeDataParser implements ValueParser<ShapeData> {
    public static final ShapeDataParser INSTANCE;

    static {
        ShapeDataParser shapeDataParser;
        new ShapeDataParser();
        INSTANCE = shapeDataParser;
    }

    private ShapeDataParser() {
    }

    public ShapeData parse(JsonReader jsonReader, float f) throws IOException {
        Throwable th;
        List<CubicCurveData> list;
        ShapeData shapeData;
        Object obj;
        Object obj2;
        ShapeData shapeData2;
        PointF pointF;
        JsonReader reader = jsonReader;
        float scale = f;
        if (reader.peek() == JsonToken.BEGIN_ARRAY) {
            reader.beginArray();
        }
        boolean closed = false;
        List<PointF> pointsArray = null;
        List<PointF> inTangents = null;
        List<PointF> outTangents = null;
        reader.beginObject();
        while (reader.hasNext()) {
            String nextName = reader.nextName();
            boolean z = true;
            switch (nextName.hashCode()) {
                case 99:
                    if (nextName.equals("c")) {
                        z = false;
                        break;
                    }
                    break;
                case 105:
                    if (nextName.equals("i")) {
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
                case 118:
                    if (nextName.equals("v")) {
                        z = true;
                        break;
                    }
                    break;
            }
            switch (z) {
                case false:
                    closed = reader.nextBoolean();
                    break;
                case true:
                    pointsArray = JsonUtils.jsonToPoints(reader, scale);
                    break;
                case true:
                    inTangents = JsonUtils.jsonToPoints(reader, scale);
                    break;
                case true:
                    outTangents = JsonUtils.jsonToPoints(reader, scale);
                    break;
            }
        }
        reader.endObject();
        if (reader.peek() == JsonToken.END_ARRAY) {
            reader.endArray();
        }
        if (pointsArray == null || inTangents == null || outTangents == null) {
            Throwable th2 = th;
            new IllegalArgumentException("Shape data was missing information.");
            throw th2;
        } else if (pointsArray.isEmpty()) {
            new PointF();
            new ShapeData(pointF, false, Collections.emptyList());
            return shapeData2;
        } else {
            int length = pointsArray.size();
            PointF initialPoint = pointsArray.get(0);
            new ArrayList<>(length);
            List<CubicCurveData> curves = list;
            for (int i = 1; i < length; i++) {
                PointF vertex = pointsArray.get(i);
                new CubicCurveData(MiscUtils.addPoints(pointsArray.get(i - 1), outTangents.get(i - 1)), MiscUtils.addPoints(vertex, inTangents.get(i)), vertex);
                boolean add = curves.add(obj2);
            }
            if (closed) {
                PointF vertex2 = pointsArray.get(0);
                new CubicCurveData(MiscUtils.addPoints(pointsArray.get(length - 1), outTangents.get(length - 1)), MiscUtils.addPoints(vertex2, inTangents.get(0)), vertex2);
                boolean add2 = curves.add(obj);
            }
            new ShapeData(initialPoint, closed, curves);
            return shapeData;
        }
    }
}
