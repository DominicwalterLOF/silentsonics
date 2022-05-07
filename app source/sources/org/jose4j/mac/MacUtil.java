package org.jose4j.mac;

import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import javax.crypto.Mac;
import org.jose4j.lang.InvalidKeyException;
import org.jose4j.lang.JoseException;

public class MacUtil {
    public static final String HMAC_SHA256 = "HmacSHA256";
    public static final String HMAC_SHA384 = "HmacSHA384";
    public static final String HMAC_SHA512 = "HmacSHA512";

    public MacUtil() {
    }

    public static Mac getInitializedMac(String algorithm, Key key) throws JoseException {
        return getInitializedMac(algorithm, key, (String) null);
    }

    public static Mac getInitializedMac(String algorithm, Key key, String provider) throws JoseException {
        Mac mac = getMac(algorithm, provider);
        initMacWithKey(mac, key);
        return mac;
    }

    public static Mac getMac(String algorithm) throws JoseException {
        return getMac(algorithm, (String) null);
    }

    public static Mac getMac(String str, String str2) throws JoseException {
        Mac instance;
        Throwable th;
        StringBuilder sb;
        Throwable th2;
        StringBuilder sb2;
        String algorithm = str;
        String provider = str2;
        if (provider == null) {
            try {
                instance = Mac.getInstance(algorithm);
            } catch (NoSuchAlgorithmException e) {
                NoSuchAlgorithmException e2 = e;
                Throwable th3 = th2;
                new StringBuilder();
                new JoseException(sb2.append("Unable to get a MAC implementation of algorithm name: ").append(algorithm).toString(), e2);
                throw th3;
            } catch (NoSuchProviderException e3) {
                NoSuchProviderException e4 = e3;
                Throwable th4 = th;
                new StringBuilder();
                new JoseException(sb.append("Unable to get a MAC implementation of algorithm name: ").append(algorithm).append(" using provider ").append(provider).toString(), e4);
                throw th4;
            }
        } else {
            instance = Mac.getInstance(algorithm, provider);
        }
        return instance;
    }

    public static void initMacWithKey(Mac mac, Key key) throws InvalidKeyException {
        Throwable th;
        StringBuilder sb;
        Mac mac2 = mac;
        try {
            mac2.init(key);
        } catch (java.security.InvalidKeyException e) {
            java.security.InvalidKeyException e2 = e;
            Throwable th2 = th;
            new StringBuilder();
            new InvalidKeyException(sb.append("Key is not valid for ").append(mac2.getAlgorithm()).append(" - ").append(e2).toString(), e2);
            throw th2;
        }
    }
}
