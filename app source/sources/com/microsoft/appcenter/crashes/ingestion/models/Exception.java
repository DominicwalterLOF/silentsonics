package com.microsoft.appcenter.crashes.ingestion.models;

import com.microsoft.appcenter.crashes.ingestion.models.json.ExceptionFactory;
import com.microsoft.appcenter.crashes.ingestion.models.json.StackFrameFactory;
import com.microsoft.appcenter.ingestion.models.CommonProperties;
import com.microsoft.appcenter.ingestion.models.Model;
import com.microsoft.appcenter.ingestion.models.json.JSONUtils;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

public class Exception implements Model {
    private static final String INNER_EXCEPTIONS = "innerExceptions";
    private static final String MESSAGE = "message";
    private static final String MINIDUMP_FILE_PATH = "minidumpFilePath";
    private static final String STACK_TRACE = "stackTrace";
    private static final String WRAPPER_SDK_NAME = "wrapperSdkName";
    private List<StackFrame> frames;
    private List<Exception> innerExceptions;
    private String message;
    private String minidumpFilePath;
    private String stackTrace;
    private String type;
    private String wrapperSdkName;

    public Exception() {
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type2) {
        String str = type2;
        this.type = str;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message2) {
        String str = message2;
        this.message = str;
    }

    public String getStackTrace() {
        return this.stackTrace;
    }

    public void setStackTrace(String stackTrace2) {
        String str = stackTrace2;
        this.stackTrace = str;
    }

    public List<StackFrame> getFrames() {
        return this.frames;
    }

    public void setFrames(List<StackFrame> frames2) {
        List<StackFrame> list = frames2;
        this.frames = list;
    }

    public List<Exception> getInnerExceptions() {
        return this.innerExceptions;
    }

    public void setInnerExceptions(List<Exception> innerExceptions2) {
        List<Exception> list = innerExceptions2;
        this.innerExceptions = list;
    }

    public String getWrapperSdkName() {
        return this.wrapperSdkName;
    }

    public void setWrapperSdkName(String wrapperSdkName2) {
        String str = wrapperSdkName2;
        this.wrapperSdkName = str;
    }

    public String getMinidumpFilePath() {
        return this.minidumpFilePath;
    }

    public void setMinidumpFilePath(String minidumpFilePath2) {
        String str = minidumpFilePath2;
        this.minidumpFilePath = str;
    }

    public void read(JSONObject jSONObject) throws JSONException {
        JSONObject object = jSONObject;
        setType(object.optString(CommonProperties.TYPE, (String) null));
        setMessage(object.optString(MESSAGE, (String) null));
        setStackTrace(object.optString(STACK_TRACE, (String) null));
        setFrames(JSONUtils.readArray(object, CommonProperties.FRAMES, StackFrameFactory.getInstance()));
        setInnerExceptions(JSONUtils.readArray(object, INNER_EXCEPTIONS, ExceptionFactory.getInstance()));
        setWrapperSdkName(object.optString(WRAPPER_SDK_NAME, (String) null));
        setMinidumpFilePath(object.optString(MINIDUMP_FILE_PATH, (String) null));
    }

    public void write(JSONStringer jSONStringer) throws JSONException {
        JSONStringer writer = jSONStringer;
        JSONUtils.write(writer, CommonProperties.TYPE, getType());
        JSONUtils.write(writer, MESSAGE, getMessage());
        JSONUtils.write(writer, STACK_TRACE, getStackTrace());
        JSONUtils.writeArray(writer, CommonProperties.FRAMES, getFrames());
        JSONUtils.writeArray(writer, INNER_EXCEPTIONS, getInnerExceptions());
        JSONUtils.write(writer, WRAPPER_SDK_NAME, getWrapperSdkName());
        JSONUtils.write(writer, MINIDUMP_FILE_PATH, getMinidumpFilePath());
    }

    public boolean equals(Object obj) {
        Object o = obj;
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Exception exception = (Exception) o;
        if (this.type == null ? exception.type != null : !this.type.equals(exception.type)) {
            return false;
        }
        if (this.message == null ? exception.message != null : !this.message.equals(exception.message)) {
            return false;
        }
        if (this.stackTrace == null ? exception.stackTrace != null : !this.stackTrace.equals(exception.stackTrace)) {
            return false;
        }
        if (this.frames == null ? exception.frames != null : !this.frames.equals(exception.frames)) {
            return false;
        }
        if (this.innerExceptions == null ? exception.innerExceptions != null : !this.innerExceptions.equals(exception.innerExceptions)) {
            return false;
        }
        if (this.wrapperSdkName == null ? exception.wrapperSdkName != null : !this.wrapperSdkName.equals(exception.wrapperSdkName)) {
            return false;
        }
        return this.minidumpFilePath != null ? this.minidumpFilePath.equals(exception.minidumpFilePath) : exception.minidumpFilePath == null;
    }

    public int hashCode() {
        return (31 * ((31 * ((31 * ((31 * ((31 * ((31 * (this.type != null ? this.type.hashCode() : 0)) + (this.message != null ? this.message.hashCode() : 0))) + (this.stackTrace != null ? this.stackTrace.hashCode() : 0))) + (this.frames != null ? this.frames.hashCode() : 0))) + (this.innerExceptions != null ? this.innerExceptions.hashCode() : 0))) + (this.wrapperSdkName != null ? this.wrapperSdkName.hashCode() : 0))) + (this.minidumpFilePath != null ? this.minidumpFilePath.hashCode() : 0);
    }
}
