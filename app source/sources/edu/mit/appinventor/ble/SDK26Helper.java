package edu.mit.appinventor.ble;

import android.os.Build;
import com.google.appinventor.components.runtime.Form;
import com.google.appinventor.components.runtime.PermissionResultHandler;

class SDK26Helper {
    SDK26Helper() {
    }

    static boolean shouldAskForPermission(Form form) {
        return form.getApplicationInfo().targetSdkVersion >= 23 && Build.VERSION.SDK_INT >= 23;
    }

    static void askForPermission(BluetoothLE bluetoothLE, Runnable next) {
        PermissionResultHandler permissionResultHandler;
        BluetoothLE ble = bluetoothLE;
        final Runnable runnable = next;
        final BluetoothLE bluetoothLE2 = ble;
        new PermissionResultHandler() {
            public void HandlePermissionResponse(String str, boolean granted) {
                String permission = str;
                if (granted) {
                    runnable.run();
                } else {
                    bluetoothLE2.getForm().PermissionDenied(bluetoothLE2, "StartScanning", permission);
                }
            }
        };
        ble.getForm().askPermission("android.permission.ACCESS_FINE_LOCATION", permissionResultHandler);
    }
}
