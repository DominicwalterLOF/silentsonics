package edu.mit.appinventor.ble;

import android.os.ParcelUuid;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.regex.Pattern;

final class BLEUtil {
    public static final String BLUETOOTH_BASE_UUID_SUFFIX = "-0000-1000-8000-00805F9B34FB";
    private static final Pattern INVALID_UUID_CHARS = Pattern.compile("[^0-9a-fA-F-]");
    private static final Pattern UUID_FORMAT = Pattern.compile("[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}");

    BLEUtil() {
    }

    static boolean hasValidUUIDFormat(String UUID) {
        return UUID_FORMAT.matcher(UUID).find();
    }

    static boolean hasInvalidUUIDChars(String UUID) {
        return INVALID_UUID_CHARS.matcher(UUID).find();
    }

    static List<String> stringifyParcelUuids(List<ParcelUuid> serviceUUIDs) {
        List<ParcelUuid> list;
        new ArrayList<>();
        List<ParcelUuid> deviceServices = list;
        for (ParcelUuid serviceUuid : serviceUUIDs) {
            boolean add = deviceServices.add(serviceUuid.toString());
        }
        return deviceServices;
    }

    public static UUID bleStringToUuid(String uuid) {
        Throwable th;
        StringBuilder sb;
        StringBuilder sb2;
        StringBuilder sb3;
        StringBuilder sb4;
        String uuid2 = uuid.toLowerCase();
        if (uuid2.length() == 4) {
            new StringBuilder();
            uuid2 = sb4.append("0000").append(uuid2).append(BLUETOOTH_BASE_UUID_SUFFIX).toString();
        } else if (uuid2.length() == 8) {
            new StringBuilder();
            uuid2 = sb3.append(uuid2).append(BLUETOOTH_BASE_UUID_SUFFIX).toString();
        } else if (uuid2.length() == 32) {
            new StringBuilder();
            uuid2 = sb2.append(uuid2.substring(0, 8)).append("-").append(uuid2.substring(8, 12)).append("-").append(uuid2.substring(12, 16)).append("-").append(uuid2.substring(16, 20)).append("-").append(uuid2.substring(20)).toString();
        } else if (!hasValidUUIDFormat(uuid2)) {
            Throwable th2 = th;
            new StringBuilder();
            new IllegalArgumentException(sb.append("Invalid UUID: ").append(uuid2).toString());
            throw th2;
        }
        return UUID.fromString(uuid2);
    }
}
