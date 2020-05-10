package lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import shapes.*;

import static utils.Constant.SupportedShapes;

/**
 * Handler for requests to Lambda function.
 */
public class EntryPoint implements RequestHandler<ShapeRequest, ShapeResponse> {

    @Override
    public ShapeResponse handleRequest(final ShapeRequest shapeRequest, final Context context) {

        final ShapeResponse area = computeArea(shapeRequest);
        Utils.headers();
        return area;
    }

    private ShapeResponse computeArea(ShapeRequest shapeRequest){

        final SupportedShapes requestedShape = SupportedShapes.valueOf(shapeRequest.getShapeName());
        Shape shape = null;

        switch (requestedShape)
        {
            case SQUARE:
            case RECTANGLE:
                shape = new Square(shapeRequest.getSides().get(0),shapeRequest.getSides().get(1));
                break;
            case TRIANGLE:
                shape = new Triangle(shapeRequest.getSides().get(0),shapeRequest.getSides().get(1));
                break;
            case CIRCLE:
                shape = new Circle(shapeRequest.getSides().get(0));
                break;
            default:
                shape = new Unknown();
        }
        return new ShapeResponse(shape.area(),shape.perimeter(),shape.getName());
    }
}
