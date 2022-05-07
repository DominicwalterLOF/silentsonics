package com.airbnb.lottie.parser;

import android.graphics.PointF;
import android.util.JsonReader;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import androidx.annotation.Nullable;
import androidx.collection.SparseArrayCompat;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.utils.Utils;
import com.airbnb.lottie.value.Keyframe;
import java.io.IOException;
import java.lang.ref.WeakReference;
import org.jose4j.jwk.RsaJsonWebKey;

class KeyframeParser {
    private static final Interpolator LINEAR_INTERPOLATOR;
    private static final float MAX_CP_VALUE = 100.0f;
    private static SparseArrayCompat<WeakReference<Interpolator>> pathInterpolatorCache;

    KeyframeParser() {
    }

    static {
        Interpolator interpolator;
        new LinearInterpolator();
        LINEAR_INTERPOLATOR = interpolator;
    }

    private static SparseArrayCompat<WeakReference<Interpolator>> pathInterpolatorCache() {
        SparseArrayCompat<WeakReference<Interpolator>> sparseArrayCompat;
        if (pathInterpolatorCache == null) {
            new SparseArrayCompat<>();
            pathInterpolatorCache = sparseArrayCompat;
        }
        return pathInterpolatorCache;
    }

    @Nullable
    private static WeakReference<Interpolator> getInterpolator(int i) {
        int hash = i;
        Class<KeyframeParser> cls = KeyframeParser.class;
        Class<KeyframeParser> cls2 = cls;
        synchronized (cls) {
            try {
                WeakReference<Interpolator> weakReference = pathInterpolatorCache().get(hash);
                return weakReference;
            } catch (Throwable th) {
                Throwable th2 = th;
                Class<KeyframeParser> cls3 = cls2;
                throw th2;
            }
        }
    }

    /* JADX INFO: finally extract failed */
    private static void putInterpolator(int i, WeakReference<Interpolator> weakReference) {
        int hash = i;
        WeakReference<Interpolator> interpolator = weakReference;
        Class<KeyframeParser> cls = KeyframeParser.class;
        Class<KeyframeParser> cls2 = cls;
        synchronized (cls) {
            try {
                pathInterpolatorCache.put(hash, interpolator);
            } catch (Throwable th) {
                Throwable th2 = th;
                Class<KeyframeParser> cls3 = cls2;
                throw th2;
            }
        }
    }

    static <T> Keyframe<T> parse(JsonReader jsonReader, LottieComposition lottieComposition, float f, ValueParser<T> valueParser, boolean animated) throws IOException {
        JsonReader reader = jsonReader;
        LottieComposition composition = lottieComposition;
        float scale = f;
        ValueParser<T> valueParser2 = valueParser;
        if (animated) {
            return parseKeyframe(composition, reader, scale, valueParser2);
        }
        return parseStaticValue(reader, scale, valueParser2);
    }

    private static <T> Keyframe<T> parseKeyframe(LottieComposition lottieComposition, JsonReader jsonReader, float f, ValueParser<T> valueParser) throws IOException {
        WeakReference weakReference;
        Keyframe keyframe;
        LottieComposition composition = lottieComposition;
        JsonReader reader = jsonReader;
        float scale = f;
        ValueParser<T> valueParser2 = valueParser;
        PointF cp1 = null;
        PointF cp2 = null;
        float startFrame = 0.0f;
        T startValue = null;
        T endValue = null;
        boolean hold = false;
        Interpolator interpolator = null;
        PointF pathCp1 = null;
        PointF pathCp2 = null;
        reader.beginObject();
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
                case 104:
                    if (nextName.equals("h")) {
                        z = true;
                        break;
                    }
                    break;
                case 105:
                    if (nextName.equals("i")) {
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
                case 3701:
                    if (nextName.equals("ti")) {
                        z = true;
                        break;
                    }
                    break;
                case 3707:
                    if (nextName.equals("to")) {
                        z = true;
                        break;
                    }
                    break;
            }
            switch (z) {
                case false:
                    startFrame = (float) reader.nextDouble();
                    break;
                case true:
                    startValue = valueParser2.parse(reader, scale);
                    break;
                case true:
                    endValue = valueParser2.parse(reader, scale);
                    break;
                case true:
                    cp1 = JsonUtils.jsonToPoint(reader, scale);
                    break;
                case true:
                    cp2 = JsonUtils.jsonToPoint(reader, scale);
                    break;
                case true:
                    hold = reader.nextInt() == 1;
                    break;
                case true:
                    pathCp1 = JsonUtils.jsonToPoint(reader, scale);
                    break;
                case true:
                    pathCp2 = JsonUtils.jsonToPoint(reader, scale);
                    break;
                default:
                    reader.skipValue();
                    break;
            }
        }
        reader.endObject();
        if (hold) {
            endValue = startValue;
            interpolator = LINEAR_INTERPOLATOR;
        } else if (cp1 == null || cp2 == null) {
            interpolator = LINEAR_INTERPOLATOR;
        } else {
            cp1.x = MiscUtils.clamp(cp1.x, -scale, scale);
            cp1.y = MiscUtils.clamp(cp1.y, -100.0f, (float) MAX_CP_VALUE);
            cp2.x = MiscUtils.clamp(cp2.x, -scale, scale);
            cp2.y = MiscUtils.clamp(cp2.y, -100.0f, (float) MAX_CP_VALUE);
            int hash = Utils.hashFor(cp1.x, cp1.y, cp2.x, cp2.y);
            WeakReference<Interpolator> interpolatorRef = getInterpolator(hash);
            if (interpolatorRef != null) {
                interpolator = (Interpolator) interpolatorRef.get();
            }
            if (interpolatorRef == null || interpolator == null) {
                interpolator = PathInterpolatorCompat.create(cp1.x / scale, cp1.y / scale, cp2.x / scale, cp2.y / scale);
                int i = hash;
                try {
                    new WeakReference(interpolator);
                    putInterpolator(i, weakReference);
                } catch (ArrayIndexOutOfBoundsException e) {
                    ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException = e;
                }
            }
        }
        new Keyframe(composition, startValue, endValue, interpolator, startFrame, (Float) null);
        Keyframe keyframe2 = keyframe;
        keyframe2.pathCp1 = pathCp1;
        keyframe2.pathCp2 = pathCp2;
        return keyframe2;
    }

    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static <T> com.airbnb.lottie.value.Keyframe<T> parseStaticValue(android.util.JsonReader r8, float r9, com.airbnb.lottie.parser.ValueParser<T> r10) throws java.io.IOException {
        /*
            r0 = r8
            r1 = r9
            r2 = r10
            r4 = r2
            r5 = r0
            r6 = r1
            java.lang.Object r4 = r4.parse(r5, r6)
            r3 = r4
            com.airbnb.lottie.value.Keyframe r4 = new com.airbnb.lottie.value.Keyframe
            r7 = r4
            r4 = r7
            r5 = r7
            r6 = r3
            r5.<init>(r6)
            r0 = r4
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.parser.KeyframeParser.parseStaticValue(android.util.JsonReader, float, com.airbnb.lottie.parser.ValueParser):com.airbnb.lottie.value.Keyframe");
    }
}
