package androidx.core.widget;

import android.os.Build;
import android.view.View;
import android.widget.ListPopupWindow;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public final class ListPopupWindowCompat {
    private ListPopupWindowCompat() {
    }

    @Deprecated
    public static View.OnTouchListener createDragToOpenListener(Object listPopupWindow, View src) {
        return createDragToOpenListener((ListPopupWindow) listPopupWindow, src);
    }

    @Nullable
    public static View.OnTouchListener createDragToOpenListener(@NonNull ListPopupWindow listPopupWindow, @NonNull View view) {
        ListPopupWindow listPopupWindow2 = listPopupWindow;
        View src = view;
        if (Build.VERSION.SDK_INT >= 19) {
            return listPopupWindow2.createDragToOpenListener(src);
        }
        return null;
    }
}
