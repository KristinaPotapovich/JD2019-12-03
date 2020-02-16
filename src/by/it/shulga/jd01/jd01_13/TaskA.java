package by.it.shulga.jd01.jd01_13;

import java.util.HashMap;

public class TaskA {

    public static void main(String[] args) {
        try {
               if (Math.random() > 0.5) {
                new HashMap<String, String>(null);
             } else
                  Integer.parseInt("привет");
        }
              catch (NumberFormatException | NullPointerException e) {
                 StackTraceElement[] stackTrace = e.getStackTrace();
                for (StackTraceElement element : stackTrace) {
                if (TaskA.class.getName().equals(element.getClassName())) {
                    String name = e.getClass().getName();
                    String className = element.getClassName();
                    int lineNumber = element.getLineNumber();

                    System.out.printf(
                                     "name: %s\n" +
                                    "class: %s\n" +
                                     "line: %d\n" ,
                                             name,className,lineNumber);


                 //   System.out.printf("%6s: %s%n", "name", name);
                  //  System.out.printf("%6s: %s%n", "class", className);
                  //  System.out.printf("%6s: %s%n", "line", lineNumber);
                    break;
                }
            }

        }
    }
}