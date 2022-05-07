package com.google.appinventor.components.runtime;

import android.content.Context;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;
import com.google.appinventor.components.annotations.DesignerComponent;
import com.google.appinventor.components.annotations.DesignerProperty;
import com.google.appinventor.components.annotations.PropertyCategory;
import com.google.appinventor.components.annotations.SimpleEvent;
import com.google.appinventor.components.annotations.SimpleFunction;
import com.google.appinventor.components.annotations.SimpleObject;
import com.google.appinventor.components.annotations.SimpleProperty;
import com.google.appinventor.components.common.ComponentCategory;
import com.google.appinventor.components.common.ComponentConstants;
import com.google.appinventor.components.runtime.util.PaintUtil;
import java.util.ArrayList;

@SimpleObject
@DesignerComponent(category = ComponentCategory.NAVIGATION, description = "", iconName = "images/viewPager.png", version = 3)
public class MakeroidViewPager extends AndroidViewComponent implements OnOrientationChangeListener {
    private static final int DEFAULT_ACCENT_COLOR = PaintUtil.hexStringToInt(ComponentConstants.DEFAULT_ACCENT_COLOR);
    private static final int DEFAULT_PRIMARY_COLOR = PaintUtil.hexStringToInt("&HFF3F51B5");
    private ArrayList<String> B8WBXPBCF2jGfUDZZU2zV5EYdqbUBu0lAZ0THCEqYyuE8VACR9dY7rDnwBIqh64T;
    private boolean DHXdVBD10imZD254vgJdvVnoNnGi6ltYnt493xQ866MP9unX6nAi8XBtATXxBfV8;
    private int JTEvmldvMjbbtPPlVS4hmZghOoRNnXC0kZOUUAZdwkVNl1VM5pL0vCTYv5HQZ7AX = -1;
    private int RC7PBJGdnqEffr8752ypFkbK8qZYkmQ3ci6maWfntRZXmeHa8bLhdKUgkXcpRo6T;
    private ComponentContainer container;
    private Context context;
    private ViewPager.LayoutParams hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME;

    /* renamed from: hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME  reason: collision with other field name */
    private ViewPager f208hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME;

    /* renamed from: hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME  reason: collision with other field name */
    private TabLayout f209hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME;

    /* renamed from: hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME  reason: collision with other field name */
    private a f210hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME;
    private int jKPsNUTq382ltO4Ct4VOTi9lUb0GK32zS6afcWmZUk1wuONzG2KH4rBMniXwxrgH = -16777216;
    private LinearLayout mainLayout;
    private int pFeTJgO2w7vELkZyStZDj0uZpMYRqdjcmMjC2zcPDquoynj4tIsgJjD3RDJtFf88 = -16777216;
    private FrameLayout.LayoutParams wq07duYRO6iFAgWM70EZOSvbCMKs1QznMRJKrct0XuHOBYqCk3XqOKtSBGIpDou;

