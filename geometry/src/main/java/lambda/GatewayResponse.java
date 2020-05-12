package lambda;

import shapes.Shape;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * POJO containing response object for API Gateway.
 */
public class GatewayResponse {

    private final Map<String, String> headers;
    private final int statusCode;
    private final String body;
    private boolean isBase64Encoded;

    public GatewayResponse(Map<String, String> headers, int statusCode, String body, boolean isBase64Encoded) {
        this.headers = headers;
        this.statusCode = statusCode;
        this.body = body;
        this.isBase64Encoded = isBase64Encoded;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public String getBody() {
        return body;
    }

    public int getStatusCode() {
        return statusCode;
    }

    @Override
    public String toString() {
        return "GatewayResponse{" +
                ", headers=" + headers +
                ", statusCode=" + statusCode +
                '}';
    }
}
