package org.jose4j.jwt.consumer;

import javax.activation.MimeType;
import javax.activation.MimeTypeParseException;
import org.jose4j.jwt.consumer.ErrorCodeValidator;
import org.jose4j.lang.UncheckedJoseException;
import org.slf4j.Marker;

public class TypeValidator implements ErrorCodeValidator {
    private static final String APPLICATION_PRIMARY_TYPE = "application";
    private MimeType expectedType;
    private boolean requireType;

    public TypeValidator(boolean z, String str) {
        Throwable th;
        StringBuilder sb;
        Throwable th2;
        boolean requireType2 = z;
        String expectedType2 = str;
        try {
            this.expectedType = toMediaType(expectedType2);
            if (this.expectedType.getSubType().equals(Marker.ANY_MARKER)) {
                Throwable th3 = th2;
                new MimeTypeParseException("cannot use wildcard in subtype");
                throw th3;
            }
            this.requireType = requireType2;
        } catch (MimeTypeParseException e) {
            MimeTypeParseException e2 = e;
            Throwable th4 = th;
            new StringBuilder();
            new UncheckedJoseException(sb.append("The given expected type '").append(expectedType2).append("' isn't a valid media type in this context.").toString(), e2);
            throw th4;
        }
    }

    public ErrorCodeValidator.Error validate(JwtContext jwtContext) {
        return validate(jwtContext.getJoseObjects().get(0).getHeader("typ"));
    }

    /* access modifiers changed from: package-private */
    public ErrorCodeValidator.Error validate(String str) {
        ErrorCodeValidator.Error error;
        StringBuilder sb;
        StringBuilder sb2;
        ErrorCodeValidator.Error error2;
        ErrorCodeValidator.Error error3;
        ErrorCodeValidator.Error error4;
        String type = str;
        if (type == null) {
            if (this.requireType) {
                error3 = error4;
                new ErrorCodeValidator.Error(21, "No typ header parameter present in the innermost JWS/JWE");
            } else {
                error3 = null;
            }
            return error3;
        }
        if (this.expectedType != null) {
            try {
                MimeType mediaType = toMediaType(type);
                if (!this.expectedType.match(mediaType) || mediaType.getSubType().equals(Marker.ANY_MARKER)) {
                    new StringBuilder();
                    StringBuilder msg = sb2;
                    StringBuilder append = msg.append("Invalid typ header parameter value '").append(type).append("'. Expecting '");
                    StringBuilder append2 = msg.append(this.expectedType).append("'");
                    if (this.expectedType.getPrimaryType().equals(APPLICATION_PRIMARY_TYPE)) {
                        StringBuilder append3 = msg.append(" or just '").append(this.expectedType.getSubType()).append("'");
                    }
                    StringBuilder append4 = msg.append(".");
                    ErrorCodeValidator.Error error5 = error2;
                    new ErrorCodeValidator.Error(22, msg.toString());
                    return error5;
                }
            } catch (MimeTypeParseException e) {
                new StringBuilder();
                new ErrorCodeValidator.Error(22, sb.append("typ header parameter value '").append(type).append("' not parsable as a media type ").append(e).toString());
                return error;
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public MimeType toMediaType(String str) throws MimeTypeParseException {
        MimeType mimeType;
        MimeType mimeType2;
        MimeType mimeType3;
        String type = str;
        if (type.contains("/")) {
            mimeType2 = mimeType3;
            new MimeType(type);
        } else {
            mimeType2 = mimeType;
            new MimeType(APPLICATION_PRIMARY_TYPE, type);
        }
        return mimeType2;
    }
}
