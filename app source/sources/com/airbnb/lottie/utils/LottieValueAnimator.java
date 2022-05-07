package com.airbnb.lottie.utils;

import android.view.Choreographer;
import androidx.annotation.FloatRange;
import androidx.annotation.MainThread;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.airbnb.lottie.LottieComposition;

public class LottieValueAnimator extends BaseLottieAnimator implements Choreographer.FrameCallback {
    @Nullable
    private LottieComposition composition;
    private float frame = 0.0f;
    private long lastFrameTimeNs = 0;
    private float maxFrame = 2.14748365E9f;
    private float minFrame = -2.14748365E9f;
    private int repeatCount = 0;
    @VisibleForTesting
    protected boolean running = false;
    private float speed = 1.0f;
    private boolean speedReversedForRepeatMode = false;

    public LottieValueAnimator() {
    }

    public Object getAnimatedValue() {
        return Float.valueOf(getAnimatedValueAbsolute());
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    public float getAnimatedValueAbsolute() {
        if (this.composition == null) {
            return 0.0f;
        }
        return (this.frame - this.composition.getStartFrame()) / (this.composition.getEndFrame() - this.composition.getStartFrame());
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    public float getAnimatedFraction() {
        if (this.composition == null) {
            return 0.0f;
        }
        if (isReversed()) {
            return (getMaxFrame() - this.frame) / (getMaxFrame() - getMinFrame());
        }
        return (this.frame - getMinFrame()) / (getMaxFrame() - getMinFrame());
    }

    public long getDuration() {
        return this.composition == null ? 0 : (long) this.composition.getDuration();
    }

    public float getFrame() {
        return this.frame;
    }

    public boolean isRunning() {
        return this.running;
    }

    public void doFrame(long j) {
        long frameTimeNanos = j;
        postFrameCallback();
        if (this.composition != null && isRunning()) {
            long now = frameTimeNanos;
            float dFrames = ((float) (this.lastFrameTimeNs == 0 ? 0 : now - this.lastFrameTimeNs)) / getFrameDurationNs();
            this.frame += isReversed() ? -dFrames : dFrames;
            boolean ended = !MiscUtils.contains(this.frame, getMinFrame(), getMaxFrame());
            this.frame = MiscUtils.clamp(this.frame, getMinFrame(), getMaxFrame());
            this.lastFrameTimeNs = now;
            notifyUpdate();
            if (ended) {
                if (getRepeatCount() == -1 || this.repeatCount < getRepeatCount()) {
                    notifyRepeat();
                    this.repeatCount++;
                    if (getRepeatMode() == 2) {
                        this.speedReversedForRepeatMode = !this.speedReversedForRepeatMode;
                        reverseAnimationSpeed();
                    } else {
                        this.frame = isReversed() ? getMaxFrame() : getMinFrame();
                    }
                    this.lastFrameTimeNs = now;
                } else {
                    this.frame = this.speed < 0.0f ? getMinFrame() : getMaxFrame();
                    removeFrameCallback();
                    notifyEnd(isReversed());
                }
            }
            verifyFrame();
        }
    }

    private float getFrameDurationNs() {
        if (this.composition == null) {
            return Float.MAX_VALUE;
        }
        return (1.0E9f / this.composition.getFrameRate()) / Math.abs(this.speed);
    }

    public void clearComposition() {
        this.composition = null;
        this.minFrame = -2.14748365E9f;
        this.maxFrame = 2.14748365E9f;
    }

    public void setComposition(LottieComposition lottieComposition) {
        LottieComposition composition2 = lottieComposition;
        boolean keepMinAndMaxFrames = this.composition == null;
        this.composition = composition2;
        if (keepMinAndMaxFrames) {
            setMinAndMaxFrames((float) ((int) Math.max(this.minFrame, composition2.getStartFrame())), (float) ((int) Math.min(this.maxFrame, composition2.getEndFrame())));
        } else {
            setMinAndMaxFrames((float) ((int) composition2.getStartFrame()), (float) ((int) composition2.getEndFrame()));
        }
        float frame2 = this.frame;
        this.frame = 0.0f;
        setFrame((int) frame2);
    }

    public void setFrame(int i) {
        int frame2 = i;
        if (this.frame != ((float) frame2)) {
            this.frame = MiscUtils.clamp((float) frame2, getMinFrame(), getMaxFrame());
            this.lastFrameTimeNs = 0;
            notifyUpdate();
        }
    }

    public void setMinFrame(int minFrame2) {
        setMinAndMaxFrames((float) minFrame2, (float) ((int) this.maxFrame));
    }

    public void setMaxFrame(float maxFrame2) {
        setMinAndMaxFrames(this.minFrame, maxFrame2);
    }

    public void setMinAndMaxFrames(float f, float f2) {
        Throwable th;
        float minFrame2 = f;
        float maxFrame2 = f2;
        if (minFrame2 > maxFrame2) {
            Throwable th2 = th;
            Object[] objArr = new Object[2];
            objArr[0] = Float.valueOf(minFrame2);
            Object[] objArr2 = objArr;
            objArr2[1] = Float.valueOf(maxFrame2);
            new IllegalArgumentException(String.format("minFrame (%s) must be <= maxFrame (%s)", objArr2));
            throw th2;
        }
        float compositionMinFrame = this.composition == null ? -3.4028235E38f : this.composition.getStartFrame();
        float compositionMaxFrame = this.composition == null ? Float.MAX_VALUE : this.composition.getEndFrame();
        this.minFrame = MiscUtils.clamp(minFrame2, compositionMinFrame, compositionMaxFrame);
        this.maxFrame = MiscUtils.clamp(maxFrame2, compositionMinFrame, compositionMaxFrame);
        setFrame((int) MiscUtils.clamp(this.frame, minFrame2, maxFrame2));
    }

    public void reverseAnimationSpeed() {
        setSpeed(-getSpeed());
    }

    public void setSpeed(float speed2) {
        float f = speed2;
        this.speed = f;
    }

    public float getSpeed() {
        return this.speed;
    }

    public void setRepeatMode(int i) {
        int value = i;
        super.setRepeatMode(value);
        if (value != 2 && this.speedReversedForRepeatMode) {
            this.speedReversedForRepeatMode = false;
            reverseAnimationSpeed();
        }
    }

    @MainThread
    public void playAnimation() {
        this.running = true;
        notifyStart(isReversed());
        setFrame((int) (isReversed() ? getMaxFrame() : getMinFrame()));
        this.lastFrameTimeNs = 0;
        this.repeatCount = 0;
        postFrameCallback();
    }

    @MainThread
    public void endAnimation() {
        removeFrameCallback();
        notifyEnd(isReversed());
    }

    @MainThread
    public void pauseAnimation() {
        removeFrameCallback();
    }

    @MainThread
    public void resumeAnimation() {
        this.running = true;
        postFrameCallback();
        this.lastFrameTimeNs = 0;
        if (isReversed() && getFrame() == getMinFrame()) {
            this.frame = getMaxFrame();
        } else if (!isReversed() && getFrame() == getMaxFrame()) {
            this.frame = getMinFrame();
        }
    }

    @MainThread
    public void cancel() {
        notifyCancel();
        removeFrameCallback();
    }

    private boolean isReversed() {
        return getSpeed() < 0.0f;
    }

    public float getMinFrame() {
        if (this.composition == null) {
            return 0.0f;
        }
        return this.minFrame == -2.14748365E9f ? this.composition.getStartFrame() : this.minFrame;
    }

    public float getMaxFrame() {
        if (this.composition == null) {
            return 0.0f;
        }
        return this.maxFrame == 2.14748365E9f ? this.composition.getEndFrame() : this.maxFrame;
    }

    /* access modifiers changed from: protected */
    public void postFrameCallback() {
        if (isRunning()) {
            removeFrameCallback(false);
            Choreographer.getInstance().postFrameCallback(this);
        }
    }

    /* access modifiers changed from: protected */
    @MainThread
    public void removeFrameCallback() {
        removeFrameCallback(true);
    }

    /* access modifiers changed from: protected */
    @MainThread
    public void removeFrameCallback(boolean stopRunning) {
        Choreographer.getInstance().removeFrameCallback(this);
        if (stopRunning) {
            this.running = false;
        }
    }

    private void verifyFrame() {
        Throwable th;
        if (this.composition != null) {
            if (this.frame < this.minFrame || this.frame > this.maxFrame) {
                Throwable th2 = th;
                Object[] objArr = new Object[3];
                objArr[0] = Float.valueOf(this.minFrame);
                Object[] objArr2 = objArr;
                objArr2[1] = Float.valueOf(this.maxFrame);
                Object[] objArr3 = objArr2;
                objArr3[2] = Float.valueOf(this.frame);
                new IllegalStateException(String.format("Frame must be [%f,%f]. It is %f", objArr3));
                throw th2;
            }
        }
    }
}
