package com.microsoft.appcenter.utils.crypto;

import android.annotation.SuppressLint;
import android.content.Context;
import android.security.KeyPairGeneratorSpec;
import android.support.annotation.RequiresApi;
import com.microsoft.appcenter.utils.crypto.CryptoUtils;
import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.cert.CertificateExpiredException;
import java.security.cert.X509Certificate;
import java.util.Calendar;
import java.util.Date;
import javax.security.auth.x500.X500Principal;

@RequiresApi(19)
class CryptoRsaHandler implements CryptoHandler {
    CryptoRsaHandler() {
    }

    public String getAlgorithm() {
        return "RSA/ECB/PKCS1Padding/2048";
    }

    @SuppressLint({"InlinedApi", "TrulyRandom"})
    public void generateKey(CryptoUtils.ICryptoFactory iCryptoFactory, String str, Context context) throws Exception {
        KeyPairGeneratorSpec.Builder builder;
        X500Principal x500Principal;
        StringBuilder sb;
        Date date;
        CryptoUtils.ICryptoFactory iCryptoFactory2 = iCryptoFactory;
        String alias = str;
        Calendar writeExpiry = Calendar.getInstance();
        writeExpiry.add(1, 1);
        KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA", "AndroidKeyStore");
        new KeyPairGeneratorSpec.Builder(context);
        new StringBuilder();
        new X500Principal(sb.append("CN=").append(alias).toString());
        new Date();
        generator.initialize(builder.setAlias(alias).setSubject(x500Principal).setStartDate(date).setEndDate(writeExpiry.getTime()).setSerialNumber(BigInteger.TEN).setKeySize(2048).build());
        KeyPair generateKeyPair = generator.generateKeyPair();
    }

    private CryptoUtils.ICipher getCipher(CryptoUtils.ICryptoFactory iCryptoFactory, int apiLevel) throws Exception {
        String provider;
        CryptoUtils.ICryptoFactory cipherFactory = iCryptoFactory;
        if (apiLevel >= 23) {
            provider = "AndroidKeyStoreBCWorkaround";
        } else {
            provider = "AndroidOpenSSL";
        }
        return cipherFactory.getCipher("RSA/ECB/PKCS1Padding", provider);
    }

    public byte[] encrypt(CryptoUtils.ICryptoFactory cryptoFactory, int apiLevel, KeyStore.Entry keyStoreEntry, byte[] bArr) throws Exception {
        Throwable th;
        byte[] input = bArr;
        CryptoUtils.ICipher cipher = getCipher(cryptoFactory, apiLevel);
        X509Certificate certificate = (X509Certificate) ((KeyStore.PrivateKeyEntry) keyStoreEntry).getCertificate();
        try {
            certificate.checkValidity();
            cipher.init(1, certificate.getPublicKey());
            return cipher.doFinal(input);
        } catch (CertificateExpiredException e) {
            CertificateExpiredException e2 = e;
            Throwable th2 = th;
            new InvalidKeyException(e2);
            throw th2;
        }
    }

    public byte[] decrypt(CryptoUtils.ICryptoFactory cryptoFactory, int apiLevel, KeyStore.Entry keyStoreEntry, byte[] data) throws Exception {
        CryptoUtils.ICipher cipher = getCipher(cryptoFactory, apiLevel);
        cipher.init(2, ((KeyStore.PrivateKeyEntry) keyStoreEntry).getPrivateKey());
        return cipher.doFinal(data);
    }
}
