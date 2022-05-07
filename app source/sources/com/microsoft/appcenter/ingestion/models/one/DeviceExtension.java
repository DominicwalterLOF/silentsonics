package com.microsoft.appcenter.ingestion.models.one;

import com.microsoft.appcenter.ingestion.models.Model;
import com.microsoft.appcenter.ingestion.models.json.JSONUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

public class DeviceExtension implements Model {
    private static final String LOCAL_ID = "localId";
    private String localId;

    public DeviceExtension() {
    }

    public String getLocalId() {
        return this.localId;
    }

    public void setLocalId(String localId2) {
        String str = localId2;
        this.localId = str;
    }

    public void read(JSONObject object) {
        setLocalId(object.optString(LOCAL_ID, (String) null));
    }

    public void write(JSONStringer writer) throws JSONException {
        JSONUtils.write(writer, LOCAL_ID, getLocalId());
    }

    public boolean equals(Object obj) {
        Object o = obj;
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        DeviceExtension that = (DeviceExtension) o;
        return this.localId != null ? this.localId.equals(that.localId) : that.localId == null;
    }

    public int hashCode() {
        return this.localId != null ? this.localId.hashCode() : 0;
    }
}
