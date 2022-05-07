package com.microsoft.appcenter.ingestion.models.properties;

import com.microsoft.appcenter.ingestion.models.CommonProperties;
import com.microsoft.appcenter.ingestion.models.json.JSONDateUtils;
import java.util.Date;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

public class DateTimeTypedProperty extends TypedProperty {
    public static final String TYPE = "dateTime";
    private Date value;

    public DateTimeTypedProperty() {
    }

    public String getType() {
        return TYPE;
    }

    public Date getValue() {
        return this.value;
    }

    public void setValue(Date value2) {
        Date date = value2;
        this.value = date;
    }

    public void read(JSONObject jSONObject) throws JSONException {
        JSONObject object = jSONObject;
        super.read(object);
        setValue(JSONDateUtils.toDate(object.getString(CommonProperties.VALUE)));
    }

    public void write(JSONStringer jSONStringer) throws JSONException {
        JSONStringer writer = jSONStringer;
        super.write(writer);
        JSONStringer value2 = writer.key(CommonProperties.VALUE).value(JSONDateUtils.toString(getValue()));
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
        DateTimeTypedProperty that = (DateTimeTypedProperty) o;
        return this.value != null ? this.value.equals(that.value) : that.value == null;
    }

    public int hashCode() {
        return (31 * super.hashCode()) + (this.value != null ? this.value.hashCode() : 0);
    }
}
