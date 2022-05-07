package com.google.android.material.internal;

import android.content.Context;
import android.view.SubMenu;
import androidx.annotation.RestrictTo;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.SubMenuBuilder;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class NavigationMenu extends MenuBuilder {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NavigationMenu(Context context) {
        super(context);
    }

    public SubMenu addSubMenu(int group, int id, int categoryOrder, CharSequence title) {
        SubMenuBuilder subMenuBuilder;
        MenuItemImpl item = (MenuItemImpl) addInternal(group, id, categoryOrder, title);
        new NavigationSubMenu(getContext(), this, item);
        SubMenuBuilder subMenu = subMenuBuilder;
        item.setSubMenu(subMenu);
        return subMenu;
    }
}
