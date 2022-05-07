package com.microsoft.appcenter.ingestion.models.one;

import com.microsoft.appcenter.ingestion.models.Model;
import com.microsoft.appcenter.ingestion.models.json.JSONUtils;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

public class ProtocolExtension implements Model {
    private static final String DEV_MAKE = "devMake";
    private static final String DEV_MODEL = "devModel";
    private static final String TICKET_KEYS = "ticketKeys";
    private String devMake;
    private String devModel;
    private List<String> ticketKeys;

    public ProtocolExtension() {
    }

    public List<String> getTicketKeys() {
        return this.ticketKeys;
    }

    public void setTicketKeys(List<String> ticketKeys2) {
        List<String> list = ticketKeys2;
        this.ticketKeys = list;
    }

    public String getDevMake() {
        return this.devMake;
    }

    public void setDevMake(String devMake2) {
        String str = devMake2;
        this.devMake = str;
    }

    public String getDevModel() {
        return this.devModel;
    }

    public void setDevModel(String devModel2) {
        String str = devModel2;
        this.devModel = str;
    }

    public void read(JSONObject jSONObject) throws JSONException {
        JSONObject object = jSONObject;
        setTicketKeys(JSONUtils.readStringArray(object, TICKET_KEYS));
        setDevMake(object.optString(DEV_MAKE, (String) null));
        setDevModel(object.optString(DEV_MODEL, (String) null));
    }

    public void write(JSONStringer jSONStringer) throws JSONException {
        JSONStringer writer = jSONStringer;
        JSONUtils.writeStringArray(writer, TICKET_KEYS, getTicketKeys());
        JSONUtils.write(writer, DEV_MAKE, getDevMake());
        JSONUtils.write(writer, DEV_MODEL, getDevModel());
    }

    public boolean equals(Object obj) {
        Object o = obj;
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ProtocolExtension that = (ProtocolExtension) o;
        if (this.ticketKeys == null ? that.ticketKeys != null : !this.ticketKeys.equals(that.ticketKeys)) {
            return false;
        }
        if (this.devMake == null ? that.devMake != null : !this.devMake.equals(that.devMake)) {
            return false;
        }
        return this.devModel != null ? this.devModel.equals(that.devModel) : that.devModel == null;
    }

    public int hashCode() {
        return (31 * ((31 * (this.ticketKeys != null ? this.ticketKeys.hashCode() : 0)) + (this.devMake != null ? this.devMake.hashCode() : 0))) + (this.devModel != null ? this.devModel.hashCode() : 0);
    }
}
