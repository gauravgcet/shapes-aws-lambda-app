package lambda;

import exception.ValidationException;
import utils.Constant;

import java.util.ArrayList;
import java.util.Arrays;
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
