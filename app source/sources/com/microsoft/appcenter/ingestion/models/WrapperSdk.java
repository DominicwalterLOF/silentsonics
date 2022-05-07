package com.microsoft.appcenter.ingestion.models;

import com.microsoft.appcenter.ingestion.models.json.JSONUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

public class WrapperSdk implements Model {
    private static final String LIVE_UPDATE_DEPLOYMENT_KEY = "liveUpdateDeploymentKey";
    private static final String LIVE_UPDATE_PACKAGE_HASH = "liveUpdatePackageHash";
    private static final String LIVE_UPDATE_RELEASE_LABEL = "liveUpdateReleaseLabel";
    private static final String WRAPPER_RUNTIME_VERSION = "wrapperRuntimeVersion";
    private static final String WRAPPER_SDK_NAME = "wrapperSdkName";
    private static final String WRAPPER_SDK_VERSION = "wrapperSdkVersion";
    private String liveUpdateDeploymentKey;
    private String liveUpdatePackageHash;
    private String liveUpdateReleaseLabel;
    private String wrapperRuntimeVersion;
    private String wrapperSdkName;
    private String wrapperSdkVersion;

    public WrapperSdk() {
    }

    public String getWrapperSdkVersion() {
        return this.wrapperSdkVersion;
    }

    public void setWrapperSdkVersion(String wrapperSdkVersion2) {
        String str = wrapperSdkVersion2;
        this.wrapperSdkVersion = str;
    }

    public String getWrapperSdkName() {
        return this.wrapperSdkName;
    }

    public void setWrapperSdkName(String wrapperSdkName2) {
        String str = wrapperSdkName2;
        this.wrapperSdkName = str;
    }

    public String getWrapperRuntimeVersion() {
        return this.wrapperRuntimeVersion;
    }

    public void setWrapperRuntimeVersion(String wrapperRuntimeVersion2) {
        String str = wrapperRuntimeVersion2;
        this.wrapperRuntimeVersion = str;
    }

    public String getLiveUpdateReleaseLabel() {
        return this.liveUpdateReleaseLabel;
    }

    public void setLiveUpdateReleaseLabel(String liveUpdateReleaseLabel2) {
        String str = liveUpdateReleaseLabel2;
        this.liveUpdateReleaseLabel = str;
    }

    public String getLiveUpdateDeploymentKey() {
        return this.liveUpdateDeploymentKey;
    }

    public void setLiveUpdateDeploymentKey(String liveUpdateDeploymentKey2) {
        String str = liveUpdateDeploymentKey2;
        this.liveUpdateDeploymentKey = str;
    }

    public String getLiveUpdatePackageHash() {
        return this.liveUpdatePackageHash;
    }

    public void setLiveUpdatePackageHash(String liveUpdatePackageHash2) {
        String str = liveUpdatePackageHash2;
        this.liveUpdatePackageHash = str;
    }

    public void read(JSONObject jSONObject) throws JSONException {
        JSONObject object = jSONObject;
        setWrapperSdkVersion(object.optString(WRAPPER_SDK_VERSION, (String) null));
        setWrapperSdkName(object.optString(WRAPPER_SDK_NAME, (String) null));
        setWrapperRuntimeVersion(object.optString(WRAPPER_RUNTIME_VERSION, (String) null));
        setLiveUpdateReleaseLabel(object.optString(LIVE_UPDATE_RELEASE_LABEL, (String) null));
        setLiveUpdateDeploymentKey(object.optString(LIVE_UPDATE_DEPLOYMENT_KEY, (String) null));
        setLiveUpdatePackageHash(object.optString(LIVE_UPDATE_PACKAGE_HASH, (String) null));
    }

    public void write(JSONStringer jSONStringer) throws JSONException {
        JSONStringer writer = jSONStringer;
        JSONUtils.write(writer, WRAPPER_SDK_VERSION, getWrapperSdkVersion());
        JSONUtils.write(writer, WRAPPER_SDK_NAME, getWrapperSdkName());
        JSONUtils.write(writer, WRAPPER_RUNTIME_VERSION, getWrapperRuntimeVersion());
        JSONUtils.write(writer, LIVE_UPDATE_RELEASE_LABEL, getLiveUpdateReleaseLabel());
        JSONUtils.write(writer, LIVE_UPDATE_DEPLOYMENT_KEY, getLiveUpdateDeploymentKey());
        JSONUtils.write(writer, LIVE_UPDATE_PACKAGE_HASH, getLiveUpdatePackageHash());
    }

    public boolean equals(Object obj) {
        Object o = obj;
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        WrapperSdk that = (WrapperSdk) o;
        if (this.wrapperSdkVersion == null ? that.wrapperSdkVersion != null : !this.wrapperSdkVersion.equals(that.wrapperSdkVersion)) {
            return false;
        }
        if (this.wrapperSdkName == null ? that.wrapperSdkName != null : !this.wrapperSdkName.equals(that.wrapperSdkName)) {
            return false;
        }
        if (this.wrapperRuntimeVersion == null ? that.wrapperRuntimeVersion != null : !this.wrapperRuntimeVersion.equals(that.wrapperRuntimeVersion)) {
            return false;
        }
        if (this.liveUpdateReleaseLabel == null ? that.liveUpdateReleaseLabel != null : !this.liveUpdateReleaseLabel.equals(that.liveUpdateReleaseLabel)) {
            return false;
        }
        if (this.liveUpdateDeploymentKey == null ? that.liveUpdateDeploymentKey != null : !this.liveUpdateDeploymentKey.equals(that.liveUpdateDeploymentKey)) {
            return false;
        }
        return this.liveUpdatePackageHash != null ? this.liveUpdatePackageHash.equals(that.liveUpdatePackageHash) : that.liveUpdatePackageHash == null;
    }

    public int hashCode() {
        return (31 * ((31 * ((31 * ((31 * ((31 * (this.wrapperSdkVersion != null ? this.wrapperSdkVersion.hashCode() : 0)) + (this.wrapperSdkName != null ? this.wrapperSdkName.hashCode() : 0))) + (this.wrapperRuntimeVersion != null ? this.wrapperRuntimeVersion.hashCode() : 0))) + (this.liveUpdateReleaseLabel != null ? this.liveUpdateReleaseLabel.hashCode() : 0))) + (this.liveUpdateDeploymentKey != null ? this.liveUpdateDeploymentKey.hashCode() : 0))) + (this.liveUpdatePackageHash != null ? this.liveUpdatePackageHash.hashCode() : 0);
    }
}
