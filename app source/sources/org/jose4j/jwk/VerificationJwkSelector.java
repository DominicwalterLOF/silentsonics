package org.jose4j.jwk;

import java.util.Collection;
import java.util.List;
import org.jose4j.jws.EcdsaUsingShaAlgorithm;
import org.jose4j.jws.JsonWebSignature;
import org.jose4j.lang.JoseException;

public class VerificationJwkSelector {
    public VerificationJwkSelector() {
    }

    public JsonWebKey select(JsonWebSignature jws, Collection<JsonWebKey> keys) throws JoseException {
        List<JsonWebKey> jsonWebKeys = selectList(jws, keys);
        return jsonWebKeys.isEmpty() ? null : jsonWebKeys.get(0);
    }

    public List<JsonWebKey> selectList(JsonWebSignature jsonWebSignature, Collection<JsonWebKey> keys) throws JoseException {
        JsonWebSignature jws = jsonWebSignature;
        SimpleJwkFilter filter = SelectorSupport.filterForInboundSigned(jws);
        List<JsonWebKey> filtered = filter.filter(keys);
        if (hasMoreThanOne(filtered)) {
            filter.setAlg(jws.getAlgorithmHeaderValue(), SimpleJwkFilter.OMITTED_OKAY);
            filtered = filter.filter(filtered);
        }
        if (hasMoreThanOne(filtered) && "EC".equals(jws.getKeyType())) {
            filter.setCrv(((EcdsaUsingShaAlgorithm) jws.getAlgorithmNoConstraintCheck()).getCurveName(), SimpleJwkFilter.OMITTED_OKAY);
            filtered = filter.filter(filtered);
        }
        return filtered;
    }

    public JsonWebKey selectWithVerifySignatureDisambiguate(JsonWebSignature jsonWebSignature, Collection<JsonWebKey> keys) throws JoseException {
        JsonWebSignature jws = jsonWebSignature;
        List<JsonWebKey> jsonWebKeys = selectList(jws, keys);
        if (jsonWebKeys.isEmpty()) {
            return null;
        }
        if (jsonWebKeys.size() == 1) {
            return jsonWebKeys.get(0);
        }
        for (JsonWebKey jwk : jsonWebKeys) {
            jws.setKey(jwk.getKey());
            if (jws.verifySignature()) {
                return jwk;
            }
        }
        return null;
    }

    private boolean hasMoreThanOne(List<JsonWebKey> filtered) {
        return filtered.size() > 1;
    }
}
