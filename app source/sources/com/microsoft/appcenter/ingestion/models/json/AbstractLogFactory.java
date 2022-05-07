package com.microsoft.appcenter.ingestion.models.json;

import com.microsoft.appcenter.ingestion.models.Log;
import com.microsoft.appcenter.ingestion.models.one.CommonSchemaLog;
import java.util.Collection;
import java.util.Collections;

public abstract class AbstractLogFactory implements LogFactory {
    public AbstractLogFactory() {
    }

    public Collection<CommonSchemaLog> toCommonSchemaLogs(Log log) {
        Log log2 = log;
        return Collections.emptyList();
    }
}
