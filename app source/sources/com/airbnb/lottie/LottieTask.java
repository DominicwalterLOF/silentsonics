package com.airbnb.lottie;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.airbnb.lottie.utils.Logger;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class LottieTask<T> {
    public static Executor EXECUTOR = Executors.newCachedThreadPool();
    private final Set<LottieListener<Throwable>> failureListeners;
    private final Handler handler;
    /* access modifiers changed from: private */
    @Nullable
    public volatile LottieResult<T> result;
    private final Set<LottieListener<T>> successListeners;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public LottieTask(Callable<LottieResult<T>> runnable) {
        this(runnable, false);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    LottieTask(Callable<LottieResult<T>> callable, boolean runNow) {
        Set<LottieListener<T>> set;
        Set<LottieListener<Throwable>> set2;
        Handler handler2;
        Runnable runnable;
        LottieResult lottieResult;
        Callable<LottieResult<T>> runnable2 = callable;
        new LinkedHashSet(1);
        this.successListeners = set;
        new LinkedHashSet(1);
        this.failureListeners = set2;
        new Handler(Looper.getMainLooper());
        this.handler = handler2;
        this.result = null;
        if (runNow) {
            try {
                setResult(runnable2.call());
            } catch (Throwable th) {
                new LottieResult(th);
                setResult(lottieResult);
            }
        } else {
            new LottieFutureTask(this, runnable2);
            EXECUTOR.execute(runnable);
        }
    }

    /* access modifiers changed from: private */
    public void setResult(@Nullable LottieResult<T> lottieResult) {
        Throwable th;
        LottieResult<T> result2 = lottieResult;
        if (this.result != null) {
            Throwable th2 = th;
            new IllegalStateException("A task may only be set once.");
            throw th2;
        }
        this.result = result2;
        notifyListeners();
    }

    public synchronized LottieTask<T> addListener(LottieListener<T> lottieListener) {
        LottieListener<T> listener = lottieListener;
        synchronized (this) {
            if (!(this.result == null || this.result.getValue() == null)) {
                listener.onResult(this.result.getValue());
            }
            boolean add = this.successListeners.add(listener);
        }
        return this;
    }

    public synchronized LottieTask<T> removeListener(LottieListener<T> lottieListener) {
        LottieListener<T> listener = lottieListener;
        synchronized (this) {
            boolean remove = this.successListeners.remove(listener);
        }
        return this;
    }

    public synchronized LottieTask<T> addFailureListener(LottieListener<Throwable> lottieListener) {
        LottieListener<Throwable> listener = lottieListener;
        synchronized (this) {
            if (!(this.result == null || this.result.getException() == null)) {
                listener.onResult(this.result.getException());
            }
            boolean add = this.failureListeners.add(listener);
        }
        return this;
    }

    public synchronized LottieTask<T> removeFailureListener(LottieListener<Throwable> lottieListener) {
        LottieListener<Throwable> listener = lottieListener;
        synchronized (this) {
            boolean remove = this.failureListeners.remove(listener);
        }
        return this;
    }

    private void notifyListeners() {
        Runnable runnable;
        new Runnable(this) {
            final /* synthetic */ LottieTask this$0;

            {
                this.this$0 = this$0;
            }

            public void run() {
                if (this.this$0.result != null) {
                    LottieResult<T> result = this.this$0.result;
                    if (result.getValue() != null) {
                        this.this$0.notifySuccessListeners(result.getValue());
                    } else {
                        this.this$0.notifyFailureListeners(result.getException());
                    }
                }
            }
        };
        boolean post = this.handler.post(runnable);
    }

    /* access modifiers changed from: private */
    public synchronized void notifySuccessListeners(T t) {
        List<LottieListener> list;
        T value = t;
        synchronized (this) {
            new ArrayList(this.successListeners);
            for (LottieListener onResult : list) {
                onResult.onResult(value);
            }
        }
    }

    /* access modifiers changed from: private */
    public synchronized void notifyFailureListeners(Throwable th) {
        List list;
        Throwable e = th;
        synchronized (this) {
            new ArrayList(this.failureListeners);
            List<LottieListener> list2 = list;
            if (list2.isEmpty()) {
                Logger.warning("Lottie encountered an error but no failure listener was added:", e);
            } else {
                for (LottieListener onResult : list2) {
                    onResult.onResult(e);
                }
            }
        }
    }

    private class LottieFutureTask extends FutureTask<LottieResult<T>> {
        final /* synthetic */ LottieTask this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        LottieFutureTask(LottieTask lottieTask, Callable<LottieResult<T>> callable) {
            super(callable);
            this.this$0 = lottieTask;
        }

        /* access modifiers changed from: protected */
        public void done() {
            LottieResult lottieResult;
            if (!isCancelled()) {
                try {
                    this.this$0.setResult((LottieResult) get());
                } catch (InterruptedException | ExecutionException e) {
                    new LottieResult((Throwable) e);
                    this.this$0.setResult(lottieResult);
                }
            }
        }
    }
}
