package org.jose4j.jwt.consumer;

import java.security.Key;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.jose4j.jca.ProviderContext;
import org.jose4j.jwa.AlgorithmConstraints;
import org.jose4j.jwe.JsonWebEncryption;
import org.jose4j.jws.AlgorithmIdentifiers;
import org.jose4j.jws.JsonWebSignature;
import org.jose4j.jwt.JwtClaims;
import org.jose4j.jwt.MalformedClaimException;
import org.jose4j.jwt.consumer.ErrorCodeValidator;
import org.jose4j.jwx.JsonWebStructure;
import org.jose4j.keys.KeyPersuasion;
import org.jose4j.keys.resolvers.DecryptionKeyResolver;
import org.jose4j.keys.resolvers.VerificationKeyResolver;
import org.jose4j.lang.ExceptionHelp;
import org.jose4j.lang.JoseException;

public class JwtConsumer {
    private DecryptionKeyResolver decryptionKeyResolver;
    private AlgorithmConstraints jweAlgorithmConstraints;
    private AlgorithmConstraints jweContentEncryptionAlgorithmConstraints;
    private JweCustomizer jweCustomizer;
    private ProviderContext jweProviderContext;
    private AlgorithmConstraints jwsAlgorithmConstraints;
    private JwsCustomizer jwsCustomizer;
    private ProviderContext jwsProviderContext;
    private boolean liberalContentTypeHandling;
    private boolean relaxDecryptionKeyValidation;
    private boolean relaxVerificationKeyValidation;
    private boolean requireEncryption;
    private boolean requireIntegrity;
    private boolean requireSignature = true;
    private boolean skipSignatureVerification;
    private boolean skipVerificationKeyResolutionOnNone;
    private List<ErrorCodeValidator> validators;
    private VerificationKeyResolver verificationKeyResolver;

    JwtConsumer() {
    }

    /* access modifiers changed from: package-private */
    public void setJwsAlgorithmConstraints(AlgorithmConstraints constraints) {
        AlgorithmConstraints algorithmConstraints = constraints;
        this.jwsAlgorithmConstraints = algorithmConstraints;
    }

    /* access modifiers changed from: package-private */
    public void setJweAlgorithmConstraints(AlgorithmConstraints constraints) {
        AlgorithmConstraints algorithmConstraints = constraints;
        this.jweAlgorithmConstraints = algorithmConstraints;
    }

    /* access modifiers changed from: package-private */
    public void setJweContentEncryptionAlgorithmConstraints(AlgorithmConstraints constraints) {
        AlgorithmConstraints algorithmConstraints = constraints;
        this.jweContentEncryptionAlgorithmConstraints = algorithmConstraints;
    }

    /* access modifiers changed from: package-private */
    public void setVerificationKeyResolver(VerificationKeyResolver verificationKeyResolver2) {
        VerificationKeyResolver verificationKeyResolver3 = verificationKeyResolver2;
        this.verificationKeyResolver = verificationKeyResolver3;
    }

    /* access modifiers changed from: package-private */
    public void setDecryptionKeyResolver(DecryptionKeyResolver decryptionKeyResolver2) {
        DecryptionKeyResolver decryptionKeyResolver3 = decryptionKeyResolver2;
        this.decryptionKeyResolver = decryptionKeyResolver3;
    }

    /* access modifiers changed from: package-private */
    public void setValidators(List<ErrorCodeValidator> validators2) {
        List<ErrorCodeValidator> list = validators2;
        this.validators = list;
    }

    /* access modifiers changed from: package-private */
    public void setRequireSignature(boolean requireSignature2) {
        boolean z = requireSignature2;
        this.requireSignature = z;
    }

    /* access modifiers changed from: package-private */
    public void setRequireEncryption(boolean requireEncryption2) {
        boolean z = requireEncryption2;
        this.requireEncryption = z;
    }

    /* access modifiers changed from: package-private */
    public void setRequireIntegrity(boolean requireIntegrity2) {
        boolean z = requireIntegrity2;
        this.requireIntegrity = z;
    }

    /* access modifiers changed from: package-private */
    public void setLiberalContentTypeHandling(boolean liberalContentTypeHandling2) {
        boolean z = liberalContentTypeHandling2;
        this.liberalContentTypeHandling = z;
    }

