package org.jose4j.jwx;

import org.jose4j.lang.JoseException;

public class CompactSerialization {
    public CompactSerialization() {
    }

    public static String[] deserialize(String cs) {
        return CompactSerializer.deserialize(cs);
    }

    public static String serialize(String... parts) throws JoseException {
        return CompactSerializer.serialize(parts);
    }
}
