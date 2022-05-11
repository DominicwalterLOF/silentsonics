package edu.mit.appinventor.ble;

import android.app.Activity;
import android.util.Log;
import com.google.appinventor.components.annotations.DesignerComponent;
import com.google.appinventor.components.annotations.DesignerProperty;
import com.google.appinventor.components.annotations.PropertyCategory;
import com.google.appinventor.components.annotations.SimpleEvent;
import com.google.appinventor.components.annotations.SimpleFunction;
import com.google.appinventor.components.annotations.SimpleObject;
import com.google.appinventor.components.annotations.SimpleProperty;
import com.google.appinventor.components.annotations.UsesPermissions;
import com.google.appinventor.components.common.ComponentCategory;
import com.google.appinventor.components.runtime.AndroidNonvisibleComponent;
import com.google.appinventor.components.runtime.Component;
import com.google.appinventor.components.runtime.Deleteable;
import com.google.appinventor.components.runtime.EventDispatcher;
import com.google.appinventor.components.runtime.Form;
import com.google.appinventor.components.runtime.util.ErrorMessages;
import com.google.appinventor.components.runtime.util.YailList;
import edu.mit.appinventor.ble.BluetoothLEint;
import gnu.lists.FString;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@DesignerComponent(category = ComponentCategory.EXTENSION, description = "Bluetooth Low Energy, also referred to as Bluetooth LE or simply BLE, is a new communication protocol similar to classic Bluetooth except that it is designed to consume less power while maintaining comparable functionality. For this reason, Bluetooth LE is the preferred choice of communication with IoT devices that have limited power resources. Starting with Android 4.3, Google introduced built-in support for Bluetooth Low Energy. The BluetoothLE extension requires Android 5.0 or higher to avoid known issues with Google's Bluetooth LE support prior to Android 5.0.", helpUrl = "http://iot.appinventor.mit.edu/#/bluetoothle/bluetoothleintro", iconName = "images/bluetooth.png", nonVisible = true, version = 20200828)
@SimpleObject(external = true)
@UsesPermissions({"android.permission.BLUETOOTH", "android.permission.BLUETOOTH_ADMIN", "android.permission.ACCESS_FINE_LOCATION"})
public class BluetoothLE extends AndroidNonvisibleComponent implements Component, Deleteable {
    public static final int ERROR_CHARACTERISTIC_INDEX_OOB = 9104;
    public static final int ERROR_DEVICE_INDEX_OOB = 9101;
    public static final int ERROR_SERVICE_INDEX_OOB = 9102;
    public static final int ERROR_SERVICE_INVALID_UUID = 9103;
    private static final String LOG_TAG = "BluetoothLE";
    private final Activity activity;
    Set<BluetoothConnectionListener> connectionListeners;
    /* access modifiers changed from: private */
    public BluetoothLEint inner;

    public interface BLEPacketHandler {
        void onPacketReceived(String str, String str2, BLEPacketReader bLEPacketReader);
    }

    public interface BluetoothConnectionListener {
        void onConnected(BluetoothLE bluetoothLE);

        void onDisconnected(BluetoothLE bluetoothLE);
    }

    public void onDelete() {
        if (this.inner != null) {
            this.inner.Disconnect();
            this.inner = null;
        }
    }

    public static abstract class BLEResponseHandler<T> {
        public BLEResponseHandler() {
        }

        public void onReceive(String serviceUuid, String characteristicUuid, List<T> list) {
        }

