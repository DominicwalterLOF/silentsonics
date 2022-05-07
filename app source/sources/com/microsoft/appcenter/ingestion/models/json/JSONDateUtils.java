package com.microsoft.appcenter.ingestion.models.json;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import org.json.JSONException;

public final class JSONDateUtils {
    private static final ThreadLocal<DateFormat> DATE_FORMAT;

    public JSONDateUtils() {
    }

    static {
        ThreadLocal<DateFormat> threadLocal;
        new ThreadLocal<DateFormat>() {
            /* access modifiers changed from: protected */
            public DateFormat initialValue() {
                DateFormat dateFormat;
                new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.US);
                DateFormat dateFormat2 = dateFormat;
                dateFormat2.setTimeZone(TimeZone.getTimeZone("UTC"));
                return dateFormat2;
            }
        };
        DATE_FORMAT = threadLocal;
    }

    private static void checkNull(Object date) throws JSONException {
        Throwable th;
        if (date == null) {
            Throwable th2 = th;
            new JSONException("date cannot be null");
            throw th2;
        }
    }

    public static String toString(Date date) throws JSONException {
        Date date2 = date;
        checkNull(date2);
        return DATE_FORMAT.get().format(date2);
    }

    public static Date toDate(String str) throws JSONException {
        Throwable th;
        String date = str;
        checkNull(date);
        try {
            return DATE_FORMAT.get().parse(date);
        } catch (ParseException e) {
            ParseException e2 = e;
            Throwable th2 = th;
            new JSONException(e2.getMessage());
            throw th2;
        }
    }
}
