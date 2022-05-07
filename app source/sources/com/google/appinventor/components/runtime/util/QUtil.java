package com.google.appinventor.components.runtime.util;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import java.io.File;

public class QUtil {
    public QUtil() {
    }

    public static String getExternalStoragePath(Context context, boolean z, boolean z2) {
        return getExternalStorageDir(context, z, z2).getAbsolutePath();
    }

    public static String getExternalStoragePath(Context context, boolean z) {
        return getExternalStoragePath(context, z, false);
    }

    public static String getExternalStoragePath(Context context) {
        return getExternalStoragePath(context, false, false);
    }

    public static File getExternalStorageDir(Context context) {
        return getExternalStorageDir(context, false);
    }

    public static File getExternalStorageDir(Context context, boolean z) {
        return getExternalStorageDir(context, z, false);
    }

    public static File getExternalStorageDir(Context context, boolean z, boolean z2) {
        Context context2 = context;
        boolean z3 = z;
        if ((z2 || Build.VERSION.SDK_INT < 29) && !z3) {
            return Environment.getExternalStorageDirectory();
        }
        return context2.getExternalFilesDir((String) null);
    }

    public static String getReplAssetPath(Context context, boolean z) {
        StringBuilder sb;
        StringBuilder sb2;
        Context context2 = context;
        boolean z2 = z;
        if (Build.VERSION.SDK_INT >= 29) {
            new StringBuilder();
            return sb2.append(getExternalStoragePath(context2, z2)).append("/assets/").toString();
        }
        new StringBuilder();
        return sb.append(getExternalStoragePath(context2, z2)).append("/Kodular/assets/").toString();
    }

    public static String getReplAssetPath(Context context) {
        return getReplAssetPath(context, false);
    }

    public static String getReplDataPath(Context context, boolean z) {
        StringBuilder sb;
        StringBuilder sb2;
        Context context2 = context;
        boolean z2 = z;
        if (Build.VERSION.SDK_INT >= 29) {
            new StringBuilder();
            return sb2.append(getExternalStoragePath(context2, z2)).append("/data/").toString();
        }
        new StringBuilder();
        return sb.append(getExternalStoragePath(context2, z2)).append("/Kodular/data/").toString();
    }

    public static String getReplDataPath(Context context) {
        return getReplDataPath(context, false);
    }
}
