package org.jose4j.jwa;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import org.jose4j.jwa.Algorithm;
import org.jose4j.lang.ExceptionHelp;
import org.jose4j.lang.InvalidAlgorithmException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AlgorithmFactory<A extends Algorithm> {
    private final Map<String, A> algorithms;
    private final Logger log;
    private String parameterName;

    public AlgorithmFactory(String parameterName2, Class<A> type) {
        Map<String, A> map;
        StringBuilder sb;
        new LinkedHashMap();
        this.algorithms = map;
        this.parameterName = parameterName2;
        new StringBuilder();
        this.log = LoggerFactory.getLogger(sb.append(getClass().getName()).append("->").append(type.getSimpleName()).toString());
    }

    public A getAlgorithm(String str) throws InvalidAlgorithmException {
        Throwable th;
        StringBuilder sb;
        String algorithmIdentifier = str;
        AlgorithmFactory<A> algo = (Algorithm) this.algorithms.get(algorithmIdentifier);
        if (algo != null) {
            return algo;
        }
        Throwable th2 = th;
        new StringBuilder();
        new InvalidAlgorithmException(sb.append(algorithmIdentifier).append(" is an unknown, unsupported or unavailable ").append(this.parameterName).append(" algorithm (not one of ").append(getSupportedAlgorithms()).append(").").toString());
        throw th2;
    }

    public boolean isAvailable(String algorithmIdentifier) {
        return this.algorithms.containsKey(algorithmIdentifier);
    }

    public Set<String> getSupportedAlgorithms() {
        return Collections.unmodifiableSet(this.algorithms.keySet());
    }

    public void registerAlgorithm(A a) {
        A algorithm = a;
        String algId = algorithm.getAlgorithmIdentifier();
        if (isAvailable(algorithm)) {
            A put = this.algorithms.put(algId, algorithm);
            Logger logger = this.log;
            Object[] objArr = new Object[3];
            objArr[0] = algorithm;
            Object[] objArr2 = objArr;
            objArr2[1] = this.parameterName;
            Object[] objArr3 = objArr2;
            objArr3[2] = algId;
            logger.debug("{} registered for {} algorithm {}", objArr3);
            return;
        }
        this.log.debug("{} is unavailable so will not be registered for {} algorithms.", (Object) algId, (Object) this.parameterName);
    }

    private boolean isAvailable(A a) {
        StringBuilder sb;
        A algorithm = a;
        try {
            return algorithm.isAvailable();
        } catch (Throwable th) {
            Throwable e = th;
            Logger logger = this.log;
            new StringBuilder();
            logger.debug(sb.append("Unexpected problem checking for availability of ").append(algorithm.getAlgorithmIdentifier()).append(" algorithm: ").append(ExceptionHelp.toStringWithCauses(e)).toString());
            return false;
        }
    }

    public void unregisterAlgorithm(String algorithmIdentifier) {
        A remove = this.algorithms.remove(algorithmIdentifier);
    }
}
