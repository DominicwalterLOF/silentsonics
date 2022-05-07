package org.jose4j.json.internal.json_simple;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collection;

public class JSONArray extends ArrayList implements JSONAware, JSONStreamAware {
    private static final long serialVersionUID = 3957988303675231981L;

    public JSONArray() {
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public JSONArray(Collection c) {
        super(c);
    }

    public static void writeJSONString(Collection collection, Writer writer) throws IOException {
        Collection collection2 = collection;
        Writer out = writer;
        if (collection2 == null) {
            out.write("null");
            return;
        }
        boolean first = true;
        out.write(91);
        for (Object value : collection2) {
            if (first) {
                first = false;
            } else {
                out.write(44);
            }
            if (value == null) {
                out.write("null");
            } else {
                JSONValue.writeJSONString(value, out);
            }
        }
        out.write(93);
    }

    public void writeJSONString(Writer out) throws IOException {
        writeJSONString((Collection) this, out);
    }

    public static String toJSONString(Collection collection) {
        StringWriter stringWriter;
        Throwable th;
        new StringWriter();
        StringWriter writer = stringWriter;
        try {
            writeJSONString(collection, (Writer) writer);
            return writer.toString();
        } catch (IOException e) {
            IOException e2 = e;
            Throwable th2 = th;
            new RuntimeException(e2);
            throw th2;
        }
    }

    public static void writeJSONString(byte[] bArr, Writer writer) throws IOException {
        byte[] array = bArr;
        Writer out = writer;
        if (array == null) {
            out.write("null");
        } else if (array.length == 0) {
            out.write("[]");
        } else {
            out.write("[");
            out.write(String.valueOf(array[0]));
            for (int i = 1; i < array.length; i++) {
                out.write(",");
                out.write(String.valueOf(array[i]));
            }
            out.write("]");
        }
    }

    public static String toJSONString(byte[] array) {
        StringWriter stringWriter;
        Throwable th;
        new StringWriter();
        StringWriter writer = stringWriter;
        try {
            writeJSONString(array, (Writer) writer);
            return writer.toString();
        } catch (IOException e) {
            IOException e2 = e;
            Throwable th2 = th;
            new RuntimeException(e2);
            throw th2;
        }
    }

    public static void writeJSONString(short[] sArr, Writer writer) throws IOException {
        short[] array = sArr;
        Writer out = writer;
        if (array == null) {
            out.write("null");
        } else if (array.length == 0) {
            out.write("[]");
        } else {
            out.write("[");
            out.write(String.valueOf(array[0]));
            for (int i = 1; i < array.length; i++) {
                out.write(",");
                out.write(String.valueOf(array[i]));
            }
            out.write("]");
        }
    }

    public static String toJSONString(short[] array) {
        StringWriter stringWriter;
        Throwable th;
        new StringWriter();
        StringWriter writer = stringWriter;
        try {
            writeJSONString(array, (Writer) writer);
            return writer.toString();
        } catch (IOException e) {
            IOException e2 = e;
            Throwable th2 = th;
            new RuntimeException(e2);
            throw th2;
        }
    }

    public static void writeJSONString(int[] iArr, Writer writer) throws IOException {
        int[] array = iArr;
        Writer out = writer;
        if (array == null) {
            out.write("null");
        } else if (array.length == 0) {
            out.write("[]");
        } else {
            out.write("[");
            out.write(String.valueOf(array[0]));
            for (int i = 1; i < array.length; i++) {
                out.write(",");
                out.write(String.valueOf(array[i]));
            }
            out.write("]");
        }
    }

    public static String toJSONString(int[] array) {
        StringWriter stringWriter;
        Throwable th;
        new StringWriter();
        StringWriter writer = stringWriter;
        try {
            writeJSONString(array, (Writer) writer);
            return writer.toString();
        } catch (IOException e) {
            IOException e2 = e;
            Throwable th2 = th;
            new RuntimeException(e2);
            throw th2;
        }
    }

    public static void writeJSONString(long[] jArr, Writer writer) throws IOException {
        long[] array = jArr;
        Writer out = writer;
        if (array == null) {
            out.write("null");
        } else if (array.length == 0) {
            out.write("[]");
        } else {
            out.write("[");
            out.write(String.valueOf(array[0]));
            for (int i = 1; i < array.length; i++) {
                out.write(",");
                out.write(String.valueOf(array[i]));
            }
            out.write("]");
        }
    }

    public static String toJSONString(long[] array) {
        StringWriter stringWriter;
        Throwable th;
        new StringWriter();
        StringWriter writer = stringWriter;
        try {
            writeJSONString(array, (Writer) writer);
            return writer.toString();
        } catch (IOException e) {
            IOException e2 = e;
            Throwable th2 = th;
            new RuntimeException(e2);
            throw th2;
        }
    }

    public static void writeJSONString(float[] fArr, Writer writer) throws IOException {
        float[] array = fArr;
        Writer out = writer;
        if (array == null) {
            out.write("null");
        } else if (array.length == 0) {
            out.write("[]");
        } else {
            out.write("[");
            out.write(String.valueOf(array[0]));
            for (int i = 1; i < array.length; i++) {
                out.write(",");
                out.write(String.valueOf(array[i]));
            }
            out.write("]");
        }
    }

    public static String toJSONString(float[] array) {
        StringWriter stringWriter;
        Throwable th;
        new StringWriter();
        StringWriter writer = stringWriter;
        try {
            writeJSONString(array, (Writer) writer);
            return writer.toString();
        } catch (IOException e) {
            IOException e2 = e;
            Throwable th2 = th;
            new RuntimeException(e2);
            throw th2;
        }
    }

    public static void writeJSONString(double[] dArr, Writer writer) throws IOException {
        double[] array = dArr;
        Writer out = writer;
        if (array == null) {
            out.write("null");
        } else if (array.length == 0) {
            out.write("[]");
        } else {
            out.write("[");
            out.write(String.valueOf(array[0]));
            for (int i = 1; i < array.length; i++) {
                out.write(",");
                out.write(String.valueOf(array[i]));
            }
            out.write("]");
        }
    }

    public static String toJSONString(double[] array) {
        StringWriter stringWriter;
        Throwable th;
        new StringWriter();
        StringWriter writer = stringWriter;
        try {
            writeJSONString(array, (Writer) writer);
            return writer.toString();
        } catch (IOException e) {
            IOException e2 = e;
            Throwable th2 = th;
            new RuntimeException(e2);
            throw th2;
        }
    }

    public static void writeJSONString(boolean[] zArr, Writer writer) throws IOException {
        boolean[] array = zArr;
        Writer out = writer;
        if (array == null) {
            out.write("null");
        } else if (array.length == 0) {
            out.write("[]");
        } else {
            out.write("[");
            out.write(String.valueOf(array[0]));
            for (int i = 1; i < array.length; i++) {
                out.write(",");
                out.write(String.valueOf(array[i]));
            }
            out.write("]");
        }
    }

    public static String toJSONString(boolean[] array) {
        StringWriter stringWriter;
        Throwable th;
        new StringWriter();
        StringWriter writer = stringWriter;
        try {
            writeJSONString(array, (Writer) writer);
            return writer.toString();
        } catch (IOException e) {
            IOException e2 = e;
            Throwable th2 = th;
            new RuntimeException(e2);
            throw th2;
        }
    }

    public static void writeJSONString(char[] cArr, Writer writer) throws IOException {
        char[] array = cArr;
        Writer out = writer;
        if (array == null) {
            out.write("null");
        } else if (array.length == 0) {
            out.write("[]");
        } else {
            out.write("[\"");
            out.write(JSONValue.escape(String.valueOf(array[0])));
            for (int i = 1; i < array.length; i++) {
                out.write("\",\"");
                out.write(JSONValue.escape(String.valueOf(array[i])));
            }
            out.write("\"]");
        }
    }

    public static String toJSONString(char[] array) {
        StringWriter stringWriter;
        Throwable th;
        new StringWriter();
        StringWriter writer = stringWriter;
        try {
            writeJSONString(array, (Writer) writer);
            return writer.toString();
        } catch (IOException e) {
            IOException e2 = e;
            Throwable th2 = th;
            new RuntimeException(e2);
            throw th2;
        }
    }

    public static void writeJSONString(Object[] objArr, Writer writer) throws IOException {
        Object[] array = objArr;
        Writer out = writer;
        if (array == null) {
            out.write("null");
        } else if (array.length == 0) {
            out.write("[]");
        } else {
            out.write("[");
            JSONValue.writeJSONString(array[0], out);
            for (int i = 1; i < array.length; i++) {
                out.write(",");
                JSONValue.writeJSONString(array[i], out);
            }
            out.write("]");
        }
    }

    public static String toJSONString(Object[] array) {
        StringWriter stringWriter;
        Throwable th;
        new StringWriter();
        StringWriter writer = stringWriter;
        try {
            writeJSONString(array, (Writer) writer);
            return writer.toString();
        } catch (IOException e) {
            IOException e2 = e;
            Throwable th2 = th;
            new RuntimeException(e2);
            throw th2;
        }
    }

    public String toJSONString() {
        return toJSONString((Collection) this);
    }

    public String toString() {
        return toJSONString();
    }
}
