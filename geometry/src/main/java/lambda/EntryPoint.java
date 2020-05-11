package lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import exception.ValidationException;
import shapes.*;

import static utils.Constant.SupportedShapes;

/**
 * Handler for requests to Lambda function.
 */
public class EntryPoint implements RequestHandler<ShapeRequest, GatewayResponse> {

    @Override
    public GatewayResponse handleRequest(final ShapeRequest shapeRequest, final Context context) {

        Shape shape;
        try {
            shape = computeArea(shapeRequest);
        } catch (ValidationException e) {
            return new GatewayResponse(null,Utils.headers(),400,e.getMessage());
        }
        return new GatewayResponse(shape,Utils.headers(),200,"success");
    }

    private Shape computeArea(ShapeRequest shapeRequest) throws ValidationException {

        shapeRequest.validate();

        final SupportedShapes requestedShape = SupportedShapes.valueOf(shapeRequest.getShapeName());
        Shape shape;
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
        return shape;
    }
}
