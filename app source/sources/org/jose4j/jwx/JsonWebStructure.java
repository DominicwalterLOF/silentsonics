package org.jose4j.jwx;

import java.security.Key;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.jose4j.base64url.Base64Url;
import org.jose4j.jca.ProviderContext;
import org.jose4j.jwa.Algorithm;
import org.jose4j.jwa.AlgorithmConstraints;
import org.jose4j.jwe.JsonWebEncryption;
import org.jose4j.jwk.PublicJsonWebKey;
import org.jose4j.jws.JsonWebSignature;
import org.jose4j.keys.X509Util;
import org.jose4j.lang.InvalidAlgorithmException;
import org.jose4j.lang.JoseException;

public abstract class JsonWebStructure {
    private static final ProviderContext DEFAULT_PROVIDER_CONTEXT;
    private AlgorithmConstraints algorithmConstraints = AlgorithmConstraints.NO_CONSTRAINTS;
    protected Base64Url base64url;
    protected boolean doKeyValidation = true;
    protected Headers headers;
    private byte[] integrity;
    private Key key;
    private Set<String> knownCriticalHeaders = Collections.emptySet();
    private ProviderContext providerCtx = DEFAULT_PROVIDER_CONTEXT;
    protected String rawCompactSerialization;

    public abstract Algorithm getAlgorithm() throws InvalidAlgorithmException;

    public abstract Algorithm getAlgorithmNoConstraintCheck() throws InvalidAlgorithmException;

    public abstract String getCompactSerialization() throws JoseException;

    public abstract String getPayload() throws JoseException;

    /* access modifiers changed from: protected */
    public abstract void setCompactSerializationParts(String[] strArr) throws JoseException;

    public abstract void setPayload(String str);

    public JsonWebStructure() {
        Base64Url base64Url;
        Headers headers2;
        new Base64Url();
        this.base64url = base64Url;
        new Headers();
        this.headers = headers2;
    }

    static {
        ProviderContext providerContext;
        new ProviderContext();
        DEFAULT_PROVIDER_CONTEXT = providerContext;
    }

    public static JsonWebStructure fromCompactSerialization(String str) throws JoseException {
        Throwable th;
        StringBuilder sb;
        JsonWebStructure jsonWebStructure;
        JsonWebStructure jsonWebObject;
        JsonWebStructure jsonWebStructure2;
        String cs = str;
        String[] parts = CompactSerializer.deserialize(cs);
        if (parts.length == 5) {
            new JsonWebEncryption();
            jsonWebObject = jsonWebStructure2;
        } else if (parts.length == 3) {
            new JsonWebSignature();
            jsonWebObject = jsonWebStructure;
        } else {
            Throwable th2 = th;
            new StringBuilder();
            new JoseException(sb.append("Invalid JOSE Compact Serialization. Expecting either 3 or 5 parts for JWS or JWE respectively but was ").append(parts.length).append(".").toString());
            throw th2;
        }
        jsonWebObject.setCompactSerializationParts(parts);
        jsonWebObject.rawCompactSerialization = cs;
        return jsonWebObject;
    }

    public void setCompactSerialization(String str) throws JoseException {
        String compactSerialization = str;
        setCompactSerializationParts(CompactSerializer.deserialize(compactSerialization));
        this.rawCompactSerialization = compactSerialization;
    }

    public String getHeader() {
        return getHeaders().getFullHeaderAsJsonString();
    }

    /* access modifiers changed from: protected */
    public String getEncodedHeader() {
        return this.headers.getEncodedHeader();
    }

    public void setHeader(String name, String value) {
        this.headers.setStringHeaderValue(name, value);
    }

    /* access modifiers changed from: protected */
    public void setEncodedHeader(String str) throws JoseException {
        String encodedHeader = str;
        checkNotEmptyPart(encodedHeader, "Encoded Header");
        this.headers.setEncodedHeader(encodedHeader);
    }

