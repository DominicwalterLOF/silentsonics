package com.airbnb.lottie.manager;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import androidx.annotation.Nullable;
import com.airbnb.lottie.ImageAssetDelegate;
import com.airbnb.lottie.LottieImageAsset;
import com.airbnb.lottie.utils.Logger;
import com.airbnb.lottie.utils.Utils;
import com.google.appinventor.components.common.ComponentConstants;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ImageAssetManager {
    private static final Object bitmapHashLock;
    private final Context context;
    @Nullable
    private ImageAssetDelegate delegate;
    private final Map<String, LottieImageAsset> imageAssets;
    private String imagesFolder;

    static {
        Object obj;
        new Object();
        bitmapHashLock = obj;
    }

    public ImageAssetManager(Drawable.Callback callback, String str, ImageAssetDelegate imageAssetDelegate, Map<String, LottieImageAsset> map) {
        Map<String, LottieImageAsset> map2;
        StringBuilder sb;
        Drawable.Callback callback2 = callback;
        String imagesFolder2 = str;
        ImageAssetDelegate delegate2 = imageAssetDelegate;
        Map<String, LottieImageAsset> imageAssets2 = map;
        this.imagesFolder = imagesFolder2;
        if (!TextUtils.isEmpty(imagesFolder2) && this.imagesFolder.charAt(this.imagesFolder.length() - 1) != '/') {
            new StringBuilder();
            this.imagesFolder = sb.append(this.imagesFolder).append('/').toString();
        }
        if (!(callback2 instanceof View)) {
            Logger.warning("LottieDrawable must be inside of a view for images to work.");
            new HashMap();
            this.imageAssets = map2;
            this.context = null;
            return;
        }
        this.context = ((View) callback2).getContext();
        this.imageAssets = imageAssets2;
        setDelegate(delegate2);
    }

    public void setDelegate(@Nullable ImageAssetDelegate assetDelegate) {
        ImageAssetDelegate imageAssetDelegate = assetDelegate;
        this.delegate = imageAssetDelegate;
    }

    @Nullable
    public Bitmap updateBitmap(String str, @Nullable Bitmap bitmap) {
        String id = str;
        Bitmap bitmap2 = bitmap;
        if (bitmap2 == null) {
            LottieImageAsset asset = this.imageAssets.get(id);
            Bitmap ret = asset.getBitmap();
            asset.setBitmap((Bitmap) null);
            return ret;
        }
        Bitmap prevBitmap = this.imageAssets.get(id).getBitmap();
        Bitmap putBitmap = putBitmap(id, bitmap2);
        return prevBitmap;
    }

    @Nullable
    public Bitmap bitmapForId(String str) {
        BitmapFactory.Options options;
        StringBuilder sb;
        Throwable th;
        String id = str;
        LottieImageAsset asset = this.imageAssets.get(id);
        if (asset == null) {
            return null;
        }
        Bitmap bitmap = asset.getBitmap();
        if (bitmap != null) {
            return bitmap;
        }
        if (this.delegate != null) {
            Bitmap bitmap2 = this.delegate.fetchBitmap(asset);
            if (bitmap2 != null) {
                Bitmap putBitmap = putBitmap(id, bitmap2);
            }
            return bitmap2;
        }
        String filename = asset.getFileName();
        new BitmapFactory.Options();
        BitmapFactory.Options opts = options;
        opts.inScaled = true;
        opts.inDensity = ComponentConstants.TEXTBOX_PREFERRED_WIDTH;
        if (!filename.startsWith("data:") || filename.indexOf("base64,") <= 0) {
            try {
                if (TextUtils.isEmpty(this.imagesFolder)) {
                    Throwable th2 = th;
                    new IllegalStateException("You must set an images folder before loading an image. Set it with LottieComposition#setImagesFolder or LottieDrawable#setImagesFolder");
                    throw th2;
                }
                AssetManager assets = this.context.getAssets();
                new StringBuilder();
                return putBitmap(id, Utils.resizeBitmapIfNeeded(BitmapFactory.decodeStream(assets.open(sb.append(this.imagesFolder).append(filename).toString()), (Rect) null, opts), asset.getWidth(), asset.getHeight()));
            } catch (IOException e) {
                Logger.warning("Unable to open asset.", e);
                return null;
            }
        } else {
            try {
                byte[] data = Base64.decode(filename.substring(filename.indexOf(44) + 1), 0);
                return putBitmap(id, BitmapFactory.decodeByteArray(data, 0, data.length, opts));
            } catch (IllegalArgumentException e2) {
                Logger.warning("data URL did not have correct base64 format.", e2);
                return null;
            }
        }
    }

    public boolean hasSameContext(Context context2) {
        Context context3 = context2;
        return (context3 == null && this.context == null) || this.context.equals(context3);
    }

    private Bitmap putBitmap(String str, @Nullable Bitmap bitmap) {
        String key = str;
        Bitmap bitmap2 = bitmap;
        Object obj = bitmapHashLock;
        Object obj2 = obj;
        synchronized (obj) {
            try {
                this.imageAssets.get(key).setBitmap(bitmap2);
                Bitmap bitmap3 = bitmap2;
                return bitmap3;
            } catch (Throwable th) {
                Throwable th2 = th;
                Object obj3 = obj2;
                throw th2;
            }
        }
    }
}
