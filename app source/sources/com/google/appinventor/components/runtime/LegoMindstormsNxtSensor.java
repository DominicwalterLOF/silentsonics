package com.google.appinventor.components.runtime;

import com.google.appinventor.components.annotations.PropertyCategory;
import com.google.appinventor.components.annotations.SimpleObject;
import com.google.appinventor.components.annotations.SimpleProperty;
import com.google.appinventor.components.common.NxtSensorPort;

@SimpleObject
public abstract class LegoMindstormsNxtSensor extends LegoMindstormsNxtBase {
    protected NxtSensorPort port;

    public abstract void SensorPort(String str);

    /* access modifiers changed from: protected */
    public abstract void initializeSensor(String str);

    static class a<T> {
        final boolean hqHtvKVLFGgMVMSKZM3hViIxQKdIh8YXfZOV4lmVWV1e2Mndp07BOheWTgPW1jrN;
        final T qPeHJnCLP0dAOwDPeFIn82vcSIsCMh6KFFn3o4kyIe0RhQKOQXDeyY2LFwPu2GbE;

        a(boolean z, T t) {
            this.hqHtvKVLFGgMVMSKZM3hViIxQKdIh8YXfZOV4lmVWV1e2Mndp07BOheWTgPW1jrN = z;
            this.qPeHJnCLP0dAOwDPeFIn82vcSIsCMh6KFFn3o4kyIe0RhQKOQXDeyY2LFwPu2GbE = t;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    protected LegoMindstormsNxtSensor(ComponentContainer componentContainer, String str) {
        super(componentContainer, str);
    }

    @SimpleProperty(category = PropertyCategory.BEHAVIOR, description = "The sensor port that the sensor is connected to.", userVisible = false)
    public String SensorPort() {
        return this.port.toUnderlyingValue();
    }

    /* access modifiers changed from: protected */
    public final void setSensorPort(String str) {
        String str2 = str;
        String str3 = "SensorPort";
        NxtSensorPort fromUnderlyingValue = NxtSensorPort.fromUnderlyingValue(str2);
        NxtSensorPort nxtSensorPort = fromUnderlyingValue;
        if (fromUnderlyingValue == null) {
            this.form.dispatchErrorOccurredEvent(this, str3, 408, str2);
            return;
        }
        this.port = nxtSensorPort;
        if (this.bluetooth != null && this.bluetooth.IsConnected()) {
            initializeSensor(str3);
        }
    }

    public void afterConnect(BluetoothConnectionBase bluetoothConnectionBase) {
        BluetoothConnectionBase bluetoothConnectionBase2 = bluetoothConnectionBase;
        initializeSensor("Connect");
    }
}
