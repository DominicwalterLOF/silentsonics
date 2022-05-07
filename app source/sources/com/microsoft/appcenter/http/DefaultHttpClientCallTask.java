package com.microsoft.appcenter.http;

import android.net.TrafficStats;
import android.os.AsyncTask;
import com.microsoft.appcenter.http.HttpClient;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.util.Map;
import java.util.regex.Pattern;
import javax.net.ssl.HttpsURLConnection;

class DefaultHttpClientCallTask extends AsyncTask<Void, Void, Object> {
    private static final int DEFAULT_STRING_BUILDER_CAPACITY = 16;
    private static final int MAX_PRETTIFY_LOG_LENGTH = 4096;
    private static final int MIN_GZIP_LENGTH = 1400;
    private static final Pattern REDIRECT_URI_REGEX_JSON = Pattern.compile("redirect_uri\":\"[^\"]+\"");
    private static final Pattern TOKEN_REGEX_JSON = Pattern.compile("token\":\"[^\"]+\"");
    private static final Pattern TOKEN_REGEX_URL_ENCODED = Pattern.compile("token=[^&]+");
    private final HttpClient.CallTemplate mCallTemplate;
    private final boolean mCompressionEnabled;
    private final Map<String, String> mHeaders;
    private final String mMethod;
    private final ServiceCallback mServiceCallback;
    private final Tracker mTracker;
    private final String mUrl;

    interface Tracker {
        void onFinish(DefaultHttpClientCallTask defaultHttpClientCallTask);

        void onStart(DefaultHttpClientCallTask defaultHttpClientCallTask);
    }

    DefaultHttpClientCallTask(String url, String method, Map<String, String> headers, HttpClient.CallTemplate callTemplate, ServiceCallback serviceCallback, Tracker tracker, boolean compressionEnabled) {
        this.mUrl = url;
        this.mMethod = method;
        this.mHeaders = headers;
        this.mCallTemplate = callTemplate;
        this.mServiceCallback = serviceCallback;
        this.mTracker = tracker;
        this.mCompressionEnabled = compressionEnabled;
    }

    private static InputStream getInputStream(HttpsURLConnection httpsURLConnection) throws IOException {
        HttpsURLConnection httpsURLConnection2 = httpsURLConnection;
        int status = httpsURLConnection2.getResponseCode();
        if (status < 200 || status >= 400) {
            return httpsURLConnection2.getErrorStream();
        }
        return httpsURLConnection2.getInputStream();
    }

    private void writePayload(OutputStream outputStream, byte[] bArr) throws IOException {
        OutputStream out = outputStream;
        byte[] payload = bArr;
        int i = 0;
        while (i < payload.length) {
            out.write(payload, i, Math.min(payload.length - i, 1024));
            if (!isCancelled()) {
                i += 1024;
            } else {
                return;
            }
        }
    }

