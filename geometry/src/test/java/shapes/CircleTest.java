package shapes;

import junit.framework.TestCase;
import org.junit.Test;
import utils.Constant;

import static org.junit.Assert.assertEquals;

public class CircleTest extends TestCase {

    @Test
    public void testArea() {
        Circle circle = new Circle(10);
        assertEquals(circle.area(),314.16, 0.01);
    }

    @Test
    public void testPerimeter() {
        Circle circle = new Circle(10);
        assertEquals(circle.perimeter(),62.83, 0.01);
    }

    @Test
    public void testTestGetName() {
        Circle circle = new Circle(10);
        assertEquals(circle.getName(), Constant.SupportedShapes.CIRCLE.name());
    }

}