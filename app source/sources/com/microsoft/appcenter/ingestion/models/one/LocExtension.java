package com.microsoft.appcenter.ingestion.models.one;

import com.microsoft.appcenter.ingestion.models.Model;
import com.microsoft.appcenter.ingestion.models.json.JSONUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

public class LocExtension implements Model {
    private static final String TZ = "tz";
    private String tz;

    public LocExtension() {
    }

    public String getTz() {
        return this.tz;
    }

    public void setTz(String tz2) {
        String str = tz2;
        this.tz = str;
    }

    public void read(JSONObject object) {
        setTz(object.optString(TZ, (String) null));
    }

    public void write(JSONStringer writer) throws JSONException {
        JSONUtils.write(writer, TZ, getTz());
    }

    public boolean equals(Object obj) {
        Object o = obj;
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LocExtension that = (LocExtension) o;
        return this.tz != null ? this.tz.equals(that.tz) : that.tz == null;
    }

    public int hashCode() {
        return this.tz != null ? this.tz.hashCode() : 0;
    }
}
