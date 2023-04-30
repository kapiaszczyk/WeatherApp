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

        System.out.println("Weather for " + location + " at " + LocalTime.now() + " local time: " + description);
        System.out.println("Temperature: " + temperature + "Celsius degrees");
        System.out.println("Humidity: " + humidity + "%");
        System.out.println("Pressure: " + pressure + " hPa");
        System.out.println("Wind Speed: " + windSpeed + " m/s");
        System.out.println("Wind Direction: " + windDirection + "degrees");
        System.out.println("Clouds: " + clouds + "%");
        System.out.println("Sunrise: " + sunrise + " local time");
        System.out.println("Sunset: " + sunset + " local time");
    }
}
