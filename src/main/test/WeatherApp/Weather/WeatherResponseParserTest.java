package WeatherApp.Weather;
import WeatherApp.WeatherAPI.WeatherData;
import WeatherApp.WeatherAPI.WeatherResponseParser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.io.FileReader;
import java.io.IOException;

public class WeatherResponseParserTest {

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
        WeatherResponseParser weatherResponseParser = new WeatherResponseParser();
        WeatherData weatherData = new WeatherData();
        weatherResponseParser.getData(getTestData());
        weatherResponseParser.passToWeatherData(weatherData);
        Assertions.assertEquals("scattered clouds", weatherData.getDescription());
    }

    @Test
    public void getEmptyDataTest() {
        WeatherResponseParser weatherResponseParser = new WeatherResponseParser();
        Assertions.assertThrows(IllegalArgumentException.class, () -> weatherResponseParser.getData(""));
    }

    @Test
    public void getNullDataTest() {
        WeatherResponseParser weatherResponseParser = new WeatherResponseParser();
        Assertions.assertThrows(IllegalArgumentException.class, () -> weatherResponseParser.getData(null));
    }

    @Test
    public void getBlankDataTest() {
        WeatherResponseParser weatherResponseParser = new WeatherResponseParser();
        Assertions.assertThrows(IllegalArgumentException.class, () -> weatherResponseParser.getData(" "));
    }

}
