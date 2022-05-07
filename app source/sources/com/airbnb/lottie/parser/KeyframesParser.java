package com.airbnb.lottie.parser;

import android.util.JsonReader;
import android.util.JsonToken;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.animation.keyframe.PathKeyframe;
import com.airbnb.lottie.value.Keyframe;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.jose4j.jwk.OctetSequenceJsonWebKey;

class KeyframesParser {
    private KeyframesParser() {
    }

    static <T> List<Keyframe<T>> parse(JsonReader jsonReader, LottieComposition lottieComposition, float f, ValueParser<T> valueParser) throws IOException {
        List<Keyframe<T>> list;
        JsonReader reader = jsonReader;
        LottieComposition composition = lottieComposition;
        float scale = f;
        ValueParser<T> valueParser2 = valueParser;
        new ArrayList();
        List<Keyframe<T>> keyframes = list;
        if (reader.peek() == JsonToken.STRING) {
            composition.addWarning("Lottie doesn't support expressions.");
            return keyframes;
        }
        reader.beginObject();
        while (reader.hasNext()) {
            String nextName = reader.nextName();
            boolean z = true;
            switch (nextName.hashCode()) {
                case 107:
                    if (nextName.equals(OctetSequenceJsonWebKey.KEY_VALUE_MEMBER_NAME)) {
                        z = false;
                        break;
                    }
                    break;
            }
            switch (z) {
                case false:
                    if (reader.peek() != JsonToken.BEGIN_ARRAY) {
                        boolean add = keyframes.add(KeyframeParser.parse(reader, composition, scale, valueParser2, false));
                        break;
                    } else {
                        reader.beginArray();
                        if (reader.peek() == JsonToken.NUMBER) {
                            boolean add2 = keyframes.add(KeyframeParser.parse(reader, composition, scale, valueParser2, false));
                        } else {
                            while (reader.hasNext()) {
                                boolean add3 = keyframes.add(KeyframeParser.parse(reader, composition, scale, valueParser2, true));
                            }
                        }
                        reader.endArray();
                        break;
                    }
                default:
                    reader.skipValue();
                    break;
            }
        }
        reader.endObject();
        setEndFrames(keyframes);
        return keyframes;
    }

    public static <T> void setEndFrames(List<? extends Keyframe<T>> list) {
        List<? extends Keyframe<T>> keyframes = list;
        int size = keyframes.size();
        for (int i = 0; i < size - 1; i++) {
            Keyframe<T> keyframe = (Keyframe) keyframes.get(i);
            Keyframe<T> nextKeyframe = (Keyframe) keyframes.get(i + 1);
            keyframe.endFrame = Float.valueOf(nextKeyframe.startFrame);
            if (keyframe.endValue == null && nextKeyframe.startValue != null) {
                keyframe.endValue = nextKeyframe.startValue;
                if (keyframe instanceof PathKeyframe) {
                    ((PathKeyframe) keyframe).createPath();
                }
            }
        }
        Keyframe<?> lastKeyframe = (Keyframe) keyframes.get(size - 1);
        if ((lastKeyframe.startValue == null || lastKeyframe.endValue == null) && keyframes.size() > 1) {
            boolean remove = keyframes.remove(lastKeyframe);
        }
    }
}
