package org.jose4j.lang;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

public class HashUtil {
    public static final String SHA_256 = "SHA-256";

    public HashUtil() {
    }

    public static MessageDigest getMessageDigest(String alg) {
        return getMessageDigest(alg, (String) null);
    }

    public static MessageDigest getMessageDigest(String str, String str2) {
        MessageDigest instance;
        Throwable th;
        StringBuilder sb;
        Throwable th2;
        StringBuilder sb2;
        String alg = str;
        String provider = str2;
        if (provider == null) {
            try {
                instance = MessageDigest.getInstance(alg);
            } catch (NoSuchAlgorithmException e) {
                NoSuchAlgorithmException noSuchAlgorithmException = e;
                Throwable th3 = th2;
                new StringBuilder();
                new UncheckedJoseException(sb2.append("Unable to get MessageDigest instance with ").append(alg).toString());
                throw th3;
            } catch (NoSuchProviderException e2) {
                NoSuchProviderException e3 = e2;
                Throwable th4 = th;
                new StringBuilder();
                new UncheckedJoseException(sb.append("Unable to get a MessageDigest implementation of algorithm name: ").append(alg).append(" using provider ").append(provider).toString(), e3);
                throw th4;
            }
        } else {
            instance = MessageDigest.getInstance(alg, provider);
        }
        return instance;
    }
}
