package lambda;

import java.util.HashMap;
import java.util.Map;

public class Utils {

    public static Map<String, String> headers(){
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");
        headers.put("X-Custom-Header", "application/json");
        return headers;

    }
}
