package com.microsoft.appcenter.ingestion;

import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;
import com.microsoft.appcenter.http.HttpClient;
import com.microsoft.appcenter.http.HttpUtils;
import com.microsoft.appcenter.ingestion.models.Log;
import com.microsoft.appcenter.ingestion.models.LogContainer;
import com.microsoft.appcenter.ingestion.models.json.LogSerializer;
import com.microsoft.appcenter.utils.AppCenterLog;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;

public class OneCollectorIngestion implements Ingestion {
    @VisibleForTesting
    static final String API_KEY = "apikey";
    private static final String CLIENT_VERSION_FORMAT = "ACS-Android-Java-no-%s-no";
    @VisibleForTesting
    static final String CLIENT_VERSION_KEY = "Client-Version";
    private static final String CONTENT_TYPE_VALUE = "application/x-json-stream; charset=utf-8";
    private static final String DEFAULT_LOG_URL = "https://mobile.events.data.microsoft.com/OneCollector/1.0";
    @VisibleForTesting
    static final String STRICT = "Strict";
    @VisibleForTesting
    static final String TICKETS = "Tickets";
    @VisibleForTesting
    static final String UPLOAD_TIME_KEY = "Upload-Time";
    private final HttpClient mHttpClient;
    private final LogSerializer mLogSerializer;
    private String mLogUrl = DEFAULT_LOG_URL;

    public OneCollectorIngestion(@NonNull HttpClient httpClient, @NonNull LogSerializer logSerializer) {
        this.mLogSerializer = logSerializer;
        this.mHttpClient = httpClient;
    }

