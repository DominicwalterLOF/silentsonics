package org.jose4j.jwe;

import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import org.jose4j.lang.JoseException;

public class CipherUtil {
    public CipherUtil() {
    }

    static Cipher getCipher(String str, String str2) throws JoseException {
        Cipher instance;
        Throwable th;
        StringBuilder sb;
        Throwable th2;
        String algorithm = str;
        String provider = str2;
        if (provider == null) {
            try {
                instance = Cipher.getInstance(algorithm);
            } catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
                GeneralSecurityException e2 = e;
                Throwable th3 = th2;
                new JoseException(e2.toString(), e2);
                throw th3;
            } catch (NoSuchProviderException e3) {
                NoSuchProviderException e4 = e3;
                Throwable th4 = th;
                new StringBuilder();
                new JoseException(sb.append("Unable to get a Cipher implementation of ").append(algorithm).append(" using provider ").append(provider).toString(), e4);
                throw th4;
            }
        } else {
            instance = Cipher.getInstance(algorithm, provider);
        }
        return instance;
    }
}
