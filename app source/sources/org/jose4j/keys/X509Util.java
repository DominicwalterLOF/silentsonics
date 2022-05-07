package org.jose4j.keys;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.security.NoSuchProviderException;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import org.jose4j.base64url.Base64;
import org.jose4j.base64url.Base64Url;
import org.jose4j.base64url.SimplePEMEncoder;
import org.jose4j.lang.HashUtil;
import org.jose4j.lang.JoseException;
import org.jose4j.lang.UncheckedJoseException;

public class X509Util {
    private static final String FACTORY_TYPE = "X.509";
    private CertificateFactory certFactory;

    public X509Util() {
        Throwable th;
        try {
            this.certFactory = CertificateFactory.getInstance(FACTORY_TYPE);
        } catch (CertificateException e) {
            CertificateException e2 = e;
            Throwable th2 = th;
            new IllegalStateException("Couldn't find X.509 CertificateFactory!?!", e2);
            throw th2;
        }
    }

    public X509Util(String provider) throws NoSuchProviderException {
        Throwable th;
        try {
            this.certFactory = CertificateFactory.getInstance(FACTORY_TYPE, provider);
        } catch (CertificateException e) {
            CertificateException e2 = e;
            Throwable th2 = th;
            new IllegalStateException("Couldn't find X.509 CertificateFactory!?!", e2);
            throw th2;
        }
    }

    public static X509Util getX509Util(String str) throws JoseException {
        Throwable th;
        StringBuilder sb;
        X509Util x509Util;
        X509Util x509Util2;
        String jcaProvider = str;
        if (jcaProvider == null) {
            new X509Util();
            return x509Util2;
        }
        try {
            X509Util x509Util3 = x509Util;
            new X509Util(jcaProvider);
            return x509Util3;
        } catch (NoSuchProviderException e) {
            NoSuchProviderException e2 = e;
            Throwable th2 = th;
            new StringBuilder();
            new JoseException(sb.append("Provider ").append(jcaProvider).append(" not found when creating X509Util.").toString(), e2);
            throw th2;
        }
    }

    public String toBase64(X509Certificate x509Certificate) {
        Throwable th;
        try {
            return Base64.encode(x509Certificate.getEncoded());
        } catch (CertificateEncodingException e) {
            CertificateEncodingException e2 = e;
            Throwable th2 = th;
            new IllegalStateException("Unexpected problem getting encoded certificate.", e2);
            throw th2;
        }
    }

    public String toPem(X509Certificate x509Certificate) {
        Throwable th;
        try {
            return SimplePEMEncoder.encode(x509Certificate.getEncoded());
        } catch (CertificateEncodingException e) {
            CertificateEncodingException e2 = e;
            Throwable th2 = th;
            new IllegalStateException("Unexpected problem getting encoded certificate.", e2);
            throw th2;
        }
    }

    public X509Certificate fromBase64Der(String str) throws JoseException {
        InputStream inputStream;
        Throwable th;
        StringBuilder sb;
        String b64EncodedDer = str;
        new ByteArrayInputStream(Base64.decode(b64EncodedDer));
        try {
            return (X509Certificate) this.certFactory.generateCertificate(inputStream);
        } catch (CertificateException e) {
            CertificateException e2 = e;
            Throwable th2 = th;
            new StringBuilder();
            new JoseException(sb.append("Unable to convert ").append(b64EncodedDer).append(" value to X509Certificate: ").append(e2).toString(), e2);
            throw th2;
        }
    }

    public static String x5t(X509Certificate certificate) {
        return base64urlThumbprint(certificate, "SHA-1");
    }

    public static String x5tS256(X509Certificate certificate) {
        return base64urlThumbprint(certificate, HashUtil.SHA_256);
    }

    private static String base64urlThumbprint(X509Certificate certificate, String hashAlg) {
        Throwable th;
        try {
            return Base64Url.encode(HashUtil.getMessageDigest(hashAlg).digest(certificate.getEncoded()));
        } catch (CertificateEncodingException e) {
            CertificateEncodingException e2 = e;
            Throwable th2 = th;
            new UncheckedJoseException("Unable to get certificate thumbprint due to unexpected certificate encoding exception.", e2);
            throw th2;
        }
    }
}
