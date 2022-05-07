package org.jose4j.jws;

import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Security;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.MGF1ParameterSpec;
import java.security.spec.PSSParameterSpec;
import org.jose4j.jwx.KeyValidationSupport;
import org.jose4j.lang.InvalidKeyException;

public class RsaUsingShaAlgorithm extends BaseSignatureAlgorithm implements JsonWebSignatureAlgorithm {
    static final String MGF1 = "MGF1";
    public static final String RSASSA_PSS = "RSASSA-PSS";
    static final int TRAILER = 1;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RsaUsingShaAlgorithm(String id, String javaAlgo) {
        super(id, javaAlgo, "RSA");
    }

    public void validatePublicKey(PublicKey key) throws InvalidKeyException {
        KeyValidationSupport.checkRsaKeySize(key);
    }

    public void validatePrivateKey(PrivateKey privateKey) throws InvalidKeyException {
        KeyValidationSupport.checkRsaKeySize(privateKey);
    }

    public static class RsaPssSha256 extends RsaUsingShaAlgorithm {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public RsaPssSha256() {
            super(AlgorithmIdentifiers.RSA_PSS_USING_SHA256, choosePssAlgorithmName("SHA256withRSAandMGF1"));
            AlgorithmParameterSpec algorithmParameterSpec;
            MGF1ParameterSpec mgf1pec = MGF1ParameterSpec.SHA256;
            new PSSParameterSpec(mgf1pec.getDigestAlgorithm(), RsaUsingShaAlgorithm.MGF1, mgf1pec, 32, 1);
            setAlgorithmParameterSpec(algorithmParameterSpec);
        }
    }

    public static class RsaPssSha384 extends RsaUsingShaAlgorithm {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public RsaPssSha384() {
            super(AlgorithmIdentifiers.RSA_PSS_USING_SHA384, choosePssAlgorithmName("SHA384withRSAandMGF1"));
            AlgorithmParameterSpec algorithmParameterSpec;
            MGF1ParameterSpec mgf1pec = MGF1ParameterSpec.SHA384;
            new PSSParameterSpec(mgf1pec.getDigestAlgorithm(), RsaUsingShaAlgorithm.MGF1, mgf1pec, 48, 1);
            setAlgorithmParameterSpec(algorithmParameterSpec);
        }
    }

    public static class RsaPssSha512 extends RsaUsingShaAlgorithm {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public RsaPssSha512() {
            super(AlgorithmIdentifiers.RSA_PSS_USING_SHA512, choosePssAlgorithmName("SHA512withRSAandMGF1"));
            AlgorithmParameterSpec algorithmParameterSpec;
            MGF1ParameterSpec mgf1pec = MGF1ParameterSpec.SHA512;
            new PSSParameterSpec(mgf1pec.getDigestAlgorithm(), RsaUsingShaAlgorithm.MGF1, mgf1pec, 64, 1);
            setAlgorithmParameterSpec(algorithmParameterSpec);
        }
    }

    public static class RsaSha256 extends RsaUsingShaAlgorithm {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public RsaSha256() {
            super(AlgorithmIdentifiers.RSA_USING_SHA256, "SHA256withRSA");
        }
    }

    public static class RsaSha384 extends RsaUsingShaAlgorithm {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public RsaSha384() {
            super(AlgorithmIdentifiers.RSA_USING_SHA384, "SHA384withRSA");
        }
    }

    public static class RsaSha512 extends RsaUsingShaAlgorithm {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public RsaSha512() {
            super(AlgorithmIdentifiers.RSA_USING_SHA512, "SHA512withRSA");
        }
    }

    static String choosePssAlgorithmName(String str) {
        String legacyName = str;
        for (String sigAlg : Security.getAlgorithms("Signature")) {
            if (RSASSA_PSS.equalsIgnoreCase(sigAlg)) {
                return sigAlg;
            }
        }
        return legacyName;
    }
}
