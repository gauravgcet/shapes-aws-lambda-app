package lambda;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import utils.Constant;

import java.util.ArrayList;

public class EntryPointTest {

  @Test
  public void successfulRectangleArea() {
    EntryPoint app = new EntryPoint();
    ShapeRequest shapeRequest = new ShapeRequest();
    shapeRequest.setShapeName(Constant.SupportedShapes.RECTANGLE.name());
    ArrayList<Double> sides = new ArrayList<Double>() {{
      add(Double.parseDouble("10"));
      add(Double.parseDouble("10"));
    }};
    shapeRequest.setSides(sides);

   GatewayResponse gatewayResponse =  app.handleRequest(shapeRequest, null);
   assertEquals(gatewayResponse.getShape().getArea(),100, 0.01);
  }

  @Test
  public void successful404() {
    EntryPoint app = new EntryPoint();
    ShapeRequest shapeRequest = new ShapeRequest();
    shapeRequest.setShapeName(null);
    ArrayList<Double> sides = new ArrayList<Double>() {{
      add(Double.parseDouble("10"));
      add(Double.parseDouble("10"));
    }};
    shapeRequest.setSides(sides);

    GatewayResponse gatewayResponse =  app.handleRequest(shapeRequest, null);
    assertEquals(gatewayResponse.getStatusCode(),400);
    assertEquals(gatewayResponse.getMessage(),"shape name can be empty");
  }

  @Test
  public void successful400UnsupportedShapes() {
    EntryPoint app = new EntryPoint();
    ShapeRequest shapeRequest = new ShapeRequest();
    shapeRequest.setShapeName("abc");
    ArrayList<Double> sides = new ArrayList<Double>() {{
      add(Double.parseDouble("10"));
      add(Double.parseDouble("10"));
    }};
    shapeRequest.setSides(sides);

    GatewayResponse gatewayResponse =  app.handleRequest(shapeRequest, null);
    assertEquals(gatewayResponse.getStatusCode(),400);
    assertEquals(gatewayResponse.getMessage(),"shape name not supported");
  }
}
