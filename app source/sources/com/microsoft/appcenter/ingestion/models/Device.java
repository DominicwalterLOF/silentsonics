package com.microsoft.appcenter.ingestion.models;

import com.microsoft.appcenter.ingestion.models.json.JSONUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

public class Device extends WrapperSdk {
    private static final String APP_BUILD = "appBuild";
    private static final String APP_NAMESPACE = "appNamespace";
    private static final String APP_VERSION = "appVersion";
    private static final String CARRIER_COUNTRY = "carrierCountry";
    private static final String CARRIER_NAME = "carrierName";
    private static final String LOCALE = "locale";
    private static final String MODEL = "model";
    private static final String OEM_NAME = "oemName";
    private static final String OS_API_LEVEL = "osApiLevel";
    private static final String OS_BUILD = "osBuild";
    private static final String OS_NAME = "osName";
    private static final String OS_VERSION = "osVersion";
    private static final String SCREEN_SIZE = "screenSize";
    private static final String SDK_NAME = "sdkName";
    private static final String SDK_VERSION = "sdkVersion";
    private static final String TIME_ZONE_OFFSET = "timeZoneOffset";
    private String appBuild;
    private String appNamespace;
    private String appVersion;
    private String carrierCountry;
    private String carrierName;
    private String locale;
    private String model;
    private String oemName;
    private Integer osApiLevel;
    private String osBuild;
    private String osName;
    private String osVersion;
    private String screenSize;
    private String sdkName;
    private String sdkVersion;
    private Integer timeZoneOffset;

    public Device() {
    }

    public String getSdkName() {
        return this.sdkName;
    }

    public void setSdkName(String sdkName2) {
        String str = sdkName2;
        this.sdkName = str;
    }

    public String getSdkVersion() {
        return this.sdkVersion;
    }

    public void setSdkVersion(String sdkVersion2) {
        String str = sdkVersion2;
        this.sdkVersion = str;
    }

    public String getModel() {
        return this.model;
    }

    public void setModel(String model2) {
        String str = model2;
        this.model = str;
    }

    public String getOemName() {
        return this.oemName;
    }

    public void setOemName(String oemName2) {
        String str = oemName2;
        this.oemName = str;
    }

    public String getOsName() {
        return this.osName;
    }

    public void setOsName(String osName2) {
        String str = osName2;
        this.osName = str;
    }

    public String getOsVersion() {
        return this.osVersion;
    }

    public void setOsVersion(String osVersion2) {
        String str = osVersion2;
        this.osVersion = str;
    }

    public String getOsBuild() {
        return this.osBuild;
    }

    public void setOsBuild(String osBuild2) {
        String str = osBuild2;
        this.osBuild = str;
    }

    public Integer getOsApiLevel() {
        return this.osApiLevel;
    }

    public void setOsApiLevel(Integer osApiLevel2) {
        Integer num = osApiLevel2;
        this.osApiLevel = num;
    }

    public String getLocale() {
        return this.locale;
    }

    public void setLocale(String locale2) {
        String str = locale2;
        this.locale = str;
    }

    public Integer getTimeZoneOffset() {
        return this.timeZoneOffset;
    }

    public void setTimeZoneOffset(Integer timeZoneOffset2) {
        Integer num = timeZoneOffset2;
        this.timeZoneOffset = num;
    }

    public String getScreenSize() {
        return this.screenSize;
    }

    public void setScreenSize(String screenSize2) {
        String str = screenSize2;
        this.screenSize = str;
    }

    public String getAppVersion() {
        return this.appVersion;
    }

    public void setAppVersion(String appVersion2) {
        String str = appVersion2;
        this.appVersion = str;
    }

    public String getCarrierName() {
        return this.carrierName;
    }

    public void setCarrierName(String carrierName2) {
        String str = carrierName2;
        this.carrierName = str;
    }

    public String getCarrierCountry() {
        return this.carrierCountry;
    }

    public void setCarrierCountry(String carrierCountry2) {
        String str = carrierCountry2;
        this.carrierCountry = str;
    }

    public String getAppBuild() {
        return this.appBuild;
    }

    public void setAppBuild(String appBuild2) {
        String str = appBuild2;
        this.appBuild = str;
    }

    public String getAppNamespace() {
        return this.appNamespace;
    }

    public void setAppNamespace(String appNamespace2) {
        String str = appNamespace2;
        this.appNamespace = str;
    }

    public void read(JSONObject jSONObject) throws JSONException {
        JSONObject object = jSONObject;
        super.read(object);
        setSdkName(object.getString(SDK_NAME));
        setSdkVersion(object.getString(SDK_VERSION));
        setModel(object.getString(MODEL));
        setOemName(object.getString(OEM_NAME));
        setOsName(object.getString(OS_NAME));
        setOsVersion(object.getString(OS_VERSION));
        setOsBuild(object.optString(OS_BUILD, (String) null));
        setOsApiLevel(JSONUtils.readInteger(object, OS_API_LEVEL));
        setLocale(object.getString(LOCALE));
        setTimeZoneOffset(Integer.valueOf(object.getInt(TIME_ZONE_OFFSET)));
        setScreenSize(object.getString(SCREEN_SIZE));
        setAppVersion(object.getString(APP_VERSION));
        setCarrierName(object.optString(CARRIER_NAME, (String) null));
        setCarrierCountry(object.optString(CARRIER_COUNTRY, (String) null));
        setAppBuild(object.getString(APP_BUILD));
        setAppNamespace(object.optString(APP_NAMESPACE, (String) null));
    }

