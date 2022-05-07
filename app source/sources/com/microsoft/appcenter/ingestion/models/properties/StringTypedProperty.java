package com.microsoft.appcenter.ingestion.models.properties;

import com.microsoft.appcenter.ingestion.models.CommonProperties;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

public class StringTypedProperty extends TypedProperty {
    public static final String TYPE = "string";
    private String value;

    public StringTypedProperty() {
    }

    public String getType() {
        return "string";
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String value2) {
        String str = value2;
        this.value = str;
    }

    public void read(JSONObject jSONObject) throws JSONException {
        JSONObject object = jSONObject;
        super.read(object);
        setValue(object.getString(CommonProperties.VALUE));
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
        StringTypedProperty that = (StringTypedProperty) o;
        return this.value != null ? this.value.equals(that.value) : that.value == null;
    }

    public int hashCode() {
        return (31 * super.hashCode()) + (this.value != null ? this.value.hashCode() : 0);
    }
}
