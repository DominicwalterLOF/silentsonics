package org.slf4j.event;

import org.slf4j.Marker;
import org.slf4j.helpers.SubstituteLogger;

public class SubstituteLoggingEvent implements LoggingEvent {
    Object[] argArray;
    Level level;
    SubstituteLogger logger;
    String loggerName;
    Marker marker;
    String message;
    String threadName;
    Throwable throwable;
    long timeStamp;

    public SubstituteLoggingEvent() {
    }

    public Level getLevel() {
        return this.level;
    }

    public void setLevel(Level level2) {
        Level level3 = level2;
        this.level = level3;
    }

    public Marker getMarker() {
        return this.marker;
    }

    public void setMarker(Marker marker2) {
        Marker marker3 = marker2;
        this.marker = marker3;
    }

    public String getLoggerName() {
        return this.loggerName;
    }

    public void setLoggerName(String loggerName2) {
        String str = loggerName2;
        this.loggerName = str;
    }

    public SubstituteLogger getLogger() {
        return this.logger;
    }

    public void setLogger(SubstituteLogger logger2) {
        SubstituteLogger substituteLogger = logger2;
        this.logger = substituteLogger;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message2) {
        String str = message2;
        this.message = str;
    }

    public Object[] getArgumentArray() {
        return this.argArray;
    }

    public void setArgumentArray(Object[] argArray2) {
        Object[] objArr = argArray2;
        this.argArray = objArr;
    }

    public long getTimeStamp() {
        return this.timeStamp;
    }

    public void setTimeStamp(long timeStamp2) {
        long j = timeStamp2;
        this.timeStamp = j;
    }

    public String getThreadName() {
        return this.threadName;
    }

    public void setThreadName(String threadName2) {
        String str = threadName2;
        this.threadName = str;
    }

    public Throwable getThrowable() {
        return this.throwable;
    }

    public void setThrowable(Throwable throwable2) {
        Throwable th = throwable2;
        this.throwable = th;
    }
}
