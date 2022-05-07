package org.jose4j.jwt;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.jose4j.base64url.Base64Url;
import org.jose4j.json.JsonUtil;
import org.jose4j.jwt.consumer.ErrorCodeValidator;
import org.jose4j.jwt.consumer.InvalidJwtException;
import org.jose4j.jwt.consumer.JwtContext;
import org.jose4j.lang.ByteUtil;
import org.jose4j.lang.JoseException;

public class JwtClaims {
    private Map<String, Object> claimsMap;
    private String rawJson;

    public JwtClaims() {
        Map<String, Object> map;
        new LinkedHashMap();
        this.claimsMap = map;
    }

    private JwtClaims(String str, JwtContext jwtContext) throws InvalidJwtException {
        StringBuilder sb;
        ErrorCodeValidator.Error error;
        Throwable th;
        Map<String, Object> map;
        String jsonClaims = str;
        JwtContext jwtContext2 = jwtContext;
        this.rawJson = jsonClaims;
        try {
            new LinkedHashMap(JsonUtil.parseJson(jsonClaims));
            this.claimsMap = map;
        } catch (JoseException e) {
            JoseException e2 = e;
            new StringBuilder();
            String msg = sb.append("Unable to parse what was expected to be the JWT Claim Set JSON: \"").append(jsonClaims).append("\"").toString();
            new ErrorCodeValidator.Error(16, "Invalid JSON.");
            Throwable th2 = th;
            new InvalidJwtException(msg, error, e2, jwtContext2);
            throw th2;
        }
    }

    public static JwtClaims parse(String jsonClaims, JwtContext jwtContext) throws InvalidJwtException {
        JwtClaims jwtClaims;
        new JwtClaims(jsonClaims, jwtContext);
        return jwtClaims;
    }

    public static JwtClaims parse(String jsonClaims) throws InvalidJwtException {
        JwtClaims jwtClaims;
        new JwtClaims(jsonClaims, (JwtContext) null);
        return jwtClaims;
    }

    public String getIssuer() throws MalformedClaimException {
        return (String) getClaimValue(ReservedClaimNames.ISSUER, String.class);
    }

    public void setIssuer(String issuer) {
        Object put = this.claimsMap.put(ReservedClaimNames.ISSUER, issuer);
    }

    public String getSubject() throws MalformedClaimException {
        return (String) getClaimValue(ReservedClaimNames.SUBJECT, String.class);
    }

    public void setSubject(String subject) {
        Object put = this.claimsMap.put(ReservedClaimNames.SUBJECT, subject);
    }

    public void setAudience(String audience) {
        Object put = this.claimsMap.put(ReservedClaimNames.AUDIENCE, audience);
    }

    public void setAudience(String... audience) {
        setAudience((List<String>) Arrays.asList(audience));
    }

    public void setAudience(List<String> list) {
        List<String> audiences = list;
        if (audiences.size() == 1) {
            setAudience(audiences.get(0));
        } else {
            Object put = this.claimsMap.put(ReservedClaimNames.AUDIENCE, audiences);
        }
    }

    public boolean hasAudience() {
        return hasClaim(ReservedClaimNames.AUDIENCE);
    }