    static /* synthetic */ void hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME(MakeroidViewPager makeroidViewPager, String str) {
        MakeroidViewPager makeroidViewPager2 = makeroidViewPager;
        String str2 = str;
        boolean add = makeroidViewPager2.B8WBXPBCF2jGfUDZZU2zV5EYdqbUBu0lAZ0THCEqYyuE8VACR9dY7rDnwBIqh64T.add(str2);
        TabLayout.Tab text = makeroidViewPager2.f209hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.newTab().setText((CharSequence) str2);
        int i = 0;
        while (i < makeroidViewPager2.B8WBXPBCF2jGfUDZZU2zV5EYdqbUBu0lAZ0THCEqYyuE8VACR9dY7rDnwBIqh64T.size()) {
            try {
                TabLayout.Tab text2 = makeroidViewPager2.f209hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.getTabAt(i).setText((CharSequence) makeroidViewPager2.B8WBXPBCF2jGfUDZZU2zV5EYdqbUBu0lAZ0THCEqYyuE8VACR9dY7rDnwBIqh64T.get(i));
                i++;
            } catch (Exception e) {
                int e2 = Log.e("Makeroid View Pager", String.valueOf(e));
                return;
            }
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public MakeroidViewPager(com.google.appinventor.components.runtime.ComponentContainer r9) {
        /*
            r8 = this;
            r0 = r8
            r1 = r9
            r2 = r0
            r3 = r1
            com.google.appinventor.components.runtime.Form r3 = r3.$form()
            r2.<init>(r3)
            r2 = r0
            r3 = -1
            r2.JTEvmldvMjbbtPPlVS4hmZghOoRNnXC0kZOUUAZdwkVNl1VM5pL0vCTYv5HQZ7AX = r3
            r2 = r0
            r3 = -16777216(0xffffffffff000000, float:-1.7014118E38)
            r2.pFeTJgO2w7vELkZyStZDj0uZpMYRqdjcmMjC2zcPDquoynj4tIsgJjD3RDJtFf88 = r3
            r2 = r0
            r3 = -16777216(0xffffffffff000000, float:-1.7014118E38)
            r2.jKPsNUTq382ltO4Ct4VOTi9lUb0GK32zS6afcWmZUk1wuONzG2KH4rBMniXwxrgH = r3
            r2 = r0
            java.util.ArrayList r3 = new java.util.ArrayList
            r7 = r3
            r3 = r7
            r4 = r7
            r4.<init>()
            r2.B8WBXPBCF2jGfUDZZU2zV5EYdqbUBu0lAZ0THCEqYyuE8VACR9dY7rDnwBIqh64T = r3
            r2 = r0
            r3 = 1
            r2.DHXdVBD10imZD254vgJdvVnoNnGi6ltYnt493xQ866MP9unX6nAi8XBtATXxBfV8 = r3
            r2 = r0
            r3 = r1
            r2.container = r3
            r2 = r1
            com.google.appinventor.components.runtime.Form r2 = r2.$form()
            r3 = r0
            r2.registerForOnOrientationChangeListener(r3)
            r2 = r0
            r3 = r1
            android.app.Activity r3 = r3.$context()
            r2.context = r3
            r2 = r0
            android.widget.LinearLayout r3 = new android.widget.LinearLayout
            r7 = r3
            r3 = r7
            r4 = r7
            r5 = r0
            android.content.Context r5 = r5.context
            r4.<init>(r5)
            r2.mainLayout = r3
            r2 = r0
            android.widget.LinearLayout r2 = r2.mainLayout
            r3 = 1
            r2.setOrientation(r3)
            r2 = r0
            com.google.android.material.tabs.TabLayout r3 = new com.google.android.material.tabs.TabLayout
            r7 = r3
            r3 = r7
            r4 = r7
            r5 = r0
            android.content.Context r5 = r5.context
            r4.<init>(r5)
            r2.f209hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME = r3
            r2 = r0
            android.widget.FrameLayout$LayoutParams r3 = new android.widget.FrameLayout$LayoutParams
            r7 = r3
            r3 = r7
            r4 = r7
            r5 = -1
            r6 = -2
            r4.<init>(r5, r6)
            r2.wq07duYRO6iFAgWM70EZOSvbCMKs1QznMRJKrct0XuHOBYqCk3XqOKtSBGIpDou = r3
            r2 = r0
            com.google.android.material.tabs.TabLayout r2 = r2.f209hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME
            r3 = 1
            r2.setTabGravity(r3)
            r2 = r0
            androidx.viewpager.widget.ViewPager r3 = new androidx.viewpager.widget.ViewPager
            r7 = r3
            r3 = r7
            r4 = r7
            r5 = r0
            android.content.Context r5 = r5.context
            r4.<init>(r5)
            r2.f208hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME = r3
            r2 = r0
            androidx.viewpager.widget.ViewPager r2 = r2.f208hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME
            r3 = 10
            r2.setOffscreenPageLimit(r3)
            r2 = r0
            androidx.viewpager.widget.ViewPager r2 = r2.f208hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME
            com.google.appinventor.components.runtime.MakeroidViewPager$1 r3 = new com.google.appinventor.components.runtime.MakeroidViewPager$1
            r7 = r3
            r3 = r7
            r4 = r7
            r5 = r0
            r4.<init>(r5)
            r2.addOnPageChangeListener(r3)
            r2 = r0
            androidx.viewpager.widget.ViewPager$LayoutParams r3 = new androidx.viewpager.widget.ViewPager$LayoutParams
            r7 = r3
            r3 = r7
            r4 = r7
            r4.<init>()
            r2.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME = r3
            r2 = r0
            androidx.viewpager.widget.ViewPager$LayoutParams r2 = r2.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME
            r3 = -1
            r2.height = r3
            r2 = r0
            androidx.viewpager.widget.ViewPager$LayoutParams r2 = r2.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME
            r3 = -1
            r2.width = r3
            r2 = r0
            com.google.appinventor.components.runtime.MakeroidViewPager$a r3 = new com.google.appinventor.components.runtime.MakeroidViewPager$a
            r7 = r3
            r3 = r7
            r4 = r7
            r5 = r0
            r6 = 0
            r4.<init>(r5, r6)
            r2.f210hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME = r3
            r2 = r0
            androidx.viewpager.widget.ViewPager r2 = r2.f208hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME
            r3 = r0
            com.google.appinventor.components.runtime.MakeroidViewPager$a r3 = r3.f210hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME
            r2.setAdapter(r3)
            r2 = r0
            android.widget.LinearLayout r2 = r2.mainLayout
            r3 = r0
            com.google.android.material.tabs.TabLayout r3 = r3.f209hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME
            r4 = r0
            android.widget.FrameLayout$LayoutParams r4 = r4.wq07duYRO6iFAgWM70EZOSvbCMKs1QznMRJKrct0XuHOBYqCk3XqOKtSBGIpDou
            r2.addView(r3, r4)
            r2 = r0
            android.widget.LinearLayout r2 = r2.mainLayout
            r3 = r0
            androidx.viewpager.widget.ViewPager r3 = r3.f208hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME
            r4 = r0
            androidx.viewpager.widget.ViewPager$LayoutParams r4 = r4.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME
            r2.addView(r3, r4)
            r2 = r0
            com.google.android.material.tabs.TabLayout r2 = r2.f209hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME
            r3 = r0
            androidx.viewpager.widget.ViewPager r3 = r3.f208hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME
            r2.setupWithViewPager(r3)
            r2 = r1
            r3 = r0
            r2.$add(r3)
            r2 = r0
            int r3 = DEFAULT_PRIMARY_COLOR
            r2.TabsBackgroundColor(r3)
            r2 = r0
            r3 = -1
            r2.TabsIndicatorColor(r3)
            r2 = r0
            r3 = -1
            r2.TabsTextColor(r3)
            r2 = r0
            int r3 = DEFAULT_ACCENT_COLOR
            r2.TabsActiveTextColor(r3)
            r2 = r0
            r3 = 1
            r2.TabsMode(r3)
            r2 = r0
            r3 = 1
            r2.ShowTabs(r3)
            r2 = r0
            r3 = 1
            r2.Visible(r3)
            r2 = r0
            r3 = -2
            r2.Width(r3)
            r2 = r0
            r3 = -2
            r2.Height(r3)
            java.lang.String r2 = "Makeroid View Pager"
            java.lang.String r3 = "Makeroid View Pager Created"
            int r2 = android.util.Log.d(r2, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.appinventor.components.runtime.MakeroidViewPager.<init>(com.google.appinventor.components.runtime.ComponentContainer):void");
    }

    public LinearLayout getView() {
        return this.mainLayout;
    }

    @SimpleProperty
    public void Width(int i) {
        int i2 = i;
        if (i2 == -1) {
            i2 = -2;
        }
        super.Width(i2);
    }

    @SimpleProperty
    public void Height(int i) {
        int i2 = i;
        if (i2 == -1) {
            i2 = -2;
        }
        super.Height(i2);
    }

    @SimpleEvent(description = "Event to detect that a page was selected.")
    public void PageSelected(int i) {
        boolean dispatchEvent = EventDispatcher.dispatchEvent(this, "PageSelected", Integer.valueOf(i));
    }

    @SimpleFunction(description = "Removes a before added view from the view pager. If you want to delete the first page then use as position '1'.")
    public void RemoveViewAt(int i) {
        int i2 = i;
        if (i2 > 0) {
            try {
                int hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME2 = this.f210hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME(this.f208hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME, i2 - 1);
                this.f210hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME(i2 - 1);
                this.f210hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.notifyDataSetChanged();
            } catch (Exception e) {
                int e2 = Log.e("Makeroid View Pager", String.valueOf(e));
            }
        } else {
            try {
                int hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME3 = this.f210hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME(this.f208hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME, 0);
                this.f210hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME(0);
                this.f210hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.notifyDataSetChanged();
            } catch (Exception e3) {
                int e4 = Log.e("Makeroid View Pager", String.valueOf(e3));
            }
        }
    }

    @SimpleProperty(category = PropertyCategory.BEHAVIOR, description = "Select a page which is then the active page. Use '1' to select the first page.")
    public void SelectPage(int i) {
        try {
            this.f208hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.setCurrentItem(i - 1, true);
        } catch (Exception e) {
            int e2 = Log.e("Makeroid View Pager", String.valueOf(e));
            this.f208hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.setCurrentItem(0, true);
        }
    }

    @SimpleProperty(category = PropertyCategory.BEHAVIOR, description = "Get the current selected visible page.")
    public int GetCurrentPage() {
        try {
            return this.f208hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.getCurrentItem() + 1;
        } catch (Exception e) {
            int e2 = Log.e("Makeroid View Pager", String.valueOf(e));
            return 0;
        }
    }

    @SimpleFunction(description = "Add a component to the view pager. The first added component will be the first visible component on the screen.")
    public void AddComponentToView(AndroidViewComponent androidViewComponent, String str) {
        Handler handler;
        Runnable runnable;
        AndroidViewComponent androidViewComponent2 = androidViewComponent;
        String str2 = str;
        try {
            new Handler();
            final AndroidViewComponent androidViewComponent3 = androidViewComponent2;
            final String str3 = str2;
            new Runnable(this) {

                /* renamed from: hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME  reason: collision with other field name */
                private /* synthetic */ MakeroidViewPager f211hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME;

                {
                    this.f211hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME = r7;
                }

                public final void run() {
                    View view = androidViewComponent3.getView();
                    View view2 = view;
                    ViewGroup viewGroup = (ViewGroup) view.getParent();
                    ViewGroup viewGroup2 = viewGroup;
                    if (viewGroup != null) {
                        viewGroup2.removeView(view2);
                    }
                    a hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME2 = MakeroidViewPager.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME(this.f211hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME);
                    hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME2.wq07duYRO6iFAgWM70EZOSvbCMKs1QznMRJKrct0XuHOBYqCk3XqOKtSBGIpDou.add(hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME2.wq07duYRO6iFAgWM70EZOSvbCMKs1QznMRJKrct0XuHOBYqCk3XqOKtSBGIpDou.size(), view2);
                    MakeroidViewPager.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME(this.f211hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME).notifyDataSetChanged();
                    MakeroidViewPager.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME(this.f211hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME, !str3.isEmpty() ? str3 : "Tab");
                }
            };
            boolean post = handler.post(runnable);
        } catch (Exception e) {
            int e2 = Log.e("Makeroid View Pager", String.valueOf(e));
        }
    }

