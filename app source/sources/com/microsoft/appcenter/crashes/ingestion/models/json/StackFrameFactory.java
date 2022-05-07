package com.microsoft.appcenter.crashes.ingestion.models.json;

import com.microsoft.appcenter.crashes.ingestion.models.StackFrame;
import com.microsoft.appcenter.ingestion.models.json.ModelFactory;
import java.util.ArrayList;
import java.util.List;

public class StackFrameFactory implements ModelFactory<StackFrame> {
    private static final StackFrameFactory sInstance;

    static {
        StackFrameFactory stackFrameFactory;
        new StackFrameFactory();
        sInstance = stackFrameFactory;
    }

    private StackFrameFactory() {
    }

    public static StackFrameFactory getInstance() {
        return sInstance;
    }

    public StackFrame create() {
        StackFrame stackFrame;
        new StackFrame();
        return stackFrame;
    }

    public List<StackFrame> createList(int capacity) {
        List<StackFrame> list;
        new ArrayList(capacity);
        return list;
    }
}
