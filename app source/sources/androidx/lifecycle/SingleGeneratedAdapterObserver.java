package androidx.lifecycle;

import androidx.annotation.RestrictTo;
import androidx.lifecycle.Lifecycle;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class SingleGeneratedAdapterObserver implements GenericLifecycleObserver {
    private final GeneratedAdapter mGeneratedAdapter;

    SingleGeneratedAdapterObserver(GeneratedAdapter generatedAdapter) {
        this.mGeneratedAdapter = generatedAdapter;
    }

    public void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        LifecycleOwner source = lifecycleOwner;
        Lifecycle.Event event2 = event;
        this.mGeneratedAdapter.callMethods(source, event2, false, (MethodCallsLogger) null);
        this.mGeneratedAdapter.callMethods(source, event2, true, (MethodCallsLogger) null);
    }
}
