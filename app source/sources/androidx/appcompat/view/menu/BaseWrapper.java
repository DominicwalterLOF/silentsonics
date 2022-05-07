package androidx.appcompat.view.menu;

class BaseWrapper<T> {
    final T mWrappedObject;

    BaseWrapper(T t) {
        Throwable th;
        T object = t;
        if (null == object) {
            Throwable th2 = th;
            new IllegalArgumentException("Wrapped Object can not be null.");
            throw th2;
        }
        this.mWrappedObject = object;
    }

    public T getWrappedObject() {
        return this.mWrappedObject;
    }
}
