package com.microsoft.appcenter.ingestion.models.properties;

import com.microsoft.appcenter.ingestion.models.CommonProperties;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

public class LongTypedProperty extends TypedProperty {
    public static final String TYPE = "long";
    private long value;

    public LongTypedProperty() {
    }

    public String getType() {
        return TYPE;
    }

    public long getValue() {
        return this.value;
    }

    public void setValue(long value2) {
        long j = value2;
        this.value = j;
    }

    public void read(JSONObject jSONObject) throws JSONException {
        JSONObject object = jSONObject;
        super.read(object);
        setValue(object.getLong(CommonProperties.VALUE));
    }

    public void write(JSONStringer jSONStringer) throws JSONException {
        JSONStringer writer = jSONStringer;
        super.write(writer);
        JSONStringer value2 = writer.key(CommonProperties.VALUE).value(getValue());
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
        return this.value == ((LongTypedProperty) o).value;
    }

    public int hashCode() {
        return (31 * super.hashCode()) + ((int) (this.value ^ (this.value >>> 32)));
    }
}
