package WeatherApp.geocodingTest;

import WeatherApp.geocoding.GeocodingData;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GeocodingDataTest {

    @Test
    public void testGetCoordinates() {
        GeocodingData geocodingData = new GeocodingData();
        geocodingData.getCoordinates("New York");
        assertEquals("40.7127281", geocodingData.getLatitude());
        assertEquals("-74.0060152", geocodingData.getLongitude());
        assertEquals("New York County", geocodingData.getLocation());
    }

}
