package by.it.lozouski.calc;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

class ConsoleRunner {
    public static void main(String[] args) {
        Logging.logFileRecord("The program was run.");
        Scanner sc1 = new Scanner(System.in);
        String inputLine;
        Parser parser = new Parser();
        Printer printer = new Printer();
        try {
            if (Files.exists(Paths.get(VarFile.getVarFile())))
                VarFile.load(parser);
        } catch (IOException e) {
            e.printStackTrace();
        }

        while (true) {
            inputLine = sc1.nextLine();
            if (inputLine.equals("end")) {
                Logging.logFileRecord("The program was end." + '\n'
                        + "***************************************************************************");
                break;
            }
            try {
                Logging.logFileRecord(inputLine);
                Var result = parser.calculate(inputLine);
                printer.print(result);
                Logging.logFileRecord("Result: " + result.toString());
            } catch (CalcException e) {
                Logging.logFileRecord(e.getMessage());
                System.out.println(e.getMessage());
            }
        }
    }
}
