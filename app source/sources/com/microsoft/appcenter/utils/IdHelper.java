package com.microsoft.appcenter.utils;

import android.support.annotation.NonNull;
import com.microsoft.appcenter.utils.storage.SharedPreferencesManager;
import java.util.UUID;

public class IdHelper {
    public IdHelper() {
    }

    @NonNull
    public static UUID getInstallId() {
        UUID installId;
        try {
            installId = UUID.fromString(SharedPreferencesManager.getString(PrefStorageConstants.KEY_INSTALL_ID, ""));
        } catch (Exception e) {
            Exception exc = e;
            AppCenterLog.warn("AppCenter", "Unable to get installID from Shared Preferences");
            installId = UUID.randomUUID();
            SharedPreferencesManager.putString(PrefStorageConstants.KEY_INSTALL_ID, installId.toString());
        }
        return installId;
    }
}
