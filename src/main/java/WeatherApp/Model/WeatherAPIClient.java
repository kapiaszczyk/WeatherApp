package WeatherApp.Model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpClient;

public class WeatherAPIClient {
    public String makeCall(String lat, String lon) {

        String url = "https://api.openweathermap.org/data/2.5/weather?" + "&lat=" + lat + "&lon=" + lon + "&appid=" + getKey();

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
}
