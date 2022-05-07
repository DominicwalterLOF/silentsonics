package com.google.appinventor.components.runtime;

import android.content.Intent;
import com.google.appinventor.components.annotations.DesignerComponent;
import com.google.appinventor.components.annotations.DesignerProperty;
import com.google.appinventor.components.annotations.PropertyCategory;
import com.google.appinventor.components.annotations.SimpleObject;
import com.google.appinventor.components.annotations.SimpleProperty;
import com.google.appinventor.components.annotations.UsesActivities;
import com.google.appinventor.components.annotations.androidmanifest.ActivityElement;
import com.google.appinventor.components.common.ComponentCategory;
import com.google.appinventor.components.runtime.util.ElementsUtil;
import com.google.appinventor.components.runtime.util.YailList;

@SimpleObject
@UsesActivities(activities = {@ActivityElement(configChanges = "orientation|keyboardHidden", name = "com.google.appinventor.components.runtime.ListPickerActivity", screenOrientation = "behind")})
@DesignerComponent(category = ComponentCategory.USERINTERFACE, description = "<p>A button that, when clicked on, displays a list of texts for the user to choose among. The texts can be specified through the Designer or Blocks Editor by setting the <code>ElementsFromString</code> property to their string-separated concatenation (for example, <em>choice 1, choice 2, choice 3</em>) or by setting the <code>Elements</code> property to a List in the Blocks editor.</p><p>Setting property ShowFilterBar to true, will make the list searchable.  Other properties affect the appearance of the button (<code>TextAlignment</code>, <code>BackgroundColor</code>, etc.) and whether it can be clicked on (<code>Enabled</code>).</p>", version = 17)
public class ListPicker extends Picker implements ActivityResultListener, Deleteable, OnResumeListener {
    static final String AjvYp2jprm0xITJdrrGGtoOyEc1YvelLDxRNqR8p3eG4UJR1UusSlSmznC0GO8Nd;
    public static final int DEFAULT_ITEM_BACKGROUND_COLOR = -16777216;
    public static final int DEFAULT_ITEM_TEXT_COLOR = -1;
    public static final int DEFAULT_STATUSBAR_COLOR = -14575886;
    public static final int DEFAULT_TITLEBAR_COLOR = -16537101;
    static final String JTEvmldvMjbbtPPlVS4hmZghOoRNnXC0kZOUUAZdwkVNl1VM5pL0vCTYv5HQZ7AX;
    static final String LVnP8NaPYXRgwZHgDK7PHMVEgcKwsNvZv2AHicCDg6yGIfguFikZkwwgr0dhWzJE;
    static final String MYUGxENNZgpsWEBTVSKDauXfXur6zyPKrPdlATl7m89YCcguzmIKP8wXNDkxMYaw;
    static final String O8YFlD3Safgd5vkxHRoLznZm2if21MG0IxIn5jepRi6FBTeulibRFlvEXsnDANgS;
    static final String OFXnSk7pjyu5TDlQcCs0Ee2Ss8ceD26gQ4XJfzIMtdlcKhGXQ2j7Mh9NsuvjNyC;
    static final String RC7PBJGdnqEffr8752ypFkbK8qZYkmQ3ci6maWfntRZXmeHa8bLhdKUgkXcpRo6T;
    static final String cOmDbOC978RubVhXjun4VkHg9OxeO5ZzRCTQEv8rZa8E7YdcVv7aSE4TjAXwfuwN;
    static final String gKFqoeV0mIepwKqPzQqyF42NDV4lXNBYlbBqvrWypn3hvG8Ace2UniGxwzdDn1SZ;
    static final String jKPsNUTq382ltO4Ct4VOTi9lUb0GK32zS6afcWmZUk1wuONzG2KH4rBMniXwxrgH;
    static final String pFeTJgO2w7vELkZyStZDj0uZpMYRqdjcmMjC2zcPDquoynj4tIsgJjD3RDJtFf88;
    static final String q2q4oDuUajVwr2T7b6DILrrBhrCqmElgSd3ODKsAFi8uEX2COWatdRT7gov0FlS5;
    private static final String seAn8f9TucJq5ZQrZ6xvA6wzyVfqYrHR0kVGH9g6Rg5gdXevmQRBQv2iJqrzi5Rz = ListPickerActivity.class.getName();
    static final String z819s2db3SwWOaVhKbPTp947sGRXlCsEqH9IfB6VLe6W07abBod2oRho8IvcelHj;
    private boolean ATBpAON767TQmZZYK3lMfxQA5S6eF21JqXY9TAJY6l4cbZGeVMlZehfHdCrTaqio = false;
    private int Qws8UL0KACxj4AFwEq11K2awfkG72XuPUTZHhPLrlGlIXoxeK9stYQCrIWmabWcL;
    private String Ta6bjdQXoFeEb44hWQ7kTTTXw2rT1LHw6UX7lms7WU7H0AkpETH9D9EhELUfywQi;
    private boolean XBLVE91Zp5kvRRn2aG2d0scvywAN7zOQf8gZkaueK9XPU163NLSIe4vWoTpXMo6u = false;
    private String YP4juQGK8ZTsNMOy2BKg810SeLJ3amlj2BQC8tc7uqP2LdhyRsu8lUHvdJ0v9u = "";
    private int Zv9msgDgBftU4SA7C2ygCk7MYKz0i3cazgjcHvHHF7brwk6qR9wS1wUER4Y8ppMY;
    private int eaS298peKlTpqlGRGLMTdk3sY259qoFGMqAzTE98DZy2JVNgCwB414XzHrUPTC;
    private int fSI6lxX8qEfUYa0M3qSNEhqEY7tqyd89UewYfJ8WSYLJpTsAFdRvTVg7ORBsMzG8;
    private boolean o4oEL8NAO5pXZcOSBAknA2NvsNjJJvehWW0lJ74yBWMu5XdCwoMznIBTr1ZGCAX = true;
    private int titleBarColor;
    private YailList vwEpIRqEf6xdtwTR9dehwBO7JUhyLV6iEzEK2WqfPN10eUMQDPn3AUmqAFfsnr6R;
    private boolean xy1Y0dkIX1oFLPndkUFF3zQF6ijcSVPdmgekjoDrBgvDBhvpj0INgajUPNaUhxY6 = true;

