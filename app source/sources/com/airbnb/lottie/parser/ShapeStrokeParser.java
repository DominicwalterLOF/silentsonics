package com.airbnb.lottie.parser;

import android.util.JsonReader;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableColorValue;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableIntegerValue;
import com.airbnb.lottie.model.content.ShapeStroke;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.jose4j.jwk.RsaJsonWebKey;

class ShapeStrokeParser {
    private ShapeStrokeParser() {
    }

    static ShapeStroke parse(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        List<AnimatableFloatValue> list;
        ShapeStroke shapeStroke;
        JsonReader reader = jsonReader;
        LottieComposition composition = lottieComposition;
        String name = null;
        AnimatableColorValue color = null;
        AnimatableFloatValue width = null;
        AnimatableIntegerValue opacity = null;
        ShapeStroke.LineCapType capType = null;
        ShapeStroke.LineJoinType joinType = null;
        AnimatableFloatValue offset = null;
        float miterLimit = 0.0f;
        boolean hidden = false;
        new ArrayList<>();
        List<AnimatableFloatValue> lineDashPattern = list;
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
                case 100:
                    if (nextName.equals("d")) {
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
                case 119:
                    if (nextName.equals("w")) {
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
                case 3447:
                    if (nextName.equals("lc")) {
                        z = true;
                        break;
                    }
                    break;
                case 3454:
                    if (nextName.equals("lj")) {
                        z = true;
                        break;
                    }
                    break;
                case 3487:
                    if (nextName.equals("ml")) {
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
            }
            switch (z) {
                case false:
                    name = reader.nextString();
                    break;
                case true:
                    color = AnimatableValueParser.parseColor(reader, composition);
                    break;
                case true:
                    width = AnimatableValueParser.parseFloat(reader, composition);
                    break;
                case true:
                    opacity = AnimatableValueParser.parseInteger(reader, composition);
                    break;
                case true:
                    capType = ShapeStroke.LineCapType.values()[reader.nextInt() - 1];
                    break;
                case true:
                    joinType = ShapeStroke.LineJoinType.values()[reader.nextInt() - 1];
                    break;
                case true:
                    miterLimit = (float) reader.nextDouble();
                    break;
                case true:
                    hidden = reader.nextBoolean();
                    break;
                case true:
                    reader.beginArray();
                    while (reader.hasNext()) {
                        String n = null;
                        AnimatableFloatValue val = null;
                        reader.beginObject();
                        while (reader.hasNext()) {
                            String nextName2 = reader.nextName();
                            boolean z2 = true;
                            switch (nextName2.hashCode()) {
                                case 110:
                                    if (nextName2.equals(RsaJsonWebKey.MODULUS_MEMBER_NAME)) {
                                        z2 = false;
                                        break;
                                    }
                                    break;
                                case 118:
                                    if (nextName2.equals("v")) {
                                        z2 = true;
                                        break;
                                    }
                                    break;
                            }
                            switch (z2) {
                                case false:
                                    n = reader.nextString();
                                    break;
                                case true:
                                    val = AnimatableValueParser.parseFloat(reader, composition);
                                    break;
                                default:
                                    reader.skipValue();
                                    break;
                            }
                        }
                        reader.endObject();
                        String str = n;
                        boolean z3 = true;
                        switch (str.hashCode()) {
                            case 100:
                                if (str.equals("d")) {
                                    z3 = true;
                                    break;
                                }
                                break;
                            case 103:
                                if (str.equals("g")) {
                                    z3 = true;
                                    break;
                                }
                                break;
                            case 111:
                                if (str.equals("o")) {
                                    z3 = false;
                                    break;
                                }
                                break;
                        }
                        switch (z3) {
                            case false:
                                offset = val;
                                break;
                            case true:
                            case true:
                                composition.setHasDashPattern(true);
                                boolean add = lineDashPattern.add(val);
                                break;
                        }
                    }
                    reader.endArray();
                    if (lineDashPattern.size() != 1) {
                        break;
                    } else {
                        boolean add2 = lineDashPattern.add(lineDashPattern.get(0));
                        break;
                    }
                default:
                    reader.skipValue();
                    break;
            }
        }
        new ShapeStroke(name, offset, lineDashPattern, color, opacity, width, capType, joinType, miterLimit, hidden);
        return shapeStroke;
    }
}
