package edu.mit.appinventor.ble;

import com.google.appinventor.components.annotations.DesignerProperty;
import com.google.appinventor.components.annotations.SimpleObject;
import com.google.appinventor.components.annotations.SimpleProperty;
import com.google.appinventor.components.runtime.AndroidNonvisibleComponent;
import com.google.appinventor.components.runtime.Form;
import edu.mit.appinventor.ble.BluetoothLE;
import java.util.UUID;

@SimpleObject
public class BLEExtension extends AndroidNonvisibleComponent implements BluetoothLE.BluetoothConnectionListener, BLEDevice {
    private BluetoothLE bleConnection = null;
    private UUID uuid = UUID.fromString("00000000-0000-0000-0000-000000000000");

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    protected BLEExtension(Form form) {
        super(form);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    protected BLEExtension(Form form, UUID serviceUuid) {
        super(form);
        this.uuid = serviceUuid;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    protected BLEExtension(Form form, String str) {
        super(form);
        StringBuilder sb;
        String serviceUuid = str;
        if (serviceUuid.length() == 4) {
            new StringBuilder();
            serviceUuid = sb.append("0000").append(serviceUuid).append(BLEUtil.BLUETOOTH_BASE_UUID_SUFFIX).toString();
        }
        this.uuid = UUID.fromString(serviceUuid.toUpperCase());
    }

    @DesignerProperty(editorType = "component:edu.mit.appinventor.ble.BluetoothLE")
    @SimpleProperty
    public void BluetoothDevice(BluetoothLE bluetoothLE) {
        BluetoothLE bluetoothLE2 = bluetoothLE;
        if (this.bleConnection != null) {
            this.bleConnection.removeConnectionListener(this);
        }
        this.bleConnection = bluetoothLE2;
        if (this.bleConnection != null) {
            this.bleConnection.addConnectionListener(this);
        }
    }

    @SimpleProperty
    public BluetoothLE BluetoothDevice() {
        return this.bleConnection;
    }

    @SimpleProperty
    public boolean IsSupported() {
        if (isConnected()) {
            return this.bleConnection.isServicePublished(this.uuid.toString());
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean isConnected() {
        return this.bleConnection != null && this.bleConnection.IsDeviceConnected();
    }

    public void onConnected(BluetoothLE bleConnection2) {
    }

    public void onDisconnected(BluetoothLE bleConnection2) {
    }

    public UUID GetBroadcastUUID() {
        return this.uuid;
    }
}
