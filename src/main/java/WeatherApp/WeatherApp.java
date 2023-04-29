package WeatherApp;

import WeatherApp.Presenter.WeatherPresenter;
public class WeatherApp {
    public static void main (String[] args) {
        WeatherPresenter presenter = new WeatherPresenter();
        presenter.getWeather();
        presenter.showWeather();
    }
}