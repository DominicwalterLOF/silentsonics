package com.microsoft.appcenter.ingestion.models.one;

import com.microsoft.appcenter.ingestion.models.AbstractLog;
import com.microsoft.appcenter.ingestion.models.json.JSONDateUtils;
import com.microsoft.appcenter.ingestion.models.json.JSONUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

public abstract class CommonSchemaLog extends AbstractLog {
    private static final String CV = "cV";
    private static final String DATA = "data";
    private static final String EXT = "ext";
    private static final String FLAGS = "flags";
    private static final String IKEY = "iKey";
    private static final String NAME = "name";
    private static final String POP_SAMPLE = "popSample";
    private static final String TIME = "time";
    private static final String VER = "ver";
    private String cV;
    private Data data;
    private Extensions ext;
    private Long flags;
    private String iKey;
    private String name;
    private Double popSample;
    private String ver;

    public CommonSchemaLog() {
    }

    public String getVer() {
        return this.ver;
    }

    public void setVer(String ver2) {
        String str = ver2;
        this.ver = str;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name2) {
        String str = name2;
        this.name = str;
    }

    public Double getPopSample() {
        return this.popSample;
    }

    public void setPopSample(Double popSample2) {
        Double d = popSample2;
        this.popSample = d;
    }

    public String getIKey() {
        return this.iKey;
    }

    public void setIKey(String iKey2) {
        String str = iKey2;
        this.iKey = str;
    }

    public Long getFlags() {
        return this.flags;
    }

    public void setFlags(Long flags2) {
        Long l = flags2;
        this.flags = l;
    }

    public String getCV() {
        return this.cV;
    }

    public void setCV(String cV2) {
        String str = cV2;
        this.cV = str;
    }

    public Extensions getExt() {
        return this.ext;
    }

    public void setExt(Extensions ext2) {
        Extensions extensions = ext2;
        this.ext = extensions;
    }

    public Data getData() {
        return this.data;
    }

    public void setData(Data data2) {
        Data data3 = data2;
        this.data = data3;
    }

    public void read(JSONObject jSONObject) throws JSONException {
        Data data2;
        Extensions extensions;
        JSONObject object = jSONObject;
        setVer(object.getString(VER));
        setName(object.getString("name"));
        setTimestamp(JSONDateUtils.toDate(object.getString(TIME)));
        if (object.has(POP_SAMPLE)) {
            setPopSample(Double.valueOf(object.getDouble(POP_SAMPLE)));
        }
        setIKey(object.optString(IKEY, (String) null));
        setFlags(JSONUtils.readLong(object, FLAGS));
        setCV(object.optString(CV, (String) null));
        if (object.has(EXT)) {
            new Extensions();
            Extensions extensions2 = extensions;
            extensions2.read(object.getJSONObject(EXT));
            setExt(extensions2);
        }
        if (object.has(DATA)) {
            new Data();
            Data data3 = data2;
            data3.read(object.getJSONObject(DATA));
            setData(data3);
        }
    }

    public void write(JSONStringer jSONStringer) throws JSONException {
        JSONStringer writer = jSONStringer;
        JSONStringer value = writer.key(VER).value(getVer());
        JSONStringer value2 = writer.key("name").value(getName());
        JSONStringer value3 = writer.key(TIME).value(JSONDateUtils.toString(getTimestamp()));
        JSONUtils.write(writer, POP_SAMPLE, getPopSample());
        JSONUtils.write(writer, IKEY, getIKey());
        JSONUtils.write(writer, FLAGS, getFlags());
        JSONUtils.write(writer, CV, getCV());
        if (getExt() != null) {
            JSONStringer object = writer.key(EXT).object();
            getExt().write(writer);
            JSONStringer endObject = writer.endObject();
        }
        if (getData() != null) {
            JSONStringer object2 = writer.key(DATA).object();
            getData().write(writer);
            JSONStringer endObject2 = writer.endObject();
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
        if (!super.equals(o)) {
            return false;
        }
        CommonSchemaLog that = (CommonSchemaLog) o;
        if (this.ver == null ? that.ver != null : !this.ver.equals(that.ver)) {
            return false;
        }
        if (this.name == null ? that.name != null : !this.name.equals(that.name)) {
            return false;
        }
        if (this.popSample == null ? that.popSample != null : !this.popSample.equals(that.popSample)) {
            return false;
        }
        if (this.iKey == null ? that.iKey != null : !this.iKey.equals(that.iKey)) {
            return false;
        }
        if (this.flags == null ? that.flags != null : !this.flags.equals(that.flags)) {
            return false;
        }
        if (this.cV == null ? that.cV != null : !this.cV.equals(that.cV)) {
            return false;
        }
        if (this.ext == null ? that.ext != null : !this.ext.equals(that.ext)) {
            return false;
        }
        return this.data != null ? this.data.equals(that.data) : that.data == null;
    }

    public int hashCode() {
        return (31 * ((31 * ((31 * ((31 * ((31 * ((31 * ((31 * ((31 * super.hashCode()) + (this.ver != null ? this.ver.hashCode() : 0))) + (this.name != null ? this.name.hashCode() : 0))) + (this.popSample != null ? this.popSample.hashCode() : 0))) + (this.iKey != null ? this.iKey.hashCode() : 0))) + (this.flags != null ? this.flags.hashCode() : 0))) + (this.cV != null ? this.cV.hashCode() : 0))) + (this.ext != null ? this.ext.hashCode() : 0))) + (this.data != null ? this.data.hashCode() : 0);
    }
}
