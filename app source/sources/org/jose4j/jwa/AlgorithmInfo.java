package org.jose4j.jwa;

import org.jose4j.keys.KeyPersuasion;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AlgorithmInfo implements Algorithm {
    private String algorithmIdentifier;
    private String javaAlgorithm;
    private KeyPersuasion keyPersuasion;
    private String keyType;
    protected final Logger log = LoggerFactory.getLogger(getClass());

    public AlgorithmInfo() {
    }

    public void setAlgorithmIdentifier(String algorithmIdentifier2) {
        String str = algorithmIdentifier2;
        this.algorithmIdentifier = str;
    }

    public void setJavaAlgorithm(String javaAlgorithm2) {
        String str = javaAlgorithm2;
        this.javaAlgorithm = str;
    }

    public String getJavaAlgorithm() {
        return this.javaAlgorithm;
    }

    public String getAlgorithmIdentifier() {
        return this.algorithmIdentifier;
    }

    public KeyPersuasion getKeyPersuasion() {
        return this.keyPersuasion;
    }

    public void setKeyPersuasion(KeyPersuasion keyPersuasion2) {
        KeyPersuasion keyPersuasion3 = keyPersuasion2;
        this.keyPersuasion = keyPersuasion3;
    }

    public String getKeyType() {
        return this.keyType;
    }

    public void setKeyType(String keyType2) {
        String str = keyType2;
        this.keyType = str;
    }
}
