package com.microsoft.appcenter.crashes.ingestion.models;

import com.microsoft.appcenter.crashes.ingestion.models.json.StackFrameFactory;
import com.microsoft.appcenter.ingestion.models.CommonProperties;
import com.microsoft.appcenter.ingestion.models.Model;
import com.microsoft.appcenter.ingestion.models.json.JSONUtils;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

public class Thread implements Model {
    private List<StackFrame> frames;
    private long id;
    private String name;

    public Thread() {
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id2) {
        long j = id2;
        this.id = j;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name2) {
        String str = name2;
        this.name = str;
    }

    public List<StackFrame> getFrames() {
        return this.frames;
    }

    public void setFrames(List<StackFrame> frames2) {
        List<StackFrame> list = frames2;
        this.frames = list;
    }

    public void read(JSONObject jSONObject) throws JSONException {
        JSONObject object = jSONObject;
        setId(object.getLong(CommonProperties.ID));
        setName(object.optString(CommonProperties.NAME, (String) null));
        setFrames(JSONUtils.readArray(object, CommonProperties.FRAMES, StackFrameFactory.getInstance()));
    }

    public void write(JSONStringer jSONStringer) throws JSONException {
        JSONStringer writer = jSONStringer;
        JSONUtils.write(writer, CommonProperties.ID, Long.valueOf(getId()));
        JSONUtils.write(writer, CommonProperties.NAME, getName());
        JSONUtils.writeArray(writer, CommonProperties.FRAMES, getFrames());
    }

    public boolean equals(Object obj) {
        Object o = obj;
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Thread that = (Thread) o;
        if (this.id != that.id) {
            return false;
        }
        if (this.name == null ? that.name != null : !this.name.equals(that.name)) {
            return false;
        }
        return this.frames != null ? this.frames.equals(that.frames) : that.frames == null;
    }

    public int hashCode() {
        return (31 * ((31 * ((int) (this.id ^ (this.id >>> 32)))) + (this.name != null ? this.name.hashCode() : 0))) + (this.frames != null ? this.frames.hashCode() : 0);
    }
}
