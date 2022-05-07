package org.jose4j.jwt.consumer;

import java.util.Collections;
import java.util.List;
import org.jose4j.jwt.consumer.ErrorCodeValidator;

public class InvalidJwtException extends Exception {
    private List<ErrorCodeValidator.Error> details = Collections.emptyList();
    private JwtContext jwtContext;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public InvalidJwtException(String message, List<ErrorCodeValidator.Error> details2, JwtContext jwtContext2) {
        super(message);
        this.details = details2;
        this.jwtContext = jwtContext2;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public InvalidJwtException(String message, ErrorCodeValidator.Error detail, Throwable cause, JwtContext jwtContext2) {
        super(message, cause);
        this.jwtContext = jwtContext2;
        this.details = Collections.singletonList(detail);
    }

    public boolean hasErrorCode(int i) {
        int code = i;
        for (ErrorCodeValidator.Error error : this.details) {
            if (code == error.getErrorCode()) {
                return true;
            }
        }
        return false;
    }

    public boolean hasExpired() {
        return hasErrorCode(1);
    }

    public List<ErrorCodeValidator.Error> getErrorDetails() {
        return this.details;
    }

    public JwtContext getJwtContext() {
        return this.jwtContext;
    }

    public String getMessage() {
        StringBuilder sb;
        new StringBuilder();
        StringBuilder sb2 = sb;
        StringBuilder append = sb2.append(super.getMessage());
        if (!this.details.isEmpty()) {
            StringBuilder append2 = sb2.append(" Additional details: ");
            StringBuilder append3 = sb2.append(this.details);
        }
        return sb2.toString();
    }
}
