package org.jose4j.jwt.consumer;

public class InvalidJwtSignatureException extends InvalidJwtException {
    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public InvalidJwtSignatureException(org.jose4j.jws.JsonWebSignature r12, org.jose4j.jwt.consumer.JwtContext r13) {
        /*
            r11 = this;
            r0 = r11
            r1 = r12
            r2 = r13
            r3 = r0
            java.lang.String r4 = "JWT rejected due to invalid signature."
            org.jose4j.jwt.consumer.ErrorCodeValidator$Error r5 = new org.jose4j.jwt.consumer.ErrorCodeValidator$Error
            r10 = r5
            r5 = r10
            r6 = r10
            r7 = 9
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r10 = r8
            r8 = r10
            r9 = r10
            r9.<init>()
            java.lang.String r9 = "Invalid JWS Signature: "
            java.lang.StringBuilder r8 = r8.append(r9)
            r9 = r1
            java.lang.StringBuilder r8 = r8.append(r9)
            java.lang.String r8 = r8.toString()
            r6.<init>(r7, r8)
            java.util.List r5 = java.util.Collections.singletonList(r5)
            r6 = r2
            r3.<init>(r4, r5, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jose4j.jwt.consumer.InvalidJwtSignatureException.<init>(org.jose4j.jws.JsonWebSignature, org.jose4j.jwt.consumer.JwtContext):void");
    }
}
