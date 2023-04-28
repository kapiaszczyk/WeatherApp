package WeatherApp;

import org.json.JSONObject;

public class GeocodingResponseParser {

    String lat;

    String lon;
    String placeName;
    String country;

    public String getLat() {
        return lat;
    }

    public String getLon() {
        return lon;
    }

    public String getPlaceName() {
        return placeName;
    }

    public String getCountry() {
        return country;
    }


    public void getData(String response) {
        parseJSON(response);
    }

    private void parseJSON(String response) {
        JSONObject obj = new JSONObject(response);
        lat = obj.getString("lat");
        lon = obj.getString("lon");
        placeName = obj.getString("name");
        country = obj.getString("country");
    }

}
