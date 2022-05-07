package org.jose4j.keys.resolvers;

import java.security.Key;
import java.util.List;
import org.jose4j.jwe.JsonWebEncryption;
import org.jose4j.jwk.DecryptionJwkSelector;
import org.jose4j.jwk.JsonWebKey;
import org.jose4j.jwk.PublicJsonWebKey;
import org.jose4j.jwx.JsonWebStructure;
import org.jose4j.lang.JoseException;
import org.jose4j.lang.UnresolvableKeyException;

public class JwksDecryptionKeyResolver implements DecryptionKeyResolver {
    private List<JsonWebKey> jsonWebKeys;
    private DecryptionJwkSelector selector;

    public JwksDecryptionKeyResolver(List<JsonWebKey> jsonWebKeys2) {
        DecryptionJwkSelector decryptionJwkSelector;
        new DecryptionJwkSelector();
        this.selector = decryptionJwkSelector;
        this.jsonWebKeys = jsonWebKeys2;
    }

    public Key resolveKey(JsonWebEncryption jsonWebEncryption, List<JsonWebStructure> list) throws UnresolvableKeyException {
        StringBuilder sb;
        Throwable th;
        StringBuilder sb2;
        Throwable th2;
        JsonWebEncryption jwe = jsonWebEncryption;
        List<JsonWebStructure> list2 = list;
        try {
            JsonWebKey selected = this.selector.select(jwe, this.jsonWebKeys);
            if (selected == null) {
                new StringBuilder();
                StringBuilder sb3 = sb2;
                StringBuilder append = sb3.append("Unable to find a suitable key for JWE w/ header ").append(jwe.getHeaders().getFullHeaderAsJsonString());
                StringBuilder append2 = sb3.append(" from JWKs ").append(this.jsonWebKeys);
                Throwable th3 = th2;
                new UnresolvableKeyException(sb3.toString());
                throw th3;
            }
            return selected instanceof PublicJsonWebKey ? ((PublicJsonWebKey) selected).getPrivateKey() : selected.getKey();
        } catch (JoseException e) {
            JoseException e2 = e;
            new StringBuilder();
            StringBuilder sb4 = sb;
            StringBuilder append3 = sb4.append("Unable to find a suitable key for JWE w/ header ").append(jwe.getHeaders().getFullHeaderAsJsonString());
            StringBuilder append4 = sb4.append(" due to an unexpected exception (").append(e2).append(") selecting from keys: ").append(this.jsonWebKeys);
            Throwable th4 = th;
            new UnresolvableKeyException(sb4.toString(), e2);
            throw th4;
        }
    }
}
