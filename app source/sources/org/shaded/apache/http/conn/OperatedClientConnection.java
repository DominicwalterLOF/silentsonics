package org.shaded.apache.http.conn;

import java.io.IOException;
import java.net.Socket;
import org.shaded.apache.http.HttpClientConnection;
import org.shaded.apache.http.HttpHost;
import org.shaded.apache.http.HttpInetConnection;
import org.shaded.apache.http.params.HttpParams;

public interface OperatedClientConnection extends HttpClientConnection, HttpInetConnection {
    Socket getSocket();

    HttpHost getTargetHost();

    boolean isSecure();

    void openCompleted(boolean z, HttpParams httpParams) throws IOException;

    void opening(Socket socket, HttpHost httpHost) throws IOException;

    void update(Socket socket, HttpHost httpHost, boolean z, HttpParams httpParams) throws IOException;
}
