package org.jose4j.jwt.consumer;

import org.jose4j.jwt.JwtClaims;
import org.jose4j.jwt.MalformedClaimException;
import org.jose4j.jwt.NumericDate;
import org.jose4j.jwt.consumer.ErrorCodeValidator;
import org.jose4j.lang.Maths;

public class NumericDateValidator implements ErrorCodeValidator {
    private static final ErrorCodeValidator.Error MISSING_EXP;
    private static final ErrorCodeValidator.Error MISSING_IAT;
    private static final ErrorCodeValidator.Error MISSING_NBF;
    private int allowedClockSkewSeconds = 0;
    private Integer iatAllowedSecondsInTheFuture;
    private Integer iatAllowedSecondsInThePast;
    private int maxFutureValidityInMinutes = 0;
    private boolean requireExp;
    private boolean requireIat;
    private boolean requireNbf;
    private NumericDate staticEvaluationTime;

    public NumericDateValidator() {
    }

    static {
        ErrorCodeValidator.Error error;
        ErrorCodeValidator.Error error2;
        ErrorCodeValidator.Error error3;
        new ErrorCodeValidator.Error(2, "No Expiration Time (exp) claim present.");
        MISSING_EXP = error;
        new ErrorCodeValidator.Error(3, "No Issued At (iat) claim present.");
        MISSING_IAT = error2;
        new ErrorCodeValidator.Error(4, "No Not Before (nbf) claim present.");
        MISSING_NBF = error3;
    }

    public void setRequireExp(boolean requireExp2) {
        boolean z = requireExp2;
        this.requireExp = z;
    }

    public void setRequireIat(boolean requireIat2) {
        boolean z = requireIat2;
        this.requireIat = z;
    }

    public void setRequireNbf(boolean requireNbf2) {
        boolean z = requireNbf2;
        this.requireNbf = z;
    }

    public void setEvaluationTime(NumericDate evaluationTime) {
        NumericDate numericDate = evaluationTime;
        this.staticEvaluationTime = numericDate;
    }

    public void setAllowedClockSkewSeconds(int allowedClockSkewSeconds2) {
        int i = allowedClockSkewSeconds2;
        this.allowedClockSkewSeconds = i;
    }

    public void setMaxFutureValidityInMinutes(int maxFutureValidityInMinutes2) {
        int i = maxFutureValidityInMinutes2;
        this.maxFutureValidityInMinutes = i;
    }

    public void setIatAllowedSecondsInTheFuture(int iatAllowedSecondsInTheFuture2) {
        Integer valueOf = Integer.valueOf(iatAllowedSecondsInTheFuture2);
        this.iatAllowedSecondsInTheFuture = valueOf;
    }

    public void setIatAllowedSecondsInThePast(int iatAllowedSecondsInThePast2) {
        Integer valueOf = Integer.valueOf(iatAllowedSecondsInThePast2);
        this.iatAllowedSecondsInThePast = valueOf;
    }

