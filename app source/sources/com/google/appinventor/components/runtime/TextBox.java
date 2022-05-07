package com.google.appinventor.components.runtime;

import android.view.inputmethod.InputMethodManager;
import com.google.appinventor.components.annotations.DesignerComponent;
import com.google.appinventor.components.annotations.DesignerProperty;
import com.google.appinventor.components.annotations.PropertyCategory;
import com.google.appinventor.components.annotations.SimpleFunction;
import com.google.appinventor.components.annotations.SimpleObject;
import com.google.appinventor.components.annotations.SimpleProperty;
import com.google.appinventor.components.common.ComponentCategory;

@SimpleObject
@DesignerComponent(category = ComponentCategory.USERINTERFACE, description = "<p>A box for the user to enter text.  The initial or user-entered text value is in the <code>Text</code> property.  If blank, the <code>Hint</code> property, which appears as faint text in the box, can provide the user with guidance as to what to type.</p><p>The <code>MultiLine</code> property determines if the text can havemore than one line.  For a single line text box, the keyboard will closeautomatically when the user presses the Done key.  To close the keyboard for multiline text boxes, the app should use  the HideKeyboard method or  rely on the user to press the Back key.</p><p>The <code> NumbersOnly</code> property restricts the keyboard to acceptnumeric input only.</p><p>Other properties affect the appearance of the text box (<code>TextAlignment</code>, <code>BackgroundColor</code>, etc.) and whether it can be used (<code>Enabled</code>).</p><p>Text boxes are usually used with the <code>Button</code> component, with the user clicking on the button when text entry is complete.</p><p>If the text entered by the user should not be displayed, use <code>PasswordTextBox</code> instead.</p>", helpUrl = "https://docs.kodular.io/components/user-interface/textbox/", version = 13)
public final class TextBox extends TextBoxBase {
    private boolean IQizCoownq3QMuqjiN3SEtpvqAzYOMGAuQhX0ytYpmBBjgggyq4HRoSxolTbNj90;
    private int ZBOPOXf20XZKrN6ycbQhEDPC2OsW2QCGfMHApJMYjAVGCpHVQNyA3eb1TXx8tY2I = 1;
    private String f3jXQdr7SaO4jKCWPTlGDFsZc4anfRmkf59KPIcTiLfRAexdccxYBXXB8h0vpeF7;
    private boolean tFNQ38WX0EWx1sBmwkfGOavwj0ohdRyv5RfL5KQ0qa5Pnr6qc7YsZTQu1aP3NtmA;
    private boolean vQeIU3Nt6lISgDcgPcgMyfTsPOzVWtilFVqv3Ws2SOY6jXuMnX7gL1LFHvLOLuoZ = false;
    private int wfWoJD9s05zGciiq11jj7TXqW1AmJIE9BV68DWBBkLZSv9NayRoTG3XJb9WJMlyD = 0;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public TextBox(com.google.appinventor.components.runtime.ComponentContainer r9) {
        /*
            r8 = this;
            r0 = r8
            r1 = r9
            r2 = r0
            r3 = r1
            androidx.appcompat.widget.AppCompatEditText r4 = new androidx.appcompat.widget.AppCompatEditText
            r7 = r4
            r4 = r7
            r5 = r7
            r6 = r1
            android.app.Activity r6 = r6.$context()
            r5.<init>(r6)
            r2.<init>(r3, r4)
            r2 = r0
            r3 = 0
            r2.vQeIU3Nt6lISgDcgPcgMyfTsPOzVWtilFVqv3Ws2SOY6jXuMnX7gL1LFHvLOLuoZ = r3
            r2 = r0
            r3 = 1
            r2.ZBOPOXf20XZKrN6ycbQhEDPC2OsW2QCGfMHApJMYjAVGCpHVQNyA3eb1TXx8tY2I = r3
            r2 = r0
            r3 = 0
            r2.wfWoJD9s05zGciiq11jj7TXqW1AmJIE9BV68DWBBkLZSv9NayRoTG3XJb9WJMlyD = r3
            r2 = r0
            r3 = 0
            r2.HighlightColor(r3)
            r2 = r0
            r3 = 0
            r2.MultiLine(r3)
            r2 = r0
            r3 = 0
            r2.ReadOnly(r3)
            r2 = r0
            r3 = 1
            r2.InputType(r3)
            r2 = r0
            android.widget.EditText r2 = r2.view
            r3 = 6
            r2.setImeOptions(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.appinventor.components.runtime.TextBox.<init>(com.google.appinventor.components.runtime.ComponentContainer):void");
    }

    @Deprecated
    @SimpleProperty(category = PropertyCategory.BEHAVIOR, description = "If true, then this text box accepts only numbers as keyboard input.  Numbers can include a decimal point and an optional leading minus sign.  This applies to keyboard input only.  Even if NumbersOnly is true, you can use [set Text to] to enter any text at all.")
    public final boolean NumbersOnly() {
        return this.IQizCoownq3QMuqjiN3SEtpvqAzYOMGAuQhX0ytYpmBBjgggyq4HRoSxolTbNj90;
    }

    @DesignerProperty(defaultValue = "False", editorType = "boolean")
    @Deprecated
    @SimpleProperty(description = "If true, then this text box accepts only numbers as keyboard input.  Numbers can include a decimal point and an optional leading minus sign.  This applies to keyboard input only.  Even if NumbersOnly is true, you can use [set Text to] to enter any text at all.")
    public final void NumbersOnly(boolean z) {
        boolean z2 = z;
        if (z2) {
            this.view.setInputType(12290);
        } else {
            this.view.setInputType(131073);
        }
        this.IQizCoownq3QMuqjiN3SEtpvqAzYOMGAuQhX0ytYpmBBjgggyq4HRoSxolTbNj90 = z2;
    }

    @SimpleProperty(category = PropertyCategory.BEHAVIOR, description = "The input type you want for this TextBox.")
    public final int InputType() {
        return this.ZBOPOXf20XZKrN6ycbQhEDPC2OsW2QCGfMHApJMYjAVGCpHVQNyA3eb1TXx8tY2I;
    }

    @DesignerProperty(defaultValue = "1", editorType = "input_type")
    @SimpleProperty
    public final void InputType(int i) {
        int i2 = i;
        switch (i2) {
            case 1:
                this.view.setInputType(1);
                break;
            case 2:
                this.view.setInputType(129);
                break;
            case 3:
                this.view.setInputType(97);
                break;
            case 4:
                this.view.setInputType(33);
                break;
            case 5:
                this.view.setInputType(12290);
                break;
            case 6:
                this.view.setInputType(12306);
                break;
            case 7:
                this.view.setInputType(4);
                break;
            case 8:
                this.view.setInputType(8194);
                break;
            case 9:
                this.view.setInputType(3);
                break;
            case 10:
                this.view.setInputType(113);
                break;
            default:
                this.view.setInputType(1);
                break;
        }
        this.ZBOPOXf20XZKrN6ycbQhEDPC2OsW2QCGfMHApJMYjAVGCpHVQNyA3eb1TXx8tY2I = i2;
    }

    @SimpleFunction(description = "Hide the keyboard.  Only multiline text boxes need this. Single line text boxes close the keyboard when the users presses the Done key.")
    public final void HideKeyboard() {
        boolean hideSoftInputFromWindow = ((InputMethodManager) this.container.$context().getSystemService("input_method")).hideSoftInputFromWindow(this.view.getWindowToken(), 0);
    }

    @SimpleProperty(category = PropertyCategory.BEHAVIOR, description = "If true, then this text box accepts multiple lines of input, which are entered using the return key.  For single line text boxes there is a Done key instead of a return key, and pressing Done hides the keyboard.  The app should call the HideKeyboard method to hide the keyboard for a mutiline text box.")
    public final boolean MultiLine() {
        return this.vQeIU3Nt6lISgDcgPcgMyfTsPOzVWtilFVqv3Ws2SOY6jXuMnX7gL1LFHvLOLuoZ;
    }

    @DesignerProperty(defaultValue = "False", editorType = "boolean")
    @SimpleProperty
    public final void MultiLine(boolean z) {
        boolean z2 = z;
        this.vQeIU3Nt6lISgDcgPcgMyfTsPOzVWtilFVqv3Ws2SOY6jXuMnX7gL1LFHvLOLuoZ = z2;
        this.view.setSingleLine(!z2);
    }

    @DesignerProperty(defaultValue = "2147483647", editorType = "non_negative_integer", propertyType = "advanced")
    @SimpleProperty
    public final void MaxLines(int i) {
        this.view.setMaxLines(i);
    }

    @SimpleProperty(category = PropertyCategory.BEHAVIOR, description = "Whether the %type% is read-only. By default, this is true.")
    public final boolean ReadOnly() {
        return this.tFNQ38WX0EWx1sBmwkfGOavwj0ohdRyv5RfL5KQ0qa5Pnr6qc7YsZTQu1aP3NtmA;
    }

    @DesignerProperty(defaultValue = "False", editorType = "boolean")
    @SimpleProperty
    public final void ReadOnly(boolean z) {
        boolean z2 = z;
        this.tFNQ38WX0EWx1sBmwkfGOavwj0ohdRyv5RfL5KQ0qa5Pnr6qc7YsZTQu1aP3NtmA = z2;
        this.view.setEnabled(!z2);
    }

    @SimpleFunction(description = "Shows an error message next to the textbox.")
    public final void ShowError() {
        this.view.setError(this.f3jXQdr7SaO4jKCWPTlGDFsZc4anfRmkf59KPIcTiLfRAexdccxYBXXB8h0vpeF7);
    }

    @SimpleProperty(category = PropertyCategory.APPEARANCE, description = "Returns the error text.")
    public final String ErrorText() {
        return this.f3jXQdr7SaO4jKCWPTlGDFsZc4anfRmkf59KPIcTiLfRAexdccxYBXXB8h0vpeF7;
    }

    @DesignerProperty(defaultValue = "", editorType = "string")
    @SimpleProperty(description = "Sets the error text message.")
    public final void ErrorText(String str) {
        String str2 = str;
        this.f3jXQdr7SaO4jKCWPTlGDFsZc4anfRmkf59KPIcTiLfRAexdccxYBXXB8h0vpeF7 = str2;
    }

    @SimpleProperty(category = PropertyCategory.APPEARANCE, description = "Returns the color of the highlighted text.")
    public final int HighlightColor() {
        return this.wfWoJD9s05zGciiq11jj7TXqW1AmJIE9BV68DWBBkLZSv9NayRoTG3XJb9WJMlyD;
    }

    @DesignerProperty(defaultValue = "&H00000000", editorType = "color", propertyType = "advanced")
    @SimpleProperty
    public final void HighlightColor(int i) {
        int i2 = i;
        this.wfWoJD9s05zGciiq11jj7TXqW1AmJIE9BV68DWBBkLZSv9NayRoTG3XJb9WJMlyD = i2;
        this.view.setHighlightColor(i2);
    }
}
