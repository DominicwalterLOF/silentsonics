package com.google.appinventor.components.runtime;

import android.content.Context;
import android.content.SharedPreferences;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.util.Log;
import com.google.appinventor.components.annotations.DesignerComponent;
import com.google.appinventor.components.annotations.DesignerProperty;
import com.google.appinventor.components.annotations.PropertyCategory;
import com.google.appinventor.components.annotations.SimpleEvent;
import com.google.appinventor.components.annotations.SimpleFunction;
import com.google.appinventor.components.annotations.SimpleObject;
import com.google.appinventor.components.annotations.SimpleProperty;
import com.google.appinventor.components.common.ComponentCategory;
import com.shaded.fasterxml.jackson.core.util.BufferRecycler;

@SimpleObject
@DesignerComponent(category = ComponentCategory.SENSORS, description = "A Component that acts like a Pedometer. It senses motion via the Accerleromter and attempts to determine if a step has been taken. Using a configurable stride length, it can estimate the distance traveled as well. ", iconName = "images/pedometer.png", nonVisible = true, version = 3)
public class Pedometer extends AndroidNonvisibleComponent implements SensorEventListener, Component, Deleteable {
    private long Co1rSUoyBoOJ9n0NOgrpxvTYmRPklnETeodUBiQlSBK151C8PCv1Q1Pl4SUa1qxB = 0;

