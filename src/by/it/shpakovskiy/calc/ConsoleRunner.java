package by.it.shpakovskiy.calc;

import java.util.Scanner;

class ConsoleRunner {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Parser parser = new Parser();
        Printer printer = new Printer();
        while (true) {
            String expression = scanner.next();
            if (expression.equals("end")) {
                System.out.println("I hope to see you again \u270B");
                break;
            }
            if (expression.equals("printvar")) {
                System.out.println(Var.getStringVars());
                continue;
            }
            if (expression.equals("sortvar")) {
                Var.sortAndPrintVars();
                continue;
            }
            try {
                Var result = parser.calc(expression);
                printer.print(result);
            } catch (CalcException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
