package WeatherApp.Exceptions;

public class EmptyAPIResponse extends Exception {
    public EmptyAPIResponse(String message) {
        super(message);
    }
}
