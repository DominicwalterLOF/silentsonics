package org.jose4j.keys.resolvers;

import java.security.Key;
import java.util.List;
import org.jose4j.jwk.JsonWebKey;
import org.jose4j.jwk.VerificationJwkSelector;
import org.jose4j.jws.JsonWebSignature;
import org.jose4j.jwx.JsonWebStructure;
import org.jose4j.lang.JoseException;
import org.jose4j.lang.UnresolvableKeyException;

public class JwksVerificationKeyResolver implements VerificationKeyResolver {
    private boolean disambiguateWithVerifySignature;
    private List<JsonWebKey> jsonWebKeys;
    private VerificationJwkSelector selector;

    public JwksVerificationKeyResolver(List<JsonWebKey> jsonWebKeys2) {
        VerificationJwkSelector verificationJwkSelector;
        new VerificationJwkSelector();
        this.selector = verificationJwkSelector;
        this.jsonWebKeys = jsonWebKeys2;
    }

    public Key resolveKey(JsonWebSignature jsonWebSignature, List<JsonWebStructure> list) throws UnresolvableKeyException {
        StringBuilder sb;
        Throwable th;
        JsonWebKey selected;
        StringBuilder sb2;
        Throwable th2;
        JsonWebSignature jws = jsonWebSignature;
        List<JsonWebStructure> list2 = list;
        try {
            if (this.disambiguateWithVerifySignature) {
                selected = this.selector.selectWithVerifySignatureDisambiguate(jws, this.jsonWebKeys);
            } else {
                selected = this.selector.select(jws, this.jsonWebKeys);
            }
            if (selected != null) {
                return selected.getKey();
            }
            new StringBuilder();
            StringBuilder sb3 = sb2;
            StringBuilder append = sb3.append("Unable to find a suitable verification key for JWS w/ header ").append(jws.getHeaders().getFullHeaderAsJsonString());
            StringBuilder append2 = sb3.append(" from JWKs ").append(this.jsonWebKeys);
            Throwable th3 = th2;
            new UnresolvableKeyException(sb3.toString());
            throw th3;
        } catch (JoseException e) {
            JoseException e2 = e;
            new StringBuilder();
            StringBuilder sb4 = sb;
            StringBuilder append3 = sb4.append("Unable to find a suitable verification key for JWS w/ header ").append(jws.getHeaders().getFullHeaderAsJsonString());
            StringBuilder append4 = sb4.append(" due to an unexpected exception (").append(e2).append(") selecting from keys: ").append(this.jsonWebKeys);
            Throwable th4 = th;
            new UnresolvableKeyException(sb4.toString(), e2);
            throw th4;
        }
    }

    public void setDisambiguateWithVerifySignature(boolean disambiguateWithVerifySignature2) {
        boolean z = disambiguateWithVerifySignature2;
        this.disambiguateWithVerifySignature = z;
    }
}
