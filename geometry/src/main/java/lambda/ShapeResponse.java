package lambda;

public class ShapeResponse {

    private final double area, perimeter;
    private final String shapeName;

    public ShapeResponse(double area, double perimeter, String shapeName) {
        this.area = area;
        this.perimeter = perimeter;
        this.shapeName = shapeName;
    }
    public double getPerimeter() {
        return perimeter;
    }
    public double getArea() {
        return area;
    }

    public String getShapeName() {
        return shapeName;
    }
}
