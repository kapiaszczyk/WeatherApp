package WeatherApp.praise;

import java.util.*;

public class PraiseData {

    private PraiseResponseParser praiseResponseParser = new PraiseResponseParser();

    private String insult;
    private String name;
    private String weatherConditions;
    private String defaultReason = "you called the OpenWeatherAPI for no good reason";
    private Map<String, String> weatherRelatedReasons = new HashMap<>();

    public PraiseData() {
        setupMap();
    }

    public String getInsult() {
        return insult;
    }

    public void setInsult(String insult) {
        this.insult = praiseResponseParser.parseJSON(insult);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWeatherConditions(String weatherConditions) {
        this.weatherConditions = weatherConditions;
    }

    public String getWeatherConditions() {
        return weatherConditions;
    }

    public void setupMap() {
        weatherRelatedReasons.put("Drizzle", "I hope the weather will get worse");
        weatherRelatedReasons.put("Thunderstorm", "I hope you will try to fly a kite during a thunderstorm");
        weatherRelatedReasons.put("Rain", "I hope you will get soaked in the rain");
        weatherRelatedReasons.put("Snow", "I hope your car will get stuck in the snow");
        weatherRelatedReasons.put("Clouds", "I hope it will start raining when you go outside");
        weatherRelatedReasons.put("Clear", "you better go do something productive");
        weatherRelatedReasons.put("Mist", "I hope you will get lost in the mist");

        // Replace the spaces with + signs because the API call will fail otherwise
        for (Map.Entry<String, String> entry : weatherRelatedReasons.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            String updatedValue = value.replace(" ", "+");
            weatherRelatedReasons.put(key, updatedValue);
        }
    }

    public String generateReason() {
        if (weatherRelatedReasons.containsKey(weatherConditions)) {
            return weatherRelatedReasons.get(weatherConditions);
        } else {
            return defaultReason;
        }
    }

}
