package com.airbnb.lottie.parser;

import android.graphics.Path;
import android.util.JsonReader;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableGradientColorValue;
import com.airbnb.lottie.model.animatable.AnimatableIntegerValue;
import com.airbnb.lottie.model.animatable.AnimatablePointValue;
import com.airbnb.lottie.model.content.GradientFill;
import com.airbnb.lottie.model.content.GradientType;
import java.io.IOException;
import org.jose4j.jwk.OctetSequenceJsonWebKey;
import org.jose4j.jwk.RsaJsonWebKey;

class GradientFillParser {
    private GradientFillParser() {
    }

    static GradientFill parse(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        GradientFill gradientFill;
        JsonReader reader = jsonReader;
        LottieComposition composition = lottieComposition;
        String name = null;
        AnimatableGradientColorValue color = null;
        AnimatableIntegerValue opacity = null;
        GradientType gradientType = null;
        AnimatablePointValue startPoint = null;
        AnimatablePointValue endPoint = null;
        Path.FillType fillType = Path.FillType.WINDING;
        boolean hidden = false;
        while (reader.hasNext()) {
            String nextName = reader.nextName();
            boolean z = true;
            switch (nextName.hashCode()) {
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
                case 114:
                    if (nextName.equals(RsaJsonWebKey.PRIME_FACTOR_OTHER_MEMBER_NAME)) {
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
                case 3324:
                    if (nextName.equals("hd")) {
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
                    fillType = reader.nextInt() == 1 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD;
                    break;
                case true:
                    hidden = reader.nextBoolean();
                    break;
                default:
                    reader.skipValue();
                    break;
            }
        }
        new GradientFill(name, gradientType, fillType, color, opacity, startPoint, endPoint, (AnimatableFloatValue) null, (AnimatableFloatValue) null, hidden);
        return gradientFill;
    }
}
