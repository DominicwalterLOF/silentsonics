package com.airbnb.lottie.parser;

import android.util.JsonReader;
import androidx.annotation.Nullable;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.content.ContentModel;
import com.airbnb.lottie.utils.Logger;
import java.io.IOException;

class ContentModelParser {
    private ContentModelParser() {
    }

    @Nullable
    static ContentModel parse(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        StringBuilder sb;
        JsonReader reader = jsonReader;
        LottieComposition composition = lottieComposition;
        String type = null;
        reader.beginObject();
        int d = 2;
        while (true) {
            if (reader.hasNext()) {
                String nextName = reader.nextName();
                boolean z = true;
                switch (nextName.hashCode()) {
                    case 100:
                        if (nextName.equals("d")) {
                            z = true;
                            break;
                        }
                        break;
                    case 3717:
                        if (nextName.equals("ty")) {
                            z = false;
                            break;
                        }
                        break;
                }
                switch (z) {
                    case false:
                        type = reader.nextString();
                        break;
                    case true:
                        d = reader.nextInt();
                        continue;
                    default:
                        reader.skipValue();
                        continue;
                }
            }
        }
        if (type == null) {
            return null;
        }
        ContentModel model = null;
        String str = type;
        boolean z2 = true;
        switch (str.hashCode()) {
            case 3239:
                if (str.equals("el")) {
                    z2 = true;
                    break;
                }
                break;
            case 3270:
                if (str.equals("fl")) {
                    z2 = true;
                    break;
                }
                break;
            case 3295:
                if (str.equals("gf")) {
                    z2 = true;
                    break;
                }
                break;
            case 3307:
                if (str.equals("gr")) {
                    z2 = false;
                    break;
                }
                break;
            case 3308:
                if (str.equals("gs")) {
                    z2 = true;
                    break;
                }
                break;
            case 3488:
                if (str.equals("mm")) {
                    z2 = true;
                    break;
                }
                break;
            case 3633:
                if (str.equals("rc")) {
                    z2 = true;
                    break;
                }
                break;
            case 3646:
                if (str.equals("rp")) {
                    z2 = true;
                    break;
                }
                break;
            case 3669:
                if (str.equals("sh")) {
                    z2 = true;
                    break;
                }
                break;
            case 3679:
                if (str.equals("sr")) {
                    z2 = true;
                    break;
                }
                break;
            case 3681:
                if (str.equals("st")) {
                    z2 = true;
                    break;
                }
                break;
            case 3705:
                if (str.equals("tm")) {
                    z2 = true;
                    break;
                }
                break;
            case 3710:
                if (str.equals("tr")) {
                    z2 = true;
                    break;
                }
                break;
        }
        switch (z2) {
            case false:
                model = ShapeGroupParser.parse(reader, composition);
                break;
            case true:
                model = ShapeStrokeParser.parse(reader, composition);
                break;
            case true:
                model = GradientStrokeParser.parse(reader, composition);
                break;
            case true:
                model = ShapeFillParser.parse(reader, composition);
                break;
            case true:
                model = GradientFillParser.parse(reader, composition);
                break;
            case true:
                model = AnimatableTransformParser.parse(reader, composition);
                break;
            case true:
                model = ShapePathParser.parse(reader, composition);
                break;
            case true:
                model = CircleShapeParser.parse(reader, composition, d);
                break;
            case true:
                model = RectangleShapeParser.parse(reader, composition);
                break;
            case true:
                model = ShapeTrimPathParser.parse(reader, composition);
                break;
            case true:
                model = PolystarShapeParser.parse(reader, composition);
                break;
            case true:
                model = MergePathsParser.parse(reader);
                composition.addWarning("Animation contains merge paths. Merge paths are only supported on KitKat+ and must be manually enabled by calling enableMergePathsForKitKatAndAbove().");
                break;
            case true:
                model = RepeaterParser.parse(reader, composition);
                break;
            default:
                new StringBuilder();
                Logger.warning(sb.append("Unknown shape type ").append(type).toString());
                break;
        }
        while (reader.hasNext()) {
            reader.skipValue();
        }
        reader.endObject();
        return model;
    }
}