    /* access modifiers changed from: package-private */
    public void setSkipSignatureVerification(boolean skipSignatureVerification2) {
        boolean z = skipSignatureVerification2;
        this.skipSignatureVerification = z;
    }

    /* access modifiers changed from: package-private */
    public void setRelaxVerificationKeyValidation(boolean relaxVerificationKeyValidation2) {
        boolean z = relaxVerificationKeyValidation2;
        this.relaxVerificationKeyValidation = z;
    }

    public void setSkipVerificationKeyResolutionOnNone(boolean skipVerificationKeyResolutionOnNone2) {
        boolean z = skipVerificationKeyResolutionOnNone2;
        this.skipVerificationKeyResolutionOnNone = z;
    }

    /* access modifiers changed from: package-private */
    public void setRelaxDecryptionKeyValidation(boolean relaxDecryptionKeyValidation2) {
        boolean z = relaxDecryptionKeyValidation2;
        this.relaxDecryptionKeyValidation = z;
    }

    /* access modifiers changed from: package-private */
    public void setJwsProviderContext(ProviderContext jwsProviderContext2) {
        ProviderContext providerContext = jwsProviderContext2;
        this.jwsProviderContext = providerContext;
    }

    /* access modifiers changed from: package-private */
    public void setJweProviderContext(ProviderContext jweProviderContext2) {
        ProviderContext providerContext = jweProviderContext2;
        this.jweProviderContext = providerContext;
    }

    /* access modifiers changed from: package-private */
    public void setJwsCustomizer(JwsCustomizer jwsCustomizer2) {
        JwsCustomizer jwsCustomizer3 = jwsCustomizer2;
        this.jwsCustomizer = jwsCustomizer3;
    }

    /* access modifiers changed from: package-private */
    public void setJweCustomizer(JweCustomizer jweCustomizer2) {
        JweCustomizer jweCustomizer3 = jweCustomizer2;
        this.jweCustomizer = jweCustomizer3;
    }

    public JwtClaims processToClaims(String jwt) throws InvalidJwtException {
        return process(jwt).getJwtClaims();
    }

