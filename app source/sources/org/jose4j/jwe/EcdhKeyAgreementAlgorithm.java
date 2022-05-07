package org.jose4j.jwe;

import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECFieldFp;
import java.security.spec.ECPoint;
import java.security.spec.EllipticCurve;
import javax.crypto.KeyAgreement;
import javax.crypto.spec.SecretKeySpec;
import org.jose4j.jca.ProviderContext;
import org.jose4j.jwa.AlgorithmAvailability;
import org.jose4j.jwa.AlgorithmInfo;
import org.jose4j.jwe.kdf.KdfUtil;
import org.jose4j.jwk.EcJwkGenerator;
import org.jose4j.jwk.PublicJsonWebKey;
import org.jose4j.jwx.HeaderParameterNames;
import org.jose4j.jwx.Headers;
import org.jose4j.jwx.KeyValidationSupport;
import org.jose4j.keys.EcKeyUtil;
import org.jose4j.keys.EllipticCurves;
import org.jose4j.keys.KeyPersuasion;
import org.jose4j.lang.ByteUtil;
import org.jose4j.lang.JoseException;
import org.jose4j.lang.UncheckedJoseException;

public class EcdhKeyAgreementAlgorithm extends AlgorithmInfo implements KeyManagementAlgorithm {
    String algorithmIdHeaderName;

