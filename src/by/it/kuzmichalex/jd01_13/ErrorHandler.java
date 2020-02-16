package by.it.kuzmichalex.jd01_13;

public class ErrorHandler {
        public static void processErr(RuntimeException e) {
            StringBuilder errOutString =new StringBuilder();
            StackTraceElement[] stackTrace = e.getStackTrace();
            for (int i = 0; i <stackTrace.length ; i++) {
                if(stackTrace[i].getClassName().contains("by.it."))
                {   errOutString.append(" name: ").append(e.getClass().getName()).append("\n");
                    errOutString.append("class: ").append(stackTrace[i].getClassName()).append("\n");
                    errOutString.append(" line: ").append(stackTrace[i].getLineNumber()).append("\n");
                }
/*            System.out.println("getClassName  " + stackTrace[i].getClassName());
            System.out.println("getMethodName " + stackTrace[i].getMethodName());
            System.out.println("stackTrace    " + stackTrace[i]);
            System.out.println("getClass      " + e.getClass());
            System.out.println("getLineNumber "+ stackTrace[i].getLineNumber());
            System.out.println("");*/
            }
            System.out.println(errOutString.toString());
        }

}
