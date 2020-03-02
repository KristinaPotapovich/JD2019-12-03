package by.it.busel.jd01_15;

import java.io.*;

public class TaskA {
    public static void main(String[] args) {
        int[][] array = new int[6][4];
        fillWithRandomInts(array);
        writeToFile(array, filePathGenerator("matrix.txt", TaskA.class));
        printFromFile(filePathGenerator("matrix.txt", TaskA.class));
    }

    /**
     * a method that finds out where the current program (.java) is being executed and
     * generates an absolute path for a file, which is to be created (from the root of a computer)
     *
     * @return an absolute path for a file, which is a String-object
     */
    private static <T> String filePathGenerator(String fileName, Class<T> classStructure) {
        StringBuilder builder = new StringBuilder();
        String packageName = classStructure.getName().replace(classStructure.getSimpleName(), "")
                .replace(".", File.separator);
        builder.append(System.getProperty("user.dir"))
                .append(File.separator)
                .append("src")
                .append(File.separator)
                .append(packageName)
                .append(fileName);
        return builder.toString();
    }

    /**
     * a method which writes an array of Integer values to a file
     * "matrix.txt"
     *
     * @param array            an array which Integer values are to be printed
     *                         to a file "matrix.txt"
     * @param absoluteFileName a String with an absolute filename
     */
    private static void writeToFile(int[][] array, String absoluteFileName) {
        try (PrintWriter writer = new PrintWriter(new FileWriter
                (absoluteFileName))
        ) {
            writer.print(toStringForFile(array));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * a method that generates Integer values from -15 to 15 including
     *
     * @param array a source array that is to store aforementioned
     *              Integer values
     */
    private static void fillWithRandomInts(int[][] array) {
        for (int[] line : array) {
            for (int i = 0; i < line.length; i++) {
                line[i] = -15 + (int) (Math.random() * 31);
            }
        }
    }

    /**
     * a method which forms a String object that contains
     * Integer values from an array from arguments
     *
     * @param array an array containing Integer values
     *              which are to be printed
     * @return A String object containing all Integer values
     * from an array from arguments of this method
     */
    private static String toStringForFile(int[][] array) {
        StringBuilder builder = new StringBuilder();
        for (int[] line : array) {
            for (int value : line) {
                builder.append(String.format("%3d ", value));
            }
            builder.append('\n');
        }
        return builder.toString();
    }

    /**
     * a method which gives String from a file and prints it
     *
     * @param absoluteFileName an absolute name a file from
     *                         which String data is being gotten
     */
    private static void printFromFile(String absoluteFileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(absoluteFileName))
        ) {
            System.out.println(getLinesFromFile(reader));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * a method that gets String data and returns it
     *
     * @param reader a source tool to read from a file
     * @return String data from a file
     * @throws IOException can be caught if the file doesn't exist
     */
    private static String getLinesFromFile(BufferedReader reader) throws IOException {
        StringBuilder builder = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            builder.append(line).append('\n');
        }
        return builder.toString();
    }
}
