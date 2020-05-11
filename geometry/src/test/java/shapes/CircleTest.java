package shapes;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;
import utils.Constant;

import static org.junit.Assert.assertEquals;

public class CircleTest {

    @Test
    public void testGetArea() {
        Circle circle = new Circle(10);
        Assert.assertEquals(circle.getArea(), 314.16, 0.01);
    }

    @Test
    public void testGetPerimeter() {
        Circle circle = new Circle(10);
        Assert.assertEquals(circle.getPerimeter(), 62.83, 0.01);
    }

    @Test
    public void testGetName() {
        Circle circle = new Circle(10);
        Assert.assertEquals(circle.getName(), Constant.SupportedShapes.CIRCLE.name());
    }

}