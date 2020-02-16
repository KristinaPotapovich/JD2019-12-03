package by.it.ban.jd01_13;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        Double allSumm=0.;
        while (true) {
            String next = scanner.next();
            if (next.equals("END")) break;
            try {
                double d = Double.parseDouble(next);
                allSumm+=d;
                double sq=Math.sqrt(allSumm);
                if (Double.isNaN(sq)) throw new ArithmeticException();
                System.out.println(d+" "+sq);
            } catch (NumberFormatException | ArithmeticException e) {
                printEx(e);
            }
        }
    }
    static void printEx(RuntimeException e) {
        String name = e.getClass().getName();
        StackTraceElement[] stackTrace = e.getStackTrace();
        for (StackTraceElement element : stackTrace) {
            String fromStackTraceClassName = element.getClassName();
            int lineNumber = element.getLineNumber();
            String myClassName = TaskB.class.getName();
            if (myClassName.equals(fromStackTraceClassName)){
                System.out.printf(
                        "  name: %s\n"+
                                " class: %s\n"+
                                "  line: %d\n",
                        name,fromStackTraceClassName,lineNumber
                );
            }
        }
    }
}
