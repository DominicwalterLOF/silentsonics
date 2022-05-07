package com.microsoft.appcenter.ingestion.models.json;

import android.support.annotation.NonNull;
import com.microsoft.appcenter.ingestion.models.CommonProperties;
import com.microsoft.appcenter.ingestion.models.Log;
import com.microsoft.appcenter.ingestion.models.LogContainer;
import com.microsoft.appcenter.ingestion.models.one.CommonSchemaLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

public class DefaultLogSerializer implements LogSerializer {
    private static final String LOGS = "logs";
    private final Map<String, LogFactory> mLogFactories;

    public DefaultLogSerializer() {
        Map<String, LogFactory> map;
        new HashMap();
        this.mLogFactories = map;
    }

    @NonNull
    private JSONStringer writeLog(JSONStringer jSONStringer, Log log) throws JSONException {
        JSONStringer writer = jSONStringer;
        JSONStringer object = writer.object();
        log.write(writer);
        JSONStringer endObject = writer.endObject();
        return writer;
    }

    @NonNull
    private Log readLog(JSONObject jSONObject, String str) throws JSONException {
        Throwable th;
        StringBuilder sb;
        JSONObject object = jSONObject;
        String type = str;
        if (type == null) {
            type = object.getString(CommonProperties.TYPE);
        }
        LogFactory logFactory = this.mLogFactories.get(type);
        if (logFactory == null) {
            Throwable th2 = th;
            new StringBuilder();
            new JSONException(sb.append("Unknown log type: ").append(type).toString());
            throw th2;
        }
        Log log = logFactory.create();
        log.read(object);
        return log;
    }

    @NonNull
    public String serializeLog(@NonNull Log log) throws JSONException {
        JSONStringer jSONStringer;
        new JSONStringer();
        return writeLog(jSONStringer, log).toString();
    }

    @NonNull
    public Log deserializeLog(@NonNull String json, String type) throws JSONException {
        JSONObject jSONObject;
        new JSONObject(json);
        return readLog(jSONObject, type);
    }

    public Collection<CommonSchemaLog> toCommonSchemaLog(@NonNull Log log) {
        Log log2 = log;
        return this.mLogFactories.get(log2.getType()).toCommonSchemaLogs(log2);
    }

    @NonNull
    public String serializeContainer(@NonNull LogContainer logContainer) throws JSONException {
        JSONStringer jSONStringer;
        new JSONStringer();
        JSONStringer writer = jSONStringer;
        JSONStringer object = writer.object();
        JSONStringer array = writer.key(LOGS).array();
        for (Log log : logContainer.getLogs()) {
            JSONStringer writeLog = writeLog(writer, log);
        }
        JSONStringer endArray = writer.endArray();
        JSONStringer endObject = writer.endObject();
        return writer.toString();
    }

    @NonNull
    public LogContainer deserializeContainer(@NonNull String json, String str) throws JSONException {
        JSONObject jContainer;
        LogContainer logContainer;
        List<Log> list;
        String type = str;
        new JSONObject(json);
        new LogContainer();
        LogContainer container = logContainer;
        JSONArray jLogs = jContainer.getJSONArray(LOGS);
        new ArrayList<>();
        List<Log> logs = list;
        for (int i = 0; i < jLogs.length(); i++) {
            boolean add = logs.add(readLog(jLogs.getJSONObject(i), type));
        }
        container.setLogs(logs);
        return container;
    }

    public void addLogFactory(@NonNull String logType, @NonNull LogFactory logFactory) {
        LogFactory put = this.mLogFactories.put(logType, logFactory);
    }
}