    /*  JADX ERROR: NullPointerException in pass: CodeShrinkVisitor
        java.lang.NullPointerException
        */
    public com.microsoft.appcenter.http.ServiceCall sendAsync(java.lang.String r27, java.util.UUID r28, com.microsoft.appcenter.ingestion.models.LogContainer r29, com.microsoft.appcenter.http.ServiceCallback r30) throws java.lang.IllegalArgumentException {
        /*
            r26 = this;
            r2 = r26
            r3 = r27
            r4 = r28
            r5 = r29
            r6 = r30
            java.util.HashMap r18 = new java.util.HashMap
            r25 = r18
            r18 = r25
            r19 = r25
            r19.<init>()
            r7 = r18
            java.util.LinkedHashSet r18 = new java.util.LinkedHashSet
            r25 = r18
            r18 = r25
            r19 = r25
            r19.<init>()
            r8 = r18
            r18 = r5
            java.util.List r18 = r18.getLogs()
            java.util.Iterator r18 = r18.iterator()
            r9 = r18
        L_0x0030:
            r18 = r9
            boolean r18 = r18.hasNext()
            if (r18 == 0) goto L_0x004f
            r18 = r9
            java.lang.Object r18 = r18.next()
            com.microsoft.appcenter.ingestion.models.Log r18 = (com.microsoft.appcenter.ingestion.models.Log) r18
            r10 = r18
            r18 = r8
            r19 = r10
            java.util.Set r19 = r19.getTransmissionTargetTokens()
            boolean r18 = r18.addAll(r19)
            goto L_0x0030
        L_0x004f:
            java.lang.StringBuilder r18 = new java.lang.StringBuilder
            r25 = r18
            r18 = r25
            r19 = r25
            r19.<init>()
            r9 = r18
            r18 = r8
            java.util.Iterator r18 = r18.iterator()
            r10 = r18
        L_0x0064:
            r18 = r10
            boolean r18 = r18.hasNext()
            if (r18 == 0) goto L_0x0086
            r18 = r10
            java.lang.Object r18 = r18.next()
            java.lang.String r18 = (java.lang.String) r18
            r11 = r18
            r18 = r9
            r19 = r11
            java.lang.StringBuilder r18 = r18.append(r19)
            java.lang.String r19 = ","
            java.lang.StringBuilder r18 = r18.append(r19)
            goto L_0x0064
        L_0x0086:
            r18 = r8
            boolean r18 = r18.isEmpty()
            if (r18 != 0) goto L_0x009e
            r18 = r9
            r19 = r9
            int r19 = r19.length()
            r20 = 1
            int r19 = r19 + -1
            java.lang.StringBuilder r18 = r18.deleteCharAt(r19)
        L_0x009e:
            r18 = r7
            java.lang.String r19 = "apikey"
            r20 = r9
            java.lang.String r20 = r20.toString()
            java.lang.Object r18 = r18.put(r19, r20)
            org.json.JSONObject r18 = new org.json.JSONObject
            r25 = r18
            r18 = r25
            r19 = r25
            r19.<init>()
            r10 = r18
            r18 = r5
            java.util.List r18 = r18.getLogs()
            java.util.Iterator r18 = r18.iterator()
            r11 = r18
        L_0x00c6:
            r18 = r11
            boolean r18 = r18.hasNext()
            if (r18 == 0) goto L_0x012e
            r18 = r11
            java.lang.Object r18 = r18.next()
            com.microsoft.appcenter.ingestion.models.Log r18 = (com.microsoft.appcenter.ingestion.models.Log) r18
            r12 = r18
            r18 = r12
            com.microsoft.appcenter.ingestion.models.one.CommonSchemaLog r18 = (com.microsoft.appcenter.ingestion.models.one.CommonSchemaLog) r18
            com.microsoft.appcenter.ingestion.models.one.Extensions r18 = r18.getExt()
            com.microsoft.appcenter.ingestion.models.one.ProtocolExtension r18 = r18.getProtocol()
            java.util.List r18 = r18.getTicketKeys()
            r13 = r18
            r18 = r13
            if (r18 == 0) goto L_0x012d
            r18 = r13
            java.util.Iterator r18 = r18.iterator()
            r14 = r18
        L_0x00f6:
            r18 = r14
            boolean r18 = r18.hasNext()
            if (r18 == 0) goto L_0x012d
            r18 = r14
            java.lang.Object r18 = r18.next()
            java.lang.String r18 = (java.lang.String) r18
            r15 = r18
            r18 = r15
            java.lang.String r18 = com.microsoft.appcenter.utils.TicketCache.getTicket(r18)
            r16 = r18
            r18 = r16
            if (r18 == 0) goto L_0x011e
            r18 = r10
            r19 = r15
            r20 = r16
            org.json.JSONObject r18 = r18.put(r19, r20)     // Catch:{ JSONException -> 0x011f }
        L_0x011e:
            goto L_0x00f6
        L_0x011f:
            r18 = move-exception
            r17 = r18
            java.lang.String r18 = "AppCenter"
            java.lang.String r19 = "Cannot serialize tickets, sending log anonymously"
            r20 = r17
            com.microsoft.appcenter.utils.AppCenterLog.error(r18, r19, r20)
        L_0x012d:
            goto L_0x00c6
        L_0x012e:
            r18 = r10
            int r18 = r18.length()
            if (r18 <= 0) goto L_0x0158
            r18 = r7
            java.lang.String r19 = "Tickets"
            r20 = r10
            java.lang.String r20 = r20.toString()
            java.lang.Object r18 = r18.put(r19, r20)
            boolean r18 = com.microsoft.appcenter.Constants.APPLICATION_DEBUGGABLE
            if (r18 == 0) goto L_0x0158
            r18 = r7
            java.lang.String r19 = "Strict"
            java.lang.Boolean r20 = java.lang.Boolean.TRUE
            java.lang.String r20 = r20.toString()
            java.lang.Object r18 = r18.put(r19, r20)
        L_0x0158:
            r18 = r7
            java.lang.String r19 = "Content-Type"
            java.lang.String r20 = "application/x-json-stream; charset=utf-8"
            java.lang.Object r18 = r18.put(r19, r20)
            java.lang.String r18 = "3.3.0"
            r11 = r18
            r18 = r7
            java.lang.String r19 = "Client-Version"
            java.lang.String r20 = "ACS-Android-Java-no-%s-no"
            r21 = 1
            r0 = r21
            java.lang.Object[] r0 = new java.lang.Object[r0]
            r21 = r0
            r25 = r21
            r21 = r25
            r22 = r25
            r23 = 0
            r24 = r11
            r22[r23] = r24
            java.lang.String r20 = java.lang.String.format(r20, r21)
            java.lang.Object r18 = r18.put(r19, r20)
            r18 = r7
            java.lang.String r19 = "Upload-Time"
            long r20 = java.lang.System.currentTimeMillis()
            java.lang.String r20 = java.lang.String.valueOf(r20)
            java.lang.Object r18 = r18.put(r19, r20)
            com.microsoft.appcenter.ingestion.OneCollectorIngestion$IngestionCallTemplate r18 = new com.microsoft.appcenter.ingestion.OneCollectorIngestion$IngestionCallTemplate
            r25 = r18
            r18 = r25
            r19 = r25
            r20 = r2
            r0 = r20
            com.microsoft.appcenter.ingestion.models.json.LogSerializer r0 = r0.mLogSerializer
            r20 = r0
            r21 = r5
            r19.<init>(r20, r21)
            r12 = r18
            r18 = r2
            r0 = r18
            com.microsoft.appcenter.http.HttpClient r0 = r0.mHttpClient
            r18 = r0
            r19 = r2
            r0 = r19
            java.lang.String r0 = r0.mLogUrl
            r19 = r0
            java.lang.String r20 = "POST"
            r21 = r7
            r22 = r12
            r23 = r6
            com.microsoft.appcenter.http.ServiceCall r18 = r18.callAsync(r19, r20, r21, r22, r23)
            r2 = r18
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microsoft.appcenter.ingestion.OneCollectorIngestion.sendAsync(java.lang.String, java.util.UUID, com.microsoft.appcenter.ingestion.models.LogContainer, com.microsoft.appcenter.http.ServiceCallback):com.microsoft.appcenter.http.ServiceCall");
    }

    public void setLogUrl(@NonNull String logUrl) {
        String str = logUrl;
        this.mLogUrl = str;
    }

    public void reopen() {
        this.mHttpClient.reopen();
    }

    public void close() throws IOException {
        this.mHttpClient.close();
    }

    private static class IngestionCallTemplate implements HttpClient.CallTemplate {
        private final LogContainer mLogContainer;
        private final LogSerializer mLogSerializer;

        IngestionCallTemplate(LogSerializer logSerializer, LogContainer logContainer) {
            this.mLogSerializer = logSerializer;
            this.mLogContainer = logContainer;
        }

        public String buildRequestBody() throws JSONException {
            StringBuilder sb;
            new StringBuilder();
            StringBuilder jsonStream = sb;
            for (Log log : this.mLogContainer.getLogs()) {
                StringBuilder append = jsonStream.append(this.mLogSerializer.serializeLog(log));
                StringBuilder append2 = jsonStream.append(10);
            }
            return jsonStream.toString();
        }

        public void onBeforeCalling(URL url, Map<String, String> map) {
            StringBuilder sb;
            Map<String, String> map2;
            StringBuilder sb2;
            URL url2 = url;
            Map<String, String> headers = map;
            if (AppCenterLog.getLogLevel() <= 2) {
                new StringBuilder();
                AppCenterLog.verbose("AppCenter", sb.append("Calling ").append(url2).append("...").toString());
                new HashMap<>(headers);
                Map<String, String> logHeaders = map2;
                String apiKeys = logHeaders.get(OneCollectorIngestion.API_KEY);
                if (apiKeys != null) {
                    String put = logHeaders.put(OneCollectorIngestion.API_KEY, HttpUtils.hideApiKeys(apiKeys));
                }
                String tickets = logHeaders.get(OneCollectorIngestion.TICKETS);
                if (tickets != null) {
                    String put2 = logHeaders.put(OneCollectorIngestion.TICKETS, HttpUtils.hideTickets(tickets));
                }
                new StringBuilder();
                AppCenterLog.verbose("AppCenter", sb2.append("Headers: ").append(logHeaders).toString());
            }
        }
    }
}
