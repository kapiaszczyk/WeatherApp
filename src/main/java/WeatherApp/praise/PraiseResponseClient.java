package WeatherApp.praise;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class PraiseResponseClient {

    public String makeCall(String name, String reason, String type) {

        if (!type.contains("praise") && !type.contains("insult")) {
            throw new IllegalArgumentException("Invalid name or type");
        }


        String url = "https://api.humorapi.com/" + type.toLowerCase().trim() + "?" + "name=" + name + "&reason=" + reason + "&api-key=" + getKey();

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
            BufferedReader br = new BufferedReader(new FileReader("src/main/java/WeatherApp/insult_key.txt"));
            return br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
