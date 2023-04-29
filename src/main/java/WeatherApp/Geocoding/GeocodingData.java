package WeatherApp.Geocoding;

public class GeocodingData {
    String latitude;
    String longitude;
    String location;

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void getCoordinates(String locationInput) {
        try {
            verifyLocation(locationInput);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        GeocodingAPIClient geocodingAPIClient = new GeocodingAPIClient();
        GeocodingResponseParser geocodingResponseParser = new GeocodingResponseParser();
        geocodingResponseParser.getData(geocodingAPIClient.makeCall(locationInput));
        latitude = geocodingResponseParser.getLat();
        longitude = geocodingResponseParser.getLon();
        location = geocodingResponseParser.getPlaceName();
    }

    private void verifyLocation(String locationInput) {
        if (locationInput == null || locationInput.isEmpty() || locationInput.trim().isEmpty()) {
            throw new IllegalArgumentException("Location cannot be empty");
        }
    }

}
