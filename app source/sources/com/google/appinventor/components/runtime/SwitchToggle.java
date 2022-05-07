package com.google.appinventor.components.runtime;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.widget.CompoundButton;
import android.widget.Switch;
import com.google.appinventor.components.annotations.DesignerComponent;
import com.google.appinventor.components.annotations.DesignerProperty;
import com.google.appinventor.components.annotations.PropertyCategory;
import com.google.appinventor.components.annotations.SimpleEvent;
import com.google.appinventor.components.annotations.SimpleFunction;
import com.google.appinventor.components.annotations.SimpleObject;
import com.google.appinventor.components.annotations.SimpleProperty;
import com.google.appinventor.components.common.ComponentCategory;
import com.google.appinventor.components.runtime.util.KodularHelper;
import com.google.appinventor.components.runtime.util.MediaUtil;
import com.google.appinventor.components.runtime.util.TextViewUtil;

@SimpleObject
@DesignerComponent(category = ComponentCategory.USERINTERFACE, description = "write in ode", helpUrl = "https://docs.kodular.io/components/user-interface/switch/", version = 4)
public final class SwitchToggle extends AndroidViewComponent implements CompoundButton.OnCheckedChangeListener {
    private String CfJsMCmg8U782C2ivbbep8ZFrAD6R9Wq7P09zMpUKCFkpiEYodk6t8FdSxHzlHKV = "Switch Off";
    private boolean PpoaLB2hgzDTOuqu9FkRmbGOAi4DOSz44cSb2WOQzHfJN0AfA0f9dWyZXVLXkHHC = false;
    private int Sj3UMCQcT7f46E8U4TVavenawPElr174psURarVHJJBTqMXe22hIekct3fzxe7Vm = Component.COLOR_TEAL;
    private String UT8jc0jwpnlGoVnBZm9Vqfc7zQxpOFTo7zW0ZxKDjXZZsrQ7LsG7hsoko7RBNNg5 = "Switch On";
    private Context context;
    private int fontTypeface = 0;
    private final Switch hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME;
    private boolean tee1T53LBirhPaiZzuBv7do2U2eC3n16AtczACNW2pKYEGgDhkkMv1hGUupyoKZE = false;
    private int textColor = Component.COLOR_GREEN;
    private int yHAbLPerXNK4pCwn5nqbt3OeUjDvQdxh29RmVa0moB4dUtgatbeaGoP5jClPUWFb = Component.COLOR_GREEN;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public SwitchToggle(com.google.appinventor.components.runtime.ComponentContainer r11) {
        /*
            r10 = this;
            r0 = r10
            r1 = r11
            r3 = r0
            r4 = r1
            com.google.appinventor.components.runtime.Form r4 = r4.$form()
            r3.<init>(r4)
            r3 = r0
            r4 = -11751600(0xffffffffff4caf50, float:-2.7207279E38)
            r3.yHAbLPerXNK4pCwn5nqbt3OeUjDvQdxh29RmVa0moB4dUtgatbeaGoP5jClPUWFb = r4
            r3 = r0
            r4 = -16738680(0xffffffffff009688, float:-1.7092279E38)
            r3.Sj3UMCQcT7f46E8U4TVavenawPElr174psURarVHJJBTqMXe22hIekct3fzxe7Vm = r4
            r3 = r0
            java.lang.String r4 = "Switch On"
            r3.UT8jc0jwpnlGoVnBZm9Vqfc7zQxpOFTo7zW0ZxKDjXZZsrQ7LsG7hsoko7RBNNg5 = r4
            r3 = r0
            java.lang.String r4 = "Switch Off"
            r3.CfJsMCmg8U782C2ivbbep8ZFrAD6R9Wq7P09zMpUKCFkpiEYodk6t8FdSxHzlHKV = r4
            r3 = r0
            r4 = -11751600(0xffffffffff4caf50, float:-2.7207279E38)
            r3.textColor = r4
            r3 = r0
            r4 = 0
            r3.PpoaLB2hgzDTOuqu9FkRmbGOAi4DOSz44cSb2WOQzHfJN0AfA0f9dWyZXVLXkHHC = r4
            r3 = r0
            r4 = 0
            r3.tee1T53LBirhPaiZzuBv7do2U2eC3n16AtczACNW2pKYEGgDhkkMv1hGUupyoKZE = r4
            r3 = r0
            r4 = 0
            r3.fontTypeface = r4
            r3 = r0
            r4 = r1
            android.app.Activity r4 = r4.$context()
            r3.context = r4
            r3 = r0
            android.content.Context r3 = r3.context
            com.google.appinventor.components.runtime.util.TextViewUtil.setContext(r3)
            r3 = r0
            android.widget.Switch r4 = new android.widget.Switch
            r9 = r4
            r4 = r9
            r5 = r9
            r6 = r0
            android.content.Context r6 = r6.context
            r5.<init>(r6)
            r3.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME = r4
            r3 = r0
            android.widget.Switch r3 = r3.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME
            r4 = r0
            r3.setOnCheckedChangeListener(r4)
            r3 = r0
            android.widget.Switch r3 = r3.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME
            r4 = r0
            android.content.Context r4 = r4.context
            r5 = 4
            r6 = 4
            r7 = 4
            r8 = 4
            com.google.appinventor.components.runtime.util.KodularHelper.setPadding(r3, r4, r5, r6, r7, r8)
            r3 = r0
            android.widget.Switch r3 = r3.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME
            r4 = r0
            r2 = r4
            r4 = 1092616192(0x41200000, float:10.0)
            r5 = r2
            android.content.Context r5 = r5.context
            android.content.res.Resources r5 = r5.getResources()
            android.util.DisplayMetrics r5 = r5.getDisplayMetrics()
            float r5 = r5.density
            float r4 = r4 * r5
            r5 = 1056964608(0x3f000000, float:0.5)
            float r4 = r4 + r5
            int r4 = (int) r4
            r3.setSwitchPadding(r4)
            r3 = r1
            r4 = r0
            r3.$add(r4)
            r3 = r0
            r4 = -11751600(0xffffffffff4caf50, float:-2.7207279E38)
            r3.ThumbColor(r4)
            r3 = r0
            r4 = -16738680(0xffffffffff009688, float:-1.7092279E38)
            r3.TrackColor(r4)
            r3 = r0
            android.widget.Switch r3 = r3.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME
            r4 = r0
            int r4 = r4.fontTypeface
            r5 = r0
            boolean r5 = r5.PpoaLB2hgzDTOuqu9FkRmbGOAi4DOSz44cSb2WOQzHfJN0AfA0f9dWyZXVLXkHHC
            r6 = r0
            boolean r6 = r6.tee1T53LBirhPaiZzuBv7do2U2eC3n16AtczACNW2pKYEGgDhkkMv1hGUupyoKZE
            com.google.appinventor.components.runtime.util.TextViewUtil.setFontTypeface(r3, r4, r5, r6)
            r3 = r0
            r4 = 1096810496(0x41600000, float:14.0)
            r3.TextSize(r4)
            r3 = r0
            r4 = -11751600(0xffffffffff4caf50, float:-2.7207279E38)
            r3.TextColor(r4)
            r3 = r0
            java.lang.String r4 = "Switch On"
            r3.TextOn(r4)
            r3 = r0
            java.lang.String r4 = "Switch Off"
            r3.TextOff(r4)
            r3 = r0
            r4 = 0
            r3.Checked(r4)
            java.lang.String r3 = "Switch"
            java.lang.String r4 = "Switch Created"
            int r3 = android.util.Log.d(r3, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.appinventor.components.runtime.SwitchToggle.<init>(com.google.appinventor.components.runtime.ComponentContainer):void");
    }

    public final Switch getView() {
        return this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        StringBuilder sb;
        StringBuilder sb2;
        CompoundButton compoundButton2 = compoundButton;
        boolean z2 = z;
        if (z2) {
            Switch switchR = this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME;
            new StringBuilder();
            switchR.setText(TextViewUtil.fromHtml(sb2.append(this.UT8jc0jwpnlGoVnBZm9Vqfc7zQxpOFTo7zW0ZxKDjXZZsrQ7LsG7hsoko7RBNNg5).append("  ").toString()));
        } else {
            Switch switchR2 = this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME;
            new StringBuilder();
            switchR2.setText(TextViewUtil.fromHtml(sb.append(this.CfJsMCmg8U782C2ivbbep8ZFrAD6R9Wq7P09zMpUKCFkpiEYodk6t8FdSxHzlHKV).append("  ").toString()));
        }
        Clicked(z2);
    }

    @SimpleEvent(description = "Event invoked when a switch has been clicked. Returns true or false if the switch is checked or not.")
    public final void Clicked(boolean z) {
        boolean dispatchEvent = EventDispatcher.dispatchEvent(this, "Clicked", Boolean.valueOf(z));
    }

    @DesignerProperty(defaultValue = "True", editorType = "boolean")
    @SimpleProperty(description = "If set to true, user can touch the switch.")
    public final void Enabled(boolean z) {
        this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.setEnabled(z);
    }

    @SimpleProperty(description = "Returns true is the switch is enabled.")
    public final boolean Enabled() {
        return this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.isEnabled();
    }

    @DesignerProperty(defaultValue = "&HFF4CAF50", editorType = "color")
    @SimpleProperty(description = "Change the disabled color of the switch.")
    public final void ThumbColor(int i) {
        int i2 = i;
        this.yHAbLPerXNK4pCwn5nqbt3OeUjDvQdxh29RmVa0moB4dUtgatbeaGoP5jClPUWFb = i2;
        this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.getThumbDrawable().setColorFilter(i2, PorterDuff.Mode.SRC_ATOP);
    }

    @SimpleProperty(description = "Return the thumb color.")
    public final int ThumbColor() {
        return this.yHAbLPerXNK4pCwn5nqbt3OeUjDvQdxh29RmVa0moB4dUtgatbeaGoP5jClPUWFb;
    }

    @DesignerProperty(defaultValue = "&HFF009688", editorType = "color")
    @SimpleProperty(description = "Change the enabled color of the switch.")
    public final void TrackColor(int i) {
        int i2 = i;
        this.Sj3UMCQcT7f46E8U4TVavenawPElr174psURarVHJJBTqMXe22hIekct3fzxe7Vm = i2;
        this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.getTrackDrawable().setColorFilter(i2, PorterDuff.Mode.SRC_ATOP);
    }

    @SimpleProperty(description = "Return the thumb color.")
    public final int TrackColor() {
        return this.Sj3UMCQcT7f46E8U4TVavenawPElr174psURarVHJJBTqMXe22hIekct3fzxe7Vm;
    }

    @SimpleProperty(description = "Return true if the switch is checked else false.")
    public final boolean isChecked() {
        return this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.isChecked();
    }

    @DesignerProperty(defaultValue = "False", editorType = "boolean")
    @SimpleProperty(description = "Set the toggle to checked or unchecked")
    public final void Checked(boolean z) {
        this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.setChecked(z);
    }

    @DesignerProperty(defaultValue = "14.0", editorType = "non_negative_float")
    @SimpleProperty(description = "The text size of the switch.")
    public final void TextSize(float f) {
        TextViewUtil.setFontSize(this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME, f);
    }

    @SimpleProperty(description = "Return the text size of the switch.")
    public final float TextSize() {
        return TextViewUtil.getFontSize(this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME, this.context);
    }

    @DesignerProperty(defaultValue = "&HFF4CAF50", editorType = "color")
    @SimpleProperty(description = "Set the text color for the switch.")
    public final void TextColor(int i) {
        int i2 = i;
        this.textColor = i2;
        this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.setTextColor(i2);
    }

    @SimpleProperty(description = "Returns the text color for the switch.")
    public final int TextColor() {
        return this.textColor;
    }

    @SimpleProperty(category = PropertyCategory.APPEARANCE, userVisible = false)
    public final boolean FontBold() {
        return this.PpoaLB2hgzDTOuqu9FkRmbGOAi4DOSz44cSb2WOQzHfJN0AfA0f9dWyZXVLXkHHC;
    }

    @DesignerProperty(defaultValue = "False", editorType = "boolean")
    @SimpleProperty(userVisible = false)
    public final void FontBold(boolean z) {
        this.PpoaLB2hgzDTOuqu9FkRmbGOAi4DOSz44cSb2WOQzHfJN0AfA0f9dWyZXVLXkHHC = z;
        TextViewUtil.setFontTypeface(this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME, this.fontTypeface, this.PpoaLB2hgzDTOuqu9FkRmbGOAi4DOSz44cSb2WOQzHfJN0AfA0f9dWyZXVLXkHHC, this.tee1T53LBirhPaiZzuBv7do2U2eC3n16AtczACNW2pKYEGgDhkkMv1hGUupyoKZE);
    }

    @SimpleProperty(category = PropertyCategory.APPEARANCE, userVisible = false)
    public final boolean FontItalic() {
        return this.tee1T53LBirhPaiZzuBv7do2U2eC3n16AtczACNW2pKYEGgDhkkMv1hGUupyoKZE;
    }

    @DesignerProperty(defaultValue = "False", editorType = "boolean")
    @SimpleProperty(userVisible = false)
    public final void FontItalic(boolean z) {
        this.tee1T53LBirhPaiZzuBv7do2U2eC3n16AtczACNW2pKYEGgDhkkMv1hGUupyoKZE = z;
        TextViewUtil.setFontTypeface(this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME, this.fontTypeface, this.PpoaLB2hgzDTOuqu9FkRmbGOAi4DOSz44cSb2WOQzHfJN0AfA0f9dWyZXVLXkHHC, this.tee1T53LBirhPaiZzuBv7do2U2eC3n16AtczACNW2pKYEGgDhkkMv1hGUupyoKZE);
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
        if (str2 != null) {
            TextViewUtil.setCustomFontTypeface(this.container.$form(), this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME, str2, this.PpoaLB2hgzDTOuqu9FkRmbGOAi4DOSz44cSb2WOQzHfJN0AfA0f9dWyZXVLXkHHC, this.tee1T53LBirhPaiZzuBv7do2U2eC3n16AtczACNW2pKYEGgDhkkMv1hGUupyoKZE);
        }
    }

    @DesignerProperty(defaultValue = "Switch On", editorType = "textArea")
    @SimpleProperty(description = "Set here the switch on text. HTML tags are too possible: <b>, <big>, <blockquote>, <br>, <cite>, <dfn>, <div>, <em>, <small>, <strong>, <sub>, <sup>, <tt>, <u>. Example: <big>Test</big>.")
    public final void TextOn(String str) {
        StringBuilder sb;
        StringBuilder sb2;
        this.UT8jc0jwpnlGoVnBZm9Vqfc7zQxpOFTo7zW0ZxKDjXZZsrQ7LsG7hsoko7RBNNg5 = str;
        if (this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.isChecked()) {
            Switch switchR = this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME;
            new StringBuilder();
            switchR.setText(TextViewUtil.fromHtml(sb2.append(this.UT8jc0jwpnlGoVnBZm9Vqfc7zQxpOFTo7zW0ZxKDjXZZsrQ7LsG7hsoko7RBNNg5).append("  ").toString()));
            return;
        }
        Switch switchR2 = this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME;
        new StringBuilder();
        switchR2.setText(TextViewUtil.fromHtml(sb.append(this.CfJsMCmg8U782C2ivbbep8ZFrAD6R9Wq7P09zMpUKCFkpiEYodk6t8FdSxHzlHKV).append("  ").toString()));
    }

    @SimpleProperty(description = "Return the switch on text.")
    public final String TextOn() {
        return this.UT8jc0jwpnlGoVnBZm9Vqfc7zQxpOFTo7zW0ZxKDjXZZsrQ7LsG7hsoko7RBNNg5;
    }

    @DesignerProperty(defaultValue = "Switch Off", editorType = "textArea")
    @SimpleProperty(description = "Set here the switch off text. HTML tags are too possible: <b>, <big>, <blockquote>, <br>, <cite>, <dfn>, <div>, <em>, <small>, <strong>, <sub>, <sup>, <tt>, <u>. Example: <big>Test</big>.")
    public final void TextOff(String str) {
        StringBuilder sb;
        StringBuilder sb2;
        this.CfJsMCmg8U782C2ivbbep8ZFrAD6R9Wq7P09zMpUKCFkpiEYodk6t8FdSxHzlHKV = str;
        if (this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.isChecked()) {
            Switch switchR = this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME;
            new StringBuilder();
            switchR.setText(TextViewUtil.fromHtml(sb2.append(this.UT8jc0jwpnlGoVnBZm9Vqfc7zQxpOFTo7zW0ZxKDjXZZsrQ7LsG7hsoko7RBNNg5).append("  ").toString()));
            return;
        }
        Switch switchR2 = this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME;
        new StringBuilder();
        switchR2.setText(TextViewUtil.fromHtml(sb.append(this.CfJsMCmg8U782C2ivbbep8ZFrAD6R9Wq7P09zMpUKCFkpiEYodk6t8FdSxHzlHKV).append("  ").toString()));
    }

    @SimpleProperty(description = "Return the switch off text.")
    public final String TextOff() {
        return this.CfJsMCmg8U782C2ivbbep8ZFrAD6R9Wq7P09zMpUKCFkpiEYodk6t8FdSxHzlHKV;
    }

    @SimpleFunction(description = "Set the drawable used for the switch 'thumb' - the piece that the user can physically touch and drag along the track. If 'color Filter Enabled' is set to true, the image will get a light tint filter with the same color that you used as thumb color.")
    public final void ThumbImage(String str) {
        String str2 = str;
        if (!str2.isEmpty()) {
            try {
                this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.setThumbDrawable(MediaUtil.getBitmapDrawable(this.container.$form(), str2));
                this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.invalidate();
            } catch (Exception e) {
                int e2 = Log.e("Switch", "Unable to load ".concat(String.valueOf(str2)));
            }
        }
    }

    @SimpleFunction(description = "Set the drawable used for the switch 'thumb' - the piece that the user can physically touch and drag along the track. You can find the icon name (or code) here at https://material.io/icons . Use as size as example '300'.")
    public final void ThumbImageFromMaterialFont(String str, float f) {
        Drawable drawable;
        String str2 = str;
        float f2 = f;
        if (!str2.isEmpty()) {
            if (f2 == 0.0f) {
                f2 = 80.0f;
            }
            int i = (int) f2;
            try {
                new BitmapDrawable(KodularHelper.textToBitmap(this.context, "material", str2, this.yHAbLPerXNK4pCwn5nqbt3OeUjDvQdxh29RmVa0moB4dUtgatbeaGoP5jClPUWFb, f2));
                Drawable drawable2 = drawable;
                Drawable drawable3 = drawable2;
                int i2 = i;
                drawable3.setBounds(0, 0, i2, i2);
                this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.setThumbDrawable(drawable2);
                this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.invalidate();
            } catch (Exception e) {
                int e2 = Log.e("Switch", String.valueOf(e));
            }
        }
    }
}
