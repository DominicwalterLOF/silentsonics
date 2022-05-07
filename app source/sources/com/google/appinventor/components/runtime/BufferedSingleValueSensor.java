package com.google.appinventor.components.runtime;

import android.hardware.SensorEvent;
import com.google.appinventor.components.annotations.SimpleObject;

@SimpleObject
public abstract class BufferedSingleValueSensor extends SingleValueSensor {
    private a hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BufferedSingleValueSensor(ComponentContainer componentContainer, int i, int i2) {
        super(componentContainer.$form(), i);
        a aVar;
        new a(this, i2, (byte) 0);
        this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME = aVar;
    }

    public void onSensorChanged(SensorEvent sensorEvent) {
        SensorEvent sensorEvent2 = sensorEvent;
        if (this.enabled && sensorEvent2.sensor.getType() == this.sensorType) {
            float[] fArr = sensorEvent2.values;
            a aVar = this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME;
            Float valueOf = Float.valueOf(fArr[0]);
            a aVar2 = aVar;
            a aVar3 = aVar2;
            Float[] fArr2 = aVar2.f53hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME;
            a aVar4 = aVar3;
            int i = aVar4.Co1rSUoyBoOJ9n0NOgrpxvTYmRPklnETeodUBiQlSBK151C8PCv1Q1Pl4SUa1qxB;
            int i2 = i + 1;
            aVar4.Co1rSUoyBoOJ9n0NOgrpxvTYmRPklnETeodUBiQlSBK151C8PCv1Q1Pl4SUa1qxB = i2;
            fArr2[i] = valueOf;
            if (aVar3.Co1rSUoyBoOJ9n0NOgrpxvTYmRPklnETeodUBiQlSBK151C8PCv1Q1Pl4SUa1qxB == aVar3.f53hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.length) {
                aVar3.Co1rSUoyBoOJ9n0NOgrpxvTYmRPklnETeodUBiQlSBK151C8PCv1Q1Pl4SUa1qxB = 0;
            }
            super.onSensorChanged(sensorEvent2);
        }
    }

    /* access modifiers changed from: protected */
    public float getAverageValue() {
        double d;
        a aVar = this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME;
        double d2 = 0.0d;
        int i = 0;
        for (int i2 = 0; i2 < aVar.f53hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.length; i2++) {
            if (aVar.f53hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME[i2] != null) {
                d2 += (double) aVar.f53hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME[i2].floatValue();
                i++;
            }
        }
        if (i == 0) {
            d = d2;
        } else {
            d = d2 / ((double) i);
        }
        return (float) d;
    }

    class a {
        int Co1rSUoyBoOJ9n0NOgrpxvTYmRPklnETeodUBiQlSBK151C8PCv1Q1Pl4SUa1qxB;
        private /* synthetic */ BufferedSingleValueSensor hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME;

        /* renamed from: hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME  reason: collision with other field name */
        Float[] f53hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME;

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        /* synthetic */ a(BufferedSingleValueSensor bufferedSingleValueSensor, int i, byte b) {
            this(bufferedSingleValueSensor, i);
            byte b2 = b;
        }

        private a(BufferedSingleValueSensor bufferedSingleValueSensor, int i) {
            this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME = bufferedSingleValueSensor;
            this.f53hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME = new Float[i];
            this.Co1rSUoyBoOJ9n0NOgrpxvTYmRPklnETeodUBiQlSBK151C8PCv1Q1Pl4SUa1qxB = 0;
        }
    }
}
