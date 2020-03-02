package by.it.plugatar.jd01_13;

import java.util.Locale;
import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word;
        double sum = 0;
        try {
            while (sc.hasNext() && !(word = sc.next()).equalsIgnoreCase("END")) {
                double d = Double.parseDouble(word);
                sum += d;
                if (sum < 0) throw new ArithmeticException();
                System.out.printf(Locale.ENGLISH,"число: %5.3f, корень из суммы чисел: %5.3f\n", d, Math.sqrt(sum));
            }
        } catch (NumberFormatException | ArithmeticException e){
            StackTraceElement[] stackTrace = e.getStackTrace();
            for (StackTraceElement stackTraceElement : stackTrace) {
            if (stackTraceElement.getMethodName().equals("main")) {
                System.out.printf(" name: %s\n" +
                        "class: %s\n" +
                        " line: %s\n", e.getClass().getSimpleName(), stackTraceElement.getClassName(), stackTraceElement.getLineNumber());
            }
            }
        }
    }
}

