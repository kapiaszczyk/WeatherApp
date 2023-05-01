package WeatherApp.Weather;

import WeatherApp.WeatherAPI.WeatherResponseParser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
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

}
