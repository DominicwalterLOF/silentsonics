package com.microsoft.appcenter.utils.crypto;

import android.content.Context;
import com.microsoft.appcenter.utils.crypto.CryptoUtils;
import java.security.KeyStore;

class CryptoNoOpHandler implements CryptoHandler {
    CryptoNoOpHandler() {
    }

    public String getAlgorithm() {
        return "None";
    }

    public void generateKey(CryptoUtils.ICryptoFactory cryptoFactory, String alias, Context context) {
    }

    public byte[] encrypt(CryptoUtils.ICryptoFactory iCryptoFactory, int i, KeyStore.Entry entry, byte[] data) {
        CryptoUtils.ICryptoFactory iCryptoFactory2 = iCryptoFactory;
        int i2 = i;
        KeyStore.Entry entry2 = entry;
        return data;
    }

    public byte[] decrypt(CryptoUtils.ICryptoFactory iCryptoFactory, int i, KeyStore.Entry entry, byte[] data) {
        CryptoUtils.ICryptoFactory iCryptoFactory2 = iCryptoFactory;
        int i2 = i;
        KeyStore.Entry entry2 = entry;
        return data;
    }
}
