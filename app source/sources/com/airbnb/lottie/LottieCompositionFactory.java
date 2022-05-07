package com.airbnb.lottie;

import android.content.Context;
import android.util.JsonReader;
import androidx.annotation.Nullable;
import androidx.annotation.RawRes;
import androidx.annotation.WorkerThread;
import com.airbnb.lottie.model.LottieCompositionCache;
import com.airbnb.lottie.network.NetworkFetcher;
import com.airbnb.lottie.parser.LottieCompositionParser;
import com.airbnb.lottie.utils.Utils;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.zip.ZipInputStream;
import org.json.JSONObject;

public class LottieCompositionFactory {
    /* access modifiers changed from: private */
    public static final Map<String, LottieTask<LottieComposition>> taskCache;

    static {
        Map<String, LottieTask<LottieComposition>> map;
        new HashMap();
        taskCache = map;
    }

    private LottieCompositionFactory() {
    }

    public static void setMaxCacheSize(int size) {
        LottieCompositionCache.getInstance().resize(size);
    }

    public static LottieTask<LottieComposition> fromUrl(Context context, String str) {
        StringBuilder sb;
        Callable callable;
        String url = str;
        new StringBuilder();
        final Context context2 = context;
        final String str2 = url;
        new Callable<LottieResult<LottieComposition>>() {
            public LottieResult<LottieComposition> call() {
                return NetworkFetcher.fetchSync(context2, str2);
            }
        };
        return cache(sb.append("url_").append(url).toString(), callable);
    }

    @WorkerThread
    public static LottieResult<LottieComposition> fromUrlSync(Context context, String url) {
        return NetworkFetcher.fetchSync(context, url);
    }

    public static LottieTask<LottieComposition> fromAsset(Context context, String str) {
        Callable callable;
        String fileName = str;
        final Context applicationContext = context.getApplicationContext();
        final String str2 = fileName;
        new Callable<LottieResult<LottieComposition>>() {
            public LottieResult<LottieComposition> call() {
                return LottieCompositionFactory.fromAssetSync(applicationContext, str2);
            }
        };
        return cache(fileName, callable);
    }

