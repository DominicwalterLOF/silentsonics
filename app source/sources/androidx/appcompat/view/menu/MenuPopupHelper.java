package androidx.appcompat.view.menu;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.ListView;
import android.widget.PopupWindow;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.appcompat.R;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class MenuPopupHelper implements MenuHelper {
    private static final int TOUCH_EPICENTER_SIZE_DP = 48;
    private View mAnchorView;
    private final Context mContext;
    private int mDropDownGravity;
    private boolean mForceShowIcon;
    private final PopupWindow.OnDismissListener mInternalOnDismissListener;
    private final MenuBuilder mMenu;
    private PopupWindow.OnDismissListener mOnDismissListener;
    private final boolean mOverflowOnly;
    private MenuPopup mPopup;
    private final int mPopupStyleAttr;
    private final int mPopupStyleRes;
    private MenuPresenter.Callback mPresenterCallback;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public MenuPopupHelper(@NonNull Context context, @NonNull MenuBuilder menu) {
        this(context, menu, (View) null, false, R.attr.popupMenuStyle, 0);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public MenuPopupHelper(@NonNull Context context, @NonNull MenuBuilder menu, @NonNull View anchorView) {
        this(context, menu, anchorView, false, R.attr.popupMenuStyle, 0);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public MenuPopupHelper(@NonNull Context context, @NonNull MenuBuilder menu, @NonNull View anchorView, boolean overflowOnly, @AttrRes int popupStyleAttr) {
        this(context, menu, anchorView, overflowOnly, popupStyleAttr, 0);
    }

    public MenuPopupHelper(@NonNull Context context, @NonNull MenuBuilder menu, @NonNull View anchorView, boolean overflowOnly, @AttrRes int popupStyleAttr, @StyleRes int popupStyleRes) {
        PopupWindow.OnDismissListener onDismissListener;
        this.mDropDownGravity = GravityCompat.START;
        new PopupWindow.OnDismissListener(this) {
            final /* synthetic */ MenuPopupHelper this$0;

            {
                this.this$0 = this$0;
            }

            public void onDismiss() {
                this.this$0.onDismiss();
            }
        };
        this.mInternalOnDismissListener = onDismissListener;
        this.mContext = context;
        this.mMenu = menu;
        this.mAnchorView = anchorView;
        this.mOverflowOnly = overflowOnly;
        this.mPopupStyleAttr = popupStyleAttr;
        this.mPopupStyleRes = popupStyleRes;
    }

    public void setOnDismissListener(@Nullable PopupWindow.OnDismissListener listener) {
        PopupWindow.OnDismissListener onDismissListener = listener;
        this.mOnDismissListener = onDismissListener;
    }

    public void setAnchorView(@NonNull View anchor) {
        View view = anchor;
        this.mAnchorView = view;
    }

    public void setForceShowIcon(boolean z) {
        boolean forceShowIcon = z;
        this.mForceShowIcon = forceShowIcon;
        if (this.mPopup != null) {
            this.mPopup.setForceShowIcon(forceShowIcon);
        }
    }

    public void setGravity(int gravity) {
        int i = gravity;
        this.mDropDownGravity = i;
    }

    public int getGravity() {
        return this.mDropDownGravity;
    }

    public void show() {
        Throwable th;
        if (!tryShow()) {
            Throwable th2 = th;
            new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
            throw th2;
        }
    }

    public void show(int x, int y) {
        Throwable th;
        if (!tryShow(x, y)) {
            Throwable th2 = th;
            new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
            throw th2;
        }
    }

    @NonNull
    public MenuPopup getPopup() {
        if (this.mPopup == null) {
            this.mPopup = createPopup();
        }
        return this.mPopup;
    }

    public boolean tryShow() {
        if (isShowing()) {
            return true;
        }
        if (this.mAnchorView == null) {
            return false;
        }
        showPopup(0, 0, false, false);
        return true;
    }

    public boolean tryShow(int i, int i2) {
        int x = i;
        int y = i2;
        if (isShowing()) {
            return true;
        }
        if (this.mAnchorView == null) {
            return false;
        }
        showPopup(x, y, true, true);
        return true;
    }

    @NonNull
    private MenuPopup createPopup() {
        Point point;
        MenuPopup menuPopup;
        MenuPopup popup;
        MenuPopup menuPopup2;
        Display display = ((WindowManager) this.mContext.getSystemService("window")).getDefaultDisplay();
        new Point();
        Point displaySize = point;
        if (Build.VERSION.SDK_INT >= 17) {
            display.getRealSize(displaySize);
        } else {
            display.getSize(displaySize);
        }
        if (Math.min(displaySize.x, displaySize.y) >= this.mContext.getResources().getDimensionPixelSize(R.dimen.abc_cascading_menus_min_smallest_width)) {
            new CascadingMenuPopup(this.mContext, this.mAnchorView, this.mPopupStyleAttr, this.mPopupStyleRes, this.mOverflowOnly);
            popup = menuPopup2;
        } else {
            new StandardMenuPopup(this.mContext, this.mMenu, this.mAnchorView, this.mPopupStyleAttr, this.mPopupStyleRes, this.mOverflowOnly);
            popup = menuPopup;
        }
        popup.addMenu(this.mMenu);
        popup.setOnDismissListener(this.mInternalOnDismissListener);
        popup.setAnchorView(this.mAnchorView);
        popup.setCallback(this.mPresenterCallback);
        popup.setForceShowIcon(this.mForceShowIcon);
        popup.setGravity(this.mDropDownGravity);
        return popup;
    }

    private void showPopup(int i, int i2, boolean useOffsets, boolean showTitle) {
        Rect epicenter;
        int xOffset = i;
        int yOffset = i2;
        MenuPopup popup = getPopup();
        popup.setShowTitle(showTitle);
        if (useOffsets) {
            if ((GravityCompat.getAbsoluteGravity(this.mDropDownGravity, ViewCompat.getLayoutDirection(this.mAnchorView)) & 7) == 5) {
                xOffset -= this.mAnchorView.getWidth();
            }
            popup.setHorizontalOffset(xOffset);
            popup.setVerticalOffset(yOffset);
            int halfSize = (int) ((48.0f * this.mContext.getResources().getDisplayMetrics().density) / 2.0f);
            new Rect(xOffset - halfSize, yOffset - halfSize, xOffset + halfSize, yOffset + halfSize);
            popup.setEpicenterBounds(epicenter);
        }
        popup.show();
    }

    public void dismiss() {
        if (isShowing()) {
            this.mPopup.dismiss();
        }
    }

    /* access modifiers changed from: protected */
    public void onDismiss() {
        this.mPopup = null;
        if (this.mOnDismissListener != null) {
            this.mOnDismissListener.onDismiss();
        }
    }

    public boolean isShowing() {
        return this.mPopup != null && this.mPopup.isShowing();
    }

    public void setPresenterCallback(@Nullable MenuPresenter.Callback callback) {
        MenuPresenter.Callback cb = callback;
        this.mPresenterCallback = cb;
        if (this.mPopup != null) {
            this.mPopup.setCallback(cb);
        }
    }

    public ListView getListView() {
        return getPopup().getListView();
    }
}
