package com.airbnb.lottie.model;

import androidx.annotation.CheckResult;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.slf4j.Marker;

public class KeyPath {
    private final List<String> keys;
    @Nullable
    private KeyPathElement resolvedElement;

    public KeyPath(String... keys2) {
        this.keys = Arrays.asList(keys2);
    }

    private KeyPath(KeyPath keyPath) {
        List<String> list;
        KeyPath keyPath2 = keyPath;
        new ArrayList(keyPath2.keys);
        this.keys = list;
        this.resolvedElement = keyPath2.resolvedElement;
    }

    @CheckResult
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public KeyPath addKey(String key) {
        KeyPath keyPath;
        new KeyPath(this);
        KeyPath newKeyPath = keyPath;
        boolean add = newKeyPath.keys.add(key);
        return newKeyPath;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public KeyPath resolve(KeyPathElement element) {
        KeyPath keyPath;
        new KeyPath(this);
        KeyPath keyPath2 = keyPath;
        keyPath2.resolvedElement = element;
        return keyPath2;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public KeyPathElement getResolvedElement() {
        return this.resolvedElement;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean matches(String str, int i) {
        String key = str;
        int depth = i;
        if (isContainer(key)) {
            return true;
        }
        if (depth >= this.keys.size()) {
            return false;
        }
        if (this.keys.get(depth).equals(key) || this.keys.get(depth).equals("**") || this.keys.get(depth).equals(Marker.ANY_MARKER)) {
            return true;
        }
        return false;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public int incrementDepthBy(String str, int i) {
        String key = str;
        int depth = i;
        if (isContainer(key)) {
            return 0;
        }
        if (!this.keys.get(depth).equals("**")) {
            return 1;
        }
        if (depth == this.keys.size() - 1) {
            return 0;
        }
        if (this.keys.get(depth + 1).equals(key)) {
            return 2;
        }
        return 0;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean fullyResolvesTo(String str, int i) {
        boolean z;
        String key = str;
        int depth = i;
        if (depth >= this.keys.size()) {
            return false;
        }
        boolean isLastDepth = depth == this.keys.size() + -1;
        String keyAtDepth = this.keys.get(depth);
        if (!keyAtDepth.equals("**")) {
            boolean matches = keyAtDepth.equals(key) || keyAtDepth.equals(Marker.ANY_MARKER);
            if ((isLastDepth || (depth == this.keys.size() - 2 && endsWithGlobstar())) && matches) {
                z = true;
            } else {
                z = false;
            }
            return z;
        }
        if (!isLastDepth && this.keys.get(depth + 1).equals(key)) {
            return depth == this.keys.size() + -2 || (depth == this.keys.size() + -3 && endsWithGlobstar());
        } else if (isLastDepth) {
            return true;
        } else {
            if (depth + 1 < this.keys.size() - 1) {
                return false;
            }
            return this.keys.get(depth + 1).equals(key);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean propagateToChildren(String key, int i) {
        int depth = i;
        if ("__container".equals(key)) {
            return true;
        }
        return depth < this.keys.size() + -1 || this.keys.get(depth).equals("**");
    }

    private boolean isContainer(String key) {
        return "__container".equals(key);
    }

    private boolean endsWithGlobstar() {
        return this.keys.get(this.keys.size() - 1).equals("**");
    }

    public String keysToString() {
        return this.keys.toString();
    }

    public String toString() {
        StringBuilder sb;
        new StringBuilder();
        return sb.append("KeyPath{keys=").append(this.keys).append(",resolved=").append(this.resolvedElement != null).append('}').toString();
    }
}
