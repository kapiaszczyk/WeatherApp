package WeatherApp.Geocoding;

import org.json.JSONArray;
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
        JSONArray jsonArray = new JSONArray(response);
        JSONObject obj = jsonArray.getJSONObject(0);
        lat = (obj.getBigDecimal("lat")).toString();
        lon = (obj.getBigDecimal("lon")).toString();
        placeName = obj.getString("name");
    }

}
