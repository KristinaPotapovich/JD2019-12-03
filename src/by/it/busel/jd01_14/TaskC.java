package by.it.busel.jd01_14;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class TaskC {
    public static void main(String[] args) {
        File sourceFile = new File(getSourceCatalogPath());
        File destinationFile = new File(filePathGenerator());
        try (PrintWriter printWriter = new PrintWriter(new FileWriter(destinationFile))) {
            fileContentsNamePrinterBothInConsoleAndFile(sourceFile, printWriter);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * a method which defines a path of a packageName with a last name of
     * an owner of a executing program
     *
     * @return a path of a packageName with an aforementioned last name
     */
    private static String getSourceCatalogPath() {
        String lastName = TaskC.class.getName().replace("by.it.", "")
                .replaceAll("\\.[a-zA-Z0-9_]+", "");
        String separator = File.separator;
        return System.getProperty("user.dir") + separator + "src" + separator +
                "by" + separator + "it" + separator + lastName;
    }

    /**
     * a method that finds out where the current program (.java) is being executed and
     * generates an absolute path for a file, which is to be created (from the root of a computer).
     * The file has a name "resultTaskC.txt" according to TaskC
     *
     * @return an absolute path for a file, which is a String-object
     */
    private static String filePathGenerator() {
        String systemPathSeparator = File.separator;
        String fileName = "resultTaskC.txt";
        String packageName = TaskA.class.getPackage().getName().replace(".", systemPathSeparator)
                + systemPathSeparator;
        String ideaCatalogName = systemPathSeparator + "src" + systemPathSeparator;
        String projectPath = System.getProperty("user.dir");
        return projectPath + ideaCatalogName + packageName + fileName;
    }

    /**
     * a method that prints to console and other file names of contents of a file (catalog) according to TaskC
     *
     * @param sourceFile a file contents of which are being printed
     * @param writer     a tool to print String-data into a file
     */
    private static void fileContentsNamePrinterBothInConsoleAndFile(File sourceFile,
                                                                    PrintWriter writer) {
        File[] files = sourceFile.listFiles();
        for (File file : files != null ? files : new File[0]) {
            if (file.isFile()) {
                System.out.printf("file:%s%n", file.getName());
                writer.printf("file:%s%n", file.getName());
            } else if (file.isDirectory()) {
                System.out.printf("dir:%s%n", file.getName());
                writer.printf("dir:%s%n", file.getName());
                fileContentsNamePrinterBothInConsoleAndFile(file, writer);
            }
        }
    }
}
