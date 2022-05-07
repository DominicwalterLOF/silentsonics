package com.airbnb.lottie;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.JsonReader;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.WorkerThread;
import androidx.collection.LongSparseArray;
import androidx.collection.SparseArrayCompat;
import com.airbnb.lottie.model.Font;
import com.airbnb.lottie.model.FontCharacter;
import com.airbnb.lottie.model.Marker;
import com.airbnb.lottie.model.layer.Layer;
import com.airbnb.lottie.utils.Logger;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public class LottieComposition {
    private Rect bounds;
    private SparseArrayCompat<FontCharacter> characters;
    private float endFrame;
    private Map<String, Font> fonts;
    private float frameRate;
    private boolean hasDashPattern;
    private Map<String, LottieImageAsset> images;
    private LongSparseArray<Layer> layerMap;
    private List<Layer> layers;
    private List<Marker> markers;
    private int maskAndMatteCount = 0;
    private final PerformanceTracker performanceTracker;
    private Map<String, List<Layer>> precomps;
    private float startFrame;
    private final HashSet<String> warnings;

    public LottieComposition() {
        PerformanceTracker performanceTracker2;
        HashSet<String> hashSet;
        new PerformanceTracker();
        this.performanceTracker = performanceTracker2;
        new HashSet<>();
        this.warnings = hashSet;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void init(Rect bounds2, float startFrame2, float endFrame2, float frameRate2, List<Layer> layers2, LongSparseArray<Layer> layerMap2, Map<String, List<Layer>> precomps2, Map<String, LottieImageAsset> images2, SparseArrayCompat<FontCharacter> characters2, Map<String, Font> fonts2, List<Marker> markers2) {
        this.bounds = bounds2;
        this.startFrame = startFrame2;
        this.endFrame = endFrame2;
        this.frameRate = frameRate2;
        this.layers = layers2;
        this.layerMap = layerMap2;
        this.precomps = precomps2;
        this.images = images2;
        this.characters = characters2;
        this.fonts = fonts2;
        this.markers = markers2;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void addWarning(String str) {
        String warning = str;
        Logger.warning(warning);
        boolean add = this.warnings.add(warning);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void setHasDashPattern(boolean hasDashPattern2) {
        boolean z = hasDashPattern2;
        this.hasDashPattern = z;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void incrementMatteOrMaskCount(int amount) {
        this.maskAndMatteCount += amount;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean hasDashPattern() {
        return this.hasDashPattern;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public int getMaskAndMatteCount() {
        return this.maskAndMatteCount;
    }

    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.ArrayList<java.lang.String> getWarnings() {
        /*
            r6 = this;
            r0 = r6
            java.util.ArrayList r1 = new java.util.ArrayList
            r5 = r1
            r1 = r5
            r2 = r5
            r3 = r0
            java.util.HashSet<java.lang.String> r3 = r3.warnings
            r4 = r0
            java.util.HashSet<java.lang.String> r4 = r4.warnings
            int r4 = r4.size()
            java.lang.String[] r4 = new java.lang.String[r4]
            java.lang.Object[] r3 = r3.toArray(r4)
            java.util.List r3 = java.util.Arrays.asList(r3)
            r2.<init>(r3)
            r0 = r1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.LottieComposition.getWarnings():java.util.ArrayList");
    }

    public void setPerformanceTrackingEnabled(boolean enabled) {
        this.performanceTracker.setEnabled(enabled);
    }

    public PerformanceTracker getPerformanceTracker() {
        return this.performanceTracker;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public Layer layerModelForId(long id) {
        return this.layerMap.get(id);
    }

    public Rect getBounds() {
        return this.bounds;
    }

    public float getDuration() {
        return (float) ((long) ((getDurationFrames() / this.frameRate) * 1000.0f));
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public float getStartFrame() {
        return this.startFrame;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public float getEndFrame() {
        return this.endFrame;
    }

    public float getFrameRate() {
        return this.frameRate;
    }

    public List<Layer> getLayers() {
        return this.layers;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public List<Layer> getPrecomps(String id) {
        return this.precomps.get(id);
    }

    public SparseArrayCompat<FontCharacter> getCharacters() {
        return this.characters;
    }

    public Map<String, Font> getFonts() {
        return this.fonts;
    }

    public List<Marker> getMarkers() {
        return this.markers;
    }

    @Nullable
    public Marker getMarker(String str) {
        String markerName = str;
        int size = this.markers.size();
        for (int i = 0; i < this.markers.size(); i++) {
            Marker marker = this.markers.get(i);
            if (marker.matchesName(markerName)) {
                return marker;
            }
        }
        return null;
    }

    public boolean hasImages() {
        return !this.images.isEmpty();
    }

    public Map<String, LottieImageAsset> getImages() {
        return this.images;
    }

    public float getDurationFrames() {
        return this.endFrame - this.startFrame;
    }

    public String toString() {
        StringBuilder sb;
        new StringBuilder("LottieComposition:\n");
        StringBuilder sb2 = sb;
        for (Layer layer : this.layers) {
            StringBuilder append = sb2.append(layer.toString("\t"));
        }
        return sb2.toString();
    }

    @Deprecated
    public static class Factory {
        private Factory() {
        }

        /* JADX WARNING: type inference failed for: r0v1, types: [com.airbnb.lottie.Cancellable] */
        /* JADX WARNING: Multi-variable type inference failed */
        @java.lang.Deprecated
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static com.airbnb.lottie.Cancellable fromAssetFileName(android.content.Context r9, java.lang.String r10, com.airbnb.lottie.OnCompositionLoadedListener r11) {
            /*
                r0 = r9
                r1 = r10
                r2 = r11
                com.airbnb.lottie.LottieComposition$Factory$ListenerAdapter r4 = new com.airbnb.lottie.LottieComposition$Factory$ListenerAdapter
                r8 = r4
                r4 = r8
                r5 = r8
                r6 = r2
                r7 = 0
                r5.<init>(r6, r7)
                r3 = r4
                r4 = r0
                r5 = r1
                com.airbnb.lottie.LottieTask r4 = com.airbnb.lottie.LottieCompositionFactory.fromAsset(r4, r5)
                r5 = r3
                com.airbnb.lottie.LottieTask r4 = r4.addListener(r5)
                r4 = r3
                r0 = r4
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.LottieComposition.Factory.fromAssetFileName(android.content.Context, java.lang.String, com.airbnb.lottie.OnCompositionLoadedListener):com.airbnb.lottie.Cancellable");
        }

        /* JADX WARNING: type inference failed for: r0v1, types: [com.airbnb.lottie.Cancellable] */
        /* JADX WARNING: Multi-variable type inference failed */
        @java.lang.Deprecated
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static com.airbnb.lottie.Cancellable fromRawFile(android.content.Context r9, @androidx.annotation.RawRes int r10, com.airbnb.lottie.OnCompositionLoadedListener r11) {
            /*
                r0 = r9
                r1 = r10
                r2 = r11
                com.airbnb.lottie.LottieComposition$Factory$ListenerAdapter r4 = new com.airbnb.lottie.LottieComposition$Factory$ListenerAdapter
                r8 = r4
                r4 = r8
                r5 = r8
                r6 = r2
                r7 = 0
                r5.<init>(r6, r7)
                r3 = r4
                r4 = r0
                r5 = r1
                com.airbnb.lottie.LottieTask r4 = com.airbnb.lottie.LottieCompositionFactory.fromRawRes(r4, r5)
                r5 = r3
                com.airbnb.lottie.LottieTask r4 = r4.addListener(r5)
                r4 = r3
                r0 = r4
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.LottieComposition.Factory.fromRawFile(android.content.Context, int, com.airbnb.lottie.OnCompositionLoadedListener):com.airbnb.lottie.Cancellable");
        }

        /* JADX WARNING: type inference failed for: r0v1, types: [com.airbnb.lottie.Cancellable] */
        /* JADX WARNING: Multi-variable type inference failed */
        @java.lang.Deprecated
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static com.airbnb.lottie.Cancellable fromInputStream(java.io.InputStream r8, com.airbnb.lottie.OnCompositionLoadedListener r9) {
            /*
                r0 = r8
                r1 = r9
                com.airbnb.lottie.LottieComposition$Factory$ListenerAdapter r3 = new com.airbnb.lottie.LottieComposition$Factory$ListenerAdapter
                r7 = r3
                r3 = r7
                r4 = r7
                r5 = r1
                r6 = 0
                r4.<init>(r5, r6)
                r2 = r3
                r3 = r0
                r4 = 0
                com.airbnb.lottie.LottieTask r3 = com.airbnb.lottie.LottieCompositionFactory.fromJsonInputStream(r3, r4)
                r4 = r2
                com.airbnb.lottie.LottieTask r3 = r3.addListener(r4)
                r3 = r2
                r0 = r3
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.LottieComposition.Factory.fromInputStream(java.io.InputStream, com.airbnb.lottie.OnCompositionLoadedListener):com.airbnb.lottie.Cancellable");
        }

        /* JADX WARNING: type inference failed for: r0v1, types: [com.airbnb.lottie.Cancellable] */
        /* JADX WARNING: Multi-variable type inference failed */
        @java.lang.Deprecated
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static com.airbnb.lottie.Cancellable fromJsonString(java.lang.String r8, com.airbnb.lottie.OnCompositionLoadedListener r9) {
            /*
                r0 = r8
                r1 = r9
                com.airbnb.lottie.LottieComposition$Factory$ListenerAdapter r3 = new com.airbnb.lottie.LottieComposition$Factory$ListenerAdapter
                r7 = r3
                r3 = r7
                r4 = r7
                r5 = r1
                r6 = 0
                r4.<init>(r5, r6)
                r2 = r3
                r3 = r0
                r4 = 0
                com.airbnb.lottie.LottieTask r3 = com.airbnb.lottie.LottieCompositionFactory.fromJsonString(r3, r4)
                r4 = r2
                com.airbnb.lottie.LottieTask r3 = r3.addListener(r4)
                r3 = r2
                r0 = r3
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.LottieComposition.Factory.fromJsonString(java.lang.String, com.airbnb.lottie.OnCompositionLoadedListener):com.airbnb.lottie.Cancellable");
        }

        /* JADX WARNING: type inference failed for: r0v1, types: [com.airbnb.lottie.Cancellable] */
        /* JADX WARNING: Multi-variable type inference failed */
        @java.lang.Deprecated
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static com.airbnb.lottie.Cancellable fromJsonReader(android.util.JsonReader r8, com.airbnb.lottie.OnCompositionLoadedListener r9) {
            /*
                r0 = r8
                r1 = r9
                com.airbnb.lottie.LottieComposition$Factory$ListenerAdapter r3 = new com.airbnb.lottie.LottieComposition$Factory$ListenerAdapter
                r7 = r3
                r3 = r7
                r4 = r7
                r5 = r1
                r6 = 0
                r4.<init>(r5, r6)
                r2 = r3
                r3 = r0
                r4 = 0
                com.airbnb.lottie.LottieTask r3 = com.airbnb.lottie.LottieCompositionFactory.fromJsonReader(r3, r4)
                r4 = r2
                com.airbnb.lottie.LottieTask r3 = r3.addListener(r4)
                r3 = r2
                r0 = r3
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.LottieComposition.Factory.fromJsonReader(android.util.JsonReader, com.airbnb.lottie.OnCompositionLoadedListener):com.airbnb.lottie.Cancellable");
        }

        @WorkerThread
        @Deprecated
        @Nullable
        public static LottieComposition fromFileSync(Context context, String fileName) {
            return LottieCompositionFactory.fromAssetSync(context, fileName).getValue();
        }

        @WorkerThread
        @Deprecated
        @Nullable
        public static LottieComposition fromInputStreamSync(InputStream stream) {
            return LottieCompositionFactory.fromJsonInputStreamSync(stream, (String) null).getValue();
        }

        @WorkerThread
        @Deprecated
        @Nullable
        public static LottieComposition fromInputStreamSync(InputStream inputStream, boolean close) {
            InputStream stream = inputStream;
            if (close) {
                Logger.warning("Lottie now auto-closes input stream!");
            }
            return LottieCompositionFactory.fromJsonInputStreamSync(stream, (String) null).getValue();
        }

        @WorkerThread
        @Deprecated
        @Nullable
        public static LottieComposition fromJsonSync(Resources resources, JSONObject json) {
            Resources resources2 = resources;
            return LottieCompositionFactory.fromJsonSync(json, (String) null).getValue();
        }

        @WorkerThread
        @Deprecated
        @Nullable
        public static LottieComposition fromJsonSync(String json) {
            return LottieCompositionFactory.fromJsonStringSync(json, (String) null).getValue();
        }

        @WorkerThread
        @Nullable
        @Deprecated
        public static LottieComposition fromJsonSync(JsonReader reader) throws IOException {
            return LottieCompositionFactory.fromJsonReaderSync(reader, (String) null).getValue();
        }

        private static final class ListenerAdapter implements LottieListener<LottieComposition>, Cancellable {
            private boolean cancelled;
            private final OnCompositionLoadedListener listener;

            /* JADX INFO: this call moved to the top of the method (can break code semantics) */
            /* synthetic */ ListenerAdapter(OnCompositionLoadedListener x0, AnonymousClass1 r7) {
                this(x0);
                AnonymousClass1 r2 = r7;
            }

            private ListenerAdapter(OnCompositionLoadedListener listener2) {
                this.cancelled = false;
                this.listener = listener2;
            }

            public void onResult(LottieComposition lottieComposition) {
                LottieComposition composition = lottieComposition;
                if (!this.cancelled) {
                    this.listener.onCompositionLoaded(composition);
                }
            }

            public void cancel() {
                this.cancelled = true;
            }
        }
    }
}
