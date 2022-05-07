package org.jose4j.jwa;

import java.security.Security;
import java.util.Arrays;
import org.jose4j.jwe.AesCbcHmacSha2ContentEncryptionAlgorithm;
import org.jose4j.jwe.AesGcmContentEncryptionAlgorithm;
import org.jose4j.jwe.AesGcmKeyEncryptionAlgorithm;
import org.jose4j.jwe.AesKeyWrapManagementAlgorithm;
import org.jose4j.jwe.ContentEncryptionAlgorithm;
import org.jose4j.jwe.DirectKeyManagementAlgorithm;
import org.jose4j.jwe.EcdhKeyAgreementAlgorithm;
import org.jose4j.jwe.EcdhKeyAgreementWithAesKeyWrapAlgorithm;
import org.jose4j.jwe.KeyManagementAlgorithm;
import org.jose4j.jwe.Pbes2HmacShaWithAesKeyWrapAlgorithm;
import org.jose4j.jwe.RsaKeyManagementAlgorithm;
import org.jose4j.jws.EcdsaUsingShaAlgorithm;
import org.jose4j.jws.HmacUsingShaAlgorithm;
import org.jose4j.jws.JsonWebSignatureAlgorithm;
import org.jose4j.jws.PlaintextNoneAlgorithm;
import org.jose4j.jws.RsaUsingShaAlgorithm;
import org.jose4j.jwx.HeaderParameterNames;
import org.jose4j.zip.CompressionAlgorithm;
import org.jose4j.zip.DeflateRFC1951CompressionAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AlgorithmFactoryFactory {
    private static final AlgorithmFactoryFactory factoryFactory;
    private static final Logger log = LoggerFactory.getLogger((Class<?>) AlgorithmFactoryFactory.class);
    private AlgorithmFactory<CompressionAlgorithm> compressionAlgorithmFactory;
    private AlgorithmFactory<ContentEncryptionAlgorithm> jweContentEncryptionAlgorithmFactory;
    private AlgorithmFactory<KeyManagementAlgorithm> jweKeyMgmtModeAlgorithmFactory;
    private AlgorithmFactory<JsonWebSignatureAlgorithm> jwsAlgorithmFactory;

    static {
        AlgorithmFactoryFactory algorithmFactoryFactory;
        new AlgorithmFactoryFactory();
        factoryFactory = algorithmFactoryFactory;
    }

    private AlgorithmFactoryFactory() {
        initialize();
    }

    /* access modifiers changed from: package-private */
    public void reinitialize() {
        log.debug("Reinitializing jose4j...");
        initialize();
    }

    private void initialize() {
        AlgorithmFactory<JsonWebSignatureAlgorithm> algorithmFactory;
        Algorithm algorithm;
        Algorithm algorithm2;
        Algorithm algorithm3;
        Algorithm algorithm4;
        Algorithm algorithm5;
        Algorithm algorithm6;
        Algorithm algorithm7;
        Algorithm algorithm8;
        Algorithm algorithm9;
        Algorithm algorithm10;
        Algorithm algorithm11;
        Algorithm algorithm12;
        Algorithm algorithm13;
        AlgorithmFactory<KeyManagementAlgorithm> algorithmFactory2;
        Algorithm algorithm14;
        Algorithm algorithm15;
        Algorithm algorithm16;
        Algorithm algorithm17;
        Algorithm algorithm18;
        Algorithm algorithm19;
        Algorithm algorithm20;
        Algorithm algorithm21;
        Algorithm algorithm22;
        Algorithm algorithm23;
        Algorithm algorithm24;
        Algorithm algorithm25;
        Algorithm algorithm26;
        Algorithm algorithm27;
        Algorithm algorithm28;
        Algorithm algorithm29;
        Algorithm algorithm30;
        AlgorithmFactory<ContentEncryptionAlgorithm> algorithmFactory3;
        Algorithm algorithm31;
        Algorithm algorithm32;
        Algorithm algorithm33;
        Algorithm algorithm34;
        Algorithm algorithm35;
        Algorithm algorithm36;
        AlgorithmFactory<CompressionAlgorithm> algorithmFactory4;
        Algorithm algorithm37;
        String version = System.getProperty("java.version");
        String vendor = System.getProperty("java.vendor");
        String home = System.getProperty("java.home");
        String providers = Arrays.toString(Security.getProviders());
        Logger logger = log;
        Object[] objArr = new Object[4];
        objArr[0] = version;
        Object[] objArr2 = objArr;
        objArr2[1] = vendor;
        Object[] objArr3 = objArr2;
        objArr3[2] = home;
        Object[] objArr4 = objArr3;
        objArr4[3] = providers;
        logger.debug("Initializing jose4j (running with Java {} from {} at {} with {} security providers installed)...", objArr4);
        long startTime = System.currentTimeMillis();
        new AlgorithmFactory<>("alg", JsonWebSignatureAlgorithm.class);
        this.jwsAlgorithmFactory = algorithmFactory;
        new PlaintextNoneAlgorithm();
        this.jwsAlgorithmFactory.registerAlgorithm(algorithm);
        new HmacUsingShaAlgorithm.HmacSha256();
        this.jwsAlgorithmFactory.registerAlgorithm(algorithm2);
        new HmacUsingShaAlgorithm.HmacSha384();
        this.jwsAlgorithmFactory.registerAlgorithm(algorithm3);
        new HmacUsingShaAlgorithm.HmacSha512();
        this.jwsAlgorithmFactory.registerAlgorithm(algorithm4);
        new EcdsaUsingShaAlgorithm.EcdsaP256UsingSha256();
        this.jwsAlgorithmFactory.registerAlgorithm(algorithm5);
        new EcdsaUsingShaAlgorithm.EcdsaP384UsingSha384();
        this.jwsAlgorithmFactory.registerAlgorithm(algorithm6);
        new EcdsaUsingShaAlgorithm.EcdsaP521UsingSha512();
        this.jwsAlgorithmFactory.registerAlgorithm(algorithm7);
        new RsaUsingShaAlgorithm.RsaSha256();
        this.jwsAlgorithmFactory.registerAlgorithm(algorithm8);
        new RsaUsingShaAlgorithm.RsaSha384();
        this.jwsAlgorithmFactory.registerAlgorithm(algorithm9);
        new RsaUsingShaAlgorithm.RsaSha512();
        this.jwsAlgorithmFactory.registerAlgorithm(algorithm10);
        new RsaUsingShaAlgorithm.RsaPssSha256();
        this.jwsAlgorithmFactory.registerAlgorithm(algorithm11);
        new RsaUsingShaAlgorithm.RsaPssSha384();
        this.jwsAlgorithmFactory.registerAlgorithm(algorithm12);
        new RsaUsingShaAlgorithm.RsaPssSha512();
        this.jwsAlgorithmFactory.registerAlgorithm(algorithm13);
        log.debug("JWS signature algorithms: {}", (Object) this.jwsAlgorithmFactory.getSupportedAlgorithms());
        new AlgorithmFactory<>("alg", KeyManagementAlgorithm.class);
        this.jweKeyMgmtModeAlgorithmFactory = algorithmFactory2;
        new RsaKeyManagementAlgorithm.Rsa1_5();
        this.jweKeyMgmtModeAlgorithmFactory.registerAlgorithm(algorithm14);
        new RsaKeyManagementAlgorithm.RsaOaep();
        this.jweKeyMgmtModeAlgorithmFactory.registerAlgorithm(algorithm15);
        new RsaKeyManagementAlgorithm.RsaOaep256();
        this.jweKeyMgmtModeAlgorithmFactory.registerAlgorithm(algorithm16);
        new DirectKeyManagementAlgorithm();
        this.jweKeyMgmtModeAlgorithmFactory.registerAlgorithm(algorithm17);
        new AesKeyWrapManagementAlgorithm.Aes128();
        this.jweKeyMgmtModeAlgorithmFactory.registerAlgorithm(algorithm18);
        new AesKeyWrapManagementAlgorithm.Aes192();
        this.jweKeyMgmtModeAlgorithmFactory.registerAlgorithm(algorithm19);
        new AesKeyWrapManagementAlgorithm.Aes256();
        this.jweKeyMgmtModeAlgorithmFactory.registerAlgorithm(algorithm20);
        new EcdhKeyAgreementAlgorithm();
        this.jweKeyMgmtModeAlgorithmFactory.registerAlgorithm(algorithm21);
        new EcdhKeyAgreementWithAesKeyWrapAlgorithm.EcdhKeyAgreementWithAes128KeyWrapAlgorithm();
        this.jweKeyMgmtModeAlgorithmFactory.registerAlgorithm(algorithm22);
        new EcdhKeyAgreementWithAesKeyWrapAlgorithm.EcdhKeyAgreementWithAes192KeyWrapAlgorithm();
        this.jweKeyMgmtModeAlgorithmFactory.registerAlgorithm(algorithm23);
        new EcdhKeyAgreementWithAesKeyWrapAlgorithm.EcdhKeyAgreementWithAes256KeyWrapAlgorithm();
        this.jweKeyMgmtModeAlgorithmFactory.registerAlgorithm(algorithm24);
        new Pbes2HmacShaWithAesKeyWrapAlgorithm.HmacSha256Aes128();
        this.jweKeyMgmtModeAlgorithmFactory.registerAlgorithm(algorithm25);
        new Pbes2HmacShaWithAesKeyWrapAlgorithm.HmacSha384Aes192();
        this.jweKeyMgmtModeAlgorithmFactory.registerAlgorithm(algorithm26);
        new Pbes2HmacShaWithAesKeyWrapAlgorithm.HmacSha512Aes256();
        this.jweKeyMgmtModeAlgorithmFactory.registerAlgorithm(algorithm27);
        new AesGcmKeyEncryptionAlgorithm.Aes128Gcm();
        this.jweKeyMgmtModeAlgorithmFactory.registerAlgorithm(algorithm28);
        new AesGcmKeyEncryptionAlgorithm.Aes192Gcm();
        this.jweKeyMgmtModeAlgorithmFactory.registerAlgorithm(algorithm29);
        new AesGcmKeyEncryptionAlgorithm.Aes256Gcm();
        this.jweKeyMgmtModeAlgorithmFactory.registerAlgorithm(algorithm30);
        log.debug("JWE key management algorithms: {}", (Object) this.jweKeyMgmtModeAlgorithmFactory.getSupportedAlgorithms());
        new AlgorithmFactory<>("enc", ContentEncryptionAlgorithm.class);
        this.jweContentEncryptionAlgorithmFactory = algorithmFactory3;
        new AesCbcHmacSha2ContentEncryptionAlgorithm.Aes128CbcHmacSha256();
        this.jweContentEncryptionAlgorithmFactory.registerAlgorithm(algorithm31);
        new AesCbcHmacSha2ContentEncryptionAlgorithm.Aes192CbcHmacSha384();
        this.jweContentEncryptionAlgorithmFactory.registerAlgorithm(algorithm32);
        new AesCbcHmacSha2ContentEncryptionAlgorithm.Aes256CbcHmacSha512();
        this.jweContentEncryptionAlgorithmFactory.registerAlgorithm(algorithm33);
        new AesGcmContentEncryptionAlgorithm.Aes128Gcm();
        this.jweContentEncryptionAlgorithmFactory.registerAlgorithm(algorithm34);
        new AesGcmContentEncryptionAlgorithm.Aes192Gcm();
        this.jweContentEncryptionAlgorithmFactory.registerAlgorithm(algorithm35);
        new AesGcmContentEncryptionAlgorithm.Aes256Gcm();
        this.jweContentEncryptionAlgorithmFactory.registerAlgorithm(algorithm36);
        log.debug("JWE content encryption algorithms: {}", (Object) this.jweContentEncryptionAlgorithmFactory.getSupportedAlgorithms());
        new AlgorithmFactory<>(HeaderParameterNames.ZIP, CompressionAlgorithm.class);
        this.compressionAlgorithmFactory = algorithmFactory4;
        new DeflateRFC1951CompressionAlgorithm();
        this.compressionAlgorithmFactory.registerAlgorithm(algorithm37);
        log.debug("JWE compression algorithms: {}", (Object) this.compressionAlgorithmFactory.getSupportedAlgorithms());
        log.debug("Initialized jose4j in {}ms", (Object) Long.valueOf(System.currentTimeMillis() - startTime));
    }

    public static AlgorithmFactoryFactory getInstance() {
        return factoryFactory;
    }

    public AlgorithmFactory<JsonWebSignatureAlgorithm> getJwsAlgorithmFactory() {
        return this.jwsAlgorithmFactory;
    }

    public AlgorithmFactory<KeyManagementAlgorithm> getJweKeyManagementAlgorithmFactory() {
        return this.jweKeyMgmtModeAlgorithmFactory;
    }

    public AlgorithmFactory<ContentEncryptionAlgorithm> getJweContentEncryptionAlgorithmFactory() {
        return this.jweContentEncryptionAlgorithmFactory;
    }

    public AlgorithmFactory<CompressionAlgorithm> getCompressionAlgorithmFactory() {
        return this.compressionAlgorithmFactory;
    }
}
