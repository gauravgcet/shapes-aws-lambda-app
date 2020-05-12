package shapes;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import utils.Constant;

public class Square implements Shape {

    @Expose(serialize = false)
    private final double width,length;

    public Square(double width, double length) {
        this.width = width;
        this.length = length;
    }

    @Override
    public double getArea() {
        return length * width;
    }

    @Override
    public double getPerimeter() {
        return 2 * (width + length);
    }

    @Override
    public String getName() {
        return Constant.SupportedShapes.SQUARE.name();
    }

}
