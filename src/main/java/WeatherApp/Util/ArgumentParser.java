package WeatherApp.Util;

import org.apache.commons.cli.*;

import java.util.Arrays;
import java.util.List;

public class ArgumentParser {

    private final Options options;
    private final CommandLineParser parser;
    private final HelpFormatter formatter;

    public ArgumentParser() {
        options = new Options();
        parser = new DefaultParser();
        formatter = new HelpFormatter();

        options.addOption("l", "location", true, "Location to get weather data for");
        options.addOption("c", "coordinates", true, "Coordinates to get weather data for [Latitude,Longitude]");
        options.addOption("u", "units", true, "Units to display weather data in [C or F]");
        options.addOption("h", "help", false, "Display help");
    }

    public WeatherArguments parse(String[] args) {
        WeatherArguments weatherArguments = new WeatherArguments();
        try {
            CommandLine cmd = parser.parse(options, args);
            if (cmd.hasOption("h")) {
                formatter.printHelp("WeatherApp", options);
                System.exit(0);
            }
            if (cmd.hasOption("l")) {
                weatherArguments.setLocation(cmd.getOptionValue("l"));
            }
            if (cmd.hasOption("c")) {
                String[] tempCoordinates = cmd.getOptionValue("c").split(",");
                List<String> coordinates = Arrays.asList(tempCoordinates);
                weatherArguments.setCoordinates(coordinates);
            }
            if (cmd.hasOption("u")) {
                weatherArguments.setUnits(cmd.getOptionValue("u"));
            }
        } catch (ParseException e) {
            System.out.println("Error parsing command line arguments");
            formatter.printHelp("WeatherApp", options);
            System.exit(1);
        }
        return weatherArguments;
    }

}
