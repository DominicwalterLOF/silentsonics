package com.microsoft.appcenter.ingestion.models.one;

import com.microsoft.appcenter.ingestion.models.Model;
import com.microsoft.appcenter.ingestion.models.json.JSONUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

public class AppExtension implements Model {
    private static final String ID = "id";
    private static final String LOCALE = "locale";
    private static final String NAME = "name";
    private static final String USER_ID = "userId";
    private static final String VER = "ver";
    private String id;
    private String locale;
    private String name;
    private String userId;
    private String ver;

    public AppExtension() {
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id2) {
        String str = id2;
        this.id = str;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name2) {
        String str = name2;
        this.name = str;
    }

    public String getVer() {
        return this.ver;
    }

    public void setVer(String ver2) {
        String str = ver2;
        this.ver = str;
    }

    public String getLocale() {
        return this.locale;
    }

    public void setLocale(String locale2) {
        String str = locale2;
        this.locale = str;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String userId2) {
        String str = userId2;
        this.userId = str;
    }

    public void read(JSONObject jSONObject) {
        JSONObject object = jSONObject;
        setId(object.optString("id", (String) null));
        setVer(object.optString(VER, (String) null));
        setName(object.optString("name", (String) null));
        setLocale(object.optString(LOCALE, (String) null));
        setUserId(object.optString(USER_ID, (String) null));
    }

    public void write(JSONStringer jSONStringer) throws JSONException {
        JSONStringer writer = jSONStringer;
        JSONUtils.write(writer, "id", getId());
        JSONUtils.write(writer, VER, getVer());
        JSONUtils.write(writer, "name", getName());
        JSONUtils.write(writer, LOCALE, getLocale());
        JSONUtils.write(writer, USER_ID, getUserId());
    }

    public boolean equals(Object obj) {
        Object o = obj;
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AppExtension that = (AppExtension) o;
        if (this.id == null ? that.id != null : !this.id.equals(that.id)) {
            return false;
        }
        if (this.ver == null ? that.ver != null : !this.ver.equals(that.ver)) {
            return false;
        }
        if (this.name == null ? that.name != null : !this.name.equals(that.name)) {
            return false;
        }
        if (this.locale == null ? that.locale != null : !this.locale.equals(that.locale)) {
            return false;
        }
        return this.userId != null ? this.userId.equals(that.userId) : that.userId == null;
    }

    public int hashCode() {
        return (31 * ((31 * ((31 * ((31 * (this.id != null ? this.id.hashCode() : 0)) + (this.ver != null ? this.ver.hashCode() : 0))) + (this.name != null ? this.name.hashCode() : 0))) + (this.locale != null ? this.locale.hashCode() : 0))) + (this.userId != null ? this.userId.hashCode() : 0);
    }
}
