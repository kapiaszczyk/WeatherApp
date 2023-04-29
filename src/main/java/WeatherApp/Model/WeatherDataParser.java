package WeatherApp.Model;

import org.json.JSONObject;

public class WeatherDataParser {

    private String location;
    private String temperature;
    private String humidity;
    private String windSpeed;
    private String windDirection;
    private String pressure;
    private String sunrise;
    private String sunset;
    private String clouds;
    private String description;

    public void getData(String response) {
        parseJSON(response);
    }

    private void parseJSON(String response) {
        JSONObject obj = new JSONObject(response);
        location = obj.getString("name");
        temperature = covertToCel(obj.getJSONObject("main").getNumber("temp").toString());
        humidity = obj.getJSONObject("main").getNumber("humidity").toString();
        windSpeed = obj.getJSONObject("wind").getNumber("speed").toString();
        windDirection = obj.getJSONObject("wind").getNumber("deg").toString();
        pressure = obj.getJSONObject("main").getNumber("pressure").toString();
        sunrise = obj.getJSONObject("sys").getNumber("sunrise").toString();
        sunset = obj.getJSONObject("sys").getNumber("sunset").toString();
        clouds = obj.getJSONObject("clouds").getNumber("all").toString();
        description = obj.getJSONArray("weather").getJSONObject(0).getString("description");
    }

    private String covertToCel(String temp) {
        double tempK = Double.parseDouble(temp);
        double tempC = (tempK - 273.15);
        return String.format("%.2f", tempC);
    }
}