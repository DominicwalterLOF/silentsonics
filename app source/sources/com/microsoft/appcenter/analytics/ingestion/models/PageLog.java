package com.microsoft.appcenter.analytics.ingestion.models;

public class PageLog extends LogWithNameAndProperties {
    public static final String TYPE = "page";

    public PageLog() {
    }

    public String getType() {
        return TYPE;
    }
}