    public Headers getHeaders() {
        return this.headers;
    }

    /* access modifiers changed from: protected */
    public void checkNotEmptyPart(String str, String str2) throws JoseException {
        Throwable th;
        StringBuilder sb;
        String encodedPart = str;
        String partName = str2;
        if (encodedPart == null || encodedPart.length() == 0) {
            Throwable th2 = th;
            new StringBuilder();
            new JoseException(sb.append("The ").append(partName).append(" cannot be empty.").toString());
            throw th2;
        }
    }

    public String getHeader(String name) {
        return this.headers.getStringHeaderValue(name);
    }

    public void setHeader(String name, Object value) {
        this.headers.setObjectHeaderValue(name, value);
    }

    public Object getObjectHeader(String name) {
        return this.headers.getObjectHeaderValue(name);
    }

    public void setAlgorithmHeaderValue(String alg) {
        setHeader("alg", alg);
    }

    public String getAlgorithmHeaderValue() {
        return getHeader("alg");
    }

    public void setContentTypeHeaderValue(String cty) {
        setHeader(HeaderParameterNames.CONTENT_TYPE, cty);
    }

    public String getContentTypeHeaderValue() {
        return getHeader(HeaderParameterNames.CONTENT_TYPE);
    }

    public void setKeyIdHeaderValue(String kid) {
        setHeader("kid", kid);
    }

    public String getKeyIdHeaderValue() {
        return getHeader("kid");
    }

    public PublicJsonWebKey getJwkHeader() throws JoseException {
        return this.headers.getPublicJwkHeaderValue(HeaderParameterNames.JWK, (String) null);
    }

    public void setJwkHeader(PublicJsonWebKey jwk) {
        this.headers.setJwkHeaderValue(HeaderParameterNames.JWK, jwk);
    }

    public X509Certificate getLeafCertificateHeaderValue() throws JoseException {
        List<X509Certificate> certificateChain = getCertificateChainHeaderValue();
        return (certificateChain == null || certificateChain.isEmpty()) ? null : certificateChain.get(0);
    }

    public List<X509Certificate> getCertificateChainHeaderValue() throws JoseException {
        List<X509Certificate> list;
        X509Util x509Util;
        Object x5c = this.headers.getObjectHeaderValue("x5c");
        if (!(x5c instanceof List)) {
            return null;
        }
        List<String> x5cList = (List) x5c;
        new ArrayList(x5cList.size());
        List<X509Certificate> certificateChain = list;
        new X509Util();
        X509Util x509Util2 = x509Util;
        for (String fromBase64Der : x5cList) {
            boolean add = certificateChain.add(x509Util2.fromBase64Der(fromBase64Der));
        }
        return certificateChain;
    }

    public void setCertificateChainHeaderValue(X509Certificate... chain) {
        List<String> list;
        X509Util x509Util;
        new ArrayList<>();
        List<String> chainStrings = list;
        new X509Util();
        X509Util x509Util2 = x509Util;
        X509Certificate[] arr$ = chain;
        int len$ = arr$.length;
        for (int i$ = 0; i$ < len$; i$++) {
            boolean add = chainStrings.add(x509Util2.toBase64(arr$[i$]));
        }
        this.headers.setObjectHeaderValue("x5c", chainStrings);
    }

    public String getX509CertSha1ThumbprintHeaderValue() {
        return getHeader("x5t");
    }

    public void setX509CertSha1ThumbprintHeaderValue(String x5t) {
        setHeader("x5t", x5t);
    }

    public void setX509CertSha1ThumbprintHeaderValue(X509Certificate certificate) {
        setX509CertSha1ThumbprintHeaderValue(X509Util.x5t(certificate));
    }

    public String getX509CertSha256ThumbprintHeaderValue() {
        return getHeader("x5t#S256");
    }

    public void setX509CertSha256ThumbprintHeaderValue(String x5tS256) {
        setHeader("x5t#S256", x5tS256);
    }

