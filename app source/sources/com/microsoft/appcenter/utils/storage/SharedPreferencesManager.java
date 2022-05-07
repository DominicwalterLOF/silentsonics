package com.microsoft.appcenter.utils.storage;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import java.util.Set;

public class SharedPreferencesManager {
    private static final String PREFERENCES_NAME = "AppCenter";
    @SuppressLint({"StaticFieldLeak"})
    private static Context sContext;
    private static SharedPreferences sSharedPreferences;

    public SharedPreferencesManager() {
    }

    public static synchronized void initialize(Context context) {
        Context context2 = context;
        synchronized (SharedPreferencesManager.class) {
            if (sContext == null) {
                sContext = context2;
                sSharedPreferences = sContext.getSharedPreferences("AppCenter", 0);
            }
        }
    }

    public static boolean getBoolean(@NonNull String key) {
        return getBoolean(key, false);
    }

    public static boolean getBoolean(@NonNull String key, boolean defValue) {
        return sSharedPreferences.getBoolean(key, defValue);
    }

    public static void putBoolean(@NonNull String key, boolean value) {
        SharedPreferences.Editor editor = sSharedPreferences.edit();
        SharedPreferences.Editor putBoolean = editor.putBoolean(key, value);
        editor.apply();
    }

    public static float getFloat(@NonNull String key) {
        return getFloat(key, 0.0f);
    }

    public static float getFloat(@NonNull String key, float defValue) {
        return sSharedPreferences.getFloat(key, defValue);
    }

    public static void putFloat(@NonNull String key, float value) {
        SharedPreferences.Editor editor = sSharedPreferences.edit();
        SharedPreferences.Editor putFloat = editor.putFloat(key, value);
        editor.apply();
    }

    public static int getInt(@NonNull String key) {
        return getInt(key, 0);
    }

    public static int getInt(@NonNull String key, int defValue) {
        return sSharedPreferences.getInt(key, defValue);
    }

    public static void putInt(@NonNull String key, int value) {
        SharedPreferences.Editor editor = sSharedPreferences.edit();
        SharedPreferences.Editor putInt = editor.putInt(key, value);
        editor.apply();
    }

    public static long getLong(@NonNull String key) {
        return getLong(key, 0);
    }

    public static long getLong(@NonNull String key, long defValue) {
        return sSharedPreferences.getLong(key, defValue);
    }

    public static void putLong(@NonNull String key, long value) {
        SharedPreferences.Editor editor = sSharedPreferences.edit();
        SharedPreferences.Editor putLong = editor.putLong(key, value);
        editor.apply();
    }

    @Nullable
    public static String getString(@NonNull String key) {
        return getString(key, (String) null);
    }

    public static String getString(@NonNull String key, String defValue) {
        return sSharedPreferences.getString(key, defValue);
    }

    public static void putString(@NonNull String key, String value) {
        SharedPreferences.Editor editor = sSharedPreferences.edit();
        SharedPreferences.Editor putString = editor.putString(key, value);
        editor.apply();
    }

    public static Set<String> getStringSet(@NonNull String key) {
        return getStringSet(key, (Set<String>) null);
    }

    public static Set<String> getStringSet(@NonNull String key, Set<String> defValue) {
        return sSharedPreferences.getStringSet(key, defValue);
    }

    public static void putStringSet(@NonNull String key, Set<String> value) {
        SharedPreferences.Editor editor = sSharedPreferences.edit();
        SharedPreferences.Editor putStringSet = editor.putStringSet(key, value);
        editor.apply();
    }

    public static void remove(@NonNull String key) {
        SharedPreferences.Editor editor = sSharedPreferences.edit();
        SharedPreferences.Editor remove = editor.remove(key);
        editor.apply();
    }

    public static void clear() {
        SharedPreferences.Editor editor = sSharedPreferences.edit();
        SharedPreferences.Editor clear = editor.clear();
        editor.apply();
    }
}
