package WeatherApp.exceptions;

public class EmptyAPIResponse extends Exception {
    public EmptyAPIResponse(String message) {
        super(message);
    }
}
