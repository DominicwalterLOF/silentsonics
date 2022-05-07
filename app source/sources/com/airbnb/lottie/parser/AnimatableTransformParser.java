package com.airbnb.lottie.parser;

import android.graphics.PointF;
import android.util.JsonReader;
import android.util.JsonToken;
import android.view.animation.Interpolator;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableIntegerValue;
import com.airbnb.lottie.model.animatable.AnimatablePathValue;
import com.airbnb.lottie.model.animatable.AnimatableScaleValue;
import com.airbnb.lottie.model.animatable.AnimatableSplitDimensionPathValue;
import com.airbnb.lottie.model.animatable.AnimatableTransform;
import com.airbnb.lottie.model.animatable.AnimatableValue;
import com.airbnb.lottie.value.Keyframe;
import com.airbnb.lottie.value.ScaleXY;
import java.io.IOException;
import org.jose4j.jwk.OctetSequenceJsonWebKey;
import org.jose4j.jwk.RsaJsonWebKey;

public class AnimatableTransformParser {
    private AnimatableTransformParser() {
    }

    public static AnimatableTransform parse(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        AnimatableTransform animatableTransform;
        Object obj;
        Object obj2;
        JsonReader reader = jsonReader;
        LottieComposition composition = lottieComposition;
        AnimatablePathValue anchorPoint = null;
        AnimatableValue<PointF, PointF> position = null;
        AnimatableScaleValue scale = null;
        AnimatableFloatValue rotation = null;
        AnimatableIntegerValue opacity = null;
        AnimatableFloatValue startOpacity = null;
        AnimatableFloatValue endOpacity = null;
        AnimatableFloatValue skew = null;
        AnimatableFloatValue skewAngle = null;
        boolean isObject = reader.peek() == JsonToken.BEGIN_OBJECT;
        if (isObject) {
            reader.beginObject();
        }
        while (reader.hasNext()) {
            String nextName = reader.nextName();
            boolean z = true;
            switch (nextName.hashCode()) {
                case 97:
                    if (nextName.equals("a")) {
                        z = false;
                        break;
                    }
                    break;
                case 111:
                    if (nextName.equals("o")) {
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
                case 3242:
                    if (nextName.equals("eo")) {
                        z = true;
                        break;
                    }
                    break;
                case 3656:
                    if (nextName.equals("rz")) {
                        z = true;
                        break;
                    }
                    break;
                case 3662:
                    if (nextName.equals("sa")) {
                        z = true;
                        break;
                    }
                    break;
                case 3672:
                    if (nextName.equals("sk")) {
                        z = true;
                        break;
                    }
                    break;
                case 3676:
                    if (nextName.equals("so")) {
                        z = true;
                        break;
                    }
                    break;
            }
            switch (z) {
                case false:
                    reader.beginObject();
                    while (reader.hasNext()) {
                        if (reader.nextName().equals(OctetSequenceJsonWebKey.KEY_VALUE_MEMBER_NAME)) {
                            anchorPoint = AnimatablePathValueParser.parse(reader, composition);
                        } else {
                            reader.skipValue();
                        }
                    }
                    reader.endObject();
                    continue;
                case true:
                    position = AnimatablePathValueParser.parseSplitPath(reader, composition);
                    continue;
                case true:
                    scale = AnimatableValueParser.parseScale(reader, composition);
                    continue;
                case true:
                    composition.addWarning("Lottie doesn't support 3D layers.");
                    break;
                case true:
                    break;
                case true:
                    opacity = AnimatableValueParser.parseInteger(reader, composition);
                    continue;
                case true:
                    startOpacity = AnimatableValueParser.parseFloat(reader, composition, false);
                    continue;
                case true:
                    endOpacity = AnimatableValueParser.parseFloat(reader, composition, false);
                    continue;
                case true:
                    skew = AnimatableValueParser.parseFloat(reader, composition, false);
                    continue;
                case true:
                    skewAngle = AnimatableValueParser.parseFloat(reader, composition, false);
                    continue;
                default:
                    reader.skipValue();
                    continue;
            }
            rotation = AnimatableValueParser.parseFloat(reader, composition, false);
            if (rotation.getKeyframes().isEmpty()) {
                new Keyframe(composition, Float.valueOf(0.0f), Float.valueOf(0.0f), (Interpolator) null, 0.0f, Float.valueOf(composition.getEndFrame()));
                boolean add = rotation.getKeyframes().add(obj2);
            } else if (((Keyframe) rotation.getKeyframes().get(0)).startValue == null) {
                new Keyframe(composition, Float.valueOf(0.0f), Float.valueOf(0.0f), (Interpolator) null, 0.0f, Float.valueOf(composition.getEndFrame()));
                Object obj3 = rotation.getKeyframes().set(0, obj);
            }
        }
        if (isObject) {
            reader.endObject();
        }
        if (isAnchorPointIdentity(anchorPoint)) {
            anchorPoint = null;
        }
        if (isPositionIdentity(position)) {
            position = null;
        }
        if (isRotationIdentity(rotation)) {
            rotation = null;
        }
        if (isScaleIdentity(scale)) {
            scale = null;
        }
        if (isSkewIdentity(skew)) {
            skew = null;
        }
        if (isSkewAngleIdentity(skewAngle)) {
            skewAngle = null;
        }
        new AnimatableTransform(anchorPoint, position, scale, rotation, opacity, startOpacity, endOpacity, skew, skewAngle);
        return animatableTransform;
    }

    private static boolean isAnchorPointIdentity(AnimatablePathValue animatablePathValue) {
        AnimatablePathValue anchorPoint = animatablePathValue;
        return anchorPoint == null || (anchorPoint.isStatic() && ((PointF) anchorPoint.getKeyframes().get(0).startValue).equals(0.0f, 0.0f));
    }

    private static boolean isPositionIdentity(AnimatableValue<PointF, PointF> animatableValue) {
        AnimatableValue<PointF, PointF> position = animatableValue;
        return position == null || (!(position instanceof AnimatableSplitDimensionPathValue) && position.isStatic() && ((PointF) position.getKeyframes().get(0).startValue).equals(0.0f, 0.0f));
    }

    private static boolean isRotationIdentity(AnimatableFloatValue animatableFloatValue) {
        AnimatableFloatValue rotation = animatableFloatValue;
        return rotation == null || (rotation.isStatic() && ((Float) ((Keyframe) rotation.getKeyframes().get(0)).startValue).floatValue() == 0.0f);
    }

    private static boolean isScaleIdentity(AnimatableScaleValue animatableScaleValue) {
        AnimatableScaleValue scale = animatableScaleValue;
        return scale == null || (scale.isStatic() && ((ScaleXY) ((Keyframe) scale.getKeyframes().get(0)).startValue).equals(1.0f, 1.0f));
    }

    private static boolean isSkewIdentity(AnimatableFloatValue animatableFloatValue) {
        AnimatableFloatValue skew = animatableFloatValue;
        return skew == null || (skew.isStatic() && ((Float) ((Keyframe) skew.getKeyframes().get(0)).startValue).floatValue() == 0.0f);
    }

    private static boolean isSkewAngleIdentity(AnimatableFloatValue animatableFloatValue) {
        AnimatableFloatValue skewAngle = animatableFloatValue;
        return skewAngle == null || (skewAngle.isStatic() && ((Float) ((Keyframe) skewAngle.getKeyframes().get(0)).startValue).floatValue() == 0.0f);
    }
}
