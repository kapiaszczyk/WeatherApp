package WeatherApp.praise;

import org.json.JSONObject;

public class PraiseResponseParser {


    public String parseJSON(String response) {
        JSONObject obj = new JSONObject(response);
        String parsedResponse =  obj.getString("text");

        return parsedResponse;
    }
}
