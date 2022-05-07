package org.jose4j.jwt.consumer;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import org.jose4j.jwt.MalformedClaimException;
import org.jose4j.jwt.consumer.ErrorCodeValidator;

public class IssValidator implements ErrorCodeValidator {
    private Set<String> expectedIssuers;
    private boolean requireIssuer;

    public IssValidator(String str, boolean z) {
        String expectedIssuer = str;
        boolean requireIssuer2 = z;
        if (expectedIssuer != null) {
            this.expectedIssuers = Collections.singleton(expectedIssuer);
        }
        this.requireIssuer = requireIssuer2;
    }

    public IssValidator(boolean requireIssuer2, String... strArr) {
        Set<String> set;
        String[] expectedIssuers2 = strArr;
        this.requireIssuer = requireIssuer2;
        if (expectedIssuers2 != null && expectedIssuers2.length > 0) {
            new HashSet();
            this.expectedIssuers = set;
            boolean addAll = Collections.addAll(this.expectedIssuers, expectedIssuers2);
        }
    }

    public ErrorCodeValidator.Error validate(JwtContext jwtContext) throws MalformedClaimException {
        ErrorCodeValidator.Error error;
        StringBuilder sb;
        ErrorCodeValidator.Error error2;
        ErrorCodeValidator.Error error3;
        String issuer = jwtContext.getJwtClaims().getIssuer();
        if (issuer == null) {
            if (this.requireIssuer) {
                error2 = error3;
                new ErrorCodeValidator.Error(11, "No Issuer (iss) claim present.");
            } else {
                error2 = null;
            }
            return error2;
        } else if (this.expectedIssuers == null || this.expectedIssuers.contains(issuer)) {
            return null;
        } else {
            new StringBuilder();
            new ErrorCodeValidator.Error(12, sb.append("Issuer (iss) claim value (").append(issuer).append(") doesn't match expected value of ").append(expectedValue()).toString());
            return error;
        }
    }

    private String expectedValue() {
        StringBuilder sb;
        String sb2;
        if (this.expectedIssuers.size() == 1) {
            sb2 = this.expectedIssuers.iterator().next();
        } else {
            new StringBuilder();
            sb2 = sb.append("one of ").append(this.expectedIssuers).toString();
        }
        return sb2;
    }
}
