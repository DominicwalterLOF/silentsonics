package org.shaded.apache.http.impl.io;

import org.shaded.apache.http.io.HttpTransportMetrics;

public class HttpTransportMetricsImpl implements HttpTransportMetrics {
    private long bytesTransferred = 0;

    public HttpTransportMetricsImpl() {
    }

    public long getBytesTransferred() {
        return this.bytesTransferred;
    }

    public void setBytesTransferred(long count) {
        long j = count;
        this.bytesTransferred = j;
    }

    public void incrementBytesTransferred(long count) {
        this.bytesTransferred += count;
    }

    public void reset() {
        this.bytesTransferred = 0;
    }
}
