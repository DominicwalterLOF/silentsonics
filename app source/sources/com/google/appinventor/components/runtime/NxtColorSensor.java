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
import com.google.appinventor.components.common.NxtSensorMode;
import com.google.appinventor.components.common.NxtSensorType;
import com.google.appinventor.components.runtime.LegoMindstormsNxtSensor;
import com.google.appinventor.components.runtime.util.ErrorMessages;
import java.util.HashMap;
import java.util.Map;

@SimpleObject
@DesignerComponent(category = ComponentCategory.NXT, description = "A component that provides a high-level interface to a color sensor on a LEGO MINDSTORMS NXT robot.", iconName = "images/legoMindstormsNxt.png", nonVisible = true, version = 1)
public class NxtColorSensor extends LegoMindstormsNxtSensor implements Deleteable {
    private static final Map<Integer, NxtSensorType> Co1rSUoyBoOJ9n0NOgrpxvTYmRPklnETeodUBiQlSBK151C8PCv1Q1Pl4SUa1qxB;
    private static final Map<Integer, Integer> sSQuIBUVrx5rcdxHqHgqC6bPLuuDnxnBF7e7BJeOxmxr54l6ArzFZvC3SGBTuUdt;
    private int ANz72NxTeEmYo9CF87MXRUuH7WvE4u0mpZwxffTnyiMdygEQRKvmdTCHaXqAvud;

    /* renamed from: Co1rSUoyBoOJ9n0NOgrpxvTYmRPklnETeodUBiQlSBK151C8PCv1Q1Pl4SUa1qxB  reason: collision with other field name */
    private final Runnable f229Co1rSUoyBoOJ9n0NOgrpxvTYmRPklnETeodUBiQlSBK151C8PCv1Q1Pl4SUa1qxB;
    private boolean FlE8cJN9pJT0vK7EOYVYVCxuB0sJcG6jpZ55tqfSsTRV8K3RkDe9yvLjVOLhsxDi;
    private int KXDzEMeLg0aMKCNRnRJuQGoMaVrKUgtBW3gGmn2kxU5q0F1ZNh5DKQo95IN9JPm2 = 16777215;
    private int NqI9fRlBp15rsxXeNmRjOrUuQwDxdaDY0xSQj1B7T50sMWnnasnmhTtbykVZmafW;
    private boolean PJTNEFub7t830GnsJOreZR2G4QGerhYk5JzZTaNM1rn2OjCmiPf1GPWMoDtnF4UY;
    private boolean PW8gZZwgOCTWcD2kHUmkv6AgL0mFh4d5ZW9zStIiy43FwfJpRxeUshErA0Pq6Vc5;
    private boolean PnDqXmvCFreSiRVUA0g9XAstwDhIMcbRjkGmb4HpU47gHx12PSApiyWiV1UWvlkR;
    private int WT81i4At6dHne14KPL5TcdNiShzKisif1ehRA81016Xex9QKtWws9m2RXtqd3wpA = a.DHXdVBD10imZD254vgJdvVnoNnGi6ltYnt493xQ866MP9unX6nAi8XBtATXxBfV8;
    private Handler handler;
    private boolean opkAxsBiNe4U2WnUIj3h2psrvR65Yw7R3K1A4XT1tnHgd80YyvpOyialIyu2UQYR;
    private int wGMjbGuJ9Yk6s2LaEm8v1pEJlXt36TYBWZSsia0LUgb1yMdHNGB7uRz3VqnF79D0;

    static /* synthetic */ int B8WBXPBCF2jGfUDZZU2zV5EYdqbUBu0lAZ0THCEqYyuE8VACR9dY7rDnwBIqh64T(NxtColorSensor nxtColorSensor, int i) {
        int i2 = i;
        int i3 = i2;
        nxtColorSensor.WT81i4At6dHne14KPL5TcdNiShzKisif1ehRA81016Xex9QKtWws9m2RXtqd3wpA = i3;
        return i2;
    }

    static /* synthetic */ int hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME(NxtColorSensor nxtColorSensor, int i) {
        int i2 = i;
        int i3 = i2;
        nxtColorSensor.KXDzEMeLg0aMKCNRnRJuQGoMaVrKUgtBW3gGmn2kxU5q0F1ZNh5DKQo95IN9JPm2 = i3;
        return i2;
    }

    enum a {
        ;
        
        public static final int DHXdVBD10imZD254vgJdvVnoNnGi6ltYnt493xQ866MP9unX6nAi8XBtATXxBfV8 = 0;
        public static final int LqPkE8nw2txhYsROtdyVVn8eaaz2Snf5qPRDJl9Xd4fWH3FTDxRDNp0V8h7hgt8B = 0;
        public static final int pA4gj2pijkqCsrKJCWMJXnTZqsBbwNoQGf3YiS6sfVTNefcGmCrEoGjUFuLXwlZr = 0;
        public static final int yTV71ZsokI1cWCTQFF82CwpCeeVC4RDXPNMp7sNxPH2Pf25hYzf1pp0KzV43yJiS = 0;

