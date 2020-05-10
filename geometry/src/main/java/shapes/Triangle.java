package shapes;

import utils.Constant;

public class Triangle implements Shape {

    private final double base, height;

    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    @Override
    public double area() {
        return (base * height)/2;
    }

    @Override
    public double perimeter() {
        return 0;
    }

    @Override
    public String getName() {
        return Constant.SupportedShapes.TRIANGLE.name();
    }
}