    /* renamed from: Co1rSUoyBoOJ9n0NOgrpxvTYmRPklnETeodUBiQlSBK151C8PCv1Q1Pl4SUa1qxB  reason: collision with other field name */
    private float[] f231Co1rSUoyBoOJ9n0NOgrpxvTYmRPklnETeodUBiQlSBK151C8PCv1Q1Pl4SUa1qxB = new float[10];
    private int G7Lxwqvaa0zcPMEYmgjECqcap18lY2TYRMrZOi1cD4z0oU809LnjVuckWEr78wl = 0;
    private boolean I88voynnB6lCbi2eFsNA2DcXYsTa46aEiMaovSB2sEx9V3gZP1qdgaJzEiYc8qjH = false;
    private boolean P89mqD3TKqF18ygPOurbjck3EPcqxgmZ649A3XXayOkNUpvgMJ4Q1cnkfpD040KQ = true;
    private float PJTNEFub7t830GnsJOreZR2G4QGerhYk5JzZTaNM1rn2OjCmiPf1GPWMoDtnF4UY = 0.73f;
    private int Qo6hTp4u7pOnq5WtKfNdQM86FuI5n4weAQCyrgAeimDlOrP2dP7U8KFwjrDIHyb = 0;
    private int RbYVQzNQ0N2UrAmoggkhMTlc54LPYDcOUMcpFAK7czpNLpbMtrjfrFIT6QATuiqT = 0;
    private int TcZoKXUijRhvOFm1gZ0ppEfXWxECqlUNNvncSPIfT3ZrTDcozo05OAb21mkMXciT = BufferRecycler.DEFAULT_WRITE_CONCAT_BUFFER_LEN;
    private boolean boZncMwfbKhn9wEZVXOlCQaCALViR3x19GsnEC1EZxndIE2ufazY5HxCE0U58Zvt = true;
    private final Context context;
    private int hOhK0kjjpreklHpzajOh4zpZ0hDhUAnmvbGmmElshoJmuxQNkJo9K2Sh2YQvTJN = 0;
    private long[] hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME = new long[2];
    private long mBLKdPlRolYfdtud5Z8giGWyhURWoCw9yHsOv08fUnIBAM4MuKAWkHVD8nEhBmIT = 0;
    private float opkAxsBiNe4U2WnUIj3h2psrvR65Yw7R3K1A4XT1tnHgd80YyvpOyialIyu2UQYR = 0.0f;
    private int pixa37in9tdgjNQb2jpfjxTaBGtatW1GnEvNM302mGQljyvLBwDosTGoRPcRGYok = 0;
    private float[] qPeHJnCLP0dAOwDPeFIn82vcSIsCMh6KFFn3o4kyIe0RhQKOQXDeyY2LFwPu2GbE = new float[100];
    private long sSQuIBUVrx5rcdxHqHgqC6bPLuuDnxnBF7e7BJeOxmxr54l6ArzFZvC3SGBTuUdt = 0;
    private final SensorManager sensorManager;
    private boolean t2ckruxpPDflxUi8XRIoUkd3SPCNiaP1fIl9I8fgeRcif548vLOXCzLwJMVgcQrg = false;
    private float vB3WjEtL56PUGm0spJ96S19MI1O4vPR6yju8tUYcKrC4atk0AV5GbVcHQNB7BlIK = 0.0f;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public Pedometer(com.google.appinventor.components.runtime.ComponentContainer r10) {
        /*
            r9 = this;
            r1 = r9
            r2 = r10
            r3 = r1
            r4 = r2
            com.google.appinventor.components.runtime.Form r4 = r4.$form()
            r3.<init>(r4)
            r3 = r1
            r4 = 2000(0x7d0, float:2.803E-42)
            r3.TcZoKXUijRhvOFm1gZ0ppEfXWxECqlUNNvncSPIfT3ZrTDcozo05OAb21mkMXciT = r4
            r3 = r1
            r4 = 0
            r3.pixa37in9tdgjNQb2jpfjxTaBGtatW1GnEvNM302mGQljyvLBwDosTGoRPcRGYok = r4
            r3 = r1
            r4 = 0
            r3.G7Lxwqvaa0zcPMEYmgjECqcap18lY2TYRMrZOi1cD4z0oU809LnjVuckWEr78wl = r4
            r3 = r1
            r4 = 0
            r3.Qo6hTp4u7pOnq5WtKfNdQM86FuI5n4weAQCyrgAeimDlOrP2dP7U8KFwjrDIHyb = r4
            r3 = r1
            r4 = 0
            r3.hOhK0kjjpreklHpzajOh4zpZ0hDhUAnmvbGmmElshoJmuxQNkJo9K2Sh2YQvTJN = r4
            r3 = r1
            r4 = 0
            r3.vB3WjEtL56PUGm0spJ96S19MI1O4vPR6yju8tUYcKrC4atk0AV5GbVcHQNB7BlIK = r4
            r3 = r1
            r4 = 100
            float[] r4 = new float[r4]
            r3.qPeHJnCLP0dAOwDPeFIn82vcSIsCMh6KFFn3o4kyIe0RhQKOQXDeyY2LFwPu2GbE = r4
            r3 = r1
            r4 = 1060823368(0x3f3ae148, float:0.73)
            r3.PJTNEFub7t830GnsJOreZR2G4QGerhYk5JzZTaNM1rn2OjCmiPf1GPWMoDtnF4UY = r4
            r3 = r1
            r4 = 0
            r3.opkAxsBiNe4U2WnUIj3h2psrvR65Yw7R3K1A4XT1tnHgd80YyvpOyialIyu2UQYR = r4
            r3 = r1
            r4 = 2
            long[] r4 = new long[r4]
            r3.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME = r4
            r3 = r1
            r4 = 0
            r3.Co1rSUoyBoOJ9n0NOgrpxvTYmRPklnETeodUBiQlSBK151C8PCv1Q1Pl4SUa1qxB = r4
            r3 = r1
            r4 = 0
            r3.sSQuIBUVrx5rcdxHqHgqC6bPLuuDnxnBF7e7BJeOxmxr54l6ArzFZvC3SGBTuUdt = r4
            r3 = r1
            r4 = 0
            r3.mBLKdPlRolYfdtud5Z8giGWyhURWoCw9yHsOv08fUnIBAM4MuKAWkHVD8nEhBmIT = r4
            r3 = r1
            r4 = 0
            r3.t2ckruxpPDflxUi8XRIoUkd3SPCNiaP1fIl9I8fgeRcif548vLOXCzLwJMVgcQrg = r4
            r3 = r1
            r4 = 0
            r3.I88voynnB6lCbi2eFsNA2DcXYsTa46aEiMaovSB2sEx9V3gZP1qdgaJzEiYc8qjH = r4
            r3 = r1
            r4 = 1
            r3.boZncMwfbKhn9wEZVXOlCQaCALViR3x19GsnEC1EZxndIE2ufazY5HxCE0U58Zvt = r4
            r3 = r1
            r4 = 1
            r3.P89mqD3TKqF18ygPOurbjck3EPcqxgmZ649A3XXayOkNUpvgMJ4Q1cnkfpD040KQ = r4
            r3 = r1
            r4 = 10
            float[] r4 = new float[r4]
            r3.f231Co1rSUoyBoOJ9n0NOgrpxvTYmRPklnETeodUBiQlSBK151C8PCv1Q1Pl4SUa1qxB = r4
            r3 = r1
            r4 = 0
            r3.RbYVQzNQ0N2UrAmoggkhMTlc54LPYDcOUMcpFAK7czpNLpbMtrjfrFIT6QATuiqT = r4
            r3 = r1
            r4 = r2
            android.app.Activity r4 = r4.$context()
            r3.context = r4
            r3 = r1
            r4 = 0
            r3.pixa37in9tdgjNQb2jpfjxTaBGtatW1GnEvNM302mGQljyvLBwDosTGoRPcRGYok = r4
            r3 = r1
            r4 = 0
            r3.I88voynnB6lCbi2eFsNA2DcXYsTa46aEiMaovSB2sEx9V3gZP1qdgaJzEiYc8qjH = r4
            r3 = r1
            r4 = 0
            r3.Qo6hTp4u7pOnq5WtKfNdQM86FuI5n4weAQCyrgAeimDlOrP2dP7U8KFwjrDIHyb = r4
            r3 = r1
            r4 = 0
            r3.hOhK0kjjpreklHpzajOh4zpZ0hDhUAnmvbGmmElshoJmuxQNkJo9K2Sh2YQvTJN = r4
            r3 = r1
            r4 = 1
            r3.t2ckruxpPDflxUi8XRIoUkd3SPCNiaP1fIl9I8fgeRcif548vLOXCzLwJMVgcQrg = r4
            r3 = r1
            r4 = 0
            r3.vB3WjEtL56PUGm0spJ96S19MI1O4vPR6yju8tUYcKrC4atk0AV5GbVcHQNB7BlIK = r4
            r3 = r1
            r8 = r3
            r3 = r8
            r4 = r8
            android.content.Context r4 = r4.context
            java.lang.String r5 = "sensor"
            java.lang.Object r4 = r4.getSystemService(r5)
            android.hardware.SensorManager r4 = (android.hardware.SensorManager) r4
            r3.sensorManager = r4
            r3 = r1
            android.content.Context r3 = r3.context
            java.lang.String r4 = "PedometerPrefs"
            r5 = 0
            android.content.SharedPreferences r3 = r3.getSharedPreferences(r4, r5)
            r2 = r3
            r3 = r1
            r4 = r2
            java.lang.String r5 = "Pedometer.stridelength"
            r6 = 1060823368(0x3f3ae148, float:0.73)
            float r4 = r4.getFloat(r5, r6)
            r3.PJTNEFub7t830GnsJOreZR2G4QGerhYk5JzZTaNM1rn2OjCmiPf1GPWMoDtnF4UY = r4
            r3 = r1
            r4 = r2
            java.lang.String r5 = "Pedometer.distance"
            r6 = 0
            float r4 = r4.getFloat(r5, r6)
            r3.opkAxsBiNe4U2WnUIj3h2psrvR65Yw7R3K1A4XT1tnHgd80YyvpOyialIyu2UQYR = r4
            r3 = r1
            r4 = r2
            java.lang.String r5 = "Pedometer.prevStepCount"
            r6 = 0
            int r4 = r4.getInt(r5, r6)
            r3.hOhK0kjjpreklHpzajOh4zpZ0hDhUAnmvbGmmElshoJmuxQNkJo9K2Sh2YQvTJN = r4
            r3 = r1
            r4 = r2
            java.lang.String r5 = "Pedometer.clockTime"
            r6 = 0
            long r4 = r4.getLong(r5, r6)
            r3.mBLKdPlRolYfdtud5Z8giGWyhURWoCw9yHsOv08fUnIBAM4MuKAWkHVD8nEhBmIT = r4
            r3 = r1
            r8 = r3
            r3 = r8
            r4 = r8
            int r4 = r4.hOhK0kjjpreklHpzajOh4zpZ0hDhUAnmvbGmmElshoJmuxQNkJo9K2Sh2YQvTJN
            r3.Qo6hTp4u7pOnq5WtKfNdQM86FuI5n4weAQCyrgAeimDlOrP2dP7U8KFwjrDIHyb = r4
            r3 = r1
            long r4 = java.lang.System.currentTimeMillis()
            r3.sSQuIBUVrx5rcdxHqHgqC6bPLuuDnxnBF7e7BJeOxmxr54l6ArzFZvC3SGBTuUdt = r4
            java.lang.String r3 = "Pedometer"
            java.lang.String r4 = "Pedometer Created"
            int r3 = android.util.Log.d(r3, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.appinventor.components.runtime.Pedometer.<init>(com.google.appinventor.components.runtime.ComponentContainer):void");
    }

    @SimpleFunction(description = "Start counting steps")
    public void Start() {
        if (this.P89mqD3TKqF18ygPOurbjck3EPcqxgmZ649A3XXayOkNUpvgMJ4Q1cnkfpD040KQ) {
            this.P89mqD3TKqF18ygPOurbjck3EPcqxgmZ649A3XXayOkNUpvgMJ4Q1cnkfpD040KQ = false;
            boolean registerListener = this.sensorManager.registerListener(this, this.sensorManager.getSensorList(1).get(0), 0);
            this.sSQuIBUVrx5rcdxHqHgqC6bPLuuDnxnBF7e7BJeOxmxr54l6ArzFZvC3SGBTuUdt = System.currentTimeMillis();
        }
    }

    @SimpleFunction(description = "Stop counting steps")
    public void Stop() {
        if (!this.P89mqD3TKqF18ygPOurbjck3EPcqxgmZ649A3XXayOkNUpvgMJ4Q1cnkfpD040KQ) {
            this.P89mqD3TKqF18ygPOurbjck3EPcqxgmZ649A3XXayOkNUpvgMJ4Q1cnkfpD040KQ = true;
            this.sensorManager.unregisterListener(this);
            int d = Log.d("Pedometer", "Unregistered listener on pause");
            this.mBLKdPlRolYfdtud5Z8giGWyhURWoCw9yHsOv08fUnIBAM4MuKAWkHVD8nEhBmIT += System.currentTimeMillis() - this.sSQuIBUVrx5rcdxHqHgqC6bPLuuDnxnBF7e7BJeOxmxr54l6ArzFZvC3SGBTuUdt;
        }
    }

    @SimpleFunction(description = "Resets the step counter, distance measure and time running.")
    public void Reset() {
        this.Qo6hTp4u7pOnq5WtKfNdQM86FuI5n4weAQCyrgAeimDlOrP2dP7U8KFwjrDIHyb = 0;
        this.hOhK0kjjpreklHpzajOh4zpZ0hDhUAnmvbGmmElshoJmuxQNkJo9K2Sh2YQvTJN = 0;
        this.opkAxsBiNe4U2WnUIj3h2psrvR65Yw7R3K1A4XT1tnHgd80YyvpOyialIyu2UQYR = 0.0f;
        this.mBLKdPlRolYfdtud5Z8giGWyhURWoCw9yHsOv08fUnIBAM4MuKAWkHVD8nEhBmIT = 0;
        this.sSQuIBUVrx5rcdxHqHgqC6bPLuuDnxnBF7e7BJeOxmxr54l6ArzFZvC3SGBTuUdt = System.currentTimeMillis();
    }

    @Deprecated
    @SimpleFunction(description = "Resumes counting, synonym of Start.")
    public void Resume() {
        Start();
    }

    @Deprecated
    @SimpleFunction(description = "Pause counting of steps and distance.")
    public void Pause() {
        Stop();
    }

    @SimpleFunction(description = "Saves the pedometer state to the phone. Permits permits accumulation of steps and distance between invocations of an App that uses the pedometer. Different Apps will have their own saved state.")
    public void Save() {
        SharedPreferences.Editor edit = this.context.getSharedPreferences("PedometerPrefs", 0).edit();
        SharedPreferences.Editor editor = edit;
        SharedPreferences.Editor putFloat = edit.putFloat("Pedometer.stridelength", this.PJTNEFub7t830GnsJOreZR2G4QGerhYk5JzZTaNM1rn2OjCmiPf1GPWMoDtnF4UY);
        SharedPreferences.Editor putFloat2 = editor.putFloat("Pedometer.distance", this.opkAxsBiNe4U2WnUIj3h2psrvR65Yw7R3K1A4XT1tnHgd80YyvpOyialIyu2UQYR);
        SharedPreferences.Editor putInt = editor.putInt("Pedometer.prevStepCount", this.hOhK0kjjpreklHpzajOh4zpZ0hDhUAnmvbGmmElshoJmuxQNkJo9K2Sh2YQvTJN);
        if (this.P89mqD3TKqF18ygPOurbjck3EPcqxgmZ649A3XXayOkNUpvgMJ4Q1cnkfpD040KQ) {
            SharedPreferences.Editor putLong = editor.putLong("Pedometer.clockTime", this.mBLKdPlRolYfdtud5Z8giGWyhURWoCw9yHsOv08fUnIBAM4MuKAWkHVD8nEhBmIT);
        } else {
            SharedPreferences.Editor putLong2 = editor.putLong("Pedometer.clockTime", this.mBLKdPlRolYfdtud5Z8giGWyhURWoCw9yHsOv08fUnIBAM4MuKAWkHVD8nEhBmIT + (System.currentTimeMillis() - this.sSQuIBUVrx5rcdxHqHgqC6bPLuuDnxnBF7e7BJeOxmxr54l6ArzFZvC3SGBTuUdt));
        }
        SharedPreferences.Editor putLong3 = editor.putLong("Pedometer.closeTime", System.currentTimeMillis());
        boolean commit = editor.commit();
        int d = Log.d("Pedometer", "Pedometer state saved.");
    }

    @SimpleEvent(description = "This event is run when a raw step is detected")
    public void SimpleStep(int i, float f) {
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(i);
        Object[] objArr2 = objArr;
        objArr2[1] = Float.valueOf(f);
        boolean dispatchEvent = EventDispatcher.dispatchEvent(this, "SimpleStep", objArr2);
    }

    @SimpleEvent(description = "This event is run when a walking step is detected. A walking step is a step that appears to be involved in forward motion.")
    public void WalkStep(int i, float f) {
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(i);
        Object[] objArr2 = objArr;
        objArr2[1] = Float.valueOf(f);
        boolean dispatchEvent = EventDispatcher.dispatchEvent(this, "WalkStep", objArr2);
    }

    @DesignerProperty(defaultValue = "0.73", editorType = "non_negative_float")
    @SimpleProperty(category = PropertyCategory.BEHAVIOR, description = "Set the average stride length in meters.")
    public void StrideLength(float f) {
        float f2 = f;
        this.PJTNEFub7t830GnsJOreZR2G4QGerhYk5JzZTaNM1rn2OjCmiPf1GPWMoDtnF4UY = f2;
    }

    @SimpleProperty
    public float StrideLength() {
        return this.PJTNEFub7t830GnsJOreZR2G4QGerhYk5JzZTaNM1rn2OjCmiPf1GPWMoDtnF4UY;
    }

    @DesignerProperty(defaultValue = "2000", editorType = "non_negative_integer")
    @SimpleProperty(category = PropertyCategory.BEHAVIOR, description = "The duration in milliseconds of idleness (no steps detected) after which to go into a \"stopped\" state")
    public void StopDetectionTimeout(int i) {
        int i2 = i;
        this.TcZoKXUijRhvOFm1gZ0ppEfXWxECqlUNNvncSPIfT3ZrTDcozo05OAb21mkMXciT = i2;
    }

    @SimpleProperty
    public int StopDetectionTimeout() {
        return this.TcZoKXUijRhvOFm1gZ0ppEfXWxECqlUNNvncSPIfT3ZrTDcozo05OAb21mkMXciT;
    }

    @SimpleProperty(category = PropertyCategory.BEHAVIOR, description = "The approximate distance traveled in meters.")
    public float Distance() {
        return this.opkAxsBiNe4U2WnUIj3h2psrvR65Yw7R3K1A4XT1tnHgd80YyvpOyialIyu2UQYR;
    }

    @SimpleProperty(category = PropertyCategory.BEHAVIOR, description = "Time elapsed in milliseconds since the pedometer was started.")
    public long ElapsedTime() {
        if (this.P89mqD3TKqF18ygPOurbjck3EPcqxgmZ649A3XXayOkNUpvgMJ4Q1cnkfpD040KQ) {
            return this.mBLKdPlRolYfdtud5Z8giGWyhURWoCw9yHsOv08fUnIBAM4MuKAWkHVD8nEhBmIT;
        }
        return this.mBLKdPlRolYfdtud5Z8giGWyhURWoCw9yHsOv08fUnIBAM4MuKAWkHVD8nEhBmIT + (System.currentTimeMillis() - this.sSQuIBUVrx5rcdxHqHgqC6bPLuuDnxnBF7e7BJeOxmxr54l6ArzFZvC3SGBTuUdt);
    }

    @SimpleProperty(category = PropertyCategory.BEHAVIOR, description = "The number of simple steps taken since the pedometer has started.")
    public int SimpleSteps() {
        return this.hOhK0kjjpreklHpzajOh4zpZ0hDhUAnmvbGmmElshoJmuxQNkJo9K2Sh2YQvTJN;
    }

    @SimpleProperty(category = PropertyCategory.BEHAVIOR, description = "the number of walk steps taken since the pedometer has started.")
    public int WalkSteps() {
        return this.Qo6hTp4u7pOnq5WtKfNdQM86FuI5n4weAQCyrgAeimDlOrP2dP7U8KFwjrDIHyb;
    }

    public void onAccuracyChanged(Sensor sensor, int i) {
        Sensor sensor2 = sensor;
        int i2 = i;
        int d = Log.d("Pedometer", "Accelerometer accuracy changed.");
    }

    public void onSensorChanged(SensorEvent sensorEvent) {
        boolean z;
        boolean z2;
        boolean z3;
        SensorEvent sensorEvent2 = sensorEvent;
        if (sensorEvent2.sensor.getType() == 1) {
            float[] fArr = sensorEvent2.values;
            float f = 0.0f;
            int length = fArr.length;
            for (int i = 0; i < length; i++) {
                float f2 = fArr[i];
                f += f2 * f2;
            }
            int i2 = (this.pixa37in9tdgjNQb2jpfjxTaBGtatW1GnEvNM302mGQljyvLBwDosTGoRPcRGYok + 50) % 100;
            if (this.I88voynnB6lCbi2eFsNA2DcXYsTa46aEiMaovSB2sEx9V3gZP1qdgaJzEiYc8qjH) {
                int i3 = (this.pixa37in9tdgjNQb2jpfjxTaBGtatW1GnEvNM302mGQljyvLBwDosTGoRPcRGYok + 50) % 100;
                int i4 = 0;
                while (true) {
                    if (i4 < 100) {
                        if (i4 != i3 && this.qPeHJnCLP0dAOwDPeFIn82vcSIsCMh6KFFn3o4kyIe0RhQKOQXDeyY2LFwPu2GbE[i4] > this.qPeHJnCLP0dAOwDPeFIn82vcSIsCMh6KFFn3o4kyIe0RhQKOQXDeyY2LFwPu2GbE[i3]) {
                            z2 = false;
                            break;
                        }
                        i4++;
                    } else {
                        z2 = true;
                        break;
                    }
                }
                if (z2 && this.t2ckruxpPDflxUi8XRIoUkd3SPCNiaP1fIl9I8fgeRcif548vLOXCzLwJMVgcQrg && this.qPeHJnCLP0dAOwDPeFIn82vcSIsCMh6KFFn3o4kyIe0RhQKOQXDeyY2LFwPu2GbE[i2] - this.vB3WjEtL56PUGm0spJ96S19MI1O4vPR6yju8tUYcKrC4atk0AV5GbVcHQNB7BlIK > 40.0f) {
                    long currentTimeMillis = System.currentTimeMillis();
                    this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME[this.G7Lxwqvaa0zcPMEYmgjECqcap18lY2TYRMrZOi1cD4z0oU809LnjVuckWEr78wl] = currentTimeMillis - this.Co1rSUoyBoOJ9n0NOgrpxvTYmRPklnETeodUBiQlSBK151C8PCv1Q1Pl4SUa1qxB;
                    this.G7Lxwqvaa0zcPMEYmgjECqcap18lY2TYRMrZOi1cD4z0oU809LnjVuckWEr78wl = (this.G7Lxwqvaa0zcPMEYmgjECqcap18lY2TYRMrZOi1cD4z0oU809LnjVuckWEr78wl + 1) % 2;
                    this.Co1rSUoyBoOJ9n0NOgrpxvTYmRPklnETeodUBiQlSBK151C8PCv1Q1Pl4SUa1qxB = currentTimeMillis;
                    float f3 = 0.0f;
                    int i5 = 0;
                    long[] jArr = this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME;
                    long[] jArr2 = jArr;
                    int length2 = jArr.length;
                    for (int i6 = 0; i6 < length2; i6++) {
                        long j = jArr2[i6];
                        long j2 = j;
                        if (j > 0) {
                            i5++;
                            f3 += (float) j2;
                        }
                    }
                    float f4 = f3 / ((float) i5);
                    long[] jArr3 = this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME;
                    long[] jArr4 = jArr3;
                    int length3 = jArr3.length;
                    int i7 = 0;
                    while (true) {
                        if (i7 >= length3) {
                            z3 = true;
                            break;
                        } else if (Math.abs(((float) jArr4[i7]) - f4) > 250.0f) {
                            z3 = false;
                            break;
                        } else {
                            i7++;
                        }
                    }
                    if (z3) {
                        if (this.boZncMwfbKhn9wEZVXOlCQaCALViR3x19GsnEC1EZxndIE2ufazY5HxCE0U58Zvt) {
                            this.Qo6hTp4u7pOnq5WtKfNdQM86FuI5n4weAQCyrgAeimDlOrP2dP7U8KFwjrDIHyb += 2;
                            this.opkAxsBiNe4U2WnUIj3h2psrvR65Yw7R3K1A4XT1tnHgd80YyvpOyialIyu2UQYR += this.PJTNEFub7t830GnsJOreZR2G4QGerhYk5JzZTaNM1rn2OjCmiPf1GPWMoDtnF4UY * 2.0f;
                            this.boZncMwfbKhn9wEZVXOlCQaCALViR3x19GsnEC1EZxndIE2ufazY5HxCE0U58Zvt = false;
                        }
                        this.Qo6hTp4u7pOnq5WtKfNdQM86FuI5n4weAQCyrgAeimDlOrP2dP7U8KFwjrDIHyb++;
                        WalkStep(this.Qo6hTp4u7pOnq5WtKfNdQM86FuI5n4weAQCyrgAeimDlOrP2dP7U8KFwjrDIHyb, this.opkAxsBiNe4U2WnUIj3h2psrvR65Yw7R3K1A4XT1tnHgd80YyvpOyialIyu2UQYR);
                        this.opkAxsBiNe4U2WnUIj3h2psrvR65Yw7R3K1A4XT1tnHgd80YyvpOyialIyu2UQYR += this.PJTNEFub7t830GnsJOreZR2G4QGerhYk5JzZTaNM1rn2OjCmiPf1GPWMoDtnF4UY;
                    } else {
                        this.boZncMwfbKhn9wEZVXOlCQaCALViR3x19GsnEC1EZxndIE2ufazY5HxCE0U58Zvt = true;
                    }
                    this.hOhK0kjjpreklHpzajOh4zpZ0hDhUAnmvbGmmElshoJmuxQNkJo9K2Sh2YQvTJN++;
                    SimpleStep(this.hOhK0kjjpreklHpzajOh4zpZ0hDhUAnmvbGmmElshoJmuxQNkJo9K2Sh2YQvTJN, this.opkAxsBiNe4U2WnUIj3h2psrvR65Yw7R3K1A4XT1tnHgd80YyvpOyialIyu2UQYR);
                    this.t2ckruxpPDflxUi8XRIoUkd3SPCNiaP1fIl9I8fgeRcif548vLOXCzLwJMVgcQrg = false;
                }
            }
            if (this.I88voynnB6lCbi2eFsNA2DcXYsTa46aEiMaovSB2sEx9V3gZP1qdgaJzEiYc8qjH) {
                int i8 = (this.pixa37in9tdgjNQb2jpfjxTaBGtatW1GnEvNM302mGQljyvLBwDosTGoRPcRGYok + 50) % 100;
                int i9 = 0;
                while (true) {
                    if (i9 < 100) {
                        if (i9 != i8 && this.qPeHJnCLP0dAOwDPeFIn82vcSIsCMh6KFFn3o4kyIe0RhQKOQXDeyY2LFwPu2GbE[i9] < this.qPeHJnCLP0dAOwDPeFIn82vcSIsCMh6KFFn3o4kyIe0RhQKOQXDeyY2LFwPu2GbE[i8]) {
                            z = false;
                            break;
                        }
                        i9++;
                    } else {
                        z = true;
                        break;
                    }
                }
                if (z) {
                    this.t2ckruxpPDflxUi8XRIoUkd3SPCNiaP1fIl9I8fgeRcif548vLOXCzLwJMVgcQrg = true;
                    this.vB3WjEtL56PUGm0spJ96S19MI1O4vPR6yju8tUYcKrC4atk0AV5GbVcHQNB7BlIK = this.qPeHJnCLP0dAOwDPeFIn82vcSIsCMh6KFFn3o4kyIe0RhQKOQXDeyY2LFwPu2GbE[i2];
                }
            }
            this.f231Co1rSUoyBoOJ9n0NOgrpxvTYmRPklnETeodUBiQlSBK151C8PCv1Q1Pl4SUa1qxB[this.RbYVQzNQ0N2UrAmoggkhMTlc54LPYDcOUMcpFAK7czpNLpbMtrjfrFIT6QATuiqT] = f;
            this.RbYVQzNQ0N2UrAmoggkhMTlc54LPYDcOUMcpFAK7czpNLpbMtrjfrFIT6QATuiqT = (this.RbYVQzNQ0N2UrAmoggkhMTlc54LPYDcOUMcpFAK7czpNLpbMtrjfrFIT6QATuiqT + 1) % this.f231Co1rSUoyBoOJ9n0NOgrpxvTYmRPklnETeodUBiQlSBK151C8PCv1Q1Pl4SUa1qxB.length;
            this.qPeHJnCLP0dAOwDPeFIn82vcSIsCMh6KFFn3o4kyIe0RhQKOQXDeyY2LFwPu2GbE[this.pixa37in9tdgjNQb2jpfjxTaBGtatW1GnEvNM302mGQljyvLBwDosTGoRPcRGYok] = 0.0f;
            float[] fArr2 = this.f231Co1rSUoyBoOJ9n0NOgrpxvTYmRPklnETeodUBiQlSBK151C8PCv1Q1Pl4SUa1qxB;
            float[] fArr3 = fArr2;
            int length4 = fArr2.length;
            for (int i10 = 0; i10 < length4; i10++) {
                float f5 = fArr3[i10];
                float[] fArr4 = this.qPeHJnCLP0dAOwDPeFIn82vcSIsCMh6KFFn3o4kyIe0RhQKOQXDeyY2LFwPu2GbE;
                int i11 = this.pixa37in9tdgjNQb2jpfjxTaBGtatW1GnEvNM302mGQljyvLBwDosTGoRPcRGYok;
                fArr4[i11] = fArr4[i11] + f5;
            }
            float[] fArr5 = this.qPeHJnCLP0dAOwDPeFIn82vcSIsCMh6KFFn3o4kyIe0RhQKOQXDeyY2LFwPu2GbE;
            int i12 = this.pixa37in9tdgjNQb2jpfjxTaBGtatW1GnEvNM302mGQljyvLBwDosTGoRPcRGYok;
            fArr5[i12] = fArr5[i12] / ((float) this.f231Co1rSUoyBoOJ9n0NOgrpxvTYmRPklnETeodUBiQlSBK151C8PCv1Q1Pl4SUa1qxB.length);
            if (this.I88voynnB6lCbi2eFsNA2DcXYsTa46aEiMaovSB2sEx9V3gZP1qdgaJzEiYc8qjH || this.pixa37in9tdgjNQb2jpfjxTaBGtatW1GnEvNM302mGQljyvLBwDosTGoRPcRGYok > 1) {
                int i13 = this.pixa37in9tdgjNQb2jpfjxTaBGtatW1GnEvNM302mGQljyvLBwDosTGoRPcRGYok - 1;
                if (i13 < 0) {
                    i13 += 100;
                }
                float[] fArr6 = this.qPeHJnCLP0dAOwDPeFIn82vcSIsCMh6KFFn3o4kyIe0RhQKOQXDeyY2LFwPu2GbE;
                int i14 = this.pixa37in9tdgjNQb2jpfjxTaBGtatW1GnEvNM302mGQljyvLBwDosTGoRPcRGYok;
                fArr6[i14] = fArr6[i14] + (2.0f * this.qPeHJnCLP0dAOwDPeFIn82vcSIsCMh6KFFn3o4kyIe0RhQKOQXDeyY2LFwPu2GbE[i13]);
                int i15 = i13 - 1;
                if (i15 < 0) {
                    i15 += 100;
                }
                float[] fArr7 = this.qPeHJnCLP0dAOwDPeFIn82vcSIsCMh6KFFn3o4kyIe0RhQKOQXDeyY2LFwPu2GbE;
                int i16 = this.pixa37in9tdgjNQb2jpfjxTaBGtatW1GnEvNM302mGQljyvLBwDosTGoRPcRGYok;
                fArr7[i16] = fArr7[i16] + this.qPeHJnCLP0dAOwDPeFIn82vcSIsCMh6KFFn3o4kyIe0RhQKOQXDeyY2LFwPu2GbE[i15];
                float[] fArr8 = this.qPeHJnCLP0dAOwDPeFIn82vcSIsCMh6KFFn3o4kyIe0RhQKOQXDeyY2LFwPu2GbE;
                int i17 = this.pixa37in9tdgjNQb2jpfjxTaBGtatW1GnEvNM302mGQljyvLBwDosTGoRPcRGYok;
                fArr8[i17] = fArr8[i17] / 4.0f;
            } else if (!this.I88voynnB6lCbi2eFsNA2DcXYsTa46aEiMaovSB2sEx9V3gZP1qdgaJzEiYc8qjH && this.pixa37in9tdgjNQb2jpfjxTaBGtatW1GnEvNM302mGQljyvLBwDosTGoRPcRGYok == 1) {
                this.qPeHJnCLP0dAOwDPeFIn82vcSIsCMh6KFFn3o4kyIe0RhQKOQXDeyY2LFwPu2GbE[1] = (this.qPeHJnCLP0dAOwDPeFIn82vcSIsCMh6KFFn3o4kyIe0RhQKOQXDeyY2LFwPu2GbE[1] + this.qPeHJnCLP0dAOwDPeFIn82vcSIsCMh6KFFn3o4kyIe0RhQKOQXDeyY2LFwPu2GbE[0]) / 2.0f;
            }
            long currentTimeMillis2 = System.currentTimeMillis();
            long j3 = currentTimeMillis2;
            if (currentTimeMillis2 - this.Co1rSUoyBoOJ9n0NOgrpxvTYmRPklnETeodUBiQlSBK151C8PCv1Q1Pl4SUa1qxB > ((long) this.TcZoKXUijRhvOFm1gZ0ppEfXWxECqlUNNvncSPIfT3ZrTDcozo05OAb21mkMXciT)) {
                this.Co1rSUoyBoOJ9n0NOgrpxvTYmRPklnETeodUBiQlSBK151C8PCv1Q1Pl4SUa1qxB = j3;
            }
            if (this.pixa37in9tdgjNQb2jpfjxTaBGtatW1GnEvNM302mGQljyvLBwDosTGoRPcRGYok == 99 && !this.I88voynnB6lCbi2eFsNA2DcXYsTa46aEiMaovSB2sEx9V3gZP1qdgaJzEiYc8qjH) {
                this.I88voynnB6lCbi2eFsNA2DcXYsTa46aEiMaovSB2sEx9V3gZP1qdgaJzEiYc8qjH = true;
            }
            this.pixa37in9tdgjNQb2jpfjxTaBGtatW1GnEvNM302mGQljyvLBwDosTGoRPcRGYok = (this.pixa37in9tdgjNQb2jpfjxTaBGtatW1GnEvNM302mGQljyvLBwDosTGoRPcRGYok + 1) % 100;
        }
    }

    public void onDelete() {
        this.sensorManager.unregisterListener(this);
    }

    @SimpleEvent(description = "deprecated")
    @Deprecated
    public void StartedMoving() {
    }

    @SimpleEvent(description = "deprecated")
    @Deprecated
    public void StoppedMoving() {
    }

    @Deprecated
    @SimpleProperty(category = PropertyCategory.BEHAVIOR)
    public void UseGPS(boolean z) {
    }

    @SimpleEvent(description = "deprecated")
    @Deprecated
    public void CalibrationFailed() {
    }

    @SimpleEvent(description = "deprecated")
    @Deprecated
    public void GPSAvailable() {
    }

    @SimpleEvent(description = "deprecated")
    @Deprecated
    public void GPSLost() {
    }

    @Deprecated
    @SimpleProperty(category = PropertyCategory.BEHAVIOR)
    public void CalibrateStrideLength(boolean z) {
    }

    @Deprecated
    @SimpleProperty(description = "deprecated")
    public boolean CalibrateStrideLength() {
        return false;
    }

    @Deprecated
    @SimpleProperty(description = "deprecated")
    public boolean Moving() {
        return false;
    }
}
