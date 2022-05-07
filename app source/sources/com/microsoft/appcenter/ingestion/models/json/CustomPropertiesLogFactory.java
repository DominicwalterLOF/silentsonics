package com.microsoft.appcenter.ingestion.models.json;

import com.microsoft.appcenter.ingestion.models.CustomPropertiesLog;
import com.microsoft.appcenter.ingestion.models.Log;

public class CustomPropertiesLogFactory extends AbstractLogFactory {
    public CustomPropertiesLogFactory() {
    }

    public Log create() {
        Log log;
        new CustomPropertiesLog();
        return log;
    }
}
