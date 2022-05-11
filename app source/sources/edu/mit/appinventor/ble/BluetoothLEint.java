package edu.mit.appinventor.ble;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.bluetooth.BluetoothManager;
import android.bluetooth.le.AdvertiseCallback;
import android.bluetooth.le.AdvertiseData;
import android.bluetooth.le.AdvertiseSettings;
import android.bluetooth.le.BluetoothLeAdvertiser;
import android.bluetooth.le.BluetoothLeScanner;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanFilter;
import android.bluetooth.le.ScanResult;
import android.bluetooth.le.ScanSettings;
import android.content.Intent;
import android.os.Handler;
import android.os.ParcelUuid;
import android.text.TextUtils;
import android.util.Log;
import com.google.appinventor.components.runtime.ActivityResultListener;
import com.google.appinventor.components.runtime.ComponentContainer;
import com.google.appinventor.components.runtime.EventDispatcher;
import com.google.appinventor.components.runtime.Form;
import com.google.appinventor.components.runtime.errors.IllegalArgumentError;
import com.google.appinventor.components.runtime.util.ErrorMessages;
import com.google.appinventor.components.runtime.util.SdkLevel;
import com.google.appinventor.components.runtime.util.YailList;
import com.shaded.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import edu.mit.appinventor.ble.BluetoothLE;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.UUID;

final class BluetoothLEint {
    private static final int ERROR_ADVERTISEMENTS_NOT_SUPPORTED = 9010;
    private static final int ERROR_API_LEVEL_TOO_LOW = 9003;
    private static final int ERROR_BLUETOOTH_LE_NOT_ENABLED = 9002;
    private static final int ERROR_BLUETOOTH_LE_NOT_SUPPORTED = 9001;
    private static final int ERROR_DEVICE_LIST_EMPTY = 9007;
    private static final int ERROR_INDEX_OUT_OF_BOUNDS = 9006;
    private static final int ERROR_INVALID_UUID_CHARACTERS = 9008;
    private static final int ERROR_INVALID_UUID_FORMAT = 9009;
    private static final int ERROR_NOT_CURRENTLY_CONNECTED = 9005;
    private static final int ERROR_NO_DEVICE_SCAN_IN_PROGRESS = 9004;
    private static final int ERROR_UNSUPPORTED_CHARACTERISTIC = 9011;
    private static final int GATT_LINK_LOSS = 8;
    private static final String LOG_TAG = "BluetoothLEint";
    private static final String UNKNOWN_CHAR_NAME = "Unknown Characteristic";
    private static final String UNKNOWN_SERVICE_NAME = "Unknown Service";
    private static final Map<Integer, String> errorMessages;
    private long SCAN_PERIOD;
    /* access modifiers changed from: private */
    public final Activity activity;
    private String advertisementScanResult;
    /* access modifiers changed from: private */
    public List<String> advertiserAddresses;
    /* access modifiers changed from: private */
    public boolean autoReconnect = false;
    private int battery;
    private String byteValue;
    private CharType charType;
    private String charUUIDList;
    private volatile int connectionTimeout = 10;
    /* access modifiers changed from: private */
    public final ComponentContainer container;
    private byte[] data;
    private byte[] descriptorValue;
    private String deviceInfoList;
    /* access modifiers changed from: private */
    public int device_rssi = 0;
    private int floatOffset;
    private float floatValue;
    private ArrayList<BluetoothGattCharacteristic> gattChars;
    /* access modifiers changed from: private */
    public HashMap<String, BluetoothGatt> gattMap;
    private int intOffset;
    private int intValue;
    private boolean isAdvertising;
    private boolean isCharRead;
    private boolean isCharWritten;
    /* access modifiers changed from: private */
    public volatile boolean isConnected;
    private boolean isScanning;
    private boolean isServiceRead;
    /* access modifiers changed from: private */
    public volatile boolean isUserDisconnect;
    /* access modifiers changed from: private */
    public AdvertiseCallback mAdvertiseCallback;
    /* access modifiers changed from: private */
    public ScanCallback mAdvertisementScanCallback;
    /* access modifiers changed from: private */
    public BluetoothGatt mBluetoothGatt;
    /* access modifiers changed from: private */
    public BluetoothLeScanner mBluetoothLeAdvertisementScanner;
    /* access modifiers changed from: private */
    public BluetoothLeAdvertiser mBluetoothLeAdvertiser;
    /* access modifiers changed from: private */
    public BluetoothLeScanner mBluetoothLeDeviceScanner = null;
    /* access modifiers changed from: private */
    public ScanCallback mDeviceScanCallback;
    /* access modifiers changed from: private */
    public BluetoothGattCallback mGattCallback;
    private BluetoothGattCharacteristic mGattChar;
    private List<BluetoothGattService> mGattService;
    /* access modifiers changed from: private */
    public Handler mHandler;
    /* access modifiers changed from: private */
    public HashMap<BluetoothDevice, Integer> mLeDeviceRssi;
    /* access modifiers changed from: private */
    public List<BluetoothDevice> mLeDevices;
    /* access modifiers changed from: private */
    public HashMap<String, String> nameToAddress;
    /* access modifiers changed from: private */
    public boolean nullTerminateStrings = true;
    /* access modifiers changed from: private */
    public final BluetoothLE outer;
    /* access modifiers changed from: private */
    public final Queue<BLEOperation> pendingOperations;
    /* access modifiers changed from: private */
    public final Map<UUID, List<BLEOperation>> pendingOperationsByUuid;
    /* access modifiers changed from: private */
    public List<String> scannedAdvertiserNames;
    /* access modifiers changed from: private */
    public HashMap<String, ScanResult> scannedAdvertisers;
    private String serviceUUIDList;
    private int strOffset;
    private String stringValue;
    private int txPower;
    /* access modifiers changed from: private */
    public final Handler uiThread;

    private enum CharType {
    }

    interface DeviceCallback {
        boolean foundDevice(String str, String str2);
    }

    static /* synthetic */ boolean access$1402(BluetoothLEint x0, boolean x1) {
        boolean z = x1;
        boolean z2 = z;
        x0.isScanning = z2;
        return z;
    }

    static /* synthetic */ boolean access$1702(BluetoothLEint x0, boolean x1) {
        boolean z = x1;
        boolean z2 = z;
        x0.isConnected = z2;
        return z;
    }

    static /* synthetic */ boolean access$1902(BluetoothLEint x0, boolean x1) {
        boolean z = x1;
        boolean z2 = z;
        x0.isUserDisconnect = z2;
        return z;
    }

    static /* synthetic */ List access$2102(BluetoothLEint x0, List x1) {
        List list = x1;
        List list2 = list;
        x0.mGattService = list2;
        return list;
    }

    static /* synthetic */ boolean access$2202(BluetoothLEint x0, boolean x1) {
        boolean z = x1;
        boolean z2 = z;
        x0.isServiceRead = z2;
        return z;
    }

    static /* synthetic */ byte[] access$2402(BluetoothLEint x0, byte[] x1) {
        byte[] bArr = x1;
        byte[] bArr2 = bArr;
        x0.descriptorValue = bArr2;
        return bArr;
    }

    static /* synthetic */ int access$2502(BluetoothLEint x0, int x1) {
        int i = x1;
        int i2 = i;
        x0.device_rssi = i2;
        return i;
    }

    static /* synthetic */ List access$2702(BluetoothLEint x0, List x1) {
        List list = x1;
        List list2 = list;
        x0.advertiserAddresses = list2;
        return list;
    }

    static /* synthetic */ HashMap access$2802(BluetoothLEint x0, HashMap x1) {
        HashMap hashMap = x1;
        HashMap hashMap2 = hashMap;
        x0.scannedAdvertisers = hashMap2;
        return hashMap;
    }

    static /* synthetic */ List access$2902(BluetoothLEint x0, List x1) {
        List list = x1;
        List list2 = list;
        x0.scannedAdvertiserNames = list2;
        return list;
    }

    static /* synthetic */ HashMap access$3002(BluetoothLEint x0, HashMap x1) {
        HashMap hashMap = x1;
        HashMap hashMap2 = hashMap;
        x0.nameToAddress = hashMap2;
        return hashMap;
    }

    static /* synthetic */ BluetoothLeScanner access$3302(BluetoothLEint x0, BluetoothLeScanner x1) {
        BluetoothLeScanner bluetoothLeScanner = x1;
        BluetoothLeScanner bluetoothLeScanner2 = bluetoothLeScanner;
        x0.mBluetoothLeDeviceScanner = bluetoothLeScanner2;
        return bluetoothLeScanner;
    }

    static /* synthetic */ BluetoothLeScanner access$3702(BluetoothLEint x0, BluetoothLeScanner x1) {
        BluetoothLeScanner bluetoothLeScanner = x1;
        BluetoothLeScanner bluetoothLeScanner2 = bluetoothLeScanner;
        x0.mBluetoothLeAdvertisementScanner = bluetoothLeScanner2;
        return bluetoothLeScanner;
    }

    static /* synthetic */ BluetoothGatt access$402(BluetoothLEint x0, BluetoothGatt x1) {
        BluetoothGatt bluetoothGatt = x1;
        BluetoothGatt bluetoothGatt2 = bluetoothGatt;
        x0.mBluetoothGatt = bluetoothGatt2;
        return bluetoothGatt;
    }

    static /* synthetic */ BluetoothLeAdvertiser access$4302(BluetoothLEint x0, BluetoothLeAdvertiser x1) {
        BluetoothLeAdvertiser bluetoothLeAdvertiser = x1;
        BluetoothLeAdvertiser bluetoothLeAdvertiser2 = bluetoothLeAdvertiser;
        x0.mBluetoothLeAdvertiser = bluetoothLeAdvertiser2;
        return bluetoothLeAdvertiser;
    }

    static /* synthetic */ boolean access$4402(BluetoothLEint x0, boolean x1) {
        boolean z = x1;
        boolean z2 = z;
        x0.isAdvertising = z2;
        return z;
    }

    static /* synthetic */ AdvertiseCallback access$4502(BluetoothLEint x0, AdvertiseCallback x1) {
        AdvertiseCallback advertiseCallback = x1;
        AdvertiseCallback advertiseCallback2 = advertiseCallback;
        x0.mAdvertiseCallback = advertiseCallback2;
        return advertiseCallback;
    }

    static /* synthetic */ long access$4602(BluetoothLEint x0, long x1) {
        long j = x1;
        long j2 = j;
        x0.SCAN_PERIOD = j2;
        return j;
    }

    private abstract class BLEAction<T> implements ActivityResultListener {
        private final String functionName;
        private final int requestEnableBT;
        final /* synthetic */ BluetoothLEint this$0;

        public abstract T action();

        BLEAction(BluetoothLEint bluetoothLEint, String functionName2) {
            BluetoothLEint bluetoothLEint2 = bluetoothLEint;
            this.this$0 = bluetoothLEint2;
            this.requestEnableBT = bluetoothLEint2.container.$form().registerForActivityResult(this);
            this.functionName = functionName2;
        }

        public final T run() {
            if (!this.this$0.container.$form().getPackageManager().hasSystemFeature("android.hardware.bluetooth_le")) {
                this.this$0.signalError(this.functionName, BluetoothLEint.ERROR_BLUETOOTH_LE_NOT_SUPPORTED, new Object[0]);
                return null;
            } else if (SdkLevel.getLevel() >= 21) {
                return action();
            } else {
                this.this$0.signalError(this.functionName, BluetoothLEint.ERROR_API_LEVEL_TOO_LOW, new Object[0]);
                return null;
            }
        }

        /* access modifiers changed from: package-private */
        public final BluetoothAdapter obtainBluetoothAdapter() {
            Intent intent;
            BluetoothAdapter bluetoothAdapter = ((BluetoothManager) this.this$0.activity.getSystemService("bluetooth")).getAdapter();
            if (bluetoothAdapter == null) {
                this.this$0.signalError(this.functionName, BluetoothLEint.ERROR_BLUETOOTH_LE_NOT_SUPPORTED, new Object[0]);
            } else if (!bluetoothAdapter.isEnabled()) {
                int i = Log.i(BluetoothLEint.LOG_TAG, "Bluetooth is not enabled, attempting to enable now...");
                new Intent("android.bluetooth.adapter.action.REQUEST_ENABLE");
                this.this$0.activity.startActivityForResult(intent, this.requestEnableBT);
            }
            return bluetoothAdapter;
        }

        public void resultReturned(int requestCode, int i, Intent intent) {
            int resultCode = i;
            Intent intent2 = intent;
            if (requestCode != this.requestEnableBT) {
                return;
            }
            if (resultCode == -1) {
                Object run = run();
            } else if (resultCode == 0) {
                this.this$0.signalError(this.functionName, BluetoothLEint.ERROR_BLUETOOTH_LE_NOT_ENABLED, new Object[0]);
            }
        }
    }

    public abstract class BLEOperation extends BluetoothGattCallback implements Runnable {
        static final int FORMAT_UTF16S = 2;
        static final int FORMAT_UTF8S = 1;
        protected final BluetoothGattCharacteristic characteristic;
        protected boolean needsRemoval = false;
        protected final int size;
        final /* synthetic */ BluetoothLEint this$0;
        protected final int type;

        public abstract boolean isNotify();

        public abstract boolean isRead();

        public abstract boolean isWrite();

        BLEOperation(BluetoothLEint this$02, BluetoothGattCharacteristic characteristic2, int i) {
            int type2 = i;
            this.this$0 = this$02;
            this.characteristic = characteristic2;
            this.type = type2;
            this.size = sizeofT(type2);
        }

        public void read(BluetoothGatt gatt) {
        }

        public void unsubscribe(BluetoothGatt gatt) {
        }

        /* access modifiers changed from: protected */
        public final int sizeofT(int type2) {
            switch (type2) {
                case 17:
                case 33:
                    return 1;
                case 18:
                case 34:
                case 50:
                    return 2;
                case 20:
                case 36:
                case 52:
                    return 4;
                default:
                    return -1;
            }
        }

        /* JADX INFO: finally extract failed */
        /* access modifiers changed from: protected */
        public final void registerPendingOperation() {
            Object obj;
            Map access$300 = this.this$0.pendingOperationsByUuid;
            Map map = access$300;
            synchronized (access$300) {
                try {
                    UUID uuid = this.characteristic.getUuid();
                    if (!this.this$0.pendingOperationsByUuid.containsKey(uuid)) {
                        new ArrayList();
                        Object put = this.this$0.pendingOperationsByUuid.put(uuid, obj);
                    }
                    if (!((List) this.this$0.pendingOperationsByUuid.get(uuid)).contains(this)) {
                        boolean add = ((List) this.this$0.pendingOperationsByUuid.get(uuid)).add(this);
                        this.needsRemoval = true;
                    }
                } catch (Throwable th) {
                    Throwable th2 = th;
                    Map map2 = map;
                    throw th2;
                }
            }
        }
    }

    private abstract class BLEReadOperation<T> extends BLEOperation {
        private int delay = 1;
        /* access modifiers changed from: private */
        public final BluetoothLE.BLEResponseHandler<T> handler;
        private final Class<T> mClass;
        private boolean notify = false;
        final /* synthetic */ BluetoothLEint this$0;

