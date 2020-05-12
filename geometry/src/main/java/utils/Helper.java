package utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Helper {

    public static Map<String, String> headers(){
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");
        headers.put("X-Custom-Header", "application/json");
        return headers;

    }

    public static List<Double> parseDoubleList(List<String> sides){
        List<Double> doubles = new ArrayList<>();
        for(String side: sides){
            doubles.add(Double.parseDouble(side));
        }
        return doubles;
    }
}
