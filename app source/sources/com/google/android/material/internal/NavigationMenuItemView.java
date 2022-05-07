package com.google.android.material.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewStub;
import android.widget.CheckedTextView;
import android.widget.FrameLayout;
import androidx.annotation.RestrictTo;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.appcompat.widget.TooltipCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.widget.TextViewCompat;
import com.google.android.material.R;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class NavigationMenuItemView extends ForegroundLinearLayout implements MenuView.ItemView {
    private static final int[] CHECKED_STATE_SET = {16842912};
    private final AccessibilityDelegateCompat accessibilityDelegate;
    private FrameLayout actionArea;
    boolean checkable;
    private Drawable emptyDrawable;
    private boolean hasIconTintList;
    private final int iconSize;
    private ColorStateList iconTintList;
    private MenuItemImpl itemData;
    private boolean needsEmptyIcon;
    private final CheckedTextView textView;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public NavigationMenuItemView(Context context) {
        this(context, (AttributeSet) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public NavigationMenuItemView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public NavigationMenuItemView(android.content.Context r10, android.util.AttributeSet r11, int r12) {
        /*
            r9 = this;
            r0 = r9
            r1 = r10
            r2 = r11
            r3 = r12
            r4 = r0
            r5 = r1
            r6 = r2
            r7 = r3
            r4.<init>(r5, r6, r7)
            r4 = r0
            com.google.android.material.internal.NavigationMenuItemView$1 r5 = new com.google.android.material.internal.NavigationMenuItemView$1
            r8 = r5
            r5 = r8
            r6 = r8
            r7 = r0
            r6.<init>(r7)
            r4.accessibilityDelegate = r5
            r4 = r0
            r5 = 0
            r4.setOrientation(r5)
            r4 = r1
            android.view.LayoutInflater r4 = android.view.LayoutInflater.from(r4)
            int r5 = com.google.android.material.R.layout.design_navigation_menu_item
            r6 = r0
            r7 = 1
            android.view.View r4 = r4.inflate(r5, r6, r7)
            r4 = r0
            r5 = r1
            android.content.res.Resources r5 = r5.getResources()
            int r6 = com.google.android.material.R.dimen.design_navigation_icon_size
            int r5 = r5.getDimensionPixelSize(r6)
            r4.iconSize = r5
            r4 = r0
            r5 = r0
            int r6 = com.google.android.material.R.id.design_menu_item_text
            android.view.View r5 = r5.findViewById(r6)
            android.widget.CheckedTextView r5 = (android.widget.CheckedTextView) r5
            r4.textView = r5
            r4 = r0
            android.widget.CheckedTextView r4 = r4.textView
            r5 = 1
            r4.setDuplicateParentStateEnabled(r5)
            r4 = r0
            android.widget.CheckedTextView r4 = r4.textView
            r5 = r0
            androidx.core.view.AccessibilityDelegateCompat r5 = r5.accessibilityDelegate
            androidx.core.view.ViewCompat.setAccessibilityDelegate(r4, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.internal.NavigationMenuItemView.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    public void initialize(MenuItemImpl menuItemImpl, int i) {
        MenuItemImpl itemData2 = menuItemImpl;
        int i2 = i;
        this.itemData = itemData2;
        setVisibility(itemData2.isVisible() ? 0 : 8);
        if (getBackground() == null) {
            ViewCompat.setBackground(this, createDefaultBackground());
        }
        setCheckable(itemData2.isCheckable());
        setChecked(itemData2.isChecked());
        setEnabled(itemData2.isEnabled());
        setTitle(itemData2.getTitle());
        setIcon(itemData2.getIcon());
        setActionView(itemData2.getActionView());
        setContentDescription(itemData2.getContentDescription());
        TooltipCompat.setTooltipText(this, itemData2.getTooltipText());
        adjustAppearance();
    }

    private boolean shouldExpandActionArea() {
        return this.itemData.getTitle() == null && this.itemData.getIcon() == null && this.itemData.getActionView() != null;
    }

    private void adjustAppearance() {
        if (shouldExpandActionArea()) {
            this.textView.setVisibility(8);
            if (this.actionArea != null) {
                LinearLayoutCompat.LayoutParams params = (LinearLayoutCompat.LayoutParams) this.actionArea.getLayoutParams();
                params.width = -1;
                this.actionArea.setLayoutParams(params);
                return;
            }
            return;
        }
        this.textView.setVisibility(0);
        if (this.actionArea != null) {
            LinearLayoutCompat.LayoutParams params2 = (LinearLayoutCompat.LayoutParams) this.actionArea.getLayoutParams();
            params2.width = -2;
            this.actionArea.setLayoutParams(params2);
        }
    }

    public void recycle() {
        if (this.actionArea != null) {
            this.actionArea.removeAllViews();
        }
        this.textView.setCompoundDrawables((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
    }

    private void setActionView(View view) {
        View actionView = view;
        if (actionView != null) {
            if (this.actionArea == null) {
                this.actionArea = (FrameLayout) ((ViewStub) findViewById(R.id.design_menu_item_action_area_stub)).inflate();
            }
            this.actionArea.removeAllViews();
            this.actionArea.addView(actionView);
        }
    }

    private StateListDrawable createDefaultBackground() {
        TypedValue typedValue;
        StateListDrawable stateListDrawable;
        Drawable drawable;
        Drawable drawable2;
        new TypedValue();
        TypedValue value = typedValue;
        if (!getContext().getTheme().resolveAttribute(androidx.appcompat.R.attr.colorControlHighlight, value, true)) {
            return null;
        }
        new StateListDrawable();
        StateListDrawable drawable3 = stateListDrawable;
        new ColorDrawable(value.data);
        drawable3.addState(CHECKED_STATE_SET, drawable);
        new ColorDrawable(0);
        drawable3.addState(EMPTY_STATE_SET, drawable2);
        return drawable3;
    }

    public MenuItemImpl getItemData() {
        return this.itemData;
    }

    public void setTitle(CharSequence title) {
        this.textView.setText(title);
    }

    public void setCheckable(boolean z) {
        boolean checkable2 = z;
        refreshDrawableState();
        if (this.checkable != checkable2) {
            this.checkable = checkable2;
            this.accessibilityDelegate.sendAccessibilityEvent(this.textView, 2048);
        }
    }

    public void setChecked(boolean checked) {
        refreshDrawableState();
        this.textView.setChecked(checked);
    }

    public void setShortcut(boolean showShortcut, char shortcutKey) {
    }

    public void setIcon(Drawable drawable) {
        Drawable icon = drawable;
        if (icon != null) {
            if (this.hasIconTintList) {
                Drawable.ConstantState state = icon.getConstantState();
                icon = DrawableCompat.wrap(state == null ? icon : state.newDrawable()).mutate();
                DrawableCompat.setTintList(icon, this.iconTintList);
            }
            icon.setBounds(0, 0, this.iconSize, this.iconSize);
        } else if (this.needsEmptyIcon) {
            if (this.emptyDrawable == null) {
                this.emptyDrawable = ResourcesCompat.getDrawable(getResources(), R.drawable.navigation_empty_icon, getContext().getTheme());
                if (this.emptyDrawable != null) {
                    this.emptyDrawable.setBounds(0, 0, this.iconSize, this.iconSize);
                }
            }
            icon = this.emptyDrawable;
        }
        TextViewCompat.setCompoundDrawablesRelative(this.textView, icon, (Drawable) null, (Drawable) null, (Drawable) null);
    }

    public boolean prefersCondensedTitle() {
        return false;
    }

    public boolean showsIcon() {
        return true;
    }

    /* access modifiers changed from: protected */
    public int[] onCreateDrawableState(int extraSpace) {
        int[] drawableState = super.onCreateDrawableState(extraSpace + 1);
        if (this.itemData != null && this.itemData.isCheckable() && this.itemData.isChecked()) {
            int[] mergeDrawableStates = mergeDrawableStates(drawableState, CHECKED_STATE_SET);
        }
        return drawableState;
    }

    /* access modifiers changed from: package-private */
    public void setIconTintList(ColorStateList tintList) {
        this.iconTintList = tintList;
        this.hasIconTintList = this.iconTintList != null;
        if (this.itemData != null) {
            setIcon(this.itemData.getIcon());
        }
    }

    public void setTextAppearance(int textAppearance) {
        TextViewCompat.setTextAppearance(this.textView, textAppearance);
    }

    public void setTextColor(ColorStateList colors) {
        this.textView.setTextColor(colors);
    }

    public void setNeedsEmptyIcon(boolean needsEmptyIcon2) {
        boolean z = needsEmptyIcon2;
        this.needsEmptyIcon = z;
    }

    public void setHorizontalPadding(int i) {
        int padding = i;
        setPadding(padding, 0, padding, 0);
    }

    public void setIconPadding(int padding) {
        this.textView.setCompoundDrawablePadding(padding);
    }
}
