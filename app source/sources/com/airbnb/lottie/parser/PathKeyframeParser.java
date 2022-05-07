package com.airbnb.lottie.parser;

import android.util.JsonReader;
import android.util.JsonToken;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.animation.keyframe.PathKeyframe;
import com.airbnb.lottie.utils.Utils;
import java.io.IOException;

class PathKeyframeParser {
    private PathKeyframeParser() {
    }

    static PathKeyframe parse(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        PathKeyframe pathKeyframe;
        JsonReader reader = jsonReader;
        LottieComposition composition = lottieComposition;
        new PathKeyframe(composition, KeyframeParser.parse(reader, composition, Utils.dpScale(), PathParser.INSTANCE, reader.peek() == JsonToken.BEGIN_OBJECT));
        return pathKeyframe;
    }
}
