package WeatherApp.view;

import WeatherApp.weather.WeatherData;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class WeatherAppView {

    public void printWeatherData(WeatherData weatherData) {

        weatherData.isNull();

        System.out.printf("Weather for %s at %s local time: %s%n", weatherData.getLocation(), LocalTime.now().truncatedTo(ChronoUnit.MINUTES), weatherData.getDescription());
        System.out.printf("Temperature: %s Celsius degrees%n", weatherData.getTemperature());
        System.out.printf("Humidity: %s%%%n", weatherData.getHumidity());
        System.out.printf("Pressure: %s hPa%n", weatherData.getPressure());
        System.out.printf("Wind Speed: %s m/s%n", weatherData.getWindSpeed());
        System.out.printf("Wind Direction: %s degrees%n", weatherData.getWindDirection());
        System.out.printf("Clouds: %s%%%n", weatherData.getClouds());
        System.out.printf("Sunrise: %s local time%n", weatherData.getSunrise());
        System.out.printf("Sunset: %s local time%n", weatherData.getSunset());
    }



    public void warnUser() {
        System.out.println("You asked for it...");
    }

    public void printInsult(String insult) {
        System.out.println(insult);
    }
}
