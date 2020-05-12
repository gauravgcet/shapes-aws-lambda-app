package lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import exception.ValidationException;
import shapes.*;
import utils.Helper;
import utils.ShapeSerializer;

import java.util.List;

import static utils.Constant.SupportedShapes;

/**
 * Handler for requests to Lambda function.
 */
public class EntryPoint implements RequestHandler<GatewayRequest, GatewayResponse> {

    @Override
    public GatewayResponse handleRequest(final GatewayRequest gatewayRequest, final Context context) {

        Gson gson = new GsonBuilder().registerTypeAdapter(Shape.class,new ShapeSerializer()).create();

        String shapeName = gatewayRequest.getPathParameters().get("shapeName");
        List<String> sides = gatewayRequest.getMultiValueQueryStringParameters().get("side");

        ShapeRequest shapeRequest = new ShapeRequest(shapeName, Helper.parseDoubleList(sides));

        Shape shape;
        try {
            shape = computeArea(shapeRequest);
        } catch (ValidationException e) {
            return new GatewayResponse(Helper.headers(),500,e.getMessage(),false);
        }
        return new GatewayResponse(Helper.headers(),200,gson.toJson(shape,Shape.class),false);
    }

    private Shape computeArea(ShapeRequest shapeRequest) throws ValidationException {

        shapeRequest.validate();
        final SupportedShapes requestedShape = SupportedShapes.valueOf(shapeRequest.getShapeName());
        Shape shape;
        switch (requestedShape)
        {
            case SQUARE:
                shape = new Square(shapeRequest.getSides().get(0),shapeRequest.getSides().get(1));
                break;
            case RECTANGLE:
                shape = new Rectangle(shapeRequest.getSides().get(0),shapeRequest.getSides().get(1));
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
