package by.it.ban.calc;

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
            Var result = null;
            try {
                result = parser.calc(expression);
                printer.print(result);
            } catch (CalcException  e){
                System.out.println(e.getMessage());
            }
        }


    }
}
