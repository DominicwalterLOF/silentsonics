package androidx.core.view;

import android.annotation.SuppressLint;
import android.os.Build;
import android.view.Menu;
import android.view.MenuItem;
import androidx.core.internal.view.SupportMenu;

public final class MenuCompat {
    @Deprecated
    public static void setShowAsAction(MenuItem item, int actionEnum) {
        item.setShowAsAction(actionEnum);
    }

    @SuppressLint({"NewApi"})
    public static void setGroupDividerEnabled(Menu menu, boolean z) {
        Menu menu2 = menu;
        boolean enabled = z;
        if (menu2 instanceof SupportMenu) {
            ((SupportMenu) menu2).setGroupDividerEnabled(enabled);
        } else if (Build.VERSION.SDK_INT >= 28) {
            menu2.setGroupDividerEnabled(enabled);
        }
    }

    private MenuCompat() {
    }
}
