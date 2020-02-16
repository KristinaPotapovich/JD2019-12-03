package by.it.lozouski.calc;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

class ConsoleRunner {
    public static void main(String[] args) {
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
        while (!(inputLine = sc1.nextLine()).equals("end")) {
            try {
                Var result = parser.calculate(inputLine);
                printer.print(result);
            } catch (CalcException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
