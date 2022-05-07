package com.microsoft.appcenter.crashes.ingestion.models.json;

import com.microsoft.appcenter.crashes.ingestion.models.ErrorAttachmentLog;
import com.microsoft.appcenter.ingestion.models.json.AbstractLogFactory;

public class ErrorAttachmentLogFactory extends AbstractLogFactory {
    private static final ErrorAttachmentLogFactory sInstance;

    static {
        ErrorAttachmentLogFactory errorAttachmentLogFactory;
        new ErrorAttachmentLogFactory();
        sInstance = errorAttachmentLogFactory;
    }

    private ErrorAttachmentLogFactory() {
    }

    public static ErrorAttachmentLogFactory getInstance() {
        return sInstance;
    }

    public ErrorAttachmentLog create() {
        ErrorAttachmentLog errorAttachmentLog;
        new ErrorAttachmentLog();
        return errorAttachmentLog;
    }
}
