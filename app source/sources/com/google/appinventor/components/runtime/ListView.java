package com.google.appinventor.components.runtime;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.appinventor.components.annotations.DesignerComponent;
import com.google.appinventor.components.annotations.DesignerProperty;
import com.google.appinventor.components.annotations.PropertyCategory;
import com.google.appinventor.components.annotations.SimpleEvent;
import com.google.appinventor.components.annotations.SimpleFunction;
import com.google.appinventor.components.annotations.SimpleObject;
import com.google.appinventor.components.annotations.SimpleProperty;
import com.google.appinventor.components.common.ComponentCategory;
import com.google.appinventor.components.runtime.util.ElementsUtil;
import com.google.appinventor.components.runtime.util.TextViewUtil;
import com.google.appinventor.components.runtime.util.YailList;

@SimpleObject
@DesignerComponent(category = ComponentCategory.LISTVIEWS, description = "<p>This is a visible component that displays a list of text elements. <br> The list can be set using the ElementsFromString property or using the Elements block in the blocks editor. </p>", iconName = "images/listView.png", version = 13)
public class ListView extends AndroidViewComponent implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener {
    private float ANz72NxTeEmYo9CF87MXRUuH7WvE4u0mpZwxffTnyiMdygEQRKvmdTCHaXqAvud = 12.0f;
    /* access modifiers changed from: private */
    public int AsUIHfRHW1pScN9YQW0IsOeuFdHXhbXb53xXbDg8x2ZIBxv57XORnQnTS1wprCIt = -1;

    /* renamed from: AsUIHfRHW1pScN9YQW0IsOeuFdHXhbXb53xXbDg8x2ZIBxv57XORnQnTS1wprCIt  reason: collision with other field name */
    private String f179AsUIHfRHW1pScN9YQW0IsOeuFdHXhbXb53xXbDg8x2ZIBxv57XORnQnTS1wprCIt = "";
    private EditText B8WBXPBCF2jGfUDZZU2zV5EYdqbUBu0lAZ0THCEqYyuE8VACR9dY7rDnwBIqh64T;
    private String[] Co1rSUoyBoOJ9n0NOgrpxvTYmRPklnETeodUBiQlSBK151C8PCv1Q1Pl4SUa1qxB;
    private float KXDzEMeLg0aMKCNRnRJuQGoMaVrKUgtBW3gGmn2kxU5q0F1ZNh5DKQo95IN9JPm2 = 1.0f;
    private int Kv1J8U7LN9Ew5Fg3SGq5PZTyUq5afJMc801ng97H4mT8uP4jFrbS1BuSDErmLQPa = 2;
    /* access modifiers changed from: private */
    public int N4rx6qe3Dkxm9iGosdnZviEGwwAyjrMopVTdmRoB5smsVn2ef0JNliQjJW08w5OT = 15;
    private boolean PpoaLB2hgzDTOuqu9FkRmbGOAi4DOSz44cSb2WOQzHfJN0AfA0f9dWyZXVLXkHHC;
    private String Ta6bjdQXoFeEb44hWQ7kTTTXw2rT1LHw6UX7lms7WU7H0AkpETH9D9EhELUfywQi;
    private String ZjHRxIxmIbXMaaxTq0tXk7fANzHmvqKL8qVP5oGbbjVmTEOJkL3QkM6pcvCB7aNQ = "Search list...";
    private int bM4TidozxzoY9OaFqMiIYPyvnCah6tSdq3o2XMkQik5CKYcFIbxeqf36lqbvGbmH = -16777216;
    private int backgroundColor = -1;
    protected final ComponentContainer container;
    private Context context;
    private boolean dTbjShrSvDZnDCeVo9i3X83sAePZ6DkuyHJPQ6B7WbRWcPLJlbxhZYnAC0mU9DUR = false;
    private int dividerColor = -16777216;
    private int fSI6lxX8qEfUYa0M3qSNEhqEY7tqyd89UewYfJ8WSYLJpTsAFdRvTVg7ORBsMzG8 = 0;
    private int fontTypeface = 0;
    private Form form;
    private TextView hR11jdqaRrvBRiBFd4KN6gI7d8MNQVP5Yc7fufDZjGGTeTxaualejjrhiR1Iz2xO;
    private ViewGroup.LayoutParams hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME;

    /* renamed from: hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME  reason: collision with other field name */
    private ArrayAdapter<String> f180hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME;

    /* renamed from: hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME  reason: collision with other field name */
    private final android.widget.ListView f181hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME;
    private final LinearLayout listViewLayout;
    private int pgq50Ta8BOwqZ1x44UiPoTcDoRPiNHTTIb3Jgmceok7eFp2gi0sO4JRUukOMKqHH = Component.COLOR_LIGHT_GRAY;
    /* access modifiers changed from: private */
    public int poblgm1P6mADk8QKAia8LTNTlp3hP9LK4vL2LyACRyn6OaTobhLhKjphCbjAETmg = Component.COLOR_LIGHT_GRAY;
    private int sSQuIBUVrx5rcdxHqHgqC6bPLuuDnxnBF7e7BJeOxmxr54l6ArzFZvC3SGBTuUdt = 0;
    private boolean tee1T53LBirhPaiZzuBv7do2U2eC3n16AtczACNW2pKYEGgDhkkMv1hGUupyoKZE;
    private YailList vwEpIRqEf6xdtwTR9dehwBO7JUhyLV6iEzEK2WqfPN10eUMQDPn3AUmqAFfsnr6R;
    private float wGMjbGuJ9Yk6s2LaEm8v1pEJlXt36TYBWZSsia0LUgb1yMdHNGB7uRz3VqnF79D0 = 22.0f;

