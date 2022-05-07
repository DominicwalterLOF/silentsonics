package org.jose4j.jws;

import java.security.Key;
import org.jose4j.jca.ProviderContext;
import org.jose4j.jwa.AlgorithmInfo;
import org.jose4j.keys.KeyPersuasion;
import org.jose4j.lang.ByteUtil;
import org.jose4j.lang.InvalidKeyException;
import org.jose4j.lang.JoseException;

public class PlaintextNoneAlgorithm extends AlgorithmInfo implements JsonWebSignatureAlgorithm {
    private static final String CANNOT_HAVE_KEY_MESSAGE = "JWS Plaintext (alg=none) must not use a key.";

    public PlaintextNoneAlgorithm() {
        setAlgorithmIdentifier(AlgorithmIdentifiers.NONE);
        setKeyPersuasion(KeyPersuasion.NONE);
    }

    public boolean verifySignature(byte[] signatureBytes, Key key, byte[] bArr, ProviderContext providerContext) throws JoseException {
        byte[] bArr2 = bArr;
        ProviderContext providerContext2 = providerContext;
        validateKey(key);
        return signatureBytes.length == 0;
    }

    public byte[] sign(Key key, byte[] bArr, ProviderContext providerContext) throws JoseException {
        byte[] bArr2 = bArr;
        ProviderContext providerContext2 = providerContext;
        validateKey(key);
        return ByteUtil.EMPTY_BYTES;
    }

    public void validateSigningKey(Key key) throws InvalidKeyException {
        validateKey(key);
    }

    public void validateVerificationKey(Key key) throws InvalidKeyException {
        validateKey(key);
    }

    private void validateKey(Key key) throws InvalidKeyException {
        Throwable th;
        if (key != null) {
            Throwable th2 = th;
            new InvalidKeyException(CANNOT_HAVE_KEY_MESSAGE);
            throw th2;
        }
    }

    public boolean isAvailable() {
        return true;
    }
}