    public EcdhKeyAgreementAlgorithm() {
        this.algorithmIdHeaderName = "enc";
        setAlgorithmIdentifier(KeyManagementAlgorithmIdentifiers.ECDH_ES);
        setJavaAlgorithm("ECDH");
        setKeyType("EC");
        setKeyPersuasion(KeyPersuasion.ASYMMETRIC);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public EcdhKeyAgreementAlgorithm(String algorithmIdHeaderName2) {
        this();
        this.algorithmIdHeaderName = algorithmIdHeaderName2;
    }

    public ContentEncryptionKeys manageForEncrypt(Key key, ContentEncryptionKeyDescriptor cekDesc, Headers headers, byte[] cekOverride, ProviderContext providerContext) throws JoseException {
        Key managementKey = key;
        ProviderContext providerContext2 = providerContext;
        KeyValidationSupport.cekNotAllowed(cekOverride, getAlgorithmIdentifier());
        String keyPairGeneratorProvider = providerContext2.getGeneralProviderContext().getKeyPairGeneratorProvider();
        SecureRandom secureRandom = providerContext2.getSecureRandom();
        return manageForEncrypt(managementKey, cekDesc, headers, (PublicJsonWebKey) EcJwkGenerator.generateJwk(((ECPublicKey) managementKey).getParams(), keyPairGeneratorProvider, secureRandom), providerContext2);
    }

    /* access modifiers changed from: package-private */
    public ContentEncryptionKeys manageForEncrypt(Key managementKey, ContentEncryptionKeyDescriptor cekDesc, Headers headers, PublicJsonWebKey publicJsonWebKey, ProviderContext providerContext) throws JoseException {
        ContentEncryptionKeys contentEncryptionKeys;
        Headers headers2 = headers;
        PublicJsonWebKey ephemeralJwk = publicJsonWebKey;
        ProviderContext providerContext2 = providerContext;
        headers2.setJwkHeaderValue(HeaderParameterNames.EPHEMERAL_PUBLIC_KEY, ephemeralJwk);
        new ContentEncryptionKeys(kdf(cekDesc, headers2, generateEcdhSecret(ephemeralJwk.getPrivateKey(), (PublicKey) managementKey, providerContext2), providerContext2), (byte[]) null);
        return contentEncryptionKeys;
    }

    public Key manageForDecrypt(Key key, byte[] bArr, ContentEncryptionKeyDescriptor contentEncryptionKeyDescriptor, Headers headers, ProviderContext providerContext) throws JoseException {
        Key key2;
        Key managementKey = key;
        byte[] bArr2 = bArr;
        ContentEncryptionKeyDescriptor cekDesc = contentEncryptionKeyDescriptor;
        Headers headers2 = headers;
        ProviderContext providerContext2 = providerContext;
        ECPublicKey ephemeralPublicKey = (ECPublicKey) headers2.getPublicJwkHeaderValue(HeaderParameterNames.EPHEMERAL_PUBLIC_KEY, providerContext2.getGeneralProviderContext().getKeyFactoryProvider()).getKey();
        checkPointIsOnCurve(ephemeralPublicKey, (ECPrivateKey) managementKey);
        new SecretKeySpec(kdf(cekDesc, headers2, generateEcdhSecret((ECPrivateKey) managementKey, ephemeralPublicKey, providerContext2), providerContext2), cekDesc.getContentEncryptionKeyAlgorithm());
        return key2;
    }

    private void checkPointIsOnCurve(ECPublicKey ephemeralPublicKey, ECPrivateKey privateKey) throws JoseException {
        Throwable th;
        StringBuilder sb;
        EllipticCurve curve = privateKey.getParams().getCurve();
        ECPoint point = ephemeralPublicKey.getW();
        BigInteger x = point.getAffineX();
        BigInteger y = point.getAffineY();
        BigInteger a = curve.getA();
        BigInteger b = curve.getB();
        BigInteger p = ((ECFieldFp) curve.getField()).getP();
        if (!y.pow(2).mod(p).equals(x.pow(3).add(a.multiply(x)).add(b).mod(p))) {
            Throwable th2 = th;
            new StringBuilder();
            new JoseException(sb.append("epk is invalid for ").append(EllipticCurves.getName(curve)).toString());
            throw th2;
        }
    }

    private byte[] kdf(ContentEncryptionKeyDescriptor cekDesc, Headers headers, byte[] z, ProviderContext providerContext) {
        KdfUtil kdf;
        Headers headers2 = headers;
        new KdfUtil(providerContext.getGeneralProviderContext().getMessageDigestProvider());
        return kdf.kdf(z, ByteUtil.bitLength(cekDesc.getContentEncryptionKeyByteLength()), headers2.getStringHeaderValue(this.algorithmIdHeaderName), headers2.getStringHeaderValue(HeaderParameterNames.AGREEMENT_PARTY_U_INFO), headers2.getStringHeaderValue(HeaderParameterNames.AGREEMENT_PARTY_V_INFO));
    }

    private KeyAgreement getKeyAgreement(String str) throws JoseException {
        KeyAgreement instance;
        Throwable th;
        StringBuilder sb;
        Throwable th2;
        StringBuilder sb2;
        String provider = str;
        String javaAlgorithm = getJavaAlgorithm();
        if (provider == null) {
            try {
                instance = KeyAgreement.getInstance(javaAlgorithm);
            } catch (NoSuchAlgorithmException e) {
                NoSuchAlgorithmException e2 = e;
                Throwable th3 = th2;
                new StringBuilder();
                new UncheckedJoseException(sb2.append("No ").append(javaAlgorithm).append(" KeyAgreement available.").toString(), e2);
                throw th3;
            } catch (NoSuchProviderException e3) {
                NoSuchProviderException e4 = e3;
                Throwable th4 = th;
                new StringBuilder();
                new JoseException(sb.append("Cannot get ").append(javaAlgorithm).append(" KeyAgreement with provider ").append(provider).toString(), e4);
                throw th4;
            }
        } else {
            instance = KeyAgreement.getInstance(javaAlgorithm, provider);
        }
        return instance;
    }

    private byte[] generateEcdhSecret(PrivateKey privateKey, PublicKey publicKey, ProviderContext providerContext) throws JoseException {
        Throwable th;
        StringBuilder sb;
        PublicKey publicKey2 = publicKey;
        KeyAgreement keyAgreement = getKeyAgreement(providerContext.getSuppliedKeyProviderContext().getKeyAgreementProvider());
        try {
            keyAgreement.init(privateKey);
            Key doPhase = keyAgreement.doPhase(publicKey2, true);
            return keyAgreement.generateSecret();
        } catch (InvalidKeyException e) {
            InvalidKeyException e2 = e;
            Throwable th2 = th;
            new StringBuilder();
            new org.jose4j.lang.InvalidKeyException(sb.append("Invalid Key for ").append(getJavaAlgorithm()).append(" key agreement - ").append(e2).toString(), e2);
            throw th2;
        }
    }

    public void validateEncryptionKey(Key managementKey, ContentEncryptionAlgorithm contentEncryptionAlgorithm) throws org.jose4j.lang.InvalidKeyException {
        ContentEncryptionAlgorithm contentEncryptionAlgorithm2 = contentEncryptionAlgorithm;
        Key castKey = KeyValidationSupport.castKey(managementKey, ECPublicKey.class);
    }

    public void validateDecryptionKey(Key managementKey, ContentEncryptionAlgorithm contentEncryptionAlgorithm) throws org.jose4j.lang.InvalidKeyException {
        ContentEncryptionAlgorithm contentEncryptionAlgorithm2 = contentEncryptionAlgorithm;
        Key castKey = KeyValidationSupport.castKey(managementKey, ECPrivateKey.class);
    }

    public boolean isAvailable() {
        EcKeyUtil ecKeyUtil;
        new EcKeyUtil();
        return ecKeyUtil.isAvailable() && AlgorithmAvailability.isAvailable("KeyAgreement", getJavaAlgorithm());
    }
}
