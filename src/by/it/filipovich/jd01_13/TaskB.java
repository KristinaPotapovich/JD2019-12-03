package by.it.filipovich.jd01_13;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        TaskB taskB = new TaskB();

        Scanner scanner = new Scanner(System.in);
        double sum = 0;

            while (true) {
                String next = scanner.next();
                if (next.equals("END")) break;
                else {
                    try {
                        double v = Double.parseDouble(next);
                        sum = sum + v;
                        Helper.printSumAndDouble(v, sum);
                    }catch ( NumberFormatException | ArithmeticException e){
                        Helper.printException(e, taskB);
                    }
                }
        }
    }
}