    static {
        StringBuilder sb;
        StringBuilder sb2;
        StringBuilder sb3;
        StringBuilder sb4;
        StringBuilder sb5;
        StringBuilder sb6;
        StringBuilder sb7;
        StringBuilder sb8;
        StringBuilder sb9;
        StringBuilder sb10;
        StringBuilder sb11;
        StringBuilder sb12;
        StringBuilder sb13;
        new StringBuilder();
        q2q4oDuUajVwr2T7b6DILrrBhrCqmElgSd3ODKsAFi8uEX2COWatdRT7gov0FlS5 = sb.append(seAn8f9TucJq5ZQrZ6xvA6wzyVfqYrHR0kVGH9g6Rg5gdXevmQRBQv2iJqrzi5Rz).append(".list").toString();
        new StringBuilder();
        LVnP8NaPYXRgwZHgDK7PHMVEgcKwsNvZv2AHicCDg6yGIfguFikZkwwgr0dhWzJE = sb2.append(seAn8f9TucJq5ZQrZ6xvA6wzyVfqYrHR0kVGH9g6Rg5gdXevmQRBQv2iJqrzi5Rz).append(".selection").toString();
        new StringBuilder();
        cOmDbOC978RubVhXjun4VkHg9OxeO5ZzRCTQEv8rZa8E7YdcVv7aSE4TjAXwfuwN = sb3.append(seAn8f9TucJq5ZQrZ6xvA6wzyVfqYrHR0kVGH9g6Rg5gdXevmQRBQv2iJqrzi5Rz).append(".index").toString();
        new StringBuilder();
        O8YFlD3Safgd5vkxHRoLznZm2if21MG0IxIn5jepRi6FBTeulibRFlvEXsnDANgS = sb4.append(seAn8f9TucJq5ZQrZ6xvA6wzyVfqYrHR0kVGH9g6Rg5gdXevmQRBQv2iJqrzi5Rz).append(".anim").toString();
        new StringBuilder();
        OFXnSk7pjyu5TDlQcCs0Ee2Ss8ceD26gQ4XJfzIMtdlcKhGXQ2j7Mh9NsuvjNyC = sb5.append(seAn8f9TucJq5ZQrZ6xvA6wzyVfqYrHR0kVGH9g6Rg5gdXevmQRBQv2iJqrzi5Rz).append(".search").toString();
        new StringBuilder();
        gKFqoeV0mIepwKqPzQqyF42NDV4lXNBYlbBqvrWypn3hvG8Ace2UniGxwzdDn1SZ = sb6.append(seAn8f9TucJq5ZQrZ6xvA6wzyVfqYrHR0kVGH9g6Rg5gdXevmQRBQv2iJqrzi5Rz).append(".title").toString();
        new StringBuilder();
        MYUGxENNZgpsWEBTVSKDauXfXur6zyPKrPdlATl7m89YCcguzmIKP8wXNDkxMYaw = sb7.append(seAn8f9TucJq5ZQrZ6xvA6wzyVfqYrHR0kVGH9g6Rg5gdXevmQRBQv2iJqrzi5Rz).append(".orientation").toString();
        new StringBuilder();
        z819s2db3SwWOaVhKbPTp947sGRXlCsEqH9IfB6VLe6W07abBod2oRho8IvcelHj = sb8.append(seAn8f9TucJq5ZQrZ6xvA6wzyVfqYrHR0kVGH9g6Rg5gdXevmQRBQv2iJqrzi5Rz).append(".itemtextcolor").toString();
        new StringBuilder();
        RC7PBJGdnqEffr8752ypFkbK8qZYkmQ3ci6maWfntRZXmeHa8bLhdKUgkXcpRo6T = sb9.append(seAn8f9TucJq5ZQrZ6xvA6wzyVfqYrHR0kVGH9g6Rg5gdXevmQRBQv2iJqrzi5Rz).append(".backgroundcolor").toString();
        new StringBuilder();
        JTEvmldvMjbbtPPlVS4hmZghOoRNnXC0kZOUUAZdwkVNl1VM5pL0vCTYv5HQZ7AX = sb10.append(seAn8f9TucJq5ZQrZ6xvA6wzyVfqYrHR0kVGH9g6Rg5gdXevmQRBQv2iJqrzi5Rz).append(".titlebarcolor").toString();
        new StringBuilder();
        pFeTJgO2w7vELkZyStZDj0uZpMYRqdjcmMjC2zcPDquoynj4tIsgJjD3RDJtFf88 = sb11.append(seAn8f9TucJq5ZQrZ6xvA6wzyVfqYrHR0kVGH9g6Rg5gdXevmQRBQv2iJqrzi5Rz).append(".statusbarcolor").toString();
        new StringBuilder();
        jKPsNUTq382ltO4Ct4VOTi9lUb0GK32zS6afcWmZUk1wuONzG2KH4rBMniXwxrgH = sb12.append(seAn8f9TucJq5ZQrZ6xvA6wzyVfqYrHR0kVGH9g6Rg5gdXevmQRBQv2iJqrzi5Rz).append(".titlebarvisible").toString();
        new StringBuilder();
        AjvYp2jprm0xITJdrrGGtoOyEc1YvelLDxRNqR8p3eG4UJR1UusSlSmznC0GO8Nd = sb13.append(seAn8f9TucJq5ZQrZ6xvA6wzyVfqYrHR0kVGH9g6Rg5gdXevmQRBQv2iJqrzi5Rz).append(".statusbarvisible").toString();
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public ListPicker(com.google.appinventor.components.runtime.ComponentContainer r7) {
        /*
            r6 = this;
            r0 = r6
            r1 = r7
            r2 = r0
            r3 = r1
            r2.<init>(r3)
            r2 = r0
            r3 = 0
            r2.XBLVE91Zp5kvRRn2aG2d0scvywAN7zOQf8gZkaueK9XPU163NLSIe4vWoTpXMo6u = r3
            r2 = r0
            java.lang.String r3 = ""
            r2.YP4juQGK8ZTsNMOy2BKg810SeLJ3amlj2BQC8tc7uqP2LdhyRsu8lUHvdJ0v9u = r3
            r2 = r0
            r3 = 0
            r2.ATBpAON767TQmZZYK3lMfxQA5S6eF21JqXY9TAJY6l4cbZGeVMlZehfHdCrTaqio = r3
            r2 = r0
            r3 = 1
            r2.xy1Y0dkIX1oFLPndkUFF3zQF6ijcSVPdmgekjoDrBgvDBhvpj0INgajUPNaUhxY6 = r3
            r2 = r0
            r3 = 1
            r2.o4oEL8NAO5pXZcOSBAknA2NvsNjJJvehWW0lJ74yBWMu5XdCwoMznIBTr1ZGCAX = r3
            r2 = r0
            com.google.appinventor.components.runtime.util.YailList r3 = new com.google.appinventor.components.runtime.util.YailList
            r5 = r3
            r3 = r5
            r4 = r5
            r4.<init>()
            r2.vwEpIRqEf6xdtwTR9dehwBO7JUhyLV6iEzEK2WqfPN10eUMQDPn3AUmqAFfsnr6R = r3
            r2 = r0
            r3 = 0
            r2.SelectionIndex(r3)
            r2 = r0
            r3 = -1
            r2.Zv9msgDgBftU4SA7C2ygCk7MYKz0i3cazgjcHvHHF7brwk6qR9wS1wUER4Y8ppMY = r3
            r2 = r0
            r3 = -16777216(0xffffffffff000000, float:-1.7014118E38)
            r2.eaS298peKlTpqlGRGLMTdk3sY259qoFGMqAzTE98DZy2JVNgCwB414XzHrUPTC = r3
            r2 = r0
            r3 = -16537101(0xffffffffff03a9f3, float:-1.750113E38)
            r2.titleBarColor = r3
            r2 = r0
            r3 = -14575886(0xffffffffff2196f2, float:-2.1478946E38)
            r2.Qws8UL0KACxj4AFwEq11K2awfkG72XuPUTZHhPLrlGlIXoxeK9stYQCrIWmabWcL = r3
            r2 = r1
            com.google.appinventor.components.runtime.Form r2 = r2.$form()
            r3 = r0
            r2.registerForOnResume(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.appinventor.components.runtime.ListPicker.<init>(com.google.appinventor.components.runtime.ComponentContainer):void");
    }

    public void onResume() {
        if (this.ATBpAON767TQmZZYK3lMfxQA5S6eF21JqXY9TAJY6l4cbZGeVMlZehfHdCrTaqio) {
            this.container.$form().getWindow().setSoftInputMode(3);
            this.ATBpAON767TQmZZYK3lMfxQA5S6eF21JqXY9TAJY6l4cbZGeVMlZehfHdCrTaqio = false;
        }
    }

    @SimpleProperty(category = PropertyCategory.BEHAVIOR, description = "The selected item.  When directly changed by the programmer, the SelectionIndex property is also changed to the first item in the ListPicker with the given value.  If the value does not appear, SelectionIndex will be set to 0.")
    public String Selection() {
        return this.Ta6bjdQXoFeEb44hWQ7kTTTXw2rT1LHw6UX7lms7WU7H0AkpETH9D9EhELUfywQi;
    }

    @DesignerProperty(defaultValue = "", editorType = "string")
    @SimpleProperty
    public void Selection(String str) {
        String str2 = str;
        this.Ta6bjdQXoFeEb44hWQ7kTTTXw2rT1LHw6UX7lms7WU7H0AkpETH9D9EhELUfywQi = str2;
        this.fSI6lxX8qEfUYa0M3qSNEhqEY7tqyd89UewYfJ8WSYLJpTsAFdRvTVg7ORBsMzG8 = ElementsUtil.setSelectedIndexFromValue(str2, this.vwEpIRqEf6xdtwTR9dehwBO7JUhyLV6iEzEK2WqfPN10eUMQDPn3AUmqAFfsnr6R);
    }

    @DesignerProperty(defaultValue = "False", editorType = "boolean")
    @SimpleProperty
    public void ShowFilterBar(boolean z) {
        boolean z2 = z;
        this.XBLVE91Zp5kvRRn2aG2d0scvywAN7zOQf8gZkaueK9XPU163NLSIe4vWoTpXMo6u = z2;
    }

    @SimpleProperty(category = PropertyCategory.BEHAVIOR, description = "Returns current state of ShowFilterBar indicating if Search Filter Bar will be displayed on ListPicker or not")
    public boolean ShowFilterBar() {
        return this.XBLVE91Zp5kvRRn2aG2d0scvywAN7zOQf8gZkaueK9XPU163NLSIe4vWoTpXMo6u;
    }

    @DesignerProperty(defaultValue = "&HFFFFFFFF", editorType = "color")
    @SimpleProperty
    public void ItemTextColor(int i) {
        int i2 = i;
        this.Zv9msgDgBftU4SA7C2ygCk7MYKz0i3cazgjcHvHHF7brwk6qR9wS1wUER4Y8ppMY = i2;
    }

    @SimpleProperty(category = PropertyCategory.APPEARANCE, description = "The text color of the ListPicker items.")
    public int ItemTextColor() {
        return this.Zv9msgDgBftU4SA7C2ygCk7MYKz0i3cazgjcHvHHF7brwk6qR9wS1wUER4Y8ppMY;
    }

    @DesignerProperty(defaultValue = "&HFF000000", editorType = "color")
    @SimpleProperty
    public void ItemBackgroundColor(int i) {
        int i2 = i;
        this.eaS298peKlTpqlGRGLMTdk3sY259qoFGMqAzTE98DZy2JVNgCwB414XzHrUPTC = i2;
    }

    @SimpleProperty(category = PropertyCategory.APPEARANCE, description = "The background color of the ListPicker items.")
    public int ItemBackgroundColor() {
        return this.eaS298peKlTpqlGRGLMTdk3sY259qoFGMqAzTE98DZy2JVNgCwB414XzHrUPTC;
    }

    @DesignerProperty(defaultValue = "&HFF03A9F3", editorType = "color", propertyType = "advanced")
    @SimpleProperty
    public void TitleBarColor(int i) {
        int i2 = i;
        this.titleBarColor = i2;
    }

    @SimpleProperty(category = PropertyCategory.APPEARANCE, description = "The TitleBarColor of the ListPicker.")
    public int TitleBarColor() {
        return this.titleBarColor;
    }

    @DesignerProperty(defaultValue = "&HFF2196F2", editorType = "color", propertyType = "advanced")
    @SimpleProperty
    public void StatusBarColor(int i) {
        int i2 = i;
        this.Qws8UL0KACxj4AFwEq11K2awfkG72XuPUTZHhPLrlGlIXoxeK9stYQCrIWmabWcL = i2;
    }

    @SimpleProperty(category = PropertyCategory.APPEARANCE, description = "The StatusBarColor of the ListPicker.")
    public int StatusBarColor() {
        return this.Qws8UL0KACxj4AFwEq11K2awfkG72XuPUTZHhPLrlGlIXoxeK9stYQCrIWmabWcL;
    }

    @SimpleProperty(category = PropertyCategory.APPEARANCE, description = "Whether to show title bar")
    public boolean TitleVisible() {
        return this.xy1Y0dkIX1oFLPndkUFF3zQF6ijcSVPdmgekjoDrBgvDBhvpj0INgajUPNaUhxY6;
    }

    @DesignerProperty(defaultValue = "True", editorType = "boolean", propertyType = "advanced")
    @SimpleProperty(category = PropertyCategory.APPEARANCE)
    public void TitleVisible(boolean z) {
        boolean z2 = z;
        this.xy1Y0dkIX1oFLPndkUFF3zQF6ijcSVPdmgekjoDrBgvDBhvpj0INgajUPNaUhxY6 = z2;
    }

    @SimpleProperty(category = PropertyCategory.APPEARANCE, description = "Whether to show status bar")
    public boolean StatusBarVisible() {
        return this.o4oEL8NAO5pXZcOSBAknA2NvsNjJJvehWW0lJ74yBWMu5XdCwoMznIBTr1ZGCAX;
    }

    @DesignerProperty(defaultValue = "True", editorType = "boolean", propertyType = "advanced")
    @SimpleProperty(category = PropertyCategory.APPEARANCE)
    public void StatusBarVisible(boolean z) {
        boolean z2 = z;
        this.o4oEL8NAO5pXZcOSBAknA2NvsNjJJvehWW0lJ74yBWMu5XdCwoMznIBTr1ZGCAX = z2;
    }

    @SimpleProperty(category = PropertyCategory.BEHAVIOR, description = "The index of the currently selected item, starting at 1.  If no item is selected, the value will be 0.  If an attempt is made to set this to a number less than 1 or greater than the number of items in the ListPicker, SelectionIndex will be set to 0, and Selection will be set to the empty text.")
    public int SelectionIndex() {
        return this.fSI6lxX8qEfUYa0M3qSNEhqEY7tqyd89UewYfJ8WSYLJpTsAFdRvTVg7ORBsMzG8;
    }

    @SimpleProperty
    public void SelectionIndex(int i) {
        int i2 = i;
        this.fSI6lxX8qEfUYa0M3qSNEhqEY7tqyd89UewYfJ8WSYLJpTsAFdRvTVg7ORBsMzG8 = ElementsUtil.selectionIndex(i2, this.vwEpIRqEf6xdtwTR9dehwBO7JUhyLV6iEzEK2WqfPN10eUMQDPn3AUmqAFfsnr6R);
        this.Ta6bjdQXoFeEb44hWQ7kTTTXw2rT1LHw6UX7lms7WU7H0AkpETH9D9EhELUfywQi = ElementsUtil.setSelectionFromIndex(i2, this.vwEpIRqEf6xdtwTR9dehwBO7JUhyLV6iEzEK2WqfPN10eUMQDPn3AUmqAFfsnr6R);
    }

    @SimpleProperty(category = PropertyCategory.BEHAVIOR)
    public YailList Elements() {
        return this.vwEpIRqEf6xdtwTR9dehwBO7JUhyLV6iEzEK2WqfPN10eUMQDPn3AUmqAFfsnr6R;
    }

    @SimpleProperty
    public void Elements(YailList yailList) {
        YailList elements = ElementsUtil.elements(yailList, "ListPicker");
        this.vwEpIRqEf6xdtwTR9dehwBO7JUhyLV6iEzEK2WqfPN10eUMQDPn3AUmqAFfsnr6R = elements;
    }

    @DesignerProperty(defaultValue = "", editorType = "string")
    @SimpleProperty(category = PropertyCategory.BEHAVIOR)
    public void ElementsFromString(String str) {
        YailList elementsFromString = ElementsUtil.elementsFromString(str);
        this.vwEpIRqEf6xdtwTR9dehwBO7JUhyLV6iEzEK2WqfPN10eUMQDPn3AUmqAFfsnr6R = elementsFromString;
    }

    @SimpleProperty(category = PropertyCategory.APPEARANCE, description = "Optional title displayed at the top of the list of choices.")
    public String Title() {
        return this.YP4juQGK8ZTsNMOy2BKg810SeLJ3amlj2BQC8tc7uqP2LdhyRsu8lUHvdJ0v9u;
    }

    @DesignerProperty(defaultValue = "", editorType = "string")
    @SimpleProperty
    public void Title(String str) {
        String str2 = str;
        this.YP4juQGK8ZTsNMOy2BKg810SeLJ3amlj2BQC8tc7uqP2LdhyRsu8lUHvdJ0v9u = str2;
    }

    public Intent getIntent() {
        Intent intent;
        new Intent();
        Intent intent2 = intent;
        Intent intent3 = intent2;
        Intent className = intent2.setClassName(this.container.$context(), seAn8f9TucJq5ZQrZ6xvA6wzyVfqYrHR0kVGH9g6Rg5gdXevmQRBQv2iJqrzi5Rz);
        Intent putExtra = intent3.putExtra(q2q4oDuUajVwr2T7b6DILrrBhrCqmElgSd3ODKsAFi8uEX2COWatdRT7gov0FlS5, this.vwEpIRqEf6xdtwTR9dehwBO7JUhyLV6iEzEK2WqfPN10eUMQDPn3AUmqAFfsnr6R.toStringArray());
        Intent putExtra2 = intent3.putExtra(OFXnSk7pjyu5TDlQcCs0Ee2Ss8ceD26gQ4XJfzIMtdlcKhGXQ2j7Mh9NsuvjNyC, String.valueOf(this.XBLVE91Zp5kvRRn2aG2d0scvywAN7zOQf8gZkaueK9XPU163NLSIe4vWoTpXMo6u));
        if (!this.YP4juQGK8ZTsNMOy2BKg810SeLJ3amlj2BQC8tc7uqP2LdhyRsu8lUHvdJ0v9u.equals("")) {
            Intent putExtra3 = intent3.putExtra(gKFqoeV0mIepwKqPzQqyF42NDV4lXNBYlbBqvrWypn3hvG8Ace2UniGxwzdDn1SZ, this.YP4juQGK8ZTsNMOy2BKg810SeLJ3amlj2BQC8tc7uqP2LdhyRsu8lUHvdJ0v9u);
        }
        Intent putExtra4 = intent3.putExtra(O8YFlD3Safgd5vkxHRoLznZm2if21MG0IxIn5jepRi6FBTeulibRFlvEXsnDANgS, this.container.$form().OpenScreenAnimation());
        Intent putExtra5 = intent3.putExtra(MYUGxENNZgpsWEBTVSKDauXfXur6zyPKrPdlATl7m89YCcguzmIKP8wXNDkxMYaw, this.container.$form().ScreenOrientation());
        Intent putExtra6 = intent3.putExtra(z819s2db3SwWOaVhKbPTp947sGRXlCsEqH9IfB6VLe6W07abBod2oRho8IvcelHj, this.Zv9msgDgBftU4SA7C2ygCk7MYKz0i3cazgjcHvHHF7brwk6qR9wS1wUER4Y8ppMY);
        Intent putExtra7 = intent3.putExtra(RC7PBJGdnqEffr8752ypFkbK8qZYkmQ3ci6maWfntRZXmeHa8bLhdKUgkXcpRo6T, this.eaS298peKlTpqlGRGLMTdk3sY259qoFGMqAzTE98DZy2JVNgCwB414XzHrUPTC);
        Intent putExtra8 = intent3.putExtra(JTEvmldvMjbbtPPlVS4hmZghOoRNnXC0kZOUUAZdwkVNl1VM5pL0vCTYv5HQZ7AX, this.titleBarColor);
        Intent putExtra9 = intent3.putExtra(pFeTJgO2w7vELkZyStZDj0uZpMYRqdjcmMjC2zcPDquoynj4tIsgJjD3RDJtFf88, this.Qws8UL0KACxj4AFwEq11K2awfkG72XuPUTZHhPLrlGlIXoxeK9stYQCrIWmabWcL);
        Intent putExtra10 = intent3.putExtra(jKPsNUTq382ltO4Ct4VOTi9lUb0GK32zS6afcWmZUk1wuONzG2KH4rBMniXwxrgH, this.xy1Y0dkIX1oFLPndkUFF3zQF6ijcSVPdmgekjoDrBgvDBhvpj0INgajUPNaUhxY6);
        Intent putExtra11 = intent3.putExtra(AjvYp2jprm0xITJdrrGGtoOyEc1YvelLDxRNqR8p3eG4UJR1UusSlSmznC0GO8Nd, this.o4oEL8NAO5pXZcOSBAknA2NvsNjJJvehWW0lJ74yBWMu5XdCwoMznIBTr1ZGCAX);
        return intent3;
    }

    public void resultReturned(int i, int i2, Intent intent) {
        int i3 = i2;
        Intent intent2 = intent;
        if (i == this.requestCode && i3 == -1) {
            if (intent2.hasExtra(LVnP8NaPYXRgwZHgDK7PHMVEgcKwsNvZv2AHicCDg6yGIfguFikZkwwgr0dhWzJE)) {
                this.Ta6bjdQXoFeEb44hWQ7kTTTXw2rT1LHw6UX7lms7WU7H0AkpETH9D9EhELUfywQi = intent2.getStringExtra(LVnP8NaPYXRgwZHgDK7PHMVEgcKwsNvZv2AHicCDg6yGIfguFikZkwwgr0dhWzJE);
            } else {
                this.Ta6bjdQXoFeEb44hWQ7kTTTXw2rT1LHw6UX7lms7WU7H0AkpETH9D9EhELUfywQi = "";
            }
            this.fSI6lxX8qEfUYa0M3qSNEhqEY7tqyd89UewYfJ8WSYLJpTsAFdRvTVg7ORBsMzG8 = intent2.getIntExtra(cOmDbOC978RubVhXjun4VkHg9OxeO5ZzRCTQEv8rZa8E7YdcVv7aSE4TjAXwfuwN, 0);
            AfterPicking(this.Ta6bjdQXoFeEb44hWQ7kTTTXw2rT1LHw6UX7lms7WU7H0AkpETH9D9EhELUfywQi);
            this.ATBpAON767TQmZZYK3lMfxQA5S6eF21JqXY9TAJY6l4cbZGeVMlZehfHdCrTaqio = true;
        }
    }

    public void onDelete() {
        this.container.$form().unregisterForActivityResult(this);
    }
}
