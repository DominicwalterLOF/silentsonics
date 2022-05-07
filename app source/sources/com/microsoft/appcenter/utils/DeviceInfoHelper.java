package com.microsoft.appcenter.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.graphics.Point;
import android.hardware.display.DisplayManager;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.microsoft.appcenter.ingestion.models.Device;
import com.microsoft.appcenter.ingestion.models.WrapperSdk;
import java.util.Locale;
import java.util.TimeZone;
import org.jose4j.jwk.EllipticCurveJsonWebKey;

public class DeviceInfoHelper {
    private static final String OS_NAME = "Android";
    private static WrapperSdk sWrapperSdk;

    public DeviceInfoHelper() {
    }

    public static synchronized Device getDeviceInfo(Context context) throws DeviceInfoException {
        Device device;
        Throwable th;
        Device device2;
        Context context2 = context;
        synchronized (DeviceInfoHelper.class) {
            Device device3 = device;
            new Device();
            Device device4 = device3;
            try {
                PackageInfo packageInfo = context2.getPackageManager().getPackageInfo(context2.getPackageName(), 0);
                device4.setAppVersion(packageInfo.versionName);
                device4.setAppBuild(String.valueOf(getVersionCode(packageInfo)));
                device4.setAppNamespace(context2.getPackageName());
                try {
                    TelephonyManager telephonyManager = (TelephonyManager) context2.getSystemService("phone");
                    String networkCountryIso = telephonyManager.getNetworkCountryIso();
                    if (!TextUtils.isEmpty(networkCountryIso)) {
                        device4.setCarrierCountry(networkCountryIso);
                    }
                    String networkOperatorName = telephonyManager.getNetworkOperatorName();
                    if (!TextUtils.isEmpty(networkOperatorName)) {
                        device4.setCarrierName(networkOperatorName);
                    }
                } catch (Exception e) {
                    AppCenterLog.error("AppCenter", "Cannot retrieve carrier info", e);
                }
                device4.setLocale(Locale.getDefault().toString());
                device4.setModel(Build.MODEL);
                device4.setOemName(Build.MANUFACTURER);
                device4.setOsApiLevel(Integer.valueOf(Build.VERSION.SDK_INT));
                device4.setOsName(OS_NAME);
                device4.setOsVersion(Build.VERSION.RELEASE);
                device4.setOsBuild(Build.ID);
                try {
                    device4.setScreenSize(getScreenSize(context2));
                } catch (Exception e2) {
                    AppCenterLog.error("AppCenter", "Cannot retrieve screen size", e2);
                }
                device4.setSdkName("appcenter.android");
                device4.setSdkVersion("3.3.0");
                device4.setTimeZoneOffset(Integer.valueOf((TimeZone.getDefault().getOffset(System.currentTimeMillis()) / 60) / 1000));
                if (sWrapperSdk != null) {
                    device4.setWrapperSdkVersion(sWrapperSdk.getWrapperSdkVersion());
                    device4.setWrapperSdkName(sWrapperSdk.getWrapperSdkName());
                    device4.setWrapperRuntimeVersion(sWrapperSdk.getWrapperRuntimeVersion());
                    device4.setLiveUpdateReleaseLabel(sWrapperSdk.getLiveUpdateReleaseLabel());
                    device4.setLiveUpdateDeploymentKey(sWrapperSdk.getLiveUpdateDeploymentKey());
                    device4.setLiveUpdatePackageHash(sWrapperSdk.getLiveUpdatePackageHash());
                }
                device2 = device4;
            } catch (Exception e3) {
                Exception e4 = e3;
                AppCenterLog.error("AppCenter", "Cannot retrieve package info", e4);
                Throwable th2 = th;
                new DeviceInfoException("Cannot retrieve package info", e4);
                throw th2;
            }
        }
        return device2;
    }

    public static int getVersionCode(PackageInfo packageInfo) {
        return packageInfo.versionCode;
    }

    @SuppressLint({"SwitchIntDef"})
    private static String getScreenSize(Context context) {
        Point point;
        Display defaultDisplay;
        int screenHeight;
        int screenWidth;
        StringBuilder sb;
        Context context2 = context;
        new Point();
        Point size = point;
        if (Build.VERSION.SDK_INT >= 17) {
            defaultDisplay = ((DisplayManager) context2.getSystemService("display")).getDisplay(0);
            DisplayMetrics displayMetrics = context2.getResources().getDisplayMetrics();
            size.x = displayMetrics.widthPixels;
            size.y = displayMetrics.heightPixels;
        } else {
            defaultDisplay = ((WindowManager) context2.getSystemService("window")).getDefaultDisplay();
            defaultDisplay.getSize(size);
        }
        switch (defaultDisplay.getRotation()) {
            case 1:
            case 3:
                screenHeight = size.x;
                screenWidth = size.y;
                break;
            default:
                screenWidth = size.x;
                screenHeight = size.y;
                break;
        }
        new StringBuilder();
        return sb.append(screenWidth).append(EllipticCurveJsonWebKey.X_MEMBER_NAME).append(screenHeight).toString();
    }

    public static synchronized void setWrapperSdk(WrapperSdk wrapperSdk) {
        WrapperSdk wrapperSdk2 = wrapperSdk;
        synchronized (DeviceInfoHelper.class) {
            sWrapperSdk = wrapperSdk2;
        }
    }

    public static class DeviceInfoException extends Exception {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public DeviceInfoException(String detailMessage, Throwable throwable) {
            super(detailMessage, throwable);
        }
    }
}
