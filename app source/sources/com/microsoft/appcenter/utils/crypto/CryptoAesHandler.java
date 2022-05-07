package com.microsoft.appcenter.utils.crypto;

import android.content.Context;
import android.security.keystore.KeyGenParameterSpec;
import android.support.annotation.RequiresApi;
import com.microsoft.appcenter.utils.crypto.CryptoUtils;
import java.security.KeyStore;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Calendar;
import javax.crypto.spec.IvParameterSpec;
import org.jose4j.keys.AesKey;

@RequiresApi(23)
class CryptoAesHandler implements CryptoHandler {
    CryptoAesHandler() {
    }

    public String getAlgorithm() {
        return "AES/CBC/PKCS7Padding/256";
    }

    public void generateKey(CryptoUtils.ICryptoFactory cryptoFactory, String alias, Context context) throws Exception {
        KeyGenParameterSpec.Builder builder;
        Context context2 = context;
        Calendar writeExpiry = Calendar.getInstance();
        writeExpiry.add(1, 1);
        CryptoUtils.IKeyGenerator keyGenerator = cryptoFactory.getKeyGenerator(AesKey.ALGORITHM, "AndroidKeyStore");
        new KeyGenParameterSpec.Builder(alias, 3);
        keyGenerator.init(builder.setBlockModes(new String[]{"CBC"}).setEncryptionPaddings(new String[]{"PKCS7Padding"}).setKeySize(256).setKeyValidityForOriginationEnd(writeExpiry.getTime()).build());
        keyGenerator.generateKey();
    }

    public byte[] encrypt(CryptoUtils.ICryptoFactory cryptoFactory, int i, KeyStore.Entry keyStoreEntry, byte[] input) throws Exception {
        int i2 = i;
        CryptoUtils.ICipher cipher = cryptoFactory.getCipher("AES/CBC/PKCS7Padding", "AndroidKeyStoreBCWorkaround");
        cipher.init(1, ((KeyStore.SecretKeyEntry) keyStoreEntry).getSecretKey());
        byte[] cipherIV = cipher.getIV();
        byte[] output = cipher.doFinal(input);
        byte[] encryptedBytes = new byte[(cipherIV.length + output.length)];
        System.arraycopy(cipherIV, 0, encryptedBytes, 0, cipherIV.length);
        System.arraycopy(output, 0, encryptedBytes, cipherIV.length, output.length);
        return encryptedBytes;
    }

    public byte[] decrypt(CryptoUtils.ICryptoFactory cryptoFactory, int i, KeyStore.Entry keyStoreEntry, byte[] bArr) throws Exception {
        AlgorithmParameterSpec algorithmParameterSpec;
        int i2 = i;
        byte[] data = bArr;
        CryptoUtils.ICipher cipher = cryptoFactory.getCipher("AES/CBC/PKCS7Padding", "AndroidKeyStoreBCWorkaround");
        int blockSize = cipher.getBlockSize();
        new IvParameterSpec(data, 0, blockSize);
        cipher.init(2, ((KeyStore.SecretKeyEntry) keyStoreEntry).getSecretKey(), algorithmParameterSpec);
        return cipher.doFinal(data, blockSize, data.length - blockSize);
    }
}
