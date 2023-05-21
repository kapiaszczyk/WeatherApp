package WeatherApp.presenterTest;

import WeatherApp.presenter.WeatherPresenter;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class WeatherPresenterTest {

    @Test
    public void testNullGetWeather() {
        WeatherPresenter presenter = new WeatherPresenter();
        assertThrows(IllegalArgumentException.class, () -> presenter.getWeather((String) null));
    }

    @Test
    public void testEmptyGetWeather() {
        WeatherPresenter presenter = new WeatherPresenter();
        assertThrows(IllegalArgumentException.class, () -> presenter.getWeather(""));
    }

    @Test
    public void testBlankGetWeather() {
        WeatherPresenter presenter = new WeatherPresenter();
        assertThrows(IllegalArgumentException.class, () -> presenter.getWeather(" "));
    }

    @Test
    public void testNonWordGetWeather() {
        WeatherPresenter presenter = new WeatherPresenter();
        assertThrows(IllegalArgumentException.class, () -> presenter.getWeather("123"));
    }

    @Test
    public void testNullShowWeather() {
        WeatherPresenter presenter = new WeatherPresenter();
        assertThrows(NullPointerException.class, () -> presenter.showWeather());
    }
}
