package lambda;

import exception.ValidationException;
import utils.Constant;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ShapeRequest {

    private final String shapeName;
    private final List<Double> sides;

    public ShapeRequest(String shapeName, List<Double> sides) {
        this.shapeName = shapeName;
        this.sides = sides;
    }

    public String getShapeName() {
        return shapeName;
    }

    public List<Double> getSides() {
        return sides;
    }

    public void validate() throws ValidationException {
        if(shapeName==null || shapeName.trim().equals("")){
            throw new ValidationException("shape name can be empty");
        }else {
            try
            {
                Constant.SupportedShapes.valueOf(shapeName);
            }catch (Exception e) {
                throw new ValidationException("shape name not supported");
            }
        }
    }
}