    @SimpleFunction(description = "Remove all tab's from view pager.")
    public void RemoveAllTabs() {
        this.f209hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.removeAllTabs();
    }

    @DesignerProperty(defaultValue = "&HFF3F51B5", editorType = "color")
    @SimpleProperty(description = "Specifies the tab's background color.")
    public void TabsBackgroundColor(int i) {
        int i2 = i;
        this.f209hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.setBackgroundColor(i2);
        this.RC7PBJGdnqEffr8752ypFkbK8qZYkmQ3ci6maWfntRZXmeHa8bLhdKUgkXcpRo6T = i2;
    }

    @SimpleProperty(category = PropertyCategory.APPEARANCE)
    public int TabsBackgroundColor() {
        return this.RC7PBJGdnqEffr8752ypFkbK8qZYkmQ3ci6maWfntRZXmeHa8bLhdKUgkXcpRo6T;
    }

    @DesignerProperty(defaultValue = "&HFFFFFFFF", editorType = "color")
    @SimpleProperty(description = "Specifies the tab's indicator color.")
    public void TabsIndicatorColor(int i) {
        int i2 = i;
        this.f209hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.setSelectedTabIndicatorColor(i2);
        this.JTEvmldvMjbbtPPlVS4hmZghOoRNnXC0kZOUUAZdwkVNl1VM5pL0vCTYv5HQZ7AX = i2;
    }

