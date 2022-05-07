package com.microsoft.appcenter.ingestion.models.one;

import com.microsoft.appcenter.ingestion.models.Model;
import com.microsoft.appcenter.ingestion.models.json.JSONUtils;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

public class SdkExtension implements Model {
    private static final String EPOCH = "epoch";
    private static final String INSTALL_ID = "installId";
    private static final String LIB_VER = "libVer";
    private static final String SEQ = "seq";
    private String epoch;
    private UUID installId;
    private String libVer;
    private Long seq;

    public SdkExtension() {
    }

    public String getLibVer() {
        return this.libVer;
    }

    public void setLibVer(String libVer2) {
        String str = libVer2;
        this.libVer = str;
    }

    public String getEpoch() {
        return this.epoch;
    }

    public void setEpoch(String epoch2) {
        String str = epoch2;
        this.epoch = str;
    }

    public Long getSeq() {
        return this.seq;
    }

    public void setSeq(Long seq2) {
        Long l = seq2;
        this.seq = l;
    }

    public UUID getInstallId() {
        return this.installId;
    }

    public void setInstallId(UUID installId2) {
        UUID uuid = installId2;
        this.installId = uuid;
    }

    public void read(JSONObject jSONObject) throws JSONException {
        JSONObject object = jSONObject;
        setLibVer(object.optString(LIB_VER, (String) null));
        setEpoch(object.optString(EPOCH, (String) null));
        setSeq(JSONUtils.readLong(object, SEQ));
        if (object.has("installId")) {
            setInstallId(UUID.fromString(object.getString("installId")));
        }
    }

    public void write(JSONStringer jSONStringer) throws JSONException {
        JSONStringer writer = jSONStringer;
        JSONUtils.write(writer, LIB_VER, getLibVer());
        JSONUtils.write(writer, EPOCH, getEpoch());
        JSONUtils.write(writer, SEQ, getSeq());
        JSONUtils.write(writer, "installId", getInstallId());
    }

    public boolean equals(Object obj) {
        Object o = obj;
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SdkExtension that = (SdkExtension) o;
        if (this.libVer == null ? that.libVer != null : !this.libVer.equals(that.libVer)) {
            return false;
        }
        if (this.epoch == null ? that.epoch != null : !this.epoch.equals(that.epoch)) {
            return false;
        }
        if (this.seq == null ? that.seq != null : !this.seq.equals(that.seq)) {
            return false;
        }
        return this.installId != null ? this.installId.equals(that.installId) : that.installId == null;
    }

    public int hashCode() {
        return (31 * ((31 * ((31 * (this.libVer != null ? this.libVer.hashCode() : 0)) + (this.epoch != null ? this.epoch.hashCode() : 0))) + (this.seq != null ? this.seq.hashCode() : 0))) + (this.installId != null ? this.installId.hashCode() : 0);
    }
}
