package by.it.popkov.calc_old;

import java.util.Scanner;

class ConsoleRunner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Printer printer = new Printer();
        Parser parser = new Parser();
        while (true) {

            String expression = scanner.next();
            if (expression.equals("end")) break;
            else if (expression.equals("printvar")) Var.printvar();
            else if (expression.equals("sortvar")) Var.sortvar();
            else try {
                    printer.print(parser.calc(expression));
                } catch (CalcException e) {
                    System.out.println(e.getMessage());
                }
        }
    }

}
