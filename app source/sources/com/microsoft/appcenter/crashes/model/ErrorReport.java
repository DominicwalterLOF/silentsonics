package com.microsoft.appcenter.crashes.model;

import com.microsoft.appcenter.ingestion.models.Device;
import java.util.Date;

public class ErrorReport {
    private Date appErrorTime;
    private Date appStartTime;
    private Device device;
    private String id;
    private String stackTrace;
    private String threadName;

    public ErrorReport() {
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id2) {
        String str = id2;
        this.id = str;
    }

    public String getThreadName() {
        return this.threadName;
    }

    public void setThreadName(String threadName2) {
        String str = threadName2;
        this.threadName = str;
    }

    public String getStackTrace() {
        return this.stackTrace;
    }

    public void setStackTrace(String stackTrace2) {
        String str = stackTrace2;
        this.stackTrace = str;
    }

    @Deprecated
    public Throwable getThrowable() {
        return null;
    }

    public Date getAppStartTime() {
        return this.appStartTime;
    }

    public void setAppStartTime(Date appStartTime2) {
        Date date = appStartTime2;
        this.appStartTime = date;
    }

    public Date getAppErrorTime() {
        return this.appErrorTime;
    }

    public void setAppErrorTime(Date appErrorTime2) {
        Date date = appErrorTime2;
        this.appErrorTime = date;
    }

    public Device getDevice() {
        return this.device;
    }

    public void setDevice(Device device2) {
        Device device3 = device2;
        this.device = device3;
    }
}
