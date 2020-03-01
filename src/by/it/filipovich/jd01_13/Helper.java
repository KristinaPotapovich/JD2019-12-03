package by.it.filipovich.jd01_13;

public class Helper {
    static void printException(Exception e, Object a){
        String nameOfException = e.getClass().getName();
        StackTraceElement[] stackTrace = e.getStackTrace();
        String nameOfClass = null;
        if (a instanceof TaskA)
            nameOfClass = TaskA.class.getName();
        else
        if (a instanceof TaskB)
            nameOfClass = TaskB.class.getName();

        for (StackTraceElement element : stackTrace) {
            String classOfException = element.getClassName();
            if (nameOfClass != null && nameOfClass.equals(classOfException)) {
                int lineNumber = element.getLineNumber();
                System.out.printf(" name: %s \n" +
                                "class: %s \n" +
                                " line: %d", nameOfException,
                        nameOfClass, lineNumber);
            }
        }
    }

    static void printSumAndDouble(double number, double sum) {
            if(sum<0){
                throw new ArithmeticException();
            }
            double sqrt = Math.sqrt(sum);
            System.out.println("Current number: "+number+"; SQRT of the all numbers: "+sqrt);

    }
}
