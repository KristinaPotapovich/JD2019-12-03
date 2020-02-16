package by.it.plugatar.calc;

import java.util.Scanner;

public class ConsoleRunner {

    public static void main(String[] args) throws CalcException {
        String line;
        Scanner scan = new Scanner(System.in);

        Parser parser = new Parser();
        Printer printer = new Printer();
        while(!(line=scan.nextLine()).equals("end")){
            try {
                Var result = parser.calc(line);
                printer.print(result);
            } catch (CalcException e) {
               // e.printStackTrace();
                System.out.println(e.getMessage());
            }
        }
    }
}
