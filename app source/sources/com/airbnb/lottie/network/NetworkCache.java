package com.airbnb.lottie.network;

import android.content.Context;
import androidx.annotation.Nullable;
import com.airbnb.lottie.utils.Logger;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

class NetworkCache {
    private final Context appContext;
    private final String url;

    NetworkCache(Context appContext2, String url2) {
        this.appContext = appContext2.getApplicationContext();
        this.url = url2;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Multi-variable type inference failed */
    @androidx.annotation.WorkerThread
    @androidx.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public androidx.core.util.Pair<com.airbnb.lottie.network.FileExtension, java.io.InputStream> fetch() {
        /*
            r9 = this;
            r0 = r9
            r4 = 0
            r1 = r4
            r4 = r0
            r5 = r0
            java.lang.String r5 = r5.url     // Catch:{ FileNotFoundException -> 0x0012 }
            java.io.File r4 = r4.getCachedFile(r5)     // Catch:{ FileNotFoundException -> 0x0012 }
            r1 = r4
            r4 = r1
            if (r4 != 0) goto L_0x0017
            r4 = 0
            r0 = r4
        L_0x0011:
            return r0
        L_0x0012:
            r4 = move-exception
            r2 = r4
            r4 = 0
            r0 = r4
            goto L_0x0011
        L_0x0017:
            java.io.FileInputStream r4 = new java.io.FileInputStream     // Catch:{ FileNotFoundException -> 0x006b }
            r8 = r4
            r4 = r8
            r5 = r8
            r6 = r1
            r5.<init>(r6)     // Catch:{ FileNotFoundException -> 0x006b }
            r2 = r4
            r4 = r1
            java.lang.String r4 = r4.getAbsolutePath()
            java.lang.String r5 = ".zip"
            boolean r4 = r4.endsWith(r5)
            if (r4 == 0) goto L_0x0070
            com.airbnb.lottie.network.FileExtension r4 = com.airbnb.lottie.network.FileExtension.ZIP
            r3 = r4
        L_0x0032:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r8 = r4
            r4 = r8
            r5 = r8
            r5.<init>()
            java.lang.String r5 = "Cache hit for "
            java.lang.StringBuilder r4 = r4.append(r5)
            r5 = r0
            java.lang.String r5 = r5.url
            java.lang.StringBuilder r4 = r4.append(r5)
            java.lang.String r5 = " at "
            java.lang.StringBuilder r4 = r4.append(r5)
            r5 = r1
            java.lang.String r5 = r5.getAbsolutePath()
            java.lang.StringBuilder r4 = r4.append(r5)
            java.lang.String r4 = r4.toString()
            com.airbnb.lottie.utils.Logger.debug(r4)
            androidx.core.util.Pair r4 = new androidx.core.util.Pair
            r8 = r4
            r4 = r8
            r5 = r8
            r6 = r3
            r7 = r2
            r5.<init>(r6, r7)
            r0 = r4
            goto L_0x0011
        L_0x006b:
            r4 = move-exception
            r3 = r4
            r4 = 0
            r0 = r4
            goto L_0x0011
        L_0x0070:
            com.airbnb.lottie.network.FileExtension r4 = com.airbnb.lottie.network.FileExtension.JSON
            r3 = r4
            goto L_0x0032
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.network.NetworkCache.fetch():androidx.core.util.Pair");
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: package-private */
    public File writeTempCacheFile(InputStream inputStream, FileExtension extension) throws IOException {
        File file;
        OutputStream outputStream;
        OutputStream output;
        InputStream stream = inputStream;
        new File(this.appContext.getCacheDir(), filenameForUrl(this.url, extension, true));
        File file2 = file;
        try {
            OutputStream outputStream2 = outputStream;
            new FileOutputStream(file2);
            output = outputStream2;
            byte[] buffer = new byte[1024];
            while (true) {
                int read = stream.read(buffer);
                int read2 = read;
                if (read != -1) {
                    output.write(buffer, 0, read2);
                } else {
                    output.flush();
                    output.close();
                    stream.close();
                    return file2;
                }
            }
        } catch (Throwable th) {
            Throwable th2 = th;
            stream.close();
            throw th2;
        }
    }

    /* access modifiers changed from: package-private */
    public void renameTempFile(FileExtension extension) {
        File file;
        File file2;
        StringBuilder sb;
        StringBuilder sb2;
        new File(this.appContext.getCacheDir(), filenameForUrl(this.url, extension, true));
        File file3 = file;
        new File(file3.getAbsolutePath().replace(".temp", ""));
        File newFile = file2;
        boolean renamed = file3.renameTo(newFile);
        new StringBuilder();
        Logger.debug(sb.append("Copying temp file to real file (").append(newFile).append(")").toString());
        if (!renamed) {
            new StringBuilder();
            Logger.warning(sb2.append("Unable to rename cache file ").append(file3.getAbsolutePath()).append(" to ").append(newFile.getAbsolutePath()).append(".").toString());
        }
    }

    @Nullable
    private File getCachedFile(String str) throws FileNotFoundException {
        File file;
        File file2;
        String url2 = str;
        new File(this.appContext.getCacheDir(), filenameForUrl(url2, FileExtension.JSON, false));
        File jsonFile = file;
        if (jsonFile.exists()) {
            return jsonFile;
        }
        new File(this.appContext.getCacheDir(), filenameForUrl(url2, FileExtension.ZIP, false));
        File zipFile = file2;
        if (zipFile.exists()) {
            return zipFile;
        }
        return null;
    }

    private static String filenameForUrl(String url2, FileExtension fileExtension, boolean isTemp) {
        StringBuilder sb;
        FileExtension extension = fileExtension;
        new StringBuilder();
        return sb.append("lottie_cache_").append(url2.replaceAll("\\W+", "")).append(isTemp ? extension.tempExtension() : extension.extension).toString();
    }
}
