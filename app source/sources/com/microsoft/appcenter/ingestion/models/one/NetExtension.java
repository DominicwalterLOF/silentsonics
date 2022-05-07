package com.microsoft.appcenter.ingestion.models.one;

import com.microsoft.appcenter.ingestion.models.Model;
import com.microsoft.appcenter.ingestion.models.json.JSONUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

public class NetExtension implements Model {
    private static final String PROVIDER = "provider";
    private String provider;

    public NetExtension() {
    }

    public String getProvider() {
        return this.provider;
    }

    public void setProvider(String provider2) {
        String str = provider2;
        this.provider = str;
    }

    public void read(JSONObject object) {
        setProvider(object.optString(PROVIDER, (String) null));
    }

    public void write(JSONStringer writer) throws JSONException {
        JSONUtils.write(writer, PROVIDER, getProvider());
    }

    public boolean equals(Object obj) {
        Object o = obj;
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        NetExtension that = (NetExtension) o;
        return this.provider != null ? this.provider.equals(that.provider) : that.provider == null;
    }

    public int hashCode() {
        return this.provider != null ? this.provider.hashCode() : 0;
    }
}
