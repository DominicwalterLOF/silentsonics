package com.microsoft.appcenter.analytics.ingestion.models;

import com.microsoft.appcenter.ingestion.models.CommonProperties;
import com.microsoft.appcenter.ingestion.models.LogWithProperties;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

public abstract class LogWithNameAndProperties extends LogWithProperties {
    private String name;

    public LogWithNameAndProperties() {
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name2) {
        String str = name2;
        this.name = str;
    }

    public void read(JSONObject jSONObject) throws JSONException {
        JSONObject object = jSONObject;
        super.read(object);
        setName(object.getString(CommonProperties.NAME));
    }

    public void write(JSONStringer jSONStringer) throws JSONException {
        JSONStringer writer = jSONStringer;
        super.write(writer);
        JSONStringer value = writer.key(CommonProperties.NAME).value(getName());
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
        LogWithNameAndProperties logWithNameAndProperties = (LogWithNameAndProperties) o;
        return this.name != null ? this.name.equals(logWithNameAndProperties.name) : logWithNameAndProperties.name == null;
    }

    public int hashCode() {
        return (31 * super.hashCode()) + (this.name != null ? this.name.hashCode() : 0);
    }
}
