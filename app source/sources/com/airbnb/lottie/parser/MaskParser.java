package com.airbnb.lottie.parser;

import android.util.JsonReader;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableIntegerValue;
import com.airbnb.lottie.model.animatable.AnimatableShapeValue;
import com.airbnb.lottie.model.content.Mask;
import com.airbnb.lottie.utils.Logger;
import java.io.IOException;

class MaskParser {
    private MaskParser() {
    }

    static Mask parse(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        Mask mask;
        StringBuilder sb;
        JsonReader reader = jsonReader;
        LottieComposition composition = lottieComposition;
        Mask.MaskMode maskMode = null;
        AnimatableShapeValue maskPath = null;
        AnimatableIntegerValue opacity = null;
        boolean inverted = false;
        reader.beginObject();
        while (reader.hasNext()) {
            String mode = reader.nextName();
            String str = mode;
            boolean z = true;
            switch (str.hashCode()) {
                case 111:
                    if (str.equals("o")) {
                        z = true;
                        break;
                    }
                    break;
                case 3588:
                    if (str.equals("pt")) {
                        z = true;
                        break;
                    }
                    break;
                case 104433:
                    if (str.equals("inv")) {
                        z = true;
                        break;
                    }
                    break;
                case 3357091:
                    if (str.equals("mode")) {
                        z = false;
                        break;
                    }
                    break;
            }
            switch (z) {
                case false:
                    String nextString = reader.nextString();
                    boolean z2 = true;
                    switch (nextString.hashCode()) {
                        case 97:
                            if (nextString.equals("a")) {
                                z2 = false;
                                break;
                            }
                            break;
                        case 105:
                            if (nextString.equals("i")) {
                                z2 = true;
                                break;
                            }
                            break;
                        case 115:
                            if (nextString.equals("s")) {
                                z2 = true;
                                break;
                            }
                            break;
                    }
                    switch (z2) {
                        case false:
                            maskMode = Mask.MaskMode.MASK_MODE_ADD;
                            break;
                        case true:
                            maskMode = Mask.MaskMode.MASK_MODE_SUBTRACT;
                            break;
                        case true:
                            composition.addWarning("Animation contains intersect masks. They are not supported but will be treated like add masks.");
                            maskMode = Mask.MaskMode.MASK_MODE_INTERSECT;
                            break;
                        default:
                            new StringBuilder();
                            Logger.warning(sb.append("Unknown mask mode ").append(mode).append(". Defaulting to Add.").toString());
                            maskMode = Mask.MaskMode.MASK_MODE_ADD;
                            break;
                    }
                case true:
                    maskPath = AnimatableValueParser.parseShapeData(reader, composition);
                    break;
                case true:
                    opacity = AnimatableValueParser.parseInteger(reader, composition);
                    break;
                case true:
                    inverted = reader.nextBoolean();
                    break;
                default:
                    reader.skipValue();
                    break;
            }
        }
        reader.endObject();
        new Mask(maskMode, maskPath, opacity, inverted);
        return mask;
    }
}
