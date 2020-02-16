package by.it.kuzmichalex.jd01_13;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskC {
    private static List<Double> listDoubles = new ArrayList();
    private static Scanner scanner;
    private static int countOfErrors = 0;

    static void readData() throws NumberFormatException, InterruptedException {
        while (true) {
            Double inputDouble = 0.0;
            String inputString = scanner.next();
            try {
                inputDouble = Double.parseDouble(inputString);
                listDoubles.add(0, inputDouble);
            } catch (NumberFormatException e) {
                Thread.sleep(100);
                System.out.println(listDoubles.toString().replaceAll("(\\[)|(\\])|(\\,)",""));
                if ((++countOfErrors) > 4) throw e;
            }
        }
    }


    public static void main(String[] args) throws InterruptedException {
        scanner = new Scanner(System.in);
        readData();
    }
}
