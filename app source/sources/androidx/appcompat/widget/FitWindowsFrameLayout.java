package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.annotation.RestrictTo;
import androidx.appcompat.widget.FitWindowsViewGroup;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class FitWindowsFrameLayout extends FrameLayout implements FitWindowsViewGroup {
    private FitWindowsViewGroup.OnFitSystemWindowsListener mListener;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FitWindowsFrameLayout(Context context) {
        super(context);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FitWindowsFrameLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void setOnFitSystemWindowsListener(FitWindowsViewGroup.OnFitSystemWindowsListener listener) {
        FitWindowsViewGroup.OnFitSystemWindowsListener onFitSystemWindowsListener = listener;
        this.mListener = onFitSystemWindowsListener;
    }

    /* access modifiers changed from: protected */
    public boolean fitSystemWindows(Rect rect) {
        Rect insets = rect;
        if (this.mListener != null) {
            this.mListener.onFitSystemWindows(insets);
        }
        return super.fitSystemWindows(insets);
    }
}
