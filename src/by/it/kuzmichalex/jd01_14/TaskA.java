package by.it.kuzmichalex.jd01_14;


import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TaskA {
    public static void main(String[] args) {
        String sFileName = FHelper.getFileName("dataTaskA.bin", TaskA.class);
        generateBinFile(sFileName);

        List<Integer> listIntFromFile = new ArrayList<>();
        readBinFile(sFileName, listIntFromFile);

        printListToConsole(listIntFromFile);

        sFileName = FHelper.getFileName("resultTaskA.txt", TaskA.class);
        printListToFile(listIntFromFile, sFileName);

    }

    private static void printListToFile(List<Integer> listIntFromFile, String sFileName) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(sFileName))
        ) {
            double sumAllItems = 0.0;
            for (int value : listIntFromFile) {
                sumAllItems += value;
                bw.write(value + " ");
            }
            bw.write("\navg=" + sumAllItems / listIntFromFile.size());
        } catch (IOException e) {
            System.out.println("Output error. File:" + sFileName);
        }
    }

    private static void printListToConsole(List<Integer> listIntFromFile) {
        double sumAllItems = 0.0;
        for (int value : listIntFromFile) {
            sumAllItems += value;
            System.out.print(value + " ");
        }
        System.out.println("\navg=" + sumAllItems / listIntFromFile.size());
    }

    private static void readBinFile(String sFileName, List<Integer> listToFill) {
        try (DataInputStream dis = new DataInputStream(new BufferedInputStream(new FileInputStream(sFileName)))) {
            while (dis.available() > 0) {
                listToFill.add(dis.readInt());
            }
        } catch (IOException e) {
            System.out.println("File input error. FileName: " + sFileName);
        }
    }

    private static void generateBinFile(String sFileName) {
        try (DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(sFileName)))) {
            Random rnd = new Random();
            for (int i = 0; i < 20; i++) dos.writeInt(rnd.nextInt());
        } catch (IOException e) {
            System.out.println("File output error. Filename: " + sFileName);
        }
    }
}