package com.microsoft.appcenter.http;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

class TLS1_2SocketFactory extends SSLSocketFactory {
    private static final String[] ENABLED_PROTOCOLS = {TLS1_2_PROTOCOL};
    private static final String TLS1_2_PROTOCOL = "TLSv1.2";
    private final SSLSocketFactory delegate;

    TLS1_2SocketFactory() {
        SSLSocketFactory socketFactory = null;
        try {
            SSLContext sc = SSLContext.getInstance(TLS1_2_PROTOCOL);
            sc.init((KeyManager[]) null, (TrustManager[]) null, (SecureRandom) null);
            socketFactory = sc.getSocketFactory();
        } catch (KeyManagementException | NoSuchAlgorithmException e) {
            Object obj = e;
        }
        this.delegate = socketFactory != null ? socketFactory : HttpsURLConnection.getDefaultSSLSocketFactory();
    }

    private SSLSocket forceTLS1_2(Socket socket) {
        SSLSocket sslSocket = (SSLSocket) socket;
        sslSocket.setEnabledProtocols(ENABLED_PROTOCOLS);
        return sslSocket;
    }

    public String[] getDefaultCipherSuites() {
        return this.delegate.getDefaultCipherSuites();
    }

    public String[] getSupportedCipherSuites() {
        return this.delegate.getSupportedCipherSuites();
    }

    public SSLSocket createSocket() throws IOException {
        return forceTLS1_2(this.delegate.createSocket());
    }

    public SSLSocket createSocket(String host, int port) throws IOException {
        return forceTLS1_2(this.delegate.createSocket(host, port));
    }

    public SSLSocket createSocket(InetAddress host, int port) throws IOException {
        return forceTLS1_2(this.delegate.createSocket(host, port));
    }

    public SSLSocket createSocket(String host, int port, InetAddress localHost, int localPort) throws IOException {
        return forceTLS1_2(this.delegate.createSocket(host, port, localHost, localPort));
    }

    public SSLSocket createSocket(InetAddress address, int port, InetAddress localAddress, int localPort) throws IOException {
        return forceTLS1_2(this.delegate.createSocket(address, port, localAddress, localPort));
    }

    public SSLSocket createSocket(Socket socket, String host, int port, boolean autoClose) throws IOException {
        return forceTLS1_2(this.delegate.createSocket(socket, host, port, autoClose));
    }
}
