package com.microsoft.appcenter;

import android.support.annotation.VisibleForTesting;
import com.microsoft.appcenter.utils.AppCenterLog;
import com.microsoft.appcenter.utils.InstrumentationRegistryHelper;

class ServiceInstrumentationUtils {
    @VisibleForTesting
    static final String DISABLE_ALL_SERVICES = "All";
    @VisibleForTesting
    static final String DISABLE_SERVICES = "APP_CENTER_DISABLE";

    ServiceInstrumentationUtils() {
    }

    static boolean isServiceDisabledByInstrumentation(String str) {
        String serviceName = str;
        try {
            String disableServices = InstrumentationRegistryHelper.getArguments().getString(DISABLE_SERVICES);
            if (disableServices == null) {
                return false;
            }
            String[] split = disableServices.split(",");
            int length = split.length;
            for (int i = 0; i < length; i++) {
                String service = split[i].trim();
                if (service.equals(DISABLE_ALL_SERVICES) || service.equals(serviceName)) {
                    return true;
                }
            }
            return false;
        } catch (IllegalStateException | LinkageError e) {
            Object obj = e;
            AppCenterLog.debug("AppCenter", "Cannot read instrumentation variables in a non-test environment.");
            return false;
        }
    }
}
