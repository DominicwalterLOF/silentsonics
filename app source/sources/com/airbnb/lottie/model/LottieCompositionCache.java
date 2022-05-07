package com.airbnb.lottie.model;

import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.collection.LruCache;
import com.airbnb.lottie.LottieComposition;

@RestrictTo({RestrictTo.Scope.LIBRARY})
public class LottieCompositionCache {
    private static final LottieCompositionCache INSTANCE;
    private final LruCache<String, LottieComposition> cache;

    static {
        LottieCompositionCache lottieCompositionCache;
        new LottieCompositionCache();
        INSTANCE = lottieCompositionCache;
    }

    public static LottieCompositionCache getInstance() {
        return INSTANCE;
    }

    @VisibleForTesting
    LottieCompositionCache() {
        LruCache<String, LottieComposition> lruCache;
        new LruCache<>(20);
        this.cache = lruCache;
    }

    @Nullable
    public LottieComposition get(@Nullable String str) {
        String cacheKey = str;
        if (cacheKey == null) {
            return null;
        }
        return this.cache.get(cacheKey);
    }

    public void put(@Nullable String str, LottieComposition lottieComposition) {
        String cacheKey = str;
        LottieComposition composition = lottieComposition;
        if (cacheKey != null) {
            LottieComposition put = this.cache.put(cacheKey, composition);
        }
    }

    public void clear() {
        this.cache.evictAll();
    }

    public void resize(int size) {
        this.cache.resize(size);
    }
}
