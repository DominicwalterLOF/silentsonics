package com.microsoft.appcenter.analytics.ingestion.models.json;

import com.microsoft.appcenter.analytics.ingestion.models.EventLog;
import com.microsoft.appcenter.analytics.ingestion.models.one.CommonSchemaEventLog;
import com.microsoft.appcenter.ingestion.models.Log;
import com.microsoft.appcenter.ingestion.models.json.AbstractLogFactory;
import com.microsoft.appcenter.ingestion.models.one.CommonSchemaDataUtils;
import com.microsoft.appcenter.ingestion.models.one.CommonSchemaLog;
import com.microsoft.appcenter.ingestion.models.one.PartAUtils;
import java.util.Collection;
import java.util.LinkedList;

public class EventLogFactory extends AbstractLogFactory {
    public EventLogFactory() {
    }

    public EventLog create() {
        EventLog eventLog;
        new EventLog();
        return eventLog;
    }

    public Collection<CommonSchemaLog> toCommonSchemaLogs(Log log) {
        Collection<CommonSchemaLog> collection;
        CommonSchemaEventLog commonSchemaEventLog;
        Log log2 = log;
        new LinkedList();
        Collection<CommonSchemaLog> commonSchemaLogs = collection;
        for (String transmissionTarget : log2.getTransmissionTargetTokens()) {
            new CommonSchemaEventLog();
            CommonSchemaEventLog commonSchemaEventLog2 = commonSchemaEventLog;
            EventLog eventLog = (EventLog) log2;
            PartAUtils.setName(commonSchemaEventLog2, eventLog.getName());
            PartAUtils.addPartAFromLog(log2, commonSchemaEventLog2, transmissionTarget);
            CommonSchemaDataUtils.addCommonSchemaData(eventLog.getTypedProperties(), commonSchemaEventLog2);
            boolean add = commonSchemaLogs.add(commonSchemaEventLog2);
            commonSchemaEventLog2.setTag(log2.getTag());
        }
        return commonSchemaLogs;
    }
}
