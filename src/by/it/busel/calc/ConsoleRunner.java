package by.it.busel.calc;

import java.util.Scanner;

class ConsoleRunner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Parser parser = new Parser();
        Printer printer = new Printer();
        Storage storage = new Storage();
        while (true) {
            String varExpression = scanner.nextLine();
            ConsoleCommands.call(varExpression);
            if (!varExpression.equals("end") && !varExpression.equals("конец")) {
                try {
                    Var result = parser.calc(varExpression.trim());
                    printer.print(result);
                } catch (CalcException e) {
                    System.out.println(e.getMessage());
                }
            } else {
                break;
            }
        }
        storage.clear();
    }
}
