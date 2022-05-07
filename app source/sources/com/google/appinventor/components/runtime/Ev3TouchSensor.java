package com.google.appinventor.components.runtime;

import android.os.Handler;
import com.google.appinventor.components.annotations.DesignerComponent;
import com.google.appinventor.components.annotations.DesignerProperty;
import com.google.appinventor.components.annotations.PropertyCategory;
import com.google.appinventor.components.annotations.SimpleEvent;
import com.google.appinventor.components.annotations.SimpleFunction;
import com.google.appinventor.components.annotations.SimpleObject;
import com.google.appinventor.components.annotations.SimpleProperty;
import com.google.appinventor.components.common.ComponentCategory;

@SimpleObject
@DesignerComponent(category = ComponentCategory.EV3, description = "A component that provides a high-level interface to a touch sensor on a LEGO MINDSTORMS EV3 robot.", iconName = "images/legoMindstormsEv3.png", nonVisible = true, version = 1)
public class Ev3TouchSensor extends LegoMindstormsEv3Sensor implements Deleteable {
    /* access modifiers changed from: private */
    public boolean ESt8lrIffFGR3zRMjd5dWbJ7NZymJSmv5KENFDX7fPBQMwlHzz9dP6Ts0eqkVO5e;
    private int J9GCddMpW5m7K6b7f8nFol5AuYTClyx20NTbEibimiSwx7sDFiwQjZjPs0Mw8DwU = -1;
    private String ZXVyhZW2wwbAysjXrMReFP00vcRkftFV6dFiSCOUB0OBlMJVjuhF9XlRGX7w6PdR = "touch";
    private int bVeTzqSexGvEaauwiYAVDIi0rEKwP38hsr4zIk14QJ70YrYaNw4t0FSa76teZ34b = 0;
    private Handler hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME;

    /* renamed from: hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME  reason: collision with other field name */
    private final Runnable f84hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME;
    private boolean iLHecwZEZ1qFKybU5FAR3aqOIDdUsGdPPaR0D5I2BkdnPzgzEMwtpOPW3wNOFXm;

    static /* synthetic */ int hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME(Ev3TouchSensor ev3TouchSensor, int i) {
        int i2 = i;
        int i3 = i2;
        ev3TouchSensor.J9GCddMpW5m7K6b7f8nFol5AuYTClyx20NTbEibimiSwx7sDFiwQjZjPs0Mw8DwU = i3;
        return i2;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Ev3TouchSensor(ComponentContainer componentContainer) {
        super(componentContainer, "Ev3TouchSensor");
        Handler handler;
        Runnable runnable;
        new Handler();
        this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME = handler;
        new Runnable(this) {
            private /* synthetic */ Ev3TouchSensor hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME;

            {
                this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME = r5;
            }

            public final void run() {
                String str = "";
                if (this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.bluetooth != null && this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.bluetooth.IsConnected()) {
                    int hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME2 = this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.B8WBXPBCF2jGfUDZZU2zV5EYdqbUBu0lAZ0THCEqYyuE8VACR9dY7rDnwBIqh64T(str);
                    if (Ev3TouchSensor.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME(this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME) < 0) {
                        int hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME3 = Ev3TouchSensor.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME(this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME, hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME2);
                        boolean postDelayed = Ev3TouchSensor.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME(this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME).postDelayed(this, 50);
                        return;
                    }
                    if (Ev3TouchSensor.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME(this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME) < 50) {
                        if (Ev3TouchSensor.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME(this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME) && hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME2 >= 50) {
                            this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.Pressed();
                        }
                    } else if (this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.ESt8lrIffFGR3zRMjd5dWbJ7NZymJSmv5KENFDX7fPBQMwlHzz9dP6Ts0eqkVO5e && hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME2 < 50) {
                        this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.Released();
                    }
                    int hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME4 = Ev3TouchSensor.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME(this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME, hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME2);
                }
                boolean postDelayed2 = Ev3TouchSensor.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME(this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME).postDelayed(this, 50);
            }
        };
        this.f84hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME = runnable;
        boolean post = this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.post(this.f84hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME);
        PressedEventEnabled(false);
        ReleasedEventEnabled(false);
    }

    @SimpleFunction(description = "Returns true if the touch sensor is pressed.")
    public boolean IsPressed() {
        return B8WBXPBCF2jGfUDZZU2zV5EYdqbUBu0lAZ0THCEqYyuE8VACR9dY7rDnwBIqh64T("IsPressed") >= 50;
    }

    @DesignerProperty(defaultValue = "False", editorType = "boolean")
    @SimpleProperty
    public void PressedEventEnabled(boolean z) {
        boolean z2 = z;
        this.ESt8lrIffFGR3zRMjd5dWbJ7NZymJSmv5KENFDX7fPBQMwlHzz9dP6Ts0eqkVO5e = z2;
    }

    @SimpleProperty(category = PropertyCategory.BEHAVIOR, description = "Whether the Released event should fire when the touch sensor is pressed.")
    public boolean PressedEventEnabled() {
        return this.ESt8lrIffFGR3zRMjd5dWbJ7NZymJSmv5KENFDX7fPBQMwlHzz9dP6Ts0eqkVO5e;
    }

    @SimpleEvent(description = "Called when the touch sensor is pressed.")
    public void Pressed() {
        boolean dispatchEvent = EventDispatcher.dispatchEvent(this, "Pressed", new Object[0]);
    }

    @SimpleProperty(category = PropertyCategory.BEHAVIOR, description = "Whether the Released event should fire when the touch sensor is released.")
    public boolean ReleasedEventEnabled() {
        return this.iLHecwZEZ1qFKybU5FAR3aqOIDdUsGdPPaR0D5I2BkdnPzgzEMwtpOPW3wNOFXm;
    }

    @DesignerProperty(defaultValue = "False", editorType = "boolean")
    @SimpleProperty
    public void ReleasedEventEnabled(boolean z) {
        boolean z2 = z;
        this.iLHecwZEZ1qFKybU5FAR3aqOIDdUsGdPPaR0D5I2BkdnPzgzEMwtpOPW3wNOFXm = z2;
    }

    @SimpleEvent(description = "Called when the touch sensor is pressed.")
    public void Released() {
        boolean dispatchEvent = EventDispatcher.dispatchEvent(this, "Released", new Object[0]);
    }

    /* access modifiers changed from: private */
    public int B8WBXPBCF2jGfUDZZU2zV5EYdqbUBu0lAZ0THCEqYyuE8VACR9dY7rDnwBIqh64T(String str) {
        return readInputPercentage(str, 0, this.sensorPortNumber, 16, 0);
    }

    public void onDelete() {
        this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.removeCallbacks(this.f84hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME);
        super.onDelete();
    }
}
