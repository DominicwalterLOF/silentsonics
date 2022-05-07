package org.jose4j.jwk;

import java.util.Map;
import org.jose4j.base64url.Base64Url;
import org.jose4j.jwk.JsonWebKey;

public class OctetSequenceJsonWebKey extends JsonWebKey {
    public static final String KEY_TYPE = "oct";
    public static final String KEY_VALUE_MEMBER_NAME = "k";
    private byte[] octetSequence;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public OctetSequenceJsonWebKey(java.security.Key r5) {
        /*
            r4 = this;
            r0 = r4
            r1 = r5
            r2 = r0
            r3 = r1
            r2.<init>((java.security.Key) r3)
            r2 = r0
            r3 = r1
            byte[] r3 = r3.getEncoded()
            r2.octetSequence = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jose4j.jwk.OctetSequenceJsonWebKey.<init>(java.security.Key):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public OctetSequenceJsonWebKey(java.util.Map<java.lang.String, java.lang.Object> r12) throws org.jose4j.lang.JoseException {
        /*
            r11 = this;
            r0 = r11
            r1 = r12
            r5 = r0
            r6 = r1
            r5.<init>((java.util.Map<java.lang.String, java.lang.Object>) r6)
            org.jose4j.base64url.Base64Url r5 = new org.jose4j.base64url.Base64Url
            r10 = r5
            r5 = r10
            r6 = r10
            r6.<init>()
            r2 = r5
            r5 = r1
            java.lang.String r6 = "k"
            java.lang.String r5 = getStringRequired(r5, r6)
            r3 = r5
            r5 = r0
            r6 = r2
            r7 = r3
            byte[] r6 = r6.base64UrlDecode(r7)
            r5.octetSequence = r6
            java.lang.String r5 = "AES"
            r4 = r5
            r5 = r0
            javax.crypto.spec.SecretKeySpec r6 = new javax.crypto.spec.SecretKeySpec
            r10 = r6
            r6 = r10
            r7 = r10
            r8 = r0
            byte[] r8 = r8.octetSequence
            r9 = r4
            r7.<init>(r8, r9)
            r5.key = r6
            r5 = r0
            r6 = 1
            java.lang.String[] r6 = new java.lang.String[r6]
            r10 = r6
            r6 = r10
            r7 = r10
            r8 = 0
            java.lang.String r9 = "k"
            r7[r8] = r9
            r5.removeFromOtherParams(r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jose4j.jwk.OctetSequenceJsonWebKey.<init>(java.util.Map):void");
    }

    public String getKeyType() {
        return KEY_TYPE;
    }

    public byte[] getOctetSequence() {
        return this.octetSequence;
    }

    private String getEncoded() {
        return Base64Url.encode(this.octetSequence);
    }

    /* access modifiers changed from: protected */
    public void fillTypeSpecificParams(Map<String, Object> map, JsonWebKey.OutputControlLevel outputLevel) {
        Map<String, Object> params = map;
        if (JsonWebKey.OutputControlLevel.INCLUDE_SYMMETRIC.compareTo(outputLevel) >= 0) {
            Object put = params.put(KEY_VALUE_MEMBER_NAME, getEncoded());
        }
    }

    /*  JADX ERROR: NullPointerException in pass: CodeShrinkVisitor
        java.lang.NullPointerException
        */
    protected java.lang.String produceThumbprintHashInput() {
        /*
            r9 = this;
            r0 = r9
            java.lang.String r3 = "{\"k\":\"%s\",\"kty\":\"oct\"}"
            r1 = r3
            r3 = r0
            java.lang.String r3 = r3.getEncoded()
            r2 = r3
            r3 = r1
            r4 = 1
            java.lang.Object[] r4 = new java.lang.Object[r4]
            r8 = r4
            r4 = r8
            r5 = r8
            r6 = 0
            r7 = r2
            r5[r6] = r7
            java.lang.String r3 = java.lang.String.format(r3, r4)
            r0 = r3
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jose4j.jwk.OctetSequenceJsonWebKey.produceThumbprintHashInput():java.lang.String");
    }
}
