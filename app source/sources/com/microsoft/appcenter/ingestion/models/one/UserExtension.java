package com.microsoft.appcenter.ingestion.models.one;

import com.microsoft.appcenter.ingestion.models.Model;
import com.microsoft.appcenter.ingestion.models.json.JSONUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

public class UserExtension implements Model {
    private static final String LOCALE = "locale";
    private static final String LOCAL_ID = "localId";
    private String localId;
    private String locale;

    public UserExtension() {
    }

    public String getLocalId() {
        return this.localId;
    }

    public void setLocalId(String localId2) {
        String str = localId2;
        this.localId = str;
    }

    public String getLocale() {
        return this.locale;
    }

    public void setLocale(String locale2) {
        String str = locale2;
        this.locale = str;
    }

    public void read(JSONObject jSONObject) {
        JSONObject object = jSONObject;
        setLocalId(object.optString(LOCAL_ID, (String) null));
        setLocale(object.optString(LOCALE, (String) null));
    }

    public void write(JSONStringer jSONStringer) throws JSONException {
        JSONStringer writer = jSONStringer;
        JSONUtils.write(writer, LOCAL_ID, getLocalId());
        JSONUtils.write(writer, LOCALE, getLocale());
    }

    public boolean equals(Object obj) {
        Object o = obj;
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        UserExtension that = (UserExtension) o;
        if (this.localId == null ? that.localId != null : !this.localId.equals(that.localId)) {
            return false;
        }
        return this.locale != null ? this.locale.equals(that.locale) : that.locale == null;
    }

    public int hashCode() {
        return (31 * (this.localId != null ? this.localId.hashCode() : 0)) + (this.locale != null ? this.locale.hashCode() : 0);
    }
}
