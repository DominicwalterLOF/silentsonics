package com.google.appinventor.components.runtime;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.appinventor.components.annotations.DesignerComponent;
import com.google.appinventor.components.annotations.DesignerProperty;
import com.google.appinventor.components.annotations.PropertyCategory;
import com.google.appinventor.components.annotations.SimpleEvent;
import com.google.appinventor.components.annotations.SimpleFunction;
import com.google.appinventor.components.annotations.SimpleObject;
import com.google.appinventor.components.annotations.SimpleProperty;
import com.google.appinventor.components.annotations.UsesPermissions;
import com.google.appinventor.components.common.ComponentCategory;
import com.google.appinventor.components.runtime.util.ElementsUtil;
import com.google.appinventor.components.runtime.util.MediaUtil;
import com.google.appinventor.components.runtime.util.ViewUtil;
import com.google.appinventor.components.runtime.util.YailList;
import java.io.IOException;

@DesignerComponent(category = ComponentCategory.LAYOUT_GENERAL, description = "", iconName = "images/gridview.png", nonVisible = false, version = 1)
@SimpleObject
@UsesPermissions({"android.permission.INTERNET"})
public class GridView extends AndroidViewComponent implements AdapterView.OnItemClickListener {
    private String TAG = "GridView";
    private boolean TQYS6YBjqkoWFaGULpL2H003Eu6rkiOxhECYAYl6g8NMleEVKHe9nH3AkWIoC5xt = true;
    private int backgroundColor;
    private Drawable backgroundImageDrawable;
    private final Context context;
    private android.widget.GridView hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME;

    /* renamed from: hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME  reason: collision with other field name */
    private MyAdapter f149hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME;
    private int ihRLpfoglw4vpN1eVLFIksSKviBvteBH3bd3uSRN7VsdBdKQo5NWEdm996sfoJhJ = 5;
    private String imagePath = "";
    private int kWxA7iNqyKKEpChQAnU1BbhddsMkflBuiFLQemEhYlpBrkEZoiOWj50aF76hVGct = 4;
    private int q0Zein2OQsQpQMJEzcCMbVGzaOYlGS7C9oJS7mmTl1ea6jnbwE6PEACmMQoD3fbj = 150;
    private int textColor = -16777216;
    private final Drawable vSp02fkBXgM8EI0gm0rKWXHQ6wdQINJBQuAtCR15YU8g4XNqVKV8r32SYxkQYxkq;

