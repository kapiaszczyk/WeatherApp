package WeatherApp.Presenter;
import WeatherApp.Geocoding.GeocodingData;
import WeatherApp.Util.WeatherArguments;
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

    public void getWeather(WeatherArguments weatherArguments) {
        if (weatherArguments.getLocation() != null) {
            geocodingData.getCoordinates(weatherArguments.getLocation());
        } else if (weatherArguments.getCoordinates() != null) {
            geocodingData.setLatitude(weatherArguments.getCoordinates().get(0));
            geocodingData.setLongitude(weatherArguments.getCoordinates().get(1));
        } else {
            geocodingData.getCoordinates(view.getLocation());
        }
        weatherData.getWeatherData(weatherAPI.makeCall(geocodingData.getLatitude(), geocodingData.getLongitude()));
    }


    public void showWeather() {
        try {
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
        catch (NullPointerException e) {
            throw new NullPointerException("Weather data was null");
        }
    }

}