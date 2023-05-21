package WeatherApp;

import WeatherApp.presenter.WeatherPresenter;
import WeatherApp.util.ArgumentParser;

public class WeatherApp {
    public static void main (String[] args) {

        ArgumentParser parser = new ArgumentParser();
        WeatherPresenter presenter = new WeatherPresenter();
        presenter.setupPresenter(parser.parse(args));
        presenter.showWeather();
    }
}