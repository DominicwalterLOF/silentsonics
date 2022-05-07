package com.microsoft.appcenter.crashes.ingestion.models;

import android.support.annotation.VisibleForTesting;
import android.util.Base64;
import com.microsoft.appcenter.ingestion.models.AbstractLog;
import com.microsoft.appcenter.ingestion.models.CommonProperties;
import com.microsoft.appcenter.ingestion.models.json.JSONUtils;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

public class ErrorAttachmentLog extends AbstractLog {
    @VisibleForTesting
    static final Charset CHARSET = Charset.forName("UTF-8");
    private static final String CONTENT_TYPE = "contentType";
    public static final String CONTENT_TYPE_TEXT_PLAIN = "text/plain";
    @VisibleForTesting
    static final String DATA = "data";
    private static final String ERROR_ID = "errorId";
    private static final String FILE_NAME = "fileName";
    public static final String TYPE = "errorAttachment";
    private String contentType;
    private byte[] data;
    private UUID errorId;
    private String fileName;
    private UUID id;

    public ErrorAttachmentLog() {
    }

    public static ErrorAttachmentLog attachmentWithText(String text, String fileName2) {
        return attachmentWithBinary(text.getBytes(CHARSET), fileName2, "text/plain");
    }

    public static ErrorAttachmentLog attachmentWithBinary(byte[] data2, String fileName2, String contentType2) {
        ErrorAttachmentLog errorAttachmentLog;
        new ErrorAttachmentLog();
        ErrorAttachmentLog attachmentLog = errorAttachmentLog;
        attachmentLog.setData(data2);
        attachmentLog.setFileName(fileName2);
        attachmentLog.setContentType(contentType2);
        return attachmentLog;
    }

    public String getType() {
        return TYPE;
    }

    public UUID getId() {
        return this.id;
    }

    public void setId(UUID id2) {
        UUID uuid = id2;
        this.id = uuid;
    }

    public UUID getErrorId() {
        return this.errorId;
    }

    public void setErrorId(UUID errorId2) {
        UUID uuid = errorId2;
        this.errorId = uuid;
    }

    public String getContentType() {
        return this.contentType;
    }

    public void setContentType(String contentType2) {
        String str = contentType2;
        this.contentType = str;
    }

    public String getFileName() {
        return this.fileName;
    }

    public void setFileName(String fileName2) {
        String str = fileName2;
        this.fileName = str;
    }

    public byte[] getData() {
        return this.data;
    }

    public void setData(byte[] data2) {
        byte[] bArr = data2;
        this.data = bArr;
    }

    public boolean isValid() {
        return (getId() == null || getErrorId() == null || getContentType() == null || getData() == null) ? false : true;
    }

    public void read(JSONObject jSONObject) throws JSONException {
        Throwable th;
        JSONObject object = jSONObject;
        super.read(object);
        setId(UUID.fromString(object.getString(CommonProperties.ID)));
        setErrorId(UUID.fromString(object.getString(ERROR_ID)));
        setContentType(object.getString(CONTENT_TYPE));
        setFileName(object.optString(FILE_NAME, (String) null));
        try {
            setData(Base64.decode(object.getString(DATA), 0));
        } catch (IllegalArgumentException e) {
            IllegalArgumentException e2 = e;
            Throwable th2 = th;
            new JSONException(e2.getMessage());
            throw th2;
        }
    }

    public void write(JSONStringer jSONStringer) throws JSONException {
        JSONStringer writer = jSONStringer;
        super.write(writer);
        JSONUtils.write(writer, CommonProperties.ID, getId());
        JSONUtils.write(writer, ERROR_ID, getErrorId());
        JSONUtils.write(writer, CONTENT_TYPE, getContentType());
        JSONUtils.write(writer, FILE_NAME, getFileName());
        JSONUtils.write(writer, DATA, Base64.encodeToString(getData(), 2));
    }

    public boolean equals(Object obj) {
        Object o = obj;
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        ErrorAttachmentLog that = (ErrorAttachmentLog) o;
        if (this.id == null ? that.id != null : !this.id.equals(that.id)) {
            return false;
        }
        if (this.errorId == null ? that.errorId != null : !this.errorId.equals(that.errorId)) {
            return false;
        }
        if (this.contentType == null ? that.contentType != null : !this.contentType.equals(that.contentType)) {
            return false;
        }
        if (this.fileName == null ? that.fileName != null : !this.fileName.equals(that.fileName)) {
            return false;
        }
        return Arrays.equals(this.data, that.data);
    }

    public int hashCode() {
        return (31 * ((31 * ((31 * ((31 * ((31 * super.hashCode()) + (this.id != null ? this.id.hashCode() : 0))) + (this.errorId != null ? this.errorId.hashCode() : 0))) + (this.contentType != null ? this.contentType.hashCode() : 0))) + (this.fileName != null ? this.fileName.hashCode() : 0))) + Arrays.hashCode(this.data);
    }
}
