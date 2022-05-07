package com.airbnb.lottie.parser;

import android.util.JsonReader;
import com.airbnb.lottie.model.DocumentData;
import java.io.IOException;
import org.jose4j.jwk.RsaJsonWebKey;

public class DocumentDataParser implements ValueParser<DocumentData> {
    public static final DocumentDataParser INSTANCE;

    static {
        DocumentDataParser documentDataParser;
        new DocumentDataParser();
        INSTANCE = documentDataParser;
    }

    private DocumentDataParser() {
    }

    public DocumentData parse(JsonReader jsonReader, float f) throws IOException {
        DocumentData documentData;
        JsonReader reader = jsonReader;
        float f2 = f;
        String text = null;
        String fontName = null;
        double size = 0.0d;
        DocumentData.Justification justification = DocumentData.Justification.CENTER;
        int tracking = 0;
        double lineHeight = 0.0d;
        double baselineShift = 0.0d;
        int fillColor = 0;
        int strokeColor = 0;
        double strokeWidth = 0.0d;
        boolean strokeOverFill = true;
        reader.beginObject();
        while (reader.hasNext()) {
            String nextName = reader.nextName();
            boolean z = true;
            switch (nextName.hashCode()) {
                case 102:
                    if (nextName.equals("f")) {
                        z = true;
                        break;
                    }
                    break;
                case 106:
                    if (nextName.equals("j")) {
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
                        z = false;
                        break;
                    }
                    break;
                case 3261:
                    if (nextName.equals("fc")) {
                        z = true;
                        break;
                    }
                    break;
                case 3452:
                    if (nextName.equals("lh")) {
                        z = true;
                        break;
                    }
                    break;
                case 3463:
                    if (nextName.equals("ls")) {
                        z = true;
                        break;
                    }
                    break;
                case 3543:
                    if (nextName.equals("of")) {
                        z = true;
                        break;
                    }
                    break;
                case 3664:
                    if (nextName.equals("sc")) {
                        z = true;
                        break;
                    }
                    break;
                case 3684:
                    if (nextName.equals("sw")) {
                        z = true;
                        break;
                    }
                    break;
                case 3710:
                    if (nextName.equals("tr")) {
                        z = true;
                        break;
                    }
                    break;
            }
            switch (z) {
                case false:
                    text = reader.nextString();
                    break;
                case true:
                    fontName = reader.nextString();
                    break;
                case true:
                    size = reader.nextDouble();
                    break;
                case true:
                    int justificationInt = reader.nextInt();
                    if (justificationInt <= DocumentData.Justification.CENTER.ordinal() && justificationInt >= 0) {
                        justification = DocumentData.Justification.values()[justificationInt];
                        break;
                    } else {
                        justification = DocumentData.Justification.CENTER;
                        break;
                    }
                    break;
                case true:
                    tracking = reader.nextInt();
                    break;
                case true:
                    lineHeight = reader.nextDouble();
                    break;
                case true:
                    baselineShift = reader.nextDouble();
                    break;
                case true:
                    fillColor = JsonUtils.jsonToColor(reader);
                    break;
                case true:
                    strokeColor = JsonUtils.jsonToColor(reader);
                    break;
                case true:
                    strokeWidth = reader.nextDouble();
                    break;
                case true:
                    strokeOverFill = reader.nextBoolean();
                    break;
                default:
                    reader.skipValue();
                    break;
            }
        }
        reader.endObject();
        new DocumentData(text, fontName, size, justification, tracking, lineHeight, baselineShift, fillColor, strokeColor, strokeWidth, strokeOverFill);
        return documentData;
    }
}
