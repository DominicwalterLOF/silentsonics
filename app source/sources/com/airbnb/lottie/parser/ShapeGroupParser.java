package com.airbnb.lottie.parser;

import android.util.JsonReader;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.content.ContentModel;
import com.airbnb.lottie.model.content.ShapeGroup;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class ShapeGroupParser {
    private ShapeGroupParser() {
    }

    static ShapeGroup parse(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        List<ContentModel> list;
        ShapeGroup shapeGroup;
        JsonReader reader = jsonReader;
        LottieComposition composition = lottieComposition;
        String name = null;
        boolean hidden = false;
        new ArrayList<>();
        List<ContentModel> items = list;
        while (reader.hasNext()) {
            String nextName = reader.nextName();
            boolean z = true;
            switch (nextName.hashCode()) {
                case 3324:
                    if (nextName.equals("hd")) {
                        z = true;
                        break;
                    }
                    break;
                case 3371:
                    if (nextName.equals("it")) {
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
                    hidden = reader.nextBoolean();
                    break;
                case true:
                    reader.beginArray();
                    while (reader.hasNext()) {
                        ContentModel newItem = ContentModelParser.parse(reader, composition);
                        if (newItem != null) {
                            boolean add = items.add(newItem);
                        }
                    }
                    reader.endArray();
                    break;
                default:
                    reader.skipValue();
                    break;
            }
        }
        new ShapeGroup(name, items, hidden);
        return shapeGroup;
    }
}
