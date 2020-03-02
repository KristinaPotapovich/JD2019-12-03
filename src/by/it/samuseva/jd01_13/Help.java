package by.it.samuseva.jd01_13;

public class Help {
    static void printException(String classNameSource, Exception e){

        StackTraceElement[] stackTrace = e.getStackTrace();
        for (StackTraceElement element : stackTrace) {
            if (classNameSource.equals(element.getClassName())){
                String name = e.getClass().getName();
                String className = element.getClassName();
                int numberRow = element.getLineNumber();
                System.out.printf("  name: %s\n class: %s\n  line: %d\n",name, className, numberRow);
                break;
            }
           /* if (TaskB.class.getName().equals(element.getClassName())){
                String name = e.getClass().getName();
                String className = element.getClassName();
                int numberRow = element.getLineNumber();
                System.out.printf("  name: %s\n class: %s\n  line: %d\n",name, className, numberRow);
                break;
            }*/
        }
    }
}
