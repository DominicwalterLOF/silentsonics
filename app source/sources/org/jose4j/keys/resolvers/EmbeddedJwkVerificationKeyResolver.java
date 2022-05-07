package org.jose4j.keys.resolvers;

import java.security.Key;
import java.util.List;
import org.jose4j.jwk.PublicJsonWebKey;
import org.jose4j.jws.JsonWebSignature;
import org.jose4j.jwx.JsonWebStructure;
import org.jose4j.lang.JoseException;
import org.jose4j.lang.UnresolvableKeyException;

public class EmbeddedJwkVerificationKeyResolver implements VerificationKeyResolver {
    private PublicJsonWebKey jwk;

    public EmbeddedJwkVerificationKeyResolver() {
    }

    public Key resolveKey(JsonWebSignature jws, List<JsonWebStructure> list) throws UnresolvableKeyException {
        Throwable th;
        Throwable th2;
        List<JsonWebStructure> list2 = list;
        try {
            this.jwk = jws.getJwkHeader();
            if (this.jwk != null) {
                return this.jwk.getKey();
            }
            Throwable th3 = th2;
            new UnresolvableKeyException("No jwk in JWS header");
            throw th3;
        } catch (JoseException e) {
            JoseException e2 = e;
            Throwable th4 = th;
            new UnresolvableKeyException("Problem processing jwk from JWS header", e2);
            throw th4;
        }
    }

    public PublicJsonWebKey getJwk() {
        return this.jwk;
    }
}
