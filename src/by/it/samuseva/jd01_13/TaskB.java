package by.it.samuseva.jd01_13;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double sum = 0;
        try {
            while (true) {
                String line = scan.nextLine();
                if (line.equals("end")||line.equals("END")||line.equals("End")) {
                    break;
                }
                else{
                    double d = Double.parseDouble(line);
                    sum += d;
                    if (sum <0 ) {
                        throw new  ArithmeticException();
                    } else {
                        System.out.println(Math.sqrt(sum));
                    }
                }
            }
        }
        catch (NumberFormatException|ArithmeticException e){
            Help.printException(TaskB.class.getName(), e);
        }
    }
}
