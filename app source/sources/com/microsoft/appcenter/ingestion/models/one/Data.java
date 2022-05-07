package com.microsoft.appcenter.ingestion.models.one;

import com.microsoft.appcenter.ingestion.models.Model;
import com.microsoft.appcenter.ingestion.models.json.JSONUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

public class Data implements Model {
    static final String BASE_DATA = "baseData";
    static final String BASE_TYPE = "baseType";
    private final JSONObject mProperties;

    public Data() {
        JSONObject jSONObject;
        new JSONObject();
        this.mProperties = jSONObject;
    }

    public JSONObject getProperties() {
        return this.mProperties;
    }

    public void read(JSONObject jSONObject) throws JSONException {
        JSONObject object = jSONObject;
        JSONArray names = object.names();
        if (names != null) {
            for (int i = 0; i < names.length(); i++) {
                String name = names.getString(i);
                JSONObject put = this.mProperties.put(name, object.get(name));
            }
        }
    }

    public void write(JSONStringer jSONStringer) throws JSONException {
        JSONStringer writer = jSONStringer;
        JSONUtils.write(writer, BASE_TYPE, this.mProperties.optString(BASE_TYPE, (String) null));
        JSONUtils.write(writer, BASE_DATA, this.mProperties.optJSONObject(BASE_DATA));
        JSONArray names = this.mProperties.names();
        if (names != null) {
            for (int i = 0; i < names.length(); i++) {
                String name = names.getString(i);
                if (!name.equals(BASE_TYPE) && !name.equals(BASE_DATA)) {
                    JSONStringer value = writer.key(name).value(this.mProperties.get(name));
                }
            }
        }
    }

    public boolean equals(Object obj) {
        Object o = obj;
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        return this.mProperties.toString().equals(((Data) o).mProperties.toString());
    }

    public int hashCode() {
        return this.mProperties.toString().hashCode();
    }
}
