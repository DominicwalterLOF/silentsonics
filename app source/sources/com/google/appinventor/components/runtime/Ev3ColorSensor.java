package com.google.appinventor.components.runtime;

import android.os.Handler;
import com.google.appinventor.components.annotations.DesignerComponent;
import com.google.appinventor.components.annotations.DesignerProperty;
import com.google.appinventor.components.annotations.Options;
import com.google.appinventor.components.annotations.PropertyCategory;
import com.google.appinventor.components.annotations.SimpleEvent;
import com.google.appinventor.components.annotations.SimpleFunction;
import com.google.appinventor.components.annotations.SimpleObject;
import com.google.appinventor.components.annotations.SimpleProperty;
import com.google.appinventor.components.common.ColorSensorMode;
import com.google.appinventor.components.common.ComponentCategory;
import com.google.appinventor.components.runtime.util.ErrorMessages;

@SimpleObject
@DesignerComponent(category = ComponentCategory.EV3, description = "A component that provides a high-level interface to a color sensor on a LEGO MINDSTORMS EV3 robot.", iconName = "images/legoMindstormsEv3.png", nonVisible = true, version = 2)
public class Ev3ColorSensor extends LegoMindstormsEv3Sensor implements Deleteable {
    private int ANz72NxTeEmYo9CF87MXRUuH7WvE4u0mpZwxffTnyiMdygEQRKvmdTCHaXqAvud;
    private int KXDzEMeLg0aMKCNRnRJuQGoMaVrKUgtBW3gGmn2kxU5q0F1ZNh5DKQo95IN9JPm2 = -1;
    private boolean PJTNEFub7t830GnsJOreZR2G4QGerhYk5JzZTaNM1rn2OjCmiPf1GPWMoDtnF4UY;
    private boolean PW8gZZwgOCTWcD2kHUmkv6AgL0mFh4d5ZW9zStIiy43FwfJpRxeUshErA0Pq6Vc5;
    private boolean PnDqXmvCFreSiRVUA0g9XAstwDhIMcbRjkGmb4HpU47gHx12PSApiyWiV1UWvlkR;
    private Handler hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME;

    /* renamed from: hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME  reason: collision with other field name */
    private ColorSensorMode f79hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME = ColorSensorMode.Reflected;

    /* renamed from: hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME  reason: collision with other field name */
    private final Runnable f80hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME;
    private boolean opkAxsBiNe4U2WnUIj3h2psrvR65Yw7R3K1A4XT1tnHgd80YyvpOyialIyu2UQYR;
    private int sLSXXiYjDERyx7CKvO5GstTCcI8HiXXLiPYrugcXt2517h4ADL52v0RLLmUd9xMb = 0;
    private int wGMjbGuJ9Yk6s2LaEm8v1pEJlXt36TYBWZSsia0LUgb1yMdHNGB7uRz3VqnF79D0;

