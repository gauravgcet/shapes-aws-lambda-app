package lambda;

import java.util.ArrayList;
import java.util.List;

public class ShapeRequest {

    private String shapeName;
    private List<Double> sides;

    public String getShapeName() {
        return shapeName;
    }
    public void setShapeName(String shapeName) {
        this.shapeName = shapeName;
    }

    public List<Double> getSides() {
        return sides;
    }

    public void setSides(List<Double> sides) {
        this.sides = sides;
    }
}
