package WeatherApp.geocoding;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;

public class GeocodingResponseParser {

    String lat;
    String lon;
    String placeName;

    public String getLat() {
        return lat;
    }

    public String getLon() {
        return lon;
    }

    public String getPlaceName() {
        return placeName;
    }


    public void getData(String response) {
        if (response == null || response.isEmpty() || response.trim().isEmpty()) {
            throw new IllegalArgumentException("geocoding API response is empty");
        }
        parseJSON(response);
    }

    private void parseJSON(String response) {
        if (response.isEmpty() || response == null || response.trim().isEmpty()) {
            throw new IllegalArgumentException("geocoding API response is empty");
        }
        try {
            JSONArray jsonArray = new JSONArray(response);
            JSONObject obj = jsonArray.getJSONObject(0);
            lat = (obj.getBigDecimal("lat")).toString();
            lon = (obj.getBigDecimal("lon")).toString();
            placeName = obj.getString("name");
        } catch (Exception e) {
            throw new IllegalArgumentException("geocoding API response is invalid");
        }
    }

    private void printResponse(String response) {
        try {
            FileWriter fileWriter = new FileWriter("src/main/test/GeocodingAPITestData.JSON");
            fileWriter.write(response);
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
