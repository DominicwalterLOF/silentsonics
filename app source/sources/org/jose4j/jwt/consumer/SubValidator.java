package org.jose4j.jwt.consumer;

import org.jose4j.jwt.MalformedClaimException;
import org.jose4j.jwt.consumer.ErrorCodeValidator;

public class SubValidator implements ErrorCodeValidator {
    private static final ErrorCodeValidator.Error MISSING_SUB;
    private String expectedSubject;
    private boolean requireSubject;

    static {
        ErrorCodeValidator.Error error;
        new ErrorCodeValidator.Error(14, "No Subject (sub) claim is present.");
        MISSING_SUB = error;
    }

    public SubValidator(boolean requireSubject2) {
        this.requireSubject = requireSubject2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public SubValidator(String expectedSubject2) {
        this(true);
        this.expectedSubject = expectedSubject2;
    }

    public ErrorCodeValidator.Error validate(JwtContext jwtContext) throws MalformedClaimException {
        StringBuilder sb;
        ErrorCodeValidator.Error error;
        String subject = jwtContext.getJwtClaims().getSubject();
        if (subject == null && this.requireSubject) {
            return MISSING_SUB;
        }
        if (this.expectedSubject == null || this.expectedSubject.equals(subject)) {
            return null;
        }
        new StringBuilder();
        new ErrorCodeValidator.Error(15, sb.append("Subject (sub) claim value (").append(subject).append(") doesn't match expected value of ").append(this.expectedSubject).toString());
        return error;
    }
}
