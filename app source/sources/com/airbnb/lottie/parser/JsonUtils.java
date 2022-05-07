package com.airbnb.lottie.parser;

import android.graphics.Color;
import android.graphics.PointF;
import android.util.JsonReader;
import android.util.JsonToken;
import androidx.annotation.ColorInt;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.jose4j.jwk.EllipticCurveJsonWebKey;

class JsonUtils {
    private JsonUtils() {
    }

    @ColorInt
    static int jsonToColor(JsonReader jsonReader) throws IOException {
        JsonReader reader = jsonReader;
        reader.beginArray();
        int r = (int) (reader.nextDouble() * 255.0d);
        int g = (int) (reader.nextDouble() * 255.0d);
        int b = (int) (reader.nextDouble() * 255.0d);
        while (reader.hasNext()) {
            reader.skipValue();
        }
        reader.endArray();
        return Color.argb(255, r, g, b);
    }

    static List<PointF> jsonToPoints(JsonReader jsonReader, float f) throws IOException {
        List<PointF> list;
        JsonReader reader = jsonReader;
        float scale = f;
        new ArrayList();
        List<PointF> points = list;
        reader.beginArray();
        while (reader.peek() == JsonToken.BEGIN_ARRAY) {
            reader.beginArray();
            boolean add = points.add(jsonToPoint(reader, scale));
            reader.endArray();
        }
        reader.endArray();
        return points;
    }

    /* renamed from: com.airbnb.lottie.parser.JsonUtils$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$android$util$JsonToken = new int[JsonToken.values().length];

        static {
            try {
                $SwitchMap$android$util$JsonToken[JsonToken.NUMBER.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
                NoSuchFieldError noSuchFieldError = e;
            }
            try {
                $SwitchMap$android$util$JsonToken[JsonToken.BEGIN_ARRAY.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
                NoSuchFieldError noSuchFieldError2 = e2;
            }
            try {
                $SwitchMap$android$util$JsonToken[JsonToken.BEGIN_OBJECT.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
                NoSuchFieldError noSuchFieldError3 = e3;
            }
        }
    }

    static PointF jsonToPoint(JsonReader jsonReader, float f) throws IOException {
        Throwable th;
        StringBuilder sb;
        JsonReader reader = jsonReader;
        float scale = f;
        switch (AnonymousClass1.$SwitchMap$android$util$JsonToken[reader.peek().ordinal()]) {
            case 1:
                return jsonNumbersToPoint(reader, scale);
            case 2:
                return jsonArrayToPoint(reader, scale);
            case 3:
                return jsonObjectToPoint(reader, scale);
            default:
                Throwable th2 = th;
                new StringBuilder();
                new IllegalArgumentException(sb.append("Unknown point starts with ").append(reader.peek()).toString());
                throw th2;
        }
    }

    private static PointF jsonNumbersToPoint(JsonReader jsonReader, float f) throws IOException {
        PointF pointF;
        JsonReader reader = jsonReader;
        float scale = f;
        float x = (float) reader.nextDouble();
        float y = (float) reader.nextDouble();
        while (reader.hasNext()) {
            reader.skipValue();
        }
        new PointF(x * scale, y * scale);
        return pointF;
    }

    private static PointF jsonArrayToPoint(JsonReader jsonReader, float f) throws IOException {
        PointF pointF;
        JsonReader reader = jsonReader;
        float scale = f;
        reader.beginArray();
        float x = (float) reader.nextDouble();
        float y = (float) reader.nextDouble();
        while (reader.peek() != JsonToken.END_ARRAY) {
            reader.skipValue();
        }
        reader.endArray();
        new PointF(x * scale, y * scale);
        return pointF;
    }

    private static PointF jsonObjectToPoint(JsonReader jsonReader, float f) throws IOException {
        PointF pointF;
        JsonReader reader = jsonReader;
        float scale = f;
        float x = 0.0f;
        float y = 0.0f;
        reader.beginObject();
        while (reader.hasNext()) {
            String nextName = reader.nextName();
            boolean z = true;
            switch (nextName.hashCode()) {
                case 120:
                    if (nextName.equals(EllipticCurveJsonWebKey.X_MEMBER_NAME)) {
                        z = false;
                        break;
                    }
                    break;
                case 121:
                    if (nextName.equals(EllipticCurveJsonWebKey.Y_MEMBER_NAME)) {
                        z = true;
                        break;
                    }
                    break;
            }
            switch (z) {
                case false:
                    x = valueFromObject(reader);
                    break;
                case true:
                    y = valueFromObject(reader);
                    break;
                default:
                    reader.skipValue();
                    break;
            }
        }
        reader.endObject();
        new PointF(x * scale, y * scale);
        return pointF;
    }

    static float valueFromObject(JsonReader jsonReader) throws IOException {
        Throwable th;
        StringBuilder sb;
        JsonReader reader = jsonReader;
        JsonToken token = reader.peek();
        switch (AnonymousClass1.$SwitchMap$android$util$JsonToken[token.ordinal()]) {
            case 1:
                return (float) reader.nextDouble();
            case 2:
                reader.beginArray();
                float val = (float) reader.nextDouble();
                while (reader.hasNext()) {
                    reader.skipValue();
                }
                reader.endArray();
                return val;
            default:
                Throwable th2 = th;
                new StringBuilder();
                new IllegalArgumentException(sb.append("Unknown value for token of type ").append(token).toString());
                throw th2;
        }
    }
}
