package androidx.core.util;

import androidx.annotation.RestrictTo;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class DebugUtils {
    public static void buildShortClassTag(Object obj, StringBuilder sb) {
        Object cls = obj;
        StringBuilder out = sb;
        if (cls == null) {
            StringBuilder append = out.append("null");
            return;
        }
        String simpleName = cls.getClass().getSimpleName();
        if (simpleName == null || simpleName.length() <= 0) {
            simpleName = cls.getClass().getName();
            int end = simpleName.lastIndexOf(46);
            if (end > 0) {
                simpleName = simpleName.substring(end + 1);
            }
        }
        StringBuilder append2 = out.append(simpleName);
        StringBuilder append3 = out.append('{');
        StringBuilder append4 = out.append(Integer.toHexString(System.identityHashCode(cls)));
    }

    private DebugUtils() {
    }
}