    /* renamed from: wGMjbGuJ9Yk6s2LaEm8v1pEJlXt36TYBWZSsia0LUgb1yMdHNGB7uRz3VqnF79D0  reason: collision with other field name */
    private boolean f182wGMjbGuJ9Yk6s2LaEm8v1pEJlXt36TYBWZSsia0LUgb1yMdHNGB7uRz3VqnF79D0 = true;
    private boolean xaven5ecM0Ll2H1GHPRV82tONpToW8URGRDgxbH0b2M0q5wAsNNBDrpsKvL0qvHt = false;

    static /* synthetic */ ViewGroup.LayoutParams hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME(ListView listView, ViewGroup.LayoutParams layoutParams) {
        ViewGroup.LayoutParams layoutParams2 = layoutParams;
        ViewGroup.LayoutParams layoutParams3 = layoutParams2;
        listView.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME = layoutParams3;
        return layoutParams2;
    }

    static /* synthetic */ TextView hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME(ListView listView, TextView textView) {
        TextView textView2 = textView;
        TextView textView3 = textView2;
        listView.hR11jdqaRrvBRiBFd4KN6gI7d8MNQVP5Yc7fufDZjGGTeTxaualejjrhiR1Iz2xO = textView3;
        return textView2;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public ListView(com.google.appinventor.components.runtime.ComponentContainer r10) {
        /*
            r9 = this;
            r0 = r9
            r1 = r10
            r2 = r0
            r3 = r1
            r2.<init>(r3)
            r2 = r0
            r3 = -16777216(0xffffffffff000000, float:-1.7014118E38)
            r2.bM4TidozxzoY9OaFqMiIYPyvnCah6tSdq3o2XMkQik5CKYcFIbxeqf36lqbvGbmH = r3
            r2 = r0
            r3 = -1
            r2.backgroundColor = r3
            r2 = r0
            r3 = -16777216(0xffffffffff000000, float:-1.7014118E38)
            r2.dividerColor = r3
            r2 = r0
            r3 = 2
            r2.Kv1J8U7LN9Ew5Fg3SGq5PZTyUq5afJMc801ng97H4mT8uP4jFrbS1BuSDErmLQPa = r3
            r2 = r0
            java.lang.String r3 = "Search list..."
            r2.ZjHRxIxmIbXMaaxTq0tXk7fANzHmvqKL8qVP5oGbbjVmTEOJkL3QkM6pcvCB7aNQ = r3
            r2 = r0
            r3 = 0
            r2.xaven5ecM0Ll2H1GHPRV82tONpToW8URGRDgxbH0b2M0q5wAsNNBDrpsKvL0qvHt = r3
            r2 = r0
            r3 = -3355444(0xffffffffffcccccc, float:NaN)
            r2.pgq50Ta8BOwqZ1x44UiPoTcDoRPiNHTTIb3Jgmceok7eFp2gi0sO4JRUukOMKqHH = r3
            r2 = r0
            r3 = 0
            r2.dTbjShrSvDZnDCeVo9i3X83sAePZ6DkuyHJPQ6B7WbRWcPLJlbxhZYnAC0mU9DUR = r3
            r2 = r0
            r3 = 0
            r2.fSI6lxX8qEfUYa0M3qSNEhqEY7tqyd89UewYfJ8WSYLJpTsAFdRvTVg7ORBsMzG8 = r3
            r2 = r0
            r3 = -1
            r2.AsUIHfRHW1pScN9YQW0IsOeuFdHXhbXb53xXbDg8x2ZIBxv57XORnQnTS1wprCIt = r3
            r2 = r0
            r3 = -3355444(0xffffffffffcccccc, float:NaN)
            r2.poblgm1P6mADk8QKAia8LTNTlp3hP9LK4vL2LyACRyn6OaTobhLhKjphCbjAETmg = r3
            r2 = r0
            r3 = 1094713344(0x41400000, float:12.0)
            r2.ANz72NxTeEmYo9CF87MXRUuH7WvE4u0mpZwxffTnyiMdygEQRKvmdTCHaXqAvud = r3
            r2 = r0
            java.lang.String r3 = ""
            r2.f179AsUIHfRHW1pScN9YQW0IsOeuFdHXhbXb53xXbDg8x2ZIBxv57XORnQnTS1wprCIt = r3
            r2 = r0
            r3 = 0
            r2.fontTypeface = r3
            r2 = r0
            r3 = 0
            r2.sSQuIBUVrx5rcdxHqHgqC6bPLuuDnxnBF7e7BJeOxmxr54l6ArzFZvC3SGBTuUdt = r3
            r2 = r0
            r3 = 1102053376(0x41b00000, float:22.0)
            r2.wGMjbGuJ9Yk6s2LaEm8v1pEJlXt36TYBWZSsia0LUgb1yMdHNGB7uRz3VqnF79D0 = r3
            r2 = r0
            r3 = 15
            r2.N4rx6qe3Dkxm9iGosdnZviEGwwAyjrMopVTdmRoB5smsVn2ef0JNliQjJW08w5OT = r3
            r2 = r0
            r3 = 1065353216(0x3f800000, float:1.0)
            r2.KXDzEMeLg0aMKCNRnRJuQGoMaVrKUgtBW3gGmn2kxU5q0F1ZNh5DKQo95IN9JPm2 = r3
            r2 = r0
            r3 = 1
            r2.f182wGMjbGuJ9Yk6s2LaEm8v1pEJlXt36TYBWZSsia0LUgb1yMdHNGB7uRz3VqnF79D0 = r3
            r2 = r0
            r3 = r1
            android.app.Activity r3 = r3.$context()
            r2.context = r3
            r2 = r0
            r3 = r1
            r2.container = r3
            r2 = r0
            r3 = r1
            com.google.appinventor.components.runtime.Form r3 = r3.$form()
            r2.form = r3
            r2 = r0
            android.widget.ListView r3 = new android.widget.ListView
            r8 = r3
            r3 = r8
            r4 = r8
            r5 = r0
            android.content.Context r5 = r5.context
            r4.<init>(r5)
            r2.f181hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME = r3
            r2 = r0
            android.widget.ListView r2 = r2.f181hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME
            r3 = 0
            r2.setCacheColorHint(r3)
            r2 = r0
            android.widget.ListView r2 = r2.f181hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME
            r3 = r0
            r2.setOnItemClickListener(r3)
            r2 = r0
            android.widget.ListView r2 = r2.f181hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME
            r3 = r0
            r2.setOnItemLongClickListener(r3)
            r2 = r0
            android.widget.ListView r2 = r2.f181hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME
            r3 = 1
            r2.setChoiceMode(r3)
            r2 = r0
            android.widget.ListView r2 = r2.f181hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME
            r3 = 0
            r2.setScrollingCacheEnabled(r3)
            r2 = r0
            android.widget.LinearLayout r3 = new android.widget.LinearLayout
            r8 = r3
            r3 = r8
            r4 = r8
            r5 = r0
            android.content.Context r5 = r5.context
            r4.<init>(r5)
            r2.listViewLayout = r3
            r2 = r0
            android.widget.LinearLayout r2 = r2.listViewLayout
            r3 = 1
            r2.setOrientation(r3)
            r2 = r0
            android.widget.EditText r3 = new android.widget.EditText
            r8 = r3
            r3 = r8
            r4 = r8
            r5 = r0
            android.content.Context r5 = r5.context
            r4.<init>(r5)
            r2.B8WBXPBCF2jGfUDZZU2zV5EYdqbUBu0lAZ0THCEqYyuE8VACR9dY7rDnwBIqh64T = r3
            r2 = r0
            android.widget.EditText r2 = r2.B8WBXPBCF2jGfUDZZU2zV5EYdqbUBu0lAZ0THCEqYyuE8VACR9dY7rDnwBIqh64T
            r3 = 1
            r2.setSingleLine(r3)
            r2 = r0
            android.widget.EditText r2 = r2.B8WBXPBCF2jGfUDZZU2zV5EYdqbUBu0lAZ0THCEqYyuE8VACR9dY7rDnwBIqh64T
            r3 = -2
            r2.setWidth(r3)
            r2 = r0
            android.widget.EditText r2 = r2.B8WBXPBCF2jGfUDZZU2zV5EYdqbUBu0lAZ0THCEqYyuE8VACR9dY7rDnwBIqh64T
            r3 = r0
            java.lang.String r3 = r3.ZjHRxIxmIbXMaaxTq0tXk7fANzHmvqKL8qVP5oGbbjVmTEOJkL3QkM6pcvCB7aNQ
            r2.setHint(r3)
            r2 = r0
            android.widget.EditText r2 = r2.B8WBXPBCF2jGfUDZZU2zV5EYdqbUBu0lAZ0THCEqYyuE8VACR9dY7rDnwBIqh64T
            r3 = r0
            android.content.Context r3 = r3.context
            r4 = 2
            r5 = 2
            r6 = 2
            r7 = 2
            com.google.appinventor.components.runtime.util.KodularHelper.setPadding(r2, r3, r4, r5, r6, r7)
            r2 = r0
            android.widget.EditText r2 = r2.B8WBXPBCF2jGfUDZZU2zV5EYdqbUBu0lAZ0THCEqYyuE8VACR9dY7rDnwBIqh64T
            com.google.appinventor.components.runtime.ListView$1 r3 = new com.google.appinventor.components.runtime.ListView$1
            r8 = r3
            r3 = r8
            r4 = r8
            r5 = r0
            r4.<init>(r5)
            r2.addTextChangedListener(r3)
            r2 = r0
            boolean r2 = r2.dTbjShrSvDZnDCeVo9i3X83sAePZ6DkuyHJPQ6B7WbRWcPLJlbxhZYnAC0mU9DUR
            if (r2 == 0) goto L_0x019f
            r2 = r0
            android.widget.EditText r2 = r2.B8WBXPBCF2jGfUDZZU2zV5EYdqbUBu0lAZ0THCEqYyuE8VACR9dY7rDnwBIqh64T
            r3 = 0
            r2.setVisibility(r3)
        L_0x0108:
            r2 = r0
            r3 = -16777216(0xffffffffff000000, float:-1.7014118E38)
            r2.DividerColor(r3)
            r2 = r0
            r3 = 2
            r2.DividerHeight(r3)
            r2 = r0
            r3 = 1102053376(0x41b00000, float:22.0)
            r2.TextSize(r3)
            r2 = r0
            r3 = 10
            r2.ItemHeight(r3)
            r2 = r0
            r3 = -16777216(0xffffffffff000000, float:-1.7014118E38)
            r2.TextColor(r3)
            r2 = r0
            r3 = -1
            r2.SearchTextColor(r3)
            r2 = r0
            r3 = -3355444(0xffffffffffcccccc, float:NaN)
            r2.SearchHintColor(r3)
            r2 = r0
            r3 = 1096810496(0x41600000, float:14.0)
            r2.SearchTextSize(r3)
            r2 = r0
            r3 = -10453621(0xffffffffff607d8b, float:-2.9839893E38)
            r2.BackgroundColor(r3)
            r2 = r0
            r3 = 1
            r2.ShowScrollbar(r3)
            r2 = r0
            r3 = 1
            r2.ScrollbarFading(r3)
            r2 = r0
            r3 = 0
            r2.LongClickEnabled(r3)
            r2 = r0
            android.content.Context r2 = r2.context
            com.google.appinventor.components.runtime.util.TextViewUtil.setContext(r2)
            r2 = r0
            r3 = 0
            r2.ShowSelectionColor(r3)
            r2 = r0
            java.lang.String r3 = ""
            r2.ElementsFromString(r3)
            r2 = r0
            r8 = r2
            r2 = r8
            r3 = r8
            float r3 = r3.KXDzEMeLg0aMKCNRnRJuQGoMaVrKUgtBW3gGmn2kxU5q0F1ZNh5DKQo95IN9JPm2
            r2.ScrollingSpeed(r3)
            r2 = r0
            r3 = 1
            r2.HTMLFormat(r3)
            r2 = r0
            r3 = -2
            r2.Width(r3)
            r2 = r0
            r3 = -2
            r2.Height(r3)
            r2 = r0
            android.widget.LinearLayout r2 = r2.listViewLayout
            r3 = r0
            android.widget.EditText r3 = r3.B8WBXPBCF2jGfUDZZU2zV5EYdqbUBu0lAZ0THCEqYyuE8VACR9dY7rDnwBIqh64T
            r2.addView(r3)
            r2 = r0
            android.widget.LinearLayout r2 = r2.listViewLayout
            r3 = r0
            android.widget.ListView r3 = r3.f181hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME
            r2.addView(r3)
            r2 = r0
            android.widget.LinearLayout r2 = r2.listViewLayout
            r2.requestLayout()
            r2 = r1
            r3 = r0
            r2.$add(r3)
            java.lang.String r2 = "ListView"
            java.lang.String r3 = "Listview Created"
            int r2 = android.util.Log.d(r2, r3)
            return
        L_0x019f:
            r2 = r0
            android.widget.EditText r2 = r2.B8WBXPBCF2jGfUDZZU2zV5EYdqbUBu0lAZ0THCEqYyuE8VACR9dY7rDnwBIqh64T
            r3 = 8
            r2.setVisibility(r3)
            goto L_0x0108
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.appinventor.components.runtime.ListView.<init>(com.google.appinventor.components.runtime.ComponentContainer):void");
    }

    public View getView() {
        return this.listViewLayout;
    }

    @SimpleProperty(category = PropertyCategory.APPEARANCE, description = "Determines the height of the list on the view.")
    public void Height(int i) {
        int i2 = i;
        if (i2 == -1) {
            i2 = -2;
        }
        super.Height(i2);
    }

    @SimpleProperty(category = PropertyCategory.APPEARANCE, description = "Determines the width of the list on the view.")
    public void Width(int i) {
        int i2 = i;
        if (i2 == -1) {
            i2 = -2;
        }
        super.Width(i2);
    }

    @SimpleProperty(description = "List of text elements to show in the ListView.")
    public void Elements(YailList yailList) {
        YailList yailList2 = yailList;
        this.vwEpIRqEf6xdtwTR9dehwBO7JUhyLV6iEzEK2WqfPN10eUMQDPn3AUmqAFfsnr6R = yailList2;
        int size = yailList2.size();
        this.Co1rSUoyBoOJ9n0NOgrpxvTYmRPklnETeodUBiQlSBK151C8PCv1Q1Pl4SUa1qxB = new String[size];
        for (int i = 0; i < size; i++) {
            this.Co1rSUoyBoOJ9n0NOgrpxvTYmRPklnETeodUBiQlSBK151C8PCv1Q1Pl4SUa1qxB[i] = YailList.YailListElementToString(yailList2.get(i + 1));
        }
        listUpdate();
    }

    @SimpleProperty(category = PropertyCategory.BEHAVIOR)
    public YailList Elements() {
        return this.vwEpIRqEf6xdtwTR9dehwBO7JUhyLV6iEzEK2WqfPN10eUMQDPn3AUmqAFfsnr6R;
    }

    @DesignerProperty(defaultValue = "", editorType = "textArea")
    @SimpleProperty(category = PropertyCategory.BEHAVIOR, description = "The ListView elements specified as a string with the items separated by commas such as: Cheese,Fruit,Bacon,Radish. Each word before the comma will be an element in the list.")
    public void ElementsFromString(String str) {
        String str2 = str;
        if (str2.length() > 0) {
            YailList makeList = YailList.makeList((Object[]) str2.split(" *, *"));
            this.vwEpIRqEf6xdtwTR9dehwBO7JUhyLV6iEzEK2WqfPN10eUMQDPn3AUmqAFfsnr6R = makeList;
            int size = makeList.size();
            this.Co1rSUoyBoOJ9n0NOgrpxvTYmRPklnETeodUBiQlSBK151C8PCv1Q1Pl4SUa1qxB = new String[size];
            for (int i = 0; i < size; i++) {
                this.Co1rSUoyBoOJ9n0NOgrpxvTYmRPklnETeodUBiQlSBK151C8PCv1Q1Pl4SUa1qxB[i] = YailList.YailListElementToString(makeList.get(i + 1));
            }
            listUpdate();
        }
    }

    @SimpleProperty(category = PropertyCategory.APPEARANCE, description = "Returns true if html is enabled.")
    public boolean HTMLFormat() {
        return this.f182wGMjbGuJ9Yk6s2LaEm8v1pEJlXt36TYBWZSsia0LUgb1yMdHNGB7uRz3VqnF79D0;
    }

    @DesignerProperty(defaultValue = "True", editorType = "boolean", propertyType = "advanced")
    @SimpleProperty(description = "If true, then the listview will show html text else it will show plain text. Note: Not all HTML is supported.")
    public void HTMLFormat(boolean z) {
        this.f182wGMjbGuJ9Yk6s2LaEm8v1pEJlXt36TYBWZSsia0LUgb1yMdHNGB7uRz3VqnF79D0 = z;
        if (this.Co1rSUoyBoOJ9n0NOgrpxvTYmRPklnETeodUBiQlSBK151C8PCv1Q1Pl4SUa1qxB != null) {
            listUpdate();
        }
    }

    public void listUpdate() {
        ArrayAdapter<String> arrayAdapter;
        Drawable drawable;
        ArrayAdapter<String> arrayAdapter2 = arrayAdapter;
        new ArrayAdapter<String>(this, this.context, this.Co1rSUoyBoOJ9n0NOgrpxvTYmRPklnETeodUBiQlSBK151C8PCv1Q1Pl4SUa1qxB) {
            private /* synthetic */ ListView hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME;

            {
                this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME = r10;
            }

            public final View getView(int i, View view, ViewGroup viewGroup) {
                int i2 = i;
                View view2 = super.getView(i2, view, viewGroup);
                TextView hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME2 = ListView.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME(this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME, (TextView) view2.findViewById(16908308));
                if (ListView.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME(this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME)) {
                    ListView.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME(this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME).setText(TextViewUtil.fromHtml((String) getItem(i2)));
                } else {
                    ListView.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME(this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME).setText((CharSequence) getItem(i2));
                }
                TextViewUtil.setFontSize(ListView.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME(this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME), ListView.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME(this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME));
                ListView.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME(this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME).setTextColor(ListView.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME(this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME));
                TextViewUtil.setAlignment(ListView.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME(this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME), ListView.B8WBXPBCF2jGfUDZZU2zV5EYdqbUBu0lAZ0THCEqYyuE8VACR9dY7rDnwBIqh64T(this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME), true);
                TextViewUtil.setFontTypeface(ListView.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME(this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME), ListView.wq07duYRO6iFAgWM70EZOSvbCMKs1QznMRJKrct0XuHOBYqCk3XqOKtSBGIpDou(this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME), ListView.B8WBXPBCF2jGfUDZZU2zV5EYdqbUBu0lAZ0THCEqYyuE8VACR9dY7rDnwBIqh64T(this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME), ListView.wq07duYRO6iFAgWM70EZOSvbCMKs1QznMRJKrct0XuHOBYqCk3XqOKtSBGIpDou(this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME));
                if (ListView.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME(this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME) != null) {
                    TextViewUtil.setCustomFontTypeface(ListView.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME(this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME), ListView.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME(this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME), ListView.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME(this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME), ListView.B8WBXPBCF2jGfUDZZU2zV5EYdqbUBu0lAZ0THCEqYyuE8VACR9dY7rDnwBIqh64T(this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME), ListView.wq07duYRO6iFAgWM70EZOSvbCMKs1QznMRJKrct0XuHOBYqCk3XqOKtSBGIpDou(this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME));
                }
                ListView.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME(this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME).setTextColor(this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.AsUIHfRHW1pScN9YQW0IsOeuFdHXhbXb53xXbDg8x2ZIBxv57XORnQnTS1wprCIt);
                ListView.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME(this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME).setHintTextColor(this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.poblgm1P6mADk8QKAia8LTNTlp3hP9LK4vL2LyACRyn6OaTobhLhKjphCbjAETmg);
                TextViewUtil.setFontSize(ListView.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME(this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME), ListView.B8WBXPBCF2jGfUDZZU2zV5EYdqbUBu0lAZ0THCEqYyuE8VACR9dY7rDnwBIqh64T(this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME));
                DisplayMetrics displayMetrics = ListView.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME(this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME).getResources().getDisplayMetrics();
                ViewGroup.LayoutParams hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME3 = ListView.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME(this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME, view2.getLayoutParams());
                ListView.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME(this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME).height = (displayMetrics.heightPixels / 100) * this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.N4rx6qe3Dkxm9iGosdnZviEGwwAyjrMopVTdmRoB5smsVn2ef0JNliQjJW08w5OT;
                view2.setLayoutParams(ListView.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME(this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME));
                return view2;
            }
        };
        this.f180hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME = arrayAdapter2;
        new ColorDrawable(this.dividerColor);
        this.f181hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.setDivider(drawable);
        this.f181hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.setDividerHeight(this.Kv1J8U7LN9Ew5Fg3SGq5PZTyUq5afJMc801ng97H4mT8uP4jFrbS1BuSDErmLQPa);
        this.f181hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.setAdapter(this.f180hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME);
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        Drawable drawable;
        AdapterView<?> adapterView2 = adapterView;
        View view2 = view;
        int i2 = i;
        long j2 = j;
        if (this.xaven5ecM0Ll2H1GHPRV82tONpToW8URGRDgxbH0b2M0q5wAsNNBDrpsKvL0qvHt) {
            new ColorDrawable(this.pgq50Ta8BOwqZ1x44UiPoTcDoRPiNHTTIb3Jgmceok7eFp2gi0sO4JRUukOMKqHH);
            this.f181hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.setSelector(drawable);
        }
        this.fSI6lxX8qEfUYa0M3qSNEhqEY7tqyd89UewYfJ8WSYLJpTsAFdRvTVg7ORBsMzG8 = i2 + 1;
        this.Ta6bjdQXoFeEb44hWQ7kTTTXw2rT1LHw6UX7lms7WU7H0AkpETH9D9EhELUfywQi = (String) this.f181hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.getItemAtPosition(i2);
        AfterPicking();
    }

    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        Drawable drawable;
        AdapterView<?> adapterView2 = adapterView;
        View view2 = view;
        int i2 = i;
        long j2 = j;
        if (this.xaven5ecM0Ll2H1GHPRV82tONpToW8URGRDgxbH0b2M0q5wAsNNBDrpsKvL0qvHt) {
            new ColorDrawable(this.pgq50Ta8BOwqZ1x44UiPoTcDoRPiNHTTIb3Jgmceok7eFp2gi0sO4JRUukOMKqHH);
            this.f181hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.setSelector(drawable);
        }
        this.fSI6lxX8qEfUYa0M3qSNEhqEY7tqyd89UewYfJ8WSYLJpTsAFdRvTVg7ORBsMzG8 = i2 + 1;
        this.Ta6bjdQXoFeEb44hWQ7kTTTXw2rT1LHw6UX7lms7WU7H0AkpETH9D9EhELUfywQi = (String) this.f181hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.getItemAtPosition(i2);
        if (this.f181hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.isLongClickable()) {
            LongClick();
        }
        return this.f181hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.isLongClickable();
    }

    @DesignerProperty(defaultValue = "False", editorType = "boolean", propertyType = "advanced")
    @SimpleProperty(description = "If true long click on items are enabled, else long click is disabled.")
    public void LongClickEnabled(boolean z) {
        this.f181hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.setLongClickable(z);
    }

    @SimpleProperty(description = "Return the state of 'Long Click Enabled'.")
    public boolean LongClickEnabled() {
        return this.f181hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.isLongClickable();
    }

    @SimpleEvent(description = "Simple event to be raised after the an element has been chosen in the list. The selected element is available in the Selection property.")
    public void AfterPicking() {
        boolean dispatchEvent = EventDispatcher.dispatchEvent(this, "AfterPicking", new Object[0]);
    }

    @SimpleEvent(description = "Simple event to be raised after the an element has been chosen in the list via long click. The selected element is available in the Selection property.")
    public void LongClick() {
        boolean dispatchEvent = EventDispatcher.dispatchEvent(this, "LongClick", new Object[0]);
    }

    @DesignerProperty(defaultValue = "22", editorType = "non_negative_float")
    @SimpleProperty(description = "The text size of the listview items.")
    public void TextSize(float f) {
        float f2 = f;
        this.wGMjbGuJ9Yk6s2LaEm8v1pEJlXt36TYBWZSsia0LUgb1yMdHNGB7uRz3VqnF79D0 = f2;
    }

    @SimpleProperty(description = "Return the text size of the listview items.")
    public float TextSize() {
        return TextViewUtil.getFontSize(this.hR11jdqaRrvBRiBFd4KN6gI7d8MNQVP5Yc7fufDZjGGTeTxaualejjrhiR1Iz2xO, this.context);
    }

    @DesignerProperty(defaultValue = "&HFF000000", editorType = "color")
    @SimpleProperty(description = "The text color of the listview items.")
    public void TextColor(int i) {
        int i2 = i;
        this.bM4TidozxzoY9OaFqMiIYPyvnCah6tSdq3o2XMkQik5CKYcFIbxeqf36lqbvGbmH = i2;
    }

    @SimpleProperty(description = "Return the text color of the listview items.")
    public int TextColor() {
        return this.bM4TidozxzoY9OaFqMiIYPyvnCah6tSdq3o2XMkQik5CKYcFIbxeqf36lqbvGbmH;
    }

    @DesignerProperty(defaultValue = "&HFF000000", editorType = "color", propertyType = "advanced")
    @SimpleProperty(description = "Set the divider color")
    public void DividerColor(int i) {
        int i2 = i;
        this.dividerColor = i2;
    }

    @SimpleProperty(description = "Return the divider color.")
    public int DividerColor() {
        return this.dividerColor;
    }

    @DesignerProperty(defaultValue = "2", editorType = "integer", propertyType = "advanced")
    @SimpleProperty(description = "Set the divider height.")
    public void DividerHeight(int i) {
        int i2 = i;
        this.Kv1J8U7LN9Ew5Fg3SGq5PZTyUq5afJMc801ng97H4mT8uP4jFrbS1BuSDErmLQPa = i2;
    }

    @SimpleProperty(description = "Return the divider height.")
    public int DividerHeight() {
        return this.Kv1J8U7LN9Ew5Fg3SGq5PZTyUq5afJMc801ng97H4mT8uP4jFrbS1BuSDErmLQPa;
    }

    @SimpleProperty(category = PropertyCategory.APPEARANCE, description = "The color of the listview background.")
    public int BackgroundColor() {
        return this.backgroundColor;
    }

    @DesignerProperty(defaultValue = "&HFF607D8B", editorType = "color")
    @SimpleProperty
    public void BackgroundColor(int i) {
        this.backgroundColor = i;
        this.listViewLayout.setBackgroundColor(this.backgroundColor);
    }

    @SimpleProperty(category = PropertyCategory.BEHAVIOR)
    public String FilterBarHint() {
        return this.ZjHRxIxmIbXMaaxTq0tXk7fANzHmvqKL8qVP5oGbbjVmTEOJkL3QkM6pcvCB7aNQ;
    }

    @DesignerProperty(defaultValue = "Search list...", editorType = "string")
    @SimpleProperty(category = PropertyCategory.BEHAVIOR, description = "The hint that will be displayed in the filter bar.")
    public void FilterBarHint(String str) {
        String str2 = str;
        this.ZjHRxIxmIbXMaaxTq0tXk7fANzHmvqKL8qVP5oGbbjVmTEOJkL3QkM6pcvCB7aNQ = str2;
        TextViewUtil.setHint(this.B8WBXPBCF2jGfUDZZU2zV5EYdqbUBu0lAZ0THCEqYyuE8VACR9dY7rDnwBIqh64T, str2);
    }

    @DesignerProperty(defaultValue = "False", editorType = "boolean")
    @SimpleProperty(description = "Sets visibility of ShowFilterBar. True will show the bar, False will hide it.")
    public void ShowFilterBar(boolean z) {
        boolean z2 = z;
        this.dTbjShrSvDZnDCeVo9i3X83sAePZ6DkuyHJPQ6B7WbRWcPLJlbxhZYnAC0mU9DUR = z2;
        if (z2) {
            this.B8WBXPBCF2jGfUDZZU2zV5EYdqbUBu0lAZ0THCEqYyuE8VACR9dY7rDnwBIqh64T.setVisibility(0);
        } else {
            this.B8WBXPBCF2jGfUDZZU2zV5EYdqbUBu0lAZ0THCEqYyuE8VACR9dY7rDnwBIqh64T.setVisibility(8);
        }
    }

    @SimpleProperty(category = PropertyCategory.BEHAVIOR, description = "Returns current state of ShowFilterBar for visibility.")
    public boolean ShowFilterBar() {
        return this.dTbjShrSvDZnDCeVo9i3X83sAePZ6DkuyHJPQ6B7WbRWcPLJlbxhZYnAC0mU9DUR;
    }

    @DesignerProperty(defaultValue = "False", editorType = "boolean", propertyType = "advanced")
    @SimpleProperty(description = "Sets visibility of ShowSelectionColor. True will show the selection color on a selected item, False will hide it.", userVisible = false)
    public void ShowSelectionColor(boolean z) {
        boolean z2 = z;
        this.xaven5ecM0Ll2H1GHPRV82tONpToW8URGRDgxbH0b2M0q5wAsNNBDrpsKvL0qvHt = z2;
    }

    @SimpleProperty(category = PropertyCategory.BEHAVIOR, description = "Returns current state of ShowSelectionColor for visibility.")
    public boolean ShowSelectionColor() {
        return this.xaven5ecM0Ll2H1GHPRV82tONpToW8URGRDgxbH0b2M0q5wAsNNBDrpsKvL0qvHt;
    }

    @DesignerProperty(defaultValue = "&HFFCCCCCC", editorType = "color")
    @SimpleProperty(description = "The color of the item when it is selected.")
    public void SelectionColor(int i) {
        int i2 = i;
        this.pgq50Ta8BOwqZ1x44UiPoTcDoRPiNHTTIb3Jgmceok7eFp2gi0sO4JRUukOMKqHH = i2;
    }

    @SimpleProperty(description = "Returns the selection color.")
    public int SelectionColor() {
        return this.pgq50Ta8BOwqZ1x44UiPoTcDoRPiNHTTIb3Jgmceok7eFp2gi0sO4JRUukOMKqHH;
    }

    @SimpleProperty(category = PropertyCategory.BEHAVIOR, description = "The index of the currently selected item, starting at 1.  If no item is selected, the value will be 0.  If an attempt is made to set this to a number less than 1 or greater than the number of items in the ListView, SelectionIndex will be set to 0, and Selection will be set to the empty text.")
    public int SelectionIndex() {
        return this.fSI6lxX8qEfUYa0M3qSNEhqEY7tqyd89UewYfJ8WSYLJpTsAFdRvTVg7ORBsMzG8;
    }

    @DesignerProperty(defaultValue = "10", editorType = "integer")
    @SimpleProperty(description = "Set the listview item height. If you write 10, that means the item height will be 10 percent of the device screen height.")
    public void ItemHeight(int i) {
        int i2 = i;
        this.N4rx6qe3Dkxm9iGosdnZviEGwwAyjrMopVTdmRoB5smsVn2ef0JNliQjJW08w5OT = i2;
    }

    @SimpleProperty(description = "Return the listview item height.")
    public int ItemHeight() {
        return this.N4rx6qe3Dkxm9iGosdnZviEGwwAyjrMopVTdmRoB5smsVn2ef0JNliQjJW08w5OT;
    }

    @SimpleProperty(category = PropertyCategory.BEHAVIOR, description = "Specifies the position of the selected item in the ListView. This could be used to retrievethe text at the chosen position. If an attempt is made to set this to a number less than 1 or greater than the number of items in the ListView, SelectionIndex will be set to 0, and Selection will be set to the empty text.")
    public void SelectionIndex(int i) {
        int i2 = i;
        this.fSI6lxX8qEfUYa0M3qSNEhqEY7tqyd89UewYfJ8WSYLJpTsAFdRvTVg7ORBsMzG8 = ElementsUtil.selectionIndex(i2, this.vwEpIRqEf6xdtwTR9dehwBO7JUhyLV6iEzEK2WqfPN10eUMQDPn3AUmqAFfsnr6R);
        this.Ta6bjdQXoFeEb44hWQ7kTTTXw2rT1LHw6UX7lms7WU7H0AkpETH9D9EhELUfywQi = ElementsUtil.setSelectionFromIndex(i2, this.vwEpIRqEf6xdtwTR9dehwBO7JUhyLV6iEzEK2WqfPN10eUMQDPn3AUmqAFfsnr6R);
    }

    @DesignerProperty(defaultValue = "", editorType = "string")
    @SimpleProperty(description = "Set the selection to the ListView.")
    public void Selection(String str) {
        String str2 = str;
        this.Ta6bjdQXoFeEb44hWQ7kTTTXw2rT1LHw6UX7lms7WU7H0AkpETH9D9EhELUfywQi = str2;
        this.fSI6lxX8qEfUYa0M3qSNEhqEY7tqyd89UewYfJ8WSYLJpTsAFdRvTVg7ORBsMzG8 = ElementsUtil.setSelectedIndexFromValue(str2, this.vwEpIRqEf6xdtwTR9dehwBO7JUhyLV6iEzEK2WqfPN10eUMQDPn3AUmqAFfsnr6R);
    }

    @SimpleProperty(category = PropertyCategory.BEHAVIOR, description = "Returns the text last selected in the ListView.")
    public String Selection() {
        return this.Ta6bjdQXoFeEb44hWQ7kTTTXw2rT1LHw6UX7lms7WU7H0AkpETH9D9EhELUfywQi;
    }

    @DesignerProperty(defaultValue = "&HFFFFFFFF", editorType = "color")
    @SimpleProperty(description = "The color of the search text.")
    public void SearchTextColor(int i) {
        int i2 = i;
        this.AsUIHfRHW1pScN9YQW0IsOeuFdHXhbXb53xXbDg8x2ZIBxv57XORnQnTS1wprCIt = i2;
    }

    @SimpleProperty(description = "Return the color of the search text.")
    public int SearchTextColor() {
        return this.AsUIHfRHW1pScN9YQW0IsOeuFdHXhbXb53xXbDg8x2ZIBxv57XORnQnTS1wprCIt;
    }

    @DesignerProperty(defaultValue = "14.0", editorType = "non_negative_float")
    @SimpleProperty(description = "The text size of the search text.")
    public void SearchTextSize(float f) {
        float f2 = f;
        this.ANz72NxTeEmYo9CF87MXRUuH7WvE4u0mpZwxffTnyiMdygEQRKvmdTCHaXqAvud = f2;
    }

    @SimpleProperty(description = "Return the text size of the search text.")
    public float SearchTextSize() {
        return TextViewUtil.getFontSize(this.B8WBXPBCF2jGfUDZZU2zV5EYdqbUBu0lAZ0THCEqYyuE8VACR9dY7rDnwBIqh64T, this.context);
    }

    @DesignerProperty(defaultValue = "&HFFCCCCCC", editorType = "color", propertyType = "advanced")
    @SimpleProperty(description = "The color of the search hint text.")
    public void SearchHintColor(int i) {
        int i2 = i;
        this.poblgm1P6mADk8QKAia8LTNTlp3hP9LK4vL2LyACRyn6OaTobhLhKjphCbjAETmg = i2;
    }

    @SimpleProperty(description = "Return the color of the search hint text.")
    public int SearchHintColor() {
        return this.poblgm1P6mADk8QKAia8LTNTlp3hP9LK4vL2LyACRyn6OaTobhLhKjphCbjAETmg;
    }

    @SimpleProperty(category = PropertyCategory.APPEARANCE, userVisible = false)
    public boolean FontBold() {
        return this.PpoaLB2hgzDTOuqu9FkRmbGOAi4DOSz44cSb2WOQzHfJN0AfA0f9dWyZXVLXkHHC;
    }

    @DesignerProperty(defaultValue = "False", editorType = "boolean")
    @SimpleProperty(userVisible = false)
    public void FontBold(boolean z) {
        boolean z2 = z;
        this.PpoaLB2hgzDTOuqu9FkRmbGOAi4DOSz44cSb2WOQzHfJN0AfA0f9dWyZXVLXkHHC = z2;
    }

    @SimpleProperty(category = PropertyCategory.APPEARANCE, userVisible = false)
    public boolean FontItalic() {
        return this.tee1T53LBirhPaiZzuBv7do2U2eC3n16AtczACNW2pKYEGgDhkkMv1hGUupyoKZE;
    }

    @DesignerProperty(defaultValue = "False", editorType = "boolean")
    @SimpleProperty(userVisible = false)
    public void FontItalic(boolean z) {
        boolean z2 = z;
        this.tee1T53LBirhPaiZzuBv7do2U2eC3n16AtczACNW2pKYEGgDhkkMv1hGUupyoKZE = z2;
    }

    @SimpleProperty(category = PropertyCategory.APPEARANCE, userVisible = false)
    public int FontTypeface() {
        return this.fontTypeface;
    }

    @DesignerProperty(defaultValue = "0", editorType = "typeface")
    @SimpleProperty(userVisible = false)
    public void FontTypeface(int i) {
        int i2 = i;
        this.fontTypeface = i2;
    }

    @DesignerProperty(defaultValue = "", editorType = "font_asset", propertyType = "advanced")
    @SimpleProperty(description = "Set a custom font.")
    public void FontTypefaceImport(String str) {
        String str2 = str;
        this.f179AsUIHfRHW1pScN9YQW0IsOeuFdHXhbXb53xXbDg8x2ZIBxv57XORnQnTS1wprCIt = str2;
    }

    @SimpleProperty(category = PropertyCategory.APPEARANCE, userVisible = false)
    public int TextAlignment() {
        return this.sSQuIBUVrx5rcdxHqHgqC6bPLuuDnxnBF7e7BJeOxmxr54l6ArzFZvC3SGBTuUdt;
    }

    @DesignerProperty(defaultValue = "0", editorType = "textalignment")
    @SimpleProperty(userVisible = false)
    public void TextAlignment(int i) {
        int i2 = i;
        this.sSQuIBUVrx5rcdxHqHgqC6bPLuuDnxnBF7e7BJeOxmxr54l6ArzFZvC3SGBTuUdt = i2;
    }

    @SimpleProperty(category = PropertyCategory.APPEARANCE, description = "Return the state of ShowScrollbar. If ShowScrollbar is enabled returns true.")
    public boolean ShowScrollbar() {
        return this.f181hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.isVerticalScrollBarEnabled();
    }

    @DesignerProperty(defaultValue = "True", editorType = "boolean")
    @SimpleProperty(description = "If true you will see a scrollbar when you scrolling the listview.")
    public void ShowScrollbar(boolean z) {
        this.f181hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.setVerticalScrollBarEnabled(z);
    }

    @SimpleProperty(category = PropertyCategory.APPEARANCE, description = "Return the state of ScrollbarFading. If ScrollbarFading is enabled returns true.")
    public boolean ScrollbarFading() {
        return this.f181hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.isScrollbarFadingEnabled();
    }

    @DesignerProperty(defaultValue = "True", editorType = "boolean")
    @SimpleProperty(description = "If true you will see always the scrollbar on the listview.")
    public void ScrollbarFading(boolean z) {
        this.f181hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.setScrollbarFadingEnabled(z);
    }

    @SimpleProperty(description = "Smoothly scroll to the specified position. The listview will scroll such that the indicated position is displayed.")
    public void ScrollToPosition(int i) {
        this.f181hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.smoothScrollToPosition(i - 1);
    }

    @DesignerProperty(defaultValue = "1.0", editorType = "non_negative_float")
    @SimpleProperty(description = "The amount of friction applied to flings.")
    public void ScrollingSpeed(float f) {
        float f2 = f;
        this.KXDzEMeLg0aMKCNRnRJuQGoMaVrKUgtBW3gGmn2kxU5q0F1ZNh5DKQo95IN9JPm2 = f2;
        this.f181hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.setFriction(ViewConfiguration.getScrollFriction() * f2);
    }

    @SimpleProperty(description = "Returns the scrolling speed.")
    public float ScrollingSpeed() {
        return this.KXDzEMeLg0aMKCNRnRJuQGoMaVrKUgtBW3gGmn2kxU5q0F1ZNh5DKQo95IN9JPm2;
    }

    @SimpleFunction(description = "Remove all the items from the list")
    public void ClearList() {
        if (this.f180hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME != null) {
            this.f180hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.clear();
            this.f180hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.notifyDataSetChanged();
        }
    }
}
