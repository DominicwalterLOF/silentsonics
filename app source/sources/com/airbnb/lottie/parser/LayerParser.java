package com.airbnb.lottie.parser;

import android.graphics.Color;
import android.graphics.Rect;
import android.util.JsonReader;
import android.view.animation.Interpolator;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableTextFrame;
import com.airbnb.lottie.model.animatable.AnimatableTextProperties;
import com.airbnb.lottie.model.animatable.AnimatableTransform;
import com.airbnb.lottie.model.content.ContentModel;
import com.airbnb.lottie.model.content.Mask;
import com.airbnb.lottie.model.layer.Layer;
import com.airbnb.lottie.utils.Utils;
import com.airbnb.lottie.value.Keyframe;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.jose4j.jwk.RsaJsonWebKey;

public class LayerParser {
    private LayerParser() {
    }

    public static Layer parse(LottieComposition lottieComposition) {
        Layer layer;
        AnimatableTransform animatableTransform;
        LottieComposition composition = lottieComposition;
        Rect bounds = composition.getBounds();
        new AnimatableTransform();
        new Layer(Collections.emptyList(), composition, "__container", -1, Layer.LayerType.PRE_COMP, -1, (String) null, Collections.emptyList(), animatableTransform, 0, 0, 0, 0.0f, 0.0f, bounds.width(), bounds.height(), (AnimatableTextFrame) null, (AnimatableTextProperties) null, Collections.emptyList(), Layer.MatteType.NONE, (AnimatableFloatValue) null, false);
        return layer;
    }

