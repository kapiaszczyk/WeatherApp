package WeatherApp.weather;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class WeatherAPIClient {
    public String makeCall(String lat, String lon) {

        String url = "https://api.openweathermap.org/data/2.5/weather?" + "&lat=" + lat + "&lon=" + lon + "&appid=" + getKey();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
        HttpResponse<String> response = null;

        try {
            response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

        if (response != null) {
            return (response.body());
        }
        else throw new RuntimeException();

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
}
