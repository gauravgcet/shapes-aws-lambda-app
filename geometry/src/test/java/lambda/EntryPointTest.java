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

    ShapeResponse shapeResponse = app.handleRequest(shapeRequest, null);
    assertEquals(shapeResponse.getArea(),100, 0.01);
  }
}
