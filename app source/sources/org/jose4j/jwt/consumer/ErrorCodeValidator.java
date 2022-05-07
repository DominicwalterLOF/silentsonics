package org.jose4j.jwt.consumer;

import org.jose4j.jwt.MalformedClaimException;

public interface ErrorCodeValidator {
    Error validate(JwtContext jwtContext) throws MalformedClaimException;

    public static class Error {
        private int errorCode;
        private String errorMessage;

        public Error(int errorCode2, String errorMessage2) {
            this.errorCode = errorCode2;
            this.errorMessage = errorMessage2;
        }

        public int getErrorCode() {
            return this.errorCode;
        }

        public String getErrorMessage() {
            return this.errorMessage;
        }

        public String toString() {
            StringBuilder sb;
            new StringBuilder();
            return sb.append("[").append(this.errorCode).append("] ").append(this.errorMessage).toString();
        }
    }
}
