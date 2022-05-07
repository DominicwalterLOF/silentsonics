package com.microsoft.appcenter.analytics.ingestion.models.json;

import com.microsoft.appcenter.analytics.ingestion.models.PageLog;
import com.microsoft.appcenter.ingestion.models.json.AbstractLogFactory;

public class PageLogFactory extends AbstractLogFactory {
    public PageLogFactory() {
    }

    public PageLog create() {
        PageLog pageLog;
        new PageLog();
        return pageLog;
    }
}
