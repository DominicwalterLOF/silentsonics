package com.google.appinventor.components.runtime;

import android.app.TimePickerDialog;
import android.os.Handler;
import com.google.appinventor.components.annotations.DesignerComponent;
import com.google.appinventor.components.annotations.PropertyCategory;
import com.google.appinventor.components.annotations.SimpleEvent;
import com.google.appinventor.components.annotations.SimpleFunction;
import com.google.appinventor.components.annotations.SimpleObject;
import com.google.appinventor.components.annotations.SimpleProperty;
import com.google.appinventor.components.common.ComponentCategory;
import com.google.appinventor.components.runtime.util.Dates;
import com.google.appinventor.components.runtime.util.ErrorMessages;
import java.util.Calendar;

@SimpleObject
@DesignerComponent(category = ComponentCategory.USERINTERFACE, description = "<p>A button that, when clicked on, launches  a popup dialog to allow the user to select a time.</p>", version = 9)
public class TimePicker extends ButtonBase {
    private boolean HThm2UFiN8mNIb2OEGwVoJpkwNLFwrt8FHi6kSBOC6T1EOtocK0hkK9xDo2LJOJZ = false;
    private Handler androidUIHandler;
    private int fAlnFrzRyM2sCUVmNXgAumx383He1buRJXamXMT9T0hNFh1WxfF7xQU1M3W9TIGM = 0;
    private Form form;
    private TimePickerDialog.OnTimeSetListener hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME;

    /* renamed from: hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME  reason: collision with other field name */
    private TimePickerDialog f250hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME;

    /* renamed from: hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME  reason: collision with other field name */
    private Calendar f251hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME;
    /* access modifiers changed from: private */
    public int jsy7Kz77rNyAY3JWsGLNrUoUOR8HajCK4Ef1UopjrJy4hdX7ElFJvGzBTGAF3HB = 0;

    static /* synthetic */ int B8WBXPBCF2jGfUDZZU2zV5EYdqbUBu0lAZ0THCEqYyuE8VACR9dY7rDnwBIqh64T(TimePicker timePicker, int i) {
        int i2 = i;
        int i3 = i2;
        timePicker.jsy7Kz77rNyAY3JWsGLNrUoUOR8HajCK4Ef1UopjrJy4hdX7ElFJvGzBTGAF3HB = i3;
        return i2;
    }

    static /* synthetic */ int hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME(TimePicker timePicker, int i) {
        int i2 = i;
        int i3 = i2;
        timePicker.fAlnFrzRyM2sCUVmNXgAumx383He1buRJXamXMT9T0hNFh1WxfF7xQU1M3W9TIGM = i3;
        return i2;
    }

