package androidx.lifecycle;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;

public abstract class Lifecycle {

    public enum Event {
    }

    @MainThread
    public abstract void addObserver(@NonNull LifecycleObserver lifecycleObserver);

    @MainThread
    @NonNull
    public abstract State getCurrentState();

    @MainThread
    public abstract void removeObserver(@NonNull LifecycleObserver lifecycleObserver);

    public Lifecycle() {
    }

    public enum State {
        ;

        public boolean isAtLeast(@NonNull State state) {
            return compareTo(state) >= 0;
        }
    }
}
