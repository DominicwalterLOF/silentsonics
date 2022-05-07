package com.airbnb.lottie.parser;

import android.util.JsonReader;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableGradientColorValue;
import com.airbnb.lottie.model.animatable.AnimatableIntegerValue;
import com.airbnb.lottie.model.animatable.AnimatablePointValue;
import com.airbnb.lottie.model.content.GradientStroke;
import com.airbnb.lottie.model.content.GradientType;
import com.airbnb.lottie.model.content.ShapeStroke;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.jose4j.jwk.OctetSequenceJsonWebKey;
import org.jose4j.jwk.RsaJsonWebKey;

class GradientStrokeParser {
    private GradientStrokeParser() {
    }

    static GradientStroke parse(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        List<AnimatableFloatValue> list;
        GradientStroke gradientStroke;
        JsonReader reader = jsonReader;
        LottieComposition composition = lottieComposition;
        String name = null;
        AnimatableGradientColorValue color = null;
        AnimatableIntegerValue opacity = null;
        GradientType gradientType = null;
        AnimatablePointValue startPoint = null;
        AnimatablePointValue endPoint = null;
        AnimatableFloatValue width = null;
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
                case 100:
                    if (nextName.equals("d")) {
                        z = true;
                        break;
                    }
                    break;
                case 101:
                    if (nextName.equals(RsaJsonWebKey.EXPONENT_MEMBER_NAME)) {
                        z = true;
                        break;
                    }
                    break;
                case 103:
                    if (nextName.equals("g")) {
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
                case 115:
                    if (nextName.equals("s")) {
                        z = true;
                        break;
                    }
                    break;
                case 116:
                    if (nextName.equals(RsaJsonWebKey.FACTOR_CRT_COEFFICIENT)) {
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
                    int points = -1;
                    reader.beginObject();
                    while (reader.hasNext()) {
                        String nextName2 = reader.nextName();
                        boolean z2 = true;
                        switch (nextName2.hashCode()) {
                            case 107:
                                if (nextName2.equals(OctetSequenceJsonWebKey.KEY_VALUE_MEMBER_NAME)) {
                                    z2 = true;
                                    break;
                                }
                                break;
                            case 112:
                                if (nextName2.equals(RsaJsonWebKey.FIRST_PRIME_FACTOR_MEMBER_NAME)) {
                                    z2 = false;
                                    break;
                                }
                                break;
                        }
                        switch (z2) {
                            case false:
                                points = reader.nextInt();
                                break;
                            case true:
                                color = AnimatableValueParser.parseGradientColor(reader, composition, points);
                                break;
                            default:
                                reader.skipValue();
                                break;
                        }
                    }
                    reader.endObject();
                    break;
                case true:
                    opacity = AnimatableValueParser.parseInteger(reader, composition);
                    break;
                case true:
                    gradientType = reader.nextInt() == 1 ? GradientType.LINEAR : GradientType.RADIAL;
                    break;
                case true:
                    startPoint = AnimatableValueParser.parsePoint(reader, composition);
                    break;
                case true:
                    endPoint = AnimatableValueParser.parsePoint(reader, composition);
                    break;
                case true:
                    width = AnimatableValueParser.parseFloat(reader, composition);
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
                            String nextName3 = reader.nextName();
                            boolean z3 = true;
                            switch (nextName3.hashCode()) {
                                case 110:
                                    if (nextName3.equals(RsaJsonWebKey.MODULUS_MEMBER_NAME)) {
                                        z3 = false;
                                        break;
                                    }
                                    break;
                                case 118:
                                    if (nextName3.equals("v")) {
                                        z3 = true;
                                        break;
                                    }
                                    break;
                            }
                            switch (z3) {
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
                        if (n.equals("o")) {
                            offset = val;
                        } else if (n.equals("d") || n.equals("g")) {
                            composition.setHasDashPattern(true);
                            boolean add = lineDashPattern.add(val);
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
        new GradientStroke(name, gradientType, color, opacity, startPoint, endPoint, width, capType, joinType, miterLimit, lineDashPattern, offset, hidden);
        return gradientStroke;
    }
}
