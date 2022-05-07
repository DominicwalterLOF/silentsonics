package com.microsoft.appcenter.ingestion.models;

import android.support.annotation.VisibleForTesting;
import com.microsoft.appcenter.ingestion.models.json.JSONDateUtils;
import com.microsoft.appcenter.ingestion.models.json.JSONUtils;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

public abstract class AbstractLog implements Log {
    @VisibleForTesting
    static final String DEVICE = "device";
    private static final String DISTRIBUTION_GROUP_ID = "distributionGroupId";
    private static final String SID = "sid";
    private static final String TIMESTAMP = "timestamp";
    private static final String USER_ID = "userId";
    private Device device;
    private String distributionGroupId;
    private UUID sid;
    private Object tag;
    private Date timestamp;
    private final Set<String> transmissionTargetTokens;
    private String userId;

    public AbstractLog() {
        Set<String> set;
        new LinkedHashSet();
        this.transmissionTargetTokens = set;
    }

    public Date getTimestamp() {
        return this.timestamp;
    }

    public void setTimestamp(Date timestamp2) {
        Date date = timestamp2;
        this.timestamp = date;
    }

    public UUID getSid() {
        return this.sid;
    }

    public void setSid(UUID sid2) {
        UUID uuid = sid2;
        this.sid = uuid;
    }

    public String getDistributionGroupId() {
        return this.distributionGroupId;
    }

    public void setDistributionGroupId(String distributionGroupId2) {
        String str = distributionGroupId2;
        this.distributionGroupId = str;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String userId2) {
        String str = userId2;
        this.userId = str;
    }

    public Device getDevice() {
        return this.device;
    }

    public void setDevice(Device device2) {
        Device device3 = device2;
        this.device = device3;
    }

    public Object getTag() {
        return this.tag;
    }

    public void setTag(Object tag2) {
        Object obj = tag2;
        this.tag = obj;
    }

    public synchronized void addTransmissionTarget(String str) {
        String transmissionTargetToken = str;
        synchronized (this) {
            boolean add = this.transmissionTargetTokens.add(transmissionTargetToken);
        }
    }

    public synchronized Set<String> getTransmissionTargetTokens() {
        Set<String> unmodifiableSet;
        synchronized (this) {
            unmodifiableSet = Collections.unmodifiableSet(this.transmissionTargetTokens);
        }
        return unmodifiableSet;
    }

    public void write(JSONStringer jSONStringer) throws JSONException {
        JSONStringer writer = jSONStringer;
        JSONUtils.write(writer, CommonProperties.TYPE, getType());
        JSONStringer value = writer.key(TIMESTAMP).value(JSONDateUtils.toString(getTimestamp()));
        JSONUtils.write(writer, SID, getSid());
        JSONUtils.write(writer, DISTRIBUTION_GROUP_ID, getDistributionGroupId());
        JSONUtils.write(writer, USER_ID, getUserId());
        if (getDevice() != null) {
            JSONStringer object = writer.key(DEVICE).object();
            getDevice().write(writer);
            JSONStringer endObject = writer.endObject();
        }
    }

    public void read(JSONObject jSONObject) throws JSONException {
        Device device2;
        Throwable th;
        JSONObject object = jSONObject;
        if (!object.getString(CommonProperties.TYPE).equals(getType())) {
            Throwable th2 = th;
            new JSONException("Invalid type");
            throw th2;
        }
        setTimestamp(JSONDateUtils.toDate(object.getString(TIMESTAMP)));
        if (object.has(SID)) {
            setSid(UUID.fromString(object.getString(SID)));
        }
        setDistributionGroupId(object.optString(DISTRIBUTION_GROUP_ID, (String) null));
        setUserId(object.optString(USER_ID, (String) null));
        if (object.has(DEVICE)) {
            new Device();
            Device device3 = device2;
            device3.read(object.getJSONObject(DEVICE));
            setDevice(device3);
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
        AbstractLog that = (AbstractLog) o;
        if (!this.transmissionTargetTokens.equals(that.transmissionTargetTokens)) {
            return false;
        }
        if (this.timestamp == null ? that.timestamp != null : !this.timestamp.equals(that.timestamp)) {
            return false;
        }
        if (this.sid == null ? that.sid != null : !this.sid.equals(that.sid)) {
            return false;
        }
        if (this.distributionGroupId == null ? that.distributionGroupId != null : !this.distributionGroupId.equals(that.distributionGroupId)) {
            return false;
        }
        if (this.userId == null ? that.userId != null : !this.userId.equals(that.userId)) {
            return false;
        }
        if (this.device == null ? that.device != null : !this.device.equals(that.device)) {
            return false;
        }
        return this.tag != null ? this.tag.equals(that.tag) : that.tag == null;
    }

    public int hashCode() {
        return (31 * ((31 * ((31 * ((31 * ((31 * ((31 * this.transmissionTargetTokens.hashCode()) + (this.timestamp != null ? this.timestamp.hashCode() : 0))) + (this.sid != null ? this.sid.hashCode() : 0))) + (this.distributionGroupId != null ? this.distributionGroupId.hashCode() : 0))) + (this.userId != null ? this.userId.hashCode() : 0))) + (this.device != null ? this.device.hashCode() : 0))) + (this.tag != null ? this.tag.hashCode() : 0);
    }
}
