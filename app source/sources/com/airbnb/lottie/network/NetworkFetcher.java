package com.airbnb.lottie.network;

import android.content.Context;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import androidx.core.util.Pair;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieCompositionFactory;
import com.airbnb.lottie.LottieResult;
import com.airbnb.lottie.utils.Logger;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.zip.ZipInputStream;

public class NetworkFetcher {
    private final Context appContext;
    private final NetworkCache networkCache;
    private final String url;

    public static LottieResult<LottieComposition> fetchSync(Context context, String url2) {
        NetworkFetcher networkFetcher;
        new NetworkFetcher(context, url2);
        return networkFetcher.fetchSync();
    }

    private NetworkFetcher(Context context, String str) {
        NetworkCache networkCache2;
        String url2 = str;
        this.appContext = context.getApplicationContext();
        this.url = url2;
        new NetworkCache(this.appContext, url2);
        this.networkCache = networkCache2;
    }

    /* JADX WARNING: Multi-variable type inference failed */
    @androidx.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.airbnb.lottie.LottieResult<com.airbnb.lottie.LottieComposition> fetchSync() {
        /*
            r6 = this;
            r0 = r6
            r2 = r0
            com.airbnb.lottie.LottieComposition r2 = r2.fetchFromCache()
            r1 = r2
            r2 = r1
            if (r2 == 0) goto L_0x0015
            com.airbnb.lottie.LottieResult r2 = new com.airbnb.lottie.LottieResult
            r5 = r2
            r2 = r5
            r3 = r5
            r4 = r1
            r3.<init>(r4)
            r0 = r2
        L_0x0014:
            return r0
        L_0x0015:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r5 = r2
            r2 = r5
            r3 = r5
            r3.<init>()
            java.lang.String r3 = "Animation for "
            java.lang.StringBuilder r2 = r2.append(r3)
            r3 = r0
            java.lang.String r3 = r3.url
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r3 = " not found in cache. Fetching from network."
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r2 = r2.toString()
            com.airbnb.lottie.utils.Logger.debug(r2)
            r2 = r0
            com.airbnb.lottie.LottieResult r2 = r2.fetchFromNetwork()
            r0 = r2
            goto L_0x0014
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.network.NetworkFetcher.fetchSync():com.airbnb.lottie.LottieResult");
    }

    @WorkerThread
    @Nullable
    private LottieComposition fetchFromCache() {
        LottieResult<LottieComposition> result;
        ZipInputStream zipInputStream;
        Pair<FileExtension, InputStream> cacheResult = this.networkCache.fetch();
        if (cacheResult == null) {
            return null;
        }
        FileExtension extension = (FileExtension) cacheResult.first;
        InputStream inputStream = (InputStream) cacheResult.second;
        if (extension == FileExtension.ZIP) {
            new ZipInputStream(inputStream);
            result = LottieCompositionFactory.fromZipStreamSync(zipInputStream, this.url);
        } else {
            result = LottieCompositionFactory.fromJsonInputStreamSync(inputStream, this.url);
        }
        if (result.getValue() != null) {
            return result.getValue();
        }
        return null;
    }

    /* JADX WARNING: Multi-variable type inference failed */
    @androidx.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.airbnb.lottie.LottieResult<com.airbnb.lottie.LottieComposition> fetchFromNetwork() {
        /*
            r6 = this;
            r0 = r6
            r2 = r0
            com.airbnb.lottie.LottieResult r2 = r2.fetchFromNetworkInternal()     // Catch:{ IOException -> 0x0008 }
            r0 = r2
        L_0x0007:
            return r0
        L_0x0008:
            r2 = move-exception
            r1 = r2
            com.airbnb.lottie.LottieResult r2 = new com.airbnb.lottie.LottieResult
            r5 = r2
            r2 = r5
            r3 = r5
            r4 = r1
            r3.<init>((java.lang.Throwable) r4)
            r0 = r2
            goto L_0x0007
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.network.NetworkFetcher.fetchFromNetwork():com.airbnb.lottie.LottieResult");
    }

    @WorkerThread
    private LottieResult fetchFromNetworkInternal() throws IOException {
        StringBuilder sb;
        URL url2;
        LottieResult lottieResult;
        LottieResult lottieResult2;
        Throwable th;
        StringBuilder sb2;
        StringBuilder sb3;
        new StringBuilder();
        Logger.debug(sb.append("Fetching ").append(this.url).toString());
        new URL(this.url);
        HttpURLConnection connection = (HttpURLConnection) url2.openConnection();
        connection.setRequestMethod("GET");
        try {
            connection.connect();
            if (connection.getErrorStream() == null && connection.getResponseCode() == 200) {
                LottieResult<LottieComposition> result = getResultFromConnection(connection);
                new StringBuilder();
                Logger.debug(sb3.append("Completed fetch from network. Success: ").append(result.getValue() != null).toString());
                LottieResult<LottieComposition> lottieResult3 = result;
                connection.disconnect();
                return lottieResult3;
            }
            String error = getErrorFromConnection(connection);
            LottieResult lottieResult4 = lottieResult2;
            new StringBuilder();
            new IllegalArgumentException(sb2.append("Unable to fetch ").append(this.url).append(". Failed with ").append(connection.getResponseCode()).append("\n").append(error).toString());
            new LottieResult(th);
            LottieResult lottieResult5 = lottieResult4;
            connection.disconnect();
            return lottieResult5;
        } catch (Exception e) {
            Exception e2 = e;
            LottieResult lottieResult6 = lottieResult;
            new LottieResult((Throwable) e2);
            LottieResult lottieResult7 = lottieResult6;
            connection.disconnect();
            return lottieResult7;
        } catch (Throwable th2) {
            Throwable th3 = th2;
            connection.disconnect();
            throw th3;
        }
    }

    private String getErrorFromConnection(HttpURLConnection httpURLConnection) throws IOException {
        BufferedReader bufferedReader;
        Reader reader;
        StringBuilder sb;
        HttpURLConnection connection = httpURLConnection;
        int responseCode = connection.getResponseCode();
        new InputStreamReader(connection.getErrorStream());
        new BufferedReader(reader);
        BufferedReader r = bufferedReader;
        new StringBuilder();
        StringBuilder error = sb;
        while (true) {
            try {
                String readLine = r.readLine();
                String line = readLine;
                if (readLine == null) {
                    break;
                }
                StringBuilder append = error.append(line).append(10);
            } catch (Exception e) {
                throw e;
            } catch (Throwable th) {
                Throwable th2 = th;
                try {
                    r.close();
                } catch (Exception e2) {
                    Exception exc = e2;
                }
                throw th2;
            }
        }
        try {
            r.close();
        } catch (Exception e3) {
            Exception exc2 = e3;
        }
        return error.toString();
    }

    @Nullable
    private LottieResult<LottieComposition> getResultFromConnection(HttpURLConnection httpURLConnection) throws IOException {
        FileExtension extension;
        ZipInputStream zipInputStream;
        InputStream inputStream;
        LottieResult<LottieComposition> result;
        InputStream inputStream2;
        File file;
        HttpURLConnection connection = httpURLConnection;
        String contentType = connection.getContentType();
        if (contentType == null) {
            contentType = "application/json";
        }
        String str = contentType;
        boolean z = true;
        switch (str.hashCode()) {
            case -1248325150:
                if (str.equals("application/zip")) {
                    z = false;
                    break;
                }
                break;
            case -43840953:
                if (str.equals("application/json")) {
                    z = true;
                    break;
                }
                break;
        }
        switch (z) {
            case false:
                Logger.debug("Handling zip response.");
                extension = FileExtension.ZIP;
                new FileInputStream(this.networkCache.writeTempCacheFile(connection.getInputStream(), extension));
                new ZipInputStream(inputStream);
                result = LottieCompositionFactory.fromZipStreamSync(zipInputStream, this.url);
                break;
            default:
                Logger.debug("Received json response.");
                extension = FileExtension.JSON;
                new File(this.networkCache.writeTempCacheFile(connection.getInputStream(), extension).getAbsolutePath());
                new FileInputStream(file);
                result = LottieCompositionFactory.fromJsonInputStreamSync(inputStream2, this.url);
                break;
        }
        if (result.getValue() != null) {
            this.networkCache.renameTempFile(extension);
        }
        return result;
    }
}
