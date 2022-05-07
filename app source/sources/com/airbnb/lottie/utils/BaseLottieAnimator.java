package com.airbnb.lottie.utils;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.os.Build;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public abstract class BaseLottieAnimator extends ValueAnimator {
    private final Set<Animator.AnimatorListener> listeners;
    private final Set<ValueAnimator.AnimatorUpdateListener> updateListeners;

    public BaseLottieAnimator() {
        Set<ValueAnimator.AnimatorUpdateListener> set;
        Set<Animator.AnimatorListener> set2;
        new CopyOnWriteArraySet();
        this.updateListeners = set;
        new CopyOnWriteArraySet();
        this.listeners = set2;
    }

    public long getStartDelay() {
        Throwable th;
        Throwable th2 = th;
        new UnsupportedOperationException("LottieAnimator does not support getStartDelay.");
        throw th2;
    }

    public void setStartDelay(long j) {
        Throwable th;
        long j2 = j;
        Throwable th2 = th;
        new UnsupportedOperationException("LottieAnimator does not support setStartDelay.");
        throw th2;
    }

    public ValueAnimator setDuration(long j) {
        Throwable th;
        long j2 = j;
        Throwable th2 = th;
        new UnsupportedOperationException("LottieAnimator does not support setDuration.");
        throw th2;
    }

    public void setInterpolator(TimeInterpolator timeInterpolator) {
        Throwable th;
        TimeInterpolator timeInterpolator2 = timeInterpolator;
        Throwable th2 = th;
        new UnsupportedOperationException("LottieAnimator does not support setInterpolator.");
        throw th2;
    }

    public void addUpdateListener(ValueAnimator.AnimatorUpdateListener listener) {
        boolean add = this.updateListeners.add(listener);
    }

    public void removeUpdateListener(ValueAnimator.AnimatorUpdateListener listener) {
        boolean remove = this.updateListeners.remove(listener);
    }

    public void removeAllUpdateListeners() {
        this.updateListeners.clear();
    }

    public void addListener(Animator.AnimatorListener listener) {
        boolean add = this.listeners.add(listener);
    }

    public void removeListener(Animator.AnimatorListener listener) {
        boolean remove = this.listeners.remove(listener);
    }

    public void removeAllListeners() {
        this.listeners.clear();
    }

    /* access modifiers changed from: package-private */
    public void notifyStart(boolean z) {
        boolean isReverse = z;
        for (Animator.AnimatorListener listener : this.listeners) {
            if (Build.VERSION.SDK_INT >= 26) {
                listener.onAnimationStart(this, isReverse);
            } else {
                listener.onAnimationStart(this);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void notifyRepeat() {
        for (Animator.AnimatorListener listener : this.listeners) {
            listener.onAnimationRepeat(this);
        }
    }

    /* access modifiers changed from: package-private */
    public void notifyEnd(boolean z) {
        boolean isReverse = z;
        for (Animator.AnimatorListener listener : this.listeners) {
            if (Build.VERSION.SDK_INT >= 26) {
                listener.onAnimationEnd(this, isReverse);
            } else {
                listener.onAnimationEnd(this);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void notifyCancel() {
        for (Animator.AnimatorListener listener : this.listeners) {
            listener.onAnimationCancel(this);
        }
    }

    /* access modifiers changed from: package-private */
    public void notifyUpdate() {
        for (ValueAnimator.AnimatorUpdateListener listener : this.updateListeners) {
            listener.onAnimationUpdate(this);
        }
    }
}
