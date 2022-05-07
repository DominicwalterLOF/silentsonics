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
import com.google.appinventor.components.runtime.util.Ev3Constants;

@SimpleObject
@DesignerComponent(category = ComponentCategory.NXT, description = "A component that provides a high-level interface to an ultrasonic sensor on a LEGO MINDSTORMS NXT robot.", iconName = "images/legoMindstormsNxt.png", nonVisible = true, version = 1)
public class NxtUltrasonicSensor extends LegoMindstormsNxtSensor implements Deleteable {
    private int ANz72NxTeEmYo9CF87MXRUuH7WvE4u0mpZwxffTnyiMdygEQRKvmdTCHaXqAvud;
    private final Runnable Co1rSUoyBoOJ9n0NOgrpxvTYmRPklnETeodUBiQlSBK151C8PCv1Q1Pl4SUa1qxB;
    private boolean PJTNEFub7t830GnsJOreZR2G4QGerhYk5JzZTaNM1rn2OjCmiPf1GPWMoDtnF4UY;
    private boolean PW8gZZwgOCTWcD2kHUmkv6AgL0mFh4d5ZW9zStIiy43FwfJpRxeUshErA0Pq6Vc5;
    private int boZncMwfbKhn9wEZVXOlCQaCALViR3x19GsnEC1EZxndIE2ufazY5HxCE0U58Zvt = a.P89mqD3TKqF18ygPOurbjck3EPcqxgmZ649A3XXayOkNUpvgMJ4Q1cnkfpD040KQ;
    private Handler handler;
    private boolean opkAxsBiNe4U2WnUIj3h2psrvR65Yw7R3K1A4XT1tnHgd80YyvpOyialIyu2UQYR;
    private int wGMjbGuJ9Yk6s2LaEm8v1pEJlXt36TYBWZSsia0LUgb1yMdHNGB7uRz3VqnF79D0;

    static /* synthetic */ int hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME(NxtUltrasonicSensor nxtUltrasonicSensor, int i) {
        int i2 = i;
        int i3 = i2;
        nxtUltrasonicSensor.boZncMwfbKhn9wEZVXOlCQaCALViR3x19GsnEC1EZxndIE2ufazY5HxCE0U58Zvt = i3;
        return i2;
    }

    enum a {
        ;
        
        public static final int I1fbWPe6RJ2coGGe88dnbV3SwCWOYXWySlRHSiEJVMw7CeEp0YdmKizbxY7zqrk2 = 0;
        public static final int Mn7MCs8byCcphc6u6vZkI1pXuzw5IvVJJPq0YTQ0xCW64cXQ1HYdJPP7QsOPqGr1 = 0;
        public static final int P89mqD3TKqF18ygPOurbjck3EPcqxgmZ649A3XXayOkNUpvgMJ4Q1cnkfpD040KQ = 0;
        public static final int hlRRzlkTvaLJKT7xudtgqrNpSapzuwbeZZHKJdIwcwGUTFYejftgk4y9qZgGh2f0 = 0;

