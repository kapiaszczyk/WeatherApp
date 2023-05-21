package WeatherApp.util;

import java.io.FileWriter;
import java.io.IOException;

public class WeatherDataFileWriter {

    public void writeToFile(String data, String fileName) {
        try {
            FileWriter fileWriter = new FileWriter(fileName + ".JSON");
            fileWriter.write(data);
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
