package com.microsoft.appcenter.crashes.ingestion.models.json;

import com.microsoft.appcenter.crashes.ingestion.models.ManagedErrorLog;
import com.microsoft.appcenter.ingestion.models.json.AbstractLogFactory;

public class ManagedErrorLogFactory extends AbstractLogFactory {
    private static final ManagedErrorLogFactory sInstance;

    static {
        ManagedErrorLogFactory managedErrorLogFactory;
        new ManagedErrorLogFactory();
        sInstance = managedErrorLogFactory;
    }

    private ManagedErrorLogFactory() {
    }

    public static ManagedErrorLogFactory getInstance() {
        return sInstance;
    }

    public ManagedErrorLog create() {
        ManagedErrorLog managedErrorLog;
        new ManagedErrorLog();
        return managedErrorLog;
    }
}
