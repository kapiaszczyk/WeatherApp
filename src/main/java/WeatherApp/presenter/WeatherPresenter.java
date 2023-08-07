package WeatherApp.presenter;

import WeatherApp.geocoding.GeocodingData;
import WeatherApp.praise.PraiseResponseClient;
import WeatherApp.praise.PraiseData;
import WeatherApp.util.WeatherArguments;
import WeatherApp.util.WeatherDataFileWriter;
import WeatherApp.view.WeatherAppView;
import WeatherApp.weather.WeatherAPIClient;
import WeatherApp.weather.WeatherData;

import java.util.List;

public class WeatherPresenter {

    private final WeatherAppView view;
    private final WeatherData weatherData;
    private final WeatherAPIClient weatherAPI;
    private final GeocodingData geocodingData;
    private PraiseData praiseData;
    private PraiseResponseClient praiseResponseClient;
    private WeatherArguments weatherArguments;

    public WeatherPresenter() {
        view = new WeatherAppView();
        weatherData = new WeatherData();
        weatherAPI = new WeatherAPIClient();
        geocodingData = new GeocodingData();
    }


    public WeatherPresenter(WeatherArguments weatherArguments) {
        view = new WeatherAppView();
        weatherData = new WeatherData();
        weatherAPI = new WeatherAPIClient();
        geocodingData = new GeocodingData();
        praiseData = new PraiseData();
        praiseResponseClient = new PraiseResponseClient();
        this.weatherArguments = weatherArguments;
    }


    public void setupPresenter() {
        if (weatherArguments.getInsultData() != null) {
            view.warnUser();
        }
        if (weatherArguments.getLocation() != null) {
            getWeather(weatherArguments.getLocation());
        } else if (weatherArguments.getCoordinates() != null) {
            getWeather(weatherArguments.getCoordinates());
        } else {
            throw new IllegalArgumentException("No location or coordinates provided");
        }
        if (weatherArguments.getFileName() != null) {
            printToFile(weatherArguments.getFileName());
        }
    }

    public void getWeather(String location) {
        if (location == null || location.isEmpty() || location.isBlank() || !location.matches("^[a-zA-Z ]*$")) {
            throw new IllegalArgumentException("Invalid location");
        }
        geocodingData.getCoordinates(location);
        getWeatherFromAPI(geocodingData);
    }

    public void getWeather(List<String> coordinates) {
        if (coordinates != null && !coordinates.isEmpty()) {
            geocodingData.setLatitude(coordinates.get(0));
            geocodingData.setLongitude(coordinates.get(1));
        }
        getWeatherFromAPI(geocodingData);
    }

    public void getWeatherFromAPI(GeocodingData geocodingData) {
        weatherData.setupWeatherData(weatherAPI.makeCall(geocodingData.getLatitude(), geocodingData.getLongitude()));
    }

    public void printToFile(String fileName) {
        WeatherDataFileWriter weatherDataFileWriter = new WeatherDataFileWriter();
        weatherDataFileWriter.writeToFile(weatherData.getResponse(), fileName);
    }


    public void showWeather() {
        if (weatherArguments.getInsultData() != null) {
            insultUser();
        }
        try {
            view.printWeatherData(weatherData);
        }
        catch (NullPointerException e) {
            throw new NullPointerException("weatherTest data was null");
        }
    }
    public void insultUser() {
        praiseData.setWeatherConditions(weatherData.getMainDescription());
        praiseData.setName(weatherArguments.getInsultData().get(0));
        praiseData.setInsult(praiseResponseClient.makeCall(praiseData.getName(), praiseData.generateReason(), weatherArguments.getInsultData().get(1)));
        view.printInsult(praiseData.getInsult());
    }

}