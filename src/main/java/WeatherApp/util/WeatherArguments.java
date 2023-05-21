package WeatherApp.util;

import java.util.List;

public class WeatherArguments {
    private String location;
    private List<String> coordinates;
    private String units;

    private String fileName;

    private List<String> insultData;

    public WeatherArguments(String location, List<String> coordinates, String units, String fileName,  List<String> insultData) {
        this.location = location;
        this.coordinates = coordinates;
        this.units = units;
        this.fileName = fileName;
        this.insultData = insultData;
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

    public void setWriteToFile(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }

    public List<String> getInsultData() {
        return insultData;
    }

    public void setInsultData(List<String> insultData) {
        this.insultData = insultData;
    }
}