        public void onWrite(String serviceUuid, String characteristicUuid, List<T> list) {
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public BluetoothLE(com.google.appinventor.components.runtime.ComponentContainer r10) {
        /*
            r9 = this;
            r0 = r9
            r1 = r10
            r2 = r0
            r3 = r1
            com.google.appinventor.components.runtime.Form r3 = r3.$form()
            r2.<init>(r3)
            r2 = r0
            java.util.HashSet r3 = new java.util.HashSet
            r8 = r3
            r3 = r8
            r4 = r8
            r4.<init>()
            r2.connectionListeners = r3
            r2 = r0
            r3 = r1
            android.app.Activity r3 = r3.$context()
            r2.activity = r3
            r2 = r1
            com.google.appinventor.components.runtime.Form r2 = r2.$form()
            android.content.pm.PackageManager r2 = r2.getPackageManager()
            java.lang.String r3 = "android.hardware.bluetooth_le"
            boolean r2 = r2.hasSystemFeature(r3)
            if (r2 != 0) goto L_0x004b
            java.lang.String r2 = "BluetoothLE"
            java.lang.String r3 = "Bluetooth LE is unsupported on this hardware. Any subsequent function calls will complain."
            int r2 = android.util.Log.e(r2, r3)
        L_0x003a:
            r2 = r0
            edu.mit.appinventor.ble.BluetoothLEint r3 = new edu.mit.appinventor.ble.BluetoothLEint
            r8 = r3
            r3 = r8
            r4 = r8
            r5 = r0
            r6 = r0
            android.app.Activity r6 = r6.activity
            r7 = r1
            r4.<init>(r5, r6, r7)
            r2.inner = r3
            return
        L_0x004b:
            int r2 = com.google.appinventor.components.runtime.util.SdkLevel.getLevel()
            r3 = 21
            if (r2 >= r3) goto L_0x005e
            java.lang.String r2 = "BluetoothLE"
            java.lang.String r3 = "The BluetoothLE extension is unsupported at this API Level. Any subsequent function calls will complain."
            int r2 = android.util.Log.e(r2, r3)
            goto L_0x003a
        L_0x005e:
            java.lang.String r2 = "BluetoothLE"
            java.lang.String r3 = "Appear to have Bluetooth LE support, continuing..."
            int r2 = android.util.Log.d(r2, r3)
            goto L_0x003a
        */
        throw new UnsupportedOperationException("Method not decompiled: edu.mit.appinventor.ble.BluetoothLE.<init>(com.google.appinventor.components.runtime.ComponentContainer):void");
    }

    public Form getForm() {
        return this.form;
    }

    public void addConnectionListener(BluetoothConnectionListener listener) {
        boolean add = this.connectionListeners.add(listener);
    }

    public void removeConnectionListener(BluetoothConnectionListener listener) {
        boolean remove = this.connectionListeners.remove(listener);
    }

    @DesignerProperty(defaultValue = "false", editorType = "boolean")
    @SimpleProperty
    public void AutoReconnect(boolean autoReconnect) {
        this.inner.setAutoReconnect(autoReconnect);
    }

    @SimpleProperty(category = PropertyCategory.BEHAVIOR, description = "If true, the application will attempt to reestablish a lost connection to a device due to link loss (e.g., moving out of range). This will not apply to connections that are disconnected by a call to the <a href='#Disconnect'><code>Disconnect</code></a> method. Such disconnects will need to be reconnected via a call to <a href='#Connect'><code>Connect</code></a> or <a href='#ConnectWithAddress'><code>ConnectWithAddress</code></a>.")
    public boolean AutoReconnect() {
        return this.inner.getAutoReconnect();
    }

    @DesignerProperty(defaultValue = "10", editorType = "non_negative_integer")
    @SimpleProperty
    public void ConnectionTimeout(int timeout) {
        this.inner.setConnectionTimeout(timeout);
    }

    @SimpleProperty(category = PropertyCategory.BEHAVIOR, description = "The amount of time, in seconds, that the BluetoothLE component will wait for a connection to be established with a device after a call to <a href='#Connect'><code>Connect</code></a> or <a href='#ConnectWithAddress'><code>ConnectWithAddress</code></a>. If a connection is not established in the given amount of time, the attempt will be aborted and the <a href='#ConnectionFailed'><code>ConnectionFailed</code></a> event will be run.")
    public int ConnectionTimeout() {
        return this.inner.getConnectionTimeout();
    }

    @SimpleFunction
    public void StartScanning() {
        Runnable runnable;
        if (this.inner == null) {
            return;
        }
        if (SDK26Helper.shouldAskForPermission(this.form)) {
            new Runnable(this) {
                final /* synthetic */ BluetoothLE this$0;

                {
                    this.this$0 = this$0;
                }

                public void run() {
                    this.this$0.inner.StartScanning();
                }
            };
            SDK26Helper.askForPermission(this, runnable);
            return;
        }
        this.inner.StartScanning();
    }

    @SimpleFunction
    public void StopScanning() {
        if (this.inner != null) {
            this.inner.StopScanning();
        }
    }

    @SimpleProperty(description = "The scanning state of the Bluetooth low energy component.")
    public boolean Scanning() {
        if (this.inner != null) {
            return this.inner.isScanning();
        }
        return false;
    }

    @SimpleFunction
    public void Connect(int i) {
        int index = i;
        if (this.inner != null) {
            try {
                this.inner.Connect(index);
            } catch (IndexOutOfBoundsException e) {
                Object[] objArr = new Object[3];
                objArr[0] = Integer.valueOf(ERROR_DEVICE_INDEX_OOB);
                Object[] objArr2 = objArr;
                objArr2[1] = LOG_TAG;
                Object[] objArr3 = objArr2;
                objArr3[2] = e.getMessage();
                this.form.dispatchErrorOccurredEvent(this, "Connect", ErrorMessages.ERROR_EXTENSION_ERROR, objArr3);
            }
        }
    }

    @SimpleFunction
    public void ConnectWithAddress(String str) {
        String address = str;
        if (this.inner != null) {
            this.inner.ConnectWithAddress(address);
        }
    }

    @SimpleFunction
    public void Disconnect() {
        if (this.inner != null) {
            this.inner.Disconnect();
        }
    }

    @SimpleFunction
    public void DisconnectWithAddress(String str) {
        String address = str;
        if (this.inner != null) {
            this.inner.DisconnectWithAddress(address);
        }
    }

    @SimpleFunction
    public void ReadBytes(String str, String str2, boolean z) {
        String serviceUuid = str;
        String characteristicUuid = str2;
        boolean signed = z;
        if (this.inner != null) {
            this.inner.ReadByteValues(serviceUuid, characteristicUuid, signed);
        }
    }

    @SimpleFunction
    public void RegisterForBytes(String str, String str2, boolean z) {
        String serviceUuid = str;
        String characteristicUuid = str2;
        boolean signed = z;
        if (this.inner != null) {
            this.inner.RegisterForByteValues(serviceUuid, characteristicUuid, signed);
        }
    }

    @SimpleFunction
    public void WriteBytes(String str, String str2, boolean z, Object obj) {
        String serviceUuid = str;
        String characteristicUuid = str2;
        boolean signed = z;
        Object values = obj;
        if (this.inner != null) {
            this.inner.WriteByteValues(serviceUuid, characteristicUuid, signed, toList(Integer.class, values, 1));
        }
    }

    @SimpleFunction
    public void WriteBytesWithResponse(String str, String str2, boolean z, Object obj) {
        String serviceUuid = str;
        String characteristicUuid = str2;
        boolean signed = z;
        Object values = obj;
        if (this.inner != null) {
            this.inner.WriteByteValuesWithResponse(serviceUuid, characteristicUuid, signed, toList(Integer.class, values, 1));
        }
    }

    @SimpleFunction
    public void ReadShorts(String str, String str2, boolean z) {
        String serviceUuid = str;
        String characteristicUuid = str2;
        boolean signed = z;
        if (this.inner != null) {
            this.inner.ReadShortValues(serviceUuid, characteristicUuid, signed);
        }
    }

    @SimpleFunction
    public void RegisterForShorts(String str, String str2, boolean z) {
        String serviceUuid = str;
        String characteristicUuid = str2;
        boolean signed = z;
        if (this.inner != null) {
            this.inner.RegisterForShortValues(serviceUuid, characteristicUuid, signed);
        }
    }

    @SimpleFunction
    public void WriteShorts(String str, String str2, boolean z, Object obj) {
        String serviceUuid = str;
        String characteristicUuid = str2;
        boolean signed = z;
        Object values = obj;
        if (this.inner != null) {
            this.inner.WriteShortValues(serviceUuid, characteristicUuid, signed, toList(Integer.class, values, 2));
        }
    }

    @SimpleFunction
    public void WriteShortsWithResponse(String str, String str2, boolean z, Object obj) {
        String serviceUuid = str;
        String characteristicUuid = str2;
        boolean signed = z;
        Object values = obj;
        if (this.inner != null) {
            this.inner.WriteShortValuesWithResponse(serviceUuid, characteristicUuid, signed, toList(Integer.class, values, 2));
        }
    }

    @SimpleFunction
    public void ReadIntegers(String str, String str2, boolean z) {
        String serviceUuid = str;
        String characteristicUuid = str2;
        boolean signed = z;
        if (this.inner != null) {
            this.inner.ReadIntegerValues(serviceUuid, characteristicUuid, signed);
        }
    }

    @SimpleFunction
    public void RegisterForIntegers(String str, String str2, boolean z) {
        String serviceUuid = str;
        String characteristicUuid = str2;
        boolean signed = z;
        if (this.inner != null) {
            this.inner.RegisterForIntegerValues(serviceUuid, characteristicUuid, signed);
        }
    }

    @SimpleFunction
    public void WriteIntegers(String str, String str2, boolean z, Object obj) {
        String serviceUuid = str;
        String characteristicUuid = str2;
        boolean signed = z;
        Object values = obj;
        if (this.inner != null) {
            this.inner.WriteIntegerValues(serviceUuid, characteristicUuid, signed, toList(Long.class, values, 4));
        }
    }

    @SimpleFunction
    public void WriteIntegersWithResponse(String str, String str2, boolean z, Object obj) {
        String serviceUuid = str;
        String characteristicUuid = str2;
        boolean signed = z;
        Object values = obj;
        if (this.inner != null) {
            this.inner.WriteIntegerValuesWithResponse(serviceUuid, characteristicUuid, signed, toList(Long.class, values, 4));
        }
    }

    @SimpleFunction
    public void ReadFloats(String str, String str2, boolean z) {
        String serviceUuid = str;
        String characteristicUuid = str2;
        boolean shortFloat = z;
        if (this.inner != null) {
            this.inner.ReadFloatValues(serviceUuid, characteristicUuid, shortFloat);
        }
    }

    @SimpleFunction
    public void RegisterForFloats(String str, String str2, boolean z) {
        String serviceUuid = str;
        String characteristicUuid = str2;
        boolean shortFloat = z;
        if (this.inner != null) {
            this.inner.RegisterForFloatValues(serviceUuid, characteristicUuid, shortFloat);
        }
    }

    @SimpleFunction
    public void WriteFloats(String str, String str2, boolean z, Object obj) {
        String serviceUuid = str;
        String characteristicUuid = str2;
        boolean shortFloat = z;
        Object values = obj;
        if (this.inner != null) {
            this.inner.WriteFloatValues(serviceUuid, characteristicUuid, shortFloat, toList(Float.class, values, shortFloat ? 2 : 4));
        }
    }

    @SimpleFunction
    public void WriteFloatsWithResponse(String str, String str2, boolean z, Object obj) {
        String serviceUuid = str;
        String characteristicUuid = str2;
        boolean shortFloat = z;
        Object values = obj;
        if (this.inner != null) {
            this.inner.WriteFloatValuesWithResponse(serviceUuid, characteristicUuid, shortFloat, toList(Float.class, values, shortFloat ? 2 : 4));
        }
    }

    @SimpleFunction
    public void ReadStrings(String str, String str2, boolean z) {
        String serviceUuid = str;
        String characteristicUuid = str2;
        boolean utf16 = z;
        if (this.inner != null) {
            this.inner.ReadStringValues(serviceUuid, characteristicUuid, utf16);
        }
    }

    @SimpleFunction
    public void RegisterForStrings(String str, String str2, boolean z) {
        String serviceUuid = str;
        String characteristicUuid = str2;
        boolean utf16 = z;
        if (this.inner != null) {
            this.inner.RegisterForStringValues(serviceUuid, characteristicUuid, utf16);
        }
    }

    @SimpleFunction
    public void WriteStrings(String str, String str2, boolean z, Object obj) {
        String serviceUuid = str;
        String characteristicUuid = str2;
        boolean utf16 = z;
        Object values = obj;
        if (this.inner != null) {
            this.inner.WriteStringValues(serviceUuid, characteristicUuid, utf16, toList(String.class, values, utf16 ? 2 : 1));
        }
    }

    @SimpleFunction
    public void WriteStringsWithResponse(String str, String str2, boolean z, Object obj) {
        String serviceUuid = str;
        String characteristicUuid = str2;
        boolean utf16 = z;
        Object values = obj;
        if (this.inner != null) {
            this.inner.WriteStringValuesWithResponse(serviceUuid, characteristicUuid, utf16, toList(String.class, values, utf16 ? 2 : 1));
        }
    }

    @SimpleFunction
    public void UnregisterForValues(String str, String str2) {
        String service_uuid = str;
        String characteristic_uuid = str2;
        if (this.inner != null) {
            this.inner.UnregisterForValues(service_uuid, characteristic_uuid);
        }
    }

    @SimpleFunction
    public int FoundDeviceRssi(int i) {
        int index = i;
        if (this.inner != null) {
            try {
                return this.inner.FoundDeviceRssi(index);
            } catch (IndexOutOfBoundsException e) {
                Object[] objArr = new Object[3];
                objArr[0] = Integer.valueOf(ERROR_DEVICE_INDEX_OOB);
                Object[] objArr2 = objArr;
                objArr2[1] = LOG_TAG;
                Object[] objArr3 = objArr2;
                objArr3[2] = e.getMessage();
                this.form.dispatchErrorOccurredEvent(this, "FoundDeviceRssi", ErrorMessages.ERROR_EXTENSION_ERROR, objArr3);
            }
        }
        return 0;
    }

    @SimpleFunction
    public String FoundDeviceName(int i) {
        int index = i;
        if (this.inner != null) {
            try {
                String result = this.inner.FoundDeviceName(index);
                return result == null ? "" : result;
            } catch (IllegalArgumentException e) {
                Object[] objArr = new Object[3];
                objArr[0] = Integer.valueOf(ERROR_DEVICE_INDEX_OOB);
                Object[] objArr2 = objArr;
                objArr2[1] = LOG_TAG;
                Object[] objArr3 = objArr2;
                objArr3[2] = e.getMessage();
                this.form.dispatchErrorOccurredEvent(this, "FoundDeviceName", ErrorMessages.ERROR_EXTENSION_ERROR, objArr3);
            }
        }
        return "";
    }

    @SimpleFunction
    public String FoundDeviceAddress(int i) {
        int index = i;
        if (this.inner != null) {
            try {
                String result = this.inner.FoundDeviceAddress(index);
                return result == null ? "" : result;
            } catch (IllegalArgumentException e) {
                Object[] objArr = new Object[3];
                objArr[0] = Integer.valueOf(ERROR_DEVICE_INDEX_OOB);
                Object[] objArr2 = objArr;
                objArr2[1] = LOG_TAG;
                Object[] objArr3 = objArr2;
                objArr3[2] = e.getMessage();
                this.form.dispatchErrorOccurredEvent(this, "FoundDeviceAddress", ErrorMessages.ERROR_EXTENSION_ERROR, objArr3);
            }
        }
        return "";
    }

    @SimpleFunction
    public void StartAdvertising(String str, String str2) {
        String inData = str;
        String serviceUuid = str2;
        if (this.inner != null) {
            this.inner.StartAdvertising(inData, serviceUuid);
        }
    }

    @SimpleFunction
    public void StopAdvertising() {
        if (this.inner != null) {
            this.inner.StopAdvertising();
        }
    }

    @SimpleFunction
    public void ScanAdvertisements(long j) {
        long scanPeriod = j;
        if (this.inner != null) {
            this.inner.ScanAdvertisements(scanPeriod);
        }
    }

    @SimpleFunction
    public void StopScanningAdvertisements() {
        if (this.inner != null) {
            this.inner.StopScanningAdvertisements();
        }
    }

    @SimpleFunction
    public String AdvertisementData(String str, String str2) {
        String deviceAddress = str;
        String serviceUuid = str2;
        if (this.inner != null) {
            return this.inner.GetAdvertisementData(deviceAddress, serviceUuid);
        }
        return "";
    }

    @SimpleFunction
    public String AdvertiserAddress(String str) {
        String deviceName = str;
        if (this.inner != null) {
            return this.inner.GetAdvertiserAddress(deviceName);
        }
        return "";
    }

    @SimpleFunction
    public List<String> AdvertiserServiceUuids(String str) {
        String deviceAddress = str;
        if (this.inner != null) {
            return this.inner.GetAdvertiserServiceUuids(deviceAddress);
        }
        return YailList.makeEmptyList();
    }

    @SimpleProperty(category = PropertyCategory.BEHAVIOR, description = "Returns the battery level.")
    public String BatteryValue() {
        if (this.inner != null) {
            return this.inner.BatteryValue();
        }
        return "";
    }

    @SimpleProperty(category = PropertyCategory.BEHAVIOR, description = "Returns the transmission power.")
    public int TxPower() {
        if (this.inner != null) {
            return this.inner.TxPower();
        }
        return -1;
    }

    @SimpleProperty(category = PropertyCategory.BEHAVIOR, description = "Returns true if a BluetoothLE device is connected; Otherwise, returns false.")
    public boolean IsDeviceConnected() {
        if (this.inner != null) {
            return this.inner.IsDeviceConnected();
        }
        return false;
    }

    @SimpleProperty(category = PropertyCategory.BEHAVIOR, description = "Returns a sorted list of BluetoothLE devices as a String.")
    public String DeviceList() {
        if (this.inner != null) {
            return this.inner.DeviceList();
        }
        return "";
    }

    @SimpleProperty(category = PropertyCategory.BEHAVIOR, description = "Returns the RSSI (Received Signal Strength Indicator) of connected device.")
    public int ConnectedDeviceRssi() {
        if (this.inner != null) {
            return this.inner.ConnectedDeviceRssi();
        }
        return Integer.MIN_VALUE;
    }

    @SimpleProperty(description = "Returns the value of ScanPeriod.")
    public long AdvertisementScanPeriod() {
        if (this.inner != null) {
            return this.inner.AdvertisementScanPeriod();
        }
        return 0;
    }

    @SimpleProperty(description = "Returns a list of the names of the devices found during Advertisment scanning.")
    public List<String> AdvertiserNames() {
        if (this.inner != null) {
            return this.inner.GetAdvertiserNames();
        }
        return Collections.emptyList();
    }

    @SimpleProperty(description = "Returns a list of the addresses of devices found during Advertisement scanning.")
    public List<String> AdvertiserAddresses() {
        if (this.inner != null) {
            return this.inner.GetAdvertiserAddresses();
        }
        return Collections.emptyList();
    }

    @SimpleProperty(description = "Returns true if the device is currently advertising, false otherwise.")
    public boolean IsDeviceAdvertising() {
        if (this.inner != null) {
            return this.inner.IsDeviceAdvertising();
        }
        return false;
    }

    @SimpleEvent
    public void Connected() {
    }

    @SimpleEvent
    public void ConnectionFailed(String reason) {
        Runnable runnable;
        final String str = reason;
        new Runnable(this) {
            final /* synthetic */ BluetoothLE this$0;

            {
                this.this$0 = this$0;
            }

            public void run() {
                boolean dispatchEvent = EventDispatcher.dispatchEvent(this.this$0, "ConnectionFailed", str);
            }
        };
        this.form.runOnUiThread(runnable);
    }

    @SimpleEvent
    public void Disconnected() {
    }

    @SimpleEvent(description = "Trigger event when RSSI (Received Signal Strength Indicator) of found BluetoothLE device changes")
    public void RssiChanged(int rssi) {
    }

    @SimpleEvent
    public void DeviceFound() {
    }

    @SimpleEvent
    public void BytesReceived(String serviceUuid, String characteristicUuid, YailList byteValues) {
        Object[] objArr = new Object[3];
        objArr[0] = serviceUuid;
        Object[] objArr2 = objArr;
        objArr2[1] = characteristicUuid;
        Object[] objArr3 = objArr2;
        objArr3[2] = byteValues;
        boolean dispatchEvent = EventDispatcher.dispatchEvent(this, "BytesReceived", objArr3);
    }

    @SimpleEvent
    public void BytesWritten(String serviceUuid, String characteristicUuid, YailList byteValues) {
        Object[] objArr = new Object[3];
        objArr[0] = serviceUuid;
        Object[] objArr2 = objArr;
        objArr2[1] = characteristicUuid;
        Object[] objArr3 = objArr2;
        objArr3[2] = byteValues;
        boolean dispatchEvent = EventDispatcher.dispatchEvent(this, "BytesWritten", objArr3);
    }

    @SimpleEvent
    public void ShortsReceived(String serviceUuid, String characteristicUuid, YailList shortValues) {
        Object[] objArr = new Object[3];
        objArr[0] = serviceUuid;
        Object[] objArr2 = objArr;
        objArr2[1] = characteristicUuid;
        Object[] objArr3 = objArr2;
        objArr3[2] = shortValues;
        boolean dispatchEvent = EventDispatcher.dispatchEvent(this, "ShortsReceived", objArr3);
    }

    @SimpleEvent
    public void ShortsWritten(String serviceUuid, String characteristicUuid, YailList shortValues) {
        Object[] objArr = new Object[3];
        objArr[0] = serviceUuid;
        Object[] objArr2 = objArr;
        objArr2[1] = characteristicUuid;
        Object[] objArr3 = objArr2;
        objArr3[2] = shortValues;
        boolean dispatchEvent = EventDispatcher.dispatchEvent(this, "ShortsWritten", objArr3);
    }

    @SimpleEvent
    public void IntegersReceived(String serviceUuid, String characteristicUuid, YailList intValues) {
        Object[] objArr = new Object[3];
        objArr[0] = serviceUuid;
        Object[] objArr2 = objArr;
        objArr2[1] = characteristicUuid;
        Object[] objArr3 = objArr2;
        objArr3[2] = intValues;
        boolean dispatchEvent = EventDispatcher.dispatchEvent(this, "IntegersReceived", objArr3);
    }

    @SimpleEvent
    public void IntegersWritten(String serviceUuid, String characteristicUuid, YailList intValues) {
        Object[] objArr = new Object[3];
        objArr[0] = serviceUuid;
        Object[] objArr2 = objArr;
        objArr2[1] = characteristicUuid;
        Object[] objArr3 = objArr2;
        objArr3[2] = intValues;
        boolean dispatchEvent = EventDispatcher.dispatchEvent(this, "IntegersWritten", objArr3);
    }

    @SimpleEvent
    public void FloatsReceived(String serviceUuid, String characteristicUuid, YailList floatValues) {
        Object[] objArr = new Object[3];
        objArr[0] = serviceUuid;
        Object[] objArr2 = objArr;
        objArr2[1] = characteristicUuid;
        Object[] objArr3 = objArr2;
        objArr3[2] = floatValues;
        boolean dispatchEvent = EventDispatcher.dispatchEvent(this, "FloatsReceived", objArr3);
    }

    @SimpleEvent
    public void FloatsWritten(String serviceUuid, String characteristicUuid, YailList floatValues) {
        Object[] objArr = new Object[3];
        objArr[0] = serviceUuid;
        Object[] objArr2 = objArr;
        objArr2[1] = characteristicUuid;
        Object[] objArr3 = objArr2;
        objArr3[2] = floatValues;
        boolean dispatchEvent = EventDispatcher.dispatchEvent(this, "FloatsWritten", objArr3);
    }

    @SimpleEvent
    public void StringsReceived(String serviceUuid, String characteristicUuid, YailList stringValues) {
        Object[] objArr = new Object[3];
        objArr[0] = serviceUuid;
        Object[] objArr2 = objArr;
        objArr2[1] = characteristicUuid;
        Object[] objArr3 = objArr2;
        objArr3[2] = stringValues;
        boolean dispatchEvent = EventDispatcher.dispatchEvent(this, "StringsReceived", objArr3);
    }

    @SimpleEvent
    public void StringsWritten(String serviceUuid, String characteristicUuid, YailList stringValues) {
        Object[] objArr = new Object[3];
        objArr[0] = serviceUuid;
        Object[] objArr2 = objArr;
        objArr2[1] = characteristicUuid;
        Object[] objArr3 = objArr2;
        objArr3[2] = stringValues;
        boolean dispatchEvent = EventDispatcher.dispatchEvent(this, "StringsWritten", objArr3);
    }

    @SimpleFunction
    public String SupportedServices() {
        if (this.inner != null) {
            return this.inner.GetSupportedServices();
        }
        return "";
    }

    @SimpleProperty(description = "A list of pairs, one for each advertised service, indicating the service's UUID and its name, if known. The format of the list will be ((uuid1 name1) (uuid2 name2) ...). If no device is connected or Bluetooth low energy is not supported, then an empty list will be returned.")
    public YailList DeviceServices() {
        if (this.inner != null) {
            return this.inner.getSupportedServicesList();
        }
        return YailList.makeEmptyList();
    }

    @SimpleFunction
    public String ServiceByIndex(int i) {
        int index = i;
        if (this.inner != null) {
            try {
                String result = this.inner.GetServiceByIndex(index);
                return result == null ? "" : result;
            } catch (IndexOutOfBoundsException e) {
                Object[] objArr = new Object[3];
                objArr[0] = Integer.valueOf(ERROR_SERVICE_INDEX_OOB);
                Object[] objArr2 = objArr;
                objArr2[1] = LOG_TAG;
                Object[] objArr3 = objArr2;
                objArr3[2] = e.getMessage();
                this.form.dispatchErrorOccurredEvent(this, "ServiceByIndex", ErrorMessages.ERROR_EXTENSION_ERROR, objArr3);
            }
        }
        return "";
    }

    @SimpleFunction
    public String SupportedCharacteristics() {
        if (this.inner != null) {
            return this.inner.GetSupportedCharacteristics();
        }
        return "";
    }

    @SimpleProperty(description = "A list of triples, one for each characteristic advertised by the connected device, containing the service UUID, characteristic UUID, and the characteristic's name, if known. The format of the list will be ((service1 characteristic1 name1) (service2 characteristic2 name2) ...). If no device is connected or Bluetooth low energy is not supported, then an empty list will be returned.")
    public YailList DeviceCharacteristics() {
        if (this.inner != null) {
            return this.inner.getSupportedCharacteristicsList();
        }
        return YailList.makeEmptyList();
    }

    @SimpleProperty(description = "The advertised name of the connected device. If no device is connected or Bluetooth low energy is not supported, this will return the empty string.")
    public String ConnectedDeviceName() {
        if (this.inner != null) {
            return this.inner.ConnectedDeviceName();
        }
        return "";
    }

    @SimpleFunction
    public YailList GetCharacteristicsForService(String str) {
        String serviceUuid = str;
        if (this.inner != null) {
            try {
                return this.inner.GetCharacteristicsForService(serviceUuid);
            } catch (RuntimeException e) {
                Object[] objArr = new Object[3];
                objArr[0] = Integer.valueOf(ERROR_SERVICE_INVALID_UUID);
                Object[] objArr2 = objArr;
                objArr2[1] = LOG_TAG;
                Object[] objArr3 = objArr2;
                objArr3[2] = e.getMessage();
                this.form.dispatchErrorOccurredEvent(this, "GetCharacteristicsForService", ErrorMessages.ERROR_EXTENSION_ERROR, objArr3);
            }
        }
        return YailList.makeEmptyList();
    }

    @SimpleFunction
    public String CharacteristicByIndex(int i) {
        int index = i;
        if (this.inner != null) {
            try {
                String result = this.inner.GetCharacteristicByIndex(index);
                return result == null ? "" : result;
            } catch (IndexOutOfBoundsException e) {
                Object[] objArr = new Object[3];
                objArr[0] = Integer.valueOf(ERROR_CHARACTERISTIC_INDEX_OOB);
                Object[] objArr2 = objArr;
                objArr2[1] = LOG_TAG;
                Object[] objArr3 = objArr2;
                objArr3[2] = e.getMessage();
                this.form.dispatchErrorOccurredEvent(this, "CharacteristicByIndex", ErrorMessages.ERROR_EXTENSION_ERROR, objArr3);
            }
        }
        return "";
    }

    @SimpleFunction
    public void ScanForDevice(BLEDevice bLEDevice) {
        Runnable runnable;
        BLEDevice device = bLEDevice;
        if (this.inner != null) {
            if (SDK26Helper.shouldAskForPermission(this.form)) {
                final BLEDevice bLEDevice2 = device;
                new Runnable(this) {
                    final /* synthetic */ BluetoothLE this$0;

                    {
                        this.this$0 = this$0;
                    }

                    public void run() {
                        this.this$0.inner.StartScanningForService("ScanForDevice", bLEDevice2.GetBroadcastUUID(), (BluetoothLEint.DeviceCallback) null);
                    }
                };
                SDK26Helper.askForPermission(this, runnable);
                return;
            }
            this.inner.StartScanningForService("ScanForDevice", device.GetBroadcastUUID(), (BluetoothLEint.DeviceCallback) null);
        }
    }

    @SimpleFunction
    public void ScanForService(String str) {
        Runnable runnable;
        String serviceUuid = str;
        if (this.inner != null) {
            UUID uuid = BLEUtil.bleStringToUuid(serviceUuid);
            if (SDK26Helper.shouldAskForPermission(this.form)) {
                final UUID uuid2 = uuid;
                new Runnable(this) {
                    final /* synthetic */ BluetoothLE this$0;

                    {
                        this.this$0 = this$0;
                    }

                    public void run() {
                        this.this$0.inner.StartScanningForService("ScanForService", uuid2, (BluetoothLEint.DeviceCallback) null);
                    }
                };
                SDK26Helper.askForPermission(this, runnable);
                return;
            }
            this.inner.StartScanningForService("ScanForService", uuid, (BluetoothLEint.DeviceCallback) null);
        }
    }

    @SimpleFunction
    public void ConnectToDeviceType(BLEDevice bLEDevice, String str) {
        Runnable runnable;
        BLEDevice device = bLEDevice;
        String name = str;
        if (this.inner != null && SDK26Helper.shouldAskForPermission(this.form)) {
            final BLEDevice bLEDevice2 = device;
            final String str2 = name;
            new Runnable(this) {
                final /* synthetic */ BluetoothLE this$0;

                {
                    this.this$0 = this$0;
                }

                public void run() {
                    BluetoothLEint.DeviceCallback deviceCallback;
                    new BluetoothLEint.DeviceCallback(this) {
                        final /* synthetic */ AnonymousClass5 this$1;

                        {
                            this.this$1 = this$1;
                        }

                        public boolean foundDevice(String str, String str2) {
                            StringBuilder sb;
                            String devname = str;
                            String str3 = str2;
                            new StringBuilder();
                            int i = Log.i(BluetoothLE.LOG_TAG, sb.append("devname = ").append(devname).append(", name = ").append(str2).toString());
                            return devname.equals(str2);
                        }
                    };
                    this.this$0.inner.StartScanningForService("ConnectToDeviceType", bLEDevice2.GetBroadcastUUID(), deviceCallback);
                }
            };
            SDK26Helper.askForPermission(this, runnable);
        }
    }

    @SimpleFunction
    public void ConnectToDeviceWithServiceAndName(String str, String str2) {
        Runnable runnable;
        String serviceUuid = str;
        String name = str2;
        if (this.inner != null && SDK26Helper.shouldAskForPermission(this.form)) {
            final String str3 = serviceUuid;
            final String str4 = name;
            new Runnable(this) {
                final /* synthetic */ BluetoothLE this$0;

                {
                    this.this$0 = this$0;
                }

                public void run() {
                    BluetoothLEint.DeviceCallback deviceCallback;
                    new BluetoothLEint.DeviceCallback(this) {
                        final /* synthetic */ AnonymousClass6 this$1;

                        {
                            this.this$1 = this$1;
                        }

                        public boolean foundDevice(String devname, String str) {
                            String str2 = str;
                            return devname.equals(str4);
                        }
                    };
                    this.this$0.inner.StartScanningForService("ConnectToDeviceWithServiceAndName", BLEUtil.bleStringToUuid(str3), deviceCallback);
                }
            };
            SDK26Helper.askForPermission(this, runnable);
        }
    }

    @SimpleFunction
    public void RequestMTU(int i) {
        Runnable runnable;
        int bytes = i;
        if (this.inner != null) {
            if (SDK26Helper.shouldAskForPermission(this.form)) {
                final int i2 = bytes;
                new Runnable(this) {
                    final /* synthetic */ BluetoothLE this$0;

                    {
                        this.this$0 = this$0;
                    }

                    public void run() {
                        this.this$0.inner.RequestMTU(i2);
                    }
                };
                SDK26Helper.askForPermission(this, runnable);
                return;
            }
            this.inner.RequestMTU(bytes);
        }
    }

    @SimpleEvent
    public void MTUChanged(int bytes) {
        Runnable runnable;
        final int i = bytes;
        new Runnable(this) {
            final /* synthetic */ BluetoothLE this$0;

            {
                this.this$0 = this$0;
            }

            public void run() {
                boolean dispatchEvent = EventDispatcher.dispatchEvent(this.this$0, "MTUChanged", Integer.valueOf(i));
            }
        };
        this.form.runOnUiThread(runnable);
    }

    @DesignerProperty(defaultValue = "True", editorType = "boolean")
    @SimpleProperty
    public void NullTerminateStrings(boolean z) {
        boolean terminate = z;
        if (this.inner != null) {
            this.inner.setNullTerminatedStrings(terminate);
        }
    }

    @SimpleProperty
    public boolean NullTerminateStrings() {
        if (this.inner != null) {
            return this.inner.isNullTerminatedStrings();
        }
        return false;
    }

    @SimpleFunction
    public void ReadConnectedRssi() {
        if (this.inner != null) {
            this.inner.readConnectedRssi();
        }
    }

    @SimpleFunction
    public boolean CanReadCharacteristic(String str, String str2) {
        String serviceUuid = str;
        String characteristicUuid = str2;
        if (this.inner != null) {
            return this.inner.canReadCharacteristic(serviceUuid, characteristicUuid);
        }
        return false;
    }

    @SimpleFunction
    public boolean CanRegisterForCharacteristic(String str, String str2) {
        String serviceUuid = str;
        String characteristicUuid = str2;
        if (this.inner != null) {
            return this.inner.canRegisterForCharacteristic(serviceUuid, characteristicUuid);
        }
        return false;
    }

    @SimpleFunction
    public boolean CanWriteCharacteristic(String str, String str2) {
        String serviceUuid = str;
        String characteristicUuid = str2;
        if (this.inner != null) {
            return this.inner.canWriteCharacteristic(serviceUuid, characteristicUuid);
        }
        return false;
    }

    @SimpleFunction
    public boolean CanWriteCharacteristicWithResponse(String str, String str2) {
        String serviceUuid = str;
        String characteristicUuid = str2;
        if (this.inner != null) {
            return this.inner.canWriteCharacteristicWithResponse(serviceUuid, characteristicUuid);
        }
        return false;
    }

    public void ExReadByteValues(String str, String str2, boolean z, BLEResponseHandler<Integer> bLEResponseHandler) {
        String serviceUuid = str;
        String characteristicUuid = str2;
        boolean signed = z;
        BLEResponseHandler<Integer> callback = bLEResponseHandler;
        if (this.inner != null) {
            this.inner.ReadByteValues(serviceUuid, characteristicUuid, signed, callback);
        }
    }

    public void ExRegisterForByteValues(String str, String str2, boolean z, BLEResponseHandler<Integer> bLEResponseHandler) {
        String serviceUuid = str;
        String characteristicUuid = str2;
        boolean signed = z;
        BLEResponseHandler<Integer> callback = bLEResponseHandler;
        if (this.inner != null) {
            this.inner.RegisterForByteValues(serviceUuid, characteristicUuid, signed, callback);
        }
    }

    public void ExWriteByteValues(String str, String str2, boolean z, List<Integer> list) {
        String serviceUuid = str;
        String characteristicUuid = str2;
        boolean signed = z;
        List<Integer> values = list;
        if (this.inner != null) {
            this.inner.WriteByteValues(serviceUuid, characteristicUuid, signed, toList(Integer.class, values, 1));
        }
    }

    public void ExWriteByteValues(String str, String str2, boolean z, Object obj) {
        String serviceUuid = str;
        String characteristicUuid = str2;
        boolean signed = z;
        Object value = obj;
        if (this.inner != null) {
            this.inner.WriteByteValues(serviceUuid, characteristicUuid, signed, toList(Integer.class, value, 1));
        }
    }

    public void ExWriteByteValues(String serviceUuid, String characteristicUuid, boolean signed, int value) {
        ExWriteByteValues(serviceUuid, characteristicUuid, signed, (List<Integer>) Collections.singletonList(Integer.valueOf(value)));
    }

    public void ExWriteByteValuesWithResponse(String str, String str2, boolean z, List<Integer> list, BLEResponseHandler<Integer> bLEResponseHandler) {
        String serviceUuid = str;
        String characteristicUuid = str2;
        boolean signed = z;
        List<Integer> values = list;
        BLEResponseHandler<Integer> callback = bLEResponseHandler;
        if (this.inner != null) {
            this.inner.WriteByteValuesWithResponse(serviceUuid, characteristicUuid, signed, toList(Integer.class, values, 1), callback);
        }
    }

    public void ExWriteByteValuesWithResponse(String str, String str2, boolean z, Object obj, BLEResponseHandler<Integer> bLEResponseHandler) {
        String serviceUuid = str;
        String characteristicUuid = str2;
        boolean signed = z;
        Object value = obj;
        BLEResponseHandler<Integer> callback = bLEResponseHandler;
        if (this.inner != null) {
            this.inner.WriteByteValuesWithResponse(serviceUuid, characteristicUuid, signed, toList(Integer.class, value, 1), callback);
        }
    }

    public void ExWriteByteValuesWithResponse(String serviceUuid, String characteristicUuid, boolean signed, int value, BLEResponseHandler<Integer> callback) {
        ExWriteByteValuesWithResponse(serviceUuid, characteristicUuid, signed, (List<Integer>) Collections.singletonList(Integer.valueOf(value)), callback);
    }

    public void ExReadShortValues(String str, String str2, boolean z, BLEResponseHandler<Integer> bLEResponseHandler) {
        String serviceUuid = str;
        String characteristicUuid = str2;
        boolean signed = z;
        BLEResponseHandler<Integer> callback = bLEResponseHandler;
        if (this.inner != null) {
            this.inner.ReadShortValues(serviceUuid, characteristicUuid, signed, callback);
        }
    }

    public void ExRegisterForShortValues(String str, String str2, boolean z, BLEResponseHandler<Integer> bLEResponseHandler) {
        String serviceUuid = str;
        String characteristicUuid = str2;
        boolean signed = z;
        BLEResponseHandler<Integer> callback = bLEResponseHandler;
        if (this.inner != null) {
            this.inner.RegisterForShortValues(serviceUuid, characteristicUuid, signed, callback);
        }
    }

    public void ExWriteShortValues(String str, String str2, boolean z, List<Integer> list) {
        String serviceUuid = str;
        String characteristicUuid = str2;
        boolean signed = z;
        List<Integer> values = list;
        if (this.inner != null) {
            this.inner.WriteShortValues(serviceUuid, characteristicUuid, signed, toList(Integer.class, values, 2));
        }
    }

    public void ExWriteShortValues(String serviceUuid, String characteristicUuid, boolean signed, int value) {
        ExWriteShortValues(serviceUuid, characteristicUuid, signed, (List<Integer>) Collections.singletonList(Integer.valueOf(value)));
    }

    public void ExWriteShortValuesWithResponse(String str, String str2, boolean z, List<Integer> list, BLEResponseHandler<Integer> bLEResponseHandler) {
        String serviceUuid = str;
        String characteristicUuid = str2;
        boolean signed = z;
        List<Integer> values = list;
        BLEResponseHandler<Integer> callback = bLEResponseHandler;
        if (this.inner != null) {
            this.inner.WriteShortValuesWithResponse(serviceUuid, characteristicUuid, signed, toList(Integer.class, values, 2), callback);
        }
    }

    public void ExWriteShortValuesWithResponse(String serviceUuid, String characteristicUuid, boolean signed, int value, BLEResponseHandler<Integer> callback) {
        ExWriteShortValuesWithResponse(serviceUuid, characteristicUuid, signed, (List<Integer>) Collections.singletonList(Integer.valueOf(value)), callback);
    }

    public void ExReadIntegerValues(String str, String str2, boolean z, BLEResponseHandler<Long> bLEResponseHandler) {
        String serviceUuid = str;
        String characteristicUuid = str2;
        boolean signed = z;
        BLEResponseHandler<Long> callback = bLEResponseHandler;
        if (this.inner != null) {
            this.inner.ReadIntegerValues(serviceUuid, characteristicUuid, signed, callback);
        }
    }

    public void ExRegisterForIntegerValues(String str, String str2, boolean z, BLEResponseHandler<Long> bLEResponseHandler) {
        String serviceUuid = str;
        String characteristicUuid = str2;
        boolean signed = z;
        BLEResponseHandler<Long> callback = bLEResponseHandler;
        if (this.inner != null) {
            this.inner.ReadIntegerValues(serviceUuid, characteristicUuid, signed, callback);
        }
    }

    public void ExWriteIntegerValues(String str, String str2, boolean z, List<Long> list) {
        String serviceUuid = str;
        String characteristicUuid = str2;
        boolean signed = z;
        List<Long> values = list;
        if (this.inner != null) {
            this.inner.WriteIntegerValues(serviceUuid, characteristicUuid, signed, toList(Long.class, values, 4));
        }
    }

    public void ExWriteIntegerValues(String serviceUuid, String characteristicUuid, boolean signed, long value) {
        ExWriteIntegerValues(serviceUuid, characteristicUuid, signed, (List<Long>) Collections.singletonList(Long.valueOf(value)));
    }

    public void ExWriteIntegerValuesWithResponse(String str, String str2, boolean z, List<Long> list, BLEResponseHandler<Long> bLEResponseHandler) {
        String serviceUuid = str;
        String characteristicUuid = str2;
        boolean signed = z;
        List<Long> values = list;
        BLEResponseHandler<Long> callback = bLEResponseHandler;
        if (this.inner != null) {
            this.inner.WriteIntegerValuesWithResponse(serviceUuid, characteristicUuid, signed, toList(Long.class, values, 4), callback);
        }
    }

    public void ExWriteIntegerValuesWithResponse(String serviceUuid, String characteristicUuid, boolean signed, long value, BLEResponseHandler<Long> callback) {
        ExWriteIntegerValuesWithResponse(serviceUuid, characteristicUuid, signed, (List<Long>) Collections.singletonList(Long.valueOf(value)), callback);
    }

    public void ExReadFloatValues(String str, String str2, boolean z, BLEResponseHandler<Float> bLEResponseHandler) {
        String serviceUuid = str;
        String characteristicUuid = str2;
        boolean shortFloats = z;
        BLEResponseHandler<Float> callback = bLEResponseHandler;
        if (this.inner != null) {
            this.inner.ReadFloatValues(serviceUuid, characteristicUuid, shortFloats, callback);
        }
    }

    public void ExRegisterForFloatValues(String str, String str2, boolean z, BLEResponseHandler<Float> bLEResponseHandler) {
        String serviceUuid = str;
        String characteristicUuid = str2;
        boolean shortFloats = z;
        BLEResponseHandler<Float> callback = bLEResponseHandler;
        if (this.inner != null) {
            this.inner.RegisterForFloatValues(serviceUuid, characteristicUuid, shortFloats, callback);
        }
    }

    public void ExWriteFloatValues(String str, String str2, boolean z, List<Float> list) {
        String serviceUuid = str;
        String characteristicUuid = str2;
        boolean shortFloats = z;
        List<Float> values = list;
        if (this.inner != null) {
            this.inner.WriteFloatValues(serviceUuid, characteristicUuid, shortFloats, toList(Float.class, values, shortFloats ? 2 : 4));
        }
    }

    public void ExWriteFloatValues(String serviceUuid, String characteristicUuid, boolean shortFloats, float value) {
        ExWriteFloatValues(serviceUuid, characteristicUuid, shortFloats, (List<Float>) Collections.singletonList(Float.valueOf(value)));
    }

    public void ExWriteFloatValuesWithResponse(String str, String str2, boolean z, List<Float> list, BLEResponseHandler<Float> bLEResponseHandler) {
        String serviceUuid = str;
        String characteristicUuid = str2;
        boolean shortFloats = z;
        List<Float> values = list;
        BLEResponseHandler<Float> callback = bLEResponseHandler;
        if (this.inner != null) {
            this.inner.WriteFloatValuesWithResponse(serviceUuid, characteristicUuid, shortFloats, toList(Float.class, values, shortFloats ? 2 : 4), callback);
        }
    }

    public void ExWriteFloatValuesWithResponse(String serviceUuid, String characteristicUuid, boolean shortFloats, float value, BLEResponseHandler<Float> callback) {
        ExWriteFloatValuesWithResponse(serviceUuid, characteristicUuid, shortFloats, (List<Float>) Collections.singletonList(Float.valueOf(value)), callback);
    }

    public void ExReadStringValues(String str, String str2, boolean z, BLEResponseHandler<String> bLEResponseHandler) {
        String serviceUuid = str;
        String characteristicUuid = str2;
        boolean utf16 = z;
        BLEResponseHandler<String> callback = bLEResponseHandler;
        if (this.inner != null) {
            this.inner.ReadStringValues(serviceUuid, characteristicUuid, utf16, callback);
        }
    }

    public void ExRegisterForStringValues(String str, String str2, boolean z, BLEResponseHandler<String> bLEResponseHandler) {
        String serviceUuid = str;
        String characteristicUuid = str2;
        boolean utf16 = z;
        BLEResponseHandler<String> callback = bLEResponseHandler;
        if (this.inner != null) {
            this.inner.RegisterForStringValues(serviceUuid, characteristicUuid, utf16, callback);
        }
    }

    public void ExWriteStringValues(String str, String str2, boolean z, List<String> list) {
        String serviceUuid = str;
        String characteristicUuid = str2;
        boolean utf16 = z;
        List<String> values = list;
        if (this.inner != null) {
            this.inner.WriteStringValues(serviceUuid, characteristicUuid, utf16, toList(String.class, values, utf16 ? 2 : 1));
        }
    }

    public void ExWriteStringValues(String serviceUuid, String characteristicUuid, boolean utf16, String value) {
        ExWriteStringValues(serviceUuid, characteristicUuid, utf16, (List<String>) Collections.singletonList(value));
    }

    public void ExWriteStringValuesWithResponse(String str, String str2, boolean z, List<String> list, BLEResponseHandler<String> bLEResponseHandler) {
        String serviceUuid = str;
        String characteristicUuid = str2;
        boolean utf16 = z;
        List<String> values = list;
        BLEResponseHandler<String> callback = bLEResponseHandler;
        if (this.inner != null) {
            this.inner.WriteStringValuesWithResponse(serviceUuid, characteristicUuid, utf16, toList(String.class, values, utf16 ? 2 : 1), callback);
        }
    }

    public void ExWriteStringValuesWithResponse(String serviceUuid, String characteristicUuid, boolean utf16, String value, BLEResponseHandler<String> callback) {
        ExWriteStringValuesWithResponse(serviceUuid, characteristicUuid, utf16, (List<String>) Collections.singletonList(value), callback);
    }

    public void ExUnregisterForValues(String str, String str2, BLEResponseHandler<?> bLEResponseHandler) {
        String serviceUuid = str;
        String characteristicUuid = str2;
        BLEResponseHandler<?> callback = bLEResponseHandler;
        if (this.inner != null) {
            this.inner.UnregisterForValues(serviceUuid, characteristicUuid, callback);
        }
    }

    public void ExReadPacket(String str, String str2, BLEPacketHandler bLEPacketHandler) {
        String serviceUuid = str;
        String characteristicUuid = str2;
        BLEPacketHandler callback = bLEPacketHandler;
        if (this.inner != null) {
            this.inner.ReadPacket(serviceUuid, characteristicUuid, callback);
        }
    }

    public void ExRegisterForPackets(String str, String str2, BLEPacketHandler bLEPacketHandler) {
        String serviceUuid = str;
        String characteristicUuid = str2;
        BLEPacketHandler callback = bLEPacketHandler;
        if (this.inner != null) {
            this.inner.RegisterForPackets(serviceUuid, characteristicUuid, callback);
        }
    }

    public void ExUnregisterForPackets(String str, String str2, BLEPacketHandler bLEPacketHandler) {
        String serviceUuid = str;
        String characteristicUuid = str2;
        BLEPacketHandler callback = bLEPacketHandler;
        if (this.inner != null) {
            this.inner.UnregisterForPackets(serviceUuid, characteristicUuid, callback);
        }
    }

    public boolean isServicePublished(String str) {
        String serviceUuid = str;
        if (this.inner != null) {
            return this.inner.isServicePublished(serviceUuid);
        }
        return false;
    }

    public boolean isCharacteristicPublished(String str, String str2) {
        String serviceUuid = str;
        String characteristicUuid = str2;
        if (this.inner != null) {
            return this.inner.isCharacteristicPublished(serviceUuid, characteristicUuid);
        }
        return false;
    }

    private static <T> List<T> toList(Class<T> cls, Object obj, int i) {
        StringBuilder sb;
        Throwable th;
        StringBuilder sb2;
        Class<T> tClass = cls;
        Object value = obj;
        int size = i;
        if (tClass.isAssignableFrom(value.getClass())) {
            return Collections.singletonList(tClass.cast(value));
        }
        if (value instanceof YailList) {
            Iterator<?> i2 = ((YailList) value).iterator();
            Object next = i2.next();
            return listFromIterator(tClass, i2);
        } else if (Number.class.isAssignableFrom(tClass)) {
            if ((value instanceof FString) || (value instanceof String)) {
                Object value2 = value.toString();
                Number numval = stringToNumber((String) value2);
                if (numval == null) {
                    return stringToList(tClass, (String) value2, size);
                }
                return toList(tClass, numval, size);
            } else if (!(value instanceof Collection)) {
                return toList(tClass, Collections.singletonList(value), size);
            } else {
                return listFromIterator(tClass, ((Collection) value).iterator());
            }
        } else if (value instanceof FString) {
            return toList(tClass, value.toString(), size);
        } else {
            if (value instanceof List) {
                return listFromIterator(tClass, ((List) value).iterator());
            }
            if (value instanceof Collection) {
                return listFromIterator(tClass, ((Collection) value).iterator());
            }
            if (value instanceof String) {
                return stringToList(tClass, (String) value, size);
            }
            new StringBuilder();
            int i3 = Log.i("BLE", sb.append("Is number assignable from ").append(tClass).append("? ").append(Number.class.isAssignableFrom(tClass)).toString());
            Throwable th2 = th;
            new StringBuilder();
            new ClassCastException(sb2.append("Unable to convert ").append(value).append(" to list").toString());
            throw th2;
        }
    }

    private static <T> List<T> listFromIterator(Class<T> cls, Iterator<?> it) {
        List<T> list;
        Throwable th;
        StringBuilder sb;
        Class<T> tClass = cls;
        Iterator<?> i = it;
        if (tClass.equals(Integer.class)) {
            return toIntList(newArrayList(i));
        }
        if (tClass.equals(Long.class)) {
            return toLongList(newArrayList(i));
        }
        if (tClass.equals(Float.class)) {
            return toFloatList(newArrayList(i));
        }
        new ArrayList();
        List<T> result = list;
        while (i.hasNext()) {
            Object o = i.next();
            if (tClass.isInstance(o) || tClass.isAssignableFrom(o.getClass())) {
                boolean add = result.add(tClass.cast(o));
            } else {
                Throwable th2 = th;
                new StringBuilder();
                new ClassCastException(sb.append("Unable to convert ").append(o).append(" of type ").append(o.getClass().getName()).append(" to type ").append(tClass.getName()).toString());
                throw th2;
            }
        }
        return result;
    }

    private static <T> List<T> checkedCast(Class<T> cls, List<?> list) {
        Throwable th;
        StringBuilder sb;
        Class<T> tClass = cls;
        List<?> list2 = list;
        for (Object o : list2) {
            if (!tClass.isInstance(o) && !tClass.isAssignableFrom(o.getClass())) {
                Throwable th2 = th;
                new StringBuilder();
                new ClassCastException(sb.append("Unable to convert ").append(o).append(" to type ").append(tClass.getName()).toString());
                throw th2;
            }
        }
        return list2;
    }

    private static <T extends Number> List<Float> toFloatList(List<T> list) {
        List<T> list2;
        List<T> value = list;
        new ArrayList<>(value.size());
        List<T> result = list2;
        for (T floatValue : value) {
            boolean add = result.add(Float.valueOf(floatValue.floatValue()));
        }
        return result;
    }

    private static <T extends Number> List<Long> toLongList(List<T> list) {
        List<T> list2;
        List<T> value = list;
        new ArrayList<>(value.size());
        List<T> result = list2;
        for (T longValue : value) {
            boolean add = result.add(Long.valueOf(longValue.longValue()));
        }
        return result;
    }

    private static <T extends Number> List<Integer> toIntList(List<T> list) {
        List<T> list2;
        List<T> value = list;
        new ArrayList<>(value.size());
        List<T> result = list2;
        for (T intValue : value) {
            boolean add = result.add(Integer.valueOf(intValue.intValue()));
        }
        return result;
    }

    private static List<Integer> toIntList(byte[] bArr) {
        List<Integer> list;
        byte[] values = bArr;
        new ArrayList(values.length);
        List<Integer> result = list;
        byte[] bArr2 = values;
        int length = bArr2.length;
        for (int i = 0; i < length; i++) {
            boolean add = result.add(Integer.valueOf(bArr2[i]));
        }
        return result;
    }

    private static <T> List<T> newArrayList(Iterator<? extends T> it) {
        List<T> list;
        Iterator<? extends T> it2 = it;
        new ArrayList();
        List<T> result = list;
        while (it2.hasNext()) {
            boolean add = result.add(it2.next());
        }
        return result;
    }

    private static Number stringToNumber(String value) {
        try {
            return Double.valueOf(Double.parseDouble(value));
        } catch (NumberFormatException e) {
            NumberFormatException numberFormatException = e;
            return null;
        }
    }

    private static <T> List<T> stringToList(Class<T> cls, String value, int size) {
        Class<T> tClass = cls;
        try {
            byte[] content = value.getBytes(size == 1 ? "UTF-8" : "UTF-16LE");
            if (tClass.equals(Integer.class)) {
                return checkedCast(tClass, toIntList(content));
            }
            return Collections.emptyList();
        } catch (UnsupportedEncodingException e) {
            int wtf = Log.wtf(LOG_TAG, "No support for UTF-8 or UTF-16", e);
            return Collections.emptyList();
        }
    }
}
