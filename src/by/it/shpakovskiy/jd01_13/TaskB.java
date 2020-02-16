package by.it.shpakovskiy.jd01_13;

import java.util.Scanner;

class TaskB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double result = 0;
        while (true) {
            String line = scanner.next();
            if (line.equals("END")) {
                break;
            }
            try {
                double number = Double.parseDouble(line);
                System.out.println("You entered: " + number);
                result += number;
                System.out.println("Sum: " + result);
                double sqrt = Math.sqrt(result);
                if (Double.isNaN(sqrt)){
                    throw new ArithmeticException();
                }
                System.out.println("Square root: " + sqrt);
            } catch (NumberFormatException | ArithmeticException e) {
                System.out.println("name: " + e.getClass().getName());
                StackTraceElement[] stackTrace = e.getStackTrace();
                for (StackTraceElement stackTraceElement : stackTrace) {
                    if (TaskB.class.getName().equals(stackTraceElement.getClassName())) {
                        System.out.println("class: " + stackTraceElement.getClassName());
                        System.out.println("line: " + stackTraceElement.getLineNumber());
                    }
                }
            }
        }
    }
}
