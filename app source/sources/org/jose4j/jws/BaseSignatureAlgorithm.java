package org.jose4j.jws;

import com.shaded.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import java.security.InvalidAlgorithmParameterException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.AlgorithmParameterSpec;
import org.jose4j.jca.ProviderContext;
import org.jose4j.jwa.AlgorithmInfo;
import org.jose4j.keys.KeyPersuasion;
import org.jose4j.lang.ExceptionHelp;
import org.jose4j.lang.InvalidKeyException;
import org.jose4j.lang.JoseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class BaseSignatureAlgorithm extends AlgorithmInfo implements JsonWebSignatureAlgorithm {
    private AlgorithmParameterSpec algorithmParameterSpec;
    private final Logger log = LoggerFactory.getLogger(getClass());

    public abstract void validatePrivateKey(PrivateKey privateKey) throws InvalidKeyException;

    public abstract void validatePublicKey(PublicKey publicKey) throws InvalidKeyException;

    public BaseSignatureAlgorithm(String id, String javaAlgo, String keyAlgo) {
        setAlgorithmIdentifier(id);
        setJavaAlgorithm(javaAlgo);
        setKeyPersuasion(KeyPersuasion.ASYMMETRIC);
        setKeyType(keyAlgo);
    }

    /* access modifiers changed from: protected */
    public void setAlgorithmParameterSpec(AlgorithmParameterSpec algorithmParameterSpec2) {
        AlgorithmParameterSpec algorithmParameterSpec3 = algorithmParameterSpec2;
        this.algorithmParameterSpec = algorithmParameterSpec3;
    }

    public boolean verifySignature(byte[] bArr, Key key, byte[] securedInputBytes, ProviderContext providerContext) throws JoseException {
        StringBuilder sb;
        byte[] signatureBytes = bArr;
        Signature signature = getSignature(providerContext);
        initForVerify(signature, key);
        try {
            signature.update(securedInputBytes);
            return signature.verify(signatureBytes);
        } catch (SignatureException e) {
            SignatureException e2 = e;
            if (this.log.isDebugEnabled()) {
                Logger logger = this.log;
                new StringBuilder();
                logger.debug(sb.append("Problem verifying signature: ").append(e2).toString());
            }
            return false;
        }
    }

    public byte[] sign(Key key, byte[] securedInputBytes, ProviderContext providerContext) throws JoseException {
        Throwable th;
        ProviderContext providerContext2 = providerContext;
        Signature signature = getSignature(providerContext2);
        initForSign(signature, key, providerContext2);
        try {
            signature.update(securedInputBytes);
            return signature.sign();
        } catch (SignatureException e) {
            SignatureException e2 = e;
            Throwable th2 = th;
            new JoseException("Problem creating signature.", e2);
            throw th2;
        }
    }

    private void initForSign(Signature signature, Key key, ProviderContext providerContext) throws InvalidKeyException {
        Throwable th;
        StringBuilder sb;
        Signature signature2 = signature;
        Key key2 = key;
        try {
            PrivateKey privateKey = (PrivateKey) key2;
            SecureRandom secureRandom = providerContext.getSecureRandom();
            if (secureRandom == null) {
                signature2.initSign(privateKey);
            } else {
                signature2.initSign(privateKey, secureRandom);
            }
        } catch (java.security.InvalidKeyException e) {
            java.security.InvalidKeyException e2 = e;
            Throwable th2 = th;
            new StringBuilder();
            new InvalidKeyException(sb.append(getBadKeyMessage(key2)).append("for ").append(getJavaAlgorithm()).toString(), e2);
            throw th2;
        }
    }

    private void initForVerify(Signature signature, Key key) throws InvalidKeyException {
        Throwable th;
        StringBuilder sb;
        Key key2 = key;
        try {
            signature.initVerify((PublicKey) key2);
        } catch (java.security.InvalidKeyException e) {
            java.security.InvalidKeyException e2 = e;
            Throwable th2 = th;
            new StringBuilder();
            new InvalidKeyException(sb.append(getBadKeyMessage(key2)).append("for ").append(getJavaAlgorithm()).toString(), e2);
            throw th2;
        }
    }

    private String getBadKeyMessage(Key key) {
        StringBuilder sb;
        String sb2;
        StringBuilder sb3;
        Key key2 = key;
        if (key2 == null) {
            sb2 = "key is null";
        } else {
            new StringBuilder();
            sb2 = sb.append("algorithm=").append(key2.getAlgorithm()).toString();
        }
        String msg = sb2;
        new StringBuilder();
        return sb3.append("The given key (").append(msg).append(") is not valid ").toString();
    }

    private Signature getSignature(ProviderContext providerContext) throws JoseException {
        Throwable th;
        StringBuilder sb;
        Throwable th2;
        StringBuilder sb2;
        Throwable th3;
        StringBuilder sb3;
        Signature instance;
        StringBuilder sb4;
        String sigProvider = providerContext.getSuppliedKeyProviderContext().getSignatureProvider();
        String javaAlg = getJavaAlgorithm();
        if (sigProvider == null) {
            try {
                instance = Signature.getInstance(javaAlg);
            } catch (NoSuchAlgorithmException e) {
                NoSuchAlgorithmException e2 = e;
                Throwable th4 = th3;
                new StringBuilder();
                new JoseException(sb3.append("Unable to get an implementation of algorithm name: ").append(javaAlg).toString(), e2);
                throw th4;
            } catch (InvalidAlgorithmParameterException e3) {
                InvalidAlgorithmParameterException e4 = e3;
                Throwable th5 = th2;
                new StringBuilder();
                new JoseException(sb2.append("Invalid algorithm parameter (").append(this.algorithmParameterSpec).append(") for: ").append(javaAlg).toString(), e4);
                throw th5;
            } catch (NoSuchProviderException e5) {
                NoSuchProviderException e6 = e5;
                Throwable th6 = th;
                new StringBuilder();
                new JoseException(sb.append("Unable to get an implementation of ").append(javaAlg).append(" for provider ").append(sigProvider).toString(), e6);
                throw th6;
            }
        } else {
            instance = Signature.getInstance(javaAlg, sigProvider);
        }
        Signature signature = instance;
        if (this.algorithmParameterSpec != null) {
            try {
                signature.setParameter(this.algorithmParameterSpec);
            } catch (UnsupportedOperationException e7) {
                UnsupportedOperationException e8 = e7;
                if (this.log.isDebugEnabled()) {
                    Logger logger = this.log;
                    new StringBuilder();
                    logger.debug(sb4.append("Unable to set algorithm parameter spec on Signature (java algorithm name: ").append(javaAlg).append(") so ignoring the UnsupportedOperationException and relying on the default parameters.").toString(), (Throwable) e8);
                }
            }
        }
        return signature;
    }

    public void validateSigningKey(Key key) throws InvalidKeyException {
        Throwable th;
        StringBuilder sb;
        Key key2 = key;
        checkForNullKey(key2);
        try {
            validatePrivateKey((PrivateKey) key2);
        } catch (ClassCastException e) {
            ClassCastException e2 = e;
            Throwable th2 = th;
            new StringBuilder();
            new InvalidKeyException(sb.append(getBadKeyMessage(key2)).append("(not a private key or is the wrong type of key) for ").append(getJavaAlgorithm()).append(" / ").append(getAlgorithmIdentifier()).append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR).append(e2).toString());
            throw th2;
        }
    }

    public void validateVerificationKey(Key key) throws InvalidKeyException {
        Throwable th;
        StringBuilder sb;
        Key key2 = key;
        checkForNullKey(key2);
        try {
            validatePublicKey((PublicKey) key2);
        } catch (ClassCastException e) {
            ClassCastException e2 = e;
            Throwable th2 = th;
            new StringBuilder();
            new InvalidKeyException(sb.append(getBadKeyMessage(key2)).append("(not a public key or is the wrong type of key) for ").append(getJavaAlgorithm()).append("/").append(getAlgorithmIdentifier()).append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR).append(e2).toString());
            throw th2;
        }
    }

    private void checkForNullKey(Key key) throws InvalidKeyException {
        Throwable th;
        if (key == null) {
            Throwable th2 = th;
            new InvalidKeyException("Key cannot be null");
            throw th2;
        }
    }

    public boolean isAvailable() {
        StringBuilder sb;
        ProviderContext providerContext;
        try {
            new ProviderContext();
            return getSignature(providerContext) != null;
        } catch (Exception e) {
            Exception e2 = e;
            Logger logger = this.log;
            new StringBuilder();
            logger.debug(sb.append(getAlgorithmIdentifier()).append(" vai ").append(getJavaAlgorithm()).append(" is NOT available from the underlying JCE (").append(ExceptionHelp.toStringWithCauses(e2)).append(").").toString());
            return false;
        }
    }
}
