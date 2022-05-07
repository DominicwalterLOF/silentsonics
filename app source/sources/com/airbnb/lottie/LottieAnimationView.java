package com.airbnb.lottie;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.JsonReader;
import android.util.Log;
import android.view.View;
import androidx.annotation.FloatRange;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RawRes;
import androidx.appcompat.widget.AppCompatImageView;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.utils.Utils;
import com.airbnb.lottie.value.LottieFrameInfo;
import com.airbnb.lottie.value.LottieValueCallback;
import com.airbnb.lottie.value.SimpleLottieValueCallback;
import java.io.Reader;
import java.io.StringReader;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottieAnimationView extends AppCompatImageView {
    private static final String TAG = LottieAnimationView.class.getSimpleName();
    private String animationName;
    @RawRes
    private int animationResId;
    private boolean autoPlay = false;
    @Nullable
    private LottieComposition composition;
    @Nullable
    private LottieTask<LottieComposition> compositionTask;
    private final LottieListener<Throwable> failureListener;
    private final LottieListener<LottieComposition> loadedListener;
    private final LottieDrawable lottieDrawable;
    private Set<LottieOnCompositionLoadedListener> lottieOnCompositionLoadedListeners;
    private RenderMode renderMode = RenderMode.AUTOMATIC;
    private boolean wasAnimatingWhenDetached = false;
    private boolean wasAnimatingWhenNotShown = false;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LottieAnimationView(Context context) {
        super(context);
        LottieListener<LottieComposition> lottieListener;
        LottieListener<Throwable> lottieListener2;
        LottieDrawable lottieDrawable2;
        Set<LottieOnCompositionLoadedListener> set;
        new LottieListener<LottieComposition>(this) {
            final /* synthetic */ LottieAnimationView this$0;

            {
                this.this$0 = this$0;
            }

            public void onResult(LottieComposition composition) {
                this.this$0.setComposition(composition);
            }
        };
        this.loadedListener = lottieListener;
        new LottieListener<Throwable>(this) {
            final /* synthetic */ LottieAnimationView this$0;

            {
                this.this$0 = this$0;
            }

            public void onResult(Throwable throwable) {
                Throwable th;
                Throwable th2 = th;
                new IllegalStateException("Unable to parse composition", throwable);
                throw th2;
            }
        };
        this.failureListener = lottieListener2;
        new LottieDrawable();
        this.lottieDrawable = lottieDrawable2;
        new HashSet();
        this.lottieOnCompositionLoadedListeners = set;
        init((AttributeSet) null);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public LottieAnimationView(android.content.Context r9, android.util.AttributeSet r10) {
        /*
            r8 = this;
            r0 = r8
            r1 = r9
            r2 = r10
            r3 = r0
            r4 = r1
            r5 = r2
            r3.<init>(r4, r5)
            r3 = r0
            com.airbnb.lottie.LottieAnimationView$1 r4 = new com.airbnb.lottie.LottieAnimationView$1
            r7 = r4
            r4 = r7
            r5 = r7
            r6 = r0
            r5.<init>(r6)
            r3.loadedListener = r4
            r3 = r0
            com.airbnb.lottie.LottieAnimationView$2 r4 = new com.airbnb.lottie.LottieAnimationView$2
            r7 = r4
            r4 = r7
            r5 = r7
            r6 = r0
            r5.<init>(r6)
            r3.failureListener = r4
            r3 = r0
            com.airbnb.lottie.LottieDrawable r4 = new com.airbnb.lottie.LottieDrawable
            r7 = r4
            r4 = r7
            r5 = r7
            r5.<init>()
            r3.lottieDrawable = r4
            r3 = r0
            r4 = 0
            r3.wasAnimatingWhenNotShown = r4
            r3 = r0
            r4 = 0
            r3.wasAnimatingWhenDetached = r4
            r3 = r0
            r4 = 0
            r3.autoPlay = r4
            r3 = r0
            com.airbnb.lottie.RenderMode r4 = com.airbnb.lottie.RenderMode.AUTOMATIC
            r3.renderMode = r4
            r3 = r0
            java.util.HashSet r4 = new java.util.HashSet
            r7 = r4
            r4 = r7
            r5 = r7
            r5.<init>()
            r3.lottieOnCompositionLoadedListeners = r4
            r3 = r0
            r4 = r2
            r3.init(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.LottieAnimationView.<init>(android.content.Context, android.util.AttributeSet):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public LottieAnimationView(android.content.Context r10, android.util.AttributeSet r11, int r12) {
        /*
            r9 = this;
            r0 = r9
            r1 = r10
            r2 = r11
            r3 = r12
            r4 = r0
            r5 = r1
            r6 = r2
            r7 = r3
            r4.<init>(r5, r6, r7)
            r4 = r0
            com.airbnb.lottie.LottieAnimationView$1 r5 = new com.airbnb.lottie.LottieAnimationView$1
            r8 = r5
            r5 = r8
            r6 = r8
            r7 = r0
            r6.<init>(r7)
            r4.loadedListener = r5
            r4 = r0
            com.airbnb.lottie.LottieAnimationView$2 r5 = new com.airbnb.lottie.LottieAnimationView$2
            r8 = r5
            r5 = r8
            r6 = r8
            r7 = r0
            r6.<init>(r7)
            r4.failureListener = r5
            r4 = r0
            com.airbnb.lottie.LottieDrawable r5 = new com.airbnb.lottie.LottieDrawable
            r8 = r5
            r5 = r8
            r6 = r8
            r6.<init>()
            r4.lottieDrawable = r5
            r4 = r0
            r5 = 0
            r4.wasAnimatingWhenNotShown = r5
            r4 = r0
            r5 = 0
            r4.wasAnimatingWhenDetached = r5
            r4 = r0
            r5 = 0
            r4.autoPlay = r5
            r4 = r0
            com.airbnb.lottie.RenderMode r5 = com.airbnb.lottie.RenderMode.AUTOMATIC
            r4.renderMode = r5
            r4 = r0
            java.util.HashSet r5 = new java.util.HashSet
            r8 = r5
            r5 = r8
            r6 = r8
            r6.<init>()
            r4.lottieOnCompositionLoadedListeners = r5
            r4 = r0
            r5 = r2
            r4.init(r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.LottieAnimationView.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    private void init(@Nullable AttributeSet attrs) {
        SimpleColorFilter filter;
        KeyPath keyPath;
        LottieValueCallback lottieValueCallback;
        String url;
        Throwable th;
        TypedArray ta = getContext().obtainStyledAttributes(attrs, R.styleable.LottieAnimationView);
        if (!isInEditMode()) {
            boolean hasRawRes = ta.hasValue(R.styleable.LottieAnimationView_lottie_rawRes);
            boolean hasFileName = ta.hasValue(R.styleable.LottieAnimationView_lottie_fileName);
            boolean hasUrl = ta.hasValue(R.styleable.LottieAnimationView_lottie_url);
            if (hasRawRes && hasFileName) {
                Throwable th2 = th;
                new IllegalArgumentException("lottie_rawRes and lottie_fileName cannot be used at the same time. Please use only one at once.");
                throw th2;
            } else if (hasRawRes) {
                int rawResId = ta.getResourceId(R.styleable.LottieAnimationView_lottie_rawRes, 0);
                if (rawResId != 0) {
                    setAnimation(rawResId);
                }
            } else if (hasFileName) {
                String fileName = ta.getString(R.styleable.LottieAnimationView_lottie_fileName);
                if (fileName != null) {
                    setAnimation(fileName);
                }
            } else if (hasUrl && (url = ta.getString(R.styleable.LottieAnimationView_lottie_url)) != null) {
                setAnimationFromUrl(url);
            }
        }
        if (ta.getBoolean(R.styleable.LottieAnimationView_lottie_autoPlay, false)) {
            this.wasAnimatingWhenDetached = true;
            this.autoPlay = true;
        }
        if (ta.getBoolean(R.styleable.LottieAnimationView_lottie_loop, false)) {
            this.lottieDrawable.setRepeatCount(-1);
        }
        if (ta.hasValue(R.styleable.LottieAnimationView_lottie_repeatMode)) {
            setRepeatMode(ta.getInt(R.styleable.LottieAnimationView_lottie_repeatMode, 1));
        }
        if (ta.hasValue(R.styleable.LottieAnimationView_lottie_repeatCount)) {
            setRepeatCount(ta.getInt(R.styleable.LottieAnimationView_lottie_repeatCount, -1));
        }
        if (ta.hasValue(R.styleable.LottieAnimationView_lottie_speed)) {
            setSpeed(ta.getFloat(R.styleable.LottieAnimationView_lottie_speed, 1.0f));
        }
        setImageAssetsFolder(ta.getString(R.styleable.LottieAnimationView_lottie_imageAssetsFolder));
        setProgress(ta.getFloat(R.styleable.LottieAnimationView_lottie_progress, 0.0f));
        enableMergePathsForKitKatAndAbove(ta.getBoolean(R.styleable.LottieAnimationView_lottie_enableMergePathsForKitKatAndAbove, false));
        if (ta.hasValue(R.styleable.LottieAnimationView_lottie_colorFilter)) {
            new SimpleColorFilter(ta.getColor(R.styleable.LottieAnimationView_lottie_colorFilter, 0));
            new KeyPath("**");
            new LottieValueCallback(filter);
            addValueCallback(keyPath, LottieProperty.COLOR_FILTER, lottieValueCallback);
        }
        if (ta.hasValue(R.styleable.LottieAnimationView_lottie_scale)) {
            this.lottieDrawable.setScale(ta.getFloat(R.styleable.LottieAnimationView_lottie_scale, 1.0f));
        }
        ta.recycle();
        this.lottieDrawable.setSystemAnimationsAreEnabled(Boolean.valueOf(Utils.getAnimationScale(getContext()) != 0.0f));
        enableOrDisableHardwareLayer();
    }

    public void setImageResource(int resId) {
        cancelLoaderTask();
        super.setImageResource(resId);
    }

    public void setImageDrawable(Drawable drawable) {
        cancelLoaderTask();
        super.setImageDrawable(drawable);
    }

    public void setImageBitmap(Bitmap bm) {
        cancelLoaderTask();
        super.setImageBitmap(bm);
    }

    public void invalidateDrawable(@NonNull Drawable drawable) {
        Drawable dr = drawable;
        if (getDrawable() == this.lottieDrawable) {
            super.invalidateDrawable(this.lottieDrawable);
        } else {
            super.invalidateDrawable(dr);
        }
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        SavedState savedState;
        new SavedState(super.onSaveInstanceState());
        SavedState ss = savedState;
        ss.animationName = this.animationName;
        ss.animationResId = this.animationResId;
        ss.progress = this.lottieDrawable.getProgress();
        ss.isAnimating = this.lottieDrawable.isAnimating();
        ss.imageAssetsFolder = this.lottieDrawable.getImageAssetsFolder();
        ss.repeatMode = this.lottieDrawable.getRepeatMode();
        ss.repeatCount = this.lottieDrawable.getRepeatCount();
        return ss;
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        Parcelable state = parcelable;
        if (!(state instanceof SavedState)) {
            super.onRestoreInstanceState(state);
            return;
        }
        SavedState ss = (SavedState) state;
        super.onRestoreInstanceState(ss.getSuperState());
        this.animationName = ss.animationName;
        if (!TextUtils.isEmpty(this.animationName)) {
            setAnimation(this.animationName);
        }
        this.animationResId = ss.animationResId;
        if (this.animationResId != 0) {
            setAnimation(this.animationResId);
        }
        setProgress(ss.progress);
        if (ss.isAnimating) {
            playAnimation();
        }
        this.lottieDrawable.setImagesAssetsFolder(ss.imageAssetsFolder);
        setRepeatMode(ss.repeatMode);
        setRepeatCount(ss.repeatCount);
    }

    /* access modifiers changed from: protected */
    public void onVisibilityChanged(@NonNull View view, int i) {
        View view2 = view;
        int i2 = i;
        if (this.lottieDrawable != null) {
            if (isShown()) {
                if (this.wasAnimatingWhenNotShown) {
                    resumeAnimation();
                    this.wasAnimatingWhenNotShown = false;
                }
            } else if (isAnimating()) {
                pauseAnimation();
                this.wasAnimatingWhenNotShown = true;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.autoPlay && this.wasAnimatingWhenDetached) {
            playAnimation();
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        if (isAnimating()) {
            cancelAnimation();
            this.wasAnimatingWhenDetached = true;
        }
        super.onDetachedFromWindow();
    }

    public void enableMergePathsForKitKatAndAbove(boolean enable) {
        this.lottieDrawable.enableMergePathsForKitKatAndAbove(enable);
    }

    public boolean isMergePathsEnabledForKitKatAndAbove() {
        return this.lottieDrawable.isMergePathsEnabledForKitKatAndAbove();
    }

    public void setAnimation(@RawRes int i) {
        int rawRes = i;
        this.animationResId = rawRes;
        this.animationName = null;
        setCompositionTask(LottieCompositionFactory.fromRawRes(getContext(), rawRes));
    }

    public void setAnimation(String str) {
        String assetName = str;
        this.animationName = assetName;
        this.animationResId = 0;
        setCompositionTask(LottieCompositionFactory.fromAsset(getContext(), assetName));
    }

    @Deprecated
    public void setAnimationFromJson(String jsonString) {
        setAnimationFromJson(jsonString, (String) null);
    }

    public void setAnimationFromJson(String jsonString, @Nullable String cacheKey) {
        JsonReader jsonReader;
        Reader reader;
        new StringReader(jsonString);
        new JsonReader(reader);
        setAnimation(jsonReader, cacheKey);
    }

    public void setAnimation(JsonReader reader, @Nullable String cacheKey) {
        setCompositionTask(LottieCompositionFactory.fromJsonReader(reader, cacheKey));
    }

    public void setAnimationFromUrl(String url) {
        setCompositionTask(LottieCompositionFactory.fromUrl(getContext(), url));
    }

    private void setCompositionTask(LottieTask<LottieComposition> compositionTask2) {
        clearComposition();
        cancelLoaderTask();
        this.compositionTask = compositionTask2.addListener(this.loadedListener).addFailureListener(this.failureListener);
    }

    private void cancelLoaderTask() {
        if (this.compositionTask != null) {
            LottieTask<LottieComposition> removeListener = this.compositionTask.removeListener(this.loadedListener);
            LottieTask<LottieComposition> removeFailureListener = this.compositionTask.removeFailureListener(this.failureListener);
        }
    }

    public void setComposition(@NonNull LottieComposition lottieComposition) {
        StringBuilder sb;
        LottieComposition composition2 = lottieComposition;
        if (L.DBG) {
            String str = TAG;
            new StringBuilder();
            int v = Log.v(str, sb.append("Set Composition \n").append(composition2).toString());
        }
        this.lottieDrawable.setCallback(this);
        this.composition = composition2;
        boolean isNewComposition = this.lottieDrawable.setComposition(composition2);
        enableOrDisableHardwareLayer();
        if (getDrawable() != this.lottieDrawable || isNewComposition) {
            setImageDrawable((Drawable) null);
            setImageDrawable(this.lottieDrawable);
            requestLayout();
            for (LottieOnCompositionLoadedListener lottieOnCompositionLoadedListener : this.lottieOnCompositionLoadedListeners) {
                lottieOnCompositionLoadedListener.onCompositionLoaded(composition2);
            }
        }
    }

    @Nullable
    public LottieComposition getComposition() {
        return this.composition;
    }

    public boolean hasMasks() {
        return this.lottieDrawable.hasMasks();
    }

    public boolean hasMatte() {
        return this.lottieDrawable.hasMatte();
    }

    @MainThread
    public void playAnimation() {
        if (isShown()) {
            this.lottieDrawable.playAnimation();
            enableOrDisableHardwareLayer();
            return;
        }
        this.wasAnimatingWhenNotShown = true;
    }

    @MainThread
    public void resumeAnimation() {
        if (isShown()) {
            this.lottieDrawable.resumeAnimation();
            enableOrDisableHardwareLayer();
            return;
        }
        this.wasAnimatingWhenNotShown = true;
    }

    public void setMinFrame(int startFrame) {
        this.lottieDrawable.setMinFrame(startFrame);
    }

    public float getMinFrame() {
        return this.lottieDrawable.getMinFrame();
    }

    public void setMinProgress(float startProgress) {
        this.lottieDrawable.setMinProgress(startProgress);
    }

    public void setMaxFrame(int endFrame) {
        this.lottieDrawable.setMaxFrame(endFrame);
    }

    public float getMaxFrame() {
        return this.lottieDrawable.getMaxFrame();
    }

    public void setMaxProgress(@FloatRange(from = 0.0d, to = 1.0d) float endProgress) {
        this.lottieDrawable.setMaxProgress(endProgress);
    }

    public void setMinFrame(String markerName) {
        this.lottieDrawable.setMinFrame(markerName);
    }

    public void setMaxFrame(String markerName) {
        this.lottieDrawable.setMaxFrame(markerName);
    }

    public void setMinAndMaxFrame(String markerName) {
        this.lottieDrawable.setMinAndMaxFrame(markerName);
    }

    public void setMinAndMaxFrame(int minFrame, int maxFrame) {
        this.lottieDrawable.setMinAndMaxFrame(minFrame, maxFrame);
    }

    public void setMinAndMaxProgress(@FloatRange(from = 0.0d, to = 1.0d) float minProgress, @FloatRange(from = 0.0d, to = 1.0d) float maxProgress) {
        this.lottieDrawable.setMinAndMaxProgress(minProgress, maxProgress);
    }

    public void reverseAnimationSpeed() {
        this.lottieDrawable.reverseAnimationSpeed();
    }

    public void setSpeed(float speed) {
        this.lottieDrawable.setSpeed(speed);
    }

    public float getSpeed() {
        return this.lottieDrawable.getSpeed();
    }

    public void addAnimatorUpdateListener(ValueAnimator.AnimatorUpdateListener updateListener) {
        this.lottieDrawable.addAnimatorUpdateListener(updateListener);
    }

    public void removeUpdateListener(ValueAnimator.AnimatorUpdateListener updateListener) {
        this.lottieDrawable.removeAnimatorUpdateListener(updateListener);
    }

    public void removeAllUpdateListeners() {
        this.lottieDrawable.removeAllUpdateListeners();
    }

    public void addAnimatorListener(Animator.AnimatorListener listener) {
        this.lottieDrawable.addAnimatorListener(listener);
    }

    public void removeAnimatorListener(Animator.AnimatorListener listener) {
        this.lottieDrawable.removeAnimatorListener(listener);
    }

    public void removeAllAnimatorListeners() {
        this.lottieDrawable.removeAllAnimatorListeners();
    }

    @Deprecated
    public void loop(boolean loop) {
        this.lottieDrawable.setRepeatCount(loop ? -1 : 0);
    }

    public void setRepeatMode(int mode) {
        this.lottieDrawable.setRepeatMode(mode);
    }

    public int getRepeatMode() {
        return this.lottieDrawable.getRepeatMode();
    }

    public void setRepeatCount(int count) {
        this.lottieDrawable.setRepeatCount(count);
    }

    public int getRepeatCount() {
        return this.lottieDrawable.getRepeatCount();
    }

    public boolean isAnimating() {
        return this.lottieDrawable.isAnimating();
    }

    public void setImageAssetsFolder(String imageAssetsFolder) {
        this.lottieDrawable.setImagesAssetsFolder(imageAssetsFolder);
    }

    @Nullable
    public String getImageAssetsFolder() {
        return this.lottieDrawable.getImageAssetsFolder();
    }

    @Nullable
    public Bitmap updateBitmap(String id, @Nullable Bitmap bitmap) {
        return this.lottieDrawable.updateBitmap(id, bitmap);
    }

    public void setImageAssetDelegate(ImageAssetDelegate assetDelegate) {
        this.lottieDrawable.setImageAssetDelegate(assetDelegate);
    }

    public void setFontAssetDelegate(FontAssetDelegate assetDelegate) {
        this.lottieDrawable.setFontAssetDelegate(assetDelegate);
    }

    public void setTextDelegate(TextDelegate textDelegate) {
        this.lottieDrawable.setTextDelegate(textDelegate);
    }

    public List<KeyPath> resolveKeyPath(KeyPath keyPath) {
        return this.lottieDrawable.resolveKeyPath(keyPath);
    }

    public <T> void addValueCallback(KeyPath keyPath, T property, LottieValueCallback<T> callback) {
        this.lottieDrawable.addValueCallback(keyPath, property, callback);
    }

    public <T> void addValueCallback(KeyPath keyPath, T property, SimpleLottieValueCallback<T> callback) {
        LottieValueCallback lottieValueCallback;
        final SimpleLottieValueCallback<T> simpleLottieValueCallback = callback;
        new LottieValueCallback<T>(this) {
            final /* synthetic */ LottieAnimationView this$0;

            {
                this.this$0 = this$0;
            }

            public T getValue(LottieFrameInfo<T> frameInfo) {
                return simpleLottieValueCallback.getValue(frameInfo);
            }
        };
        this.lottieDrawable.addValueCallback(keyPath, property, lottieValueCallback);
    }

    public void setScale(float scale) {
        this.lottieDrawable.setScale(scale);
        if (getDrawable() == this.lottieDrawable) {
            setImageDrawable((Drawable) null);
            setImageDrawable(this.lottieDrawable);
        }
    }

    public float getScale() {
        return this.lottieDrawable.getScale();
    }

    @MainThread
    public void cancelAnimation() {
        this.wasAnimatingWhenNotShown = false;
        this.lottieDrawable.cancelAnimation();
        enableOrDisableHardwareLayer();
    }

    @MainThread
    public void pauseAnimation() {
        this.wasAnimatingWhenDetached = false;
        this.wasAnimatingWhenNotShown = false;
        this.lottieDrawable.pauseAnimation();
        enableOrDisableHardwareLayer();
    }

    public void setFrame(int frame) {
        this.lottieDrawable.setFrame(frame);
    }

    public int getFrame() {
        return this.lottieDrawable.getFrame();
    }

    public void setProgress(@FloatRange(from = 0.0d, to = 1.0d) float progress) {
        this.lottieDrawable.setProgress(progress);
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    public float getProgress() {
        return this.lottieDrawable.getProgress();
    }

    public long getDuration() {
        return this.composition != null ? (long) this.composition.getDuration() : 0;
    }

    public void setPerformanceTrackingEnabled(boolean enabled) {
        this.lottieDrawable.setPerformanceTrackingEnabled(enabled);
    }

    @Nullable
    public PerformanceTracker getPerformanceTracker() {
        return this.lottieDrawable.getPerformanceTracker();
    }

    private void clearComposition() {
        this.composition = null;
        this.lottieDrawable.clearComposition();
    }

    public void buildDrawingCache(boolean z) {
        boolean autoScale = z;
        super.buildDrawingCache(autoScale);
        if (getLayerType() == 1 && getDrawingCache(autoScale) == null) {
            setRenderMode(RenderMode.HARDWARE);
        }
    }

    public void setRenderMode(RenderMode renderMode2) {
        this.renderMode = renderMode2;
        enableOrDisableHardwareLayer();
    }

    private void enableOrDisableHardwareLayer() {
        switch (this.renderMode) {
            case HARDWARE:
                setLayerType(2, (Paint) null);
                return;
            case SOFTWARE:
                setLayerType(1, (Paint) null);
                return;
            case AUTOMATIC:
                boolean useHardwareLayer = true;
                if (this.composition != null && this.composition.hasDashPattern() && Build.VERSION.SDK_INT < 28) {
                    useHardwareLayer = false;
                } else if (this.composition != null && this.composition.getMaskAndMatteCount() > 4) {
                    useHardwareLayer = false;
                }
                setLayerType(useHardwareLayer ? 2 : 1, (Paint) null);
                return;
            default:
                return;
        }
    }

    public boolean addLottieOnCompositionLoadedListener(@NonNull LottieOnCompositionLoadedListener lottieOnCompositionLoadedListener) {
        return this.lottieOnCompositionLoadedListeners.add(lottieOnCompositionLoadedListener);
    }

    public boolean removeLottieOnCompositionLoadedListener(@NonNull LottieOnCompositionLoadedListener lottieOnCompositionLoadedListener) {
        return this.lottieOnCompositionLoadedListeners.remove(lottieOnCompositionLoadedListener);
    }

    public void removeAllLottieOnCompositionLoadedListener() {
        this.lottieOnCompositionLoadedListeners.clear();
    }

    private static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR;
        String animationName;
        int animationResId;
        String imageAssetsFolder;
        boolean isAnimating;
        float progress;
        int repeatCount;
        int repeatMode;

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        /* synthetic */ SavedState(Parcel x0, AnonymousClass1 r7) {
            this(x0);
            AnonymousClass1 r2 = r7;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        SavedState(Parcelable superState) {
            super(superState);
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private SavedState(android.os.Parcel r6) {
            /*
                r5 = this;
                r0 = r5
                r1 = r6
                r2 = r0
                r3 = r1
                r2.<init>(r3)
                r2 = r0
                r3 = r1
                java.lang.String r3 = r3.readString()
                r2.animationName = r3
                r2 = r0
                r3 = r1
                float r3 = r3.readFloat()
                r2.progress = r3
                r2 = r0
                r3 = r1
                int r3 = r3.readInt()
                r4 = 1
                if (r3 != r4) goto L_0x003c
                r3 = 1
            L_0x0021:
                r2.isAnimating = r3
                r2 = r0
                r3 = r1
                java.lang.String r3 = r3.readString()
                r2.imageAssetsFolder = r3
                r2 = r0
                r3 = r1
                int r3 = r3.readInt()
                r2.repeatMode = r3
                r2 = r0
                r3 = r1
                int r3 = r3.readInt()
                r2.repeatCount = r3
                return
            L_0x003c:
                r3 = 0
                goto L_0x0021
            */
            throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.LottieAnimationView.SavedState.<init>(android.os.Parcel):void");
        }

        public void writeToParcel(Parcel parcel, int flags) {
            Parcel out = parcel;
            super.writeToParcel(out, flags);
            out.writeString(this.animationName);
            out.writeFloat(this.progress);
            out.writeInt(this.isAnimating ? 1 : 0);
            out.writeString(this.imageAssetsFolder);
            out.writeInt(this.repeatMode);
            out.writeInt(this.repeatCount);
        }

        static {
            Parcelable.Creator<SavedState> creator;
            new Parcelable.Creator<SavedState>() {
                public SavedState createFromParcel(Parcel in) {
                    SavedState savedState;
                    new SavedState(in, (AnonymousClass1) null);
                    return savedState;
                }

                public SavedState[] newArray(int size) {
                    return new SavedState[size];
                }
            };
            CREATOR = creator;
        }
    }
}
