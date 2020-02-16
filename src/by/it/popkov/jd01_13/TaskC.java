package by.it.popkov.jd01_13;

import java.util.Arrays;
import java.util.Scanner;

public class TaskC {
    static double[] ints = new double[0];
    static int size = 0;
    static int errorCounter = 0;
    static String textScan;

    public static void readData() throws InterruptedException {
        ints = Arrays.copyOf(ints, ints.length + 1);
        try {
            ints[size] = Double.parseDouble(textScan);
            size++;
        } catch (NumberFormatException e) {
            errorCounter++;
            if (errorCounter >= 5) throw e;
            Thread.sleep(100);
            for (int i1 = size - 1; i1 >= 0; i1--) {
                System.out.print(ints[i1] + " ");
            }
        }

    }

    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            textScan = scanner.next();
            readData();
        }

    }
}
