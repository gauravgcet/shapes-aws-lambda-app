package shapes;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;
import utils.Constant;

public class TriangleTest {

    @Test
    public void testGetArea() {
        Triangle triangle = new Triangle(10,10);
        Assert.assertEquals(triangle.getArea(), 50, 0.01);
    }

    @Test
    public void testGetPerimeter() {
        Triangle triangle = new Triangle(10,10);
        Assert.assertEquals(triangle.getPerimeter(), 0.0, 0.01);
    }

    @Test
    public void testGetName() {
        Triangle triangle = new Triangle(10,10);
        Assert.assertEquals(triangle.getName(), Constant.SupportedShapes.TRIANGLE.name());
    }
}