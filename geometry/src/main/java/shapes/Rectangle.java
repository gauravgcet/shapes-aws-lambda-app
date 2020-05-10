package shapes;

import utils.Constant;

public class Rectangle extends Square {

    public Rectangle(double width, double length) {
        super(width, length);
    }

    @Override
    public String getName() {
        return Constant.SupportedShapes.RECTANGLE.name();
    }
}
