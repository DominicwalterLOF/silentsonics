package com.microsoft.appcenter.crashes.ingestion.models;

import com.microsoft.appcenter.ingestion.models.AbstractLog;
import com.microsoft.appcenter.ingestion.models.CommonProperties;
import com.microsoft.appcenter.ingestion.models.json.JSONDateUtils;
import com.microsoft.appcenter.ingestion.models.json.JSONUtils;
import java.util.Date;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

public abstract class AbstractErrorLog extends AbstractLog {
    private static final String APP_LAUNCH_TIMESTAMP = "appLaunchTimestamp";
    private static final String ARCHITECTURE = "architecture";
    private static final String ERROR_THREAD_ID = "errorThreadId";
    private static final String ERROR_THREAD_NAME = "errorThreadName";
    private static final String FATAL = "fatal";
    private static final String PARENT_PROCESS_ID = "parentProcessId";
    private static final String PARENT_PROCESS_NAME = "parentProcessName";
    private static final String PROCESS_ID = "processId";
    private static final String PROCESS_NAME = "processName";
    private Date appLaunchTimestamp;
    private String architecture;
    private Long errorThreadId;
    private String errorThreadName;
    private Boolean fatal;
    private UUID id;
    private Integer parentProcessId;
    private String parentProcessName;
    private Integer processId;
    private String processName;

    public AbstractErrorLog() {
    }

    public UUID getId() {
        return this.id;
    }

    public void setId(UUID id2) {
        UUID uuid = id2;
        this.id = uuid;
    }

    public Integer getProcessId() {
        return this.processId;
    }

    public void setProcessId(Integer processId2) {
        Integer num = processId2;
        this.processId = num;
    }

    public String getProcessName() {
        return this.processName;
    }

    public void setProcessName(String processName2) {
        String str = processName2;
        this.processName = str;
    }

    public Integer getParentProcessId() {
        return this.parentProcessId;
    }

    public void setParentProcessId(Integer parentProcessId2) {
        Integer num = parentProcessId2;
        this.parentProcessId = num;
    }

    public String getParentProcessName() {
        return this.parentProcessName;
    }

    public void setParentProcessName(String parentProcessName2) {
        String str = parentProcessName2;
        this.parentProcessName = str;
    }

    public Long getErrorThreadId() {
        return this.errorThreadId;
    }

    public void setErrorThreadId(Long errorThreadId2) {
        Long l = errorThreadId2;
        this.errorThreadId = l;
    }

    public String getErrorThreadName() {
        return this.errorThreadName;
    }

    public void setErrorThreadName(String errorThreadName2) {
        String str = errorThreadName2;
        this.errorThreadName = str;
    }

    public Boolean getFatal() {
        return this.fatal;
    }

    public void setFatal(Boolean fatal2) {
        Boolean bool = fatal2;
        this.fatal = bool;
    }

    public Date getAppLaunchTimestamp() {
        return this.appLaunchTimestamp;
    }

    public void setAppLaunchTimestamp(Date appLaunchTimestamp2) {
        Date date = appLaunchTimestamp2;
        this.appLaunchTimestamp = date;
    }

    public String getArchitecture() {
        return this.architecture;
    }

    public void setArchitecture(String architecture2) {
        String str = architecture2;
        this.architecture = str;
    }

    public void read(JSONObject jSONObject) throws JSONException {
        JSONObject object = jSONObject;
        super.read(object);
        setId(UUID.fromString(object.getString(CommonProperties.ID)));
        setProcessId(JSONUtils.readInteger(object, PROCESS_ID));
        setProcessName(object.optString(PROCESS_NAME, (String) null));
        setParentProcessId(JSONUtils.readInteger(object, PARENT_PROCESS_ID));
        setParentProcessName(object.optString(PARENT_PROCESS_NAME, (String) null));
        setErrorThreadId(JSONUtils.readLong(object, ERROR_THREAD_ID));
        setErrorThreadName(object.optString(ERROR_THREAD_NAME, (String) null));
        setFatal(JSONUtils.readBoolean(object, FATAL));
        setAppLaunchTimestamp(JSONDateUtils.toDate(object.getString(APP_LAUNCH_TIMESTAMP)));
        setArchitecture(object.optString(ARCHITECTURE, (String) null));
    }

    public void write(JSONStringer jSONStringer) throws JSONException {
        JSONStringer writer = jSONStringer;
        super.write(writer);
        JSONUtils.write(writer, CommonProperties.ID, getId());
        JSONUtils.write(writer, PROCESS_ID, getProcessId());
        JSONUtils.write(writer, PROCESS_NAME, getProcessName());
        JSONUtils.write(writer, PARENT_PROCESS_ID, getParentProcessId());
        JSONUtils.write(writer, PARENT_PROCESS_NAME, getParentProcessName());
        JSONUtils.write(writer, ERROR_THREAD_ID, getErrorThreadId());
        JSONUtils.write(writer, ERROR_THREAD_NAME, getErrorThreadName());
        JSONUtils.write(writer, FATAL, getFatal());
        JSONUtils.write(writer, APP_LAUNCH_TIMESTAMP, JSONDateUtils.toString(getAppLaunchTimestamp()));
        JSONUtils.write(writer, ARCHITECTURE, getArchitecture());
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
        AbstractErrorLog that = (AbstractErrorLog) o;
        if (this.id == null ? that.id != null : !this.id.equals(that.id)) {
            return false;
        }
        if (this.processId == null ? that.processId != null : !this.processId.equals(that.processId)) {
            return false;
        }
        if (this.processName == null ? that.processName != null : !this.processName.equals(that.processName)) {
            return false;
        }
        if (this.parentProcessId == null ? that.parentProcessId != null : !this.parentProcessId.equals(that.parentProcessId)) {
            return false;
        }
        if (this.parentProcessName == null ? that.parentProcessName != null : !this.parentProcessName.equals(that.parentProcessName)) {
            return false;
        }
        if (this.errorThreadId == null ? that.errorThreadId != null : !this.errorThreadId.equals(that.errorThreadId)) {
            return false;
        }
        if (this.errorThreadName == null ? that.errorThreadName != null : !this.errorThreadName.equals(that.errorThreadName)) {
            return false;
        }
        if (this.fatal == null ? that.fatal != null : !this.fatal.equals(that.fatal)) {
            return false;
        }
        if (this.appLaunchTimestamp == null ? that.appLaunchTimestamp != null : !this.appLaunchTimestamp.equals(that.appLaunchTimestamp)) {
            return false;
        }
        return this.architecture != null ? this.architecture.equals(that.architecture) : that.architecture == null;
    }

    public int hashCode() {
        return (31 * ((31 * ((31 * ((31 * ((31 * ((31 * ((31 * ((31 * ((31 * ((31 * super.hashCode()) + (this.id != null ? this.id.hashCode() : 0))) + (this.processId != null ? this.processId.hashCode() : 0))) + (this.processName != null ? this.processName.hashCode() : 0))) + (this.parentProcessId != null ? this.parentProcessId.hashCode() : 0))) + (this.parentProcessName != null ? this.parentProcessName.hashCode() : 0))) + (this.errorThreadId != null ? this.errorThreadId.hashCode() : 0))) + (this.errorThreadName != null ? this.errorThreadName.hashCode() : 0))) + (this.fatal != null ? this.fatal.hashCode() : 0))) + (this.appLaunchTimestamp != null ? this.appLaunchTimestamp.hashCode() : 0))) + (this.architecture != null ? this.architecture.hashCode() : 0);
    }
}
