package org.jose4j.jca;

import java.security.SecureRandom;

public class ProviderContext {
    private Context generalProviderContext;
    private SecureRandom secureRandom;
    private Context suppliedKeyProviderContext;

    public ProviderContext() {
        Context context;
        Context context2;
        new Context(this);
        this.suppliedKeyProviderContext = context;
        new Context(this);
        this.generalProviderContext = context2;
    }

    public Context getSuppliedKeyProviderContext() {
        return this.suppliedKeyProviderContext;
    }

    public Context getGeneralProviderContext() {
        return this.generalProviderContext;
    }

    public SecureRandom getSecureRandom() {
        return this.secureRandom;
    }

    public void setSecureRandom(SecureRandom secureRandom2) {
        SecureRandom secureRandom3 = secureRandom2;
        this.secureRandom = secureRandom3;
    }

    public class Context {
        private String cipherProvider;
        private String generalProvider;
        private String keyAgreementProvider;
        private String keyFactoryProvider;
        private String keyPairGeneratorProvider;
        private String macProvider;
        private String messageDigestProvider;
        private String signatureProvider;
        final /* synthetic */ ProviderContext this$0;

        public Context(ProviderContext providerContext) {
            this.this$0 = providerContext;
        }

        public String getGeneralProvider() {
            return this.generalProvider;
        }

        public void setGeneralProvider(String generalProvider2) {
            String str = generalProvider2;
            this.generalProvider = str;
        }

        public String getKeyPairGeneratorProvider() {
            return select(this.keyPairGeneratorProvider);
        }

        public void setKeyPairGeneratorProvider(String keyPairGeneratorProvider2) {
            String str = keyPairGeneratorProvider2;
            this.keyPairGeneratorProvider = str;
        }

        public String getKeyAgreementProvider() {
            return select(this.keyAgreementProvider);
        }

        public void setKeyAgreementProvider(String keyAgreementProvider2) {
            String str = keyAgreementProvider2;
            this.keyAgreementProvider = str;
        }

        public String getCipherProvider() {
            return select(this.cipherProvider);
        }

        public void setCipherProvider(String cipherProvider2) {
            String str = cipherProvider2;
            this.cipherProvider = str;
        }

        public String getSignatureProvider() {
            return select(this.signatureProvider);
        }

        public void setSignatureProvider(String signatureProvider2) {
            String str = signatureProvider2;
            this.signatureProvider = str;
        }

        public String getMacProvider() {
            return select(this.macProvider);
        }

        public void setMacProvider(String macProvider2) {
            String str = macProvider2;
            this.macProvider = str;
        }

        public String getMessageDigestProvider() {
            return select(this.messageDigestProvider);
        }

        public void setMessageDigestProvider(String messageDigestProvider2) {
            String str = messageDigestProvider2;
            this.messageDigestProvider = str;
        }

        public String getKeyFactoryProvider() {
            return select(this.keyFactoryProvider);
        }

        public void setKeyFactoryProvider(String keyFactoryProvider2) {
            String str = keyFactoryProvider2;
            this.keyFactoryProvider = str;
        }

        private String select(String str) {
            String specificValue = str;
            return specificValue == null ? this.generalProvider : specificValue;
        }
    }
}
