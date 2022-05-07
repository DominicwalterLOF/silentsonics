package androidx.appcompat.widget;

import android.os.Build;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class TooltipCompat {
    public static void setTooltipText(@NonNull View view, @Nullable CharSequence charSequence) {
        View view2 = view;
        CharSequence tooltipText = charSequence;
        if (Build.VERSION.SDK_INT >= 26) {
            view2.setTooltipText(tooltipText);
        } else {
            TooltipCompatHandler.setTooltipText(view2, tooltipText);
        }
    }

    private TooltipCompat() {
    }
}
