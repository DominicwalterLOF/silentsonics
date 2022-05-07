package org.jose4j.zip;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.Inflater;
import java.util.zip.InflaterInputStream;
import org.jose4j.keys.KeyPersuasion;
import org.jose4j.lang.JoseException;
import org.jose4j.lang.UncheckedJoseException;

public class DeflateRFC1951CompressionAlgorithm implements CompressionAlgorithm {
    public DeflateRFC1951CompressionAlgorithm() {
    }

    public byte[] compress(byte[] bArr) {
        Deflater deflater;
        Throwable th;
        ByteArrayOutputStream byteArrayOutputStream;
        Throwable th2;
        DeflaterOutputStream deflaterOutputStream;
        Throwable th3;
        byte[] byteArray;
        byte[] data = bArr;
        new Deflater(8, true);
        Deflater deflater2 = deflater;
        try {
            ByteArrayOutputStream byteArrayOutputStream2 = byteArrayOutputStream;
            new ByteArrayOutputStream();
            ByteArrayOutputStream byteArrayOutputStream3 = byteArrayOutputStream2;
            try {
                DeflaterOutputStream deflaterOutputStream2 = deflaterOutputStream;
                new DeflaterOutputStream(byteArrayOutputStream3, deflater2);
                DeflaterOutputStream deflaterOutputStream3 = deflaterOutputStream2;
                try {
                    deflaterOutputStream3.write(data);
                    deflaterOutputStream3.finish();
                    byteArray = byteArrayOutputStream3.toByteArray();
                    if (deflaterOutputStream3 != null) {
                        if (0 != 0) {
                            deflaterOutputStream3.close();
                        } else {
                            deflaterOutputStream3.close();
                        }
                    }
                } catch (Throwable th4) {
                    Throwable th5 = th4;
                    if (deflaterOutputStream3 != null) {
                        if (th3 != null) {
                            deflaterOutputStream3.close();
                        } else {
                            deflaterOutputStream3.close();
                        }
                    }
                    throw th5;
                }
            } catch (Throwable th6) {
                Throwable th7 = th6;
                th2 = th7;
                try {
                    throw th7;
                } catch (Throwable th8) {
                    Throwable th9 = th8;
                    if (byteArrayOutputStream3 != null) {
                        if (th2 != null) {
                            byteArrayOutputStream3.close();
                        } else {
                            byteArrayOutputStream3.close();
                        }
                    }
                    throw th9;
                }
            }
            if (byteArrayOutputStream3 != null) {
                if (0 != 0) {
                    try {
                        byteArrayOutputStream3.close();
                    } catch (Throwable th10) {
                        Throwable x2 = th10;
                        Throwable th11 = null;
                        th11.addSuppressed(x2);
                    }
                } else {
                    byteArrayOutputStream3.close();
                }
            }
            deflater2.end();
            return byteArray;
        } catch (IOException e) {
            IOException e2 = e;
            try {
                Throwable th12 = th;
                new UncheckedJoseException("Problem compressing data.", e2);
                throw th12;
            } catch (Throwable th13) {
                Throwable th14 = th13;
                deflater2.end();
                throw th14;
            }
        } catch (Throwable th15) {
            th2.addSuppressed(th15);
        }
    }

    public byte[] decompress(byte[] bArr) throws JoseException {
        Inflater inflater;
        ByteArrayOutputStream byteArrayOutputStream;
        Throwable th;
        InflaterInputStream inflaterInputStream;
        InputStream inputStream;
        Throwable th2;
        byte[] compressedData = bArr;
        new Inflater(true);
        Inflater inflater2 = inflater;
        new ByteArrayOutputStream();
        ByteArrayOutputStream byteArrayOutputStream2 = byteArrayOutputStream;
        try {
            InflaterInputStream inflaterInputStream2 = inflaterInputStream;
            new ByteArrayInputStream(compressedData);
            new InflaterInputStream(inputStream, inflater2);
            InflaterInputStream iis = inflaterInputStream2;
            try {
                byte[] buff = new byte[256];
                while (true) {
                    int read = iis.read(buff);
                    int bytesRead = read;
                    if (read == -1) {
                        break;
                    }
                    byteArrayOutputStream2.write(buff, 0, bytesRead);
                }
                byte[] byteArray = byteArrayOutputStream2.toByteArray();
                if (iis != null) {
                    if (0 != 0) {
                        try {
                            iis.close();
                        } catch (Throwable th3) {
                            Throwable x2 = th3;
                            Throwable th4 = null;
                            th4.addSuppressed(x2);
                        }
                    } else {
                        iis.close();
                    }
                }
                inflater2.end();
                return byteArray;
            } catch (Throwable th5) {
                Throwable th6 = th5;
                if (iis != null) {
                    if (th2 != null) {
                        iis.close();
                    } else {
                        iis.close();
                    }
                }
                throw th6;
            }
        } catch (IOException e) {
            IOException e2 = e;
            Throwable th7 = th;
            new JoseException("Problem decompressing data.", e2);
            throw th7;
        } catch (Throwable th8) {
            Throwable th9 = th8;
            inflater2.end();
            throw th9;
        }
    }

    public String getJavaAlgorithm() {
        return null;
    }

    public String getAlgorithmIdentifier() {
        return CompressionAlgorithmIdentifiers.DEFLATE;
    }

    public KeyPersuasion getKeyPersuasion() {
        return KeyPersuasion.NONE;
    }

    public String getKeyType() {
        return null;
    }

    public boolean isAvailable() {
        return true;
    }
}
