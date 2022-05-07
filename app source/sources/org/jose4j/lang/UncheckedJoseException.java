package org.jose4j.lang;

public class UncheckedJoseException extends RuntimeException {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public UncheckedJoseException(String message) {
        super(message);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public UncheckedJoseException(String message, Throwable cause) {
        super(message, cause);
    }
}
