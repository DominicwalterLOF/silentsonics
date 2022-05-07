package org.jose4j.jwk;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class SimpleJwkFilter {
    private static final String[] EMPTY = new String[2];
    public static boolean OMITTED_OKAY = true;
    public static boolean VALUE_REQUIRED = false;
    private Criteria alg;
    private boolean allowThumbsFallbackDeriveFromX5c;
    private Criteria crv;
    private KeyOpsCriteria keyOps;
    private Criteria kid;
    private Criteria kty;
    private Criteria use;
    private Criteria x5t;
    private Criteria x5tS256;

    public SimpleJwkFilter() {
    }

    public void setKid(String expectedKid, boolean omittedValueAcceptable) {
        Criteria criteria;
        Criteria criteria2 = criteria;
        new Criteria(expectedKid, omittedValueAcceptable, (AnonymousClass1) null);
        this.kid = criteria2;
    }

    public void setKty(String expectedKty) {
        Criteria criteria;
        Criteria criteria2 = criteria;
        new Criteria(expectedKty, false, (AnonymousClass1) null);
        this.kty = criteria2;
    }

    public void setUse(String expectedUse, boolean omittedValueAcceptable) {
        Criteria criteria;
        Criteria criteria2 = criteria;
        new Criteria(expectedUse, omittedValueAcceptable, (AnonymousClass1) null);
        this.use = criteria2;
    }

    public void setKeyOperations(String[] expectedKeyOps, boolean omittedValueAcceptable) {
        KeyOpsCriteria keyOpsCriteria;
        KeyOpsCriteria keyOpsCriteria2 = keyOpsCriteria;
        new KeyOpsCriteria(expectedKeyOps, omittedValueAcceptable, (AnonymousClass1) null);
        this.keyOps = keyOpsCriteria2;
    }

    public void setAlg(String expectedAlg, boolean omittedValueAcceptable) {
        Criteria criteria;
        Criteria criteria2 = criteria;
        new Criteria(expectedAlg, omittedValueAcceptable, (AnonymousClass1) null);
        this.alg = criteria2;
    }

    public void setX5t(String expectedThumb, boolean omittedValueAcceptable) {
        Criteria criteria;
        Criteria criteria2 = criteria;
        new Criteria(expectedThumb, omittedValueAcceptable, (AnonymousClass1) null);
        this.x5t = criteria2;
    }

    public void setX5tS256(String expectedThumb, boolean omittedValueAcceptable) {
        Criteria criteria;
        Criteria criteria2 = criteria;
        new Criteria(expectedThumb, omittedValueAcceptable, (AnonymousClass1) null);
        this.x5tS256 = criteria2;
    }

    public void setAllowFallbackDeriveFromX5cForX5Thumbs(boolean allow) {
        boolean z = allow;
        this.allowThumbsFallbackDeriveFromX5c = z;
    }

    public void setCrv(String expectedCrv, boolean omittedValueAcceptable) {
        Criteria criteria;
        Criteria criteria2 = criteria;
        new Criteria(expectedCrv, omittedValueAcceptable, (AnonymousClass1) null);
        this.crv = criteria2;
    }

    public List<JsonWebKey> filter(Collection<JsonWebKey> jsonWebKeys) {
        List<JsonWebKey> list;
        new ArrayList();
        List<JsonWebKey> filtered = list;
        for (JsonWebKey jwk : jsonWebKeys) {
            boolean match = isMatch(this.kid, jwk.getKeyId()) & isMatch(this.kty, jwk.getKeyType()) & isMatch(this.use, jwk.getUse()) & isMatch(this.alg, jwk.getAlgorithm());
            String[] thumbs = getThumbs(jwk, this.allowThumbsFallbackDeriveFromX5c);
            if ((match & isMatch(this.x5t, thumbs[0]) & isMatch(this.x5tS256, thumbs[1]) & isMatch(this.crv, getCrv(jwk))) && (this.keyOps == null || this.keyOps.meetsCriteria(jwk.getKeyOps()))) {
                boolean add = filtered.add(jwk);
            }
        }
        return filtered;
    }

    /* access modifiers changed from: package-private */
    public boolean isMatch(Criteria criteria, String value) {
        Criteria criteria2 = criteria;
        return criteria2 == null || criteria2.meetsCriteria(value);
    }

    /* access modifiers changed from: package-private */
    public String getCrv(JsonWebKey jsonWebKey) {
        JsonWebKey jwk = jsonWebKey;
        return jwk instanceof EllipticCurveJsonWebKey ? ((EllipticCurveJsonWebKey) jwk).getCurveName() : null;
    }

    /* access modifiers changed from: package-private */
    public String[] getThumbs(JsonWebKey jsonWebKey, boolean z) {
        JsonWebKey jwk = jsonWebKey;
        boolean allowFallbackDeriveFromX5c = z;
        if (this.x5t == null && this.x5tS256 == null) {
            return EMPTY;
        }
        if (!(jwk instanceof PublicJsonWebKey)) {
            return EMPTY;
        }
        PublicJsonWebKey publicJwk = (PublicJsonWebKey) jwk;
        String x5t2 = publicJwk.getX509CertificateSha1Thumbprint(allowFallbackDeriveFromX5c);
        String x5tS2562 = publicJwk.getX509CertificateSha256Thumbprint(allowFallbackDeriveFromX5c);
        String[] strArr = new String[2];
        strArr[0] = x5t2;
        String[] strArr2 = strArr;
        strArr2[1] = x5tS2562;
        return strArr2;
    }

    private static class Criteria {
        boolean noValueOk;
        String value;

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        /* synthetic */ Criteria(String x0, boolean x1, AnonymousClass1 r10) {
            this(x0, x1);
            AnonymousClass1 r3 = r10;
        }

        private Criteria(String value2, boolean noValueOk2) {
            this.value = value2;
            this.noValueOk = noValueOk2;
        }

        public boolean meetsCriteria(String str) {
            String value2 = str;
            if (value2 == null) {
                return this.noValueOk;
            }
            return value2.equals(this.value);
        }
    }

    private static class KeyOpsCriteria {
        boolean noValueOk;
        String[] values;

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        /* synthetic */ KeyOpsCriteria(String[] x0, boolean x1, AnonymousClass1 r10) {
            this(x0, x1);
            AnonymousClass1 r3 = r10;
        }

        private KeyOpsCriteria(String[] values2, boolean noValueOk2) {
            this.values = values2;
            this.noValueOk = noValueOk2;
        }

        public boolean meetsCriteria(List<String> list) {
            List<String> values2 = list;
            if (values2 == null) {
                return this.noValueOk;
            }
            String[] arr$ = this.values;
            int len$ = arr$.length;
            for (int i$ = 0; i$ < len$; i$++) {
                if (values2.contains(arr$[i$])) {
                    return true;
                }
            }
            return false;
        }
    }
}
