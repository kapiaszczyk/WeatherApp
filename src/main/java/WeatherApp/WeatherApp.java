package WeatherApp;

import WeatherApp.Presenter.WeatherPresenter;
import WeatherApp.Util.ArgumentParser;

public class WeatherApp {
    public static void main (String[] args) {

        ArgumentParser parser = new ArgumentParser();
        WeatherPresenter presenter = new WeatherPresenter();
        presenter.getWeather(parser.parse(args));
        presenter.showWeather();
    }
}