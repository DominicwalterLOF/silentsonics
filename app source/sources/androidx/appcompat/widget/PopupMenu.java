package androidx.appcompat.widget;

import android.content.Context;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.PopupWindow;
import androidx.annotation.AttrRes;
import androidx.annotation.MenuRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.appcompat.R;
import androidx.appcompat.view.SupportMenuInflater;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPopupHelper;
import androidx.appcompat.view.menu.ShowableListMenu;

public class PopupMenu {
    private final View mAnchor;
    private final Context mContext;
    private View.OnTouchListener mDragListener;
    private final MenuBuilder mMenu;
    OnMenuItemClickListener mMenuItemClickListener;
    OnDismissListener mOnDismissListener;
    final MenuPopupHelper mPopup;

    public interface OnDismissListener {
        void onDismiss(PopupMenu popupMenu);
    }

    public interface OnMenuItemClickListener {
        boolean onMenuItemClick(MenuItem menuItem);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public PopupMenu(@NonNull Context context, @NonNull View anchor) {
        this(context, anchor, 0);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public PopupMenu(@NonNull Context context, @NonNull View anchor, int gravity) {
        this(context, anchor, gravity, R.attr.popupMenuStyle, 0);
    }

    public PopupMenu(@NonNull Context context, @NonNull View view, int gravity, @AttrRes int popupStyleAttr, @StyleRes int popupStyleRes) {
        MenuBuilder menuBuilder;
        MenuBuilder.Callback callback;
        MenuPopupHelper menuPopupHelper;
        PopupWindow.OnDismissListener onDismissListener;
        Context context2 = context;
        View anchor = view;
        this.mContext = context2;
        this.mAnchor = anchor;
        new MenuBuilder(context2);
        this.mMenu = menuBuilder;
        new MenuBuilder.Callback(this) {
            final /* synthetic */ PopupMenu this$0;

            {
                this.this$0 = this$0;
            }

            public boolean onMenuItemSelected(MenuBuilder menuBuilder, MenuItem menuItem) {
                MenuBuilder menuBuilder2 = menuBuilder;
                MenuItem item = menuItem;
                if (this.this$0.mMenuItemClickListener != null) {
                    return this.this$0.mMenuItemClickListener.onMenuItemClick(item);
                }
                return false;
            }

            public void onMenuModeChange(MenuBuilder menu) {
            }
        };
        this.mMenu.setCallback(callback);
        new MenuPopupHelper(context2, this.mMenu, anchor, false, popupStyleAttr, popupStyleRes);
        this.mPopup = menuPopupHelper;
        this.mPopup.setGravity(gravity);
        new PopupWindow.OnDismissListener(this) {
            final /* synthetic */ PopupMenu this$0;

            {
                this.this$0 = this$0;
            }

            public void onDismiss() {
                if (this.this$0.mOnDismissListener != null) {
                    this.this$0.mOnDismissListener.onDismiss(this.this$0);
                }
            }
        };
        this.mPopup.setOnDismissListener(onDismissListener);
    }

    public void setGravity(int gravity) {
        this.mPopup.setGravity(gravity);
    }

    public int getGravity() {
        return this.mPopup.getGravity();
    }

    @NonNull
    public View.OnTouchListener getDragToOpenListener() {
        View.OnTouchListener onTouchListener;
        if (this.mDragListener == null) {
            new ForwardingListener(this, this.mAnchor) {
                final /* synthetic */ PopupMenu this$0;

                {
                    this.this$0 = this$0;
                }

                /* access modifiers changed from: protected */
                public boolean onForwardingStarted() {
                    this.this$0.show();
                    return true;
                }

                /* access modifiers changed from: protected */
                public boolean onForwardingStopped() {
                    this.this$0.dismiss();
                    return true;
                }

                public ShowableListMenu getPopup() {
                    return this.this$0.mPopup.getPopup();
                }
            };
            this.mDragListener = onTouchListener;
        }
        return this.mDragListener;
    }

    @NonNull
    public Menu getMenu() {
        return this.mMenu;
    }

    @NonNull
    public MenuInflater getMenuInflater() {
        MenuInflater menuInflater;
        new SupportMenuInflater(this.mContext);
        return menuInflater;
    }

    public void inflate(@MenuRes int menuRes) {
        getMenuInflater().inflate(menuRes, this.mMenu);
    }

    public void show() {
        this.mPopup.show();
    }

    public void dismiss() {
        this.mPopup.dismiss();
    }

    public void setOnMenuItemClickListener(@Nullable OnMenuItemClickListener listener) {
        OnMenuItemClickListener onMenuItemClickListener = listener;
        this.mMenuItemClickListener = onMenuItemClickListener;
    }

    public void setOnDismissListener(@Nullable OnDismissListener listener) {
        OnDismissListener onDismissListener = listener;
        this.mOnDismissListener = onDismissListener;
    }

    /* access modifiers changed from: package-private */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public ListView getMenuListView() {
        if (!this.mPopup.isShowing()) {
            return null;
        }
        return this.mPopup.getListView();
    }
}
