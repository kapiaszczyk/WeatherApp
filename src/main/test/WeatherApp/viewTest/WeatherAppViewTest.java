package WeatherApp.viewTest;

import WeatherApp.view.WeatherAppView;
import WeatherApp.weather.WeatherData;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class WeatherAppViewTest {

    @Test
    public void testAllNullPrintWeatherData() {
        WeatherAppView view = new WeatherAppView();
        assertThrows(NullPointerException.class, () -> view.printWeatherData(new WeatherData()));
    }

    @Test
    public void testNullLocationPrintWeatherData() {
        WeatherAppView view = new WeatherAppView();
        assertThrows(NullPointerException.class, () -> view.printWeatherData(prepareExampleWeatherData()));
    }

    public WeatherData prepareExampleWeatherData() {
        WeatherData weatherData = new WeatherData();

        weatherData.setLocation(null);
        weatherData.setTemperature("20.5");
        weatherData.setHumidity("89");
        weatherData.setWindSpeed("25");
        weatherData.setWindDirection("16");
        weatherData.setPressure("1001");
        weatherData.setClouds("75");
        weatherData.setDescription("Example description");

        return weatherData;
    }

}
