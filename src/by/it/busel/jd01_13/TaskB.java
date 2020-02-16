package by.it.busel.jd01_13;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double sumOfInputRealNumbers = 0.0;
        while (true) {
            String line = scanner.nextLine();
            if (line.equals("END")) break;
            try {
                double realNumber = Double.parseDouble(line);
                sumOfInputRealNumbers = sumOfInputRealNumbers + realNumber;
                double sqrt = Math.sqrt(sumOfInputRealNumbers);
                if (Double.valueOf(sqrt).equals(Double.NaN)) {
                    throw new ArithmeticException();
                }
                System.out.println(realNumber + " " + sqrt);
            } catch (NumberFormatException | ArithmeticException e) {
                StackTraceElement[] stackTrace = e.getStackTrace();
                for (StackTraceElement element : stackTrace) {
                    if (TaskB.class.getName().equals(element.getClassName())) {
                        String name = e.getClass().getName();
                        String className = element.getClassName();
                        int lineNumber = element.getLineNumber();
                        System.out.printf("%6s: %s%n", "name", name);
                        System.out.printf("%6s: %s%n", "class", className);
                        System.out.printf("%6s: %s%n", "line", lineNumber);
                        break;
                    }
                }
            }
        }
    }
}
