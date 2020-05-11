package shapes;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;
import utils.Constant;

public class SquareTest {
    @Test
    public void testGetArea() {
        Square square = new Square(10.2,10.2);
        Assert.assertEquals(square.getArea(), 104.04, 0.01);
    }

    @Test
    public void testGetPerimeter() {
        Square square = new Square(10.2,10.2);
        Assert.assertEquals(square.getPerimeter(), 40.8, 0.01);
    }

    @Test
    public void testGetName() {
        Square square = new Square(10.2,10.2);
        Assert.assertEquals(square.getName(), Constant.SupportedShapes.SQUARE.name());
    }

}