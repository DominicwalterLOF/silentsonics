package org.jose4j.jwa;

import java.security.Security;
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AlgorithmAvailability {
    private static Logger log = LoggerFactory.getLogger((Class<?>) AlgorithmAvailability.class);

    public AlgorithmAvailability() {
    }

    public static boolean isAvailable(String str, String str2) {
        String serviceName = str;
        String algorithm = str2;
        Set<String> algorithms = Security.getAlgorithms(serviceName);
        for (String serviceAlg : algorithms) {
            if (serviceAlg.equalsIgnoreCase(algorithm)) {
                return true;
            }
        }
        Logger logger = log;
        Object[] objArr = new Object[3];
        objArr[0] = algorithm;
        Object[] objArr2 = objArr;
        objArr2[1] = serviceName;
        Object[] objArr3 = objArr2;
        objArr3[2] = algorithms;
        logger.debug("{} is NOT available for {}. Algorithms available from underlying JCE: {}", objArr3);
        return false;
    }
}
