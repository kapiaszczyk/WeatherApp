package WeatherApp.Geocoding;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class GeocodingAPIClient {

    public String makeCall(String location) {

        location = encodeLocation(location);

        String url = "http://api.openweathermap.org/geo/1.0/direct?" + "q=" + location + "&limit=1" + "&appid=" + getKey();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
        HttpResponse<String> response = null;

        try {
            response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return (response.body());

    }

    private String getKey() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("src/main/java/WeatherApp/key.txt"));
            return br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private String encodeLocation(String location) {
        String replaced = location;
        if (location.contains(" ")) {
            replaced = location.replace(" ", "%20");
        }
        return replaced;
    }

}
