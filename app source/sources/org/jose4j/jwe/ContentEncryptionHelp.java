package org.jose4j.jwe;

import org.jose4j.jca.ProviderContext;
import org.jose4j.jwx.Headers;

class ContentEncryptionHelp {
    ContentEncryptionHelp() {
    }

    static String getCipherProvider(Headers headers, ProviderContext providerCtx) {
        return choseContext(headers, providerCtx).getCipherProvider();
    }

    static String getMacProvider(Headers headers, ProviderContext providerContext) {
        return choseContext(headers, providerContext).getMacProvider();
    }

    private static ProviderContext.Context choseContext(Headers headers, ProviderContext providerContext) {
        Headers headers2 = headers;
        ProviderContext providerCtx = providerContext;
        return headers2 != null && KeyManagementAlgorithmIdentifiers.DIRECT.equals(headers2.getStringHeaderValue("alg")) ? providerCtx.getSuppliedKeyProviderContext() : providerCtx.getGeneralProviderContext();
    }
}
