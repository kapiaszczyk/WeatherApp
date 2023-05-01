import WeatherApp.Presenter.WeatherPresenter;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class WeatherAppViewTest {

    @Test
    public void testNullLocationGetWeather() {
        WeatherPresenter presenter = new WeatherPresenter();
        Assert.assertThrows(IllegalArgumentException.class, () -> presenter.getWeather(null));
    }

    @Test
    public void testEmptyLocationGetWeather() {
        WeatherPresenter presenter = new WeatherPresenter();
        Assert.assertThrows(IllegalArgumentException.class, () -> presenter.getWeather(""));
    }

    @Test
    public void testBlankLocationGetWeather() {
        WeatherPresenter presenter = new WeatherPresenter();
        Assert.assertThrows(IllegalArgumentException.class, () -> presenter.getWeather(" "));
    }

    @Test
    public void testNonWordLocationGetWeather() {
        WeatherPresenter presenter = new WeatherPresenter();
        Assert.assertThrows(IllegalArgumentException.class, () -> presenter.getWeather("123"));
    }

}
