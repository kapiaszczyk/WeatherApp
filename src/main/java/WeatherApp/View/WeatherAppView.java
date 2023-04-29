package WeatherApp.View;

public class WeatherAppView {
    public void printWeatherData(String location,
                                 String temperature,
                                 String humidity,
                                 String pressure,
                                 String windSpeed,
                                 String windDirection,
                                 String cloudiness,
                                 String sunrise,
                                 String sunset) {

        System.out.println("Weather for " + location + ":");
        System.out.println("Temperature: " + temperature);
        System.out.println("Humidity: " + humidity);
        System.out.println("Pressure: " + pressure);
        System.out.println("Wind Speed: " + windSpeed);
        System.out.println("Wind Direction: " + windDirection);
        System.out.println("Cloudiness: " + cloudiness);
        System.out.println("Sunrise: " + sunrise);
        System.out.println("Sunset: " + sunset);
    }
}
