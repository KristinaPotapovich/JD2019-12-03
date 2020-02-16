package by.it.shulga.jd01.jd01_09;

import java.util.Scanner;

public class ConsoleRunner {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Parser parser = new Parser();
        Printer printer = new Printer();
        while (true){
            String expression = scanner.next();
            if (expression.equals("end"))
                break;
            Var result = parser.calc(expression);
            printer.print(result);
        }


    }
}


