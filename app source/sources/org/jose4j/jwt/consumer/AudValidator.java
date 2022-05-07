package org.jose4j.jwt.consumer;

import java.util.List;
import java.util.Set;
import org.jose4j.jwt.JwtClaims;
import org.jose4j.jwt.MalformedClaimException;
import org.jose4j.jwt.consumer.ErrorCodeValidator;

public class AudValidator implements ErrorCodeValidator {
    private static final ErrorCodeValidator.Error MISSING_AUD;
    private Set<String> acceptableAudiences;
    private boolean requireAudience;

    static {
        ErrorCodeValidator.Error error;
        new ErrorCodeValidator.Error(7, "No Audience (aud) claim present.");
        MISSING_AUD = error;
    }

    public AudValidator(Set<String> acceptableAudiences2, boolean requireAudience2) {
        this.acceptableAudiences = acceptableAudiences2;
        this.requireAudience = requireAudience2;
    }

    public ErrorCodeValidator.Error validate(JwtContext jwtContext) throws MalformedClaimException {
        StringBuilder sb;
        ErrorCodeValidator.Error error;
        ErrorCodeValidator.Error error2;
        JwtClaims jwtClaims = jwtContext.getJwtClaims();
        if (!jwtClaims.hasAudience()) {
            if (this.requireAudience) {
                error2 = MISSING_AUD;
            } else {
                error2 = null;
            }
            return error2;
        }
        List<String> audiences = jwtClaims.getAudience();
        boolean ok = false;
        for (String audience : audiences) {
            if (this.acceptableAudiences.contains(audience)) {
                ok = true;
            }
        }
        if (ok) {
            return null;
        }
        new StringBuilder();
        StringBuilder sb2 = sb;
        StringBuilder append = sb2.append("Audience (aud) claim ").append(audiences);
        if (this.acceptableAudiences.isEmpty()) {
            StringBuilder append2 = sb2.append(" present in the JWT but no expected audience value(s) were provided to the JWT Consumer.");
        } else {
            StringBuilder append3 = sb2.append(" doesn't contain an acceptable identifier.");
        }
        StringBuilder append4 = sb2.append(" Expected ");
        if (this.acceptableAudiences.size() == 1) {
            StringBuilder append5 = sb2.append(this.acceptableAudiences.iterator().next());
        } else {
            StringBuilder append6 = sb2.append("one of ").append(this.acceptableAudiences);
        }
        StringBuilder append7 = sb2.append(" as an aud value.");
        new ErrorCodeValidator.Error(8, sb2.toString());
        return error;
    }
}
