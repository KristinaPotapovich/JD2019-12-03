package by.it.kuzmichalex.jd01_13;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double sumAllInputs=0.0;
        double inputDouble;
        double sqrtAllInputs;
        while (true) {
            String inputString = scanner.next();
            if (inputString.toLowerCase().equals("end")) break;
            try {
                inputDouble= Double.parseDouble(inputString);
                sumAllInputs+=inputDouble;
                if(sumAllInputs>0)sqrtAllInputs=Math.sqrt(sumAllInputs);
                else throw new ArithmeticException();
                System.out.println(inputDouble);
                System.out.println(sqrtAllInputs);
            } catch(NumberFormatException | ArithmeticException e){
                ErrorHandler.processErr(e);
            }
        }
    }
}

