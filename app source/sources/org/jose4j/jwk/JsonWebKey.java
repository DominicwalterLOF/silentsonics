package org.jose4j.jwk;

import java.io.Serializable;
import java.security.Key;
import java.security.PublicKey;
import java.security.interfaces.ECPublicKey;
import java.security.interfaces.RSAPublicKey;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.jose4j.base64url.Base64Url;
import org.jose4j.json.JsonUtil;
import org.jose4j.lang.HashUtil;
import org.jose4j.lang.JoseException;
import org.jose4j.lang.JsonHelp;
import org.jose4j.lang.StringUtil;

public abstract class JsonWebKey implements Serializable {
    public static final String ALGORITHM_PARAMETER = "alg";
    public static final String KEY_ID_PARAMETER = "kid";
    public static final String KEY_OPERATIONS = "key_ops";
    public static final String KEY_TYPE_PARAMETER = "kty";
    public static final String USE_PARAMETER = "use";
    private String algorithm;
    protected Key key;
    private String keyId;
    private List<String> keyOps;
    protected Map<String, Object> otherParameters;
    private String use;

    public enum OutputControlLevel {
    }

    /* access modifiers changed from: protected */
    public abstract void fillTypeSpecificParams(Map<String, Object> map, OutputControlLevel outputControlLevel);

    public abstract String getKeyType();

    /* access modifiers changed from: protected */
    public abstract String produceThumbprintHashInput();

    protected JsonWebKey(Key key2) {
        Map<String, Object> map;
        new LinkedHashMap();
        this.otherParameters = map;
        this.key = key2;
    }

    protected JsonWebKey(Map<String, Object> map) throws JoseException {
        Map<String, Object> map2;
        Map<String, Object> params = map;
        new LinkedHashMap();
        this.otherParameters = map2;
        this.otherParameters.putAll(params);
        String[] strArr = new String[5];
        strArr[0] = KEY_TYPE_PARAMETER;
        String[] strArr2 = strArr;
        strArr2[1] = USE_PARAMETER;
        String[] strArr3 = strArr2;
        strArr3[2] = "kid";
        String[] strArr4 = strArr3;
        strArr4[3] = "alg";
        String[] strArr5 = strArr4;
        strArr5[4] = KEY_OPERATIONS;
        removeFromOtherParams(strArr5);
        setUse(getString(params, USE_PARAMETER));
        setKeyId(getString(params, "kid"));
        setAlgorithm(getString(params, "alg"));
        if (params.containsKey(KEY_OPERATIONS)) {
            this.keyOps = JsonHelp.getStringArray(params, KEY_OPERATIONS);
        }
    }

    public PublicKey getPublicKey() {
        try {
            return (PublicKey) this.key;
        } catch (Exception e) {
            Exception exc = e;
            return null;
        }
    }

    public Key getKey() {
        return this.key;
    }

    public String getUse() {
        return this.use;
    }

    public void setUse(String use2) {
        String str = use2;
        this.use = str;
    }

    public String getKeyId() {
        return this.keyId;
    }

    public void setKeyId(String keyId2) {
        String str = keyId2;
        this.keyId = str;
    }

    public String getAlgorithm() {
        return this.algorithm;
    }

    public void setAlgorithm(String algorithm2) {
        String str = algorithm2;
        this.algorithm = str;
    }

    public List<String> getKeyOps() {
        return this.keyOps;
    }

    public void setKeyOps(List<String> keyOps2) {
        List<String> list = keyOps2;
        this.keyOps = list;
    }

    public void setOtherParameter(String name, Object value) {
        Object put = this.otherParameters.put(name, value);
    }

    public <T> T getOtherParameterValue(String name, Class<T> type) {
        return type.cast(this.otherParameters.get(name));
    }

    /* access modifiers changed from: protected */
    public void removeFromOtherParams(String... names) {
        String[] arr$ = names;
        int len$ = arr$.length;
        for (int i$ = 0; i$ < len$; i$++) {
            Object remove = this.otherParameters.remove(arr$[i$]);
        }
    }

    public Map<String, Object> toParams(OutputControlLevel outputLevel) {
        Map<String, Object> map;
        new LinkedHashMap();
        Map<String, Object> params = map;
        Object put = params.put(KEY_TYPE_PARAMETER, getKeyType());
        putIfNotNull("kid", getKeyId(), params);
        putIfNotNull(USE_PARAMETER, getUse(), params);
        putIfNotNull(KEY_OPERATIONS, this.keyOps, params);
        putIfNotNull("alg", getAlgorithm(), params);
        fillTypeSpecificParams(params, outputLevel);
        params.putAll(this.otherParameters);
        return params;
    }

