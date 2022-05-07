package com.microsoft.appcenter.ingestion.models.one;

import com.microsoft.appcenter.ingestion.models.Model;
import com.microsoft.appcenter.ingestion.models.json.JSONUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

public class OsExtension implements Model {
    private static final String NAME = "name";
    private static final String VER = "ver";
    private String name;
    private String ver;

    public OsExtension() {
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

    public void read(JSONObject jSONObject) {
        JSONObject object = jSONObject;
        setName(object.optString("name", (String) null));
        setVer(object.optString(VER, (String) null));
    }

    public void write(JSONStringer jSONStringer) throws JSONException {
        JSONStringer writer = jSONStringer;
        JSONUtils.write(writer, "name", getName());
        JSONUtils.write(writer, VER, getVer());
    }

    public boolean equals(Object obj) {
        Object o = obj;
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        OsExtension that = (OsExtension) o;
        if (this.name == null ? that.name != null : !this.name.equals(that.name)) {
            return false;
        }
        return this.ver != null ? this.ver.equals(that.ver) : that.ver == null;
    }

    public int hashCode() {
        return (31 * (this.name != null ? this.name.hashCode() : 0)) + (this.ver != null ? this.ver.hashCode() : 0);
    }
}