        static {
            P89mqD3TKqF18ygPOurbjck3EPcqxgmZ649A3XXayOkNUpvgMJ4Q1cnkfpD040KQ = 1;
            hlRRzlkTvaLJKT7xudtgqrNpSapzuwbeZZHKJdIwcwGUTFYejftgk4y9qZgGh2f0 = 2;
            I1fbWPe6RJ2coGGe88dnbV3SwCWOYXWySlRHSiEJVMw7CeEp0YdmKizbxY7zqrk2 = 3;
            Mn7MCs8byCcphc6u6vZkI1pXuzw5IvVJJPq0YTQ0xCW64cXQ1HYdJPP7QsOPqGr1 = 4;
            int[] iArr = new int[4];
            iArr[0] = 1;
            int[] iArr2 = iArr;
            iArr2[1] = 2;
            int[] iArr3 = iArr2;
            iArr3[2] = 3;
            iArr3[3] = 4;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NxtUltrasonicSensor(ComponentContainer componentContainer) {
        super(componentContainer, "NxtUltrasonicSensor");
        Handler handler2;
        Runnable runnable;
        new Handler();
        this.handler = handler2;
        new Runnable(this) {
            private /* synthetic */ NxtUltrasonicSensor hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME;

            {
                this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME = r5;
            }

            public final void run() {
                int i;
                if (this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.bluetooth != null && this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.bluetooth.IsConnected()) {
                    LegoMindstormsNxtSensor.a hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME2 = this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.hR11jdqaRrvBRiBFd4KN6gI7d8MNQVP5Yc7fufDZjGGTeTxaualejjrhiR1Iz2xO("");
                    LegoMindstormsNxtSensor.a aVar = hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME2;
                    if (hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME2.hqHtvKVLFGgMVMSKZM3hViIxQKdIh8YXfZOV4lmVWV1e2Mndp07BOheWTgPW1jrN) {
                        if (((Integer) aVar.qPeHJnCLP0dAOwDPeFIn82vcSIsCMh6KFFn3o4kyIe0RhQKOQXDeyY2LFwPu2GbE).intValue() < NxtUltrasonicSensor.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME(this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME)) {
                            i = a.hlRRzlkTvaLJKT7xudtgqrNpSapzuwbeZZHKJdIwcwGUTFYejftgk4y9qZgGh2f0;
                        } else if (((Integer) aVar.qPeHJnCLP0dAOwDPeFIn82vcSIsCMh6KFFn3o4kyIe0RhQKOQXDeyY2LFwPu2GbE).intValue() > NxtUltrasonicSensor.B8WBXPBCF2jGfUDZZU2zV5EYdqbUBu0lAZ0THCEqYyuE8VACR9dY7rDnwBIqh64T(this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME)) {
                            i = a.Mn7MCs8byCcphc6u6vZkI1pXuzw5IvVJJPq0YTQ0xCW64cXQ1HYdJPP7QsOPqGr1;
                        } else {
                            i = a.I1fbWPe6RJ2coGGe88dnbV3SwCWOYXWySlRHSiEJVMw7CeEp0YdmKizbxY7zqrk2;
                        }
                        if (i != NxtUltrasonicSensor.wq07duYRO6iFAgWM70EZOSvbCMKs1QznMRJKrct0XuHOBYqCk3XqOKtSBGIpDou(this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME)) {
                            if (i == a.hlRRzlkTvaLJKT7xudtgqrNpSapzuwbeZZHKJdIwcwGUTFYejftgk4y9qZgGh2f0 && NxtUltrasonicSensor.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME(this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME)) {
                                this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.BelowRange();
                            }
                            if (i == a.I1fbWPe6RJ2coGGe88dnbV3SwCWOYXWySlRHSiEJVMw7CeEp0YdmKizbxY7zqrk2 && NxtUltrasonicSensor.B8WBXPBCF2jGfUDZZU2zV5EYdqbUBu0lAZ0THCEqYyuE8VACR9dY7rDnwBIqh64T(this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME)) {
                                this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.WithinRange();
                            }
                            if (i == a.Mn7MCs8byCcphc6u6vZkI1pXuzw5IvVJJPq0YTQ0xCW64cXQ1HYdJPP7QsOPqGr1 && NxtUltrasonicSensor.wq07duYRO6iFAgWM70EZOSvbCMKs1QznMRJKrct0XuHOBYqCk3XqOKtSBGIpDou(this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME)) {
                                this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.AboveRange();
                            }
                        }
                        int hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME3 = NxtUltrasonicSensor.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME(this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME, i);
                    }
                }
                if (this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.wq07duYRO6iFAgWM70EZOSvbCMKs1QznMRJKrct0XuHOBYqCk3XqOKtSBGIpDou()) {
                    boolean post = NxtUltrasonicSensor.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME(this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME).post(NxtUltrasonicSensor.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME(this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME));
                }
            }
        };
        this.Co1rSUoyBoOJ9n0NOgrpxvTYmRPklnETeodUBiQlSBK151C8PCv1Q1Pl4SUa1qxB = runnable;
        SensorPort("4");
        BottomOfRange(30);
        TopOfRange(90);
        BelowRangeEventEnabled(false);
        WithinRangeEventEnabled(false);
        AboveRangeEventEnabled(false);
    }

    /* access modifiers changed from: protected */
    public void initializeSensor(String str) {
        String str2 = str;
        setInputMode(str2, this.port, NxtSensorType.Digital12C9V, NxtSensorMode.Raw);
        String str3 = str2;
        byte[] bArr = new byte[3];
        byte[] bArr2 = bArr;
        bArr[0] = 2;
        bArr2[1] = Ev3Constants.Opcode.JR_FALSE;
        bArr2[2] = 2;
        lsWrite(str3, this.port, bArr2, 0);
    }

    @DesignerProperty(defaultValue = "4", editorType = "lego_nxt_sensor_port")
    @SimpleProperty(userVisible = false)
    public void SensorPort(String str) {
        setSensorPort(str);
    }

    @SimpleFunction(description = "Returns the current distance in centimeters as a value between 0 and 254, or -1 if the distance can not be read.")
    public int GetDistance() {
        String str = "GetDistance";
        if (!checkBluetooth(str)) {
            return -1;
        }
        LegoMindstormsNxtSensor.a<Integer> hR11jdqaRrvBRiBFd4KN6gI7d8MNQVP5Yc7fufDZjGGTeTxaualejjrhiR1Iz2xO = hR11jdqaRrvBRiBFd4KN6gI7d8MNQVP5Yc7fufDZjGGTeTxaualejjrhiR1Iz2xO(str);
        LegoMindstormsNxtSensor.a<Integer> aVar = hR11jdqaRrvBRiBFd4KN6gI7d8MNQVP5Yc7fufDZjGGTeTxaualejjrhiR1Iz2xO;
        if (hR11jdqaRrvBRiBFd4KN6gI7d8MNQVP5Yc7fufDZjGGTeTxaualejjrhiR1Iz2xO.hqHtvKVLFGgMVMSKZM3hViIxQKdIh8YXfZOV4lmVWV1e2Mndp07BOheWTgPW1jrN) {
            return ((Integer) aVar.qPeHJnCLP0dAOwDPeFIn82vcSIsCMh6KFFn3o4kyIe0RhQKOQXDeyY2LFwPu2GbE).intValue();
        }
        return -1;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.appinventor.components.runtime.LegoMindstormsNxtSensor.a<java.lang.Integer> hR11jdqaRrvBRiBFd4KN6gI7d8MNQVP5Yc7fufDZjGGTeTxaualejjrhiR1Iz2xO(java.lang.String r10) {
        /*
            r9 = this;
            r0 = r9
            r1 = r10
            r3 = 2
            byte[] r3 = new byte[r3]
            r8 = r3
            r3 = r8
            r4 = r8
            r2 = r4
            r4 = 0
            r5 = 2
            r3[r4] = r5
            r3 = r2
            r4 = 1
            r5 = 66
            r3[r4] = r5
            r3 = r0
            r4 = r1
            r5 = r0
            com.google.appinventor.components.common.NxtSensorPort r5 = r5.port
            r6 = r2
            r7 = 1
            r3.lsWrite((java.lang.String) r4, (com.google.appinventor.components.common.NxtSensorPort) r5, (byte[]) r6, (int) r7)
            r3 = 0
            r2 = r3
        L_0x001f:
            r3 = r2
            r4 = 3
            if (r3 >= r4) goto L_0x005f
            r3 = r0
            r4 = r1
            r5 = r0
            com.google.appinventor.components.common.NxtSensorPort r5 = r5.port
            int r3 = r3.lsGetStatus((java.lang.String) r4, (com.google.appinventor.components.common.NxtSensorPort) r5)
            if (r3 <= 0) goto L_0x006b
            r3 = r0
            r4 = r1
            r5 = r0
            com.google.appinventor.components.common.NxtSensorPort r5 = r5.port
            byte[] r3 = r3.lsRead((java.lang.String) r4, (com.google.appinventor.components.common.NxtSensorPort) r5)
            r8 = r3
            r3 = r8
            r4 = r8
            r1 = r4
            if (r3 == 0) goto L_0x005f
            r3 = r0
            r4 = r1
            r5 = 4
            int r3 = r3.getUBYTEValueFromBytes(r4, r5)
            r8 = r3
            r3 = r8
            r4 = r8
            r1 = r4
            if (r3 < 0) goto L_0x005f
            r3 = r1
            r4 = 254(0xfe, float:3.56E-43)
            if (r3 > r4) goto L_0x005f
            com.google.appinventor.components.runtime.LegoMindstormsNxtSensor$a r3 = new com.google.appinventor.components.runtime.LegoMindstormsNxtSensor$a
            r8 = r3
            r3 = r8
            r4 = r8
            r5 = 1
            r6 = r1
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            r4.<init>(r5, r6)
            r0 = r3
        L_0x005e:
            return r0
        L_0x005f:
            com.google.appinventor.components.runtime.LegoMindstormsNxtSensor$a r3 = new com.google.appinventor.components.runtime.LegoMindstormsNxtSensor$a
            r8 = r3
            r3 = r8
            r4 = r8
            r5 = 0
            r6 = 0
            r4.<init>(r5, r6)
            r0 = r3
            goto L_0x005e
        L_0x006b:
            int r2 = r2 + 1
            goto L_0x001f
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.appinventor.components.runtime.NxtUltrasonicSensor.hR11jdqaRrvBRiBFd4KN6gI7d8MNQVP5Yc7fufDZjGGTeTxaualejjrhiR1Iz2xO(java.lang.String):com.google.appinventor.components.runtime.LegoMindstormsNxtSensor$a");
    }

    @SimpleProperty(category = PropertyCategory.BEHAVIOR, description = "The bottom of the range used for the BelowRange, WithinRange, and AboveRange events.")
    public int BottomOfRange() {
        return this.ANz72NxTeEmYo9CF87MXRUuH7WvE4u0mpZwxffTnyiMdygEQRKvmdTCHaXqAvud;
    }

    @DesignerProperty(defaultValue = "30", editorType = "non_negative_integer")
    @SimpleProperty
    public void BottomOfRange(int i) {
        this.ANz72NxTeEmYo9CF87MXRUuH7WvE4u0mpZwxffTnyiMdygEQRKvmdTCHaXqAvud = i;
        this.boZncMwfbKhn9wEZVXOlCQaCALViR3x19GsnEC1EZxndIE2ufazY5HxCE0U58Zvt = a.P89mqD3TKqF18ygPOurbjck3EPcqxgmZ649A3XXayOkNUpvgMJ4Q1cnkfpD040KQ;
    }

    @SimpleProperty(category = PropertyCategory.BEHAVIOR, description = "The top of the range used for the BelowRange, WithinRange, and AboveRange events.")
    public int TopOfRange() {
        return this.wGMjbGuJ9Yk6s2LaEm8v1pEJlXt36TYBWZSsia0LUgb1yMdHNGB7uRz3VqnF79D0;
    }

    @DesignerProperty(defaultValue = "90", editorType = "non_negative_integer")
    @SimpleProperty
    public void TopOfRange(int i) {
        this.wGMjbGuJ9Yk6s2LaEm8v1pEJlXt36TYBWZSsia0LUgb1yMdHNGB7uRz3VqnF79D0 = i;
        this.boZncMwfbKhn9wEZVXOlCQaCALViR3x19GsnEC1EZxndIE2ufazY5HxCE0U58Zvt = a.P89mqD3TKqF18ygPOurbjck3EPcqxgmZ649A3XXayOkNUpvgMJ4Q1cnkfpD040KQ;
    }

    @SimpleProperty(category = PropertyCategory.BEHAVIOR, description = "Whether the BelowRange event should fire when the distance goes below the BottomOfRange.")
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
            this.handler.removeCallbacks(this.Co1rSUoyBoOJ9n0NOgrpxvTYmRPklnETeodUBiQlSBK151C8PCv1Q1Pl4SUa1qxB);
        }
        if (!wq07duYRO6iFAgWM70EZOSvbCMKs1QznMRJKrct0XuHOBYqCk3XqOKtSBGIpDou && wq07duYRO6iFAgWM70EZOSvbCMKs1QznMRJKrct0XuHOBYqCk3XqOKtSBGIpDou2) {
            this.boZncMwfbKhn9wEZVXOlCQaCALViR3x19GsnEC1EZxndIE2ufazY5HxCE0U58Zvt = a.P89mqD3TKqF18ygPOurbjck3EPcqxgmZ649A3XXayOkNUpvgMJ4Q1cnkfpD040KQ;
            boolean post = this.handler.post(this.Co1rSUoyBoOJ9n0NOgrpxvTYmRPklnETeodUBiQlSBK151C8PCv1Q1Pl4SUa1qxB);
        }
    }

    @SimpleEvent(description = "Distance has gone below the range.")
    public void BelowRange() {
        boolean dispatchEvent = EventDispatcher.dispatchEvent(this, "BelowRange", new Object[0]);
    }

    @SimpleProperty(category = PropertyCategory.BEHAVIOR, description = "Whether the WithinRange event should fire when the distance goes between the BottomOfRange and the TopOfRange.")
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
            this.handler.removeCallbacks(this.Co1rSUoyBoOJ9n0NOgrpxvTYmRPklnETeodUBiQlSBK151C8PCv1Q1Pl4SUa1qxB);
        }
        if (!wq07duYRO6iFAgWM70EZOSvbCMKs1QznMRJKrct0XuHOBYqCk3XqOKtSBGIpDou && wq07duYRO6iFAgWM70EZOSvbCMKs1QznMRJKrct0XuHOBYqCk3XqOKtSBGIpDou2) {
            this.boZncMwfbKhn9wEZVXOlCQaCALViR3x19GsnEC1EZxndIE2ufazY5HxCE0U58Zvt = a.P89mqD3TKqF18ygPOurbjck3EPcqxgmZ649A3XXayOkNUpvgMJ4Q1cnkfpD040KQ;
            boolean post = this.handler.post(this.Co1rSUoyBoOJ9n0NOgrpxvTYmRPklnETeodUBiQlSBK151C8PCv1Q1Pl4SUa1qxB);
        }
    }

    @SimpleEvent(description = "Distance has gone within the range.")
    public void WithinRange() {
        boolean dispatchEvent = EventDispatcher.dispatchEvent(this, "WithinRange", new Object[0]);
    }

    @SimpleProperty(category = PropertyCategory.BEHAVIOR, description = "Whether the AboveRange event should fire when the distance goes above the TopOfRange.")
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
            this.handler.removeCallbacks(this.Co1rSUoyBoOJ9n0NOgrpxvTYmRPklnETeodUBiQlSBK151C8PCv1Q1Pl4SUa1qxB);
        }
        if (!wq07duYRO6iFAgWM70EZOSvbCMKs1QznMRJKrct0XuHOBYqCk3XqOKtSBGIpDou && wq07duYRO6iFAgWM70EZOSvbCMKs1QznMRJKrct0XuHOBYqCk3XqOKtSBGIpDou2) {
            this.boZncMwfbKhn9wEZVXOlCQaCALViR3x19GsnEC1EZxndIE2ufazY5HxCE0U58Zvt = a.P89mqD3TKqF18ygPOurbjck3EPcqxgmZ649A3XXayOkNUpvgMJ4Q1cnkfpD040KQ;
            boolean post = this.handler.post(this.Co1rSUoyBoOJ9n0NOgrpxvTYmRPklnETeodUBiQlSBK151C8PCv1Q1Pl4SUa1qxB);
        }
    }

    @SimpleEvent(description = "Distance has gone above the range.")
    public void AboveRange() {
        boolean dispatchEvent = EventDispatcher.dispatchEvent(this, "AboveRange", new Object[0]);
    }

    /* access modifiers changed from: private */
    public boolean wq07duYRO6iFAgWM70EZOSvbCMKs1QznMRJKrct0XuHOBYqCk3XqOKtSBGIpDou() {
        return this.PJTNEFub7t830GnsJOreZR2G4QGerhYk5JzZTaNM1rn2OjCmiPf1GPWMoDtnF4UY || this.opkAxsBiNe4U2WnUIj3h2psrvR65Yw7R3K1A4XT1tnHgd80YyvpOyialIyu2UQYR || this.PW8gZZwgOCTWcD2kHUmkv6AgL0mFh4d5ZW9zStIiy43FwfJpRxeUshErA0Pq6Vc5;
    }

    public void onDelete() {
        this.handler.removeCallbacks(this.Co1rSUoyBoOJ9n0NOgrpxvTYmRPklnETeodUBiQlSBK151C8PCv1Q1Pl4SUa1qxB);
        super.onDelete();
    }
}