    /*  JADX ERROR: NullPointerException in pass: CodeShrinkVisitor
        java.lang.NullPointerException
        */
    public java.util.List<java.lang.String> getAudience() throws org.jose4j.jwt.MalformedClaimException {
        /*
            r8 = this;
            r0 = r8
            r4 = r0
            java.util.Map<java.lang.String, java.lang.Object> r4 = r4.claimsMap
            java.lang.String r5 = "aud"
            java.lang.Object r4 = r4.get(r5)
            r1 = r4
            r4 = r1
            boolean r4 = r4 instanceof java.lang.String
            if (r4 == 0) goto L_0x001a
            r4 = r1
            java.lang.String r4 = (java.lang.String) r4
            java.util.List r4 = java.util.Collections.singletonList(r4)
            r0 = r4
        L_0x0019:
            return r0
        L_0x001a:
            r4 = r1
            boolean r4 = r4 instanceof java.util.List
            if (r4 != 0) goto L_0x0022
            r4 = r1
            if (r4 != 0) goto L_0x0033
        L_0x0022:
            r4 = r1
            java.util.List r4 = (java.util.List) r4
            r2 = r4
            java.lang.String r4 = "aud"
            r3 = r4
            r4 = r0
            r5 = r2
            r6 = r3
            java.util.List r4 = r4.toStringList(r5, r6)
            r0 = r4
            goto L_0x0019
        L_0x0033:
            org.jose4j.jwt.MalformedClaimException r4 = new org.jose4j.jwt.MalformedClaimException
            r7 = r4
            r4 = r7
            r5 = r7
            java.lang.String r6 = "The value of the 'aud' claim is not an array of strings or a single string value."
            r5.<init>(r6)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jose4j.jwt.JwtClaims.getAudience():java.util.List");
    }

    private List<String> toStringList(List list, String str) throws MalformedClaimException {
        List<String> list2;
        Throwable th;
        StringBuilder sb;
        List list3 = list;
        String claimName = str;
        if (list3 == null) {
            return Collections.emptyList();
        }
        new ArrayList();
        List<String> values = list2;
        for (Object object : list3) {
            try {
                boolean add = values.add((String) object);
            } catch (ClassCastException e) {
                ClassCastException e2 = e;
                Throwable th2 = th;
                new StringBuilder();
                new MalformedClaimException(sb.append("The array value of the '").append(claimName).append("' claim contains non string values ").append(classCastMsg(e2, object)).toString(), e2);
                throw th2;
            }
        }
        return values;
    }

    public NumericDate getExpirationTime() throws MalformedClaimException {
        return getNumericDateClaimValue(ReservedClaimNames.EXPIRATION_TIME);
    }

    public void setExpirationTime(NumericDate expirationTime) {
        setNumericDateClaim(ReservedClaimNames.EXPIRATION_TIME, expirationTime);
    }

    public void setExpirationTimeMinutesInTheFuture(float minutes) {
        setExpirationTime(offsetFromNow(minutes));
    }

    private NumericDate offsetFromNow(float offsetMinutes) {
        NumericDate numericDate = NumericDate.now();
        numericDate.addSeconds((long) (offsetMinutes * 60.0f));
        return numericDate;
    }

    public NumericDate getNotBefore() throws MalformedClaimException {
        return getNumericDateClaimValue(ReservedClaimNames.NOT_BEFORE);
    }

    public void setNotBefore(NumericDate notBefore) {
        setNumericDateClaim(ReservedClaimNames.NOT_BEFORE, notBefore);
    }

    public void setNotBeforeMinutesInThePast(float minutes) {
        setNotBefore(offsetFromNow(-1.0f * minutes));
    }

    public NumericDate getIssuedAt() throws MalformedClaimException {
        return getNumericDateClaimValue(ReservedClaimNames.ISSUED_AT);
    }

    public void setIssuedAt(NumericDate issuedAt) {
        setNumericDateClaim(ReservedClaimNames.ISSUED_AT, issuedAt);
    }

    public void setIssuedAtToNow() {
        setIssuedAt(NumericDate.now());
    }

    public String getJwtId() throws MalformedClaimException {
        return (String) getClaimValue(ReservedClaimNames.JWT_ID, String.class);
    }

    public void setJwtId(String jwtId) {
        Object put = this.claimsMap.put(ReservedClaimNames.JWT_ID, jwtId);
    }

    public void setGeneratedJwtId(int numberOfBytes) {
        setJwtId(Base64Url.encode(ByteUtil.randomBytes(numberOfBytes)));
    }

    public void setGeneratedJwtId() {
        setGeneratedJwtId(16);
    }

    public void unsetClaim(String claimName) {
        Object remove = this.claimsMap.remove(claimName);
    }

    public <T> T getClaimValue(String str, Class<T> type) throws MalformedClaimException {
        Throwable th;
        StringBuilder sb;
        String claimName = str;
        Object o = this.claimsMap.get(claimName);
        try {
            return type.cast(o);
        } catch (ClassCastException e) {
            ClassCastException e2 = e;
            Throwable th2 = th;
            new StringBuilder();
            new MalformedClaimException(sb.append("The value of the '").append(claimName).append("' claim is not the expected type ").append(classCastMsg(e2, o)).toString(), e2);
            throw th2;
        }
    }

    public Object getClaimValue(String claimName) {
        return this.claimsMap.get(claimName);
    }

    public boolean hasClaim(String claimName) {
        return getClaimValue(claimName) != null;
    }

    private String classCastMsg(ClassCastException e, Object o) {
        StringBuilder sb;
        new StringBuilder();
        return sb.append("(").append(o).append(" - ").append(e.getMessage()).append(")").toString();
    }

    public NumericDate getNumericDateClaimValue(String claimName) throws MalformedClaimException {
        Throwable th;
        StringBuilder sb;
        Number number = (Number) getClaimValue(claimName, Number.class);
        if (number instanceof BigInteger) {
            Throwable th2 = th;
            new StringBuilder();
            new MalformedClaimException(sb.append(number).append(" is unreasonable for a NumericDate").toString());
            throw th2;
        }
        return number != null ? NumericDate.fromSeconds(number.longValue()) : null;
    }

    public String getStringClaimValue(String claimName) throws MalformedClaimException {
        return (String) getClaimValue(claimName, String.class);
    }

    public String getClaimValueAsString(String claimName) {
        Object claimObjectValue = getClaimValue(claimName);
        return claimObjectValue != null ? claimObjectValue.toString() : null;
    }

    public List<String> getStringListClaimValue(String str) throws MalformedClaimException {
        String claimName = str;
        return toStringList((List) getClaimValue(claimName, List.class), claimName);
    }

    public void setNumericDateClaim(String claimName, NumericDate numericDate) {
        NumericDate value = numericDate;
        Object put = this.claimsMap.put(claimName, value != null ? Long.valueOf(value.getValue()) : null);
    }

    public void setStringClaim(String claimName, String value) {
        Object put = this.claimsMap.put(claimName, value);
    }

    public void setStringListClaim(String claimName, List<String> values) {
        Object put = this.claimsMap.put(claimName, values);
    }

    public void setStringListClaim(String claimName, String... values) {
        Object put = this.claimsMap.put(claimName, Arrays.asList(values));
    }

    public void setClaim(String claimName, Object value) {
        Object put = this.claimsMap.put(claimName, value);
    }

    public boolean isClaimValueOfType(String claimName, Class type) {
        try {
            return getClaimValue(claimName, type) != null;
        } catch (MalformedClaimException e) {
            MalformedClaimException malformedClaimException = e;
            return false;
        }
    }

    public boolean isClaimValueString(String claimName) {
        return isClaimValueOfType(claimName, String.class);
    }

    public boolean isClaimValueStringList(String str) {
        String claimName = str;
        try {
            return hasClaim(claimName) && getStringListClaimValue(claimName) != null;
        } catch (MalformedClaimException e) {
            MalformedClaimException malformedClaimException = e;
            return false;
        }
    }

    public Map<String, List<Object>> flattenClaims() {
        return flattenClaims((Set<String>) null);
    }

    public Map<String, List<Object>> flattenClaims(Set<String> set) {
        Map<String, List<Object>> map;
        Set<String> omittedClaims = set;
        Set<String> omittedClaims2 = omittedClaims == null ? Collections.emptySet() : omittedClaims;
        new LinkedHashMap();
        Map<String, List<Object>> flattenedClaims = map;
        for (Map.Entry<String, Object> e : this.claimsMap.entrySet()) {
            String key = e.getKey();
            if (!omittedClaims2.contains(key)) {
                dfs((String) null, key, e.getValue(), flattenedClaims);
            }
        }
        return flattenedClaims;
    }

    private void dfs(String str, String str2, Object obj, Map<String, List<Object>> map) {
        StringBuilder sb;
        StringBuilder sb2;
        String sb3;
        List<Object> list;
        String baseName = str;
        String name = str2;
        Object value = obj;
        Map<String, List<Object>> flattenedClaims = map;
        StringBuilder sb4 = sb;
        new StringBuilder();
        if (baseName == null) {
            sb3 = "";
        } else {
            new StringBuilder();
            sb3 = sb2.append(baseName).append(".").toString();
        }
        String key = sb4.append(sb3).append(name).toString();
        if (value instanceof List) {
            new ArrayList<>();
            List<Object> newList = list;
            for (Object item : (List) value) {
                if (item instanceof Map) {
                    for (Map.Entry<?, ?> e : ((Map) item).entrySet()) {
                        dfs(key, e.getKey().toString(), e.getValue(), flattenedClaims);
                    }
                } else {
                    boolean add = newList.add(item);
                }
            }
            List<Object> put = flattenedClaims.put(key, newList);
        } else if (value instanceof Map) {
            for (Map.Entry<?, ?> e2 : ((Map) value).entrySet()) {
                dfs(key, e2.getKey().toString(), e2.getValue(), flattenedClaims);
            }
        } else {
            List<Object> put2 = flattenedClaims.put(key, Collections.singletonList(value));
        }
    }

    public Map<String, Object> getClaimsMap(Set<String> set) {
        LinkedHashMap linkedHashMap;
        Set<String> omittedClaims = set;
        Set<String> omittedClaims2 = omittedClaims != null ? omittedClaims : Collections.emptySet();
        new LinkedHashMap(this.claimsMap);
        LinkedHashMap linkedHashMap2 = linkedHashMap;
        for (String omittedClaim : omittedClaims2) {
            Object remove = linkedHashMap2.remove(omittedClaim);
        }
        return linkedHashMap2;
    }

    public Map<String, Object> getClaimsMap() {
        return getClaimsMap((Set<String>) null);
    }

    public Collection<String> getClaimNames(Set<String> omittedClaims) {
        return getClaimsMap(omittedClaims).keySet();
    }

    public Collection<String> getClaimNames() {
        return getClaimNames((Set<String>) null);
    }

    public String toJson() {
        return JsonUtil.toJson(this.claimsMap);
    }

    public String getRawJson() {
        return this.rawJson;
    }

    public String toString() {
        StringBuilder sb;
        new StringBuilder();
        return sb.append("JWT Claims Set:").append(this.claimsMap).toString();
    }
}
