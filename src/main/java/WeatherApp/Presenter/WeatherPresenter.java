package WeatherApp.Presenter;
import WeatherApp.Geocoding.GeocodingData;
import WeatherApp.Model.WeatherAPI;
import WeatherApp.Model.WeatherData;
import WeatherApp.View.WeatherAppView;

public class WeatherPresenter {

    private final WeatherAppView view;
    private final WeatherData weatherData;
    private final WeatherAPI weatherAPI;
    private final GeocodingData geocodingData;

    public WeatherPresenter() {
        view = new WeatherAppView();
        weatherData = new WeatherData();
        weatherAPI = new WeatherAPI();
        geocodingData = new GeocodingData();
    }


}