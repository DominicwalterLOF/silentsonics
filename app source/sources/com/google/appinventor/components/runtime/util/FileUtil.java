package com.google.appinventor.components.runtime.util;

import android.os.Environment;
import android.util.Log;
import com.google.appinventor.components.runtime.Form;
import com.google.appinventor.components.runtime.errors.PermissionException;
import com.google.appinventor.components.runtime.errors.RuntimeError;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.net.URL;

public class FileUtil {
    private static final String LOG_TAG = FileUtil.class.getSimpleName();

    private FileUtil() {
    }

    public static String getFileUrl(String str) {
        File file;
        new File(str);
        return file.toURI().toString();
    }

    @Deprecated
    public static byte[] readFile(String str) throws IOException {
        Throwable th;
        new IllegalAccessException();
        int w = Log.w(LOG_TAG, "Calling deprecated function readFile", th);
        return readFile(Form.getActiveForm(), str);
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0052  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] readFile(com.google.appinventor.components.runtime.Form r12, java.lang.String r13) throws java.io.IOException {
        /*
            r1 = r12
            r2 = r13
            java.io.File r6 = new java.io.File
            r11 = r6
            r6 = r11
            r7 = r11
            r8 = r2
            r7.<init>(r8)
            r11 = r6
            r6 = r11
            r7 = r11
            r3 = r7
            boolean r6 = r6.isFile()
            if (r6 != 0) goto L_0x002a
            java.io.FileNotFoundException r6 = new java.io.FileNotFoundException
            r11 = r6
            r6 = r11
            r7 = r11
            java.lang.String r8 = "Cannot find file: "
            r9 = r2
            java.lang.String r9 = java.lang.String.valueOf(r9)
            java.lang.String r8 = r8.concat(r9)
            r7.<init>(r8)
            throw r6
        L_0x002a:
            r6 = 0
            r4 = r6
            r6 = r1
            r7 = r2
            java.io.FileInputStream r6 = openFile((com.google.appinventor.components.runtime.Form) r6, (java.lang.String) r7)     // Catch:{ all -> 0x0067 }
            r4 = r6
            r6 = r3
            long r6 = r6.length()     // Catch:{ all -> 0x0067 }
            int r6 = (int) r6     // Catch:{ all -> 0x0067 }
            r11 = r6
            r6 = r11
            r7 = r11
            r2 = r7
            byte[] r6 = new byte[r6]     // Catch:{ all -> 0x0067 }
            r1 = r6
            r6 = 0
            r3 = r6
        L_0x0042:
            r6 = r4
            r7 = r1
            r8 = r3
            r9 = r2
            r10 = r3
            int r9 = r9 - r10
            int r6 = r6.read(r7, r8, r9)     // Catch:{ all -> 0x0067 }
            r11 = r6
            r6 = r11
            r7 = r11
            r5 = r7
            if (r6 <= 0) goto L_0x0056
            r6 = r3
            r7 = r5
            int r6 = r6 + r7
            r3 = r6
        L_0x0056:
            r6 = r3
            r7 = r2
            if (r6 == r7) goto L_0x005d
            r6 = r5
            if (r6 >= 0) goto L_0x0042
        L_0x005d:
            r6 = r4
            if (r6 == 0) goto L_0x0064
            r6 = r4
            r6.close()
        L_0x0064:
            r6 = r1
            r1 = r6
            return r1
        L_0x0067:
            r6 = move-exception
            r1 = r6
            r6 = r4
            if (r6 == 0) goto L_0x0070
            r6 = r4
            r6.close()
        L_0x0070:
            r6 = r1
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.appinventor.components.runtime.util.FileUtil.readFile(com.google.appinventor.components.runtime.Form, java.lang.String):byte[]");
    }

    @Deprecated
    public static FileInputStream openFile(String str) throws IOException, PermissionException {
        Throwable th;
        new IllegalAccessException();
        int w = Log.w(LOG_TAG, "Calling deprecated function openFile", th);
        return openFile(Form.getActiveForm(), str);
    }

    public static FileInputStream openFile(Form form, String str) throws IOException {
        FileInputStream fileInputStream;
        Form form2 = form;
        String str2 = str;
        if (MediaUtil.isExternalFile(form2, str2)) {
            form2.assertPermission("android.permission.READ_EXTERNAL_STORAGE");
        }
        new FileInputStream(str2);
        return fileInputStream;
    }

    @Deprecated
    public static FileInputStream openFile(File file) throws IOException, PermissionException {
        Throwable th;
        new IllegalAccessException();
        int w = Log.w(LOG_TAG, "Calling deprecated function openFile", th);
        return openFile(Form.getActiveForm(), file.getAbsolutePath());
    }

    public static FileInputStream openFile(Form form, File file) throws IOException, PermissionException {
        return openFile(form, file.getAbsolutePath());
    }

    @Deprecated
    public static FileInputStream openFile(URI uri) throws IOException, PermissionException {
        Throwable th;
        new IllegalAccessException();
        int w = Log.w(LOG_TAG, "Calling deprecated function openFile", th);
        return openFile(Form.getActiveForm(), uri);
    }

    public static FileInputStream openFile(Form form, URI uri) throws IOException, PermissionException {
        FileInputStream fileInputStream;
        File file;
        Form form2 = form;
        URI uri2 = uri;
        if (MediaUtil.isExternalFileUrl(form2, uri2.toString())) {
            form2.assertPermission("android.permission.READ_EXTERNAL_STORAGE");
        }
        new File(uri2);
        new FileInputStream(file);
        return fileInputStream;
    }

    /* JADX INFO: finally extract failed */
    public static String downloadUrlToFile(String str, String str2) throws IOException {
        URL url;
        new URL(str);
        InputStream openStream = url.openStream();
        try {
            String writeStreamToFile = writeStreamToFile(openStream, str2);
            openStream.close();
            return writeStreamToFile;
        } catch (Throwable th) {
            Throwable th2 = th;
            openStream.close();
            throw th2;
        }
    }

    /* JADX INFO: finally extract failed */
    public static String writeFile(byte[] bArr, String str) throws IOException {
        InputStream inputStream;
        new ByteArrayInputStream(bArr);
        InputStream inputStream2 = inputStream;
        try {
            String writeStreamToFile = writeStreamToFile(inputStream2, str);
            inputStream2.close();
            return writeStreamToFile;
        } catch (Throwable th) {
            Throwable th2 = th;
            inputStream2.close();
            throw th2;
        }
    }

    /* JADX INFO: finally extract failed */
    public static String copyFile(String str, String str2) throws IOException {
        InputStream inputStream;
        new FileInputStream(str);
        InputStream inputStream2 = inputStream;
        try {
            String writeStreamToFile = writeStreamToFile(inputStream2, str2);
            inputStream2.close();
            return writeStreamToFile;
        } catch (Throwable th) {
            Throwable th2 = th;
            inputStream2.close();
            throw th2;
        }
    }

    /* JADX INFO: finally extract failed */
    public static String writeStreamToFile(InputStream inputStream, String str) throws IOException {
        File file;
        OutputStream outputStream;
        new File(str);
        File file2 = file;
        File file3 = file2;
        boolean mkdirs = file2.getParentFile().mkdirs();
        new FileOutputStream(file3);
        OutputStream outputStream2 = outputStream;
        try {
            hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME(inputStream, outputStream2);
            String uri = file3.toURI().toString();
            outputStream2.flush();
            outputStream2.close();
            return uri;
        } catch (Throwable th) {
            Throwable th2 = th;
            outputStream2.flush();
            outputStream2.close();
            throw th2;
        }
    }

    private static void hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME(InputStream inputStream, OutputStream outputStream) throws IOException {
        OutputStream outputStream2;
        InputStream inputStream2;
        new BufferedOutputStream(outputStream, 4096);
        OutputStream outputStream3 = outputStream2;
        new BufferedInputStream(inputStream, 4096);
        InputStream inputStream3 = inputStream2;
        while (true) {
            int read = inputStream3.read();
            int i = read;
            if (read != -1) {
                outputStream3.write(i);
            } else {
                outputStream3.flush();
                return;
            }
        }
    }

    public static File getPictureFile(String str) throws IOException, FileException {
        Throwable th;
        new IllegalAccessException();
        int w = Log.w(LOG_TAG, "Calling deprecated function getPictureFile", th);
        return getPictureFile(Form.getActiveForm(), str);
    }

    public static File getPictureFile(Form form, String str) throws IOException, FileException {
        return hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME(form, "Pictures", str);
    }

    @Deprecated
    public static File getRecordingFile(String str) throws IOException, FileException {
        return getRecordingFile(Form.getActiveForm(), str);
    }

    public static File getRecordingFile(Form form, String str) throws IOException, FileException {
        return hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME(form, "Recordings", str);
    }

    @Deprecated
    public static File getDownloadFile(String str) throws IOException, FileException {
        Throwable th;
        new IllegalAccessException();
        int w = Log.w(LOG_TAG, "Calling deprecated function getDownloadFile", th);
        return getDownloadFile(Form.getActiveForm(), str);
    }

    public static File getDownloadFile(Form form, String str) throws IOException, FileException {
        return hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME(form, "Downloads", str);
    }

    private static File hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME(Form form, String str, String str2) throws IOException, FileException {
        StringBuilder sb;
        new StringBuilder("My Documents/");
        return getExternalFile(form, sb.append(str).append("/kodular_").append(System.currentTimeMillis()).append(".").append(str2).toString());
    }

    @Deprecated
    public static File getExternalFile(String str) throws IOException, FileException, SecurityException {
        return getExternalFile(Form.getActiveForm(), str);
    }

    public static File getExternalFile(Form form, String str) throws IOException, FileException, SecurityException {
        File file;
        Throwable th;
        StringBuilder sb;
        Throwable th2;
        StringBuilder sb2;
        Form form2 = form;
        checkExternalStorageWriteable();
        new File(QUtil.getExternalStoragePath(form2), str);
        File file2 = file;
        File file3 = file2;
        File parentFile = file2.getParentFile();
        if (form2 != null) {
            form2.assertPermission("android.permission.WRITE_EXTERNAL_STORAGE");
        }
        if (!parentFile.exists() && !parentFile.mkdirs()) {
            Throwable th3 = th2;
            new StringBuilder("Unable to create directory ");
            new IOException(sb2.append(parentFile.getAbsolutePath()).toString());
            throw th3;
        } else if (!file3.exists() || file3.delete()) {
            return file3;
        } else {
            Throwable th4 = th;
            new StringBuilder("Cannot overwrite existing file ");
            new IOException(sb.append(file3.getAbsolutePath()).toString());
            throw th4;
        }
    }

    public static void checkExternalStorageWriteable() throws FileException {
        Throwable th;
        Throwable th2;
        String externalStorageState = Environment.getExternalStorageState();
        if (!"mounted".equals(externalStorageState)) {
            if ("mounted_ro".equals(externalStorageState)) {
                Throwable th3 = th2;
                new FileException(ErrorMessages.ERROR_MEDIA_EXTERNAL_STORAGE_READONLY);
                throw th3;
            }
            Throwable th4 = th;
            new FileException(ErrorMessages.ERROR_MEDIA_EXTERNAL_STORAGE_NOT_AVAILABLE);
            throw th4;
        }
    }

    public static class FileException extends RuntimeError {
        private final int UT8jc0jwpnlGoVnBZm9Vqfc7zQxpOFTo7zW0ZxKDjXZZsrQ7LsG7hsoko7RBNNg5;

        public FileException(int i) {
            this.UT8jc0jwpnlGoVnBZm9Vqfc7zQxpOFTo7zW0ZxKDjXZZsrQ7LsG7hsoko7RBNNg5 = i;
        }

        public int getErrorMessageNumber() {
            return this.UT8jc0jwpnlGoVnBZm9Vqfc7zQxpOFTo7zW0ZxKDjXZZsrQ7LsG7hsoko7RBNNg5;
        }
    }
}
