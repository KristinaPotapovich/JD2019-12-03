package by.it.lozouski.jd01_13;

class Exceptions {
    static void printException(RuntimeException e, Object a) {
        StackTraceElement[] stackTrace = e.getStackTrace();
        String currentClassName = a.getClass().getName();

        for (StackTraceElement stackTraceElement : stackTrace) {
            if (currentClassName.equals(stackTraceElement.getClassName())){
                String nameException = e.getClass().getName();
                String classNameException = stackTraceElement.getClassName();
                int lineNumberException = stackTraceElement.getLineNumber();
                System.out.printf("name: %s\n" + "class: %s\n" + "line: %d\n", nameException, classNameException, lineNumberException);
            }
        }
    }
}
