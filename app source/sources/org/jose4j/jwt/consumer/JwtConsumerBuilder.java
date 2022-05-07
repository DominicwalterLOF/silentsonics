package org.jose4j.jwt.consumer;

import java.security.Key;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.jose4j.jca.ProviderContext;
import org.jose4j.jwa.AlgorithmConstraints;
import org.jose4j.jwt.NumericDate;
import org.jose4j.keys.resolvers.DecryptionKeyResolver;
import org.jose4j.keys.resolvers.VerificationKeyResolver;

public class JwtConsumerBuilder {
    private AudValidator audValidator;
    private List<ErrorCodeValidator> customValidators;
    private NumericDateValidator dateClaimsValidator;
    private DecryptionKeyResolver decryptionKeyResolver;
    private String expectedSubject;
    private IssValidator issValidator;
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
    private boolean requireJti;
    private boolean requireSignature = true;
    private boolean requireSubject;
    private boolean skipAllDefaultValidators = false;
    private boolean skipAllValidators = false;
    private boolean skipDefaultAudienceValidation;
    private boolean skipSignatureVerification = false;
    private boolean skipVerificationKeyResolutionOnNone;
    private TypeValidator typeValidator;
    private VerificationKeyResolver verificationKeyResolver;

    public JwtConsumerBuilder() {
        VerificationKeyResolver verificationKeyResolver2;
        DecryptionKeyResolver decryptionKeyResolver2;
        NumericDateValidator numericDateValidator;
        List<ErrorCodeValidator> list;
        new SimpleKeyResolver((Key) null);
        this.verificationKeyResolver = verificationKeyResolver2;
        new SimpleKeyResolver((Key) null);
        this.decryptionKeyResolver = decryptionKeyResolver2;
        new NumericDateValidator();
        this.dateClaimsValidator = numericDateValidator;
        new ArrayList();
        this.customValidators = list;
    }

    public JwtConsumerBuilder setEnableRequireEncryption() {
        this.requireEncryption = true;
        return this;
    }

    public JwtConsumerBuilder setEnableRequireIntegrity() {
        this.requireIntegrity = true;
        return this;
    }

    public JwtConsumerBuilder setDisableRequireSignature() {
        this.requireSignature = false;
        return this;
    }

    public JwtConsumerBuilder setEnableLiberalContentTypeHandling() {
        this.liberalContentTypeHandling = true;
        return this;
    }

    public JwtConsumerBuilder setSkipSignatureVerification() {
        this.skipSignatureVerification = true;
        return this;
    }

    public JwtConsumerBuilder setSkipAllValidators() {
        this.skipAllValidators = true;
        return this;
    }

    public JwtConsumerBuilder setSkipAllDefaultValidators() {
        this.skipAllDefaultValidators = true;
        return this;
    }

    public JwtConsumerBuilder setJwsAlgorithmConstraints(AlgorithmConstraints constraints) {
        this.jwsAlgorithmConstraints = constraints;
        return this;
    }

    public JwtConsumerBuilder setJweAlgorithmConstraints(AlgorithmConstraints constraints) {
        this.jweAlgorithmConstraints = constraints;
        return this;
    }

    public JwtConsumerBuilder setJweContentEncryptionAlgorithmConstraints(AlgorithmConstraints constraints) {
        this.jweContentEncryptionAlgorithmConstraints = constraints;
        return this;
    }

    public JwtConsumerBuilder setJwsAlgorithmConstraints(AlgorithmConstraints.ConstraintType type, String... algorithms) {
        AlgorithmConstraints algorithmConstraints;
        new AlgorithmConstraints(type, algorithms);
        this.jwsAlgorithmConstraints = algorithmConstraints;
        return this;
    }

    public JwtConsumerBuilder setJweAlgorithmConstraints(AlgorithmConstraints.ConstraintType type, String... algorithms) {
        AlgorithmConstraints algorithmConstraints;
        new AlgorithmConstraints(type, algorithms);
        this.jweAlgorithmConstraints = algorithmConstraints;
        return this;
    }

    public JwtConsumerBuilder setJweContentEncryptionAlgorithmConstraints(AlgorithmConstraints.ConstraintType type, String... algorithms) {
        AlgorithmConstraints algorithmConstraints;
        new AlgorithmConstraints(type, algorithms);
        this.jweContentEncryptionAlgorithmConstraints = algorithmConstraints;
        return this;
    }

