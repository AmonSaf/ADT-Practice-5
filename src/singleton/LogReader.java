package singleton;

import java.io.*;

public class LogReader {

    public static void read(String filePath, LogLevel minLevel) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String levelPart = line.split("\\[")[1].split("]")[0];
                LogLevel level = LogLevel.valueOf(levelPart);

                if (level.getPriority() >= minLevel.getPriority()) {
                    System.out.println(line);
                }
            }
        }
    }
}