    public void write(JSONStringer jSONStringer) throws JSONException {
        JSONStringer writer = jSONStringer;
        super.write(writer);
        JSONStringer value = writer.key(SDK_NAME).value(getSdkName());
        JSONStringer value2 = writer.key(SDK_VERSION).value(getSdkVersion());
        JSONStringer value3 = writer.key(MODEL).value(getModel());
        JSONStringer value4 = writer.key(OEM_NAME).value(getOemName());
        JSONStringer value5 = writer.key(OS_NAME).value(getOsName());
        JSONStringer value6 = writer.key(OS_VERSION).value(getOsVersion());
        JSONUtils.write(writer, OS_BUILD, getOsBuild());
        JSONUtils.write(writer, OS_API_LEVEL, getOsApiLevel());
        JSONStringer value7 = writer.key(LOCALE).value(getLocale());
        JSONStringer value8 = writer.key(TIME_ZONE_OFFSET).value(getTimeZoneOffset());
        JSONStringer value9 = writer.key(SCREEN_SIZE).value(getScreenSize());
        JSONStringer value10 = writer.key(APP_VERSION).value(getAppVersion());
        JSONUtils.write(writer, CARRIER_NAME, getCarrierName());
        JSONUtils.write(writer, CARRIER_COUNTRY, getCarrierCountry());
        JSONStringer value11 = writer.key(APP_BUILD).value(getAppBuild());
        JSONUtils.write(writer, APP_NAMESPACE, getAppNamespace());
    }

    public boolean equals(Object obj) {
        Object o = obj;
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        Device device = (Device) o;
        if (this.sdkName == null ? device.sdkName != null : !this.sdkName.equals(device.sdkName)) {
            return false;
        }
        if (this.sdkVersion == null ? device.sdkVersion != null : !this.sdkVersion.equals(device.sdkVersion)) {
            return false;
        }
        if (this.model == null ? device.model != null : !this.model.equals(device.model)) {
            return false;
        }
        if (this.oemName == null ? device.oemName != null : !this.oemName.equals(device.oemName)) {
            return false;
        }
        if (this.osName == null ? device.osName != null : !this.osName.equals(device.osName)) {
            return false;
        }
        if (this.osVersion == null ? device.osVersion != null : !this.osVersion.equals(device.osVersion)) {
            return false;
        }
        if (this.osBuild == null ? device.osBuild != null : !this.osBuild.equals(device.osBuild)) {
            return false;
        }
        if (this.osApiLevel == null ? device.osApiLevel != null : !this.osApiLevel.equals(device.osApiLevel)) {
            return false;
        }
        if (this.locale == null ? device.locale != null : !this.locale.equals(device.locale)) {
            return false;
        }
        if (this.timeZoneOffset == null ? device.timeZoneOffset != null : !this.timeZoneOffset.equals(device.timeZoneOffset)) {
            return false;
        }
        if (this.screenSize == null ? device.screenSize != null : !this.screenSize.equals(device.screenSize)) {
            return false;
        }
        if (this.appVersion == null ? device.appVersion != null : !this.appVersion.equals(device.appVersion)) {
            return false;
        }
        if (this.carrierName == null ? device.carrierName != null : !this.carrierName.equals(device.carrierName)) {
            return false;
        }
        if (this.carrierCountry == null ? device.carrierCountry != null : !this.carrierCountry.equals(device.carrierCountry)) {
            return false;
        }
        if (this.appBuild == null ? device.appBuild != null : !this.appBuild.equals(device.appBuild)) {
            return false;
        }
        return this.appNamespace != null ? this.appNamespace.equals(device.appNamespace) : device.appNamespace == null;
    }

    public int hashCode() {
        return (31 * ((31 * ((31 * ((31 * ((31 * ((31 * ((31 * ((31 * ((31 * ((31 * ((31 * ((31 * ((31 * ((31 * ((31 * ((31 * super.hashCode()) + (this.sdkName != null ? this.sdkName.hashCode() : 0))) + (this.sdkVersion != null ? this.sdkVersion.hashCode() : 0))) + (this.model != null ? this.model.hashCode() : 0))) + (this.oemName != null ? this.oemName.hashCode() : 0))) + (this.osName != null ? this.osName.hashCode() : 0))) + (this.osVersion != null ? this.osVersion.hashCode() : 0))) + (this.osBuild != null ? this.osBuild.hashCode() : 0))) + (this.osApiLevel != null ? this.osApiLevel.hashCode() : 0))) + (this.locale != null ? this.locale.hashCode() : 0))) + (this.timeZoneOffset != null ? this.timeZoneOffset.hashCode() : 0))) + (this.screenSize != null ? this.screenSize.hashCode() : 0))) + (this.appVersion != null ? this.appVersion.hashCode() : 0))) + (this.carrierName != null ? this.carrierName.hashCode() : 0))) + (this.carrierCountry != null ? this.carrierCountry.hashCode() : 0))) + (this.appBuild != null ? this.appBuild.hashCode() : 0))) + (this.appNamespace != null ? this.appNamespace.hashCode() : 0);
    }
}
