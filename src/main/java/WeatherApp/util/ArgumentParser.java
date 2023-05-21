package WeatherApp.util;

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
        options.addOption("w", "writeToFile", true, "Write weather data to file");
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
                String [] tempLocation = cmd.getOptionValues("l");
                StringBuilder sb = new StringBuilder();
                for (String s : tempLocation) {
                    sb.append(s);
                    sb.append(" ");
                }
                weatherArguments.setLocation(sb.toString());
            }
            if (cmd.hasOption("c")) {
                String[] tempCoordinates = cmd.getOptionValues("c");
                for (String s : tempCoordinates) {
                    System.out.println(s);
                }
                List<String> coordinates = new ArrayList<>(Arrays.asList(tempCoordinates));
                for (String s : coordinates) {
                    System.out.println(s);
                }
                weatherArguments.setCoordinates(coordinates);
            }
            if (cmd.hasOption("u")) {
                weatherArguments.setUnits(cmd.getOptionValue("u"));
            }
            if (cmd.hasOption("w")) {
                weatherArguments.setWriteToFile(cmd.getOptionValue("w"));
            }
        } catch (ParseException e) {
            System.out.println("Error parsing command line arguments");
            formatter.printHelp("WeatherApp", options);
            System.exit(1);
        }
        return weatherArguments;
    }

}