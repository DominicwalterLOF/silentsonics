package com.google.appinventor.components.runtime;

import android.content.Context;
import android.graphics.PorterDuff;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
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
import com.google.appinventor.components.runtime.util.KodularHelper;
import com.google.appinventor.components.runtime.util.TextViewUtil;
import com.google.appinventor.components.runtime.util.YailList;

@SimpleObject
@DesignerComponent(category = ComponentCategory.USERINTERFACE, description = "<p>A spinner component that displays a pop-up with a list of elements. These elements can be set in the Designer or Blocks Editor by setting the<code>ElementsFromString</code> property to a string-separated concatenation (for example, <em>choice 1, choice 2, choice 3</em>) or by setting the <code>Elements</code> property to a List in the Blocks editor. Spinners are created with the first item already selected. So selecting  it does not generate an After Picking event. Consequently it's useful to make the  first Spinner item be a non-choice like \"Select from below...\". </p>", iconName = "images/spinner.png", nonVisible = false, version = 3)
public final class Spinner extends AndroidViewComponent implements AdapterView.OnItemSelectedListener {
    private String AsUIHfRHW1pScN9YQW0IsOeuFdHXhbXb53xXbDg8x2ZIBxv57XORnQnTS1wprCIt = "";
    private float ESt8lrIffFGR3zRMjd5dWbJ7NZymJSmv5KENFDX7fPBQMwlHzz9dP6Ts0eqkVO5e;
    private int PMWpqVMsyfTUgqkfqh3FKX4Q3IYlcybzKrBGEl7qtzs6HNVssJ63V430Ige89pyP = -16777216;
    private boolean PpoaLB2hgzDTOuqu9FkRmbGOAi4DOSz44cSb2WOQzHfJN0AfA0f9dWyZXVLXkHHC;
    private int TQYS6YBjqkoWFaGULpL2H003Eu6rkiOxhECYAYl6g8NMleEVKHe9nH3AkWIoC5xt = -1;
    private int bxHyewHDU6tjPjcIzbzXfzV01j8NQWoss5bSPV3aTV9R2HuXrtdJDRKZiMMA21Bn;
    private Context context;
    private int eaS298peKlTpqlGRGLMTdk3sY259qoFGMqAzTE98DZy2JVNgCwB414XzHrUPTC = -16537101;
    /* access modifiers changed from: private */
    public int fontTypeface = 0;
    private Form form;
    private ArrayAdapter<String> hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME;

    /* renamed from: hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME  reason: collision with other field name */
    private final android.widget.Spinner f243hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME;
    private int ik13O8j78hPb27XeipAJHUcJmdHxYMJFw4gYbTGvLKIOs7SX1F7x61gocQ17TlNc = Component.COLOR_LIGHT_GRAY;
    private float jKqYCd0kbp4PLjuOSuX9UMjydG4JrQByekpZGS3DgrCgeBLPmjJ5QsHwhJoPxxWm = 18.0f;
    private TextView l557Ll1q9gLt3cEfyQaLTgWgvIutpQIPuKKLXX2glk42j33zjQ1xoBSDeCkOGk6j;
    private TextView mBLKdPlRolYfdtud5Z8giGWyhURWoCw9yHsOv08fUnIBAM4MuKAWkHVD8nEhBmIT;
    private boolean plg04zzrdr0Ht9HKV9W5nEWP5Bmt4Culb23NXhe3Y9LVDLRrW71oAQyHt0KrFVdM = false;
    private int sSQuIBUVrx5rcdxHqHgqC6bPLuuDnxnBF7e7BJeOxmxr54l6ArzFZvC3SGBTuUdt = 0;
    private boolean tee1T53LBirhPaiZzuBv7do2U2eC3n16AtczACNW2pKYEGgDhkkMv1hGUupyoKZE;
    private YailList vwEpIRqEf6xdtwTR9dehwBO7JUhyLV6iEzEK2WqfPN10eUMQDPn3AUmqAFfsnr6R;
    private int vzOZHmUO5BPgEzqFqapthv9IfOCdoiue7DhwcposBCrplFafOlnwvaDCI1FzofZg;

