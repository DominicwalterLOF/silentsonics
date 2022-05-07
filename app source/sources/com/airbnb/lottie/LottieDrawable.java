package com.airbnb.lottie;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Typeface;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.airbnb.lottie.manager.FontAssetManager;
import com.airbnb.lottie.manager.ImageAssetManager;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.Marker;
import com.airbnb.lottie.model.layer.CompositionLayer;
import com.airbnb.lottie.parser.LayerParser;
import com.airbnb.lottie.utils.Logger;
import com.airbnb.lottie.utils.LottieValueAnimator;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.LottieFrameInfo;
import com.airbnb.lottie.value.LottieValueCallback;
import com.airbnb.lottie.value.SimpleLottieValueCallback;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class LottieDrawable extends Drawable implements Drawable.Callback, Animatable {
    public static final int INFINITE = -1;
    public static final int RESTART = 1;
    public static final int REVERSE = 2;
    private static final String TAG = LottieDrawable.class.getSimpleName();
    private int alpha;
    /* access modifiers changed from: private */
    public final LottieValueAnimator animator;
    private final Set<ColorFilterData> colorFilterData;
    private LottieComposition composition;
    /* access modifiers changed from: private */
    @Nullable
    public CompositionLayer compositionLayer;
    private boolean enableMergePaths;
    @Nullable
    FontAssetDelegate fontAssetDelegate;
    @Nullable
    private FontAssetManager fontAssetManager;
    @Nullable
    private ImageAssetDelegate imageAssetDelegate;
    @Nullable
    private ImageAssetManager imageAssetManager;
    @Nullable
    private String imageAssetsFolder;
    private boolean isDirty;
    private final ArrayList<LazyCompositionTask> lazyCompositionTasks;
    private final Matrix matrix;
    private boolean performanceTrackingEnabled;
    private float scale = 1.0f;
    private boolean systemAnimationsEnabled = true;
    @Nullable
    TextDelegate textDelegate;

    private interface LazyCompositionTask {
        void run(LottieComposition lottieComposition);
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface RepeatMode {
    }

    public LottieDrawable() {
        Matrix matrix2;
        LottieValueAnimator lottieValueAnimator;
        Set<ColorFilterData> set;
        ArrayList<LazyCompositionTask> arrayList;
        ValueAnimator.AnimatorUpdateListener animatorUpdateListener;
        new Matrix();
        this.matrix = matrix2;
        new LottieValueAnimator();
        this.animator = lottieValueAnimator;
        new HashSet();
        this.colorFilterData = set;
        new ArrayList<>();
        this.lazyCompositionTasks = arrayList;
        this.alpha = 255;
        this.isDirty = false;
        new ValueAnimator.AnimatorUpdateListener(this) {
            final /* synthetic */ LottieDrawable this$0;

            {
                this.this$0 = this$0;
            }

            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                ValueAnimator valueAnimator2 = valueAnimator;
                if (this.this$0.compositionLayer != null) {
                    this.this$0.compositionLayer.setProgress(this.this$0.animator.getAnimatedValueAbsolute());
                }
            }
        };
        this.animator.addUpdateListener(animatorUpdateListener);
    }

    public boolean hasMasks() {
        return this.compositionLayer != null && this.compositionLayer.hasMasks();
    }

    public boolean hasMatte() {
        return this.compositionLayer != null && this.compositionLayer.hasMatte();
    }

    public boolean enableMergePathsForKitKatAndAbove() {
        return this.enableMergePaths;
    }

    public void enableMergePathsForKitKatAndAbove(boolean z) {
        boolean enable = z;
        if (this.enableMergePaths != enable) {
            if (Build.VERSION.SDK_INT < 19) {
                Logger.warning("Merge paths are not supported pre-Kit Kat.");
                return;
            }
            this.enableMergePaths = enable;
            if (this.composition != null) {
                buildCompositionLayer();
            }
        }
    }

    public boolean isMergePathsEnabledForKitKatAndAbove() {
        return this.enableMergePaths;
    }

    public void setImagesAssetsFolder(@Nullable String imageAssetsFolder2) {
        String str = imageAssetsFolder2;
        this.imageAssetsFolder = str;
    }

    @Nullable
    public String getImageAssetsFolder() {
        return this.imageAssetsFolder;
    }

    public boolean setComposition(LottieComposition lottieComposition) {
        ArrayList arrayList;
        LottieComposition composition2 = lottieComposition;
        if (this.composition == composition2) {
            return false;
        }
        this.isDirty = false;
        clearComposition();
        this.composition = composition2;
        buildCompositionLayer();
        this.animator.setComposition(composition2);
        setProgress(this.animator.getAnimatedFraction());
        setScale(this.scale);
        updateBounds();
        new ArrayList(this.lazyCompositionTasks);
        Iterator<LazyCompositionTask> it = arrayList.iterator();
        while (it.hasNext()) {
            it.next().run(composition2);
            it.remove();
        }
        this.lazyCompositionTasks.clear();
        composition2.setPerformanceTrackingEnabled(this.performanceTrackingEnabled);
        return true;
    }

    public void setPerformanceTrackingEnabled(boolean z) {
        boolean enabled = z;
        this.performanceTrackingEnabled = enabled;
        if (this.composition != null) {
            this.composition.setPerformanceTrackingEnabled(enabled);
        }
    }

    @Nullable
    public PerformanceTracker getPerformanceTracker() {
        if (this.composition != null) {
            return this.composition.getPerformanceTracker();
        }
        return null;
    }

    private void buildCompositionLayer() {
        CompositionLayer compositionLayer2;
        new CompositionLayer(this, LayerParser.parse(this.composition), this.composition.getLayers(), this.composition);
        this.compositionLayer = compositionLayer2;
    }

    public void clearComposition() {
        if (this.animator.isRunning()) {
            this.animator.cancel();
        }
        this.composition = null;
        this.compositionLayer = null;
        this.imageAssetManager = null;
        this.animator.clearComposition();
        invalidateSelf();
    }

    public void invalidateSelf() {
        if (!this.isDirty) {
            this.isDirty = true;
            Drawable.Callback callback = getCallback();
            if (callback != null) {
                callback.invalidateDrawable(this);
            }
        }
    }

    public void setAlpha(@IntRange(from = 0, to = 255) int alpha2) {
        this.alpha = alpha2;
        invalidateSelf();
    }

    public int getAlpha() {
        return this.alpha;
    }

    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        ColorFilter colorFilter2 = colorFilter;
        Logger.warning("Use addColorFilter instead.");
    }

    public int getOpacity() {
        return -3;
    }

    public void draw(@NonNull Canvas canvas) {
        Canvas canvas2 = canvas;
        this.isDirty = false;
        L.beginSection("Drawable#draw");
        if (this.compositionLayer != null) {
            float scale2 = this.scale;
            float extraScale = 1.0f;
            float maxScale = getMaxScale(canvas2);
            if (scale2 > maxScale) {
                scale2 = maxScale;
                extraScale = this.scale / scale2;
            }
            int saveCount = -1;
            if (extraScale > 1.0f) {
                saveCount = canvas2.save();
                float halfWidth = ((float) this.composition.getBounds().width()) / 2.0f;
                float halfHeight = ((float) this.composition.getBounds().height()) / 2.0f;
                float scaledHalfWidth = halfWidth * scale2;
                float scaledHalfHeight = halfHeight * scale2;
                canvas2.translate((getScale() * halfWidth) - scaledHalfWidth, (getScale() * halfHeight) - scaledHalfHeight);
                canvas2.scale(extraScale, extraScale, scaledHalfWidth, scaledHalfHeight);
            }
            this.matrix.reset();
            boolean preScale = this.matrix.preScale(scale2, scale2);
            this.compositionLayer.draw(canvas2, this.matrix, this.alpha);
            float endSection = L.endSection("Drawable#draw");
            if (saveCount > 0) {
                canvas2.restoreToCount(saveCount);
            }
        }
    }

    @MainThread
    public void start() {
        playAnimation();
    }

    @MainThread
    public void stop() {
        endAnimation();
    }

    public boolean isRunning() {
        return isAnimating();
    }

    @MainThread
    public void playAnimation() {
        Object obj;
        if (this.compositionLayer == null) {
            new LazyCompositionTask(this) {
                final /* synthetic */ LottieDrawable this$0;

                {
                    this.this$0 = this$0;
                }

                public void run(LottieComposition lottieComposition) {
                    LottieComposition lottieComposition2 = lottieComposition;
                    this.this$0.playAnimation();
                }
            };
            boolean add = this.lazyCompositionTasks.add(obj);
            return;
        }
        if (this.systemAnimationsEnabled || getRepeatCount() == 0) {
            this.animator.playAnimation();
        }
        if (!this.systemAnimationsEnabled) {
            setFrame((int) (getSpeed() < 0.0f ? getMinFrame() : getMaxFrame()));
        }
    }

    @MainThread
    public void endAnimation() {
        this.lazyCompositionTasks.clear();
        this.animator.endAnimation();
    }

    @MainThread
    public void resumeAnimation() {
        Object obj;
        if (this.compositionLayer == null) {
            new LazyCompositionTask(this) {
                final /* synthetic */ LottieDrawable this$0;

                {
                    this.this$0 = this$0;
                }

                public void run(LottieComposition lottieComposition) {
                    LottieComposition lottieComposition2 = lottieComposition;
                    this.this$0.resumeAnimation();
                }
            };
            boolean add = this.lazyCompositionTasks.add(obj);
            return;
        }
        this.animator.resumeAnimation();
    }

    public void setMinFrame(int i) {
        Object obj;
        int minFrame = i;
        if (this.composition == null) {
            final int i2 = minFrame;
            new LazyCompositionTask(this) {
                final /* synthetic */ LottieDrawable this$0;

                {
                    this.this$0 = this$0;
                }

                public void run(LottieComposition lottieComposition) {
                    LottieComposition lottieComposition2 = lottieComposition;
                    this.this$0.setMinFrame(i2);
                }
            };
            boolean add = this.lazyCompositionTasks.add(obj);
            return;
        }
        this.animator.setMinFrame(minFrame);
    }

    public float getMinFrame() {
        return this.animator.getMinFrame();
    }

    public void setMinProgress(float f) {
        Object obj;
        float minProgress = f;
        if (this.composition == null) {
            final float f2 = minProgress;
            new LazyCompositionTask(this) {
                final /* synthetic */ LottieDrawable this$0;

                {
                    this.this$0 = this$0;
                }

                public void run(LottieComposition lottieComposition) {
                    LottieComposition lottieComposition2 = lottieComposition;
                    this.this$0.setMinProgress(f2);
                }
            };
            boolean add = this.lazyCompositionTasks.add(obj);
            return;
        }
        setMinFrame((int) MiscUtils.lerp(this.composition.getStartFrame(), this.composition.getEndFrame(), minProgress));
    }

    public void setMaxFrame(int i) {
        Object obj;
        int maxFrame = i;
        if (this.composition == null) {
            final int i2 = maxFrame;
            new LazyCompositionTask(this) {
                final /* synthetic */ LottieDrawable this$0;

                {
                    this.this$0 = this$0;
                }

                public void run(LottieComposition lottieComposition) {
                    LottieComposition lottieComposition2 = lottieComposition;
                    this.this$0.setMaxFrame(i2);
                }
            };
            boolean add = this.lazyCompositionTasks.add(obj);
            return;
        }
        this.animator.setMaxFrame(((float) maxFrame) + 0.99f);
    }

    public float getMaxFrame() {
        return this.animator.getMaxFrame();
    }

    public void setMaxProgress(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        Object obj;
        float maxProgress = f;
        if (this.composition == null) {
            final float f2 = maxProgress;
            new LazyCompositionTask(this) {
                final /* synthetic */ LottieDrawable this$0;

                {
                    this.this$0 = this$0;
                }

                public void run(LottieComposition lottieComposition) {
                    LottieComposition lottieComposition2 = lottieComposition;
                    this.this$0.setMaxProgress(f2);
                }
            };
            boolean add = this.lazyCompositionTasks.add(obj);
            return;
        }
        setMaxFrame((int) MiscUtils.lerp(this.composition.getStartFrame(), this.composition.getEndFrame(), maxProgress));
    }

    public void setMinFrame(String str) {
        Throwable th;
        StringBuilder sb;
        Object obj;
        String markerName = str;
        if (this.composition == null) {
            final String str2 = markerName;
            new LazyCompositionTask(this) {
                final /* synthetic */ LottieDrawable this$0;

                {
                    this.this$0 = this$0;
                }

                public void run(LottieComposition lottieComposition) {
                    LottieComposition lottieComposition2 = lottieComposition;
                    this.this$0.setMinFrame(str2);
                }
            };
            boolean add = this.lazyCompositionTasks.add(obj);
            return;
        }
        Marker marker = this.composition.getMarker(markerName);
        if (marker == null) {
            Throwable th2 = th;
            new StringBuilder();
            new IllegalArgumentException(sb.append("Cannot find marker with name ").append(markerName).append(".").toString());
            throw th2;
        }
        setMinFrame((int) marker.startFrame);
    }

    public void setMaxFrame(String str) {
        Throwable th;
        StringBuilder sb;
        Object obj;
        String markerName = str;
        if (this.composition == null) {
            final String str2 = markerName;
            new LazyCompositionTask(this) {
                final /* synthetic */ LottieDrawable this$0;

                {
                    this.this$0 = this$0;
                }

                public void run(LottieComposition lottieComposition) {
                    LottieComposition lottieComposition2 = lottieComposition;
                    this.this$0.setMaxFrame(str2);
                }
            };
            boolean add = this.lazyCompositionTasks.add(obj);
            return;
        }
        Marker marker = this.composition.getMarker(markerName);
        if (marker == null) {
            Throwable th2 = th;
            new StringBuilder();
            new IllegalArgumentException(sb.append("Cannot find marker with name ").append(markerName).append(".").toString());
            throw th2;
        }
        setMaxFrame((int) (marker.startFrame + marker.durationFrames));
    }

    public void setMinAndMaxFrame(String str) {
        Throwable th;
        StringBuilder sb;
        Object obj;
        String markerName = str;
        if (this.composition == null) {
            final String str2 = markerName;
            new LazyCompositionTask(this) {
                final /* synthetic */ LottieDrawable this$0;

                {
                    this.this$0 = this$0;
                }

                public void run(LottieComposition lottieComposition) {
                    LottieComposition lottieComposition2 = lottieComposition;
                    this.this$0.setMinAndMaxFrame(str2);
                }
            };
            boolean add = this.lazyCompositionTasks.add(obj);
            return;
        }
        Marker marker = this.composition.getMarker(markerName);
        if (marker == null) {
            Throwable th2 = th;
            new StringBuilder();
            new IllegalArgumentException(sb.append("Cannot find marker with name ").append(markerName).append(".").toString());
            throw th2;
        }
        int startFrame = (int) marker.startFrame;
        setMinAndMaxFrame(startFrame, startFrame + ((int) marker.durationFrames));
    }

    public void setMinAndMaxFrame(int i, int i2) {
        Object obj;
        int minFrame = i;
        int maxFrame = i2;
        if (this.composition == null) {
            final int i3 = minFrame;
            final int i4 = maxFrame;
            new LazyCompositionTask(this) {
                final /* synthetic */ LottieDrawable this$0;

                {
                    this.this$0 = this$0;
                }

                public void run(LottieComposition lottieComposition) {
                    LottieComposition lottieComposition2 = lottieComposition;
                    this.this$0.setMinAndMaxFrame(i3, i4);
                }
            };
            boolean add = this.lazyCompositionTasks.add(obj);
            return;
        }
        this.animator.setMinAndMaxFrames((float) minFrame, ((float) maxFrame) + 0.99f);
    }

    public void setMinAndMaxProgress(@FloatRange(from = 0.0d, to = 1.0d) float f, @FloatRange(from = 0.0d, to = 1.0d) float f2) {
        Object obj;
        float minProgress = f;
        float maxProgress = f2;
        if (this.composition == null) {
            final float f3 = minProgress;
            final float f4 = maxProgress;
            new LazyCompositionTask(this) {
                final /* synthetic */ LottieDrawable this$0;

                {
                    this.this$0 = this$0;
                }

                public void run(LottieComposition lottieComposition) {
                    LottieComposition lottieComposition2 = lottieComposition;
                    this.this$0.setMinAndMaxProgress(f3, f4);
                }
            };
            boolean add = this.lazyCompositionTasks.add(obj);
            return;
        }
        setMinAndMaxFrame((int) MiscUtils.lerp(this.composition.getStartFrame(), this.composition.getEndFrame(), minProgress), (int) MiscUtils.lerp(this.composition.getStartFrame(), this.composition.getEndFrame(), maxProgress));
    }

    public void reverseAnimationSpeed() {
        this.animator.reverseAnimationSpeed();
    }

    public void setSpeed(float speed) {
        this.animator.setSpeed(speed);
    }

    public float getSpeed() {
        return this.animator.getSpeed();
    }

    public void addAnimatorUpdateListener(ValueAnimator.AnimatorUpdateListener updateListener) {
        this.animator.addUpdateListener(updateListener);
    }

    public void removeAnimatorUpdateListener(ValueAnimator.AnimatorUpdateListener updateListener) {
        this.animator.removeUpdateListener(updateListener);
    }

    public void removeAllUpdateListeners() {
        this.animator.removeAllUpdateListeners();
    }

    public void addAnimatorListener(Animator.AnimatorListener listener) {
        this.animator.addListener(listener);
    }

    public void removeAnimatorListener(Animator.AnimatorListener listener) {
        this.animator.removeListener(listener);
    }

    public void removeAllAnimatorListeners() {
        this.animator.removeAllListeners();
    }

    public void setFrame(int i) {
        Object obj;
        int frame = i;
        if (this.composition == null) {
            final int i2 = frame;
            new LazyCompositionTask(this) {
                final /* synthetic */ LottieDrawable this$0;

                {
                    this.this$0 = this$0;
                }

                public void run(LottieComposition lottieComposition) {
                    LottieComposition lottieComposition2 = lottieComposition;
                    this.this$0.setFrame(i2);
                }
            };
            boolean add = this.lazyCompositionTasks.add(obj);
            return;
        }
        this.animator.setFrame(frame);
    }

    public int getFrame() {
        return (int) this.animator.getFrame();
    }

    public void setProgress(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        Object obj;
        float progress = f;
        if (this.composition == null) {
            final float f2 = progress;
            new LazyCompositionTask(this) {
                final /* synthetic */ LottieDrawable this$0;

                {
                    this.this$0 = this$0;
                }

                public void run(LottieComposition lottieComposition) {
                    LottieComposition lottieComposition2 = lottieComposition;
                    this.this$0.setProgress(f2);
                }
            };
            boolean add = this.lazyCompositionTasks.add(obj);
            return;
        }
        setFrame((int) MiscUtils.lerp(this.composition.getStartFrame(), this.composition.getEndFrame(), progress));
    }

    @Deprecated
    public void loop(boolean loop) {
        this.animator.setRepeatCount(loop ? -1 : 0);
    }

    public void setRepeatMode(int mode) {
        this.animator.setRepeatMode(mode);
    }

    public int getRepeatMode() {
        return this.animator.getRepeatMode();
    }

    public void setRepeatCount(int count) {
        this.animator.setRepeatCount(count);
    }

    public int getRepeatCount() {
        return this.animator.getRepeatCount();
    }

    public boolean isLooping() {
        return this.animator.getRepeatCount() == -1;
    }

    public boolean isAnimating() {
        return this.animator.isRunning();
    }

    /* access modifiers changed from: package-private */
    public void setSystemAnimationsAreEnabled(Boolean areEnabled) {
        boolean booleanValue = areEnabled.booleanValue();
        this.systemAnimationsEnabled = booleanValue;
    }

    public void setScale(float scale2) {
        this.scale = scale2;
        updateBounds();
    }

    public void setImageAssetDelegate(ImageAssetDelegate imageAssetDelegate2) {
        ImageAssetDelegate assetDelegate = imageAssetDelegate2;
        this.imageAssetDelegate = assetDelegate;
        if (this.imageAssetManager != null) {
            this.imageAssetManager.setDelegate(assetDelegate);
        }
    }

    public void setFontAssetDelegate(FontAssetDelegate fontAssetDelegate2) {
        FontAssetDelegate assetDelegate = fontAssetDelegate2;
        this.fontAssetDelegate = assetDelegate;
        if (this.fontAssetManager != null) {
            this.fontAssetManager.setDelegate(assetDelegate);
        }
    }

    public void setTextDelegate(TextDelegate textDelegate2) {
        TextDelegate textDelegate3 = textDelegate2;
        this.textDelegate = textDelegate3;
    }

    @Nullable
    public TextDelegate getTextDelegate() {
        return this.textDelegate;
    }

    public boolean useTextGlyphs() {
        return this.textDelegate == null && this.composition.getCharacters().size() > 0;
    }

    public float getScale() {
        return this.scale;
    }

    public LottieComposition getComposition() {
        return this.composition;
    }

    private void updateBounds() {
        if (this.composition != null) {
            float scale2 = getScale();
            setBounds(0, 0, (int) (((float) this.composition.getBounds().width()) * scale2), (int) (((float) this.composition.getBounds().height()) * scale2));
        }
    }

    public void cancelAnimation() {
        this.lazyCompositionTasks.clear();
        this.animator.cancel();
    }

    public void pauseAnimation() {
        this.lazyCompositionTasks.clear();
        this.animator.pauseAnimation();
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    public float getProgress() {
        return this.animator.getAnimatedValueAbsolute();
    }

    public int getIntrinsicWidth() {
        return this.composition == null ? -1 : (int) (((float) this.composition.getBounds().width()) * getScale());
    }

    public int getIntrinsicHeight() {
        return this.composition == null ? -1 : (int) (((float) this.composition.getBounds().height()) * getScale());
    }

    public List<KeyPath> resolveKeyPath(KeyPath keyPath) {
        List<KeyPath> list;
        KeyPath keyPath2;
        KeyPath keyPath3 = keyPath;
        if (this.compositionLayer == null) {
            Logger.warning("Cannot resolve KeyPath. Composition is not set yet.");
            return Collections.emptyList();
        }
        new ArrayList();
        List<KeyPath> keyPaths = list;
        new KeyPath(new String[0]);
        this.compositionLayer.resolveKeyPath(keyPath3, 0, keyPaths, keyPath2);
        return keyPaths;
    }

    public <T> void addValueCallback(KeyPath keyPath, T t, LottieValueCallback<T> lottieValueCallback) {
        boolean invalidate;
        Object obj;
        KeyPath keyPath2 = keyPath;
        T property = t;
        LottieValueCallback<T> callback = lottieValueCallback;
        if (this.compositionLayer == null) {
            final KeyPath keyPath3 = keyPath2;
            final T t2 = property;
            final LottieValueCallback<T> lottieValueCallback2 = callback;
            new LazyCompositionTask(this) {
                final /* synthetic */ LottieDrawable this$0;

                {
                    this.this$0 = this$0;
                }

                public void run(LottieComposition lottieComposition) {
                    LottieComposition lottieComposition2 = lottieComposition;
                    this.this$0.addValueCallback(keyPath3, t2, lottieValueCallback2);
                }
            };
            boolean add = this.lazyCompositionTasks.add(obj);
            return;
        }
        if (keyPath2.getResolvedElement() != null) {
            keyPath2.getResolvedElement().addValueCallback(property, callback);
            invalidate = true;
        } else {
            List<KeyPath> elements = resolveKeyPath(keyPath2);
            for (int i = 0; i < elements.size(); i++) {
                elements.get(i).getResolvedElement().addValueCallback(property, callback);
            }
            invalidate = !elements.isEmpty();
        }
        if (invalidate) {
            invalidateSelf();
            if (property == LottieProperty.TIME_REMAP) {
                setProgress(getProgress());
            }
        }
    }

    public <T> void addValueCallback(KeyPath keyPath, T property, SimpleLottieValueCallback<T> callback) {
        LottieValueCallback lottieValueCallback;
        final SimpleLottieValueCallback<T> simpleLottieValueCallback = callback;
        new LottieValueCallback<T>(this) {
            final /* synthetic */ LottieDrawable this$0;

            {
                this.this$0 = this$0;
            }

            public T getValue(LottieFrameInfo<T> frameInfo) {
                return simpleLottieValueCallback.getValue(frameInfo);
            }
        };
        addValueCallback(keyPath, property, lottieValueCallback);
    }

    @Nullable
    public Bitmap updateBitmap(String str, @Nullable Bitmap bitmap) {
        String id = str;
        Bitmap bitmap2 = bitmap;
        ImageAssetManager bm = getImageAssetManager();
        if (bm == null) {
            Logger.warning("Cannot update bitmap. Most likely the drawable is not added to a View which prevents Lottie from getting a Context.");
            return null;
        }
        Bitmap ret = bm.updateBitmap(id, bitmap2);
        invalidateSelf();
        return ret;
    }

    @Nullable
    public Bitmap getImageAsset(String str) {
        String id = str;
        ImageAssetManager bm = getImageAssetManager();
        if (bm != null) {
            return bm.bitmapForId(id);
        }
        return null;
    }

    private ImageAssetManager getImageAssetManager() {
        ImageAssetManager imageAssetManager2;
        if (getCallback() == null) {
            return null;
        }
        if (this.imageAssetManager != null && !this.imageAssetManager.hasSameContext(getContext())) {
            this.imageAssetManager = null;
        }
        if (this.imageAssetManager == null) {
            new ImageAssetManager(getCallback(), this.imageAssetsFolder, this.imageAssetDelegate, this.composition.getImages());
            this.imageAssetManager = imageAssetManager2;
        }
        return this.imageAssetManager;
    }

    @Nullable
    public Typeface getTypeface(String str, String str2) {
        String fontFamily = str;
        String style = str2;
        FontAssetManager assetManager = getFontAssetManager();
        if (assetManager != null) {
            return assetManager.getTypeface(fontFamily, style);
        }
        return null;
    }

    private FontAssetManager getFontAssetManager() {
        FontAssetManager fontAssetManager2;
        if (getCallback() == null) {
            return null;
        }
        if (this.fontAssetManager == null) {
            new FontAssetManager(getCallback(), this.fontAssetDelegate);
            this.fontAssetManager = fontAssetManager2;
        }
        return this.fontAssetManager;
    }

    @Nullable
    private Context getContext() {
        Drawable.Callback callback = getCallback();
        if (callback == null) {
            return null;
        }
        if (callback instanceof View) {
            return ((View) callback).getContext();
        }
        return null;
    }

    public void invalidateDrawable(@NonNull Drawable drawable) {
        Drawable drawable2 = drawable;
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    public void scheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable, long j) {
        Drawable drawable2 = drawable;
        Runnable what = runnable;
        long when = j;
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.scheduleDrawable(this, what, when);
        }
    }

    public void unscheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable) {
        Drawable drawable2 = drawable;
        Runnable what = runnable;
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.unscheduleDrawable(this, what);
        }
    }

    private float getMaxScale(@NonNull Canvas canvas) {
        Canvas canvas2 = canvas;
        return Math.min(((float) canvas2.getWidth()) / ((float) this.composition.getBounds().width()), ((float) canvas2.getHeight()) / ((float) this.composition.getBounds().height()));
    }

    private static class ColorFilterData {
        @Nullable
        final ColorFilter colorFilter;
        @Nullable
        final String contentName;
        final String layerName;

        ColorFilterData(@Nullable String layerName2, @Nullable String contentName2, @Nullable ColorFilter colorFilter2) {
            this.layerName = layerName2;
            this.contentName = contentName2;
            this.colorFilter = colorFilter2;
        }

        public int hashCode() {
            int hashCode = 17;
            if (this.layerName != null) {
                hashCode = 17 * 31 * this.layerName.hashCode();
            }
            if (this.contentName != null) {
                hashCode = hashCode * 31 * this.contentName.hashCode();
            }
            return hashCode;
        }

        public boolean equals(Object obj) {
            Object obj2 = obj;
            if (this == obj2) {
                return true;
            }
            if (!(obj2 instanceof ColorFilterData)) {
                return false;
            }
            ColorFilterData other = (ColorFilterData) obj2;
            return hashCode() == other.hashCode() && this.colorFilter == other.colorFilter;
        }
    }
}
