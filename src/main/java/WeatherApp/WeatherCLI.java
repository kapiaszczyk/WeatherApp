package WeatherApp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class WeatherCLI {

    public void run() {
        // getWeather();
        getWeather(getParameters());
    }

    private void getWeather() {
        WeatherData weatherData = new WeatherData();
        WeatherAPI weatherAPI = new WeatherAPI();
        List<String> parameters = Arrays.asList("19.0", "58.3");
        weatherData.getData((weatherAPI.makeCall(parameters.get(0), parameters.get(1))));
        weatherData.printData();
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

}