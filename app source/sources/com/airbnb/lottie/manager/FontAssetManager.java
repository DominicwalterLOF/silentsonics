package com.airbnb.lottie.manager;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.annotation.Nullable;
import com.airbnb.lottie.FontAssetDelegate;
import com.airbnb.lottie.model.MutablePair;
import com.airbnb.lottie.utils.Logger;
import java.util.HashMap;
import java.util.Map;

public class FontAssetManager {
    private final AssetManager assetManager;
    private String defaultFontFileExtension = ".ttf";
    @Nullable
    private FontAssetDelegate delegate;
    private final Map<String, Typeface> fontFamilies;
    private final Map<MutablePair<String>, Typeface> fontMap;
    private final MutablePair<String> tempPair;

    public FontAssetManager(Drawable.Callback callback, @Nullable FontAssetDelegate delegate2) {
        MutablePair<String> mutablePair;
        Map<MutablePair<String>, Typeface> map;
        Map<String, Typeface> map2;
        Drawable.Callback callback2 = callback;
        new MutablePair<>();
        this.tempPair = mutablePair;
        new HashMap();
        this.fontMap = map;
        new HashMap();
        this.fontFamilies = map2;
        this.delegate = delegate2;
        if (!(callback2 instanceof View)) {
            Logger.warning("LottieDrawable must be inside of a view for images to work.");
            this.assetManager = null;
            return;
        }
        this.assetManager = ((View) callback2).getContext().getAssets();
    }

    public void setDelegate(@Nullable FontAssetDelegate assetDelegate) {
        FontAssetDelegate fontAssetDelegate = assetDelegate;
        this.delegate = fontAssetDelegate;
    }

    public void setDefaultFontFileExtension(String defaultFontFileExtension2) {
        String str = defaultFontFileExtension2;
        this.defaultFontFileExtension = str;
    }

    public Typeface getTypeface(String str, String str2) {
        String fontFamily = str;
        String style = str2;
        this.tempPair.set(fontFamily, style);
        Typeface typeface = this.fontMap.get(this.tempPair);
        if (typeface != null) {
            return typeface;
        }
        Typeface typeface2 = typefaceForStyle(getFontFamily(fontFamily), style);
        Typeface put = this.fontMap.put(this.tempPair, typeface2);
        return typeface2;
    }

    private Typeface getFontFamily(String str) {
        StringBuilder sb;
        String path;
        String fontFamily = str;
        Typeface defaultTypeface = this.fontFamilies.get(fontFamily);
        if (defaultTypeface != null) {
            return defaultTypeface;
        }
        Typeface typeface = null;
        if (this.delegate != null) {
            typeface = this.delegate.fetchFont(fontFamily);
        }
        if (!(this.delegate == null || typeface != null || (path = this.delegate.getFontPath(fontFamily)) == null)) {
            typeface = Typeface.createFromAsset(this.assetManager, path);
        }
        if (typeface == null) {
            new StringBuilder();
            typeface = Typeface.createFromAsset(this.assetManager, sb.append("fonts/").append(fontFamily).append(this.defaultFontFileExtension).toString());
        }
        Typeface put = this.fontFamilies.put(fontFamily, typeface);
        return typeface;
    }

    private Typeface typefaceForStyle(Typeface typeface, String str) {
        Typeface typeface2 = typeface;
        String style = str;
        int styleInt = 0;
        boolean containsItalic = style.contains("Italic");
        boolean containsBold = style.contains("Bold");
        if (containsItalic && containsBold) {
            styleInt = 3;
        } else if (containsItalic) {
            styleInt = 2;
        } else if (containsBold) {
            styleInt = 1;
        }
        if (typeface2.getStyle() == styleInt) {
            return typeface2;
        }
        return Typeface.create(typeface2, styleInt);
    }
}
