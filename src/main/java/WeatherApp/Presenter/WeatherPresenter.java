package WeatherApp.Presenter;
import WeatherApp.Geocoding.GeocodingData;
import WeatherApp.WeatherAPI.WeatherAPIClient;
import WeatherApp.WeatherAPI.WeatherData;
import WeatherApp.View.WeatherAppView;

public class WeatherPresenter {

    private final WeatherAppView view;
    private final WeatherData weatherData;
    private final WeatherAPIClient weatherAPI;
    private final GeocodingData geocodingData;

    public WeatherPresenter() {
        view = new WeatherAppView();
        weatherData = new WeatherData();
        weatherAPI = new WeatherAPIClient();
        geocodingData = new GeocodingData();
    }

    public void getWeather() {
        String location = view.getLocation();
        if (location == null || location.isEmpty() || location.isBlank() || !location.matches("^[a-zA-Z ]*$")) {
            throw new IllegalArgumentException("Location cannot be null, empty, or blank");
        }
        geocodingData.getCoordinates(location);
        weatherData.getWeatherData(weatherAPI.makeCall(geocodingData.getLatitude(), geocodingData.getLongitude()));
    }

    public void getWeather(String location) {
        if (location == null || location.isEmpty() || location.isBlank() || !location.matches("^[a-zA-Z ]*$")) {
            throw new IllegalArgumentException("Location cannot be null, empty, or blank");
        }
        geocodingData.getCoordinates(location);
        weatherData.getWeatherData(weatherAPI.makeCall(geocodingData.getLatitude(), geocodingData.getLongitude()));
    }


    public void showWeather() {
        view.printWeatherData(
                weatherData.getLocation(),
                weatherData.getDescription(),
                weatherData.getTemperature(),
                weatherData.getHumidity(),
                weatherData.getPressure(),
                weatherData.getWindSpeed(),
                weatherData.getWindDirection(),
                weatherData.getClouds(),
                weatherData.getSunrise(),
                weatherData.getSunset()
        );
    }

}