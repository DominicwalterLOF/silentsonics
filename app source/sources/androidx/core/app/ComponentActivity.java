package androidx.core.app;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.collection.SimpleArrayMap;
import androidx.core.view.KeyEventDispatcher;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.ReportFragment;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class ComponentActivity extends Activity implements LifecycleOwner, KeyEventDispatcher.Component {
    private SimpleArrayMap<Class<? extends ExtraData>, ExtraData> mExtraDataMap;
    private LifecycleRegistry mLifecycleRegistry;

    public ComponentActivity() {
        SimpleArrayMap<Class<? extends ExtraData>, ExtraData> simpleArrayMap;
        LifecycleRegistry lifecycleRegistry;
        new SimpleArrayMap<>();
        this.mExtraDataMap = simpleArrayMap;
        new LifecycleRegistry(this);
        this.mLifecycleRegistry = lifecycleRegistry;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void putExtraData(ExtraData extraData) {
        ExtraData extraData2 = extraData;
        ExtraData put = this.mExtraDataMap.put(extraData2.getClass(), extraData2);
    }

    /* access modifiers changed from: protected */
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ReportFragment.injectIfNeededIn(this);
    }

    /* access modifiers changed from: protected */
    @CallSuper
    public void onSaveInstanceState(Bundle outState) {
        this.mLifecycleRegistry.markState(Lifecycle.State.CREATED);
        super.onSaveInstanceState(outState);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public <T extends ExtraData> T getExtraData(Class<T> extraDataClass) {
        return (ExtraData) this.mExtraDataMap.get(extraDataClass);
    }

    public Lifecycle getLifecycle() {
        return this.mLifecycleRegistry;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean superDispatchKeyEvent(KeyEvent event) {
        return super.dispatchKeyEvent(event);
    }

    public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        KeyEvent event = keyEvent;
        View decor = getWindow().getDecorView();
        if (decor == null || !KeyEventDispatcher.dispatchBeforeHierarchy(decor, event)) {
            return super.dispatchKeyShortcutEvent(event);
        }
        return true;
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        KeyEvent event = keyEvent;
        View decor = getWindow().getDecorView();
        if (decor == null || !KeyEventDispatcher.dispatchBeforeHierarchy(decor, event)) {
            return KeyEventDispatcher.dispatchKeyEvent(this, decor, this, event);
        }
        return true;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static class ExtraData {
        public ExtraData() {
        }
    }
}
