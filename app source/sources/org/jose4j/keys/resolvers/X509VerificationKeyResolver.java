package org.jose4j.keys.resolvers;

import com.shaded.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import java.security.Key;
import java.security.PublicKey;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.jose4j.jws.JsonWebSignature;
import org.jose4j.jwx.JsonWebStructure;
import org.jose4j.keys.X509Util;
import org.jose4j.lang.ExceptionHelp;
import org.jose4j.lang.JoseException;
import org.jose4j.lang.UncheckedJoseException;
import org.jose4j.lang.UnresolvableKeyException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class X509VerificationKeyResolver implements VerificationKeyResolver {
    private static final Logger log = LoggerFactory.getLogger((Class<?>) X509VerificationKeyResolver.class);
    private boolean tryAllOnNoThumbHeader;
    private Map<String, X509Certificate> x5tMap;
    private Map<String, X509Certificate> x5tS256Map;

    public X509VerificationKeyResolver(List<X509Certificate> certificates) {
        Map<String, X509Certificate> map;
        Map<String, X509Certificate> map2;
        new LinkedHashMap();
        this.x5tMap = map;
        new LinkedHashMap();
        this.x5tS256Map = map2;
        for (X509Certificate cert : certificates) {
            try {
                X509Certificate put = this.x5tMap.put(X509Util.x5t(cert), cert);
                X509Certificate put2 = this.x5tS256Map.put(X509Util.x5tS256(cert), cert);
            } catch (UncheckedJoseException e) {
                log.warn("Unable to get certificate thumbprint.", (Throwable) e);
            }
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public X509VerificationKeyResolver(X509Certificate... certificates) {
        this((List<X509Certificate>) Arrays.asList(certificates));
    }

    public void setTryAllOnNoThumbHeader(boolean tryAllOnNoThumbHeader2) {
        boolean z = tryAllOnNoThumbHeader2;
        this.tryAllOnNoThumbHeader = z;
    }

    public Key resolveKey(JsonWebSignature jsonWebSignature, List<JsonWebStructure> list) throws UnresolvableKeyException {
        StringBuilder sb;
        Throwable th;
        Throwable th2;
        JsonWebSignature jws = jsonWebSignature;
        List<JsonWebStructure> list2 = list;
        String x5t = jws.getX509CertSha1ThumbprintHeaderValue();
        String x5tS256 = jws.getX509CertSha256ThumbprintHeaderValue();
        if (x5t != null || x5tS256 != null) {
            X509Certificate x509Certificate = this.x5tMap.get(x5t);
            if (x509Certificate == null) {
                x509Certificate = this.x5tS256Map.get(x5tS256);
            }
            if (x509Certificate != null) {
                return x509Certificate.getPublicKey();
            }
            new StringBuilder();
            StringBuilder sb2 = sb;
            StringBuilder append = sb2.append("The X.509 Certificate Thumbprint header(s) in the JWS do not identify any of the provided Certificates -");
            if (x5t != null) {
                StringBuilder append2 = sb2.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR).append("x5t").append("=").append(x5t);
                StringBuilder append3 = sb2.append(" vs. SHA-1 thumbs:").append(this.x5tMap.keySet());
            }
            if (x5tS256 != null) {
                StringBuilder append4 = sb2.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR).append("x5t#S256").append("=").append(x5tS256);
                StringBuilder append5 = sb2.append(" vs. SHA-256 thumbs:").append(this.x5tS256Map.keySet());
            }
            StringBuilder append6 = sb2.append(".");
            Throwable th3 = th;
            new UnresolvableKeyException(sb2.toString());
            throw th3;
        } else if (this.tryAllOnNoThumbHeader) {
            return attemptAll(jws);
        } else {
            Throwable th4 = th2;
            new UnresolvableKeyException("Neither the x5t header nor the x5t#S256 header are present in the JWS.");
            throw th4;
        }
    }

    private Key attemptAll(JsonWebSignature jsonWebSignature) throws UnresolvableKeyException {
        StringBuilder sb;
        Throwable th;
        JsonWebSignature jws = jsonWebSignature;
        for (X509Certificate certificate : this.x5tMap.values()) {
            PublicKey publicKey = certificate.getPublicKey();
            jws.setKey(publicKey);
            try {
                if (jws.verifySignature()) {
                    return publicKey;
                }
            } catch (JoseException e) {
                log.debug("Verify signature didn't work: {}", (Object) ExceptionHelp.toStringWithCauses(e));
            }
        }
        new StringBuilder();
        StringBuilder sb2 = sb;
        StringBuilder append = sb2.append("Unable to verify the signature with any of the provided keys - SHA-1 thumbs of provided certificates: ");
        StringBuilder append2 = sb2.append(this.x5tMap.keySet());
        StringBuilder append3 = sb2.append(".");
        Throwable th2 = th;
        new UnresolvableKeyException(sb2.toString());
        throw th2;
    }
}
