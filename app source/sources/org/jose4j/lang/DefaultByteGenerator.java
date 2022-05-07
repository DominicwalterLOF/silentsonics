package org.jose4j.lang;

import java.security.SecureRandom;

public class DefaultByteGenerator implements ByteGenerator {
    private final SecureRandom random;

    public DefaultByteGenerator() {
        SecureRandom secureRandom;
        new SecureRandom();
        this.random = secureRandom;
    }

    public byte[] randomBytes(int length) {
        byte[] bytes = new byte[length];
        this.random.nextBytes(bytes);
        return bytes;
    }
}
