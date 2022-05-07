package org.jose4j.jwx;

import java.util.LinkedHashMap;
import java.util.Map;
import org.jose4j.base64url.Base64Url;
import org.jose4j.json.JsonUtil;
import org.jose4j.jwk.JsonWebKey;
import org.jose4j.jwk.PublicJsonWebKey;
import org.jose4j.lang.JoseException;
import org.jose4j.lang.JsonHelp;

public class Headers {
    protected Base64Url base64url;
    private String encodedHeader;
    private String header;
    private Map<String, Object> headerMap;

    public Headers() {
        Base64Url base64Url;
        Map<String, Object> map;
        new Base64Url();
        this.base64url = base64Url;
        new LinkedHashMap();
        this.headerMap = map;
    }

    public String getFullHeaderAsJsonString() {
        if (this.header == null) {
            this.header = JsonUtil.toJson(this.headerMap);
        }
        return this.header;
    }

    public String getEncodedHeader() {
        if (this.encodedHeader == null) {
            this.encodedHeader = this.base64url.base64UrlEncodeUtf8ByteRepresentation(getFullHeaderAsJsonString());
        }
        return this.encodedHeader;
    }

    public void setStringHeaderValue(String name, String value) {
        setObjectHeaderValue(name, value);
    }

    public void setObjectHeaderValue(String name, Object value) {
        Object put = this.headerMap.put(name, value);
        this.header = null;
        this.encodedHeader = null;
    }

    public void setJwkHeaderValue(String name, JsonWebKey jwk) {
        setObjectHeaderValue(name, jwk.toParams(JsonWebKey.OutputControlLevel.PUBLIC_ONLY));
    }

    public String getStringHeaderValue(String headerName) {
        return JsonHelp.getString(this.headerMap, headerName);
    }

    public Long getLongHeaderValue(String headerName) {
        return JsonHelp.getLong(this.headerMap, headerName);
    }

    public Object getObjectHeaderValue(String name) {
        return this.headerMap.get(name);
    }

    public JsonWebKey getJwkHeaderValue(String name) throws JoseException {
        Map<String, Object> jwkParams = (Map) getObjectHeaderValue(name);
        return jwkParams != null ? JsonWebKey.Factory.newJwk(jwkParams) : null;
    }

    public PublicJsonWebKey getPublicJwkHeaderValue(String name, String str) throws JoseException {
        String jcaProvider = str;
        Map<String, Object> jwkParams = (Map) getObjectHeaderValue(name);
        return jwkParams != null ? PublicJsonWebKey.Factory.newPublicJwk(jwkParams, jcaProvider) : null;
    }

    public void setFullHeaderAsJsonString(String str) throws JoseException {
        String header2 = str;
        this.encodedHeader = null;
        this.header = header2;
        this.headerMap = JsonUtil.parseJson(header2);
    }

    /* access modifiers changed from: package-private */
    public void setEncodedHeader(String encodedHeader2) throws JoseException {
        this.encodedHeader = encodedHeader2;
        this.header = this.base64url.base64UrlDecodeToUtf8String(this.encodedHeader);
        this.headerMap = JsonUtil.parseJson(this.header);
    }
}
