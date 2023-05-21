package WeatherApp.util;

import org.apache.commons.cli.*;

import java.util.ArrayList;
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

        Option coordinates = new Option("c", "coordinates", true, "Coordinates to get weather data for [Latitude Longitude]");
        coordinates.setArgs(2);
        options.addOption(coordinates);

        Option location = new Option("l", "location", true, "Location to get weather data for");
        location.setArgs(2);
        options.addOption(location);

        Option insultMe = new Option("i", "insultMe", true, "Get insulted or praised by a piece of Java code [Your name][praise or insult]");
        insultMe.setArgs(2);
        options.addOption(insultMe);

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
            if (cmd.hasOption("w")) {
                weatherArguments.setWriteToFile(cmd.getOptionValue("w"));
            }
            if (cmd.hasOption("i")) {
                String[] tempInsult = cmd.getOptionValues("i");
                List<String> insult = new ArrayList<>(Arrays.asList(tempInsult));
                weatherArguments.setInsultData(insult);
            }
        } catch (ParseException e) {
            System.out.println("Error parsing command line arguments");
            formatter.printHelp("WeatherApp", options);
            System.exit(1);
        }
        return weatherArguments;
    }

}