    static /* synthetic */ TextView hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME(Spinner spinner, TextView textView) {
        TextView textView2 = textView;
        TextView textView3 = textView2;
        spinner.mBLKdPlRolYfdtud5Z8giGWyhURWoCw9yHsOv08fUnIBAM4MuKAWkHVD8nEhBmIT = textView3;
        return textView2;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public Spinner(com.google.appinventor.components.runtime.ComponentContainer r9) {
        /*
            r8 = this;
            r0 = r8
            r1 = r9
            r2 = r0
            r3 = r1
            r2.<init>(r3)
            r2 = r0
            com.google.appinventor.components.runtime.util.YailList r3 = new com.google.appinventor.components.runtime.util.YailList
            r7 = r3
            r3 = r7
            r4 = r7
            r4.<init>()
            r2.vwEpIRqEf6xdtwTR9dehwBO7JUhyLV6iEzEK2WqfPN10eUMQDPn3AUmqAFfsnr6R = r3
            r2 = r0
            r3 = -1
            r2.TQYS6YBjqkoWFaGULpL2H003Eu6rkiOxhECYAYl6g8NMleEVKHe9nH3AkWIoC5xt = r3
            r2 = r0
            r3 = -16537101(0xffffffffff03a9f3, float:-1.750113E38)
            r2.eaS298peKlTpqlGRGLMTdk3sY259qoFGMqAzTE98DZy2JVNgCwB414XzHrUPTC = r3
            r2 = r0
            r3 = -16777216(0xffffffffff000000, float:-1.7014118E38)
            r2.PMWpqVMsyfTUgqkfqh3FKX4Q3IYlcybzKrBGEl7qtzs6HNVssJ63V430Ige89pyP = r3
            r2 = r0
            r3 = 0
            r2.sSQuIBUVrx5rcdxHqHgqC6bPLuuDnxnBF7e7BJeOxmxr54l6ArzFZvC3SGBTuUdt = r3
            r2 = r0
            r3 = 1099956224(0x41900000, float:18.0)
            r2.jKqYCd0kbp4PLjuOSuX9UMjydG4JrQByekpZGS3DgrCgeBLPmjJ5QsHwhJoPxxWm = r3
            r2 = r0
            java.lang.String r3 = ""
            r2.AsUIHfRHW1pScN9YQW0IsOeuFdHXhbXb53xXbDg8x2ZIBxv57XORnQnTS1wprCIt = r3
            r2 = r0
            r3 = 0
            r2.fontTypeface = r3
            r2 = r0
            r3 = 0
            r2.plg04zzrdr0Ht9HKV9W5nEWP5Bmt4Culb23NXhe3Y9LVDLRrW71oAQyHt0KrFVdM = r3
            r2 = r0
            r3 = -3355444(0xffffffffffcccccc, float:NaN)
            r2.ik13O8j78hPb27XeipAJHUcJmdHxYMJFw4gYbTGvLKIOs7SX1F7x61gocQ17TlNc = r3
            r2 = r0
            r3 = r1
            com.google.appinventor.components.runtime.Form r3 = r3.$form()
            r2.form = r3
            r2 = r0
            r3 = r1
            android.app.Activity r3 = r3.$context()
            r2.context = r3
            r2 = r0
            android.widget.Spinner r3 = new android.widget.Spinner
            r7 = r3
            r3 = r7
            r4 = r7
            r5 = r0
            android.content.Context r5 = r5.context
            r4.<init>(r5)
            r2.f243hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME = r3
            r2 = r0
            com.google.appinventor.components.runtime.Spinner$1 r3 = new com.google.appinventor.components.runtime.Spinner$1
            r7 = r3
            r3 = r7
            r4 = r7
            r5 = r0
            r7 = r5
            r5 = r7
            r6 = r7
            android.content.Context r6 = r6.context
            r4.<init>(r5, r6)
            r2.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME = r3
            r2 = r0
            android.widget.Spinner r2 = r2.f243hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME
            r3 = r0
            android.widget.ArrayAdapter<java.lang.String> r3 = r3.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME
            r2.setAdapter(r3)
            r2 = r0
            android.widget.Spinner r2 = r2.f243hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME
            r3 = r0
            r2.setOnItemSelectedListener(r3)
            r2 = r1
            r3 = r0
            r2.$add(r3)
            r2 = r0
            r7 = r2
            r2 = r7
            r3 = r7
            int r3 = r3.SelectionIndex()
            r2.vzOZHmUO5BPgEzqFqapthv9IfOCdoiue7DhwcposBCrplFafOlnwvaDCI1FzofZg = r3
            r2 = r0
            android.content.Context r2 = r2.context
            com.google.appinventor.components.runtime.util.TextViewUtil.setContext(r2)
            r2 = r0
            r3 = 0
            r2.TextAlignment(r3)
            r2 = r0
            r3 = -1
            r2.ItemTextColor(r3)
            r2 = r0
            r3 = -16537101(0xffffffffff03a9f3, float:-1.750113E38)
            r2.ItemBackgroundColor(r3)
            r2 = r0
            r3 = -14575886(0xffffffffff2196f2, float:-2.1478946E38)
            r2.SpinnerColor(r3)
            r2 = r0
            r3 = -3355444(0xffffffffffcccccc, float:NaN)
            r2.PromptItemColor(r3)
            r2 = r0
            r3 = 1102577664(0x41b80000, float:23.0)
            r2.TextSize(r3)
            r2 = r0
            r3 = 1096810496(0x41600000, float:14.0)
            r2.SpinnerTextSize(r3)
            r2 = r0
            java.lang.String r3 = "Item1,Item2,Item3"
            r2.ElementsFromString(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.appinventor.components.runtime.Spinner.<init>(com.google.appinventor.components.runtime.ComponentContainer):void");
    }

    public final View getView() {
        return this.f243hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME;
    }

    @DesignerProperty(defaultValue = "&HFFFFFFFF", editorType = "color")
    @SimpleProperty(description = "Set the text color for the spinner items.")
    public final void ItemTextColor(int i) {
        int i2 = i;
        this.TQYS6YBjqkoWFaGULpL2H003Eu6rkiOxhECYAYl6g8NMleEVKHe9nH3AkWIoC5xt = i2;
    }

    @SimpleProperty(description = "Returns the text color for the spinner items.")
    public final int ItemTextColor() {
        return this.TQYS6YBjqkoWFaGULpL2H003Eu6rkiOxhECYAYl6g8NMleEVKHe9nH3AkWIoC5xt;
    }

    @DesignerProperty(defaultValue = "&HFF03A9F3", editorType = "color")
    @SimpleProperty(description = "Set the background color for the spinner items.")
    public final void ItemBackgroundColor(int i) {
        int i2 = i;
        this.eaS298peKlTpqlGRGLMTdk3sY259qoFGMqAzTE98DZy2JVNgCwB414XzHrUPTC = i2;
        this.f243hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.getPopupBackground().setColorFilter(i2, PorterDuff.Mode.SRC_ATOP);
    }

    @SimpleProperty(description = "Returns the background color for the spinner items.")
    public final int ItemBackgroundColor() {
        return this.eaS298peKlTpqlGRGLMTdk3sY259qoFGMqAzTE98DZy2JVNgCwB414XzHrUPTC;
    }

    @DesignerProperty(defaultValue = "&HFF2196F2", editorType = "color")
    @SimpleProperty(description = "Set the text color for the spinner.")
    public final void SpinnerColor(int i) {
        int i2 = i;
        this.PMWpqVMsyfTUgqkfqh3FKX4Q3IYlcybzKrBGEl7qtzs6HNVssJ63V430Ige89pyP = i2;
        this.f243hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.getBackground().setColorFilter(i2, PorterDuff.Mode.SRC_ATOP);
    }

    @SimpleProperty(description = "Returns the text color for the spinner.")
    public final int SpinnerColor() {
        return this.PMWpqVMsyfTUgqkfqh3FKX4Q3IYlcybzKrBGEl7qtzs6HNVssJ63V430Ige89pyP;
    }

    @SimpleProperty(category = PropertyCategory.APPEARANCE, userVisible = false)
    public final int TextAlignment() {
        return this.sSQuIBUVrx5rcdxHqHgqC6bPLuuDnxnBF7e7BJeOxmxr54l6ArzFZvC3SGBTuUdt;
    }

    @DesignerProperty(defaultValue = "0", editorType = "textalignment")
    @SimpleProperty(userVisible = false)
    public final void TextAlignment(int i) {
        int i2 = i;
        this.sSQuIBUVrx5rcdxHqHgqC6bPLuuDnxnBF7e7BJeOxmxr54l6ArzFZvC3SGBTuUdt = i2;
    }

    @DesignerProperty(defaultValue = "18", editorType = "non_negative_float")
    @SimpleProperty(description = "The text size of the spinner items.")
    public final void TextSize(float f) {
        float f2 = f;
        this.jKqYCd0kbp4PLjuOSuX9UMjydG4JrQByekpZGS3DgrCgeBLPmjJ5QsHwhJoPxxWm = f2;
    }

    @SimpleProperty(description = "Return the text size of the spinner items.")
    public final float TextSize() {
        return TextViewUtil.getFontSize(this.mBLKdPlRolYfdtud5Z8giGWyhURWoCw9yHsOv08fUnIBAM4MuKAWkHVD8nEhBmIT, this.context);
    }

    @SimpleProperty(category = PropertyCategory.APPEARANCE, userVisible = false)
    public final boolean FontBold() {
        return this.PpoaLB2hgzDTOuqu9FkRmbGOAi4DOSz44cSb2WOQzHfJN0AfA0f9dWyZXVLXkHHC;
    }

    @DesignerProperty(defaultValue = "False", editorType = "boolean")
    @SimpleProperty(userVisible = false)
    public final void FontBold(boolean z) {
        boolean z2 = z;
        this.PpoaLB2hgzDTOuqu9FkRmbGOAi4DOSz44cSb2WOQzHfJN0AfA0f9dWyZXVLXkHHC = z2;
    }

    @SimpleProperty(category = PropertyCategory.APPEARANCE, userVisible = false)
    public final boolean FontItalic() {
        return this.tee1T53LBirhPaiZzuBv7do2U2eC3n16AtczACNW2pKYEGgDhkkMv1hGUupyoKZE;
    }

    @DesignerProperty(defaultValue = "False", editorType = "boolean")
    @SimpleProperty(userVisible = false)
    public final void FontItalic(boolean z) {
        boolean z2 = z;
        this.tee1T53LBirhPaiZzuBv7do2U2eC3n16AtczACNW2pKYEGgDhkkMv1hGUupyoKZE = z2;
    }

    @SimpleProperty(category = PropertyCategory.APPEARANCE, userVisible = false)
    public final int FontTypeface() {
        return this.fontTypeface;
    }

    @DesignerProperty(defaultValue = "0", editorType = "typeface")
    @SimpleProperty(userVisible = false)
    public final void FontTypeface(int i) {
        int i2 = i;
        this.fontTypeface = i2;
    }

    @DesignerProperty(defaultValue = "", editorType = "font_asset", propertyType = "advanced")
    @SimpleProperty(description = "Set a custom font.")
    public final void FontTypefaceImport(String str) {
        String str2 = str;
        this.AsUIHfRHW1pScN9YQW0IsOeuFdHXhbXb53xXbDg8x2ZIBxv57XORnQnTS1wprCIt = str2;
    }

    @DesignerProperty(defaultValue = "False", editorType = "boolean", propertyType = "advanced")
    @SimpleProperty(description = "If true the first spinner item will be the prompt text.")
    public final void UsePrompt(boolean z) {
        boolean z2 = z;
        this.plg04zzrdr0Ht9HKV9W5nEWP5Bmt4Culb23NXhe3Y9LVDLRrW71oAQyHt0KrFVdM = z2;
    }

    @DesignerProperty(defaultValue = "&HFFCCCCCC", editorType = "color")
    @SimpleProperty(description = "Set the text color for the spinner items prompt/hint.")
    public final void PromptItemColor(int i) {
        int i2 = i;
        this.ik13O8j78hPb27XeipAJHUcJmdHxYMJFw4gYbTGvLKIOs7SX1F7x61gocQ17TlNc = i2;
    }

    @SimpleProperty(description = "Returns the text color for the spinner items prompt/hint.")
    public final int PromptItemColor() {
        return this.ik13O8j78hPb27XeipAJHUcJmdHxYMJFw4gYbTGvLKIOs7SX1F7x61gocQ17TlNc;
    }

    @SimpleProperty(category = PropertyCategory.BEHAVIOR, description = "Returns the current selected item in the spinner.")
    public final String Selection() {
        return SelectionIndex() == 0 ? "" : (String) this.f243hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.getItemAtPosition(SelectionIndex() - 1);
    }

    @DesignerProperty(defaultValue = "", editorType = "string")
    @SimpleProperty(category = PropertyCategory.BEHAVIOR, description = "Set the selected item in the spinner")
    public final void Selection(String str) {
        SelectionIndex(ElementsUtil.setSelectedIndexFromValue(str, this.vwEpIRqEf6xdtwTR9dehwBO7JUhyLV6iEzEK2WqfPN10eUMQDPn3AUmqAFfsnr6R));
    }

    @SimpleProperty(category = PropertyCategory.BEHAVIOR, description = "The index of the currently selected item, starting at 1. If no item is selected, the value will be 0.")
    public final int SelectionIndex() {
        return ElementsUtil.selectionIndex(this.f243hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.getSelectedItemPosition() + 1, this.vwEpIRqEf6xdtwTR9dehwBO7JUhyLV6iEzEK2WqfPN10eUMQDPn3AUmqAFfsnr6R);
    }

    @SimpleProperty(category = PropertyCategory.BEHAVIOR, description = "Set the spinner selection to the element at the given index.If an attempt is made to set this to a number less than 1 or greater than the number of items in the Spinner, SelectionIndex will be set to 0, and Selection will be set to empty.")
    public final void SelectionIndex(int i) {
        this.vzOZHmUO5BPgEzqFqapthv9IfOCdoiue7DhwcposBCrplFafOlnwvaDCI1FzofZg = SelectionIndex();
        this.f243hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.setSelection(ElementsUtil.selectionIndex(i, this.vwEpIRqEf6xdtwTR9dehwBO7JUhyLV6iEzEK2WqfPN10eUMQDPn3AUmqAFfsnr6R) - 1);
    }

    @SimpleProperty(category = PropertyCategory.BEHAVIOR, description = "returns a list of text elements to be picked from.")
    public final YailList Elements() {
        return this.vwEpIRqEf6xdtwTR9dehwBO7JUhyLV6iEzEK2WqfPN10eUMQDPn3AUmqAFfsnr6R;
    }

    @SimpleProperty(category = PropertyCategory.BEHAVIOR, description = "Adds the passed text element to the Spinner list.")
    public final void Elements(YailList yailList) {
        YailList yailList2 = yailList;
        if (yailList2.size() == 0) {
            SelectionIndex(0);
        } else if (yailList2.size() < this.vwEpIRqEf6xdtwTR9dehwBO7JUhyLV6iEzEK2WqfPN10eUMQDPn3AUmqAFfsnr6R.size() && SelectionIndex() == this.vwEpIRqEf6xdtwTR9dehwBO7JUhyLV6iEzEK2WqfPN10eUMQDPn3AUmqAFfsnr6R.size()) {
            SelectionIndex(yailList2.size());
        }
        this.vwEpIRqEf6xdtwTR9dehwBO7JUhyLV6iEzEK2WqfPN10eUMQDPn3AUmqAFfsnr6R = ElementsUtil.elements(yailList2, "Spinner");
        String[] stringArray = yailList2.toStringArray();
        this.bxHyewHDU6tjPjcIzbzXfzV01j8NQWoss5bSPV3aTV9R2HuXrtdJDRKZiMMA21Bn = this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.getCount();
        this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.clear();
        for (int i = 0; i < stringArray.length; i++) {
            this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.add(stringArray[i]);
        }
    }

    @DesignerProperty(defaultValue = "Item1, Item2, Item3", editorType = "string")
    @SimpleProperty(category = PropertyCategory.BEHAVIOR, description = "Sets the Spinner list to the elements passed in the comma-separated string.")
    public final void ElementsFromString(String str) {
        Elements(ElementsUtil.elementsFromString(str));
    }

    @Deprecated
    @SimpleProperty(category = PropertyCategory.APPEARANCE, description = "Text with the current title for the Spinner window.", userVisible = false)
    public final String Prompt() {
        return this.f243hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.getPrompt().toString();
    }

    @DesignerProperty(defaultValue = "", editorType = "string")
    @Deprecated
    @SimpleProperty(category = PropertyCategory.APPEARANCE, description = "Sets the Spinner window prompt to the given title.", userVisible = false)
    public final void Prompt(String str) {
        this.f243hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.setPrompt(str);
    }

    @SimpleFunction(description = "displays the dropdown list for selection, same action as when the user clicks on the spinner.")
    public final void DisplayDropdown() {
        boolean performClick = this.f243hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.performClick();
    }

    @SimpleEvent(description = "Event called after the user selects an item from the dropdown list.")
    public final void AfterSelecting(String str) {
        boolean dispatchEvent = EventDispatcher.dispatchEvent(this, "AfterSelecting", str);
    }

    @DesignerProperty(defaultValue = "14.0", editorType = "non_negative_float")
    @SimpleProperty(description = "The size of the spinner selected text.")
    public final void SpinnerTextSize(float f) {
        float f2 = f;
        this.ESt8lrIffFGR3zRMjd5dWbJ7NZymJSmv5KENFDX7fPBQMwlHzz9dP6Ts0eqkVO5e = f2;
    }

    @SimpleProperty(description = "Return the size of the spinner selection text.")
    public final float SpinnerTextSize() {
        return TextViewUtil.getFontSize(this.l557Ll1q9gLt3cEfyQaLTgWgvIutpQIPuKKLXX2glk42j33zjQ1xoBSDeCkOGk6j, this.context);
    }

    public final void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
        AdapterView<?> adapterView2 = adapterView;
        int i2 = i;
        long j2 = j;
        this.l557Ll1q9gLt3cEfyQaLTgWgvIutpQIPuKKLXX2glk42j33zjQ1xoBSDeCkOGk6j = (TextView) view;
        this.l557Ll1q9gLt3cEfyQaLTgWgvIutpQIPuKKLXX2glk42j33zjQ1xoBSDeCkOGk6j.setTextColor(this.PMWpqVMsyfTUgqkfqh3FKX4Q3IYlcybzKrBGEl7qtzs6HNVssJ63V430Ige89pyP);
        KodularHelper.setPadding(this.l557Ll1q9gLt3cEfyQaLTgWgvIutpQIPuKKLXX2glk42j33zjQ1xoBSDeCkOGk6j, this.context, 2, 1, 2, 1);
        TextViewUtil.setFontSize(this.l557Ll1q9gLt3cEfyQaLTgWgvIutpQIPuKKLXX2glk42j33zjQ1xoBSDeCkOGk6j, this.ESt8lrIffFGR3zRMjd5dWbJ7NZymJSmv5KENFDX7fPBQMwlHzz9dP6Ts0eqkVO5e);
        if ((this.bxHyewHDU6tjPjcIzbzXfzV01j8NQWoss5bSPV3aTV9R2HuXrtdJDRKZiMMA21Bn == 0 && this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.getCount() > 0 && this.vzOZHmUO5BPgEzqFqapthv9IfOCdoiue7DhwcposBCrplFafOlnwvaDCI1FzofZg == 0) || (this.bxHyewHDU6tjPjcIzbzXfzV01j8NQWoss5bSPV3aTV9R2HuXrtdJDRKZiMMA21Bn > this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.getCount() && this.vzOZHmUO5BPgEzqFqapthv9IfOCdoiue7DhwcposBCrplFafOlnwvaDCI1FzofZg > this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.getCount())) {
            SelectionIndex(i2 + 1);
            this.bxHyewHDU6tjPjcIzbzXfzV01j8NQWoss5bSPV3aTV9R2HuXrtdJDRKZiMMA21Bn = this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.getCount();
        } else if (!this.plg04zzrdr0Ht9HKV9W5nEWP5Bmt4Culb23NXhe3Y9LVDLRrW71oAQyHt0KrFVdM || i2 > 0) {
            SelectionIndex(i2 + 1);
            AfterSelecting(Selection());
        }
    }

    public final void onNothingSelected(AdapterView<?> adapterView) {
        AdapterView<?> adapterView2 = adapterView;
        this.f243hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.setSelection(0);
    }
}
