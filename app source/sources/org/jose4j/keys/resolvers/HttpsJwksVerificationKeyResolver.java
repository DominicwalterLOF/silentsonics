package org.jose4j.keys.resolvers;

import java.io.IOException;
import java.security.Key;
import java.util.List;
import org.jose4j.jwk.HttpsJwks;
import org.jose4j.jwk.JsonWebKey;
import org.jose4j.jwk.VerificationJwkSelector;
import org.jose4j.jws.JsonWebSignature;
import org.jose4j.jwx.JsonWebStructure;
import org.jose4j.lang.JoseException;
import org.jose4j.lang.UnresolvableKeyException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HttpsJwksVerificationKeyResolver implements VerificationKeyResolver {
    private static final Logger log = LoggerFactory.getLogger((Class<?>) HttpsJwksVerificationKeyResolver.class);
    private boolean disambiguateWithVerifySignature;
    private HttpsJwks httpsJkws;
    private VerificationJwkSelector verificationJwkSelector;

    public HttpsJwksVerificationKeyResolver(HttpsJwks httpsJkws2) {
        VerificationJwkSelector verificationJwkSelector2;
        new VerificationJwkSelector();
        this.verificationJwkSelector = verificationJwkSelector2;
        this.httpsJkws = httpsJkws2;
    }

    public Key resolveKey(JsonWebSignature jsonWebSignature, List<JsonWebStructure> list) throws UnresolvableKeyException {
        StringBuilder sb;
        Throwable th;
        StringBuilder sb2;
        Throwable th2;
        JsonWebSignature jws = jsonWebSignature;
        List<JsonWebStructure> list2 = list;
        try {
            List<JsonWebKey> jsonWebKeys = this.httpsJkws.getJsonWebKeys();
            JsonWebKey theChosenOne = select(jws, jsonWebKeys);
            if (theChosenOne == null) {
                Logger logger = log;
                Object[] objArr = new Object[3];
                objArr[0] = this.httpsJkws.getLocation();
                Object[] objArr2 = objArr;
                objArr2[1] = jws.getHeaders().getFullHeaderAsJsonString();
                Object[] objArr3 = objArr2;
                objArr3[2] = jsonWebKeys;
                logger.debug("Refreshing JWKs from {} as no suitable verification key for JWS w/ header {} was found in {}", objArr3);
                this.httpsJkws.refresh();
                jsonWebKeys = this.httpsJkws.getJsonWebKeys();
                theChosenOne = select(jws, jsonWebKeys);
            }
            if (theChosenOne != null) {
                return theChosenOne.getKey();
            }
            new StringBuilder();
            StringBuilder sb3 = sb2;
            StringBuilder append = sb3.append("Unable to find a suitable verification key for JWS w/ header ").append(jws.getHeaders().getFullHeaderAsJsonString());
            StringBuilder append2 = sb3.append(" from JWKs ").append(jsonWebKeys).append(" obtained from ").append(this.httpsJkws.getLocation());
            Throwable th3 = th2;
            new UnresolvableKeyException(sb3.toString());
            throw th3;
        } catch (IOException | JoseException e) {
            Exception e2 = e;
            new StringBuilder();
            StringBuilder sb4 = sb;
            StringBuilder append3 = sb4.append("Unable to find a suitable verification key for JWS w/ header ").append(jws.getHeaders().getFullHeaderAsJsonString());
            StringBuilder append4 = sb4.append(" due to an unexpected exception (").append(e2).append(") while obtaining or using keys from JWKS endpoint at ").append(this.httpsJkws.getLocation());
            Throwable th4 = th;
            new UnresolvableKeyException(sb4.toString(), e2);
            throw th4;
        }
    }

    /* access modifiers changed from: protected */
    public JsonWebKey select(JsonWebSignature jsonWebSignature, List<JsonWebKey> list) throws JoseException {
        JsonWebSignature jws = jsonWebSignature;
        List<JsonWebKey> jsonWebKeys = list;
        if (this.disambiguateWithVerifySignature) {
            return this.verificationJwkSelector.selectWithVerifySignatureDisambiguate(jws, jsonWebKeys);
        }
        return this.verificationJwkSelector.select(jws, jsonWebKeys);
    }

    public void setDisambiguateWithVerifySignature(boolean disambiguateWithVerifySignature2) {
        boolean z = disambiguateWithVerifySignature2;
        this.disambiguateWithVerifySignature = z;
    }
}
