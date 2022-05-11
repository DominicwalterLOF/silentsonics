package org.jose4j.jwk;

import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECPoint;
import java.util.Map;
import org.jose4j.keys.EllipticCurves;
import org.jose4j.lang.JoseException;

public class EllipticCurveJsonWebKey extends PublicJsonWebKey {
    public static final String CURVE_MEMBER_NAME = "crv";
    public static final String KEY_TYPE = "EC";
    public static final String PRIVATE_KEY_MEMBER_NAME = "d";
    public static final String X_MEMBER_NAME = "x";
    public static final String Y_MEMBER_NAME = "y";
    private String curveName;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public EllipticCurveJsonWebKey(java.security.interfaces.ECPublicKey r7) {
        /*
            r6 = this;
            r0 = r6
            r1 = r7
            r4 = r0
            r5 = r1
            r4.<init>((java.security.PublicKey) r5)
            r4 = r1
            java.security.spec.ECParameterSpec r4 = r4.getParams()
            r2 = r4
            r4 = r2
            java.security.spec.EllipticCurve r4 = r4.getCurve()
            r3 = r4
            r4 = r0
            r5 = r3
            java.lang.String r5 = org.jose4j.keys.EllipticCurves.getName(r5)
            r4.curveName = r5
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jose4j.jwk.EllipticCurveJsonWebKey.<init>(java.security.interfaces.ECPublicKey):void");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public EllipticCurveJsonWebKey(Map<String, Object> params) throws JoseException {
        this(params, (String) null);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public EllipticCurveJsonWebKey(java.util.Map<java.lang.String, java.lang.Object> r15, java.lang.String r16) throws org.jose4j.lang.JoseException {
        /*
            r14 = this;
            r0 = r14
            r1 = r15
            r2 = r16
            r8 = r0
            r9 = r1
            r10 = r2
            r8.<init>(r9, r10)
            r8 = r0
            r9 = r1
            java.lang.String r10 = "crv"
            r11 = 1
            java.lang.String r9 = getString(r9, r10, r11)
            r8.curveName = r9
            r8 = r0
            java.lang.String r8 = r8.curveName
            java.security.spec.ECParameterSpec r8 = org.jose4j.keys.EllipticCurves.getSpec(r8)
            r3 = r8
            r8 = r0
            r9 = r1
            java.lang.String r10 = "x"
            r11 = 1
            java.math.BigInteger r8 = r8.getBigIntFromBase64UrlEncodedParam(r9, r10, r11)
            r4 = r8
            r8 = r0
            r9 = r1
            java.lang.String r10 = "y"
            r11 = 1
            java.math.BigInteger r8 = r8.getBigIntFromBase64UrlEncodedParam(r9, r10, r11)
            r5 = r8
            org.jose4j.keys.EcKeyUtil r8 = new org.jose4j.keys.EcKeyUtil
            r13 = r8
            r8 = r13
            r9 = r13
            r10 = r2
            r11 = 0
            r9.<init>(r10, r11)
            r6 = r8
            r8 = r0
            r9 = r6
            r10 = r4
            r11 = r5
            r12 = r3
            java.security.interfaces.ECPublicKey r9 = r9.publicKey(r10, r11, r12)
            r8.key = r9
            r8 = r0
            r8.checkForBareKeyCertMismatch()
            r8 = r1
            java.lang.String r9 = "d"
            boolean r8 = r8.containsKey(r9)
            if (r8 == 0) goto L_0x006d
            r8 = r0
            r9 = r1
            java.lang.String r10 = "d"
            r11 = 0
            java.math.BigInteger r8 = r8.getBigIntFromBase64UrlEncodedParam(r9, r10, r11)
            r7 = r8
            r8 = r0
            r9 = r6
            r10 = r7
            r11 = r3
            java.security.interfaces.ECPrivateKey r9 = r9.privateKey(r10, r11)
            r8.privateKey = r9
        L_0x006d:
            r8 = r0
            r9 = 4
            java.lang.String[] r9 = new java.lang.String[r9]
            r13 = r9
            r9 = r13
            r10 = r13
            r11 = 0
            java.lang.String r12 = "crv"
            r10[r11] = r12
            r13 = r9
            r9 = r13
            r10 = r13
            r11 = 1
            java.lang.String r12 = "x"
            r10[r11] = r12
            r13 = r9
            r9 = r13
            r10 = r13
            r11 = 2
            java.lang.String r12 = "y"
            r10[r11] = r12
            r13 = r9
            r9 = r13
            r10 = r13
            r11 = 3
            java.lang.String r12 = "d"
            r10[r11] = r12
            r8.removeFromOtherParams(r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jose4j.jwk.EllipticCurveJsonWebKey.<init>(java.util.Map, java.lang.String):void");
    }

    public ECPublicKey getECPublicKey() {
        return (ECPublicKey) this.key;
    }

    public ECPrivateKey getEcPrivateKey() {
        return (ECPrivateKey) this.privateKey;
    }

    public String getKeyType() {
        return "EC";
    }

    public String getCurveName() {
        return this.curveName;
    }

    private int getCoordinateByteLength() {
        return (int) Math.ceil(((double) EllipticCurves.getSpec(getCurveName()).getCurve().getField().getFieldSize()) / 8.0d);
    }

    /* access modifiers changed from: protected */
    public void fillPublicTypeSpecificParams(Map<String, Object> map) {
        Map<String, Object> params = map;
        ECPoint w = getECPublicKey().getW();
        int coordinateByteLength = getCoordinateByteLength();
        putBigIntAsBase64UrlEncodedParam(params, X_MEMBER_NAME, w.getAffineX(), coordinateByteLength);
        putBigIntAsBase64UrlEncodedParam(params, Y_MEMBER_NAME, w.getAffineY(), coordinateByteLength);
        Object put = params.put(CURVE_MEMBER_NAME, getCurveName());
    }

    /* access modifiers changed from: protected */
    public void fillPrivateTypeSpecificParams(Map<String, Object> map) {
        Map<String, Object> params = map;
        ECPrivateKey ecPrivateKey = getEcPrivateKey();
        if (ecPrivateKey != null) {
            putBigIntAsBase64UrlEncodedParam(params, "d", ecPrivateKey.getS(), getCoordinateByteLength());
        }
    }

    /*  JADX ERROR: NullPointerException in pass: CodeShrinkVisitor
        java.lang.NullPointerException
        */
    protected java.lang.String produceThumbprintHashInput() {
        /*
            r12 = this;
            r0 = r12
            java.lang.String r6 = "{\"crv\":\"%s\",\"kty\":\"EC\",\"x\":\"%s\",\"y\":\"%s\"}"
            r1 = r6
            java.util.HashMap r6 = new java.util.HashMap
            r11 = r6
            r6 = r11
            r7 = r11
            r7.<init>()
            r2 = r6
            r6 = r0
            r7 = r2
            r6.fillPublicTypeSpecificParams(r7)
            r6 = r2
            java.lang.String r7 = "crv"
            java.lang.Object r6 = r6.get(r7)
            r3 = r6
            r6 = r2
            java.lang.String r7 = "x"
            java.lang.Object r6 = r6.get(r7)
            r4 = r6
            r6 = r2
            java.lang.String r7 = "y"
            java.lang.Object r6 = r6.get(r7)
            r5 = r6
            r6 = r1
            r7 = 3
            java.lang.Object[] r7 = new java.lang.Object[r7]
            r11 = r7
            r7 = r11
            r8 = r11
            r9 = 0
            r10 = r3
            r8[r9] = r10
            r11 = r7
            r7 = r11
            r8 = r11
            r9 = 1
            r10 = r4
            r8[r9] = r10
            r11 = r7
            r7 = r11
            r8 = r11
            r9 = 2
            r10 = r5
            r8[r9] = r10
            java.lang.String r6 = java.lang.String.format(r6, r7)
            r0 = r6
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jose4j.jwk.EllipticCurveJsonWebKey.produceThumbprintHashInput():java.lang.String");
    }
}
