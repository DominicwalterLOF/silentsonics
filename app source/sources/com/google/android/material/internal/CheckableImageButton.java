package com.google.android.material.internal;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.widget.Checkable;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class CheckableImageButton extends AppCompatImageButton implements Checkable {
    private static final int[] DRAWABLE_STATE_CHECKED = {16842912};
    private boolean checked;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public CheckableImageButton(Context context) {
        this(context, (AttributeSet) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public CheckableImageButton(Context context, AttributeSet attrs) {
        this(context, attrs, R.attr.imageButtonStyle);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CheckableImageButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        AccessibilityDelegateCompat accessibilityDelegateCompat;
        new AccessibilityDelegateCompat(this) {
            final /* synthetic */ CheckableImageButton this$0;

            {
                this.this$0 = this$0;
            }

            public void onInitializeAccessibilityEvent(View host, AccessibilityEvent accessibilityEvent) {
                AccessibilityEvent event = accessibilityEvent;
                super.onInitializeAccessibilityEvent(host, event);
                event.setChecked(this.this$0.isChecked());
            }

            public void onInitializeAccessibilityNodeInfo(View host, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
                AccessibilityNodeInfoCompat info = accessibilityNodeInfoCompat;
                super.onInitializeAccessibilityNodeInfo(host, info);
                info.setCheckable(true);
                info.setChecked(this.this$0.isChecked());
            }
        };
        ViewCompat.setAccessibilityDelegate(this, accessibilityDelegateCompat);
    }

    public void setChecked(boolean z) {
        boolean checked2 = z;
        if (this.checked != checked2) {
            this.checked = checked2;
            refreshDrawableState();
            sendAccessibilityEvent(2048);
        }
    }

    public boolean isChecked() {
        return this.checked;
    }

    public void toggle() {
        setChecked(!this.checked);
    }

    public int[] onCreateDrawableState(int i) {
        int extraSpace = i;
        if (this.checked) {
            return mergeDrawableStates(super.onCreateDrawableState(extraSpace + DRAWABLE_STATE_CHECKED.length), DRAWABLE_STATE_CHECKED);
        }
        return super.onCreateDrawableState(extraSpace);
    }
}