    /* JADX INFO: finally extract failed */
    private String readResponse(HttpsURLConnection httpsURLConnection) throws IOException {
        StringBuilder sb;
        Reader reader;
        HttpsURLConnection httpsURLConnection2 = httpsURLConnection;
        new StringBuilder(Math.max(httpsURLConnection2.getContentLength(), 16));
        StringBuilder builder = sb;
        InputStream stream = getInputStream(httpsURLConnection2);
        try {
            new InputStreamReader(stream, "UTF-8");
            Reader reader2 = reader;
            char[] buffer = new char[1024];
            do {
                int read = reader2.read(buffer);
                int len = read;
                if (read <= 0) {
                    break;
                }
                StringBuilder append = builder.append(buffer, 0, len);
            } while (!isCancelled());
            String sb2 = builder.toString();
            stream.close();
            return sb2;
        } catch (Throwable th) {
            Throwable th2 = th;
            stream.close();
            throw th2;
        }
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: type inference failed for: r13v91, types: [java.io.ByteArrayOutputStream] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.microsoft.appcenter.http.HttpResponse doHttpCall() throws java.lang.Exception {
        /*
            r19 = this;
            r0 = r19
            java.net.URL r13 = new java.net.URL
            r18 = r13
            r13 = r18
            r14 = r18
            r15 = r0
            java.lang.String r15 = r15.mUrl
            r14.<init>(r15)
            r1 = r13
            r13 = r1
            javax.net.ssl.HttpsURLConnection r13 = com.microsoft.appcenter.http.HttpUtils.createHttpsConnection(r13)
            r2 = r13
            r13 = r2
            r14 = r0
            java.lang.String r14 = r14.mMethod     // Catch:{ all -> 0x017c }
            r13.setRequestMethod(r14)     // Catch:{ all -> 0x017c }
            r13 = 0
            r3 = r13
            r13 = 0
            r4 = r13
            r13 = 0
            r5 = r13
            r13 = r0
            java.lang.String r13 = r13.mMethod     // Catch:{ all -> 0x017c }
            java.lang.String r14 = "POST"
            boolean r13 = r13.equals(r14)     // Catch:{ all -> 0x017c }
            r6 = r13
            r13 = r6
            if (r13 == 0) goto L_0x006e
            r13 = r0
            com.microsoft.appcenter.http.HttpClient$CallTemplate r13 = r13.mCallTemplate     // Catch:{ all -> 0x017c }
            if (r13 == 0) goto L_0x006e
            r13 = r0
            com.microsoft.appcenter.http.HttpClient$CallTemplate r13 = r13.mCallTemplate     // Catch:{ all -> 0x017c }
            java.lang.String r13 = r13.buildRequestBody()     // Catch:{ all -> 0x017c }
            r3 = r13
            r13 = r3
            java.lang.String r14 = "UTF-8"
            byte[] r13 = r13.getBytes(r14)     // Catch:{ all -> 0x017c }
            r4 = r13
            r13 = r0
            boolean r13 = r13.mCompressionEnabled     // Catch:{ all -> 0x017c }
            if (r13 == 0) goto L_0x00ac
            r13 = r4
            int r13 = r13.length     // Catch:{ all -> 0x017c }
            r14 = 1400(0x578, float:1.962E-42)
            if (r13 < r14) goto L_0x00ac
            r13 = 1
        L_0x0054:
            r5 = r13
            r13 = r0
            java.util.Map<java.lang.String, java.lang.String> r13 = r13.mHeaders     // Catch:{ all -> 0x017c }
            java.lang.String r14 = "Content-Type"
            boolean r13 = r13.containsKey(r14)     // Catch:{ all -> 0x017c }
            if (r13 != 0) goto L_0x006e
            r13 = r0
            java.util.Map<java.lang.String, java.lang.String> r13 = r13.mHeaders     // Catch:{ all -> 0x017c }
            java.lang.String r14 = "Content-Type"
            java.lang.String r15 = "application/json"
            java.lang.Object r13 = r13.put(r14, r15)     // Catch:{ all -> 0x017c }
        L_0x006e:
            r13 = r5
            if (r13 == 0) goto L_0x007e
            r13 = r0
            java.util.Map<java.lang.String, java.lang.String> r13 = r13.mHeaders     // Catch:{ all -> 0x017c }
            java.lang.String r14 = "Content-Encoding"
            java.lang.String r15 = "gzip"
            java.lang.Object r13 = r13.put(r14, r15)     // Catch:{ all -> 0x017c }
        L_0x007e:
            r13 = r0
            java.util.Map<java.lang.String, java.lang.String> r13 = r13.mHeaders     // Catch:{ all -> 0x017c }
            java.util.Set r13 = r13.entrySet()     // Catch:{ all -> 0x017c }
            java.util.Iterator r13 = r13.iterator()     // Catch:{ all -> 0x017c }
            r7 = r13
        L_0x008a:
            r13 = r7
            boolean r13 = r13.hasNext()     // Catch:{ all -> 0x017c }
            if (r13 == 0) goto L_0x00ae
            r13 = r7
            java.lang.Object r13 = r13.next()     // Catch:{ all -> 0x017c }
            java.util.Map$Entry r13 = (java.util.Map.Entry) r13     // Catch:{ all -> 0x017c }
            r8 = r13
            r13 = r2
            r14 = r8
            java.lang.Object r14 = r14.getKey()     // Catch:{ all -> 0x017c }
            java.lang.String r14 = (java.lang.String) r14     // Catch:{ all -> 0x017c }
            r15 = r8
            java.lang.Object r15 = r15.getValue()     // Catch:{ all -> 0x017c }
            java.lang.String r15 = (java.lang.String) r15     // Catch:{ all -> 0x017c }
            r13.setRequestProperty(r14, r15)     // Catch:{ all -> 0x017c }
            goto L_0x008a
        L_0x00ac:
            r13 = 0
            goto L_0x0054
        L_0x00ae:
            r13 = r0
            boolean r13 = r13.isCancelled()     // Catch:{ all -> 0x017c }
            if (r13 == 0) goto L_0x00be
            r13 = 0
            r7 = r13
            r13 = r2
            r13.disconnect()
            r13 = r7
            r0 = r13
        L_0x00bd:
            return r0
        L_0x00be:
            r13 = r0
            com.microsoft.appcenter.http.HttpClient$CallTemplate r13 = r13.mCallTemplate     // Catch:{ all -> 0x017c }
            if (r13 == 0) goto L_0x00cd
            r13 = r0
            com.microsoft.appcenter.http.HttpClient$CallTemplate r13 = r13.mCallTemplate     // Catch:{ all -> 0x017c }
            r14 = r1
            r15 = r0
            java.util.Map<java.lang.String, java.lang.String> r15 = r15.mHeaders     // Catch:{ all -> 0x017c }
            r13.onBeforeCalling(r14, r15)     // Catch:{ all -> 0x017c }
        L_0x00cd:
            r13 = r4
            if (r13 == 0) goto L_0x0163
            int r13 = com.microsoft.appcenter.utils.AppCenterLog.getLogLevel()     // Catch:{ all -> 0x017c }
            r14 = 2
            if (r13 > r14) goto L_0x011b
            r13 = r3
            int r13 = r13.length()     // Catch:{ all -> 0x017c }
            r14 = 4096(0x1000, float:5.74E-42)
            if (r13 >= r14) goto L_0x0114
            java.util.regex.Pattern r13 = TOKEN_REGEX_URL_ENCODED     // Catch:{ all -> 0x017c }
            r14 = r3
            java.util.regex.Matcher r13 = r13.matcher(r14)     // Catch:{ all -> 0x017c }
            java.lang.String r14 = "token=***"
            java.lang.String r13 = r13.replaceAll(r14)     // Catch:{ all -> 0x017c }
            r3 = r13
            java.lang.String r13 = "application/json"
            r14 = r0
            java.util.Map<java.lang.String, java.lang.String> r14 = r14.mHeaders     // Catch:{ all -> 0x017c }
            java.lang.String r15 = "Content-Type"
            java.lang.Object r14 = r14.get(r15)     // Catch:{ all -> 0x017c }
            boolean r13 = r13.equals(r14)     // Catch:{ all -> 0x017c }
            if (r13 == 0) goto L_0x0114
            org.json.JSONObject r13 = new org.json.JSONObject     // Catch:{ all -> 0x017c }
            r18 = r13
            r13 = r18
            r14 = r18
            r15 = r3
            r14.<init>(r15)     // Catch:{ all -> 0x017c }
            r14 = 2
            java.lang.String r13 = r13.toString(r14)     // Catch:{ all -> 0x017c }
            r3 = r13
        L_0x0114:
            java.lang.String r13 = "AppCenter"
            r14 = r3
            com.microsoft.appcenter.utils.AppCenterLog.verbose(r13, r14)     // Catch:{ all -> 0x017c }
        L_0x011b:
            r13 = r5
            if (r13 == 0) goto L_0x0148
            java.io.ByteArrayOutputStream r13 = new java.io.ByteArrayOutputStream     // Catch:{ all -> 0x017c }
            r18 = r13
            r13 = r18
            r14 = r18
            r15 = r4
            int r15 = r15.length     // Catch:{ all -> 0x017c }
            r14.<init>(r15)     // Catch:{ all -> 0x017c }
            r7 = r13
            java.util.zip.GZIPOutputStream r13 = new java.util.zip.GZIPOutputStream     // Catch:{ all -> 0x017c }
            r18 = r13
            r13 = r18
            r14 = r18
            r15 = r7
            r14.<init>(r15)     // Catch:{ all -> 0x017c }
            r8 = r13
            r13 = r8
            r14 = r4
            r13.write(r14)     // Catch:{ all -> 0x017c }
            r13 = r8
            r13.close()     // Catch:{ all -> 0x017c }
            r13 = r7
            byte[] r13 = r13.toByteArray()     // Catch:{ all -> 0x017c }
            r4 = r13
        L_0x0148:
            r13 = r2
            r14 = 1
            r13.setDoOutput(r14)     // Catch:{ all -> 0x017c }
            r13 = r2
            r14 = r4
            int r14 = r14.length     // Catch:{ all -> 0x017c }
            r13.setFixedLengthStreamingMode(r14)     // Catch:{ all -> 0x017c }
            r13 = r2
            java.io.OutputStream r13 = r13.getOutputStream()     // Catch:{ all -> 0x017c }
            r7 = r13
            r13 = r0
            r14 = r7
            r15 = r4
            r13.writePayload(r14, r15)     // Catch:{ all -> 0x0174 }
            r13 = r7
            r13.close()     // Catch:{ all -> 0x017c }
        L_0x0163:
            r13 = r0
            boolean r13 = r13.isCancelled()     // Catch:{ all -> 0x017c }
            if (r13 == 0) goto L_0x0184
            r13 = 0
            r7 = r13
            r13 = r2
            r13.disconnect()
            r13 = r7
            r0 = r13
            goto L_0x00bd
        L_0x0174:
            r13 = move-exception
            r9 = r13
            r13 = r7
            r13.close()     // Catch:{ all -> 0x017c }
            r13 = r9
            throw r13     // Catch:{ all -> 0x017c }
        L_0x017c:
            r13 = move-exception
            r12 = r13
            r13 = r2
            r13.disconnect()
            r13 = r12
            throw r13
        L_0x0184:
            r13 = r2
            int r13 = r13.getResponseCode()     // Catch:{ all -> 0x017c }
            r7 = r13
            r13 = r0
            r14 = r2
            java.lang.String r13 = r13.readResponse(r14)     // Catch:{ all -> 0x017c }
            r8 = r13
            int r13 = com.microsoft.appcenter.utils.AppCenterLog.getLogLevel()     // Catch:{ all -> 0x017c }
            r14 = 2
            if (r13 > r14) goto L_0x0203
            r13 = r2
            java.lang.String r14 = "Content-Type"
            java.lang.String r13 = r13.getHeaderField(r14)     // Catch:{ all -> 0x017c }
            r9 = r13
            r13 = r9
            if (r13 == 0) goto L_0x01b8
            r13 = r9
            java.lang.String r14 = "text/"
            boolean r13 = r13.startsWith(r14)     // Catch:{ all -> 0x017c }
            if (r13 != 0) goto L_0x01b8
            r13 = r9
            java.lang.String r14 = "application/"
            boolean r13 = r13.startsWith(r14)     // Catch:{ all -> 0x017c }
            if (r13 == 0) goto L_0x0246
        L_0x01b8:
            java.util.regex.Pattern r13 = TOKEN_REGEX_JSON     // Catch:{ all -> 0x017c }
            r14 = r8
            java.util.regex.Matcher r13 = r13.matcher(r14)     // Catch:{ all -> 0x017c }
            java.lang.String r14 = "token\":\"***\""
            java.lang.String r13 = r13.replaceAll(r14)     // Catch:{ all -> 0x017c }
            r10 = r13
            java.util.regex.Pattern r13 = REDIRECT_URI_REGEX_JSON     // Catch:{ all -> 0x017c }
            r14 = r10
            java.util.regex.Matcher r13 = r13.matcher(r14)     // Catch:{ all -> 0x017c }
            java.lang.String r14 = "redirect_uri\":\"***\""
            java.lang.String r13 = r13.replaceAll(r14)     // Catch:{ all -> 0x017c }
            r10 = r13
        L_0x01d6:
            java.lang.String r13 = "AppCenter"
            java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ all -> 0x017c }
            r18 = r14
            r14 = r18
            r15 = r18
            r15.<init>()     // Catch:{ all -> 0x017c }
            java.lang.String r15 = "HTTP response status="
            java.lang.StringBuilder r14 = r14.append(r15)     // Catch:{ all -> 0x017c }
            r15 = r7
            java.lang.StringBuilder r14 = r14.append(r15)     // Catch:{ all -> 0x017c }
            java.lang.String r15 = " payload="
            java.lang.StringBuilder r14 = r14.append(r15)     // Catch:{ all -> 0x017c }
            r15 = r10
            java.lang.StringBuilder r14 = r14.append(r15)     // Catch:{ all -> 0x017c }
            java.lang.String r14 = r14.toString()     // Catch:{ all -> 0x017c }
            com.microsoft.appcenter.utils.AppCenterLog.verbose(r13, r14)     // Catch:{ all -> 0x017c }
        L_0x0203:
            java.util.HashMap r13 = new java.util.HashMap     // Catch:{ all -> 0x017c }
            r18 = r13
            r13 = r18
            r14 = r18
            r14.<init>()     // Catch:{ all -> 0x017c }
            r9 = r13
            r13 = r2
            java.util.Map r13 = r13.getHeaderFields()     // Catch:{ all -> 0x017c }
            java.util.Set r13 = r13.entrySet()     // Catch:{ all -> 0x017c }
            java.util.Iterator r13 = r13.iterator()     // Catch:{ all -> 0x017c }
            r10 = r13
        L_0x021d:
            r13 = r10
            boolean r13 = r13.hasNext()     // Catch:{ all -> 0x017c }
            if (r13 == 0) goto L_0x024b
            r13 = r10
            java.lang.Object r13 = r13.next()     // Catch:{ all -> 0x017c }
            java.util.Map$Entry r13 = (java.util.Map.Entry) r13     // Catch:{ all -> 0x017c }
            r11 = r13
            r13 = r9
            r14 = r11
            java.lang.Object r14 = r14.getKey()     // Catch:{ all -> 0x017c }
            r15 = r11
            java.lang.Object r15 = r15.getValue()     // Catch:{ all -> 0x017c }
            java.util.List r15 = (java.util.List) r15     // Catch:{ all -> 0x017c }
            java.util.Iterator r15 = r15.iterator()     // Catch:{ all -> 0x017c }
            java.lang.Object r15 = r15.next()     // Catch:{ all -> 0x017c }
            java.lang.Object r13 = r13.put(r14, r15)     // Catch:{ all -> 0x017c }
            goto L_0x021d
        L_0x0246:
            java.lang.String r13 = "<binary>"
            r10 = r13
            goto L_0x01d6
        L_0x024b:
            com.microsoft.appcenter.http.HttpResponse r13 = new com.microsoft.appcenter.http.HttpResponse     // Catch:{ all -> 0x017c }
            r18 = r13
            r13 = r18
            r14 = r18
            r15 = r7
            r16 = r8
            r17 = r9
            r14.<init>(r15, r16, r17)     // Catch:{ all -> 0x017c }
            r10 = r13
            r13 = r7
            r14 = 200(0xc8, float:2.8E-43)
            if (r13 < r14) goto L_0x0270
            r13 = r7
            r14 = 300(0x12c, float:4.2E-43)
            if (r13 >= r14) goto L_0x0270
            r13 = r10
            r11 = r13
            r13 = r2
            r13.disconnect()
            r13 = r11
            r0 = r13
            goto L_0x00bd
        L_0x0270:
            com.microsoft.appcenter.http.HttpException r13 = new com.microsoft.appcenter.http.HttpException     // Catch:{ all -> 0x017c }
            r18 = r13
            r13 = r18
            r14 = r18
            r15 = r10
            r14.<init>(r15)     // Catch:{ all -> 0x017c }
            throw r13     // Catch:{ all -> 0x017c }
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microsoft.appcenter.http.DefaultHttpClientCallTask.doHttpCall():com.microsoft.appcenter.http.HttpResponse");
    }

    /* access modifiers changed from: protected */
    public Object doInBackground(Void... voidArr) {
        Void[] voidArr2 = voidArr;
        TrafficStats.setThreadStatsTag(HttpUtils.THREAD_STATS_TAG);
        try {
            HttpResponse doHttpCall = doHttpCall();
            TrafficStats.clearThreadStatsTag();
            return doHttpCall;
        } catch (Exception e) {
            TrafficStats.clearThreadStatsTag();
            return e;
        } catch (Throwable th) {
            TrafficStats.clearThreadStatsTag();
            throw th;
        }
    }

    /* access modifiers changed from: protected */
    public void onPreExecute() {
        this.mTracker.onStart(this);
    }

    /* access modifiers changed from: protected */
    public void onPostExecute(Object obj) {
        Object result = obj;
        this.mTracker.onFinish(this);
        if (result instanceof Exception) {
            this.mServiceCallback.onCallFailed((Exception) result);
            return;
        }
        this.mServiceCallback.onCallSucceeded((HttpResponse) result);
    }

    /* access modifiers changed from: protected */
    public void onCancelled(Object obj) {
        Object result = obj;
        if ((result instanceof HttpResponse) || (result instanceof HttpException)) {
            onPostExecute(result);
        } else {
            this.mTracker.onFinish(this);
        }
    }
}
