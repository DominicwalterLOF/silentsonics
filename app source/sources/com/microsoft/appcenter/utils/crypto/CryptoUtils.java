package com.microsoft.appcenter.utils.crypto;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import android.util.Base64;
import com.microsoft.appcenter.Constants;
import com.microsoft.appcenter.utils.AppCenterLog;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyStore;
import java.security.cert.CertificateExpiredException;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class CryptoUtils {
    @VisibleForTesting
    static final ICryptoFactory DEFAULT_CRYPTO_FACTORY;
    private static final String M_KEY_EXPIRED_EXCEPTION = "android.security.keystore.KeyExpiredException";
    @SuppressLint({"StaticFieldLeak"})
    private static CryptoUtils sInstance;
    private final int mApiLevel;
    private final Context mContext;
    private final ICryptoFactory mCryptoFactory;
    private final Map<String, CryptoHandlerEntry> mCryptoHandlers;
    private final KeyStore mKeyStore;

    interface ICipher {
        byte[] doFinal(byte[] bArr) throws Exception;

        byte[] doFinal(byte[] bArr, int i, int i2) throws Exception;

        @VisibleForTesting
        String getAlgorithm();

        int getBlockSize();

        byte[] getIV();

        @VisibleForTesting
        String getProvider();

        void init(int i, Key key) throws Exception;

        void init(int i, Key key, AlgorithmParameterSpec algorithmParameterSpec) throws Exception;
    }

    interface ICryptoFactory {
        ICipher getCipher(String str, String str2) throws Exception;

        IKeyGenerator getKeyGenerator(String str, String str2) throws Exception;
    }

    interface IKeyGenerator {
        void generateKey();

        void init(AlgorithmParameterSpec algorithmParameterSpec) throws Exception;
    }

    static {
        ICryptoFactory iCryptoFactory;
        new ICryptoFactory() {
            public IKeyGenerator getKeyGenerator(String algorithm, String provider) throws Exception {
                IKeyGenerator iKeyGenerator;
                final KeyGenerator instance = KeyGenerator.getInstance(algorithm, provider);
                new IKeyGenerator(this) {
                    final /* synthetic */ AnonymousClass1 this$0;

                    {
                        this.this$0 = this$0;
                    }

                    public void init(AlgorithmParameterSpec parameters) throws Exception {
                        instance.init(parameters);
                    }

                    public void generateKey() {
                        SecretKey generateKey = instance.generateKey();
                    }
                };
                return iKeyGenerator;
            }

            public ICipher getCipher(String transformation, String provider) throws Exception {
                ICipher iCipher;
                final Cipher instance = Cipher.getInstance(transformation, provider);
                new ICipher(this) {
                    final /* synthetic */ AnonymousClass1 this$0;

                    {
                        this.this$0 = this$0;
                    }

                    public void init(int opMode, Key key) throws Exception {
                        instance.init(opMode, key);
                    }

                    public void init(int opMode, Key key, AlgorithmParameterSpec params) throws Exception {
                        instance.init(opMode, key, params);
                    }

                    public byte[] doFinal(byte[] input) throws Exception {
                        return instance.doFinal(input);
                    }

                    public byte[] doFinal(byte[] input, int inputOffset, int inputLength) throws Exception {
                        return instance.doFinal(input, inputOffset, inputLength);
                    }

                    public byte[] getIV() {
                        return instance.getIV();
                    }

                    public int getBlockSize() {
                        return instance.getBlockSize();
                    }

                    public String getAlgorithm() {
                        return instance.getAlgorithm();
                    }

                    public String getProvider() {
                        return instance.getProvider().getName();
                    }
                };
                return iCipher;
            }
        };
        DEFAULT_CRYPTO_FACTORY = iCryptoFactory;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    private CryptoUtils(@NonNull Context context) {
        this(context, DEFAULT_CRYPTO_FACTORY, Build.VERSION.SDK_INT);
    }

    @VisibleForTesting
    @TargetApi(23)
    CryptoUtils(@NonNull Context context, @NonNull ICryptoFactory cryptoFactory, int i) {
        Map<String, CryptoHandlerEntry> map;
        CryptoNoOpHandler cryptoNoOpHandler;
        Object obj;
        CryptoHandler cryptoHandler;
        CryptoHandler cryptoHandler2;
        int apiLevel = i;
        new LinkedHashMap();
        this.mCryptoHandlers = map;
        this.mContext = context.getApplicationContext();
        this.mCryptoFactory = cryptoFactory;
        this.mApiLevel = apiLevel;
        KeyStore keyStore = null;
        if (apiLevel >= 19) {
            try {
                keyStore = KeyStore.getInstance("AndroidKeyStore");
                keyStore.load((KeyStore.LoadStoreParameter) null);
            } catch (Exception e) {
                Exception exc = e;
                AppCenterLog.error("AppCenter", "Cannot use secure keystore on this device.");
            }
        }
        this.mKeyStore = keyStore;
        if (keyStore != null && apiLevel >= 23) {
            try {
                new CryptoAesHandler();
                registerHandler(cryptoHandler2);
            } catch (Exception e2) {
                Exception exc2 = e2;
                AppCenterLog.error("AppCenter", "Cannot use modern encryption on this device.");
            }
        }
        if (keyStore != null) {
            try {
                new CryptoRsaHandler();
                registerHandler(cryptoHandler);
            } catch (Exception e3) {
                Exception exc3 = e3;
                AppCenterLog.error("AppCenter", "Cannot use old encryption on this device.");
            }
        }
        new CryptoNoOpHandler();
        CryptoNoOpHandler cryptoNoOpHandler2 = cryptoNoOpHandler;
        new CryptoHandlerEntry(0, cryptoNoOpHandler2);
        CryptoHandlerEntry put = this.mCryptoHandlers.put(cryptoNoOpHandler2.getAlgorithm(), obj);
    }

    public static CryptoUtils getInstance(@NonNull Context context) {
        CryptoUtils cryptoUtils;
        Context context2 = context;
        if (sInstance == null) {
            new CryptoUtils(context2);
            sInstance = cryptoUtils;
        }
        return sInstance;
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public ICryptoFactory getCryptoFactory() {
        return this.mCryptoFactory;
    }

    private void registerHandler(@NonNull CryptoHandler cryptoHandler) throws Exception {
        StringBuilder sb;
        Object obj;
        StringBuilder sb2;
        CryptoHandler handler = cryptoHandler;
        String alias0 = getAlias(handler, 0);
        String alias1 = getAlias(handler, 1);
        Date aliasDate0 = this.mKeyStore.getCreationDate(alias0);
        Date aliasDate1 = this.mKeyStore.getCreationDate(alias1);
        int index = 0;
        String alias = alias0;
        if (aliasDate1 != null && aliasDate1.after(aliasDate0)) {
            index = 1;
            alias = alias1;
        }
        if (this.mCryptoHandlers.isEmpty() && !this.mKeyStore.containsAlias(alias)) {
            new StringBuilder();
            AppCenterLog.debug("AppCenter", sb2.append("Creating alias: ").append(alias).toString());
            handler.generateKey(this.mCryptoFactory, alias, this.mContext);
        }
        new StringBuilder();
        AppCenterLog.debug("AppCenter", sb.append("Using ").append(alias).toString());
        new CryptoHandlerEntry(index, handler);
        CryptoHandlerEntry put = this.mCryptoHandlers.put(handler.getAlgorithm(), obj);
    }

    @NonNull
    private String getAlias(@NonNull CryptoHandler handler, int index) {
        StringBuilder sb;
        new StringBuilder();
        return sb.append("appcenter.").append(index).append(".").append(handler.getAlgorithm()).toString();
    }

    @Nullable
    private KeyStore.Entry getKeyStoreEntry(@NonNull CryptoHandlerEntry cryptoHandlerEntry) throws Exception {
        CryptoHandlerEntry handlerEntry = cryptoHandlerEntry;
        return getKeyStoreEntry(handlerEntry.mCryptoHandler, handlerEntry.mAliasIndex);
    }

    @Nullable
    private KeyStore.Entry getKeyStoreEntry(CryptoHandler cryptoHandler, int i) throws Exception {
        CryptoHandler cryptoHandler2 = cryptoHandler;
        int aliasIndex = i;
        if (this.mKeyStore == null) {
            return null;
        }
        return this.mKeyStore.getEntry(getAlias(cryptoHandler2, aliasIndex), (KeyStore.ProtectionParameter) null);
    }

    @Nullable
    public String encrypt(@Nullable String str) {
        CryptoHandlerEntry handlerEntry;
        CryptoHandler handler;
        StringBuilder sb;
        StringBuilder sb2;
        StringBuilder sb3;
        StringBuilder sb4;
        String data = str;
        if (data == null) {
            return null;
        }
        try {
            handlerEntry = this.mCryptoHandlers.values().iterator().next();
            handler = handlerEntry.mCryptoHandler;
            String encryptedString = Base64.encodeToString(handler.encrypt(this.mCryptoFactory, this.mApiLevel, getKeyStoreEntry(handlerEntry), data.getBytes("UTF-8")), 0);
            new StringBuilder();
            return sb4.append(handler.getAlgorithm()).append(Constants.COMMON_SCHEMA_PREFIX_SEPARATOR).append(encryptedString).toString();
        } catch (InvalidKeyException e) {
            InvalidKeyException e2 = e;
            if ((e2.getCause() instanceof CertificateExpiredException) || M_KEY_EXPIRED_EXCEPTION.equals(e2.getClass().getName())) {
                new StringBuilder();
                AppCenterLog.debug("AppCenter", sb.append("Alias expired: ").append(handlerEntry.mAliasIndex).toString());
                handlerEntry.mAliasIndex ^= 1;
                String newAlias = getAlias(handler, handlerEntry.mAliasIndex);
                if (this.mKeyStore.containsAlias(newAlias)) {
                    new StringBuilder();
                    AppCenterLog.debug("AppCenter", sb3.append("Deleting alias: ").append(newAlias).toString());
                    this.mKeyStore.deleteEntry(newAlias);
                }
                new StringBuilder();
                AppCenterLog.debug("AppCenter", sb2.append("Creating alias: ").append(newAlias).toString());
                handler.generateKey(this.mCryptoFactory, newAlias, this.mContext);
                return encrypt(data);
            }
            throw e2;
        } catch (Exception e3) {
            Exception exc = e3;
            AppCenterLog.error("AppCenter", "Failed to encrypt data.");
            return data;
        }
    }

    @NonNull
    public DecryptedData decrypt(@Nullable String str) {
        DecryptedData decryptedData;
        DecryptedData decryptedData2;
        DecryptedData decryptedData3;
        String data = str;
        if (data == null) {
            new DecryptedData((String) null, (String) null);
            return decryptedData3;
        }
        String[] dataSplit = data.split(Constants.COMMON_SCHEMA_PREFIX_SEPARATOR);
        CryptoHandlerEntry handlerEntry = dataSplit.length == 2 ? this.mCryptoHandlers.get(dataSplit[0]) : null;
        CryptoHandler cryptoHandler = handlerEntry == null ? null : handlerEntry.mCryptoHandler;
        if (cryptoHandler == null) {
            AppCenterLog.error("AppCenter", "Failed to decrypt data.");
            new DecryptedData(data, (String) null);
            return decryptedData2;
        }
        try {
            return getDecryptedData(cryptoHandler, handlerEntry.mAliasIndex, dataSplit[1]);
        } catch (Exception e) {
            Exception exc = e;
            try {
                return getDecryptedData(cryptoHandler, handlerEntry.mAliasIndex ^ 1, dataSplit[1]);
            } catch (Exception e2) {
                Exception exc2 = e2;
                AppCenterLog.error("AppCenter", "Failed to decrypt data.");
                new DecryptedData(data, (String) null);
                return decryptedData;
            }
        }
    }

    @NonNull
    private DecryptedData getDecryptedData(CryptoHandler cryptoHandler, int aliasIndex, String data) throws Exception {
        String str;
        DecryptedData decryptedData;
        CryptoHandler cryptoHandler2 = cryptoHandler;
        new String(cryptoHandler2.decrypt(this.mCryptoFactory, this.mApiLevel, getKeyStoreEntry(cryptoHandler2, aliasIndex), Base64.decode(data, 0)), "UTF-8");
        String decryptedString = str;
        String newEncryptedData = null;
        if (cryptoHandler2 != this.mCryptoHandlers.values().iterator().next().mCryptoHandler) {
            newEncryptedData = encrypt(decryptedString);
        }
        new DecryptedData(decryptedString, newEncryptedData);
        return decryptedData;
    }

    @VisibleForTesting
    static class CryptoHandlerEntry {
        int mAliasIndex;
        final CryptoHandler mCryptoHandler;

        CryptoHandlerEntry(int aliasIndex, CryptoHandler cryptoHandler) {
            this.mAliasIndex = aliasIndex;
            this.mCryptoHandler = cryptoHandler;
        }
    }

    public static class DecryptedData {
        final String mDecryptedData;
        final String mNewEncryptedData;

        @VisibleForTesting
        public DecryptedData(String decryptedData, String newEncryptedData) {
            this.mDecryptedData = decryptedData;
            this.mNewEncryptedData = newEncryptedData;
        }

        public String getDecryptedData() {
            return this.mDecryptedData;
        }

        public String getNewEncryptedData() {
            return this.mNewEncryptedData;
        }
    }
}
