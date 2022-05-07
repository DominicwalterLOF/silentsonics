package com.microsoft.appcenter.utils.crypto;

import android.annotation.SuppressLint;
import android.support.annotation.RequiresApi;

class CryptoConstants {
    static final int AES_KEY_SIZE = 256;
    static final String ALGORITHM_DATA_SEPARATOR = ":";
    static final String ALIAS_SEPARATOR = ".";
    static final String ANDROID_KEY_STORE = "AndroidKeyStore";
    static final String CHARSET = "UTF-8";
    @RequiresApi(23)
    static final String CIPHER_AES = "AES/CBC/PKCS7Padding";
    @SuppressLint({"InlinedApi"})
    static final String CIPHER_RSA = "RSA/ECB/PKCS1Padding";
    static final int ENCRYPT_KEY_LIFETIME_IN_YEARS = 1;
    static final String KEYSTORE_ALIAS_PREFIX = "appcenter";
    static final String PROVIDER_ANDROID_M = "AndroidKeyStoreBCWorkaround";
    static final String PROVIDER_ANDROID_OLD = "AndroidOpenSSL";
    static final int RSA_KEY_SIZE = 2048;

    CryptoConstants() {
    }
}
