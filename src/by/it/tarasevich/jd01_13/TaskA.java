package by.it.tarasevich.jd01_13;

import java.util.HashMap;

public class TaskA {
    public static void main(String[] args) {
        try {
            if (Math.random() > 0.5)
                new HashMap<String, String>(null);
            else
                Integer.parseInt("привет");
        } catch (NullPointerException | NumberFormatException e) {
            Except(e);
        }
    }

    static void Except(RuntimeException e) {
        String name = e.getClass().getName();
        StackTraceElement[] stackTrace = e.getStackTrace();
        for (StackTraceElement element : stackTrace) {
            String fromStackTraceClassName = element.getClassName();
            int lineNumber = element.getLineNumber();
            String myClassName = TaskA.class.getName();
            if (myClassName.equals(fromStackTraceClassName)) {
                System.out.printf(
                        "  name: %s\n" +
                                " class: %s\n" +
                                "  line: %d\n",
                        name, fromStackTraceClassName, lineNumber
                );
            }
        }
    }
}
