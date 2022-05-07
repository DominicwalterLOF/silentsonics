package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.CheckBox;
import androidx.annotation.DrawableRes;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.widget.TintableCompoundButton;

public class AppCompatCheckBox extends CheckBox implements TintableCompoundButton {
    private final AppCompatCompoundButtonHelper mCompoundButtonHelper;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public AppCompatCheckBox(Context context) {
        this(context, (AttributeSet) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public AppCompatCheckBox(Context context, AttributeSet attrs) {
        this(context, attrs, R.attr.checkboxStyle);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public AppCompatCheckBox(android.content.Context r10, android.util.AttributeSet r11, int r12) {
        /*
            r9 = this;
            r0 = r9
            r1 = r10
            r2 = r11
            r3 = r12
            r4 = r0
            r5 = r1
            android.content.Context r5 = androidx.appcompat.widget.TintContextWrapper.wrap(r5)
            r6 = r2
            r7 = r3
            r4.<init>(r5, r6, r7)
            r4 = r0
            androidx.appcompat.widget.AppCompatCompoundButtonHelper r5 = new androidx.appcompat.widget.AppCompatCompoundButtonHelper
            r8 = r5
            r5 = r8
            r6 = r8
            r7 = r0
            r6.<init>(r7)
            r4.mCompoundButtonHelper = r5
            r4 = r0
            androidx.appcompat.widget.AppCompatCompoundButtonHelper r4 = r4.mCompoundButtonHelper
            r5 = r2
            r6 = r3
            r4.loadFromAttributes(r5, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.AppCompatCheckBox.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    public void setButtonDrawable(Drawable buttonDrawable) {
        super.setButtonDrawable(buttonDrawable);
        if (this.mCompoundButtonHelper != null) {
            this.mCompoundButtonHelper.onSetButtonDrawable();
        }
    }

    public void setButtonDrawable(@DrawableRes int resId) {
        setButtonDrawable(AppCompatResources.getDrawable(getContext(), resId));
    }

    public int getCompoundPaddingLeft() {
        int value = super.getCompoundPaddingLeft();
        return this.mCompoundButtonHelper != null ? this.mCompoundButtonHelper.getCompoundPaddingLeft(value) : value;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setSupportButtonTintList(@Nullable ColorStateList colorStateList) {
        ColorStateList tint = colorStateList;
        if (this.mCompoundButtonHelper != null) {
            this.mCompoundButtonHelper.setSupportButtonTintList(tint);
        }
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public ColorStateList getSupportButtonTintList() {
        return this.mCompoundButtonHelper != null ? this.mCompoundButtonHelper.getSupportButtonTintList() : null;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setSupportButtonTintMode(@Nullable PorterDuff.Mode mode) {
        PorterDuff.Mode tintMode = mode;
        if (this.mCompoundButtonHelper != null) {
            this.mCompoundButtonHelper.setSupportButtonTintMode(tintMode);
        }
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public PorterDuff.Mode getSupportButtonTintMode() {
        return this.mCompoundButtonHelper != null ? this.mCompoundButtonHelper.getSupportButtonTintMode() : null;
    }
}
