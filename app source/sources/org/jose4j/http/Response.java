package org.jose4j.http;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Response implements SimpleResponse {
    private String body;
    private Map<String, List<String>> headers;
    private int statusCode;
    private String statusMessage;

    public Response(int statusCode2, String statusMessage2, Map<String, List<String>> headers2, String str) {
        Map<String, List<String>> map;
        String body2 = str;
        this.statusCode = statusCode2;
        this.statusMessage = statusMessage2;
        new HashMap();
        this.headers = map;
        for (Map.Entry<String, List<String>> header : headers2.entrySet()) {
            List<String> put = this.headers.put(normalizeHeaderName(header.getKey()), header.getValue());
        }
        this.body = body2;
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    public String getStatusMessage() {
        return this.statusMessage;
    }

    public Collection<String> getHeaderNames() {
        return this.headers.keySet();
    }

    public List<String> getHeaderValues(String name) {
        return this.headers.get(normalizeHeaderName(name));
    }

    public String getBody() {
        return this.body;
    }

    private String normalizeHeaderName(String str) {
        String name = str;
        return name != null ? name.toLowerCase().trim() : null;
    }

    public String toString() {
        StringBuilder sb;
        new StringBuilder();
        return sb.append("SimpleResponse{statusCode=").append(this.statusCode).append(", statusMessage='").append(this.statusMessage).append('\'').append(", headers=").append(this.headers).append(", body='").append(this.body).append('\'').append('}').toString();
    }
}