    public void setX509CertSha256ThumbprintHeaderValue(X509Certificate certificate) {
        setX509CertSha256ThumbprintHeaderValue(X509Util.x5tS256(certificate));
    }

    public Key getKey() {
        return this.key;
    }

    public void setKey(Key key2) {
        Key key3 = key2;
        if (!(key3 == null ? this.key == null : this.key != null && key3.equals(this.key))) {
            onNewKey();
        }
        this.key = key3;
    }

    /* access modifiers changed from: protected */
    public void onNewKey() {
    }

    /* access modifiers changed from: protected */
    public byte[] getIntegrity() {
        return this.integrity;
    }

    /* access modifiers changed from: protected */
    public void setIntegrity(byte[] integrity2) {
        byte[] bArr = integrity2;
        this.integrity = bArr;
    }

    public boolean isDoKeyValidation() {
        return this.doKeyValidation;
    }

    public void setDoKeyValidation(boolean doKeyValidation2) {
        boolean z = doKeyValidation2;
        this.doKeyValidation = z;
    }

    /* access modifiers changed from: protected */
    public AlgorithmConstraints getAlgorithmConstraints() {
        return this.algorithmConstraints;
    }

    public void setAlgorithmConstraints(AlgorithmConstraints algorithmConstraints2) {
        AlgorithmConstraints algorithmConstraints3 = algorithmConstraints2;
        this.algorithmConstraints = algorithmConstraints3;
    }

    public void setCriticalHeaderNames(String... headerNames) {
        this.headers.setObjectHeaderValue(HeaderParameterNames.CRITICAL, headerNames);
    }

    public void setKnownCriticalHeaders(String... knownCriticalHeaders2) {
        Set<String> set;
        Set<String> set2 = set;
        new HashSet(Arrays.asList(knownCriticalHeaders2));
        this.knownCriticalHeaders = set2;
    }

    /* access modifiers changed from: protected */
    public void checkCrit() throws JoseException {
        Throwable th;
        StringBuilder sb;
        List<String> criticalHeaders;
        Throwable th2;
        StringBuilder sb2;
        Object criticalHeaderObjectValue = this.headers.getObjectHeaderValue(HeaderParameterNames.CRITICAL);
        if (criticalHeaderObjectValue != null) {
            if (criticalHeaderObjectValue instanceof List) {
                criticalHeaders = (List) criticalHeaderObjectValue;
            } else if (criticalHeaderObjectValue instanceof String[]) {
                criticalHeaders = Arrays.asList((String[]) criticalHeaderObjectValue);
            } else {
                Throwable th3 = th;
                new StringBuilder();
                new JoseException(sb.append("crit header value not an array (").append(criticalHeaderObjectValue.getClass()).append(").").toString());
                throw th3;
            }
            for (String criticalHeader : criticalHeaders) {
                if (!this.knownCriticalHeaders.contains(criticalHeader) && !isSupportedCriticalHeader(criticalHeader)) {
                    Throwable th4 = th2;
                    new StringBuilder();
                    new JoseException(sb2.append("Unrecognized header '").append(criticalHeader).append("' marked as critical.").toString());
                    throw th4;
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public boolean isSupportedCriticalHeader(String str) {
        String str2 = str;
        return false;
    }

    /* access modifiers changed from: protected */
    public ProviderContext getProviderCtx() {
        return this.providerCtx;
    }

    public void setProviderContext(ProviderContext providerCtx2) {
        ProviderContext providerContext = providerCtx2;
        this.providerCtx = providerContext;
    }

    public String toString() {
        StringBuilder sb;
        new StringBuilder();
        StringBuilder sb2 = sb;
        StringBuilder append = sb2.append(getClass().getSimpleName()).append(getHeaders().getFullHeaderAsJsonString());
        if (this.rawCompactSerialization != null) {
            StringBuilder append2 = sb2.append("->").append(this.rawCompactSerialization);
        }
        return sb2.toString();
    }
}