        static {
            DHXdVBD10imZD254vgJdvVnoNnGi6ltYnt493xQ866MP9unX6nAi8XBtATXxBfV8 = 1;
            LqPkE8nw2txhYsROtdyVVn8eaaz2Snf5qPRDJl9Xd4fWH3FTDxRDNp0V8h7hgt8B = 2;
            pA4gj2pijkqCsrKJCWMJXnTZqsBbwNoQGf3YiS6sfVTNefcGmCrEoGjUFuLXwlZr = 3;
            yTV71ZsokI1cWCTQFF82CwpCeeVC4RDXPNMp7sNxPH2Pf25hYzf1pp0KzV43yJiS = 4;
            int[] iArr = new int[4];
            iArr[0] = 1;
            int[] iArr2 = iArr;
            iArr2[1] = 2;
            int[] iArr3 = iArr2;
            iArr3[2] = 3;
            iArr3[3] = 4;
        }
    }

    static {
        Map<Integer, NxtSensorType> map;
        Map<Integer, Integer> map2;
        new HashMap();
        Map<Integer, NxtSensorType> map3 = map;
        Co1rSUoyBoOJ9n0NOgrpxvTYmRPklnETeodUBiQlSBK151C8PCv1Q1Pl4SUa1qxB = map3;
        NxtSensorType put = map3.put(Integer.valueOf(Component.COLOR_RED), NxtSensorType.ColorRed);
        NxtSensorType put2 = Co1rSUoyBoOJ9n0NOgrpxvTYmRPklnETeodUBiQlSBK151C8PCv1Q1Pl4SUa1qxB.put(Integer.valueOf(Component.COLOR_GREEN), NxtSensorType.ColorGreen);
        NxtSensorType put3 = Co1rSUoyBoOJ9n0NOgrpxvTYmRPklnETeodUBiQlSBK151C8PCv1Q1Pl4SUa1qxB.put(-14575886, NxtSensorType.ColorBlue);
        NxtSensorType put4 = Co1rSUoyBoOJ9n0NOgrpxvTYmRPklnETeodUBiQlSBK151C8PCv1Q1Pl4SUa1qxB.put(16777215, NxtSensorType.ColorNone);
        new HashMap();
        Map<Integer, Integer> map4 = map2;
        sSQuIBUVrx5rcdxHqHgqC6bPLuuDnxnBF7e7BJeOxmxr54l6ArzFZvC3SGBTuUdt = map4;
        Integer put5 = map4.put(1, -16777216);
        Integer put6 = sSQuIBUVrx5rcdxHqHgqC6bPLuuDnxnBF7e7BJeOxmxr54l6ArzFZvC3SGBTuUdt.put(2, -14575886);
        Integer put7 = sSQuIBUVrx5rcdxHqHgqC6bPLuuDnxnBF7e7BJeOxmxr54l6ArzFZvC3SGBTuUdt.put(3, Integer.valueOf(Component.COLOR_GREEN));
        Integer put8 = sSQuIBUVrx5rcdxHqHgqC6bPLuuDnxnBF7e7BJeOxmxr54l6ArzFZvC3SGBTuUdt.put(4, Integer.valueOf(Component.COLOR_YELLOW));
        Integer put9 = sSQuIBUVrx5rcdxHqHgqC6bPLuuDnxnBF7e7BJeOxmxr54l6ArzFZvC3SGBTuUdt.put(5, Integer.valueOf(Component.COLOR_RED));
        Integer put10 = sSQuIBUVrx5rcdxHqHgqC6bPLuuDnxnBF7e7BJeOxmxr54l6ArzFZvC3SGBTuUdt.put(6, -1);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NxtColorSensor(ComponentContainer componentContainer) {
        super(componentContainer, "NxtColorSensor");
        Handler handler2;
        Runnable runnable;
        new Handler();
        this.handler = handler2;
        new Runnable(this) {
            private /* synthetic */ NxtColorSensor hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME;

            {
                this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME = r5;
            }

            public final void run() {
                int i;
                if (this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.bluetooth != null && this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.bluetooth.IsConnected()) {
                    if (NxtColorSensor.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME(this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME)) {
                        LegoMindstormsNxtSensor.a hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME2 = this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME("");
                        LegoMindstormsNxtSensor.a aVar = hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME2;
                        if (hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME2.hqHtvKVLFGgMVMSKZM3hViIxQKdIh8YXfZOV4lmVWV1e2Mndp07BOheWTgPW1jrN) {
                            int intValue = ((Integer) aVar.qPeHJnCLP0dAOwDPeFIn82vcSIsCMh6KFFn3o4kyIe0RhQKOQXDeyY2LFwPu2GbE).intValue();
                            int i2 = intValue;
                            if (intValue != NxtColorSensor.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME(this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME)) {
                                this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.ColorChanged(i2);
                            }
                            int hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME3 = NxtColorSensor.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME(this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME, i2);
                        }
                    } else {
                        LegoMindstormsNxtSensor.a B8WBXPBCF2jGfUDZZU2zV5EYdqbUBu0lAZ0THCEqYyuE8VACR9dY7rDnwBIqh64T = this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.B8WBXPBCF2jGfUDZZU2zV5EYdqbUBu0lAZ0THCEqYyuE8VACR9dY7rDnwBIqh64T("");
                        LegoMindstormsNxtSensor.a aVar2 = B8WBXPBCF2jGfUDZZU2zV5EYdqbUBu0lAZ0THCEqYyuE8VACR9dY7rDnwBIqh64T;
                        if (B8WBXPBCF2jGfUDZZU2zV5EYdqbUBu0lAZ0THCEqYyuE8VACR9dY7rDnwBIqh64T.hqHtvKVLFGgMVMSKZM3hViIxQKdIh8YXfZOV4lmVWV1e2Mndp07BOheWTgPW1jrN) {
                            if (((Integer) aVar2.qPeHJnCLP0dAOwDPeFIn82vcSIsCMh6KFFn3o4kyIe0RhQKOQXDeyY2LFwPu2GbE).intValue() < NxtColorSensor.B8WBXPBCF2jGfUDZZU2zV5EYdqbUBu0lAZ0THCEqYyuE8VACR9dY7rDnwBIqh64T(this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME)) {
                                i = a.LqPkE8nw2txhYsROtdyVVn8eaaz2Snf5qPRDJl9Xd4fWH3FTDxRDNp0V8h7hgt8B;
                            } else if (((Integer) aVar2.qPeHJnCLP0dAOwDPeFIn82vcSIsCMh6KFFn3o4kyIe0RhQKOQXDeyY2LFwPu2GbE).intValue() > NxtColorSensor.wq07duYRO6iFAgWM70EZOSvbCMKs1QznMRJKrct0XuHOBYqCk3XqOKtSBGIpDou(this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME)) {
                                i = a.yTV71ZsokI1cWCTQFF82CwpCeeVC4RDXPNMp7sNxPH2Pf25hYzf1pp0KzV43yJiS;
                            } else {
                                i = a.pA4gj2pijkqCsrKJCWMJXnTZqsBbwNoQGf3YiS6sfVTNefcGmCrEoGjUFuLXwlZr;
                            }
                            if (i != NxtColorSensor.vSp02fkBXgM8EI0gm0rKWXHQ6wdQINJBQuAtCR15YU8g4XNqVKV8r32SYxkQYxkq(this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME)) {
                                if (i == a.LqPkE8nw2txhYsROtdyVVn8eaaz2Snf5qPRDJl9Xd4fWH3FTDxRDNp0V8h7hgt8B && NxtColorSensor.B8WBXPBCF2jGfUDZZU2zV5EYdqbUBu0lAZ0THCEqYyuE8VACR9dY7rDnwBIqh64T(this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME)) {
                                    this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.BelowRange();
                                }
                                if (i == a.pA4gj2pijkqCsrKJCWMJXnTZqsBbwNoQGf3YiS6sfVTNefcGmCrEoGjUFuLXwlZr && NxtColorSensor.wq07duYRO6iFAgWM70EZOSvbCMKs1QznMRJKrct0XuHOBYqCk3XqOKtSBGIpDou(this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME)) {
                                    this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.WithinRange();
                                }
                                if (i == a.yTV71ZsokI1cWCTQFF82CwpCeeVC4RDXPNMp7sNxPH2Pf25hYzf1pp0KzV43yJiS && NxtColorSensor.vSp02fkBXgM8EI0gm0rKWXHQ6wdQINJBQuAtCR15YU8g4XNqVKV8r32SYxkQYxkq(this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME)) {
                                    this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.AboveRange();
                                }
                            }
                            int B8WBXPBCF2jGfUDZZU2zV5EYdqbUBu0lAZ0THCEqYyuE8VACR9dY7rDnwBIqh64T2 = NxtColorSensor.B8WBXPBCF2jGfUDZZU2zV5EYdqbUBu0lAZ0THCEqYyuE8VACR9dY7rDnwBIqh64T(this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME, i);
                        }
                    }
                }
                if (this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.wq07duYRO6iFAgWM70EZOSvbCMKs1QznMRJKrct0XuHOBYqCk3XqOKtSBGIpDou()) {
                    boolean post = NxtColorSensor.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME(this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME).post(NxtColorSensor.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME(this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME));
                }
            }
        };
        this.f229Co1rSUoyBoOJ9n0NOgrpxvTYmRPklnETeodUBiQlSBK151C8PCv1Q1Pl4SUa1qxB = runnable;
        SensorPort("3");
        DetectColor(true);
        ColorChangedEventEnabled(false);
        BottomOfRange(256);
        TopOfRange(767);
        BelowRangeEventEnabled(false);
        WithinRangeEventEnabled(false);
        AboveRangeEventEnabled(false);
        GenerateColor(16777215);
    }

    /* access modifiers changed from: protected */
    public void initializeSensor(String str) {
        String str2 = str;
        setInputMode(str2, this.port, this.FlE8cJN9pJT0vK7EOYVYVCxuB0sJcG6jpZ55tqfSsTRV8K3RkDe9yvLjVOLhsxDi ? NxtSensorType.ColorFull : Co1rSUoyBoOJ9n0NOgrpxvTYmRPklnETeodUBiQlSBK151C8PCv1Q1Pl4SUa1qxB.get(Integer.valueOf(this.NqI9fRlBp15rsxXeNmRjOrUuQwDxdaDY0xSQj1B7T50sMWnnasnmhTtbykVZmafW)), NxtSensorMode.Raw);
        resetInputScaledValue(str2, this.port);
    }

    @DesignerProperty(defaultValue = "3", editorType = "lego_nxt_sensor_port")
    @SimpleProperty(userVisible = false)
    public void SensorPort(String str) {
        setSensorPort(str);
    }

    @SimpleProperty(category = PropertyCategory.BEHAVIOR, description = "Whether the sensor should detect color or light. True indicates that the sensor should detect color; False indicates that the sensor should detect light. If the DetectColor property is set to True, the BelowRange, WithinRange, and AboveRange events will not occur and the sensor will not generate color. If the DetectColor property is set to False, the ColorChanged event will not occur.")
    public boolean DetectColor() {
        return this.FlE8cJN9pJT0vK7EOYVYVCxuB0sJcG6jpZ55tqfSsTRV8K3RkDe9yvLjVOLhsxDi;
    }

    @DesignerProperty(defaultValue = "True", editorType = "boolean")
    @SimpleProperty
    public void DetectColor(boolean z) {
        boolean wq07duYRO6iFAgWM70EZOSvbCMKs1QznMRJKrct0XuHOBYqCk3XqOKtSBGIpDou = wq07duYRO6iFAgWM70EZOSvbCMKs1QznMRJKrct0XuHOBYqCk3XqOKtSBGIpDou();
        this.FlE8cJN9pJT0vK7EOYVYVCxuB0sJcG6jpZ55tqfSsTRV8K3RkDe9yvLjVOLhsxDi = z;
        if (this.bluetooth != null && this.bluetooth.IsConnected()) {
            initializeSensor("DetectColor");
        }
        boolean wq07duYRO6iFAgWM70EZOSvbCMKs1QznMRJKrct0XuHOBYqCk3XqOKtSBGIpDou2 = wq07duYRO6iFAgWM70EZOSvbCMKs1QznMRJKrct0XuHOBYqCk3XqOKtSBGIpDou();
        if (wq07duYRO6iFAgWM70EZOSvbCMKs1QznMRJKrct0XuHOBYqCk3XqOKtSBGIpDou && !wq07duYRO6iFAgWM70EZOSvbCMKs1QznMRJKrct0XuHOBYqCk3XqOKtSBGIpDou2) {
            this.handler.removeCallbacks(this.f229Co1rSUoyBoOJ9n0NOgrpxvTYmRPklnETeodUBiQlSBK151C8PCv1Q1Pl4SUa1qxB);
        }
        this.KXDzEMeLg0aMKCNRnRJuQGoMaVrKUgtBW3gGmn2kxU5q0F1ZNh5DKQo95IN9JPm2 = 16777215;
        this.WT81i4At6dHne14KPL5TcdNiShzKisif1ehRA81016Xex9QKtWws9m2RXtqd3wpA = a.DHXdVBD10imZD254vgJdvVnoNnGi6ltYnt493xQ866MP9unX6nAi8XBtATXxBfV8;
        if (!wq07duYRO6iFAgWM70EZOSvbCMKs1QznMRJKrct0XuHOBYqCk3XqOKtSBGIpDou && wq07duYRO6iFAgWM70EZOSvbCMKs1QznMRJKrct0XuHOBYqCk3XqOKtSBGIpDou2) {
            boolean post = this.handler.post(this.f229Co1rSUoyBoOJ9n0NOgrpxvTYmRPklnETeodUBiQlSBK151C8PCv1Q1Pl4SUa1qxB);
        }
    }

    @SimpleFunction(description = "Returns the current detected color, or the color None if the color can not be read or if the DetectColor property is set to False.")
    public int GetColor() {
        String str = "GetColor";
        if (!checkBluetooth(str)) {
            return 16777215;
        }
        if (!this.FlE8cJN9pJT0vK7EOYVYVCxuB0sJcG6jpZ55tqfSsTRV8K3RkDe9yvLjVOLhsxDi) {
            this.form.dispatchErrorOccurredEvent(this, str, 417, new Object[0]);
            return 16777215;
        }
        LegoMindstormsNxtSensor.a<Integer> hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME = hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME(str);
        LegoMindstormsNxtSensor.a<Integer> aVar = hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME;
        if (hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.hqHtvKVLFGgMVMSKZM3hViIxQKdIh8YXfZOV4lmVWV1e2Mndp07BOheWTgPW1jrN) {
            return ((Integer) aVar.qPeHJnCLP0dAOwDPeFIn82vcSIsCMh6KFFn3o4kyIe0RhQKOQXDeyY2LFwPu2GbE).intValue();
        }
        return 16777215;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.appinventor.components.runtime.LegoMindstormsNxtSensor.a<java.lang.Integer> hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME(java.lang.String r8) {
        /*
            r7 = this;
            r0 = r7
            r1 = r8
            r2 = r0
            r3 = r1
            r4 = r0
            com.google.appinventor.components.common.NxtSensorPort r4 = r4.port
            byte[] r2 = r2.getInputValues((java.lang.String) r3, (com.google.appinventor.components.common.NxtSensorPort) r4)
            r6 = r2
            r2 = r6
            r3 = r6
            r1 = r3
            if (r2 == 0) goto L_0x0052
            r2 = r0
            r3 = r1
            r4 = 4
            boolean r2 = r2.getBooleanValueFromBytes(r3, r4)
            if (r2 == 0) goto L_0x0052
            r2 = r0
            r3 = r1
            r4 = 12
            int r2 = r2.getSWORDValueFromBytes(r3, r4)
            r1 = r2
            java.util.Map<java.lang.Integer, java.lang.Integer> r2 = sSQuIBUVrx5rcdxHqHgqC6bPLuuDnxnBF7e7BJeOxmxr54l6ArzFZvC3SGBTuUdt
            r3 = r1
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            boolean r2 = r2.containsKey(r3)
            if (r2 == 0) goto L_0x0052
            java.util.Map<java.lang.Integer, java.lang.Integer> r2 = sSQuIBUVrx5rcdxHqHgqC6bPLuuDnxnBF7e7BJeOxmxr54l6ArzFZvC3SGBTuUdt
            r3 = r1
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            java.lang.Object r2 = r2.get(r3)
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r2 = r2.intValue()
            r1 = r2
            com.google.appinventor.components.runtime.LegoMindstormsNxtSensor$a r2 = new com.google.appinventor.components.runtime.LegoMindstormsNxtSensor$a
            r6 = r2
            r2 = r6
            r3 = r6
            r4 = 1
            r5 = r1
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            r3.<init>(r4, r5)
            r0 = r2
        L_0x0051:
            return r0
        L_0x0052:
            com.google.appinventor.components.runtime.LegoMindstormsNxtSensor$a r2 = new com.google.appinventor.components.runtime.LegoMindstormsNxtSensor$a
            r6 = r2
            r2 = r6
            r3 = r6
            r4 = 0
            r5 = 0
            r3.<init>(r4, r5)
            r0 = r2
            goto L_0x0051
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.appinventor.components.runtime.NxtColorSensor.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME(java.lang.String):com.google.appinventor.components.runtime.LegoMindstormsNxtSensor$a");
    }

    @SimpleProperty(category = PropertyCategory.BEHAVIOR, description = "Whether the ColorChanged event should fire when the DetectColor property is set to True and the detected color changes.")
    public boolean ColorChangedEventEnabled() {
        return this.PnDqXmvCFreSiRVUA0g9XAstwDhIMcbRjkGmb4HpU47gHx12PSApiyWiV1UWvlkR;
    }

    @DesignerProperty(defaultValue = "False", editorType = "boolean")
    @SimpleProperty
    public void ColorChangedEventEnabled(boolean z) {
        boolean wq07duYRO6iFAgWM70EZOSvbCMKs1QznMRJKrct0XuHOBYqCk3XqOKtSBGIpDou = wq07duYRO6iFAgWM70EZOSvbCMKs1QznMRJKrct0XuHOBYqCk3XqOKtSBGIpDou();
        this.PnDqXmvCFreSiRVUA0g9XAstwDhIMcbRjkGmb4HpU47gHx12PSApiyWiV1UWvlkR = z;
        boolean wq07duYRO6iFAgWM70EZOSvbCMKs1QznMRJKrct0XuHOBYqCk3XqOKtSBGIpDou2 = wq07duYRO6iFAgWM70EZOSvbCMKs1QznMRJKrct0XuHOBYqCk3XqOKtSBGIpDou();
        if (wq07duYRO6iFAgWM70EZOSvbCMKs1QznMRJKrct0XuHOBYqCk3XqOKtSBGIpDou && !wq07duYRO6iFAgWM70EZOSvbCMKs1QznMRJKrct0XuHOBYqCk3XqOKtSBGIpDou2) {
            this.handler.removeCallbacks(this.f229Co1rSUoyBoOJ9n0NOgrpxvTYmRPklnETeodUBiQlSBK151C8PCv1Q1Pl4SUa1qxB);
        }
        if (!wq07duYRO6iFAgWM70EZOSvbCMKs1QznMRJKrct0XuHOBYqCk3XqOKtSBGIpDou && wq07duYRO6iFAgWM70EZOSvbCMKs1QznMRJKrct0XuHOBYqCk3XqOKtSBGIpDou2) {
            this.KXDzEMeLg0aMKCNRnRJuQGoMaVrKUgtBW3gGmn2kxU5q0F1ZNh5DKQo95IN9JPm2 = 16777215;
            boolean post = this.handler.post(this.f229Co1rSUoyBoOJ9n0NOgrpxvTYmRPklnETeodUBiQlSBK151C8PCv1Q1Pl4SUa1qxB);
        }
    }

    @SimpleEvent(description = "Detected color has changed. The ColorChanged event will not occur if the DetectColor property is set to False or if the ColorChangedEventEnabled property is set to False.")
    public void ColorChanged(int i) {
        boolean dispatchEvent = EventDispatcher.dispatchEvent(this, "ColorChanged", Integer.valueOf(i));
    }

    @SimpleFunction(description = "Returns the current light level as a value between 0 and 1023, or -1 if the light level can not be read or if the DetectColor property is set to True.")
    public int GetLightLevel() {
        String str = "GetLightLevel";
        if (!checkBluetooth(str)) {
            return -1;
        }
        if (this.FlE8cJN9pJT0vK7EOYVYVCxuB0sJcG6jpZ55tqfSsTRV8K3RkDe9yvLjVOLhsxDi) {
            this.form.dispatchErrorOccurredEvent(this, str, ErrorMessages.ERROR_NXT_CANNOT_DETECT_LIGHT, new Object[0]);
            return -1;
        }
        LegoMindstormsNxtSensor.a<Integer> B8WBXPBCF2jGfUDZZU2zV5EYdqbUBu0lAZ0THCEqYyuE8VACR9dY7rDnwBIqh64T = B8WBXPBCF2jGfUDZZU2zV5EYdqbUBu0lAZ0THCEqYyuE8VACR9dY7rDnwBIqh64T(str);
        LegoMindstormsNxtSensor.a<Integer> aVar = B8WBXPBCF2jGfUDZZU2zV5EYdqbUBu0lAZ0THCEqYyuE8VACR9dY7rDnwBIqh64T;
        if (B8WBXPBCF2jGfUDZZU2zV5EYdqbUBu0lAZ0THCEqYyuE8VACR9dY7rDnwBIqh64T.hqHtvKVLFGgMVMSKZM3hViIxQKdIh8YXfZOV4lmVWV1e2Mndp07BOheWTgPW1jrN) {
            return ((Integer) aVar.qPeHJnCLP0dAOwDPeFIn82vcSIsCMh6KFFn3o4kyIe0RhQKOQXDeyY2LFwPu2GbE).intValue();
        }
        return -1;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.appinventor.components.runtime.LegoMindstormsNxtSensor.a<java.lang.Integer> B8WBXPBCF2jGfUDZZU2zV5EYdqbUBu0lAZ0THCEqYyuE8VACR9dY7rDnwBIqh64T(java.lang.String r8) {
        /*
            r7 = this;
            r0 = r7
            r1 = r8
            r2 = r0
            r3 = r1
            r4 = r0
            com.google.appinventor.components.common.NxtSensorPort r4 = r4.port
            byte[] r2 = r2.getInputValues((java.lang.String) r3, (com.google.appinventor.components.common.NxtSensorPort) r4)
            r6 = r2
            r2 = r6
            r3 = r6
            r1 = r3
            if (r2 == 0) goto L_0x0033
            r2 = r0
            r3 = r1
            r4 = 4
            boolean r2 = r2.getBooleanValueFromBytes(r3, r4)
            if (r2 == 0) goto L_0x0033
            r2 = r0
            r3 = r1
            r4 = 10
            int r2 = r2.getUWORDValueFromBytes(r3, r4)
            r1 = r2
            com.google.appinventor.components.runtime.LegoMindstormsNxtSensor$a r2 = new com.google.appinventor.components.runtime.LegoMindstormsNxtSensor$a
            r6 = r2
            r2 = r6
            r3 = r6
            r4 = 1
            r5 = r1
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            r3.<init>(r4, r5)
            r0 = r2
        L_0x0032:
            return r0
        L_0x0033:
            com.google.appinventor.components.runtime.LegoMindstormsNxtSensor$a r2 = new com.google.appinventor.components.runtime.LegoMindstormsNxtSensor$a
            r6 = r2
            r2 = r6
            r3 = r6
            r4 = 0
            r5 = 0
            r3.<init>(r4, r5)
            r0 = r2
            goto L_0x0032
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.appinventor.components.runtime.NxtColorSensor.B8WBXPBCF2jGfUDZZU2zV5EYdqbUBu0lAZ0THCEqYyuE8VACR9dY7rDnwBIqh64T(java.lang.String):com.google.appinventor.components.runtime.LegoMindstormsNxtSensor$a");
    }

    @SimpleProperty(category = PropertyCategory.BEHAVIOR, description = "The bottom of the range used for the BelowRange, WithinRange, and AboveRange events.")
    public int BottomOfRange() {
        return this.ANz72NxTeEmYo9CF87MXRUuH7WvE4u0mpZwxffTnyiMdygEQRKvmdTCHaXqAvud;
    }

    @DesignerProperty(defaultValue = "256", editorType = "non_negative_integer")
    @SimpleProperty
    public void BottomOfRange(int i) {
        this.ANz72NxTeEmYo9CF87MXRUuH7WvE4u0mpZwxffTnyiMdygEQRKvmdTCHaXqAvud = i;
        this.WT81i4At6dHne14KPL5TcdNiShzKisif1ehRA81016Xex9QKtWws9m2RXtqd3wpA = a.DHXdVBD10imZD254vgJdvVnoNnGi6ltYnt493xQ866MP9unX6nAi8XBtATXxBfV8;
    }

    @SimpleProperty(category = PropertyCategory.BEHAVIOR, description = "The top of the range used for the BelowRange, WithinRange, and AboveRange events.")
    public int TopOfRange() {
        return this.wGMjbGuJ9Yk6s2LaEm8v1pEJlXt36TYBWZSsia0LUgb1yMdHNGB7uRz3VqnF79D0;
    }

    @DesignerProperty(defaultValue = "767", editorType = "non_negative_integer")
    @SimpleProperty
    public void TopOfRange(int i) {
        this.wGMjbGuJ9Yk6s2LaEm8v1pEJlXt36TYBWZSsia0LUgb1yMdHNGB7uRz3VqnF79D0 = i;
        this.WT81i4At6dHne14KPL5TcdNiShzKisif1ehRA81016Xex9QKtWws9m2RXtqd3wpA = a.DHXdVBD10imZD254vgJdvVnoNnGi6ltYnt493xQ866MP9unX6nAi8XBtATXxBfV8;
    }

    @SimpleProperty(category = PropertyCategory.BEHAVIOR, description = "Whether the BelowRange event should fire when the DetectColor property is set to False and the light level goes below the BottomOfRange.")
    public boolean BelowRangeEventEnabled() {
        return this.PJTNEFub7t830GnsJOreZR2G4QGerhYk5JzZTaNM1rn2OjCmiPf1GPWMoDtnF4UY;
    }

    @DesignerProperty(defaultValue = "False", editorType = "boolean")
    @SimpleProperty
    public void BelowRangeEventEnabled(boolean z) {
        boolean wq07duYRO6iFAgWM70EZOSvbCMKs1QznMRJKrct0XuHOBYqCk3XqOKtSBGIpDou = wq07duYRO6iFAgWM70EZOSvbCMKs1QznMRJKrct0XuHOBYqCk3XqOKtSBGIpDou();
        this.PJTNEFub7t830GnsJOreZR2G4QGerhYk5JzZTaNM1rn2OjCmiPf1GPWMoDtnF4UY = z;
        boolean wq07duYRO6iFAgWM70EZOSvbCMKs1QznMRJKrct0XuHOBYqCk3XqOKtSBGIpDou2 = wq07duYRO6iFAgWM70EZOSvbCMKs1QznMRJKrct0XuHOBYqCk3XqOKtSBGIpDou();
        if (wq07duYRO6iFAgWM70EZOSvbCMKs1QznMRJKrct0XuHOBYqCk3XqOKtSBGIpDou && !wq07duYRO6iFAgWM70EZOSvbCMKs1QznMRJKrct0XuHOBYqCk3XqOKtSBGIpDou2) {
            this.handler.removeCallbacks(this.f229Co1rSUoyBoOJ9n0NOgrpxvTYmRPklnETeodUBiQlSBK151C8PCv1Q1Pl4SUa1qxB);
        }
        if (!wq07duYRO6iFAgWM70EZOSvbCMKs1QznMRJKrct0XuHOBYqCk3XqOKtSBGIpDou && wq07duYRO6iFAgWM70EZOSvbCMKs1QznMRJKrct0XuHOBYqCk3XqOKtSBGIpDou2) {
            this.WT81i4At6dHne14KPL5TcdNiShzKisif1ehRA81016Xex9QKtWws9m2RXtqd3wpA = a.DHXdVBD10imZD254vgJdvVnoNnGi6ltYnt493xQ866MP9unX6nAi8XBtATXxBfV8;
            boolean post = this.handler.post(this.f229Co1rSUoyBoOJ9n0NOgrpxvTYmRPklnETeodUBiQlSBK151C8PCv1Q1Pl4SUa1qxB);
        }
    }

    @SimpleEvent(description = "Light level has gone below the range. The BelowRange event will not occur if the DetectColor property is set to True or if the BelowRangeEventEnabled property is set to False.")
    public void BelowRange() {
        boolean dispatchEvent = EventDispatcher.dispatchEvent(this, "BelowRange", new Object[0]);
    }

    @SimpleProperty(category = PropertyCategory.BEHAVIOR, description = "Whether the WithinRange event should fire when the DetectColor property is set to False and the light level goes between the BottomOfRange and the TopOfRange.")
    public boolean WithinRangeEventEnabled() {
        return this.opkAxsBiNe4U2WnUIj3h2psrvR65Yw7R3K1A4XT1tnHgd80YyvpOyialIyu2UQYR;
    }

    @DesignerProperty(defaultValue = "False", editorType = "boolean")
    @SimpleProperty
    public void WithinRangeEventEnabled(boolean z) {
        boolean wq07duYRO6iFAgWM70EZOSvbCMKs1QznMRJKrct0XuHOBYqCk3XqOKtSBGIpDou = wq07duYRO6iFAgWM70EZOSvbCMKs1QznMRJKrct0XuHOBYqCk3XqOKtSBGIpDou();
        this.opkAxsBiNe4U2WnUIj3h2psrvR65Yw7R3K1A4XT1tnHgd80YyvpOyialIyu2UQYR = z;
        boolean wq07duYRO6iFAgWM70EZOSvbCMKs1QznMRJKrct0XuHOBYqCk3XqOKtSBGIpDou2 = wq07duYRO6iFAgWM70EZOSvbCMKs1QznMRJKrct0XuHOBYqCk3XqOKtSBGIpDou();
        if (wq07duYRO6iFAgWM70EZOSvbCMKs1QznMRJKrct0XuHOBYqCk3XqOKtSBGIpDou && !wq07duYRO6iFAgWM70EZOSvbCMKs1QznMRJKrct0XuHOBYqCk3XqOKtSBGIpDou2) {
            this.handler.removeCallbacks(this.f229Co1rSUoyBoOJ9n0NOgrpxvTYmRPklnETeodUBiQlSBK151C8PCv1Q1Pl4SUa1qxB);
        }
        if (!wq07duYRO6iFAgWM70EZOSvbCMKs1QznMRJKrct0XuHOBYqCk3XqOKtSBGIpDou && wq07duYRO6iFAgWM70EZOSvbCMKs1QznMRJKrct0XuHOBYqCk3XqOKtSBGIpDou2) {
            this.WT81i4At6dHne14KPL5TcdNiShzKisif1ehRA81016Xex9QKtWws9m2RXtqd3wpA = a.DHXdVBD10imZD254vgJdvVnoNnGi6ltYnt493xQ866MP9unX6nAi8XBtATXxBfV8;
            boolean post = this.handler.post(this.f229Co1rSUoyBoOJ9n0NOgrpxvTYmRPklnETeodUBiQlSBK151C8PCv1Q1Pl4SUa1qxB);
        }
    }

    @SimpleEvent(description = "Light level has gone within the range. The WithinRange event will not occur if the DetectColor property is set to True or if the WithinRangeEventEnabled property is set to False.")
    public void WithinRange() {
        boolean dispatchEvent = EventDispatcher.dispatchEvent(this, "WithinRange", new Object[0]);
    }

    @SimpleProperty(category = PropertyCategory.BEHAVIOR, description = "Whether the AboveRange event should fire when the DetectColor property is set to False and the light level goes above the TopOfRange.")
    public boolean AboveRangeEventEnabled() {
        return this.PW8gZZwgOCTWcD2kHUmkv6AgL0mFh4d5ZW9zStIiy43FwfJpRxeUshErA0Pq6Vc5;
    }

    @DesignerProperty(defaultValue = "False", editorType = "boolean")
    @SimpleProperty
    public void AboveRangeEventEnabled(boolean z) {
        boolean wq07duYRO6iFAgWM70EZOSvbCMKs1QznMRJKrct0XuHOBYqCk3XqOKtSBGIpDou = wq07duYRO6iFAgWM70EZOSvbCMKs1QznMRJKrct0XuHOBYqCk3XqOKtSBGIpDou();
        this.PW8gZZwgOCTWcD2kHUmkv6AgL0mFh4d5ZW9zStIiy43FwfJpRxeUshErA0Pq6Vc5 = z;
        boolean wq07duYRO6iFAgWM70EZOSvbCMKs1QznMRJKrct0XuHOBYqCk3XqOKtSBGIpDou2 = wq07duYRO6iFAgWM70EZOSvbCMKs1QznMRJKrct0XuHOBYqCk3XqOKtSBGIpDou();
        if (wq07duYRO6iFAgWM70EZOSvbCMKs1QznMRJKrct0XuHOBYqCk3XqOKtSBGIpDou && !wq07duYRO6iFAgWM70EZOSvbCMKs1QznMRJKrct0XuHOBYqCk3XqOKtSBGIpDou2) {
            this.handler.removeCallbacks(this.f229Co1rSUoyBoOJ9n0NOgrpxvTYmRPklnETeodUBiQlSBK151C8PCv1Q1Pl4SUa1qxB);
        }
        if (!wq07duYRO6iFAgWM70EZOSvbCMKs1QznMRJKrct0XuHOBYqCk3XqOKtSBGIpDou && wq07duYRO6iFAgWM70EZOSvbCMKs1QznMRJKrct0XuHOBYqCk3XqOKtSBGIpDou2) {
            this.WT81i4At6dHne14KPL5TcdNiShzKisif1ehRA81016Xex9QKtWws9m2RXtqd3wpA = a.DHXdVBD10imZD254vgJdvVnoNnGi6ltYnt493xQ866MP9unX6nAi8XBtATXxBfV8;
            boolean post = this.handler.post(this.f229Co1rSUoyBoOJ9n0NOgrpxvTYmRPklnETeodUBiQlSBK151C8PCv1Q1Pl4SUa1qxB);
        }
    }

    @SimpleEvent(description = "Light level has gone above the range. The AboveRange event will not occur if the DetectColor property is set to True or if the AboveRangeEventEnabled property is set to False.")
    public void AboveRange() {
        boolean dispatchEvent = EventDispatcher.dispatchEvent(this, "AboveRange", new Object[0]);
    }

    @SimpleProperty(category = PropertyCategory.BEHAVIOR, description = "The color that should generated by the sensor. Only None, Red, Green, or Blue are valid values. The sensor will not generate color when the DetectColor property is set to True.")
    public int GenerateColor() {
        return this.NqI9fRlBp15rsxXeNmRjOrUuQwDxdaDY0xSQj1B7T50sMWnnasnmhTtbykVZmafW;
    }

    @DesignerProperty(defaultValue = "&H00FFFFFF", editorType = "lego_nxt_generated_color")
    @SimpleProperty
    public void GenerateColor(int i) {
        int i2 = i;
        String str = "GenerateColor";
        if (Co1rSUoyBoOJ9n0NOgrpxvTYmRPklnETeodUBiQlSBK151C8PCv1Q1Pl4SUa1qxB.containsKey(Integer.valueOf(i2))) {
            this.NqI9fRlBp15rsxXeNmRjOrUuQwDxdaDY0xSQj1B7T50sMWnnasnmhTtbykVZmafW = i2;
            if (this.bluetooth != null && this.bluetooth.IsConnected()) {
                initializeSensor(str);
                return;
            }
            return;
        }
        this.form.dispatchErrorOccurredEvent(this, str, 419, new Object[0]);
    }

    /* access modifiers changed from: private */
    public boolean wq07duYRO6iFAgWM70EZOSvbCMKs1QznMRJKrct0XuHOBYqCk3XqOKtSBGIpDou() {
        if (this.FlE8cJN9pJT0vK7EOYVYVCxuB0sJcG6jpZ55tqfSsTRV8K3RkDe9yvLjVOLhsxDi) {
            return this.PnDqXmvCFreSiRVUA0g9XAstwDhIMcbRjkGmb4HpU47gHx12PSApiyWiV1UWvlkR;
        }
        return this.PJTNEFub7t830GnsJOreZR2G4QGerhYk5JzZTaNM1rn2OjCmiPf1GPWMoDtnF4UY || this.opkAxsBiNe4U2WnUIj3h2psrvR65Yw7R3K1A4XT1tnHgd80YyvpOyialIyu2UQYR || this.PW8gZZwgOCTWcD2kHUmkv6AgL0mFh4d5ZW9zStIiy43FwfJpRxeUshErA0Pq6Vc5;
    }

    public void onDelete() {
        this.handler.removeCallbacks(this.f229Co1rSUoyBoOJ9n0NOgrpxvTYmRPklnETeodUBiQlSBK151C8PCv1Q1Pl4SUa1qxB);
        super.onDelete();
    }
}
