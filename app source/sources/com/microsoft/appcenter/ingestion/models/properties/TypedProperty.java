package com.microsoft.appcenter.ingestion.models.properties;

import com.microsoft.appcenter.ingestion.models.CommonProperties;
import com.microsoft.appcenter.ingestion.models.Model;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

public abstract class TypedProperty implements Model {
    private String name;

    public abstract String getType();

    public TypedProperty() {
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name2) {
        String str = name2;
        this.name = str;
    }

    public void read(JSONObject jSONObject) throws JSONException {
        Throwable th;
        JSONObject object = jSONObject;
        if (!object.getString(CommonProperties.TYPE).equals(getType())) {
            Throwable th2 = th;
            new JSONException("Invalid type");
            throw th2;
        }
        setName(object.getString(CommonProperties.NAME));
    }

    public void write(JSONStringer jSONStringer) throws JSONException {
        JSONStringer writer = jSONStringer;
        JSONStringer value = writer.key(CommonProperties.TYPE).value(getType());
        JSONStringer value2 = writer.key(CommonProperties.NAME).value(getName());
    }

    public boolean equals(Object obj) {
        Object o = obj;
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TypedProperty that = (TypedProperty) o;
        return this.name != null ? this.name.equals(that.name) : that.name == null;
    }

    public int hashCode() {
        return this.name != null ? this.name.hashCode() : 0;
    }
}
