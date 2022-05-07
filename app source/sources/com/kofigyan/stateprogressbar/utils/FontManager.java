package com.kofigyan.stateprogressbar.utils;

import android.content.Context;
import android.graphics.Typeface;
import java.util.HashMap;
import java.util.Map;

public class FontManager {
    private static final String FONTAWESOME = "fonts/fontawesome-webfont.ttf";
    private static final Map<String, Typeface> mFontCache;

    public FontManager() {
    }

    static {
        Map<String, Typeface> map;
        new HashMap();
        mFontCache = map;
    }

    public static Typeface getTypeface(Context context) {
        Context context2 = context;
        Typeface typeface = mFontCache.get(FONTAWESOME);
        if (typeface == null) {
            typeface = Typeface.createFromAsset(context2.getAssets(), FONTAWESOME);
            Typeface put = mFontCache.put(FONTAWESOME, typeface);
        }
        return typeface;
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.graphics.Typeface getTypeface(android.content.Context r9, java.lang.String r10) {
        /*
            r0 = r9
            r1 = r10
            java.util.Map<java.lang.String, android.graphics.Typeface> r5 = mFontCache
            r8 = r5
            r5 = r8
            r6 = r8
            r2 = r6
            monitor-enter(r5)
            java.util.Map<java.lang.String, android.graphics.Typeface> r5 = mFontCache     // Catch:{ Exception -> 0x0037 }
            r6 = r1
            boolean r5 = r5.containsKey(r6)     // Catch:{ Exception -> 0x0037 }
            if (r5 != 0) goto L_0x002a
            r5 = r0
            android.content.res.AssetManager r5 = r5.getAssets()     // Catch:{ Exception -> 0x0037 }
            r6 = r1
            android.graphics.Typeface r5 = android.graphics.Typeface.createFromAsset(r5, r6)     // Catch:{ Exception -> 0x0037 }
            r3 = r5
            java.util.Map<java.lang.String, android.graphics.Typeface> r5 = mFontCache     // Catch:{ Exception -> 0x0037 }
            r6 = r1
            r7 = r3
            java.lang.Object r5 = r5.put(r6, r7)     // Catch:{ Exception -> 0x0037 }
            r5 = r3
            r6 = r2
            monitor-exit(r6)     // Catch:{ all -> 0x006d }
            r0 = r5
        L_0x0029:
            return r0
        L_0x002a:
            java.util.Map<java.lang.String, android.graphics.Typeface> r5 = mFontCache     // Catch:{ all -> 0x006d }
            r6 = r1
            java.lang.Object r5 = r5.get(r6)     // Catch:{ all -> 0x006d }
            android.graphics.Typeface r5 = (android.graphics.Typeface) r5     // Catch:{ all -> 0x006d }
            r6 = r2
            monitor-exit(r6)     // Catch:{ all -> 0x006d }
            r0 = r5
            goto L_0x0029
        L_0x0037:
            r5 = move-exception
            r3 = r5
            java.lang.String r5 = "StateProgressBar"
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x006d }
            r8 = r6
            r6 = r8
            r7 = r8
            r7.<init>()     // Catch:{ all -> 0x006d }
            java.lang.String r7 = "Cannot create asset from "
            java.lang.StringBuilder r6 = r6.append(r7)     // Catch:{ all -> 0x006d }
            r7 = r1
            java.lang.StringBuilder r6 = r6.append(r7)     // Catch:{ all -> 0x006d }
            java.lang.String r7 = ". Ensure you have passed in the correct path and file name."
            java.lang.StringBuilder r6 = r6.append(r7)     // Catch:{ all -> 0x006d }
            java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x006d }
            r7 = r3
            int r5 = android.util.Log.w(r5, r6, r7)     // Catch:{ all -> 0x006d }
            java.util.Map<java.lang.String, android.graphics.Typeface> r5 = mFontCache     // Catch:{ all -> 0x006d }
            r6 = r1
            r7 = 0
            java.lang.Object r5 = r5.put(r6, r7)     // Catch:{ all -> 0x006d }
            r5 = 0
            r6 = r2
            monitor-exit(r6)     // Catch:{ all -> 0x006d }
            r0 = r5
            goto L_0x0029
        L_0x006d:
            r5 = move-exception
            r4 = r5
            r5 = r2
            monitor-exit(r5)     // Catch:{ all -> 0x006d }
            r5 = r4
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kofigyan.stateprogressbar.utils.FontManager.getTypeface(android.content.Context, java.lang.String):android.graphics.Typeface");
    }
}