    public void processContext(JwtContext jwtContext) throws InvalidJwtException {
        ArrayList arrayList;
        Object obj;
        Throwable th;
        StringBuilder sb;
        Object obj2;
        Throwable th2;
        StringBuilder sb2;
        Object obj3;
        Throwable th3;
        StringBuilder sb3;
        StringBuilder sb4;
        ErrorCodeValidator.Error error;
        Throwable th4;
        StringBuilder sb5;
        ErrorCodeValidator.Error error2;
        Throwable th5;
        Object obj4;
        Throwable th6;
        Throwable th7;
        JwtContext jwtContext2 = jwtContext;
        boolean hasSignature = false;
        boolean hasEncryption = false;
        boolean hasSymmetricEncryption = false;
        new ArrayList(jwtContext2.getJoseObjects());
        ArrayList arrayList2 = arrayList;
        int idx = arrayList2.size() - 1;
        while (idx >= 0) {
            List<JsonWebStructure> joseObjects = arrayList2.subList(idx + 1, arrayList2.size());
            List<JsonWebStructure> nestingContext = Collections.unmodifiableList(joseObjects);
            JsonWebStructure currentJoseObject = (JsonWebStructure) arrayList2.get(idx);
            try {
                if (currentJoseObject instanceof JsonWebSignature) {
                    JsonWebSignature jws = (JsonWebSignature) currentJoseObject;
                    boolean isNoneAlg = AlgorithmIdentifiers.NONE.equals(jws.getAlgorithmHeaderValue());
                    if (!this.skipSignatureVerification) {
                        if (this.jwsProviderContext != null) {
                            jws.setProviderContext(this.jwsProviderContext);
                        }
                        if (this.relaxVerificationKeyValidation) {
                            jws.setDoKeyValidation(false);
                        }
                        if (this.jwsAlgorithmConstraints != null) {
                            jws.setAlgorithmConstraints(this.jwsAlgorithmConstraints);
                        }
                        if (!isNoneAlg || !this.skipVerificationKeyResolutionOnNone) {
                            jws.setKey(this.verificationKeyResolver.resolveKey(jws, nestingContext));
                        }
                        if (this.jwsCustomizer != null) {
                            this.jwsCustomizer.customize(jws, nestingContext);
                        }
                        if (!jws.verifySignature()) {
                            Throwable th8 = th7;
                            new InvalidJwtSignatureException(jws, jwtContext2);
                            throw th8;
                        }
                    }
                    if (!isNoneAlg) {
                        hasSignature = true;
                    }
                } else {
                    JsonWebEncryption jwe = (JsonWebEncryption) currentJoseObject;
                    Key key = this.decryptionKeyResolver.resolveKey(jwe, nestingContext);
                    if (key == null || key.equals(jwe.getKey())) {
                        if (this.jweAlgorithmConstraints != null) {
                            this.jweAlgorithmConstraints.checkConstraint(jwe.getAlgorithmHeaderValue());
                        }
                        if (this.jweContentEncryptionAlgorithmConstraints != null) {
                            this.jweContentEncryptionAlgorithmConstraints.checkConstraint(jwe.getEncryptionMethodHeaderParameter());
                        }
                        hasEncryption = true;
                        hasSymmetricEncryption = jwe.getKeyManagementModeAlgorithm().getKeyPersuasion() == KeyPersuasion.SYMMETRIC;
                    } else {
                        new ErrorCodeValidator.Error(17, "Key resolution problem.");
                        Throwable th9 = th6;
                        new InvalidJwtException("The resolved decryption key is different than the one originally used to decrypt the JWE.", Collections.singletonList(obj4), jwtContext2);
                        throw th9;
                    }
                }
                idx--;
            } catch (JoseException e) {
                JoseException e2 = e;
                new StringBuilder();
                StringBuilder sb6 = sb5;
                StringBuilder append = sb6.append("Unable to process");
                if (!joseObjects.isEmpty()) {
                    StringBuilder append2 = sb6.append(" nested");
                }
                StringBuilder append3 = sb6.append(" JOSE object (cause: ").append(e2).append("): ").append(currentJoseObject);
                new ErrorCodeValidator.Error(17, sb6.toString());
                Throwable th10 = th5;
                new InvalidJwtException("JWT processing failed.", error2, e2, jwtContext2);
                throw th10;
            } catch (InvalidJwtException e3) {
                throw e3;
            } catch (Exception e4) {
                Exception e5 = e4;
                new StringBuilder();
                StringBuilder sb7 = sb4;
                StringBuilder append4 = sb7.append("Unexpected exception encountered while processing");
                if (!joseObjects.isEmpty()) {
                    StringBuilder append5 = sb7.append(" nested");
                }
                StringBuilder append6 = sb7.append(" JOSE object (").append(e5).append("): ").append(currentJoseObject);
                new ErrorCodeValidator.Error(17, sb7.toString());
                Throwable th11 = th4;
                new InvalidJwtException("JWT processing failed.", error, e5, jwtContext2);
                throw th11;
            }
        }
        if (this.requireSignature && !hasSignature) {
            new ErrorCodeValidator.Error(10, "Missing signature.");
            List<ErrorCodeValidator.Error> errors = Collections.singletonList(obj3);
            Throwable th12 = th3;
            new StringBuilder();
            new InvalidJwtException(sb3.append("The JWT has no signature but the JWT Consumer is configured to require one: ").append(jwtContext2.getJwt()).toString(), errors, jwtContext2);
            throw th12;
        } else if (this.requireEncryption && !hasEncryption) {
            new ErrorCodeValidator.Error(19, "No encryption.");
            List<ErrorCodeValidator.Error> errors2 = Collections.singletonList(obj2);
            Throwable th13 = th2;
            new StringBuilder();
            new InvalidJwtException(sb2.append("The JWT has no encryption but the JWT Consumer is configured to require it: ").append(jwtContext2.getJwt()).toString(), errors2, jwtContext2);
            throw th13;
        } else if (!this.requireIntegrity || hasSignature || hasSymmetricEncryption) {
            validate(jwtContext2);
        } else {
            new ErrorCodeValidator.Error(20, "Missing Integrity Protection");
            List<ErrorCodeValidator.Error> errors3 = Collections.singletonList(obj);
            Throwable th14 = th;
            new StringBuilder();
            new InvalidJwtException(sb.append("The JWT has no integrity protection (signature/MAC or symmetric AEAD encryption) but the JWT Consumer is configured to require it: ").append(jwtContext2.getJwt()).toString(), errors3, jwtContext2);
            throw th14;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00ca, code lost:
        r11 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00cb, code lost:
        r7 = r11;
        new java.lang.StringBuilder();
        r8 = r17;
        r11 = r8.append("Unable to process");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00e5, code lost:
        if (r4.isEmpty() == false) goto L_0x00e7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00e7, code lost:
        r11 = r8.append(" nested");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00ef, code lost:
        r11 = r8.append(" JOSE object (cause: ").append(r7).append("): ").append(r2);
        new org.jose4j.jwt.consumer.ErrorCodeValidator.Error(17, r8.toString());
        r11 = r17;
        new org.jose4j.jwt.consumer.InvalidJwtException("JWT processing failed.", r17, r7, r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x012d, code lost:
        throw r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x0130, code lost:
        r11 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x0133, code lost:
        throw r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0134, code lost:
        r11 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0135, code lost:
        r7 = r11;
        new java.lang.StringBuilder();
        r8 = r17;
        r11 = r8.append("Unexpected exception encountered while processing");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x014f, code lost:
        if (r4.isEmpty() == false) goto L_0x0151;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x0151, code lost:
        r11 = r8.append(" nested");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0159, code lost:
        r11 = r8.append(" JOSE object (").append(r7).append("): ").append(r2);
        new org.jose4j.jwt.consumer.ErrorCodeValidator.Error(17, r8.toString());
        r11 = r17;
        new org.jose4j.jwt.consumer.InvalidJwtException("JWT processing failed.", r17, r7, r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0197, code lost:
        throw r11;
     */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00ca A[ExcHandler: JoseException (r11v30 'e' org.jose4j.lang.JoseException A[CUSTOM_DECLARE]), Splitter:B:4:0x002b] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0130 A[ExcHandler: InvalidJwtException (r11v28 'e' org.jose4j.jwt.consumer.InvalidJwtException A[CUSTOM_DECLARE]), Splitter:B:4:0x002b] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0134 A[ExcHandler: Exception (r11v10 'e' java.lang.Exception A[CUSTOM_DECLARE]), Splitter:B:4:0x002b] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public org.jose4j.jwt.consumer.JwtContext process(java.lang.String r19) throws org.jose4j.jwt.consumer.InvalidJwtException {
        /*
            r18 = this;
            r0 = r18
            r1 = r19
            r11 = r1
            r2 = r11
            r11 = 0
            r3 = r11
            java.util.LinkedList r11 = new java.util.LinkedList
            r17 = r11
            r11 = r17
            r12 = r17
            r12.<init>()
            r4 = r11
            org.jose4j.jwt.consumer.JwtContext r11 = new org.jose4j.jwt.consumer.JwtContext
            r17 = r11
            r11 = r17
            r12 = r17
            r13 = r1
            r14 = 0
            r15 = r4
            java.util.List r15 = java.util.Collections.unmodifiableList(r15)
            r12.<init>(r13, r14, r15)
            r5 = r11
        L_0x0027:
            r11 = r3
            if (r11 != 0) goto L_0x0198
            r11 = r2
            org.jose4j.jwx.JsonWebStructure r11 = org.jose4j.jwx.JsonWebStructure.fromCompactSerialization(r11)     // Catch:{ JoseException -> 0x00ca, InvalidJwtException -> 0x0130, Exception -> 0x0134 }
            r6 = r11
            r11 = r6
            boolean r11 = r11 instanceof org.jose4j.jws.JsonWebSignature     // Catch:{ JoseException -> 0x00ca, InvalidJwtException -> 0x0130, Exception -> 0x0134 }
            if (r11 == 0) goto L_0x004f
            r11 = r6
            org.jose4j.jws.JsonWebSignature r11 = (org.jose4j.jws.JsonWebSignature) r11     // Catch:{ JoseException -> 0x00ca, InvalidJwtException -> 0x0130, Exception -> 0x0134 }
            r8 = r11
            r11 = r8
            java.lang.String r11 = r11.getUnverifiedPayload()     // Catch:{ JoseException -> 0x00ca, InvalidJwtException -> 0x0130, Exception -> 0x0134 }
            r7 = r11
        L_0x003f:
            r11 = r0
            r12 = r6
            boolean r11 = r11.isNestedJwt(r12)     // Catch:{ JoseException -> 0x00ca, InvalidJwtException -> 0x0130, Exception -> 0x0134 }
            if (r11 == 0) goto L_0x00aa
            r11 = r7
            r2 = r11
        L_0x0049:
            r11 = r4
            r12 = r6
            r11.addFirst(r12)     // Catch:{ JoseException -> 0x00ca, InvalidJwtException -> 0x0130, Exception -> 0x0134 }
            goto L_0x0027
        L_0x004f:
            r11 = r6
            org.jose4j.jwe.JsonWebEncryption r11 = (org.jose4j.jwe.JsonWebEncryption) r11     // Catch:{ JoseException -> 0x00ca, InvalidJwtException -> 0x0130, Exception -> 0x0134 }
            r8 = r11
            r11 = r0
            org.jose4j.jca.ProviderContext r11 = r11.jweProviderContext     // Catch:{ JoseException -> 0x00ca, InvalidJwtException -> 0x0130, Exception -> 0x0134 }
            if (r11 == 0) goto L_0x005f
            r11 = r8
            r12 = r0
            org.jose4j.jca.ProviderContext r12 = r12.jweProviderContext     // Catch:{ JoseException -> 0x00ca, InvalidJwtException -> 0x0130, Exception -> 0x0134 }
            r11.setProviderContext(r12)     // Catch:{ JoseException -> 0x00ca, InvalidJwtException -> 0x0130, Exception -> 0x0134 }
        L_0x005f:
            r11 = r0
            boolean r11 = r11.relaxDecryptionKeyValidation     // Catch:{ JoseException -> 0x00ca, InvalidJwtException -> 0x0130, Exception -> 0x0134 }
            if (r11 == 0) goto L_0x0069
            r11 = r8
            r12 = 0
            r11.setDoKeyValidation(r12)     // Catch:{ JoseException -> 0x00ca, InvalidJwtException -> 0x0130, Exception -> 0x0134 }
        L_0x0069:
            r11 = r0
            org.jose4j.jwa.AlgorithmConstraints r11 = r11.jweContentEncryptionAlgorithmConstraints     // Catch:{ JoseException -> 0x00ca, InvalidJwtException -> 0x0130, Exception -> 0x0134 }
            if (r11 == 0) goto L_0x0075
            r11 = r8
            r12 = r0
            org.jose4j.jwa.AlgorithmConstraints r12 = r12.jweContentEncryptionAlgorithmConstraints     // Catch:{ JoseException -> 0x00ca, InvalidJwtException -> 0x0130, Exception -> 0x0134 }
            r11.setContentEncryptionAlgorithmConstraints(r12)     // Catch:{ JoseException -> 0x00ca, InvalidJwtException -> 0x0130, Exception -> 0x0134 }
        L_0x0075:
            r11 = r4
            java.util.List r11 = java.util.Collections.unmodifiableList(r11)     // Catch:{ JoseException -> 0x00ca, InvalidJwtException -> 0x0130, Exception -> 0x0134 }
            r9 = r11
            r11 = r0
            org.jose4j.keys.resolvers.DecryptionKeyResolver r11 = r11.decryptionKeyResolver     // Catch:{ JoseException -> 0x00ca, InvalidJwtException -> 0x0130, Exception -> 0x0134 }
            r12 = r8
            r13 = r9
            java.security.Key r11 = r11.resolveKey(r12, r13)     // Catch:{ JoseException -> 0x00ca, InvalidJwtException -> 0x0130, Exception -> 0x0134 }
            r10 = r11
            r11 = r8
            r12 = r10
            r11.setKey(r12)     // Catch:{ JoseException -> 0x00ca, InvalidJwtException -> 0x0130, Exception -> 0x0134 }
            r11 = r0
            org.jose4j.jwa.AlgorithmConstraints r11 = r11.jweAlgorithmConstraints     // Catch:{ JoseException -> 0x00ca, InvalidJwtException -> 0x0130, Exception -> 0x0134 }
            if (r11 == 0) goto L_0x0096
            r11 = r8
            r12 = r0
            org.jose4j.jwa.AlgorithmConstraints r12 = r12.jweAlgorithmConstraints     // Catch:{ JoseException -> 0x00ca, InvalidJwtException -> 0x0130, Exception -> 0x0134 }
            r11.setAlgorithmConstraints(r12)     // Catch:{ JoseException -> 0x00ca, InvalidJwtException -> 0x0130, Exception -> 0x0134 }
        L_0x0096:
            r11 = r0
            org.jose4j.jwt.consumer.JweCustomizer r11 = r11.jweCustomizer     // Catch:{ JoseException -> 0x00ca, InvalidJwtException -> 0x0130, Exception -> 0x0134 }
            if (r11 == 0) goto L_0x00a3
            r11 = r0
            org.jose4j.jwt.consumer.JweCustomizer r11 = r11.jweCustomizer     // Catch:{ JoseException -> 0x00ca, InvalidJwtException -> 0x0130, Exception -> 0x0134 }
            r12 = r8
            r13 = r9
            r11.customize(r12, r13)     // Catch:{ JoseException -> 0x00ca, InvalidJwtException -> 0x0130, Exception -> 0x0134 }
        L_0x00a3:
            r11 = r8
            java.lang.String r11 = r11.getPayload()     // Catch:{ JoseException -> 0x00ca, InvalidJwtException -> 0x0130, Exception -> 0x0134 }
            r7 = r11
            goto L_0x003f
        L_0x00aa:
            r11 = r7
            r12 = r5
            org.jose4j.jwt.JwtClaims r11 = org.jose4j.jwt.JwtClaims.parse(r11, r12)     // Catch:{ InvalidJwtException -> 0x00b7, JoseException -> 0x00ca, Exception -> 0x0134 }
            r3 = r11
            r11 = r5
            r12 = r3
            r11.setJwtClaims(r12)     // Catch:{ InvalidJwtException -> 0x00b7, JoseException -> 0x00ca, Exception -> 0x0134 }
            goto L_0x0049
        L_0x00b7:
            r11 = move-exception
            r8 = r11
            r11 = r0
            boolean r11 = r11.liberalContentTypeHandling     // Catch:{ JoseException -> 0x00ca, InvalidJwtException -> 0x0130, Exception -> 0x0134 }
            if (r11 == 0) goto L_0x012e
            r11 = r1
            org.jose4j.jwx.JsonWebStructure r11 = org.jose4j.jwx.JsonWebStructure.fromCompactSerialization(r11)     // Catch:{ JoseException -> 0x00c6, InvalidJwtException -> 0x0130, Exception -> 0x0134 }
            r11 = r7
            r2 = r11
            goto L_0x0049
        L_0x00c6:
            r11 = move-exception
            r9 = r11
            r11 = r8
            throw r11     // Catch:{ JoseException -> 0x00ca, InvalidJwtException -> 0x0130, Exception -> 0x0134 }
        L_0x00ca:
            r11 = move-exception
            r7 = r11
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r17 = r11
            r11 = r17
            r12 = r17
            r12.<init>()
            r8 = r11
            r11 = r8
            java.lang.String r12 = "Unable to process"
            java.lang.StringBuilder r11 = r11.append(r12)
            r11 = r4
            boolean r11 = r11.isEmpty()
            if (r11 != 0) goto L_0x00ef
            r11 = r8
            java.lang.String r12 = " nested"
            java.lang.StringBuilder r11 = r11.append(r12)
        L_0x00ef:
            r11 = r8
            java.lang.String r12 = " JOSE object (cause: "
            java.lang.StringBuilder r11 = r11.append(r12)
            r12 = r7
            java.lang.StringBuilder r11 = r11.append(r12)
            java.lang.String r12 = "): "
            java.lang.StringBuilder r11 = r11.append(r12)
            r12 = r2
            java.lang.StringBuilder r11 = r11.append(r12)
            org.jose4j.jwt.consumer.ErrorCodeValidator$Error r11 = new org.jose4j.jwt.consumer.ErrorCodeValidator$Error
            r17 = r11
            r11 = r17
            r12 = r17
            r13 = 17
            r14 = r8
            java.lang.String r14 = r14.toString()
            r12.<init>(r13, r14)
            r9 = r11
            org.jose4j.jwt.consumer.InvalidJwtException r11 = new org.jose4j.jwt.consumer.InvalidJwtException
            r17 = r11
            r11 = r17
            r12 = r17
            java.lang.String r13 = "JWT processing failed."
            r14 = r9
            r15 = r7
            r16 = r5
            r12.<init>(r13, r14, r15, r16)
            throw r11
        L_0x012e:
            r11 = r8
            throw r11     // Catch:{ JoseException -> 0x00ca, InvalidJwtException -> 0x0130, Exception -> 0x0134 }
        L_0x0130:
            r11 = move-exception
            r7 = r11
            r11 = r7
            throw r11
        L_0x0134:
            r11 = move-exception
            r7 = r11
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r17 = r11
            r11 = r17
            r12 = r17
            r12.<init>()
            r8 = r11
            r11 = r8
            java.lang.String r12 = "Unexpected exception encountered while processing"
            java.lang.StringBuilder r11 = r11.append(r12)
            r11 = r4
            boolean r11 = r11.isEmpty()
            if (r11 != 0) goto L_0x0159
            r11 = r8
            java.lang.String r12 = " nested"
            java.lang.StringBuilder r11 = r11.append(r12)
        L_0x0159:
            r11 = r8
            java.lang.String r12 = " JOSE object ("
            java.lang.StringBuilder r11 = r11.append(r12)
            r12 = r7
            java.lang.StringBuilder r11 = r11.append(r12)
            java.lang.String r12 = "): "
            java.lang.StringBuilder r11 = r11.append(r12)
            r12 = r2
            java.lang.StringBuilder r11 = r11.append(r12)
            org.jose4j.jwt.consumer.ErrorCodeValidator$Error r11 = new org.jose4j.jwt.consumer.ErrorCodeValidator$Error
            r17 = r11
            r11 = r17
            r12 = r17
            r13 = 17
            r14 = r8
            java.lang.String r14 = r14.toString()
            r12.<init>(r13, r14)
            r9 = r11
            org.jose4j.jwt.consumer.InvalidJwtException r11 = new org.jose4j.jwt.consumer.InvalidJwtException
            r17 = r11
            r11 = r17
            r12 = r17
            java.lang.String r13 = "JWT processing failed."
            r14 = r9
            r15 = r7
            r16 = r5
            r12.<init>(r13, r14, r15, r16)
            throw r11
        L_0x0198:
            r11 = r0
            r12 = r5
            r11.processContext(r12)
            r11 = r5
            r0 = r11
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jose4j.jwt.consumer.JwtConsumer.process(java.lang.String):org.jose4j.jwt.consumer.JwtContext");
    }

    /* access modifiers changed from: package-private */
    public void validate(JwtContext jwtContext) throws InvalidJwtException {
        List<ErrorCodeValidator.Error> list;
        StringBuilder sb;
        Throwable th;
        StringBuilder sb2;
        ErrorCodeValidator.Error error;
        ErrorCodeValidator.Error error2;
        ErrorCodeValidator.Error error3;
        JwtContext jwtCtx = jwtContext;
        new ArrayList<>();
        List<ErrorCodeValidator.Error> issues = list;
        for (ErrorCodeValidator validator : this.validators) {
            try {
                error2 = validator.validate(jwtCtx);
            } catch (MalformedClaimException e) {
                new ErrorCodeValidator.Error(18, e.getMessage());
                error2 = error3;
            } catch (Exception e2) {
                new StringBuilder();
                new ErrorCodeValidator.Error(17, sb2.append("Unexpected exception thrown from validator ").append(validator.getClass().getName()).append(": ").append(ExceptionHelp.toStringWithCausesAndAbbreviatedStack(e2, getClass())).toString());
                error2 = error;
            }
            if (error2 != null) {
                boolean add = issues.add(error2);
            }
        }
        if (!issues.isEmpty()) {
            new StringBuilder();
            Throwable th2 = th;
            new InvalidJwtException(sb.append("JWT (claims->").append(jwtCtx.getJwtClaims().getRawJson()).append(") rejected due to invalid claims or other invalid content.").toString(), issues, jwtCtx);
            throw th2;
        }
    }

    private boolean isNestedJwt(JsonWebStructure joseObject) {
        String cty = joseObject.getContentTypeHeaderValue();
        return cty != null && (cty.equalsIgnoreCase("jwt") || cty.equalsIgnoreCase("application/jwt"));
    }
}
