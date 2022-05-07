package com.microsoft.appcenter.ingestion.models.one;

import com.microsoft.appcenter.ingestion.models.Model;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

public class MetadataExtension implements Model {
    private JSONObject mMetadata;

    public MetadataExtension() {
        JSONObject jSONObject;
        new JSONObject();
        this.mMetadata = jSONObject;
    }

    public JSONObject getMetadata() {
        return this.mMetadata;
    }

    public void read(JSONObject object) {
        JSONObject jSONObject = object;
        this.mMetadata = jSONObject;
    }

    public void write(JSONStringer jSONStringer) throws JSONException {
        JSONStringer writer = jSONStringer;
        Iterator<String> iterator = this.mMetadata.keys();
        while (iterator.hasNext()) {
            String key = iterator.next();
            JSONStringer value = writer.key(key).value(this.mMetadata.get(key));
        }
    }

    public boolean equals(Object obj) {
        Object o = obj;
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        return this.mMetadata.toString().equals(((MetadataExtension) o).mMetadata.toString());
    }

    public int hashCode() {
        return this.mMetadata.toString().hashCode();
    }
}
