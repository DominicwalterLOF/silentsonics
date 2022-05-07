package org.shaded.apache.http.impl.io;

import java.io.IOException;
import java.io.InputStream;
import org.shaded.apache.http.io.SessionInputBuffer;

public class ContentLengthInputStream extends InputStream {
    private static final int BUFFER_SIZE = 2048;
    private boolean closed = false;
    private long contentLength;
    private SessionInputBuffer in = null;
    private long pos = 0;

    public ContentLengthInputStream(SessionInputBuffer sessionInputBuffer, long j) {
        Throwable th;
        Throwable th2;
        SessionInputBuffer in2 = sessionInputBuffer;
        long contentLength2 = j;
        if (in2 == null) {
            Throwable th3 = th2;
            new IllegalArgumentException("Input stream may not be null");
            throw th3;
        } else if (contentLength2 < 0) {
            Throwable th4 = th;
            new IllegalArgumentException("Content length may not be negative");
            throw th4;
        } else {
            this.in = in2;
            this.contentLength = contentLength2;
        }
    }

    public void close() throws IOException {
        if (!this.closed) {
            try {
                do {
                } while (read(new byte[2048]) >= 0);
                this.closed = true;
            } catch (Throwable th) {
                Throwable th2 = th;
                this.closed = true;
                throw th2;
            }
        }
    }

    public int read() throws IOException {
        Throwable th;
        if (this.closed) {
            Throwable th2 = th;
            new IOException("Attempted read from closed stream.");
            throw th2;
        } else if (this.pos >= this.contentLength) {
            return -1;
        } else {
            this.pos++;
            return this.in.read();
        }
    }

    public int read(byte[] bArr, int i, int i2) throws IOException {
        Throwable th;
        byte[] b = bArr;
        int off = i;
        int len = i2;
        if (this.closed) {
            Throwable th2 = th;
            new IOException("Attempted read from closed stream.");
            throw th2;
        } else if (this.pos >= this.contentLength) {
            return -1;
        } else {
            if (this.pos + ((long) len) > this.contentLength) {
                len = (int) (this.contentLength - this.pos);
            }
            int count = this.in.read(b, off, len);
            this.pos += (long) count;
            return count;
        }
    }

    public int read(byte[] bArr) throws IOException {
        byte[] b = bArr;
        return read(b, 0, b.length);
    }

    public long skip(long j) throws IOException {
        int l;
        long n = j;
        if (n <= 0) {
            return 0;
        }
        byte[] buffer = new byte[2048];
        long remaining = Math.min(n, this.contentLength - this.pos);
        long count = 0;
        while (remaining > 0 && (l = read(buffer, 0, (int) Math.min(2048, remaining))) != -1) {
            count += (long) l;
            remaining -= (long) l;
        }
        return count;
    }
}
