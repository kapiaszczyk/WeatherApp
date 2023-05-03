package WeatherApp.View;

import java.time.LocalTime;
import java.util.Scanner;

public class WeatherAppView {

    public String getLocation() {
        System.out.println("Enter a location: ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
    public void printWeatherData(String location,
                                 String description,
                                 String temperature,
                                 String humidity,
                                 String pressure,
                                 String windSpeed,
                                 String windDirection,
                                 String clouds,
                                 String sunrise,
                                 String sunset) {
        System.out.printf("Weather for %s at %s local time: %s%n", location, LocalTime.now(), description);
        System.out.printf("Temperature: %s Celsius degrees%n", temperature);
        System.out.printf("Humidity: %s%%%n", humidity);
        System.out.printf("Pressure: %s hPa%n", pressure);
        System.out.printf("Wind Speed: %s m/s%n", windSpeed);
        System.out.printf("Wind Direction: %s degrees%n", windDirection);
        System.out.printf("Clouds: %s%%%n", clouds);
        System.out.printf("Sunrise: %s local time%n", sunrise);
        System.out.printf("Sunset: %s local time%n", sunset);
    }
}
