package com.microsoft.appcenter.ingestion;

import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;
import com.microsoft.appcenter.Constants;
import com.microsoft.appcenter.http.AbstractAppCallTemplate;
import com.microsoft.appcenter.http.HttpClient;
import com.microsoft.appcenter.http.ServiceCall;
import com.microsoft.appcenter.http.ServiceCallback;
import com.microsoft.appcenter.ingestion.models.LogContainer;
import com.microsoft.appcenter.ingestion.models.json.LogSerializer;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.json.JSONException;

public class AppCenterIngestion implements Ingestion {
    @VisibleForTesting
    static final String API_PATH = "/logs?api-version=1.0.0";
    public static final String DEFAULT_LOG_URL = "https://in.appcenter.ms";
    @VisibleForTesting
    static final String INSTALL_ID = "Install-ID";
    private final HttpClient mHttpClient;
    private final LogSerializer mLogSerializer;
    private String mLogUrl = DEFAULT_LOG_URL;

    public AppCenterIngestion(@NonNull HttpClient httpClient, @NonNull LogSerializer logSerializer) {
        this.mLogSerializer = logSerializer;
        this.mHttpClient = httpClient;
    }

    public void setLogUrl(@NonNull String logUrl) {
        String str = logUrl;
        this.mLogUrl = str;
    }

    public ServiceCall sendAsync(String appSecret, UUID installId, LogContainer logContainer, ServiceCallback serviceCallback) throws IllegalArgumentException {
        Map<String, String> map;
        HttpClient.CallTemplate callTemplate;
        StringBuilder sb;
        new HashMap<>();
        Map<String, String> headers = map;
        String put = headers.put(INSTALL_ID, installId.toString());
        String put2 = headers.put(Constants.APP_SECRET, appSecret);
        new IngestionCallTemplate(this.mLogSerializer, logContainer);
        HttpClient.CallTemplate callTemplate2 = callTemplate;
        HttpClient httpClient = this.mHttpClient;
        new StringBuilder();
        return httpClient.callAsync(sb.append(this.mLogUrl).append(API_PATH).toString(), "POST", headers, callTemplate2, serviceCallback);
    }

    public void close() throws IOException {
        this.mHttpClient.close();
    }

    public void reopen() {
        this.mHttpClient.reopen();
    }

    private static class IngestionCallTemplate extends AbstractAppCallTemplate {
        private final LogContainer mLogContainer;
        private final LogSerializer mLogSerializer;

        IngestionCallTemplate(LogSerializer logSerializer, LogContainer logContainer) {
            this.mLogSerializer = logSerializer;
            this.mLogContainer = logContainer;
        }

        public String buildRequestBody() throws JSONException {
            return this.mLogSerializer.serializeContainer(this.mLogContainer);
        }
    }
}
