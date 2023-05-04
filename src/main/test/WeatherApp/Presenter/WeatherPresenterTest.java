package WeatherApp.Presenter;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class WeatherPresenterTest {

    @Test
    public void testNullGetWeather() {
        WeatherPresenter presenter = new WeatherPresenter();
        Assert.assertThrows(IllegalArgumentException.class, () -> presenter.getWeather(null));
    }

    @Test
    public void testEmptyGetWeather() {
        WeatherPresenter presenter = new WeatherPresenter();
        Assert.assertThrows(IllegalArgumentException.class, () -> presenter.getWeather(""));
    }

    @Test
    public void testBlankGetWeather() {
        WeatherPresenter presenter = new WeatherPresenter();
        Assert.assertThrows(IllegalArgumentException.class, () -> presenter.getWeather(" "));
    }
}
