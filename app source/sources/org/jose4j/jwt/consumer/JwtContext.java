package org.jose4j.jwt.consumer;

import java.util.List;
import org.jose4j.jwt.JwtClaims;
import org.jose4j.jwx.JsonWebStructure;

public class JwtContext {
    private List<JsonWebStructure> joseObjects;
    private String jwt;
    private JwtClaims jwtClaims;

    public JwtContext(JwtClaims jwtClaims2, List<JsonWebStructure> joseObjects2) {
        this.jwtClaims = jwtClaims2;
        this.joseObjects = joseObjects2;
    }

    public JwtContext(String jwt2, JwtClaims jwtClaims2, List<JsonWebStructure> joseObjects2) {
        this.jwt = jwt2;
        this.jwtClaims = jwtClaims2;
        this.joseObjects = joseObjects2;
    }

    public JwtClaims getJwtClaims() {
        return this.jwtClaims;
    }

    /* access modifiers changed from: package-private */
    public void setJwtClaims(JwtClaims jwtClaims2) {
        JwtClaims jwtClaims3 = jwtClaims2;
        this.jwtClaims = jwtClaims3;
    }

    public List<JsonWebStructure> getJoseObjects() {
        return this.joseObjects;
    }

    public String getJwt() {
        return this.jwt;
    }
}