        /* access modifiers changed from: protected */
        public abstract void onReceive(List<T> list);

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        BLEReadOperation(edu.mit.appinventor.ble.BluetoothLEint r12, java.lang.Class<T> r13, android.bluetooth.BluetoothGattCharacteristic r14, int r15, edu.mit.appinventor.ble.BluetoothLE.BLEResponseHandler<T> r16, boolean r17) {
            /*
                r11 = this;
                r0 = r11
                r1 = r12
                r2 = r13
                r3 = r14
                r4 = r15
                r5 = r16
                r6 = r17
                r7 = r0
                r8 = r1
                r7.this$0 = r8
                r7 = r0
                r8 = r1
                r9 = r3
                r10 = r4
                r7.<init>(r8, r9, r10)
                r7 = r0
                r8 = 0
                r7.notify = r8
                r7 = r0
                r8 = 1
                r7.delay = r8
                r7 = r0
                r8 = r2
                r7.mClass = r8
                r7 = r0
                r8 = r5
                r7.handler = r8
                r7 = r0
                r8 = r6
                r7.notify = r8
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: edu.mit.appinventor.ble.BluetoothLEint.BLEReadOperation.<init>(edu.mit.appinventor.ble.BluetoothLEint, java.lang.Class, android.bluetooth.BluetoothGattCharacteristic, int, edu.mit.appinventor.ble.BluetoothLE$BLEResponseHandler, boolean):void");
        }

        public boolean isRead() {
            return true;
        }

        public boolean isNotify() {
            return this.notify;
        }

        public boolean isWrite() {
            return false;
        }

        public void run() {
            if (isNotify()) {
                subscribe(this.this$0.mBluetoothGatt);
            } else {
                read(this.this$0.mBluetoothGatt);
            }
        }

        public void read(BluetoothGatt bluetoothGatt) {
            StringBuilder sb;
            Runnable runnable;
            BluetoothGatt gatt = bluetoothGatt;
            if (gatt.readCharacteristic(this.characteristic)) {
                registerPendingOperation();
            } else if (this.delay > 2000) {
                int i = Log.i(BluetoothLEint.LOG_TAG, "Took too long to schedule read. Treating this as failure.");
            } else {
                new StringBuilder();
                int d = Log.d(BluetoothLEint.LOG_TAG, sb.append("Unable to read characteristic ").append(this.characteristic.getUuid()).append(". Deferring operation by ").append(this.delay).append("ms.").toString());
                final BluetoothGatt bluetoothGatt2 = gatt;
                new Runnable(this) {
                    final /* synthetic */ BLEReadOperation this$1;

                    {
                        this.this$1 = this$1;
                    }

                    public void run() {
                        this.this$1.read(bluetoothGatt2);
                    }
                };
                boolean postDelayed = this.this$0.mHandler.postDelayed(runnable, (long) this.delay);
                this.delay *= 2;
            }
        }

        public void subscribe(BluetoothGatt bluetoothGatt) {
            StringBuilder sb;
            StringBuilder sb2;
            Runnable runnable;
            BluetoothGatt gatt = bluetoothGatt;
            this.notify = true;
            registerPendingOperation();
            BluetoothGattDescriptor desc = this.characteristic.getDescriptor(BluetoothLEGattAttributes.CLIENT_CHARACTERISTIC_CONFIGURATION);
            boolean wroteDescriptor = false;
            if (desc != null) {
                if ((this.characteristic.getProperties() & 16) != 0) {
                    boolean value = desc.setValue(BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE);
                } else {
                    boolean value2 = desc.setValue(BluetoothGattDescriptor.ENABLE_INDICATION_VALUE);
                }
                boolean writeDescriptor = gatt.writeDescriptor(desc);
                wroteDescriptor = true;
            }
            if (gatt.setCharacteristicNotification(this.characteristic, true)) {
                if (!wroteDescriptor && this.this$0.runPendingOperation(this)) {
                    this.needsRemoval = false;
                }
                new StringBuilder();
                int d = Log.d(BluetoothLEint.LOG_TAG, sb.append("Subscribed for UUID: ").append(this.characteristic.getUuid()).toString());
            } else if (this.delay > 2000) {
                int i = Log.i(BluetoothLEint.LOG_TAG, "Took too long to subscribe. Treating this as failure.");
            } else {
                new StringBuilder();
                int d2 = Log.d(BluetoothLEint.LOG_TAG, sb2.append("Unable to set characteristic notification for ").append(this.characteristic.getUuid()).append(". Deferring operation by ").append(this.delay).append("ms.").toString());
                final BluetoothGatt bluetoothGatt2 = gatt;
                new Runnable(this) {
                    final /* synthetic */ BLEReadOperation this$1;

                    {
                        this.this$1 = this$1;
                    }

                    public void run() {
                        this.this$1.subscribe(bluetoothGatt2);
                    }
                };
                boolean postDelayed = this.this$0.mHandler.postDelayed(runnable, (long) this.delay);
                this.delay *= 2;
            }
        }

        /* JADX INFO: finally extract failed */
        public void unsubscribe(BluetoothGatt bluetoothGatt) {
            StringBuilder sb;
            Runnable runnable;
            BluetoothGatt gatt = bluetoothGatt;
            Map access$300 = this.this$0.pendingOperationsByUuid;
            Map map = access$300;
            synchronized (access$300) {
                if (gatt != null) {
                    try {
                        if (!gatt.setCharacteristicNotification(this.characteristic, false)) {
                            if (this.delay > 2000) {
                                int i = Log.i(BluetoothLEint.LOG_TAG, "Took too long to unsubscribe. Treating this as failure.");
                            } else {
                                new StringBuilder();
                                int d = Log.d(BluetoothLEint.LOG_TAG, sb.append("setCharacteristicNotification returned false. Deferring operation by ").append(this.delay).append("ms.").toString());
                                final BluetoothGatt bluetoothGatt2 = gatt;
                                new Runnable(this) {
                                    final /* synthetic */ BLEReadOperation this$1;

                                    {
                                        this.this$1 = this$1;
                                    }

                                    public void run() {
                                        this.this$1.unsubscribe(bluetoothGatt2);
                                    }
                                };
                                boolean postDelayed = this.this$0.mHandler.postDelayed(runnable, (long) this.delay);
                                this.delay *= 2;
                            }
                        }
                    } catch (Throwable th) {
                        Throwable th2 = th;
                        Map map2 = map;
                        throw th2;
                    }
                }
                boolean remove = ((List) this.this$0.pendingOperationsByUuid.get(this.characteristic.getUuid())).remove(this);
                this.notify = false;
            }
        }

        public void onCharacteristicChanged(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
            StringBuilder sb;
            Runnable runnable;
            BluetoothGatt bluetoothGatt2 = bluetoothGatt;
            BluetoothGattCharacteristic characteristic = bluetoothGattCharacteristic;
            if (this.characteristic == characteristic) {
                List<T> data = readCharacteristic();
                onReceive(data);
                new StringBuilder();
                int d = Log.d(BluetoothLEint.LOG_TAG, sb.append("handler = ").append(this.handler).toString());
                if (this.handler != null) {
                    int d2 = Log.d(BluetoothLEint.LOG_TAG, "Posting handler's onReceive to UI thread");
                    final BluetoothGattCharacteristic bluetoothGattCharacteristic2 = characteristic;
                    final List<T> list = data;
                    new Runnable(this) {
                        final /* synthetic */ BLEReadOperation this$1;

                        {
                            this.this$1 = this$1;
                        }

                        public void run() {
                            this.this$1.handler.onReceive(bluetoothGattCharacteristic2.getService().getUuid().toString(), bluetoothGattCharacteristic2.getUuid().toString(), list);
                        }
                    };
                    boolean post = this.this$0.mHandler.post(runnable);
                }
                if (this.needsRemoval && this.this$0.runPendingOperation(this)) {
                    this.needsRemoval = false;
                    return;
                }
                return;
            }
            int d3 = Log.d(BluetoothLEint.LOG_TAG, "Characteristic did not match");
        }

        public void onCharacteristicRead(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
            StringBuilder sb;
            StringBuilder sb2;
            StringBuilder sb3;
            Runnable runnable;
            StringBuilder sb4;
            StringBuilder sb5;
            StringBuilder sb6;
            BluetoothGatt bluetoothGatt2 = bluetoothGatt;
            BluetoothGattCharacteristic characteristic = bluetoothGattCharacteristic;
            int status = i;
            if (this.characteristic == characteristic) {
                switch (status) {
                    case 0:
                        List<T> data = readCharacteristic();
                        onReceive(data);
                        new StringBuilder();
                        int d = Log.d(BluetoothLEint.LOG_TAG, sb3.append("handler = ").append(this.handler).toString());
                        if (this.handler != null) {
                            int d2 = Log.d(BluetoothLEint.LOG_TAG, "Posting handler's onReceive to UI thread");
                            final BluetoothGattCharacteristic bluetoothGattCharacteristic2 = characteristic;
                            final List<T> list = data;
                            new Runnable(this) {
                                final /* synthetic */ BLEReadOperation this$1;

                                {
                                    this.this$1 = this$1;
                                }

                                public void run() {
                                    this.this$1.handler.onReceive(bluetoothGattCharacteristic2.getService().getUuid().toString(), bluetoothGattCharacteristic2.getUuid().toString(), list);
                                }
                            };
                            boolean post = this.this$0.mHandler.post(runnable);
                            break;
                        }
                        break;
                    default:
                        try {
                            new StringBuilder();
                            int e = Log.e(BluetoothLEint.LOG_TAG, sb6.append("Error code ").append(status).append(" from characteristic ").append(characteristic.getUuid()).toString());
                            break;
                        } catch (Throwable th) {
                            Throwable th2 = th;
                            boolean remove = ((List) this.this$0.pendingOperationsByUuid.get(characteristic.getUuid())).remove(this);
                            if (this.needsRemoval && this.this$0.runPendingOperation(this)) {
                                this.needsRemoval = false;
                            }
                            new StringBuilder();
                            int d3 = Log.d(BluetoothLEint.LOG_TAG, sb.append("pendingOperations.size() = ").append(this.this$0.pendingOperations.size()).toString());
                            new StringBuilder();
                            int d4 = Log.d(BluetoothLEint.LOG_TAG, sb2.append("pendingOperationsByUuid.size() = ").append(this.this$0.pendingOperationsByUuid.size()).toString());
                            throw th2;
                        }
                }
                boolean remove2 = ((List) this.this$0.pendingOperationsByUuid.get(characteristic.getUuid())).remove(this);
                if (this.needsRemoval && this.this$0.runPendingOperation(this)) {
                    this.needsRemoval = false;
                }
                new StringBuilder();
                int d5 = Log.d(BluetoothLEint.LOG_TAG, sb4.append("pendingOperations.size() = ").append(this.this$0.pendingOperations.size()).toString());
                new StringBuilder();
                int d6 = Log.d(BluetoothLEint.LOG_TAG, sb5.append("pendingOperationsByUuid.size() = ").append(this.this$0.pendingOperationsByUuid.size()).toString());
            }
        }

        public void onDescriptorRead(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor descriptor, int i) {
            StringBuilder sb;
            BluetoothGatt bluetoothGatt2 = bluetoothGatt;
            int i2 = i;
            new StringBuilder();
            int d = Log.d(BluetoothLEint.LOG_TAG, sb.append("onDescriptorRead: ").append(descriptor.getCharacteristic().getUuid()).toString());
            if (this.needsRemoval && this.this$0.runPendingOperation(this)) {
                this.needsRemoval = false;
            }
        }

        public void onDescriptorWrite(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor descriptor, int i) {
            StringBuilder sb;
            BluetoothGatt bluetoothGatt2 = bluetoothGatt;
            int i2 = i;
            new StringBuilder();
            int d = Log.d(BluetoothLEint.LOG_TAG, sb.append("onDescriptorWrite: ").append(descriptor.getCharacteristic().getUuid()).toString());
            if (this.needsRemoval && this.this$0.runPendingOperation(this)) {
                this.needsRemoval = false;
            }
        }

        /* access modifiers changed from: protected */
        public List<T> readCharacteristic() {
            StringBuilder sb;
            List<T> list;
            Reader reader;
            InputStream inputStream;
            StringBuilder sb2;
            List<T> list2;
            StringBuilder sb3;
            List<T> list3;
            new StringBuilder();
            int d = Log.d(BluetoothLEint.LOG_TAG, sb.append("Received bytes = ").append(Arrays.toString(this.characteristic.getValue())).toString());
            if (this.type == 1 || this.type == 2) {
                new ArrayList();
                List<T> result = list;
                try {
                    Reader reader2 = reader;
                    InputStream inputStream2 = inputStream;
                    new ByteArrayInputStream(this.characteristic.getValue());
                    new InputStreamReader(inputStream2, this.type == 1 ? "UTF-8" : "UTF-16LE");
                    Reader reader3 = reader2;
                    new StringBuilder();
                    StringBuilder sb4 = sb2;
                    while (true) {
                        int read = reader3.read();
                        int c = read;
                        if (read < 0) {
                            break;
                        } else if (c != 0) {
                            StringBuilder append = sb4.append(Character.toChars(c));
                        } else {
                            if (sb4.length() > 0) {
                                boolean add = result.add(this.mClass.cast(sb4.toString()));
                            }
                            sb4.setLength(0);
                        }
                    }
                    if (sb4.length() > 0) {
                        boolean add2 = result.add(this.mClass.cast(sb4.toString()));
                    }
                    if (reader3 != null) {
                        try {
                            reader3.close();
                        } catch (IOException e) {
                            IOException iOException = e;
                            int wtf = Log.wtf(BluetoothLEint.LOG_TAG, "Unable to close stream after IOException.");
                        }
                    }
                } catch (IOException e2) {
                    IOException iOException2 = e2;
                    int e3 = Log.e(BluetoothLEint.LOG_TAG, "Unable to read UTF-8 string from byte array.");
                    if (0 != 0) {
                        Reader reader4 = null;
                        try {
                            reader4.close();
                        } catch (IOException e4) {
                            int wtf2 = Log.wtf(BluetoothLEint.LOG_TAG, "Unable to close stream after IOException.");
                        }
                    }
                } catch (Throwable th) {
                    Throwable th2 = th;
                    if (0 != 0) {
                        Reader reader5 = null;
                        try {
                            reader5.close();
                        } catch (IOException e5) {
                            IOException iOException3 = e5;
                            int wtf3 = Log.wtf(BluetoothLEint.LOG_TAG, "Unable to close stream after IOException.");
                        }
                    }
                    throw th2;
                }
                return result;
            } else if (this.type == 52 || this.type == 50) {
                int elements = this.characteristic.getValue().length / this.size;
                new ArrayList(elements);
                List<T> values = list2;
                if (this.size == 4) {
                    ByteBuffer buffer = ByteBuffer.wrap(this.characteristic.getValue()).order(ByteOrder.LITTLE_ENDIAN);
                    for (int i = 0; i < elements; i++) {
                        boolean add3 = values.add(this.mClass.cast(Float.valueOf(buffer.getFloat(this.size * i))));
                    }
                } else {
                    for (int i2 = 0; i2 < elements; i2++) {
                        Float value = this.characteristic.getFloatValue(this.type, i2 * this.size);
                        if (value != null) {
                            boolean add4 = values.add(this.mClass.cast(value));
                        } else {
                            boolean add5 = values.add(this.mClass.cast(Float.valueOf(Float.NaN)));
                        }
                    }
                }
                return values;
            } else {
                int elements2 = this.characteristic.getValue().length / this.size;
                new StringBuilder();
                int d2 = Log.d(BluetoothLEint.LOG_TAG, sb3.append("Reading ").append(elements2).append(" elements of size ").append(this.size).toString());
                new ArrayList(elements2);
                List<T> values2 = list3;
                for (int i3 = 0; i3 < elements2; i3++) {
                    Integer value2 = this.characteristic.getIntValue(this.type, i3 * this.size);
                    if (value2 != null) {
                        boolean add6 = values2.add(this.mClass.cast(value2));
                    } else {
                        boolean add7 = values2.add(this.mClass.cast(0));
                    }
                }
                return values2;
            }
        }
    }

    private abstract class BLEWriteOperation<T> extends BLEOperation {
        /* access modifiers changed from: private */
        public List<T> data;
        /* access modifiers changed from: private */
        public BluetoothLE.BLEResponseHandler<T> handler;
        private final Class<T> mClass;
        final /* synthetic */ BluetoothLEint this$0;
        private final int writeType;

        /* access modifiers changed from: protected */
        public abstract void onWrite(List<T> list);

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        BLEWriteOperation(edu.mit.appinventor.ble.BluetoothLEint r12, java.lang.Class<T> r13, android.bluetooth.BluetoothGattCharacteristic r14, int r15, java.util.List<T> r16, int r17) {
            /*
                r11 = this;
                r0 = r11
                r1 = r12
                r2 = r13
                r3 = r14
                r4 = r15
                r5 = r16
                r6 = r17
                r7 = r0
                r8 = r1
                r7.this$0 = r8
                r7 = r0
                r8 = r1
                r9 = r3
                r10 = r4
                r7.<init>(r8, r9, r10)
                r7 = r0
                r8 = r2
                r7.mClass = r8
                r7 = r0
                r8 = r5
                r7.data = r8
                r7 = r0
                r8 = r6
                r7.writeType = r8
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: edu.mit.appinventor.ble.BluetoothLEint.BLEWriteOperation.<init>(edu.mit.appinventor.ble.BluetoothLEint, java.lang.Class, android.bluetooth.BluetoothGattCharacteristic, int, java.util.List, int):void");
        }

        public boolean isRead() {
            return false;
        }

        public boolean isNotify() {
            return false;
        }

        public boolean isWrite() {
            return true;
        }

        public void run() {
            write(this.this$0.mBluetoothGatt, this.writeType);
        }

        public void onCharacteristicWrite(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
            StringBuilder sb;
            StringBuilder sb2;
            Runnable runnable;
            StringBuilder sb3;
            StringBuilder sb4;
            StringBuilder sb5;
            BluetoothGatt bluetoothGatt2 = bluetoothGatt;
            BluetoothGattCharacteristic characteristic = bluetoothGattCharacteristic;
            int status = i;
            if (this.characteristic == characteristic) {
                switch (status) {
                    case 0:
                        onWrite(this.data);
                        if (this.handler != null) {
                            final BluetoothGattCharacteristic bluetoothGattCharacteristic2 = characteristic;
                            new Runnable(this) {
                                final /* synthetic */ BLEWriteOperation this$1;

                                {
                                    this.this$1 = this$1;
                                }

                                public void run() {
                                    this.this$1.handler.onWrite(bluetoothGattCharacteristic2.getService().getUuid().toString(), bluetoothGattCharacteristic2.getUuid().toString(), this.this$1.data);
                                }
                            };
                            boolean post = this.this$0.mHandler.post(runnable);
                            break;
                        }
                        break;
                    default:
                        try {
                            new StringBuilder();
                            int e = Log.e(BluetoothLEint.LOG_TAG, sb5.append("Error code ").append(status).append(" from characteristic ").append(characteristic.getUuid()).toString());
                            break;
                        } catch (Throwable th) {
                            Throwable th2 = th;
                            boolean remove = ((List) this.this$0.pendingOperationsByUuid.get(characteristic.getUuid())).remove(this);
                            if (this.needsRemoval && this.this$0.runPendingOperation(this)) {
                                this.needsRemoval = false;
                            }
                            new StringBuilder();
                            int d = Log.d(BluetoothLEint.LOG_TAG, sb.append("pendingOperations.size() = ").append(this.this$0.pendingOperations.size()).toString());
                            new StringBuilder();
                            int d2 = Log.d(BluetoothLEint.LOG_TAG, sb2.append("pendingOperationsByUuid.size() = ").append(this.this$0.pendingOperationsByUuid.size()).toString());
                            throw th2;
                        }
                }
                boolean remove2 = ((List) this.this$0.pendingOperationsByUuid.get(characteristic.getUuid())).remove(this);
                if (this.needsRemoval && this.this$0.runPendingOperation(this)) {
                    this.needsRemoval = false;
                }
                new StringBuilder();
                int d3 = Log.d(BluetoothLEint.LOG_TAG, sb3.append("pendingOperations.size() = ").append(this.this$0.pendingOperations.size()).toString());
                new StringBuilder();
                int d4 = Log.d(BluetoothLEint.LOG_TAG, sb4.append("pendingOperationsByUuid.size() = ").append(this.this$0.pendingOperationsByUuid.size()).toString());
            }
        }

        private void write(BluetoothGatt bluetoothGatt, int writeType2) {
            BluetoothGatt gatt = bluetoothGatt;
            registerPendingOperation();
            this.characteristic.setWriteType(writeType2);
            if (this.mClass == String.class) {
                byte[] str = ((String) this.data.get(0)).getBytes();
                int len = Math.min(23, str.length + (this.this$0.nullTerminateStrings ? 1 : 0));
                byte[] buffer = new byte[len];
                System.arraycopy(str, 0, buffer, 0, len - (this.this$0.nullTerminateStrings ? 1 : 0));
                if (this.this$0.nullTerminateStrings) {
                    buffer[len - 1] = 0;
                }
                boolean value = this.characteristic.setValue(buffer);
            } else if (this.mClass == Float.class) {
                byte[] contents = new byte[(this.size * this.data.size())];
                int i = 0;
                if (this.size == 4) {
                    for (T f : this.data) {
                        int value2 = Float.floatToIntBits(f.floatValue());
                        int i2 = i;
                        int i3 = i + 1;
                        contents[i2] = (byte) (value2 & 255);
                        int i4 = i3;
                        int i5 = i3 + 1;
                        contents[i4] = (byte) ((value2 >> 8) & 255);
                        int i6 = i5;
                        int i7 = i5 + 1;
                        contents[i6] = (byte) ((value2 >> 16) & 255);
                        int i8 = i7;
                        i = i7 + 1;
                        contents[i8] = (byte) ((value2 >> 24) & 255);
                    }
                } else {
                    for (T f2 : this.data) {
                        int value3 = Float.floatToIntBits(f2.floatValue());
                        int value4 = ((value3 & Integer.MIN_VALUE) >> 16) | ((((((value3 & 2139095040) >> 23) + 127) - 15) & 31) << 11) | ((value3 & 8384512) >> 13);
                        int i9 = i;
                        int i10 = i + 1;
                        contents[i9] = (byte) (value4 & 255);
                        int i11 = i10;
                        i = i10 + 1;
                        contents[i11] = (byte) ((value4 >> 8) & 255);
                    }
                }
                boolean value5 = this.characteristic.setValue(contents);
            } else {
                byte[] contents2 = new byte[(this.size * this.data.size())];
                int i12 = 0;
                for (T n : this.data) {
                    long value6 = n.longValue();
                    for (int j = 0; j < this.size; j++) {
                        int i13 = i12;
                        i12++;
                        contents2[i13] = (byte) ((int) (value6 & 255));
                        value6 >>= 8;
                    }
                }
                boolean value7 = this.characteristic.setValue(contents2);
            }
            boolean writeCharacteristic = gatt.writeCharacteristic(this.characteristic);
        }

        public void write(BluetoothGatt gatt) {
            write(gatt, 1);
        }

        public void writeWithResponse(BluetoothGatt gatt, BluetoothLE.BLEResponseHandler<T> handler2) {
            this.handler = handler2;
            write(gatt, 1);
        }
    }

    class BLEReadByteOperation extends BLEReadOperation<Integer> {
        final /* synthetic */ BluetoothLEint this$0;

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        BLEReadByteOperation(BluetoothLEint this$02, BluetoothGattCharacteristic characteristic, boolean signed, BluetoothLE.BLEResponseHandler<Integer> handler) {
            this(this$02, characteristic, signed, handler, false);
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        BLEReadByteOperation(edu.mit.appinventor.ble.BluetoothLEint r14, android.bluetooth.BluetoothGattCharacteristic r15, boolean r16, edu.mit.appinventor.ble.BluetoothLE.BLEResponseHandler<java.lang.Integer> r17, boolean r18) {
            /*
                r13 = this;
                r0 = r13
                r1 = r14
                r2 = r15
                r3 = r16
                r4 = r17
                r5 = r18
                r6 = r0
                r7 = r1
                r6.this$0 = r7
                r6 = r0
                r7 = r1
                java.lang.Class<java.lang.Integer> r8 = java.lang.Integer.class
                r9 = r2
                r10 = r3
                if (r10 == 0) goto L_0x001d
                r10 = 33
            L_0x0017:
                r11 = r4
                r12 = r5
                r6.<init>(r7, r8, r9, r10, r11, r12)
                return
            L_0x001d:
                r10 = 17
                goto L_0x0017
            */
            throw new UnsupportedOperationException("Method not decompiled: edu.mit.appinventor.ble.BluetoothLEint.BLEReadByteOperation.<init>(edu.mit.appinventor.ble.BluetoothLEint, android.bluetooth.BluetoothGattCharacteristic, boolean, edu.mit.appinventor.ble.BluetoothLE$BLEResponseHandler, boolean):void");
        }

        /* access modifiers changed from: protected */
        public void onReceive(List<Integer> values) {
            Runnable runnable;
            final YailList makeList = YailList.makeList((List) values);
            new Runnable(this) {
                final /* synthetic */ BLEReadByteOperation this$1;

                {
                    this.this$1 = this$1;
                }

                public void run() {
                    this.this$1.this$0.outer.BytesReceived(this.this$1.characteristic.getService().getUuid().toString(), this.this$1.characteristic.getUuid().toString(), makeList);
                }
            };
            boolean post = this.this$0.mHandler.post(runnable);
        }
    }

    class BLEReadShortOperation extends BLEReadOperation<Integer> {
        final /* synthetic */ BluetoothLEint this$0;

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        BLEReadShortOperation(BluetoothLEint this$02, BluetoothGattCharacteristic characteristic, boolean signed, BluetoothLE.BLEResponseHandler<Integer> handler) {
            this(this$02, characteristic, signed, handler, false);
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        BLEReadShortOperation(edu.mit.appinventor.ble.BluetoothLEint r14, android.bluetooth.BluetoothGattCharacteristic r15, boolean r16, edu.mit.appinventor.ble.BluetoothLE.BLEResponseHandler<java.lang.Integer> r17, boolean r18) {
            /*
                r13 = this;
                r0 = r13
                r1 = r14
                r2 = r15
                r3 = r16
                r4 = r17
                r5 = r18
                r6 = r0
                r7 = r1
                r6.this$0 = r7
                r6 = r0
                r7 = r1
                java.lang.Class<java.lang.Integer> r8 = java.lang.Integer.class
                r9 = r2
                r10 = r3
                if (r10 == 0) goto L_0x001d
                r10 = 34
            L_0x0017:
                r11 = r4
                r12 = r5
                r6.<init>(r7, r8, r9, r10, r11, r12)
                return
            L_0x001d:
                r10 = 18
                goto L_0x0017
            */
            throw new UnsupportedOperationException("Method not decompiled: edu.mit.appinventor.ble.BluetoothLEint.BLEReadShortOperation.<init>(edu.mit.appinventor.ble.BluetoothLEint, android.bluetooth.BluetoothGattCharacteristic, boolean, edu.mit.appinventor.ble.BluetoothLE$BLEResponseHandler, boolean):void");
        }

        /* access modifiers changed from: protected */
        public void onReceive(List<Integer> values) {
            Runnable runnable;
            final YailList makeList = YailList.makeList((List) values);
            new Runnable(this) {
                final /* synthetic */ BLEReadShortOperation this$1;

                {
                    this.this$1 = this$1;
                }

                public void run() {
                    this.this$1.this$0.outer.ShortsReceived(this.this$1.characteristic.getService().getUuid().toString(), this.this$1.characteristic.getUuid().toString(), makeList);
                }
            };
            boolean post = this.this$0.mHandler.post(runnable);
        }
    }

    class BLEReadIntegerOperation extends BLEReadOperation<Long> {
        final /* synthetic */ BluetoothLEint this$0;

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        BLEReadIntegerOperation(BluetoothLEint this$02, BluetoothGattCharacteristic characteristic, boolean signed, BluetoothLE.BLEResponseHandler<Long> handler) {
            this(this$02, characteristic, signed, handler, false);
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        BLEReadIntegerOperation(edu.mit.appinventor.ble.BluetoothLEint r14, android.bluetooth.BluetoothGattCharacteristic r15, boolean r16, edu.mit.appinventor.ble.BluetoothLE.BLEResponseHandler<java.lang.Long> r17, boolean r18) {
            /*
                r13 = this;
                r0 = r13
                r1 = r14
                r2 = r15
                r3 = r16
                r4 = r17
                r5 = r18
                r6 = r0
                r7 = r1
                r6.this$0 = r7
                r6 = r0
                r7 = r1
                java.lang.Class<java.lang.Long> r8 = java.lang.Long.class
                r9 = r2
                r10 = r3
                if (r10 == 0) goto L_0x001d
                r10 = 36
            L_0x0017:
                r11 = r4
                r12 = r5
                r6.<init>(r7, r8, r9, r10, r11, r12)
                return
            L_0x001d:
                r10 = 20
                goto L_0x0017
            */
            throw new UnsupportedOperationException("Method not decompiled: edu.mit.appinventor.ble.BluetoothLEint.BLEReadIntegerOperation.<init>(edu.mit.appinventor.ble.BluetoothLEint, android.bluetooth.BluetoothGattCharacteristic, boolean, edu.mit.appinventor.ble.BluetoothLE$BLEResponseHandler, boolean):void");
        }

        /* access modifiers changed from: protected */
        public void onReceive(List<Long> values) {
            Runnable runnable;
            final YailList makeList = YailList.makeList((List) values);
            new Runnable(this) {
                final /* synthetic */ BLEReadIntegerOperation this$1;

                {
                    this.this$1 = this$1;
                }

                public void run() {
                    this.this$1.this$0.outer.IntegersReceived(this.this$1.characteristic.getService().getUuid().toString(), this.this$1.characteristic.getUuid().toString(), makeList);
                }
            };
            boolean post = this.this$0.mHandler.post(runnable);
        }
    }

    class BLEReadFloatOperation extends BLEReadOperation<Float> {
        final /* synthetic */ BluetoothLEint this$0;

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        BLEReadFloatOperation(BluetoothLEint this$02, BluetoothGattCharacteristic characteristic, boolean shortFloat, BluetoothLE.BLEResponseHandler<Float> handler) {
            this(this$02, characteristic, shortFloat, handler, false);
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        BLEReadFloatOperation(edu.mit.appinventor.ble.BluetoothLEint r14, android.bluetooth.BluetoothGattCharacteristic r15, boolean r16, edu.mit.appinventor.ble.BluetoothLE.BLEResponseHandler<java.lang.Float> r17, boolean r18) {
            /*
                r13 = this;
                r0 = r13
                r1 = r14
                r2 = r15
                r3 = r16
                r4 = r17
                r5 = r18
                r6 = r0
                r7 = r1
                r6.this$0 = r7
                r6 = r0
                r7 = r1
                java.lang.Class<java.lang.Float> r8 = java.lang.Float.class
                r9 = r2
                r10 = r3
                if (r10 == 0) goto L_0x001d
                r10 = 50
            L_0x0017:
                r11 = r4
                r12 = r5
                r6.<init>(r7, r8, r9, r10, r11, r12)
                return
            L_0x001d:
                r10 = 52
                goto L_0x0017
            */
            throw new UnsupportedOperationException("Method not decompiled: edu.mit.appinventor.ble.BluetoothLEint.BLEReadFloatOperation.<init>(edu.mit.appinventor.ble.BluetoothLEint, android.bluetooth.BluetoothGattCharacteristic, boolean, edu.mit.appinventor.ble.BluetoothLE$BLEResponseHandler, boolean):void");
        }

        public void onReceive(List<Float> values) {
            Runnable runnable;
            final YailList makeList = YailList.makeList((List) values);
            new Runnable(this) {
                final /* synthetic */ BLEReadFloatOperation this$1;

                {
                    this.this$1 = this$1;
                }

                public void run() {
                    this.this$1.this$0.outer.FloatsReceived(this.this$1.characteristic.getService().getUuid().toString(), this.this$1.characteristic.getUuid().toString(), makeList);
                }
            };
            boolean post = this.this$0.mHandler.post(runnable);
        }
    }

    class BLEReadStringOperation extends BLEReadOperation<String> {
        final /* synthetic */ BluetoothLEint this$0;

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        BLEReadStringOperation(BluetoothLEint this$02, BluetoothGattCharacteristic characteristic, boolean utf16, BluetoothLE.BLEResponseHandler<String> handler) {
            this(this$02, characteristic, utf16, handler, false);
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        BLEReadStringOperation(edu.mit.appinventor.ble.BluetoothLEint r14, android.bluetooth.BluetoothGattCharacteristic r15, boolean r16, edu.mit.appinventor.ble.BluetoothLE.BLEResponseHandler<java.lang.String> r17, boolean r18) {
            /*
                r13 = this;
                r0 = r13
                r1 = r14
                r2 = r15
                r3 = r16
                r4 = r17
                r5 = r18
                r6 = r0
                r7 = r1
                r6.this$0 = r7
                r6 = r0
                r7 = r1
                java.lang.Class<java.lang.String> r8 = java.lang.String.class
                r9 = r2
                r10 = r3
                if (r10 == 0) goto L_0x001c
                r10 = 2
            L_0x0016:
                r11 = r4
                r12 = r5
                r6.<init>(r7, r8, r9, r10, r11, r12)
                return
            L_0x001c:
                r10 = 1
                goto L_0x0016
            */
            throw new UnsupportedOperationException("Method not decompiled: edu.mit.appinventor.ble.BluetoothLEint.BLEReadStringOperation.<init>(edu.mit.appinventor.ble.BluetoothLEint, android.bluetooth.BluetoothGattCharacteristic, boolean, edu.mit.appinventor.ble.BluetoothLE$BLEResponseHandler, boolean):void");
        }

        public void onReceive(List<String> values) {
            Runnable runnable;
            final YailList makeList = YailList.makeList((List) values);
            new Runnable(this) {
                final /* synthetic */ BLEReadStringOperation this$1;

                {
                    this.this$1 = this$1;
                }

                public void run() {
                    this.this$1.this$0.outer.StringsReceived(this.this$1.characteristic.getService().getUuid().toString(), this.this$1.characteristic.getUuid().toString(), makeList);
                }
            };
            boolean post = this.this$0.mHandler.post(runnable);
        }
    }

    class BLEReadPacketOperation extends BLEReadOperation<BLEPacketReader> {
        /* access modifiers changed from: private */
        public final BluetoothLE.BLEPacketHandler handler;
        final /* synthetic */ BluetoothLEint this$0;

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        BLEReadPacketOperation(edu.mit.appinventor.ble.BluetoothLEint r13, android.bluetooth.BluetoothGattCharacteristic r14, boolean r15, edu.mit.appinventor.ble.BluetoothLE.BLEPacketHandler r16) {
            /*
                r12 = this;
                r0 = r12
                r1 = r13
                r2 = r14
                r3 = r15
                r4 = r16
                r5 = r0
                r6 = r1
                r5.this$0 = r6
                r5 = r0
                r6 = r1
                java.lang.Class<edu.mit.appinventor.ble.BLEPacketReader> r7 = edu.mit.appinventor.ble.BLEPacketReader.class
                r8 = r2
                r9 = 33
                r10 = 0
                r11 = r3
                r5.<init>(r6, r7, r8, r9, r10, r11)
                r5 = r0
                r6 = r4
                r5.handler = r6
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: edu.mit.appinventor.ble.BluetoothLEint.BLEReadPacketOperation.<init>(edu.mit.appinventor.ble.BluetoothLEint, android.bluetooth.BluetoothGattCharacteristic, boolean, edu.mit.appinventor.ble.BluetoothLE$BLEPacketHandler):void");
        }

        /* access modifiers changed from: protected */
        public void onReceive(List<BLEPacketReader> values) {
            Runnable runnable;
            final BLEPacketReader bLEPacketReader = values.get(0);
            new Runnable(this) {
                final /* synthetic */ BLEReadPacketOperation this$1;

                {
                    this.this$1 = this$1;
                }

                public void run() {
                    this.this$1.handler.onPacketReceived(this.this$1.characteristic.getService().getUuid().toString(), this.this$1.characteristic.getUuid().toString(), bLEPacketReader);
                }
            };
            boolean post = this.this$0.mHandler.post(runnable);
        }

        /* access modifiers changed from: protected */
        public List<BLEPacketReader> readCharacteristic() {
            Object obj;
            new BLEPacketReader(this.characteristic.getValue());
            return Collections.singletonList(obj);
        }
    }

    class BLEWriteBytesOperation extends BLEWriteOperation<Integer> {
        final /* synthetic */ BluetoothLEint this$0;

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        BLEWriteBytesOperation(edu.mit.appinventor.ble.BluetoothLEint r14, android.bluetooth.BluetoothGattCharacteristic r15, boolean r16, java.util.List<java.lang.Integer> r17, int r18) {
            /*
                r13 = this;
                r0 = r13
                r1 = r14
                r2 = r15
                r3 = r16
                r4 = r17
                r5 = r18
                r6 = r0
                r7 = r1
                r6.this$0 = r7
                r6 = r0
                r7 = r1
                java.lang.Class<java.lang.Integer> r8 = java.lang.Integer.class
                r9 = r2
                r10 = r3
                if (r10 == 0) goto L_0x001d
                r10 = 33
            L_0x0017:
                r11 = r4
                r12 = r5
                r6.<init>(r7, r8, r9, r10, r11, r12)
                return
            L_0x001d:
                r10 = 17
                goto L_0x0017
            */
            throw new UnsupportedOperationException("Method not decompiled: edu.mit.appinventor.ble.BluetoothLEint.BLEWriteBytesOperation.<init>(edu.mit.appinventor.ble.BluetoothLEint, android.bluetooth.BluetoothGattCharacteristic, boolean, java.util.List, int):void");
        }

        public void onWrite(List<Integer> values) {
            Runnable runnable;
            final YailList makeList = YailList.makeList((List) values);
            new Runnable(this) {
                final /* synthetic */ BLEWriteBytesOperation this$1;

                {
                    this.this$1 = this$1;
                }

                public void run() {
                    this.this$1.this$0.outer.BytesWritten(this.this$1.characteristic.getService().getUuid().toString(), this.this$1.characteristic.getUuid().toString(), makeList);
                }
            };
            boolean post = this.this$0.mHandler.post(runnable);
        }
    }

    class BLEWriteShortsOperation extends BLEWriteOperation<Integer> {
        final /* synthetic */ BluetoothLEint this$0;

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        BLEWriteShortsOperation(edu.mit.appinventor.ble.BluetoothLEint r14, android.bluetooth.BluetoothGattCharacteristic r15, boolean r16, java.util.List<java.lang.Integer> r17, int r18) {
            /*
                r13 = this;
                r0 = r13
                r1 = r14
                r2 = r15
                r3 = r16
                r4 = r17
                r5 = r18
                r6 = r0
                r7 = r1
                r6.this$0 = r7
                r6 = r0
                r7 = r1
                java.lang.Class<java.lang.Integer> r8 = java.lang.Integer.class
                r9 = r2
                r10 = r3
                if (r10 == 0) goto L_0x001d
                r10 = 34
            L_0x0017:
                r11 = r4
                r12 = r5
                r6.<init>(r7, r8, r9, r10, r11, r12)
                return
            L_0x001d:
                r10 = 18
                goto L_0x0017
            */
            throw new UnsupportedOperationException("Method not decompiled: edu.mit.appinventor.ble.BluetoothLEint.BLEWriteShortsOperation.<init>(edu.mit.appinventor.ble.BluetoothLEint, android.bluetooth.BluetoothGattCharacteristic, boolean, java.util.List, int):void");
        }

        public void onWrite(List<Integer> values) {
            Runnable runnable;
            final YailList makeList = YailList.makeList((List) values);
            new Runnable(this) {
                final /* synthetic */ BLEWriteShortsOperation this$1;

                {
                    this.this$1 = this$1;
                }

                public void run() {
                    this.this$1.this$0.outer.ShortsWritten(this.this$1.characteristic.getService().getUuid().toString(), this.this$1.characteristic.getUuid().toString(), makeList);
                }
            };
            boolean post = this.this$0.mHandler.post(runnable);
        }
    }

    class BLEWriteIntegersOperation extends BLEWriteOperation<Long> {
        final /* synthetic */ BluetoothLEint this$0;

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        BLEWriteIntegersOperation(edu.mit.appinventor.ble.BluetoothLEint r14, android.bluetooth.BluetoothGattCharacteristic r15, boolean r16, java.util.List<java.lang.Long> r17, int r18) {
            /*
                r13 = this;
                r0 = r13
                r1 = r14
                r2 = r15
                r3 = r16
                r4 = r17
                r5 = r18
                r6 = r0
                r7 = r1
                r6.this$0 = r7
                r6 = r0
                r7 = r1
                java.lang.Class<java.lang.Long> r8 = java.lang.Long.class
                r9 = r2
                r10 = r3
                if (r10 == 0) goto L_0x001d
                r10 = 36
            L_0x0017:
                r11 = r4
                r12 = r5
                r6.<init>(r7, r8, r9, r10, r11, r12)
                return
            L_0x001d:
                r10 = 20
                goto L_0x0017
            */
            throw new UnsupportedOperationException("Method not decompiled: edu.mit.appinventor.ble.BluetoothLEint.BLEWriteIntegersOperation.<init>(edu.mit.appinventor.ble.BluetoothLEint, android.bluetooth.BluetoothGattCharacteristic, boolean, java.util.List, int):void");
        }

        public void onWrite(List<Long> values) {
            Runnable runnable;
            final YailList makeList = YailList.makeList((List) values);
            new Runnable(this) {
                final /* synthetic */ BLEWriteIntegersOperation this$1;

                {
                    this.this$1 = this$1;
                }

                public void run() {
                    this.this$1.this$0.outer.IntegersWritten(this.this$1.characteristic.getService().getUuid().toString(), this.this$1.characteristic.getUuid().toString(), makeList);
                }
            };
            boolean post = this.this$0.mHandler.post(runnable);
        }
    }

    class BLEWriteFloatsOperation extends BLEWriteOperation<Float> {
        final /* synthetic */ BluetoothLEint this$0;

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        BLEWriteFloatsOperation(edu.mit.appinventor.ble.BluetoothLEint r14, android.bluetooth.BluetoothGattCharacteristic r15, boolean r16, java.util.List<java.lang.Float> r17, int r18) {
            /*
                r13 = this;
                r0 = r13
                r1 = r14
                r2 = r15
                r3 = r16
                r4 = r17
                r5 = r18
                r6 = r0
                r7 = r1
                r6.this$0 = r7
                r6 = r0
                r7 = r1
                java.lang.Class<java.lang.Float> r8 = java.lang.Float.class
                r9 = r2
                r10 = r3
                if (r10 == 0) goto L_0x001d
                r10 = 50
            L_0x0017:
                r11 = r4
                r12 = r5
                r6.<init>(r7, r8, r9, r10, r11, r12)
                return
            L_0x001d:
                r10 = 52
                goto L_0x0017
            */
            throw new UnsupportedOperationException("Method not decompiled: edu.mit.appinventor.ble.BluetoothLEint.BLEWriteFloatsOperation.<init>(edu.mit.appinventor.ble.BluetoothLEint, android.bluetooth.BluetoothGattCharacteristic, boolean, java.util.List, int):void");
        }

        public void onWrite(List<Float> values) {
            Runnable runnable;
            final YailList makeList = YailList.makeList((List) values);
            new Runnable(this) {
                final /* synthetic */ BLEWriteFloatsOperation this$1;

                {
                    this.this$1 = this$1;
                }

                public void run() {
                    this.this$1.this$0.outer.FloatsWritten(this.this$1.characteristic.getService().getUuid().toString(), this.this$1.characteristic.getUuid().toString(), makeList);
                }
            };
            boolean post = this.this$0.mHandler.post(runnable);
        }
    }

    class BLEWriteStringsOperation extends BLEWriteOperation<String> {
        final /* synthetic */ BluetoothLEint this$0;

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        BLEWriteStringsOperation(edu.mit.appinventor.ble.BluetoothLEint r14, android.bluetooth.BluetoothGattCharacteristic r15, boolean r16, java.util.List<java.lang.String> r17, int r18) {
            /*
                r13 = this;
                r0 = r13
                r1 = r14
                r2 = r15
                r3 = r16
                r4 = r17
                r5 = r18
                r6 = r0
                r7 = r1
                r6.this$0 = r7
                r6 = r0
                r7 = r1
                java.lang.Class<java.lang.String> r8 = java.lang.String.class
                r9 = r2
                r10 = r3
                if (r10 == 0) goto L_0x001c
                r10 = 2
            L_0x0016:
                r11 = r4
                r12 = r5
                r6.<init>(r7, r8, r9, r10, r11, r12)
                return
            L_0x001c:
                r10 = 1
                goto L_0x0016
            */
            throw new UnsupportedOperationException("Method not decompiled: edu.mit.appinventor.ble.BluetoothLEint.BLEWriteStringsOperation.<init>(edu.mit.appinventor.ble.BluetoothLEint, android.bluetooth.BluetoothGattCharacteristic, boolean, java.util.List, int):void");
        }

        public void onWrite(List<String> values) {
            Runnable runnable;
            final YailList makeList = YailList.makeList((List) values);
            new Runnable(this) {
                final /* synthetic */ BLEWriteStringsOperation this$1;

                {
                    this.this$1 = this$1;
                }

                public void run() {
                    this.this$1.this$0.outer.StringsWritten(this.this$1.characteristic.getService().getUuid().toString(), this.this$1.characteristic.getUuid().toString(), makeList);
                }
            };
            boolean post = this.this$0.mHandler.post(runnable);
        }
    }

    static {
        Map<Integer, String> map;
        new HashMap();
        errorMessages = map;
        String put = errorMessages.put(Integer.valueOf(ERROR_BLUETOOTH_LE_NOT_SUPPORTED), "BluetoothLE is not supported on your phone's hardware!");
        String put2 = errorMessages.put(Integer.valueOf(ERROR_BLUETOOTH_LE_NOT_ENABLED), "BluetoothLE is not enabled!");
        String put3 = errorMessages.put(Integer.valueOf(ERROR_API_LEVEL_TOO_LOW), "BluetoothLE requires Android 5.0 or newer!");
        String put4 = errorMessages.put(Integer.valueOf(ERROR_NO_DEVICE_SCAN_IN_PROGRESS), "StopScan cannot be called before StartScan! There is no scan currently in progress.");
        String put5 = errorMessages.put(Integer.valueOf(ERROR_NOT_CURRENTLY_CONNECTED), "Disconnect cannot be called before you are connected! There is no Bluetooth LE device currently connected.");
        String put6 = errorMessages.put(Integer.valueOf(ERROR_INDEX_OUT_OF_BOUNDS), "Block %1s attempted to access %2s with an invalid index. Index out of bounds!");
        String put7 = errorMessages.put(Integer.valueOf(ERROR_DEVICE_LIST_EMPTY), "You cannot connect to a device when the device list is empty! Try scanning again.");
        String put8 = errorMessages.put(Integer.valueOf(ERROR_INVALID_UUID_CHARACTERS), "%1s UUID string in block %2s contains invalid characters! Try typing it in again and rebuilding your app.");
        String put9 = errorMessages.put(Integer.valueOf(ERROR_INVALID_UUID_FORMAT), "%1s UUID string in block %2s does not use the proper format! Try typing it in again and rebuilding your app.");
        String put10 = errorMessages.put(Integer.valueOf(ERROR_ADVERTISEMENTS_NOT_SUPPORTED), "Bluetooth Advertisements not supported!");
    }

    BluetoothLEint(BluetoothLE bluetoothLE, Activity activity2, ComponentContainer container2) {
        Map<UUID, List<BLEOperation>> map;
        Queue<BLEOperation> queue;
        Handler handler;
        List<String> list;
        HashMap<String, ScanResult> hashMap;
        List<String> list2;
        HashMap<String, String> hashMap2;
        List<BluetoothDevice> list3;
        List<BluetoothGattService> list4;
        ArrayList<BluetoothGattCharacteristic> arrayList;
        HashMap<BluetoothDevice, Integer> hashMap3;
        HashMap<String, BluetoothGatt> hashMap4;
        Handler handler2;
        ScanCallback scanCallback;
        BluetoothGattCallback bluetoothGattCallback;
        ScanCallback scanCallback2;
        BluetoothLE outer2 = bluetoothLE;
        new HashMap();
        this.pendingOperationsByUuid = map;
        new LinkedList();
        this.pendingOperations = queue;
        this.deviceInfoList = "";
        this.isScanning = false;
        this.isConnected = false;
        this.isUserDisconnect = false;
        this.isCharRead = false;
        this.isCharWritten = false;
        this.isServiceRead = false;
        this.battery = -1;
        this.txPower = -1;
        this.intValue = 0;
        this.floatValue = 0.0f;
        this.stringValue = "";
        this.byteValue = "";
        this.intOffset = 0;
        this.strOffset = 0;
        this.floatOffset = 0;
        this.charType = CharType.BYTE;
        new Handler();
        this.mHandler = handler;
        this.SCAN_PERIOD = 5000;
        this.advertisementScanResult = "";
        new ArrayList();
        this.scannedAdvertiserNames = list;
        new HashMap<>();
        this.scannedAdvertisers = hashMap;
        new ArrayList();
        this.advertiserAddresses = list2;
        new HashMap<>();
        this.nameToAddress = hashMap2;
        this.isAdvertising = false;
        this.outer = outer2;
        this.activity = activity2;
        this.container = container2;
        new ArrayList();
        this.mLeDevices = list3;
        new ArrayList();
        this.mGattService = list4;
        new ArrayList<>();
        this.gattChars = arrayList;
        new HashMap<>();
        this.mLeDeviceRssi = hashMap3;
        new HashMap<>();
        this.gattMap = hashMap4;
        new Handler();
        this.uiThread = handler2;
        new ScanCallback(this) {
            final /* synthetic */ BluetoothLEint this$0;

            {
                this.this$0 = this$0;
            }

            public void onScanResult(int callbackType, ScanResult scanResult) {
                Runnable runnable;
                ScanResult scanResult2 = scanResult;
                super.onScanResult(callbackType, scanResult2);
                if (scanResult2 != null && scanResult2.getDevice() != null) {
                    final ScanResult scanResult3 = scanResult2;
                    new Runnable(this) {
                        final /* synthetic */ AnonymousClass1 this$1;

                        {
                            this.this$1 = this$1;
                        }

                        public void run() {
                            boolean access$1402 = BluetoothLEint.access$1402(this.this$1.this$0, true);
                            this.this$1.this$0.addDevice(scanResult3.getDevice(), scanResult3.getRssi());
                        }
                    };
                    boolean post = this.this$0.uiThread.post(runnable);
                }
            }

            public void onBatchScanResults(List<ScanResult> results) {
                super.onBatchScanResults(results);
            }

            public void onScanFailed(int i) {
                StringBuilder sb;
                int errorCode = i;
                switch (errorCode) {
                    case 1:
                        int e = Log.e(BluetoothLEint.LOG_TAG, "Device Scan failed. There is already a scan in progress.");
                        break;
                    default:
                        boolean access$1402 = BluetoothLEint.access$1402(this.this$0, false);
                        new StringBuilder();
                        int e2 = Log.e(BluetoothLEint.LOG_TAG, sb.append("Device Scan failed due to an internal error. Error Code: ").append(errorCode).toString());
                        break;
                }
                super.onScanFailed(errorCode);
            }
        };
        this.mDeviceScanCallback = scanCallback;
        final BluetoothLE bluetoothLE2 = outer2;
        new BluetoothGattCallback(this) {
            final /* synthetic */ BluetoothLEint this$0;

            {
                this.this$0 = this$0;
            }

            public void onConnectionStateChange(BluetoothGatt bluetoothGatt, int i, int i2) {
                StringBuilder sb;
                StringBuilder sb2;
                StringBuilder sb3;
                BluetoothGatt gatt = bluetoothGatt;
                int status = i;
                int newState = i2;
                if (gatt == this.this$0.mBluetoothGatt) {
                    if (newState == 2) {
                        boolean discoverServices = gatt.discoverServices();
                        boolean readRemoteRssi = gatt.readRemoteRssi();
                        int i3 = Log.i(BluetoothLEint.LOG_TAG, "Connect successful.");
                    } else if (newState == 0) {
                        boolean access$1702 = BluetoothLEint.access$1702(this.this$0, false);
                        if (!this.this$0.autoReconnect || this.this$0.isUserDisconnect) {
                            this.this$0.mBluetoothGatt.close();
                            BluetoothGatt access$402 = BluetoothLEint.access$402(this.this$0, (BluetoothGatt) null);
                            boolean access$1902 = BluetoothLEint.access$1902(this.this$0, false);
                        } else {
                            boolean connect = this.this$0.mBluetoothGatt.connect();
                        }
                        this.this$0.Disconnected();
                        int i4 = Log.i(BluetoothLEint.LOG_TAG, "Disconnect successful.");
                    }
                    if (status != 0 && !this.this$0.isConnected && (status != 8 || !this.this$0.autoReconnect)) {
                        BluetoothLE access$1200 = this.this$0.outer;
                        new StringBuilder();
                        access$1200.ConnectionFailed(sb3.append("Connection status was set to OS code ").append(status).toString());
                    }
                    new StringBuilder();
                    int i5 = Log.i(BluetoothLEint.LOG_TAG, sb.append("onConnectionStateChange fired with status: ").append(status).toString());
                    new StringBuilder();
                    int i6 = Log.i(BluetoothLEint.LOG_TAG, sb2.append("onConnectionStateChange fired with newState: ").append(newState).toString());
                }
            }

            public void onServicesDiscovered(BluetoothGatt bluetoothGatt, int i) {
                StringBuilder sb;
                StringBuilder sb2;
                BluetoothGatt gatt = bluetoothGatt;
                int status = i;
                if (status == 0) {
                    int i2 = Log.i(BluetoothLEint.LOG_TAG, "Services Discovered!");
                    List access$2102 = BluetoothLEint.access$2102(this.this$0, gatt.getServices());
                    boolean access$2202 = BluetoothLEint.access$2202(this.this$0, true);
                    boolean access$1702 = BluetoothLEint.access$1702(this.this$0, true);
                    this.this$0.pendingOperationsByUuid.clear();
                    this.this$0.pendingOperations.clear();
                    this.this$0.Connected();
                } else {
                    BluetoothLE access$1200 = this.this$0.outer;
                    new StringBuilder();
                    access$1200.ConnectionFailed(sb.append("Service discovery failed with OS code ").append(status).toString());
                }
                new StringBuilder();
                int i3 = Log.i(BluetoothLEint.LOG_TAG, sb2.append("onServicesDiscovered fired with status: ").append(status).toString());
            }

            public void onCharacteristicRead(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
                StringBuilder sb;
                List<BLEOperation> operations;
                BluetoothGatt gatt = bluetoothGatt;
                BluetoothGattCharacteristic characteristic = bluetoothGattCharacteristic;
                int status = i;
                if (this.this$0.pendingOperationsByUuid.containsKey(characteristic.getUuid())) {
                    new StringBuilder();
                    int d = Log.d(BluetoothLEint.LOG_TAG, sb.append("onCharacteristicRead: ").append(characteristic.getUuid()).toString());
                    new ArrayList<>((Collection) this.this$0.pendingOperationsByUuid.get(characteristic.getUuid()));
                    for (BLEOperation operation : operations) {
                        operation.onCharacteristicRead(gatt, characteristic, status);
                    }
                }
            }

            public void onCharacteristicChanged(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
                List<BLEOperation> operations;
                BluetoothGatt gatt = bluetoothGatt;
                BluetoothGattCharacteristic characteristic = bluetoothGattCharacteristic;
                if (this.this$0.pendingOperationsByUuid.containsKey(characteristic.getUuid())) {
                    int d = Log.d(BluetoothLEint.LOG_TAG, "onCharacteristicRead");
                    new ArrayList<>((Collection) this.this$0.pendingOperationsByUuid.get(characteristic.getUuid()));
                    for (BLEOperation operation : operations) {
                        operation.onCharacteristicChanged(gatt, characteristic);
                    }
                }
            }

            public void onCharacteristicWrite(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
                List<BLEOperation> operations;
                BluetoothGatt gatt = bluetoothGatt;
                BluetoothGattCharacteristic characteristic = bluetoothGattCharacteristic;
                int status = i;
                if (this.this$0.pendingOperationsByUuid.containsKey(characteristic.getUuid())) {
                    new ArrayList<>((Collection) this.this$0.pendingOperationsByUuid.get(characteristic.getUuid()));
                    for (BLEOperation operation : operations) {
                        operation.onCharacteristicWrite(gatt, characteristic, status);
                    }
                }
            }

            public void onDescriptorRead(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i) {
                List<BLEOperation> operations;
                BluetoothGatt gatt = bluetoothGatt;
                BluetoothGattDescriptor descriptor = bluetoothGattDescriptor;
                int status = i;
                byte[] access$2402 = BluetoothLEint.access$2402(this.this$0, descriptor.getValue());
                BluetoothGattCharacteristic characteristic = descriptor.getCharacteristic();
                if (this.this$0.pendingOperationsByUuid.containsKey(characteristic.getUuid())) {
                    int d = Log.d(BluetoothLEint.LOG_TAG, "onDescriptorRead");
                    new ArrayList<>((Collection) this.this$0.pendingOperationsByUuid.get(characteristic.getUuid()));
                    for (BLEOperation operation : operations) {
                        operation.onDescriptorRead(gatt, descriptor, status);
                    }
                }
            }

            public void onDescriptorWrite(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i) {
                List<BLEOperation> operations;
                BluetoothGatt gatt = bluetoothGatt;
                BluetoothGattDescriptor descriptor = bluetoothGattDescriptor;
                int status = i;
                int i2 = Log.i(BluetoothLEint.LOG_TAG, "Write Descriptor Successfully.");
                BluetoothGattCharacteristic characteristic = descriptor.getCharacteristic();
                if (this.this$0.pendingOperationsByUuid.containsKey(characteristic.getUuid())) {
                    int d = Log.d(BluetoothLEint.LOG_TAG, "onDescriptorWrite");
                    new ArrayList<>((Collection) this.this$0.pendingOperationsByUuid.get(characteristic.getUuid()));
                    for (BLEOperation operation : operations) {
                        operation.onDescriptorWrite(gatt, descriptor, status);
                    }
                }
            }

            public void onReadRemoteRssi(BluetoothGatt bluetoothGatt, int rssi, int i) {
                BluetoothGatt bluetoothGatt2 = bluetoothGatt;
                int i2 = i;
                int access$2502 = BluetoothLEint.access$2502(this.this$0, rssi);
                this.this$0.RssiChanged(this.this$0.device_rssi);
            }

            public void onMtuChanged(BluetoothGatt bluetoothGatt, int mtu, int i) {
                BluetoothGatt bluetoothGatt2 = bluetoothGatt;
                int i2 = i;
                bluetoothLE2.MTUChanged(mtu);
            }
        };
        this.mGattCallback = bluetoothGattCallback;
        new ScanCallback(this) {
            final /* synthetic */ BluetoothLEint this$0;

            {
                this.this$0 = this$0;
            }

            public void onScanResult(int callbackType, ScanResult scanResult) {
                ScanResult result = scanResult;
                super.onScanResult(callbackType, result);
                if (result != null && result.getDevice() != null && !TextUtils.isEmpty(result.getDevice().getName())) {
                    String advertiserAddress = result.getDevice().getAddress();
                    String advertiserName = result.getDevice().getName();
                    boolean add = this.this$0.advertiserAddresses.add(advertiserAddress);
                    Object put = this.this$0.scannedAdvertisers.put(advertiserAddress, result);
                    boolean add2 = this.this$0.scannedAdvertiserNames.add(advertiserName);
                    Object put2 = this.this$0.nameToAddress.put(advertiserName, advertiserAddress);
                }
            }

            public void onBatchScanResults(List<ScanResult> results) {
                super.onBatchScanResults(results);
            }

            public void onScanFailed(int i) {
                StringBuilder sb;
                int errorCode = i;
                new StringBuilder();
                int e = Log.e(BluetoothLEint.LOG_TAG, sb.append("Advertisement onScanFailed: ").append(errorCode).toString());
                super.onScanFailed(errorCode);
            }
        };
        this.mAdvertisementScanCallback = scanCallback2;
    }

    /* access modifiers changed from: package-private */
    public boolean isScanning() {
        return this.isScanning;
    }

    /* access modifiers changed from: package-private */
    public void StartScanning() {
        AnonymousClass4 r5;
        new BLEAction<Void>(this, "StartScanning") {
            final /* synthetic */ BluetoothLEint this$0;

            {
                BluetoothLEint this$02 = r7;
                this.this$0 = this$02;
            }

            public Void action() {
                ScanSettings.Builder builder;
                List<ScanFilter> list;
                ScanFilter.Builder builder2;
                if (!this.this$0.mLeDevices.isEmpty()) {
                    this.this$0.mLeDevices.clear();
                    this.this$0.mLeDeviceRssi.clear();
                }
                BluetoothAdapter btAdapter = obtainBluetoothAdapter();
                if (btAdapter != null) {
                    BluetoothLeScanner access$3302 = BluetoothLEint.access$3302(this.this$0, btAdapter.getBluetoothLeScanner());
                    if (this.this$0.mBluetoothLeDeviceScanner != null) {
                        new ScanSettings.Builder();
                        ScanSettings settings = builder.setScanMode(2).build();
                        new ArrayList<>();
                        List<ScanFilter> filters = list;
                        new ScanFilter.Builder();
                        boolean add = filters.add(builder2.build());
                        this.this$0.mBluetoothLeDeviceScanner.startScan(filters, settings, this.this$0.mDeviceScanCallback);
                        int i = Log.i(BluetoothLEint.LOG_TAG, "StartScanning successful.");
                    }
                }
                return null;
            }
        };
        Object run = r5.run();
    }

    /* access modifiers changed from: package-private */
    public void StartScanningForService(String caller, UUID serviceUuid, DeviceCallback callback) {
        AnonymousClass5 r10;
        final UUID uuid = serviceUuid;
        final DeviceCallback deviceCallback = callback;
        new BLEAction<Void>(this, caller) {
            final /* synthetic */ BluetoothLEint this$0;

            {
                BluetoothLEint this$02 = r9;
                this.this$0 = this$02;
            }

            public Void action() {
                ScanSettings.Builder builder;
                List<ScanFilter> list;
                ScanFilter.Builder builder2;
                ParcelUuid parcelUuid;
                ScanCallback scanCallback;
                if (!this.this$0.mLeDevices.isEmpty()) {
                    this.this$0.mLeDevices.clear();
                    this.this$0.mLeDeviceRssi.clear();
                }
                BluetoothAdapter btAdapter = obtainBluetoothAdapter();
                if (btAdapter == null) {
                    return null;
                }
                BluetoothLeScanner access$3302 = BluetoothLEint.access$3302(this.this$0, btAdapter.getBluetoothLeScanner());
                if (this.this$0.mBluetoothLeDeviceScanner == null) {
                    return null;
                }
                new ScanSettings.Builder();
                ScanSettings settings = builder.setScanMode(2).build();
                new ArrayList<>();
                List<ScanFilter> filters = list;
                new ScanFilter.Builder();
                new ParcelUuid(uuid);
                boolean add = filters.add(builder2.setServiceUuid(parcelUuid).build());
                if (deviceCallback != null) {
                    new ScanCallback(this) {
                        final /* synthetic */ AnonymousClass5 this$1;

                        {
                            this.this$1 = this$1;
                        }

                        public void onScanResult(int callbackType, ScanResult scanResult) {
                            StringBuilder sb;
                            ScanResult result = scanResult;
                            super.onScanResult(callbackType, result);
                            if (result != null) {
                                BluetoothDevice device = result.getDevice();
                                if (deviceCallback.foundDevice(device.getName(), device.getAddress())) {
                                    this.this$1.this$0.mBluetoothLeDeviceScanner.stopScan(this);
                                    boolean access$1402 = BluetoothLEint.access$1402(this.this$1.this$0, false);
                                    new StringBuilder();
                                    int i = Log.i(BluetoothLEint.LOG_TAG, sb.append("Connecting to device ").append(device).toString());
                                    BluetoothGatt access$402 = BluetoothLEint.access$402(this.this$1.this$0, device.connectGatt(this.this$1.this$0.activity, this.this$1.this$0.autoReconnect, this.this$1.this$0.mGattCallback));
                                    if (this.this$1.this$0.mBluetoothGatt == null) {
                                        this.this$1.this$0.outer.ConnectionFailed("Connect failed to return a BluetoothGatt object");
                                        int e = Log.e(BluetoothLEint.LOG_TAG, "Connect failed.");
                                        return;
                                    }
                                    this.this$1.this$0.scheduleConnectionTimeoutMessage();
                                }
                            }
                        }

                        public void onScanFailed(int i) {
                            int errorCode = i;
                            if (errorCode != 1) {
                                boolean access$1402 = BluetoothLEint.access$1402(this.this$1.this$0, false);
                            }
                            super.onScanFailed(errorCode);
                        }
                    };
                    this.this$0.mBluetoothLeDeviceScanner.startScan(filters, settings, scanCallback);
                    boolean access$1402 = BluetoothLEint.access$1402(this.this$0, true);
                } else {
                    this.this$0.mBluetoothLeDeviceScanner.startScan(filters, settings, this.this$0.mDeviceScanCallback);
                }
                return null;
            }
        };
        Object run = r10.run();
    }

    /* access modifiers changed from: package-private */
    public void RequestMTU(int bytes) {
        AnonymousClass6 r7;
        final int i = bytes;
        new BLEAction<Void>(this, "RequestMTU") {
            final /* synthetic */ BluetoothLEint this$0;

            {
                BluetoothLEint this$02 = r8;
                this.this$0 = this$02;
            }

            public Void action() {
                if (this.this$0.mBluetoothGatt != null) {
                    boolean requestMtu = this.this$0.mBluetoothGatt.requestMtu(i);
                }
                return null;
            }
        };
        Object run = r7.run();
    }

    /* access modifiers changed from: package-private */
    public void StopScanning() {
        AnonymousClass7 r5;
        new BLEAction<Void>(this, "StopScanning") {
            final /* synthetic */ BluetoothLEint this$0;

            {
                BluetoothLEint this$02 = r7;
                this.this$0 = this$02;
            }

            public Void action() {
                if (this.this$0.mBluetoothLeDeviceScanner != null) {
                    this.this$0.mBluetoothLeDeviceScanner.stopScan(this.this$0.mDeviceScanCallback);
                    boolean access$1402 = BluetoothLEint.access$1402(this.this$0, false);
                    int i = Log.i(BluetoothLEint.LOG_TAG, "StopScanning successful.");
                } else {
                    this.this$0.signalError("StopScanning", BluetoothLEint.ERROR_NO_DEVICE_SCAN_IN_PROGRESS, new Object[0]);
                }
                return null;
            }
        };
        Object run = r5.run();
    }

    /* access modifiers changed from: package-private */
    public void Connect(int i) {
        Throwable th;
        StringBuilder sb;
        AnonymousClass8 r7;
        int index = i;
        if (index < 1 || index > this.mLeDevices.size()) {
            this.outer.ConnectionFailed("Invalid index provided to Connect");
            Throwable th2 = th;
            new StringBuilder();
            new IndexOutOfBoundsException(sb.append("Expected device index between 1 and ").append(this.mLeDevices.size()).toString());
            throw th2;
        }
        final int i2 = index;
        new BLEAction<Void>(this, "Connect") {
            final /* synthetic */ BluetoothLEint this$0;

            {
                BluetoothLEint this$02 = r8;
                this.this$0 = this$02;
            }

            public Void action() {
                try {
                    if (this.this$0.mBluetoothLeAdvertisementScanner != null) {
                        this.this$0.mBluetoothLeAdvertisementScanner.stopScan(this.this$0.mDeviceScanCallback);
                        boolean access$1402 = BluetoothLEint.access$1402(this.this$0, false);
                    }
                    if (!this.this$0.mLeDevices.isEmpty()) {
                        this.this$0.forceDisconnect();
                        BluetoothGatt access$402 = BluetoothLEint.access$402(this.this$0, ((BluetoothDevice) this.this$0.mLeDevices.get(i2 - 1)).connectGatt(this.this$0.activity, this.this$0.autoReconnect, this.this$0.mGattCallback));
                        if (this.this$0.mBluetoothGatt != null) {
                            Object put = this.this$0.gattMap.put(((BluetoothDevice) this.this$0.mLeDevices.get(i2 - 1)).toString(), this.this$0.mBluetoothGatt);
                            this.this$0.scheduleConnectionTimeoutMessage();
                        } else {
                            this.this$0.outer.ConnectionFailed("Connect failed to return a BluetoothGatt object");
                            int e = Log.e(BluetoothLEint.LOG_TAG, "Connect failed.");
                        }
                    } else {
                        this.this$0.outer.ConnectionFailed("Device list was empty");
                        this.this$0.signalError("Connect", BluetoothLEint.ERROR_DEVICE_LIST_EMPTY, new Object[0]);
                    }
                } catch (IndexOutOfBoundsException e2) {
                    this.this$0.outer.ConnectionFailed(e2.getMessage());
                    BluetoothLEint bluetoothLEint = this.this$0;
                    Object[] objArr = new Object[2];
                    objArr[0] = "Connect";
                    Object[] objArr2 = objArr;
                    objArr2[1] = "DeviceList";
                    bluetoothLEint.signalError("Connect", BluetoothLEint.ERROR_INDEX_OUT_OF_BOUNDS, objArr2);
                }
                return null;
            }
        };
        Object run = r7.run();
    }

    /* access modifiers changed from: package-private */
    public void ConnectWithAddress(String address) {
        AnonymousClass9 r7;
        final String str = address;
        new BLEAction<Void>(this, "ConnectWithAddress") {
            final /* synthetic */ BluetoothLEint this$0;

            {
                BluetoothLEint this$02 = r8;
                this.this$0 = this$02;
            }

            public Void action() {
                try {
                    if (this.this$0.mBluetoothLeAdvertisementScanner != null) {
                        this.this$0.mBluetoothLeAdvertisementScanner.stopScan(this.this$0.mDeviceScanCallback);
                        boolean access$1402 = BluetoothLEint.access$1402(this.this$0, false);
                    }
                    for (BluetoothDevice bluetoothDevice : this.this$0.mLeDevices) {
                        if (bluetoothDevice.getAddress().equals(str)) {
                            this.this$0.forceDisconnect();
                            BluetoothGatt access$402 = BluetoothLEint.access$402(this.this$0, bluetoothDevice.connectGatt(this.this$0.activity, this.this$0.autoReconnect, this.this$0.mGattCallback));
                            if (this.this$0.mBluetoothGatt != null) {
                                Object put = this.this$0.gattMap.put(bluetoothDevice.getAddress(), this.this$0.mBluetoothGatt);
                                this.this$0.scheduleConnectionTimeoutMessage();
                                int i = Log.i(BluetoothLEint.LOG_TAG, "ConnectWithAddress successful.");
                            } else {
                                this.this$0.outer.ConnectionFailed("Connect failed to return a BluetoothGatt object");
                                int e = Log.e(BluetoothLEint.LOG_TAG, "ConnectWithAddress failed.");
                            }
                            return null;
                        }
                    }
                    BluetoothDevice dev = BluetoothAdapter.getDefaultAdapter().getRemoteDevice(str.toUpperCase());
                    this.this$0.forceDisconnect();
                    BluetoothGatt access$4022 = BluetoothLEint.access$402(this.this$0, dev.connectGatt(this.this$0.activity, this.this$0.autoReconnect, this.this$0.mGattCallback));
                    if (this.this$0.mBluetoothGatt != null) {
                        Object put2 = this.this$0.gattMap.put(dev.getAddress(), this.this$0.mBluetoothGatt);
                        this.this$0.scheduleConnectionTimeoutMessage();
                        return null;
                    }
                    this.this$0.outer.ConnectionFailed("Device list was empty");
                    this.this$0.signalError("ConnectWithAddress", BluetoothLEint.ERROR_DEVICE_LIST_EMPTY, new Object[0]);
                    return null;
                } catch (IndexOutOfBoundsException e2) {
                    this.this$0.outer.ConnectionFailed(e2.getMessage());
                    BluetoothLEint bluetoothLEint = this.this$0;
                    Object[] objArr = new Object[2];
                    objArr[0] = "ConnectWithAddress";
                    Object[] objArr2 = objArr;
                    objArr2[1] = "DeviceList";
                    bluetoothLEint.signalError("ConnectWithAddress", BluetoothLEint.ERROR_INDEX_OUT_OF_BOUNDS, objArr2);
                }
            }
        };
        Object run = r7.run();
    }

    /* access modifiers changed from: package-private */
    public void Disconnect() {
        AnonymousClass10 r5;
        new BLEAction<Void>(this, "Disconnect") {
            final /* synthetic */ BluetoothLEint this$0;

            {
                BluetoothLEint this$02 = r7;
                this.this$0 = this$02;
            }

            public Void action() {
                if (this.this$0.mBluetoothGatt != null) {
                    boolean access$1902 = BluetoothLEint.access$1902(this.this$0, true);
                    this.this$0.mBluetoothGatt.disconnect();
                } else {
                    this.this$0.signalError("Disconnect", BluetoothLEint.ERROR_NOT_CURRENTLY_CONNECTED, new Object[0]);
                }
                return null;
            }
        };
        Object run = r5.run();
    }

    /* access modifiers changed from: package-private */
    public void DisconnectWithAddress(String address) {
        AnonymousClass11 r7;
        final String str = address;
        new BLEAction<Void>(this, "DisconnectWithAddress") {
            final /* synthetic */ BluetoothLEint this$0;

            {
                BluetoothLEint this$02 = r8;
                this.this$0 = this$02;
            }

            public Void action() {
                if (this.this$0.gattMap.containsKey(str)) {
                    ((BluetoothGatt) this.this$0.gattMap.get(str)).disconnect();
                    Object remove = this.this$0.gattMap.remove(str);
                    int i = Log.i(BluetoothLEint.LOG_TAG, "Disconnect successful.");
                } else {
                    int e = Log.e(BluetoothLEint.LOG_TAG, "Disconnect failed. No such address in the list.");
                }
                return null;
            }
        };
        Object run = r7.run();
    }

    /* access modifiers changed from: package-private */
    public void ReadByteValues(String serviceUuid, String characteristicUuid, boolean signed) {
        ReadByteValues(serviceUuid, characteristicUuid, signed, (BluetoothLE.BLEResponseHandler<Integer>) null);
    }

    /* access modifiers changed from: package-private */
    public void ReadByteValues(String serviceUuid, String characteristicUuid, boolean signed, BluetoothLE.BLEResponseHandler<Integer> callback) {
        AnonymousClass12 r14;
        Object obj = "ReadByteValues";
        final String str = serviceUuid;
        final String str2 = characteristicUuid;
        final boolean z = signed;
        final BluetoothLE.BLEResponseHandler<Integer> bLEResponseHandler = callback;
        new BLEAction<Void>(this, "ReadByteValues") {
            final /* synthetic */ BluetoothLEint this$0;

            {
                BluetoothLEint this$02 = r11;
                this.this$0 = this$02;
            }

            public Void action() {
                BLEOperation bLEOperation;
                new BLEReadByteOperation(this.this$0, this.this$0.findMGattChar(BLEUtil.bleStringToUuid(str), BLEUtil.bleStringToUuid(str2)), z, bLEResponseHandler);
                this.this$0.schedulePendingOperation(bLEOperation);
                return null;
            }
        };
        Object run = r14.run();
    }

    /* access modifiers changed from: package-private */
    public void RegisterForByteValues(String serviceUuid, String characteristicUuid, boolean signed) {
        RegisterForByteValues(serviceUuid, characteristicUuid, signed, (BluetoothLE.BLEResponseHandler<Integer>) null);
    }

    /* access modifiers changed from: package-private */
    public void RegisterForByteValues(String serviceUuid, String characteristicUuid, boolean signed, BluetoothLE.BLEResponseHandler<Integer> callback) {
        Runnable runnable;
        Object obj = "RegisterForByteValues";
        final String str = serviceUuid;
        final String str2 = characteristicUuid;
        final boolean z = signed;
        final BluetoothLE.BLEResponseHandler<Integer> bLEResponseHandler = callback;
        new Runnable(this) {
            final /* synthetic */ BluetoothLEint this$0;

            {
                this.this$0 = this$0;
            }

            public void run() {
                AnonymousClass1 r5;
                new BLEAction<Void>(this, "RegisterForByteValues") {
                    final /* synthetic */ AnonymousClass13 this$1;

                    {
                        AnonymousClass13 this$12 = r7;
                        this.this$1 = this$12;
                    }

                    public Void action() {
                        BLEOperation bLEOperation;
                        new BLEReadByteOperation(this.this$1.this$0, this.this$1.this$0.findMGattChar(BLEUtil.bleStringToUuid(str), BLEUtil.bleStringToUuid(str2)), z, bLEResponseHandler, true);
                        this.this$1.this$0.schedulePendingOperation(bLEOperation);
                        return null;
                    }
                };
                Object run = r5.run();
            }
        };
        boolean postDelayed = this.mHandler.postDelayed(runnable, 1);
    }

    /* access modifiers changed from: package-private */
    public void WriteByteValues(String serviceUuid, String characteristicUuid, boolean signed, List<Integer> values) {
        AnonymousClass14 r14;
        Object obj = "WriteByteValues";
        final String str = serviceUuid;
        final String str2 = characteristicUuid;
        final boolean z = signed;
        final List<Integer> list = values;
        new BLEAction<Void>(this, "WriteByteValues") {
            final /* synthetic */ BluetoothLEint this$0;

            {
                BluetoothLEint this$02 = r11;
                this.this$0 = this$02;
            }

            public Void action() {
                BLEOperation bLEOperation;
                new BLEWriteBytesOperation(this.this$0, this.this$0.findMGattChar(BLEUtil.bleStringToUuid(str), BLEUtil.bleStringToUuid(str2)), z, list, 1);
                this.this$0.schedulePendingOperation(bLEOperation);
                return null;
            }
        };
        Object run = r14.run();
    }

    /* access modifiers changed from: package-private */
    public void WriteByteValuesWithResponse(String serviceUuid, String characteristicUuid, boolean signed, List<Integer> values) {
        WriteByteValuesWithResponse(serviceUuid, characteristicUuid, signed, values, (BluetoothLE.BLEResponseHandler<Integer>) null);
    }

    /* access modifiers changed from: package-private */
    public void WriteByteValuesWithResponse(String serviceUuid, String characteristicUuid, boolean signed, List<Integer> list, BluetoothLE.BLEResponseHandler<Integer> bLEResponseHandler) {
        StringBuilder sb;
        AnonymousClass15 r15;
        List<Integer> values = list;
        BluetoothLE.BLEResponseHandler<Integer> bLEResponseHandler2 = bLEResponseHandler;
        Object obj = "WriteByteValuesWithResponse";
        new StringBuilder();
        int d = Log.d(LOG_TAG, sb.append("WriteByteValuesWithResponse: ").append(values).toString());
        final String str = serviceUuid;
        final String str2 = characteristicUuid;
        final boolean z = signed;
        final List<Integer> list2 = values;
        new BLEAction<Void>(this, "WriteByteValuesWithResponse") {
            final /* synthetic */ BluetoothLEint this$0;

            {
                BluetoothLEint this$02 = r11;
                this.this$0 = this$02;
            }

            public Void action() {
                BLEOperation bLEOperation;
                new BLEWriteBytesOperation(this.this$0, this.this$0.findMGattChar(BLEUtil.bleStringToUuid(str), BLEUtil.bleStringToUuid(str2)), z, list2, 2);
                this.this$0.schedulePendingOperation(bLEOperation);
                return null;
            }
        };
        Object run = r15.run();
    }

    /* access modifiers changed from: package-private */
    public void ReadShortValues(String serviceUuid, String characteristicUuid, boolean signed) {
        ReadShortValues(serviceUuid, characteristicUuid, signed, (BluetoothLE.BLEResponseHandler<Integer>) null);
    }

    /* access modifiers changed from: package-private */
    public void ReadShortValues(String serviceUuid, String characteristicUuid, boolean signed, BluetoothLE.BLEResponseHandler<Integer> callback) {
        AnonymousClass16 r14;
        Object obj = "ReadShortValues";
        final String str = serviceUuid;
        final String str2 = characteristicUuid;
        final boolean z = signed;
        final BluetoothLE.BLEResponseHandler<Integer> bLEResponseHandler = callback;
        new BLEAction<Void>(this, "ReadShortValues") {
            final /* synthetic */ BluetoothLEint this$0;

            {
                BluetoothLEint this$02 = r11;
                this.this$0 = this$02;
            }

            public Void action() {
                BLEOperation bLEOperation;
                new BLEReadShortOperation(this.this$0, this.this$0.findMGattChar(BLEUtil.bleStringToUuid(str), BLEUtil.bleStringToUuid(str2)), z, bLEResponseHandler);
                this.this$0.schedulePendingOperation(bLEOperation);
                return null;
            }
        };
        Object run = r14.run();
    }

    /* access modifiers changed from: package-private */
    public void RegisterForShortValues(String serviceUuid, String characteristicUuid, boolean signed) {
        RegisterForShortValues(serviceUuid, characteristicUuid, signed, (BluetoothLE.BLEResponseHandler<Integer>) null);
    }

    /* access modifiers changed from: package-private */
    public void RegisterForShortValues(String serviceUuid, String characteristicUuid, boolean signed, BluetoothLE.BLEResponseHandler<Integer> callback) {
        AnonymousClass17 r14;
        Object obj = "RegisterForShortValues";
        final String str = serviceUuid;
        final String str2 = characteristicUuid;
        final boolean z = signed;
        final BluetoothLE.BLEResponseHandler<Integer> bLEResponseHandler = callback;
        new BLEAction<Void>(this, "RegisterForShortValues") {
            final /* synthetic */ BluetoothLEint this$0;

            {
                BluetoothLEint this$02 = r11;
                this.this$0 = this$02;
            }

            public Void action() {
                BLEOperation bLEOperation;
                new BLEReadShortOperation(this.this$0, this.this$0.findMGattChar(BLEUtil.bleStringToUuid(str), BLEUtil.bleStringToUuid(str2)), z, bLEResponseHandler, true);
                this.this$0.schedulePendingOperation(bLEOperation);
                return null;
            }
        };
        Object run = r14.run();
    }

    /* access modifiers changed from: package-private */
    public void WriteShortValues(String serviceUuid, String characteristicUuid, boolean signed, List<Integer> values) {
        AnonymousClass18 r14;
        Object obj = "WriteShortValues";
        final String str = serviceUuid;
        final String str2 = characteristicUuid;
        final boolean z = signed;
        final List<Integer> list = values;
        new BLEAction<Void>(this, "WriteShortValues") {
            final /* synthetic */ BluetoothLEint this$0;

            {
                BluetoothLEint this$02 = r11;
                this.this$0 = this$02;
            }

            public Void action() {
                BLEOperation bLEOperation;
                new BLEWriteShortsOperation(this.this$0, this.this$0.findMGattChar(BLEUtil.bleStringToUuid(str), BLEUtil.bleStringToUuid(str2)), z, list, 1);
                this.this$0.schedulePendingOperation(bLEOperation);
                return null;
            }
        };
        Object run = r14.run();
    }

    /* access modifiers changed from: package-private */
    public void WriteShortValuesWithResponse(String serviceUuid, String characteristicUuid, boolean signed, List<Integer> values) {
        WriteShortValuesWithResponse(serviceUuid, characteristicUuid, signed, values, (BluetoothLE.BLEResponseHandler<Integer>) null);
    }

    /* access modifiers changed from: package-private */
    public void WriteShortValuesWithResponse(String serviceUuid, String characteristicUuid, boolean signed, List<Integer> values, BluetoothLE.BLEResponseHandler<Integer> bLEResponseHandler) {
        AnonymousClass19 r15;
        BluetoothLE.BLEResponseHandler<Integer> bLEResponseHandler2 = bLEResponseHandler;
        Object obj = "WriteShortValuesWithResponse";
        final String str = serviceUuid;
        final String str2 = characteristicUuid;
        final boolean z = signed;
        final List<Integer> list = values;
        new BLEAction<Void>(this, "WriteShortValuesWithResponse") {
            final /* synthetic */ BluetoothLEint this$0;

            {
                BluetoothLEint this$02 = r11;
                this.this$0 = this$02;
            }

            public Void action() {
                BLEOperation bLEOperation;
                new BLEWriteShortsOperation(this.this$0, this.this$0.findMGattChar(BLEUtil.bleStringToUuid(str), BLEUtil.bleStringToUuid(str2)), z, list, 2);
                this.this$0.schedulePendingOperation(bLEOperation);
                return null;
            }
        };
        Object run = r15.run();
    }

    /* access modifiers changed from: package-private */
    public void ReadIntegerValues(String serviceUuid, String characteristicUuid, boolean signed) {
        ReadIntegerValues(serviceUuid, characteristicUuid, signed, (BluetoothLE.BLEResponseHandler<Long>) null);
    }

    /* access modifiers changed from: package-private */
    public void ReadIntegerValues(String serviceUuid, String characteristicUuid, boolean signed, BluetoothLE.BLEResponseHandler<Long> handler) {
        AnonymousClass20 r14;
        Object obj = "ReadIntegerValues";
        final String str = serviceUuid;
        final String str2 = characteristicUuid;
        final boolean z = signed;
        final BluetoothLE.BLEResponseHandler<Long> bLEResponseHandler = handler;
        new BLEAction<Void>(this, "ReadIntegerValues") {
            final /* synthetic */ BluetoothLEint this$0;

            {
                BluetoothLEint this$02 = r11;
                this.this$0 = this$02;
            }

            public Void action() {
                BLEOperation bLEOperation;
                new BLEReadIntegerOperation(this.this$0, this.this$0.findMGattChar(BLEUtil.bleStringToUuid(str), BLEUtil.bleStringToUuid(str2)), z, bLEResponseHandler);
                this.this$0.schedulePendingOperation(bLEOperation);
                return null;
            }
        };
        Object run = r14.run();
    }

    /* access modifiers changed from: package-private */
    public void RegisterForIntegerValues(String serviceUuid, String characteristicUuid, boolean signed) {
        RegisterForIntegerValues(serviceUuid, characteristicUuid, signed, (BluetoothLE.BLEResponseHandler<Long>) null);
    }

    /* access modifiers changed from: package-private */
    public void RegisterForIntegerValues(String serviceUuid, String characteristicUuid, boolean signed, BluetoothLE.BLEResponseHandler<Long> handler) {
        AnonymousClass21 r14;
        Object obj = "RegisterForIntegerValues";
        final String str = serviceUuid;
        final String str2 = characteristicUuid;
        final boolean z = signed;
        final BluetoothLE.BLEResponseHandler<Long> bLEResponseHandler = handler;
        new BLEAction<Void>(this, "RegisterForIntegerValues") {
            final /* synthetic */ BluetoothLEint this$0;

            {
                BluetoothLEint this$02 = r11;
                this.this$0 = this$02;
            }

            public Void action() {
                BLEOperation bLEOperation;
                new BLEReadIntegerOperation(this.this$0, this.this$0.findMGattChar(BLEUtil.bleStringToUuid(str), BLEUtil.bleStringToUuid(str2)), z, bLEResponseHandler, true);
                this.this$0.schedulePendingOperation(bLEOperation);
                return null;
            }
        };
        Object run = r14.run();
    }

    /* access modifiers changed from: package-private */
    public void WriteIntegerValues(String serviceUuid, String characteristicUuid, boolean signed, List<Long> values) {
        AnonymousClass22 r14;
        Object obj = "WriteIntegerValuesWithResponse";
        final String str = serviceUuid;
        final String str2 = characteristicUuid;
        final boolean z = signed;
        final List<Long> list = values;
        new BLEAction<Void>(this, "WriteIntegerValuesWithResponse") {
            final /* synthetic */ BluetoothLEint this$0;

            {
                BluetoothLEint this$02 = r11;
                this.this$0 = this$02;
            }

            public Void action() {
                BLEOperation bLEOperation;
                new BLEWriteIntegersOperation(this.this$0, this.this$0.findMGattChar(BLEUtil.bleStringToUuid(str), BLEUtil.bleStringToUuid(str2)), z, list, 1);
                this.this$0.schedulePendingOperation(bLEOperation);
                return null;
            }
        };
        Object run = r14.run();
    }

    /* access modifiers changed from: package-private */
    public void WriteIntegerValuesWithResponse(String serviceUuid, String characteristicUuid, boolean signed, List<Long> values) {
        WriteIntegerValuesWithResponse(serviceUuid, characteristicUuid, signed, values, (BluetoothLE.BLEResponseHandler<Long>) null);
    }

    /* access modifiers changed from: package-private */
    public void WriteIntegerValuesWithResponse(String serviceUuid, String characteristicUuid, boolean signed, List<Long> values, BluetoothLE.BLEResponseHandler<Long> bLEResponseHandler) {
        AnonymousClass23 r15;
        BluetoothLE.BLEResponseHandler<Long> bLEResponseHandler2 = bLEResponseHandler;
        Object obj = "WriteIntegerValuesWithResponse";
        final String str = serviceUuid;
        final String str2 = characteristicUuid;
        final boolean z = signed;
        final List<Long> list = values;
        new BLEAction<Void>(this, "WriteIntegerValuesWithResponse") {
            final /* synthetic */ BluetoothLEint this$0;

            {
                BluetoothLEint this$02 = r11;
                this.this$0 = this$02;
            }

            public Void action() {
                BLEOperation bLEOperation;
                new BLEWriteIntegersOperation(this.this$0, this.this$0.findMGattChar(BLEUtil.bleStringToUuid(str), BLEUtil.bleStringToUuid(str2)), z, list, 2);
                this.this$0.schedulePendingOperation(bLEOperation);
                return null;
            }
        };
        Object run = r15.run();
    }

    /* access modifiers changed from: package-private */
    public void ReadFloatValues(String serviceUuid, String characteristicUuid, boolean shortFloat) {
        ReadFloatValues(serviceUuid, characteristicUuid, shortFloat, (BluetoothLE.BLEResponseHandler<Float>) null);
    }

    /* access modifiers changed from: package-private */
    public void ReadFloatValues(String serviceUuid, String characteristicUuid, boolean shortFloat, BluetoothLE.BLEResponseHandler<Float> callback) {
        AnonymousClass24 r14;
        Object obj = "ReadFloatValues";
        final String str = serviceUuid;
        final String str2 = characteristicUuid;
        final boolean z = shortFloat;
        final BluetoothLE.BLEResponseHandler<Float> bLEResponseHandler = callback;
        new BLEAction<Void>(this, "ReadFloatValues") {
            final /* synthetic */ BluetoothLEint this$0;

            {
                BluetoothLEint this$02 = r11;
                this.this$0 = this$02;
            }

            public Void action() {
                BLEOperation bLEOperation;
                new BLEReadFloatOperation(this.this$0, this.this$0.findMGattChar(BLEUtil.bleStringToUuid(str), BLEUtil.bleStringToUuid(str2)), z, bLEResponseHandler);
                this.this$0.schedulePendingOperation(bLEOperation);
                return null;
            }
        };
        Object run = r14.run();
    }

    /* access modifiers changed from: package-private */
    public void RegisterForFloatValues(String serviceUuid, String characteristicUuid, boolean shortFloat) {
        RegisterForFloatValues(serviceUuid, characteristicUuid, shortFloat, (BluetoothLE.BLEResponseHandler<Float>) null);
    }

    /* access modifiers changed from: package-private */
    public void RegisterForFloatValues(String serviceUuid, String characteristicUuid, boolean shortFloat, BluetoothLE.BLEResponseHandler<Float> callback) {
        AnonymousClass25 r14;
        Object obj = "RegisterForFloatValues";
        final String str = serviceUuid;
        final String str2 = characteristicUuid;
        final boolean z = shortFloat;
        final BluetoothLE.BLEResponseHandler<Float> bLEResponseHandler = callback;
        new BLEAction<Void>(this, "RegisterForFloatValues") {
            final /* synthetic */ BluetoothLEint this$0;

            {
                BluetoothLEint this$02 = r11;
                this.this$0 = this$02;
            }

            public Void action() {
                BLEOperation bLEOperation;
                new BLEReadFloatOperation(this.this$0, this.this$0.findMGattChar(BLEUtil.bleStringToUuid(str), BLEUtil.bleStringToUuid(str2)), z, bLEResponseHandler, true);
                this.this$0.schedulePendingOperation(bLEOperation);
                return null;
            }
        };
        Object run = r14.run();
    }

    /* access modifiers changed from: package-private */
    public void WriteFloatValues(String serviceUuid, String characteristicUuid, boolean shortFloat, List<Float> values) {
        AnonymousClass26 r14;
        Object obj = "WriteFloatValues";
        final String str = serviceUuid;
        final String str2 = characteristicUuid;
        final boolean z = shortFloat;
        final List<Float> list = values;
        new BLEAction<Void>(this, "WriteFloatValues") {
            final /* synthetic */ BluetoothLEint this$0;

            {
                BluetoothLEint this$02 = r11;
                this.this$0 = this$02;
            }

            public Void action() {
                BLEOperation bLEOperation;
                new BLEWriteFloatsOperation(this.this$0, this.this$0.findMGattChar(BLEUtil.bleStringToUuid(str), BLEUtil.bleStringToUuid(str2)), z, list, 1);
                this.this$0.schedulePendingOperation(bLEOperation);
                return null;
            }
        };
        Object run = r14.run();
    }

    /* access modifiers changed from: package-private */
    public void WriteFloatValuesWithResponse(String serviceUuid, String characteristicUuid, boolean shortFloat, List<Float> values) {
        WriteFloatValuesWithResponse(serviceUuid, characteristicUuid, shortFloat, values, (BluetoothLE.BLEResponseHandler<Float>) null);
    }

    /* access modifiers changed from: package-private */
    public void WriteFloatValuesWithResponse(String serviceUuid, String characteristicUuid, boolean shortFloat, List<Float> values, BluetoothLE.BLEResponseHandler<Float> bLEResponseHandler) {
        AnonymousClass27 r15;
        BluetoothLE.BLEResponseHandler<Float> bLEResponseHandler2 = bLEResponseHandler;
        Object obj = "WriteFloatValuesWithResponse";
        final String str = serviceUuid;
        final String str2 = characteristicUuid;
        final boolean z = shortFloat;
        final List<Float> list = values;
        new BLEAction<Void>(this, "WriteFloatValuesWithResponse") {
            final /* synthetic */ BluetoothLEint this$0;

            {
                BluetoothLEint this$02 = r11;
                this.this$0 = this$02;
            }

            public Void action() {
                BLEOperation bLEOperation;
                new BLEWriteFloatsOperation(this.this$0, this.this$0.findMGattChar(BLEUtil.bleStringToUuid(str), BLEUtil.bleStringToUuid(str2)), z, list, 2);
                this.this$0.schedulePendingOperation(bLEOperation);
                return null;
            }
        };
        Object run = r15.run();
    }

    /* access modifiers changed from: package-private */
    public void ReadStringValues(String serviceUuid, String characteristicUuid, boolean utf16) {
        ReadStringValues(serviceUuid, characteristicUuid, utf16, (BluetoothLE.BLEResponseHandler<String>) null);
    }

    /* access modifiers changed from: package-private */
    public void ReadStringValues(String serviceUuid, String characteristicUuid, boolean utf16, BluetoothLE.BLEResponseHandler<String> handler) {
        AnonymousClass28 r14;
        Object obj = "ReadStringValues";
        final String str = serviceUuid;
        final String str2 = characteristicUuid;
        final boolean z = utf16;
        final BluetoothLE.BLEResponseHandler<String> bLEResponseHandler = handler;
        new BLEAction<Void>(this, "ReadStringValues") {
            final /* synthetic */ BluetoothLEint this$0;

            {
                BluetoothLEint this$02 = r11;
                this.this$0 = this$02;
            }

            public Void action() {
                BLEOperation bLEOperation;
                try {
                    new BLEReadStringOperation(this.this$0, this.this$0.findMGattChar(BLEUtil.bleStringToUuid(str), BLEUtil.bleStringToUuid(str2)), z, bLEResponseHandler);
                    this.this$0.schedulePendingOperation(bLEOperation);
                } catch (IllegalStateException e) {
                    IllegalStateException illegalStateException = e;
                    Form $form = this.this$0.container.$form();
                    BluetoothLE access$1200 = this.this$0.outer;
                    Object[] objArr = new Object[3];
                    objArr[0] = Integer.valueOf(BluetoothLEint.ERROR_UNSUPPORTED_CHARACTERISTIC);
                    Object[] objArr2 = objArr;
                    objArr2[1] = "BluetoothLE";
                    Object[] objArr3 = objArr2;
                    objArr3[2] = BluetoothLEint.UNKNOWN_CHAR_NAME;
                    $form.dispatchErrorOccurredEvent(access$1200, "ReadString", ErrorMessages.ERROR_EXTENSION_ERROR, objArr3);
                }
                return null;
            }
        };
        Object run = r14.run();
    }

    /* access modifiers changed from: package-private */
    public void RegisterForStringValues(String serviceUuid, String characteristicUuid, boolean utf16) {
        RegisterForStringValues(serviceUuid, characteristicUuid, utf16, (BluetoothLE.BLEResponseHandler<String>) null);
    }

    /* access modifiers changed from: package-private */
    public void RegisterForStringValues(String serviceUuid, String characteristicUuid, boolean utf16, BluetoothLE.BLEResponseHandler<String> handler) {
        AnonymousClass29 r14;
        Object obj = "RegisterForStringValues";
        final String str = serviceUuid;
        final String str2 = characteristicUuid;
        final boolean z = utf16;
        final BluetoothLE.BLEResponseHandler<String> bLEResponseHandler = handler;
        new BLEAction<Void>(this, "RegisterForStringValues") {
            final /* synthetic */ BluetoothLEint this$0;

            {
                BluetoothLEint this$02 = r11;
                this.this$0 = this$02;
            }

            public Void action() {
                BLEOperation bLEOperation;
                new BLEReadStringOperation(this.this$0, this.this$0.findMGattChar(BLEUtil.bleStringToUuid(str), BLEUtil.bleStringToUuid(str2)), z, bLEResponseHandler, true);
                this.this$0.schedulePendingOperation(bLEOperation);
                return null;
            }
        };
        Object run = r14.run();
    }

    /* access modifiers changed from: package-private */
    public void WriteStringValues(String serviceUuid, String characteristicUuid, boolean utf16, List<String> values) {
        AnonymousClass30 r14;
        Object obj = "WriteStringValues";
        final String str = serviceUuid;
        final String str2 = characteristicUuid;
        final boolean z = utf16;
        final List<String> list = values;
        new BLEAction<Void>(this, "WriteStringValues") {
            final /* synthetic */ BluetoothLEint this$0;

            {
                BluetoothLEint this$02 = r11;
                this.this$0 = this$02;
            }

            public Void action() {
                BLEOperation bLEOperation;
                new BLEWriteStringsOperation(this.this$0, this.this$0.findMGattChar(BLEUtil.bleStringToUuid(str), BLEUtil.bleStringToUuid(str2)), z, list, 1);
                this.this$0.schedulePendingOperation(bLEOperation);
                return null;
            }
        };
        Object run = r14.run();
    }

    /* access modifiers changed from: package-private */
    public void WriteStringValuesWithResponse(String serviceUuid, String characteristicUuid, boolean utf16, List<String> values) {
        WriteStringValuesWithResponse(serviceUuid, characteristicUuid, utf16, values, (BluetoothLE.BLEResponseHandler<String>) null);
    }

    /* access modifiers changed from: package-private */
    public void WriteStringValuesWithResponse(String serviceUuid, String characteristicUuid, boolean utf16, List<String> values, BluetoothLE.BLEResponseHandler<String> bLEResponseHandler) {
        AnonymousClass31 r15;
        BluetoothLE.BLEResponseHandler<String> bLEResponseHandler2 = bLEResponseHandler;
        Object obj = "WriteStringValuesWithResponse";
        final String str = serviceUuid;
        final String str2 = characteristicUuid;
        final boolean z = utf16;
        final List<String> list = values;
        new BLEAction<Void>(this, "WriteStringValuesWithResponse") {
            final /* synthetic */ BluetoothLEint this$0;

            {
                BluetoothLEint this$02 = r11;
                this.this$0 = this$02;
            }

            public Void action() {
                BLEOperation bLEOperation;
                new BLEWriteStringsOperation(this.this$0, this.this$0.findMGattChar(BLEUtil.bleStringToUuid(str), BLEUtil.bleStringToUuid(str2)), z, list, 2);
                this.this$0.schedulePendingOperation(bLEOperation);
                return null;
            }
        };
        Object run = r15.run();
    }

    /* access modifiers changed from: package-private */
    public void UnregisterForValues(String serviceUuid, String characteristicUuid) {
        UnregisterForValues(serviceUuid, characteristicUuid, (BluetoothLE.BLEResponseHandler<?>) null);
    }

    /* access modifiers changed from: package-private */
    public void UnregisterForValues(String str, String characteristicUuid, BluetoothLE.BLEResponseHandler<?> bLEResponseHandler) {
        AnonymousClass32 r10;
        String str2 = str;
        BluetoothLE.BLEResponseHandler<?> bLEResponseHandler2 = bLEResponseHandler;
        Object obj = "UnsubscribeForValues";
        final String str3 = characteristicUuid;
        new BLEAction<Void>(this, "UnsubscribeForValues") {
            final /* synthetic */ BluetoothLEint this$0;

            {
                BluetoothLEint this$02 = r8;
                this.this$0 = this$02;
            }

            public Void action() {
                List<BLEOperation> readOnlyList;
                List<BLEOperation> operations = (List) this.this$0.pendingOperationsByUuid.get(BLEUtil.bleStringToUuid(str3));
                if (operations != null) {
                    new ArrayList<>(operations);
                    for (BLEOperation operation : readOnlyList) {
                        if (operation.isNotify()) {
                            operation.unsubscribe(this.this$0.mBluetoothGatt);
                        }
                    }
                }
                return null;
            }
        };
        Object run = r10.run();
    }

    /* access modifiers changed from: package-private */
    public void ReadPacket(String serviceUuid, String characteristicUuid, BluetoothLE.BLEPacketHandler callback) {
        AnonymousClass33 r12;
        Object obj = "ReadPacket";
        final String str = serviceUuid;
        final String str2 = characteristicUuid;
        final BluetoothLE.BLEPacketHandler bLEPacketHandler = callback;
        new BLEAction<Void>(this, "ReadPacket") {
            final /* synthetic */ BluetoothLEint this$0;

            {
                BluetoothLEint this$02 = r10;
                this.this$0 = this$02;
            }

            public Void action() {
                BLEOperation bLEOperation;
                new BLEReadPacketOperation(this.this$0, this.this$0.findMGattChar(BLEUtil.bleStringToUuid(str), BLEUtil.bleStringToUuid(str2)), false, bLEPacketHandler);
                this.this$0.schedulePendingOperation(bLEOperation);
                return null;
            }
        };
        Object run = r12.run();
    }

    /* access modifiers changed from: package-private */
    public void RegisterForPackets(String serviceUuid, String characteristicUuid, BluetoothLE.BLEPacketHandler callback) {
        AnonymousClass34 r12;
        Object obj = "RegisterForPackets";
        final String str = serviceUuid;
        final String str2 = characteristicUuid;
        final BluetoothLE.BLEPacketHandler bLEPacketHandler = callback;
        new BLEAction<Void>(this, "RegisterForPackets") {
            final /* synthetic */ BluetoothLEint this$0;

            {
                BluetoothLEint this$02 = r10;
                this.this$0 = this$02;
            }

            public Void action() {
                BLEOperation bLEOperation;
                new BLEReadPacketOperation(this.this$0, this.this$0.findMGattChar(BLEUtil.bleStringToUuid(str), BLEUtil.bleStringToUuid(str2)), true, bLEPacketHandler);
                this.this$0.schedulePendingOperation(bLEOperation);
                return null;
            }
        };
        Object run = r12.run();
    }

    /* access modifiers changed from: package-private */
    public void UnregisterForPackets(String str, String characteristicUuid, BluetoothLE.BLEPacketHandler bLEPacketHandler) {
        AnonymousClass35 r10;
        String str2 = str;
        BluetoothLE.BLEPacketHandler bLEPacketHandler2 = bLEPacketHandler;
        Object obj = "UnregisterForPackets";
        final String str3 = characteristicUuid;
        new BLEAction<Void>(this, "UnregisterForPackets") {
            final /* synthetic */ BluetoothLEint this$0;

            {
                BluetoothLEint this$02 = r8;
                this.this$0 = this$02;
            }

            public Void action() {
                List<BLEOperation> readOnlyList;
                List<BLEOperation> operations = (List) this.this$0.pendingOperationsByUuid.get(BLEUtil.bleStringToUuid(str3));
                if (operations != null) {
                    new ArrayList<>(operations);
                    for (BLEOperation operation : readOnlyList) {
                        if (operation.isNotify()) {
                            operation.unsubscribe(this.this$0.mBluetoothGatt);
                        }
                    }
                }
                return null;
            }
        };
        Object run = r10.run();
    }

    /* access modifiers changed from: package-private */
    public int FoundDeviceRssi(int i) {
        Throwable th;
        StringBuilder sb;
        AnonymousClass36 r8;
        int index = i;
        if (index < 1 || index > this.mLeDevices.size()) {
            Throwable th2 = th;
            new StringBuilder();
            new IllegalArgumentException(sb.append("Expected device index between 1 and ").append(this.mLeDevices.size()).toString());
            throw th2;
        }
        final int i2 = index;
        new BLEAction<Integer>(this, "FoundDeviceRssi") {
            final /* synthetic */ BluetoothLEint this$0;

            {
                BluetoothLEint this$02 = r8;
                this.this$0 = this$02;
            }

            public Integer action() {
                if (i2 <= this.this$0.mLeDevices.size()) {
                    try {
                        if (!this.this$0.mLeDevices.isEmpty()) {
                            return (Integer) this.this$0.mLeDeviceRssi.get(this.this$0.mLeDevices.get(i2 - 1));
                        }
                        this.this$0.signalError("FoundDeviceRssi", BluetoothLEint.ERROR_DEVICE_LIST_EMPTY, new Object[0]);
                    } catch (IndexOutOfBoundsException e) {
                        IndexOutOfBoundsException indexOutOfBoundsException = e;
                        BluetoothLEint bluetoothLEint = this.this$0;
                        Object[] objArr = new Object[2];
                        objArr[0] = "FoundDeviceRssi";
                        Object[] objArr2 = objArr;
                        objArr2[1] = "DeviceList";
                        bluetoothLEint.signalError("FoundDeviceRssi", BluetoothLEint.ERROR_INDEX_OUT_OF_BOUNDS, objArr2);
                    }
                }
                return null;
            }
        };
        Integer result = (Integer) r8.run();
        return result != null ? result.intValue() : -1;
    }

    /* access modifiers changed from: package-private */
    public String FoundDeviceName(int i) {
        Throwable th;
        StringBuilder sb;
        int index = i;
        if (index < 1 || index > this.mLeDevices.size()) {
            Throwable th2 = th;
            new StringBuilder();
            new IllegalArgumentException(sb.append("Expected device index between 1 and ").append(this.mLeDevices.size()).toString());
            throw th2;
        } else if (index <= this.mLeDevices.size()) {
            int i2 = Log.i(LOG_TAG, "Device Name is found");
            return this.mLeDevices.get(index - 1).getName();
        } else {
            int e = Log.e(LOG_TAG, "Device Name isn't found");
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public String FoundDeviceAddress(int i) {
        Throwable th;
        StringBuilder sb;
        int index = i;
        if (index < 1 || index > this.mLeDevices.size()) {
            Throwable th2 = th;
            new StringBuilder();
            new IllegalArgumentException(sb.append("Expected device index between 1 and ").append(this.mLeDevices.size()).toString());
            throw th2;
        } else if (index <= this.mLeDevices.size()) {
            int i2 = Log.i(LOG_TAG, "Device Address is found");
            return this.mLeDevices.get(index - 1).getAddress();
        } else {
            int e = Log.e(LOG_TAG, "Device Address is found");
            return "";
        }
    }

    /* access modifiers changed from: package-private */
    public String ConnectedDeviceName() {
        BluetoothDevice device;
        if (!this.isConnected || this.mBluetoothGatt == null || (device = this.mBluetoothGatt.getDevice()) == null) {
            return "";
        }
        return device.getName();
    }

    /* access modifiers changed from: package-private */
    public void StartAdvertising(String inData, String serviceUuid) {
        AnonymousClass37 r9;
        final String str = serviceUuid;
        final String str2 = inData;
        new BLEAction<Void>(this, "StartAdvertising") {
            final /* synthetic */ BluetoothLEint this$0;

            {
                BluetoothLEint this$02 = r9;
                this.this$0 = this$02;
            }

            public Void action() {
                AdvertiseCallback advertiseCallback;
                AdvertiseSettings.Builder builder;
                ParcelUuid parcelUuid;
                AdvertiseData.Builder builder2;
                BluetoothAdapter btAdapter = obtainBluetoothAdapter();
                if (!btAdapter.isMultipleAdvertisementSupported()) {
                    int i = Log.i(BluetoothLEint.LOG_TAG, "Adapter does not support Bluetooth Advertisements.");
                    this.this$0.signalError("StartAdvertising", BluetoothLEint.ERROR_ADVERTISEMENTS_NOT_SUPPORTED, new Object[0]);
                    return null;
                } else if (!this.this$0.validateUUID(str, "Service", "StartAdvertising")) {
                    return null;
                } else {
                    BluetoothLeAdvertiser access$4302 = BluetoothLEint.access$4302(this.this$0, btAdapter.getBluetoothLeAdvertiser());
                    new AdvertiseCallback(this) {
                        final /* synthetic */ AnonymousClass37 this$1;

                        {
                            this.this$1 = this$1;
                        }

                        public void onStartSuccess(AdvertiseSettings settingsInEffect) {
                            boolean access$4402 = BluetoothLEint.access$4402(this.this$1.this$0, true);
                            super.onStartSuccess(settingsInEffect);
                        }

                        public void onStartFailure(int i) {
                            StringBuilder sb;
                            int errorCode = i;
                            new StringBuilder();
                            int e = Log.e(BluetoothLEint.LOG_TAG, sb.append("Advertising onStartFailure: ").append(errorCode).toString());
                            super.onStartFailure(errorCode);
                        }
                    };
                    AdvertiseCallback advertisingCallback = advertiseCallback;
                    new AdvertiseSettings.Builder();
                    AdvertiseSettings advSettings = builder.setAdvertiseMode(2).setTxPowerLevel(3).setConnectable(false).build();
                    new ParcelUuid(UUID.fromString(str));
                    ParcelUuid pUuid = parcelUuid;
                    new AdvertiseData.Builder();
                    AdvertiseData advData = builder2.setIncludeDeviceName(true).addServiceUuid(pUuid).addServiceData(pUuid, str2.getBytes(Charset.forName("UTF-8"))).build();
                    if (this.this$0.mAdvertiseCallback == null) {
                        AdvertiseCallback access$4502 = BluetoothLEint.access$4502(this.this$0, advertisingCallback);
                        if (this.this$0.mBluetoothLeAdvertiser != null) {
                            this.this$0.mBluetoothLeAdvertiser.startAdvertising(advSettings, advData, this.this$0.mAdvertiseCallback);
                        }
                    }
                    int i2 = Log.i(BluetoothLEint.LOG_TAG, "StartScanningAdvertisements Successfully.");
                    return null;
                }
            }
        };
        Object run = r9.run();
    }

    /* access modifiers changed from: package-private */
    public void StopAdvertising() {
        AnonymousClass38 r5;
        new BLEAction<Void>(this, "StopAdvertising") {
            final /* synthetic */ BluetoothLEint this$0;

            {
                BluetoothLEint this$02 = r7;
                this.this$0 = this$02;
            }

            public Void action() {
                int i = Log.i(BluetoothLEint.LOG_TAG, "Stopping BLE Advertising");
                if (this.this$0.mBluetoothLeAdvertiser != null) {
                    this.this$0.mBluetoothLeAdvertiser.stopAdvertising(this.this$0.mAdvertiseCallback);
                    boolean access$4402 = BluetoothLEint.access$4402(this.this$0, false);
                    AdvertiseCallback access$4502 = BluetoothLEint.access$4502(this.this$0, (AdvertiseCallback) null);
                }
                return null;
            }
        };
        Object run = r5.run();
    }

    /* access modifiers changed from: package-private */
    public void ScanAdvertisements(long scanPeriod) {
        AnonymousClass39 r10;
        final long j = scanPeriod;
        new BLEAction<Void>(this, "ScanAdvertisements") {
            final /* synthetic */ BluetoothLEint this$0;

            {
                BluetoothLEint this$02 = r10;
                this.this$0 = this$02;
            }

            public Void action() {
                List list;
                HashMap hashMap;
                List list2;
                HashMap hashMap2;
                Runnable runnable;
                ScanSettings.Builder builder;
                List<ScanFilter> list3;
                ScanFilter.Builder builder2;
                long access$4602 = BluetoothLEint.access$4602(this.this$0, j);
                new ArrayList();
                List access$2702 = BluetoothLEint.access$2702(this.this$0, list);
                new HashMap();
                HashMap access$2802 = BluetoothLEint.access$2802(this.this$0, hashMap);
                new ArrayList();
                List access$2902 = BluetoothLEint.access$2902(this.this$0, list2);
                new HashMap();
                HashMap access$3002 = BluetoothLEint.access$3002(this.this$0, hashMap2);
                new Runnable(this) {
                    final /* synthetic */ AnonymousClass39 this$1;

                    {
                        this.this$1 = this$1;
                    }

                    public void run() {
                        this.this$1.this$0.StopScanningAdvertisements();
                    }
                };
                boolean postDelayed = this.this$0.uiThread.postDelayed(runnable, j);
                BluetoothAdapter btAdapter = obtainBluetoothAdapter();
                if (btAdapter != null) {
                    BluetoothLeScanner access$3702 = BluetoothLEint.access$3702(this.this$0, btAdapter.getBluetoothLeScanner());
                    if (this.this$0.mAdvertisementScanCallback == null) {
                        int i = Log.i(BluetoothLEint.LOG_TAG, "mAdvertisementScanCallback is null.");
                    } else if (this.this$0.mBluetoothLeAdvertisementScanner != null) {
                        new ScanSettings.Builder();
                        ScanSettings settings = builder.setScanMode(2).build();
                        new ArrayList<>();
                        List<ScanFilter> filters = list3;
                        new ScanFilter.Builder();
                        boolean add = filters.add(builder2.build());
                        if (settings != null) {
                            this.this$0.mBluetoothLeAdvertisementScanner.startScan(filters, settings, this.this$0.mAdvertisementScanCallback);
                        } else {
                            int i2 = Log.i(BluetoothLEint.LOG_TAG, "settings or filters are null.");
                        }
                    } else {
                        int i3 = Log.i(BluetoothLEint.LOG_TAG, "Bluetooth LE scanner is null.");
                    }
                } else {
                    int i4 = Log.i(BluetoothLEint.LOG_TAG, "No bluetooth adapter found.");
                }
                return null;
            }
        };
        Object run = r10.run();
    }

    /* access modifiers changed from: package-private */
    public void StopScanningAdvertisements() {
        AnonymousClass40 r5;
        new BLEAction<Void>(this, "StopScanningAdvertisements") {
            final /* synthetic */ BluetoothLEint this$0;

            {
                BluetoothLEint this$02 = r7;
                this.this$0 = this$02;
            }

            public Void action() {
                int i = Log.i(BluetoothLEint.LOG_TAG, "Stopping BLE Advertisement Scan.");
                this.this$0.mBluetoothLeAdvertisementScanner.stopScan(this.this$0.mAdvertisementScanCallback);
                return null;
            }
        };
        Object run = r5.run();
    }

    /* access modifiers changed from: package-private */
    public String GetAdvertisementData(String str, String str2) {
        StringBuilder sb;
        String deviceAddress = str;
        String serviceUuid = str2;
        if (!validateUUID(serviceUuid, "Service", "GetAdvertisementData")) {
            return "";
        }
        new StringBuilder();
        return sb.append("").append(Arrays.toString(this.scannedAdvertisers.get(deviceAddress).getScanRecord().getServiceData().get(ParcelUuid.fromString(serviceUuid)))).toString();
    }

    /* access modifiers changed from: package-private */
    public String GetAdvertiserAddress(String deviceName) {
        return this.nameToAddress.get(deviceName);
    }

    /* access modifiers changed from: package-private */
    public List<String> GetAdvertiserServiceUuids(String deviceAddress) {
        return BLEUtil.stringifyParcelUuids(this.scannedAdvertisers.get(deviceAddress).getScanRecord().getServiceUuids());
    }

    /* access modifiers changed from: package-private */
    public String BatteryValue() {
        if (this.isCharRead) {
            return Integer.toString(this.battery);
        }
        return "Cannot Read Battery Level";
    }

    /* access modifiers changed from: package-private */
    public int TxPower() {
        return this.txPower;
    }

    /* access modifiers changed from: package-private */
    public boolean IsDeviceConnected() {
        return this.isConnected;
    }

    /* access modifiers changed from: package-private */
    public String DeviceList() {
        StringBuilder sb;
        StringBuilder sb2;
        this.deviceInfoList = "";
        this.mLeDevices = sortDeviceList(this.mLeDevices);
        if (!this.mLeDevices.isEmpty()) {
            for (int i = 0; i < this.mLeDevices.size(); i++) {
                if (i != this.mLeDevices.size() - 1) {
                    new StringBuilder();
                    this.deviceInfoList = sb2.append(this.deviceInfoList).append(this.mLeDevices.get(i).getAddress()).append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR).append(this.mLeDevices.get(i).getName()).append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR).append(Integer.toString(this.mLeDeviceRssi.get(this.mLeDevices.get(i)).intValue())).append(",").toString();
                } else {
                    new StringBuilder();
                    this.deviceInfoList = sb.append(this.deviceInfoList).append(this.mLeDevices.get(i).getAddress()).append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR).append(this.mLeDevices.get(i).getName()).append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR).append(Integer.toString(this.mLeDeviceRssi.get(this.mLeDevices.get(i)).intValue())).toString();
                }
            }
        }
        return this.deviceInfoList;
    }

    /* access modifiers changed from: package-private */
    public int ConnectedDeviceRssi() {
        return this.device_rssi;
    }

    /* access modifiers changed from: package-private */
    public long AdvertisementScanPeriod() {
        return this.SCAN_PERIOD;
    }

    /* access modifiers changed from: package-private */
    public List<String> GetAdvertiserNames() {
        return this.scannedAdvertiserNames;
    }

    /* access modifiers changed from: package-private */
    public List<String> GetAdvertiserAddresses() {
        return this.advertiserAddresses;
    }

    /* access modifiers changed from: package-private */
    public boolean IsDeviceAdvertising() {
        return this.isAdvertising;
    }

    /* access modifiers changed from: private */
    public void Connected() {
        Runnable runnable;
        new Runnable(this) {
            final /* synthetic */ BluetoothLEint this$0;

            {
                this.this$0 = this$0;
            }

            public void run() {
                Set<BluetoothLE.BluetoothConnectionListener> listeners;
                boolean dispatchEvent = EventDispatcher.dispatchEvent(this.this$0.outer, "Connected", new Object[0]);
                new HashSet<>(this.this$0.outer.connectionListeners);
                for (BluetoothLE.BluetoothConnectionListener listener : listeners) {
                    listener.onConnected(this.this$0.outer);
                }
            }
        };
        boolean post = this.uiThread.post(runnable);
    }

    /* access modifiers changed from: private */
    public void Disconnected() {
        Runnable runnable;
        new Runnable(this) {
            final /* synthetic */ BluetoothLEint this$0;

            {
                this.this$0 = this$0;
            }

            public void run() {
                Set<BluetoothLE.BluetoothConnectionListener> set;
                try {
                    new HashSet(this.this$0.outer.connectionListeners);
                    for (BluetoothLE.BluetoothConnectionListener listener : set) {
                        listener.onDisconnected(this.this$0.outer);
                    }
                    boolean dispatchEvent = EventDispatcher.dispatchEvent(this.this$0.outer, "Disconnected", new Object[0]);
                } catch (Throwable th) {
                    Throwable th2 = th;
                    boolean dispatchEvent2 = EventDispatcher.dispatchEvent(this.this$0.outer, "Disconnected", new Object[0]);
                    throw th2;
                }
            }
        };
        boolean post = this.uiThread.post(runnable);
    }

    /* access modifiers changed from: private */
    public void RssiChanged(int device_rssi2) {
        Runnable runnable;
        final int i = device_rssi2;
        new Runnable(this) {
            final /* synthetic */ BluetoothLEint this$0;

            {
                this.this$0 = this$0;
            }

            public void run() {
                boolean dispatchEvent = EventDispatcher.dispatchEvent(this.this$0.outer, "RssiChanged", Integer.valueOf(i));
            }
        };
        boolean postDelayed = this.uiThread.postDelayed(runnable, 1000);
    }

    private void DeviceFound() {
        Runnable runnable;
        new Runnable(this) {
            final /* synthetic */ BluetoothLEint this$0;

            {
                this.this$0 = this$0;
            }

            public void run() {
                boolean dispatchEvent = EventDispatcher.dispatchEvent(this.this$0.outer, "DeviceFound", new Object[0]);
            }
        };
        boolean post = this.uiThread.post(runnable);
    }

    /*  JADX ERROR: NullPointerException in pass: CodeShrinkVisitor
        java.lang.NullPointerException
        */
    java.lang.String GetSupportedServices() {
        /*
            r10 = this;
            r0 = r10
            r5 = r0
            java.util.List<android.bluetooth.BluetoothGattService> r5 = r5.mGattService
            if (r5 != 0) goto L_0x000b
            java.lang.String r5 = ","
            r0 = r5
        L_0x000a:
            return r0
        L_0x000b:
            r5 = r0
            java.lang.String r6 = ", "
            r5.serviceUUIDList = r6
            r5 = 0
            r1 = r5
        L_0x0013:
            r5 = r1
            r6 = r0
            java.util.List<android.bluetooth.BluetoothGattService> r6 = r6.mGattService
            int r6 = r6.size()
            if (r5 >= r6) goto L_0x0075
            r5 = r1
            if (r5 != 0) goto L_0x0026
            r5 = r0
            java.lang.String r6 = ""
            r5.serviceUUIDList = r6
        L_0x0026:
            r5 = r0
            java.util.List<android.bluetooth.BluetoothGattService> r5 = r5.mGattService
            r6 = r1
            java.lang.Object r5 = r5.get(r6)
            android.bluetooth.BluetoothGattService r5 = (android.bluetooth.BluetoothGattService) r5
            java.util.UUID r5 = r5.getUuid()
            r2 = r5
            java.lang.String r5 = "Unknown Service"
            r3 = r5
            r5 = r2
            r6 = r3
            java.lang.String r5 = edu.mit.appinventor.ble.BluetoothLEGattAttributes.lookup(r5, r6)
            r4 = r5
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r8 = r5
            r5 = r8
            r6 = r8
            r6.<init>()
            r6 = r0
            r8 = r5
            r9 = r6
            r5 = r9
            r6 = r8
            r7 = r9
            java.lang.String r7 = r7.serviceUUIDList
            java.lang.StringBuilder r6 = r6.append(r7)
            r7 = r2
            java.lang.StringBuilder r6 = r6.append(r7)
            java.lang.String r7 = " "
            java.lang.StringBuilder r6 = r6.append(r7)
            r7 = r4
            java.lang.StringBuilder r6 = r6.append(r7)
            java.lang.String r7 = ","
            java.lang.StringBuilder r6 = r6.append(r7)
            java.lang.String r6 = r6.toString()
            r5.serviceUUIDList = r6
            int r1 = r1 + 1
            goto L_0x0013
        L_0x0075:
            r5 = r0
            java.lang.String r5 = r5.serviceUUIDList
            r0 = r5
            goto L_0x000a
        */
        throw new UnsupportedOperationException("Method not decompiled: edu.mit.appinventor.ble.BluetoothLEint.GetSupportedServices():java.lang.String");
    }

    /* access modifiers changed from: package-private */
    public YailList getSupportedServicesList() {
        List<YailList> list;
        if (this.mGattService == null) {
            return YailList.makeEmptyList();
        }
        new ArrayList<>();
        List<YailList> results = list;
        for (BluetoothGattService service : this.mGattService) {
            UUID serviceUuid = service.getUuid();
            Object[] objArr = new Object[2];
            objArr[0] = serviceUuid.toString();
            Object[] objArr2 = objArr;
            objArr2[1] = BluetoothLEGattAttributes.lookup(serviceUuid, UNKNOWN_SERVICE_NAME);
            boolean add = results.add(YailList.makeList(objArr2));
        }
        return YailList.makeList((List) results);
    }

    /* access modifiers changed from: package-private */
    public String GetServiceByIndex(int i) {
        Throwable th;
        StringBuilder sb;
        int index = i;
        if (index >= 1 && index <= this.mGattService.size()) {
            return this.mGattService.get(index - 1).getUuid().toString();
        }
        Throwable th2 = th;
        new StringBuilder();
        new IndexOutOfBoundsException(sb.append("Expected service index between 1 and ").append(this.mGattService.size()).toString());
        throw th2;
    }

    /* access modifiers changed from: package-private */
    public String GetSupportedCharacteristics() {
        StringBuilder sb;
        if (this.mGattService == null || this.mGattService.size() == 0) {
            return ",";
        }
        this.gattChars.clear();
        for (BluetoothGattService bluetoothGattService : this.mGattService) {
            boolean addAll = this.gattChars.addAll(bluetoothGattService.getCharacteristics());
        }
        String unknownCharString = UNKNOWN_CHAR_NAME;
        new StringBuilder();
        StringBuilder sb2 = sb;
        String sep = "";
        Iterator<BluetoothGattCharacteristic> it = this.gattChars.iterator();
        while (it.hasNext()) {
            UUID charUUID = it.next().getUuid();
            String charName = BluetoothLEGattAttributes.lookup(charUUID, unknownCharString);
            StringBuilder append = sb2.append(sep);
            StringBuilder append2 = sb2.append(charUUID);
            StringBuilder append3 = sb2.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
            StringBuilder append4 = sb2.append(charName);
            sep = ",";
        }
        this.charUUIDList = sb2.toString();
        return this.charUUIDList;
    }

    /* access modifiers changed from: package-private */
    public YailList getSupportedCharacteristicsList() {
        List<YailList> list;
        if (this.mGattService == null) {
            return YailList.makeEmptyList();
        }
        new ArrayList<>();
        List<YailList> results = list;
        for (BluetoothGattService service : this.mGattService) {
            for (BluetoothGattCharacteristic characteristic : service.getCharacteristics()) {
                UUID serviceUuid = service.getUuid();
                UUID characteristicUuid = characteristic.getUuid();
                Object[] objArr = new Object[3];
                objArr[0] = serviceUuid.toString();
                Object[] objArr2 = objArr;
                objArr2[1] = characteristicUuid.toString();
                Object[] objArr3 = objArr2;
                objArr3[2] = BluetoothLEGattAttributes.lookup(characteristicUuid, UNKNOWN_CHAR_NAME);
                boolean add = results.add(YailList.makeList(objArr3));
            }
        }
        return YailList.makeList((List) results);
    }

    /* access modifiers changed from: package-private */
    public YailList GetCharacteristicsForService(String str) {
        List<YailList> list;
        Throwable th;
        StringBuilder sb;
        Throwable th2;
        StringBuilder sb2;
        String serviceUuid = str;
        if (this.mGattService == null) {
            return YailList.makeEmptyList();
        }
        new ArrayList<>();
        List<YailList> result = list;
        Object obj = UNKNOWN_CHAR_NAME;
        try {
            BluetoothGattService service = this.mBluetoothGatt.getService(UUID.fromString(serviceUuid));
            if (service == null) {
                Throwable th3 = th2;
                new StringBuilder();
                new IllegalArgumentException(sb2.append("Device does not advertise service ").append(serviceUuid).toString());
                throw th3;
            }
            for (BluetoothGattCharacteristic c : service.getCharacteristics()) {
                Object[] objArr = new Object[2];
                objArr[0] = c.getUuid().toString().toUpperCase();
                Object[] objArr2 = objArr;
                objArr2[1] = BluetoothLEGattAttributes.lookup(c.getUuid(), UNKNOWN_CHAR_NAME);
                boolean add = result.add(YailList.makeList(objArr2));
            }
            return YailList.makeList((List) result);
        } catch (Exception e) {
            Exception e2 = e;
            int e3 = Log.e(LOG_TAG, "Exception while looking up BluetoothLE service", e2);
            Throwable th4 = th;
            new StringBuilder();
            new RuntimeException(sb.append("Exception while looking up BluetoothLE service: ").append(e2.getMessage()).toString(), e2);
            throw th4;
        }
    }

    /* access modifiers changed from: package-private */
    public String GetCharacteristicByIndex(int i) {
        Throwable th;
        StringBuilder sb;
        int index = i;
        if (index >= 1 && index <= this.gattChars.size()) {
            return this.gattChars.get(index - 1).getUuid().toString();
        }
        Throwable th2 = th;
        new StringBuilder();
        new IndexOutOfBoundsException(sb.append("Expected characteristic index between 1 and ").append(this.gattChars.size()).toString());
        throw th2;
    }

    /* access modifiers changed from: package-private */
    public boolean isServicePublished(String serviceUuid) {
        return (this.mBluetoothGatt == null || this.mBluetoothGatt.getService(BLEUtil.bleStringToUuid(serviceUuid)) == null) ? false : true;
    }

    /* access modifiers changed from: package-private */
    public boolean isCharacteristicPublished(String serviceUuid, String characteristicUuid) {
        BluetoothGattService gattService;
        UUID service = BLEUtil.bleStringToUuid(serviceUuid);
        UUID characteristic = BLEUtil.bleStringToUuid(characteristicUuid);
        if (this.mBluetoothGatt == null || (gattService = this.mBluetoothGatt.getService(service)) == null) {
            return false;
        }
        return gattService.getCharacteristic(characteristic) != null;
    }

    /* access modifiers changed from: package-private */
    public void setConnectionTimeout(int timeout) {
        int i = timeout;
        this.connectionTimeout = i;
    }

    /* access modifiers changed from: package-private */
    public int getConnectionTimeout() {
        return this.connectionTimeout;
    }

    /* access modifiers changed from: package-private */
    public void setAutoReconnect(boolean autoReconnect2) {
        boolean z = autoReconnect2;
        this.autoReconnect = z;
    }

    /* access modifiers changed from: package-private */
    public boolean getAutoReconnect() {
        return this.autoReconnect;
    }

    /* access modifiers changed from: package-private */
    public void setNullTerminatedStrings(boolean terminate) {
        boolean z = terminate;
        this.nullTerminateStrings = z;
    }

    /* access modifiers changed from: package-private */
    public boolean isNullTerminatedStrings() {
        return this.nullTerminateStrings;
    }

    /* access modifiers changed from: package-private */
    public void readConnectedRssi() {
        if (this.mBluetoothGatt != null) {
            boolean readRemoteRssi = this.mBluetoothGatt.readRemoteRssi();
        }
    }

    /* access modifiers changed from: package-private */
    public boolean canReadCharacteristic(String serviceUuid, String characteristicUuid) {
        AnonymousClass45 r10;
        final String str = serviceUuid;
        final String str2 = characteristicUuid;
        new BLEAction<Boolean>(this, "CanReadCharacteristic") {
            final /* synthetic */ BluetoothLEint this$0;

            {
                BluetoothLEint this$02 = r9;
                this.this$0 = this$02;
            }

            public Boolean action() {
                BluetoothGattCharacteristic bleChar = this.this$0.findMGattChar(BLEUtil.bleStringToUuid(str), BLEUtil.bleStringToUuid(str2));
                if (bleChar == null) {
                    return null;
                }
                return Boolean.valueOf((bleChar.getProperties() & 2) != 0);
            }
        };
        Boolean result = (Boolean) r10.run();
        return result == null ? false : result.booleanValue();
    }

    /* access modifiers changed from: package-private */
    public boolean canRegisterForCharacteristic(String serviceUuid, String characteristicUuid) {
        AnonymousClass46 r10;
        final String str = serviceUuid;
        final String str2 = characteristicUuid;
        new BLEAction<Boolean>(this, "CanRegisterForCharacteristic") {
            final /* synthetic */ BluetoothLEint this$0;

            {
                BluetoothLEint this$02 = r9;
                this.this$0 = this$02;
            }

            public Boolean action() {
                BluetoothGattCharacteristic bleChar = this.this$0.findMGattChar(BLEUtil.bleStringToUuid(str), BLEUtil.bleStringToUuid(str2));
                if (bleChar == null) {
                    return null;
                }
                return Boolean.valueOf(((bleChar.getProperties() & 16) == 0 && (bleChar.getProperties() & 32) == 0) ? false : true);
            }
        };
        Boolean result = (Boolean) r10.run();
        return result == null ? false : result.booleanValue();
    }

    /* access modifiers changed from: package-private */
    public boolean canWriteCharacteristic(String serviceUuid, String characteristicUuid) {
        AnonymousClass47 r10;
        final String str = serviceUuid;
        final String str2 = characteristicUuid;
        new BLEAction<Boolean>(this, "CanWriteCharacteristic") {
            final /* synthetic */ BluetoothLEint this$0;

            {
                BluetoothLEint this$02 = r9;
                this.this$0 = this$02;
            }

            public Boolean action() {
                BluetoothGattCharacteristic bleChar = this.this$0.findMGattChar(BLEUtil.bleStringToUuid(str), BLEUtil.bleStringToUuid(str2));
                if (bleChar == null) {
                    return null;
                }
                return Boolean.valueOf((bleChar.getProperties() & 4) != 0);
            }
        };
        Boolean result = (Boolean) r10.run();
        return result == null ? false : result.booleanValue();
    }

    /* access modifiers changed from: package-private */
    public boolean canWriteCharacteristicWithResponse(String serviceUuid, String characteristicUuid) {
        AnonymousClass48 r10;
        final String str = serviceUuid;
        final String str2 = characteristicUuid;
        new BLEAction<Boolean>(this, "CanWriteCharacteristicWithResponse") {
            final /* synthetic */ BluetoothLEint this$0;

            {
                BluetoothLEint this$02 = r9;
                this.this$0 = this$02;
            }

            public Boolean action() {
                BluetoothGattCharacteristic bleChar = this.this$0.findMGattChar(BLEUtil.bleStringToUuid(str), BLEUtil.bleStringToUuid(str2));
                if (bleChar == null) {
                    return null;
                }
                return Boolean.valueOf((bleChar.getProperties() & 8) != 0);
            }
        };
        Boolean result = (Boolean) r10.run();
        return result == null ? false : result.booleanValue();
    }

    /* access modifiers changed from: private */
    public void signalError(String functionName, int i, Object... messageArgs) {
        Runnable runnable;
        int errorNumber = i;
        String errorMessage = String.format(errorMessages.get(Integer.valueOf(errorNumber)), messageArgs);
        int e = Log.e(LOG_TAG, errorMessage);
        final String str = functionName;
        final int i2 = errorNumber;
        final String str2 = errorMessage;
        new Runnable(this) {
            final /* synthetic */ BluetoothLEint this$0;

            {
                this.this$0 = this$0;
            }

            public void run() {
                Form $form = this.this$0.container.$form();
                BluetoothLE access$1200 = this.this$0.outer;
                String str = str;
                Object[] objArr = new Object[3];
                objArr[0] = Integer.valueOf(i2);
                Object[] objArr2 = objArr;
                objArr2[1] = "BluetoothLE";
                Object[] objArr3 = objArr2;
                objArr3[2] = str2;
                $form.dispatchErrorOccurredEvent(access$1200, str, ErrorMessages.ERROR_EXTENSION_ERROR, objArr3);
            }
        };
        this.activity.runOnUiThread(runnable);
    }

    /* access modifiers changed from: private */
    public boolean validateUUID(String str, String str2, String str3) {
        String UUID = str;
        String type = str2;
        String callerBlock = str3;
        if (BLEUtil.hasValidUUIDFormat(UUID)) {
            return true;
        }
        if (BLEUtil.hasInvalidUUIDChars(UUID)) {
            Object[] objArr = new Object[2];
            objArr[0] = type;
            Object[] objArr2 = objArr;
            objArr2[1] = callerBlock;
            signalError(callerBlock, ERROR_INVALID_UUID_CHARACTERS, objArr2);
            return false;
        }
        Object[] objArr3 = new Object[2];
        objArr3[0] = type;
        Object[] objArr4 = objArr3;
        objArr4[1] = callerBlock;
        signalError(callerBlock, ERROR_INVALID_UUID_FORMAT, objArr4);
        return false;
    }

    private List<BluetoothDevice> sortDeviceList(List<BluetoothDevice> list) {
        Comparator comparator;
        List<BluetoothDevice> deviceList = list;
        new Comparator<BluetoothDevice>(this) {
            final /* synthetic */ BluetoothLEint this$0;

            {
                this.this$0 = this$0;
            }

            public int compare(BluetoothDevice device1, BluetoothDevice device2) {
                return ((Integer) this.this$0.mLeDeviceRssi.get(device2)).intValue() - ((Integer) this.this$0.mLeDeviceRssi.get(device1)).intValue();
            }
        };
        Collections.sort(deviceList, comparator);
        return deviceList;
    }

    /* access modifiers changed from: private */
    public void addDevice(BluetoothDevice bluetoothDevice, int i) {
        BluetoothDevice device = bluetoothDevice;
        int rssi = i;
        if (!this.mLeDevices.contains(device)) {
            boolean add = this.mLeDevices.add(device);
            Integer put = this.mLeDeviceRssi.put(device, Integer.valueOf(rssi));
            DeviceFound();
        } else {
            Integer put2 = this.mLeDeviceRssi.put(device, Integer.valueOf(rssi));
        }
        RssiChanged(rssi);
    }

    /* access modifiers changed from: private */
    public BluetoothGattCharacteristic findMGattChar(UUID uuid, UUID uuid2) {
        StringBuilder sb;
        StringBuilder sb2;
        Throwable th;
        StringBuilder sb3;
        Throwable th2;
        UUID ser_uuid = uuid;
        UUID char_uuid = uuid2;
        new StringBuilder();
        int i = Log.i(LOG_TAG, sb.append("isServiceRead: ").append(this.isServiceRead).toString());
        new StringBuilder();
        int i2 = Log.i(LOG_TAG, sb2.append("mGattService.isEmpty(): ").append(this.mGattService.isEmpty()).toString());
        if (!this.isServiceRead) {
            Throwable th3 = th2;
            new IllegalStateException("Not connected to a Bluetooth low energy device.");
            throw th3;
        }
        if (!this.mGattService.isEmpty()) {
            for (BluetoothGattService aMGattService : this.mGattService) {
                if (aMGattService.getUuid().equals(ser_uuid)) {
                    return aMGattService.getCharacteristic(char_uuid);
                }
            }
        }
        Throwable th4 = th;
        new StringBuilder();
        new IllegalStateException(sb3.append("Service ").append(ser_uuid).append(", characteristic ").append(char_uuid).append(" are not published by the connected device.").toString());
        throw th4;
    }

    private void readChar(UUID ser_uuid, UUID char_uuid) {
        StringBuilder sb;
        this.mGattChar = findMGattChar(ser_uuid, char_uuid);
        if (this.mGattChar != null) {
            new StringBuilder();
            int i = Log.i(LOG_TAG, sb.append("mGattChar initialized to ").append(this.mGattChar.getUuid().toString()).toString());
            BluetoothGattDescriptor desc = this.mGattChar.getDescriptor(BluetoothLEGattAttributes.CLIENT_CHARACTERISTIC_CONFIGURATION);
            if (desc != null) {
                if ((this.mGattChar.getProperties() & 32) != 0) {
                    boolean value = desc.setValue(BluetoothGattDescriptor.ENABLE_INDICATION_VALUE);
                } else {
                    boolean value2 = desc.setValue(BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE);
                }
                boolean writeDescriptor = this.mBluetoothGatt.writeDescriptor(desc);
            }
            boolean characteristicNotification = this.mBluetoothGatt.setCharacteristicNotification(this.mGattChar, true);
            this.isCharRead = this.mBluetoothGatt.readCharacteristic(this.mGattChar);
        } else {
            int i2 = Log.i(LOG_TAG, "mGattChar is null!");
        }
        if (this.isCharRead) {
            int i3 = Log.i(LOG_TAG, "Read Character Successfully.");
        } else {
            int e = Log.e(LOG_TAG, "Read Character Fail.");
        }
    }

    private void writeChar(UUID ser_uuid, UUID char_uuid, Object obj) {
        StringBuilder sb;
        Throwable th;
        Object payload = obj;
        this.mGattChar = findMGattChar(ser_uuid, char_uuid);
        if (this.mGattChar == null || payload == null) {
            int i = Log.i(LOG_TAG, "mGattChar is null!");
        } else {
            new StringBuilder();
            int i2 = Log.i(LOG_TAG, sb.append("mGattChar initialized to ").append(this.mGattChar.getUuid().toString()).toString());
            if (payload instanceof int[]) {
                int[] args = (int[]) payload;
                boolean value = this.mGattChar.setValue(args[0], args[1], args[2]);
            } else if (payload instanceof byte[]) {
                boolean value2 = this.mGattChar.setValue((byte[]) payload);
            } else if (payload instanceof String) {
                boolean value3 = this.mGattChar.setValue((String) payload);
            } else {
                Throwable th2 = th;
                new IllegalArgumentError("Attempted to write to characteristic with unsupported data type.");
                throw th2;
            }
            this.isCharWritten = this.mBluetoothGatt.writeCharacteristic(this.mGattChar);
        }
        if (this.isCharWritten) {
            int i3 = Log.i(LOG_TAG, "Write Gatt Characteristic Successfully");
        } else {
            int e = Log.e(LOG_TAG, "Write Gatt Characteristic Fail");
        }
    }

    /* access modifiers changed from: private */
    public void schedulePendingOperation(BLEOperation bLEOperation) {
        BLEOperation operation = bLEOperation;
        Queue<BLEOperation> queue = this.pendingOperations;
        Queue<BLEOperation> queue2 = queue;
        synchronized (queue) {
            try {
                boolean add = this.pendingOperations.add(operation);
                if (this.pendingOperations.size() == 1) {
                    boolean post = this.mHandler.post(operation);
                }
            } catch (Throwable th) {
                Throwable th2 = th;
                Queue<BLEOperation> queue3 = queue2;
                throw th2;
            }
        }
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: private */
    public boolean runPendingOperation(BLEOperation bLEOperation) {
        StringBuilder sb;
        StringBuilder sb2;
        StringBuilder sb3;
        BLEOperation after = bLEOperation;
        Queue<BLEOperation> queue = this.pendingOperations;
        Queue<BLEOperation> queue2 = queue;
        synchronized (queue) {
            boolean removed = false;
            try {
                BLEOperation operation = this.pendingOperations.peek();
                if (operation == after) {
                    BLEOperation poll = this.pendingOperations.poll();
                    removed = true;
                    BLEOperation operation2 = this.pendingOperations.peek();
                    new StringBuilder();
                    int d = Log.d(LOG_TAG, sb3.append("running next operation ").append(operation2).toString());
                    if (operation2 != null) {
                        boolean post = this.mHandler.post(operation2);
                    }
                } else {
                    new StringBuilder();
                    int d2 = Log.d(LOG_TAG, sb.append("after operation = ").append(after).toString());
                    new StringBuilder();
                    int d3 = Log.d(LOG_TAG, sb2.append("pending operation = ").append(operation).toString());
                }
                boolean z = removed;
                return z;
            } catch (Throwable th) {
                Throwable th2 = th;
                Queue<BLEOperation> queue3 = queue2;
                throw th2;
            }
        }
    }

    /* access modifiers changed from: private */
    public void scheduleConnectionTimeoutMessage() {
        Runnable runnable;
        new Runnable(this) {
            final /* synthetic */ BluetoothLEint this$0;

            {
                this.this$0 = this$0;
            }

            public void run() {
                if (!this.this$0.isConnected && this.this$0.mBluetoothGatt != null) {
                    this.this$0.mBluetoothGatt.disconnect();
                    this.this$0.outer.ConnectionFailed("Connection timeout reached");
                }
            }
        };
        boolean postDelayed = this.uiThread.postDelayed(runnable, (long) (this.connectionTimeout * 1000));
    }

    /* access modifiers changed from: private */
    public void forceDisconnect() {
        if (this.mBluetoothGatt != null) {
            if (this.isConnected) {
                this.mBluetoothGatt.disconnect();
                this.mBluetoothGatt.close();
                this.mBluetoothGatt = null;
            } else if (this.autoReconnect) {
                this.mBluetoothGatt.disconnect();
                this.mBluetoothGatt.close();
                this.mBluetoothGatt = null;
            }
            this.isConnected = false;
            this.isUserDisconnect = true;
        }
        this.mBluetoothGatt = null;
    }
}
