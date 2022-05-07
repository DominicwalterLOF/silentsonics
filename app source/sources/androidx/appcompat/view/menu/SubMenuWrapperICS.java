package androidx.appcompat.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.annotation.RestrictTo;
import androidx.core.internal.view.SupportSubMenu;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
class SubMenuWrapperICS extends MenuWrapperICS implements SubMenu {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SubMenuWrapperICS(Context context, SupportSubMenu subMenu) {
        super(context, subMenu);
    }

    public SupportSubMenu getWrappedObject() {
        return (SupportSubMenu) this.mWrappedObject;
    }

    public SubMenu setHeaderTitle(int titleRes) {
        SubMenu headerTitle = getWrappedObject().setHeaderTitle(titleRes);
        return this;
    }

    public SubMenu setHeaderTitle(CharSequence title) {
        SubMenu headerTitle = getWrappedObject().setHeaderTitle(title);
        return this;
    }

    public SubMenu setHeaderIcon(int iconRes) {
        SubMenu headerIcon = getWrappedObject().setHeaderIcon(iconRes);
        return this;
    }

    public SubMenu setHeaderIcon(Drawable icon) {
        SubMenu headerIcon = getWrappedObject().setHeaderIcon(icon);
        return this;
    }

    public SubMenu setHeaderView(View view) {
        SubMenu headerView = getWrappedObject().setHeaderView(view);
        return this;
    }

    public void clearHeader() {
        getWrappedObject().clearHeader();
    }

    public SubMenu setIcon(int iconRes) {
        SubMenu icon = getWrappedObject().setIcon(iconRes);
        return this;
    }

    public SubMenu setIcon(Drawable icon) {
        SubMenu icon2 = getWrappedObject().setIcon(icon);
        return this;
    }

    public MenuItem getItem() {
        return getMenuItemWrapper(getWrappedObject().getItem());
    }
}