    /* renamed from: vSp02fkBXgM8EI0gm0rKWXHQ6wdQINJBQuAtCR15YU8g4XNqVKV8r32SYxkQYxkq  reason: collision with other field name */
    private YailList f150vSp02fkBXgM8EI0gm0rKWXHQ6wdQINJBQuAtCR15YU8g4XNqVKV8r32SYxkQYxkq;
    private long wq07duYRO6iFAgWM70EZOSvbCMKs1QznMRJKrct0XuHOBYqCk3XqOKtSBGIpDou = 0;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public GridView(com.google.appinventor.components.runtime.ComponentContainer r11) {
        /*
            r10 = this;
            r1 = r10
            r2 = r11
            r3 = r1
            r4 = r2
            r3.<init>(r4)
            r3 = r1
            r4 = 5
            r3.ihRLpfoglw4vpN1eVLFIksSKviBvteBH3bd3uSRN7VsdBdKQo5NWEdm996sfoJhJ = r4
            r3 = r1
            r4 = 4
            r3.kWxA7iNqyKKEpChQAnU1BbhddsMkflBuiFLQemEhYlpBrkEZoiOWj50aF76hVGct = r4
            r3 = r1
            r4 = 0
            r3.wq07duYRO6iFAgWM70EZOSvbCMKs1QznMRJKrct0XuHOBYqCk3XqOKtSBGIpDou = r4
            r3 = r1
            r4 = 150(0x96, float:2.1E-43)
            r3.q0Zein2OQsQpQMJEzcCMbVGzaOYlGS7C9oJS7mmTl1ea6jnbwE6PEACmMQoD3fbj = r4
            r3 = r1
            java.lang.String r4 = ""
            r3.imagePath = r4
            r3 = r1
            r4 = 1
            r3.TQYS6YBjqkoWFaGULpL2H003Eu6rkiOxhECYAYl6g8NMleEVKHe9nH3AkWIoC5xt = r4
            r3 = r1
            r4 = -16777216(0xffffffffff000000, float:-1.7014118E38)
            r3.textColor = r4
            r3 = r1
            java.lang.String r4 = "GridView"
            r3.TAG = r4
            r3 = r1
            r4 = r2
            android.app.Activity r4 = r4.$context()
            r3.context = r4
            r3 = r1
            android.widget.GridView r4 = new android.widget.GridView
            r9 = r4
            r4 = r9
            r5 = r9
            r6 = r2
            android.app.Activity r6 = r6.$context()
            r5.<init>(r6)
            r3.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME = r4
            r3 = r1
            r9 = r3
            r3 = r9
            r4 = r9
            android.view.View r4 = r4.getView()
            android.graphics.drawable.Drawable r4 = r4.getBackground()
            r3.vSp02fkBXgM8EI0gm0rKWXHQ6wdQINJBQuAtCR15YU8g4XNqVKV8r32SYxkQYxkq = r4
            r3 = r1
            android.widget.GridView r3 = r3.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME
            android.widget.AbsListView$LayoutParams r4 = new android.widget.AbsListView$LayoutParams
            r9 = r4
            r4 = r9
            r5 = r9
            r6 = -1
            r7 = -1
            r5.<init>(r6, r7)
            r3.setLayoutParams(r4)
            r3 = r1
            r9 = r3
            r3 = r9
            r4 = r9
            boolean r4 = r4.TQYS6YBjqkoWFaGULpL2H003Eu6rkiOxhECYAYl6g8NMleEVKHe9nH3AkWIoC5xt
            r3.StretchEnabled(r4)
            r3 = r1
            android.widget.GridView r3 = r3.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME
            r4 = 1
            r3.setGravity(r4)
            r3 = r1
            r9 = r3
            r3 = r9
            r4 = r9
            int r4 = r4.kWxA7iNqyKKEpChQAnU1BbhddsMkflBuiFLQemEhYlpBrkEZoiOWj50aF76hVGct
            r3.Columns(r4)
            r3 = r1
            r4 = 0
            r3.BackgroundColor(r4)
            r3 = r1
            com.google.appinventor.components.runtime.GridView$MyAdapter r4 = new com.google.appinventor.components.runtime.GridView$MyAdapter
            r9 = r4
            r4 = r9
            r5 = r9
            r6 = r1
            r7 = r2
            android.app.Activity r7 = r7.$context()
            r8 = 0
            r5.<init>(r6, r7, r8)
            r3.f149hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME = r4
            r3 = r1
            r4 = 1096810496(0x41600000, float:14.0)
            r3.FontSize(r4)
            r3 = r1
            r4 = -16777216(0xffffffffff000000, float:-1.7014118E38)
            r3.TextColor(r4)
            r3 = r1
            java.lang.String r4 = ""
            r3.ElementsFromString(r4)
            r3 = r1
            android.widget.GridView r3 = r3.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME
            r4 = r1
            r3.setOnItemClickListener(r4)
            r3 = r2
            r4 = r1
            r3.$add(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.appinventor.components.runtime.GridView.<init>(com.google.appinventor.components.runtime.ComponentContainer):void");
    }

    @DesignerProperty(defaultValue = "", editorType = "string")
    @SimpleProperty(category = PropertyCategory.BEHAVIOR, description = "The elements specified as a string with the items separated by commas such as: Cheese,Fruit,Bacon,Radish. Each word before the comma will be an element in the list.")
    public void ElementsFromString(String str) {
        this.f150vSp02fkBXgM8EI0gm0rKWXHQ6wdQINJBQuAtCR15YU8g4XNqVKV8r32SYxkQYxkq = ElementsUtil.elementsFromString(str);
        Elements(this.f150vSp02fkBXgM8EI0gm0rKWXHQ6wdQINJBQuAtCR15YU8g4XNqVKV8r32SYxkQYxkq);
    }

    @SimpleFunction(description = "Clears the items from the component")
    public void ClearGridView() {
        MyAdapter myAdapter;
        this.f149hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.clear();
        MyAdapter myAdapter2 = myAdapter;
        new MyAdapter(this, this.context, (byte) 0);
        this.f149hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME = myAdapter2;
        this.f149hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.setElements(this.f150vSp02fkBXgM8EI0gm0rKWXHQ6wdQINJBQuAtCR15YU8g4XNqVKV8r32SYxkQYxkq.toStringArray());
        this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.setAdapter(this.f149hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME);
        Elements(this.f150vSp02fkBXgM8EI0gm0rKWXHQ6wdQINJBQuAtCR15YU8g4XNqVKV8r32SYxkQYxkq);
    }

    @DesignerProperty(defaultValue = "True", editorType = "boolean")
    @SimpleProperty(description = "Control how items are stretched to fill their space")
    public void StretchEnabled(boolean z) {
        boolean z2 = z;
        this.TQYS6YBjqkoWFaGULpL2H003Eu6rkiOxhECYAYl6g8NMleEVKHe9nH3AkWIoC5xt = z2;
        if (z2) {
            this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.setStretchMode(2);
        } else {
            this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.setStretchMode(3);
        }
    }

    @SimpleProperty(category = PropertyCategory.APPEARANCE)
    public int TextColor() {
        return this.textColor;
    }

    @DesignerProperty(defaultValue = "&HFF000000", editorType = "color")
    @SimpleProperty
    public void TextColor(int i) {
        this.f149hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.setTextColor(i);
    }

    @DesignerProperty(defaultValue = "14.0", editorType = "non_negative_float")
    @SimpleProperty(description = "Sets the font size of the elements")
    public void FontSize(float f) {
        this.f149hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.setFontSize(f);
    }

    @SimpleProperty(description = "Returns the font size of the elements")
    public float FontSize() {
        return this.f149hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.getFontSize();
    }

    @SimpleProperty(description = "List of elements to be used for GridView")
    public void Elements(YailList yailList) {
        MyAdapter myAdapter;
        YailList yailList2 = yailList;
        if (yailList2 != null && yailList2.size() > 0) {
            this.f150vSp02fkBXgM8EI0gm0rKWXHQ6wdQINJBQuAtCR15YU8g4XNqVKV8r32SYxkQYxkq = yailList2;
            MyAdapter myAdapter2 = myAdapter;
            new MyAdapter(this, this.container.$context(), (byte) 0);
            this.f149hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME = myAdapter2;
            this.f149hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.setElements(yailList2.toStringArray());
            this.f149hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.notifyDataSetChanged();
            this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.setAdapter(this.f149hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME);
            this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.invalidate();
        }
    }

    @DesignerProperty(defaultValue = "2", editorType = "integer")
    @SimpleProperty(description = "The amount of padding (in DIP) on left, top, right, bottom")
    public void Padding(int i) {
        int i2 = i;
        this.ihRLpfoglw4vpN1eVLFIksSKviBvteBH3bd3uSRN7VsdBdKQo5NWEdm996sfoJhJ = i2;
        this.f149hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.setPadding(i2);
    }

    @SimpleProperty
    public int Padding() {
        return this.ihRLpfoglw4vpN1eVLFIksSKviBvteBH3bd3uSRN7VsdBdKQo5NWEdm996sfoJhJ;
    }

    public void BackgroundImage(String str) {
        StringBuilder sb;
        if (!TextUtils.isEmpty(str)) {
            try {
                this.backgroundImageDrawable = MediaUtil.getBitmapDrawable(this.container.$form(), this.imagePath);
                if (this.backgroundImageDrawable != null) {
                    ViewUtil.setBackgroundImage(this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME, this.backgroundImageDrawable);
                } else if (this.backgroundColor == 0) {
                    ViewUtil.setBackgroundDrawable(this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME, this.vSp02fkBXgM8EI0gm0rKWXHQ6wdQINJBQuAtCR15YU8g4XNqVKV8r32SYxkQYxkq);
                } else {
                    ViewUtil.setBackgroundDrawable(this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME, (Drawable) null);
                    this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.setBackgroundColor(this.backgroundColor);
                }
            } catch (IOException e) {
                String str2 = this.TAG;
                new StringBuilder("Unable to load ");
                int e2 = Log.e(str2, sb.append(this.imagePath).toString());
            }
        }
    }

    @DesignerProperty(defaultValue = "&H00000000", editorType = "color")
    @SimpleProperty(description = "Specifies the background color. ")
    public void BackgroundColor(int i) {
        this.backgroundColor = i;
        this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.setBackgroundColor(this.backgroundColor);
    }

    @SimpleProperty(description = "Returns the background color. ")
    public int BackgroundColor() {
        return this.backgroundColor;
    }

    @DesignerProperty(defaultValue = "155", editorType = "integer")
    @SimpleProperty(description = "Sets the thumbnail width in DIP (Density Independent Pixels)")
    public void ThumbnailWidth(int i) {
        this.f149hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.vB3WjEtL56PUGm0spJ96S19MI1O4vPR6yju8tUYcKrC4atk0AV5GbVcHQNB7BlIK = i;
        this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.setAdapter(this.f149hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME);
        this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.requestLayout();
    }

    @SimpleProperty(category = PropertyCategory.BEHAVIOR, description = "Returns number of columns for this component")
    public int Columns() {
        return this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.getNumColumns();
    }

    @DesignerProperty(defaultValue = "4", editorType = "integer")
    @SimpleProperty(description = "Sets number of columns used for this component")
    public void Columns(int i) {
        this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.setNumColumns(i);
        this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.invalidate();
    }

    @SimpleProperty(description = "Gets current width of thumbnails")
    public int ThumbnailWidth() {
        return this.f149hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.vB3WjEtL56PUGm0spJ96S19MI1O4vPR6yju8tUYcKrC4atk0AV5GbVcHQNB7BlIK;
    }

    @DesignerProperty(defaultValue = "155", editorType = "integer")
    @SimpleProperty(description = "Sets the thumbnail height in DIP (Density Independent Pixels)")
    public void ThumbnailHeight(int i) {
        this.f149hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.PJTNEFub7t830GnsJOreZR2G4QGerhYk5JzZTaNM1rn2OjCmiPf1GPWMoDtnF4UY = i;
        this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.setAdapter(this.f149hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME);
        this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.requestLayout();
    }

    @SimpleProperty(description = "Gets current height of thumbnails")
    public int ThumbnailHeight() {
        return this.f149hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.PJTNEFub7t830GnsJOreZR2G4QGerhYk5JzZTaNM1rn2OjCmiPf1GPWMoDtnF4UY;
    }

    @SimpleProperty(category = PropertyCategory.BEHAVIOR, description = "Set the selection to the GridView")
    public void Selection(String str) {
        String lowerCase = str.toLowerCase();
        YailList Elements = Elements();
        for (int i = 0; i < Elements.length(); i++) {
            if (lowerCase.equals(Elements.getString(i).toLowerCase())) {
                this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.setSelection(i);
                this.wq07duYRO6iFAgWM70EZOSvbCMKs1QznMRJKrct0XuHOBYqCk3XqOKtSBGIpDou = (long) i;
                return;
            }
        }
    }

    @SimpleProperty(category = PropertyCategory.BEHAVIOR, description = "Gets the selected item from GridView")
    public String Selection() {
        return this.f150vSp02fkBXgM8EI0gm0rKWXHQ6wdQINJBQuAtCR15YU8g4XNqVKV8r32SYxkQYxkq.getString((int) this.wq07duYRO6iFAgWM70EZOSvbCMKs1QznMRJKrct0XuHOBYqCk3XqOKtSBGIpDou);
    }

    @SimpleProperty(category = PropertyCategory.BEHAVIOR, description = "Gets the list of elements")
    public YailList Elements() {
        return this.f150vSp02fkBXgM8EI0gm0rKWXHQ6wdQINJBQuAtCR15YU8g4XNqVKV8r32SYxkQYxkq;
    }

    public View getView() {
        return this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        AdapterView<?> adapterView2 = adapterView;
        View view2 = view;
        int i2 = i;
        long j2 = j;
        this.wq07duYRO6iFAgWM70EZOSvbCMKs1QznMRJKrct0XuHOBYqCk3XqOKtSBGIpDou = (long) i2;
        AfterPicking(this.f150vSp02fkBXgM8EI0gm0rKWXHQ6wdQINJBQuAtCR15YU8g4XNqVKV8r32SYxkQYxkq.getString(i2));
    }

    @SimpleEvent(description = "Triggers after an item from this component has been selected")
    public void AfterPicking(String str) {
        boolean dispatchEvent = EventDispatcher.dispatchEvent(this, "AfterPicking", str);
    }

    public class MyAdapter extends ArrayAdapter<String> {
        private float KbzcIEn6WDqjdY1QBot1TMrBwhEYy4xAUKG2cbzQ22VNohlOtuBGKUJsEeMNZyEH;
        /* access modifiers changed from: private */
        public int PJTNEFub7t830GnsJOreZR2G4QGerhYk5JzZTaNM1rn2OjCmiPf1GPWMoDtnF4UY;
        private Context hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME;

        /* renamed from: hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME  reason: collision with other field name */
        private /* synthetic */ GridView f151hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME;
        private int opkAxsBiNe4U2WnUIj3h2psrvR65Yw7R3K1A4XT1tnHgd80YyvpOyialIyu2UQYR;
        private int rtyU3Uj4Fd2cS2DWhNVfozs9qaFOsy3YcN33Msvg0fbnB6MZpRvgk3PrzB8p4A;
        private int sR32qIN7Ar1u7i1api4nHQx9ll4d2UKsyYwGlFPHAR6MP73rw39BVQBnLHX3cktp;
        private int textColor;
        /* access modifiers changed from: private */
        public int vB3WjEtL56PUGm0spJ96S19MI1O4vPR6yju8tUYcKrC4atk0AV5GbVcHQNB7BlIK;
        private String[] vwEpIRqEf6xdtwTR9dehwBO7JUhyLV6iEzEK2WqfPN10eUMQDPn3AUmqAFfsnr6R;

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        /* synthetic */ MyAdapter(GridView gridView, Context context, byte b) {
            this(gridView, context);
            byte b2 = b;
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private MyAdapter(com.google.appinventor.components.runtime.GridView r10, android.content.Context r11) {
            /*
                r9 = this;
                r0 = r9
                r1 = r10
                r2 = r11
                r3 = r0
                r4 = r1
                r3.f151hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME = r4
                r3 = r0
                r4 = r2
                r5 = 17367043(0x1090003, float:2.5162934E-38)
                r3.<init>(r4, r5)
                r3 = r0
                r4 = 0
                java.lang.String[] r4 = new java.lang.String[r4]
                r3.vwEpIRqEf6xdtwTR9dehwBO7JUhyLV6iEzEK2WqfPN10eUMQDPn3AUmqAFfsnr6R = r4
                r3 = r0
                r4 = 150(0x96, float:2.1E-43)
                r3.vB3WjEtL56PUGm0spJ96S19MI1O4vPR6yju8tUYcKrC4atk0AV5GbVcHQNB7BlIK = r4
                r3 = r0
                r4 = 150(0x96, float:2.1E-43)
                r3.PJTNEFub7t830GnsJOreZR2G4QGerhYk5JzZTaNM1rn2OjCmiPf1GPWMoDtnF4UY = r4
                r3 = r0
                r4 = 2
                r3.rtyU3Uj4Fd2cS2DWhNVfozs9qaFOsy3YcN33Msvg0fbnB6MZpRvgk3PrzB8p4A = r4
                r3 = r0
                r4 = 1096810496(0x41600000, float:14.0)
                r3.KbzcIEn6WDqjdY1QBot1TMrBwhEYy4xAUKG2cbzQ22VNohlOtuBGKUJsEeMNZyEH = r4
                r3 = r0
                r4 = -16777216(0xffffffffff000000, float:-1.7014118E38)
                r3.textColor = r4
                r3 = r0
                r8 = r3
                r3 = r8
                r4 = r8
                com.google.appinventor.components.runtime.GridView r4 = r4.f151hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME
                android.content.Context r4 = com.google.appinventor.components.runtime.GridView.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME((com.google.appinventor.components.runtime.GridView) r4)
                android.content.res.Resources r4 = r4.getResources()
                android.util.DisplayMetrics r4 = r4.getDisplayMetrics()
                float r4 = r4.density
                int r4 = (int) r4
                r3.sR32qIN7Ar1u7i1api4nHQx9ll4d2UKsyYwGlFPHAR6MP73rw39BVQBnLHX3cktp = r4
                r3 = r0
                r4 = r2
                r3.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME = r4
                r3 = r0
                r4 = r1
                com.google.appinventor.components.runtime.ComponentContainer r4 = r4.container
                android.app.Activity r4 = r4.$context()
                android.content.res.Resources r4 = r4.getResources()
                java.lang.String r5 = "ImageGallery_android_galleryItemBackground"
                java.lang.String r6 = "styleable"
                r7 = r1
                com.google.appinventor.components.runtime.ComponentContainer r7 = r7.container
                android.app.Activity r7 = r7.$context()
                java.lang.String r7 = r7.getPackageName()
                int r4 = r4.getIdentifier(r5, r6, r7)
                r3.opkAxsBiNe4U2WnUIj3h2psrvR65Yw7R3K1A4XT1tnHgd80YyvpOyialIyu2UQYR = r4
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.appinventor.components.runtime.GridView.MyAdapter.<init>(com.google.appinventor.components.runtime.GridView, android.content.Context):void");
        }

        public int getCount() {
            return this.vwEpIRqEf6xdtwTR9dehwBO7JUhyLV6iEzEK2WqfPN10eUMQDPn3AUmqAFfsnr6R.length;
        }

        public long getItemId(int i) {
            return (long) i;
        }

        public void setElements(String[] strArr) {
            String[] strArr2 = strArr;
            this.vwEpIRqEf6xdtwTR9dehwBO7JUhyLV6iEzEK2WqfPN10eUMQDPn3AUmqAFfsnr6R = strArr2;
        }

        public String[] getElements() {
            return this.vwEpIRqEf6xdtwTR9dehwBO7JUhyLV6iEzEK2WqfPN10eUMQDPn3AUmqAFfsnr6R;
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            ImageView imageView;
            TextView textView;
            ViewGroup.LayoutParams layoutParams;
            ViewGroup.LayoutParams layoutParams2;
            int i2 = i;
            View view2 = view;
            ViewGroup viewGroup2 = viewGroup;
            new ImageView(this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME);
            ImageView imageView2 = imageView;
            new TextView(this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME);
            TextView textView2 = textView;
            String lowerCase = this.vwEpIRqEf6xdtwTR9dehwBO7JUhyLV6iEzEK2WqfPN10eUMQDPn3AUmqAFfsnr6R[i2].toLowerCase();
            boolean z = false;
            if (lowerCase.endsWith(".png") || lowerCase.endsWith(".jpg") || lowerCase.endsWith(".jpeg") || lowerCase.endsWith(".gif")) {
                z = true;
            }
            int i3 = this.rtyU3Uj4Fd2cS2DWhNVfozs9qaFOsy3YcN33Msvg0fbnB6MZpRvgk3PrzB8p4A * this.sR32qIN7Ar1u7i1api4nHQx9ll4d2UKsyYwGlFPHAR6MP73rw39BVQBnLHX3cktp;
            if (z) {
                try {
                    imageView2.setImageDrawable(MediaUtil.getBitmapDrawable(this.f151hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.container.$form(), this.vwEpIRqEf6xdtwTR9dehwBO7JUhyLV6iEzEK2WqfPN10eUMQDPn3AUmqAFfsnr6R[i2]));
                    new AbsListView.LayoutParams(this.vB3WjEtL56PUGm0spJ96S19MI1O4vPR6yju8tUYcKrC4atk0AV5GbVcHQNB7BlIK * this.sR32qIN7Ar1u7i1api4nHQx9ll4d2UKsyYwGlFPHAR6MP73rw39BVQBnLHX3cktp, this.PJTNEFub7t830GnsJOreZR2G4QGerhYk5JzZTaNM1rn2OjCmiPf1GPWMoDtnF4UY * this.sR32qIN7Ar1u7i1api4nHQx9ll4d2UKsyYwGlFPHAR6MP73rw39BVQBnLHX3cktp);
                    imageView2.setLayoutParams(layoutParams2);
                    imageView2.setScaleType(ImageView.ScaleType.FIT_XY);
                    imageView2.setBackgroundResource(this.opkAxsBiNe4U2WnUIj3h2psrvR65Yw7R3K1A4XT1tnHgd80YyvpOyialIyu2UQYR);
                    int i4 = i3;
                    int i5 = i4;
                    int i6 = i4;
                    int i7 = i3;
                    imageView2.setPadding(i5, i6, i7, i7);
                    return imageView2;
                } catch (IOException e) {
                    int e2 = Log.e(GridView.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME(this.f151hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME), e.getMessage());
                    return textView2;
                }
            } else {
                textView2.setText(this.vwEpIRqEf6xdtwTR9dehwBO7JUhyLV6iEzEK2WqfPN10eUMQDPn3AUmqAFfsnr6R[i2]);
                textView2.setTextSize(this.KbzcIEn6WDqjdY1QBot1TMrBwhEYy4xAUKG2cbzQ22VNohlOtuBGKUJsEeMNZyEH);
                textView2.setTextColor(this.textColor);
                new AbsListView.LayoutParams(this.vB3WjEtL56PUGm0spJ96S19MI1O4vPR6yju8tUYcKrC4atk0AV5GbVcHQNB7BlIK, this.PJTNEFub7t830GnsJOreZR2G4QGerhYk5JzZTaNM1rn2OjCmiPf1GPWMoDtnF4UY);
                textView2.setLayoutParams(layoutParams);
                textView2.setBackgroundResource(this.opkAxsBiNe4U2WnUIj3h2psrvR65Yw7R3K1A4XT1tnHgd80YyvpOyialIyu2UQYR);
                int i8 = i3;
                int i9 = i8;
                int i10 = i8;
                int i11 = i3;
                textView2.setPadding(i9, i10, i11, i11);
                return textView2;
            }
        }

        public void setFontSize(float f) {
            float f2 = f;
            this.KbzcIEn6WDqjdY1QBot1TMrBwhEYy4xAUKG2cbzQ22VNohlOtuBGKUJsEeMNZyEH = f2;
        }

        public float getFontSize() {
            return this.KbzcIEn6WDqjdY1QBot1TMrBwhEYy4xAUKG2cbzQ22VNohlOtuBGKUJsEeMNZyEH;
        }

        public void setTextColor(int i) {
            int i2 = i;
            this.textColor = i2;
        }

        public float getTextColor() {
            return (float) this.textColor;
        }

        public int getPadding() {
            return this.rtyU3Uj4Fd2cS2DWhNVfozs9qaFOsy3YcN33Msvg0fbnB6MZpRvgk3PrzB8p4A;
        }

        public void setPadding(int i) {
            int i2 = i;
            this.rtyU3Uj4Fd2cS2DWhNVfozs9qaFOsy3YcN33Msvg0fbnB6MZpRvgk3PrzB8p4A = i2;
        }
    }
}
