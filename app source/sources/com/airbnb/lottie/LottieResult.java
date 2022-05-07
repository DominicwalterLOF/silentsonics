package com.airbnb.lottie;

import androidx.annotation.Nullable;
import java.util.Arrays;

public final class LottieResult<V> {
    @Nullable
    private final Throwable exception;
    @Nullable
    private final V value;

    public LottieResult(V value2) {
        this.value = value2;
        this.exception = null;
    }

    public LottieResult(Throwable exception2) {
        this.exception = exception2;
        this.value = null;
    }

    @Nullable
    public V getValue() {
        return this.value;
    }

    @Nullable
    public Throwable getException() {
        return this.exception;
    }

    public boolean equals(Object obj) {
        Object o = obj;
        if (this == o) {
            return true;
        }
        if (!(o instanceof LottieResult)) {
            return false;
        }
        LottieResult<?> that = (LottieResult) o;
        if (getValue() != null && getValue().equals(that.getValue())) {
            return true;
        }
        if (getException() == null || that.getException() == null) {
            return false;
        }
        return getException().toString().equals(getException().toString());
    }

    public int hashCode() {
        Object[] objArr = new Object[2];
        objArr[0] = getValue();
        Object[] objArr2 = objArr;
        objArr2[1] = getException();
        return Arrays.hashCode(objArr2);
    }
}
