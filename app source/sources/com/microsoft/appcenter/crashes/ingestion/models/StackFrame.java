package com.microsoft.appcenter.crashes.ingestion.models;

import com.microsoft.appcenter.ingestion.models.Model;
import com.microsoft.appcenter.ingestion.models.json.JSONUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

public class StackFrame implements Model {
    private static final String CLASS_NAME = "className";
    private static final String FILE_NAME = "fileName";
    private static final String LINE_NUMBER = "lineNumber";
    private static final String METHOD_NAME = "methodName";
    private String className;
    private String fileName;
    private Integer lineNumber;
    private String methodName;

    public StackFrame() {
    }

    public String getClassName() {
        return this.className;
    }

    public void setClassName(String className2) {
        String str = className2;
        this.className = str;
    }

    public String getMethodName() {
        return this.methodName;
    }

    public void setMethodName(String methodName2) {
        String str = methodName2;
        this.methodName = str;
    }

    public Integer getLineNumber() {
        return this.lineNumber;
    }

    public void setLineNumber(Integer lineNumber2) {
        Integer num = lineNumber2;
        this.lineNumber = num;
    }

    public String getFileName() {
        return this.fileName;
    }

    public void setFileName(String fileName2) {
        String str = fileName2;
        this.fileName = str;
    }

    public void read(JSONObject jSONObject) throws JSONException {
        JSONObject object = jSONObject;
        setClassName(object.optString(CLASS_NAME, (String) null));
        setMethodName(object.optString(METHOD_NAME, (String) null));
        setLineNumber(JSONUtils.readInteger(object, LINE_NUMBER));
        setFileName(object.optString(FILE_NAME, (String) null));
    }

    public void write(JSONStringer jSONStringer) throws JSONException {
        JSONStringer writer = jSONStringer;
        JSONUtils.write(writer, CLASS_NAME, getClassName());
        JSONUtils.write(writer, METHOD_NAME, getMethodName());
        JSONUtils.write(writer, LINE_NUMBER, getLineNumber());
        JSONUtils.write(writer, FILE_NAME, getFileName());
    }

    public boolean equals(Object obj) {
        Object o = obj;
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        StackFrame that = (StackFrame) o;
        if (this.className == null ? that.className != null : !this.className.equals(that.className)) {
            return false;
        }
        if (this.methodName == null ? that.methodName != null : !this.methodName.equals(that.methodName)) {
            return false;
        }
        if (this.lineNumber == null ? that.lineNumber != null : !this.lineNumber.equals(that.lineNumber)) {
            return false;
        }
        return this.fileName != null ? this.fileName.equals(that.fileName) : that.fileName == null;
    }

    public int hashCode() {
        return (31 * ((31 * ((31 * (this.className != null ? this.className.hashCode() : 0)) + (this.methodName != null ? this.methodName.hashCode() : 0))) + (this.lineNumber != null ? this.lineNumber.hashCode() : 0))) + (this.fileName != null ? this.fileName.hashCode() : 0);
    }
}
