package by.it.lozouski.jd01_09;

import java.util.Scanner;

class ConsoleRunner {
    public static void main(String[] args) {
        Scanner sc1 = new Scanner(System.in);
        String inputLine;
        Parser parser = new Parser();
        Printer printer = new Printer();
        while (!(inputLine = sc1.nextLine()).equals("end")) {
            Var result = parser.calculate(inputLine);
            printer.print(result);
        }
    }
}
