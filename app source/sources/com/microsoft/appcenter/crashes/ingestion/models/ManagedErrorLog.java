package com.microsoft.appcenter.crashes.ingestion.models;

import com.microsoft.appcenter.crashes.ingestion.models.json.ThreadFactory;
import com.microsoft.appcenter.ingestion.models.json.JSONUtils;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

public class ManagedErrorLog extends AbstractErrorLog {
    private static final String EXCEPTION = "exception";
    private static final String THREADS = "threads";
    public static final String TYPE = "managedError";
    private Exception exception;
    private List<Thread> threads;

    public ManagedErrorLog() {
    }

    public String getType() {
        return TYPE;
    }

    public Exception getException() {
        return this.exception;
    }

    public void setException(Exception exception2) {
        Exception exception3 = exception2;
        this.exception = exception3;
    }

    public List<Thread> getThreads() {
        return this.threads;
    }

    public void setThreads(List<Thread> threads2) {
        List<Thread> list = threads2;
        this.threads = list;
    }

    public void read(JSONObject jSONObject) throws JSONException {
        Exception exception2;
        JSONObject object = jSONObject;
        super.read(object);
        if (object.has(EXCEPTION)) {
            JSONObject jException = object.getJSONObject(EXCEPTION);
            new Exception();
            Exception exception3 = exception2;
            exception3.read(jException);
            setException(exception3);
        }
        setThreads(JSONUtils.readArray(object, THREADS, ThreadFactory.getInstance()));
    }

    public void write(JSONStringer jSONStringer) throws JSONException {
        JSONStringer writer = jSONStringer;
        super.write(writer);
        if (getException() != null) {
            JSONStringer object = writer.key(EXCEPTION).object();
            this.exception.write(writer);
            JSONStringer endObject = writer.endObject();
        }
        JSONUtils.writeArray(writer, THREADS, getThreads());
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
        ManagedErrorLog that = (ManagedErrorLog) o;
        if (this.exception == null ? that.exception != null : !this.exception.equals(that.exception)) {
            return false;
        }
        return this.threads != null ? this.threads.equals(that.threads) : that.threads == null;
    }

    public int hashCode() {
        return (31 * ((31 * super.hashCode()) + (this.exception != null ? this.exception.hashCode() : 0))) + (this.threads != null ? this.threads.hashCode() : 0);
    }
}
