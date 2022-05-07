package androidx.core.util;

import android.os.Build;
import androidx.annotation.Nullable;
import java.util.Arrays;
import java.util.Objects;

public class ObjectsCompat {
    private ObjectsCompat() {
    }

    public static boolean equals(@Nullable Object obj, @Nullable Object obj2) {
        Object a = obj;
        Object b = obj2;
        if (Build.VERSION.SDK_INT >= 19) {
            return Objects.equals(a, b);
        }
        return a == b || (a != null && a.equals(b));
    }

    public static int hashCode(@Nullable Object obj) {
        Object o = obj;
        return o != null ? o.hashCode() : 0;
    }

    public static int hash(@Nullable Object... objArr) {
        Object[] values = objArr;
        if (Build.VERSION.SDK_INT >= 19) {
            return Objects.hash(values);
        }
        return Arrays.hashCode(values);
    }
}
