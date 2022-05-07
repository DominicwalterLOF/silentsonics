package androidx.appcompat.view.menu;

import android.content.Context;
import android.view.MenuItem;
import android.view.SubMenu;
import androidx.collection.ArrayMap;
import androidx.core.internal.view.SupportMenuItem;
import androidx.core.internal.view.SupportSubMenu;
import java.util.Iterator;
import java.util.Map;

abstract class BaseMenuWrapper<T> extends BaseWrapper<T> {
    final Context mContext;
    private Map<SupportMenuItem, MenuItem> mMenuItems;
    private Map<SupportSubMenu, SubMenu> mSubMenus;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BaseMenuWrapper(Context context, T object) {
        super(object);
        this.mContext = context;
    }

    /* access modifiers changed from: package-private */
    public final MenuItem getMenuItemWrapper(MenuItem menuItem) {
        Map<SupportMenuItem, MenuItem> map;
        MenuItem menuItem2 = menuItem;
        if (!(menuItem2 instanceof SupportMenuItem)) {
            return menuItem2;
        }
        SupportMenuItem supportMenuItem = (SupportMenuItem) menuItem2;
        if (this.mMenuItems == null) {
            new ArrayMap();
            this.mMenuItems = map;
        }
        MenuItem wrappedItem = this.mMenuItems.get(menuItem2);
        if (null == wrappedItem) {
            wrappedItem = MenuWrapperFactory.wrapSupportMenuItem(this.mContext, supportMenuItem);
            MenuItem put = this.mMenuItems.put(supportMenuItem, wrappedItem);
        }
        return wrappedItem;
    }

    /* access modifiers changed from: package-private */
    public final SubMenu getSubMenuWrapper(SubMenu subMenu) {
        Map<SupportSubMenu, SubMenu> map;
        SubMenu subMenu2 = subMenu;
        if (!(subMenu2 instanceof SupportSubMenu)) {
            return subMenu2;
        }
        SupportSubMenu supportSubMenu = (SupportSubMenu) subMenu2;
        if (this.mSubMenus == null) {
            new ArrayMap();
            this.mSubMenus = map;
        }
        SubMenu wrappedMenu = this.mSubMenus.get(supportSubMenu);
        if (null == wrappedMenu) {
            wrappedMenu = MenuWrapperFactory.wrapSupportSubMenu(this.mContext, supportSubMenu);
            SubMenu put = this.mSubMenus.put(supportSubMenu, wrappedMenu);
        }
        return wrappedMenu;
    }

    /* access modifiers changed from: package-private */
    public final void internalClear() {
        if (this.mMenuItems != null) {
            this.mMenuItems.clear();
        }
        if (this.mSubMenus != null) {
            this.mSubMenus.clear();
        }
    }

    /* access modifiers changed from: package-private */
    public final void internalRemoveGroup(int i) {
        int groupId = i;
        if (this.mMenuItems != null) {
            Iterator<SupportMenuItem> iterator = this.mMenuItems.keySet().iterator();
            while (iterator.hasNext()) {
                if (groupId == iterator.next().getGroupId()) {
                    iterator.remove();
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void internalRemoveItem(int i) {
        int id = i;
        if (this.mMenuItems != null) {
            Iterator<SupportMenuItem> iterator = this.mMenuItems.keySet().iterator();
            while (iterator.hasNext()) {
                if (id == iterator.next().getItemId()) {
                    iterator.remove();
                    return;
                }
            }
        }
    }
}
