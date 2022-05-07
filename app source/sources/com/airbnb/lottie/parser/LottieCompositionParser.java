package com.airbnb.lottie.parser;

import android.graphics.Rect;
import android.util.JsonReader;
import androidx.collection.LongSparseArray;
import androidx.collection.SparseArrayCompat;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieImageAsset;
import com.airbnb.lottie.model.Font;
import com.airbnb.lottie.model.FontCharacter;
import com.airbnb.lottie.model.Marker;
import com.airbnb.lottie.model.layer.Layer;
import com.airbnb.lottie.utils.Logger;
import com.airbnb.lottie.utils.Utils;
import com.google.appinventor.components.common.ComponentDescriptorConstants;
import com.microsoft.appcenter.ingestion.models.CommonProperties;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.jose4j.jwk.RsaJsonWebKey;

public class LottieCompositionParser {
    private LottieCompositionParser() {
    }

    public static LottieComposition parse(JsonReader jsonReader) throws IOException {
        LongSparseArray longSparseArray;
        List<Layer> list;
        Map<String, List<Layer>> map;
        Map<String, LottieImageAsset> map2;
        Map<String, Font> map3;
        List<Marker> list2;
        SparseArrayCompat sparseArrayCompat;
        LottieComposition lottieComposition;
        Rect bounds;
        JsonReader reader = jsonReader;
        float scale = Utils.dpScale();
        float startFrame = 0.0f;
        float endFrame = 0.0f;
        float frameRate = 0.0f;
        new LongSparseArray();
        LongSparseArray longSparseArray2 = longSparseArray;
        new ArrayList<>();
        List<Layer> layers = list;
        int width = 0;
        int height = 0;
        new HashMap<>();
        Map<String, List<Layer>> precomps = map;
        new HashMap<>();
        Map<String, LottieImageAsset> images = map2;
        new HashMap<>();
        Map<String, Font> fonts = map3;
        new ArrayList<>();
        List<Marker> markers = list2;
        new SparseArrayCompat();
        SparseArrayCompat sparseArrayCompat2 = sparseArrayCompat;
        new LottieComposition();
        LottieComposition composition = lottieComposition;
        reader.beginObject();
        while (reader.hasNext()) {
            String nextName = reader.nextName();
            boolean z = true;
            switch (nextName.hashCode()) {
                case -1408207997:
                    if (nextName.equals(ComponentDescriptorConstants.ASSETS_TARGET)) {
                        z = true;
                        break;
                    }
                    break;
                case -1109732030:
                    if (nextName.equals("layers")) {
                        z = true;
                        break;
                    }
                    break;
                case 104:
                    if (nextName.equals("h")) {
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
                case 119:
                    if (nextName.equals("w")) {
                        z = false;
                        break;
                    }
                    break;
                case 3276:
                    if (nextName.equals("fr")) {
                        z = true;
                        break;
                    }
                    break;
                case 3367:
                    if (nextName.equals("ip")) {
                        z = true;
                        break;
                    }
                    break;
                case 3553:
                    if (nextName.equals("op")) {
                        z = true;
                        break;
                    }
                    break;
                case 94623709:
                    if (nextName.equals("chars")) {
                        z = true;
                        break;
                    }
                    break;
                case 97615364:
                    if (nextName.equals("fonts")) {
                        z = true;
                        break;
                    }
                    break;
                case 839250809:
                    if (nextName.equals("markers")) {
                        z = true;
                        break;
                    }
                    break;
            }
            switch (z) {
                case false:
                    width = reader.nextInt();
                    break;
                case true:
                    height = reader.nextInt();
                    break;
                case true:
                    startFrame = (float) reader.nextDouble();
                    break;
                case true:
                    endFrame = ((float) reader.nextDouble()) - 0.01f;
                    break;
                case true:
                    frameRate = (float) reader.nextDouble();
                    break;
                case true:
                    String[] versions = reader.nextString().split("\\.");
                    if (Utils.isAtLeastVersion(Integer.parseInt(versions[0]), Integer.parseInt(versions[1]), Integer.parseInt(versions[2]), 4, 4, 0)) {
                        break;
                    } else {
                        composition.addWarning("Lottie only supports bodymovin >= 4.4.0");
                        break;
                    }
                case true:
                    parseLayers(reader, composition, layers, longSparseArray2);
                    break;
                case true:
                    parseAssets(reader, composition, precomps, images);
                    break;
                case true:
                    parseFonts(reader, fonts);
                    break;
                case true:
                    parseChars(reader, composition, sparseArrayCompat2);
                    break;
                case true:
                    parseMarkers(reader, composition, markers);
                    break;
                default:
                    reader.skipValue();
                    break;
            }
        }
        reader.endObject();
        new Rect(0, 0, (int) (((float) width) * scale), (int) (((float) height) * scale));
        composition.init(bounds, startFrame, endFrame, frameRate, layers, longSparseArray2, precomps, images, sparseArrayCompat2, fonts, markers);
        return composition;
    }

    private static void parseLayers(JsonReader jsonReader, LottieComposition lottieComposition, List<Layer> list, LongSparseArray<Layer> longSparseArray) throws IOException {
        StringBuilder sb;
        JsonReader reader = jsonReader;
        LottieComposition composition = lottieComposition;
        List<Layer> layers = list;
        LongSparseArray<Layer> layerMap = longSparseArray;
        int imageCount = 0;
        reader.beginArray();
        while (reader.hasNext()) {
            Layer layer = LayerParser.parse(reader, composition);
            if (layer.getLayerType() == Layer.LayerType.IMAGE) {
                imageCount++;
            }
            boolean add = layers.add(layer);
            layerMap.put(layer.getId(), layer);
            if (imageCount > 4) {
                new StringBuilder();
                Logger.warning(sb.append("You have ").append(imageCount).append(" images. Lottie should primarily be used with shapes. If you are using Adobe Illustrator, convert the Illustrator layers to shape layers.").toString());
            }
        }
        reader.endArray();
    }

    private static void parseAssets(JsonReader jsonReader, LottieComposition lottieComposition, Map<String, List<Layer>> map, Map<String, LottieImageAsset> map2) throws IOException {
        List<Layer> list;
        LongSparseArray longSparseArray;
        LottieImageAsset lottieImageAsset;
        JsonReader reader = jsonReader;
        LottieComposition composition = lottieComposition;
        Map<String, List<Layer>> precomps = map;
        Map<String, LottieImageAsset> images = map2;
        reader.beginArray();
        while (reader.hasNext()) {
            String id = null;
            new ArrayList<>();
            List<Layer> layers = list;
            new LongSparseArray();
            LongSparseArray longSparseArray2 = longSparseArray;
            int width = 0;
            int height = 0;
            String imageFileName = null;
            String relativeFolder = null;
            reader.beginObject();
            while (reader.hasNext()) {
                String nextName = reader.nextName();
                boolean z = true;
                switch (nextName.hashCode()) {
                    case -1109732030:
                        if (nextName.equals("layers")) {
                            z = true;
                            break;
                        }
                        break;
                    case 104:
                        if (nextName.equals("h")) {
                            z = true;
                            break;
                        }
                        break;
                    case 112:
                        if (nextName.equals(RsaJsonWebKey.FIRST_PRIME_FACTOR_MEMBER_NAME)) {
                            z = true;
                            break;
                        }
                        break;
                    case 117:
                        if (nextName.equals("u")) {
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
                    case 3355:
                        if (nextName.equals(CommonProperties.ID)) {
                            z = false;
                            break;
                        }
                        break;
                }
                switch (z) {
                    case false:
                        id = reader.nextString();
                        break;
                    case true:
                        reader.beginArray();
                        while (reader.hasNext()) {
                            Layer layer = LayerParser.parse(reader, composition);
                            longSparseArray2.put(layer.getId(), layer);
                            boolean add = layers.add(layer);
                        }
                        reader.endArray();
                        break;
                    case true:
                        width = reader.nextInt();
                        break;
                    case true:
                        height = reader.nextInt();
                        break;
                    case true:
                        imageFileName = reader.nextString();
                        break;
                    case true:
                        relativeFolder = reader.nextString();
                        break;
                    default:
                        reader.skipValue();
                        break;
                }
            }
            reader.endObject();
            if (imageFileName != null) {
                new LottieImageAsset(width, height, id, imageFileName, relativeFolder);
                LottieImageAsset image = lottieImageAsset;
                LottieImageAsset put = images.put(image.getId(), image);
            } else {
                List<Layer> put2 = precomps.put(id, layers);
            }
        }
        reader.endArray();
    }

    private static void parseFonts(JsonReader jsonReader, Map<String, Font> map) throws IOException {
        JsonReader reader = jsonReader;
        Map<String, Font> fonts = map;
        reader.beginObject();
        while (reader.hasNext()) {
            String nextName = reader.nextName();
            boolean z = true;
            switch (nextName.hashCode()) {
                case 3322014:
                    if (nextName.equals("list")) {
                        z = false;
                        break;
                    }
                    break;
            }
            switch (z) {
                case false:
                    reader.beginArray();
                    while (reader.hasNext()) {
                        Font font = FontParser.parse(reader);
                        Font put = fonts.put(font.getName(), font);
                    }
                    reader.endArray();
                    break;
                default:
                    reader.skipValue();
                    break;
            }
        }
        reader.endObject();
    }

    private static void parseChars(JsonReader jsonReader, LottieComposition lottieComposition, SparseArrayCompat<FontCharacter> sparseArrayCompat) throws IOException {
        JsonReader reader = jsonReader;
        LottieComposition composition = lottieComposition;
        SparseArrayCompat<FontCharacter> characters = sparseArrayCompat;
        reader.beginArray();
        while (reader.hasNext()) {
            FontCharacter character = FontCharacterParser.parse(reader, composition);
            characters.put(character.hashCode(), character);
        }
        reader.endArray();
    }

    private static void parseMarkers(JsonReader jsonReader, LottieComposition lottieComposition, List<Marker> list) throws IOException {
        Object obj;
        JsonReader reader = jsonReader;
        LottieComposition lottieComposition2 = lottieComposition;
        List<Marker> markers = list;
        reader.beginArray();
        while (reader.hasNext()) {
            String comment = null;
            float frame = 0.0f;
            float durationFrames = 0.0f;
            reader.beginObject();
            while (reader.hasNext()) {
                String nextName = reader.nextName();
                boolean z = true;
                switch (nextName.hashCode()) {
                    case 3178:
                        if (nextName.equals("cm")) {
                            z = false;
                            break;
                        }
                        break;
                    case 3214:
                        if (nextName.equals("dr")) {
                            z = true;
                            break;
                        }
                        break;
                    case 3705:
                        if (nextName.equals("tm")) {
                            z = true;
                            break;
                        }
                        break;
                }
                switch (z) {
                    case false:
                        comment = reader.nextString();
                        break;
                    case true:
                        frame = (float) reader.nextDouble();
                        break;
                    case true:
                        durationFrames = (float) reader.nextDouble();
                        break;
                    default:
                        reader.skipValue();
                        break;
                }
            }
            reader.endObject();
            new Marker(comment, frame, durationFrames);
            boolean add = markers.add(obj);
        }
        reader.endArray();
    }
}
