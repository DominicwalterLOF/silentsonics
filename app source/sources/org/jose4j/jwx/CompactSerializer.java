package org.jose4j.jwx;

public class CompactSerializer {
    private static final String EMPTY_STRING = "";
    private static final String PERIOD_SEPARATOR = ".";
    private static final String PERIOD_SEPARATOR_REGEX = "\\.";

    public CompactSerializer() {
    }

    public static String[] deserialize(String str) {
        String compactSerialization = str;
        String[] parts = compactSerialization.split(PERIOD_SEPARATOR_REGEX);
        if (compactSerialization.endsWith(PERIOD_SEPARATOR)) {
            String[] tempParts = new String[(parts.length + 1)];
            System.arraycopy(parts, 0, tempParts, 0, parts.length);
            tempParts[parts.length] = "";
            parts = tempParts;
        }
        return parts;
    }

    public static String serialize(String... strArr) {
        StringBuilder sb;
        String[] parts = strArr;
        new StringBuilder();
        StringBuilder sb2 = sb;
        for (int i = 0; i < parts.length; i++) {
            StringBuilder append = sb2.append(parts[i] == null ? "" : parts[i]);
            if (i != parts.length - 1) {
                StringBuilder append2 = sb2.append(PERIOD_SEPARATOR);
            }
        }
        return sb2.toString();
    }
}