    @SimpleProperty(category = PropertyCategory.APPEARANCE)
    public int TabsIndicatorColor() {
        return this.JTEvmldvMjbbtPPlVS4hmZghOoRNnXC0kZOUUAZdwkVNl1VM5pL0vCTYv5HQZ7AX;
    }

    @DesignerProperty(defaultValue = "&HFFFFFFFF", editorType = "color")
    @SimpleProperty(description = "Specifies the tab's text color for not selected tab's.")
    public void TabsTextColor(int i) {
        int i2 = i;
        this.pFeTJgO2w7vELkZyStZDj0uZpMYRqdjcmMjC2zcPDquoynj4tIsgJjD3RDJtFf88 = i2;
        this.f209hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.setTabTextColors(i2, this.jKPsNUTq382ltO4Ct4VOTi9lUb0GK32zS6afcWmZUk1wuONzG2KH4rBMniXwxrgH);
    }

    @SimpleProperty(category = PropertyCategory.APPEARANCE)
    public int TabsTextColor() {
        return this.pFeTJgO2w7vELkZyStZDj0uZpMYRqdjcmMjC2zcPDquoynj4tIsgJjD3RDJtFf88;
    }

    @DesignerProperty(defaultValue = "&HFFFF4081", editorType = "color")
    @SimpleProperty(description = "Specifies the tab's text color for active tab's.")
    public void TabsActiveTextColor(int i) {
        int i2 = i;
        this.jKPsNUTq382ltO4Ct4VOTi9lUb0GK32zS6afcWmZUk1wuONzG2KH4rBMniXwxrgH = i2;
        this.f209hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.setTabTextColors(this.pFeTJgO2w7vELkZyStZDj0uZpMYRqdjcmMjC2zcPDquoynj4tIsgJjD3RDJtFf88, i2);
    }

