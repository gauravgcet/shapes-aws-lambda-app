package shapes;

import junit.framework.TestCase;
import org.junit.Test;
import utils.Constant;

public class TriangleTest extends TestCase {

    @Test
    public void testArea() {
        Triangle triangle = new Triangle(10,10);
        assertEquals(triangle.area(),50, 0.01);
    }

    @Test
    public void testPerimeter() {
        Triangle triangle = new Triangle(10,10);
        assertEquals(triangle.perimeter(),0.0,0.01);
    }

    @Test
    public void testTestGetName() {
        Triangle triangle = new Triangle(10,10);
        assertEquals(triangle.getName(), Constant.SupportedShapes.TRIANGLE.name());
    }
}