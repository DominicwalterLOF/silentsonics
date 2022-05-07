package com.microsoft.appcenter.crashes.ingestion.models.json;

import com.microsoft.appcenter.crashes.ingestion.models.HandledErrorLog;
import com.microsoft.appcenter.ingestion.models.json.AbstractLogFactory;

public class HandledErrorLogFactory extends AbstractLogFactory {
    private static final HandledErrorLogFactory sInstance;

    static {
        HandledErrorLogFactory handledErrorLogFactory;
        new HandledErrorLogFactory();
        sInstance = handledErrorLogFactory;
    }

    private HandledErrorLogFactory() {
    }

    public static HandledErrorLogFactory getInstance() {
        return sInstance;
    }

    public HandledErrorLog create() {
        HandledErrorLog handledErrorLog;
        new HandledErrorLog();
        return handledErrorLog;
    }
}
