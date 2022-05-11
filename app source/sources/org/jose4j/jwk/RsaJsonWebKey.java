package org.jose4j.jwk;

import java.security.PublicKey;
import java.security.interfaces.RSAPrivateCrtKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.Map;
import org.jose4j.lang.JoseException;

public class RsaJsonWebKey extends PublicJsonWebKey {
    public static final String EXPONENT_MEMBER_NAME = "e";
    public static final String FACTOR_CRT_COEFFICIENT = "t";
    public static final String FACTOR_CRT_EXPONENT_OTHER_MEMBER_NAME = "d";
    public static final String FIRST_CRT_COEFFICIENT_MEMBER_NAME = "qi";
    public static final String FIRST_FACTOR_CRT_EXPONENT_MEMBER_NAME = "dp";
    public static final String FIRST_PRIME_FACTOR_MEMBER_NAME = "p";
    public static final String KEY_TYPE = "RSA";
    public static final String MODULUS_MEMBER_NAME = "n";
    public static final String OTHER_PRIMES_INFO_MEMBER_NAME = "oth";
    public static final String PRIME_FACTOR_OTHER_MEMBER_NAME = "r";
    public static final String PRIVATE_EXPONENT_MEMBER_NAME = "d";
    public static final String SECOND_FACTOR_CRT_EXPONENT_MEMBER_NAME = "dq";
    public static final String SECOND_PRIME_FACTOR_MEMBER_NAME = "q";

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RsaJsonWebKey(RSAPublicKey publicKey) {
        super((PublicKey) publicKey);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public RsaJsonWebKey(Map<String, Object> params) throws JoseException {
        this(params, (String) null);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public RsaJsonWebKey(java.util.Map<java.lang.String, java.lang.Object> r24, java.lang.String r25) throws org.jose4j.lang.JoseException {
        /*
            r23 = this;
            r0 = r23
            r1 = r24
            r2 = r25
            r12 = r0
            r13 = r1
            r14 = r2
            r12.<init>(r13, r14)
            r12 = r0
            r13 = r1
            java.lang.String r14 = "n"
            r15 = 1
            java.math.BigInteger r12 = r12.getBigIntFromBase64UrlEncodedParam(r13, r14, r15)
            r3 = r12
            r12 = r0
            r13 = r1
            java.lang.String r14 = "e"
            r15 = 1
            java.math.BigInteger r12 = r12.getBigIntFromBase64UrlEncodedParam(r13, r14, r15)
            r4 = r12
            org.jose4j.keys.RsaKeyUtil r12 = new org.jose4j.keys.RsaKeyUtil
            r22 = r12
            r12 = r22
            r13 = r22
            r14 = r2
            r15 = 0
            r13.<init>(r14, r15)
            r5 = r12
            r12 = r0
            r13 = r5
            r14 = r3
            r15 = r4
            java.security.interfaces.RSAPublicKey r13 = r13.publicKey(r14, r15)
            r12.key = r13
            r12 = r0
            r12.checkForBareKeyCertMismatch()
            r12 = r1
            java.lang.String r13 = "d"
            boolean r12 = r12.containsKey(r13)
            if (r12 == 0) goto L_0x00aa
            r12 = r0
            r13 = r1
            java.lang.String r14 = "d"
            r15 = 0
            java.math.BigInteger r12 = r12.getBigIntFromBase64UrlEncodedParam(r13, r14, r15)
            r6 = r12
            r12 = r1
            java.lang.String r13 = "p"
            boolean r12 = r12.containsKey(r13)
            if (r12 == 0) goto L_0x0113
            r12 = r0
            r13 = r1
            java.lang.String r14 = "p"
            r15 = 0
            java.math.BigInteger r12 = r12.getBigIntFromBase64UrlEncodedParam(r13, r14, r15)
            r7 = r12
            r12 = r0
            r13 = r1
            java.lang.String r14 = "q"
            r15 = 0
            java.math.BigInteger r12 = r12.getBigIntFromBase64UrlEncodedParam(r13, r14, r15)
            r8 = r12
            r12 = r0
            r13 = r1
            java.lang.String r14 = "dp"
            r15 = 0
            java.math.BigInteger r12 = r12.getBigIntFromBase64UrlEncodedParam(r13, r14, r15)
            r9 = r12
            r12 = r0
            r13 = r1
            java.lang.String r14 = "dq"
            r15 = 0
            java.math.BigInteger r12 = r12.getBigIntFromBase64UrlEncodedParam(r13, r14, r15)
            r10 = r12
            r12 = r0
            r13 = r1
            java.lang.String r14 = "qi"
            r15 = 0
            java.math.BigInteger r12 = r12.getBigIntFromBase64UrlEncodedParam(r13, r14, r15)
            r11 = r12
            r12 = r0
            r13 = r5
            r14 = r3
            r15 = r4
            r16 = r6
            r17 = r7
            r18 = r8
            r19 = r9
            r20 = r10
            r21 = r11
            java.security.interfaces.RSAPrivateKey r13 = r13.privateKey(r14, r15, r16, r17, r18, r19, r20, r21)
            r12.privateKey = r13
        L_0x00aa:
            r12 = r0
            r13 = 8
            java.lang.String[] r13 = new java.lang.String[r13]
            r22 = r13
            r13 = r22
            r14 = r22
            r15 = 0
            java.lang.String r16 = "n"
            r14[r15] = r16
            r22 = r13
            r13 = r22
            r14 = r22
            r15 = 1
            java.lang.String r16 = "e"
            r14[r15] = r16
            r22 = r13
            r13 = r22
            r14 = r22
            r15 = 2
            java.lang.String r16 = "d"
            r14[r15] = r16
            r22 = r13
            r13 = r22
            r14 = r22
            r15 = 3
            java.lang.String r16 = "p"
            r14[r15] = r16
            r22 = r13
            r13 = r22
            r14 = r22
            r15 = 4
            java.lang.String r16 = "q"
            r14[r15] = r16
            r22 = r13
            r13 = r22
            r14 = r22
            r15 = 5
            java.lang.String r16 = "dp"
            r14[r15] = r16
            r22 = r13
            r13 = r22
            r14 = r22
            r15 = 6
            java.lang.String r16 = "dq"
            r14[r15] = r16
            r22 = r13
            r13 = r22
            r14 = r22
            r15 = 7
            java.lang.String r16 = "qi"
            r14[r15] = r16
            r12.removeFromOtherParams(r13)
            return
        L_0x0113:
            r12 = r0
            r13 = r5
            r14 = r3
            r15 = r6
            java.security.interfaces.RSAPrivateKey r13 = r13.privateKey(r14, r15)
            r12.privateKey = r13
            goto L_0x00aa
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jose4j.jwk.RsaJsonWebKey.<init>(java.util.Map, java.lang.String):void");
    }

    public String getKeyType() {
        return "RSA";
    }

    public RSAPublicKey getRsaPublicKey() {
        return (RSAPublicKey) this.key;
    }

    public RSAPublicKey getRSAPublicKey() {
        return getRsaPublicKey();
    }

    public RSAPrivateKey getRsaPrivateKey() {
        return (RSAPrivateKey) this.privateKey;
    }

    /* access modifiers changed from: protected */
    public void fillPublicTypeSpecificParams(Map<String, Object> map) {
        Map<String, Object> params = map;
        RSAPublicKey rsaPublicKey = getRsaPublicKey();
        putBigIntAsBase64UrlEncodedParam(params, MODULUS_MEMBER_NAME, rsaPublicKey.getModulus());
        putBigIntAsBase64UrlEncodedParam(params, EXPONENT_MEMBER_NAME, rsaPublicKey.getPublicExponent());
    }

    /* access modifiers changed from: protected */
    public void fillPrivateTypeSpecificParams(Map<String, Object> map) {
        Map<String, Object> params = map;
        RSAPrivateKey rsaPrivateKey = getRsaPrivateKey();
        if (rsaPrivateKey != null) {
            putBigIntAsBase64UrlEncodedParam(params, "d", rsaPrivateKey.getPrivateExponent());
            if (rsaPrivateKey instanceof RSAPrivateCrtKey) {
                RSAPrivateCrtKey crt = (RSAPrivateCrtKey) rsaPrivateKey;
                putBigIntAsBase64UrlEncodedParam(params, FIRST_PRIME_FACTOR_MEMBER_NAME, crt.getPrimeP());
                putBigIntAsBase64UrlEncodedParam(params, SECOND_PRIME_FACTOR_MEMBER_NAME, crt.getPrimeQ());
                putBigIntAsBase64UrlEncodedParam(params, FIRST_FACTOR_CRT_EXPONENT_MEMBER_NAME, crt.getPrimeExponentP());
                putBigIntAsBase64UrlEncodedParam(params, SECOND_FACTOR_CRT_EXPONENT_MEMBER_NAME, crt.getPrimeExponentQ());
                putBigIntAsBase64UrlEncodedParam(params, FIRST_CRT_COEFFICIENT_MEMBER_NAME, crt.getCrtCoefficient());
            }
        }
    }

    /*  JADX ERROR: NullPointerException in pass: CodeShrinkVisitor
        java.lang.NullPointerException
        */
    protected java.lang.String produceThumbprintHashInput() {
        /*
            r10 = this;
            r0 = r10
            java.lang.String r3 = "{\"e\":\"%s\",\"kty\":\"RSA\",\"n\":\"%s\"}"
            r1 = r3
            java.util.HashMap r3 = new java.util.HashMap
            r9 = r3
            r3 = r9
            r4 = r9
            r4.<init>()
            r2 = r3
            r3 = r0
            r4 = r2
            r3.fillPublicTypeSpecificParams(r4)
            r3 = r1
            r4 = 2
            java.lang.Object[] r4 = new java.lang.Object[r4]
            r9 = r4
            r4 = r9
            r5 = r9
            r6 = 0
            r7 = r2
            java.lang.String r8 = "e"
            java.lang.Object r7 = r7.get(r8)
            r5[r6] = r7
            r9 = r4
            r4 = r9
            r5 = r9
            r6 = 1
            r7 = r2
            java.lang.String r8 = "n"
            java.lang.Object r7 = r7.get(r8)
            r5[r6] = r7
            java.lang.String r3 = java.lang.String.format(r3, r4)
            r0 = r3
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jose4j.jwk.RsaJsonWebKey.produceThumbprintHashInput():java.lang.String");
    }
}
