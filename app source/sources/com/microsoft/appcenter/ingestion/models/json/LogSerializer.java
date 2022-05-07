package com.microsoft.appcenter.ingestion.models.json;

import android.support.annotation.NonNull;
import com.microsoft.appcenter.ingestion.models.Log;
import com.microsoft.appcenter.ingestion.models.LogContainer;
import com.microsoft.appcenter.ingestion.models.one.CommonSchemaLog;
import java.util.Collection;
import org.json.JSONException;

public interface LogSerializer {
    void addLogFactory(@NonNull String str, @NonNull LogFactory logFactory);

    @NonNull
    LogContainer deserializeContainer(@NonNull String str, String str2) throws JSONException;

    @NonNull
    Log deserializeLog(@NonNull String str, String str2) throws JSONException;

    @NonNull
    String serializeContainer(@NonNull LogContainer logContainer) throws JSONException;

    @NonNull
    String serializeLog(@NonNull Log log) throws JSONException;

    Collection<CommonSchemaLog> toCommonSchemaLog(@NonNull Log log);
}
