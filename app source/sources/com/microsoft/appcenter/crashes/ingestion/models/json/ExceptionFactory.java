package com.microsoft.appcenter.crashes.ingestion.models.json;

import com.microsoft.appcenter.crashes.ingestion.models.Exception;
import com.microsoft.appcenter.ingestion.models.json.ModelFactory;
import java.util.ArrayList;
import java.util.List;

public class ExceptionFactory implements ModelFactory<Exception> {
    private static final ExceptionFactory sInstance;

    static {
        ExceptionFactory exceptionFactory;
        new ExceptionFactory();
        sInstance = exceptionFactory;
    }

    private ExceptionFactory() {
    }

    public static ExceptionFactory getInstance() {
        return sInstance;
    }

    public Exception create() {
        Exception exception;
        new Exception();
        return exception;
    }

    public List<Exception> createList(int capacity) {
        List<Exception> list;
        new ArrayList(capacity);
        return list;
    }
}
