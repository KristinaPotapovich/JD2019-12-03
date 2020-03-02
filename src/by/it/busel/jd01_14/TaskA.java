package by.it.busel.jd01_14;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TaskA {
    public static void main(String[] args) {
        File file = new File(filePathGenerator("dataTaskA.bin"));
        fileIntFiller(file);
        List<Integer> list = new ArrayList<>();
        File fileResult = new File(filePathGenerator("resultTaskA.txt"));
        listIntFiller(file, list, fileResult);
    }

    /**
     * a method which reads Integer-values from a file, adds them to a list,
     * prints them with an empty space separator,
     * calculates an average number of these values and prints it,
     * all printed in the console String data is being written
     * in a destination file with an extension ".txt"
     *
     * @param sourceFile      a source file which Integer-values are being read from
     * @param destinationList a destination list which Integer-values are being written in
     * @param destinationFile a destination file which contains a console representation of
     *                        aforementioned values
     */
    private static void listIntFiller(File sourceFile, List<Integer> destinationList, File destinationFile) {
        try (DataInputStream dis = new DataInputStream(new FileInputStream(sourceFile));
             PrintWriter pw = new PrintWriter(new FileWriter(destinationFile))) {
            double sum = 0.0;
            double count = 0.0;
            while (dis.available() > 0) {
                int i = dis.readInt();
                destinationList.add(i);
                System.out.print(i + " ");
                pw.print(i + " ");
                sum = sum + i;
                count++;
            }
            double avg = sum / count;
            System.out.println("\navg=" + avg);
            pw.println("\navg=" + avg);
        } catch (IOException e) {
            System.out.println("Reading is unsuccessful.");
            e.printStackTrace();
        }
    }

    /**
     * a method which fills a file (a method-argument) with random Integer values
     *
     * @param file a file in which random Integer-values are being written
     */
    private static void fileIntFiller(File file) {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(file))) {
            for (int i = 0; i < 20; i++) {
                dos.writeInt((int) (Math.random() * 20 + 100));
            }
        } catch (IOException e) {
            System.out.println("Recording is unsuccessful.");
            e.printStackTrace();
        }
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
