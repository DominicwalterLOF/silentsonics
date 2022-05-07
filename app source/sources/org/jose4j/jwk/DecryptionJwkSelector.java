package org.jose4j.jwk;

import java.util.Collection;
import java.util.List;
import org.jose4j.jwe.JsonWebEncryption;
import org.jose4j.lang.JoseException;

public class DecryptionJwkSelector {
    public DecryptionJwkSelector() {
    }

    public JsonWebKey select(JsonWebEncryption jwe, Collection<JsonWebKey> keys) throws JoseException {
        List<JsonWebKey> jsonWebKeys = selectList(jwe, keys);
        return jsonWebKeys.isEmpty() ? null : jsonWebKeys.get(0);
    }

    public List<JsonWebKey> selectList(JsonWebEncryption jwe, Collection<JsonWebKey> keys) throws JoseException {
        return SelectorSupport.filterForInboundEncrypted(jwe).filter(keys);
    }
}
