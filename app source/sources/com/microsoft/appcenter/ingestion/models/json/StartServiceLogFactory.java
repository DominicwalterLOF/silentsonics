package com.microsoft.appcenter.ingestion.models.json;

import com.microsoft.appcenter.ingestion.models.Log;
import com.microsoft.appcenter.ingestion.models.StartServiceLog;

public class StartServiceLogFactory extends AbstractLogFactory {
    public StartServiceLogFactory() {
    }

    public Log create() {
        Log log;
        new StartServiceLog();
        return log;
    }
}
