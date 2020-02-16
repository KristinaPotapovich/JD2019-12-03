package by.it.shpakovskiy.jd01_13;

import java.util.HashMap;

class TaskA {
    public static void main(String[] args) {
        try {
            if (Math.random() > 0.5)
                new HashMap<String, String>(null);
            else
                Integer.parseInt("привет");
        } catch (NullPointerException | NumberFormatException e) {
            System.out.println("name: " + e.getClass().getName());
            StackTraceElement[] stackTrace = e.getStackTrace();
            for (StackTraceElement stackTraceElement : stackTrace) {
                if (TaskA.class.getName().equals(stackTraceElement.getClassName())) {
                    System.out.println("class: " + stackTraceElement.getClassName());
                    System.out.println("line: " + stackTraceElement.getLineNumber());
                }
            }
        }
    }
}
