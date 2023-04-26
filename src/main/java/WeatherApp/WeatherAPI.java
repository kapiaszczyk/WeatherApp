package WeatherApp;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpClient;

public class WeatherAPI {
    public String makeCall(String lat, String lon) {

        String url = "https://api.openweathermap.org/data/2.5/weather?" + "&lat=" + lat + "&lon=" + lon + "&appid=KEY";

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
}