    static /* synthetic */ Calendar hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME(TimePicker timePicker, Calendar calendar) {
        Calendar calendar2 = calendar;
        Calendar calendar3 = calendar2;
        timePicker.f251hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME = calendar3;
        return calendar2;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public TimePicker(com.google.appinventor.components.runtime.ComponentContainer r12) {
        /*
            r11 = this;
            r0 = r11
            r1 = r12
            r2 = r0
            r3 = r1
            r2.<init>(r3)
            r2 = r0
            r3 = 0
            r2.fAlnFrzRyM2sCUVmNXgAumx383He1buRJXamXMT9T0hNFh1WxfF7xQU1M3W9TIGM = r3
            r2 = r0
            r3 = 0
            r2.jsy7Kz77rNyAY3JWsGLNrUoUOR8HajCK4Ef1UopjrJy4hdX7ElFJvGzBTGAF3HB = r3
            r2 = r0
            r3 = 0
            r2.HThm2UFiN8mNIb2OEGwVoJpkwNLFwrt8FHi6kSBOC6T1EOtocK0hkK9xDo2LJOJZ = r3
            r2 = r0
            com.google.appinventor.components.runtime.TimePicker$1 r3 = new com.google.appinventor.components.runtime.TimePicker$1
            r10 = r3
            r3 = r10
            r4 = r10
            r5 = r0
            r4.<init>(r5)
            r2.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME = r3
            r2 = r0
            r3 = r1
            com.google.appinventor.components.runtime.Form r3 = r3.$form()
            r2.form = r3
            java.util.Calendar r2 = java.util.Calendar.getInstance()
            r1 = r2
            r2 = r0
            r3 = r1
            r4 = 11
            int r3 = r3.get(r4)
            r2.fAlnFrzRyM2sCUVmNXgAumx383He1buRJXamXMT9T0hNFh1WxfF7xQU1M3W9TIGM = r3
            r2 = r0
            r3 = r1
            r4 = 12
            int r3 = r3.get(r4)
            r2.jsy7Kz77rNyAY3JWsGLNrUoUOR8HajCK4Ef1UopjrJy4hdX7ElFJvGzBTGAF3HB = r3
            r2 = r0
            android.app.TimePickerDialog r3 = new android.app.TimePickerDialog
            r10 = r3
            r3 = r10
            r4 = r10
            r5 = r0
            com.google.appinventor.components.runtime.ComponentContainer r5 = r5.container
            android.app.Activity r5 = r5.$context()
            r6 = r0
            android.app.TimePickerDialog$OnTimeSetListener r6 = r6.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME
            r7 = r0
            int r7 = r7.fAlnFrzRyM2sCUVmNXgAumx383He1buRJXamXMT9T0hNFh1WxfF7xQU1M3W9TIGM
            r8 = r0
            int r8 = r8.jsy7Kz77rNyAY3JWsGLNrUoUOR8HajCK4Ef1UopjrJy4hdX7ElFJvGzBTGAF3HB
            r9 = r0
            com.google.appinventor.components.runtime.ComponentContainer r9 = r9.container
            android.app.Activity r9 = r9.$context()
            boolean r9 = android.text.format.DateFormat.is24HourFormat(r9)
            r4.<init>(r5, r6, r7, r8, r9)
            r2.f250hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME = r3
            r2 = r0
            r10 = r2
            r2 = r10
            r3 = r10
            int r3 = r3.fAlnFrzRyM2sCUVmNXgAumx383He1buRJXamXMT9T0hNFh1WxfF7xQU1M3W9TIGM
            r4 = r0
            int r4 = r4.jsy7Kz77rNyAY3JWsGLNrUoUOR8HajCK4Ef1UopjrJy4hdX7ElFJvGzBTGAF3HB
            java.util.Calendar r3 = com.google.appinventor.components.runtime.util.Dates.TimeInstant(r3, r4)
            r2.f251hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME = r3
            r2 = r0
            android.os.Handler r3 = new android.os.Handler
            r10 = r3
            r3 = r10
            r4 = r10
            r4.<init>()
            r2.androidUIHandler = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.appinventor.components.runtime.TimePicker.<init>(com.google.appinventor.components.runtime.ComponentContainer):void");
    }

    @SimpleProperty(category = PropertyCategory.APPEARANCE, description = "The hour of the last time set using the time picker. The hour is in a 24 hour format. If the last time set was 11:53 pm, this property will return 23.")
    public int Hour() {
        return this.fAlnFrzRyM2sCUVmNXgAumx383He1buRJXamXMT9T0hNFh1WxfF7xQU1M3W9TIGM;
    }

    @SimpleProperty(category = PropertyCategory.APPEARANCE, description = "The minute of the last time set using the time picker")
    public int Minute() {
        return this.jsy7Kz77rNyAY3JWsGLNrUoUOR8HajCK4Ef1UopjrJy4hdX7ElFJvGzBTGAF3HB;
    }

    @SimpleProperty(category = PropertyCategory.APPEARANCE, description = "The instant of the last time set using the time picker")
    public Calendar Instant() {
        return this.f251hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME;
    }

    @SimpleFunction(description = "Set the time to be shown in the Time Picker popup. Current time is shown by default.")
    public void SetTimeToDisplay(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        if (i3 < 0 || i3 > 23) {
            this.form.dispatchErrorOccurredEvent(this, "SetTimeToDisplay", ErrorMessages.ERROR_ILLEGAL_HOUR, new Object[0]);
        } else if (i4 < 0 || i4 > 59) {
            this.form.dispatchErrorOccurredEvent(this, "SetTimeToDisplay", ErrorMessages.ERROR_ILLEGAL_MINUTE, new Object[0]);
        } else {
            this.f250hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.updateTime(i3, i4);
            this.f251hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME = Dates.TimeInstant(i3, i4);
            this.HThm2UFiN8mNIb2OEGwVoJpkwNLFwrt8FHi6kSBOC6T1EOtocK0hkK9xDo2LJOJZ = true;
        }
    }

    @SimpleFunction(description = "Set the time from the instant to be shown in the Time Picker popup. Current time is shown by default.")
    public void SetTimeToDisplayFromInstant(Calendar calendar) {
        Calendar calendar2 = calendar;
        int Hour = Dates.Hour(calendar2);
        int Minute = Dates.Minute(calendar2);
        this.f250hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.updateTime(Hour, Minute);
        Calendar TimeInstant = Dates.TimeInstant(Hour, Minute);
        this.HThm2UFiN8mNIb2OEGwVoJpkwNLFwrt8FHi6kSBOC6T1EOtocK0hkK9xDo2LJOJZ = true;
    }

    @SimpleFunction(description = "Launches the TimePicker popup.")
    public void LaunchPicker() {
        click();
    }

    public void click() {
        if (!this.HThm2UFiN8mNIb2OEGwVoJpkwNLFwrt8FHi6kSBOC6T1EOtocK0hkK9xDo2LJOJZ) {
            Calendar instance = Calendar.getInstance();
            this.f250hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.updateTime(instance.get(11), instance.get(12));
            this.f251hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME = Dates.TimeInstant(this.fAlnFrzRyM2sCUVmNXgAumx383He1buRJXamXMT9T0hNFh1WxfF7xQU1M3W9TIGM, this.jsy7Kz77rNyAY3JWsGLNrUoUOR8HajCK4Ef1UopjrJy4hdX7ElFJvGzBTGAF3HB);
        } else {
            this.HThm2UFiN8mNIb2OEGwVoJpkwNLFwrt8FHi6kSBOC6T1EOtocK0hkK9xDo2LJOJZ = false;
        }
        this.f250hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.show();
    }

    @SimpleEvent(description = "This event is run when a user has set the time in the popup dialog.")
    public void AfterTimeSet() {
        boolean dispatchEvent = EventDispatcher.dispatchEvent(this, "AfterTimeSet", new Object[0]);
    }
}
