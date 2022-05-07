package com.microsoft.appcenter.http;

import android.content.Context;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;
import com.microsoft.appcenter.utils.NetworkStateHelper;
import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketException;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.Locale;
import java.util.concurrent.RejectedExecutionException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSocketFactory;

public class HttpUtils {
    private static final Pattern API_KEY_PATTERN = Pattern.compile("-[^,]+(,|$)");
    private static final Pattern CONNECTION_ISSUE_PATTERN = Pattern.compile("connection (time|reset|abort)|failure in ssl library, usually a protocol error|anchor for certification path not found");
    public static final int CONNECT_TIMEOUT = 10000;
    @VisibleForTesting
    static final int MAX_CHARACTERS_DISPLAYED_FOR_SECRET = 8;
    public static final int READ_BUFFER_SIZE = 1024;
    public static final int READ_TIMEOUT = 10000;
    private static final Class[] RECOVERABLE_EXCEPTIONS;
    public static final int THREAD_STATS_TAG = -667034599;
    private static final Pattern TOKEN_VALUE_PATTERN = Pattern.compile(":[^\"]+");
    public static final int WRITE_BUFFER_SIZE = 1024;

    static {
        Class[] clsArr = new Class[5];
        clsArr[0] = EOFException.class;
        Class[] clsArr2 = clsArr;
        clsArr2[1] = InterruptedIOException.class;
        Class[] clsArr3 = clsArr2;
        clsArr3[2] = SocketException.class;
        Class[] clsArr4 = clsArr3;
        clsArr4[3] = UnknownHostException.class;
        Class[] clsArr5 = clsArr4;
        clsArr5[4] = RejectedExecutionException.class;
        RECOVERABLE_EXCEPTIONS = clsArr5;
    }

    @VisibleForTesting
    HttpUtils() {
    }

    public static boolean isRecoverableError(Throwable th) {
        String message;
        boolean z;
        Throwable t = th;
        if (t instanceof HttpException) {
            int code = ((HttpException) t).getHttpResponse().getStatusCode();
            if (code >= 500 || code == 408 || code == 429) {
                z = true;
            } else {
                z = false;
            }
            return z;
        }
        Class<?>[] clsArr = RECOVERABLE_EXCEPTIONS;
        int length = clsArr.length;
        for (int i = 0; i < length; i++) {
            if (clsArr[i].isAssignableFrom(t.getClass())) {
                return true;
            }
        }
        Throwable cause = t.getCause();
        if (cause != null) {
            Class<?>[] clsArr2 = RECOVERABLE_EXCEPTIONS;
            int length2 = clsArr2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                if (clsArr2[i2].isAssignableFrom(cause.getClass())) {
                    return true;
                }
            }
        }
        if (!(t instanceof SSLException) || (message = t.getMessage()) == null || !CONNECTION_ISSUE_PATTERN.matcher(message.toLowerCase(Locale.US)).find()) {
            return false;
        }
        return true;
    }

    public static String hideSecret(@NonNull String str) {
        StringBuilder sb;
        String str2;
        String secret = str;
        int hidingEndIndex = secret.length() - (secret.length() >= 8 ? 8 : 0);
        char[] fill = new char[hidingEndIndex];
        Arrays.fill(fill, '*');
        new StringBuilder();
        new String(fill);
        return sb.append(str2).append(secret.substring(hidingEndIndex)).toString();
    }

    public static String hideApiKeys(@NonNull String str) {
        StringBuilder sb;
        int lastEnd;
        String apiKeys = str;
        new StringBuilder();
        StringBuilder buffer = sb;
        Matcher matcher = API_KEY_PATTERN.matcher(apiKeys);
        int i = 0;
        while (true) {
            lastEnd = i;
            if (!matcher.find()) {
                break;
            }
            StringBuilder append = buffer.append(apiKeys.substring(lastEnd, matcher.start()));
            StringBuilder append2 = buffer.append("-***");
            StringBuilder append3 = buffer.append(matcher.group(1));
            i = matcher.end();
        }
        if (lastEnd < apiKeys.length()) {
            StringBuilder append4 = buffer.append(apiKeys.substring(lastEnd));
        }
        return buffer.toString();
    }

    public static String hideTickets(@NonNull String tickets) {
        return TOKEN_VALUE_PATTERN.matcher(tickets).replaceAll(":***");
    }

    public static HttpClient createHttpClient(@NonNull Context context) {
        return createHttpClient(context, true);
    }

    public static HttpClient createHttpClient(@NonNull Context context, boolean compressionEnabled) {
        HttpClient httpClient;
        new HttpClientRetryer(createHttpClientWithoutRetryer(context, compressionEnabled));
        return httpClient;
    }

    public static HttpClient createHttpClientWithoutRetryer(@NonNull Context context, boolean compressionEnabled) {
        HttpClient httpClient;
        HttpClient httpClient2;
        new DefaultHttpClient(compressionEnabled);
        new HttpClientNetworkStateHandler(httpClient, NetworkStateHelper.getSharedInstance(context));
        return httpClient2;
    }

    @NonNull
    public static HttpsURLConnection createHttpsConnection(@NonNull URL url) throws IOException {
        Throwable th;
        SSLSocketFactory sSLSocketFactory;
        Throwable th2;
        URL url2 = url;
        if (!"https".equals(url2.getProtocol())) {
            Throwable th3 = th2;
            new IOException("App Center support only HTTPS connection.");
            throw th3;
        }
        URLConnection urlConnection = url2.openConnection();
        if (urlConnection instanceof HttpsURLConnection) {
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) urlConnection;
            if (Build.VERSION.SDK_INT <= 21) {
                new TLS1_2SocketFactory();
                httpsURLConnection.setSSLSocketFactory(sSLSocketFactory);
            }
            httpsURLConnection.setConnectTimeout(10000);
            httpsURLConnection.setReadTimeout(10000);
            return httpsURLConnection;
        }
        Throwable th4 = th;
        new IOException("App Center supports only HTTPS connection.");
        throw th4;
    }
}
