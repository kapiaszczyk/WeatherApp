package WeatherApp.Exceptions;

public class InvalidApiResponseException extends Exception {
    public InvalidApiResponseException(String message) {
        super(message);
    }
}