    public ErrorCodeValidator.Error validate(JwtContext jwtContext) throws MalformedClaimException {
        StringBuilder sb;
        ErrorCodeValidator.Error error;
        StringBuilder sb2;
        ErrorCodeValidator.Error error2;
        StringBuilder sb3;
        ErrorCodeValidator.Error error3;
        StringBuilder sb4;
        ErrorCodeValidator.Error error4;
        ErrorCodeValidator.Error error5;
        StringBuilder sb5;
        ErrorCodeValidator.Error error6;
        StringBuilder sb6;
        StringBuilder sb7;
        ErrorCodeValidator.Error error7;
        JwtClaims jwtClaims = jwtContext.getJwtClaims();
        NumericDate expirationTime = jwtClaims.getExpirationTime();
        NumericDate issuedAt = jwtClaims.getIssuedAt();
        NumericDate notBefore = jwtClaims.getNotBefore();
        if (this.requireExp && expirationTime == null) {
            return MISSING_EXP;
        }
        if (this.requireIat && issuedAt == null) {
            return MISSING_IAT;
        }
        if (this.requireNbf && notBefore == null) {
            return MISSING_NBF;
        }
        NumericDate evaluationTime = this.staticEvaluationTime == null ? NumericDate.now() : this.staticEvaluationTime;
        if (expirationTime != null) {
            if (Maths.subtract(evaluationTime.getValue(), (long) this.allowedClockSkewSeconds) >= expirationTime.getValue()) {
                new StringBuilder();
                new ErrorCodeValidator.Error(1, sb7.append("The JWT is no longer valid - the evaluation time ").append(evaluationTime).append(" is on or after the Expiration Time (exp=").append(expirationTime).append(") claim value").append(skewMessage()).toString());
                return error7;
            } else if (issuedAt != null && expirationTime.isBefore(issuedAt)) {
                new StringBuilder();
                new ErrorCodeValidator.Error(17, sb6.append("The Expiration Time (exp=").append(expirationTime).append(") claim value cannot be before the Issued At (iat=").append(issuedAt).append(") claim value.").toString());
                return error6;
            } else if (notBefore != null && expirationTime.isBefore(notBefore)) {
                new StringBuilder();
                new ErrorCodeValidator.Error(17, sb5.append("The Expiration Time (exp=").append(expirationTime).append(") claim value cannot be before the Not Before (nbf=").append(notBefore).append(") claim value.").toString());
                return error5;
            } else if (this.maxFutureValidityInMinutes > 0 && Maths.subtract(Maths.subtract(expirationTime.getValue(), (long) this.allowedClockSkewSeconds), evaluationTime.getValue()) > ((long) this.maxFutureValidityInMinutes) * 60) {
                new StringBuilder();
                new ErrorCodeValidator.Error(5, sb4.append("The Expiration Time (exp=").append(expirationTime).append(") claim value cannot be more than ").append(this.maxFutureValidityInMinutes).append(" minutes in the future relative to the evaluation time ").append(evaluationTime).append(skewMessage()).toString());
                return error4;
            }
        }
        if (notBefore == null || Maths.add(evaluationTime.getValue(), (long) this.allowedClockSkewSeconds) >= notBefore.getValue()) {
            if (issuedAt != null) {
                if (this.iatAllowedSecondsInTheFuture != null && Maths.subtract(Maths.subtract(issuedAt.getValue(), evaluationTime.getValue()), (long) this.allowedClockSkewSeconds) > ((long) this.iatAllowedSecondsInTheFuture.intValue())) {
                    new StringBuilder();
                    new ErrorCodeValidator.Error(23, sb2.append("iat ").append(issuedAt).append(" is more than ").append(this.iatAllowedSecondsInTheFuture).append(" second(s) ahead of now ").append(evaluationTime).append(skewMessage()).toString());
                    return error2;
                } else if (this.iatAllowedSecondsInThePast != null && Maths.subtract(Maths.subtract(evaluationTime.getValue(), issuedAt.getValue()), (long) this.allowedClockSkewSeconds) > ((long) this.iatAllowedSecondsInThePast.intValue())) {
                    new StringBuilder();
                    new ErrorCodeValidator.Error(24, sb.append("As of now ").append(evaluationTime).append(" iat ").append(issuedAt).append(" is more than ").append(this.iatAllowedSecondsInThePast).append(" second(s) in the past").append(skewMessage()).toString());
                    return error;
                }
            }
            return null;
        }
        new StringBuilder();
        new ErrorCodeValidator.Error(6, sb3.append("The JWT is not yet valid as the evaluation time ").append(evaluationTime).append(" is before the Not Before (nbf=").append(notBefore).append(") claim time").append(skewMessage()).toString());
        return error3;
    }

    private String skewMessage() {
        StringBuilder sb;
        if (this.allowedClockSkewSeconds <= 0) {
            return ".";
        }
        new StringBuilder();
        return sb.append(" (even when providing ").append(this.allowedClockSkewSeconds).append(" seconds of leeway to account for clock skew).").toString();
    }
}
