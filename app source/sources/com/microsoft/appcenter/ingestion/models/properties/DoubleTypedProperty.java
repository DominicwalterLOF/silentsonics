package com.microsoft.appcenter.ingestion.models.properties;

import com.microsoft.appcenter.ingestion.models.CommonProperties;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

public class DoubleTypedProperty extends TypedProperty {
    public static final String TYPE = "double";
    private double value;

    public DoubleTypedProperty() {
    }

    public String getType() {
        return TYPE;
    }

    public double getValue() {
        return this.value;
    }

    public void setValue(double value2) {
        double d = value2;
        this.value = d;
    }

    public void read(JSONObject jSONObject) throws JSONException {
        JSONObject object = jSONObject;
        super.read(object);
        setValue(object.getDouble(CommonProperties.VALUE));
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
        return Double.compare(((DoubleTypedProperty) o).value, this.value) == 0;
    }

    public int hashCode() {
        int result = super.hashCode();
        long temp = Double.doubleToLongBits(this.value);
        return (31 * result) + ((int) (temp ^ (temp >>> 32)));
    }
}