    @SimpleProperty(category = PropertyCategory.APPEARANCE)
    public int TabsActiveTextColor() {
        return this.jKPsNUTq382ltO4Ct4VOTi9lUb0GK32zS6afcWmZUk1wuONzG2KH4rBMniXwxrgH;
    }

    @DesignerProperty(defaultValue = "1", editorType = "tabs_mode")
    @SimpleProperty(description = "Choose the mode used for the tab's. If no mode is specified, 'Scrollable' is taken as 'Default'. Use '0' for scrollable and '1' for fixed.")
    public void TabsMode(int i) {
        switch (i) {
            case 0:
                this.f209hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.setTabMode(0);
                return;
            case 1:
                this.f209hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.setTabMode(1);
                return;
            default:
                this.f209hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.setTabMode(0);
                return;
        }
    }

    @SimpleProperty
    public int TabsMode() {
        return this.f209hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.getTabMode();
    }

    @DesignerProperty(defaultValue = "True", editorType = "boolean", propertyType = "experimental")
    @SimpleProperty(description = "If set to true, you will see tabs above the view pager.")
    public void ShowTabs(boolean z) {
        boolean z2 = z;
        this.DHXdVBD10imZD254vgJdvVnoNnGi6ltYnt493xQ866MP9unX6nAi8XBtATXxBfV8 = z2;
        this.f209hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.setVisibility(z2 ? 0 : 8);
        if (z2) {
            this.container.$form().removeElevation();
        } else {
            this.container.$form().addElevation();
        }
    }

    @SimpleProperty
    public boolean ShowTabs() {
        return this.DHXdVBD10imZD254vgJdvVnoNnGi6ltYnt493xQ866MP9unX6nAi8XBtATXxBfV8;
    }

    public void onOrientationChange() {
        if (this.mainLayout.getVisibility() != 0 || !this.DHXdVBD10imZD254vgJdvVnoNnGi6ltYnt493xQ866MP9unX6nAi8XBtATXxBfV8) {
            this.container.$form().addElevation();
        } else {
            this.container.$form().removeElevation();
        }
    }

    @DesignerProperty(defaultValue = "True", editorType = "visibility")
    @SimpleProperty(description = "Specifies whether the component should be visible on the screen. Value is true if the component is showing and false if hidden.")
    public void Visible(boolean z) {
        boolean z2 = z;
        getView().setVisibility(z2 ? 0 : 8);
        if (!z2 || !this.DHXdVBD10imZD254vgJdvVnoNnGi6ltYnt493xQ866MP9unX6nAi8XBtATXxBfV8) {
            this.container.$form().addElevation();
        } else {
            this.container.$form().removeElevation();
        }
    }

