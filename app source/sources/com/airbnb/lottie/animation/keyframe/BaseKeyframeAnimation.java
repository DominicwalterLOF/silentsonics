package com.airbnb.lottie.animation.keyframe;

import androidx.annotation.FloatRange;
import androidx.annotation.Nullable;
import com.airbnb.lottie.value.Keyframe;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseKeyframeAnimation<K, A> {
    private float cachedEndProgress = -1.0f;
    @Nullable
    private A cachedGetValue = null;
    @Nullable
    private Keyframe<K> cachedGetValueKeyframe;
    private float cachedGetValueProgress = -1.0f;
    @Nullable
    private Keyframe<K> cachedKeyframe;
    private float cachedStartDelayProgress = -1.0f;
    private boolean isDiscrete = false;
    private final List<? extends Keyframe<K>> keyframes;
    final List<AnimationListener> listeners;
    private float progress = 0.0f;
    @Nullable
    protected LottieValueCallback<A> valueCallback;

    public interface AnimationListener {
        void onValueChanged();
    }

    /* access modifiers changed from: package-private */
    public abstract A getValue(Keyframe<K> keyframe, float f);

    BaseKeyframeAnimation(List<? extends Keyframe<K>> keyframes2) {
        List<AnimationListener> list;
        new ArrayList(1);
        this.listeners = list;
        this.keyframes = keyframes2;
    }

    public void setIsDiscrete() {
        this.isDiscrete = true;
    }

    public void addUpdateListener(AnimationListener listener) {
        boolean add = this.listeners.add(listener);
    }

    public void setProgress(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        float progress2 = f;
        if (!this.keyframes.isEmpty()) {
            Keyframe<K> previousKeyframe = getCurrentKeyframe();
            if (progress2 < getStartDelayProgress()) {
                progress2 = getStartDelayProgress();
            } else if (progress2 > getEndProgress()) {
                progress2 = getEndProgress();
            }
            if (progress2 != this.progress) {
                this.progress = progress2;
                Keyframe<K> newKeyframe = getCurrentKeyframe();
                if (previousKeyframe != newKeyframe || !newKeyframe.isStatic()) {
                    notifyListeners();
                }
            }
        }
    }

    public void notifyListeners() {
        for (int i = 0; i < this.listeners.size(); i++) {
            this.listeners.get(i).onValueChanged();
        }
    }

    /* access modifiers changed from: protected */
    public Keyframe<K> getCurrentKeyframe() {
        if (this.cachedKeyframe != null && this.cachedKeyframe.containsProgress(this.progress)) {
            return this.cachedKeyframe;
        }
        Keyframe<K> keyframe = (Keyframe) this.keyframes.get(this.keyframes.size() - 1);
        if (this.progress < keyframe.getStartProgress()) {
            for (int i = this.keyframes.size() - 1; i >= 0; i--) {
                keyframe = (Keyframe) this.keyframes.get(i);
                if (keyframe.containsProgress(this.progress)) {
                    break;
                }
            }
        }
        this.cachedKeyframe = keyframe;
        return keyframe;
    }

    /* access modifiers changed from: package-private */
    public float getLinearCurrentKeyframeProgress() {
        if (this.isDiscrete) {
            return 0.0f;
        }
        Keyframe<K> keyframe = getCurrentKeyframe();
        if (keyframe.isStatic()) {
            return 0.0f;
        }
        return (this.progress - keyframe.getStartProgress()) / (keyframe.getEndProgress() - keyframe.getStartProgress());
    }

    /* access modifiers changed from: protected */
    public float getInterpolatedCurrentKeyframeProgress() {
        Keyframe<K> keyframe = getCurrentKeyframe();
        if (keyframe.isStatic()) {
            return 0.0f;
        }
        return keyframe.interpolator.getInterpolation(getLinearCurrentKeyframeProgress());
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    private float getStartDelayProgress() {
        if (this.cachedStartDelayProgress == -1.0f) {
            this.cachedStartDelayProgress = this.keyframes.isEmpty() ? 0.0f : ((Keyframe) this.keyframes.get(0)).getStartProgress();
        }
        return this.cachedStartDelayProgress;
    }

    /* access modifiers changed from: package-private */
    @FloatRange(from = 0.0d, to = 1.0d)
    public float getEndProgress() {
        if (this.cachedEndProgress == -1.0f) {
            this.cachedEndProgress = this.keyframes.isEmpty() ? 1.0f : ((Keyframe) this.keyframes.get(this.keyframes.size() - 1)).getEndProgress();
        }
        return this.cachedEndProgress;
    }

    public A getValue() {
        Keyframe<K> keyframe = getCurrentKeyframe();
        float progress2 = getInterpolatedCurrentKeyframeProgress();
        if (this.valueCallback == null && keyframe == this.cachedGetValueKeyframe && this.cachedGetValueProgress == progress2) {
            return this.cachedGetValue;
        }
        this.cachedGetValueKeyframe = keyframe;
        this.cachedGetValueProgress = progress2;
        BaseKeyframeAnimation<K, A> value = getValue(keyframe, progress2);
        this.cachedGetValue = value;
        return value;
    }

    public float getProgress() {
        return this.progress;
    }

    public void setValueCallback(@Nullable LottieValueCallback<A> lottieValueCallback) {
        LottieValueCallback<A> valueCallback2 = lottieValueCallback;
        if (this.valueCallback != null) {
            this.valueCallback.setAnimation((BaseKeyframeAnimation<?, ?>) null);
        }
        this.valueCallback = valueCallback2;
        if (valueCallback2 != null) {
            valueCallback2.setAnimation(this);
        }
    }
}
