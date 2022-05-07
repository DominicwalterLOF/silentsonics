package com.airbnb.lottie.model;

import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.util.Pair;
import com.shaded.fasterxml.jackson.core.util.MinimalPrettyPrinter;

@RestrictTo({RestrictTo.Scope.LIBRARY})
public class MutablePair<T> {
    @Nullable
    T first;
    @Nullable
    T second;

    public MutablePair() {
    }

    public void set(T first2, T second2) {
        this.first = first2;
        this.second = second2;
    }

    public boolean equals(Object obj) {
        Object o = obj;
        if (!(o instanceof Pair)) {
            return false;
        }
        Pair<?, ?> p = (Pair) o;
        return objectsEqual(p.first, this.first) && objectsEqual(p.second, this.second);
    }

    private static boolean objectsEqual(Object obj, Object obj2) {
        Object a = obj;
        Object b = obj2;
        return a == b || (a != null && a.equals(b));
    }

    public int hashCode() {
        return (this.first == null ? 0 : this.first.hashCode()) ^ (this.second == null ? 0 : this.second.hashCode());
    }

    public String toString() {
        StringBuilder sb;
        new StringBuilder();
        return sb.append("Pair{").append(String.valueOf(this.first)).append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR).append(String.valueOf(this.second)).append("}").toString();
    }
}
