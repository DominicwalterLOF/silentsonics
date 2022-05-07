package org.jose4j.jwt;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class ReservedClaimNames {
    public static final String AUDIENCE = "aud";
    public static final String EXPIRATION_TIME = "exp";
    public static final Set<String> INITIAL_REGISTERED_CLAIM_NAMES;
    public static final String ISSUED_AT = "iat";
    public static final String ISSUER = "iss";
    public static final String JWT_ID = "jti";
    public static final String NOT_BEFORE = "nbf";
    public static final String SUBJECT = "sub";
    public static final String TYPE = "typ";

    public ReservedClaimNames() {
    }

    static {
        Set set;
        Set set2 = set;
        String[] strArr = new String[7];
        strArr[0] = ISSUER;
        String[] strArr2 = strArr;
        strArr2[1] = SUBJECT;
        String[] strArr3 = strArr2;
        strArr3[2] = AUDIENCE;
        String[] strArr4 = strArr3;
        strArr4[3] = EXPIRATION_TIME;
        String[] strArr5 = strArr4;
        strArr5[4] = NOT_BEFORE;
        String[] strArr6 = strArr5;
        strArr6[5] = ISSUED_AT;
        String[] strArr7 = strArr6;
        strArr7[6] = JWT_ID;
        new HashSet(Arrays.asList(strArr7));
        INITIAL_REGISTERED_CLAIM_NAMES = Collections.unmodifiableSet(set2);
    }
}