    public String toJson() {
        return toJson(OutputControlLevel.INCLUDE_SYMMETRIC);
    }

    public String toJson(OutputControlLevel outputLevel) {
        return JsonUtil.toJson(toParams(outputLevel));
    }

    public String toString() {
        StringBuilder sb;
        new StringBuilder();
        return sb.append(getClass().getName()).append(toParams(OutputControlLevel.PUBLIC_ONLY)).toString();
    }

    public String calculateBase64urlEncodedThumbprint(String hashAlgorithm) {
        return Base64Url.encode(calculateThumbprint(hashAlgorithm));
    }

    public byte[] calculateThumbprint(String hashAlgorithm) {
        return HashUtil.getMessageDigest(hashAlgorithm).digest(StringUtil.getBytesUtf8(produceThumbprintHashInput()));
    }

    /* access modifiers changed from: protected */
    public void putIfNotNull(String str, Object obj, Map<String, Object> map) {
        String name = str;
        Object value = obj;
        Map<String, Object> params = map;
        if (value != null) {
            Object put = params.put(name, value);
        }
    }

    protected static String getString(Map<String, Object> params, String name) throws JoseException {
        return JsonHelp.getStringChecked(params, name);
    }

    protected static String getStringRequired(Map<String, Object> params, String name) throws JoseException {
        return getString(params, name, true);
    }

    protected static String getString(Map<String, Object> params, String str, boolean z) throws JoseException {
        Throwable th;
        StringBuilder sb;
        String name = str;
        boolean required = z;
        String value = getString(params, name);
        if (value != null || !required) {
            return value;
        }
        Throwable th2 = th;
        new StringBuilder();
        new JoseException(sb.append("Missing required '").append(name).append("' parameter.").toString());
        throw th2;
    }

    public static class Factory {
        public Factory() {
        }

        public static JsonWebKey newJwk(Map<String, Object> map) throws JoseException {
            JsonWebKey jsonWebKey;
            JsonWebKey jsonWebKey2;
            JsonWebKey jsonWebKey3;
            Throwable th;
            StringBuilder sb;
            Map<String, Object> params = map;
            String kty = JsonWebKey.getStringRequired(params, JsonWebKey.KEY_TYPE_PARAMETER);
            String str = kty;
            boolean z = true;
            switch (str.hashCode()) {
                case 2206:
                    if (str.equals("EC")) {
                        z = true;
                        break;
                    }
                    break;
                case 81440:
                    if (str.equals("RSA")) {
                        z = false;
                        break;
                    }
                    break;
                case 109856:
                    if (str.equals(OctetSequenceJsonWebKey.KEY_TYPE)) {
                        z = true;
                        break;
                    }
                    break;
            }
            switch (z) {
                case false:
                    new RsaJsonWebKey(params);
                    return jsonWebKey3;
                case true:
                    new EllipticCurveJsonWebKey(params);
                    return jsonWebKey2;
                case true:
                    new OctetSequenceJsonWebKey(params);
                    return jsonWebKey;
                default:
                    Throwable th2 = th;
                    new StringBuilder();
                    new JoseException(sb.append("Unknown key type algorithm: '").append(kty).append("'").toString());
                    throw th2;
            }
        }

        public static JsonWebKey newJwk(Key key) throws JoseException {
            JsonWebKey jsonWebKey;
            Throwable th;
            StringBuilder sb;
            JsonWebKey jsonWebKey2;
            JsonWebKey jsonWebKey3;
            Key key2 = key;
            if (RSAPublicKey.class.isInstance(key2)) {
                new RsaJsonWebKey((RSAPublicKey) key2);
                return jsonWebKey3;
            } else if (ECPublicKey.class.isInstance(key2)) {
                new EllipticCurveJsonWebKey((ECPublicKey) key2);
                return jsonWebKey2;
            } else if (PublicKey.class.isInstance(key2)) {
                Throwable th2 = th;
                new StringBuilder();
                new JoseException(sb.append("Unsupported or unknown public key ").append(key2).toString());
                throw th2;
            } else {
                new OctetSequenceJsonWebKey(key2);
                return jsonWebKey;
            }
        }

        public static JsonWebKey newJwk(String json) throws JoseException {
            return newJwk(JsonUtil.parseJson(json));
        }
    }
}
