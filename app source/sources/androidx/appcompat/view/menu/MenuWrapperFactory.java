package androidx.appcompat.view.menu;

import android.content.Context;
import android.os.Build;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import androidx.annotation.RestrictTo;
import androidx.core.internal.view.SupportMenu;
import androidx.core.internal.view.SupportMenuItem;
import androidx.core.internal.view.SupportSubMenu;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class MenuWrapperFactory {
    private MenuWrapperFactory() {
    }

    public static Menu wrapSupportMenu(Context context, SupportMenu supportMenu) {
        Menu menu;
        new MenuWrapperICS(context, supportMenu);
        return menu;
    }

    public static MenuItem wrapSupportMenuItem(Context context, SupportMenuItem supportMenuItem) {
        MenuItem menuItem;
        MenuItem menuItem2;
        Context context2 = context;
        SupportMenuItem supportMenuItem2 = supportMenuItem;
        if (Build.VERSION.SDK_INT >= 16) {
            new MenuItemWrapperJB(context2, supportMenuItem2);
            return menuItem2;
        }
        new MenuItemWrapperICS(context2, supportMenuItem2);
        return menuItem;
    }

    public static SubMenu wrapSupportSubMenu(Context context, SupportSubMenu supportSubMenu) {
        SubMenu subMenu;
        new SubMenuWrapperICS(context, supportSubMenu);
        return subMenu;
    }
}
