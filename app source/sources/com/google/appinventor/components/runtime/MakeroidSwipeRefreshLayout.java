package com.google.appinventor.components.runtime;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.google.appinventor.components.annotations.DesignerComponent;
import com.google.appinventor.components.annotations.DesignerProperty;
import com.google.appinventor.components.annotations.PropertyCategory;
import com.google.appinventor.components.annotations.SimpleEvent;
import com.google.appinventor.components.annotations.SimpleObject;
import com.google.appinventor.components.annotations.SimpleProperty;
import com.google.appinventor.components.annotations.UsesLibraries;
import com.google.appinventor.components.common.ComponentCategory;
import com.google.appinventor.components.runtime.util.AlignmentUtil;
import com.google.appinventor.components.runtime.util.ErrorMessages;
import com.google.appinventor.components.runtime.util.ViewUtil;
import com.google.appinventor.components.runtime.util.YailList;

@SimpleObject
@DesignerComponent(category = ComponentCategory.LAYOUT_GENERAL, description = "", version = 2)
@UsesLibraries(libraries = "swiperefreshlayout.jar, swiperefreshlayout.aar")
public class MakeroidSwipeRefreshLayout extends AndroidViewComponent implements SwipeRefreshLayout.OnRefreshListener, ComponentContainer {
    private boolean Al9x361S9LLe4YuJ2FYrCTKylxVrvlRhCPyJ97vxqAo0DGA2cpEUDnPNY8RXP1UW = true;
    private boolean NqI9fRlBp15rsxXeNmRjOrUuQwDxdaDY0xSQj1B7T50sMWnnasnmhTtbykVZmafW;
    private boolean WT81i4At6dHne14KPL5TcdNiShzKisif1ehRA81016Xex9QKtWws9m2RXtqd3wpA = false;
    private final Activity activity;
    private AlignmentUtil alignmentSetter;
    private final Handler androidUIHandler;
    private int backgroundColor;
    private ComponentContainer container;
    private Context context;
    private int horizontalAlignment;
    private final SwipeRefreshLayout hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME;
    private final ViewGroup mainLayout;
    private YailList sSQuIBUVrx5rcdxHqHgqC6bPLuuDnxnBF7e7BJeOxmxr54l6ArzFZvC3SGBTuUdt;
    private int verticalAlignment;
    private final LinearLayout viewLayout;
    private int z819s2db3SwWOaVhKbPTp947sGRXlCsEqH9IfB6VLe6W07abBod2oRho8IvcelHj = -1;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public MakeroidSwipeRefreshLayout(com.google.appinventor.components.runtime.ComponentContainer r12) {
        /*
            r11 = this;
            r0 = r11
            r1 = r12
            r3 = r0
            r4 = r1
            r3.<init>(r4)
            r3 = r0
            android.os.Handler r4 = new android.os.Handler
            r10 = r4
            r4 = r10
            r5 = r10
            r5.<init>()
            r3.androidUIHandler = r4
            r3 = r0
            r4 = -1
            r3.z819s2db3SwWOaVhKbPTp947sGRXlCsEqH9IfB6VLe6W07abBod2oRho8IvcelHj = r4
            r3 = r0
            r4 = 1
            r3.Al9x361S9LLe4YuJ2FYrCTKylxVrvlRhCPyJ97vxqAo0DGA2cpEUDnPNY8RXP1UW = r4
            r3 = r0
            r4 = 0
            r3.WT81i4At6dHne14KPL5TcdNiShzKisif1ehRA81016Xex9QKtWws9m2RXtqd3wpA = r4
            r3 = r0
            r4 = 4
            java.lang.Object[] r4 = new java.lang.Object[r4]
            r10 = r4
            r4 = r10
            r5 = r10
            r6 = 0
            r7 = -14575886(0xffffffffff2196f2, float:-2.1478946E38)
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            r5[r6] = r7
            r10 = r4
            r4 = r10
            r5 = r10
            r6 = 1
            r7 = -11751600(0xffffffffff4caf50, float:-2.7207279E38)
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            r5[r6] = r7
            r10 = r4
            r4 = r10
            r5 = r10
            r6 = 2
            r7 = -71109(0xfffffffffffeea3b, float:NaN)
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            r5[r6] = r7
            r10 = r4
            r4 = r10
            r5 = r10
            r6 = 3
            r7 = -834762(0xfffffffffff34336, float:NaN)
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            r5[r6] = r7
            com.google.appinventor.components.runtime.util.YailList r4 = com.google.appinventor.components.runtime.util.YailList.makeList((java.lang.Object[]) r4)
            r3.sSQuIBUVrx5rcdxHqHgqC6bPLuuDnxnBF7e7BJeOxmxr54l6ArzFZvC3SGBTuUdt = r4
            r3 = r0
            r4 = 0
            r3.backgroundColor = r4
            r3 = r0
            r4 = 0
            r3.NqI9fRlBp15rsxXeNmRjOrUuQwDxdaDY0xSQj1B7T50sMWnnasnmhTtbykVZmafW = r4
            r3 = r0
            r4 = r1
            r3.container = r4
            r3 = r0
            r4 = r1
            android.app.Activity r4 = r4.$context()
            r3.context = r4
            r3 = r0
            r4 = r1
            android.app.Activity r4 = r4.$context()
            r3.activity = r4
            r3 = r0
            androidx.swiperefreshlayout.widget.SwipeRefreshLayout r4 = new androidx.swiperefreshlayout.widget.SwipeRefreshLayout
            r10 = r4
            r4 = r10
            r5 = r10
            r6 = r0
            android.content.Context r6 = r6.context
            r5.<init>(r6)
            r3.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME = r4
            r3 = r0
            androidx.swiperefreshlayout.widget.SwipeRefreshLayout r3 = r3.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME
            r4 = r0
            r3.setOnRefreshListener(r4)
            android.widget.LinearLayout$LayoutParams r3 = new android.widget.LinearLayout$LayoutParams
            r10 = r3
            r3 = r10
            r4 = r10
            r5 = -1
            r6 = -1
            r4.<init>(r5, r6)
            r2 = r3
            r3 = r0
            androidx.swiperefreshlayout.widget.SwipeRefreshLayout r3 = r3.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME
            r4 = r2
            r3.setLayoutParams(r4)
            r3 = r0
            com.google.appinventor.components.runtime.LinearLayout r4 = new com.google.appinventor.components.runtime.LinearLayout
            r10 = r4
            r4 = r10
            r5 = r10
            r6 = r0
            android.content.Context r6 = r6.context
            r7 = 1
            r8 = 100
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
            r9 = 100
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)
            r5.<init>(r6, r7, r8, r9)
            r3.viewLayout = r4
            r3 = r0
            com.google.appinventor.components.runtime.LinearLayout r3 = r3.viewLayout
            r4 = 0
            r3.setBaselineAligned(r4)
            r3 = r0
            com.google.appinventor.components.runtime.util.AlignmentUtil r4 = new com.google.appinventor.components.runtime.util.AlignmentUtil
            r10 = r4
            r4 = r10
            r5 = r10
            r6 = r0
            com.google.appinventor.components.runtime.LinearLayout r6 = r6.viewLayout
            r5.<init>(r6)
            r3.alignmentSetter = r4
            r3 = r0
            r4 = 1
            r3.horizontalAlignment = r4
            r3 = r0
            r4 = 1
            r3.verticalAlignment = r4
            r3 = r0
            com.google.appinventor.components.runtime.util.AlignmentUtil r3 = r3.alignmentSetter
            r4 = r0
            int r4 = r4.horizontalAlignment
            r3.setHorizontalAlignment((int) r4)
            r3 = r0
            com.google.appinventor.components.runtime.util.AlignmentUtil r3 = r3.alignmentSetter
            r4 = r0
            int r4 = r4.verticalAlignment
            r3.setVerticalAlignment((int) r4)
            r3 = r0
            androidx.swiperefreshlayout.widget.SwipeRefreshLayout r3 = r3.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME
            r4 = r0
            com.google.appinventor.components.runtime.LinearLayout r4 = r4.viewLayout
            android.view.ViewGroup r4 = r4.getLayoutManager()
            android.view.ViewGroup$LayoutParams r5 = new android.view.ViewGroup$LayoutParams
            r10 = r5
            r5 = r10
            r6 = r10
            r7 = -1
            r8 = -1
            r6.<init>(r7, r8)
            r3.addView(r4, r5)
            r3 = r0
            android.widget.FrameLayout r4 = new android.widget.FrameLayout
            r10 = r4
            r4 = r10
            r5 = r10
            r6 = r0
            android.content.Context r6 = r6.context
            r5.<init>(r6)
            r3.mainLayout = r4
            r3 = r0
            android.view.ViewGroup r3 = r3.mainLayout
            android.view.ViewGroup$LayoutParams r4 = new android.view.ViewGroup$LayoutParams
            r10 = r4
            r4 = r10
            r5 = r10
            r6 = 100
            r7 = 100
            r5.<init>(r6, r7)
            r3.setLayoutParams(r4)
            r3 = r0
            android.view.ViewGroup r3 = r3.mainLayout
            r4 = r0
            androidx.swiperefreshlayout.widget.SwipeRefreshLayout r4 = r4.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME
            r3.addView(r4)
            r3 = r1
            r4 = r0
            r3.$add(r4)
            r3 = r0
            r4 = 1
            r3.Enabled(r4)
            r3 = r0
            r10 = r3
            r3 = r10
            r4 = r10
            com.google.appinventor.components.runtime.util.YailList r4 = r4.sSQuIBUVrx5rcdxHqHgqC6bPLuuDnxnBF7e7BJeOxmxr54l6ArzFZvC3SGBTuUdt
            r3.ProgressAnimationColors(r4)
            r3 = r0
            r4 = -1
            r3.ProgressBackgroundColor(r4)
            r3 = r0
            r4 = 0
            r3.LargeSize(r4)
            r3 = r0
            r4 = 0
            r3.BackgroundColor(r4)
            r3 = r0
            r4 = 0
            r3.NestedScrolling(r4)
            java.lang.String r3 = "Swipe Refresh Layout"
            java.lang.String r4 = "Swipe Refresh Layout Created"
            int r3 = android.util.Log.d(r3, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.appinventor.components.runtime.MakeroidSwipeRefreshLayout.<init>(com.google.appinventor.components.runtime.ComponentContainer):void");
    }

    public View getView() {
        return this.mainLayout;
    }

    public Activity $context() {
        return this.activity;
    }

    public Form $form() {
        return this.container.$form();
    }

    public void $add(AndroidViewComponent androidViewComponent) {
        this.viewLayout.add(androidViewComponent);
    }

    public void setChildWidth(AndroidViewComponent androidViewComponent, int i) {
        setChildWidth(androidViewComponent, i, 0);
    }

    public void setChildWidth(AndroidViewComponent androidViewComponent, int i, int i2) {
        Runnable runnable;
        AndroidViewComponent androidViewComponent2 = androidViewComponent;
        int i3 = i;
        int i4 = i2;
        int Width = this.container.$form().Width();
        int i5 = Width;
        if (Width == 0 && i4 < 2) {
            final AndroidViewComponent androidViewComponent3 = androidViewComponent2;
            final int i6 = i3;
            final int i7 = i4;
            new Runnable(this) {

                /* renamed from: hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME  reason: collision with other field name */
                private /* synthetic */ MakeroidSwipeRefreshLayout f206hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME;

                {
                    this.f206hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME = r8;
                }

                public final void run() {
                    this.f206hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.setChildWidth(androidViewComponent3, i6, i7 + 1);
                }
            };
            boolean postDelayed = this.androidUIHandler.postDelayed(runnable, 100);
        }
        if (i3 <= -1000) {
            i3 = (i5 * (-(i3 + 1000))) / 100;
        }
        androidViewComponent2.setLastWidth(i3);
        ViewUtil.setChildWidthForVerticalLayout(androidViewComponent2.getView(), i3);
    }

    public void setChildHeight(AndroidViewComponent androidViewComponent, int i) {
        Runnable runnable;
        AndroidViewComponent androidViewComponent2 = androidViewComponent;
        int i2 = i;
        int Height = this.container.$form().Height();
        int i3 = Height;
        if (Height == 0) {
            final AndroidViewComponent androidViewComponent3 = androidViewComponent2;
            final int i4 = i2;
            new Runnable(this) {

                /* renamed from: hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME  reason: collision with other field name */
                private /* synthetic */ MakeroidSwipeRefreshLayout f207hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME;

                {
                    this.f207hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME = r7;
                }

                public final void run() {
                    this.f207hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.setChildHeight(androidViewComponent3, i4);
                }
            };
            boolean postDelayed = this.androidUIHandler.postDelayed(runnable, 100);
        }
        if (i2 <= -1000) {
            i2 = (i3 * (-(i2 + 1000))) / 100;
        }
        androidViewComponent2.setLastHeight(i2);
        ViewUtil.setChildHeightForVerticalLayout(androidViewComponent2.getView(), i2);
    }

    public void onRefresh() {
        if (this.Al9x361S9LLe4YuJ2FYrCTKylxVrvlRhCPyJ97vxqAo0DGA2cpEUDnPNY8RXP1UW) {
            OnRefresh();
        }
    }

    @SimpleEvent(description = "Event to detect when a refresh is triggered via the swipe gesture.")
    public void OnRefresh() {
        boolean dispatchEvent = EventDispatcher.dispatchEvent(this, "OnRefresh", new Object[0]);
    }

    @DesignerProperty(defaultValue = "&HFFFFFFFF", editorType = "color")
    @SimpleProperty(description = "Change the pull to refresh background color.")
    public void ProgressBackgroundColor(int i) {
        int i2 = i;
        this.z819s2db3SwWOaVhKbPTp947sGRXlCsEqH9IfB6VLe6W07abBod2oRho8IvcelHj = i2;
        this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.setProgressBackgroundColorSchemeColor(i2);
    }

    @SimpleProperty(description = "Return the pull to refresh background color.")
    public int ProgressBackgroundColor() {
        return this.z819s2db3SwWOaVhKbPTp947sGRXlCsEqH9IfB6VLe6W07abBod2oRho8IvcelHj;
    }

    @SimpleProperty(description = "Set the colors used in the progress animation. Use a 'make a list' block. The first color on the list is than the first spinner color.")
    public void ProgressAnimationColors(YailList yailList) {
        YailList yailList2 = yailList;
        this.sSQuIBUVrx5rcdxHqHgqC6bPLuuDnxnBF7e7BJeOxmxr54l6ArzFZvC3SGBTuUdt = yailList2;
        String[] stringArray = yailList2.toStringArray();
        String[] strArr = stringArray;
        int[] iArr = new int[stringArray.length];
        for (int i = 0; i < strArr.length; i++) {
            iArr[i] = Integer.parseInt(strArr[i]);
        }
        this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.setColorSchemeColors(iArr);
    }

    @SimpleProperty(description = "Returns the used colors als list.")
    public YailList ProgressAnimationColors() {
        return this.sSQuIBUVrx5rcdxHqHgqC6bPLuuDnxnBF7e7BJeOxmxr54l6ArzFZvC3SGBTuUdt;
    }

    @SimpleProperty(description = "Notify the widget that refresh state has changed. Do not call this when refresh is triggered by a swipe gesture.")
    public void Refreshing(boolean z) {
        this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.setRefreshing(z);
    }

    @SimpleProperty(description = "Returns true if is actively showing refresh progress.")
    public boolean IsRefreshing() {
        return this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.isRefreshing();
    }

    @DesignerProperty(defaultValue = "False", editorType = "boolean")
    @SimpleProperty(description = "If enabled is set to true the pull size will be large, else the size is default.")
    public void LargeSize(boolean z) {
        boolean z2 = z;
        this.WT81i4At6dHne14KPL5TcdNiShzKisif1ehRA81016Xex9QKtWws9m2RXtqd3wpA = z2;
        this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.setSize(z2 ? 0 : 1);
    }

    @SimpleProperty(description = "Returns true if large size is used.")
    public boolean LargeSize() {
        return this.WT81i4At6dHne14KPL5TcdNiShzKisif1ehRA81016Xex9QKtWws9m2RXtqd3wpA;
    }

    @DesignerProperty(defaultValue = "True", editorType = "boolean")
    @SimpleProperty(description = "If set to true the swpipe refresh layout is enabled.")
    public void Enabled(boolean z) {
        boolean z2 = z;
        this.Al9x361S9LLe4YuJ2FYrCTKylxVrvlRhCPyJ97vxqAo0DGA2cpEUDnPNY8RXP1UW = z2;
        this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.setEnabled(z2);
    }

    @SimpleProperty(description = "Returns true if enabled.")
    public boolean Enabled() {
        return this.Al9x361S9LLe4YuJ2FYrCTKylxVrvlRhCPyJ97vxqAo0DGA2cpEUDnPNY8RXP1UW;
    }

    @DesignerProperty(defaultValue = "False", editorType = "boolean")
    @SimpleProperty(description = "Enable or disable nested scrolling for this view.")
    public void NestedScrolling(boolean z) {
        boolean z2 = z;
        this.NqI9fRlBp15rsxXeNmRjOrUuQwDxdaDY0xSQj1B7T50sMWnnasnmhTtbykVZmafW = z2;
        this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.setNestedScrollingEnabled(z2);
    }

    @SimpleProperty(description = "Returns true if nested scrolling is enabled.")
    public boolean NestedScrolling() {
        return this.NqI9fRlBp15rsxXeNmRjOrUuQwDxdaDY0xSQj1B7T50sMWnnasnmhTtbykVZmafW;
    }

    @DesignerProperty(defaultValue = "1", editorType = "horizontal_alignment")
    @SimpleProperty
    public void AlignHorizontal(int i) {
        int i2 = i;
        try {
            this.alignmentSetter.setHorizontalAlignment(i2);
            this.horizontalAlignment = i2;
        } catch (IllegalArgumentException e) {
            this.container.$form().dispatchErrorOccurredEvent(this, "HorizontalAlignment", ErrorMessages.ERROR_BAD_VALUE_FOR_HORIZONTAL_ALIGNMENT, Integer.valueOf(i2));
        }
    }

    @SimpleProperty(category = PropertyCategory.APPEARANCE, description = "A number that encodes how contents of the arrangement are aligned  horizontally. The choices are: 1 = left aligned, 2 = right aligned,  3 = horizontally centered.  Alignment has no effect if the arrangement's width is automatic.")
    public int AlignHorizontal() {
        return this.horizontalAlignment;
    }

    @DesignerProperty(defaultValue = "1", editorType = "vertical_alignment")
    @SimpleProperty
    public void AlignVertical(int i) {
        int i2 = i;
        try {
            this.alignmentSetter.setVerticalAlignment(i2);
            this.verticalAlignment = i2;
        } catch (IllegalArgumentException e) {
            this.container.$form().dispatchErrorOccurredEvent(this, "VerticalAlignment", ErrorMessages.ERROR_BAD_VALUE_FOR_VERTICAL_ALIGNMENT, Integer.valueOf(i2));
        }
    }

    @SimpleProperty(category = PropertyCategory.APPEARANCE, description = "A number that encodes how the contents of the arrangement are aligned  vertically. The choices are: 1 = aligned at the top, 2 = vertically centered, 3 = aligned at the bottom.  Alignment has no effect if the arrangement's height is automatic.")
    public int AlignVertical() {
        return this.verticalAlignment;
    }

    @DesignerProperty(defaultValue = "&H00000000", editorType = "color")
    @SimpleProperty
    public void BackgroundColor(int i) {
        int i2 = i;
        this.backgroundColor = i2;
        this.mainLayout.setBackgroundColor(i2);
    }

    @SimpleProperty(category = PropertyCategory.APPEARANCE, description = "The background color of the swipe refresh layout.")
    public int BackgroundColor() {
        return this.backgroundColor;
    }
}