    public JwtConsumerBuilder setVerificationKey(Key verificationKey) {
        VerificationKeyResolver verificationKeyResolver2;
        new SimpleKeyResolver(verificationKey);
        return setVerificationKeyResolver(verificationKeyResolver2);
    }

    public JwtConsumerBuilder setVerificationKeyResolver(VerificationKeyResolver verificationKeyResolver2) {
        this.verificationKeyResolver = verificationKeyResolver2;
        return this;
    }

    public JwtConsumerBuilder setSkipVerificationKeyResolutionOnNone() {
        this.skipVerificationKeyResolutionOnNone = true;
        return this;
    }

    public JwtConsumerBuilder setDecryptionKey(Key decryptionKey) {
        DecryptionKeyResolver decryptionKeyResolver2;
        new SimpleKeyResolver(decryptionKey);
        return setDecryptionKeyResolver(decryptionKeyResolver2);
    }

    public JwtConsumerBuilder setDecryptionKeyResolver(DecryptionKeyResolver decryptionKeyResolver2) {
        this.decryptionKeyResolver = decryptionKeyResolver2;
        return this;
    }

    public JwtConsumerBuilder setExpectedAudience(String... audience) {
        return setExpectedAudience(true, audience);
    }

    public JwtConsumerBuilder setExpectedAudience(boolean requireAudienceClaim, String... audience) {
        Set<String> acceptableAudiences;
        AudValidator audValidator2;
        new HashSet<>(Arrays.asList(audience));
        new AudValidator(acceptableAudiences, requireAudienceClaim);
        this.audValidator = audValidator2;
        return this;
    }

    public JwtConsumerBuilder setSkipDefaultAudienceValidation() {
        this.skipDefaultAudienceValidation = true;
        return this;
    }

    public JwtConsumerBuilder setExpectedIssuers(boolean requireIssuer, String... expectedIssuers) {
        IssValidator issValidator2;
        new IssValidator(requireIssuer, expectedIssuers);
        this.issValidator = issValidator2;
        return this;
    }

    public JwtConsumerBuilder setExpectedIssuer(boolean requireIssuer, String expectedIssuer) {
        IssValidator issValidator2;
        new IssValidator(expectedIssuer, requireIssuer);
        this.issValidator = issValidator2;
        return this;
    }

    public JwtConsumerBuilder setExpectedIssuer(String expectedIssuer) {
        return setExpectedIssuer(true, expectedIssuer);
    }

    public JwtConsumerBuilder setRequireSubject() {
        this.requireSubject = true;
        return this;
    }

    public JwtConsumerBuilder setExpectedSubject(String subject) {
        this.expectedSubject = subject;
        return setRequireSubject();
    }

    public JwtConsumerBuilder setRequireJwtId() {
        this.requireJti = true;
        return this;
    }

    public JwtConsumerBuilder setRequireExpirationTime() {
        this.dateClaimsValidator.setRequireExp(true);
        return this;
    }

    public JwtConsumerBuilder setRequireIssuedAt() {
        this.dateClaimsValidator.setRequireIat(true);
        return this;
    }

    public JwtConsumerBuilder setIssuedAtRestrictions(int allowedSecondsInTheFuture, int allowedSecondsInThePast) {
        this.dateClaimsValidator.setIatAllowedSecondsInTheFuture(allowedSecondsInTheFuture);
        this.dateClaimsValidator.setIatAllowedSecondsInThePast(allowedSecondsInThePast);
        return this;
    }

    public JwtConsumerBuilder setRequireNotBefore() {
        this.dateClaimsValidator.setRequireNbf(true);
        return this;
    }

    public JwtConsumerBuilder setEvaluationTime(NumericDate evaluationTime) {
        this.dateClaimsValidator.setEvaluationTime(evaluationTime);
        return this;
    }

    public JwtConsumerBuilder setAllowedClockSkewInSeconds(int secondsOfAllowedClockSkew) {
        this.dateClaimsValidator.setAllowedClockSkewSeconds(secondsOfAllowedClockSkew);
        return this;
    }

    public JwtConsumerBuilder setMaxFutureValidityInMinutes(int maxFutureValidityInMinutes) {
        this.dateClaimsValidator.setMaxFutureValidityInMinutes(maxFutureValidityInMinutes);
        return this;
    }

    public JwtConsumerBuilder setRelaxVerificationKeyValidation() {
        this.relaxVerificationKeyValidation = true;
        return this;
    }

    public JwtConsumerBuilder setRelaxDecryptionKeyValidation() {
        this.relaxDecryptionKeyValidation = true;
        return this;
    }