    /* JADX WARNING: Multi-variable type inference failed */
    @androidx.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.airbnb.lottie.LottieResult<com.airbnb.lottie.LottieComposition> fromAssetSync(android.content.Context r8, java.lang.String r9) {
        /*
            r0 = r8
            r1 = r9
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x004f }
            r7 = r3
            r3 = r7
            r4 = r7
            r4.<init>()     // Catch:{ IOException -> 0x004f }
            java.lang.String r4 = "asset_"
            java.lang.StringBuilder r3 = r3.append(r4)     // Catch:{ IOException -> 0x004f }
            r4 = r1
            java.lang.StringBuilder r3 = r3.append(r4)     // Catch:{ IOException -> 0x004f }
            java.lang.String r3 = r3.toString()     // Catch:{ IOException -> 0x004f }
            r2 = r3
            r3 = r1
            java.lang.String r4 = ".zip"
            boolean r3 = r3.endsWith(r4)     // Catch:{ IOException -> 0x004f }
            if (r3 == 0) goto L_0x003e
            java.util.zip.ZipInputStream r3 = new java.util.zip.ZipInputStream     // Catch:{ IOException -> 0x004f }
            r7 = r3
            r3 = r7
            r4 = r7
            r5 = r0
            android.content.res.AssetManager r5 = r5.getAssets()     // Catch:{ IOException -> 0x004f }
            r6 = r1
            java.io.InputStream r5 = r5.open(r6)     // Catch:{ IOException -> 0x004f }
            r4.<init>(r5)     // Catch:{ IOException -> 0x004f }
            r4 = r2
            com.airbnb.lottie.LottieResult r3 = fromZipStreamSync(r3, r4)     // Catch:{ IOException -> 0x004f }
            r0 = r3
        L_0x003d:
            return r0
        L_0x003e:
            r3 = r0
            android.content.res.AssetManager r3 = r3.getAssets()     // Catch:{ IOException -> 0x004f }
            r4 = r1
            java.io.InputStream r3 = r3.open(r4)     // Catch:{ IOException -> 0x004f }
            r4 = r2
            com.airbnb.lottie.LottieResult r3 = fromJsonInputStreamSync(r3, r4)     // Catch:{ IOException -> 0x004f }
            r0 = r3
            goto L_0x003d
        L_0x004f:
            r3 = move-exception
            r2 = r3
            com.airbnb.lottie.LottieResult r3 = new com.airbnb.lottie.LottieResult
            r7 = r3
            r3 = r7
            r4 = r7
            r5 = r2
            r4.<init>((java.lang.Throwable) r5)
            r0 = r3
            goto L_0x003d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.LottieCompositionFactory.fromAssetSync(android.content.Context, java.lang.String):com.airbnb.lottie.LottieResult");
    }

    public static LottieTask<LottieComposition> fromRawRes(Context context, @RawRes int i) {
        Callable callable;
        int rawRes = i;
        final Context applicationContext = context.getApplicationContext();
        final int i2 = rawRes;
        new Callable<LottieResult<LottieComposition>>() {
            public LottieResult<LottieComposition> call() {
                return LottieCompositionFactory.fromRawResSync(applicationContext, i2);
            }
        };
        return cache(rawResCacheKey(rawRes), callable);
    }

    /* JADX WARNING: Multi-variable type inference failed */
    @androidx.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.airbnb.lottie.LottieResult<com.airbnb.lottie.LottieComposition> fromRawResSync(android.content.Context r7, @androidx.annotation.RawRes int r8) {
        /*
            r0 = r7
            r1 = r8
            r3 = r0
            android.content.res.Resources r3 = r3.getResources()     // Catch:{ NotFoundException -> 0x0017 }
            r4 = r1
            java.io.InputStream r3 = r3.openRawResource(r4)     // Catch:{ NotFoundException -> 0x0017 }
            r4 = r1
            java.lang.String r4 = rawResCacheKey(r4)     // Catch:{ NotFoundException -> 0x0017 }
            com.airbnb.lottie.LottieResult r3 = fromJsonInputStreamSync(r3, r4)     // Catch:{ NotFoundException -> 0x0017 }
            r0 = r3
        L_0x0016:
            return r0
        L_0x0017:
            r3 = move-exception
            r2 = r3
            com.airbnb.lottie.LottieResult r3 = new com.airbnb.lottie.LottieResult
            r6 = r3
            r3 = r6
            r4 = r6
            r5 = r2
            r4.<init>((java.lang.Throwable) r5)
            r0 = r3
            goto L_0x0016
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.LottieCompositionFactory.fromRawResSync(android.content.Context, int):com.airbnb.lottie.LottieResult");
    }

    private static String rawResCacheKey(@RawRes int resId) {
        StringBuilder sb;
        new StringBuilder();
        return sb.append("rawRes_").append(resId).toString();
    }

    public static LottieTask<LottieComposition> fromJsonInputStream(InputStream stream, @Nullable String str) {
        Callable callable;
        String cacheKey = str;
        final InputStream inputStream = stream;
        final String str2 = cacheKey;
        new Callable<LottieResult<LottieComposition>>() {
            public LottieResult<LottieComposition> call() {
                return LottieCompositionFactory.fromJsonInputStreamSync(inputStream, str2);
            }
        };
        return cache(cacheKey, callable);
    }

    @WorkerThread
    public static LottieResult<LottieComposition> fromJsonInputStreamSync(InputStream stream, @Nullable String cacheKey) {
        return fromJsonInputStreamSync(stream, cacheKey, true);
    }

    /* JADX INFO: finally extract failed */
    @WorkerThread
    private static LottieResult<LottieComposition> fromJsonInputStreamSync(InputStream inputStream, @Nullable String str, boolean z) {
        JsonReader jsonReader;
        Reader reader;
        InputStream stream = inputStream;
        String cacheKey = str;
        boolean close = z;
        try {
            new InputStreamReader(stream);
            new JsonReader(reader);
            LottieResult<LottieComposition> fromJsonReaderSync = fromJsonReaderSync(jsonReader, cacheKey);
            if (close) {
                Utils.closeQuietly(stream);
            }
            return fromJsonReaderSync;
        } catch (Throwable th) {
            Throwable th2 = th;
            if (close) {
                Utils.closeQuietly(stream);
            }
            throw th2;
        }
    }

    @Deprecated
    public static LottieTask<LottieComposition> fromJson(JSONObject json, @Nullable String str) {
        Callable callable;
        String cacheKey = str;
        final JSONObject jSONObject = json;
        final String str2 = cacheKey;
        new Callable<LottieResult<LottieComposition>>() {
            public LottieResult<LottieComposition> call() {
                return LottieCompositionFactory.fromJsonSync(jSONObject, str2);
            }
        };
        return cache(cacheKey, callable);
    }

    @WorkerThread
    @Deprecated
    public static LottieResult<LottieComposition> fromJsonSync(JSONObject json, @Nullable String cacheKey) {
        return fromJsonStringSync(json.toString(), cacheKey);
    }

    public static LottieTask<LottieComposition> fromJsonString(String json, @Nullable String str) {
        Callable callable;
        String cacheKey = str;
        final String str2 = json;
        final String str3 = cacheKey;
        new Callable<LottieResult<LottieComposition>>() {
            public LottieResult<LottieComposition> call() {
                return LottieCompositionFactory.fromJsonStringSync(str2, str3);
            }
        };
        return cache(cacheKey, callable);
    }

    @WorkerThread
    public static LottieResult<LottieComposition> fromJsonStringSync(String json, @Nullable String cacheKey) {
        JsonReader jsonReader;
        Reader reader;
        new StringReader(json);
        new JsonReader(reader);
        return fromJsonReaderSync(jsonReader, cacheKey);
    }

    public static LottieTask<LottieComposition> fromJsonReader(JsonReader reader, @Nullable String str) {
        Callable callable;
        String cacheKey = str;
        final JsonReader jsonReader = reader;
        final String str2 = cacheKey;
        new Callable<LottieResult<LottieComposition>>() {
            public LottieResult<LottieComposition> call() {
                return LottieCompositionFactory.fromJsonReaderSync(jsonReader, str2);
            }
        };
        return cache(cacheKey, callable);
    }

    @WorkerThread
    public static LottieResult<LottieComposition> fromJsonReaderSync(JsonReader reader, @Nullable String cacheKey) {
        return fromJsonReaderSyncInternal(reader, cacheKey, true);
    }

    private static LottieResult<LottieComposition> fromJsonReaderSyncInternal(JsonReader jsonReader, @Nullable String str, boolean z) {
        LottieResult<LottieComposition> lottieResult;
        LottieResult<LottieComposition> lottieResult2;
        JsonReader reader = jsonReader;
        String cacheKey = str;
        boolean close = z;
        try {
            LottieComposition composition = LottieCompositionParser.parse(reader);
            LottieCompositionCache.getInstance().put(cacheKey, composition);
            LottieResult<LottieComposition> lottieResult3 = lottieResult2;
            new LottieResult(composition);
            LottieResult<LottieComposition> lottieResult4 = lottieResult3;
            if (close) {
                Utils.closeQuietly(reader);
            }
            return lottieResult4;
        } catch (Exception e) {
            Exception e2 = e;
            LottieResult<LottieComposition> lottieResult5 = lottieResult;
            new LottieResult((Throwable) e2);
            LottieResult<LottieComposition> lottieResult6 = lottieResult5;
            if (close) {
                Utils.closeQuietly(reader);
            }
            return lottieResult6;
        } catch (Throwable th) {
            Throwable th2 = th;
            if (close) {
                Utils.closeQuietly(reader);
            }
            throw th2;
        }
    }

    public static LottieTask<LottieComposition> fromZipStream(ZipInputStream inputStream, @Nullable String str) {
        Callable callable;
        String cacheKey = str;
        final ZipInputStream zipInputStream = inputStream;
        final String str2 = cacheKey;
        new Callable<LottieResult<LottieComposition>>() {
            public LottieResult<LottieComposition> call() {
                return LottieCompositionFactory.fromZipStreamSync(zipInputStream, str2);
            }
        };
        return cache(cacheKey, callable);
    }

    /* JADX INFO: finally extract failed */
    @WorkerThread
    public static LottieResult<LottieComposition> fromZipStreamSync(ZipInputStream zipInputStream, @Nullable String cacheKey) {
        ZipInputStream inputStream = zipInputStream;
        try {
            LottieResult<LottieComposition> fromZipStreamSyncInternal = fromZipStreamSyncInternal(inputStream, cacheKey);
            Utils.closeQuietly(inputStream);
            return fromZipStreamSyncInternal;
        } catch (Throwable th) {
            Throwable th2 = th;
            Utils.closeQuietly(inputStream);
            throw th2;
        }
    }

    /* JADX WARNING: Multi-variable type inference failed */
    @androidx.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.airbnb.lottie.LottieResult<com.airbnb.lottie.LottieComposition> fromZipStreamSyncInternal(java.util.zip.ZipInputStream r15, @androidx.annotation.Nullable java.lang.String r16) {
        /*
            r0 = r15
            r1 = r16
            r8 = 0
            r2 = r8
            java.util.HashMap r8 = new java.util.HashMap
            r14 = r8
            r8 = r14
            r9 = r14
            r9.<init>()
            r3 = r8
            r8 = r0
            java.util.zip.ZipEntry r8 = r8.getNextEntry()     // Catch:{ IOException -> 0x0094 }
            r4 = r8
        L_0x0014:
            r8 = r4
            if (r8 == 0) goto L_0x00a1
            r8 = r4
            java.lang.String r8 = r8.getName()     // Catch:{ IOException -> 0x0094 }
            r5 = r8
            r8 = r5
            java.lang.String r9 = "__MACOSX"
            boolean r8 = r8.contains(r9)     // Catch:{ IOException -> 0x0094 }
            if (r8 == 0) goto L_0x0032
            r8 = r0
            r8.closeEntry()     // Catch:{ IOException -> 0x0094 }
        L_0x002b:
            r8 = r0
            java.util.zip.ZipEntry r8 = r8.getNextEntry()     // Catch:{ IOException -> 0x0094 }
            r4 = r8
            goto L_0x0014
        L_0x0032:
            r8 = r5
            java.lang.String r9 = ".json"
            boolean r8 = r8.contains(r9)     // Catch:{ IOException -> 0x0094 }
            if (r8 == 0) goto L_0x005d
            android.util.JsonReader r8 = new android.util.JsonReader     // Catch:{ IOException -> 0x0094 }
            r14 = r8
            r8 = r14
            r9 = r14
            java.io.InputStreamReader r10 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x0094 }
            r14 = r10
            r10 = r14
            r11 = r14
            r12 = r0
            r11.<init>(r12)     // Catch:{ IOException -> 0x0094 }
            r9.<init>(r10)     // Catch:{ IOException -> 0x0094 }
            r6 = r8
            r8 = r6
            r9 = 0
            r10 = 0
            com.airbnb.lottie.LottieResult r8 = fromJsonReaderSyncInternal(r8, r9, r10)     // Catch:{ IOException -> 0x0094 }
            java.lang.Object r8 = r8.getValue()     // Catch:{ IOException -> 0x0094 }
            com.airbnb.lottie.LottieComposition r8 = (com.airbnb.lottie.LottieComposition) r8     // Catch:{ IOException -> 0x0094 }
            r2 = r8
            goto L_0x002b
        L_0x005d:
            r8 = r5
            java.lang.String r9 = ".png"
            boolean r8 = r8.contains(r9)     // Catch:{ IOException -> 0x0094 }
            if (r8 != 0) goto L_0x0071
            r8 = r5
            java.lang.String r9 = ".webp"
            boolean r8 = r8.contains(r9)     // Catch:{ IOException -> 0x0094 }
            if (r8 == 0) goto L_0x008f
        L_0x0071:
            r8 = r5
            java.lang.String r9 = "/"
            java.lang.String[] r8 = r8.split(r9)     // Catch:{ IOException -> 0x0094 }
            r6 = r8
            r8 = r6
            r9 = r6
            int r9 = r9.length     // Catch:{ IOException -> 0x0094 }
            r10 = 1
            int r9 = r9 + -1
            r8 = r8[r9]     // Catch:{ IOException -> 0x0094 }
            r7 = r8
            r8 = r3
            r9 = r7
            r10 = r0
            android.graphics.Bitmap r10 = android.graphics.BitmapFactory.decodeStream(r10)     // Catch:{ IOException -> 0x0094 }
            java.lang.Object r8 = r8.put(r9, r10)     // Catch:{ IOException -> 0x0094 }
            goto L_0x002b
        L_0x008f:
            r8 = r0
            r8.closeEntry()     // Catch:{ IOException -> 0x0094 }
            goto L_0x002b
        L_0x0094:
            r8 = move-exception
            r4 = r8
            com.airbnb.lottie.LottieResult r8 = new com.airbnb.lottie.LottieResult
            r14 = r8
            r8 = r14
            r9 = r14
            r10 = r4
            r9.<init>((java.lang.Throwable) r10)
            r0 = r8
        L_0x00a0:
            return r0
        L_0x00a1:
            r8 = r2
            if (r8 != 0) goto L_0x00b9
            com.airbnb.lottie.LottieResult r8 = new com.airbnb.lottie.LottieResult
            r14 = r8
            r8 = r14
            r9 = r14
            java.lang.IllegalArgumentException r10 = new java.lang.IllegalArgumentException
            r14 = r10
            r10 = r14
            r11 = r14
            java.lang.String r12 = "Unable to parse composition"
            r11.<init>(r12)
            r9.<init>((java.lang.Throwable) r10)
            r0 = r8
            goto L_0x00a0
        L_0x00b9:
            r8 = r3
            java.util.Set r8 = r8.entrySet()
            java.util.Iterator r8 = r8.iterator()
            r4 = r8
        L_0x00c3:
            r8 = r4
            boolean r8 = r8.hasNext()
            if (r8 == 0) goto L_0x00fc
            r8 = r4
            java.lang.Object r8 = r8.next()
            java.util.Map$Entry r8 = (java.util.Map.Entry) r8
            r5 = r8
            r8 = r2
            r9 = r5
            java.lang.Object r9 = r9.getKey()
            java.lang.String r9 = (java.lang.String) r9
            com.airbnb.lottie.LottieImageAsset r8 = findImageAssetForFileName(r8, r9)
            r6 = r8
            r8 = r6
            if (r8 == 0) goto L_0x00fb
            r8 = r6
            r9 = r5
            java.lang.Object r9 = r9.getValue()
            android.graphics.Bitmap r9 = (android.graphics.Bitmap) r9
            r10 = r6
            int r10 = r10.getWidth()
            r11 = r6
            int r11 = r11.getHeight()
            android.graphics.Bitmap r9 = com.airbnb.lottie.utils.Utils.resizeBitmapIfNeeded(r9, r10, r11)
            r8.setBitmap(r9)
        L_0x00fb:
            goto L_0x00c3
        L_0x00fc:
            r8 = r2
            java.util.Map r8 = r8.getImages()
            java.util.Set r8 = r8.entrySet()
            java.util.Iterator r8 = r8.iterator()
            r4 = r8
        L_0x010a:
            r8 = r4
            boolean r8 = r8.hasNext()
            if (r8 == 0) goto L_0x015c
            r8 = r4
            java.lang.Object r8 = r8.next()
            java.util.Map$Entry r8 = (java.util.Map.Entry) r8
            r5 = r8
            r8 = r5
            java.lang.Object r8 = r8.getValue()
            com.airbnb.lottie.LottieImageAsset r8 = (com.airbnb.lottie.LottieImageAsset) r8
            android.graphics.Bitmap r8 = r8.getBitmap()
            if (r8 != 0) goto L_0x015b
            com.airbnb.lottie.LottieResult r8 = new com.airbnb.lottie.LottieResult
            r14 = r8
            r8 = r14
            r9 = r14
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            r14 = r10
            r10 = r14
            r11 = r14
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r14 = r12
            r12 = r14
            r13 = r14
            r13.<init>()
            java.lang.String r13 = "There is no image for "
            java.lang.StringBuilder r12 = r12.append(r13)
            r13 = r5
            java.lang.Object r13 = r13.getValue()
            com.airbnb.lottie.LottieImageAsset r13 = (com.airbnb.lottie.LottieImageAsset) r13
            java.lang.String r13 = r13.getFileName()
            java.lang.StringBuilder r12 = r12.append(r13)
            java.lang.String r12 = r12.toString()
            r11.<init>(r12)
            r9.<init>((java.lang.Throwable) r10)
            r0 = r8
            goto L_0x00a0
        L_0x015b:
            goto L_0x010a
        L_0x015c:
            com.airbnb.lottie.model.LottieCompositionCache r8 = com.airbnb.lottie.model.LottieCompositionCache.getInstance()
            r9 = r1
            r10 = r2
            r8.put(r9, r10)
            com.airbnb.lottie.LottieResult r8 = new com.airbnb.lottie.LottieResult
            r14 = r8
            r8 = r14
            r9 = r14
            r10 = r2
            r9.<init>(r10)
            r0 = r8
            goto L_0x00a0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.LottieCompositionFactory.fromZipStreamSyncInternal(java.util.zip.ZipInputStream, java.lang.String):com.airbnb.lottie.LottieResult");
    }

    @Nullable
    private static LottieImageAsset findImageAssetForFileName(LottieComposition composition, String str) {
        String fileName = str;
        for (LottieImageAsset asset : composition.getImages().values()) {
            if (asset.getFileName().equals(fileName)) {
                return asset;
            }
        }
        return null;
    }

    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.airbnb.lottie.LottieTask<com.airbnb.lottie.LottieComposition> cache(@androidx.annotation.Nullable java.lang.String r10, java.util.concurrent.Callable<com.airbnb.lottie.LottieResult<com.airbnb.lottie.LottieComposition>> r11) {
        /*
            r0 = r10
            r1 = r11
            r4 = r0
            if (r4 != 0) goto L_0x001d
            r4 = 0
        L_0x0006:
            r2 = r4
            r4 = r2
            if (r4 == 0) goto L_0x0027
            com.airbnb.lottie.LottieTask r4 = new com.airbnb.lottie.LottieTask
            r9 = r4
            r4 = r9
            r5 = r9
            com.airbnb.lottie.LottieCompositionFactory$9 r6 = new com.airbnb.lottie.LottieCompositionFactory$9
            r9 = r6
            r6 = r9
            r7 = r9
            r8 = r2
            r7.<init>(r8)
            r5.<init>(r6)
            r0 = r4
        L_0x001c:
            return r0
        L_0x001d:
            com.airbnb.lottie.model.LottieCompositionCache r4 = com.airbnb.lottie.model.LottieCompositionCache.getInstance()
            r5 = r0
            com.airbnb.lottie.LottieComposition r4 = r4.get(r5)
            goto L_0x0006
        L_0x0027:
            r4 = r0
            if (r4 == 0) goto L_0x003e
            java.util.Map<java.lang.String, com.airbnb.lottie.LottieTask<com.airbnb.lottie.LottieComposition>> r4 = taskCache
            r5 = r0
            boolean r4 = r4.containsKey(r5)
            if (r4 == 0) goto L_0x003e
            java.util.Map<java.lang.String, com.airbnb.lottie.LottieTask<com.airbnb.lottie.LottieComposition>> r4 = taskCache
            r5 = r0
            java.lang.Object r4 = r4.get(r5)
            com.airbnb.lottie.LottieTask r4 = (com.airbnb.lottie.LottieTask) r4
            r0 = r4
            goto L_0x001c
        L_0x003e:
            com.airbnb.lottie.LottieTask r4 = new com.airbnb.lottie.LottieTask
            r9 = r4
            r4 = r9
            r5 = r9
            r6 = r1
            r5.<init>(r6)
            r3 = r4
            r4 = r3
            com.airbnb.lottie.LottieCompositionFactory$10 r5 = new com.airbnb.lottie.LottieCompositionFactory$10
            r9 = r5
            r5 = r9
            r6 = r9
            r7 = r0
            r6.<init>(r7)
            com.airbnb.lottie.LottieTask r4 = r4.addListener(r5)
            r4 = r3
            com.airbnb.lottie.LottieCompositionFactory$11 r5 = new com.airbnb.lottie.LottieCompositionFactory$11
            r9 = r5
            r5 = r9
            r6 = r9
            r7 = r0
            r6.<init>(r7)
            com.airbnb.lottie.LottieTask r4 = r4.addFailureListener(r5)
            java.util.Map<java.lang.String, com.airbnb.lottie.LottieTask<com.airbnb.lottie.LottieComposition>> r4 = taskCache
            r5 = r0
            r6 = r3
            java.lang.Object r4 = r4.put(r5, r6)
            r4 = r3
            r0 = r4
            goto L_0x001c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.LottieCompositionFactory.cache(java.lang.String, java.util.concurrent.Callable):com.airbnb.lottie.LottieTask");
    }
}
