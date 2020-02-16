package by.it.busel.jd01_13;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class TaskC {
    private static Scanner scanner;

    private static <T> void storageReversePrinter(LinkedList<T> storage) {
        Iterator<T> stringIterator = storage.descendingIterator();
        while (stringIterator.hasNext()) {
            System.out.print(stringIterator.next() + " ");
        }
        System.out.println();
    }

    private static void readData() throws InterruptedException {
        LinkedList<Double> storage = new LinkedList<>();
        int exceptionCounter = 0;
        while (true) {
            String line = scanner.nextLine();
            if (line.equals("end")) break;
            try {
                storage.add(Double.valueOf(line));
            } catch (Exception e) {
                Thread.sleep(100);
                storageReversePrinter(storage);
                if (++exceptionCounter % 5 == 0) {
                    throw e;
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        scanner = new Scanner(System.in);
        readData();
    }
}
