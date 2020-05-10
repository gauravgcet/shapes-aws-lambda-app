package shapes;

import utils.Constant;

public class Square implements Shape {

    private final double width,length;

    public Square(double width, double length) {
        this.width = width;
        this.length = length;
    }

    @Override
    public double area() {
        return length * width;
    }

    @Override
    public double perimeter() {
        return 2 * (width + length);
    }

    @Override
    public String getName() {
        return Constant.SupportedShapes.SQUARE.name();
    }
}
