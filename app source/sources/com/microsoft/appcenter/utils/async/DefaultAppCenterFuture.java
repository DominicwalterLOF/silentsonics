package com.microsoft.appcenter.utils.async;

import com.microsoft.appcenter.utils.HandlerUtils;
import java.util.Collection;
import java.util.LinkedList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class DefaultAppCenterFuture<T> implements AppCenterFuture<T> {
    /* access modifiers changed from: private */
    public Collection<AppCenterConsumer<T>> mConsumers;
    private final CountDownLatch mLatch;
    /* access modifiers changed from: private */
    public T mResult;

    public DefaultAppCenterFuture() {
        CountDownLatch countDownLatch;
        new CountDownLatch(1);
        this.mLatch = countDownLatch;
    }

    static /* synthetic */ Collection access$102(DefaultAppCenterFuture x0, Collection x1) {
        Collection collection = x1;
        Collection collection2 = collection;
        x0.mConsumers = collection2;
        return collection;
    }

    public T get() {
        while (true) {
            try {
                this.mLatch.await();
                break;
            } catch (InterruptedException e) {
                InterruptedException interruptedException = e;
            }
        }
        return this.mResult;
    }

    public boolean isDone() {
        while (true) {
            try {
                break;
            } catch (InterruptedException e) {
                InterruptedException interruptedException = e;
            }
        }
        return this.mLatch.await(0, TimeUnit.MILLISECONDS);
    }

    public synchronized void thenAccept(AppCenterConsumer<T> appCenterConsumer) {
        Collection<AppCenterConsumer<T>> collection;
        Runnable runnable;
        AppCenterConsumer<T> function = appCenterConsumer;
        synchronized (this) {
            if (isDone()) {
                final AppCenterConsumer<T> appCenterConsumer2 = function;
                new Runnable(this) {
                    final /* synthetic */ DefaultAppCenterFuture this$0;

                    {
                        this.this$0 = this$0;
                    }

                    public void run() {
                        appCenterConsumer2.accept(this.this$0.mResult);
                    }
                };
                HandlerUtils.runOnUiThread(runnable);
            } else {
                if (this.mConsumers == null) {
                    new LinkedList();
                    this.mConsumers = collection;
                }
                boolean add = this.mConsumers.add(function);
            }
        }
    }

    public synchronized void complete(T t) {
        Runnable runnable;
        T value = t;
        synchronized (this) {
            if (!isDone()) {
                this.mResult = value;
                this.mLatch.countDown();
                if (this.mConsumers != null) {
                    final T t2 = value;
                    new Runnable(this) {
                        final /* synthetic */ DefaultAppCenterFuture this$0;

                        {
                            this.this$0 = this$0;
                        }

                        public void run() {
                            for (AppCenterConsumer accept : this.this$0.mConsumers) {
                                accept.accept(t2);
                            }
                            Collection access$102 = DefaultAppCenterFuture.access$102(this.this$0, (Collection) null);
                        }
                    };
                    HandlerUtils.runOnUiThread(runnable);
                }
            }
        }
    }
}
