package by.it.popkov.calc;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

class ConsoleRunner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Printer printer = new Printer();
        Parser parser = new Parser();
        try {
            if (Files.exists(Paths.get(CalcFile.getFullFileName())))
                CalcFile.readValue(parser);
        } catch (IOException e) {
            e.printStackTrace();
        }

        while (true) {

            String expression = scanner.nextLine();
            if (expression.equals("end")) break;
            else if (expression.equals("printvar")) Var.printvar();
            else if (expression.equals("sortvar")) Var.sortvar();
            else try {
                    printer.print(parser.calc(expression));
                } catch (CalcException e) {
                    Log.writeLog(e.getMessage());
                    System.out.println(e.getMessage());
                }
        }
    }

}
