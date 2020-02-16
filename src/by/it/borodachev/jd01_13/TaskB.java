package by.it.borodachev.jd01_13;

import java.util.Scanner;

public class TaskB {
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
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String strSome = scanner.next();
        Double sum=0.0;
        Double sumsqrt;
        while (!strSome.toLowerCase().equals("end")) {
            try {
                double d=Double.parseDouble(strSome);
                sum=sum+d;
                sumsqrt=Math.sqrt(sum);
                if (sumsqrt.equals(Double.NaN)) {
                    throw new ArithmeticException("NaN");
                }
                System.out.println(strSome+" "+sumsqrt);
            }
            catch (NullPointerException |NumberFormatException e){
                printEx(e);
            }
            catch (ArithmeticException e){
                printEx(e);
            }
            strSome = scanner.next();
        }


    }
}
