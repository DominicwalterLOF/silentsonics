package org.jose4j.http;

import com.shaded.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import java.io.IOException;
import java.io.InputStream;
import java.net.Proxy;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.Collection;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import org.jose4j.lang.UncheckedJoseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Get implements SimpleGet {
    private static final long MAX_RETRY_WAIT = 8000;
    private static final Logger log = LoggerFactory.getLogger((Class<?>) Get.class);
    private int connectTimeout = 20000;
    private HostnameVerifier hostnameVerifier;
    private long initialRetryWaitTime = 180;
    private boolean progressiveRetryWait = true;
    private Proxy proxy;
    private int readTimeout = 20000;
    private int responseBodySizeLimit = 524288;
    private int retries = 3;
    private SSLSocketFactory sslSocketFactory;

    public Get() {
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v7, resolved type: java.net.URL} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v16, resolved type: java.net.URL} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v18, resolved type: java.net.URL} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v11, resolved type: java.net.URL} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v13, resolved type: java.net.URL} */
    /* JADX WARNING: type inference failed for: r1v1, types: [org.jose4j.http.SimpleResponse] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public org.jose4j.http.SimpleResponse get(java.lang.String r22) throws java.io.IOException {
        /*
            r21 = this;
            r1 = r21
            r2 = r22
            r13 = 0
            r3 = r13
            org.slf4j.Logger r13 = log
            java.lang.String r14 = "HTTP GET of {}"
            r15 = r2
            r13.debug((java.lang.String) r14, (java.lang.Object) r15)
            java.net.URL r13 = new java.net.URL
            r20 = r13
            r13 = r20
            r14 = r20
            r15 = r2
            r14.<init>(r15)
            r4 = r13
        L_0x001c:
            r13 = r1
            java.net.Proxy r13 = r13.proxy     // Catch:{ SSLHandshakeException -> 0x0091, SSLPeerUnverifiedException -> 0x0149, FileNotFoundException -> 0x014c, ResponseBodyTooLargeException -> 0x014f, IOException -> 0x00d4 }
            if (r13 != 0) goto L_0x0095
            r13 = r4
            java.net.URLConnection r13 = r13.openConnection()     // Catch:{ SSLHandshakeException -> 0x0091, SSLPeerUnverifiedException -> 0x0149, FileNotFoundException -> 0x014c, ResponseBodyTooLargeException -> 0x014f, IOException -> 0x00d4 }
        L_0x0026:
            r5 = r13
            r13 = r5
            r14 = r1
            int r14 = r14.connectTimeout     // Catch:{ SSLHandshakeException -> 0x0091, SSLPeerUnverifiedException -> 0x0149, FileNotFoundException -> 0x014c, ResponseBodyTooLargeException -> 0x014f, IOException -> 0x00d4 }
            r13.setConnectTimeout(r14)     // Catch:{ SSLHandshakeException -> 0x0091, SSLPeerUnverifiedException -> 0x0149, FileNotFoundException -> 0x014c, ResponseBodyTooLargeException -> 0x014f, IOException -> 0x00d4 }
            r13 = r5
            r14 = r1
            int r14 = r14.readTimeout     // Catch:{ SSLHandshakeException -> 0x0091, SSLPeerUnverifiedException -> 0x0149, FileNotFoundException -> 0x014c, ResponseBodyTooLargeException -> 0x014f, IOException -> 0x00d4 }
            r13.setReadTimeout(r14)     // Catch:{ SSLHandshakeException -> 0x0091, SSLPeerUnverifiedException -> 0x0149, FileNotFoundException -> 0x014c, ResponseBodyTooLargeException -> 0x014f, IOException -> 0x00d4 }
            r13 = r1
            r14 = r5
            r13.setUpTls(r14)     // Catch:{ SSLHandshakeException -> 0x0091, SSLPeerUnverifiedException -> 0x0149, FileNotFoundException -> 0x014c, ResponseBodyTooLargeException -> 0x014f, IOException -> 0x00d4 }
            r13 = r5
            java.net.HttpURLConnection r13 = (java.net.HttpURLConnection) r13     // Catch:{ SSLHandshakeException -> 0x0091, SSLPeerUnverifiedException -> 0x0149, FileNotFoundException -> 0x014c, ResponseBodyTooLargeException -> 0x014f, IOException -> 0x00d4 }
            r6 = r13
            r13 = r6
            int r13 = r13.getResponseCode()     // Catch:{ SSLHandshakeException -> 0x0091, SSLPeerUnverifiedException -> 0x0149, FileNotFoundException -> 0x014c, ResponseBodyTooLargeException -> 0x014f, IOException -> 0x00d4 }
            r7 = r13
            r13 = r6
            java.lang.String r13 = r13.getResponseMessage()     // Catch:{ SSLHandshakeException -> 0x0091, SSLPeerUnverifiedException -> 0x0149, FileNotFoundException -> 0x014c, ResponseBodyTooLargeException -> 0x014f, IOException -> 0x00d4 }
            r8 = r13
            r13 = r7
            r14 = 200(0xc8, float:2.8E-43)
            if (r13 == r14) goto L_0x009e
            java.io.IOException r13 = new java.io.IOException     // Catch:{ SSLHandshakeException -> 0x0091, SSLPeerUnverifiedException -> 0x0149, FileNotFoundException -> 0x014c, ResponseBodyTooLargeException -> 0x014f, IOException -> 0x00d4 }
            r20 = r13
            r13 = r20
            r14 = r20
            java.lang.StringBuilder r15 = new java.lang.StringBuilder     // Catch:{ SSLHandshakeException -> 0x0091, SSLPeerUnverifiedException -> 0x0149, FileNotFoundException -> 0x014c, ResponseBodyTooLargeException -> 0x014f, IOException -> 0x00d4 }
            r20 = r15
            r15 = r20
            r16 = r20
            r16.<init>()     // Catch:{ SSLHandshakeException -> 0x0091, SSLPeerUnverifiedException -> 0x0149, FileNotFoundException -> 0x014c, ResponseBodyTooLargeException -> 0x014f, IOException -> 0x00d4 }
            java.lang.String r16 = "Non 200 status code ("
            java.lang.StringBuilder r15 = r15.append(r16)     // Catch:{ SSLHandshakeException -> 0x0091, SSLPeerUnverifiedException -> 0x0149, FileNotFoundException -> 0x014c, ResponseBodyTooLargeException -> 0x014f, IOException -> 0x00d4 }
            r16 = r7
            java.lang.StringBuilder r15 = r15.append(r16)     // Catch:{ SSLHandshakeException -> 0x0091, SSLPeerUnverifiedException -> 0x0149, FileNotFoundException -> 0x014c, ResponseBodyTooLargeException -> 0x014f, IOException -> 0x00d4 }
            java.lang.String r16 = " "
            java.lang.StringBuilder r15 = r15.append(r16)     // Catch:{ SSLHandshakeException -> 0x0091, SSLPeerUnverifiedException -> 0x0149, FileNotFoundException -> 0x014c, ResponseBodyTooLargeException -> 0x014f, IOException -> 0x00d4 }
            r16 = r8
            java.lang.StringBuilder r15 = r15.append(r16)     // Catch:{ SSLHandshakeException -> 0x0091, SSLPeerUnverifiedException -> 0x0149, FileNotFoundException -> 0x014c, ResponseBodyTooLargeException -> 0x014f, IOException -> 0x00d4 }
            java.lang.String r16 = ") returned from "
            java.lang.StringBuilder r15 = r15.append(r16)     // Catch:{ SSLHandshakeException -> 0x0091, SSLPeerUnverifiedException -> 0x0149, FileNotFoundException -> 0x014c, ResponseBodyTooLargeException -> 0x014f, IOException -> 0x00d4 }
            r16 = r4
            java.lang.StringBuilder r15 = r15.append(r16)     // Catch:{ SSLHandshakeException -> 0x0091, SSLPeerUnverifiedException -> 0x0149, FileNotFoundException -> 0x014c, ResponseBodyTooLargeException -> 0x014f, IOException -> 0x00d4 }
            java.lang.String r15 = r15.toString()     // Catch:{ SSLHandshakeException -> 0x0091, SSLPeerUnverifiedException -> 0x0149, FileNotFoundException -> 0x014c, ResponseBodyTooLargeException -> 0x014f, IOException -> 0x00d4 }
            r14.<init>(r15)     // Catch:{ SSLHandshakeException -> 0x0091, SSLPeerUnverifiedException -> 0x0149, FileNotFoundException -> 0x014c, ResponseBodyTooLargeException -> 0x014f, IOException -> 0x00d4 }
            throw r13     // Catch:{ SSLHandshakeException -> 0x0091, SSLPeerUnverifiedException -> 0x0149, FileNotFoundException -> 0x014c, ResponseBodyTooLargeException -> 0x014f, IOException -> 0x00d4 }
        L_0x0091:
            r13 = move-exception
        L_0x0092:
            r5 = r13
            r13 = r5
            throw r13
        L_0x0095:
            r13 = r4
            r14 = r1
            java.net.Proxy r14 = r14.proxy     // Catch:{ SSLHandshakeException -> 0x0091, SSLPeerUnverifiedException -> 0x0149, FileNotFoundException -> 0x014c, ResponseBodyTooLargeException -> 0x014f, IOException -> 0x00d4 }
            java.net.URLConnection r13 = r13.openConnection(r14)     // Catch:{ SSLHandshakeException -> 0x0091, SSLPeerUnverifiedException -> 0x0149, FileNotFoundException -> 0x014c, ResponseBodyTooLargeException -> 0x014f, IOException -> 0x00d4 }
            goto L_0x0026
        L_0x009e:
            r13 = r1
            r14 = r5
            java.lang.String r13 = r13.getCharset(r14)     // Catch:{ SSLHandshakeException -> 0x0091, SSLPeerUnverifiedException -> 0x0149, FileNotFoundException -> 0x014c, ResponseBodyTooLargeException -> 0x014f, IOException -> 0x00d4 }
            r9 = r13
            r13 = r1
            r14 = r5
            r15 = r9
            java.lang.String r13 = r13.getBody(r14, r15)     // Catch:{ SSLHandshakeException -> 0x0091, SSLPeerUnverifiedException -> 0x0149, FileNotFoundException -> 0x014c, ResponseBodyTooLargeException -> 0x014f, IOException -> 0x00d4 }
            r10 = r13
            r13 = r6
            java.util.Map r13 = r13.getHeaderFields()     // Catch:{ SSLHandshakeException -> 0x0091, SSLPeerUnverifiedException -> 0x0149, FileNotFoundException -> 0x014c, ResponseBodyTooLargeException -> 0x014f, IOException -> 0x00d4 }
            r11 = r13
            org.jose4j.http.Response r13 = new org.jose4j.http.Response     // Catch:{ SSLHandshakeException -> 0x0091, SSLPeerUnverifiedException -> 0x0149, FileNotFoundException -> 0x014c, ResponseBodyTooLargeException -> 0x014f, IOException -> 0x00d4 }
            r20 = r13
            r13 = r20
            r14 = r20
            r15 = r7
            r16 = r8
            r17 = r11
            r18 = r10
            r14.<init>(r15, r16, r17, r18)     // Catch:{ SSLHandshakeException -> 0x0091, SSLPeerUnverifiedException -> 0x0149, FileNotFoundException -> 0x014c, ResponseBodyTooLargeException -> 0x014f, IOException -> 0x00d4 }
            r12 = r13
            org.slf4j.Logger r13 = log     // Catch:{ SSLHandshakeException -> 0x0091, SSLPeerUnverifiedException -> 0x0149, FileNotFoundException -> 0x014c, ResponseBodyTooLargeException -> 0x014f, IOException -> 0x00d4 }
            java.lang.String r14 = "HTTP GET of {} returned {}"
            r15 = r4
            r16 = r12
            r13.debug((java.lang.String) r14, (java.lang.Object) r15, (java.lang.Object) r16)     // Catch:{ SSLHandshakeException -> 0x0091, SSLPeerUnverifiedException -> 0x0149, FileNotFoundException -> 0x014c, ResponseBodyTooLargeException -> 0x014f, IOException -> 0x00d4 }
            r13 = r12
            r1 = r13
            return r1
        L_0x00d4:
            r13 = move-exception
            r5 = r13
            int r3 = r3 + 1
            r13 = r3
            r14 = r1
            int r14 = r14.retries
            if (r13 <= r14) goto L_0x00e0
            r13 = r5
            throw r13
        L_0x00e0:
            r13 = r1
            r14 = r3
            long r13 = r13.getRetryWaitTime(r14)
            r6 = r13
            org.slf4j.Logger r13 = log
            java.lang.String r14 = "Waiting {}ms before retrying ({} of {}) HTTP GET of {} after failed attempt: {}"
            r15 = 5
            java.lang.Object[] r15 = new java.lang.Object[r15]
            r20 = r15
            r15 = r20
            r16 = r20
            r17 = 0
            r18 = r6
            java.lang.Long r18 = java.lang.Long.valueOf(r18)
            r16[r17] = r18
            r20 = r15
            r15 = r20
            r16 = r20
            r17 = 1
            r18 = r3
            java.lang.Integer r18 = java.lang.Integer.valueOf(r18)
            r16[r17] = r18
            r20 = r15
            r15 = r20
            r16 = r20
            r17 = 2
            r18 = r1
            r0 = r18
            int r0 = r0.retries
            r18 = r0
            java.lang.Integer r18 = java.lang.Integer.valueOf(r18)
            r16[r17] = r18
            r20 = r15
            r15 = r20
            r16 = r20
            r17 = 3
            r18 = r4
            r16[r17] = r18
            r20 = r15
            r15 = r20
            r16 = r20
            r17 = 4
            r18 = r5
            r16[r17] = r18
            r13.debug((java.lang.String) r14, (java.lang.Object[]) r15)
            r13 = r6
            java.lang.Thread.sleep(r13)     // Catch:{ InterruptedException -> 0x0146 }
        L_0x0144:
            goto L_0x001c
        L_0x0146:
            r13 = move-exception
            r8 = r13
            goto L_0x0144
        L_0x0149:
            r13 = move-exception
            goto L_0x0092
        L_0x014c:
            r13 = move-exception
            goto L_0x0092
        L_0x014f:
            r13 = move-exception
            goto L_0x0092
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jose4j.http.Get.get(java.lang.String):org.jose4j.http.SimpleResponse");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:44:?, code lost:
        log.debug("read {} characters", (java.lang.Object) java.lang.Integer.valueOf(r10));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0106, code lost:
        if (r8 == null) goto L_0x0111;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x010a, code lost:
        if (0 == 0) goto L_0x0132;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:?, code lost:
        r8.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0127, code lost:
        r17 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0128, code lost:
        r10 = r17;
        r17 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:?, code lost:
        r17.addSuppressed(r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x0132, code lost:
        r8.close();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String getBody(java.net.URLConnection r23, java.lang.String r24) throws java.io.IOException {
        /*
            r22 = this;
            r2 = r22
            r3 = r23
            r4 = r24
            java.io.StringWriter r17 = new java.io.StringWriter
            r21 = r17
            r17 = r21
            r18 = r21
            r18.<init>()
            r5 = r17
            r17 = r3
            java.io.InputStream r17 = r17.getInputStream()
            r6 = r17
            r17 = 0
            r7 = r17
            java.io.InputStreamReader r17 = new java.io.InputStreamReader     // Catch:{ Throwable -> 0x00d9 }
            r21 = r17
            r17 = r21
            r18 = r21
            r19 = r6
            r20 = r4
            r18.<init>(r19, r20)     // Catch:{ Throwable -> 0x00d9 }
            r8 = r17
            r17 = 0
            r9 = r17
            r17 = 0
            r10 = r17
            r17 = 1024(0x400, float:1.435E-42)
            r0 = r17
            char[] r0 = new char[r0]     // Catch:{ Throwable -> 0x00bc }
            r17 = r0
            r11 = r17
        L_0x0042:
            r17 = -1
            r18 = r8
            r19 = r11
            int r18 = r18.read(r19)     // Catch:{ Throwable -> 0x00bc }
            r21 = r18
            r18 = r21
            r19 = r21
            r12 = r19
            r0 = r17
            r1 = r18
            if (r0 == r1) goto L_0x00f6
            r17 = r5
            r18 = r11
            r19 = 0
            r20 = r12
            r17.write(r18, r19, r20)     // Catch:{ Throwable -> 0x00bc }
            r17 = r10
            r18 = r12
            int r17 = r17 + r18
            r10 = r17
            r17 = r2
            r0 = r17
            int r0 = r0.responseBodySizeLimit     // Catch:{ Throwable -> 0x00bc }
            r17 = r0
            if (r17 <= 0) goto L_0x0042
            r17 = r10
            r18 = r2
            r0 = r18
            int r0 = r0.responseBodySizeLimit     // Catch:{ Throwable -> 0x00bc }
            r18 = r0
            r0 = r17
            r1 = r18
            if (r0 <= r1) goto L_0x0042
            org.jose4j.http.Get$ResponseBodyTooLargeException r17 = new org.jose4j.http.Get$ResponseBodyTooLargeException     // Catch:{ Throwable -> 0x00bc }
            r21 = r17
            r17 = r21
            r18 = r21
            java.lang.StringBuilder r19 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x00bc }
            r21 = r19
            r19 = r21
            r20 = r21
            r20.<init>()     // Catch:{ Throwable -> 0x00bc }
            java.lang.String r20 = "More than "
            java.lang.StringBuilder r19 = r19.append(r20)     // Catch:{ Throwable -> 0x00bc }
            r20 = r2
            r0 = r20
            int r0 = r0.responseBodySizeLimit     // Catch:{ Throwable -> 0x00bc }
            r20 = r0
            java.lang.StringBuilder r19 = r19.append(r20)     // Catch:{ Throwable -> 0x00bc }
            java.lang.String r20 = " characters have been read from the response body."
            java.lang.StringBuilder r19 = r19.append(r20)     // Catch:{ Throwable -> 0x00bc }
            java.lang.String r19 = r19.toString()     // Catch:{ Throwable -> 0x00bc }
            r18.<init>(r19)     // Catch:{ Throwable -> 0x00bc }
            throw r17     // Catch:{ Throwable -> 0x00bc }
        L_0x00bc:
            r17 = move-exception
            r10 = r17
            r17 = r10
            r9 = r17
            r17 = r10
            throw r17     // Catch:{ all -> 0x00c6 }
        L_0x00c6:
            r17 = move-exception
            r13 = r17
            r17 = r8
            if (r17 == 0) goto L_0x00d6
            r17 = r9
            if (r17 == 0) goto L_0x0143
            r17 = r8
            r17.close()     // Catch:{ Throwable -> 0x0138 }
        L_0x00d6:
            r17 = r13
            throw r17     // Catch:{ Throwable -> 0x00d9 }
        L_0x00d9:
            r17 = move-exception
            r8 = r17
            r17 = r8
            r7 = r17
            r17 = r8
            throw r17     // Catch:{ all -> 0x00e3 }
        L_0x00e3:
            r17 = move-exception
            r15 = r17
            r17 = r6
            if (r17 == 0) goto L_0x00f3
            r17 = r7
            if (r17 == 0) goto L_0x0165
            r17 = r6
            r17.close()     // Catch:{ Throwable -> 0x015a }
        L_0x00f3:
            r17 = r15
            throw r17
        L_0x00f6:
            org.slf4j.Logger r17 = log     // Catch:{ Throwable -> 0x00bc }
            java.lang.String r18 = "read {} characters"
            r19 = r10
            java.lang.Integer r19 = java.lang.Integer.valueOf(r19)     // Catch:{ Throwable -> 0x00bc }
            r17.debug((java.lang.String) r18, (java.lang.Object) r19)     // Catch:{ Throwable -> 0x00bc }
            r17 = r8
            if (r17 == 0) goto L_0x0111
            r17 = r9
            if (r17 == 0) goto L_0x0132
            r17 = r8
            r17.close()     // Catch:{ Throwable -> 0x0127 }
        L_0x0111:
            r17 = r6
            if (r17 == 0) goto L_0x011e
            r17 = r7
            if (r17 == 0) goto L_0x0154
            r17 = r6
            r17.close()     // Catch:{ Throwable -> 0x0149 }
        L_0x011e:
            r17 = r5
            java.lang.String r17 = r17.toString()
            r2 = r17
            return r2
        L_0x0127:
            r17 = move-exception
            r10 = r17
            r17 = r9
            r18 = r10
            r17.addSuppressed(r18)     // Catch:{ Throwable -> 0x00d9 }
            goto L_0x0111
        L_0x0132:
            r17 = r8
            r17.close()     // Catch:{ Throwable -> 0x00d9 }
            goto L_0x0111
        L_0x0138:
            r17 = move-exception
            r14 = r17
            r17 = r9
            r18 = r14
            r17.addSuppressed(r18)     // Catch:{ Throwable -> 0x00d9 }
            goto L_0x00d6
        L_0x0143:
            r17 = r8
            r17.close()     // Catch:{ Throwable -> 0x00d9 }
            goto L_0x00d6
        L_0x0149:
            r17 = move-exception
            r8 = r17
            r17 = r7
            r18 = r8
            r17.addSuppressed(r18)
            goto L_0x011e
        L_0x0154:
            r17 = r6
            r17.close()
            goto L_0x011e
        L_0x015a:
            r17 = move-exception
            r16 = r17
            r17 = r7
            r18 = r16
            r17.addSuppressed(r18)
            goto L_0x00f3
        L_0x0165:
            r17 = r6
            r17.close()
            goto L_0x00f3
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jose4j.http.Get.getBody(java.net.URLConnection, java.lang.String):java.lang.String");
    }

    private void setUpTls(URLConnection uRLConnection) {
        URLConnection urlConnection = uRLConnection;
        if (urlConnection instanceof HttpsURLConnection) {
            HttpsURLConnection httpsUrlConnection = (HttpsURLConnection) urlConnection;
            if (this.sslSocketFactory != null) {
                httpsUrlConnection.setSSLSocketFactory(this.sslSocketFactory);
            }
            if (this.hostnameVerifier != null) {
                httpsUrlConnection.setHostnameVerifier(this.hostnameVerifier);
            }
        }
    }

    private String getCharset(URLConnection urlConnection) {
        String contentType = urlConnection.getHeaderField("Content-Type");
        String charset = "UTF-8";
        if (contentType != null) {
            try {
                String[] arr$ = contentType.replace(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR, "").split(";");
                int len$ = arr$.length;
                int i$ = 0;
                while (true) {
                    if (i$ >= len$) {
                        break;
                    }
                    String part = arr$[i$];
                    String prefix = "charset=";
                    if (part.startsWith(prefix)) {
                        charset = part.substring(prefix.length());
                        break;
                    }
                    i$++;
                }
                Charset forName = Charset.forName(charset);
            } catch (Exception e) {
                log.debug("Unexpected problem attempted to determine the charset from the Content-Type ({}) so will default to using UTF8: {}", (Object) contentType, (Object) e);
                charset = "UTF-8";
            }
        }
        return charset;
    }

    private long getRetryWaitTime(int i) {
        int attempt = i;
        if (this.progressiveRetryWait) {
            return Math.min((long) (Math.pow(2.0d, (double) (attempt - 1)) * ((double) this.initialRetryWaitTime)), MAX_RETRY_WAIT);
        }
        return this.initialRetryWaitTime;
    }

    public void setConnectTimeout(int connectTimeout2) {
        int i = connectTimeout2;
        this.connectTimeout = i;
    }

    public void setReadTimeout(int readTimeout2) {
        int i = readTimeout2;
        this.readTimeout = i;
    }

    public void setHostnameVerifier(HostnameVerifier hostnameVerifier2) {
        HostnameVerifier hostnameVerifier3 = hostnameVerifier2;
        this.hostnameVerifier = hostnameVerifier3;
    }

    public void setTrustedCertificates(X509Certificate... certificates) {
        setTrustedCertificates((Collection<X509Certificate>) Arrays.asList(certificates));
    }

    public void setRetries(int retries2) {
        int i = retries2;
        this.retries = i;
    }

    public void setProgressiveRetryWait(boolean progressiveRetryWait2) {
        boolean z = progressiveRetryWait2;
        this.progressiveRetryWait = z;
    }

    public void setInitialRetryWaitTime(long initialRetryWaitTime2) {
        long j = initialRetryWaitTime2;
        this.initialRetryWaitTime = j;
    }

    public void setResponseBodySizeLimit(int responseBodySizeLimit2) {
        int i = responseBodySizeLimit2;
        this.responseBodySizeLimit = i;
    }

    public void setTrustedCertificates(Collection<X509Certificate> collection) {
        Throwable th;
        StringBuilder sb;
        Collection<X509Certificate> certificates = collection;
        try {
            TrustManagerFactory trustMgrFactory = TrustManagerFactory.getInstance("PKIX");
            KeyStore keyStore = KeyStore.getInstance("jks");
            keyStore.load((InputStream) null, (char[]) null);
            int i = 0;
            for (X509Certificate certificate : certificates) {
                new StringBuilder();
                int i2 = i;
                i++;
                keyStore.setCertificateEntry(sb.append("alias").append(i2).toString(), certificate);
            }
            trustMgrFactory.init(keyStore);
            TrustManager[] customTrustManagers = trustMgrFactory.getTrustManagers();
            SSLContext sslContext = SSLContext.getInstance(org.shaded.apache.http.conn.ssl.SSLSocketFactory.TLS);
            sslContext.init((KeyManager[]) null, customTrustManagers, (SecureRandom) null);
            this.sslSocketFactory = sslContext.getSocketFactory();
        } catch (IOException | KeyManagementException | KeyStoreException | NoSuchAlgorithmException | CertificateException e) {
            Exception e2 = e;
            Throwable th2 = th;
            new UncheckedJoseException("Unable to initialize socket factory with custom trusted  certificates.", e2);
            throw th2;
        }
    }

    public void setSslSocketFactory(SSLSocketFactory sslSocketFactory2) {
        SSLSocketFactory sSLSocketFactory = sslSocketFactory2;
        this.sslSocketFactory = sSLSocketFactory;
    }

    public void setHttpProxy(Proxy proxy2) {
        Proxy proxy3 = proxy2;
        this.proxy = proxy3;
    }

    private static class ResponseBodyTooLargeException extends IOException {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ResponseBodyTooLargeException(String message) {
            super(message);
        }
    }
}
