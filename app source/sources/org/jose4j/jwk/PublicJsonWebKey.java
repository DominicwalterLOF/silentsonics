package org.jose4j.jwk;

import java.math.BigInteger;
import java.security.Key;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.jose4j.json.JsonUtil;
import org.jose4j.jwk.JsonWebKey;
import org.jose4j.keys.BigEndianBigInteger;
import org.jose4j.keys.X509Util;
import org.jose4j.lang.JoseException;

public abstract class PublicJsonWebKey extends JsonWebKey {
    public static final String X509_CERTIFICATE_CHAIN_PARAMETER = "x5c";
    public static final String X509_SHA256_THUMBPRINT_PARAMETER = "x5t#S256";
    public static final String X509_THUMBPRINT_PARAMETER = "x5t";
    public static final String X509_URL_PARAMETER = "x5u";
    private List<X509Certificate> certificateChain;
    protected String jcaProvider;
    protected PrivateKey privateKey;
    protected boolean writeOutPrivateKeyToJson;
    private String x5t;
    private String x5tS256;
    private String x5u;

    /* access modifiers changed from: protected */
    public abstract void fillPrivateTypeSpecificParams(Map<String, Object> map);

    /* access modifiers changed from: protected */
    public abstract void fillPublicTypeSpecificParams(Map<String, Object> map);

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    protected PublicJsonWebKey(PublicKey publicKey) {
        super((Key) publicKey);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    protected PublicJsonWebKey(Map<String, Object> params) throws JoseException {
        this(params, (String) null);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected PublicJsonWebKey(java.util.Map<java.lang.String, java.lang.Object> r15, java.lang.String r16) throws org.jose4j.lang.JoseException {
        /*
            r14 = this;
            r0 = r14
            r1 = r15
            r2 = r16
            r8 = r0
            r9 = r1
            r8.<init>((java.util.Map<java.lang.String, java.lang.Object>) r9)
            r8 = r0
            r9 = r2
            r8.jcaProvider = r9
            r8 = r1
            java.lang.String r9 = "x5c"
            boolean r8 = r8.containsKey(r9)
            if (r8 == 0) goto L_0x005b
            r8 = r1
            java.lang.String r9 = "x5c"
            java.util.List r8 = org.jose4j.lang.JsonHelp.getStringArray(r8, r9)
            r3 = r8
            r8 = r0
            java.util.ArrayList r9 = new java.util.ArrayList
            r13 = r9
            r9 = r13
            r10 = r13
            r11 = r3
            int r11 = r11.size()
            r10.<init>(r11)
            r8.certificateChain = r9
            r8 = r2
            org.jose4j.keys.X509Util r8 = org.jose4j.keys.X509Util.getX509Util(r8)
            r4 = r8
            r8 = r3
            java.util.Iterator r8 = r8.iterator()
            r5 = r8
        L_0x003c:
            r8 = r5
            boolean r8 = r8.hasNext()
            if (r8 == 0) goto L_0x005b
            r8 = r5
            java.lang.Object r8 = r8.next()
            java.lang.String r8 = (java.lang.String) r8
            r6 = r8
            r8 = r4
            r9 = r6
            java.security.cert.X509Certificate r8 = r8.fromBase64Der(r9)
            r7 = r8
            r8 = r0
            java.util.List<java.security.cert.X509Certificate> r8 = r8.certificateChain
            r9 = r7
            boolean r8 = r8.add(r9)
            goto L_0x003c
        L_0x005b:
            r8 = r0
            r9 = r1
            java.lang.String r10 = "x5t"
            java.lang.String r9 = getString(r9, r10)
            r8.x5t = r9
            r8 = r0
            r9 = r1
            java.lang.String r10 = "x5t#S256"
            java.lang.String r9 = getString(r9, r10)
            r8.x5tS256 = r9
            r8 = r0
            r9 = r1
            java.lang.String r10 = "x5u"
            java.lang.String r9 = getString(r9, r10)
            r8.x5u = r9
            r8 = r0
            r9 = 4
            java.lang.String[] r9 = new java.lang.String[r9]
            r13 = r9
            r9 = r13
            r10 = r13
            r11 = 0
            java.lang.String r12 = "x5c"
            r10[r11] = r12
            r13 = r9
            r9 = r13
            r10 = r13
            r11 = 1
            java.lang.String r12 = "x5t#S256"
            r10[r11] = r12
            r13 = r9
            r9 = r13
            r10 = r13
            r11 = 2
            java.lang.String r12 = "x5t"
            r10[r11] = r12
            r13 = r9
            r9 = r13
            r10 = r13
            r11 = 3
            java.lang.String r12 = "x5u"
            r10[r11] = r12
            r8.removeFromOtherParams(r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jose4j.jwk.PublicJsonWebKey.<init>(java.util.Map, java.lang.String):void");
    }

    /* access modifiers changed from: protected */
    public void fillTypeSpecificParams(Map<String, Object> map, JsonWebKey.OutputControlLevel outputControlLevel) {
        X509Util x509Util;
        List<String> list;
        Map<String, Object> params = map;
        JsonWebKey.OutputControlLevel outputLevel = outputControlLevel;
        fillPublicTypeSpecificParams(params);
        if (this.certificateChain != null) {
            new X509Util();
            X509Util x509Util2 = x509Util;
            new ArrayList<>(this.certificateChain.size());
            List<String> x5cStrings = list;
            for (X509Certificate cert : this.certificateChain) {
                boolean add = x5cStrings.add(x509Util2.toBase64(cert));
            }
            Object put = params.put("x5c", x5cStrings);
        }
        putIfNotNull("x5t", this.x5t, params);
        putIfNotNull("x5t#S256", this.x5tS256, params);
        putIfNotNull("x5u", this.x5u, params);
        if (this.writeOutPrivateKeyToJson || outputLevel == JsonWebKey.OutputControlLevel.INCLUDE_PRIVATE) {
            fillPrivateTypeSpecificParams(params);
        }
    }

    public PublicKey getPublicKey() {
        return (PublicKey) this.key;
    }

    public void setWriteOutPrivateKeyToJson(boolean writeOutPrivateKeyToJson2) {
        boolean z = writeOutPrivateKeyToJson2;
        this.writeOutPrivateKeyToJson = z;
    }

    public PrivateKey getPrivateKey() {
        return this.privateKey;
    }

    public void setPrivateKey(PrivateKey privateKey2) {
        PrivateKey privateKey3 = privateKey2;
        this.privateKey = privateKey3;
    }

    public List<X509Certificate> getCertificateChain() {
        return this.certificateChain;
    }

    public X509Certificate getLeafCertificate() {
        return (this.certificateChain == null || this.certificateChain.isEmpty()) ? null : this.certificateChain.get(0);
    }

    public String getX509CertificateSha1Thumbprint() {
        return getX509CertificateSha1Thumbprint(false);
    }

    public String getX509CertificateSha1Thumbprint(boolean z) {
        X509Certificate leafCertificate;
        boolean allowFallbackDeriveFromX5c = z;
        String result = this.x5t;
        if (result == null && allowFallbackDeriveFromX5c && (leafCertificate = getLeafCertificate()) != null) {
            result = X509Util.x5t(leafCertificate);
        }
        return result;
    }

    public String getX509CertificateSha256Thumbprint() {
        return getX509CertificateSha256Thumbprint(false);
    }

    public String getX509CertificateSha256Thumbprint(boolean z) {
        X509Certificate leafCertificate;
        boolean allowFallbackDeriveFromX5c = z;
        String result = this.x5tS256;
        if (result == null && allowFallbackDeriveFromX5c && (leafCertificate = getLeafCertificate()) != null) {
            result = X509Util.x5tS256(leafCertificate);
        }
        return result;
    }

    public String getX509Url() {
        return this.x5u;
    }

    public void setCertificateChain(List<X509Certificate> certificateChain2) {
        checkForBareKeyCertMismatch();
        this.certificateChain = certificateChain2;
    }

    public void setX509CertificateSha1Thumbprint(String x5t2) {
        String str = x5t2;
        this.x5t = str;
    }

    public void setX509CertificateSha256Thumbprint(String x5tS2) {
        String str = x5tS2;
        this.x5tS256 = str;
    }

    public void setX509Url(String x5u2) {
        String str = x5u2;
        this.x5u = str;
    }

    /* access modifiers changed from: package-private */
    public void checkForBareKeyCertMismatch() {
        Throwable th;
        StringBuilder sb;
        X509Certificate leafCertificate = getLeafCertificate();
        if (leafCertificate != null && !leafCertificate.getPublicKey().equals(getPublicKey())) {
            Throwable th2 = th;
            new StringBuilder();
            new IllegalArgumentException(sb.append("The key in the first certificate MUST match the bare public key represented by other members of the JWK. Public key = ").append(getPublicKey()).append(" cert = ").append(leafCertificate).toString());
            throw th2;
        }
    }

    public void setCertificateChain(X509Certificate... certificates) {
        setCertificateChain((List<X509Certificate>) Arrays.asList(certificates));
    }

    /* access modifiers changed from: package-private */
    public BigInteger getBigIntFromBase64UrlEncodedParam(Map<String, Object> params, String parameterName, boolean required) throws JoseException {
        return BigEndianBigInteger.fromBase64Url(getString(params, parameterName, required));
    }

    /* access modifiers changed from: package-private */
    public void putBigIntAsBase64UrlEncodedParam(Map<String, Object> params, String parameterName, BigInteger value) {
        Object put = params.put(parameterName, BigEndianBigInteger.toBase64Url(value));
    }

    /* access modifiers changed from: package-private */
    public void putBigIntAsBase64UrlEncodedParam(Map<String, Object> params, String parameterName, BigInteger value, int minLength) {
        Object put = params.put(parameterName, BigEndianBigInteger.toBase64Url(value, minLength));
    }

    public static class Factory {
        public Factory() {
        }

        public static PublicJsonWebKey newPublicJwk(Map<String, Object> map, String str) throws JoseException {
            PublicJsonWebKey publicJsonWebKey;
            PublicJsonWebKey publicJsonWebKey2;
            Throwable th;
            StringBuilder sb;
            Map<String, Object> params = map;
            String jcaProvider = str;
            String kty = JsonWebKey.getStringRequired(params, JsonWebKey.KEY_TYPE_PARAMETER);
            String str2 = kty;
            boolean z = true;
            switch (str2.hashCode()) {
                case 2206:
                    if (str2.equals("EC")) {
                        z = true;
                        break;
                    }
                    break;
                case 81440:
                    if (str2.equals("RSA")) {
                        z = false;
                        break;
                    }
                    break;
            }
            switch (z) {
                case false:
                    new RsaJsonWebKey(params, jcaProvider);
                    return publicJsonWebKey2;
                case true:
                    new EllipticCurveJsonWebKey(params, jcaProvider);
                    return publicJsonWebKey;
                default:
                    Throwable th2 = th;
                    new StringBuilder();
                    new JoseException(sb.append("Unknown key type (for public keys): '").append(kty).append("'").toString());
                    throw th2;
            }
        }

        public static PublicJsonWebKey newPublicJwk(Map<String, Object> params) throws JoseException {
            return newPublicJwk(params, (String) null);
        }

        public static PublicJsonWebKey newPublicJwk(Key publicKey) throws JoseException {
            return (PublicJsonWebKey) JsonWebKey.Factory.newJwk(publicKey);
        }

        public static PublicJsonWebKey newPublicJwk(String json) throws JoseException {
            return newPublicJwk(json, (String) null);
        }

        public static PublicJsonWebKey newPublicJwk(String json, String jcaProvider) throws JoseException {
            return newPublicJwk(JsonUtil.parseJson(json), jcaProvider);
        }
    }
}
