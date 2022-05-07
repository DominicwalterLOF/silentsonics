package com.microsoft.appcenter.ingestion.models;

import java.util.List;

public class LogContainer {
    private List<Log> logs;

    public LogContainer() {
    }

    public List<Log> getLogs() {
        return this.logs;
    }

    public void setLogs(List<Log> logs2) {
        List<Log> list = logs2;
        this.logs = list;
    }

    public boolean equals(Object obj) {
        Object o = obj;
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LogContainer container = (LogContainer) o;
        return this.logs != null ? this.logs.equals(container.logs) : container.logs == null;
    }

    public int hashCode() {
        return this.logs != null ? this.logs.hashCode() : 0;
    }
}
