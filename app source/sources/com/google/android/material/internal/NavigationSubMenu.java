package com.google.android.material.internal;

import android.content.Context;
import androidx.annotation.RestrictTo;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.SubMenuBuilder;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class NavigationSubMenu extends SubMenuBuilder {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NavigationSubMenu(Context context, NavigationMenu menu, MenuItemImpl item) {
        super(context, menu, item);
    }

    public void onItemsChanged(boolean z) {
        boolean structureChanged = z;
        super.onItemsChanged(structureChanged);
        ((MenuBuilder) getParentMenu()).onItemsChanged(structureChanged);
    }
}
