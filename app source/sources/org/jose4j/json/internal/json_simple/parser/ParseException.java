package org.jose4j.json.internal.json_simple.parser;

public class ParseException extends Exception {
    public static final int ERROR_UNEXPECTED_CHAR = 0;
    public static final int ERROR_UNEXPECTED_EXCEPTION = 2;
    public static final int ERROR_UNEXPECTED_TOKEN = 1;
    private static final long serialVersionUID = -7880698968187728547L;
    private int errorType;
    private int position;
    private Object unexpectedObject;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ParseException(int errorType2) {
        this(-1, errorType2, (Object) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ParseException(int errorType2, Object unexpectedObject2) {
        this(-1, errorType2, unexpectedObject2);
    }

    public ParseException(int position2, int errorType2, Object unexpectedObject2) {
        this.position = position2;
        this.errorType = errorType2;
        this.unexpectedObject = unexpectedObject2;
    }

    public int getErrorType() {
        return this.errorType;
    }

    public void setErrorType(int errorType2) {
        int i = errorType2;
        this.errorType = i;
    }

    public int getPosition() {
        return this.position;
    }

    public void setPosition(int position2) {
        int i = position2;
        this.position = i;
    }

    public Object getUnexpectedObject() {
        return this.unexpectedObject;
    }

    public void setUnexpectedObject(Object unexpectedObject2) {
        Object obj = unexpectedObject2;
        this.unexpectedObject = obj;
    }

    public String getMessage() {
        StringBuilder sb;
        new StringBuilder();
        StringBuilder sb2 = sb;
        switch (this.errorType) {
            case 0:
                StringBuilder append = sb2.append("Unexpected character (").append(this.unexpectedObject).append(") at position ").append(this.position).append(".");
                break;
            case 1:
                StringBuilder append2 = sb2.append("Unexpected token ").append(this.unexpectedObject).append(" at position ").append(this.position).append(".");
                break;
            case 2:
                StringBuilder append3 = sb2.append("Unexpected exception at position ").append(this.position).append(": ").append(this.unexpectedObject);
                break;
            default:
                StringBuilder append4 = sb2.append("Unknown error at position ").append(this.position).append(".");
                break;
        }
        return sb2.toString();
    }
}
