package org.jose4j.jwt.consumer;

import org.jose4j.jwt.MalformedClaimException;
import org.jose4j.jwt.consumer.ErrorCodeValidator;

public class JtiValidator implements ErrorCodeValidator {
    private static final ErrorCodeValidator.Error MISSING_JTI;
    private boolean requireJti;

    static {
        ErrorCodeValidator.Error error;
        new ErrorCodeValidator.Error(13, "The JWT ID (jti) claim is not present.");
        MISSING_JTI = error;
    }

    public JtiValidator(boolean requireJti2) {
        this.requireJti = requireJti2;
    }

    public ErrorCodeValidator.Error validate(JwtContext jwtContext) throws MalformedClaimException {
        return (jwtContext.getJwtClaims().getJwtId() != null || !this.requireJti) ? null : MISSING_JTI;
    }
}