    public JwtConsumerBuilder registerValidator(Validator validator) {
        Object obj;
        new ErrorCodeValidatorAdapter(validator);
        boolean add = this.customValidators.add(obj);
        return this;
    }

    public JwtConsumerBuilder registerValidator(ErrorCodeValidator validator) {
        boolean add = this.customValidators.add(validator);
        return this;
    }

    public JwtConsumerBuilder setJwsCustomizer(JwsCustomizer jwsCustomizer2) {
        this.jwsCustomizer = jwsCustomizer2;
        return this;
    }

    public JwtConsumerBuilder setJweCustomizer(JweCustomizer jweCustomizer2) {
        this.jweCustomizer = jweCustomizer2;
        return this;
    }

    public JwtConsumerBuilder setJwsProviderContext(ProviderContext jwsProviderContext2) {
        this.jwsProviderContext = jwsProviderContext2;
        return this;
    }

    public JwtConsumerBuilder setJweProviderContext(ProviderContext jweProviderContext2) {
        this.jweProviderContext = jweProviderContext2;
        return this;
    }

    public JwtConsumerBuilder setExpectedType(boolean requireType, String expectedType) {
        TypeValidator typeValidator2;
        new TypeValidator(requireType, expectedType);
        this.typeValidator = typeValidator2;
        return this;
    }

    public JwtConsumer build() {
        List<ErrorCodeValidator> list;
        JwtConsumer jwtConsumer;
        Object obj;
        Object obj2;
        Object obj3;
        Object obj4;
        IssValidator issValidator2;
        AudValidator audValidator2;
        new ArrayList<>();
        List<ErrorCodeValidator> validators = list;
        if (!this.skipAllValidators) {
            if (!this.skipAllDefaultValidators) {
                if (!this.skipDefaultAudienceValidation) {
                    if (this.audValidator == null) {
                        new AudValidator(Collections.emptySet(), false);
                        this.audValidator = audValidator2;
                    }
                    boolean add = validators.add(this.audValidator);
                }
                if (this.issValidator == null) {
                    new IssValidator((String) null, false);
                    this.issValidator = issValidator2;
                }
                boolean add2 = validators.add(this.issValidator);
                boolean add3 = validators.add(this.dateClaimsValidator);
                if (this.expectedSubject == null) {
                    obj2 = obj4;
                    new SubValidator(this.requireSubject);
                } else {
                    obj2 = obj;
                    new SubValidator(this.expectedSubject);
                }
                boolean add4 = validators.add(obj2);
                new JtiValidator(this.requireJti);
                boolean add5 = validators.add(obj3);
                if (this.typeValidator != null) {
                    boolean add6 = validators.add(this.typeValidator);
                }
            }
            boolean addAll = validators.addAll(this.customValidators);
        }
        new JwtConsumer();
        JwtConsumer jwtConsumer2 = jwtConsumer;
        jwtConsumer2.setValidators(validators);
        jwtConsumer2.setVerificationKeyResolver(this.verificationKeyResolver);
        jwtConsumer2.setDecryptionKeyResolver(this.decryptionKeyResolver);
        jwtConsumer2.setJwsAlgorithmConstraints(this.jwsAlgorithmConstraints);
        jwtConsumer2.setJweAlgorithmConstraints(this.jweAlgorithmConstraints);
        jwtConsumer2.setJweContentEncryptionAlgorithmConstraints(this.jweContentEncryptionAlgorithmConstraints);
        jwtConsumer2.setRequireSignature(this.requireSignature);
        jwtConsumer2.setRequireEncryption(this.requireEncryption);
        jwtConsumer2.setRequireIntegrity(this.requireIntegrity);
        jwtConsumer2.setLiberalContentTypeHandling(this.liberalContentTypeHandling);
        jwtConsumer2.setSkipSignatureVerification(this.skipSignatureVerification);
        jwtConsumer2.setSkipVerificationKeyResolutionOnNone(this.skipVerificationKeyResolutionOnNone);
        jwtConsumer2.setRelaxVerificationKeyValidation(this.relaxVerificationKeyValidation);
        jwtConsumer2.setRelaxDecryptionKeyValidation(this.relaxDecryptionKeyValidation);
        jwtConsumer2.setJwsCustomizer(this.jwsCustomizer);
        jwtConsumer2.setJweCustomizer(this.jweCustomizer);
        jwtConsumer2.setJwsProviderContext(this.jwsProviderContext);
        jwtConsumer2.setJweProviderContext(this.jweProviderContext);
        return jwtConsumer2;
    }
}
