package WeatherApp.geocodingTest;

import WeatherApp.geocoding.GeocodingResponseParser;
import org.junit.jupiter.api.Test;

import java.io.FileReader;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class GeocodingResponseParserTest {

    String getTestData() {
        try {
            FileReader fileReader = new FileReader("src/main/test/GeocodingAPITestData.JSON");
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
    void getData() {
        GeocodingResponseParser parser = new GeocodingResponseParser();
        parser.getData(getTestData());
        assertEquals("50.2598987", parser.getLat());
        assertEquals("19.0215852", parser.getLon());
        assertEquals("Katowice", parser.getPlaceName());
    }

    @Test
    void getDataEmpty() {
        GeocodingResponseParser parser = new GeocodingResponseParser();
        assertThrows(IllegalArgumentException.class, () -> {
            parser.getData("");
        });
    }

    @Test
    void getDataNull() {
        GeocodingResponseParser parser = new GeocodingResponseParser();
        assertThrows(IllegalArgumentException.class, () -> {
            parser.getData(null);
        });
    }

    @Test
    void getDataBlank() {
        GeocodingResponseParser parser = new GeocodingResponseParser();
        assertThrows(IllegalArgumentException.class, () -> {
            parser.getData(" ");
        });
    }

    @Test
    void getDataInvalid() {
        GeocodingResponseParser parser = new GeocodingResponseParser();
        assertThrows(IllegalArgumentException.class, () -> {
            parser.getData("invalid");
        });
    }

    @Test
    void getDataInvalidJSON() {
        GeocodingResponseParser parser = new GeocodingResponseParser();
        assertThrows(IllegalArgumentException.class, () -> {
            parser.getData("{\"invalid\": \"json\"}");
        });
    }
}