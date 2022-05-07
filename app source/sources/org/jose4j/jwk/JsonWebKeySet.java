package org.jose4j.jwk;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.jose4j.json.JsonUtil;
import org.jose4j.jwk.JsonWebKey;
import org.jose4j.lang.JoseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JsonWebKeySet {
    public static final String JWK_SET_MEMBER_NAME = "keys";
    private static final Logger log = LoggerFactory.getLogger((Class<?>) JsonWebKeySet.class);
    private List<JsonWebKey> keys;

    public JsonWebKeySet(String str) throws JoseException {
        List<JsonWebKey> list;
        Throwable th;
        String json = str;
        List<Map<String, Object>> jwkParamMapList = (List) JsonUtil.parseJson(json).get(JWK_SET_MEMBER_NAME);
        if (jwkParamMapList == null) {
            Throwable th2 = th;
            new JoseException("The JSON JWKS content does not include the keys member.");
            throw th2;
        }
        new ArrayList(jwkParamMapList.size());
        this.keys = list;
        for (Map<String, Object> jwkParamsMap : jwkParamMapList) {
            try {
                boolean add = this.keys.add(JsonWebKey.Factory.newJwk(jwkParamsMap));
            } catch (Exception e) {
                Exception e2 = e;
                Logger logger = log;
                Object[] objArr = new Object[3];
                objArr[0] = jwkParamsMap;
                Object[] objArr2 = objArr;
                objArr2[1] = json;
                Object[] objArr3 = objArr2;
                objArr3[2] = e2;
                logger.debug("Ignoring an individual JWK in a JWKS due to a problem processing it. JWK params: {} and the full JWKS content: {}. {}", objArr3);
            }
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public JsonWebKeySet(JsonWebKey... keys2) {
        this((List<? extends JsonWebKey>) Arrays.asList(keys2));
    }

    public JsonWebKeySet(List<? extends JsonWebKey> list) {
        List<JsonWebKey> list2;
        List<? extends JsonWebKey> keys2 = list;
        new ArrayList(keys2.size());
        this.keys = list2;
        for (JsonWebKey jwk : keys2) {
            boolean add = this.keys.add(jwk);
        }
    }

    public void addJsonWebKey(JsonWebKey jsonWebKey) {
        boolean add = this.keys.add(jsonWebKey);
    }

    public List<JsonWebKey> getJsonWebKeys() {
        return this.keys;
    }

    public JsonWebKey findJsonWebKey(String keyId, String keyType, String use, String algorithm) {
        List<JsonWebKey> found = findJsonWebKeys(keyId, keyType, use, algorithm);
        return found.isEmpty() ? null : found.iterator().next();
    }

    public List<JsonWebKey> findJsonWebKeys(String str, String str2, String str3, String str4) {
        List<JsonWebKey> list;
        String keyId = str;
        String keyType = str2;
        String use = str3;
        String algorithm = str4;
        new ArrayList();
        List<JsonWebKey> found = list;
        for (JsonWebKey jwk : this.keys) {
            boolean isMeetsCriteria = true;
            if (keyId != null) {
                isMeetsCriteria = keyId.equals(jwk.getKeyId());
            }
            if (use != null) {
                isMeetsCriteria &= use.equals(jwk.getUse());
            }
            if (keyType != null) {
                isMeetsCriteria &= keyType.equals(jwk.getKeyType());
            }
            if (algorithm != null) {
                isMeetsCriteria &= algorithm.equals(jwk.getAlgorithm());
            }
            if (isMeetsCriteria) {
                boolean add = found.add(jwk);
            }
        }
        return found;
    }

    public String toJson() {
        return toJson(JsonWebKey.OutputControlLevel.INCLUDE_SYMMETRIC);
    }

    public String toJson(JsonWebKey.OutputControlLevel outputControlLevel) {
        List<Map<String, Object>> list;
        Map<String, Object> map;
        JsonWebKey.OutputControlLevel outputControlLevel2 = outputControlLevel;
        new ArrayList<>(this.keys.size());
        List<Map<String, Object>> keyList = list;
        for (JsonWebKey key : this.keys) {
            boolean add = keyList.add(key.toParams(outputControlLevel2));
        }
        new LinkedHashMap<>();
        Map<String, Object> jwks = map;
        Object put = jwks.put(JWK_SET_MEMBER_NAME, keyList);
        return JsonUtil.toJson(jwks);
    }
}
