package com.microsoft.appcenter.ingestion.models;

import com.microsoft.appcenter.ingestion.models.json.JSONUtils;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

public abstract class LogWithProperties extends AbstractLog {
    private static final String PROPERTIES = "properties";
    private Map<String, String> properties;

    public LogWithProperties() {
    }

    public Map<String, String> getProperties() {
        return this.properties;
    }

    public void setProperties(Map<String, String> properties2) {
        Map<String, String> map = properties2;
        this.properties = map;
    }

    public void read(JSONObject jSONObject) throws JSONException {
        JSONObject object = jSONObject;
        super.read(object);
        setProperties(JSONUtils.readMap(object, PROPERTIES));
    }

    public void write(JSONStringer jSONStringer) throws JSONException {
        JSONStringer writer = jSONStringer;
        super.write(writer);
        JSONUtils.writeMap(writer, PROPERTIES, getProperties());
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
        LogWithProperties that = (LogWithProperties) o;
        return this.properties != null ? this.properties.equals(that.properties) : that.properties == null;
    }

    public int hashCode() {
        return (31 * super.hashCode()) + (this.properties != null ? this.properties.hashCode() : 0);
    }
}
