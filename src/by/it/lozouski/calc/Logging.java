package by.it.lozouski.calc;

import by.it.lozouski.jd01_14.Helper;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

class Logging extends Helper {
    //fields
    private static String logFileTxtPath = Helper.getPath("log.txt", Logging.class);
    private static Path logPath = Paths.get(logFileTxtPath);
    private static int limitOfLogMessages = 25;

    //methods
    public static void logFileRecord(String currentLogMessage) {
        try {
            if (Files.exists(logPath) && Files.readAllLines(logPath).size() >= limitOfLogMessages) {
                logFileUpdate(currentLogMessage);
            } else {
                try (PrintWriter logWriter = new PrintWriter(new FileWriter(logFileTxtPath, true))) {
                    String currentTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));
                    logWriter.println("Log time: " + currentTime + ". Event: " + currentLogMessage);
                } catch (IOException e) {
                    System.out.println("ERROR...IO");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void logFileUpdate(String updateLogMessage) {
        try {
            List<String> elementsOfLogFile = Files.readAllLines(logPath);
            elementsOfLogFile.remove(0);
            String currentTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));
            elementsOfLogFile.add("Log time: " + currentTime + ". Event: " + updateLogMessage);
            Files.write(logPath, elementsOfLogFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
