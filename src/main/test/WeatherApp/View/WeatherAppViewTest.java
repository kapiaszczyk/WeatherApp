package WeatherApp.View;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class WeatherAppViewTest {

    @Test
    public void testAllNullPrintWeatherData() {
        WeatherAppView view = new WeatherAppView();
        Assert.assertThrows(NullPointerException.class, () -> view.printWeatherData(null, null, null, null, null, null, null, null, null, null));
    }

    @Test
    public void testNullLocationPrintWeatherData() {
        WeatherAppView view = new WeatherAppView();
        Assert.assertThrows(NullPointerException.class, () -> view.printWeatherData(null, "description", "temperature", "humidity", "pressure", "windSpeed", "windDirection", "clouds", "sunrise", "sunset"));
    }

}
