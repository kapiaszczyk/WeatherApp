package WeatherApp.Weather;

import WeatherApp.WeatherAPI.WeatherData;
import org.junit.jupiter.api.Test;
import java.io.FileReader;
import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class WeatherDataTest {

    public String getTestData() {
        try {
            FileReader fileReader = new FileReader("src/main/test/WeatherAPITestData.JSON");
            int i;
            StringBuilder stringBuilder = new StringBuilder();
            while ((i = fileReader.read()) != -1) {
                stringBuilder.append((char) i);
            }
            return stringBuilder.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Test
    public void getDataTest() {
        WeatherData weatherData = new WeatherData();
        weatherData.getWeatherData(getTestData());
        assertEquals("scattered clouds", weatherData.getDescription());
    }
}
