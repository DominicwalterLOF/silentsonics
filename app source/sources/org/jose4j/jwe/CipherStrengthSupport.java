package org.jose4j.jwe;

import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import org.jose4j.lang.ByteUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CipherStrengthSupport {
    private static final Logger log = LoggerFactory.getLogger((Class<?>) CipherStrengthSupport.class);

    public CipherStrengthSupport() {
    }

    public static boolean isAvailable(String str, int keyByteLength) {
        boolean isAvailable;
        String algorithm = str;
        int bitKeyLength = ByteUtil.bitLength(keyByteLength);
        try {
            int maxAllowedKeyLength = Cipher.getMaxAllowedKeyLength(algorithm);
            isAvailable = bitKeyLength <= maxAllowedKeyLength;
            if (!isAvailable) {
                log.debug("max allowed key length for {} is {}", (Object) algorithm, (Object) Integer.valueOf(maxAllowedKeyLength));
            }
        } catch (NoSuchAlgorithmException e) {
            log.debug("Unknown/unsupported algorithm, {} {}", (Object) algorithm, (Object) e);
            isAvailable = false;
        }
        return isAvailable;
    }
}
