package lambda;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * POJO containing response object for API Gateway.
 */
public class GatewayResponse {

    private final ShapeResponse shapeResponse;
    private final Map<String, String> headers;
    private final int statusCode;

    public GatewayResponse(final ShapeResponse shapeResponse, final Map<String, String> headers, final int statusCode) {
        this.statusCode = statusCode;
        this.shapeResponse = shapeResponse;
        this.headers = Collections.unmodifiableMap(new HashMap<>(headers));
    }

    public ShapeResponse getAreaResponse() {
        return shapeResponse;
    }
    public Map<String, String> getHeaders() {
        return headers;
    }

    public int getStatusCode() {
        return statusCode;
    }
}
