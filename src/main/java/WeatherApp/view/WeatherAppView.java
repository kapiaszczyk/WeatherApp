package WeatherApp.view;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
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

        if (location == null || description == null || temperature == null || humidity == null || pressure == null || windSpeed == null || windDirection == null || clouds == null || sunrise == null || sunset == null) {
            throw new NullPointerException("Some weather data was null");
        }

        System.out.printf("Weather for %s at %s local time: %s%n", location, LocalTime.now().truncatedTo(ChronoUnit.MINUTES), description);
        System.out.printf("Temperature: %s Celsius degrees%n", temperature);
        System.out.printf("Humidity: %s%%%n", humidity);
        System.out.printf("Pressure: %s hPa%n", pressure);
        System.out.printf("Wind Speed: %s m/s%n", windSpeed);
        System.out.printf("Wind Direction: %s degrees%n", windDirection);
        System.out.printf("Clouds: %s%%%n", clouds);
        System.out.printf("Sunrise: %s local time%n", sunrise);
        System.out.printf("Sunset: %s local time%n", sunset);
    }

    public void warnUser() {
        System.out.println("You asked for it...");
    }

    public void printInsult(String insult) {
        System.out.println(insult);
    }
}
