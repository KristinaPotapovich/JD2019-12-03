package by.it.popkov.jd01_09;

import java.util.Scanner;

class ConsoleRunner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Printer printer = new Printer();
        Parser parser = new Parser();
        while (true) {
            String expression = scanner.next();
            if (expression.equals("end")) break;
            printer.print(parser.calc(expression));
        }
    }

}
