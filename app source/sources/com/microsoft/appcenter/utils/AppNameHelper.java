package com.microsoft.appcenter.utils;

import android.content.Context;
import android.content.pm.ApplicationInfo;

public class AppNameHelper {
    public AppNameHelper() {
    }

    public static String getAppName(Context context) {
        Context context2 = context;
        ApplicationInfo applicationInfo = context2.getApplicationInfo();
        int labelRes = applicationInfo.labelRes;
        if (labelRes == 0) {
            return String.valueOf(applicationInfo.nonLocalizedLabel);
        }
        return context2.getString(labelRes);
    }
}