    public static Layer parse(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        List<Mask> list;
        List<ContentModel> list2;
        List<Keyframe<Float>> list3;
        float endFrame;
        Object obj;
        Object obj2;
        Layer layer;
        Object obj3;
        List<String> list4;
        StringBuilder sb;
        JsonReader reader = jsonReader;
        LottieComposition composition = lottieComposition;
        String layerName = "UNSET";
        Layer.LayerType layerType = null;
        String refId = null;
        long layerId = 0;
        int solidWidth = 0;
        int solidHeight = 0;
        int solidColor = 0;
        int preCompWidth = 0;
        int preCompHeight = 0;
        long parentId = -1;
        float timeStretch = 1.0f;
        float startFrame = 0.0f;
        float inFrame = 0.0f;
        float outFrame = 0.0f;
        String cl = null;
        boolean hidden = false;
        Layer.MatteType matteType = Layer.MatteType.NONE;
        AnimatableTransform transform = null;
        AnimatableTextFrame text = null;
        AnimatableTextProperties textProperties = null;
        AnimatableFloatValue timeRemapping = null;
        new ArrayList<>();
        List<Mask> masks = list;
        new ArrayList<>();
        List<ContentModel> shapes = list2;
        reader.beginObject();
        while (reader.hasNext()) {
            String nextName = reader.nextName();
            boolean z = true;
            switch (nextName.hashCode()) {
                case -995424086:
                    if (nextName.equals("parent")) {
                        z = true;
                        break;
                    }
                    break;
                case -903568142:
                    if (nextName.equals("shapes")) {
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
                case 3177:
                    if (nextName.equals("cl")) {
                        z = true;
                        break;
                    }
                    break;
                case 3233:
                    if (nextName.equals("ef")) {
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
                case 3367:
                    if (nextName.equals("ip")) {
                        z = true;
                        break;
                    }
                    break;
                case 3432:
                    if (nextName.equals("ks")) {
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
                case 3553:
                    if (nextName.equals("op")) {
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
                case 3669:
                    if (nextName.equals("sh")) {
                        z = true;
                        break;
                    }
                    break;
                case 3679:
                    if (nextName.equals("sr")) {
                        z = true;
                        break;
                    }
                    break;
                case 3681:
                    if (nextName.equals("st")) {
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
                case 3705:
                    if (nextName.equals("tm")) {
                        z = true;
                        break;
                    }
                    break;
                case 3712:
                    if (nextName.equals("tt")) {
                        z = true;
                        break;
                    }
                    break;
                case 3717:
                    if (nextName.equals("ty")) {
                        z = true;
                        break;
                    }
                    break;
                case 104415:
                    if (nextName.equals("ind")) {
                        z = true;
                        break;
                    }
                    break;
                case 108390670:
                    if (nextName.equals("refId")) {
                        z = true;
                        break;
                    }
                    break;
                case 1441620890:
                    if (nextName.equals("masksProperties")) {
                        z = true;
                        break;
                    }
                    break;
            }
            switch (z) {
                case false:
                    layerName = reader.nextString();
                    break;
                case true:
                    layerId = (long) reader.nextInt();
                    break;
                case true:
                    refId = reader.nextString();
                    break;
                case true:
                    int layerTypeInt = reader.nextInt();
                    if (layerTypeInt >= Layer.LayerType.UNKNOWN.ordinal()) {
                        layerType = Layer.LayerType.UNKNOWN;
                        break;
                    } else {
                        layerType = Layer.LayerType.values()[layerTypeInt];
                        break;
                    }
                case true:
                    parentId = (long) reader.nextInt();
                    break;
                case true:
                    solidWidth = (int) (((float) reader.nextInt()) * Utils.dpScale());
                    break;
                case true:
                    solidHeight = (int) (((float) reader.nextInt()) * Utils.dpScale());
                    break;
                case true:
                    solidColor = Color.parseColor(reader.nextString());
                    break;
                case true:
                    transform = AnimatableTransformParser.parse(reader, composition);
                    break;
                case true:
                    matteType = Layer.MatteType.values()[reader.nextInt()];
                    composition.incrementMatteOrMaskCount(1);
                    break;
                case true:
                    reader.beginArray();
                    while (reader.hasNext()) {
                        boolean add = masks.add(MaskParser.parse(reader, composition));
                    }
                    composition.incrementMatteOrMaskCount(masks.size());
                    reader.endArray();
                    break;
                case true:
                    reader.beginArray();
                    while (reader.hasNext()) {
                        ContentModel shape = ContentModelParser.parse(reader, composition);
                        if (shape != null) {
                            boolean add2 = shapes.add(shape);
                        }
                    }
                    reader.endArray();
                    break;
                case true:
                    reader.beginObject();
                    while (reader.hasNext()) {
                        String nextName2 = reader.nextName();
                        boolean z2 = true;
                        switch (nextName2.hashCode()) {
                            case 97:
                                if (nextName2.equals("a")) {
                                    z2 = true;
                                    break;
                                }
                                break;
                            case 100:
                                if (nextName2.equals("d")) {
                                    z2 = false;
                                    break;
                                }
                                break;
                        }
                        switch (z2) {
                            case false:
                                text = AnimatableValueParser.parseDocumentData(reader, composition);
                                break;
                            case true:
                                reader.beginArray();
                                if (reader.hasNext()) {
                                    textProperties = AnimatableTextPropertiesParser.parse(reader, composition);
                                }
                                while (reader.hasNext()) {
                                    reader.skipValue();
                                }
                                reader.endArray();
                                break;
                            default:
                                reader.skipValue();
                                break;
                        }
                    }
                    reader.endObject();
                    break;
                case true:
                    reader.beginArray();
                    new ArrayList<>();
                    List<String> effectNames = list4;
                    while (reader.hasNext()) {
                        reader.beginObject();
                        while (reader.hasNext()) {
                            String nextName3 = reader.nextName();
                            boolean z3 = true;
                            switch (nextName3.hashCode()) {
                                case 3519:
                                    if (nextName3.equals("nm")) {
                                        z3 = false;
                                        break;
                                    }
                                    break;
                            }
                            switch (z3) {
                                case false:
                                    boolean add3 = effectNames.add(reader.nextString());
                                    break;
                                default:
                                    reader.skipValue();
                                    break;
                            }
                        }
                        reader.endObject();
                    }
                    reader.endArray();
                    new StringBuilder();
                    composition.addWarning(sb.append("Lottie doesn't support layer effects. If you are using them for  fills, strokes, trim paths etc. then try adding them directly as contents  in your shape. Found: ").append(effectNames).toString());
                    break;
                case true:
                    timeStretch = (float) reader.nextDouble();
                    break;
                case true:
                    startFrame = (float) reader.nextDouble();
                    break;
                case true:
                    preCompWidth = (int) (((float) reader.nextInt()) * Utils.dpScale());
                    break;
                case true:
                    preCompHeight = (int) (((float) reader.nextInt()) * Utils.dpScale());
                    break;
                case true:
                    inFrame = (float) reader.nextDouble();
                    break;
                case true:
                    outFrame = (float) reader.nextDouble();
                    break;
                case true:
                    timeRemapping = AnimatableValueParser.parseFloat(reader, composition, false);
                    break;
                case true:
                    cl = reader.nextString();
                    break;
                case true:
                    hidden = reader.nextBoolean();
                    break;
                default:
                    reader.skipValue();
                    break;
            }
        }
        reader.endObject();
        float inFrame2 = inFrame / timeStretch;
        float outFrame2 = outFrame / timeStretch;
        new ArrayList<>();
        List<Keyframe<Float>> inOutKeyframes = list3;
        if (inFrame2 > 0.0f) {
            new Keyframe(composition, Float.valueOf(0.0f), Float.valueOf(0.0f), (Interpolator) null, 0.0f, Float.valueOf(inFrame2));
            boolean add4 = inOutKeyframes.add(obj3);
        }
        if (outFrame2 > 0.0f) {
            endFrame = outFrame2;
        } else {
            endFrame = composition.getEndFrame();
        }
        float outFrame3 = endFrame;
        new Keyframe(composition, Float.valueOf(1.0f), Float.valueOf(1.0f), (Interpolator) null, inFrame2, Float.valueOf(outFrame3));
        boolean add5 = inOutKeyframes.add(obj);
        new Keyframe(composition, Float.valueOf(0.0f), Float.valueOf(0.0f), (Interpolator) null, outFrame3, Float.valueOf(Float.MAX_VALUE));
        boolean add6 = inOutKeyframes.add(obj2);
        if (layerName.endsWith(".ai") || "ai".equals(cl)) {
            composition.addWarning("Convert your Illustrator layers to shape layers.");
        }
        new Layer(shapes, composition, layerName, layerId, layerType, parentId, refId, masks, transform, solidWidth, solidHeight, solidColor, timeStretch, startFrame, preCompWidth, preCompHeight, text, textProperties, inOutKeyframes, matteType, timeRemapping, hidden);
        return layer;
    }
}
