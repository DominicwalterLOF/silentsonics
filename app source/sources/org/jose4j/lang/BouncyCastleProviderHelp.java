package org.jose4j.lang;

import java.security.Provider;
import java.security.Security;

public class BouncyCastleProviderHelp {
    private static final String BC_PROVIDER_FQCN = "org.bouncycastle.jce.provider.BouncyCastleProvider";

    public BouncyCastleProviderHelp() {
    }

    public static boolean enableBouncyCastleProvider() {
        try {
            Class<?> cls = Class.forName(BC_PROVIDER_FQCN);
            Provider[] arr$ = Security.getProviders();
            int len$ = arr$.length;
            for (int i$ = 0; i$ < len$; i$++) {
                if (cls.isInstance(arr$[i$])) {
                    return true;
                }
            }
            int addProvider = Security.addProvider((Provider) cls.newInstance());
            return true;
        } catch (Exception e) {
            Exception exc = e;
            return false;
        }
    }
}
