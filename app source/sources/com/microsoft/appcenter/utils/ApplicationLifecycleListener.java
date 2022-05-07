package com.microsoft.appcenter.utils;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public class ApplicationLifecycleListener implements Application.ActivityLifecycleCallbacks {
    private static final long TIMEOUT_MS = 700;
    private Runnable mDelayedPauseRunnable;
    private Handler mHandler;
    private final Set<ApplicationLifecycleCallbacks> mLifecycleCallbacks;
    private boolean mPauseSent = true;
    private int mResumedCounter = 0;
    private int mStartedCounter = 0;
    private boolean mStopSent = true;

    public interface ApplicationLifecycleCallbacks {
        void onApplicationEnterBackground();

        void onApplicationEnterForeground();
    }

    public ApplicationLifecycleListener(Handler handler) {
        Set<ApplicationLifecycleCallbacks> set;
        Runnable runnable;
        new CopyOnWriteArraySet();
        this.mLifecycleCallbacks = set;
        new Runnable(this) {
            final /* synthetic */ ApplicationLifecycleListener this$0;

            {
                this.this$0 = this$0;
            }

            public void run() {
                this.this$0.dispatchPauseIfNeeded();
                this.this$0.dispatchStopIfNeeded();
            }
        };
        this.mDelayedPauseRunnable = runnable;
        this.mHandler = handler;
    }

    public void registerApplicationLifecycleCallbacks(ApplicationLifecycleCallbacks lifecycleCallback) {
        boolean add = this.mLifecycleCallbacks.add(lifecycleCallback);
    }

    /* access modifiers changed from: private */
    public void dispatchPauseIfNeeded() {
        if (this.mResumedCounter == 0) {
            this.mPauseSent = true;
        }
    }

    /* access modifiers changed from: private */
    public void dispatchStopIfNeeded() {
        if (this.mStartedCounter == 0 && this.mPauseSent) {
            for (ApplicationLifecycleCallbacks service : this.mLifecycleCallbacks) {
                service.onApplicationEnterBackground();
            }
            this.mStopSent = true;
        }
    }

    public void onActivityCreated(@NonNull Activity activity, @Nullable Bundle savedInstanceState) {
    }

    public void onActivityStarted(@NonNull Activity activity) {
        Activity activity2 = activity;
        this.mStartedCounter++;
        if (this.mStartedCounter == 1 && this.mStopSent) {
            for (ApplicationLifecycleCallbacks service : this.mLifecycleCallbacks) {
                service.onApplicationEnterForeground();
            }
            this.mStopSent = false;
        }
    }

    public void onActivityResumed(@NonNull Activity activity) {
        Activity activity2 = activity;
        this.mResumedCounter++;
        if (this.mResumedCounter != 1) {
            return;
        }
        if (this.mPauseSent) {
            this.mPauseSent = false;
        } else {
            this.mHandler.removeCallbacks(this.mDelayedPauseRunnable);
        }
    }

    public void onActivityPaused(@NonNull Activity activity) {
        Activity activity2 = activity;
        if (this.mStartedCounter == 0) {
            this.mStopSent = false;
        }
        if (this.mResumedCounter == 0) {
            this.mPauseSent = false;
        }
        this.mResumedCounter = Math.max(this.mResumedCounter - 1, 0);
        if (this.mResumedCounter == 0) {
            boolean postDelayed = this.mHandler.postDelayed(this.mDelayedPauseRunnable, TIMEOUT_MS);
        }
    }

    public void onActivityStopped(@NonNull Activity activity) {
        Activity activity2 = activity;
        this.mStartedCounter = Math.max(this.mStartedCounter - 1, 0);
        dispatchStopIfNeeded();
    }

    public void onActivitySaveInstanceState(@NonNull Activity activity, @NonNull Bundle outState) {
    }

    public void onActivityDestroyed(@NonNull Activity activity) {
    }
}
