package androidx.appcompat.widget;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.PopupWindow;
import androidx.appcompat.R;
import androidx.core.widget.PopupWindowCompat;

class AppCompatPopupWindow extends PopupWindow {
    private static final boolean COMPAT_OVERLAP_ANCHOR = (Build.VERSION.SDK_INT < 21);
    private boolean mOverlapAnchor;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public AppCompatPopupWindow(@androidx.annotation.NonNull android.content.Context r10, @androidx.annotation.Nullable android.util.AttributeSet r11, @androidx.annotation.AttrRes int r12) {
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
            r5 = r1
            r6 = r2
            r7 = r3
            r8 = 0
            r4.init(r5, r6, r7, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.AppCompatPopupWindow.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public AppCompatPopupWindow(@androidx.annotation.NonNull android.content.Context r11, @androidx.annotation.Nullable android.util.AttributeSet r12, @androidx.annotation.AttrRes int r13, @androidx.annotation.StyleRes int r14) {
        /*
            r10 = this;
            r0 = r10
            r1 = r11
            r2 = r12
            r3 = r13
            r4 = r14
            r5 = r0
            r6 = r1
            r7 = r2
            r8 = r3
            r9 = r4
            r5.<init>(r6, r7, r8, r9)
            r5 = r0
            r6 = r1
            r7 = r2
            r8 = r3
            r9 = r4
            r5.init(r6, r7, r8, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.AppCompatPopupWindow.<init>(android.content.Context, android.util.AttributeSet, int, int):void");
    }

    private void init(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        TintTypedArray a = TintTypedArray.obtainStyledAttributes(context, attrs, R.styleable.PopupWindow, defStyleAttr, defStyleRes);
        if (a.hasValue(R.styleable.PopupWindow_overlapAnchor)) {
            setSupportOverlapAnchor(a.getBoolean(R.styleable.PopupWindow_overlapAnchor, false));
        }
        setBackgroundDrawable(a.getDrawable(R.styleable.PopupWindow_android_popupBackground));
        a.recycle();
    }

    public void showAsDropDown(View view, int i, int i2) {
        View anchor = view;
        int xoff = i;
        int yoff = i2;
        if (COMPAT_OVERLAP_ANCHOR && this.mOverlapAnchor) {
            yoff -= anchor.getHeight();
        }
        super.showAsDropDown(anchor, xoff, yoff);
    }

    public void showAsDropDown(View view, int i, int i2, int i3) {
        View anchor = view;
        int xoff = i;
        int yoff = i2;
        int gravity = i3;
        if (COMPAT_OVERLAP_ANCHOR && this.mOverlapAnchor) {
            yoff -= anchor.getHeight();
        }
        super.showAsDropDown(anchor, xoff, yoff, gravity);
    }

    public void update(View view, int i, int i2, int i3, int i4) {
        View anchor = view;
        int xoff = i;
        int yoff = i2;
        int width = i3;
        int height = i4;
        if (COMPAT_OVERLAP_ANCHOR && this.mOverlapAnchor) {
            yoff -= anchor.getHeight();
        }
        super.update(anchor, xoff, yoff, width, height);
    }

    private void setSupportOverlapAnchor(boolean z) {
        boolean overlapAnchor = z;
        if (COMPAT_OVERLAP_ANCHOR) {
            this.mOverlapAnchor = overlapAnchor;
            return;
        }
        PopupWindowCompat.setOverlapAnchor(this, overlapAnchor);
    }
}
