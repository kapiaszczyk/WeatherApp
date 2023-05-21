<!-- Introduction -->

# WeatherApp

Simple passive-aggressive CLI app that calls OpenWeatherMap API to get information about the current weather in a given location.

<!-- ABOUT -->
## About

WeatherApp is a simple Java CLI app that calls OpenWeatherMap API to get information about the current weather in a given location. The location can be passed in two ways: by a location name or its coordinates.

## Getting Started

### Set-up
To properly function, WeatherApp requires an OpenWeatherMapAPI key to be placed in the "key.txt" file, in the `...src/main/java/WeatherApp`  directory. For extra security, the file should be placed in the `.gitignore` file. If you want to use the extra functionality, you will also need to place an InsultAPI key in the "insultKey.txt" file, in the same directory.

### Usage
The app can be run from the command line by typing `java -jar WeatherApp.jar` in the `.../target` directory.

It needs to be run with one of the following arguments:
- `-l` or `--location` - the location for which the weather information is requested. The location should be specified by city name (e.g. `London`)
  or
- `-c` or `--coordinates` - the coordinates for which the weather information is requested. The coordinates should be specified by latitude and longitude (e.g. `51.5074 0.1278`)
#### Optional arguments
- `-w` or `--writeToFile` - the app will write the weather information to a file. Specify the file name after the argument (e.g. `-w fileName`)
- `-i` or `--insultMe` - the app will insult you. Specify your name after the argument (e.g. `-i John`) and insult type (e.g. `-i John insult`) or (e.g. `-i John praise`).

To get help, run the app with the `-h` or `--help` argument.

### Example program calls
- `java -jar WeatherApp.jar -l London` 
- `java -jar WeatherApp.jar -l New York`
- `java -jar WeatherApp.jar -l Warsaw -w fileName`
- `java -jar WeatherApp.jar -c 51.5074 0.1278`
- `java -jar WeatherApp.jar -c 51.5074 0.1278 -w fileName`
- `java -jar WeatherApp.jar -c 51.5074 0.1278 -i John insult`
- `java -jar WeatherApp.jar -c 51.5074 0.1278 -i John praise`

### Output
The app will output the following information:
```
Weather for [location] at [HH:MM] local time: [weather description]
Temperature: [temperature] Celsius degrees
Humidity: [humidity]%
Pressure: [pressure] hPa
Wind Speed: [wind speed] m/s
Wind Direction: [wind direction] degrees
Clouds: [0-100]%
Sunrise: [HH:MM] local time
Sunset: [HH:MM] local time
```

<!-- STACK -->
## Built With

[![Java][Java]][Java-url]
[![IntelliJ IDEA][IntelliJ IDEA]][IntelliJ IDEA-url]
[![Maven][Maven]][Maven-url]
- `org.apache.commons.cli` - for parsing command line arguments
- `org.json` - for parsing JSON data


<!-- To-do -->
## To-do
- [ ] whatever interesting comes to mind :)

<!-- MARKDOWN LINKS & IMAGES -->
[Java]: https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white
[Java-url]: https://www.java.com/en/
[IntelliJ IDEA]: https://img.shields.io/badge/IntelliJ_IDEA-000000.svg?style=for-the-badge&logo=intellij-idea&logoColor=white
[IntelliJ IDEA-url]: https://www.jetbrains.com/idea/
[Maven]: https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=apache-maven&logoColor=white
[Maven-url]: https://maven.apache.org/