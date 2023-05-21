package WeatherApp.exceptions;

public class InvalidApiResponseException extends Exception {
    public InvalidApiResponseException(String message) {
        super(message);
    }
}
