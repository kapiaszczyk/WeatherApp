package WeatherApp;

import org.json.JSONObject;

public class WeatherData {

    private String placeName;
    private String tempK;
    private String tempC;
    private String dsc;

    public void getData(String response) {
        parseJSON(response);
    }

    private void parseJSON(String response) {
        JSONObject obj = new JSONObject(response);
        placeName = obj.getString("name");
        tempK = obj.getJSONObject("main").getNumber("temp").toString();
        tempC = covertToCel(tempK);
        dsc = obj.getJSONArray("weather").getJSONObject(0).getString("description");
    }

    public void printData() {
        System.out.println("Place: " + this.placeName);
        System.out.println("Temperature: " + this.tempC + "C");
        System.out.println("Description: " + this.dsc);
    }

    private String covertToCel(String temp) {
        double tempK = Double.parseDouble(temp);
        double tempC = (tempK - 273.15);
        return String.format("%.2f", tempC);
    }
}