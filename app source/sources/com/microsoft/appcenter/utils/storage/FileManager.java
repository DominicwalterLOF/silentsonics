package com.microsoft.appcenter.utils.storage;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.Writer;

public class FileManager {
    @SuppressLint({"StaticFieldLeak"})
    private static Context sContext;

    public FileManager() {
    }

    public static synchronized void initialize(Context context) {
        Context context2 = context;
        synchronized (FileManager.class) {
            if (sContext == null) {
                sContext = context2;
            }
        }
    }

    public static String read(@NonNull String path) {
        File file;
        new File(path);
        return read(file);
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String read(@android.support.annotation.NonNull java.io.File r12) {
        /*
            r0 = r12
            java.io.BufferedReader r6 = new java.io.BufferedReader     // Catch:{ IOException -> 0x005d }
            r11 = r6
            r6 = r11
            r7 = r11
            java.io.FileReader r8 = new java.io.FileReader     // Catch:{ IOException -> 0x005d }
            r11 = r8
            r8 = r11
            r9 = r11
            r10 = r0
            r9.<init>(r10)     // Catch:{ IOException -> 0x005d }
            r7.<init>(r8)     // Catch:{ IOException -> 0x005d }
            r1 = r6
            java.lang.String r6 = "line.separator"
            java.lang.String r6 = java.lang.System.getProperty(r6)     // Catch:{ all -> 0x0055 }
            r4 = r6
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x0055 }
            r11 = r6
            r6 = r11
            r7 = r11
            r7.<init>()     // Catch:{ all -> 0x0055 }
            r2 = r6
            r6 = r1
            java.lang.String r6 = r6.readLine()     // Catch:{ all -> 0x0055 }
            r3 = r6
            r6 = r3
            if (r6 == 0) goto L_0x004a
            r6 = r2
            r7 = r3
            java.lang.StringBuilder r6 = r6.append(r7)     // Catch:{ all -> 0x0055 }
        L_0x0033:
            r6 = r1
            java.lang.String r6 = r6.readLine()     // Catch:{ all -> 0x0055 }
            r11 = r6
            r6 = r11
            r7 = r11
            r3 = r7
            if (r6 == 0) goto L_0x004a
            r6 = r2
            r7 = r4
            java.lang.StringBuilder r6 = r6.append(r7)     // Catch:{ all -> 0x0055 }
            r7 = r3
            java.lang.StringBuilder r6 = r6.append(r7)     // Catch:{ all -> 0x0055 }
            goto L_0x0033
        L_0x004a:
            r6 = r1
            r6.close()     // Catch:{ IOException -> 0x005d }
            r6 = r2
            java.lang.String r6 = r6.toString()     // Catch:{ IOException -> 0x005d }
            r0 = r6
        L_0x0054:
            return r0
        L_0x0055:
            r6 = move-exception
            r5 = r6
            r6 = r1
            r6.close()     // Catch:{ IOException -> 0x005d }
            r6 = r5
            throw r6     // Catch:{ IOException -> 0x005d }
        L_0x005d:
            r6 = move-exception
            r1 = r6
            java.lang.String r6 = "AppCenter"
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r11 = r7
            r7 = r11
            r8 = r11
            r8.<init>()
            java.lang.String r8 = "Could not read file "
            java.lang.StringBuilder r7 = r7.append(r8)
            r8 = r0
            java.lang.String r8 = r8.getAbsolutePath()
            java.lang.StringBuilder r7 = r7.append(r8)
            java.lang.String r7 = r7.toString()
            r8 = r1
            com.microsoft.appcenter.utils.AppCenterLog.error(r6, r7, r8)
            r6 = 0
            r0 = r6
            goto L_0x0054
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microsoft.appcenter.utils.storage.FileManager.read(java.io.File):java.lang.String");
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] readBytes(@android.support.annotation.NonNull java.io.File r10) {
        /*
            r0 = r10
            r6 = r0
            long r6 = r6.length()
            int r6 = (int) r6
            byte[] r6 = new byte[r6]
            r1 = r6
            java.io.FileInputStream r6 = new java.io.FileInputStream     // Catch:{ IOException -> 0x0034 }
            r9 = r6
            r6 = r9
            r7 = r9
            r8 = r0
            r7.<init>(r8)     // Catch:{ IOException -> 0x0034 }
            r2 = r6
            java.io.DataInputStream r6 = new java.io.DataInputStream     // Catch:{ all -> 0x002c }
            r9 = r6
            r6 = r9
            r7 = r9
            r8 = r2
            r7.<init>(r8)     // Catch:{ all -> 0x002c }
            r3 = r6
            r6 = r3
            r7 = r1
            r6.readFully(r7)     // Catch:{ all -> 0x002c }
            r6 = r1
            r4 = r6
            r6 = r2
            r6.close()     // Catch:{ IOException -> 0x0034 }
            r6 = r4
            r0 = r6
        L_0x002b:
            return r0
        L_0x002c:
            r6 = move-exception
            r5 = r6
            r6 = r2
            r6.close()     // Catch:{ IOException -> 0x0034 }
            r6 = r5
            throw r6     // Catch:{ IOException -> 0x0034 }
        L_0x0034:
            r6 = move-exception
            r2 = r6
            java.lang.String r6 = "AppCenter"
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r9 = r7
            r7 = r9
            r8 = r9
            r8.<init>()
            java.lang.String r8 = "Could not read file "
            java.lang.StringBuilder r7 = r7.append(r8)
            r8 = r0
            java.lang.String r8 = r8.getAbsolutePath()
            java.lang.StringBuilder r7 = r7.append(r8)
            java.lang.String r7 = r7.toString()
            r8 = r2
            com.microsoft.appcenter.utils.AppCenterLog.error(r6, r7, r8)
            r6 = 0
            r0 = r6
            goto L_0x002b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microsoft.appcenter.utils.storage.FileManager.readBytes(java.io.File):byte[]");
    }

    public static void write(@NonNull String path, @NonNull String contents) throws IOException {
        File file;
        new File(path);
        write(file, contents);
    }

    public static void write(@NonNull File file, @NonNull String str) throws IOException {
        BufferedWriter bufferedWriter;
        Writer writer;
        File file2 = file;
        String contents = str;
        if (!TextUtils.isEmpty(contents) && TextUtils.getTrimmedLength(contents) > 0) {
            new FileWriter(file2);
            new BufferedWriter(writer);
            BufferedWriter writer2 = bufferedWriter;
            try {
                writer2.write(contents);
                writer2.close();
            } catch (Throwable th) {
                Throwable th2 = th;
                writer2.close();
                throw th2;
            }
        }
    }

    @NonNull
    public static String[] getFilenames(@NonNull String path, @Nullable FilenameFilter filenameFilter) {
        File file;
        FilenameFilter filter = filenameFilter;
        new File(path);
        File dir = file;
        if (dir.exists()) {
            return dir.list(filter);
        }
        return new String[0];
    }

    @Nullable
    public static File lastModifiedFile(@NonNull String path, @Nullable FilenameFilter filter) {
        File file;
        new File(path);
        return lastModifiedFile(file, filter);
    }

    @Nullable
    public static File lastModifiedFile(@NonNull File file, @Nullable FilenameFilter filenameFilter) {
        File dir = file;
        FilenameFilter filter = filenameFilter;
        if (dir.exists()) {
            File[] files = dir.listFiles(filter);
            long lastModification = 0;
            File lastModifiedFile = null;
            if (files != null) {
                File[] fileArr = files;
                int length = fileArr.length;
                for (int i = 0; i < length; i++) {
                    File file2 = fileArr[i];
                    if (file2.lastModified() > lastModification) {
                        lastModification = file2.lastModified();
                        lastModifiedFile = file2;
                    }
                }
                return lastModifiedFile;
            }
        }
        return null;
    }

    public static boolean delete(@NonNull String path) {
        File file;
        new File(path);
        return delete(file);
    }

    public static boolean delete(@NonNull File file) {
        return file.delete();
    }

    public static boolean deleteDirectory(@NonNull File file) {
        File file2 = file;
        File[] contents = file2.listFiles();
        if (contents != null) {
            File[] fileArr = contents;
            int length = fileArr.length;
            for (int i = 0; i < length; i++) {
                boolean deleteDirectory = deleteDirectory(fileArr[i]);
            }
        }
        return file2.delete();
    }

    public static void cleanDirectory(@NonNull File directory) {
        File[] contents = directory.listFiles();
        if (contents != null) {
            File[] fileArr = contents;
            int length = fileArr.length;
            for (int i = 0; i < length; i++) {
                boolean deleteDirectory = deleteDirectory(fileArr[i]);
            }
        }
    }

    public static void mkdir(@NonNull String path) {
        File file;
        new File(path);
        boolean mkdirs = file.mkdirs();
    }
}
