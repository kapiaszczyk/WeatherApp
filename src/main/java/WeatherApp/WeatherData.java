package WeatherApp;

import org.json.JSONObject;

public class WeatherData {

    private String placeName;
    private String tempK;
    private String tempC;
    private String dsc;

    public void get() {
        WeatherAPI api = new WeatherAPI();
        parseJSON(api.makeCall("50.28", "19.10"));
        printData(placeName, tempK, tempC, dsc);
    }

    private void parseJSON(String response) {
        JSONObject obj = new JSONObject(response);
        placeName = obj.getString("name");
        tempK = obj.getJSONObject("main").getNumber("temp").toString();
        tempC = covertToCel(tempK);
        dsc = obj.getJSONArray("weather").getJSONObject(0).getString("description");
    }

    private void printData(String placeName, String tempF, String tempC, String dsc) {
        System.out.println("Place: " + placeName);
        System.out.println("Temperature: " + tempC + "C");
        System.out.println("Description: " + dsc);
    }

    private String covertToCel(String temp) {
        double tempK = Double.parseDouble(temp);
        double tempC = (tempK - 273.15);
        return String.format("%.2f", tempC);
    }
}