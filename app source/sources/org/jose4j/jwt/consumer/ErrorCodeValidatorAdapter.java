package org.jose4j.jwt.consumer;

import org.jose4j.jwt.MalformedClaimException;
import org.jose4j.jwt.consumer.ErrorCodeValidator;

public class ErrorCodeValidatorAdapter implements ErrorCodeValidator {
    private Validator validator;

    public ErrorCodeValidatorAdapter(Validator validator2) {
        this.validator = validator2;
    }

    public ErrorCodeValidator.Error validate(JwtContext jwtContext) throws MalformedClaimException {
        ErrorCodeValidator.Error error;
        ErrorCodeValidator.Error error2;
        String result = this.validator.validate(jwtContext);
        if (result == null) {
            error2 = null;
        } else {
            error2 = error;
            new ErrorCodeValidator.Error(17, result);
        }
        return error2;
    }
}
