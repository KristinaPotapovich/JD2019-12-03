package by.it.rumiantcau.jd01_13;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        // BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);
        // ArrayList <Double> arrayList = new ArrayList<Double>();
        String str;
        double sum = 0;
        double d;

        try {
            while (sc.hasNextLine()) {
                str = sc.nextLine();

                if (!str.equals("END")) {
                    sum += Double.parseDouble(str);
                    if (Double.isNaN(Math.sqrt(sum))) {
                        throw new ArithmeticException("incorrect");
                    }else { double root = Math.sqrt(sum);

                        System.out.println(root);
                    }
                }else {
                    break;
                }

            }
        } catch (NumberFormatException | ArithmeticException e) {
            StackTraceElement[] stackTrace = e.getStackTrace();
            for (StackTraceElement element : stackTrace) {
                if (TaskB.class.getName().equals(element.getClassName())) {
                    System.out.println(element);
                    String name = e.getClass().getName();
                    String clName = element.getClassName();
                    int number = element.getLineNumber();
                    System.out.printf(
                            "name: %s\n" +
                                    "class: %s\n" +
                                    "line: %d\n",
                            name, clName, number);
                    break;

                }
            }
        }
    }
}
