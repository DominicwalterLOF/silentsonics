package androidx.arch.core.executor;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public abstract class TaskExecutor {
    public abstract void executeOnDiskIO(@NonNull Runnable runnable);

    public abstract boolean isMainThread();

    public abstract void postToMainThread(@NonNull Runnable runnable);

    public TaskExecutor() {
    }

    public void executeOnMainThread(@NonNull Runnable runnable) {
        Runnable runnable2 = runnable;
        if (isMainThread()) {
            runnable2.run();
        } else {
            postToMainThread(runnable2);
        }
    }
}
