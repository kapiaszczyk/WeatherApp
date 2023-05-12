# WeatherApp

WeatherApp is a simple Java CLI app that calls OpenWeatherMap API to get information about the current weather in a given location.
The location coordinates are determined by calling the Geocoding API from OpenWeatherMap.

## Getting Started

### Set-up
To properly function, WeatherApp requires an OpenWeatherMapAPI key to be placed in the "key.txt" file, in the `...src/main/java/WeatherApp`  directory. **Remember, do not publish your API keys on GitHub!*** 

### Usage
The app can be run from the command line by typing `java -jar WeatherApp.jar` in the `.../target` directory. 

The app needs to be run with the following arguments:
- `-l` or `--location` - the location for which the weather information is requested. The location should be specified by city name (e.g. `London`)
or
- `-c` or `--coordinates` - the coordinates for which the weather information is requested. The coordinates should be specified by latitude and longitude (e.g. `51.5074, 0.1278`)

To get help, run the app with the `-h` or `--help` argument.

### Example program calls
`java -jar WeatherApp.jar -l London`
`java -jar WeatherApp.jar -c 51.5074, 0.1278`

### Output
The app will output the following information:
```
Weather for [location] at [HH:MM] local time: [weather description
Temperature: [temperature] Celsius degrees
Humidity: [humidity]%
Pressure: [pressure] hPa
Wind Speed: [wind speed] m/s
Wind Direction: [wind direction] degrees
Clouds: [0-100]%
Sunrise: [HH:MM] local time
Sunset: [HH:MM] local time
```

## Built with
- `org.apache.commons.cli` - for parsing command line arguments
- `org.json` - for parsing JSON data


### To do
- setting units for the output (currently only metric units are supported)
- exporting the output to a file (also raw JSON data)
- adding useful information when `-help` is called
- refactoring the code
- whatever interesting comes to mind :)

