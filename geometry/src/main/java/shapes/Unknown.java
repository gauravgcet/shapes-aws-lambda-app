package shapes;

public class Unknown implements Shape{

    @Override
    public double getArea() {
        return 0;
    }

    @Override
    public double getPerimeter() {
        return 0;
    }

    @Override
    public String getName() {
        return "Unknown Shape";
    }
}
