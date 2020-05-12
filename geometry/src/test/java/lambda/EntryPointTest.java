package lambda;

import junit.framework.TestCase;

import org.junit.Test;
import java.util.Arrays;
import java.util.Map;


import static org.junit.Assert.*;

public class EntryPointTest {

    @Test
    public void successfulRectangleArea() {

        EntryPoint app = new EntryPoint();
        GatewayRequest gatewayRequest = new GatewayRequest();

        gatewayRequest.setPathParameters(Map.of("shapeName", "RECTANGLE"));
        gatewayRequest.setMultiValueQueryStringParameters(Map.of("side", Arrays.asList("10","10")));

        GatewayResponse gatewayResponse =  app.handleRequest(gatewayRequest, null);

        assertEquals(gatewayResponse.getBody().contains("100"),true);
    }

    @Test
    public void successful400UnsupportedShapes() {
        EntryPoint app = new EntryPoint();
        GatewayRequest gatewayRequest = new GatewayRequest();

        gatewayRequest.setPathParameters(Map.of("shapeName", "abc"));
        gatewayRequest.setMultiValueQueryStringParameters(Map.of("side", Arrays.asList("10","10")));

        GatewayResponse gatewayResponse =  app.handleRequest(gatewayRequest, null);
        assertEquals(gatewayResponse.getStatusCode(),500);
        assertEquals(gatewayResponse.getBody(),"shape name not supported");
    }
}
