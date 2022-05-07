package com.microsoft.appcenter.crashes.ingestion.models.json;

import com.microsoft.appcenter.crashes.ingestion.models.Thread;
import com.microsoft.appcenter.ingestion.models.json.ModelFactory;
import java.util.ArrayList;
import java.util.List;

public class ThreadFactory implements ModelFactory<Thread> {
    private static final ThreadFactory sInstance;

    static {
        ThreadFactory threadFactory;
        new ThreadFactory();
        sInstance = threadFactory;
    }

    private ThreadFactory() {
    }

    public static ThreadFactory getInstance() {
        return sInstance;
    }

    public Thread create() {
        Thread thread;
        new Thread();
        return thread;
    }

    public List<Thread> createList(int capacity) {
        List<Thread> list;
        new ArrayList(capacity);
        return list;
    }
}
