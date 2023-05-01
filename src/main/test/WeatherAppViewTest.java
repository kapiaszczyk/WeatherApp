import WeatherApp.Presenter.WeatherPresenter;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class WeatherAppViewTest {

    WeatherPresenter presenter;

    @BeforeEach
    public void setUp() {
        presenter = new WeatherPresenter();
    }

    @Test
    public void testNullLocationGetWeather() {
        Assert.assertThrows(IllegalArgumentException.class, () -> presenter.getWeather(null));
    }

    @Test
    public void testEmptyLocationGetWeather() {
        Assert.assertThrows(IllegalArgumentException.class, () -> presenter.getWeather(""));
    }

    @Test
    public void testBlankLocationGetWeather() {
        Assert.assertThrows(IllegalArgumentException.class, () -> presenter.getWeather(" "));
    }

    @Test
    public void testNonWordLocationGetWeather() {
        Assert.assertThrows(IllegalArgumentException.class, () -> presenter.getWeather("123"));
    }

}
