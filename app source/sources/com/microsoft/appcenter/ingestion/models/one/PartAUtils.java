package com.microsoft.appcenter.ingestion.models.one;

import com.microsoft.appcenter.ingestion.models.Device;
import com.microsoft.appcenter.ingestion.models.Log;
import com.microsoft.appcenter.utils.context.UserIdContext;
import java.util.Locale;
import java.util.regex.Pattern;
import org.slf4j.Marker;

public class PartAUtils {
    private static final Pattern NAME_REGEX = Pattern.compile("^[a-zA-Z0-9]((\\.(?!(\\.|$)))|[_a-zA-Z0-9]){3,99}$");

    public PartAUtils() {
    }

    public static String getTargetKey(String targetToken) {
        return targetToken.split("-")[0];
    }

    public static void setName(CommonSchemaLog commonSchemaLog, String str) throws IllegalArgumentException {
        Throwable th;
        StringBuilder sb;
        Throwable th2;
        CommonSchemaLog log = commonSchemaLog;
        String name = str;
        if (name == null) {
            Throwable th3 = th2;
            new IllegalArgumentException("Name cannot be null.");
            throw th3;
        } else if (!NAME_REGEX.matcher(name).matches()) {
            Throwable th4 = th;
            new StringBuilder();
            new IllegalArgumentException(sb.append("Name must match '").append(NAME_REGEX).append("' but was '").append(name).append("'.").toString());
            throw th4;
        } else {
            log.setName(name);
        }
    }

    public static void addPartAFromLog(Log log, CommonSchemaLog commonSchemaLog, String str) {
        StringBuilder sb;
        ProtocolExtension protocolExtension;
        UserExtension userExtension;
        OsExtension osExtension;
        StringBuilder sb2;
        AppExtension appExtension;
        StringBuilder sb3;
        NetExtension netExtension;
        SdkExtension sdkExtension;
        StringBuilder sb4;
        LocExtension locExtension;
        DeviceExtension deviceExtension;
        Extensions extensions;
        Log src = log;
        CommonSchemaLog dest = commonSchemaLog;
        String transmissionTarget = str;
        Device device = src.getDevice();
        dest.setVer("3.0");
        dest.setTimestamp(src.getTimestamp());
        new StringBuilder();
        dest.setIKey(sb.append("o:").append(getTargetKey(transmissionTarget)).toString());
        dest.addTransmissionTarget(transmissionTarget);
        if (dest.getExt() == null) {
            new Extensions();
            dest.setExt(extensions);
        }
        new ProtocolExtension();
        dest.getExt().setProtocol(protocolExtension);
        dest.getExt().getProtocol().setDevModel(device.getModel());
        dest.getExt().getProtocol().setDevMake(device.getOemName());
        new UserExtension();
        dest.getExt().setUser(userExtension);
        dest.getExt().getUser().setLocalId(UserIdContext.getPrefixedUserId(src.getUserId()));
        dest.getExt().getUser().setLocale(device.getLocale().replace("_", "-"));
        new OsExtension();
        dest.getExt().setOs(osExtension);
        dest.getExt().getOs().setName(device.getOsName());
        OsExtension os = dest.getExt().getOs();
        new StringBuilder();
        os.setVer(sb2.append(device.getOsVersion()).append("-").append(device.getOsBuild()).append("-").append(device.getOsApiLevel()).toString());
        new AppExtension();
        dest.getExt().setApp(appExtension);
        dest.getExt().getApp().setVer(device.getAppVersion());
        AppExtension app = dest.getExt().getApp();
        new StringBuilder();
        app.setId(sb3.append("a:").append(device.getAppNamespace()).toString());
        new NetExtension();
        dest.getExt().setNet(netExtension);
        dest.getExt().getNet().setProvider(device.getCarrierName());
        new SdkExtension();
        dest.getExt().setSdk(sdkExtension);
        SdkExtension sdk = dest.getExt().getSdk();
        new StringBuilder();
        sdk.setLibVer(sb4.append(device.getSdkName()).append("-").append(device.getSdkVersion()).toString());
        new LocExtension();
        dest.getExt().setLoc(locExtension);
        Locale locale = Locale.US;
        Object[] objArr = new Object[3];
        Object[] objArr2 = objArr;
        objArr[0] = device.getTimeZoneOffset().intValue() >= 0 ? Marker.ANY_NON_NULL_MARKER : "-";
        Object[] objArr3 = objArr2;
        objArr3[1] = Integer.valueOf(Math.abs(device.getTimeZoneOffset().intValue() / 60));
        Object[] objArr4 = objArr3;
        objArr4[2] = Integer.valueOf(Math.abs(device.getTimeZoneOffset().intValue() % 60));
        dest.getExt().getLoc().setTz(String.format(locale, "%s%02d:%02d", objArr4));
        new DeviceExtension();
        dest.getExt().setDevice(deviceExtension);
    }
}
