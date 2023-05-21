package WeatherApp.weather;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class WeatherData {

    private String location;
    private String temperature;
    private String humidity;
    private String windSpeed;
    private String windDirection;
    private String pressure;
    private String sunrise;
    private String sunset;
    private String clouds;
    private String description;
    private String mainDescription;

    private String response;

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public String getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(String windSpeed) {
        this.windSpeed = windSpeed;
    }

    public String getWindDirection() {
        return windDirection;
    }

    public void setWindDirection(String windDirection) {
        this.windDirection = windDirection;
    }

    public String getPressure() {
        return pressure;
    }

    public void setPressure(String pressure) {
        this.pressure = pressure;
    }

    public String getSunrise() {
        return sunrise;
    }

    public void setSunrise(String sunrise) {
        this.sunrise = convertTime(Long.parseLong(sunrise));
    }

    public String getSunset() {
        return sunset;
    }

    public void setSunset(String sunset) {
        this.sunset = convertTime(Long.parseLong(sunset));
    }

    public String getClouds() {
        return clouds;
    }

    public void setClouds(String clouds) {
        this.clouds = clouds;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMainDescription() {
        return mainDescription;
    }

    public void setMainDescription(String mainDescription) {
        this.mainDescription = mainDescription;
    }

    public String getResponse() {
        return response;
    }

    public void setupWeatherData(String response) {
        this.response = response;
        getWeatherData();
    }

    public void getWeatherData() {
        WeatherResponseParser weatherDataParser = new WeatherResponseParser();
        weatherDataParser.getData(this.response);
        weatherDataParser.passToWeatherData(this);
    }

    private String convertTime(long unixSeconds) {
        if (unixSeconds == 0) throw new IllegalArgumentException("Unix time cannot be 0");
        java.util.Date date = new java.util.Date(unixSeconds*1000L);
        LocalTime convertedTime = date.toInstant().atZone(java.time.ZoneId.systemDefault()).toLocalTime().truncatedTo(ChronoUnit.MINUTES);
        return convertedTime.toString();
    }

}
