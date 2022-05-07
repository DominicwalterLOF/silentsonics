package org.shaded.apache.http.impl.io;

import java.io.IOException;
import java.io.InputStream;
import org.shaded.apache.http.io.SessionInputBuffer;

public class IdentityInputStream extends InputStream {
    private boolean closed = false;
    private final SessionInputBuffer in;

    public IdentityInputStream(SessionInputBuffer sessionInputBuffer) {
        Throwable th;
        SessionInputBuffer in2 = sessionInputBuffer;
        if (in2 == null) {
            Throwable th2 = th;
            new IllegalArgumentException("Session input buffer may not be null");
            throw th2;
        }
        this.in = in2;
    }

    public int available() throws IOException {
        if (this.closed || !this.in.isDataAvailable(10)) {
            return 0;
        }
        return 1;
    }

    public void close() throws IOException {
        this.closed = true;
    }

    public int read() throws IOException {
        if (this.closed) {
            return -1;
        }
        return this.in.read();
    }

    public int read(byte[] bArr, int i, int i2) throws IOException {
        byte[] b = bArr;
        int off = i;
        int len = i2;
        if (this.closed) {
            return -1;
        }
        return this.in.read(b, off, len);
    }
}
