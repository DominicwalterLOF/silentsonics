package androidx.browser.browseractions;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.RestrictTo;
import androidx.browser.R;
import gnu.expr.Declaration;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class BrowserActionsFallbackMenuView extends LinearLayout {
    private final int mBrowserActionsMenuMaxWidthPx = getResources().getDimensionPixelOffset(R.dimen.browser_actions_context_menu_max_width);
    private final int mBrowserActionsMenuMinPaddingPx = getResources().getDimensionPixelOffset(R.dimen.browser_actions_context_menu_min_padding);

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BrowserActionsFallbackMenuView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int heightMeasureSpec) {
        int i2 = i;
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(Math.min(getResources().getDisplayMetrics().widthPixels - (2 * this.mBrowserActionsMenuMinPaddingPx), this.mBrowserActionsMenuMaxWidthPx), Declaration.MODULE_REFERENCE), heightMeasureSpec);
    }
}
