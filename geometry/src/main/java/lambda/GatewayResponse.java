package lambda;

import shapes.Shape;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * POJO containing response object for API Gateway.
 */
public class GatewayResponse {

    private final Shape shape;
    private final Map<String, String> headers;
    private final int statusCode;
    private final String message;


    public GatewayResponse(final Shape shape, final Map<String, String> headers, final int statusCode,final String message) {
        this.statusCode = statusCode;
        this.shape = shape;
        this.headers = Collections.unmodifiableMap(new HashMap<>(headers));
        this.message = message;
    }

    public Shape getShape() {
        return shape;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public String getMessage() {
        return message;
    }

    public int getStatusCode() {
        return statusCode;
    }

    @Override
    public String toString() {
        return "GatewayResponse{" +
                "shape=" + shape +
                ", headers=" + headers +
                ", statusCode=" + statusCode +
                ", message='" + message + '\'' +
                '}';
    }
}
