package shapes;

import junit.framework.TestCase;
import org.junit.Test;
import utils.Constant;

public class SquareTest extends TestCase {
    @Test
    public void testArea() {
        Square square = new Square(10.2,10.2);
        assertEquals(square.area(),104.04, 0.01);
    }

    @Test
    public void testPerimeter() {
        Square square = new Square(10.2,10.2);
        assertEquals(square.perimeter(),40.8, 0.01);
    }

    @Test
    public void testTestGetName() {
        Square square = new Square(10.2,10.2);
        assertEquals(square.getName(), Constant.SupportedShapes.SQUARE.name());
    }

}