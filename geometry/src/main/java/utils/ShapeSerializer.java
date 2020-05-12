package utils;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import shapes.*;

import java.lang.reflect.Type;

public class ShapeSerializer implements JsonSerializer<Shape> {

    private static final String CLASSNAME = "CLASSNAME";
    private static final String INSTANCE  = "INSTANCE";
    @Override
    public JsonElement serialize(Shape shape, Type type, JsonSerializationContext jsonSerializationContext) {
        JsonObject root = new JsonObject();
        if(shape instanceof Square) {
            root.add("area", jsonSerializationContext.serialize(((Square)shape).getArea(), Double.class));
            root.add("perimeter", jsonSerializationContext.serialize(((Square)shape).getPerimeter(), Double.class));
            root.add("shapeName", jsonSerializationContext.serialize(((Square)shape).getName(), String.class));
        }
        if(shape instanceof Circle){
            root.add("area", jsonSerializationContext.serialize(((Circle)shape).getArea(), Double.class));
            root.add("perimeter", jsonSerializationContext.serialize(((Circle)shape).getPerimeter(), Double.class));
            root.add("shapeName", jsonSerializationContext.serialize(((Circle)shape).getName(), String.class));
        }
        if(shape instanceof Rectangle){
            root.add("area", jsonSerializationContext.serialize(((Rectangle)shape).getArea(), Double.class));
            root.add("perimeter", jsonSerializationContext.serialize(((Rectangle)shape).getPerimeter(), Double.class));
            root.add("shapeName", jsonSerializationContext.serialize(((Rectangle)shape).getName(), String.class));
        }
        if(shape instanceof Triangle){
            root.add("area", jsonSerializationContext.serialize(((Triangle)shape).getArea(), Double.class));
            root.add("perimeter", jsonSerializationContext.serialize(((Triangle)shape).getPerimeter(), Double.class));
            root.add("shapeName", jsonSerializationContext.serialize(((Triangle)shape).getName(), String.class));
        }
        return root;

    }
}