    static /* synthetic */ int B8WBXPBCF2jGfUDZZU2zV5EYdqbUBu0lAZ0THCEqYyuE8VACR9dY7rDnwBIqh64T(Ev3ColorSensor ev3ColorSensor, int i) {
        int i2 = i;
        int i3 = i2;
        ev3ColorSensor.sLSXXiYjDERyx7CKvO5GstTCcI8HiXXLiPYrugcXt2517h4ADL52v0RLLmUd9xMb = i3;
        return i2;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Ev3ColorSensor(ComponentContainer componentContainer) {
        super(componentContainer, "Ev3ColorSensor");
        Handler handler;
        Runnable runnable;
        new Handler();
        this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME = handler;
        new Runnable(this) {
            private /* synthetic */ Ev3ColorSensor hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME;

            {
                this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME = r5;
            }

            public final void run() {
                String str = "";
                if (this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.bluetooth != null && this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.bluetooth.IsConnected()) {
                    if (Ev3ColorSensor.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME(this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME) == ColorSensorMode.Color) {
                        int hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME2 = this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME(str);
                        if (Ev3ColorSensor.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME(this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME) < 0) {
                            int hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME3 = Ev3ColorSensor.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME(this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME, hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME2);
                            boolean postDelayed = Ev3ColorSensor.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME(this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME).postDelayed(this, 50);
                            return;
                        }
                        if (hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME2 != Ev3ColorSensor.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME(this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME) && Ev3ColorSensor.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME(this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME)) {
                            Ev3ColorSensor ev3ColorSensor = this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME;
                            ev3ColorSensor.ColorChanged(hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME2, Ev3ColorSensor.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME(ev3ColorSensor, hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME2));
                        }
                        int hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME4 = Ev3ColorSensor.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME(this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME, hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME2);
                    } else {
                        int hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME5 = this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME(str);
                        if (Ev3ColorSensor.B8WBXPBCF2jGfUDZZU2zV5EYdqbUBu0lAZ0THCEqYyuE8VACR9dY7rDnwBIqh64T(this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME) < 0) {
                            int B8WBXPBCF2jGfUDZZU2zV5EYdqbUBu0lAZ0THCEqYyuE8VACR9dY7rDnwBIqh64T = Ev3ColorSensor.B8WBXPBCF2jGfUDZZU2zV5EYdqbUBu0lAZ0THCEqYyuE8VACR9dY7rDnwBIqh64T(this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME, hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME5);
                            boolean postDelayed2 = Ev3ColorSensor.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME(this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME).postDelayed(this, 50);
                            return;
                        }
                        if (hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME5 < Ev3ColorSensor.wq07duYRO6iFAgWM70EZOSvbCMKs1QznMRJKrct0XuHOBYqCk3XqOKtSBGIpDou(this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME)) {
                            if (Ev3ColorSensor.B8WBXPBCF2jGfUDZZU2zV5EYdqbUBu0lAZ0THCEqYyuE8VACR9dY7rDnwBIqh64T(this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME) && Ev3ColorSensor.B8WBXPBCF2jGfUDZZU2zV5EYdqbUBu0lAZ0THCEqYyuE8VACR9dY7rDnwBIqh64T(this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME) >= Ev3ColorSensor.wq07duYRO6iFAgWM70EZOSvbCMKs1QznMRJKrct0XuHOBYqCk3XqOKtSBGIpDou(this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME)) {
                                this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.BelowRange();
                            }
                        } else if (hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME5 > Ev3ColorSensor.vSp02fkBXgM8EI0gm0rKWXHQ6wdQINJBQuAtCR15YU8g4XNqVKV8r32SYxkQYxkq(this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME)) {
                            if (Ev3ColorSensor.wq07duYRO6iFAgWM70EZOSvbCMKs1QznMRJKrct0XuHOBYqCk3XqOKtSBGIpDou(this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME) && Ev3ColorSensor.B8WBXPBCF2jGfUDZZU2zV5EYdqbUBu0lAZ0THCEqYyuE8VACR9dY7rDnwBIqh64T(this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME) <= Ev3ColorSensor.vSp02fkBXgM8EI0gm0rKWXHQ6wdQINJBQuAtCR15YU8g4XNqVKV8r32SYxkQYxkq(this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME)) {
                                this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.AboveRange();
                            }
                        } else if (Ev3ColorSensor.vSp02fkBXgM8EI0gm0rKWXHQ6wdQINJBQuAtCR15YU8g4XNqVKV8r32SYxkQYxkq(this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME) && (Ev3ColorSensor.B8WBXPBCF2jGfUDZZU2zV5EYdqbUBu0lAZ0THCEqYyuE8VACR9dY7rDnwBIqh64T(this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME) < Ev3ColorSensor.wq07duYRO6iFAgWM70EZOSvbCMKs1QznMRJKrct0XuHOBYqCk3XqOKtSBGIpDou(this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME) || Ev3ColorSensor.B8WBXPBCF2jGfUDZZU2zV5EYdqbUBu0lAZ0THCEqYyuE8VACR9dY7rDnwBIqh64T(this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME) > Ev3ColorSensor.vSp02fkBXgM8EI0gm0rKWXHQ6wdQINJBQuAtCR15YU8g4XNqVKV8r32SYxkQYxkq(this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME))) {
                            this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.WithinRange();
                        }
                        int B8WBXPBCF2jGfUDZZU2zV5EYdqbUBu0lAZ0THCEqYyuE8VACR9dY7rDnwBIqh64T2 = Ev3ColorSensor.B8WBXPBCF2jGfUDZZU2zV5EYdqbUBu0lAZ0THCEqYyuE8VACR9dY7rDnwBIqh64T(this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME, hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME5);
                    }
                }
                boolean postDelayed3 = Ev3ColorSensor.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME(this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME).postDelayed(this, 50);
            }
        };
        this.f80hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME = runnable;
        boolean post = this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.post(this.f80hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME);
        TopOfRange(60);
        BottomOfRange(30);
        BelowRangeEventEnabled(false);
        AboveRangeEventEnabled(false);
        WithinRangeEventEnabled(false);
        ColorChangedEventEnabled(false);
        ModeAbstract(ColorSensorMode.Reflected);
    }

    @SimpleFunction(description = "It returns the light level in percentage, or -1 when the light level cannot be read.")
    public int GetLightLevel() {
        if (this.f79hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME == ColorSensorMode.Color) {
            return -1;
        }
        return hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME("GetLightLevel");
    }

    @SimpleFunction(description = "It returns the color code from 0 to 7 corresponding to no color, black, blue, green, yellow, red, white and brown.")
    public int GetColorCode() {
        if (this.f79hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME != ColorSensorMode.Color) {
            return 0;
        }
        return hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME("GetColorCode");
    }

    @SimpleFunction(description = "Return the color name in one of \"No Color\", \"Black\", \"Blue\", \"Green\", \"Yellow\", \"Red\", \"White\", \"Brown\".")
    public String GetColorName() {
        if (this.f79hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME != ColorSensorMode.Color) {
            return "No Color";
        }
        return hR11jdqaRrvBRiBFd4KN6gI7d8MNQVP5Yc7fufDZjGGTeTxaualejjrhiR1Iz2xO(hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME("GetColorName"));
    }

    @SimpleProperty(category = PropertyCategory.BEHAVIOR, description = "The bottom of the range used for the BelowRange, WithinRange, and AboveRange events.")
    public int BottomOfRange() {
        return this.ANz72NxTeEmYo9CF87MXRUuH7WvE4u0mpZwxffTnyiMdygEQRKvmdTCHaXqAvud;
    }

    @DesignerProperty(defaultValue = "30", editorType = "non_negative_integer")
    @SimpleProperty
    public void BottomOfRange(int i) {
        int i2 = i;
        this.ANz72NxTeEmYo9CF87MXRUuH7WvE4u0mpZwxffTnyiMdygEQRKvmdTCHaXqAvud = i2;
    }

    @SimpleProperty(category = PropertyCategory.BEHAVIOR, description = "The top of the range used for the BelowRange, WithinRange, and AboveRange events.")
    public int TopOfRange() {
        return this.wGMjbGuJ9Yk6s2LaEm8v1pEJlXt36TYBWZSsia0LUgb1yMdHNGB7uRz3VqnF79D0;
    }

    @DesignerProperty(defaultValue = "60", editorType = "non_negative_integer")
    @SimpleProperty
    public void TopOfRange(int i) {
        int i2 = i;
        this.wGMjbGuJ9Yk6s2LaEm8v1pEJlXt36TYBWZSsia0LUgb1yMdHNGB7uRz3VqnF79D0 = i2;
    }

    @SimpleProperty(category = PropertyCategory.BEHAVIOR, description = "Whether the BelowRange event should fire when the light level goes below the BottomOfRange.")
    public boolean BelowRangeEventEnabled() {
        return this.PJTNEFub7t830GnsJOreZR2G4QGerhYk5JzZTaNM1rn2OjCmiPf1GPWMoDtnF4UY;
    }

    @DesignerProperty(defaultValue = "False", editorType = "boolean")
    @SimpleProperty
    public void BelowRangeEventEnabled(boolean z) {
        boolean z2 = z;
        this.PJTNEFub7t830GnsJOreZR2G4QGerhYk5JzZTaNM1rn2OjCmiPf1GPWMoDtnF4UY = z2;
    }

    @SimpleEvent(description = "Light level has gone below the range.")
    public void BelowRange() {
        boolean dispatchEvent = EventDispatcher.dispatchEvent(this, "BelowRange", new Object[0]);
    }

    @SimpleProperty(category = PropertyCategory.BEHAVIOR, description = "Whether the WithinRange event should fire when the light level goes between the BottomOfRange and the TopOfRange.")
    public boolean WithinRangeEventEnabled() {
        return this.opkAxsBiNe4U2WnUIj3h2psrvR65Yw7R3K1A4XT1tnHgd80YyvpOyialIyu2UQYR;
    }

    @DesignerProperty(defaultValue = "False", editorType = "boolean")
    @SimpleProperty
    public void WithinRangeEventEnabled(boolean z) {
        boolean z2 = z;
        this.opkAxsBiNe4U2WnUIj3h2psrvR65Yw7R3K1A4XT1tnHgd80YyvpOyialIyu2UQYR = z2;
    }

    @SimpleEvent(description = "Light level has gone within the range.")
    public void WithinRange() {
        boolean dispatchEvent = EventDispatcher.dispatchEvent(this, "WithinRange", new Object[0]);
    }

    @SimpleProperty(category = PropertyCategory.BEHAVIOR, description = "Whether the AboveRange event should fire when the light level goes above the TopOfRange.")
    public boolean AboveRangeEventEnabled() {
        return this.PW8gZZwgOCTWcD2kHUmkv6AgL0mFh4d5ZW9zStIiy43FwfJpRxeUshErA0Pq6Vc5;
    }

    @DesignerProperty(defaultValue = "False", editorType = "boolean")
    @SimpleProperty
    public void AboveRangeEventEnabled(boolean z) {
        boolean z2 = z;
        this.PW8gZZwgOCTWcD2kHUmkv6AgL0mFh4d5ZW9zStIiy43FwfJpRxeUshErA0Pq6Vc5 = z2;
    }

    @SimpleEvent(description = "Light level has gone above the range.")
    public void AboveRange() {
        boolean dispatchEvent = EventDispatcher.dispatchEvent(this, "AboveRange", new Object[0]);
    }

    @SimpleProperty(category = PropertyCategory.BEHAVIOR, description = "Whether the ColorChanged event should fire when the Mode property is set to \"color\" and the detected color changes.")
    public boolean ColorChangedEventEnabled() {
        return this.PnDqXmvCFreSiRVUA0g9XAstwDhIMcbRjkGmb4HpU47gHx12PSApiyWiV1UWvlkR;
    }

    @DesignerProperty(defaultValue = "False", editorType = "boolean")
    @SimpleProperty
    public void ColorChangedEventEnabled(boolean z) {
        boolean z2 = z;
        this.PnDqXmvCFreSiRVUA0g9XAstwDhIMcbRjkGmb4HpU47gHx12PSApiyWiV1UWvlkR = z2;
    }

    @SimpleEvent(description = "Called when the detected color has changed. The ColorChanged event will occur if the Mode property is set to \"color\" and the ColorChangedEventEnabled property is set to True.")
    public void ColorChanged(int i, String str) {
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(i);
        Object[] objArr2 = objArr;
        objArr2[1] = str;
        boolean dispatchEvent = EventDispatcher.dispatchEvent(this, "ColorChanged", objArr2);
    }

    /* access modifiers changed from: private */
    public int hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME(String str) {
        int readInputPercentage = readInputPercentage(str, 0, this.sensorPortNumber, 29, this.f79hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.toInt().intValue());
        if (this.f79hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME != ColorSensorMode.Color) {
            return readInputPercentage;
        }
        switch (readInputPercentage) {
            case 0:
                return 0;
            case 12:
                return 1;
            case 25:
                return 2;
            case 37:
                return 3;
            case 50:
                return 4;
            case 62:
                return 5;
            case 75:
                return 6;
            case 87:
                return 7;
            default:
                return 0;
        }
    }

    private String hR11jdqaRrvBRiBFd4KN6gI7d8MNQVP5Yc7fufDZjGGTeTxaualejjrhiR1Iz2xO(int i) {
        int i2 = i;
        if (this.f79hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME != ColorSensorMode.Color) {
            return "No Color";
        }
        switch (i2) {
            case 0:
                return "No Color";
            case 1:
                return "Black";
            case 2:
                return "Blue";
            case 3:
                return "Green";
            case 4:
                return "Yellow";
            case 5:
                return "Red";
            case 6:
                return "White";
            case 7:
                return "Brown";
            default:
                return "No Color";
        }
    }

    @DesignerProperty(defaultValue = "reflected", editorType = "lego_ev3_color_sensor_mode")
    @SimpleProperty
    public void Mode(@Options(ColorSensorMode.class) String str) {
        String str2 = str;
        ColorSensorMode fromUnderlyingValue = ColorSensorMode.fromUnderlyingValue(str2);
        ColorSensorMode colorSensorMode = fromUnderlyingValue;
        if (fromUnderlyingValue == null) {
            this.form.dispatchErrorOccurredEvent(this, "Mode", ErrorMessages.ERROR_EV3_ILLEGAL_ARGUMENT, str2);
            return;
        }
        hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME(colorSensorMode);
    }

    public void ModeAbstract(ColorSensorMode colorSensorMode) {
        hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME(colorSensorMode);
    }

    public ColorSensorMode ModeAbstract() {
        return this.f79hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME;
    }

    @Options(ColorSensorMode.class)
    @SimpleProperty(category = PropertyCategory.BEHAVIOR, description = "Get the current sensor mode.")
    public String Mode() {
        return this.f79hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.toUnderlyingValue();
    }

    @Deprecated
    @SimpleFunction(description = "Enter the color detection mode.")
    public void SetColorMode() {
        hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME(ColorSensorMode.Color);
    }

    @Deprecated
    @SimpleFunction(description = "Make the sensor read the light level with reflected light.")
    public void SetReflectedMode() {
        hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME(ColorSensorMode.Reflected);
    }

    @Deprecated
    @SimpleFunction(description = "Make the sensor read the light level without reflected light.")
    public void SetAmbientMode() {
        hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME(ColorSensorMode.Ambient);
    }

    private void hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME(ColorSensorMode colorSensorMode) {
        this.KXDzEMeLg0aMKCNRnRJuQGoMaVrKUgtBW3gGmn2kxU5q0F1ZNh5DKQo95IN9JPm2 = -1;
        this.sLSXXiYjDERyx7CKvO5GstTCcI8HiXXLiPYrugcXt2517h4ADL52v0RLLmUd9xMb = -1;
        this.f79hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME = colorSensorMode;
    }

    public void onDelete() {
        this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.removeCallbacks(this.f80hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME);
        super.onDelete();
    }
}
