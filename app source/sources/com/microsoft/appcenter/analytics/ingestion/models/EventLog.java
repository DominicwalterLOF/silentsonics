package com.microsoft.appcenter.analytics.ingestion.models;

import com.microsoft.appcenter.ingestion.models.CommonProperties;
import com.microsoft.appcenter.ingestion.models.json.JSONUtils;
import com.microsoft.appcenter.ingestion.models.properties.TypedProperty;
import com.microsoft.appcenter.ingestion.models.properties.TypedPropertyUtils;
import java.util.List;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

public class EventLog extends LogWithNameAndProperties {
    public static final String TYPE = "event";
    private UUID id;
    private List<TypedProperty> typedProperties;

    public EventLog() {
    }

    public String getType() {
        return "event";
    }

    public UUID getId() {
        return this.id;
    }

    public void setId(UUID id2) {
        UUID uuid = id2;
        this.id = uuid;
    }

    public List<TypedProperty> getTypedProperties() {
        return this.typedProperties;
    }

    public void setTypedProperties(List<TypedProperty> typedProperties2) {
        List<TypedProperty> list = typedProperties2;
        this.typedProperties = list;
    }

    public void read(JSONObject jSONObject) throws JSONException {
        JSONObject object = jSONObject;
        super.read(object);
        setId(UUID.fromString(object.getString(CommonProperties.ID)));
        setTypedProperties(TypedPropertyUtils.read(object));
    }

    public void write(JSONStringer jSONStringer) throws JSONException {
        JSONStringer writer = jSONStringer;
        super.write(writer);
        JSONStringer value = writer.key(CommonProperties.ID).value(getId());
        JSONUtils.writeArray(writer, CommonProperties.TYPED_PROPERTIES, getTypedProperties());
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
        EventLog eventLog = (EventLog) o;
        if (this.id == null ? eventLog.id != null : !this.id.equals(eventLog.id)) {
            return false;
        }
        return this.typedProperties != null ? this.typedProperties.equals(eventLog.typedProperties) : eventLog.typedProperties == null;
    }

    public int hashCode() {
        return (31 * ((31 * super.hashCode()) + (this.id != null ? this.id.hashCode() : 0))) + (this.typedProperties != null ? this.typedProperties.hashCode() : 0);
    }
}
