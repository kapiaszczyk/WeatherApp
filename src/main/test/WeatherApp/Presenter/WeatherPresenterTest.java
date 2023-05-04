package WeatherApp.Presenter;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class WeatherPresenterTest {

    @Test
    public void testNullGetWeather() {
        WeatherPresenter presenter = new WeatherPresenter();
        Assert.assertThrows(IllegalArgumentException.class, () -> presenter.getWeather(null));
    }
}
