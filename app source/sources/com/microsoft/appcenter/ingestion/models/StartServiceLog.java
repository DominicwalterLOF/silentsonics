package com.microsoft.appcenter.ingestion.models;

import com.microsoft.appcenter.ingestion.models.json.JSONUtils;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

public class StartServiceLog extends AbstractLog {
    private static final String SERVICES = "services";
    public static final String TYPE = "startService";
    private List<String> services;

    public StartServiceLog() {
    }

    public String getType() {
        return TYPE;
    }

    public List<String> getServices() {
        return this.services;
    }

    public void setServices(List<String> services2) {
        List<String> list = services2;
        this.services = list;
    }

    public void read(JSONObject jSONObject) throws JSONException {
        JSONObject object = jSONObject;
        super.read(object);
        setServices(JSONUtils.readStringArray(object, "services"));
    }

    public void write(JSONStringer jSONStringer) throws JSONException {
        JSONStringer writer = jSONStringer;
        super.write(writer);
        JSONUtils.writeStringArray(writer, "services", getServices());
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
        StartServiceLog that = (StartServiceLog) o;
        return this.services != null ? this.services.equals(that.services) : that.services == null;
    }

    public int hashCode() {
        return (31 * super.hashCode()) + (this.services != null ? this.services.hashCode() : 0);
    }
}
