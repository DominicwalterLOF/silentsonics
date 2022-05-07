package com.microsoft.appcenter.http;

import com.microsoft.appcenter.Constants;
import com.microsoft.appcenter.http.HttpClient;
import com.microsoft.appcenter.utils.AppCenterLog;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractAppCallTemplate implements HttpClient.CallTemplate {
    public AbstractAppCallTemplate() {
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
            String appSecret = logHeaders.get(Constants.APP_SECRET);
            if (appSecret != null) {
                String put = logHeaders.put(Constants.APP_SECRET, HttpUtils.hideSecret(appSecret));
            }
            new StringBuilder();
            AppCenterLog.verbose("AppCenter", sb2.append("Headers: ").append(logHeaders).toString());
        }
    }
}
