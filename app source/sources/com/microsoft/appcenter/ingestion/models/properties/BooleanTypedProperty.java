package com.microsoft.appcenter.ingestion.models.properties;

import com.microsoft.appcenter.ingestion.models.CommonProperties;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

public class BooleanTypedProperty extends TypedProperty {
    public static final String TYPE = "boolean";
    private boolean value;

    public BooleanTypedProperty() {
    }

    public String getType() {
        return "boolean";
    }

    public boolean getValue() {
        return this.value;
    }

    public void setValue(boolean value2) {
        boolean z = value2;
        this.value = z;
    }

    public void read(JSONObject jSONObject) throws JSONException {
        JSONObject object = jSONObject;
        super.read(object);
        setValue(object.getBoolean(CommonProperties.VALUE));
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
        return this.value == ((BooleanTypedProperty) o).value;
    }

    public int hashCode() {
        return (31 * super.hashCode()) + (this.value ? 1 : 0);
    }
}
