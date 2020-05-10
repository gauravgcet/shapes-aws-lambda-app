package shapes;

public class Unknown implements Shape{

    @Override
    public double area() {
        return 0;
    }

    @Override
    public double perimeter() {
        return 0;
    }

    @Override
    public String getName() {
        return "Unknown Shape";
    }
}
