package by.it.busel.jd01_14;

import java.io.*;
import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        File fileTaskBTxt = new File(filePathGenerator("text.txt"));
        int wordCounter = 0;
        int marksCounter = 0;
        occurrencesFinder(fileTaskBTxt, wordCounter, marksCounter);
    }

    /**
     * a method which finds and prints a number of occurrences of words and punctuation marks in a source file
     *
     * @param sourceFile   a file with a String-data
     * @param wordCounter  a counter of words in a source file
     * @param marksCounter a counter of punctuation marks in a source file
     */
    private static void occurrencesFinder(File sourceFile, int wordCounter, int marksCounter) {
        try (Scanner scannerForWords = new Scanner(new BufferedReader(new FileReader(sourceFile)));
             Scanner scannerForMarks = new Scanner(new BufferedReader(new FileReader(sourceFile)));
             PrintWriter printWriter = new PrintWriter(new FileWriter
                     (new File(filePathGenerator("resultTaskB.txt"))));
        ) {
            wordCounter = getCounter(scannerForWords, wordCounter, "[^А-Яа-яЁё]+");
            marksCounter = getCounter(scannerForMarks, marksCounter, "[^,.!:?\\-]+");
            System.out.printf("words=%d,punctuation marks=%d", wordCounter, marksCounter);
            printWriter.printf("words=%d,punctuation marks=%d", wordCounter, marksCounter);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * a method which finds a number of occurrences according to "pattern" from a file
     *
     * @param scannerTool a tool which  finds a number of occurrences
     * @param counter     a variable that contains a number of occurrences
     * @param delimiter   a String, which cuts unnecessary String-data from a source file
     * @return a number of occurrences
     */
    private static int getCounter(Scanner scannerTool, int counter, String delimiter) {
        scannerTool.useDelimiter(delimiter);
        while (scannerTool.hasNext()) {
            scannerTool.next();
            counter++;
        }
        return counter;
    }

    /**
     * a method that finds out where the current program (.java) is being executed and
     * generates an absolute path for a file, which is to be created (from the root of a computer)
     *
     * @return an absolute path for a file, which is a String-object
     */
    private static String filePathGenerator(String fileName) {
        String systemPathSeparator = File.separator;
//        String fileName = "dataTaskA.bin";
        String packageName = TaskA.class.getPackage().getName().replace(".", systemPathSeparator)
                + systemPathSeparator;
        String ideaCatalogName = systemPathSeparator + "src" + systemPathSeparator;
        String projectPath = System.getProperty("user.dir");
        return projectPath + ideaCatalogName + packageName + fileName;
    }

}
