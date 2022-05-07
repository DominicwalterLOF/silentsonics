package androidx.arch.core.executor;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class DefaultTaskExecutor extends TaskExecutor {
    private final ExecutorService mDiskIO;
    private final Object mLock;
    @Nullable
    private volatile Handler mMainHandler;

    public DefaultTaskExecutor() {
        Object obj;
        ThreadFactory threadFactory;
        new Object();
        this.mLock = obj;
        new ThreadFactory(this) {
            private static final String THREAD_NAME_STEM = "arch_disk_io_%d";
            private final AtomicInteger mThreadId;
            final /* synthetic */ DefaultTaskExecutor this$0;

            {
                AtomicInteger atomicInteger;
                this.this$0 = this$0;
                new AtomicInteger(0);
                this.mThreadId = atomicInteger;
            }

            public Thread newThread(Runnable r) {
                Thread thread;
                new Thread(r);
                Thread t = thread;
                t.setName(String.format(THREAD_NAME_STEM, new Object[]{Integer.valueOf(this.mThreadId.getAndIncrement())}));
                return t;
            }
        };
        this.mDiskIO = Executors.newFixedThreadPool(2, threadFactory);
    }

    public void executeOnDiskIO(Runnable runnable) {
        this.mDiskIO.execute(runnable);
    }

    public void postToMainThread(Runnable runnable) {
        Handler handler;
        Runnable runnable2 = runnable;
        if (this.mMainHandler == null) {
            Object obj = this.mLock;
            Object obj2 = obj;
            synchronized (obj) {
                try {
                    if (this.mMainHandler == null) {
                        new Handler(Looper.getMainLooper());
                        this.mMainHandler = handler;
                    }
                } catch (Throwable th) {
                    while (true) {
                        Throwable th2 = th;
                        Object obj3 = obj2;
                        throw th2;
                    }
                }
            }
        }
        boolean post = this.mMainHandler.post(runnable2);
    }

    public boolean isMainThread() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }
}
