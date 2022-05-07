package com.google.android.material.internal;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageButton;
import androidx.annotation.RestrictTo;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class VisibilityAwareImageButton extends ImageButton {
    private int userSetVisibility;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public VisibilityAwareImageButton(Context context) {
        this(context, (AttributeSet) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public VisibilityAwareImageButton(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VisibilityAwareImageButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.userSetVisibility = getVisibility();
    }

    public void setVisibility(int visibility) {
        internalSetVisibility(visibility, true);
    }

    public final void internalSetVisibility(int i, boolean fromUser) {
        int visibility = i;
        super.setVisibility(visibility);
        if (fromUser) {
            this.userSetVisibility = visibility;
        }
    }

    public final int getUserSetVisibility() {
        return this.userSetVisibility;
    }
}