    @SimpleProperty(category = PropertyCategory.APPEARANCE)
    public boolean Visible() {
        return getView().getVisibility() == 0;
    }

    class a extends PagerAdapter {
        private /* synthetic */ MakeroidViewPager hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME;
        ArrayList<View> wq07duYRO6iFAgWM70EZOSvbCMKs1QznMRJKrct0XuHOBYqCk3XqOKtSBGIpDou;

        private a(MakeroidViewPager makeroidViewPager) {
            ArrayList<View> arrayList;
            this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME = makeroidViewPager;
            new ArrayList<>();
            this.wq07duYRO6iFAgWM70EZOSvbCMKs1QznMRJKrct0XuHOBYqCk3XqOKtSBGIpDou = arrayList;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        /* synthetic */ a(MakeroidViewPager makeroidViewPager, byte b) {
            this(makeroidViewPager);
            byte b2 = b;
        }

        public final int getItemPosition(@NonNull Object obj) {
            int indexOf = this.wq07duYRO6iFAgWM70EZOSvbCMKs1QznMRJKrct0XuHOBYqCk3XqOKtSBGIpDou.indexOf(obj);
            int i = indexOf;
            if (indexOf == -1) {
                return -2;
            }
            return i;
        }

        public final Object instantiateItem(@NonNull ViewGroup viewGroup, int i) {
            ViewGroup viewGroup2 = viewGroup;
            try {
                View view = this.wq07duYRO6iFAgWM70EZOSvbCMKs1QznMRJKrct0XuHOBYqCk3XqOKtSBGIpDou.get(i);
                viewGroup2.addView(view);
                return view;
            } catch (Exception e) {
                int e2 = Log.e("Makeroid View Pager", String.valueOf(e));
                return null;
            }
        }

        public final void destroyItem(@NonNull ViewGroup viewGroup, int i, @NonNull Object obj) {
            Object obj2 = obj;
            try {
                viewGroup.removeView(this.wq07duYRO6iFAgWM70EZOSvbCMKs1QznMRJKrct0XuHOBYqCk3XqOKtSBGIpDou.get(i));
            } catch (Exception e) {
                int e2 = Log.e("Makeroid View Pager", String.valueOf(e));
            }
        }

        public final int getCount() {
            return this.wq07duYRO6iFAgWM70EZOSvbCMKs1QznMRJKrct0XuHOBYqCk3XqOKtSBGIpDou.size();
        }

        /* JADX WARNING: type inference failed for: r7v0, types: [java.lang.Object] */
        /* JADX WARNING: Unknown variable types count: 1 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean isViewFromObject(@androidx.annotation.NonNull android.view.View r6, @androidx.annotation.NonNull java.lang.Object r7) {
            /*
                r5 = this;
                r0 = r5
                r1 = r6
                r2 = r7
                r3 = r1
                r4 = r2
                if (r3 != r4) goto L_0x000a
                r3 = 1
                r0 = r3
            L_0x0009:
                return r0
            L_0x000a:
                r3 = 0
                r0 = r3
                goto L_0x0009
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.appinventor.components.runtime.MakeroidViewPager.a.isViewFromObject(android.view.View, java.lang.Object):boolean");
        }

        public final int hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME(ViewPager viewPager, int i) {
            ViewPager viewPager2 = viewPager;
            int i2 = i;
            viewPager2.setAdapter((PagerAdapter) null);
            View remove = this.wq07duYRO6iFAgWM70EZOSvbCMKs1QznMRJKrct0XuHOBYqCk3XqOKtSBGIpDou.remove(i2);
            viewPager2.setAdapter(this);
            return i2;
        }

        public final CharSequence getPageTitle(int i) {
            StringBuilder sb;
            int i2 = i;
            int i3 = Log.i("Makeroid View Pager", String.valueOf(i2));
            try {
                new StringBuilder();
                return sb.append((String) MakeroidViewPager.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME(this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME).get(i2)).toString();
            } catch (Exception e) {
                int e2 = Log.e("Makeroid View Pager", String.valueOf(e));
                return "";
            }
        }

        public final void hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME(int i) {
            Object remove = MakeroidViewPager.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME(this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME).remove(i);
        }
    }
}
