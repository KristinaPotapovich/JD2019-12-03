package by.it.akhmelev.jd01_13;

public class Helper {
    static void printEx(RuntimeException e) {
        String name = e.getClass().getName();
        StackTraceElement[] stackTrace = e.getStackTrace();
        for (StackTraceElement element : stackTrace) {
            String fromStackTraceClassName = element.getClassName();
            int lineNumber = element.getLineNumber();
            String myClassName = TaskA.class.getName();
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
