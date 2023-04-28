package WeatherApp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class WeatherCLI {

    public void run() {
        getWeather(getParameters());
    }

    private void getWeather(List<String> parameters) {
        WeatherData weatherData = new WeatherData();
        WeatherAPI weatherAPI = new WeatherAPI();
        weatherData.getData((weatherAPI.makeCall(parameters.get(0), parameters.get(1))));
        weatherData.printData();
    }

    private List<String> getParameters(){
        List<String> parameters = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Set latitude");
        parameters.add(scanner.nextLine());
        System.out.println("Set longitude");
        parameters.add(scanner.nextLine());
        return parameters;
    }

    private String getCity() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Set city");
        String cityInput = scanner.nextLine();
        if (cityInput == null || cityInput.isEmpty() || cityInput.trim().isEmpty()) {
            System.out.println("City cannot be empty");
            getCity();
        }
        return cityInput;
    }

    private String getCity(String city) {
        if ( city.isBlank() || city == null) {
            throw new IllegalArgumentException("City cannot be empty");
        }
        return city;
    }

}