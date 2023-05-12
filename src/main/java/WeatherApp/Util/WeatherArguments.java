package WeatherApp.Util;

import java.util.List;

public class WeatherArguments {
    private String location;
    private List<String> coordinates;
    private String units;

    public WeatherArguments(String location, List<String> coordinates, String units) {
        this.location = location;
        this.coordinates = coordinates;
        this.units = units;
    }

    public WeatherArguments() {
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<String> getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(List<String> coordinates) {
        this.coordinates = coordinates;
    }

    public String getUnits() {
        return units;
    }

    public void setUnits(String units) {
        this.units = units;
    }
}
