package org.jose4j.jwa;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import org.jose4j.jws.AlgorithmIdentifiers;
import org.jose4j.lang.InvalidAlgorithmException;

public class AlgorithmConstraints {
    public static final AlgorithmConstraints ALLOW_ONLY_NONE;
    public static final AlgorithmConstraints DISALLOW_NONE;
    public static final AlgorithmConstraints NO_CONSTRAINTS;
    private final Set<String> algorithms;
    private final ConstraintType type;

    public enum ConstraintType {
    }

    static {
        AlgorithmConstraints algorithmConstraints;
        AlgorithmConstraints algorithmConstraints2;
        AlgorithmConstraints algorithmConstraints3;
        new AlgorithmConstraints(ConstraintType.BLOCK, new String[0]);
        NO_CONSTRAINTS = algorithmConstraints;
        AlgorithmConstraints algorithmConstraints4 = algorithmConstraints2;
        new AlgorithmConstraints(ConstraintType.BLOCK, AlgorithmIdentifiers.NONE);
        DISALLOW_NONE = algorithmConstraints4;
        AlgorithmConstraints algorithmConstraints5 = algorithmConstraints3;
        new AlgorithmConstraints(ConstraintType.PERMIT, AlgorithmIdentifiers.NONE);
        ALLOW_ONLY_NONE = algorithmConstraints5;
    }

    public AlgorithmConstraints(ConstraintType constraintType, String... strArr) {
        Set<String> set;
        Throwable th;
        ConstraintType type2 = constraintType;
        String[] algorithms2 = strArr;
        if (type2 == null) {
            Throwable th2 = th;
            new NullPointerException("ConstraintType cannot be null");
            throw th2;
        }
        this.type = type2;
        new HashSet(Arrays.asList(algorithms2));
        this.algorithms = set;
    }

    public void checkConstraint(String str) throws InvalidAlgorithmException {
        Throwable th;
        StringBuilder sb;
        Throwable th2;
        StringBuilder sb2;
        String algorithm = str;
        switch (this.type) {
            case PERMIT:
            case WHITELIST:
                if (!this.algorithms.contains(algorithm)) {
                    Throwable th3 = th2;
                    new StringBuilder();
                    new InvalidAlgorithmException(sb2.append("'").append(algorithm).append("' is not a permitted algorithm.").toString());
                    throw th3;
                }
                return;
            case BLOCK:
            case BLACKLIST:
                if (this.algorithms.contains(algorithm)) {
                    Throwable th4 = th;
                    new StringBuilder();
                    new InvalidAlgorithmException(sb.append("'").append(algorithm).append("' is a blocked algorithm.").toString());
                    throw th4;
                }
                return;
            default:
                return;
        }
    }
}
